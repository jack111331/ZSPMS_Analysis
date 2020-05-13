package com.herosdk.d;

import android.content.Context;
import java.io.InputStream;

public class bh {
  public static String a = "";
  
  private static String a(Context paramContext, String paramString) {
    String str;
    try {
      InputStream inputStream = paramContext.getResources().getAssets().open(paramString);
      byte[] arrayOfByte = new byte[inputStream.available()];
      inputStream.read(arrayOfByte);
      str = new String();
      this(arrayOfByte, "UTF-8");
      try {
        inputStream.close();
      } catch (Exception exception) {}
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  public static void a(Context paramContext) {
    a(a(paramContext, o.f()));
  }
  
  private static void a(String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_3
    //   6: aconst_null
    //   7: astore #4
    //   9: aload_0
    //   10: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   13: ifeq -> 25
    //   16: ldc 'frameLib'
    //   18: ldc 'x c is empty'
    //   20: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   23: pop
    //   24: return
    //   25: invokestatic newPullParser : ()Lorg/xmlpull/v1/XmlPullParser;
    //   28: astore #5
    //   30: aload_0
    //   31: ldc 'resources'
    //   33: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   36: ifeq -> 133
    //   39: new java/io/StringReader
    //   42: astore #6
    //   44: aload #6
    //   46: aload_0
    //   47: invokespecial <init> : (Ljava/lang/String;)V
    //   50: aload #6
    //   52: astore_3
    //   53: aload_1
    //   54: astore_2
    //   55: aload #5
    //   57: aload #6
    //   59: invokeinterface setInput : (Ljava/io/Reader;)V
    //   64: aload #6
    //   66: astore_3
    //   67: aload_1
    //   68: astore_2
    //   69: aload_0
    //   70: putstatic com/herosdk/d/bh.a : Ljava/lang/String;
    //   73: aload #6
    //   75: astore_0
    //   76: aload_0
    //   77: astore_3
    //   78: aload #4
    //   80: astore_2
    //   81: aload #5
    //   83: invokeinterface getEventType : ()I
    //   88: istore #7
    //   90: iload #7
    //   92: iconst_1
    //   93: if_icmpeq -> 551
    //   96: iload #7
    //   98: tableswitch default -> 116, 2 -> 196
    //   116: aload_0
    //   117: astore_3
    //   118: aload #4
    //   120: astore_2
    //   121: aload #5
    //   123: invokeinterface next : ()I
    //   128: istore #7
    //   130: goto -> 90
    //   133: invokestatic gpvk : ()Ljava/lang/String;
    //   136: invokestatic b : (Ljava/lang/String;)Ljava/security/interfaces/RSAPrivateKey;
    //   139: aload_0
    //   140: iconst_2
    //   141: invokestatic decode : (Ljava/lang/String;I)[B
    //   144: invokestatic b : (Ljava/security/interfaces/RSAPrivateKey;[B)[B
    //   147: astore_0
    //   148: new java/lang/String
    //   151: astore #4
    //   153: aload #4
    //   155: aload_0
    //   156: invokespecial <init> : ([B)V
    //   159: aload #4
    //   161: putstatic com/herosdk/d/bh.a : Ljava/lang/String;
    //   164: new java/io/ByteArrayInputStream
    //   167: dup
    //   168: getstatic com/herosdk/d/bh.a : Ljava/lang/String;
    //   171: invokevirtual getBytes : ()[B
    //   174: invokespecial <init> : ([B)V
    //   177: astore_0
    //   178: aload #5
    //   180: aload_0
    //   181: ldc 'UTF-8'
    //   183: invokeinterface setInput : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   188: aload_0
    //   189: astore #4
    //   191: aconst_null
    //   192: astore_0
    //   193: goto -> 76
    //   196: aload_0
    //   197: astore_3
    //   198: aload #4
    //   200: astore_2
    //   201: ldc 'string'
    //   203: aload #5
    //   205: invokeinterface getName : ()Ljava/lang/String;
    //   210: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   213: ifeq -> 263
    //   216: aload_0
    //   217: astore_3
    //   218: aload #4
    //   220: astore_2
    //   221: ldc 'name'
    //   223: aload #5
    //   225: iconst_0
    //   226: invokeinterface getAttributeName : (I)Ljava/lang/String;
    //   231: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   234: ifeq -> 263
    //   237: aload_0
    //   238: astore_3
    //   239: aload #4
    //   241: astore_2
    //   242: invokestatic a : ()Lcom/herosdk/d/k;
    //   245: aload #5
    //   247: iconst_0
    //   248: invokeinterface getAttributeValue : (I)Ljava/lang/String;
    //   253: aload #5
    //   255: invokeinterface nextText : ()Ljava/lang/String;
    //   260: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload_0
    //   264: astore_3
    //   265: aload #4
    //   267: astore_2
    //   268: ldc 'string-array'
    //   270: aload #5
    //   272: invokeinterface getName : ()Ljava/lang/String;
    //   277: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   280: ifeq -> 116
    //   283: aload_0
    //   284: astore_3
    //   285: aload #4
    //   287: astore_2
    //   288: ldc 'name'
    //   290: aload #5
    //   292: iconst_0
    //   293: invokeinterface getAttributeName : (I)Ljava/lang/String;
    //   298: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   301: ifeq -> 116
    //   304: aload_0
    //   305: astore_3
    //   306: aload #4
    //   308: astore_2
    //   309: aload #5
    //   311: iconst_0
    //   312: invokeinterface getAttributeValue : (I)Ljava/lang/String;
    //   317: astore_1
    //   318: aload_0
    //   319: astore_3
    //   320: aload #4
    //   322: astore_2
    //   323: aload_1
    //   324: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   327: ifne -> 116
    //   330: aload_0
    //   331: astore_3
    //   332: aload #4
    //   334: astore_2
    //   335: new java/util/ArrayList
    //   338: astore #6
    //   340: aload_0
    //   341: astore_3
    //   342: aload #4
    //   344: astore_2
    //   345: aload #6
    //   347: invokespecial <init> : ()V
    //   350: aload_0
    //   351: astore_3
    //   352: aload #4
    //   354: astore_2
    //   355: aload #5
    //   357: invokeinterface nextTag : ()I
    //   362: pop
    //   363: aload_0
    //   364: astore_3
    //   365: aload #4
    //   367: astore_2
    //   368: aload #5
    //   370: invokeinterface getEventType : ()I
    //   375: istore #7
    //   377: iload #7
    //   379: iconst_2
    //   380: if_icmpne -> 465
    //   383: aload_0
    //   384: astore_3
    //   385: aload #4
    //   387: astore_2
    //   388: ldc 'item'
    //   390: aload #5
    //   392: invokeinterface getName : ()Ljava/lang/String;
    //   397: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   400: ifeq -> 421
    //   403: aload_0
    //   404: astore_3
    //   405: aload #4
    //   407: astore_2
    //   408: aload #6
    //   410: aload #5
    //   412: invokeinterface nextText : ()Ljava/lang/String;
    //   417: invokevirtual add : (Ljava/lang/Object;)Z
    //   420: pop
    //   421: aload_0
    //   422: astore_3
    //   423: aload #4
    //   425: astore_2
    //   426: aload #5
    //   428: invokeinterface nextTag : ()I
    //   433: pop
    //   434: goto -> 363
    //   437: astore_0
    //   438: aload_3
    //   439: ifnull -> 446
    //   442: aload_3
    //   443: invokevirtual close : ()V
    //   446: aload_2
    //   447: ifnull -> 24
    //   450: aload_2
    //   451: invokevirtual close : ()V
    //   454: goto -> 24
    //   457: astore_0
    //   458: aload_0
    //   459: invokestatic printExceptionInfo : (Ljava/lang/Throwable;)V
    //   462: goto -> 24
    //   465: iload #7
    //   467: iconst_3
    //   468: if_icmpne -> 363
    //   471: aload_0
    //   472: astore_3
    //   473: aload #4
    //   475: astore_2
    //   476: ldc 'string-array'
    //   478: aload #5
    //   480: invokeinterface getName : ()Ljava/lang/String;
    //   485: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   488: ifeq -> 535
    //   491: aload_0
    //   492: astore_3
    //   493: aload #4
    //   495: astore_2
    //   496: invokestatic a : ()Lcom/herosdk/d/k;
    //   499: aload_1
    //   500: aload #6
    //   502: invokevirtual a : (Ljava/lang/String;Ljava/util/List;)V
    //   505: goto -> 116
    //   508: astore #6
    //   510: aload_0
    //   511: astore_3
    //   512: aload #6
    //   514: astore_0
    //   515: aload_3
    //   516: ifnull -> 523
    //   519: aload_3
    //   520: invokevirtual close : ()V
    //   523: aload #4
    //   525: ifnull -> 533
    //   528: aload #4
    //   530: invokevirtual close : ()V
    //   533: aload_0
    //   534: athrow
    //   535: aload_0
    //   536: astore_3
    //   537: aload #4
    //   539: astore_2
    //   540: aload #5
    //   542: invokeinterface nextTag : ()I
    //   547: pop
    //   548: goto -> 363
    //   551: aload_0
    //   552: ifnull -> 559
    //   555: aload_0
    //   556: invokevirtual close : ()V
    //   559: aload #4
    //   561: ifnull -> 24
    //   564: aload #4
    //   566: invokevirtual close : ()V
    //   569: goto -> 24
    //   572: astore_0
    //   573: aload_0
    //   574: invokestatic printExceptionInfo : (Ljava/lang/Throwable;)V
    //   577: goto -> 24
    //   580: astore #4
    //   582: aload #4
    //   584: invokestatic printExceptionInfo : (Ljava/lang/Throwable;)V
    //   587: goto -> 533
    //   590: astore_0
    //   591: aconst_null
    //   592: astore #4
    //   594: goto -> 515
    //   597: astore_0
    //   598: aconst_null
    //   599: astore #4
    //   601: aload #6
    //   603: astore_3
    //   604: goto -> 515
    //   607: astore #6
    //   609: aload_0
    //   610: astore #4
    //   612: aload #6
    //   614: astore_0
    //   615: goto -> 515
    //   618: astore_0
    //   619: aconst_null
    //   620: astore_3
    //   621: goto -> 438
    //   624: astore #4
    //   626: aconst_null
    //   627: astore_3
    //   628: aload_0
    //   629: astore_2
    //   630: goto -> 438
    // Exception table:
    //   from	to	target	type
    //   25	50	618	java/lang/Exception
    //   25	50	590	finally
    //   55	64	437	java/lang/Exception
    //   55	64	597	finally
    //   69	73	437	java/lang/Exception
    //   69	73	597	finally
    //   81	90	437	java/lang/Exception
    //   81	90	508	finally
    //   121	130	437	java/lang/Exception
    //   121	130	508	finally
    //   133	178	618	java/lang/Exception
    //   133	178	590	finally
    //   178	188	624	java/lang/Exception
    //   178	188	607	finally
    //   201	216	437	java/lang/Exception
    //   201	216	508	finally
    //   221	237	437	java/lang/Exception
    //   221	237	508	finally
    //   242	263	437	java/lang/Exception
    //   242	263	508	finally
    //   268	283	437	java/lang/Exception
    //   268	283	508	finally
    //   288	304	437	java/lang/Exception
    //   288	304	508	finally
    //   309	318	437	java/lang/Exception
    //   309	318	508	finally
    //   323	330	437	java/lang/Exception
    //   323	330	508	finally
    //   335	340	437	java/lang/Exception
    //   335	340	508	finally
    //   345	350	437	java/lang/Exception
    //   345	350	508	finally
    //   355	363	437	java/lang/Exception
    //   355	363	508	finally
    //   368	377	437	java/lang/Exception
    //   368	377	508	finally
    //   388	403	437	java/lang/Exception
    //   388	403	508	finally
    //   408	421	437	java/lang/Exception
    //   408	421	508	finally
    //   426	434	437	java/lang/Exception
    //   426	434	508	finally
    //   442	446	457	java/io/IOException
    //   450	454	457	java/io/IOException
    //   476	491	437	java/lang/Exception
    //   476	491	508	finally
    //   496	505	437	java/lang/Exception
    //   496	505	508	finally
    //   519	523	580	java/io/IOException
    //   528	533	580	java/io/IOException
    //   540	548	437	java/lang/Exception
    //   540	548	508	finally
    //   555	559	572	java/io/IOException
    //   564	569	572	java/io/IOException
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */