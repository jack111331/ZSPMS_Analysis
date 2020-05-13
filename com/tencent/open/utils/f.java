package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;

public class f {
  private static f a = null;
  
  private volatile WeakReference<SharedPreferences> b = null;
  
  public static f a() {
    // Byte code:
    //   0: ldc com/tencent/open/utils/f
    //   2: monitorenter
    //   3: getstatic com/tencent/open/utils/f.a : Lcom/tencent/open/utils/f;
    //   6: ifnonnull -> 21
    //   9: new com/tencent/open/utils/f
    //   12: astore_0
    //   13: aload_0
    //   14: invokespecial <init> : ()V
    //   17: aload_0
    //   18: putstatic com/tencent/open/utils/f.a : Lcom/tencent/open/utils/f;
    //   21: getstatic com/tencent/open/utils/f.a : Lcom/tencent/open/utils/f;
    //   24: astore_0
    //   25: ldc com/tencent/open/utils/f
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc com/tencent/open/utils/f
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
  }
  
  public String a(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Ljava/lang/ref/WeakReference;
    //   4: ifnull -> 17
    //   7: aload_0
    //   8: getfield b : Ljava/lang/ref/WeakReference;
    //   11: invokevirtual get : ()Ljava/lang/Object;
    //   14: ifnonnull -> 35
    //   17: aload_0
    //   18: new java/lang/ref/WeakReference
    //   21: dup
    //   22: aload_1
    //   23: ldc 'ServerPrefs'
    //   25: iconst_0
    //   26: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   29: invokespecial <init> : (Ljava/lang/Object;)V
    //   32: putfield b : Ljava/lang/ref/WeakReference;
    //   35: aload_2
    //   36: astore_1
    //   37: new java/net/URL
    //   40: astore_3
    //   41: aload_2
    //   42: astore_1
    //   43: aload_3
    //   44: aload_2
    //   45: invokespecial <init> : (Ljava/lang/String;)V
    //   48: aload_2
    //   49: astore_1
    //   50: aload_3
    //   51: invokevirtual getHost : ()Ljava/lang/String;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnonnull -> 95
    //   59: aload_2
    //   60: astore_1
    //   61: new java/lang/StringBuilder
    //   64: astore_3
    //   65: aload_2
    //   66: astore_1
    //   67: aload_3
    //   68: invokespecial <init> : ()V
    //   71: aload_2
    //   72: astore_1
    //   73: ldc 'openSDK_LOG.ServerSetting'
    //   75: aload_3
    //   76: ldc 'Get host error. url='
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_2
    //   82: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual toString : ()Ljava/lang/String;
    //   88: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_2
    //   92: astore_1
    //   93: aload_1
    //   94: areturn
    //   95: aload_2
    //   96: astore_1
    //   97: aload_0
    //   98: getfield b : Ljava/lang/ref/WeakReference;
    //   101: invokevirtual get : ()Ljava/lang/Object;
    //   104: checkcast android/content/SharedPreferences
    //   107: aload_3
    //   108: aconst_null
    //   109: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   114: astore #4
    //   116: aload #4
    //   118: ifnull -> 132
    //   121: aload_2
    //   122: astore_1
    //   123: aload_3
    //   124: aload #4
    //   126: invokevirtual equals : (Ljava/lang/Object;)Z
    //   129: ifeq -> 222
    //   132: aload_2
    //   133: astore_1
    //   134: new java/lang/StringBuilder
    //   137: astore #5
    //   139: aload_2
    //   140: astore_1
    //   141: aload #5
    //   143: invokespecial <init> : ()V
    //   146: aload_2
    //   147: astore_1
    //   148: ldc 'openSDK_LOG.ServerSetting'
    //   150: aload #5
    //   152: ldc 'host='
    //   154: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_3
    //   158: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc ', envHost='
    //   163: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload #4
    //   168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual toString : ()Ljava/lang/String;
    //   174: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload_2
    //   178: astore_1
    //   179: goto -> 93
    //   182: astore_2
    //   183: ldc 'openSDK_LOG.ServerSetting'
    //   185: new java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial <init> : ()V
    //   192: ldc 'getEnvUrl url='
    //   194: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_1
    //   198: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc 'error.: '
    //   203: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_2
    //   207: invokevirtual getMessage : ()Ljava/lang/String;
    //   210: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual toString : ()Ljava/lang/String;
    //   216: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   219: goto -> 93
    //   222: aload_2
    //   223: astore_1
    //   224: aload_2
    //   225: aload_3
    //   226: aload #4
    //   228: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   231: astore_2
    //   232: aload_2
    //   233: astore_1
    //   234: new java/lang/StringBuilder
    //   237: astore_3
    //   238: aload_2
    //   239: astore_1
    //   240: aload_3
    //   241: invokespecial <init> : ()V
    //   244: aload_2
    //   245: astore_1
    //   246: ldc 'openSDK_LOG.ServerSetting'
    //   248: aload_3
    //   249: ldc 'return environment url : '
    //   251: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_2
    //   255: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual toString : ()Ljava/lang/String;
    //   261: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload_2
    //   265: astore_1
    //   266: goto -> 93
    // Exception table:
    //   from	to	target	type
    //   37	41	182	java/lang/Exception
    //   43	48	182	java/lang/Exception
    //   50	55	182	java/lang/Exception
    //   61	65	182	java/lang/Exception
    //   67	71	182	java/lang/Exception
    //   73	91	182	java/lang/Exception
    //   97	116	182	java/lang/Exception
    //   123	132	182	java/lang/Exception
    //   134	139	182	java/lang/Exception
    //   141	146	182	java/lang/Exception
    //   148	177	182	java/lang/Exception
    //   224	232	182	java/lang/Exception
    //   234	238	182	java/lang/Exception
    //   240	244	182	java/lang/Exception
    //   246	264	182	java/lang/Exception
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\ope\\utils\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */