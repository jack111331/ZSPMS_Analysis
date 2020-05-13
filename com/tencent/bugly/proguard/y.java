package com.tencent.bugly.proguard;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;

public final class y {
  public static boolean a = true;
  
  private static SimpleDateFormat b;
  
  private static int c = 5120;
  
  private static StringBuilder d;
  
  private static StringBuilder e;
  
  private static boolean f;
  
  private static a g;
  
  private static String h;
  
  private static String i;
  
  private static Context j;
  
  private static String k;
  
  private static boolean l;
  
  private static boolean m;
  
  private static ExecutorService n;
  
  private static int o;
  
  private static final Object p = new Object();
  
  static {
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
      this("MM-dd HH:mm:ss");
      b = simpleDateFormat;
      return;
    } catch (Throwable throwable) {
      return;
    } 
  }
  
  public static void a(int paramInt) {
    synchronized (p) {
      c = paramInt;
      if (paramInt < 0) {
        c = 0;
      } else if (paramInt > 10240) {
        c = 10240;
      } 
      return;
    } 
  }
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/y
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/proguard/y.l : Z
    //   6: ifne -> 162
    //   9: aload_0
    //   10: ifnull -> 162
    //   13: getstatic com/tencent/bugly/proguard/y.a : Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne -> 24
    //   21: goto -> 162
    //   24: invokestatic newSingleThreadExecutor : ()Ljava/util/concurrent/ExecutorService;
    //   27: putstatic com/tencent/bugly/proguard/y.n : Ljava/util/concurrent/ExecutorService;
    //   30: new java/lang/StringBuilder
    //   33: astore_2
    //   34: aload_2
    //   35: iconst_0
    //   36: invokespecial <init> : (I)V
    //   39: aload_2
    //   40: putstatic com/tencent/bugly/proguard/y.e : Ljava/lang/StringBuilder;
    //   43: new java/lang/StringBuilder
    //   46: astore_2
    //   47: aload_2
    //   48: iconst_0
    //   49: invokespecial <init> : (I)V
    //   52: aload_2
    //   53: putstatic com/tencent/bugly/proguard/y.d : Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: putstatic com/tencent/bugly/proguard/y.j : Landroid/content/Context;
    //   60: aload_0
    //   61: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   64: astore_0
    //   65: aload_0
    //   66: getfield d : Ljava/lang/String;
    //   69: putstatic com/tencent/bugly/proguard/y.h : Ljava/lang/String;
    //   72: aload_0
    //   73: invokevirtual getClass : ()Ljava/lang/Class;
    //   76: pop
    //   77: ldc ''
    //   79: putstatic com/tencent/bugly/proguard/y.i : Ljava/lang/String;
    //   82: new java/lang/StringBuilder
    //   85: astore_0
    //   86: aload_0
    //   87: invokespecial <init> : ()V
    //   90: aload_0
    //   91: getstatic com/tencent/bugly/proguard/y.j : Landroid/content/Context;
    //   94: invokevirtual getFilesDir : ()Ljava/io/File;
    //   97: invokevirtual getPath : ()Ljava/lang/String;
    //   100: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_0
    //   105: ldc '/buglylog_'
    //   107: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_0
    //   112: getstatic com/tencent/bugly/proguard/y.h : Ljava/lang/String;
    //   115: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_0
    //   120: ldc '_'
    //   122: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_0
    //   127: getstatic com/tencent/bugly/proguard/y.i : Ljava/lang/String;
    //   130: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_0
    //   135: ldc '.txt'
    //   137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_0
    //   142: invokevirtual toString : ()Ljava/lang/String;
    //   145: putstatic com/tencent/bugly/proguard/y.k : Ljava/lang/String;
    //   148: invokestatic myPid : ()I
    //   151: putstatic com/tencent/bugly/proguard/y.o : I
    //   154: iconst_1
    //   155: putstatic com/tencent/bugly/proguard/y.l : Z
    //   158: ldc com/tencent/bugly/proguard/y
    //   160: monitorexit
    //   161: return
    //   162: ldc com/tencent/bugly/proguard/y
    //   164: monitorexit
    //   165: return
    //   166: astore_0
    //   167: ldc com/tencent/bugly/proguard/y
    //   169: monitorexit
    //   170: aload_0
    //   171: athrow
    //   172: astore_0
    //   173: goto -> 154
    // Exception table:
    //   from	to	target	type
    //   3	9	166	finally
    //   13	17	166	finally
    //   24	154	172	java/lang/Throwable
    //   24	154	166	finally
    //   154	158	166	finally
  }
  
  public static void a(String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/y
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/proguard/y.l : Z
    //   6: ifeq -> 97
    //   9: getstatic com/tencent/bugly/proguard/y.a : Z
    //   12: istore_3
    //   13: iload_3
    //   14: ifne -> 20
    //   17: goto -> 97
    //   20: getstatic com/tencent/bugly/proguard/y.m : Z
    //   23: ifeq -> 56
    //   26: getstatic com/tencent/bugly/proguard/y.n : Ljava/util/concurrent/ExecutorService;
    //   29: astore #4
    //   31: new com/tencent/bugly/proguard/y$1
    //   34: astore #5
    //   36: aload #5
    //   38: aload_0
    //   39: aload_1
    //   40: aload_2
    //   41: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload #4
    //   46: aload #5
    //   48: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   53: goto -> 93
    //   56: getstatic com/tencent/bugly/proguard/y.n : Ljava/util/concurrent/ExecutorService;
    //   59: astore #4
    //   61: new com/tencent/bugly/proguard/y$2
    //   64: astore #5
    //   66: aload #5
    //   68: aload_0
    //   69: aload_1
    //   70: aload_2
    //   71: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload #4
    //   76: aload #5
    //   78: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   83: ldc com/tencent/bugly/proguard/y
    //   85: monitorexit
    //   86: return
    //   87: astore_0
    //   88: aload_0
    //   89: invokestatic b : (Ljava/lang/Throwable;)Z
    //   92: pop
    //   93: ldc com/tencent/bugly/proguard/y
    //   95: monitorexit
    //   96: return
    //   97: ldc com/tencent/bugly/proguard/y
    //   99: monitorexit
    //   100: return
    //   101: astore_0
    //   102: ldc com/tencent/bugly/proguard/y
    //   104: monitorexit
    //   105: aload_0
    //   106: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	101	finally
    //   20	53	87	java/lang/Exception
    //   20	53	101	finally
    //   56	83	87	java/lang/Exception
    //   56	83	101	finally
    //   88	93	101	finally
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable) {
    if (paramThrowable == null)
      return; 
    String str1 = paramThrowable.getMessage();
    String str2 = str1;
    if (str1 == null)
      str2 = ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str2);
    stringBuilder.append('\n');
    stringBuilder.append(z.b(paramThrowable));
    a(paramString1, paramString2, stringBuilder.toString());
  }
  
  public static void a(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder("[LogUtil] Whether can record user log into native: ");
    stringBuilder.append(paramBoolean);
    x.a(stringBuilder.toString(), new Object[0]);
    m = paramBoolean;
  }
  
  public static byte[] a() {
    if (!a)
      return null; 
    if (m) {
      x.a("[LogUtil] Get user log from native.", new Object[0]);
      String str = b();
      if (str != null) {
        x.a("[LogUtil] Got user log from native: %d bytes", new Object[] { Integer.valueOf(str.length()) });
        return z.a((File)null, str, "BuglyNativeLog.txt");
      } 
    } 
    null = new StringBuilder();
    synchronized (p) {
      if (g != null && a.d(g) && a.a(g) != null && a.a(g).length() > 0L)
        null.append(z.a(a.a(g), 30720, true)); 
      if (e != null && e.length() > 0)
        null.append(e.toString()); 
      return z.a((File)null, null.toString(), "BuglyLog.txt");
    } 
  }
  
  private static String b() {
    try {
      com.tencent.bugly.crashreport.common.info.a a1 = com.tencent.bugly.crashreport.common.info.a.b();
      if (a1 != null && a1.D != null)
        return a1.D.getLogFromNative(); 
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
    } 
    return null;
  }
  
  private static boolean d(String paramString1, String paramString2, String paramString3) {
    try {
      com.tencent.bugly.crashreport.common.info.a a1 = com.tencent.bugly.crashreport.common.info.a.b();
      if (a1 != null && a1.D != null)
        return a1.D.appendLogToNative(paramString1, paramString2, paramString3); 
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
    } 
    return false;
  }
  
  private static void e(String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/y
    //   2: monitorenter
    //   3: invokestatic myTid : ()I
    //   6: i2l
    //   7: lstore_3
    //   8: getstatic com/tencent/bugly/proguard/y.d : Ljava/lang/StringBuilder;
    //   11: iconst_0
    //   12: invokevirtual setLength : (I)V
    //   15: aload_2
    //   16: astore #5
    //   18: aload_2
    //   19: invokevirtual length : ()I
    //   22: sipush #30720
    //   25: if_icmple -> 48
    //   28: aload_2
    //   29: aload_2
    //   30: invokevirtual length : ()I
    //   33: sipush #30720
    //   36: isub
    //   37: aload_2
    //   38: invokevirtual length : ()I
    //   41: iconst_1
    //   42: isub
    //   43: invokevirtual substring : (II)Ljava/lang/String;
    //   46: astore #5
    //   48: new java/util/Date
    //   51: astore_2
    //   52: aload_2
    //   53: invokespecial <init> : ()V
    //   56: getstatic com/tencent/bugly/proguard/y.b : Ljava/text/SimpleDateFormat;
    //   59: ifnull -> 73
    //   62: getstatic com/tencent/bugly/proguard/y.b : Ljava/text/SimpleDateFormat;
    //   65: aload_2
    //   66: invokevirtual format : (Ljava/util/Date;)Ljava/lang/String;
    //   69: astore_2
    //   70: goto -> 78
    //   73: aload_2
    //   74: invokevirtual toString : ()Ljava/lang/String;
    //   77: astore_2
    //   78: getstatic com/tencent/bugly/proguard/y.d : Ljava/lang/StringBuilder;
    //   81: astore #6
    //   83: aload #6
    //   85: aload_2
    //   86: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload #6
    //   92: ldc_w ' '
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload #6
    //   101: getstatic com/tencent/bugly/proguard/y.o : I
    //   104: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload #6
    //   110: ldc_w ' '
    //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload #6
    //   119: lload_3
    //   120: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload #6
    //   126: ldc_w ' '
    //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload #6
    //   135: aload_0
    //   136: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload #6
    //   142: ldc_w ' '
    //   145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload #6
    //   151: aload_1
    //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload #6
    //   158: ldc_w ': '
    //   161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload #6
    //   167: aload #5
    //   169: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload #6
    //   175: ldc_w '\\r\\n'
    //   178: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: getstatic com/tencent/bugly/proguard/y.d : Ljava/lang/StringBuilder;
    //   185: invokevirtual toString : ()Ljava/lang/String;
    //   188: astore_1
    //   189: getstatic com/tencent/bugly/proguard/y.p : Ljava/lang/Object;
    //   192: astore_0
    //   193: aload_0
    //   194: monitorenter
    //   195: getstatic com/tencent/bugly/proguard/y.e : Ljava/lang/StringBuilder;
    //   198: aload_1
    //   199: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: getstatic com/tencent/bugly/proguard/y.e : Ljava/lang/StringBuilder;
    //   206: invokevirtual length : ()I
    //   209: istore #7
    //   211: getstatic com/tencent/bugly/proguard/y.c : I
    //   214: istore #8
    //   216: iload #7
    //   218: iload #8
    //   220: if_icmpgt -> 229
    //   223: aload_0
    //   224: monitorexit
    //   225: ldc com/tencent/bugly/proguard/y
    //   227: monitorexit
    //   228: return
    //   229: getstatic com/tencent/bugly/proguard/y.f : Z
    //   232: istore #9
    //   234: iload #9
    //   236: ifeq -> 245
    //   239: aload_0
    //   240: monitorexit
    //   241: ldc com/tencent/bugly/proguard/y
    //   243: monitorexit
    //   244: return
    //   245: iconst_1
    //   246: putstatic com/tencent/bugly/proguard/y.f : Z
    //   249: getstatic com/tencent/bugly/proguard/y.g : Lcom/tencent/bugly/proguard/y$a;
    //   252: ifnonnull -> 273
    //   255: new com/tencent/bugly/proguard/y$a
    //   258: astore_1
    //   259: aload_1
    //   260: getstatic com/tencent/bugly/proguard/y.k : Ljava/lang/String;
    //   263: invokespecial <init> : (Ljava/lang/String;)V
    //   266: aload_1
    //   267: putstatic com/tencent/bugly/proguard/y.g : Lcom/tencent/bugly/proguard/y$a;
    //   270: goto -> 316
    //   273: getstatic com/tencent/bugly/proguard/y.g : Lcom/tencent/bugly/proguard/y$a;
    //   276: invokestatic a : (Lcom/tencent/bugly/proguard/y$a;)Ljava/io/File;
    //   279: ifnull -> 309
    //   282: getstatic com/tencent/bugly/proguard/y.g : Lcom/tencent/bugly/proguard/y$a;
    //   285: invokestatic a : (Lcom/tencent/bugly/proguard/y$a;)Ljava/io/File;
    //   288: invokevirtual length : ()J
    //   291: getstatic com/tencent/bugly/proguard/y.e : Ljava/lang/StringBuilder;
    //   294: invokevirtual length : ()I
    //   297: i2l
    //   298: ladd
    //   299: getstatic com/tencent/bugly/proguard/y.g : Lcom/tencent/bugly/proguard/y$a;
    //   302: invokestatic b : (Lcom/tencent/bugly/proguard/y$a;)J
    //   305: lcmp
    //   306: ifle -> 316
    //   309: getstatic com/tencent/bugly/proguard/y.g : Lcom/tencent/bugly/proguard/y$a;
    //   312: invokestatic c : (Lcom/tencent/bugly/proguard/y$a;)Z
    //   315: pop
    //   316: getstatic com/tencent/bugly/proguard/y.g : Lcom/tencent/bugly/proguard/y$a;
    //   319: getstatic com/tencent/bugly/proguard/y.e : Ljava/lang/StringBuilder;
    //   322: invokevirtual toString : ()Ljava/lang/String;
    //   325: invokevirtual a : (Ljava/lang/String;)Z
    //   328: ifeq -> 349
    //   331: getstatic com/tencent/bugly/proguard/y.e : Ljava/lang/StringBuilder;
    //   334: iconst_0
    //   335: invokevirtual setLength : (I)V
    //   338: iconst_0
    //   339: putstatic com/tencent/bugly/proguard/y.f : Z
    //   342: goto -> 349
    //   345: astore_1
    //   346: goto -> 355
    //   349: aload_0
    //   350: monitorexit
    //   351: ldc com/tencent/bugly/proguard/y
    //   353: monitorexit
    //   354: return
    //   355: aload_0
    //   356: monitorexit
    //   357: aload_1
    //   358: athrow
    //   359: astore_0
    //   360: ldc com/tencent/bugly/proguard/y
    //   362: monitorexit
    //   363: aload_0
    //   364: athrow
    //   365: astore_1
    //   366: goto -> 349
    // Exception table:
    //   from	to	target	type
    //   3	15	359	finally
    //   18	48	359	finally
    //   48	70	359	finally
    //   73	78	359	finally
    //   78	195	359	finally
    //   195	216	365	java/lang/Throwable
    //   195	216	345	finally
    //   223	225	345	finally
    //   229	234	365	java/lang/Throwable
    //   229	234	345	finally
    //   239	241	345	finally
    //   245	270	365	java/lang/Throwable
    //   245	270	345	finally
    //   273	309	365	java/lang/Throwable
    //   273	309	345	finally
    //   309	316	365	java/lang/Throwable
    //   309	316	345	finally
    //   316	342	365	java/lang/Throwable
    //   316	342	345	finally
    //   349	351	345	finally
    //   355	359	359	finally
  }
  
  public static final class a {
    private boolean a;
    
    private File b;
    
    private String c;
    
    private long d;
    
    private long e = 30720L;
    
    public a(String param1String) {
      if (param1String == null || param1String.equals(""))
        return; 
      this.c = param1String;
      this.a = a();
    }
    
    private boolean a() {
      try {
        File file = new File();
        this(this.c);
        this.b = file;
        if (this.b.exists() && !this.b.delete()) {
          this.a = false;
          return false;
        } 
        if (!this.b.createNewFile()) {
          this.a = false;
          return false;
        } 
        return true;
      } catch (Throwable throwable) {
        x.a(throwable);
        this.a = false;
        return false;
      } 
    }
    
    public final boolean a(String param1String) {
      Throwable throwable2;
      if (!this.a)
        return false; 
      String str1 = null;
      Object object = null;
      throwable1 = (Throwable)object;
      try {
        FileOutputStream fileOutputStream = new FileOutputStream();
        throwable1 = (Throwable)object;
        this(this.b, true);
      } catch (Throwable null) {
      
      } finally {
        param1String = null;
      } 
      String str2 = param1String;
      x.a(throwable2);
      str2 = param1String;
      this.a = false;
      if (param1String != null)
        try {
          param1String.close();
        } catch (IOException iOException) {} 
      return false;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\proguard\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */