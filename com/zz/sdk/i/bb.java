package com.zz.sdk.i;

import android.content.Context;
import com.zz.sdk.ParamChain;

final class bb extends Thread {
  bb(String paramString1, Context paramContext, String paramString2, ParamChain paramParamChain) {
    super(paramString1);
  }
  
  public void run() {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: invokestatic a : ()Ljava/lang/Object;
    //   5: astore_2
    //   6: aload_2
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield a : Landroid/content/Context;
    //   12: ldc 'devicesyn'
    //   14: iconst_0
    //   15: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   18: ldc 'devicesyn'
    //   20: aconst_null
    //   21: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnonnull -> 201
    //   31: aload_2
    //   32: monitorexit
    //   33: aload_0
    //   34: getfield a : Landroid/content/Context;
    //   37: invokestatic a : (Landroid/content/Context;)Lcom/zz/sdk/i/t;
    //   40: astore_3
    //   41: iload_1
    //   42: istore #4
    //   44: iload_1
    //   45: ifle -> 117
    //   48: aload_3
    //   49: aload_0
    //   50: getfield a : Landroid/content/Context;
    //   53: aload_0
    //   54: getfield b : Ljava/lang/String;
    //   57: aload_0
    //   58: getfield c : Lcom/zz/sdk/ParamChain;
    //   61: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Lcom/zz/sdk/ParamChain;)Lcom/zz/sdk/b/a/a;
    //   64: astore_2
    //   65: aload_2
    //   66: ifnull -> 195
    //   69: aload_2
    //   70: invokevirtual c : ()Z
    //   73: ifeq -> 195
    //   76: invokestatic a : ()Ljava/lang/Object;
    //   79: astore_2
    //   80: aload_2
    //   81: monitorenter
    //   82: aload_0
    //   83: getfield a : Landroid/content/Context;
    //   86: ldc 'devicesyn'
    //   88: iconst_0
    //   89: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   92: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   97: ldc 'devicesyn'
    //   99: ldc '0'
    //   101: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   106: invokeinterface commit : ()Z
    //   111: pop
    //   112: aload_2
    //   113: monitorexit
    //   114: iconst_0
    //   115: istore #4
    //   117: iload #4
    //   119: ifne -> 195
    //   122: aload_3
    //   123: invokevirtual f : ()Lcom/zz/sdk/b/a/t;
    //   126: astore_2
    //   127: aload_2
    //   128: ifnull -> 195
    //   131: aload_2
    //   132: invokevirtual e : ()Z
    //   135: ifeq -> 195
    //   138: aload_2
    //   139: invokevirtual d : ()I
    //   142: istore_1
    //   143: iload_1
    //   144: ifeq -> 152
    //   147: iload_1
    //   148: iconst_2
    //   149: if_icmpne -> 195
    //   152: invokestatic a : ()Ljava/lang/Object;
    //   155: astore_2
    //   156: aload_2
    //   157: monitorenter
    //   158: aload_0
    //   159: getfield a : Landroid/content/Context;
    //   162: ldc 'devicesyn'
    //   164: iconst_0
    //   165: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   168: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   173: ldc 'devicesyn'
    //   175: ldc '-1'
    //   177: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   182: invokeinterface commit : ()Z
    //   187: pop
    //   188: ldc 'DeviceUtil_regDevice:edit_DEVICESYN = -1'
    //   190: invokestatic a : (Ljava/lang/Object;)V
    //   193: aload_2
    //   194: monitorexit
    //   195: iconst_0
    //   196: invokestatic a : (Z)Z
    //   199: pop
    //   200: return
    //   201: ldc '0'
    //   203: aload_3
    //   204: invokevirtual equals : (Ljava/lang/Object;)Z
    //   207: ifeq -> 215
    //   210: iconst_0
    //   211: istore_1
    //   212: goto -> 31
    //   215: ldc '-1'
    //   217: aload_3
    //   218: invokevirtual equals : (Ljava/lang/Object;)Z
    //   221: ifeq -> 31
    //   224: iconst_m1
    //   225: istore_1
    //   226: goto -> 31
    //   229: astore_3
    //   230: aload_2
    //   231: monitorexit
    //   232: aload_3
    //   233: athrow
    //   234: astore_3
    //   235: aload_2
    //   236: monitorexit
    //   237: aload_3
    //   238: athrow
    //   239: astore_3
    //   240: aload_2
    //   241: monitorexit
    //   242: aload_3
    //   243: athrow
    // Exception table:
    //   from	to	target	type
    //   8	27	229	finally
    //   31	33	229	finally
    //   82	114	234	finally
    //   158	195	239	finally
    //   201	210	229	finally
    //   215	224	229	finally
    //   230	232	229	finally
    //   235	237	234	finally
    //   240	242	239	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */