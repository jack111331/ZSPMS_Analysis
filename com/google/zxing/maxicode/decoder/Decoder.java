package com.google.zxing.maxicode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

public final class Decoder {
  private static final int ALL = 0;
  
  private static final int EVEN = 1;
  
  private static final int ODD = 2;
  
  private final ReedSolomonDecoder rsDecoder = new ReedSolomonDecoder(GenericGF.MAXICODE_FIELD_64);
  
  private void correctErrors(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4) throws ChecksumException {
    byte b1;
    int i = paramInt2 + paramInt3;
    if (paramInt4 == 0) {
      b1 = 1;
    } else {
      b1 = 2;
    } 
    int[] arrayOfInt = new int[i / b1];
    boolean bool = false;
    for (byte b2 = 0; b2 < i; b2++) {
      if (paramInt4 == 0 || b2 % 2 == paramInt4 - 1)
        arrayOfInt[b2 / b1] = paramArrayOfbyte[b2 + paramInt1] & 0xFF; 
    } 
    try {
      this.rsDecoder.decode(arrayOfInt, paramInt3 / b1);
      for (paramInt3 = bool; paramInt3 < paramInt2; paramInt3++) {
        if (paramInt4 == 0 || paramInt3 % 2 == paramInt4 - 1)
          paramArrayOfbyte[paramInt3 + paramInt1] = (byte)(byte)arrayOfInt[paramInt3 / b1]; 
      } 
      return;
    } catch (ReedSolomonException reedSolomonException) {
      throw ChecksumException.getChecksumInstance();
    } 
  }
  
  public DecoderResult decode(BitMatrix paramBitMatrix) throws ChecksumException, FormatException {
    return decode(paramBitMatrix, null);
  }
  
  public DecoderResult decode(BitMatrix paramBitMatrix, Map<DecodeHintType, ?> paramMap) throws FormatException, ChecksumException {
    byte[] arrayOfByte2 = (new BitMatrixParser(paramBitMatrix)).readCodewords();
    correctErrors(arrayOfByte2, 0, 10, 10, 0);
    int i = arrayOfByte2[0] & 0xF;
    switch (i) {
      default:
        throw FormatException.getFormatInstance();
      case 5:
        correctErrors(arrayOfByte2, 20, 68, 56, 1);
        correctErrors(arrayOfByte2, 20, 68, 56, 2);
        arrayOfByte1 = new byte[78];
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 10);
        System.arraycopy(arrayOfByte2, 20, arrayOfByte1, 10, arrayOfByte1.length - 10);
        return DecodedBitStreamParser.decode(arrayOfByte1, i);
      case 2:
      case 3:
      case 4:
        break;
    } 
    correctErrors(arrayOfByte2, 20, 84, 40, 1);
    correctErrors(arrayOfByte2, 20, 84, 40, 2);
    byte[] arrayOfByte1 = new byte[94];
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 10);
    System.arraycopy(arrayOfByte2, 20, arrayOfByte1, 10, arrayOfByte1.length - 10);
    return DecodedBitStreamParser.decode(arrayOfByte1, i);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\maxicode\decoder\Decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */