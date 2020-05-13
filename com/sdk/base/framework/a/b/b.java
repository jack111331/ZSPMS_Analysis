package com.sdk.base.framework.a.b;

import java.io.File;
import java.net.HttpURLConnection;

public class b {
  public File a(HttpURLConnection paramHttpURLConnection, c paramc, String paramString1, boolean paramBoolean, String paramString2) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 11
    //   4: aload_3
    //   5: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   8: ifeq -> 15
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_1
    //   14: areturn
    //   15: new java/io/File
    //   18: dup
    //   19: aload_3
    //   20: invokespecial <init> : (Ljava/lang/String;)V
    //   23: astore #6
    //   25: aload #6
    //   27: invokevirtual exists : ()Z
    //   30: ifne -> 62
    //   33: aload #6
    //   35: invokevirtual getParentFile : ()Ljava/io/File;
    //   38: astore #7
    //   40: aload #7
    //   42: invokevirtual exists : ()Z
    //   45: ifne -> 56
    //   48: aload #7
    //   50: invokevirtual mkdirs : ()Z
    //   53: ifeq -> 62
    //   56: aload #6
    //   58: invokevirtual createNewFile : ()Z
    //   61: pop
    //   62: lconst_0
    //   63: lstore #8
    //   65: aconst_null
    //   66: astore #7
    //   68: aconst_null
    //   69: astore #10
    //   71: aconst_null
    //   72: astore #11
    //   74: iload #4
    //   76: ifeq -> 188
    //   79: aload #6
    //   81: invokevirtual length : ()J
    //   84: lstore #8
    //   86: new java/io/FileOutputStream
    //   89: astore #12
    //   91: aload #12
    //   93: aload_3
    //   94: iconst_1
    //   95: invokespecial <init> : (Ljava/lang/String;Z)V
    //   98: aload_1
    //   99: invokevirtual getContentLength : ()I
    //   102: i2l
    //   103: lload #8
    //   105: ladd
    //   106: lstore #13
    //   108: new java/io/BufferedInputStream
    //   111: astore_3
    //   112: aload_3
    //   113: aload_1
    //   114: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   117: invokespecial <init> : (Ljava/io/InputStream;)V
    //   120: new java/io/BufferedOutputStream
    //   123: astore #7
    //   125: aload #7
    //   127: aload #12
    //   129: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   132: aload_2
    //   133: ifnull -> 308
    //   136: aload_2
    //   137: lload #13
    //   139: lload #8
    //   141: iconst_1
    //   142: invokeinterface a : (JJZ)Z
    //   147: istore #4
    //   149: iload #4
    //   151: ifne -> 308
    //   154: aload_3
    //   155: ifnull -> 162
    //   158: aload_3
    //   159: invokevirtual close : ()V
    //   162: aload #6
    //   164: astore_1
    //   165: aload #7
    //   167: ifnull -> 13
    //   170: aload #7
    //   172: invokevirtual close : ()V
    //   175: aload #6
    //   177: astore_1
    //   178: goto -> 13
    //   181: astore_1
    //   182: aload #6
    //   184: astore_1
    //   185: goto -> 13
    //   188: new java/io/FileOutputStream
    //   191: dup
    //   192: aload_3
    //   193: invokespecial <init> : (Ljava/lang/String;)V
    //   196: astore #12
    //   198: goto -> 98
    //   201: astore_3
    //   202: aconst_null
    //   203: astore_1
    //   204: aload #11
    //   206: astore_2
    //   207: aload_3
    //   208: invokevirtual printStackTrace : ()V
    //   211: aload_1
    //   212: ifnull -> 219
    //   215: aload_1
    //   216: invokevirtual close : ()V
    //   219: aload_2
    //   220: ifnull -> 227
    //   223: aload_2
    //   224: invokevirtual close : ()V
    //   227: aload #6
    //   229: astore_1
    //   230: aload #6
    //   232: invokevirtual exists : ()Z
    //   235: ifeq -> 13
    //   238: aload #6
    //   240: astore_1
    //   241: aload #5
    //   243: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   246: ifne -> 13
    //   249: new java/io/File
    //   252: dup
    //   253: aload #6
    //   255: invokevirtual getParent : ()Ljava/lang/String;
    //   258: aload #5
    //   260: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   263: astore_1
    //   264: aload_1
    //   265: invokevirtual exists : ()Z
    //   268: ifeq -> 479
    //   271: new java/io/File
    //   274: dup
    //   275: aload #6
    //   277: invokevirtual getParent : ()Ljava/lang/String;
    //   280: new java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial <init> : ()V
    //   287: invokestatic currentTimeMillis : ()J
    //   290: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   293: aload #5
    //   295: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual toString : ()Ljava/lang/String;
    //   301: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   304: astore_1
    //   305: goto -> 264
    //   308: sipush #4096
    //   311: newarray byte
    //   313: astore_1
    //   314: aload_3
    //   315: aload_1
    //   316: invokevirtual read : ([B)I
    //   319: istore #15
    //   321: iload #15
    //   323: iconst_m1
    //   324: if_icmpeq -> 408
    //   327: aload #7
    //   329: aload_1
    //   330: iconst_0
    //   331: iload #15
    //   333: invokevirtual write : ([BII)V
    //   336: lload #8
    //   338: iload #15
    //   340: i2l
    //   341: ladd
    //   342: lstore #16
    //   344: lload #16
    //   346: lstore #8
    //   348: aload_2
    //   349: ifnull -> 314
    //   352: aload_2
    //   353: lload #13
    //   355: lload #16
    //   357: iconst_0
    //   358: invokeinterface a : (JJZ)Z
    //   363: istore #4
    //   365: lload #16
    //   367: lstore #8
    //   369: iload #4
    //   371: ifne -> 314
    //   374: aload_3
    //   375: ifnull -> 382
    //   378: aload_3
    //   379: invokevirtual close : ()V
    //   382: aload #6
    //   384: astore_1
    //   385: aload #7
    //   387: ifnull -> 13
    //   390: aload #7
    //   392: invokevirtual close : ()V
    //   395: aload #6
    //   397: astore_1
    //   398: goto -> 13
    //   401: astore_1
    //   402: aload #6
    //   404: astore_1
    //   405: goto -> 13
    //   408: aload #7
    //   410: invokevirtual flush : ()V
    //   413: aload_2
    //   414: ifnull -> 429
    //   417: aload_2
    //   418: lload #13
    //   420: lload #8
    //   422: iconst_1
    //   423: invokeinterface a : (JJZ)Z
    //   428: pop
    //   429: aload_3
    //   430: ifnull -> 437
    //   433: aload_3
    //   434: invokevirtual close : ()V
    //   437: aload #7
    //   439: ifnull -> 227
    //   442: aload #7
    //   444: invokevirtual close : ()V
    //   447: goto -> 227
    //   450: astore_1
    //   451: goto -> 227
    //   454: astore_1
    //   455: aload #7
    //   457: astore_2
    //   458: aload #10
    //   460: astore_3
    //   461: aload_2
    //   462: ifnull -> 469
    //   465: aload_2
    //   466: invokevirtual close : ()V
    //   469: aload_3
    //   470: ifnull -> 477
    //   473: aload_3
    //   474: invokevirtual close : ()V
    //   477: aload_1
    //   478: athrow
    //   479: aload #6
    //   481: aload_1
    //   482: invokevirtual renameTo : (Ljava/io/File;)Z
    //   485: ifeq -> 491
    //   488: goto -> 13
    //   491: aload #6
    //   493: astore_1
    //   494: goto -> 488
    //   497: astore_1
    //   498: goto -> 162
    //   501: astore_1
    //   502: goto -> 382
    //   505: astore_1
    //   506: goto -> 437
    //   509: astore_1
    //   510: goto -> 219
    //   513: astore_1
    //   514: goto -> 227
    //   517: astore_2
    //   518: goto -> 469
    //   521: astore_2
    //   522: goto -> 477
    //   525: astore_1
    //   526: aload_3
    //   527: astore_2
    //   528: aload #10
    //   530: astore_3
    //   531: goto -> 461
    //   534: astore_1
    //   535: aload_3
    //   536: astore_2
    //   537: aload #7
    //   539: astore_3
    //   540: goto -> 461
    //   543: astore_3
    //   544: aload_1
    //   545: astore #5
    //   547: aload_3
    //   548: astore_1
    //   549: aload_2
    //   550: astore_3
    //   551: aload #5
    //   553: astore_2
    //   554: goto -> 461
    //   557: astore_2
    //   558: aload_3
    //   559: astore_1
    //   560: aload_2
    //   561: astore_3
    //   562: aload #11
    //   564: astore_2
    //   565: goto -> 207
    //   568: astore #12
    //   570: aload #7
    //   572: astore_2
    //   573: aload_3
    //   574: astore_1
    //   575: aload #12
    //   577: astore_3
    //   578: goto -> 207
    // Exception table:
    //   from	to	target	type
    //   79	98	201	java/lang/Throwable
    //   79	98	454	finally
    //   98	120	201	java/lang/Throwable
    //   98	120	454	finally
    //   120	132	557	java/lang/Throwable
    //   120	132	525	finally
    //   136	149	568	java/lang/Throwable
    //   136	149	534	finally
    //   158	162	497	java/lang/Throwable
    //   170	175	181	java/lang/Throwable
    //   188	198	201	java/lang/Throwable
    //   188	198	454	finally
    //   207	211	543	finally
    //   215	219	509	java/lang/Throwable
    //   223	227	513	java/lang/Throwable
    //   308	314	568	java/lang/Throwable
    //   308	314	534	finally
    //   314	321	568	java/lang/Throwable
    //   314	321	534	finally
    //   327	336	568	java/lang/Throwable
    //   327	336	534	finally
    //   352	365	568	java/lang/Throwable
    //   352	365	534	finally
    //   378	382	501	java/lang/Throwable
    //   390	395	401	java/lang/Throwable
    //   408	413	568	java/lang/Throwable
    //   408	413	534	finally
    //   417	429	568	java/lang/Throwable
    //   417	429	534	finally
    //   433	437	505	java/lang/Throwable
    //   442	447	450	java/lang/Throwable
    //   465	469	517	java/lang/Throwable
    //   473	477	521	java/lang/Throwable
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */