package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.Map;

public final class UPCAReader extends UPCEANReader {
  private final UPCEANReader ean13Reader = new EAN13Reader();
  
  private static Result maybeReturnResult(Result paramResult) throws FormatException {
    String str = paramResult.getText();
    if (str.charAt(0) == '0') {
      Result result = new Result(str.substring(1), null, paramResult.getResultPoints(), BarcodeFormat.UPC_A);
      if (paramResult.getResultMetadata() != null)
        result.putAllMetadata(paramResult.getResultMetadata()); 
      return result;
    } 
    throw FormatException.getFormatInstance();
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap) throws NotFoundException, FormatException {
    return maybeReturnResult(this.ean13Reader.decode(paramBinaryBitmap));
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException, FormatException {
    return maybeReturnResult(this.ean13Reader.decode(paramBinaryBitmap, paramMap));
  }
  
  protected int decodeMiddle(BitArray paramBitArray, int[] paramArrayOfint, StringBuilder paramStringBuilder) throws NotFoundException {
    return this.ean13Reader.decodeMiddle(paramBitArray, paramArrayOfint, paramStringBuilder);
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException, FormatException, ChecksumException {
    return maybeReturnResult(this.ean13Reader.decodeRow(paramInt, paramBitArray, paramMap));
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, int[] paramArrayOfint, Map<DecodeHintType, ?> paramMap) throws NotFoundException, FormatException, ChecksumException {
    return maybeReturnResult(this.ean13Reader.decodeRow(paramInt, paramBitArray, paramArrayOfint, paramMap));
  }
  
  BarcodeFormat getBarcodeFormat() {
    return BarcodeFormat.UPC_A;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\UPCAReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */