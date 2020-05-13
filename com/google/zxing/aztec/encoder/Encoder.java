package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

public final class Encoder {
  public static final int DEFAULT_AZTEC_LAYERS = 0;
  
  public static final int DEFAULT_EC_PERCENT = 33;
  
  private static final int MAX_NB_BITS = 32;
  
  private static final int MAX_NB_BITS_COMPACT = 4;
  
  private static final int[] WORD_SIZE = new int[] { 
      4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 
      10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 
      10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 
      12, 12, 12 };
  
  private static int[] bitsToWords(BitArray paramBitArray, int paramInt1, int paramInt2) {
    int[] arrayOfInt = new int[paramInt2];
    int i = paramBitArray.getSize() / paramInt1;
    for (paramInt2 = 0; paramInt2 < i; paramInt2++) {
      byte b = 0;
      int j = 0;
      while (b < paramInt1) {
        byte b1;
        if (paramBitArray.get(paramInt2 * paramInt1 + b)) {
          b1 = 1 << paramInt1 - b - 1;
        } else {
          b1 = 0;
        } 
        j |= b1;
        b++;
      } 
      arrayOfInt[paramInt2] = j;
    } 
    return arrayOfInt;
  }
  
  private static void drawBullsEye(BitMatrix paramBitMatrix, int paramInt1, int paramInt2) {
    int i = 0;
    while (i < paramInt2) {
      int k = paramInt1 - i;
      int m = k;
      while (true) {
        int n = paramInt1 + i;
        if (m <= n) {
          paramBitMatrix.set(m, k);
          paramBitMatrix.set(m, n);
          paramBitMatrix.set(k, m);
          paramBitMatrix.set(n, m);
          m++;
          continue;
        } 
        i += 2;
      } 
    } 
    i = paramInt1 - paramInt2;
    paramBitMatrix.set(i, i);
    int j = i + 1;
    paramBitMatrix.set(j, i);
    paramBitMatrix.set(i, j);
    paramInt1 += paramInt2;
    paramBitMatrix.set(paramInt1, i);
    paramBitMatrix.set(paramInt1, j);
    paramBitMatrix.set(paramInt1, paramInt1 - 1);
  }
  
  private static void drawModeMessage(BitMatrix paramBitMatrix, boolean paramBoolean, int paramInt, BitArray paramBitArray) {
    int i = paramInt / 2;
    paramInt = 0;
    int j = 0;
    if (paramBoolean) {
      for (paramInt = j; paramInt < 7; paramInt++) {
        j = i - 3 + paramInt;
        if (paramBitArray.get(paramInt))
          paramBitMatrix.set(j, i - 5); 
        if (paramBitArray.get(paramInt + 7))
          paramBitMatrix.set(i + 5, j); 
        if (paramBitArray.get(20 - paramInt))
          paramBitMatrix.set(j, i + 5); 
        if (paramBitArray.get(27 - paramInt))
          paramBitMatrix.set(i - 5, j); 
      } 
      return;
    } 
    while (paramInt < 10) {
      j = i - 5 + paramInt + paramInt / 5;
      if (paramBitArray.get(paramInt))
        paramBitMatrix.set(j, i - 7); 
      if (paramBitArray.get(paramInt + 10))
        paramBitMatrix.set(i + 7, j); 
      if (paramBitArray.get(29 - paramInt))
        paramBitMatrix.set(j, i + 7); 
      if (paramBitArray.get(39 - paramInt))
        paramBitMatrix.set(i - 7, j); 
      paramInt++;
    } 
  }
  
  public static AztecCode encode(byte[] paramArrayOfbyte) {
    return encode(paramArrayOfbyte, 33, 0);
  }
  
  public static AztecCode encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    BitArray bitArray1;
    int k;
    boolean bool;
    BitArray bitArray2 = (new HighLevelEncoder(paramArrayOfbyte)).encode();
    paramInt1 = bitArray2.getSize() * paramInt1 / 100;
    byte b = 11;
    int i = paramInt1 + 11;
    int j = bitArray2.getSize();
    paramInt1 = 32;
    if (paramInt2 != 0) {
      boolean bool1;
      if (paramInt2 < 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      int m = Math.abs(paramInt2);
      if (bool1)
        paramInt1 = 4; 
      if (m <= paramInt1) {
        j = totalBitsInLayer(m, bool1);
        int n = WORD_SIZE[m];
        BitArray bitArray = stuffBits(bitArray2, n);
        if (bitArray.getSize() + i <= j - j % n) {
          k = j;
          bitArray1 = bitArray;
          bool = bool1;
          paramInt2 = n;
          paramInt1 = m;
          if (bool1)
            if (bitArray.getSize() <= n << 6) {
              k = j;
              bitArray1 = bitArray;
              bool = bool1;
              paramInt2 = n;
              paramInt1 = m;
            } else {
              throw new IllegalArgumentException("Data to large for user specified layer");
            }  
        } else {
          throw new IllegalArgumentException("Data to large for user specified layer");
        } 
      } else {
        throw new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[] { Integer.valueOf(paramInt2) }));
      } 
    } else {
      paramArrayOfbyte = null;
      paramInt2 = 0;
      for (paramInt1 = 0; paramInt2 <= 32; paramInt1 = m) {
        boolean bool1;
        BitArray bitArray;
        if (paramInt2 <= 3) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (bool1) {
          k = paramInt2 + 1;
        } else {
          k = paramInt2;
        } 
        int n = totalBitsInLayer(k, bool1);
        byte[] arrayOfByte = paramArrayOfbyte;
        int m = paramInt1;
        if (j + i <= n) {
          BitArray bitArray4;
          if (paramArrayOfbyte == null || paramInt1 != WORD_SIZE[k]) {
            paramInt1 = WORD_SIZE[k];
            bitArray4 = stuffBits(bitArray2, paramInt1);
          } 
          if ((bool1 && bitArray4.getSize() > paramInt1 << 6) || bitArray4.getSize() + i > n - n % paramInt1) {
            bitArray = bitArray4;
            m = paramInt1;
          } else {
            paramInt2 = paramInt1;
            paramInt1 = k;
            k = n;
            bool = bool1;
            bitArray = generateCheckWords(bitArray4, k, paramInt2);
            i = bitArray4.getSize() / paramInt2;
            bitArray2 = generateModeMessage(bool, paramInt1, i);
          } 
        } 
        paramInt2++;
        bitArray1 = bitArray;
      } 
      throw new IllegalArgumentException("Data too large for an Aztec code");
    } 
    BitArray bitArray3 = generateCheckWords(bitArray1, k, paramInt2);
    i = bitArray1.getSize() / paramInt2;
    bitArray2 = generateModeMessage(bool, paramInt1, i);
  }
  
  private static BitArray generateCheckWords(BitArray paramBitArray, int paramInt1, int paramInt2) {
    int i = paramBitArray.getSize() / paramInt2;
    ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(paramInt2));
    int j = paramInt1 / paramInt2;
    int[] arrayOfInt = bitsToWords(paramBitArray, paramInt2, j);
    reedSolomonEncoder.encode(arrayOfInt, j - i);
    BitArray bitArray = new BitArray();
    i = 0;
    bitArray.appendBits(0, paramInt1 % paramInt2);
    j = arrayOfInt.length;
    for (paramInt1 = i; paramInt1 < j; paramInt1++)
      bitArray.appendBits(arrayOfInt[paramInt1], paramInt2); 
    return bitArray;
  }
  
  static BitArray generateModeMessage(boolean paramBoolean, int paramInt1, int paramInt2) {
    BitArray bitArray = new BitArray();
    if (paramBoolean) {
      bitArray.appendBits(paramInt1 - 1, 2);
      bitArray.appendBits(paramInt2 - 1, 6);
      bitArray = generateCheckWords(bitArray, 28, 4);
    } else {
      bitArray.appendBits(paramInt1 - 1, 5);
      bitArray.appendBits(paramInt2 - 1, 11);
      bitArray = generateCheckWords(bitArray, 40, 4);
    } 
    return bitArray;
  }
  
  private static GenericGF getGF(int paramInt) {
    if (paramInt != 4) {
      if (paramInt != 6) {
        if (paramInt != 8) {
          if (paramInt != 10) {
            if (paramInt == 12)
              return GenericGF.AZTEC_DATA_12; 
            throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(paramInt)));
          } 
          return GenericGF.AZTEC_DATA_10;
        } 
        return GenericGF.AZTEC_DATA_8;
      } 
      return GenericGF.AZTEC_DATA_6;
    } 
    return GenericGF.AZTEC_PARAM;
  }
  
  static BitArray stuffBits(BitArray paramBitArray, int paramInt) {
    // Byte code:
    //   0: new com/google/zxing/common/BitArray
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual getSize : ()I
    //   12: istore_3
    //   13: iconst_1
    //   14: iload_1
    //   15: ishl
    //   16: iconst_2
    //   17: isub
    //   18: istore #4
    //   20: iconst_0
    //   21: istore #5
    //   23: iload #5
    //   25: iload_3
    //   26: if_icmpge -> 153
    //   29: iconst_0
    //   30: istore #6
    //   32: iconst_0
    //   33: istore #7
    //   35: iload #6
    //   37: iload_1
    //   38: if_icmpge -> 90
    //   41: iload #5
    //   43: iload #6
    //   45: iadd
    //   46: istore #8
    //   48: iload #8
    //   50: iload_3
    //   51: if_icmpge -> 67
    //   54: iload #7
    //   56: istore #9
    //   58: aload_0
    //   59: iload #8
    //   61: invokevirtual get : (I)Z
    //   64: ifeq -> 80
    //   67: iload #7
    //   69: iconst_1
    //   70: iload_1
    //   71: iconst_1
    //   72: isub
    //   73: iload #6
    //   75: isub
    //   76: ishl
    //   77: ior
    //   78: istore #9
    //   80: iinc #6, 1
    //   83: iload #9
    //   85: istore #7
    //   87: goto -> 35
    //   90: iload #7
    //   92: iload #4
    //   94: iand
    //   95: istore #9
    //   97: iload #9
    //   99: iload #4
    //   101: if_icmpne -> 117
    //   104: aload_2
    //   105: iload #9
    //   107: iload_1
    //   108: invokevirtual appendBits : (II)V
    //   111: iinc #5, -1
    //   114: goto -> 144
    //   117: iload #9
    //   119: ifne -> 137
    //   122: aload_2
    //   123: iload #7
    //   125: iconst_1
    //   126: ior
    //   127: iload_1
    //   128: invokevirtual appendBits : (II)V
    //   131: iinc #5, -1
    //   134: goto -> 144
    //   137: aload_2
    //   138: iload #7
    //   140: iload_1
    //   141: invokevirtual appendBits : (II)V
    //   144: iload #5
    //   146: iload_1
    //   147: iadd
    //   148: istore #5
    //   150: goto -> 23
    //   153: aload_2
    //   154: areturn
  }
  
  private static int totalBitsInLayer(int paramInt, boolean paramBoolean) {
    byte b;
    if (paramBoolean) {
      b = 88;
    } else {
      b = 112;
    } 
    return (b + (paramInt << 4)) * paramInt;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\aztec\encoder\Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */