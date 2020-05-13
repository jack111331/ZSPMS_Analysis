package com.herosdk.b;

import java.io.InputStream;

public class ae {
  public static final int a = 10000;
  
  private String b;
  
  private String c;
  
  private am d;
  
  private boolean e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private InputStream i;
  
  private byte[] j;
  
  private ak k;
  
  private ak l;
  
  ae(ah paramah) {
    this.b = paramah.a;
    this.c = paramah.b;
    this.d = paramah.c;
    this.f = paramah.d;
    this.g = paramah.e;
    this.e = paramah.f;
    this.k = paramah.g;
  }
  
  private void b() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_3
    //   6: aconst_null
    //   7: astore #4
    //   9: new java/net/URL
    //   12: astore #5
    //   14: aload #5
    //   16: aload_0
    //   17: getfield b : Ljava/lang/String;
    //   20: invokespecial <init> : (Ljava/lang/String;)V
    //   23: aload #5
    //   25: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   28: checkcast java/net/HttpURLConnection
    //   31: astore #5
    //   33: aload_3
    //   34: astore_1
    //   35: aload #5
    //   37: aload_0
    //   38: getfield f : I
    //   41: invokevirtual setConnectTimeout : (I)V
    //   44: aload_3
    //   45: astore_1
    //   46: aload #5
    //   48: aload_0
    //   49: getfield g : I
    //   52: invokevirtual setReadTimeout : (I)V
    //   55: aload_3
    //   56: astore_1
    //   57: aload_0
    //   58: getfield k : Lcom/herosdk/b/ak;
    //   61: ifnull -> 198
    //   64: aload_3
    //   65: astore_1
    //   66: aload_0
    //   67: getfield k : Lcom/herosdk/b/ak;
    //   70: invokevirtual a : ()Ljava/util/HashMap;
    //   73: ifnull -> 198
    //   76: aload_3
    //   77: astore_1
    //   78: aload_0
    //   79: getfield k : Lcom/herosdk/b/ak;
    //   82: invokevirtual a : ()Ljava/util/HashMap;
    //   85: invokevirtual keySet : ()Ljava/util/Set;
    //   88: invokeinterface iterator : ()Ljava/util/Iterator;
    //   93: astore #4
    //   95: aload_3
    //   96: astore_1
    //   97: aload #4
    //   99: invokeinterface hasNext : ()Z
    //   104: ifeq -> 198
    //   107: aload_3
    //   108: astore_1
    //   109: aload #4
    //   111: invokeinterface next : ()Ljava/lang/Object;
    //   116: checkcast java/lang/String
    //   119: astore #6
    //   121: aload_3
    //   122: astore_1
    //   123: aload #5
    //   125: aload #6
    //   127: aload_0
    //   128: getfield k : Lcom/herosdk/b/ak;
    //   131: aload #6
    //   133: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   136: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   139: goto -> 95
    //   142: astore_3
    //   143: aconst_null
    //   144: astore_1
    //   145: aload #5
    //   147: astore #4
    //   149: aload_3
    //   150: astore #5
    //   152: aload #5
    //   154: invokestatic printExceptionInfo : (Ljava/lang/Throwable;)V
    //   157: aload #5
    //   159: athrow
    //   160: astore_3
    //   161: aload #4
    //   163: astore #5
    //   165: aload_3
    //   166: astore #4
    //   168: aload #5
    //   170: invokevirtual disconnect : ()V
    //   173: aload_1
    //   174: ifnull -> 181
    //   177: aload_1
    //   178: invokevirtual close : ()V
    //   181: aload_0
    //   182: getfield i : Ljava/io/InputStream;
    //   185: ifnull -> 195
    //   188: aload_0
    //   189: getfield i : Ljava/io/InputStream;
    //   192: invokevirtual close : ()V
    //   195: aload #4
    //   197: athrow
    //   198: aload_3
    //   199: astore_1
    //   200: aload_0
    //   201: getfield c : Ljava/lang/String;
    //   204: ldc 'POST'
    //   206: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   209: ifeq -> 548
    //   212: aload_3
    //   213: astore_1
    //   214: aload #5
    //   216: ldc 'POST'
    //   218: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   221: aload_3
    //   222: astore_1
    //   223: aload #5
    //   225: ldc 'Content-Type'
    //   227: ldc 'application/x-www-form-urlencoded'
    //   229: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload_3
    //   233: astore_1
    //   234: aload #5
    //   236: iconst_1
    //   237: invokevirtual setDoInput : (Z)V
    //   240: aload_3
    //   241: astore_1
    //   242: aload #5
    //   244: iconst_1
    //   245: invokevirtual setDoOutput : (Z)V
    //   248: aload_3
    //   249: astore_1
    //   250: aload #5
    //   252: iconst_0
    //   253: invokevirtual setUseCaches : (Z)V
    //   256: aload_2
    //   257: astore #4
    //   259: aload_3
    //   260: astore_1
    //   261: aload_0
    //   262: getfield d : Lcom/herosdk/b/am;
    //   265: ifnull -> 362
    //   268: aload_2
    //   269: astore #4
    //   271: aload_3
    //   272: astore_1
    //   273: aload_0
    //   274: getfield d : Lcom/herosdk/b/am;
    //   277: getfield a : Ljava/util/HashMap;
    //   280: ifnull -> 362
    //   283: aload_2
    //   284: astore #4
    //   286: aload_3
    //   287: astore_1
    //   288: aload_0
    //   289: getfield d : Lcom/herosdk/b/am;
    //   292: getfield a : Ljava/util/HashMap;
    //   295: invokevirtual size : ()I
    //   298: ifle -> 362
    //   301: aload_3
    //   302: astore_1
    //   303: aload_0
    //   304: getfield d : Lcom/herosdk/b/am;
    //   307: invokevirtual toString : ()Ljava/lang/String;
    //   310: ldc 'UTF-8'
    //   312: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   315: astore_2
    //   316: aload_3
    //   317: astore_1
    //   318: aload #5
    //   320: ldc 'Content-Length'
    //   322: aload_2
    //   323: arraylength
    //   324: invokestatic toString : (I)Ljava/lang/String;
    //   327: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   330: aload_3
    //   331: astore_1
    //   332: aload #5
    //   334: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   337: astore #4
    //   339: aload #4
    //   341: astore_1
    //   342: aload #4
    //   344: astore_3
    //   345: aload #4
    //   347: aload_2
    //   348: invokevirtual write : ([B)V
    //   351: aload #4
    //   353: astore_1
    //   354: aload #4
    //   356: astore_3
    //   357: aload #4
    //   359: invokevirtual flush : ()V
    //   362: aload #4
    //   364: astore_1
    //   365: aload #4
    //   367: astore_3
    //   368: aload_0
    //   369: aload #5
    //   371: invokevirtual getResponseCode : ()I
    //   374: putfield h : I
    //   377: aload #4
    //   379: astore_1
    //   380: aload #4
    //   382: astore_3
    //   383: aload_0
    //   384: aload #5
    //   386: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   389: putfield i : Ljava/io/InputStream;
    //   392: aload #4
    //   394: astore_1
    //   395: aload #4
    //   397: astore_3
    //   398: new com/herosdk/b/al
    //   401: astore_2
    //   402: aload #4
    //   404: astore_1
    //   405: aload #4
    //   407: astore_3
    //   408: aload_2
    //   409: invokespecial <init> : ()V
    //   412: aload #4
    //   414: astore_1
    //   415: aload #4
    //   417: astore_3
    //   418: aload_0
    //   419: aload_2
    //   420: aload #5
    //   422: invokevirtual getHeaderFields : ()Ljava/util/Map;
    //   425: invokevirtual a : (Ljava/util/Map;)Lcom/herosdk/b/al;
    //   428: invokevirtual a : ()Lcom/herosdk/b/ak;
    //   431: putfield l : Lcom/herosdk/b/ak;
    //   434: aload #4
    //   436: astore_1
    //   437: aload #4
    //   439: astore_3
    //   440: aload_0
    //   441: getfield i : Ljava/io/InputStream;
    //   444: ifnull -> 501
    //   447: aload #4
    //   449: astore_1
    //   450: aload #4
    //   452: astore_3
    //   453: ldc 'gzip'
    //   455: aload #5
    //   457: invokevirtual getContentEncoding : ()Ljava/lang/String;
    //   460: invokevirtual equals : (Ljava/lang/Object;)Z
    //   463: ifeq -> 501
    //   466: aload #4
    //   468: astore_1
    //   469: aload #4
    //   471: astore_3
    //   472: new java/util/zip/GZIPInputStream
    //   475: astore_2
    //   476: aload #4
    //   478: astore_1
    //   479: aload #4
    //   481: astore_3
    //   482: aload_2
    //   483: aload_0
    //   484: getfield i : Ljava/io/InputStream;
    //   487: invokespecial <init> : (Ljava/io/InputStream;)V
    //   490: aload #4
    //   492: astore_1
    //   493: aload #4
    //   495: astore_3
    //   496: aload_0
    //   497: aload_2
    //   498: putfield i : Ljava/io/InputStream;
    //   501: aload #4
    //   503: astore_1
    //   504: aload #4
    //   506: astore_3
    //   507: aload_0
    //   508: aload_0
    //   509: getfield i : Ljava/io/InputStream;
    //   512: invokestatic b : (Ljava/io/InputStream;)[B
    //   515: putfield j : [B
    //   518: aload #5
    //   520: invokevirtual disconnect : ()V
    //   523: aload #4
    //   525: ifnull -> 533
    //   528: aload #4
    //   530: invokevirtual close : ()V
    //   533: aload_0
    //   534: getfield i : Ljava/io/InputStream;
    //   537: ifnull -> 547
    //   540: aload_0
    //   541: getfield i : Ljava/io/InputStream;
    //   544: invokevirtual close : ()V
    //   547: return
    //   548: aload_3
    //   549: astore_1
    //   550: aload_0
    //   551: getfield c : Ljava/lang/String;
    //   554: ldc 'GET'
    //   556: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   559: ifeq -> 582
    //   562: aload_3
    //   563: astore_1
    //   564: aload #5
    //   566: ldc 'GET'
    //   568: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   571: aload_2
    //   572: astore #4
    //   574: goto -> 362
    //   577: astore #4
    //   579: goto -> 168
    //   582: aload_3
    //   583: astore_1
    //   584: new java/lang/IllegalArgumentException
    //   587: astore_2
    //   588: aload_3
    //   589: astore_1
    //   590: new java/lang/StringBuilder
    //   593: astore #4
    //   595: aload_3
    //   596: astore_1
    //   597: aload #4
    //   599: invokespecial <init> : ()V
    //   602: aload_3
    //   603: astore_1
    //   604: aload_2
    //   605: aload #4
    //   607: ldc 'unsupported http method:'
    //   609: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: aload_0
    //   613: getfield c : Ljava/lang/String;
    //   616: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: invokevirtual toString : ()Ljava/lang/String;
    //   622: invokespecial <init> : (Ljava/lang/String;)V
    //   625: aload_3
    //   626: astore_1
    //   627: aload_2
    //   628: athrow
    //   629: astore_1
    //   630: goto -> 523
    //   633: astore_1
    //   634: goto -> 533
    //   637: astore #5
    //   639: goto -> 173
    //   642: astore_1
    //   643: goto -> 181
    //   646: astore_1
    //   647: goto -> 195
    //   650: astore #4
    //   652: aconst_null
    //   653: astore #5
    //   655: goto -> 168
    //   658: astore #5
    //   660: aconst_null
    //   661: astore_1
    //   662: goto -> 152
    //   665: astore_2
    //   666: aload_3
    //   667: astore_1
    //   668: aload #5
    //   670: astore #4
    //   672: aload_2
    //   673: astore #5
    //   675: goto -> 152
    //   678: astore_1
    //   679: goto -> 547
    // Exception table:
    //   from	to	target	type
    //   9	33	658	java/lang/Exception
    //   9	33	650	finally
    //   35	44	142	java/lang/Exception
    //   35	44	577	finally
    //   46	55	142	java/lang/Exception
    //   46	55	577	finally
    //   57	64	142	java/lang/Exception
    //   57	64	577	finally
    //   66	76	142	java/lang/Exception
    //   66	76	577	finally
    //   78	95	142	java/lang/Exception
    //   78	95	577	finally
    //   97	107	142	java/lang/Exception
    //   97	107	577	finally
    //   109	121	142	java/lang/Exception
    //   109	121	577	finally
    //   123	139	142	java/lang/Exception
    //   123	139	577	finally
    //   152	160	160	finally
    //   168	173	637	java/lang/Exception
    //   177	181	642	java/lang/Exception
    //   181	195	646	java/lang/Exception
    //   200	212	142	java/lang/Exception
    //   200	212	577	finally
    //   214	221	142	java/lang/Exception
    //   214	221	577	finally
    //   223	232	142	java/lang/Exception
    //   223	232	577	finally
    //   234	240	142	java/lang/Exception
    //   234	240	577	finally
    //   242	248	142	java/lang/Exception
    //   242	248	577	finally
    //   250	256	142	java/lang/Exception
    //   250	256	577	finally
    //   261	268	142	java/lang/Exception
    //   261	268	577	finally
    //   273	283	142	java/lang/Exception
    //   273	283	577	finally
    //   288	301	142	java/lang/Exception
    //   288	301	577	finally
    //   303	316	142	java/lang/Exception
    //   303	316	577	finally
    //   318	330	142	java/lang/Exception
    //   318	330	577	finally
    //   332	339	142	java/lang/Exception
    //   332	339	577	finally
    //   345	351	665	java/lang/Exception
    //   345	351	577	finally
    //   357	362	665	java/lang/Exception
    //   357	362	577	finally
    //   368	377	665	java/lang/Exception
    //   368	377	577	finally
    //   383	392	665	java/lang/Exception
    //   383	392	577	finally
    //   398	402	665	java/lang/Exception
    //   398	402	577	finally
    //   408	412	665	java/lang/Exception
    //   408	412	577	finally
    //   418	434	665	java/lang/Exception
    //   418	434	577	finally
    //   440	447	665	java/lang/Exception
    //   440	447	577	finally
    //   453	466	665	java/lang/Exception
    //   453	466	577	finally
    //   472	476	665	java/lang/Exception
    //   472	476	577	finally
    //   482	490	665	java/lang/Exception
    //   482	490	577	finally
    //   496	501	665	java/lang/Exception
    //   496	501	577	finally
    //   507	518	665	java/lang/Exception
    //   507	518	577	finally
    //   518	523	629	java/lang/Exception
    //   528	533	633	java/lang/Exception
    //   533	547	678	java/lang/Exception
    //   550	562	142	java/lang/Exception
    //   550	562	577	finally
    //   564	571	142	java/lang/Exception
    //   564	571	577	finally
    //   584	588	142	java/lang/Exception
    //   584	588	577	finally
    //   590	595	142	java/lang/Exception
    //   590	595	577	finally
    //   597	602	142	java/lang/Exception
    //   597	602	577	finally
    //   604	625	142	java/lang/Exception
    //   604	625	577	finally
    //   627	629	142	java/lang/Exception
    //   627	629	577	finally
  }
  
  private void c() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_3
    //   6: aconst_null
    //   7: astore #4
    //   9: new com/herosdk/b/af
    //   12: astore #5
    //   14: aload #5
    //   16: aload_0
    //   17: invokespecial <init> : (Lcom/herosdk/b/ae;)V
    //   20: ldc_w 'SSL'
    //   23: invokestatic getInstance : (Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   26: astore #6
    //   28: aload #6
    //   30: aconst_null
    //   31: iconst_1
    //   32: anewarray javax/net/ssl/TrustManager
    //   35: dup
    //   36: iconst_0
    //   37: aload #5
    //   39: aastore
    //   40: aconst_null
    //   41: invokevirtual init : ([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   44: new java/net/URL
    //   47: astore #5
    //   49: aload #5
    //   51: aload_0
    //   52: getfield b : Ljava/lang/String;
    //   55: invokespecial <init> : (Ljava/lang/String;)V
    //   58: aload #5
    //   60: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   63: checkcast javax/net/ssl/HttpsURLConnection
    //   66: astore #5
    //   68: aload_3
    //   69: astore_1
    //   70: aload #5
    //   72: aload #6
    //   74: invokevirtual getSocketFactory : ()Ljavax/net/ssl/SSLSocketFactory;
    //   77: invokevirtual setSSLSocketFactory : (Ljavax/net/ssl/SSLSocketFactory;)V
    //   80: aload_3
    //   81: astore_1
    //   82: aload #5
    //   84: getstatic org/apache/http/conn/ssl/SSLSocketFactory.STRICT_HOSTNAME_VERIFIER : Lorg/apache/http/conn/ssl/X509HostnameVerifier;
    //   87: invokevirtual setHostnameVerifier : (Ljavax/net/ssl/HostnameVerifier;)V
    //   90: aload_3
    //   91: astore_1
    //   92: new com/herosdk/b/ag
    //   95: astore #4
    //   97: aload_3
    //   98: astore_1
    //   99: aload #4
    //   101: aload_0
    //   102: invokespecial <init> : (Lcom/herosdk/b/ae;)V
    //   105: aload_3
    //   106: astore_1
    //   107: aload #5
    //   109: aload #4
    //   111: invokevirtual setHostnameVerifier : (Ljavax/net/ssl/HostnameVerifier;)V
    //   114: aload_3
    //   115: astore_1
    //   116: aload #5
    //   118: aload_0
    //   119: getfield f : I
    //   122: invokevirtual setConnectTimeout : (I)V
    //   125: aload_3
    //   126: astore_1
    //   127: aload #5
    //   129: aload_0
    //   130: getfield g : I
    //   133: invokevirtual setReadTimeout : (I)V
    //   136: aload_3
    //   137: astore_1
    //   138: aload_0
    //   139: getfield k : Lcom/herosdk/b/ak;
    //   142: ifnull -> 279
    //   145: aload_3
    //   146: astore_1
    //   147: aload_0
    //   148: getfield k : Lcom/herosdk/b/ak;
    //   151: invokevirtual a : ()Ljava/util/HashMap;
    //   154: ifnull -> 279
    //   157: aload_3
    //   158: astore_1
    //   159: aload_0
    //   160: getfield k : Lcom/herosdk/b/ak;
    //   163: invokevirtual a : ()Ljava/util/HashMap;
    //   166: invokevirtual keySet : ()Ljava/util/Set;
    //   169: invokeinterface iterator : ()Ljava/util/Iterator;
    //   174: astore #4
    //   176: aload_3
    //   177: astore_1
    //   178: aload #4
    //   180: invokeinterface hasNext : ()Z
    //   185: ifeq -> 279
    //   188: aload_3
    //   189: astore_1
    //   190: aload #4
    //   192: invokeinterface next : ()Ljava/lang/Object;
    //   197: checkcast java/lang/String
    //   200: astore #6
    //   202: aload_3
    //   203: astore_1
    //   204: aload #5
    //   206: aload #6
    //   208: aload_0
    //   209: getfield k : Lcom/herosdk/b/ak;
    //   212: aload #6
    //   214: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   217: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   220: goto -> 176
    //   223: astore_3
    //   224: aconst_null
    //   225: astore_1
    //   226: aload #5
    //   228: astore #4
    //   230: aload_3
    //   231: astore #5
    //   233: aload #5
    //   235: invokestatic printExceptionInfo : (Ljava/lang/Throwable;)V
    //   238: aload #5
    //   240: athrow
    //   241: astore_3
    //   242: aload #4
    //   244: astore #5
    //   246: aload_3
    //   247: astore #4
    //   249: aload #5
    //   251: invokevirtual disconnect : ()V
    //   254: aload_1
    //   255: ifnull -> 262
    //   258: aload_1
    //   259: invokevirtual close : ()V
    //   262: aload_0
    //   263: getfield i : Ljava/io/InputStream;
    //   266: ifnull -> 276
    //   269: aload_0
    //   270: getfield i : Ljava/io/InputStream;
    //   273: invokevirtual close : ()V
    //   276: aload #4
    //   278: athrow
    //   279: aload_3
    //   280: astore_1
    //   281: aload_0
    //   282: getfield c : Ljava/lang/String;
    //   285: ldc 'POST'
    //   287: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   290: ifeq -> 602
    //   293: aload_3
    //   294: astore_1
    //   295: aload #5
    //   297: ldc 'POST'
    //   299: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   302: aload_3
    //   303: astore_1
    //   304: aload #5
    //   306: ldc 'Content-Type'
    //   308: ldc 'application/x-www-form-urlencoded'
    //   310: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   313: aload_3
    //   314: astore_1
    //   315: aload #5
    //   317: iconst_1
    //   318: invokevirtual setDoInput : (Z)V
    //   321: aload_3
    //   322: astore_1
    //   323: aload #5
    //   325: iconst_1
    //   326: invokevirtual setDoOutput : (Z)V
    //   329: aload_3
    //   330: astore_1
    //   331: aload #5
    //   333: iconst_0
    //   334: invokevirtual setUseCaches : (Z)V
    //   337: aload_2
    //   338: astore #4
    //   340: aload_3
    //   341: astore_1
    //   342: aload_0
    //   343: getfield d : Lcom/herosdk/b/am;
    //   346: getfield a : Ljava/util/HashMap;
    //   349: invokevirtual size : ()I
    //   352: ifle -> 416
    //   355: aload_3
    //   356: astore_1
    //   357: aload_0
    //   358: getfield d : Lcom/herosdk/b/am;
    //   361: invokevirtual toString : ()Ljava/lang/String;
    //   364: ldc 'UTF-8'
    //   366: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   369: astore_2
    //   370: aload_3
    //   371: astore_1
    //   372: aload #5
    //   374: ldc 'Content-Length'
    //   376: aload_2
    //   377: arraylength
    //   378: invokestatic toString : (I)Ljava/lang/String;
    //   381: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   384: aload_3
    //   385: astore_1
    //   386: aload #5
    //   388: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   391: astore #4
    //   393: aload #4
    //   395: astore_1
    //   396: aload #4
    //   398: astore_3
    //   399: aload #4
    //   401: aload_2
    //   402: invokevirtual write : ([B)V
    //   405: aload #4
    //   407: astore_1
    //   408: aload #4
    //   410: astore_3
    //   411: aload #4
    //   413: invokevirtual flush : ()V
    //   416: aload #4
    //   418: astore_1
    //   419: aload #4
    //   421: astore_3
    //   422: aload_0
    //   423: aload #5
    //   425: invokevirtual getResponseCode : ()I
    //   428: putfield h : I
    //   431: aload #4
    //   433: astore_1
    //   434: aload #4
    //   436: astore_3
    //   437: aload_0
    //   438: aload #5
    //   440: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   443: putfield i : Ljava/io/InputStream;
    //   446: aload #4
    //   448: astore_1
    //   449: aload #4
    //   451: astore_3
    //   452: new com/herosdk/b/al
    //   455: astore_2
    //   456: aload #4
    //   458: astore_1
    //   459: aload #4
    //   461: astore_3
    //   462: aload_2
    //   463: invokespecial <init> : ()V
    //   466: aload #4
    //   468: astore_1
    //   469: aload #4
    //   471: astore_3
    //   472: aload_0
    //   473: aload_2
    //   474: aload #5
    //   476: invokevirtual getHeaderFields : ()Ljava/util/Map;
    //   479: invokevirtual a : (Ljava/util/Map;)Lcom/herosdk/b/al;
    //   482: invokevirtual a : ()Lcom/herosdk/b/ak;
    //   485: putfield l : Lcom/herosdk/b/ak;
    //   488: aload #4
    //   490: astore_1
    //   491: aload #4
    //   493: astore_3
    //   494: aload_0
    //   495: getfield i : Ljava/io/InputStream;
    //   498: ifnull -> 555
    //   501: aload #4
    //   503: astore_1
    //   504: aload #4
    //   506: astore_3
    //   507: ldc 'gzip'
    //   509: aload #5
    //   511: invokevirtual getContentEncoding : ()Ljava/lang/String;
    //   514: invokevirtual equals : (Ljava/lang/Object;)Z
    //   517: ifeq -> 555
    //   520: aload #4
    //   522: astore_1
    //   523: aload #4
    //   525: astore_3
    //   526: new java/util/zip/GZIPInputStream
    //   529: astore_2
    //   530: aload #4
    //   532: astore_1
    //   533: aload #4
    //   535: astore_3
    //   536: aload_2
    //   537: aload_0
    //   538: getfield i : Ljava/io/InputStream;
    //   541: invokespecial <init> : (Ljava/io/InputStream;)V
    //   544: aload #4
    //   546: astore_1
    //   547: aload #4
    //   549: astore_3
    //   550: aload_0
    //   551: aload_2
    //   552: putfield i : Ljava/io/InputStream;
    //   555: aload #4
    //   557: astore_1
    //   558: aload #4
    //   560: astore_3
    //   561: aload_0
    //   562: aload_0
    //   563: getfield i : Ljava/io/InputStream;
    //   566: invokestatic b : (Ljava/io/InputStream;)[B
    //   569: putfield j : [B
    //   572: aload #5
    //   574: invokevirtual disconnect : ()V
    //   577: aload #4
    //   579: ifnull -> 587
    //   582: aload #4
    //   584: invokevirtual close : ()V
    //   587: aload_0
    //   588: getfield i : Ljava/io/InputStream;
    //   591: ifnull -> 601
    //   594: aload_0
    //   595: getfield i : Ljava/io/InputStream;
    //   598: invokevirtual close : ()V
    //   601: return
    //   602: aload_3
    //   603: astore_1
    //   604: aload_0
    //   605: getfield c : Ljava/lang/String;
    //   608: ldc 'GET'
    //   610: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   613: ifeq -> 636
    //   616: aload_3
    //   617: astore_1
    //   618: aload #5
    //   620: ldc 'GET'
    //   622: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   625: aload_2
    //   626: astore #4
    //   628: goto -> 416
    //   631: astore #4
    //   633: goto -> 249
    //   636: aload_3
    //   637: astore_1
    //   638: new java/lang/IllegalArgumentException
    //   641: astore_2
    //   642: aload_3
    //   643: astore_1
    //   644: new java/lang/StringBuilder
    //   647: astore #4
    //   649: aload_3
    //   650: astore_1
    //   651: aload #4
    //   653: invokespecial <init> : ()V
    //   656: aload_3
    //   657: astore_1
    //   658: aload_2
    //   659: aload #4
    //   661: ldc 'unsupported http method:'
    //   663: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload_0
    //   667: getfield c : Ljava/lang/String;
    //   670: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: invokevirtual toString : ()Ljava/lang/String;
    //   676: invokespecial <init> : (Ljava/lang/String;)V
    //   679: aload_3
    //   680: astore_1
    //   681: aload_2
    //   682: athrow
    //   683: astore_1
    //   684: goto -> 577
    //   687: astore_1
    //   688: goto -> 587
    //   691: astore #5
    //   693: goto -> 254
    //   696: astore_1
    //   697: goto -> 262
    //   700: astore_1
    //   701: goto -> 276
    //   704: astore #4
    //   706: aconst_null
    //   707: astore #5
    //   709: goto -> 249
    //   712: astore #5
    //   714: aconst_null
    //   715: astore_1
    //   716: goto -> 233
    //   719: astore_2
    //   720: aload_3
    //   721: astore_1
    //   722: aload #5
    //   724: astore #4
    //   726: aload_2
    //   727: astore #5
    //   729: goto -> 233
    //   732: astore_1
    //   733: goto -> 601
    // Exception table:
    //   from	to	target	type
    //   9	68	712	java/lang/Exception
    //   9	68	704	finally
    //   70	80	223	java/lang/Exception
    //   70	80	631	finally
    //   82	90	223	java/lang/Exception
    //   82	90	631	finally
    //   92	97	223	java/lang/Exception
    //   92	97	631	finally
    //   99	105	223	java/lang/Exception
    //   99	105	631	finally
    //   107	114	223	java/lang/Exception
    //   107	114	631	finally
    //   116	125	223	java/lang/Exception
    //   116	125	631	finally
    //   127	136	223	java/lang/Exception
    //   127	136	631	finally
    //   138	145	223	java/lang/Exception
    //   138	145	631	finally
    //   147	157	223	java/lang/Exception
    //   147	157	631	finally
    //   159	176	223	java/lang/Exception
    //   159	176	631	finally
    //   178	188	223	java/lang/Exception
    //   178	188	631	finally
    //   190	202	223	java/lang/Exception
    //   190	202	631	finally
    //   204	220	223	java/lang/Exception
    //   204	220	631	finally
    //   233	241	241	finally
    //   249	254	691	java/lang/Exception
    //   258	262	696	java/lang/Exception
    //   262	276	700	java/lang/Exception
    //   281	293	223	java/lang/Exception
    //   281	293	631	finally
    //   295	302	223	java/lang/Exception
    //   295	302	631	finally
    //   304	313	223	java/lang/Exception
    //   304	313	631	finally
    //   315	321	223	java/lang/Exception
    //   315	321	631	finally
    //   323	329	223	java/lang/Exception
    //   323	329	631	finally
    //   331	337	223	java/lang/Exception
    //   331	337	631	finally
    //   342	355	223	java/lang/Exception
    //   342	355	631	finally
    //   357	370	223	java/lang/Exception
    //   357	370	631	finally
    //   372	384	223	java/lang/Exception
    //   372	384	631	finally
    //   386	393	223	java/lang/Exception
    //   386	393	631	finally
    //   399	405	719	java/lang/Exception
    //   399	405	631	finally
    //   411	416	719	java/lang/Exception
    //   411	416	631	finally
    //   422	431	719	java/lang/Exception
    //   422	431	631	finally
    //   437	446	719	java/lang/Exception
    //   437	446	631	finally
    //   452	456	719	java/lang/Exception
    //   452	456	631	finally
    //   462	466	719	java/lang/Exception
    //   462	466	631	finally
    //   472	488	719	java/lang/Exception
    //   472	488	631	finally
    //   494	501	719	java/lang/Exception
    //   494	501	631	finally
    //   507	520	719	java/lang/Exception
    //   507	520	631	finally
    //   526	530	719	java/lang/Exception
    //   526	530	631	finally
    //   536	544	719	java/lang/Exception
    //   536	544	631	finally
    //   550	555	719	java/lang/Exception
    //   550	555	631	finally
    //   561	572	719	java/lang/Exception
    //   561	572	631	finally
    //   572	577	683	java/lang/Exception
    //   582	587	687	java/lang/Exception
    //   587	601	732	java/lang/Exception
    //   604	616	223	java/lang/Exception
    //   604	616	631	finally
    //   618	625	223	java/lang/Exception
    //   618	625	631	finally
    //   638	642	223	java/lang/Exception
    //   638	642	631	finally
    //   644	649	223	java/lang/Exception
    //   644	649	631	finally
    //   651	656	223	java/lang/Exception
    //   651	656	631	finally
    //   658	679	223	java/lang/Exception
    //   658	679	631	finally
    //   681	683	223	java/lang/Exception
    //   681	683	631	finally
  }
  
  public ar a() {
    if (this.e == true) {
      c();
      return (new as()).a(this.h).a(this.j).a(this.l).a();
    } 
    b();
    return (new as()).a(this.h).a(this.j).a(this.l).a();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */