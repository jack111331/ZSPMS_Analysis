package com.alipay.sdk.app.statistic;

import android.content.Context;

public final class a {
  public static final String a = "alipay_cashier_statistic_record";
  
  private static c b;
  
  public static void a(Context paramContext) {
    if (b == null)
      b = new c(paramContext); 
  }
  
  public static void a(Context paramContext, String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: ldc com/alipay/sdk/app/statistic/a
    //   6: monitorenter
    //   7: getstatic com/alipay/sdk/app/statistic/a.b : Lcom/alipay/sdk/app/statistic/c;
    //   10: astore #4
    //   12: aload #4
    //   14: ifnonnull -> 21
    //   17: ldc com/alipay/sdk/app/statistic/a
    //   19: monitorexit
    //   20: return
    //   21: getstatic com/alipay/sdk/app/statistic/a.b : Lcom/alipay/sdk/app/statistic/c;
    //   24: astore #5
    //   26: aload #5
    //   28: getfield Q : Ljava/lang/String;
    //   31: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   34: ifeq -> 79
    //   37: ldc ''
    //   39: astore_1
    //   40: new java/lang/Thread
    //   43: astore #4
    //   45: new com/alipay/sdk/app/statistic/b
    //   48: astore_3
    //   49: aload_3
    //   50: aload_0
    //   51: aload_1
    //   52: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;)V
    //   55: aload #4
    //   57: aload_3
    //   58: invokespecial <init> : (Ljava/lang/Runnable;)V
    //   61: aload #4
    //   63: invokevirtual start : ()V
    //   66: aconst_null
    //   67: putstatic com/alipay/sdk/app/statistic/a.b : Lcom/alipay/sdk/app/statistic/c;
    //   70: goto -> 17
    //   73: astore_0
    //   74: ldc com/alipay/sdk/app/statistic/a
    //   76: monitorexit
    //   77: aload_0
    //   78: athrow
    //   79: aload_1
    //   80: ldc '&'
    //   82: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   85: astore #6
    //   87: aload #6
    //   89: ifnull -> 253
    //   92: aload #6
    //   94: arraylength
    //   95: istore #7
    //   97: iconst_0
    //   98: istore #8
    //   100: aconst_null
    //   101: astore_1
    //   102: aload_3
    //   103: astore_2
    //   104: aload_1
    //   105: astore #4
    //   107: iload #8
    //   109: iload #7
    //   111: if_icmpge -> 256
    //   114: aload #6
    //   116: iload #8
    //   118: aaload
    //   119: ldc '='
    //   121: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   124: astore #9
    //   126: aload_3
    //   127: astore #4
    //   129: aload_1
    //   130: astore_2
    //   131: aload #9
    //   133: ifnull -> 177
    //   136: aload_3
    //   137: astore #4
    //   139: aload_1
    //   140: astore_2
    //   141: aload #9
    //   143: arraylength
    //   144: iconst_2
    //   145: if_icmpne -> 177
    //   148: aload #9
    //   150: iconst_0
    //   151: aaload
    //   152: ldc 'partner'
    //   154: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   157: ifeq -> 188
    //   160: aload #9
    //   162: iconst_1
    //   163: aaload
    //   164: ldc '"'
    //   166: ldc ''
    //   168: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   171: pop
    //   172: aload_1
    //   173: astore_2
    //   174: aload_3
    //   175: astore #4
    //   177: iinc #8, 1
    //   180: aload #4
    //   182: astore_3
    //   183: aload_2
    //   184: astore_1
    //   185: goto -> 102
    //   188: aload #9
    //   190: iconst_0
    //   191: aaload
    //   192: ldc 'out_trade_no'
    //   194: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   197: ifeq -> 218
    //   200: aload #9
    //   202: iconst_1
    //   203: aaload
    //   204: ldc '"'
    //   206: ldc ''
    //   208: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   211: astore_2
    //   212: aload_3
    //   213: astore #4
    //   215: goto -> 177
    //   218: aload_3
    //   219: astore #4
    //   221: aload_1
    //   222: astore_2
    //   223: aload #9
    //   225: iconst_0
    //   226: aaload
    //   227: ldc 'trade_no'
    //   229: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   232: ifeq -> 177
    //   235: aload #9
    //   237: iconst_1
    //   238: aaload
    //   239: ldc '"'
    //   241: ldc ''
    //   243: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   246: astore #4
    //   248: aload_1
    //   249: astore_2
    //   250: goto -> 177
    //   253: aconst_null
    //   254: astore #4
    //   256: aload_2
    //   257: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   260: astore_1
    //   261: aload #4
    //   263: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   266: astore_3
    //   267: aload #5
    //   269: ldc '%s,%s,-,%s,-,-,-'
    //   271: iconst_3
    //   272: anewarray java/lang/Object
    //   275: dup
    //   276: iconst_0
    //   277: aload_1
    //   278: aastore
    //   279: dup
    //   280: iconst_1
    //   281: aload_3
    //   282: aastore
    //   283: dup
    //   284: iconst_2
    //   285: aload_3
    //   286: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   289: aastore
    //   290: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   293: putfield J : Ljava/lang/String;
    //   296: ldc '[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]'
    //   298: bipush #10
    //   300: anewarray java/lang/Object
    //   303: dup
    //   304: iconst_0
    //   305: aload #5
    //   307: getfield I : Ljava/lang/String;
    //   310: aastore
    //   311: dup
    //   312: iconst_1
    //   313: aload #5
    //   315: getfield J : Ljava/lang/String;
    //   318: aastore
    //   319: dup
    //   320: iconst_2
    //   321: aload #5
    //   323: getfield K : Ljava/lang/String;
    //   326: aastore
    //   327: dup
    //   328: iconst_3
    //   329: aload #5
    //   331: getfield L : Ljava/lang/String;
    //   334: aastore
    //   335: dup
    //   336: iconst_4
    //   337: aload #5
    //   339: getfield M : Ljava/lang/String;
    //   342: aastore
    //   343: dup
    //   344: iconst_5
    //   345: aload #5
    //   347: getfield N : Ljava/lang/String;
    //   350: aastore
    //   351: dup
    //   352: bipush #6
    //   354: aload #5
    //   356: getfield O : Ljava/lang/String;
    //   359: aastore
    //   360: dup
    //   361: bipush #7
    //   363: aload #5
    //   365: getfield P : Ljava/lang/String;
    //   368: aastore
    //   369: dup
    //   370: bipush #8
    //   372: aload #5
    //   374: getfield Q : Ljava/lang/String;
    //   377: aastore
    //   378: dup
    //   379: bipush #9
    //   381: aload #5
    //   383: getfield R : Ljava/lang/String;
    //   386: aastore
    //   387: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   390: astore_1
    //   391: goto -> 40
    // Exception table:
    //   from	to	target	type
    //   7	12	73	finally
    //   21	37	73	finally
    //   40	70	73	finally
    //   79	87	73	finally
    //   92	97	73	finally
    //   114	126	73	finally
    //   141	172	73	finally
    //   188	212	73	finally
    //   223	248	73	finally
    //   256	391	73	finally
  }
  
  public static void a(String paramString1, String paramString2, String paramString3) {
    if (b != null)
      b.a(paramString1, paramString2, paramString3); 
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable) {
    if (b != null)
      b.a(paramString1, paramString2, paramThrowable); 
  }
  
  private static void a(String paramString1, String paramString2, Throwable paramThrowable, String paramString3) {
    if (b != null)
      b.a(paramString1, paramString2, c.a(paramThrowable), paramString3); 
  }
  
  public static void a(String paramString, Throwable paramThrowable) {
    if (b != null && paramThrowable.getClass() != null)
      b.a(paramString, paramThrowable.getClass().getSimpleName(), paramThrowable); 
  }
  
  private static void b(Context paramContext, String paramString) {
    (new Thread(new b(paramContext, paramString))).start();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\app\statistic\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */