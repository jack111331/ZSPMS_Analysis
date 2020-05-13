package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Base64;
import com.tencent.bugly.b;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public final class u {
  private static u b;
  
  public boolean a = true;
  
  private final p c;
  
  private final Context d;
  
  private Map<Integer, Long> e = new HashMap<Integer, Long>();
  
  private long f;
  
  private long g;
  
  private LinkedBlockingQueue<Runnable> h = new LinkedBlockingQueue<Runnable>();
  
  private LinkedBlockingQueue<Runnable> i = new LinkedBlockingQueue<Runnable>();
  
  private final Object j = new Object();
  
  private String k = null;
  
  private byte[] l = null;
  
  private long m = 0L;
  
  private byte[] n = null;
  
  private long o = 0L;
  
  private String p = null;
  
  private long q = 0L;
  
  private final Object r = new Object();
  
  private boolean s = false;
  
  private final Object t = new Object();
  
  private int u = 0;
  
  private u(Context paramContext) {
    this.d = paramContext;
    this.c = p.a();
    try {
      Class.forName("android.util.Base64");
    } catch (ClassNotFoundException classNotFoundException) {
      x.a("[UploadManager] Error: Can not find Base64 class, will not use stronger security way to upload", new Object[0]);
      this.a = false;
    } 
    if (this.a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDP9x32s5pPtZBXzJBz2GWM/sbTvVO2+RvW0PH01IdaBxc/");
      stringBuilder.append("fB6fbHZocC9T3nl1+J5eAFjIRVuV8vHDky7Qo82Mnh0PVvcZIEQvMMVKU8dsMQopxgsOs2gkSHJwgWdinKNS8CmWobo6pFwPUW11lMv714jAUZRq2GBOqiO2vQI6iwIDAQAB");
      this.k = stringBuilder.toString();
    } 
  }
  
  public static u a() {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/u
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/proguard/u.b : Lcom/tencent/bugly/proguard/u;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/proguard/u
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/proguard/u
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static u a(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/u
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/proguard/u.b : Lcom/tencent/bugly/proguard/u;
    //   6: ifnonnull -> 22
    //   9: new com/tencent/bugly/proguard/u
    //   12: astore_1
    //   13: aload_1
    //   14: aload_0
    //   15: invokespecial <init> : (Landroid/content/Context;)V
    //   18: aload_1
    //   19: putstatic com/tencent/bugly/proguard/u.b : Lcom/tencent/bugly/proguard/u;
    //   22: getstatic com/tencent/bugly/proguard/u.b : Lcom/tencent/bugly/proguard/u;
    //   25: astore_0
    //   26: ldc com/tencent/bugly/proguard/u
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: ldc com/tencent/bugly/proguard/u
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	31	finally
    //   22	26	31	finally
  }
  
  private void a(Runnable paramRunnable, long paramLong) {
    if (paramRunnable == null) {
      x.d("[UploadManager] Upload task should not be null", new Object[0]);
      return;
    } 
    x.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    Thread thread = z.a(paramRunnable, "BUGLY_SYNC_UPLOAD");
    if (thread == null) {
      x.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
      a(paramRunnable, true);
      return;
    } 
    try {
      thread.join(paramLong);
      return;
    } catch (Throwable throwable) {
      x.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", new Object[] { throwable.getMessage() });
      a(paramRunnable, true);
      c(0);
      return;
    } 
  }
  
  private void a(Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2, long paramLong) {
    if (paramRunnable == null)
      x.d("[UploadManager] Upload task should not be null", new Object[0]); 
    x.c("[UploadManager] Add upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    if (this.p != null) {
      if (b()) {
        x.c("[UploadManager] Sucessfully got session ID, try to execute upload task now (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        if (paramBoolean2) {
          a(paramRunnable, paramLong);
          return;
        } 
        a(paramRunnable, paramBoolean1);
        c(0);
        return;
      } 
      x.a("[UploadManager] Session ID is expired, drop it (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      b(false);
    } 
    synchronized (this.t) {
      if (this.s) {
        a(paramRunnable, paramBoolean1);
        return;
      } 
      this.s = true;
      x.c("[UploadManager] Initialize security context now (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      if (paramBoolean2) {
        a(new a(this, this.d, paramRunnable, paramLong), 0L);
        return;
      } 
      a(paramRunnable, paramBoolean1);
      null = new a(this, this.d);
      x.a("[UploadManager] Create and start a new thread to execute a task of initializing security context: %s", new Object[] { "BUGLY_ASYNC_UPLOAD" });
      if (z.a((Runnable)null, "BUGLY_ASYNC_UPLOAD") == null) {
        x.d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
        w w = w.a();
        if (w != null) {
          w.a((Runnable)null);
          return;
        } 
        x.e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
        synchronized (this.t) {
          this.s = false;
          return;
        } 
      } 
      return;
    } 
  }
  
  private boolean a(Runnable paramRunnable, boolean paramBoolean) {
    if (paramRunnable == null) {
      x.a("[UploadManager] Upload task should not be null", new Object[0]);
      return false;
    } 
    try {
      x.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      Object object = this.j;
      /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
      if (paramBoolean) {
        try {
          this.h.put(paramRunnable);
        } finally {}
      } else {
        this.i.put(paramRunnable);
      } 
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
      return true;
    } catch (Throwable throwable) {
      x.e("[UploadManager] Failed to add upload task to queue: %s", new Object[] { throwable.getMessage() });
      return false;
    } 
  }
  
  private void c(int paramInt) {
    // Byte code:
    //   0: iload_1
    //   1: ifge -> 15
    //   4: ldc '[UploadManager] Number of task to execute should >= 0'
    //   6: iconst_0
    //   7: anewarray java/lang/Object
    //   10: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   13: pop
    //   14: return
    //   15: invokestatic a : ()Lcom/tencent/bugly/proguard/w;
    //   18: astore_2
    //   19: new java/util/concurrent/LinkedBlockingQueue
    //   22: dup
    //   23: invokespecial <init> : ()V
    //   26: astore_3
    //   27: new java/util/concurrent/LinkedBlockingQueue
    //   30: dup
    //   31: invokespecial <init> : ()V
    //   34: astore #4
    //   36: aload_0
    //   37: getfield j : Ljava/lang/Object;
    //   40: astore #5
    //   42: aload #5
    //   44: monitorenter
    //   45: ldc '[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)'
    //   47: iconst_2
    //   48: anewarray java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: invokestatic myPid : ()I
    //   56: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: invokestatic myTid : ()I
    //   65: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   68: aastore
    //   69: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   72: pop
    //   73: aload_0
    //   74: getfield h : Ljava/util/concurrent/LinkedBlockingQueue;
    //   77: invokevirtual size : ()I
    //   80: istore #6
    //   82: aload_0
    //   83: getfield i : Ljava/util/concurrent/LinkedBlockingQueue;
    //   86: invokevirtual size : ()I
    //   89: istore #7
    //   91: iload #6
    //   93: ifne -> 115
    //   96: iload #7
    //   98: ifne -> 115
    //   101: ldc '[UploadManager] There is no upload task in queue.'
    //   103: iconst_0
    //   104: anewarray java/lang/Object
    //   107: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   110: pop
    //   111: aload #5
    //   113: monitorexit
    //   114: return
    //   115: iload_1
    //   116: ifeq -> 154
    //   119: iload_1
    //   120: iload #6
    //   122: if_icmpge -> 137
    //   125: iconst_0
    //   126: istore #7
    //   128: iload_1
    //   129: istore #6
    //   131: iload #7
    //   133: istore_1
    //   134: goto -> 157
    //   137: iload_1
    //   138: iload #6
    //   140: iload #7
    //   142: iadd
    //   143: if_icmpge -> 154
    //   146: iload_1
    //   147: iload #6
    //   149: isub
    //   150: istore_1
    //   151: goto -> 157
    //   154: iload #7
    //   156: istore_1
    //   157: aload_2
    //   158: ifnull -> 168
    //   161: aload_2
    //   162: invokevirtual c : ()Z
    //   165: ifne -> 170
    //   168: iconst_0
    //   169: istore_1
    //   170: iconst_0
    //   171: istore #7
    //   173: iload #7
    //   175: iload #6
    //   177: if_icmpge -> 241
    //   180: aload_0
    //   181: getfield h : Ljava/util/concurrent/LinkedBlockingQueue;
    //   184: invokevirtual peek : ()Ljava/lang/Object;
    //   187: checkcast java/lang/Runnable
    //   190: astore #8
    //   192: aload #8
    //   194: ifnull -> 241
    //   197: aload_3
    //   198: aload #8
    //   200: invokevirtual put : (Ljava/lang/Object;)V
    //   203: aload_0
    //   204: getfield h : Ljava/util/concurrent/LinkedBlockingQueue;
    //   207: invokevirtual poll : ()Ljava/lang/Object;
    //   210: pop
    //   211: goto -> 235
    //   214: astore #8
    //   216: ldc_w '[UploadManager] Failed to add upload task to temp urgent queue: %s'
    //   219: iconst_1
    //   220: anewarray java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: aload #8
    //   227: invokevirtual getMessage : ()Ljava/lang/String;
    //   230: aastore
    //   231: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   234: pop
    //   235: iinc #7, 1
    //   238: goto -> 173
    //   241: iconst_0
    //   242: istore #7
    //   244: iload #7
    //   246: iload_1
    //   247: if_icmpge -> 312
    //   250: aload_0
    //   251: getfield i : Ljava/util/concurrent/LinkedBlockingQueue;
    //   254: invokevirtual peek : ()Ljava/lang/Object;
    //   257: checkcast java/lang/Runnable
    //   260: astore #8
    //   262: aload #8
    //   264: ifnull -> 312
    //   267: aload #4
    //   269: aload #8
    //   271: invokevirtual put : (Ljava/lang/Object;)V
    //   274: aload_0
    //   275: getfield i : Ljava/util/concurrent/LinkedBlockingQueue;
    //   278: invokevirtual poll : ()Ljava/lang/Object;
    //   281: pop
    //   282: goto -> 306
    //   285: astore #8
    //   287: ldc_w '[UploadManager] Failed to add upload task to temp urgent queue: %s'
    //   290: iconst_1
    //   291: anewarray java/lang/Object
    //   294: dup
    //   295: iconst_0
    //   296: aload #8
    //   298: invokevirtual getMessage : ()Ljava/lang/String;
    //   301: aastore
    //   302: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   305: pop
    //   306: iinc #7, 1
    //   309: goto -> 244
    //   312: aload #5
    //   314: monitorexit
    //   315: iload #6
    //   317: ifle -> 357
    //   320: ldc_w '[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)'
    //   323: iconst_3
    //   324: anewarray java/lang/Object
    //   327: dup
    //   328: iconst_0
    //   329: iload #6
    //   331: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   334: aastore
    //   335: dup
    //   336: iconst_1
    //   337: invokestatic myPid : ()I
    //   340: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   343: aastore
    //   344: dup
    //   345: iconst_2
    //   346: invokestatic myTid : ()I
    //   349: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   352: aastore
    //   353: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   356: pop
    //   357: iconst_0
    //   358: istore #7
    //   360: iload #7
    //   362: iload #6
    //   364: if_icmpge -> 514
    //   367: aload_3
    //   368: invokevirtual poll : ()Ljava/lang/Object;
    //   371: checkcast java/lang/Runnable
    //   374: astore #8
    //   376: aload #8
    //   378: ifnull -> 514
    //   381: aload_0
    //   382: getfield j : Ljava/lang/Object;
    //   385: astore #5
    //   387: aload #5
    //   389: monitorenter
    //   390: aload_0
    //   391: getfield u : I
    //   394: iconst_2
    //   395: if_icmplt -> 415
    //   398: aload_2
    //   399: ifnull -> 415
    //   402: aload_2
    //   403: aload #8
    //   405: invokevirtual a : (Ljava/lang/Runnable;)Z
    //   408: pop
    //   409: aload #5
    //   411: monitorexit
    //   412: goto -> 502
    //   415: aload #5
    //   417: monitorexit
    //   418: ldc_w '[UploadManager] Create and start a new thread to execute a upload task: %s'
    //   421: iconst_1
    //   422: anewarray java/lang/Object
    //   425: dup
    //   426: iconst_0
    //   427: ldc 'BUGLY_ASYNC_UPLOAD'
    //   429: aastore
    //   430: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   433: pop
    //   434: new com/tencent/bugly/proguard/u$1
    //   437: dup
    //   438: aload_0
    //   439: aload #8
    //   441: invokespecial <init> : (Lcom/tencent/bugly/proguard/u;Ljava/lang/Runnable;)V
    //   444: ldc 'BUGLY_ASYNC_UPLOAD'
    //   446: invokestatic a : (Ljava/lang/Runnable;Ljava/lang/String;)Ljava/lang/Thread;
    //   449: ifnull -> 483
    //   452: aload_0
    //   453: getfield j : Ljava/lang/Object;
    //   456: astore #5
    //   458: aload #5
    //   460: monitorenter
    //   461: aload_0
    //   462: aload_0
    //   463: getfield u : I
    //   466: iconst_1
    //   467: iadd
    //   468: putfield u : I
    //   471: aload #5
    //   473: monitorexit
    //   474: goto -> 502
    //   477: astore_3
    //   478: aload #5
    //   480: monitorexit
    //   481: aload_3
    //   482: athrow
    //   483: ldc_w '[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.'
    //   486: iconst_0
    //   487: anewarray java/lang/Object
    //   490: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   493: pop
    //   494: aload_0
    //   495: aload #8
    //   497: iconst_1
    //   498: invokespecial a : (Ljava/lang/Runnable;Z)Z
    //   501: pop
    //   502: iinc #7, 1
    //   505: goto -> 360
    //   508: astore_3
    //   509: aload #5
    //   511: monitorexit
    //   512: aload_3
    //   513: athrow
    //   514: iload_1
    //   515: ifle -> 554
    //   518: ldc_w '[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)'
    //   521: iconst_3
    //   522: anewarray java/lang/Object
    //   525: dup
    //   526: iconst_0
    //   527: iload_1
    //   528: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   531: aastore
    //   532: dup
    //   533: iconst_1
    //   534: invokestatic myPid : ()I
    //   537: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   540: aastore
    //   541: dup
    //   542: iconst_2
    //   543: invokestatic myTid : ()I
    //   546: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   549: aastore
    //   550: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   553: pop
    //   554: aload_2
    //   555: ifnull -> 574
    //   558: aload_2
    //   559: new com/tencent/bugly/proguard/u$2
    //   562: dup
    //   563: aload_0
    //   564: iload_1
    //   565: aload #4
    //   567: invokespecial <init> : (Lcom/tencent/bugly/proguard/u;ILjava/util/concurrent/LinkedBlockingQueue;)V
    //   570: invokevirtual a : (Ljava/lang/Runnable;)Z
    //   573: pop
    //   574: return
    //   575: astore_3
    //   576: aload #5
    //   578: monitorexit
    //   579: aload_3
    //   580: athrow
    // Exception table:
    //   from	to	target	type
    //   45	91	575	finally
    //   101	114	575	finally
    //   161	168	575	finally
    //   180	192	575	finally
    //   197	211	214	java/lang/Throwable
    //   197	211	575	finally
    //   216	235	575	finally
    //   250	262	575	finally
    //   267	282	285	java/lang/Throwable
    //   267	282	575	finally
    //   287	306	575	finally
    //   312	315	575	finally
    //   390	398	508	finally
    //   402	412	508	finally
    //   461	474	477	finally
  }
  
  private static boolean c() {
    x.c("[UploadManager] Drop security info of database (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try {
      p p1 = p.a();
      if (p1 == null) {
        x.d("[UploadManager] Failed to get Database", new Object[0]);
        return false;
      } 
      return p1.a(555, "security_info", (o)null, true);
    } catch (Throwable throwable) {
      x.a(throwable);
      return false;
    } 
  }
  
  private boolean d() {
    x.c("[UploadManager] Record security info to database (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try {
      p p1 = p.a();
      if (p1 == null) {
        x.d("[UploadManager] Failed to get database", new Object[0]);
        return false;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      this();
      if (this.n != null) {
        stringBuilder.append(Base64.encodeToString(this.n, 0));
        stringBuilder.append("#");
        if (this.o != 0L) {
          stringBuilder.append(Long.toString(this.o));
        } else {
          stringBuilder.append("null");
        } 
        stringBuilder.append("#");
        if (this.p != null) {
          stringBuilder.append(this.p);
        } else {
          stringBuilder.append("null");
        } 
        stringBuilder.append("#");
        if (this.q != 0L) {
          stringBuilder.append(Long.toString(this.q));
        } else {
          stringBuilder.append("null");
        } 
        p1.a(555, "security_info", stringBuilder.toString().getBytes(), (o)null, true);
        return true;
      } 
      x.c("[UploadManager] AES key is null, will not record", new Object[0]);
      return false;
    } catch (Throwable throwable) {
      x.a(throwable);
      c();
      return false;
    } 
  }
  
  private boolean e() {
    x.c("[UploadManager] Load security info from database (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try {
      p p1 = p.a();
      if (p1 == null) {
        x.d("[UploadManager] Failed to get database", new Object[0]);
        return false;
      } 
      Map<String, byte[]> map = p1.a(555, (o)null, true);
      if (map != null && map.containsKey("security_info")) {
        boolean bool;
        String str = new String();
        this(map.get("security_info"));
        String[] arrayOfString = str.split("#");
        if (arrayOfString.length == 4) {
          if (!arrayOfString[0].isEmpty()) {
            boolean bool2 = arrayOfString[0].equals("null");
            if (!bool2)
              try {
                this.n = Base64.decode(arrayOfString[0], 0);
              } catch (Throwable null) {
                x.a(throwable2);
                boolean bool3 = true;
              }  
          } 
          bool = false;
          boolean bool1 = bool;
          if (!bool) {
            bool1 = bool;
            if (!arrayOfString[1].isEmpty()) {
              boolean bool2 = arrayOfString[1].equals("null");
              bool1 = bool;
              if (!bool2)
                try {
                  this.o = Long.parseLong(arrayOfString[1]);
                  bool1 = bool;
                } catch (Throwable throwable2) {
                  x.a(throwable2);
                  bool1 = true;
                }  
            } 
          } 
          if (!bool1 && !arrayOfString[2].isEmpty() && !arrayOfString[2].equals("null"))
            this.p = arrayOfString[2]; 
          bool = bool1;
          if (!bool1) {
            bool = bool1;
            if (!arrayOfString[3].isEmpty()) {
              boolean bool2 = arrayOfString[3].equals("null");
              bool = bool1;
              if (!bool2)
                try {
                  this.q = Long.parseLong(arrayOfString[3]);
                  bool = bool1;
                } catch (Throwable throwable1) {
                  x.a(throwable1);
                  bool = true;
                }  
            } 
          } 
        } else {
          x.a("SecurityInfo = %s, Strings.length = %d", new Object[] { throwable2, Integer.valueOf(throwable1.length) });
          bool = true;
        } 
        if (bool)
          c(); 
      } 
      return true;
    } catch (Throwable throwable) {
      x.a(throwable);
      return false;
    } 
  }
  
  public final long a(int paramInt) {
    long l2;
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/proguard/u}} */
    long l1 = 0L;
    if (paramInt >= 0) {
      try {
        Long long_ = this.e.get(Integer.valueOf(paramInt));
        if (long_ != null) {
          long l = long_.longValue();
          /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/u}} */
          return l;
        } 
        List<r> list = this.c.a(paramInt);
        l2 = l1;
        if (list != null) {
          l2 = l1;
          if (list.size() > 0) {
            r r;
            if (list.size() > 1) {
              Iterator<r> iterator = list.iterator();
              l2 = l1;
              while (iterator.hasNext()) {
                r = iterator.next();
                if (r.e > l2)
                  l2 = r.e; 
              } 
              this.c.b(paramInt);
            } else {
              try {
                l2 = ((r)r.get(0)).e;
              } catch (Throwable throwable) {
                x.a(throwable);
                l2 = l1;
              } 
            } 
          } 
        } 
      } finally {
        Exception exception;
      } 
    } else {
      x.e("[UploadManager] Unknown upload ID: %d", new Object[] { Integer.valueOf(paramInt) });
      l2 = l1;
    } 
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/u}} */
    return l2;
  }
  
  public final long a(boolean paramBoolean) {
    byte b;
    long l2;
    long l1 = z.b();
    if (paramBoolean) {
      b = 5;
    } else {
      b = 3;
    } 
    List<r> list = this.c.a(b);
    if (list != null && list.size() > 0) {
      try {
        r r = list.get(0);
        if (r.e >= l1) {
          l1 = z.c(r.g);
          if (b == 3) {
            try {
              this.f = l1;
            } catch (Throwable throwable) {}
          } else {
            this.g = l1;
          } 
          list.remove(throwable);
        } else {
          l1 = 0L;
        } 
      } catch (Throwable throwable) {
        l1 = 0L;
        x.a(throwable);
      } 
      l2 = l1;
      if (list.size() > 0) {
        this.c.a(list);
        l2 = l1;
      } 
    } else if (paramBoolean) {
      l2 = this.g;
    } else {
      l2 = this.f;
    } 
    x.c("[UploadManager] Local network consume: %d KB", new Object[] { Long.valueOf(l2 / 1024L) });
    return l2;
  }
  
  public final void a(int paramInt1, int paramInt2, byte[] paramArrayOfbyte, String paramString1, String paramString2, t paramt, int paramInt3, int paramInt4, boolean paramBoolean, Map<String, String> paramMap) {
    try {
      v v = new v();
      this(this.d, paramInt1, paramInt2, paramArrayOfbyte, paramString1, paramString2, paramt, this.a, paramInt3, paramInt4, false, paramMap);
      a(v, paramBoolean, false, 0L);
      return;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return;
    } 
  }
  
  public final void a(int paramInt, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iflt -> 121
    //   6: aload_0
    //   7: getfield e : Ljava/util/Map;
    //   10: iload_1
    //   11: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   14: lload_2
    //   15: invokestatic valueOf : (J)Ljava/lang/Long;
    //   18: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   23: pop
    //   24: new com/tencent/bugly/proguard/r
    //   27: astore #4
    //   29: aload #4
    //   31: invokespecial <init> : ()V
    //   34: aload #4
    //   36: iload_1
    //   37: putfield b : I
    //   40: aload #4
    //   42: lload_2
    //   43: putfield e : J
    //   46: aload #4
    //   48: ldc_w ''
    //   51: putfield c : Ljava/lang/String;
    //   54: aload #4
    //   56: ldc_w ''
    //   59: putfield d : Ljava/lang/String;
    //   62: aload #4
    //   64: iconst_0
    //   65: newarray byte
    //   67: putfield g : [B
    //   70: aload_0
    //   71: getfield c : Lcom/tencent/bugly/proguard/p;
    //   74: iload_1
    //   75: invokevirtual b : (I)V
    //   78: aload_0
    //   79: getfield c : Lcom/tencent/bugly/proguard/p;
    //   82: aload #4
    //   84: invokevirtual a : (Lcom/tencent/bugly/proguard/r;)Z
    //   87: pop
    //   88: ldc_w '[UploadManager] Uploading(ID:%d) time: %s'
    //   91: iconst_2
    //   92: anewarray java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: iload_1
    //   98: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   101: aastore
    //   102: dup
    //   103: iconst_1
    //   104: lload_2
    //   105: invokestatic a : (J)Ljava/lang/String;
    //   108: aastore
    //   109: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   112: pop
    //   113: aload_0
    //   114: monitorexit
    //   115: return
    //   116: astore #4
    //   118: goto -> 142
    //   121: ldc_w '[UploadManager] Unknown uploading ID: %d'
    //   124: iconst_1
    //   125: anewarray java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: iload_1
    //   131: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   134: aastore
    //   135: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   138: pop
    //   139: aload_0
    //   140: monitorexit
    //   141: return
    //   142: aload_0
    //   143: monitorexit
    //   144: aload #4
    //   146: athrow
    // Exception table:
    //   from	to	target	type
    //   6	113	116	finally
    //   121	139	116	finally
  }
  
  public final void a(int paramInt, ap paramap, String paramString1, String paramString2, t paramt, long paramLong, boolean paramBoolean) {
    int i = paramap.g;
    byte[] arrayOfByte = a.a(paramap);
    try {
      v v = new v();
      this(this.d, paramInt, i, arrayOfByte, paramString1, paramString2, paramt, this.a, paramBoolean);
      a(v, true, true, paramLong);
      return;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return;
    } 
  }
  
  public final void a(int paramInt, ap paramap, String paramString1, String paramString2, t paramt, boolean paramBoolean) {
    a(paramInt, paramap.g, a.a(paramap), paramString1, paramString2, paramt, 0, 0, paramBoolean, null);
  }
  
  public final void a(int paramInt, aq paramaq) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Z
    //   4: ifne -> 8
    //   7: return
    //   8: iconst_1
    //   9: istore_3
    //   10: iconst_1
    //   11: istore #4
    //   13: iconst_1
    //   14: istore #5
    //   16: iload_1
    //   17: iconst_2
    //   18: if_icmpne -> 58
    //   21: ldc_w '[UploadManager] Session ID is invalid, will clear security context (pid=%d | tid=%d)'
    //   24: iconst_2
    //   25: anewarray java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: invokestatic myPid : ()I
    //   33: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: invokestatic myTid : ()I
    //   42: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   45: aastore
    //   46: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   49: pop
    //   50: aload_0
    //   51: iconst_1
    //   52: invokevirtual b : (Z)V
    //   55: goto -> 527
    //   58: aload_0
    //   59: getfield t : Ljava/lang/Object;
    //   62: astore #6
    //   64: aload #6
    //   66: monitorenter
    //   67: aload_0
    //   68: getfield s : Z
    //   71: ifne -> 78
    //   74: aload #6
    //   76: monitorexit
    //   77: return
    //   78: aload #6
    //   80: monitorexit
    //   81: aload_2
    //   82: ifnull -> 493
    //   85: ldc_w '[UploadManager] Record security context (pid=%d | tid=%d)'
    //   88: iconst_2
    //   89: anewarray java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: invokestatic myPid : ()I
    //   97: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: invokestatic myTid : ()I
    //   106: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   109: aastore
    //   110: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   113: pop
    //   114: iload_3
    //   115: istore #7
    //   117: aload_2
    //   118: getfield g : Ljava/util/Map;
    //   121: astore #6
    //   123: iload #4
    //   125: istore_1
    //   126: aload #6
    //   128: ifnull -> 481
    //   131: iload_3
    //   132: istore #7
    //   134: iload #4
    //   136: istore_1
    //   137: aload #6
    //   139: ldc_w 'S1'
    //   142: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   147: ifeq -> 481
    //   150: iload_3
    //   151: istore #7
    //   153: iload #4
    //   155: istore_1
    //   156: aload #6
    //   158: ldc_w 'S2'
    //   161: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   166: ifeq -> 481
    //   169: iload_3
    //   170: istore #7
    //   172: aload_0
    //   173: aload_2
    //   174: getfield e : J
    //   177: invokestatic currentTimeMillis : ()J
    //   180: lsub
    //   181: putfield m : J
    //   184: iload_3
    //   185: istore #7
    //   187: ldc_w '[UploadManager] Time lag of server is: %d'
    //   190: iconst_1
    //   191: anewarray java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: aload_0
    //   197: getfield m : J
    //   200: invokestatic valueOf : (J)Ljava/lang/Long;
    //   203: aastore
    //   204: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   207: pop
    //   208: iload_3
    //   209: istore #7
    //   211: aload_0
    //   212: aload #6
    //   214: ldc_w 'S1'
    //   217: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   222: checkcast java/lang/String
    //   225: putfield p : Ljava/lang/String;
    //   228: iload_3
    //   229: istore #7
    //   231: ldc_w '[UploadManager] Session ID from server is: %s'
    //   234: iconst_1
    //   235: anewarray java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: aload_0
    //   241: getfield p : Ljava/lang/String;
    //   244: aastore
    //   245: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   248: pop
    //   249: iload_3
    //   250: istore #7
    //   252: aload_0
    //   253: getfield p : Ljava/lang/String;
    //   256: invokevirtual length : ()I
    //   259: istore_1
    //   260: iload_1
    //   261: ifle -> 452
    //   264: iload_3
    //   265: istore #7
    //   267: aload_0
    //   268: aload #6
    //   270: ldc_w 'S2'
    //   273: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   278: checkcast java/lang/String
    //   281: invokestatic parseLong : (Ljava/lang/String;)J
    //   284: putfield q : J
    //   287: iload_3
    //   288: istore #7
    //   290: aload_0
    //   291: getfield q : J
    //   294: lstore #8
    //   296: iload_3
    //   297: istore #7
    //   299: new java/util/Date
    //   302: astore_2
    //   303: iload_3
    //   304: istore #7
    //   306: aload_2
    //   307: aload_0
    //   308: getfield q : J
    //   311: invokespecial <init> : (J)V
    //   314: iload_3
    //   315: istore #7
    //   317: ldc_w '[UploadManager] Session expired time from server is: %d(%s)'
    //   320: iconst_2
    //   321: anewarray java/lang/Object
    //   324: dup
    //   325: iconst_0
    //   326: lload #8
    //   328: invokestatic valueOf : (J)Ljava/lang/Long;
    //   331: aastore
    //   332: dup
    //   333: iconst_1
    //   334: aload_2
    //   335: invokevirtual toString : ()Ljava/lang/String;
    //   338: aastore
    //   339: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   342: pop
    //   343: iload_3
    //   344: istore #7
    //   346: aload_0
    //   347: getfield q : J
    //   350: ldc2_w 1000
    //   353: lcmp
    //   354: ifge -> 409
    //   357: iload_3
    //   358: istore #7
    //   360: ldc_w '[UploadManager] Session expired time from server is less than 1 second, will set to default value'
    //   363: iconst_0
    //   364: anewarray java/lang/Object
    //   367: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   370: pop
    //   371: iload_3
    //   372: istore #7
    //   374: aload_0
    //   375: ldc2_w 259200000
    //   378: putfield q : J
    //   381: goto -> 409
    //   384: astore_2
    //   385: iload_3
    //   386: istore #7
    //   388: ldc_w '[UploadManager] Session expired time is invalid, will set to default value'
    //   391: iconst_0
    //   392: anewarray java/lang/Object
    //   395: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   398: pop
    //   399: iload_3
    //   400: istore #7
    //   402: aload_0
    //   403: ldc2_w 259200000
    //   406: putfield q : J
    //   409: iload_3
    //   410: istore #7
    //   412: aload_0
    //   413: invokespecial d : ()Z
    //   416: ifeq -> 424
    //   419: iconst_0
    //   420: istore_1
    //   421: goto -> 441
    //   424: iload_3
    //   425: istore #7
    //   427: ldc_w '[UploadManager] Failed to record database'
    //   430: iconst_0
    //   431: anewarray java/lang/Object
    //   434: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   437: pop
    //   438: iload #5
    //   440: istore_1
    //   441: iload_1
    //   442: istore #7
    //   444: aload_0
    //   445: iconst_0
    //   446: invokespecial c : (I)V
    //   449: goto -> 481
    //   452: iload_3
    //   453: istore #7
    //   455: ldc_w '[UploadManager] Session ID from server is invalid, try next time'
    //   458: iconst_0
    //   459: anewarray java/lang/Object
    //   462: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   465: pop
    //   466: iload #4
    //   468: istore_1
    //   469: goto -> 481
    //   472: astore_2
    //   473: aload_2
    //   474: invokestatic a : (Ljava/lang/Throwable;)Z
    //   477: pop
    //   478: iload #7
    //   480: istore_1
    //   481: iload_1
    //   482: ifeq -> 527
    //   485: aload_0
    //   486: iconst_0
    //   487: invokevirtual b : (Z)V
    //   490: goto -> 527
    //   493: ldc_w '[UploadManager] Fail to init security context and clear local info (pid=%d | tid=%d)'
    //   496: iconst_2
    //   497: anewarray java/lang/Object
    //   500: dup
    //   501: iconst_0
    //   502: invokestatic myPid : ()I
    //   505: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   508: aastore
    //   509: dup
    //   510: iconst_1
    //   511: invokestatic myTid : ()I
    //   514: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   517: aastore
    //   518: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   521: pop
    //   522: aload_0
    //   523: iconst_0
    //   524: invokevirtual b : (Z)V
    //   527: aload_0
    //   528: getfield t : Ljava/lang/Object;
    //   531: astore_2
    //   532: aload_2
    //   533: monitorenter
    //   534: aload_0
    //   535: getfield s : Z
    //   538: ifeq -> 557
    //   541: aload_0
    //   542: iconst_0
    //   543: putfield s : Z
    //   546: aload_0
    //   547: getfield d : Landroid/content/Context;
    //   550: ldc_w 'security_info'
    //   553: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)Z
    //   556: pop
    //   557: aload_2
    //   558: monitorexit
    //   559: return
    //   560: astore #6
    //   562: aload_2
    //   563: monitorexit
    //   564: aload #6
    //   566: athrow
    //   567: astore_2
    //   568: aload #6
    //   570: monitorexit
    //   571: aload_2
    //   572: athrow
    // Exception table:
    //   from	to	target	type
    //   67	77	567	finally
    //   117	123	472	java/lang/Throwable
    //   137	150	472	java/lang/Throwable
    //   156	169	472	java/lang/Throwable
    //   172	184	472	java/lang/Throwable
    //   187	208	472	java/lang/Throwable
    //   211	228	472	java/lang/Throwable
    //   231	249	472	java/lang/Throwable
    //   252	260	472	java/lang/Throwable
    //   267	287	384	java/lang/NumberFormatException
    //   267	287	472	java/lang/Throwable
    //   290	296	384	java/lang/NumberFormatException
    //   290	296	472	java/lang/Throwable
    //   299	303	384	java/lang/NumberFormatException
    //   299	303	472	java/lang/Throwable
    //   306	314	384	java/lang/NumberFormatException
    //   306	314	472	java/lang/Throwable
    //   317	343	384	java/lang/NumberFormatException
    //   317	343	472	java/lang/Throwable
    //   346	357	384	java/lang/NumberFormatException
    //   346	357	472	java/lang/Throwable
    //   360	371	384	java/lang/NumberFormatException
    //   360	371	472	java/lang/Throwable
    //   374	381	384	java/lang/NumberFormatException
    //   374	381	472	java/lang/Throwable
    //   388	399	472	java/lang/Throwable
    //   402	409	472	java/lang/Throwable
    //   412	419	472	java/lang/Throwable
    //   427	438	472	java/lang/Throwable
    //   444	449	472	java/lang/Throwable
    //   455	466	472	java/lang/Throwable
    //   534	557	560	finally
    //   557	559	560	finally
  }
  
  protected final void a(long paramLong, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_3
    //   3: ifeq -> 12
    //   6: iconst_5
    //   7: istore #4
    //   9: goto -> 15
    //   12: iconst_3
    //   13: istore #4
    //   15: new com/tencent/bugly/proguard/r
    //   18: astore #5
    //   20: aload #5
    //   22: invokespecial <init> : ()V
    //   25: aload #5
    //   27: iload #4
    //   29: putfield b : I
    //   32: aload #5
    //   34: invokestatic b : ()J
    //   37: putfield e : J
    //   40: aload #5
    //   42: ldc_w ''
    //   45: putfield c : Ljava/lang/String;
    //   48: aload #5
    //   50: ldc_w ''
    //   53: putfield d : Ljava/lang/String;
    //   56: aload #5
    //   58: lload_1
    //   59: invokestatic c : (J)[B
    //   62: putfield g : [B
    //   65: aload_0
    //   66: getfield c : Lcom/tencent/bugly/proguard/p;
    //   69: iload #4
    //   71: invokevirtual b : (I)V
    //   74: aload_0
    //   75: getfield c : Lcom/tencent/bugly/proguard/p;
    //   78: aload #5
    //   80: invokevirtual a : (Lcom/tencent/bugly/proguard/r;)Z
    //   83: pop
    //   84: iload_3
    //   85: ifeq -> 96
    //   88: aload_0
    //   89: lload_1
    //   90: putfield g : J
    //   93: goto -> 101
    //   96: aload_0
    //   97: lload_1
    //   98: putfield f : J
    //   101: ldc_w '[UploadManager] Network total consume: %d KB'
    //   104: iconst_1
    //   105: anewarray java/lang/Object
    //   108: dup
    //   109: iconst_0
    //   110: lload_1
    //   111: ldc2_w 1024
    //   114: ldiv
    //   115: invokestatic valueOf : (J)Ljava/lang/Long;
    //   118: aastore
    //   119: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   122: pop
    //   123: aload_0
    //   124: monitorexit
    //   125: return
    //   126: astore #5
    //   128: aload_0
    //   129: monitorexit
    //   130: aload #5
    //   132: athrow
    // Exception table:
    //   from	to	target	type
    //   15	84	126	finally
    //   88	93	126	finally
    //   96	101	126	finally
    //   101	123	126	finally
  }
  
  public final boolean a(Map<String, String> paramMap) {
    if (paramMap == null)
      return false; 
    x.c("[UploadManager] Integrate security to HTTP headers (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    if (this.p != null) {
      paramMap.put("secureSessionId", this.p);
      return true;
    } 
    if (this.n == null || this.n.length << 3 != 128) {
      x.d("[UploadManager] AES key is invalid", new Object[0]);
      return false;
    } 
    if (this.l == null) {
      this.l = Base64.decode(this.k, 0);
      if (this.l == null) {
        x.d("[UploadManager] Failed to decode RSA public key", new Object[0]);
        return false;
      } 
    } 
    byte[] arrayOfByte = z.b(1, this.n, this.l);
    if (arrayOfByte == null) {
      x.d("[UploadManager] Failed to encrypt AES key", new Object[0]);
      return false;
    } 
    String str = Base64.encodeToString(arrayOfByte, 0);
    if (str == null) {
      x.d("[UploadManager] Failed to encode AES key", new Object[0]);
      return false;
    } 
    paramMap.put("raKey", str);
    return true;
  }
  
  public final byte[] a(byte[] paramArrayOfbyte) {
    if (this.n == null || this.n.length << 3 != 128) {
      x.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      return null;
    } 
    return z.a(1, paramArrayOfbyte, this.n);
  }
  
  protected final void b(boolean paramBoolean) {
    synchronized (this.r) {
      x.c("[UploadManager] Clear security context (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      this.n = null;
      this.p = null;
      this.q = 0L;
      if (paramBoolean)
        c(); 
      return;
    } 
  }
  
  protected final boolean b() {
    if (this.p == null || this.q == 0L)
      return false; 
    long l = System.currentTimeMillis() + this.m;
    if (this.q < l) {
      x.c("[UploadManager] Session ID expired time from server is: %d(%s), but now is: %d(%s)", new Object[] { Long.valueOf(this.q), (new Date(this.q)).toString(), Long.valueOf(l), (new Date(l)).toString() });
      return false;
    } 
    return true;
  }
  
  public final boolean b(int paramInt) {
    if (b.c) {
      x.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
      return true;
    } 
    long l = System.currentTimeMillis() - a(paramInt);
    x.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", new Object[] { Long.valueOf(l / 1000L), Integer.valueOf(paramInt) });
    if (l < 30000L) {
      x.a("[UploadManager] Data only be uploaded once in %d seconds.", new Object[] { Long.valueOf(30L) });
      return false;
    } 
    return true;
  }
  
  public final byte[] b(byte[] paramArrayOfbyte) {
    if (this.n == null || this.n.length << 3 != 128) {
      x.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      return null;
    } 
    return z.a(2, paramArrayOfbyte, this.n);
  }
  
  final class a implements Runnable {
    private final Context a;
    
    private final Runnable b;
    
    private final long c;
    
    public a(u this$0, Context param1Context) {
      this.a = param1Context;
      this.b = null;
      this.c = 0L;
    }
    
    public a(u this$0, Context param1Context, Runnable param1Runnable, long param1Long) {
      this.a = param1Context;
      this.b = param1Runnable;
      this.c = param1Long;
    }
    
    public final void run() {
      if (!z.a(this.a, "security_info", 30000L)) {
        x.c("[UploadManager] Sleep %d try to lock security file again (pid=%d | tid=%d)", new Object[] { Integer.valueOf(5000), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        z.b(5000L);
        if (z.a(this, "BUGLY_ASYNC_UPLOAD") == null) {
          x.d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
          w w = w.a();
          if (w != null) {
            w.a(this);
            return;
          } 
          x.e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
          return;
        } 
        return;
      } 
      if (!u.c(this.d)) {
        x.d("[UploadManager] Failed to load security info from database", new Object[0]);
        this.d.b(false);
      } 
      if (u.d(this.d) != null) {
        if (this.d.b()) {
          x.c("[UploadManager] Sucessfully got session ID, try to execute upload tasks now (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
          if (this.b != null)
            u.a(this.d, this.b, this.c); 
          u.a(this.d, 0);
          z.b(this.a, "security_info");
          synchronized (u.e(this.d)) {
            u.a(this.d, false);
            return;
          } 
        } 
        x.a("[UploadManager] Session ID is expired, drop it.", new Object[0]);
        this.d.b(true);
      } 
      null = z.a(128);
      if (null != null && null.length << 3 == 128) {
        u.a(this.d, null);
        x.c("[UploadManager] Execute one upload task for requesting session ID (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        if (this.b != null) {
          u.a(this.d, this.b, this.c);
          return;
        } 
        u.a(this.d, 1);
        return;
      } 
      x.d("[UploadManager] Failed to create AES key (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      this.d.b(false);
      z.b(this.a, "security_info");
      synchronized (u.e(this.d)) {
        u.a(this.d, false);
        return;
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\proguar\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */