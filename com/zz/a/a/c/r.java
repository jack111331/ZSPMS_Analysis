package com.zz.a.a.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.LruCache;
import com.zz.sdk.ParamChain;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;

public class r {
  private static final String a = "ImageCache";
  
  private static final int b = 5120;
  
  private static final int c = 10485760;
  
  private static final Bitmap.CompressFormat d = Bitmap.CompressFormat.JPEG;
  
  private static final int e = 70;
  
  private static final int f = 0;
  
  private static final boolean g = true;
  
  private static final boolean h = true;
  
  private static final boolean i = false;
  
  private l j;
  
  private LruCache k;
  
  private t l;
  
  private final Object m = new Object();
  
  private boolean n = true;
  
  private HashSet o;
  
  private r(t paramt) {
    a(paramt);
  }
  
  @TargetApi(12)
  public static int a(BitmapDrawable paramBitmapDrawable) {
    Bitmap bitmap = paramBitmapDrawable.getBitmap();
    if (ac.d())
      return bitmap.getByteCount(); 
    null = bitmap.getRowBytes();
    return bitmap.getHeight() * null;
  }
  
  @TargetApi(9)
  public static long a(File paramFile) {
    if (ac.b())
      return paramFile.getUsableSpace(); 
    if (!paramFile.exists())
      return 0L; 
    StatFs statFs = new StatFs(paramFile.getPath());
    null = statFs.getBlockSize();
    return statFs.getAvailableBlocks() * null;
  }
  
  public static r a(FragmentManager paramFragmentManager, t paramt) {
    u u = a(paramFragmentManager);
    r r2 = (r)u.a();
    r r1 = r2;
    if (r2 == null) {
      r1 = new r(paramt);
      u.a(r1);
    } 
    return r1;
  }
  
  public static r a(ParamChain paramParamChain, t paramt) {
    r r1 = (r)paramParamChain.get("ImageCache", r.class);
    r r2 = r1;
    if (r1 == null) {
      r2 = new r(paramt);
      paramParamChain.add("ImageCache", r2);
    } 
    return r2;
  }
  
  private static u a(FragmentManager paramFragmentManager) {
    u u1 = (u)paramFragmentManager.findFragmentByTag("ImageCache");
    u u2 = u1;
    if (u1 == null) {
      u2 = new u();
      paramFragmentManager.beginTransaction().add(u2, "ImageCache").commitAllowingStateLoss();
    } 
    return u2;
  }
  
  @TargetApi(8)
  public static File a(Context paramContext) {
    if (ac.a()) {
      File file = paramContext.getExternalCacheDir();
      if (file != null)
        return file; 
    } 
    if (a(Environment.getExternalStorageDirectory()) < 102400L)
      return paramContext.getCacheDir(); 
    String str = "/Android/data/" + paramContext.getPackageName() + "/cache/";
    return new File(Environment.getExternalStorageDirectory().getPath() + str);
  }
  
  public static File a(Context paramContext, String paramString) {
    if ("mounted".equals(Environment.getExternalStorageState()) || !e()) {
      str = a(paramContext).getPath();
      return new File(str + File.separator + paramString);
    } 
    String str = str.getCacheDir().getPath();
    return new File(str + File.separator + paramString);
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < paramArrayOfbyte.length; b++) {
      String str = Integer.toHexString(paramArrayOfbyte[b] & 0xFF);
      if (str.length() == 1)
        stringBuilder.append('0'); 
      stringBuilder.append(str);
    } 
    return stringBuilder.toString();
  }
  
  private void a(t paramt) {
    this.l = paramt;
    if (this.l.f) {
      if (ac.c())
        this.o = new HashSet(); 
      this.k = new s(this, this.l.a);
    } 
    if (paramt.h)
      a(); 
  }
  
  private static boolean a(Bitmap paramBitmap, BitmapFactory.Options paramOptions) {
    int i = paramOptions.outWidth / paramOptions.inSampleSize;
    int j = paramOptions.outHeight / paramOptions.inSampleSize;
    return (paramBitmap.getWidth() == i && paramBitmap.getHeight() == j);
  }
  
  public static String c(String paramString) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramString.getBytes());
      String str = a(messageDigest.digest());
      paramString = str;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      paramString = String.valueOf(paramString.hashCode());
    } 
    return paramString;
  }
  
  @TargetApi(9)
  public static boolean e() {
    return ac.b() ? Environment.isExternalStorageRemovable() : true;
  }
  
  protected Bitmap a(BitmapFactory.Options paramOptions) {
    // Byte code:
    //   0: aload_0
    //   1: getfield o : Ljava/util/HashSet;
    //   4: ifnull -> 88
    //   7: aload_0
    //   8: getfield o : Ljava/util/HashSet;
    //   11: invokevirtual isEmpty : ()Z
    //   14: ifne -> 88
    //   17: aload_0
    //   18: getfield o : Ljava/util/HashSet;
    //   21: invokevirtual iterator : ()Ljava/util/Iterator;
    //   24: astore_2
    //   25: aload_2
    //   26: invokeinterface hasNext : ()Z
    //   31: ifeq -> 88
    //   34: aload_2
    //   35: invokeinterface next : ()Ljava/lang/Object;
    //   40: checkcast java/lang/ref/SoftReference
    //   43: invokevirtual get : ()Ljava/lang/Object;
    //   46: checkcast android/graphics/Bitmap
    //   49: astore_3
    //   50: aload_3
    //   51: ifnull -> 79
    //   54: aload_3
    //   55: invokevirtual isMutable : ()Z
    //   58: ifeq -> 79
    //   61: aload_3
    //   62: aload_1
    //   63: invokestatic a : (Landroid/graphics/Bitmap;Landroid/graphics/BitmapFactory$Options;)Z
    //   66: ifeq -> 25
    //   69: aload_2
    //   70: invokeinterface remove : ()V
    //   75: aload_3
    //   76: astore_1
    //   77: aload_1
    //   78: areturn
    //   79: aload_2
    //   80: invokeinterface remove : ()V
    //   85: goto -> 25
    //   88: aconst_null
    //   89: astore_1
    //   90: goto -> 77
  }
  
  public BitmapDrawable a(String paramString) {
    BitmapDrawable bitmapDrawable = null;
    if (this.k != null)
      bitmapDrawable = (BitmapDrawable)this.k.get(paramString); 
    return bitmapDrawable;
  }
  
  public void a() {
    synchronized (this.m) {
      if (this.j == null || this.j.d()) {
        File file = this.l.c;
        if (this.l.g && file != null) {
          if (!file.exists())
            file.mkdirs(); 
          long l1 = a(file);
          int i = this.l.b;
          if (l1 > i)
            try {
              this.j = l.a(file, 1, 1, this.l.b);
            } catch (IOException iOException) {} 
        } 
      } 
      this.n = false;
      this.m.notifyAll();
      return;
    } 
  }
  
  public void a(String paramString, BitmapDrawable paramBitmapDrawable) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 8
    //   4: aload_2
    //   5: ifnonnull -> 9
    //   8: return
    //   9: aload_0
    //   10: getfield k : Landroid/support/v4/util/LruCache;
    //   13: ifnull -> 44
    //   16: ldc_w com/zz/a/a/c/ab
    //   19: aload_2
    //   20: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   23: ifeq -> 34
    //   26: aload_2
    //   27: checkcast com/zz/a/a/c/ab
    //   30: iconst_1
    //   31: invokevirtual b : (Z)V
    //   34: aload_0
    //   35: getfield k : Landroid/support/v4/util/LruCache;
    //   38: aload_1
    //   39: aload_2
    //   40: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   43: pop
    //   44: aload_0
    //   45: getfield m : Ljava/lang/Object;
    //   48: astore_3
    //   49: aload_3
    //   50: monitorenter
    //   51: aload_0
    //   52: getfield j : Lcom/zz/a/a/c/l;
    //   55: ifnull -> 145
    //   58: aload_1
    //   59: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   62: astore #4
    //   64: aconst_null
    //   65: astore_1
    //   66: aload_0
    //   67: getfield j : Lcom/zz/a/a/c/l;
    //   70: aload #4
    //   72: invokevirtual a : (Ljava/lang/String;)Lcom/zz/a/a/c/q;
    //   75: astore #5
    //   77: aload #5
    //   79: ifnonnull -> 155
    //   82: aload_0
    //   83: getfield j : Lcom/zz/a/a/c/l;
    //   86: aload #4
    //   88: invokevirtual b : (Ljava/lang/String;)Lcom/zz/a/a/c/n;
    //   91: astore #5
    //   93: aload #5
    //   95: ifnull -> 137
    //   98: aload #5
    //   100: iconst_0
    //   101: invokevirtual c : (I)Ljava/io/OutputStream;
    //   104: astore_1
    //   105: aload_2
    //   106: invokevirtual getBitmap : ()Landroid/graphics/Bitmap;
    //   109: aload_0
    //   110: getfield l : Lcom/zz/a/a/c/t;
    //   113: getfield d : Landroid/graphics/Bitmap$CompressFormat;
    //   116: aload_0
    //   117: getfield l : Lcom/zz/a/a/c/t;
    //   120: getfield e : I
    //   123: aload_1
    //   124: invokevirtual compress : (Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   127: pop
    //   128: aload #5
    //   130: invokevirtual a : ()V
    //   133: aload_1
    //   134: invokevirtual close : ()V
    //   137: aload_1
    //   138: ifnull -> 145
    //   141: aload_1
    //   142: invokevirtual close : ()V
    //   145: aload_3
    //   146: monitorexit
    //   147: goto -> 8
    //   150: astore_1
    //   151: aload_3
    //   152: monitorexit
    //   153: aload_1
    //   154: athrow
    //   155: aload #5
    //   157: iconst_0
    //   158: invokevirtual a : (I)Ljava/io/InputStream;
    //   161: invokevirtual close : ()V
    //   164: goto -> 137
    //   167: astore #5
    //   169: aconst_null
    //   170: astore_2
    //   171: aload_2
    //   172: astore_1
    //   173: new java/lang/StringBuilder
    //   176: astore #4
    //   178: aload_2
    //   179: astore_1
    //   180: aload #4
    //   182: invokespecial <init> : ()V
    //   185: aload_2
    //   186: astore_1
    //   187: ldc 'ImageCache'
    //   189: aload #4
    //   191: ldc_w 'addBitmapToCache - '
    //   194: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload #5
    //   199: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   202: invokevirtual toString : ()Ljava/lang/String;
    //   205: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   208: pop
    //   209: aload_2
    //   210: ifnull -> 145
    //   213: aload_2
    //   214: invokevirtual close : ()V
    //   217: goto -> 145
    //   220: astore_1
    //   221: goto -> 145
    //   224: astore #5
    //   226: aconst_null
    //   227: astore_2
    //   228: aload_2
    //   229: astore_1
    //   230: new java/lang/StringBuilder
    //   233: astore #4
    //   235: aload_2
    //   236: astore_1
    //   237: aload #4
    //   239: invokespecial <init> : ()V
    //   242: aload_2
    //   243: astore_1
    //   244: ldc 'ImageCache'
    //   246: aload #4
    //   248: ldc_w 'addBitmapToCache - '
    //   251: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload #5
    //   256: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   259: invokevirtual toString : ()Ljava/lang/String;
    //   262: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   265: pop
    //   266: aload_2
    //   267: ifnull -> 145
    //   270: aload_2
    //   271: invokevirtual close : ()V
    //   274: goto -> 145
    //   277: astore_1
    //   278: goto -> 145
    //   281: astore_2
    //   282: aconst_null
    //   283: astore_1
    //   284: aload_1
    //   285: ifnull -> 292
    //   288: aload_1
    //   289: invokevirtual close : ()V
    //   292: aload_2
    //   293: athrow
    //   294: astore_1
    //   295: goto -> 145
    //   298: astore_1
    //   299: goto -> 292
    //   302: astore_2
    //   303: goto -> 284
    //   306: astore_2
    //   307: goto -> 284
    //   310: astore #5
    //   312: aload_1
    //   313: astore_2
    //   314: goto -> 228
    //   317: astore #5
    //   319: aload_1
    //   320: astore_2
    //   321: goto -> 171
    // Exception table:
    //   from	to	target	type
    //   51	64	150	finally
    //   66	77	167	java/io/IOException
    //   66	77	224	java/lang/Exception
    //   66	77	281	finally
    //   82	93	167	java/io/IOException
    //   82	93	224	java/lang/Exception
    //   82	93	281	finally
    //   98	105	167	java/io/IOException
    //   98	105	224	java/lang/Exception
    //   98	105	281	finally
    //   105	137	317	java/io/IOException
    //   105	137	310	java/lang/Exception
    //   105	137	302	finally
    //   141	145	294	java/io/IOException
    //   141	145	150	finally
    //   145	147	150	finally
    //   151	153	150	finally
    //   155	164	167	java/io/IOException
    //   155	164	224	java/lang/Exception
    //   155	164	281	finally
    //   173	178	306	finally
    //   180	185	306	finally
    //   187	209	306	finally
    //   213	217	220	java/io/IOException
    //   213	217	150	finally
    //   230	235	306	finally
    //   237	242	306	finally
    //   244	266	306	finally
    //   270	274	277	java/io/IOException
    //   270	274	150	finally
    //   288	292	298	java/io/IOException
    //   288	292	150	finally
    //   292	294	150	finally
  }
  
  public Bitmap b(String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_1
    //   5: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   8: astore_1
    //   9: aload_0
    //   10: getfield m : Ljava/lang/Object;
    //   13: astore #4
    //   15: aload #4
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield n : Z
    //   22: istore #5
    //   24: iload #5
    //   26: ifeq -> 44
    //   29: aload_0
    //   30: getfield m : Ljava/lang/Object;
    //   33: invokevirtual wait : ()V
    //   36: goto -> 18
    //   39: astore #6
    //   41: goto -> 18
    //   44: aload_0
    //   45: getfield j : Lcom/zz/a/a/c/l;
    //   48: astore #7
    //   50: aload_2
    //   51: astore #6
    //   53: aload #7
    //   55: ifnull -> 127
    //   58: aload_0
    //   59: getfield j : Lcom/zz/a/a/c/l;
    //   62: aload_1
    //   63: invokevirtual a : (Ljava/lang/String;)Lcom/zz/a/a/c/q;
    //   66: astore_1
    //   67: aload_1
    //   68: ifnull -> 238
    //   71: aload_1
    //   72: iconst_0
    //   73: invokevirtual a : (I)Ljava/io/InputStream;
    //   76: astore_1
    //   77: aload_1
    //   78: astore #7
    //   80: aload_1
    //   81: ifnull -> 111
    //   84: aload_1
    //   85: astore_3
    //   86: aload_1
    //   87: checkcast java/io/FileInputStream
    //   90: invokevirtual getFD : ()Ljava/io/FileDescriptor;
    //   93: ldc_w 2147483647
    //   96: ldc_w 2147483647
    //   99: aload_0
    //   100: invokestatic a : (Ljava/io/FileDescriptor;IILcom/zz/a/a/c/r;)Landroid/graphics/Bitmap;
    //   103: astore #6
    //   105: aload #6
    //   107: astore_3
    //   108: aload_1
    //   109: astore #7
    //   111: aload_3
    //   112: astore #6
    //   114: aload #7
    //   116: ifnull -> 127
    //   119: aload #7
    //   121: invokevirtual close : ()V
    //   124: aload_3
    //   125: astore #6
    //   127: aload #4
    //   129: monitorexit
    //   130: aload #6
    //   132: areturn
    //   133: astore #6
    //   135: aconst_null
    //   136: astore_1
    //   137: aload_1
    //   138: astore_3
    //   139: new java/lang/StringBuilder
    //   142: astore #7
    //   144: aload_1
    //   145: astore_3
    //   146: aload #7
    //   148: invokespecial <init> : ()V
    //   151: aload_1
    //   152: astore_3
    //   153: ldc 'ImageCache'
    //   155: aload #7
    //   157: ldc_w 'getBitmapFromDiskCache - '
    //   160: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload #6
    //   165: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: invokevirtual toString : ()Ljava/lang/String;
    //   171: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   174: pop
    //   175: aload_2
    //   176: astore #6
    //   178: aload_1
    //   179: ifnull -> 127
    //   182: aload_1
    //   183: invokevirtual close : ()V
    //   186: aload_2
    //   187: astore #6
    //   189: goto -> 127
    //   192: astore_1
    //   193: aload_2
    //   194: astore #6
    //   196: goto -> 127
    //   199: astore_1
    //   200: aconst_null
    //   201: astore_3
    //   202: aload_3
    //   203: ifnull -> 210
    //   206: aload_3
    //   207: invokevirtual close : ()V
    //   210: aload_1
    //   211: athrow
    //   212: astore_1
    //   213: aload #4
    //   215: monitorexit
    //   216: aload_1
    //   217: athrow
    //   218: astore_1
    //   219: aload_3
    //   220: astore #6
    //   222: goto -> 127
    //   225: astore_3
    //   226: goto -> 210
    //   229: astore_1
    //   230: goto -> 202
    //   233: astore #6
    //   235: goto -> 137
    //   238: aconst_null
    //   239: astore #7
    //   241: goto -> 111
    // Exception table:
    //   from	to	target	type
    //   18	24	212	finally
    //   29	36	39	java/lang/InterruptedException
    //   29	36	212	finally
    //   44	50	212	finally
    //   58	67	133	java/io/IOException
    //   58	67	199	finally
    //   71	77	133	java/io/IOException
    //   71	77	199	finally
    //   86	105	233	java/io/IOException
    //   86	105	229	finally
    //   119	124	218	java/io/IOException
    //   119	124	212	finally
    //   127	130	212	finally
    //   139	144	229	finally
    //   146	151	229	finally
    //   153	175	229	finally
    //   182	186	192	java/io/IOException
    //   182	186	212	finally
    //   206	210	225	java/io/IOException
    //   206	210	212	finally
    //   210	212	212	finally
    //   213	216	212	finally
  }
  
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: getfield k : Landroid/support/v4/util/LruCache;
    //   4: ifnull -> 14
    //   7: aload_0
    //   8: getfield k : Landroid/support/v4/util/LruCache;
    //   11: invokevirtual evictAll : ()V
    //   14: aload_0
    //   15: getfield m : Ljava/lang/Object;
    //   18: astore_1
    //   19: aload_1
    //   20: monitorenter
    //   21: aload_0
    //   22: iconst_1
    //   23: putfield n : Z
    //   26: aload_0
    //   27: getfield j : Lcom/zz/a/a/c/l;
    //   30: ifnull -> 61
    //   33: aload_0
    //   34: getfield j : Lcom/zz/a/a/c/l;
    //   37: invokevirtual d : ()Z
    //   40: istore_2
    //   41: iload_2
    //   42: ifne -> 61
    //   45: aload_0
    //   46: getfield j : Lcom/zz/a/a/c/l;
    //   49: invokevirtual f : ()V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield j : Lcom/zz/a/a/c/l;
    //   57: aload_0
    //   58: invokevirtual a : ()V
    //   61: aload_1
    //   62: monitorexit
    //   63: return
    //   64: astore_3
    //   65: new java/lang/StringBuilder
    //   68: astore #4
    //   70: aload #4
    //   72: invokespecial <init> : ()V
    //   75: ldc 'ImageCache'
    //   77: aload #4
    //   79: ldc_w 'clearCache - '
    //   82: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_3
    //   86: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: invokevirtual toString : ()Ljava/lang/String;
    //   92: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   95: pop
    //   96: goto -> 52
    //   99: astore #4
    //   101: aload_1
    //   102: monitorexit
    //   103: aload #4
    //   105: athrow
    // Exception table:
    //   from	to	target	type
    //   21	41	99	finally
    //   45	52	64	java/io/IOException
    //   45	52	99	finally
    //   52	61	99	finally
    //   61	63	99	finally
    //   65	96	99	finally
    //   101	103	99	finally
  }
  
  public void c() {
    synchronized (this.m) {
      l l1 = this.j;
      if (l1 != null)
        try {
          this.j.e();
        } catch (IOException iOException) {} 
      return;
    } 
  }
  
  public void d() {
    synchronized (this.m) {
      l l1 = this.j;
      if (l1 != null)
        try {
          if (!this.j.d()) {
            this.j.close();
            this.j = null;
          } 
        } catch (IOException iOException) {} 
      return;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */