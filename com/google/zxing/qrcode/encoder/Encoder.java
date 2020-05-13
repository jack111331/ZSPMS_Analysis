package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class Encoder {
  private static final int[] ALPHANUMERIC_TABLE = new int[] { 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, 
      -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 
      2, 3, 4, 5, 6, 7, 8, 9, 44, -1, 
      -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 
      15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
      25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 
      35, -1, -1, -1, -1, -1 };
  
  static final String DEFAULT_BYTE_MODE_ENCODING = "ISO-8859-1";
  
  static void append8BitBytes(String paramString1, BitArray paramBitArray, String paramString2) throws WriterException {
    try {
      byte[] arrayOfByte = paramString1.getBytes(paramString2);
      int i = arrayOfByte.length;
      for (byte b = 0; b < i; b++)
        paramBitArray.appendBits(arrayOfByte[b], 8); 
      return;
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new WriterException(unsupportedEncodingException);
    } 
  }
  
  static void appendAlphanumericBytes(CharSequence paramCharSequence, BitArray paramBitArray) throws WriterException {
    int i = paramCharSequence.length();
    int j = 0;
    while (j < i) {
      int k = getAlphanumericCode(paramCharSequence.charAt(j));
      if (k != -1) {
        int m = j + 1;
        if (m < i) {
          m = getAlphanumericCode(paramCharSequence.charAt(m));
          if (m != -1) {
            paramBitArray.appendBits(k * 45 + m, 11);
            j += 2;
            continue;
          } 
          throw new WriterException();
        } 
        paramBitArray.appendBits(k, 6);
        j = m;
        continue;
      } 
      throw new WriterException();
    } 
  }
  
  static void appendBytes(String paramString1, Mode paramMode, BitArray paramBitArray, String paramString2) throws WriterException {
    switch (paramMode) {
      default:
        throw new WriterException("Invalid mode: ".concat(String.valueOf(paramMode)));
      case KANJI:
        appendKanjiBytes(paramString1, paramBitArray);
        return;
      case BYTE:
        append8BitBytes(paramString1, paramBitArray, paramString2);
        return;
      case ALPHANUMERIC:
        appendAlphanumericBytes(paramString1, paramBitArray);
        return;
      case NUMERIC:
        break;
    } 
    appendNumericBytes(paramString1, paramBitArray);
  }
  
  private static void appendECI(CharacterSetECI paramCharacterSetECI, BitArray paramBitArray) {
    paramBitArray.appendBits(Mode.ECI.getBits(), 4);
    paramBitArray.appendBits(paramCharacterSetECI.getValue(), 8);
  }
  
  static void appendKanjiBytes(String paramString, BitArray paramBitArray) throws WriterException {
    try {
      byte[] arrayOfByte = paramString.getBytes("Shift_JIS");
      int i = arrayOfByte.length;
      byte b = 0;
      while (b < i) {
        int j = (arrayOfByte[b] & 0xFF) << 8 | arrayOfByte[b + 1] & 0xFF;
        if (j >= 33088 && j <= 40956) {
          j -= 33088;
        } else if (j >= 57408 && j <= 60351) {
          j -= 49472;
        } else {
          j = -1;
        } 
        if (j != -1) {
          paramBitArray.appendBits((j >> 8) * 192 + (j & 0xFF), 13);
          b += 2;
          continue;
        } 
        throw new WriterException("Invalid byte sequence");
      } 
      return;
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new WriterException(unsupportedEncodingException);
    } 
  }
  
  static void appendLengthInfo(int paramInt, Version paramVersion, Mode paramMode, BitArray paramBitArray) throws WriterException {
    int i = paramMode.getCharacterCountBits(paramVersion);
    int j = 1 << i;
    if (paramInt < j) {
      paramBitArray.appendBits(paramInt, i);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append(" is bigger than ");
    stringBuilder.append(j - 1);
    throw new WriterException(stringBuilder.toString());
  }
  
  static void appendModeInfo(Mode paramMode, BitArray paramBitArray) {
    paramBitArray.appendBits(paramMode.getBits(), 4);
  }
  
  static void appendNumericBytes(CharSequence paramCharSequence, BitArray paramBitArray) {
    int i = paramCharSequence.length();
    int j = 0;
    while (j < i) {
      int k = paramCharSequence.charAt(j) - 48;
      int m = j + 2;
      if (m < i) {
        paramBitArray.appendBits(k * 100 + (paramCharSequence.charAt(j + 1) - 48) * 10 + paramCharSequence.charAt(m) - 48, 10);
        j += 3;
        continue;
      } 
      if (++j < i) {
        paramBitArray.appendBits(k * 10 + paramCharSequence.charAt(j) - 48, 7);
        j = m;
        continue;
      } 
      paramBitArray.appendBits(k, 4);
    } 
  }
  
  private static int calculateBitsNeeded(Mode paramMode, BitArray paramBitArray1, BitArray paramBitArray2, Version paramVersion) {
    return paramBitArray1.getSize() + paramMode.getCharacterCountBits(paramVersion) + paramBitArray2.getSize();
  }
  
  private static int calculateMaskPenalty(ByteMatrix paramByteMatrix) {
    return MaskUtil.applyMaskPenaltyRule1(paramByteMatrix) + MaskUtil.applyMaskPenaltyRule2(paramByteMatrix) + MaskUtil.applyMaskPenaltyRule3(paramByteMatrix) + MaskUtil.applyMaskPenaltyRule4(paramByteMatrix);
  }
  
  private static int chooseMaskPattern(BitArray paramBitArray, ErrorCorrectionLevel paramErrorCorrectionLevel, Version paramVersion, ByteMatrix paramByteMatrix) throws WriterException {
    int i = Integer.MAX_VALUE;
    byte b = -1;
    byte b1 = 0;
    while (b1 < 8) {
      MatrixUtil.buildMatrix(paramBitArray, paramErrorCorrectionLevel, paramVersion, b1, paramByteMatrix);
      int j = calculateMaskPenalty(paramByteMatrix);
      int k = i;
      if (j < i) {
        b = b1;
        k = j;
      } 
      b1++;
      i = k;
    } 
    return b;
  }
  
  public static Mode chooseMode(String paramString) {
    return chooseMode(paramString, null);
  }
  
  private static Mode chooseMode(String paramString1, String paramString2) {
    if ("Shift_JIS".equals(paramString2) && isOnlyDoubleByteKanji(paramString1))
      return Mode.KANJI; 
    byte b = 0;
    boolean bool1 = false;
    boolean bool2 = false;
    while (b < paramString1.length()) {
      char c = paramString1.charAt(b);
      if (c >= '0' && c <= '9') {
        bool2 = true;
      } else if (getAlphanumericCode(c) != -1) {
        bool1 = true;
      } else {
        return Mode.BYTE;
      } 
      b++;
    } 
    return bool1 ? Mode.ALPHANUMERIC : (bool2 ? Mode.NUMERIC : Mode.BYTE);
  }
  
  private static Version chooseVersion(int paramInt, ErrorCorrectionLevel paramErrorCorrectionLevel) throws WriterException {
    for (byte b = 1; b <= 40; b++) {
      Version version = Version.getVersionForNumber(b);
      if (willFit(paramInt, version, paramErrorCorrectionLevel))
        return version; 
    } 
    throw new WriterException("Data too big");
  }
  
  public static QRCode encode(String paramString, ErrorCorrectionLevel paramErrorCorrectionLevel) throws WriterException {
    return encode(paramString, paramErrorCorrectionLevel, null);
  }
  
  public static QRCode encode(String paramString, ErrorCorrectionLevel paramErrorCorrectionLevel, Map<EncodeHintType, ?> paramMap) throws WriterException {
    Version version;
    String str = "ISO-8859-1";
    byte b = 1;
    if (paramMap != null && paramMap.containsKey(EncodeHintType.CHARACTER_SET)) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i)
      str = paramMap.get(EncodeHintType.CHARACTER_SET).toString(); 
    Mode mode = chooseMode(paramString, str);
    BitArray bitArray3 = new BitArray();
    if (mode == Mode.BYTE && i) {
      CharacterSetECI characterSetECI = CharacterSetECI.getCharacterSetECIByName(str);
      if (characterSetECI != null)
        appendECI(characterSetECI, bitArray3); 
    } 
    if (paramMap != null && paramMap.containsKey(EncodeHintType.GS1_FORMAT)) {
      i = b;
    } else {
      i = 0;
    } 
    if (i && Boolean.valueOf(paramMap.get(EncodeHintType.GS1_FORMAT).toString()).booleanValue())
      appendModeInfo(Mode.FNC1_FIRST_POSITION, bitArray3); 
    appendModeInfo(mode, bitArray3);
    BitArray bitArray4 = new BitArray();
    appendBytes(paramString, mode, bitArray4, str);
    if (paramMap != null && paramMap.containsKey(EncodeHintType.QR_VERSION)) {
      version = Version.getVersionForNumber(Integer.parseInt(paramMap.get(EncodeHintType.QR_VERSION).toString()));
      if (!willFit(calculateBitsNeeded(mode, bitArray3, bitArray4, version), version, paramErrorCorrectionLevel))
        throw new WriterException("Data too big for requested version"); 
    } else {
      version = recommendVersion(paramErrorCorrectionLevel, mode, bitArray3, bitArray4);
    } 
    BitArray bitArray2 = new BitArray();
    bitArray2.appendBitArray(bitArray3);
    if (mode == Mode.BYTE) {
      i = bitArray4.getSizeInBytes();
    } else {
      i = paramString.length();
    } 
    appendLengthInfo(i, version, mode, bitArray2);
    bitArray2.appendBitArray(bitArray4);
    Version.ECBlocks eCBlocks = version.getECBlocksForLevel(paramErrorCorrectionLevel);
    int i = version.getTotalCodewords() - eCBlocks.getTotalECCodewords();
    terminateBits(i, bitArray2);
    BitArray bitArray1 = interleaveWithECBytes(bitArray2, version.getTotalCodewords(), i, eCBlocks.getNumBlocks());
    QRCode qRCode = new QRCode();
    qRCode.setECLevel(paramErrorCorrectionLevel);
    qRCode.setMode(mode);
    qRCode.setVersion(version);
    i = version.getDimensionForVersion();
    ByteMatrix byteMatrix = new ByteMatrix(i, i);
    i = chooseMaskPattern(bitArray1, paramErrorCorrectionLevel, version, byteMatrix);
    qRCode.setMaskPattern(i);
    MatrixUtil.buildMatrix(bitArray1, paramErrorCorrectionLevel, version, i, byteMatrix);
    qRCode.setMatrix(byteMatrix);
    return qRCode;
  }
  
  static byte[] generateECBytes(byte[] paramArrayOfbyte, int paramInt) {
    int i = paramArrayOfbyte.length;
    int[] arrayOfInt = new int[i + paramInt];
    boolean bool = false;
    byte b;
    for (b = 0; b < i; b++)
      arrayOfInt[b] = paramArrayOfbyte[b] & 0xFF; 
    (new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256)).encode(arrayOfInt, paramInt);
    paramArrayOfbyte = new byte[paramInt];
    for (b = bool; b < paramInt; b++)
      paramArrayOfbyte[b] = (byte)(byte)arrayOfInt[i + b]; 
    return paramArrayOfbyte;
  }
  
  static int getAlphanumericCode(int paramInt) {
    return (paramInt < ALPHANUMERIC_TABLE.length) ? ALPHANUMERIC_TABLE[paramInt] : -1;
  }
  
  static void getNumDataBytesAndNumECBytesForBlockID(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint1, int[] paramArrayOfint2) throws WriterException {
    if (paramInt4 < paramInt3) {
      int i = paramInt1 % paramInt3;
      int j = paramInt3 - i;
      int k = paramInt1 / paramInt3;
      int m = paramInt2 / paramInt3;
      paramInt2 = m + 1;
      int n = k - m;
      k = k + 1 - paramInt2;
      if (n == k) {
        if (paramInt3 == j + i) {
          if (paramInt1 == (m + n) * j + (paramInt2 + k) * i) {
            if (paramInt4 < j) {
              paramArrayOfint1[0] = m;
              paramArrayOfint2[0] = n;
              return;
            } 
            paramArrayOfint1[0] = paramInt2;
            paramArrayOfint2[0] = k;
            return;
          } 
          throw new WriterException("Total bytes mismatch");
        } 
        throw new WriterException("RS blocks mismatch");
      } 
      throw new WriterException("EC bytes mismatch");
    } 
    throw new WriterException("Block ID too large");
  }
  
  static BitArray interleaveWithECBytes(BitArray paramBitArray, int paramInt1, int paramInt2, int paramInt3) throws WriterException {
    if (paramBitArray.getSizeInBytes() == paramInt2) {
      ArrayList<BlockPair> arrayList = new ArrayList(paramInt3);
      boolean bool = false;
      byte b = 0;
      int i = 0;
      int j = 0;
      int k = 0;
      while (b < paramInt3) {
        int[] arrayOfInt1 = new int[1];
        int[] arrayOfInt2 = new int[1];
        getNumDataBytesAndNumECBytesForBlockID(paramInt1, paramInt2, paramInt3, b, arrayOfInt1, arrayOfInt2);
        int m = arrayOfInt1[0];
        byte[] arrayOfByte2 = new byte[m];
        paramBitArray.toBytes(i << 3, arrayOfByte2, 0, m);
        byte[] arrayOfByte1 = generateECBytes(arrayOfByte2, arrayOfInt2[0]);
        arrayList.add(new BlockPair(arrayOfByte2, arrayOfByte1));
        j = Math.max(j, m);
        k = Math.max(k, arrayOfByte1.length);
        i += arrayOfInt1[0];
        b++;
      } 
      if (paramInt2 == i) {
        paramBitArray = new BitArray();
        paramInt3 = 0;
        while (true) {
          paramInt2 = bool;
          if (paramInt3 < j) {
            Iterator<BlockPair> iterator = arrayList.iterator();
            while (iterator.hasNext()) {
              byte[] arrayOfByte = ((BlockPair)iterator.next()).getDataBytes();
              if (paramInt3 < arrayOfByte.length)
                paramBitArray.appendBits(arrayOfByte[paramInt3], 8); 
            } 
            paramInt3++;
            continue;
          } 
          break;
        } 
        while (paramInt2 < k) {
          Iterator<BlockPair> iterator = arrayList.iterator();
          while (iterator.hasNext()) {
            byte[] arrayOfByte = ((BlockPair)iterator.next()).getErrorCorrectionBytes();
            if (paramInt2 < arrayOfByte.length)
              paramBitArray.appendBits(arrayOfByte[paramInt2], 8); 
          } 
          paramInt2++;
        } 
        if (paramInt1 == paramBitArray.getSizeInBytes())
          return paramBitArray; 
        StringBuilder stringBuilder = new StringBuilder("Interleaving error: ");
        stringBuilder.append(paramInt1);
        stringBuilder.append(" and ");
        stringBuilder.append(paramBitArray.getSizeInBytes());
        stringBuilder.append(" differ.");
        throw new WriterException(stringBuilder.toString());
      } 
      throw new WriterException("Data bytes does not match offset");
    } 
    throw new WriterException("Number of bits and data bytes does not match");
  }
  
  private static boolean isOnlyDoubleByteKanji(String paramString) {
    try {
      byte[] arrayOfByte = paramString.getBytes("Shift_JIS");
      int i = arrayOfByte.length;
      if (i % 2 != 0)
        return false; 
      for (byte b = 0; b < i; b += 2) {
        int j = arrayOfByte[b] & 0xFF;
        if ((j < 129 || j > 159) && (j < 224 || j > 235))
          return false; 
      } 
      return true;
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      return false;
    } 
  }
  
  private static Version recommendVersion(ErrorCorrectionLevel paramErrorCorrectionLevel, Mode paramMode, BitArray paramBitArray1, BitArray paramBitArray2) throws WriterException {
    return chooseVersion(calculateBitsNeeded(paramMode, paramBitArray1, paramBitArray2, chooseVersion(calculateBitsNeeded(paramMode, paramBitArray1, paramBitArray2, Version.getVersionForNumber(1)), paramErrorCorrectionLevel)), paramErrorCorrectionLevel);
  }
  
  static void terminateBits(int paramInt, BitArray paramBitArray) throws WriterException {
    int i = paramInt << 3;
    if (paramBitArray.getSize() <= i) {
      char c = Character.MIN_VALUE;
      int j;
      for (j = 0; j < 4 && paramBitArray.getSize() < i; j++)
        paramBitArray.appendBit(false); 
      j = paramBitArray.getSize() & 0x7;
      if (j > 0)
        while (j < 8) {
          paramBitArray.appendBit(false);
          j++;
        }  
      int k = paramBitArray.getSizeInBytes();
      for (j = c; j < paramInt - k; j++) {
        if ((j & 0x1) == 0) {
          c = 'ì';
        } else {
          c = '\021';
        } 
        paramBitArray.appendBits(c, 8);
      } 
      if (paramBitArray.getSize() == i)
        return; 
      throw new WriterException("Bits size does not equal capacity");
    } 
    StringBuilder stringBuilder = new StringBuilder("data bits cannot fit in the QR Code");
    stringBuilder.append(paramBitArray.getSize());
    stringBuilder.append(" > ");
    stringBuilder.append(i);
    throw new WriterException(stringBuilder.toString());
  }
  
  private static boolean willFit(int paramInt, Version paramVersion, ErrorCorrectionLevel paramErrorCorrectionLevel) {
    return (paramVersion.getTotalCodewords() - paramVersion.getECBlocksForLevel(paramErrorCorrectionLevel).getTotalECCodewords() >= (paramInt + 7) / 8);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\encoder\Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */