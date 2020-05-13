package com.tencent.wxop.stat.b;

final class k extends i {
  private static final byte[] cM = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
      101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
      111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
      121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
      56, 57, 43, 47 };
  
  private static final byte[] cN = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
      101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
      111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
      121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
      56, 57, 45, 95 };
  
  public final boolean ba;
  
  public final boolean bb;
  
  private final byte[] cO;
  
  public final boolean cP;
  
  private final byte[] cQ;
  
  private int cc;
  
  int cp;
  
  public k() {
    byte b;
    this.cI = null;
    this.ba = true;
    this.bb = true;
    this.cP = false;
    this.cQ = cM;
    this.cO = new byte[2];
    this.cp = 0;
    if (this.bb) {
      b = 19;
    } else {
      b = -1;
    } 
    this.cc = b;
  }
  
  public final boolean a(byte[] paramArrayOfbyte, int paramInt) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: getfield cQ : [B
    //   6: astore #4
    //   8: aload_0
    //   9: getfield cI : [B
    //   12: astore #5
    //   14: aload_0
    //   15: getfield cc : I
    //   18: istore #6
    //   20: iload_2
    //   21: iconst_0
    //   22: iadd
    //   23: istore #7
    //   25: aload_0
    //   26: getfield cp : I
    //   29: tableswitch default -> 56, 0 -> 348, 1 -> 356, 2 -> 416
    //   56: iconst_m1
    //   57: istore_2
    //   58: iconst_0
    //   59: istore #8
    //   61: iload_2
    //   62: iconst_m1
    //   63: if_icmpeq -> 1036
    //   66: aload #5
    //   68: iconst_0
    //   69: aload #4
    //   71: iload_2
    //   72: bipush #18
    //   74: ishr
    //   75: bipush #63
    //   77: iand
    //   78: baload
    //   79: i2b
    //   80: bastore
    //   81: aload #5
    //   83: iconst_1
    //   84: aload #4
    //   86: iload_2
    //   87: bipush #12
    //   89: ishr
    //   90: bipush #63
    //   92: iand
    //   93: baload
    //   94: i2b
    //   95: bastore
    //   96: aload #5
    //   98: iconst_2
    //   99: aload #4
    //   101: iload_2
    //   102: bipush #6
    //   104: ishr
    //   105: bipush #63
    //   107: iand
    //   108: baload
    //   109: i2b
    //   110: bastore
    //   111: iconst_4
    //   112: istore #9
    //   114: aload #5
    //   116: iconst_3
    //   117: aload #4
    //   119: iload_2
    //   120: bipush #63
    //   122: iand
    //   123: baload
    //   124: i2b
    //   125: bastore
    //   126: iinc #6, -1
    //   129: iload #6
    //   131: ifne -> 1031
    //   134: iload #9
    //   136: istore_2
    //   137: aload_0
    //   138: getfield cP : Z
    //   141: ifeq -> 153
    //   144: iconst_5
    //   145: istore_2
    //   146: aload #5
    //   148: iconst_4
    //   149: bipush #13
    //   151: i2b
    //   152: bastore
    //   153: iload_2
    //   154: iconst_1
    //   155: iadd
    //   156: istore #9
    //   158: aload #5
    //   160: iload_2
    //   161: bipush #10
    //   163: i2b
    //   164: bastore
    //   165: bipush #19
    //   167: istore #6
    //   169: iload #9
    //   171: istore_2
    //   172: iload #8
    //   174: iconst_3
    //   175: iadd
    //   176: iload #7
    //   178: if_icmpgt -> 478
    //   181: aload_1
    //   182: iload #8
    //   184: baload
    //   185: sipush #255
    //   188: iand
    //   189: bipush #16
    //   191: ishl
    //   192: aload_1
    //   193: iload #8
    //   195: iconst_1
    //   196: iadd
    //   197: baload
    //   198: sipush #255
    //   201: iand
    //   202: bipush #8
    //   204: ishl
    //   205: ior
    //   206: aload_1
    //   207: iload #8
    //   209: iconst_2
    //   210: iadd
    //   211: baload
    //   212: sipush #255
    //   215: iand
    //   216: ior
    //   217: istore #9
    //   219: aload #5
    //   221: iload_2
    //   222: aload #4
    //   224: iload #9
    //   226: bipush #18
    //   228: ishr
    //   229: bipush #63
    //   231: iand
    //   232: baload
    //   233: i2b
    //   234: bastore
    //   235: aload #5
    //   237: iload_2
    //   238: iconst_1
    //   239: iadd
    //   240: aload #4
    //   242: iload #9
    //   244: bipush #12
    //   246: ishr
    //   247: bipush #63
    //   249: iand
    //   250: baload
    //   251: i2b
    //   252: bastore
    //   253: aload #5
    //   255: iload_2
    //   256: iconst_2
    //   257: iadd
    //   258: aload #4
    //   260: iload #9
    //   262: bipush #6
    //   264: ishr
    //   265: bipush #63
    //   267: iand
    //   268: baload
    //   269: i2b
    //   270: bastore
    //   271: aload #5
    //   273: iload_2
    //   274: iconst_3
    //   275: iadd
    //   276: aload #4
    //   278: iload #9
    //   280: bipush #63
    //   282: iand
    //   283: baload
    //   284: i2b
    //   285: bastore
    //   286: iinc #8, 3
    //   289: iinc #2, 4
    //   292: iinc #6, -1
    //   295: iload #6
    //   297: ifne -> 1028
    //   300: aload_0
    //   301: getfield cP : Z
    //   304: ifeq -> 1025
    //   307: iload_2
    //   308: iconst_1
    //   309: iadd
    //   310: istore #6
    //   312: aload #5
    //   314: iload_2
    //   315: bipush #13
    //   317: i2b
    //   318: bastore
    //   319: iload #6
    //   321: istore_2
    //   322: iload_2
    //   323: iconst_1
    //   324: iadd
    //   325: istore #6
    //   327: aload #5
    //   329: iload_2
    //   330: bipush #10
    //   332: i2b
    //   333: bastore
    //   334: bipush #19
    //   336: istore #9
    //   338: iload #6
    //   340: istore_2
    //   341: iload #9
    //   343: istore #6
    //   345: goto -> 172
    //   348: iconst_m1
    //   349: istore_2
    //   350: iconst_0
    //   351: istore #8
    //   353: goto -> 61
    //   356: iconst_2
    //   357: iload #7
    //   359: if_icmpgt -> 56
    //   362: aload_0
    //   363: getfield cO : [B
    //   366: iconst_0
    //   367: baload
    //   368: istore #9
    //   370: aload_1
    //   371: iconst_0
    //   372: baload
    //   373: istore_2
    //   374: aload_1
    //   375: iconst_1
    //   376: baload
    //   377: istore #8
    //   379: aload_0
    //   380: iconst_0
    //   381: putfield cp : I
    //   384: iload #9
    //   386: sipush #255
    //   389: iand
    //   390: bipush #16
    //   392: ishl
    //   393: iload_2
    //   394: sipush #255
    //   397: iand
    //   398: bipush #8
    //   400: ishl
    //   401: ior
    //   402: iload #8
    //   404: sipush #255
    //   407: iand
    //   408: ior
    //   409: istore_2
    //   410: iconst_2
    //   411: istore #8
    //   413: goto -> 61
    //   416: iload #7
    //   418: ifle -> 56
    //   421: aload_0
    //   422: getfield cO : [B
    //   425: iconst_0
    //   426: baload
    //   427: istore_2
    //   428: aload_0
    //   429: getfield cO : [B
    //   432: iconst_1
    //   433: baload
    //   434: istore #9
    //   436: aload_1
    //   437: iconst_0
    //   438: baload
    //   439: istore #8
    //   441: aload_0
    //   442: iconst_0
    //   443: putfield cp : I
    //   446: iload_2
    //   447: sipush #255
    //   450: iand
    //   451: bipush #16
    //   453: ishl
    //   454: iload #9
    //   456: sipush #255
    //   459: iand
    //   460: bipush #8
    //   462: ishl
    //   463: ior
    //   464: iload #8
    //   466: sipush #255
    //   469: iand
    //   470: ior
    //   471: istore_2
    //   472: iconst_1
    //   473: istore #8
    //   475: goto -> 61
    //   478: iload #8
    //   480: aload_0
    //   481: getfield cp : I
    //   484: isub
    //   485: iload #7
    //   487: iconst_1
    //   488: isub
    //   489: if_icmpne -> 681
    //   492: aload_0
    //   493: getfield cp : I
    //   496: ifle -> 667
    //   499: aload_0
    //   500: getfield cO : [B
    //   503: iconst_0
    //   504: baload
    //   505: istore #9
    //   507: iconst_1
    //   508: istore_3
    //   509: iload #9
    //   511: sipush #255
    //   514: iand
    //   515: iconst_4
    //   516: ishl
    //   517: istore #9
    //   519: aload_0
    //   520: aload_0
    //   521: getfield cp : I
    //   524: iload_3
    //   525: isub
    //   526: putfield cp : I
    //   529: iload_2
    //   530: iconst_1
    //   531: iadd
    //   532: istore #10
    //   534: aload #5
    //   536: iload_2
    //   537: aload #4
    //   539: iload #9
    //   541: bipush #6
    //   543: ishr
    //   544: bipush #63
    //   546: iand
    //   547: baload
    //   548: i2b
    //   549: bastore
    //   550: iload #10
    //   552: iconst_1
    //   553: iadd
    //   554: istore_3
    //   555: aload #5
    //   557: iload #10
    //   559: aload #4
    //   561: iload #9
    //   563: bipush #63
    //   565: iand
    //   566: baload
    //   567: i2b
    //   568: bastore
    //   569: iload_3
    //   570: istore_2
    //   571: aload_0
    //   572: getfield ba : Z
    //   575: ifeq -> 603
    //   578: iload_3
    //   579: iconst_1
    //   580: iadd
    //   581: istore #9
    //   583: aload #5
    //   585: iload_3
    //   586: bipush #61
    //   588: i2b
    //   589: bastore
    //   590: iload #9
    //   592: iconst_1
    //   593: iadd
    //   594: istore_2
    //   595: aload #5
    //   597: iload #9
    //   599: bipush #61
    //   601: i2b
    //   602: bastore
    //   603: iload_2
    //   604: istore_3
    //   605: aload_0
    //   606: getfield bb : Z
    //   609: ifeq -> 642
    //   612: iload_2
    //   613: istore_3
    //   614: aload_0
    //   615: getfield cP : Z
    //   618: ifeq -> 632
    //   621: aload #5
    //   623: iload_2
    //   624: bipush #13
    //   626: i2b
    //   627: bastore
    //   628: iload_2
    //   629: iconst_1
    //   630: iadd
    //   631: istore_3
    //   632: aload #5
    //   634: iload_3
    //   635: bipush #10
    //   637: i2b
    //   638: bastore
    //   639: iinc #3, 1
    //   642: iload #8
    //   644: istore #9
    //   646: getstatic com/tencent/wxop/stat/b/k.ad : Z
    //   649: ifne -> 985
    //   652: aload_0
    //   653: getfield cp : I
    //   656: ifeq -> 985
    //   659: new java/lang/AssertionError
    //   662: dup
    //   663: invokespecial <init> : ()V
    //   666: athrow
    //   667: aload_1
    //   668: iload #8
    //   670: baload
    //   671: istore #9
    //   673: iinc #8, 1
    //   676: iconst_0
    //   677: istore_3
    //   678: goto -> 509
    //   681: iload #8
    //   683: aload_0
    //   684: getfield cp : I
    //   687: isub
    //   688: iload #7
    //   690: iconst_2
    //   691: isub
    //   692: if_icmpne -> 911
    //   695: aload_0
    //   696: getfield cp : I
    //   699: iconst_1
    //   700: if_icmple -> 887
    //   703: aload_0
    //   704: getfield cO : [B
    //   707: iconst_0
    //   708: baload
    //   709: istore #9
    //   711: iconst_1
    //   712: istore_3
    //   713: aload_0
    //   714: getfield cp : I
    //   717: ifle -> 899
    //   720: aload_0
    //   721: getfield cO : [B
    //   724: iload_3
    //   725: baload
    //   726: istore #10
    //   728: iinc #3, 1
    //   731: iload #10
    //   733: sipush #255
    //   736: iand
    //   737: iconst_2
    //   738: ishl
    //   739: iload #9
    //   741: sipush #255
    //   744: iand
    //   745: bipush #10
    //   747: ishl
    //   748: ior
    //   749: istore #9
    //   751: aload_0
    //   752: aload_0
    //   753: getfield cp : I
    //   756: iload_3
    //   757: isub
    //   758: putfield cp : I
    //   761: iload_2
    //   762: iconst_1
    //   763: iadd
    //   764: istore_3
    //   765: aload #5
    //   767: iload_2
    //   768: aload #4
    //   770: iload #9
    //   772: bipush #12
    //   774: ishr
    //   775: bipush #63
    //   777: iand
    //   778: baload
    //   779: i2b
    //   780: bastore
    //   781: iload_3
    //   782: iconst_1
    //   783: iadd
    //   784: istore #10
    //   786: aload #5
    //   788: iload_3
    //   789: aload #4
    //   791: iload #9
    //   793: bipush #6
    //   795: ishr
    //   796: bipush #63
    //   798: iand
    //   799: baload
    //   800: i2b
    //   801: bastore
    //   802: iload #10
    //   804: iconst_1
    //   805: iadd
    //   806: istore_2
    //   807: aload #5
    //   809: iload #10
    //   811: aload #4
    //   813: iload #9
    //   815: bipush #63
    //   817: iand
    //   818: baload
    //   819: i2b
    //   820: bastore
    //   821: aload_0
    //   822: getfield ba : Z
    //   825: ifeq -> 1022
    //   828: iload_2
    //   829: iconst_1
    //   830: iadd
    //   831: istore_3
    //   832: aload #5
    //   834: iload_2
    //   835: bipush #61
    //   837: i2b
    //   838: bastore
    //   839: iload_3
    //   840: istore_2
    //   841: iload_2
    //   842: istore_3
    //   843: aload_0
    //   844: getfield bb : Z
    //   847: ifeq -> 880
    //   850: iload_2
    //   851: istore_3
    //   852: aload_0
    //   853: getfield cP : Z
    //   856: ifeq -> 870
    //   859: aload #5
    //   861: iload_2
    //   862: bipush #13
    //   864: i2b
    //   865: bastore
    //   866: iload_2
    //   867: iconst_1
    //   868: iadd
    //   869: istore_3
    //   870: aload #5
    //   872: iload_3
    //   873: bipush #10
    //   875: i2b
    //   876: bastore
    //   877: iinc #3, 1
    //   880: iload #8
    //   882: istore #9
    //   884: goto -> 646
    //   887: aload_1
    //   888: iload #8
    //   890: baload
    //   891: istore #9
    //   893: iinc #8, 1
    //   896: goto -> 713
    //   899: aload_1
    //   900: iload #8
    //   902: baload
    //   903: istore #10
    //   905: iinc #8, 1
    //   908: goto -> 731
    //   911: iload #8
    //   913: istore #9
    //   915: iload_2
    //   916: istore_3
    //   917: aload_0
    //   918: getfield bb : Z
    //   921: ifeq -> 646
    //   924: iload #8
    //   926: istore #9
    //   928: iload_2
    //   929: istore_3
    //   930: iload_2
    //   931: ifle -> 646
    //   934: iload #8
    //   936: istore #9
    //   938: iload_2
    //   939: istore_3
    //   940: iload #6
    //   942: bipush #19
    //   944: if_icmpeq -> 646
    //   947: aload_0
    //   948: getfield cP : Z
    //   951: ifeq -> 1019
    //   954: iload_2
    //   955: iconst_1
    //   956: iadd
    //   957: istore_3
    //   958: aload #5
    //   960: iload_2
    //   961: bipush #13
    //   963: i2b
    //   964: bastore
    //   965: iload_3
    //   966: istore_2
    //   967: iload_2
    //   968: iconst_1
    //   969: iadd
    //   970: istore_3
    //   971: aload #5
    //   973: iload_2
    //   974: bipush #10
    //   976: i2b
    //   977: bastore
    //   978: iload #8
    //   980: istore #9
    //   982: goto -> 646
    //   985: getstatic com/tencent/wxop/stat/b/k.ad : Z
    //   988: ifne -> 1006
    //   991: iload #9
    //   993: iload #7
    //   995: if_icmpeq -> 1006
    //   998: new java/lang/AssertionError
    //   1001: dup
    //   1002: invokespecial <init> : ()V
    //   1005: athrow
    //   1006: aload_0
    //   1007: iload_3
    //   1008: putfield g : I
    //   1011: aload_0
    //   1012: iload #6
    //   1014: putfield cc : I
    //   1017: iconst_1
    //   1018: ireturn
    //   1019: goto -> 967
    //   1022: goto -> 841
    //   1025: goto -> 322
    //   1028: goto -> 172
    //   1031: iconst_4
    //   1032: istore_2
    //   1033: goto -> 172
    //   1036: iconst_0
    //   1037: istore_2
    //   1038: goto -> 172
  }
  
  static {
    boolean bool;
    if (!h.class.desiredAssertionStatus()) {
      bool = true;
    } else {
      bool = false;
    } 
    ad = bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */