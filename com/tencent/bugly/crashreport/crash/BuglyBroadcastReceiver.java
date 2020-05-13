package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.x;

public class BuglyBroadcastReceiver extends BroadcastReceiver {
  private static BuglyBroadcastReceiver d;
  
  private IntentFilter a = new IntentFilter();
  
  private Context b;
  
  private String c;
  
  private boolean e = true;
  
  private boolean a(Context paramContext, Intent paramIntent) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 300
    //   6: aload_2
    //   7: ifnull -> 300
    //   10: aload_2
    //   11: invokevirtual getAction : ()Ljava/lang/String;
    //   14: ldc 'android.net.conn.CONNECTIVITY_CHANGE'
    //   16: invokevirtual equals : (Ljava/lang/Object;)Z
    //   19: ifne -> 25
    //   22: goto -> 300
    //   25: aload_0
    //   26: getfield e : Z
    //   29: ifeq -> 41
    //   32: aload_0
    //   33: iconst_0
    //   34: putfield e : Z
    //   37: aload_0
    //   38: monitorexit
    //   39: iconst_1
    //   40: ireturn
    //   41: aload_0
    //   42: getfield b : Landroid/content/Context;
    //   45: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   48: astore_2
    //   49: new java/lang/StringBuilder
    //   52: astore_3
    //   53: aload_3
    //   54: ldc 'is Connect BC '
    //   56: invokespecial <init> : (Ljava/lang/String;)V
    //   59: aload_3
    //   60: aload_2
    //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_3
    //   66: invokevirtual toString : ()Ljava/lang/String;
    //   69: iconst_0
    //   70: anewarray java/lang/Object
    //   73: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   76: pop
    //   77: new java/lang/StringBuilder
    //   80: astore_3
    //   81: aload_3
    //   82: invokespecial <init> : ()V
    //   85: aload_3
    //   86: aload_0
    //   87: getfield c : Ljava/lang/String;
    //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_3
    //   95: invokevirtual toString : ()Ljava/lang/String;
    //   98: astore #4
    //   100: new java/lang/StringBuilder
    //   103: astore_3
    //   104: aload_3
    //   105: invokespecial <init> : ()V
    //   108: aload_3
    //   109: aload_2
    //   110: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: ldc 'network %s changed to %s'
    //   116: iconst_2
    //   117: anewarray java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload #4
    //   124: aastore
    //   125: dup
    //   126: iconst_1
    //   127: aload_3
    //   128: invokevirtual toString : ()Ljava/lang/String;
    //   131: aastore
    //   132: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   135: pop
    //   136: aload_2
    //   137: ifnonnull -> 149
    //   140: aload_0
    //   141: aconst_null
    //   142: putfield c : Ljava/lang/String;
    //   145: aload_0
    //   146: monitorexit
    //   147: iconst_1
    //   148: ireturn
    //   149: aload_0
    //   150: getfield c : Ljava/lang/String;
    //   153: astore #4
    //   155: aload_0
    //   156: aload_2
    //   157: putfield c : Ljava/lang/String;
    //   160: invokestatic currentTimeMillis : ()J
    //   163: lstore #5
    //   165: invokestatic a : ()Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   168: astore #7
    //   170: invokestatic a : ()Lcom/tencent/bugly/proguard/u;
    //   173: astore_3
    //   174: aload_1
    //   175: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   178: astore_1
    //   179: aload #7
    //   181: ifnull -> 281
    //   184: aload_3
    //   185: ifnull -> 281
    //   188: aload_1
    //   189: ifnonnull -> 195
    //   192: goto -> 281
    //   195: aload_2
    //   196: aload #4
    //   198: invokevirtual equals : (Ljava/lang/Object;)Z
    //   201: ifne -> 277
    //   204: lload #5
    //   206: aload_3
    //   207: getstatic com/tencent/bugly/crashreport/crash/c.a : I
    //   210: invokevirtual a : (I)J
    //   213: lsub
    //   214: ldc2_w 30000
    //   217: lcmp
    //   218: ifle -> 244
    //   221: ldc 'try to upload crash on network changed.'
    //   223: iconst_0
    //   224: anewarray java/lang/Object
    //   227: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   230: pop
    //   231: invokestatic a : ()Lcom/tencent/bugly/crashreport/crash/c;
    //   234: astore_1
    //   235: aload_1
    //   236: ifnull -> 244
    //   239: aload_1
    //   240: lconst_0
    //   241: invokevirtual a : (J)V
    //   244: lload #5
    //   246: aload_3
    //   247: sipush #1001
    //   250: invokevirtual a : (I)J
    //   253: lsub
    //   254: ldc2_w 30000
    //   257: lcmp
    //   258: ifle -> 277
    //   261: ldc 'try to upload userinfo on network changed.'
    //   263: iconst_0
    //   264: anewarray java/lang/Object
    //   267: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   270: pop
    //   271: getstatic com/tencent/bugly/crashreport/biz/b.a : Lcom/tencent/bugly/crashreport/biz/a;
    //   274: invokevirtual b : ()V
    //   277: aload_0
    //   278: monitorexit
    //   279: iconst_1
    //   280: ireturn
    //   281: ldc 'not inited BC not work'
    //   283: iconst_0
    //   284: anewarray java/lang/Object
    //   287: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   290: pop
    //   291: aload_0
    //   292: monitorexit
    //   293: iconst_1
    //   294: ireturn
    //   295: astore_1
    //   296: aload_0
    //   297: monitorexit
    //   298: aload_1
    //   299: athrow
    //   300: aload_0
    //   301: monitorexit
    //   302: iconst_0
    //   303: ireturn
    // Exception table:
    //   from	to	target	type
    //   10	22	295	finally
    //   25	37	295	finally
    //   41	136	295	finally
    //   140	145	295	finally
    //   149	179	295	finally
    //   195	235	295	finally
    //   239	244	295	finally
    //   244	277	295	finally
    //   281	291	295	finally
  }
  
  public static BuglyBroadcastReceiver getInstance() {
    // Byte code:
    //   0: ldc com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver.d : Lcom/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver;
    //   6: ifnonnull -> 21
    //   9: new com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver
    //   12: astore_0
    //   13: aload_0
    //   14: invokespecial <init> : ()V
    //   17: aload_0
    //   18: putstatic com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver.d : Lcom/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver;
    //   21: getstatic com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver.d : Lcom/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver;
    //   24: astore_0
    //   25: ldc com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
  }
  
  public void addFilter(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/content/IntentFilter;
    //   6: aload_1
    //   7: invokevirtual hasAction : (Ljava/lang/String;)Z
    //   10: ifne -> 21
    //   13: aload_0
    //   14: getfield a : Landroid/content/IntentFilter;
    //   17: aload_1
    //   18: invokevirtual addAction : (Ljava/lang/String;)V
    //   21: ldc 'add action %s'
    //   23: iconst_1
    //   24: anewarray java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_1
    //   30: aastore
    //   31: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   34: pop
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	38	finally
    //   21	35	38	finally
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent) {
    try {
      a(paramContext, paramIntent);
      return;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return;
    } 
  }
  
  public void register(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield b : Landroid/content/Context;
    //   7: new com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver$1
    //   10: astore_1
    //   11: aload_1
    //   12: aload_0
    //   13: aload_0
    //   14: invokespecial <init> : (Lcom/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver;Lcom/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver;)V
    //   17: aload_1
    //   18: invokestatic a : (Ljava/lang/Runnable;)Z
    //   21: pop
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	25	finally
  }
  
  public void unregister(Context paramContext) {
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver}} */
    try {
      x.a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
      paramContext.unregisterReceiver(this);
      this.b = paramContext;
      /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver}} */
      return;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver}} */
      return;
    } finally {}
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver}} */
    throw paramContext;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\crashreport\crash\BuglyBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */