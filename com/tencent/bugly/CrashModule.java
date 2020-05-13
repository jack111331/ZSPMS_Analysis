package com.tencent.bugly;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.c;

public class CrashModule extends a {
  public static final int MODULE_ID = 1004;
  
  private static int c;
  
  private static CrashModule e = new CrashModule();
  
  private long a;
  
  private BuglyStrategy.a b;
  
  private boolean d = false;
  
  private void a(Context paramContext, BuglyStrategy paramBuglyStrategy) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_2
    //   10: invokevirtual getLibBuglySOFilePath : ()Ljava/lang/String;
    //   13: astore_3
    //   14: aload_3
    //   15: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   18: ifne -> 43
    //   21: aload_1
    //   22: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   25: aload_3
    //   26: putfield m : Ljava/lang/String;
    //   29: ldc 'setted libBugly.so file path :%s'
    //   31: iconst_1
    //   32: anewarray java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload_3
    //   38: aastore
    //   39: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   42: pop
    //   43: aload_2
    //   44: invokevirtual getCrashHandleCallback : ()Lcom/tencent/bugly/BuglyStrategy$a;
    //   47: ifnull -> 68
    //   50: aload_0
    //   51: aload_2
    //   52: invokevirtual getCrashHandleCallback : ()Lcom/tencent/bugly/BuglyStrategy$a;
    //   55: putfield b : Lcom/tencent/bugly/BuglyStrategy$a;
    //   58: ldc 'setted CrashHanldeCallback'
    //   60: iconst_0
    //   61: anewarray java/lang/Object
    //   64: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   67: pop
    //   68: aload_2
    //   69: invokevirtual getAppReportDelay : ()J
    //   72: lconst_0
    //   73: lcmp
    //   74: ifle -> 105
    //   77: aload_0
    //   78: aload_2
    //   79: invokevirtual getAppReportDelay : ()J
    //   82: putfield a : J
    //   85: ldc 'setted delay: %d'
    //   87: iconst_1
    //   88: anewarray java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: aload_0
    //   94: getfield a : J
    //   97: invokestatic valueOf : (J)Ljava/lang/Long;
    //   100: aastore
    //   101: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   104: pop
    //   105: aload_0
    //   106: monitorexit
    //   107: return
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Exception table:
    //   from	to	target	type
    //   9	43	108	finally
    //   43	68	108	finally
    //   68	105	108	finally
  }
  
  public static CrashModule getInstance() {
    e.id = 1004;
    return e;
  }
  
  public String[] getTables() {
    return new String[] { "t_cr" };
  }
  
  public boolean hasInitialized() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public void init(Context paramContext, boolean paramBoolean, BuglyStrategy paramBuglyStrategy) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 249
    //   6: aload_0
    //   7: getfield d : Z
    //   10: ifeq -> 16
    //   13: goto -> 249
    //   16: ldc 'Initializing crash module.'
    //   18: iconst_0
    //   19: anewarray java/lang/Object
    //   22: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   25: pop
    //   26: invokestatic a : ()Lcom/tencent/bugly/proguard/n;
    //   29: astore #4
    //   31: getstatic com/tencent/bugly/CrashModule.c : I
    //   34: iconst_1
    //   35: iadd
    //   36: istore #5
    //   38: iload #5
    //   40: putstatic com/tencent/bugly/CrashModule.c : I
    //   43: aload #4
    //   45: sipush #1004
    //   48: iload #5
    //   50: invokevirtual a : (II)V
    //   53: aload_0
    //   54: iconst_1
    //   55: putfield d : Z
    //   58: aload_1
    //   59: invokestatic setContext : (Landroid/content/Context;)V
    //   62: aload_0
    //   63: aload_1
    //   64: aload_3
    //   65: invokespecial a : (Landroid/content/Context;Lcom/tencent/bugly/BuglyStrategy;)V
    //   68: sipush #1004
    //   71: aload_1
    //   72: iload_2
    //   73: aload_0
    //   74: getfield b : Lcom/tencent/bugly/BuglyStrategy$a;
    //   77: aconst_null
    //   78: aconst_null
    //   79: invokestatic a : (ILandroid/content/Context;ZLcom/tencent/bugly/BuglyStrategy$a;Lcom/tencent/bugly/proguard/o;Ljava/lang/String;)Lcom/tencent/bugly/crashreport/crash/c;
    //   82: astore #4
    //   84: aload #4
    //   86: invokevirtual e : ()V
    //   89: aload #4
    //   91: invokevirtual m : ()V
    //   94: aload_3
    //   95: ifnull -> 126
    //   98: aload_3
    //   99: invokevirtual isEnableNativeCrashMonitor : ()Z
    //   102: ifeq -> 108
    //   105: goto -> 126
    //   108: ldc '[crash] Closed native crash monitor!'
    //   110: iconst_0
    //   111: anewarray java/lang/Object
    //   114: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   117: pop
    //   118: aload #4
    //   120: invokevirtual f : ()V
    //   123: goto -> 131
    //   126: aload #4
    //   128: invokevirtual g : ()V
    //   131: aload_3
    //   132: ifnull -> 163
    //   135: aload_3
    //   136: invokevirtual isEnableANRCrashMonitor : ()Z
    //   139: ifeq -> 145
    //   142: goto -> 163
    //   145: ldc '[crash] Closed ANR monitor!'
    //   147: iconst_0
    //   148: anewarray java/lang/Object
    //   151: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   154: pop
    //   155: aload #4
    //   157: invokevirtual i : ()V
    //   160: goto -> 168
    //   163: aload #4
    //   165: invokevirtual h : ()V
    //   168: aload_3
    //   169: ifnull -> 181
    //   172: aload_3
    //   173: invokevirtual getAppReportDelay : ()J
    //   176: lstore #6
    //   178: goto -> 184
    //   181: lconst_0
    //   182: lstore #6
    //   184: aload #4
    //   186: lload #6
    //   188: invokevirtual a : (J)V
    //   191: aload #4
    //   193: invokevirtual l : ()V
    //   196: aload_1
    //   197: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/crashreport/crash/d;
    //   200: pop
    //   201: invokestatic getInstance : ()Lcom/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver;
    //   204: astore_3
    //   205: aload_3
    //   206: ldc 'android.net.conn.CONNECTIVITY_CHANGE'
    //   208: invokevirtual addFilter : (Ljava/lang/String;)V
    //   211: aload_3
    //   212: aload_1
    //   213: invokevirtual register : (Landroid/content/Context;)V
    //   216: invokestatic a : ()Lcom/tencent/bugly/proguard/n;
    //   219: astore_1
    //   220: getstatic com/tencent/bugly/CrashModule.c : I
    //   223: iconst_1
    //   224: isub
    //   225: istore #5
    //   227: iload #5
    //   229: putstatic com/tencent/bugly/CrashModule.c : I
    //   232: aload_1
    //   233: sipush #1004
    //   236: iload #5
    //   238: invokevirtual a : (II)V
    //   241: aload_0
    //   242: monitorexit
    //   243: return
    //   244: astore_1
    //   245: aload_0
    //   246: monitorexit
    //   247: aload_1
    //   248: athrow
    //   249: aload_0
    //   250: monitorexit
    //   251: return
    // Exception table:
    //   from	to	target	type
    //   6	13	244	finally
    //   16	94	244	finally
    //   98	105	244	finally
    //   108	123	244	finally
    //   126	131	244	finally
    //   135	142	244	finally
    //   145	160	244	finally
    //   163	168	244	finally
    //   172	178	244	finally
    //   184	241	244	finally
  }
  
  public void onServerStrategyChanged(StrategyBean paramStrategyBean) {
    if (paramStrategyBean == null)
      return; 
    c c = c.a();
    if (c != null)
      c.a(paramStrategyBean); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\CrashModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */