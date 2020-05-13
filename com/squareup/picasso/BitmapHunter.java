package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class BitmapHunter implements Runnable {
  private static final Object DECODE_LOCK = new Object();
  
  private static final RequestHandler ERRORING_HANDLER;
  
  private static final ThreadLocal<StringBuilder> NAME_BUILDER = new ThreadLocal<StringBuilder>() {
      protected StringBuilder initialValue() {
        return new StringBuilder("Picasso-");
      }
    };
  
  private static final AtomicInteger SEQUENCE_GENERATOR = new AtomicInteger();
  
  Action action;
  
  List<Action> actions;
  
  final Cache cache;
  
  final Request data;
  
  final Dispatcher dispatcher;
  
  Exception exception;
  
  int exifRotation;
  
  Future<?> future;
  
  final String key;
  
  Picasso.LoadedFrom loadedFrom;
  
  final int memoryPolicy;
  
  int networkPolicy;
  
  final Picasso picasso;
  
  Picasso.Priority priority;
  
  final RequestHandler requestHandler;
  
  Bitmap result;
  
  int retryCount;
  
  final int sequence = SEQUENCE_GENERATOR.incrementAndGet();
  
  final Stats stats;
  
  static {
    ERRORING_HANDLER = new RequestHandler() {
        public boolean canHandleRequest(Request param1Request) {
          return true;
        }
        
        public RequestHandler.Result load(Request param1Request, int param1Int) throws IOException {
          throw new IllegalStateException("Unrecognized type of request: " + param1Request);
        }
      };
  }
  
  BitmapHunter(Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction, RequestHandler paramRequestHandler) {
    this.picasso = paramPicasso;
    this.dispatcher = paramDispatcher;
    this.cache = paramCache;
    this.stats = paramStats;
    this.action = paramAction;
    this.key = paramAction.getKey();
    this.data = paramAction.getRequest();
    this.priority = paramAction.getPriority();
    this.memoryPolicy = paramAction.getMemoryPolicy();
    this.networkPolicy = paramAction.getNetworkPolicy();
    this.requestHandler = paramRequestHandler;
    this.retryCount = paramRequestHandler.getRetryCount();
  }
  
  static Bitmap applyCustomTransformations(List<Transformation> paramList, Bitmap paramBitmap) {
    byte b = 0;
    int i = paramList.size();
    Bitmap bitmap = paramBitmap;
    while (true) {
      final Transformation transformation;
      paramBitmap = bitmap;
      if (b < i) {
        transformation = paramList.get(b);
        try {
          paramBitmap = transformation.transform(bitmap);
          if (paramBitmap == null) {
            null = (new StringBuilder()).append("Transformation ").append(transformation.key()).append(" returned null after ").append(b).append(" previous transformation(s).\n\nTransformation list:\n");
            Iterator<Transformation> iterator = paramList.iterator();
            while (iterator.hasNext())
              null.append(((Transformation)iterator.next()).key()).append('\n'); 
            Picasso.HANDLER.post(new Runnable() {
                  public void run() {
                    throw new NullPointerException(builder.toString());
                  }
                });
            return null;
          } 
        } catch (RuntimeException runtimeException) {
          Picasso.HANDLER.post(new Runnable() {
                public void run() {
                  throw new RuntimeException("Transformation " + transformation.key() + " crashed with exception.", e);
                }
              });
          return null;
        } 
      } else {
        return paramBitmap;
      } 
      if (paramBitmap == bitmap && bitmap.isRecycled()) {
        Picasso.HANDLER.post(new Runnable() {
              public void run() {
                throw new IllegalStateException("Transformation " + transformation.key() + " returned input Bitmap but recycled it.");
              }
            });
        return null;
      } 
      if (paramBitmap != bitmap && !bitmap.isRecycled()) {
        Picasso.HANDLER.post(new Runnable() {
              public void run() {
                throw new IllegalStateException("Transformation " + transformation.key() + " mutated input Bitmap but failed to recycle the original.");
              }
            });
        return null;
      } 
      bitmap = paramBitmap;
      b++;
    } 
  }
  
  private Picasso.Priority computeNewPriority() {
    byte b;
    int i;
    Picasso.Priority priority = Picasso.Priority.LOW;
    if (this.actions != null && !this.actions.isEmpty()) {
      b = 1;
    } else {
      b = 0;
    } 
    if (this.action != null || b) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i) {
      if (this.action != null)
        priority = this.action.getPriority(); 
      Picasso.Priority priority1 = priority;
      if (b) {
        b = 0;
        i = this.actions.size();
        while (true) {
          priority1 = priority;
          if (b < i) {
            Picasso.Priority priority2 = ((Action)this.actions.get(b)).getPriority();
            priority1 = priority;
            if (priority2.ordinal() > priority.ordinal())
              priority1 = priority2; 
            b++;
            priority = priority1;
            continue;
          } 
          break;
        } 
      } 
      priority = priority1;
    } 
    return priority;
  }
  
  static Bitmap decodeStream(InputStream paramInputStream, Request paramRequest) throws IOException {
    byte[] arrayOfByte;
    MarkableInputStream markableInputStream = new MarkableInputStream(paramInputStream);
    long l = markableInputStream.savePosition(65536);
    BitmapFactory.Options options = RequestHandler.createBitmapOptions(paramRequest);
    boolean bool1 = RequestHandler.requiresInSampleSize(options);
    boolean bool2 = Utils.isWebPFile(markableInputStream);
    markableInputStream.reset(l);
    if (bool2) {
      arrayOfByte = Utils.toByteArray(markableInputStream);
      if (bool1) {
        BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, options);
        RequestHandler.calculateInSampleSize(paramRequest.targetWidth, paramRequest.targetHeight, options, paramRequest);
      } 
      return BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, options);
    } 
    if (bool1) {
      BitmapFactory.decodeStream((InputStream)arrayOfByte, null, options);
      RequestHandler.calculateInSampleSize(paramRequest.targetWidth, paramRequest.targetHeight, options, paramRequest);
      arrayOfByte.reset(l);
    } 
    Bitmap bitmap2 = BitmapFactory.decodeStream((InputStream)arrayOfByte, null, options);
    Bitmap bitmap1 = bitmap2;
    if (bitmap2 == null)
      throw new IOException("Failed to decode stream."); 
    return bitmap1;
  }
  
  static BitmapHunter forRequest(Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction) {
    // Byte code:
    //   0: aload #4
    //   2: invokevirtual getRequest : ()Lcom/squareup/picasso/Request;
    //   5: astore #5
    //   7: aload_0
    //   8: invokevirtual getRequestHandlers : ()Ljava/util/List;
    //   11: astore #6
    //   13: iconst_0
    //   14: istore #7
    //   16: aload #6
    //   18: invokeinterface size : ()I
    //   23: istore #8
    //   25: iload #7
    //   27: iload #8
    //   29: if_icmpge -> 80
    //   32: aload #6
    //   34: iload #7
    //   36: invokeinterface get : (I)Ljava/lang/Object;
    //   41: checkcast com/squareup/picasso/RequestHandler
    //   44: astore #9
    //   46: aload #9
    //   48: aload #5
    //   50: invokevirtual canHandleRequest : (Lcom/squareup/picasso/Request;)Z
    //   53: ifeq -> 74
    //   56: new com/squareup/picasso/BitmapHunter
    //   59: dup
    //   60: aload_0
    //   61: aload_1
    //   62: aload_2
    //   63: aload_3
    //   64: aload #4
    //   66: aload #9
    //   68: invokespecial <init> : (Lcom/squareup/picasso/Picasso;Lcom/squareup/picasso/Dispatcher;Lcom/squareup/picasso/Cache;Lcom/squareup/picasso/Stats;Lcom/squareup/picasso/Action;Lcom/squareup/picasso/RequestHandler;)V
    //   71: astore_0
    //   72: aload_0
    //   73: areturn
    //   74: iinc #7, 1
    //   77: goto -> 25
    //   80: new com/squareup/picasso/BitmapHunter
    //   83: dup
    //   84: aload_0
    //   85: aload_1
    //   86: aload_2
    //   87: aload_3
    //   88: aload #4
    //   90: getstatic com/squareup/picasso/BitmapHunter.ERRORING_HANDLER : Lcom/squareup/picasso/RequestHandler;
    //   93: invokespecial <init> : (Lcom/squareup/picasso/Picasso;Lcom/squareup/picasso/Dispatcher;Lcom/squareup/picasso/Cache;Lcom/squareup/picasso/Stats;Lcom/squareup/picasso/Action;Lcom/squareup/picasso/RequestHandler;)V
    //   96: astore_0
    //   97: goto -> 72
  }
  
  private static boolean shouldResize(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (!paramBoolean || paramInt1 > paramInt3 || paramInt2 > paramInt4);
  }
  
  static Bitmap transformResult(Request paramRequest, Bitmap paramBitmap, int paramInt) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getWidth : ()I
    //   4: istore_3
    //   5: aload_1
    //   6: invokevirtual getHeight : ()I
    //   9: istore #4
    //   11: aload_0
    //   12: getfield onlyScaleDown : Z
    //   15: istore #5
    //   17: iconst_0
    //   18: istore #6
    //   20: iconst_0
    //   21: istore #7
    //   23: iconst_0
    //   24: istore #8
    //   26: iconst_0
    //   27: istore #9
    //   29: iload_3
    //   30: istore #10
    //   32: iload #4
    //   34: istore #11
    //   36: new android/graphics/Matrix
    //   39: dup
    //   40: invokespecial <init> : ()V
    //   43: astore #12
    //   45: iload #6
    //   47: istore #13
    //   49: iload #8
    //   51: istore #14
    //   53: iload #10
    //   55: istore #15
    //   57: iload #11
    //   59: istore #16
    //   61: aload_0
    //   62: invokevirtual needsMatrixTransform : ()Z
    //   65: ifeq -> 246
    //   68: aload_0
    //   69: getfield targetWidth : I
    //   72: istore #17
    //   74: aload_0
    //   75: getfield targetHeight : I
    //   78: istore #18
    //   80: aload_0
    //   81: getfield rotationDegrees : F
    //   84: fstore #19
    //   86: fload #19
    //   88: fconst_0
    //   89: fcmpl
    //   90: ifeq -> 115
    //   93: aload_0
    //   94: getfield hasRotationPivot : Z
    //   97: ifeq -> 292
    //   100: aload #12
    //   102: fload #19
    //   104: aload_0
    //   105: getfield rotationPivotX : F
    //   108: aload_0
    //   109: getfield rotationPivotY : F
    //   112: invokevirtual setRotate : (FFF)V
    //   115: aload_0
    //   116: getfield centerCrop : Z
    //   119: ifeq -> 341
    //   122: iload #17
    //   124: i2f
    //   125: iload_3
    //   126: i2f
    //   127: fdiv
    //   128: fstore #20
    //   130: iload #18
    //   132: i2f
    //   133: iload #4
    //   135: i2f
    //   136: fdiv
    //   137: fstore #19
    //   139: fload #20
    //   141: fload #19
    //   143: fcmpl
    //   144: ifle -> 302
    //   147: iload #4
    //   149: i2f
    //   150: fload #19
    //   152: fload #20
    //   154: fdiv
    //   155: fmul
    //   156: f2d
    //   157: invokestatic ceil : (D)D
    //   160: d2i
    //   161: istore #11
    //   163: iload #4
    //   165: iload #11
    //   167: isub
    //   168: iconst_2
    //   169: idiv
    //   170: istore #9
    //   172: fload #20
    //   174: fstore #19
    //   176: iload #18
    //   178: i2f
    //   179: iload #11
    //   181: i2f
    //   182: fdiv
    //   183: fstore #20
    //   185: fload #19
    //   187: fstore #21
    //   189: iload #7
    //   191: istore #13
    //   193: iload #9
    //   195: istore #14
    //   197: iload #10
    //   199: istore #15
    //   201: iload #11
    //   203: istore #16
    //   205: iload #5
    //   207: iload_3
    //   208: iload #4
    //   210: iload #17
    //   212: iload #18
    //   214: invokestatic shouldResize : (ZIIII)Z
    //   217: ifeq -> 246
    //   220: aload #12
    //   222: fload #21
    //   224: fload #20
    //   226: invokevirtual preScale : (FF)Z
    //   229: pop
    //   230: iload #11
    //   232: istore #16
    //   234: iload #10
    //   236: istore #15
    //   238: iload #9
    //   240: istore #14
    //   242: iload #7
    //   244: istore #13
    //   246: iload_2
    //   247: ifeq -> 258
    //   250: aload #12
    //   252: iload_2
    //   253: i2f
    //   254: invokevirtual preRotate : (F)Z
    //   257: pop
    //   258: aload_1
    //   259: iload #13
    //   261: iload #14
    //   263: iload #15
    //   265: iload #16
    //   267: aload #12
    //   269: iconst_1
    //   270: invokestatic createBitmap : (Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   273: astore #12
    //   275: aload_1
    //   276: astore_0
    //   277: aload #12
    //   279: aload_1
    //   280: if_acmpeq -> 290
    //   283: aload_1
    //   284: invokevirtual recycle : ()V
    //   287: aload #12
    //   289: astore_0
    //   290: aload_0
    //   291: areturn
    //   292: aload #12
    //   294: fload #19
    //   296: invokevirtual setRotate : (F)V
    //   299: goto -> 115
    //   302: iload_3
    //   303: i2f
    //   304: fload #20
    //   306: fload #19
    //   308: fdiv
    //   309: fmul
    //   310: f2d
    //   311: invokestatic ceil : (D)D
    //   314: d2i
    //   315: istore #10
    //   317: iload_3
    //   318: iload #10
    //   320: isub
    //   321: iconst_2
    //   322: idiv
    //   323: istore #7
    //   325: iload #17
    //   327: i2f
    //   328: iload #10
    //   330: i2f
    //   331: fdiv
    //   332: fstore #21
    //   334: fload #19
    //   336: fstore #20
    //   338: goto -> 189
    //   341: aload_0
    //   342: getfield centerInside : Z
    //   345: ifeq -> 440
    //   348: iload #17
    //   350: i2f
    //   351: iload_3
    //   352: i2f
    //   353: fdiv
    //   354: fstore #19
    //   356: iload #18
    //   358: i2f
    //   359: iload #4
    //   361: i2f
    //   362: fdiv
    //   363: fstore #20
    //   365: fload #19
    //   367: fload #20
    //   369: fcmpg
    //   370: ifge -> 433
    //   373: iload #6
    //   375: istore #13
    //   377: iload #8
    //   379: istore #14
    //   381: iload #10
    //   383: istore #15
    //   385: iload #11
    //   387: istore #16
    //   389: iload #5
    //   391: iload_3
    //   392: iload #4
    //   394: iload #17
    //   396: iload #18
    //   398: invokestatic shouldResize : (ZIIII)Z
    //   401: ifeq -> 246
    //   404: aload #12
    //   406: fload #19
    //   408: fload #19
    //   410: invokevirtual preScale : (FF)Z
    //   413: pop
    //   414: iload #6
    //   416: istore #13
    //   418: iload #8
    //   420: istore #14
    //   422: iload #10
    //   424: istore #15
    //   426: iload #11
    //   428: istore #16
    //   430: goto -> 246
    //   433: fload #20
    //   435: fstore #19
    //   437: goto -> 373
    //   440: iload #17
    //   442: ifne -> 466
    //   445: iload #6
    //   447: istore #13
    //   449: iload #8
    //   451: istore #14
    //   453: iload #10
    //   455: istore #15
    //   457: iload #11
    //   459: istore #16
    //   461: iload #18
    //   463: ifeq -> 246
    //   466: iload #17
    //   468: iload_3
    //   469: if_icmpne -> 495
    //   472: iload #6
    //   474: istore #13
    //   476: iload #8
    //   478: istore #14
    //   480: iload #10
    //   482: istore #15
    //   484: iload #11
    //   486: istore #16
    //   488: iload #18
    //   490: iload #4
    //   492: if_icmpeq -> 246
    //   495: iload #17
    //   497: ifeq -> 582
    //   500: iload #17
    //   502: i2f
    //   503: iload_3
    //   504: i2f
    //   505: fdiv
    //   506: fstore #19
    //   508: iload #18
    //   510: ifeq -> 594
    //   513: iload #18
    //   515: i2f
    //   516: iload #4
    //   518: i2f
    //   519: fdiv
    //   520: fstore #20
    //   522: iload #6
    //   524: istore #13
    //   526: iload #8
    //   528: istore #14
    //   530: iload #10
    //   532: istore #15
    //   534: iload #11
    //   536: istore #16
    //   538: iload #5
    //   540: iload_3
    //   541: iload #4
    //   543: iload #17
    //   545: iload #18
    //   547: invokestatic shouldResize : (ZIIII)Z
    //   550: ifeq -> 246
    //   553: aload #12
    //   555: fload #19
    //   557: fload #20
    //   559: invokevirtual preScale : (FF)Z
    //   562: pop
    //   563: iload #6
    //   565: istore #13
    //   567: iload #8
    //   569: istore #14
    //   571: iload #10
    //   573: istore #15
    //   575: iload #11
    //   577: istore #16
    //   579: goto -> 246
    //   582: iload #18
    //   584: i2f
    //   585: iload #4
    //   587: i2f
    //   588: fdiv
    //   589: fstore #19
    //   591: goto -> 508
    //   594: iload #17
    //   596: i2f
    //   597: iload_3
    //   598: i2f
    //   599: fdiv
    //   600: fstore #20
    //   602: goto -> 522
  }
  
  static void updateThreadName(Request paramRequest) {
    String str = paramRequest.getName();
    StringBuilder stringBuilder = NAME_BUILDER.get();
    stringBuilder.ensureCapacity("Picasso-".length() + str.length());
    stringBuilder.replace("Picasso-".length(), stringBuilder.length(), str);
    Thread.currentThread().setName(stringBuilder.toString());
  }
  
  void attach(Action paramAction) {
    boolean bool = this.picasso.loggingEnabled;
    Request request = paramAction.request;
    if (this.action == null) {
      this.action = paramAction;
      if (bool) {
        if (this.actions == null || this.actions.isEmpty()) {
          Utils.log("Hunter", "joined", request.logId(), "to empty hunter");
          return;
        } 
      } else {
        return;
      } 
      Utils.log("Hunter", "joined", request.logId(), Utils.getLogIdsForHunter(this, "to "));
      return;
    } 
    if (this.actions == null)
      this.actions = new ArrayList<Action>(3); 
    this.actions.add(paramAction);
    if (bool)
      Utils.log("Hunter", "joined", request.logId(), Utils.getLogIdsForHunter(this, "to ")); 
    Picasso.Priority priority = paramAction.getPriority();
    if (priority.ordinal() > this.priority.ordinal())
      this.priority = priority; 
  }
  
  boolean cancel() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iload_1
    //   3: istore_2
    //   4: aload_0
    //   5: getfield action : Lcom/squareup/picasso/Action;
    //   8: ifnonnull -> 58
    //   11: aload_0
    //   12: getfield actions : Ljava/util/List;
    //   15: ifnull -> 32
    //   18: iload_1
    //   19: istore_2
    //   20: aload_0
    //   21: getfield actions : Ljava/util/List;
    //   24: invokeinterface isEmpty : ()Z
    //   29: ifeq -> 58
    //   32: iload_1
    //   33: istore_2
    //   34: aload_0
    //   35: getfield future : Ljava/util/concurrent/Future;
    //   38: ifnull -> 58
    //   41: iload_1
    //   42: istore_2
    //   43: aload_0
    //   44: getfield future : Ljava/util/concurrent/Future;
    //   47: iconst_0
    //   48: invokeinterface cancel : (Z)Z
    //   53: ifeq -> 58
    //   56: iconst_1
    //   57: istore_2
    //   58: iload_2
    //   59: ireturn
  }
  
  void detach(Action paramAction) {
    boolean bool = false;
    if (this.action == paramAction) {
      this.action = null;
      bool = true;
    } else if (this.actions != null) {
      bool = this.actions.remove(paramAction);
    } 
    if (bool && paramAction.getPriority() == this.priority)
      this.priority = computeNewPriority(); 
    if (this.picasso.loggingEnabled)
      Utils.log("Hunter", "removed", paramAction.request.logId(), Utils.getLogIdsForHunter(this, "from ")); 
  }
  
  Action getAction() {
    return this.action;
  }
  
  List<Action> getActions() {
    return this.actions;
  }
  
  Request getData() {
    return this.data;
  }
  
  Exception getException() {
    return this.exception;
  }
  
  String getKey() {
    return this.key;
  }
  
  Picasso.LoadedFrom getLoadedFrom() {
    return this.loadedFrom;
  }
  
  int getMemoryPolicy() {
    return this.memoryPolicy;
  }
  
  Picasso getPicasso() {
    return this.picasso;
  }
  
  Picasso.Priority getPriority() {
    return this.priority;
  }
  
  Bitmap getResult() {
    return this.result;
  }
  
  Bitmap hunt() throws IOException {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield memoryPolicy : I
    //   6: invokestatic shouldReadFromMemoryCache : (I)Z
    //   9: ifeq -> 77
    //   12: aload_0
    //   13: getfield cache : Lcom/squareup/picasso/Cache;
    //   16: aload_0
    //   17: getfield key : Ljava/lang/String;
    //   20: invokeinterface get : (Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   25: astore_2
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: ifnull -> 77
    //   32: aload_0
    //   33: getfield stats : Lcom/squareup/picasso/Stats;
    //   36: invokevirtual dispatchCacheHit : ()V
    //   39: aload_0
    //   40: getstatic com/squareup/picasso/Picasso$LoadedFrom.MEMORY : Lcom/squareup/picasso/Picasso$LoadedFrom;
    //   43: putfield loadedFrom : Lcom/squareup/picasso/Picasso$LoadedFrom;
    //   46: aload_0
    //   47: getfield picasso : Lcom/squareup/picasso/Picasso;
    //   50: getfield loggingEnabled : Z
    //   53: ifeq -> 75
    //   56: ldc_w 'Hunter'
    //   59: ldc_w 'decoded'
    //   62: aload_0
    //   63: getfield data : Lcom/squareup/picasso/Request;
    //   66: invokevirtual logId : ()Ljava/lang/String;
    //   69: ldc_w 'from cache'
    //   72: invokestatic log : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_2
    //   76: areturn
    //   77: aload_0
    //   78: getfield data : Lcom/squareup/picasso/Request;
    //   81: astore_2
    //   82: aload_0
    //   83: getfield retryCount : I
    //   86: ifne -> 380
    //   89: getstatic com/squareup/picasso/NetworkPolicy.OFFLINE : Lcom/squareup/picasso/NetworkPolicy;
    //   92: getfield index : I
    //   95: istore_3
    //   96: aload_2
    //   97: iload_3
    //   98: putfield networkPolicy : I
    //   101: aload_0
    //   102: getfield requestHandler : Lcom/squareup/picasso/RequestHandler;
    //   105: aload_0
    //   106: getfield data : Lcom/squareup/picasso/Request;
    //   109: aload_0
    //   110: getfield networkPolicy : I
    //   113: invokevirtual load : (Lcom/squareup/picasso/Request;I)Lcom/squareup/picasso/RequestHandler$Result;
    //   116: astore #4
    //   118: aload #4
    //   120: ifnull -> 172
    //   123: aload_0
    //   124: aload #4
    //   126: invokevirtual getLoadedFrom : ()Lcom/squareup/picasso/Picasso$LoadedFrom;
    //   129: putfield loadedFrom : Lcom/squareup/picasso/Picasso$LoadedFrom;
    //   132: aload_0
    //   133: aload #4
    //   135: invokevirtual getExifOrientation : ()I
    //   138: putfield exifRotation : I
    //   141: aload #4
    //   143: invokevirtual getBitmap : ()Landroid/graphics/Bitmap;
    //   146: astore_2
    //   147: aload_2
    //   148: astore_1
    //   149: aload_2
    //   150: ifnonnull -> 172
    //   153: aload #4
    //   155: invokevirtual getStream : ()Ljava/io/InputStream;
    //   158: astore_2
    //   159: aload_2
    //   160: aload_0
    //   161: getfield data : Lcom/squareup/picasso/Request;
    //   164: invokestatic decodeStream : (Ljava/io/InputStream;Lcom/squareup/picasso/Request;)Landroid/graphics/Bitmap;
    //   167: astore_1
    //   168: aload_2
    //   169: invokestatic closeQuietly : (Ljava/io/InputStream;)V
    //   172: aload_1
    //   173: astore_2
    //   174: aload_1
    //   175: ifnull -> 377
    //   178: aload_0
    //   179: getfield picasso : Lcom/squareup/picasso/Picasso;
    //   182: getfield loggingEnabled : Z
    //   185: ifeq -> 204
    //   188: ldc_w 'Hunter'
    //   191: ldc_w 'decoded'
    //   194: aload_0
    //   195: getfield data : Lcom/squareup/picasso/Request;
    //   198: invokevirtual logId : ()Ljava/lang/String;
    //   201: invokestatic log : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   204: aload_0
    //   205: getfield stats : Lcom/squareup/picasso/Stats;
    //   208: aload_1
    //   209: invokevirtual dispatchBitmapDecoded : (Landroid/graphics/Bitmap;)V
    //   212: aload_0
    //   213: getfield data : Lcom/squareup/picasso/Request;
    //   216: invokevirtual needsTransformation : ()Z
    //   219: ifne -> 231
    //   222: aload_1
    //   223: astore_2
    //   224: aload_0
    //   225: getfield exifRotation : I
    //   228: ifeq -> 377
    //   231: getstatic com/squareup/picasso/BitmapHunter.DECODE_LOCK : Ljava/lang/Object;
    //   234: astore #4
    //   236: aload #4
    //   238: monitorenter
    //   239: aload_0
    //   240: getfield data : Lcom/squareup/picasso/Request;
    //   243: invokevirtual needsMatrixTransform : ()Z
    //   246: ifne -> 258
    //   249: aload_1
    //   250: astore_2
    //   251: aload_0
    //   252: getfield exifRotation : I
    //   255: ifeq -> 301
    //   258: aload_0
    //   259: getfield data : Lcom/squareup/picasso/Request;
    //   262: aload_1
    //   263: aload_0
    //   264: getfield exifRotation : I
    //   267: invokestatic transformResult : (Lcom/squareup/picasso/Request;Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   270: astore_1
    //   271: aload_1
    //   272: astore_2
    //   273: aload_0
    //   274: getfield picasso : Lcom/squareup/picasso/Picasso;
    //   277: getfield loggingEnabled : Z
    //   280: ifeq -> 301
    //   283: ldc_w 'Hunter'
    //   286: ldc_w 'transformed'
    //   289: aload_0
    //   290: getfield data : Lcom/squareup/picasso/Request;
    //   293: invokevirtual logId : ()Ljava/lang/String;
    //   296: invokestatic log : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload_1
    //   300: astore_2
    //   301: aload_2
    //   302: astore_1
    //   303: aload_0
    //   304: getfield data : Lcom/squareup/picasso/Request;
    //   307: invokevirtual hasCustomTransformations : ()Z
    //   310: ifeq -> 358
    //   313: aload_0
    //   314: getfield data : Lcom/squareup/picasso/Request;
    //   317: getfield transformations : Ljava/util/List;
    //   320: aload_2
    //   321: invokestatic applyCustomTransformations : (Ljava/util/List;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   324: astore_2
    //   325: aload_2
    //   326: astore_1
    //   327: aload_0
    //   328: getfield picasso : Lcom/squareup/picasso/Picasso;
    //   331: getfield loggingEnabled : Z
    //   334: ifeq -> 358
    //   337: ldc_w 'Hunter'
    //   340: ldc_w 'transformed'
    //   343: aload_0
    //   344: getfield data : Lcom/squareup/picasso/Request;
    //   347: invokevirtual logId : ()Ljava/lang/String;
    //   350: ldc_w 'from custom transformations'
    //   353: invokestatic log : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload_2
    //   357: astore_1
    //   358: aload #4
    //   360: monitorexit
    //   361: aload_1
    //   362: astore_2
    //   363: aload_1
    //   364: ifnull -> 377
    //   367: aload_0
    //   368: getfield stats : Lcom/squareup/picasso/Stats;
    //   371: aload_1
    //   372: invokevirtual dispatchBitmapTransformed : (Landroid/graphics/Bitmap;)V
    //   375: aload_1
    //   376: astore_2
    //   377: goto -> 75
    //   380: aload_0
    //   381: getfield networkPolicy : I
    //   384: istore_3
    //   385: goto -> 96
    //   388: astore_1
    //   389: aload_2
    //   390: invokestatic closeQuietly : (Ljava/io/InputStream;)V
    //   393: aload_1
    //   394: athrow
    //   395: astore_1
    //   396: aload #4
    //   398: monitorexit
    //   399: aload_1
    //   400: athrow
    // Exception table:
    //   from	to	target	type
    //   159	168	388	finally
    //   239	249	395	finally
    //   251	258	395	finally
    //   258	271	395	finally
    //   273	299	395	finally
    //   303	325	395	finally
    //   327	356	395	finally
    //   358	361	395	finally
    //   396	399	395	finally
  }
  
  boolean isCancelled() {
    return (this.future != null && this.future.isCancelled());
  }
  
  public void run() {
    try {
      updateThreadName(this.data);
      if (this.picasso.loggingEnabled)
        Utils.log("Hunter", "executing", Utils.getLogIdsForHunter(this)); 
      this.result = hunt();
      if (this.result == null) {
        this.dispatcher.dispatchFailed(this);
      } else {
        this.dispatcher.dispatchComplete(this);
      } 
      return;
    } catch (ResponseException responseException) {
      if (!responseException.localCacheOnly || responseException.responseCode != 504)
        this.exception = responseException; 
      this.dispatcher.dispatchFailed(this);
      return;
    } catch (ContentLengthException contentLengthException) {
      this.exception = contentLengthException;
      this.dispatcher.dispatchRetry(this);
      return;
    } catch (IOException iOException) {
      this.exception = iOException;
      this.dispatcher.dispatchRetry(this);
      return;
    } catch (OutOfMemoryError outOfMemoryError) {
      StringWriter stringWriter = new StringWriter();
      this();
      StatsSnapshot statsSnapshot = this.stats.createSnapshot();
      PrintWriter printWriter = new PrintWriter();
      this(stringWriter);
      statsSnapshot.dump(printWriter);
      RuntimeException runtimeException = new RuntimeException();
      this(stringWriter.toString(), outOfMemoryError);
      this.exception = runtimeException;
      this.dispatcher.dispatchFailed(this);
      return;
    } catch (Exception exception) {
      this.exception = exception;
      this.dispatcher.dispatchFailed(this);
      return;
    } finally {
      Thread.currentThread().setName("Picasso-Idle");
    } 
  }
  
  boolean shouldRetry(boolean paramBoolean, NetworkInfo paramNetworkInfo) {
    boolean bool2;
    boolean bool1 = false;
    if (this.retryCount > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (!bool2)
      return bool1; 
    this.retryCount--;
    return this.requestHandler.shouldRetry(paramBoolean, paramNetworkInfo);
  }
  
  boolean supportsReplay() {
    return this.requestHandler.supportsReplay();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\squareup\picasso\BitmapHunter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */