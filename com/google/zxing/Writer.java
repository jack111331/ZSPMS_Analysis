package com.google.zxing;

import com.google.zxing.common.BitMatrix;
import java.util.Map;

public interface Writer {
  BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2) throws WriterException;
  
  BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap) throws WriterException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\Writer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */