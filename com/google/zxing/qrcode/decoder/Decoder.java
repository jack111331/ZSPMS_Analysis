package com.google.zxing.qrcode.decoder;

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
  private final ReedSolomonDecoder rsDecoder = new ReedSolomonDecoder(GenericGF.QR_CODE_FIELD_256);
  
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
  
  private DecoderResult decode(BitMatrixParser paramBitMatrixParser, Map<DecodeHintType, ?> paramMap) throws FormatException, ChecksumException {
    Version version = paramBitMatrixParser.readVersion();
    ErrorCorrectionLevel errorCorrectionLevel = paramBitMatrixParser.readFormatInformation().getErrorCorrectionLevel();
    DataBlock[] arrayOfDataBlock = DataBlock.getDataBlocks(paramBitMatrixParser.readCodewords(), version, errorCorrectionLevel);
    int i = arrayOfDataBlock.length;
    byte b = 0;
    int j = 0;
    while (b < i) {
      j += arrayOfDataBlock[b].getNumDataCodewords();
      b++;
    } 
    byte[] arrayOfByte = new byte[j];
    int k = arrayOfDataBlock.length;
    j = 0;
    b = 0;
    while (j < k) {
      DataBlock dataBlock = arrayOfDataBlock[j];
      byte[] arrayOfByte1 = dataBlock.getCodewords();
      int m = dataBlock.getNumDataCodewords();
      correctErrors(arrayOfByte1, m);
      i = 0;
      while (i < m) {
        arrayOfByte[b] = (byte)arrayOfByte1[i];
        i++;
        b++;
      } 
      j++;
    } 
    return DecodedBitStreamParser.decode(arrayOfByte, version, errorCorrectionLevel, paramMap);
  }
  
  public DecoderResult decode(BitMatrix paramBitMatrix) throws ChecksumException, FormatException {
    return decode(paramBitMatrix, (Map<DecodeHintType, ?>)null);
  }
  
  public DecoderResult decode(BitMatrix paramBitMatrix, Map<DecodeHintType, ?> paramMap) throws FormatException, ChecksumException {
    BitMatrixParser bitMatrixParser = new BitMatrixParser(paramBitMatrix);
    paramBitMatrix = null;
    try {
      return decode(bitMatrixParser, paramMap);
    } catch (FormatException formatException) {
      checksumException = null;
    } catch (ChecksumException checksumException) {}
    try {
      bitMatrixParser.remask();
      bitMatrixParser.setMirror(true);
      bitMatrixParser.readVersion();
      bitMatrixParser.readFormatInformation();
      bitMatrixParser.mirror();
      DecoderResult decoderResult = decode(bitMatrixParser, paramMap);
      QRCodeDecoderMetaData qRCodeDecoderMetaData = new QRCodeDecoderMetaData();
      this(true);
      decoderResult.setOther(qRCodeDecoderMetaData);
      return decoderResult;
    } catch (FormatException|ChecksumException formatException1) {
      if (formatException != null)
        throw formatException; 
      throw checksumException;
    } 
  }
  
  public DecoderResult decode(boolean[][] paramArrayOfboolean) throws ChecksumException, FormatException {
    return decode(paramArrayOfboolean, (Map<DecodeHintType, ?>)null);
  }
  
  public DecoderResult decode(boolean[][] paramArrayOfboolean, Map<DecodeHintType, ?> paramMap) throws ChecksumException, FormatException {
    return decode(BitMatrix.parse(paramArrayOfboolean), paramMap);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\decoder\Decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */