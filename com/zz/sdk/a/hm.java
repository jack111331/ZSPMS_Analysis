package com.zz.sdk.a;

class hm implements Runnable {
  hm(hl paramhl) {}
  
  public void run() {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Lcom/zz/sdk/a/hl;
    //   4: invokestatic b : (Lcom/zz/sdk/a/hl;)Lcom/zz/sdk/i/t;
    //   7: astore_1
    //   8: getstatic com/zz/sdk/i/v.n : Ljava/lang/String;
    //   11: astore_2
    //   12: invokestatic e : ()Ljava/lang/String;
    //   15: astore_3
    //   16: aload_0
    //   17: getfield a : Lcom/zz/sdk/a/hl;
    //   20: invokestatic a : (Lcom/zz/sdk/a/hl;)Lcom/zz/sdk/i/cq;
    //   23: invokevirtual j : ()Ljava/lang/String;
    //   26: astore #4
    //   28: ldc 'UITN25LMUQC436IM'
    //   30: aload_0
    //   31: getfield a : Lcom/zz/sdk/a/hl;
    //   34: invokestatic a : (Lcom/zz/sdk/a/hl;)Lcom/zz/sdk/i/cq;
    //   37: invokevirtual r : ()Ljava/lang/String;
    //   40: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   43: astore #5
    //   45: aload_0
    //   46: getfield a : Lcom/zz/sdk/a/hl;
    //   49: invokestatic a : (Lcom/zz/sdk/a/hl;)Lcom/zz/sdk/i/cq;
    //   52: invokevirtual t : ()Ljava/lang/String;
    //   55: astore #6
    //   57: invokestatic a : ()Z
    //   60: ifeq -> 241
    //   63: ldc '1'
    //   65: astore #7
    //   67: aload_1
    //   68: aload_2
    //   69: iconst_2
    //   70: bipush #12
    //   72: anewarray java/lang/String
    //   75: dup
    //   76: iconst_0
    //   77: ldc 'appkey'
    //   79: aastore
    //   80: dup
    //   81: iconst_1
    //   82: aload_3
    //   83: aastore
    //   84: dup
    //   85: iconst_2
    //   86: ldc 'username'
    //   88: aastore
    //   89: dup
    //   90: iconst_3
    //   91: aload #4
    //   93: aastore
    //   94: dup
    //   95: iconst_4
    //   96: ldc 'password'
    //   98: aastore
    //   99: dup
    //   100: iconst_5
    //   101: aload #5
    //   103: aastore
    //   104: dup
    //   105: bipush #6
    //   107: ldc 'uid'
    //   109: aastore
    //   110: dup
    //   111: bipush #7
    //   113: aload #6
    //   115: aastore
    //   116: dup
    //   117: bipush #8
    //   119: ldc 'is_public'
    //   121: aastore
    //   122: dup
    //   123: bipush #9
    //   125: aload #7
    //   127: aastore
    //   128: dup
    //   129: bipush #10
    //   131: ldc 'type'
    //   133: aastore
    //   134: dup
    //   135: bipush #11
    //   137: ldc '2'
    //   139: aastore
    //   140: invokevirtual a : (Ljava/lang/String;I[Ljava/lang/String;)Ljava/io/InputStream;
    //   143: astore_2
    //   144: aload_2
    //   145: ifnull -> 548
    //   148: new java/io/File
    //   151: dup
    //   152: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   155: ldc '/DCIM/Camera'
    //   157: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   160: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   163: astore #7
    //   165: sipush #2048
    //   168: newarray byte
    //   170: astore_1
    //   171: aload_0
    //   172: getfield a : Lcom/zz/sdk/a/hl;
    //   175: aload #7
    //   177: aload_0
    //   178: getfield a : Lcom/zz/sdk/a/hl;
    //   181: invokevirtual F : ()Ljava/lang/String;
    //   184: invokestatic a : (Lcom/zz/sdk/a/hl;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   187: astore_3
    //   188: aload_3
    //   189: ifnonnull -> 248
    //   192: invokestatic obtain : ()Landroid/os/Message;
    //   195: astore #7
    //   197: aload #7
    //   199: iconst_1
    //   200: putfield what : I
    //   203: aload_0
    //   204: getfield a : Lcom/zz/sdk/a/hl;
    //   207: invokestatic c : (Lcom/zz/sdk/a/hl;)Landroid/os/Handler;
    //   210: aload #7
    //   212: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   215: pop
    //   216: iconst_0
    //   217: ifeq -> 228
    //   220: new java/lang/NullPointerException
    //   223: dup
    //   224: invokespecial <init> : ()V
    //   227: athrow
    //   228: iconst_0
    //   229: ifeq -> 240
    //   232: new java/lang/NullPointerException
    //   235: dup
    //   236: invokespecial <init> : ()V
    //   239: athrow
    //   240: return
    //   241: ldc '0'
    //   243: astore #7
    //   245: goto -> 67
    //   248: new java/io/FileOutputStream
    //   251: dup
    //   252: aload_3
    //   253: invokespecial <init> : (Ljava/io/File;)V
    //   256: astore #6
    //   258: aload #6
    //   260: astore #7
    //   262: aload_2
    //   263: aload_1
    //   264: invokevirtual read : ([B)I
    //   267: istore #8
    //   269: iload #8
    //   271: iconst_m1
    //   272: if_icmpeq -> 394
    //   275: aload #6
    //   277: astore #7
    //   279: aload #6
    //   281: aload_1
    //   282: iconst_0
    //   283: iload #8
    //   285: invokevirtual write : ([BII)V
    //   288: goto -> 258
    //   291: astore_1
    //   292: aload #6
    //   294: astore #7
    //   296: new java/lang/StringBuilder
    //   299: astore_2
    //   300: aload #6
    //   302: astore #7
    //   304: aload_2
    //   305: invokespecial <init> : ()V
    //   308: aload #6
    //   310: astore #7
    //   312: aload_2
    //   313: ldc 'down failed'
    //   315: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_1
    //   319: invokevirtual toString : ()Ljava/lang/String;
    //   322: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual toString : ()Ljava/lang/String;
    //   328: invokestatic a : (Ljava/lang/Object;)V
    //   331: aload #6
    //   333: astore #7
    //   335: invokestatic obtain : ()Landroid/os/Message;
    //   338: astore_1
    //   339: aload #6
    //   341: astore #7
    //   343: aload_1
    //   344: iconst_1
    //   345: putfield what : I
    //   348: aload #6
    //   350: astore #7
    //   352: aload_0
    //   353: getfield a : Lcom/zz/sdk/a/hl;
    //   356: invokestatic c : (Lcom/zz/sdk/a/hl;)Landroid/os/Handler;
    //   359: aload_1
    //   360: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   363: pop
    //   364: iconst_0
    //   365: ifeq -> 376
    //   368: new java/lang/NullPointerException
    //   371: dup
    //   372: invokespecial <init> : ()V
    //   375: athrow
    //   376: aload #6
    //   378: ifnull -> 240
    //   381: aload #6
    //   383: invokevirtual close : ()V
    //   386: goto -> 240
    //   389: astore #7
    //   391: goto -> 240
    //   394: aload #6
    //   396: astore #7
    //   398: aload #6
    //   400: invokevirtual flush : ()V
    //   403: aload #6
    //   405: astore #7
    //   407: new android/content/ContentValues
    //   410: astore_1
    //   411: aload #6
    //   413: astore #7
    //   415: aload_1
    //   416: invokespecial <init> : ()V
    //   419: aload #6
    //   421: astore #7
    //   423: aload_1
    //   424: ldc '_data'
    //   426: aload_3
    //   427: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   430: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   433: aload #6
    //   435: astore #7
    //   437: aload_0
    //   438: getfield a : Lcom/zz/sdk/a/hl;
    //   441: getfield b : Landroid/app/Activity;
    //   444: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   447: getstatic android/provider/MediaStore$Images$Media.EXTERNAL_CONTENT_URI : Landroid/net/Uri;
    //   450: aload_1
    //   451: invokevirtual insert : (Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   454: pop
    //   455: aload #6
    //   457: astore #7
    //   459: invokestatic obtain : ()Landroid/os/Message;
    //   462: astore_1
    //   463: aload #6
    //   465: astore #7
    //   467: aload_1
    //   468: iconst_0
    //   469: putfield what : I
    //   472: aload #6
    //   474: astore #7
    //   476: aload_0
    //   477: getfield a : Lcom/zz/sdk/a/hl;
    //   480: invokestatic c : (Lcom/zz/sdk/a/hl;)Landroid/os/Handler;
    //   483: aload_1
    //   484: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   487: pop
    //   488: iconst_0
    //   489: ifeq -> 500
    //   492: new java/lang/NullPointerException
    //   495: dup
    //   496: invokespecial <init> : ()V
    //   499: athrow
    //   500: aload #6
    //   502: ifnull -> 240
    //   505: aload #6
    //   507: invokevirtual close : ()V
    //   510: goto -> 240
    //   513: astore #7
    //   515: goto -> 240
    //   518: astore #6
    //   520: aconst_null
    //   521: astore #7
    //   523: iconst_0
    //   524: ifeq -> 535
    //   527: new java/lang/NullPointerException
    //   530: dup
    //   531: invokespecial <init> : ()V
    //   534: athrow
    //   535: aload #7
    //   537: ifnull -> 545
    //   540: aload #7
    //   542: invokevirtual close : ()V
    //   545: aload #6
    //   547: athrow
    //   548: invokestatic obtain : ()Landroid/os/Message;
    //   551: astore #7
    //   553: aload #7
    //   555: iconst_1
    //   556: putfield what : I
    //   559: aload_0
    //   560: getfield a : Lcom/zz/sdk/a/hl;
    //   563: invokestatic c : (Lcom/zz/sdk/a/hl;)Landroid/os/Handler;
    //   566: aload #7
    //   568: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   571: pop
    //   572: goto -> 240
    //   575: astore #7
    //   577: goto -> 228
    //   580: astore #7
    //   582: goto -> 240
    //   585: astore #7
    //   587: goto -> 500
    //   590: astore #7
    //   592: goto -> 376
    //   595: astore_1
    //   596: goto -> 535
    //   599: astore #7
    //   601: goto -> 545
    //   604: astore #6
    //   606: goto -> 523
    //   609: astore_1
    //   610: aconst_null
    //   611: astore #6
    //   613: goto -> 292
    // Exception table:
    //   from	to	target	type
    //   171	188	609	java/io/IOException
    //   171	188	518	finally
    //   192	216	609	java/io/IOException
    //   192	216	518	finally
    //   220	228	575	java/io/IOException
    //   232	240	580	java/io/IOException
    //   248	258	609	java/io/IOException
    //   248	258	518	finally
    //   262	269	291	java/io/IOException
    //   262	269	604	finally
    //   279	288	291	java/io/IOException
    //   279	288	604	finally
    //   296	300	604	finally
    //   304	308	604	finally
    //   312	331	604	finally
    //   335	339	604	finally
    //   343	348	604	finally
    //   352	364	604	finally
    //   368	376	590	java/io/IOException
    //   381	386	389	java/io/IOException
    //   398	403	291	java/io/IOException
    //   398	403	604	finally
    //   407	411	291	java/io/IOException
    //   407	411	604	finally
    //   415	419	291	java/io/IOException
    //   415	419	604	finally
    //   423	433	291	java/io/IOException
    //   423	433	604	finally
    //   437	455	291	java/io/IOException
    //   437	455	604	finally
    //   459	463	291	java/io/IOException
    //   459	463	604	finally
    //   467	472	291	java/io/IOException
    //   467	472	604	finally
    //   476	488	291	java/io/IOException
    //   476	488	604	finally
    //   492	500	585	java/io/IOException
    //   505	510	513	java/io/IOException
    //   527	535	595	java/io/IOException
    //   540	545	599	java/io/IOException
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\hm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */