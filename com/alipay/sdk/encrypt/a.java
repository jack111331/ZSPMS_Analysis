package com.alipay.sdk.encrypt;

public final class a {
  private static final int a = 128;
  
  private static final int b = 64;
  
  private static final int c = 24;
  
  private static final int d = 8;
  
  private static final int e = 16;
  
  private static final int f = 4;
  
  private static final int g = -128;
  
  private static final char h = '=';
  
  private static final byte[] i = new byte[128];
  
  private static final char[] j = new char[64];
  
  static {
    byte b1;
    for (b1 = 0; b1 < ''; b1++)
      i[b1] = (byte)-1; 
    for (b1 = 90; b1 >= 65; b1--)
      i[b1] = (byte)(byte)(b1 - 65); 
    for (b1 = 122; b1 >= 97; b1--)
      i[b1] = (byte)(byte)(b1 - 97 + 26); 
    for (b1 = 57; b1 >= 48; b1--)
      i[b1] = (byte)(byte)(b1 - 48 + 52); 
    i[43] = (byte)62;
    i[47] = (byte)63;
    for (b1 = 0; b1 <= 25; b1++)
      j[b1] = (char)(char)(b1 + 65); 
    byte b2 = 26;
    for (b1 = 0; b2 <= 51; b1++) {
      j[b2] = (char)(char)(b1 + 97);
      b2++;
    } 
    b2 = 52;
    for (b1 = bool; b2 <= 61; b1++) {
      j[b2] = (char)(char)(b1 + 48);
      b2++;
    } 
    j[62] = (char)'+';
    j[63] = (char)'/';
  }
  
  private static int a(char[] paramArrayOfchar) {
    if (paramArrayOfchar == null)
      return 0; 
    int i = paramArrayOfchar.length;
    byte b = 0;
    int j = 0;
    while (true) {
      int k = j;
      if (b < i) {
        k = paramArrayOfchar[b];
        if (k == 32 || k == 13 || k == 10 || k == 9) {
          k = 1;
        } else {
          k = 0;
        } 
        if (k == 0) {
          k = j + 1;
          paramArrayOfchar[j] = (char)paramArrayOfchar[b];
          j = k;
        } 
        b++;
        continue;
      } 
      return k;
    } 
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    int i = 0;
    if (paramArrayOfbyte == null)
      return null; 
    int j = paramArrayOfbyte.length * 8;
    if (j == 0)
      return ""; 
    int k = j % 24;
    int m = j / 24;
    if (k != 0) {
      j = m + 1;
    } else {
      j = m;
    } 
    char[] arrayOfChar = new char[j * 4];
    byte b = 0;
    j = 0;
    while (b < m) {
      byte b4;
      int n = i + 1;
      i = paramArrayOfbyte[i];
      int i1 = n + 1;
      n = paramArrayOfbyte[n];
      byte b1 = paramArrayOfbyte[i1];
      byte b2 = (byte)(n & 0xF);
      byte b3 = (byte)(i & 0x3);
      if ((i & 0xFFFFFF80) == 0) {
        i = (byte)(i >> 2);
      } else {
        i = (byte)(i >> 2 ^ 0xC0);
      } 
      if ((n & 0xFFFFFF80) == 0) {
        n = (byte)(n >> 4);
      } else {
        n = (byte)(n >> 4 ^ 0xF0);
      } 
      if ((b1 & Byte.MIN_VALUE) == 0) {
        b4 = (byte)(b1 >> 6);
      } else {
        b4 = (byte)(b1 >> 6 ^ 0xFC);
      } 
      int i2 = j + 1;
      arrayOfChar[j] = (char)j[i];
      j = i2 + 1;
      arrayOfChar[i2] = (char)j[n | b3 << 4];
      i = j + 1;
      arrayOfChar[j] = (char)j[b4 | b2 << 2];
      arrayOfChar[i] = (char)j[b1 & 0x3F];
      b++;
      j = i + 1;
      i = i1 + 1;
    } 
    if (k == 8) {
      b = paramArrayOfbyte[i];
      i = (byte)(b & 0x3);
      if ((b & 0xFFFFFF80) == 0) {
        b = (byte)(b >> 2);
      } else {
        b = (byte)(b >> 2 ^ 0xC0);
      } 
      int n = j + 1;
      arrayOfChar[j] = (char)j[b];
      j = n + 1;
      arrayOfChar[n] = (char)j[i << 4];
      arrayOfChar[j] = (char)'=';
      arrayOfChar[j + 1] = (char)'=';
    } else if (k == 16) {
      b = paramArrayOfbyte[i];
      i = paramArrayOfbyte[i + 1];
      byte b1 = (byte)(i & 0xF);
      byte b2 = (byte)(b & 0x3);
      if ((b & 0xFFFFFF80) == 0) {
        b = (byte)(b >> 2);
      } else {
        b = (byte)(b >> 2 ^ 0xC0);
      } 
      if ((i & 0xFFFFFF80) == 0) {
        i = (byte)(i >> 4);
      } else {
        i = (byte)(i >> 4 ^ 0xF0);
      } 
      m = j + 1;
      arrayOfChar[j] = (char)j[b];
      j = m + 1;
      arrayOfChar[m] = (char)j[i | b2 << 4];
      arrayOfChar[j] = (char)j[b1 << 2];
      arrayOfChar[j + 1] = (char)'=';
    } 
    return new String(arrayOfChar);
  }
  
  private static boolean a(char paramChar) {
    return (paramChar == ' ' || paramChar == '\r' || paramChar == '\n' || paramChar == '\t');
  }
  
  public static byte[] a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull -> 8
    //   4: aconst_null
    //   5: astore_0
    //   6: aload_0
    //   7: areturn
    //   8: aload_0
    //   9: invokevirtual toCharArray : ()[C
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull -> 30
    //   17: iconst_0
    //   18: istore_2
    //   19: iload_2
    //   20: iconst_4
    //   21: irem
    //   22: ifeq -> 111
    //   25: aconst_null
    //   26: astore_0
    //   27: goto -> 6
    //   30: aload_1
    //   31: arraylength
    //   32: istore_3
    //   33: iconst_0
    //   34: istore #4
    //   36: iconst_0
    //   37: istore #5
    //   39: iload #5
    //   41: istore_2
    //   42: iload #4
    //   44: iload_3
    //   45: if_icmpge -> 19
    //   48: aload_1
    //   49: iload #4
    //   51: caload
    //   52: istore_2
    //   53: iload_2
    //   54: bipush #32
    //   56: if_icmpeq -> 77
    //   59: iload_2
    //   60: bipush #13
    //   62: if_icmpeq -> 77
    //   65: iload_2
    //   66: bipush #10
    //   68: if_icmpeq -> 77
    //   71: iload_2
    //   72: bipush #9
    //   74: if_icmpne -> 106
    //   77: iconst_1
    //   78: istore_2
    //   79: iload_2
    //   80: ifne -> 658
    //   83: iload #5
    //   85: iconst_1
    //   86: iadd
    //   87: istore_2
    //   88: aload_1
    //   89: iload #5
    //   91: aload_1
    //   92: iload #4
    //   94: caload
    //   95: i2c
    //   96: castore
    //   97: iload_2
    //   98: istore #5
    //   100: iinc #4, 1
    //   103: goto -> 39
    //   106: iconst_0
    //   107: istore_2
    //   108: goto -> 79
    //   111: iload_2
    //   112: iconst_4
    //   113: idiv
    //   114: istore_3
    //   115: iload_3
    //   116: ifne -> 126
    //   119: iconst_0
    //   120: newarray byte
    //   122: astore_0
    //   123: goto -> 6
    //   126: iload_3
    //   127: iconst_3
    //   128: imul
    //   129: newarray byte
    //   131: astore_0
    //   132: iconst_0
    //   133: istore_2
    //   134: iconst_0
    //   135: istore #5
    //   137: iconst_0
    //   138: istore #4
    //   140: iload #4
    //   142: iload_3
    //   143: iconst_1
    //   144: isub
    //   145: if_icmpge -> 333
    //   148: iload_2
    //   149: iconst_1
    //   150: iadd
    //   151: istore #6
    //   153: aload_1
    //   154: iload_2
    //   155: caload
    //   156: istore #7
    //   158: iload #7
    //   160: invokestatic c : (C)Z
    //   163: ifeq -> 222
    //   166: iload #6
    //   168: iconst_1
    //   169: iadd
    //   170: istore_2
    //   171: aload_1
    //   172: iload #6
    //   174: caload
    //   175: istore #8
    //   177: iload #8
    //   179: invokestatic c : (C)Z
    //   182: ifeq -> 222
    //   185: iload_2
    //   186: iconst_1
    //   187: iadd
    //   188: istore #6
    //   190: aload_1
    //   191: iload_2
    //   192: caload
    //   193: istore #9
    //   195: iload #9
    //   197: invokestatic c : (C)Z
    //   200: ifeq -> 222
    //   203: iload #6
    //   205: iconst_1
    //   206: iadd
    //   207: istore_2
    //   208: aload_1
    //   209: iload #6
    //   211: caload
    //   212: istore #10
    //   214: iload #10
    //   216: invokestatic c : (C)Z
    //   219: ifne -> 227
    //   222: aconst_null
    //   223: astore_0
    //   224: goto -> 6
    //   227: getstatic com/alipay/sdk/encrypt/a.i : [B
    //   230: iload #7
    //   232: baload
    //   233: istore #11
    //   235: getstatic com/alipay/sdk/encrypt/a.i : [B
    //   238: iload #8
    //   240: baload
    //   241: istore #12
    //   243: getstatic com/alipay/sdk/encrypt/a.i : [B
    //   246: iload #9
    //   248: baload
    //   249: istore #13
    //   251: getstatic com/alipay/sdk/encrypt/a.i : [B
    //   254: iload #10
    //   256: baload
    //   257: istore #6
    //   259: iload #5
    //   261: iconst_1
    //   262: iadd
    //   263: istore #14
    //   265: aload_0
    //   266: iload #5
    //   268: iload #11
    //   270: iconst_2
    //   271: ishl
    //   272: iload #12
    //   274: iconst_4
    //   275: ishr
    //   276: ior
    //   277: i2b
    //   278: i2b
    //   279: bastore
    //   280: iload #14
    //   282: iconst_1
    //   283: iadd
    //   284: istore #11
    //   286: aload_0
    //   287: iload #14
    //   289: iload #12
    //   291: bipush #15
    //   293: iand
    //   294: iconst_4
    //   295: ishl
    //   296: iload #13
    //   298: iconst_2
    //   299: ishr
    //   300: bipush #15
    //   302: iand
    //   303: ior
    //   304: i2b
    //   305: i2b
    //   306: bastore
    //   307: iload #11
    //   309: iconst_1
    //   310: iadd
    //   311: istore #5
    //   313: aload_0
    //   314: iload #11
    //   316: iload #13
    //   318: bipush #6
    //   320: ishl
    //   321: iload #6
    //   323: ior
    //   324: i2b
    //   325: i2b
    //   326: bastore
    //   327: iinc #4, 1
    //   330: goto -> 140
    //   333: iload_2
    //   334: iconst_1
    //   335: iadd
    //   336: istore_3
    //   337: aload_1
    //   338: iload_2
    //   339: caload
    //   340: istore #10
    //   342: iload #10
    //   344: invokestatic c : (C)Z
    //   347: ifeq -> 368
    //   350: iload_3
    //   351: iconst_1
    //   352: iadd
    //   353: istore #6
    //   355: aload_1
    //   356: iload_3
    //   357: caload
    //   358: istore #7
    //   360: iload #7
    //   362: invokestatic c : (C)Z
    //   365: ifne -> 373
    //   368: aconst_null
    //   369: astore_0
    //   370: goto -> 6
    //   373: getstatic com/alipay/sdk/encrypt/a.i : [B
    //   376: iload #10
    //   378: baload
    //   379: istore_2
    //   380: getstatic com/alipay/sdk/encrypt/a.i : [B
    //   383: iload #7
    //   385: baload
    //   386: istore_3
    //   387: aload_1
    //   388: iload #6
    //   390: caload
    //   391: istore #7
    //   393: aload_1
    //   394: iload #6
    //   396: iconst_1
    //   397: iadd
    //   398: caload
    //   399: istore #10
    //   401: iload #7
    //   403: invokestatic c : (C)Z
    //   406: ifeq -> 417
    //   409: iload #10
    //   411: invokestatic c : (C)Z
    //   414: ifne -> 584
    //   417: iload #7
    //   419: invokestatic b : (C)Z
    //   422: ifeq -> 483
    //   425: iload #10
    //   427: invokestatic b : (C)Z
    //   430: ifeq -> 483
    //   433: iload_3
    //   434: bipush #15
    //   436: iand
    //   437: ifeq -> 445
    //   440: aconst_null
    //   441: astore_0
    //   442: goto -> 6
    //   445: iload #4
    //   447: iconst_3
    //   448: imul
    //   449: iconst_1
    //   450: iadd
    //   451: newarray byte
    //   453: astore_1
    //   454: aload_0
    //   455: iconst_0
    //   456: aload_1
    //   457: iconst_0
    //   458: iload #4
    //   460: iconst_3
    //   461: imul
    //   462: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   465: aload_1
    //   466: iload #5
    //   468: iload_2
    //   469: iconst_2
    //   470: ishl
    //   471: iload_3
    //   472: iconst_4
    //   473: ishr
    //   474: ior
    //   475: i2b
    //   476: i2b
    //   477: bastore
    //   478: aload_1
    //   479: astore_0
    //   480: goto -> 6
    //   483: iload #7
    //   485: invokestatic b : (C)Z
    //   488: ifne -> 579
    //   491: iload #10
    //   493: invokestatic b : (C)Z
    //   496: ifeq -> 579
    //   499: getstatic com/alipay/sdk/encrypt/a.i : [B
    //   502: iload #7
    //   504: baload
    //   505: istore #6
    //   507: iload #6
    //   509: iconst_3
    //   510: iand
    //   511: ifeq -> 519
    //   514: aconst_null
    //   515: astore_0
    //   516: goto -> 6
    //   519: iload #4
    //   521: iconst_3
    //   522: imul
    //   523: iconst_2
    //   524: iadd
    //   525: newarray byte
    //   527: astore_1
    //   528: aload_0
    //   529: iconst_0
    //   530: aload_1
    //   531: iconst_0
    //   532: iload #4
    //   534: iconst_3
    //   535: imul
    //   536: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   539: aload_1
    //   540: iload #5
    //   542: iload_2
    //   543: iconst_2
    //   544: ishl
    //   545: iload_3
    //   546: iconst_4
    //   547: ishr
    //   548: ior
    //   549: i2b
    //   550: i2b
    //   551: bastore
    //   552: aload_1
    //   553: iload #5
    //   555: iconst_1
    //   556: iadd
    //   557: iload_3
    //   558: bipush #15
    //   560: iand
    //   561: iconst_4
    //   562: ishl
    //   563: iload #6
    //   565: iconst_2
    //   566: ishr
    //   567: bipush #15
    //   569: iand
    //   570: ior
    //   571: i2b
    //   572: i2b
    //   573: bastore
    //   574: aload_1
    //   575: astore_0
    //   576: goto -> 6
    //   579: aconst_null
    //   580: astore_0
    //   581: goto -> 6
    //   584: getstatic com/alipay/sdk/encrypt/a.i : [B
    //   587: iload #7
    //   589: baload
    //   590: istore #4
    //   592: getstatic com/alipay/sdk/encrypt/a.i : [B
    //   595: iload #10
    //   597: baload
    //   598: istore #6
    //   600: iload #5
    //   602: iconst_1
    //   603: iadd
    //   604: istore #13
    //   606: aload_0
    //   607: iload #5
    //   609: iload_2
    //   610: iconst_2
    //   611: ishl
    //   612: iload_3
    //   613: iconst_4
    //   614: ishr
    //   615: ior
    //   616: i2b
    //   617: i2b
    //   618: bastore
    //   619: aload_0
    //   620: iload #13
    //   622: iload_3
    //   623: bipush #15
    //   625: iand
    //   626: iconst_4
    //   627: ishl
    //   628: iload #4
    //   630: iconst_2
    //   631: ishr
    //   632: bipush #15
    //   634: iand
    //   635: ior
    //   636: i2b
    //   637: i2b
    //   638: bastore
    //   639: aload_0
    //   640: iload #13
    //   642: iconst_1
    //   643: iadd
    //   644: iload #6
    //   646: iload #4
    //   648: bipush #6
    //   650: ishl
    //   651: ior
    //   652: i2b
    //   653: i2b
    //   654: bastore
    //   655: goto -> 6
    //   658: goto -> 100
  }
  
  private static boolean b(char paramChar) {
    return (paramChar == '=');
  }
  
  private static boolean c(char paramChar) {
    return (paramChar < '' && i[paramChar] != -1);
  }
  
  static {
    boolean bool = false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\encrypt\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */