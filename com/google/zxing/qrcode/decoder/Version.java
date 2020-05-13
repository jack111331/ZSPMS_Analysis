package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

public final class Version {
  private static final Version[] VERSIONS;
  
  private static final int[] VERSION_DECODE_INFO = new int[] { 
      31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 
      70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 
      110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 
      152622, 158308, 161089, 167017 };
  
  private final int[] alignmentPatternCenters;
  
  private final ECBlocks[] ecBlocks;
  
  private final int totalCodewords;
  
  private final int versionNumber;
  
  static {
    VERSIONS = buildVersions();
  }
  
  private Version(int paramInt, int[] paramArrayOfint, ECBlocks... paramVarArgs) {
    this.versionNumber = paramInt;
    this.alignmentPatternCenters = paramArrayOfint;
    this.ecBlocks = paramVarArgs;
    paramInt = 0;
    int i = paramVarArgs[0].getECCodewordsPerBlock();
    ECB[] arrayOfECB = paramVarArgs[0].getECBlocks();
    int j = arrayOfECB.length;
    int k = 0;
    while (paramInt < j) {
      ECB eCB = arrayOfECB[paramInt];
      k += eCB.getCount() * (eCB.getDataCodewords() + i);
      paramInt++;
    } 
    this.totalCodewords = k;
  }
  
  private static Version[] buildVersions() {
    ECBlocks eCBlocks1 = new ECBlocks(7, new ECB[] { new ECB(1, 19) });
    ECBlocks eCBlocks2 = new ECBlocks(10, new ECB[] { new ECB(1, 16) });
    ECBlocks eCBlocks3 = new ECBlocks(13, new ECB[] { new ECB(1, 13) });
    ECBlocks eCBlocks4 = new ECBlocks(17, new ECB[] { new ECB(1, 9) });
    Version version1 = new Version(1, new int[0], new ECBlocks[] { eCBlocks1, eCBlocks2, eCBlocks3, eCBlocks4 });
    eCBlocks3 = new ECBlocks(10, new ECB[] { new ECB(1, 34) });
    ECBlocks eCBlocks5 = new ECBlocks(16, new ECB[] { new ECB(1, 28) });
    eCBlocks2 = new ECBlocks(22, new ECB[] { new ECB(1, 22) });
    eCBlocks4 = new ECBlocks(28, new ECB[] { new ECB(1, 16) });
    Version version4 = new Version(2, new int[] { 6, 18 }, new ECBlocks[] { eCBlocks3, eCBlocks5, eCBlocks2, eCBlocks4 });
    eCBlocks2 = new ECBlocks(15, new ECB[] { new ECB(1, 55) });
    eCBlocks3 = new ECBlocks(26, new ECB[] { new ECB(1, 44) });
    ECBlocks eCBlocks6 = new ECBlocks(18, new ECB[] { new ECB(2, 17) });
    eCBlocks5 = new ECBlocks(22, new ECB[] { new ECB(2, 13) });
    Version version3 = new Version(3, new int[] { 6, 22 }, new ECBlocks[] { eCBlocks2, eCBlocks3, eCBlocks6, eCBlocks5 });
    eCBlocks5 = new ECBlocks(20, new ECB[] { new ECB(1, 80) });
    eCBlocks6 = new ECBlocks(18, new ECB[] { new ECB(2, 32) });
    eCBlocks2 = new ECBlocks(26, new ECB[] { new ECB(2, 24) });
    ECBlocks eCBlocks7 = new ECBlocks(16, new ECB[] { new ECB(4, 9) });
    Version version2 = new Version(4, new int[] { 6, 26 }, new ECBlocks[] { eCBlocks5, eCBlocks6, eCBlocks2, eCBlocks7 });
    eCBlocks5 = new ECBlocks(26, new ECB[] { new ECB(1, 108) });
    eCBlocks6 = new ECBlocks(24, new ECB[] { new ECB(2, 43) });
    eCBlocks7 = new ECBlocks(18, new ECB[] { new ECB(2, 15), new ECB(2, 16) });
    ECBlocks eCBlocks8 = new ECBlocks(22, new ECB[] { new ECB(2, 11), new ECB(2, 12) });
    Version version5 = new Version(5, new int[] { 6, 30 }, new ECBlocks[] { eCBlocks5, eCBlocks6, eCBlocks7, eCBlocks8 });
    ECBlocks eCBlocks9 = new ECBlocks(18, new ECB[] { new ECB(2, 68) });
    eCBlocks6 = new ECBlocks(16, new ECB[] { new ECB(4, 27) });
    eCBlocks8 = new ECBlocks(24, new ECB[] { new ECB(4, 19) });
    eCBlocks7 = new ECBlocks(28, new ECB[] { new ECB(4, 15) });
    Version version6 = new Version(6, new int[] { 6, 34 }, new ECBlocks[] { eCBlocks9, eCBlocks6, eCBlocks8, eCBlocks7 });
    eCBlocks8 = new ECBlocks(20, new ECB[] { new ECB(2, 78) });
    eCBlocks7 = new ECBlocks(18, new ECB[] { new ECB(4, 31) });
    ECBlocks eCBlocks10 = new ECBlocks(18, new ECB[] { new ECB(2, 14), new ECB(4, 15) });
    eCBlocks9 = new ECBlocks(26, new ECB[] { new ECB(4, 13), new ECB(1, 14) });
    Version version7 = new Version(7, new int[] { 6, 22, 38 }, new ECBlocks[] { eCBlocks8, eCBlocks7, eCBlocks10, eCBlocks9 });
    eCBlocks9 = new ECBlocks(24, new ECB[] { new ECB(2, 97) });
    eCBlocks8 = new ECBlocks(22, new ECB[] { new ECB(2, 38), new ECB(2, 39) });
    ECBlocks eCBlocks11 = new ECBlocks(22, new ECB[] { new ECB(4, 18), new ECB(2, 19) });
    eCBlocks10 = new ECBlocks(26, new ECB[] { new ECB(4, 14), new ECB(2, 15) });
    Version version8 = new Version(8, new int[] { 6, 24, 42 }, new ECBlocks[] { eCBlocks9, eCBlocks8, eCBlocks11, eCBlocks10 });
    eCBlocks9 = new ECBlocks(30, new ECB[] { new ECB(2, 116) });
    eCBlocks10 = new ECBlocks(22, new ECB[] { new ECB(3, 36), new ECB(2, 37) });
    ECBlocks eCBlocks12 = new ECBlocks(20, new ECB[] { new ECB(4, 16), new ECB(4, 17) });
    eCBlocks11 = new ECBlocks(24, new ECB[] { new ECB(4, 12), new ECB(4, 13) });
    Version version9 = new Version(9, new int[] { 6, 26, 46 }, new ECBlocks[] { eCBlocks9, eCBlocks10, eCBlocks12, eCBlocks11 });
    eCBlocks12 = new ECBlocks(18, new ECB[] { new ECB(2, 68), new ECB(2, 69) });
    eCBlocks10 = new ECBlocks(26, new ECB[] { new ECB(4, 43), new ECB(1, 44) });
    ECBlocks eCBlocks13 = new ECBlocks(24, new ECB[] { new ECB(6, 19), new ECB(2, 20) });
    eCBlocks11 = new ECBlocks(28, new ECB[] { new ECB(6, 15), new ECB(2, 16) });
    Version version10 = new Version(10, new int[] { 6, 28, 50 }, new ECBlocks[] { eCBlocks12, eCBlocks10, eCBlocks13, eCBlocks11 });
    eCBlocks13 = new ECBlocks(20, new ECB[] { new ECB(4, 81) });
    eCBlocks11 = new ECBlocks(30, new ECB[] { new ECB(1, 50), new ECB(4, 51) });
    eCBlocks12 = new ECBlocks(28, new ECB[] { new ECB(4, 22), new ECB(4, 23) });
    ECBlocks eCBlocks14 = new ECBlocks(24, new ECB[] { new ECB(3, 12), new ECB(8, 13) });
    Version version11 = new Version(11, new int[] { 6, 30, 54 }, new ECBlocks[] { eCBlocks13, eCBlocks11, eCBlocks12, eCBlocks14 });
    ECBlocks eCBlocks15 = new ECBlocks(24, new ECB[] { new ECB(2, 92), new ECB(2, 93) });
    eCBlocks14 = new ECBlocks(22, new ECB[] { new ECB(6, 36), new ECB(2, 37) });
    eCBlocks12 = new ECBlocks(26, new ECB[] { new ECB(4, 20), new ECB(6, 21) });
    eCBlocks13 = new ECBlocks(28, new ECB[] { new ECB(7, 14), new ECB(4, 15) });
    Version version12 = new Version(12, new int[] { 6, 32, 58 }, new ECBlocks[] { eCBlocks15, eCBlocks14, eCBlocks12, eCBlocks13 });
    eCBlocks13 = new ECBlocks(26, new ECB[] { new ECB(4, 107) });
    eCBlocks14 = new ECBlocks(22, new ECB[] { new ECB(8, 37), new ECB(1, 38) });
    ECBlocks eCBlocks16 = new ECBlocks(24, new ECB[] { new ECB(8, 20), new ECB(4, 21) });
    eCBlocks15 = new ECBlocks(22, new ECB[] { new ECB(12, 11), new ECB(4, 12) });
    Version version13 = new Version(13, new int[] { 6, 34, 62 }, new ECBlocks[] { eCBlocks13, eCBlocks14, eCBlocks16, eCBlocks15 });
    eCBlocks16 = new ECBlocks(30, new ECB[] { new ECB(3, 115), new ECB(1, 116) });
    eCBlocks14 = new ECBlocks(24, new ECB[] { new ECB(4, 40), new ECB(5, 41) });
    eCBlocks15 = new ECBlocks(20, new ECB[] { new ECB(11, 16), new ECB(5, 17) });
    ECBlocks eCBlocks17 = new ECBlocks(24, new ECB[] { new ECB(11, 12), new ECB(5, 13) });
    Version version14 = new Version(14, new int[] { 6, 26, 46, 66 }, new ECBlocks[] { eCBlocks16, eCBlocks14, eCBlocks15, eCBlocks17 });
    eCBlocks15 = new ECBlocks(22, new ECB[] { new ECB(5, 87), new ECB(1, 88) });
    eCBlocks16 = new ECBlocks(24, new ECB[] { new ECB(5, 41), new ECB(5, 42) });
    ECBlocks eCBlocks18 = new ECBlocks(30, new ECB[] { new ECB(5, 24), new ECB(7, 25) });
    eCBlocks17 = new ECBlocks(24, new ECB[] { new ECB(11, 12), new ECB(7, 13) });
    Version version15 = new Version(15, new int[] { 6, 26, 48, 70 }, new ECBlocks[] { eCBlocks15, eCBlocks16, eCBlocks18, eCBlocks17 });
    eCBlocks18 = new ECBlocks(24, new ECB[] { new ECB(5, 98), new ECB(1, 99) });
    eCBlocks17 = new ECBlocks(28, new ECB[] { new ECB(7, 45), new ECB(3, 46) });
    ECBlocks eCBlocks19 = new ECBlocks(24, new ECB[] { new ECB(15, 19), new ECB(2, 20) });
    eCBlocks16 = new ECBlocks(30, new ECB[] { new ECB(3, 15), new ECB(13, 16) });
    Version version16 = new Version(16, new int[] { 6, 26, 50, 74 }, new ECBlocks[] { eCBlocks18, eCBlocks17, eCBlocks19, eCBlocks16 });
    ECBlocks eCBlocks20 = new ECBlocks(28, new ECB[] { new ECB(1, 107), new ECB(5, 108) });
    eCBlocks17 = new ECBlocks(28, new ECB[] { new ECB(10, 46), new ECB(1, 47) });
    eCBlocks19 = new ECBlocks(28, new ECB[] { new ECB(1, 22), new ECB(15, 23) });
    eCBlocks18 = new ECBlocks(28, new ECB[] { new ECB(2, 14), new ECB(17, 15) });
    Version version17 = new Version(17, new int[] { 6, 30, 54, 78 }, new ECBlocks[] { eCBlocks20, eCBlocks17, eCBlocks19, eCBlocks18 });
    eCBlocks19 = new ECBlocks(30, new ECB[] { new ECB(5, 120), new ECB(1, 121) });
    eCBlocks20 = new ECBlocks(26, new ECB[] { new ECB(9, 43), new ECB(4, 44) });
    eCBlocks18 = new ECBlocks(28, new ECB[] { new ECB(17, 22), new ECB(1, 23) });
    ECBlocks eCBlocks21 = new ECBlocks(28, new ECB[] { new ECB(2, 14), new ECB(19, 15) });
    Version version18 = new Version(18, new int[] { 6, 30, 56, 82 }, new ECBlocks[] { eCBlocks19, eCBlocks20, eCBlocks18, eCBlocks21 });
    ECBlocks eCBlocks22 = new ECBlocks(28, new ECB[] { new ECB(3, 113), new ECB(4, 114) });
    eCBlocks19 = new ECBlocks(26, new ECB[] { new ECB(3, 44), new ECB(11, 45) });
    eCBlocks21 = new ECBlocks(26, new ECB[] { new ECB(17, 21), new ECB(4, 22) });
    eCBlocks20 = new ECBlocks(26, new ECB[] { new ECB(9, 13), new ECB(16, 14) });
    Version version19 = new Version(19, new int[] { 6, 30, 58, 86 }, new ECBlocks[] { eCBlocks22, eCBlocks19, eCBlocks21, eCBlocks20 });
    ECBlocks eCBlocks23 = new ECBlocks(28, new ECB[] { new ECB(3, 107), new ECB(5, 108) });
    eCBlocks22 = new ECBlocks(26, new ECB[] { new ECB(3, 41), new ECB(13, 42) });
    eCBlocks21 = new ECBlocks(30, new ECB[] { new ECB(15, 24), new ECB(5, 25) });
    eCBlocks20 = new ECBlocks(28, new ECB[] { new ECB(15, 15), new ECB(10, 16) });
    Version version20 = new Version(20, new int[] { 6, 34, 62, 90 }, new ECBlocks[] { eCBlocks23, eCBlocks22, eCBlocks21, eCBlocks20 });
    eCBlocks21 = new ECBlocks(28, new ECB[] { new ECB(4, 116), new ECB(4, 117) });
    eCBlocks22 = new ECBlocks(26, new ECB[] { new ECB(17, 42) });
    ECBlocks eCBlocks24 = new ECBlocks(28, new ECB[] { new ECB(17, 22), new ECB(6, 23) });
    eCBlocks23 = new ECBlocks(30, new ECB[] { new ECB(19, 16), new ECB(6, 17) });
    Version version21 = new Version(21, new int[] { 6, 28, 50, 72, 94 }, new ECBlocks[] { eCBlocks21, eCBlocks22, eCBlocks24, eCBlocks23 });
    eCBlocks24 = new ECBlocks(28, new ECB[] { new ECB(2, 111), new ECB(7, 112) });
    eCBlocks23 = new ECBlocks(28, new ECB[] { new ECB(17, 46) });
    eCBlocks22 = new ECBlocks(30, new ECB[] { new ECB(7, 24), new ECB(16, 25) });
    ECBlocks eCBlocks25 = new ECBlocks(24, new ECB[] { new ECB(34, 13) });
    Version version22 = new Version(22, new int[] { 6, 26, 50, 74, 98 }, new ECBlocks[] { eCBlocks24, eCBlocks23, eCBlocks22, eCBlocks25 });
    eCBlocks23 = new ECBlocks(30, new ECB[] { new ECB(4, 121), new ECB(5, 122) });
    ECBlocks eCBlocks26 = new ECBlocks(28, new ECB[] { new ECB(4, 47), new ECB(14, 48) });
    eCBlocks24 = new ECBlocks(30, new ECB[] { new ECB(11, 24), new ECB(14, 25) });
    eCBlocks25 = new ECBlocks(30, new ECB[] { new ECB(16, 15), new ECB(14, 16) });
    Version version23 = new Version(23, new int[] { 6, 30, 54, 78, 102 }, new ECBlocks[] { eCBlocks23, eCBlocks26, eCBlocks24, eCBlocks25 });
    eCBlocks26 = new ECBlocks(30, new ECB[] { new ECB(6, 117), new ECB(4, 118) });
    ECBlocks eCBlocks27 = new ECBlocks(28, new ECB[] { new ECB(6, 45), new ECB(14, 46) });
    eCBlocks25 = new ECBlocks(30, new ECB[] { new ECB(11, 24), new ECB(16, 25) });
    eCBlocks24 = new ECBlocks(30, new ECB[] { new ECB(30, 16), new ECB(2, 17) });
    Version version24 = new Version(24, new int[] { 6, 28, 54, 80, 106 }, new ECBlocks[] { eCBlocks26, eCBlocks27, eCBlocks25, eCBlocks24 });
    ECBlocks eCBlocks28 = new ECBlocks(26, new ECB[] { new ECB(8, 106), new ECB(4, 107) });
    eCBlocks26 = new ECBlocks(28, new ECB[] { new ECB(8, 47), new ECB(13, 48) });
    eCBlocks27 = new ECBlocks(30, new ECB[] { new ECB(7, 24), new ECB(22, 25) });
    eCBlocks25 = new ECBlocks(30, new ECB[] { new ECB(22, 15), new ECB(13, 16) });
    Version version25 = new Version(25, new int[] { 6, 32, 58, 84, 110 }, new ECBlocks[] { eCBlocks28, eCBlocks26, eCBlocks27, eCBlocks25 });
    eCBlocks28 = new ECBlocks(28, new ECB[] { new ECB(10, 114), new ECB(2, 115) });
    eCBlocks27 = new ECBlocks(28, new ECB[] { new ECB(19, 46), new ECB(4, 47) });
    ECBlocks eCBlocks29 = new ECBlocks(28, new ECB[] { new ECB(28, 22), new ECB(6, 23) });
    eCBlocks26 = new ECBlocks(30, new ECB[] { new ECB(33, 16), new ECB(4, 17) });
    Version version26 = new Version(26, new int[] { 6, 30, 58, 86, 114 }, new ECBlocks[] { eCBlocks28, eCBlocks27, eCBlocks29, eCBlocks26 });
    eCBlocks27 = new ECBlocks(30, new ECB[] { new ECB(8, 122), new ECB(4, 123) });
    eCBlocks29 = new ECBlocks(28, new ECB[] { new ECB(22, 45), new ECB(3, 46) });
    eCBlocks28 = new ECBlocks(30, new ECB[] { new ECB(8, 23), new ECB(26, 24) });
    ECBlocks eCBlocks30 = new ECBlocks(30, new ECB[] { new ECB(12, 15), new ECB(28, 16) });
    Version version27 = new Version(27, new int[] { 6, 34, 62, 90, 118 }, new ECBlocks[] { eCBlocks27, eCBlocks29, eCBlocks28, eCBlocks30 });
    eCBlocks30 = new ECBlocks(30, new ECB[] { new ECB(3, 117), new ECB(10, 118) });
    eCBlocks29 = new ECBlocks(28, new ECB[] { new ECB(3, 45), new ECB(23, 46) });
    eCBlocks28 = new ECBlocks(30, new ECB[] { new ECB(4, 24), new ECB(31, 25) });
    ECBlocks eCBlocks31 = new ECBlocks(30, new ECB[] { new ECB(11, 15), new ECB(31, 16) });
    Version version28 = new Version(28, new int[] { 6, 26, 50, 74, 98, 122 }, new ECBlocks[] { eCBlocks30, eCBlocks29, eCBlocks28, eCBlocks31 });
    eCBlocks29 = new ECBlocks(30, new ECB[] { new ECB(7, 116), new ECB(7, 117) });
    eCBlocks30 = new ECBlocks(28, new ECB[] { new ECB(21, 45), new ECB(7, 46) });
    eCBlocks31 = new ECBlocks(30, new ECB[] { new ECB(1, 23), new ECB(37, 24) });
    ECBlocks eCBlocks32 = new ECBlocks(30, new ECB[] { new ECB(19, 15), new ECB(26, 16) });
    Version version29 = new Version(29, new int[] { 6, 30, 54, 78, 102, 126 }, new ECBlocks[] { eCBlocks29, eCBlocks30, eCBlocks31, eCBlocks32 });
    eCBlocks32 = new ECBlocks(30, new ECB[] { new ECB(5, 115), new ECB(10, 116) });
    eCBlocks31 = new ECBlocks(28, new ECB[] { new ECB(19, 47), new ECB(10, 48) });
    eCBlocks30 = new ECBlocks(30, new ECB[] { new ECB(15, 24), new ECB(25, 25) });
    ECBlocks eCBlocks33 = new ECBlocks(30, new ECB[] { new ECB(23, 15), new ECB(25, 16) });
    Version version30 = new Version(30, new int[] { 6, 26, 52, 78, 104, 130 }, new ECBlocks[] { eCBlocks32, eCBlocks31, eCBlocks30, eCBlocks33 });
    eCBlocks33 = new ECBlocks(30, new ECB[] { new ECB(13, 115), new ECB(3, 116) });
    eCBlocks32 = new ECBlocks(28, new ECB[] { new ECB(2, 46), new ECB(29, 47) });
    ECBlocks eCBlocks34 = new ECBlocks(30, new ECB[] { new ECB(42, 24), new ECB(1, 25) });
    eCBlocks31 = new ECBlocks(30, new ECB[] { new ECB(23, 15), new ECB(28, 16) });
    Version version31 = new Version(31, new int[] { 6, 30, 56, 82, 108, 134 }, new ECBlocks[] { eCBlocks33, eCBlocks32, eCBlocks34, eCBlocks31 });
    eCBlocks32 = new ECBlocks(30, new ECB[] { new ECB(17, 115) });
    eCBlocks33 = new ECBlocks(28, new ECB[] { new ECB(10, 46), new ECB(23, 47) });
    ECBlocks eCBlocks35 = new ECBlocks(30, new ECB[] { new ECB(10, 24), new ECB(35, 25) });
    eCBlocks34 = new ECBlocks(30, new ECB[] { new ECB(19, 15), new ECB(35, 16) });
    Version version32 = new Version(32, new int[] { 6, 34, 60, 86, 112, 138 }, new ECBlocks[] { eCBlocks32, eCBlocks33, eCBlocks35, eCBlocks34 });
    eCBlocks34 = new ECBlocks(30, new ECB[] { new ECB(17, 115), new ECB(1, 116) });
    eCBlocks35 = new ECBlocks(28, new ECB[] { new ECB(14, 46), new ECB(21, 47) });
    ECBlocks eCBlocks36 = new ECBlocks(30, new ECB[] { new ECB(29, 24), new ECB(19, 25) });
    eCBlocks33 = new ECBlocks(30, new ECB[] { new ECB(11, 15), new ECB(46, 16) });
    Version version33 = new Version(33, new int[] { 6, 30, 58, 86, 114, 142 }, new ECBlocks[] { eCBlocks34, eCBlocks35, eCBlocks36, eCBlocks33 });
    eCBlocks34 = new ECBlocks(30, new ECB[] { new ECB(13, 115), new ECB(6, 116) });
    ECBlocks eCBlocks37 = new ECBlocks(28, new ECB[] { new ECB(14, 46), new ECB(23, 47) });
    eCBlocks35 = new ECBlocks(30, new ECB[] { new ECB(44, 24), new ECB(7, 25) });
    eCBlocks36 = new ECBlocks(30, new ECB[] { new ECB(59, 16), new ECB(1, 17) });
    Version version34 = new Version(34, new int[] { 6, 34, 62, 90, 118, 146 }, new ECBlocks[] { eCBlocks34, eCBlocks37, eCBlocks35, eCBlocks36 });
    eCBlocks36 = new ECBlocks(30, new ECB[] { new ECB(12, 121), new ECB(7, 122) });
    eCBlocks37 = new ECBlocks(28, new ECB[] { new ECB(12, 47), new ECB(26, 48) });
    eCBlocks35 = new ECBlocks(30, new ECB[] { new ECB(39, 24), new ECB(14, 25) });
    ECBlocks eCBlocks38 = new ECBlocks(30, new ECB[] { new ECB(22, 15), new ECB(41, 16) });
    Version version35 = new Version(35, new int[] { 6, 30, 54, 78, 102, 126, 150 }, new ECBlocks[] { eCBlocks36, eCBlocks37, eCBlocks35, eCBlocks38 });
    eCBlocks37 = new ECBlocks(30, new ECB[] { new ECB(6, 121), new ECB(14, 122) });
    ECBlocks eCBlocks39 = new ECBlocks(28, new ECB[] { new ECB(6, 47), new ECB(34, 48) });
    eCBlocks38 = new ECBlocks(30, new ECB[] { new ECB(46, 24), new ECB(10, 25) });
    eCBlocks36 = new ECBlocks(30, new ECB[] { new ECB(2, 15), new ECB(64, 16) });
    Version version36 = new Version(36, new int[] { 6, 24, 50, 76, 102, 128, 154 }, new ECBlocks[] { eCBlocks37, eCBlocks39, eCBlocks38, eCBlocks36 });
    eCBlocks39 = new ECBlocks(30, new ECB[] { new ECB(17, 122), new ECB(4, 123) });
    eCBlocks37 = new ECBlocks(28, new ECB[] { new ECB(29, 46), new ECB(14, 47) });
    eCBlocks38 = new ECBlocks(30, new ECB[] { new ECB(49, 24), new ECB(10, 25) });
    ECBlocks eCBlocks40 = new ECBlocks(30, new ECB[] { new ECB(24, 15), new ECB(46, 16) });
    Version version37 = new Version(37, new int[] { 6, 28, 54, 80, 106, 132, 158 }, new ECBlocks[] { eCBlocks39, eCBlocks37, eCBlocks38, eCBlocks40 });
    eCBlocks40 = new ECBlocks(30, new ECB[] { new ECB(4, 122), new ECB(18, 123) });
    eCBlocks38 = new ECBlocks(28, new ECB[] { new ECB(13, 46), new ECB(32, 47) });
    eCBlocks39 = new ECBlocks(30, new ECB[] { new ECB(48, 24), new ECB(14, 25) });
    ECBlocks eCBlocks41 = new ECBlocks(30, new ECB[] { new ECB(42, 15), new ECB(32, 16) });
    Version version38 = new Version(38, new int[] { 6, 32, 58, 84, 110, 136, 162 }, new ECBlocks[] { eCBlocks40, eCBlocks38, eCBlocks39, eCBlocks41 });
    ECBlocks eCBlocks42 = new ECBlocks(30, new ECB[] { new ECB(20, 117), new ECB(4, 118) });
    eCBlocks40 = new ECBlocks(28, new ECB[] { new ECB(40, 47), new ECB(7, 48) });
    eCBlocks39 = new ECBlocks(30, new ECB[] { new ECB(43, 24), new ECB(22, 25) });
    eCBlocks41 = new ECBlocks(30, new ECB[] { new ECB(10, 15), new ECB(67, 16) });
    Version version39 = new Version(39, new int[] { 6, 26, 54, 82, 110, 138, 166 }, new ECBlocks[] { eCBlocks42, eCBlocks40, eCBlocks39, eCBlocks41 });
    eCBlocks42 = new ECBlocks(30, new ECB[] { new ECB(19, 118), new ECB(6, 119) });
    eCBlocks41 = new ECBlocks(28, new ECB[] { new ECB(18, 47), new ECB(31, 48) });
    ECBlocks eCBlocks43 = new ECBlocks(30, new ECB[] { new ECB(34, 24), new ECB(34, 25) });
    eCBlocks39 = new ECBlocks(30, new ECB[] { new ECB(20, 15), new ECB(61, 16) });
    return new Version[] { 
        version1, version4, version3, version2, version5, version6, version7, version8, version9, version10, 
        version11, version12, version13, version14, version15, version16, version17, version18, version19, version20, 
        version21, version22, version23, version24, version25, version26, version27, version28, version29, version30, 
        version31, version32, version33, version34, version35, version36, version37, version38, version39, new Version(40, new int[] { 6, 30, 58, 86, 114, 142, 170 }, new ECBlocks[] { eCBlocks42, eCBlocks41, eCBlocks43, eCBlocks39 }) };
  }
  
  static Version decodeVersionInformation(int paramInt) {
    byte b = 0;
    int i = Integer.MAX_VALUE;
    int j = 0;
    while (b < VERSION_DECODE_INFO.length) {
      int k = VERSION_DECODE_INFO[b];
      if (k == paramInt)
        return getVersionForNumber(b + 7); 
      int m = FormatInformation.numBitsDiffering(paramInt, k);
      k = i;
      if (m < i) {
        j = b + 7;
        k = m;
      } 
      b++;
      i = k;
    } 
    return (i <= 3) ? getVersionForNumber(j) : null;
  }
  
  public static Version getProvisionalVersionForDimension(int paramInt) throws FormatException {
    if (paramInt % 4 == 1)
      try {
        return getVersionForNumber((paramInt - 17) / 4);
      } catch (IllegalArgumentException illegalArgumentException) {
        throw FormatException.getFormatInstance();
      }  
    throw FormatException.getFormatInstance();
  }
  
  public static Version getVersionForNumber(int paramInt) {
    if (paramInt > 0 && paramInt <= 40)
      return VERSIONS[paramInt - 1]; 
    throw new IllegalArgumentException();
  }
  
  BitMatrix buildFunctionPattern() {
    int i = getDimensionForVersion();
    BitMatrix bitMatrix = new BitMatrix(i);
    bitMatrix.setRegion(0, 0, 9, 9);
    int j = i - 8;
    bitMatrix.setRegion(j, 0, 8, 9);
    bitMatrix.setRegion(0, j, 9, 8);
    int k = this.alignmentPatternCenters.length;
    for (j = 0; j < k; j++) {
      int m = this.alignmentPatternCenters[j];
      for (byte b = 0; b < k; b++) {
        if ((j != 0 || (b != 0 && b != k - 1)) && (j != k - 1 || b != 0))
          bitMatrix.setRegion(this.alignmentPatternCenters[b] - 2, m - 2, 5, 5); 
      } 
    } 
    j = i - 17;
    bitMatrix.setRegion(6, 9, 1, j);
    bitMatrix.setRegion(9, 6, j, 1);
    if (this.versionNumber > 6) {
      j = i - 11;
      bitMatrix.setRegion(j, 0, 3, 6);
      bitMatrix.setRegion(0, j, 6, 3);
    } 
    return bitMatrix;
  }
  
  public int[] getAlignmentPatternCenters() {
    return this.alignmentPatternCenters;
  }
  
  public int getDimensionForVersion() {
    return this.versionNumber * 4 + 17;
  }
  
  public ECBlocks getECBlocksForLevel(ErrorCorrectionLevel paramErrorCorrectionLevel) {
    return this.ecBlocks[paramErrorCorrectionLevel.ordinal()];
  }
  
  public int getTotalCodewords() {
    return this.totalCodewords;
  }
  
  public int getVersionNumber() {
    return this.versionNumber;
  }
  
  public String toString() {
    return String.valueOf(this.versionNumber);
  }
  
  public static final class ECB {
    private final int count;
    
    private final int dataCodewords;
    
    ECB(int param1Int1, int param1Int2) {
      this.count = param1Int1;
      this.dataCodewords = param1Int2;
    }
    
    public int getCount() {
      return this.count;
    }
    
    public int getDataCodewords() {
      return this.dataCodewords;
    }
  }
  
  public static final class ECBlocks {
    private final Version.ECB[] ecBlocks;
    
    private final int ecCodewordsPerBlock;
    
    ECBlocks(int param1Int, Version.ECB... param1VarArgs) {
      this.ecCodewordsPerBlock = param1Int;
      this.ecBlocks = param1VarArgs;
    }
    
    public Version.ECB[] getECBlocks() {
      return this.ecBlocks;
    }
    
    public int getECCodewordsPerBlock() {
      return this.ecCodewordsPerBlock;
    }
    
    public int getNumBlocks() {
      Version.ECB[] arrayOfECB = this.ecBlocks;
      int i = arrayOfECB.length;
      byte b = 0;
      int j = 0;
      while (b < i) {
        j += arrayOfECB[b].getCount();
        b++;
      } 
      return j;
    }
    
    public int getTotalECCodewords() {
      return this.ecCodewordsPerBlock * getNumBlocks();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\decoder\Version.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */