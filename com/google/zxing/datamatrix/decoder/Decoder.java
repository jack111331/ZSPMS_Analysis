package com.google.zxing.datamatrix.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

public final class Decoder {
  private final ReedSolomonDecoder rsDecoder = new ReedSolomonDecoder(GenericGF.DATA_MATRIX_FIELD_256);
  
  private void correctErrors(byte[] paramArrayOfbyte, int paramInt) throws ChecksumException {
    int i = paramArrayOfbyte.length;
    int[] arrayOfInt = new int[i];
    boolean bool = false;
    byte b;
    for (b = 0; b < i; b++)
      arrayOfInt[b] = paramArrayOfbyte[b] & 0xFF; 
    try {
      this.rsDecoder.decode(arrayOfInt, paramArrayOfbyte.length - paramInt);
      for (b = bool; b < paramInt; b++)
        paramArrayOfbyte[b] = (byte)(byte)arrayOfInt[b]; 
      return;
    } catch (ReedSolomonException reedSolomonException) {
      throw ChecksumException.getChecksumInstance();
    } 
  }
  
  public DecoderResult decode(BitMatrix paramBitMatrix) throws FormatException, ChecksumException {
    BitMatrixParser bitMatrixParser = new BitMatrixParser(paramBitMatrix);
    Version version = bitMatrixParser.getVersion();
    DataBlock[] arrayOfDataBlock = DataBlock.getDataBlocks(bitMatrixParser.readCodewords(), version);
    int i = arrayOfDataBlock.length;
    byte b = 0;
    int j = 0;
    while (b < i) {
      j += arrayOfDataBlock[b].getNumDataCodewords();
      b++;
    } 
    byte[] arrayOfByte = new byte[j];
    i = arrayOfDataBlock.length;
    for (j = 0; j < i; j++) {
      DataBlock dataBlock = arrayOfDataBlock[j];
      byte[] arrayOfByte1 = dataBlock.getCodewords();
      int k = dataBlock.getNumDataCodewords();
      correctErrors(arrayOfByte1, k);
      for (b = 0; b < k; b++)
        arrayOfByte[b * i + j] = (byte)arrayOfByte1[b]; 
    } 
    return DecodedBitStreamParser.decode(arrayOfByte);
  }
  
  public DecoderResult decode(boolean[][] paramArrayOfboolean) throws FormatException, ChecksumException {
    return decode(BitMatrix.parse(paramArrayOfboolean));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\decoder\Decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */