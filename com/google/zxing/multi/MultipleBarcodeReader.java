package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Map;

public interface MultipleBarcodeReader {
  Result[] decodeMultiple(BinaryBitmap paramBinaryBitmap) throws NotFoundException;
  
  Result[] decodeMultiple(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\multi\MultipleBarcodeReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */