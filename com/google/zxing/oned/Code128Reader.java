package com.google.zxing.oned;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.Map;

public final class Code128Reader extends OneDReader {
  private static final int CODE_CODE_A = 101;
  
  private static final int CODE_CODE_B = 100;
  
  private static final int CODE_CODE_C = 99;
  
  private static final int CODE_FNC_1 = 102;
  
  private static final int CODE_FNC_2 = 97;
  
  private static final int CODE_FNC_3 = 96;
  
  private static final int CODE_FNC_4_A = 101;
  
  private static final int CODE_FNC_4_B = 100;
  
  static final int[][] CODE_PATTERNS;
  
  private static final int CODE_SHIFT = 98;
  
  private static final int CODE_START_A = 103;
  
  private static final int CODE_START_B = 104;
  
  private static final int CODE_START_C = 105;
  
  private static final int CODE_STOP = 106;
  
  private static final float MAX_AVG_VARIANCE = 0.25F;
  
  private static final float MAX_INDIVIDUAL_VARIANCE = 0.7F;
  
  static {
    int[] arrayOfInt1 = { 2, 1, 2, 2, 2, 2 };
    int[] arrayOfInt2 = { 1, 2, 1, 3, 2, 2 };
    int[] arrayOfInt3 = { 1, 2, 2, 3, 1, 2 };
    int[] arrayOfInt4 = { 2, 2, 1, 2, 1, 3 };
    int[] arrayOfInt5 = { 2, 2, 1, 3, 1, 2 };
    int[] arrayOfInt6 = { 1, 1, 2, 2, 3, 2 };
    int[] arrayOfInt7 = { 1, 2, 2, 2, 3, 1 };
    int[] arrayOfInt8 = { 1, 2, 3, 2, 2, 1 };
    int[] arrayOfInt9 = { 2, 2, 3, 2, 1, 1 };
    int[] arrayOfInt10 = { 2, 2, 1, 1, 3, 2 };
    int[] arrayOfInt11 = { 2, 1, 3, 2, 1, 2 };
    int[] arrayOfInt12 = { 3, 1, 2, 1, 3, 1 };
    int[] arrayOfInt13 = { 3, 2, 1, 1, 2, 2 };
    int[] arrayOfInt14 = { 1, 1, 1, 3, 2, 3 };
    int[] arrayOfInt15 = { 2, 3, 1, 1, 1, 3 };
    int[] arrayOfInt16 = { 2, 3, 1, 3, 1, 1 };
    int[] arrayOfInt17 = { 1, 3, 2, 1, 3, 1 };
    int[] arrayOfInt18 = { 1, 1, 3, 3, 2, 1 };
    int[] arrayOfInt19 = { 1, 3, 3, 1, 2, 1 };
    int[] arrayOfInt20 = { 3, 1, 3, 1, 2, 1 };
    int[] arrayOfInt21 = { 2, 1, 1, 3, 3, 1 };
    int[] arrayOfInt22 = { 2, 3, 1, 1, 3, 1 };
    int[] arrayOfInt23 = { 2, 1, 3, 3, 1, 1 };
    int[] arrayOfInt24 = { 2, 1, 3, 1, 3, 1 };
    int[] arrayOfInt25 = { 3, 1, 4, 1, 1, 1 };
    int[] arrayOfInt26 = { 4, 3, 1, 1, 1, 1 };
    int[] arrayOfInt27 = { 1, 1, 2, 2, 1, 4 };
    int[] arrayOfInt28 = { 1, 2, 2, 1, 1, 4 };
    int[] arrayOfInt29 = { 2, 4, 1, 2, 1, 1 };
    int[] arrayOfInt30 = { 2, 4, 1, 1, 1, 2 };
    int[] arrayOfInt31 = { 1, 3, 4, 1, 1, 1 };
    int[] arrayOfInt32 = { 1, 1, 1, 2, 4, 2 };
    int[] arrayOfInt33 = { 1, 1, 4, 2, 1, 2 };
    int[] arrayOfInt34 = { 1, 2, 4, 2, 1, 1 };
    int[] arrayOfInt35 = { 4, 2, 1, 2, 1, 1 };
    int[] arrayOfInt36 = { 2, 1, 4, 1, 2, 1 };
    int[] arrayOfInt37 = { 1, 1, 1, 3, 4, 1 };
    int[] arrayOfInt38 = { 1, 3, 1, 1, 4, 1 };
    int[] arrayOfInt39 = { 1, 1, 4, 1, 1, 3 };
    int[] arrayOfInt40 = { 4, 1, 1, 1, 1, 3 };
    int[] arrayOfInt41 = { 1, 1, 4, 1, 3, 1 };
    int[] arrayOfInt42 = { 3, 1, 1, 1, 4, 1 };
    int[] arrayOfInt43 = { 2, 1, 1, 2, 1, 4 };
    CODE_PATTERNS = new int[][] { 
        arrayOfInt1, { 2, 2, 2, 1, 2, 2 }, { 2, 2, 2, 2, 2, 1 }, { 1, 2, 1, 2, 2, 3 }, arrayOfInt2, { 1, 3, 1, 2, 2, 2 }, { 1, 2, 2, 2, 1, 3 }, arrayOfInt3, { 1, 3, 2, 2, 1, 2 }, arrayOfInt4, 
        arrayOfInt5, { 2, 3, 1, 2, 1, 2 }, arrayOfInt6, { 1, 2, 2, 1, 3, 2 }, arrayOfInt7, { 1, 1, 3, 2, 2, 2 }, { 1, 2, 3, 1, 2, 2 }, arrayOfInt8, arrayOfInt9, arrayOfInt10, 
        { 2, 2, 1, 2, 3, 1 }, arrayOfInt11, { 2, 2, 3, 1, 1, 2 }, arrayOfInt12, { 3, 1, 1, 2, 2, 2 }, arrayOfInt13, { 3, 2, 1, 2, 2, 1 }, { 3, 1, 2, 2, 1, 2 }, { 3, 2, 2, 1, 1, 2 }, { 3, 2, 2, 2, 1, 1 }, 
        { 2, 1, 2, 1, 2, 3 }, { 2, 1, 2, 3, 2, 1 }, { 2, 3, 2, 1, 2, 1 }, arrayOfInt14, { 1, 3, 1, 1, 2, 3 }, { 1, 3, 1, 3, 2, 1 }, { 1, 1, 2, 3, 1, 3 }, { 1, 3, 2, 1, 1, 3 }, { 1, 3, 2, 3, 1, 1 }, { 2, 1, 1, 3, 1, 3 }, 
        arrayOfInt15, arrayOfInt16, { 1, 1, 2, 1, 3, 3 }, { 1, 1, 2, 3, 3, 1 }, arrayOfInt17, { 1, 1, 3, 1, 2, 3 }, arrayOfInt18, arrayOfInt19, arrayOfInt20, arrayOfInt21, 
        arrayOfInt22, { 2, 1, 3, 1, 1, 3 }, arrayOfInt23, arrayOfInt24, { 3, 1, 1, 1, 2, 3 }, { 3, 1, 1, 3, 2, 1 }, { 3, 3, 1, 1, 2, 1 }, { 3, 1, 2, 1, 1, 3 }, { 3, 1, 2, 3, 1, 1 }, { 3, 3, 2, 1, 1, 1 }, 
        arrayOfInt25, { 2, 2, 1, 4, 1, 1 }, arrayOfInt26, { 1, 1, 1, 2, 2, 4 }, { 1, 1, 1, 4, 2, 2 }, { 1, 2, 1, 1, 2, 4 }, { 1, 2, 1, 4, 2, 1 }, { 1, 4, 1, 1, 2, 2 }, { 1, 4, 1, 2, 2, 1 }, arrayOfInt27, 
        { 1, 1, 2, 4, 1, 2 }, arrayOfInt28, { 1, 2, 2, 4, 1, 1 }, { 1, 4, 2, 1, 1, 2 }, { 1, 4, 2, 2, 1, 1 }, arrayOfInt29, { 2, 2, 1, 1, 1, 4 }, { 4, 1, 3, 1, 1, 1 }, arrayOfInt30, arrayOfInt31, 
        arrayOfInt32, { 1, 2, 1, 1, 4, 2 }, { 1, 2, 1, 2, 4, 1 }, arrayOfInt33, { 1, 2, 4, 1, 1, 2 }, arrayOfInt34, { 4, 1, 1, 2, 1, 2 }, { 4, 2, 1, 1, 1, 2 }, arrayOfInt35, { 2, 1, 2, 1, 4, 1 }, 
        arrayOfInt36, { 4, 1, 2, 1, 2, 1 }, { 1, 1, 1, 1, 4, 3 }, arrayOfInt37, arrayOfInt38, arrayOfInt39, { 1, 1, 4, 3, 1, 1 }, arrayOfInt40, { 4, 1, 1, 3, 1, 1 }, { 1, 1, 3, 1, 4, 1 }, 
        arrayOfInt41, arrayOfInt42, { 4, 1, 1, 1, 3, 1 }, { 2, 1, 1, 4, 1, 2 }, arrayOfInt43, { 2, 1, 1, 2, 3, 2 }, { 2, 3, 3, 1, 1, 1, 2 } };
  }
  
  private static int decodeCode(BitArray paramBitArray, int[] paramArrayOfint, int paramInt) throws NotFoundException {
    recordPattern(paramBitArray, paramInt, paramArrayOfint);
    float f = 0.25F;
    int i = -1;
    paramInt = 0;
    while (paramInt < CODE_PATTERNS.length) {
      float f1 = patternMatchVariance(paramArrayOfint, CODE_PATTERNS[paramInt], 0.7F);
      float f2 = f;
      if (f1 < f) {
        i = paramInt;
        f2 = f1;
      } 
      paramInt++;
      f = f2;
    } 
    if (i >= 0)
      return i; 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static int[] findStartPattern(BitArray paramBitArray) throws NotFoundException {
    int i = paramBitArray.getSize();
    int j = paramBitArray.getNextSet(0);
    int[] arrayOfInt = new int[6];
    int k = j;
    boolean bool = false;
    int m = 0;
    while (j < i) {
      int n;
      if (paramBitArray.get(j) != bool) {
        arrayOfInt[m] = arrayOfInt[m] + 1;
        n = k;
      } else {
        if (m == 5) {
          float f = 0.25F;
          n = 103;
          int i2 = -1;
          while (n <= 105) {
            float f1 = patternMatchVariance(arrayOfInt, CODE_PATTERNS[n], 0.7F);
            float f2 = f;
            if (f1 < f) {
              i2 = n;
              f2 = f1;
            } 
            n++;
            f = f2;
          } 
          if (i2 >= 0 && paramBitArray.isRange(Math.max(0, k - (j - k) / 2), k, false))
            return new int[] { k, j, i2 }; 
          n = k + arrayOfInt[0] + arrayOfInt[1];
          k = m - 1;
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, k);
          arrayOfInt[k] = 0;
          arrayOfInt[m] = 0;
          k = m - 1;
        } else {
          m++;
          n = k;
          k = m;
        } 
        arrayOfInt[k] = 1;
        int i1 = bool ^ true;
        m = k;
      } 
      j++;
      k = n;
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException, FormatException, ChecksumException {
    // Byte code:
    //   0: aload_3
    //   1: ifnull -> 22
    //   4: aload_3
    //   5: getstatic com/google/zxing/DecodeHintType.ASSUME_GS1 : Lcom/google/zxing/DecodeHintType;
    //   8: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   13: ifeq -> 22
    //   16: iconst_1
    //   17: istore #4
    //   19: goto -> 25
    //   22: iconst_0
    //   23: istore #4
    //   25: aload_2
    //   26: invokestatic findStartPattern : (Lcom/google/zxing/common/BitArray;)[I
    //   29: astore #5
    //   31: aload #5
    //   33: iconst_2
    //   34: iaload
    //   35: istore #6
    //   37: new java/util/ArrayList
    //   40: dup
    //   41: bipush #20
    //   43: invokespecial <init> : (I)V
    //   46: astore #7
    //   48: aload #7
    //   50: iload #6
    //   52: i2b
    //   53: invokestatic valueOf : (B)Ljava/lang/Byte;
    //   56: invokeinterface add : (Ljava/lang/Object;)Z
    //   61: pop
    //   62: iload #6
    //   64: tableswitch default -> 92, 103 -> 110, 104 -> 103, 105 -> 96
    //   92: invokestatic getFormatInstance : ()Lcom/google/zxing/FormatException;
    //   95: athrow
    //   96: bipush #99
    //   98: istore #8
    //   100: goto -> 114
    //   103: bipush #100
    //   105: istore #8
    //   107: goto -> 114
    //   110: bipush #101
    //   112: istore #8
    //   114: new java/lang/StringBuilder
    //   117: dup
    //   118: bipush #20
    //   120: invokespecial <init> : (I)V
    //   123: astore_3
    //   124: aload #5
    //   126: iconst_0
    //   127: iaload
    //   128: istore #9
    //   130: aload #5
    //   132: iconst_1
    //   133: iaload
    //   134: istore #10
    //   136: bipush #6
    //   138: newarray int
    //   140: astore #11
    //   142: iload #8
    //   144: istore #12
    //   146: iconst_0
    //   147: istore #13
    //   149: iconst_0
    //   150: istore #14
    //   152: iconst_0
    //   153: istore #15
    //   155: iconst_0
    //   156: istore #16
    //   158: iconst_0
    //   159: istore #17
    //   161: iconst_0
    //   162: istore #18
    //   164: iconst_0
    //   165: istore #19
    //   167: iconst_1
    //   168: istore #8
    //   170: iload #17
    //   172: istore #20
    //   174: iload #14
    //   176: ifne -> 1202
    //   179: aload_2
    //   180: aload #11
    //   182: iload #10
    //   184: invokestatic decodeCode : (Lcom/google/zxing/common/BitArray;[II)I
    //   187: istore #21
    //   189: aload #7
    //   191: iload #21
    //   193: i2b
    //   194: invokestatic valueOf : (B)Ljava/lang/Byte;
    //   197: invokeinterface add : (Ljava/lang/Object;)Z
    //   202: pop
    //   203: iload #21
    //   205: bipush #106
    //   207: if_icmpeq -> 213
    //   210: iconst_1
    //   211: istore #8
    //   213: iload #6
    //   215: istore #22
    //   217: iload #18
    //   219: istore #19
    //   221: iload #21
    //   223: bipush #106
    //   225: if_icmpeq -> 244
    //   228: iload #18
    //   230: iconst_1
    //   231: iadd
    //   232: istore #19
    //   234: iload #6
    //   236: iload #19
    //   238: iload #21
    //   240: imul
    //   241: iadd
    //   242: istore #22
    //   244: iload #10
    //   246: istore #18
    //   248: iconst_0
    //   249: istore #17
    //   251: iload #17
    //   253: bipush #6
    //   255: if_icmpge -> 274
    //   258: iload #18
    //   260: aload #11
    //   262: iload #17
    //   264: iaload
    //   265: iadd
    //   266: istore #18
    //   268: iinc #17, 1
    //   271: goto -> 251
    //   274: iload #21
    //   276: tableswitch default -> 304, 103 -> 339, 104 -> 339, 105 -> 339
    //   304: iload #12
    //   306: tableswitch default -> 332, 99 -> 949, 100 -> 623, 101 -> 343
    //   332: iload #8
    //   334: istore #17
    //   336: goto -> 1114
    //   339: invokestatic getFormatInstance : ()Lcom/google/zxing/FormatException;
    //   342: athrow
    //   343: iload #21
    //   345: bipush #64
    //   347: if_icmpge -> 389
    //   350: iload #13
    //   352: iload #16
    //   354: if_icmpne -> 371
    //   357: aload_3
    //   358: iload #21
    //   360: bipush #32
    //   362: iadd
    //   363: i2c
    //   364: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: goto -> 666
    //   371: aload_3
    //   372: iload #21
    //   374: bipush #32
    //   376: iadd
    //   377: sipush #128
    //   380: iadd
    //   381: i2c
    //   382: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: goto -> 666
    //   389: iload #21
    //   391: bipush #96
    //   393: if_icmpge -> 431
    //   396: iload #13
    //   398: iload #16
    //   400: if_icmpne -> 417
    //   403: aload_3
    //   404: iload #21
    //   406: bipush #64
    //   408: isub
    //   409: i2c
    //   410: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: goto -> 666
    //   417: aload_3
    //   418: iload #21
    //   420: bipush #64
    //   422: iadd
    //   423: i2c
    //   424: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: goto -> 666
    //   431: iload #21
    //   433: bipush #106
    //   435: if_icmpeq -> 441
    //   438: iconst_0
    //   439: istore #8
    //   441: iload #8
    //   443: istore #17
    //   445: iload #21
    //   447: bipush #106
    //   449: if_icmpeq -> 916
    //   452: iload #8
    //   454: istore #6
    //   456: iload #14
    //   458: istore #9
    //   460: iload #8
    //   462: istore #17
    //   464: iload #21
    //   466: tableswitch default -> 508, 96 -> 919, 97 -> 919, 98 -> 616, 99 -> 895, 100 -> 609, 101 -> 575, 102 -> 519
    //   508: iload #14
    //   510: istore #9
    //   512: iload #8
    //   514: istore #17
    //   516: goto -> 919
    //   519: iload #14
    //   521: istore #9
    //   523: iload #8
    //   525: istore #17
    //   527: iload #4
    //   529: ifeq -> 919
    //   532: aload_3
    //   533: invokevirtual length : ()I
    //   536: ifne -> 557
    //   539: aload_3
    //   540: ldc ']C1'
    //   542: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: pop
    //   546: iload #14
    //   548: istore #9
    //   550: iload #8
    //   552: istore #17
    //   554: goto -> 919
    //   557: aload_3
    //   558: bipush #29
    //   560: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: iload #14
    //   566: istore #9
    //   568: iload #8
    //   570: istore #17
    //   572: goto -> 919
    //   575: iload #16
    //   577: ifne -> 588
    //   580: iload #13
    //   582: ifeq -> 588
    //   585: goto -> 844
    //   588: iload #8
    //   590: istore #6
    //   592: iload #16
    //   594: ifeq -> 874
    //   597: iload #8
    //   599: istore #6
    //   601: iload #13
    //   603: ifeq -> 874
    //   606: goto -> 868
    //   609: bipush #100
    //   611: istore #12
    //   613: goto -> 927
    //   616: bipush #100
    //   618: istore #12
    //   620: goto -> 910
    //   623: iload #21
    //   625: bipush #96
    //   627: if_icmpge -> 683
    //   630: iload #13
    //   632: iload #16
    //   634: if_icmpne -> 651
    //   637: aload_3
    //   638: iload #21
    //   640: bipush #32
    //   642: iadd
    //   643: i2c
    //   644: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: goto -> 666
    //   651: aload_3
    //   652: iload #21
    //   654: bipush #32
    //   656: iadd
    //   657: sipush #128
    //   660: iadd
    //   661: i2c
    //   662: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   665: pop
    //   666: iconst_0
    //   667: istore #13
    //   669: iconst_0
    //   670: istore #6
    //   672: iload #12
    //   674: istore #17
    //   676: iload #6
    //   678: istore #12
    //   680: goto -> 1133
    //   683: iload #21
    //   685: bipush #106
    //   687: if_icmpeq -> 693
    //   690: iconst_0
    //   691: istore #8
    //   693: iload #8
    //   695: istore #17
    //   697: iload #21
    //   699: bipush #106
    //   701: if_icmpeq -> 916
    //   704: iload #8
    //   706: istore #6
    //   708: iload #14
    //   710: istore #9
    //   712: iload #8
    //   714: istore #17
    //   716: iload #21
    //   718: tableswitch default -> 760, 96 -> 919, 97 -> 919, 98 -> 906, 99 -> 895, 100 -> 834, 101 -> 827, 102 -> 771
    //   760: iload #14
    //   762: istore #9
    //   764: iload #8
    //   766: istore #17
    //   768: goto -> 919
    //   771: iload #14
    //   773: istore #9
    //   775: iload #8
    //   777: istore #17
    //   779: iload #4
    //   781: ifeq -> 919
    //   784: aload_3
    //   785: invokevirtual length : ()I
    //   788: ifne -> 809
    //   791: aload_3
    //   792: ldc ']C1'
    //   794: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: pop
    //   798: iload #14
    //   800: istore #9
    //   802: iload #8
    //   804: istore #17
    //   806: goto -> 919
    //   809: aload_3
    //   810: bipush #29
    //   812: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   815: pop
    //   816: iload #14
    //   818: istore #9
    //   820: iload #8
    //   822: istore #17
    //   824: goto -> 919
    //   827: bipush #101
    //   829: istore #12
    //   831: goto -> 927
    //   834: iload #16
    //   836: ifne -> 850
    //   839: iload #13
    //   841: ifeq -> 850
    //   844: iconst_1
    //   845: istore #16
    //   847: goto -> 666
    //   850: iload #8
    //   852: istore #6
    //   854: iload #16
    //   856: ifeq -> 874
    //   859: iload #8
    //   861: istore #6
    //   863: iload #13
    //   865: ifeq -> 874
    //   868: iconst_0
    //   869: istore #16
    //   871: goto -> 666
    //   874: iconst_0
    //   875: istore #13
    //   877: iconst_1
    //   878: istore #8
    //   880: iload #12
    //   882: istore #17
    //   884: iload #8
    //   886: istore #12
    //   888: iload #6
    //   890: istore #8
    //   892: goto -> 1133
    //   895: bipush #99
    //   897: istore #12
    //   899: iload #6
    //   901: istore #8
    //   903: goto -> 927
    //   906: bipush #101
    //   908: istore #12
    //   910: iconst_1
    //   911: istore #6
    //   913: goto -> 930
    //   916: iconst_1
    //   917: istore #9
    //   919: iload #17
    //   921: istore #8
    //   923: iload #9
    //   925: istore #14
    //   927: iconst_0
    //   928: istore #6
    //   930: iload #13
    //   932: istore #9
    //   934: iload #12
    //   936: istore #17
    //   938: iload #6
    //   940: istore #13
    //   942: iload #9
    //   944: istore #12
    //   946: goto -> 1133
    //   949: iload #21
    //   951: bipush #100
    //   953: if_icmpge -> 984
    //   956: iload #21
    //   958: bipush #10
    //   960: if_icmpge -> 970
    //   963: aload_3
    //   964: bipush #48
    //   966: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   969: pop
    //   970: aload_3
    //   971: iload #21
    //   973: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   976: pop
    //   977: iload #8
    //   979: istore #17
    //   981: goto -> 1114
    //   984: iload #21
    //   986: bipush #106
    //   988: if_icmpeq -> 994
    //   991: iconst_0
    //   992: istore #8
    //   994: iload #21
    //   996: bipush #106
    //   998: if_icmpeq -> 1093
    //   1001: iload #21
    //   1003: tableswitch default -> 1028, 100 -> 1086, 101 -> 1079, 102 -> 1035
    //   1028: iload #8
    //   1030: istore #17
    //   1032: goto -> 1114
    //   1035: iload #8
    //   1037: istore #17
    //   1039: iload #4
    //   1041: ifeq -> 1114
    //   1044: aload_3
    //   1045: invokevirtual length : ()I
    //   1048: ifne -> 1065
    //   1051: aload_3
    //   1052: ldc ']C1'
    //   1054: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: pop
    //   1058: iload #8
    //   1060: istore #17
    //   1062: goto -> 1114
    //   1065: aload_3
    //   1066: bipush #29
    //   1068: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   1071: pop
    //   1072: iload #8
    //   1074: istore #17
    //   1076: goto -> 1114
    //   1079: bipush #101
    //   1081: istore #17
    //   1083: goto -> 1122
    //   1086: bipush #100
    //   1088: istore #17
    //   1090: goto -> 1122
    //   1093: iload #13
    //   1095: istore #6
    //   1097: iconst_0
    //   1098: istore #13
    //   1100: iconst_1
    //   1101: istore #14
    //   1103: iload #12
    //   1105: istore #17
    //   1107: iload #6
    //   1109: istore #12
    //   1111: goto -> 1133
    //   1114: iload #17
    //   1116: istore #8
    //   1118: iload #12
    //   1120: istore #17
    //   1122: iconst_0
    //   1123: istore #6
    //   1125: iload #13
    //   1127: istore #12
    //   1129: iload #6
    //   1131: istore #13
    //   1133: iload #15
    //   1135: ifeq -> 1159
    //   1138: iload #17
    //   1140: bipush #101
    //   1142: if_icmpne -> 1152
    //   1145: bipush #100
    //   1147: istore #17
    //   1149: goto -> 1159
    //   1152: bipush #101
    //   1154: istore #17
    //   1156: goto -> 1159
    //   1159: iload #13
    //   1161: istore #15
    //   1163: iload #12
    //   1165: istore #13
    //   1167: iload #21
    //   1169: istore #6
    //   1171: iload #10
    //   1173: istore #9
    //   1175: iload #18
    //   1177: istore #10
    //   1179: iload #17
    //   1181: istore #12
    //   1183: iload #6
    //   1185: istore #17
    //   1187: iload #22
    //   1189: istore #6
    //   1191: iload #19
    //   1193: istore #18
    //   1195: iload #20
    //   1197: istore #19
    //   1199: goto -> 170
    //   1202: aload_2
    //   1203: iload #10
    //   1205: invokevirtual getNextUnset : (I)I
    //   1208: istore #13
    //   1210: aload_2
    //   1211: iload #13
    //   1213: aload_2
    //   1214: invokevirtual getSize : ()I
    //   1217: iload #13
    //   1219: iload #9
    //   1221: isub
    //   1222: iconst_2
    //   1223: idiv
    //   1224: iload #13
    //   1226: iadd
    //   1227: invokestatic min : (II)I
    //   1230: iconst_0
    //   1231: invokevirtual isRange : (IIZ)Z
    //   1234: ifeq -> 1461
    //   1237: iload #6
    //   1239: iload #18
    //   1241: iload #19
    //   1243: imul
    //   1244: isub
    //   1245: bipush #103
    //   1247: irem
    //   1248: iload #19
    //   1250: if_icmpne -> 1457
    //   1253: aload_3
    //   1254: invokevirtual length : ()I
    //   1257: istore #13
    //   1259: iload #13
    //   1261: ifeq -> 1453
    //   1264: iload #13
    //   1266: ifle -> 1306
    //   1269: iload #8
    //   1271: ifeq -> 1306
    //   1274: iload #12
    //   1276: bipush #99
    //   1278: if_icmpne -> 1295
    //   1281: aload_3
    //   1282: iload #13
    //   1284: iconst_2
    //   1285: isub
    //   1286: iload #13
    //   1288: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   1291: pop
    //   1292: goto -> 1306
    //   1295: aload_3
    //   1296: iload #13
    //   1298: iconst_1
    //   1299: isub
    //   1300: iload #13
    //   1302: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   1305: pop
    //   1306: aload #5
    //   1308: iconst_1
    //   1309: iaload
    //   1310: aload #5
    //   1312: iconst_0
    //   1313: iaload
    //   1314: iadd
    //   1315: i2f
    //   1316: fconst_2
    //   1317: fdiv
    //   1318: fstore #23
    //   1320: iload #9
    //   1322: i2f
    //   1323: fstore #24
    //   1325: iload #10
    //   1327: iload #9
    //   1329: isub
    //   1330: i2f
    //   1331: fconst_2
    //   1332: fdiv
    //   1333: fstore #25
    //   1335: aload #7
    //   1337: invokeinterface size : ()I
    //   1342: istore #13
    //   1344: iload #13
    //   1346: newarray byte
    //   1348: astore_2
    //   1349: iconst_0
    //   1350: istore #8
    //   1352: iload #8
    //   1354: iload #13
    //   1356: if_icmpge -> 1384
    //   1359: aload_2
    //   1360: iload #8
    //   1362: aload #7
    //   1364: iload #8
    //   1366: invokeinterface get : (I)Ljava/lang/Object;
    //   1371: checkcast java/lang/Byte
    //   1374: invokevirtual byteValue : ()B
    //   1377: bastore
    //   1378: iinc #8, 1
    //   1381: goto -> 1352
    //   1384: aload_3
    //   1385: invokevirtual toString : ()Ljava/lang/String;
    //   1388: astore #7
    //   1390: iload_1
    //   1391: i2f
    //   1392: fstore #26
    //   1394: new com/google/zxing/ResultPoint
    //   1397: dup
    //   1398: fload #23
    //   1400: fload #26
    //   1402: invokespecial <init> : (FF)V
    //   1405: astore_3
    //   1406: new com/google/zxing/ResultPoint
    //   1409: dup
    //   1410: fload #24
    //   1412: fload #25
    //   1414: fadd
    //   1415: fload #26
    //   1417: invokespecial <init> : (FF)V
    //   1420: astore #5
    //   1422: getstatic com/google/zxing/BarcodeFormat.CODE_128 : Lcom/google/zxing/BarcodeFormat;
    //   1425: astore #11
    //   1427: new com/google/zxing/Result
    //   1430: dup
    //   1431: aload #7
    //   1433: aload_2
    //   1434: iconst_2
    //   1435: anewarray com/google/zxing/ResultPoint
    //   1438: dup
    //   1439: iconst_0
    //   1440: aload_3
    //   1441: aastore
    //   1442: dup
    //   1443: iconst_1
    //   1444: aload #5
    //   1446: aastore
    //   1447: aload #11
    //   1449: invokespecial <init> : (Ljava/lang/String;[B[Lcom/google/zxing/ResultPoint;Lcom/google/zxing/BarcodeFormat;)V
    //   1452: areturn
    //   1453: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   1456: athrow
    //   1457: invokestatic getChecksumInstance : ()Lcom/google/zxing/ChecksumException;
    //   1460: athrow
    //   1461: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   1464: athrow
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\Code128Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */