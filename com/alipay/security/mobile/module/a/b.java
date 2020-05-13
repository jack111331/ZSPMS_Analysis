package com.alipay.security.mobile.module.a;

public final class b {
  public static String a(String paramString1, String paramString2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial <init> : ()V
    //   11: astore #4
    //   13: new java/io/File
    //   16: astore #5
    //   18: aload #5
    //   20: aload_0
    //   21: aload_1
    //   22: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   25: aload #5
    //   27: invokevirtual exists : ()Z
    //   30: ifne -> 37
    //   33: aload_3
    //   34: astore_0
    //   35: aload_0
    //   36: areturn
    //   37: new java/io/BufferedReader
    //   40: astore_0
    //   41: new java/io/InputStreamReader
    //   44: astore_3
    //   45: new java/io/FileInputStream
    //   48: astore_1
    //   49: aload_1
    //   50: aload #5
    //   52: invokespecial <init> : (Ljava/io/File;)V
    //   55: aload_3
    //   56: aload_1
    //   57: ldc 'UTF-8'
    //   59: invokespecial <init> : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   62: aload_0
    //   63: aload_3
    //   64: invokespecial <init> : (Ljava/io/Reader;)V
    //   67: aload_0
    //   68: invokevirtual readLine : ()Ljava/lang/String;
    //   71: astore_1
    //   72: aload_1
    //   73: ifnull -> 104
    //   76: aload #4
    //   78: aload_1
    //   79: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: goto -> 67
    //   86: astore_1
    //   87: aload_0
    //   88: ifnull -> 95
    //   91: aload_0
    //   92: invokevirtual close : ()V
    //   95: aload #4
    //   97: invokevirtual toString : ()Ljava/lang/String;
    //   100: astore_0
    //   101: goto -> 35
    //   104: aload_0
    //   105: invokevirtual close : ()V
    //   108: goto -> 95
    //   111: astore_0
    //   112: goto -> 95
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_0
    //   118: aload_0
    //   119: ifnull -> 126
    //   122: aload_0
    //   123: invokevirtual close : ()V
    //   126: aload_1
    //   127: athrow
    //   128: astore_0
    //   129: goto -> 95
    //   132: astore_0
    //   133: goto -> 126
    //   136: astore_1
    //   137: goto -> 118
    //   140: astore_0
    //   141: aload_2
    //   142: astore_0
    //   143: goto -> 87
    // Exception table:
    //   from	to	target	type
    //   13	33	140	java/io/IOException
    //   13	33	115	finally
    //   37	67	140	java/io/IOException
    //   37	67	115	finally
    //   67	72	86	java/io/IOException
    //   67	72	136	finally
    //   76	83	86	java/io/IOException
    //   76	83	136	finally
    //   91	95	128	java/lang/Throwable
    //   104	108	111	java/lang/Throwable
    //   122	126	132	java/lang/Throwable
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\security\mobile\module\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */