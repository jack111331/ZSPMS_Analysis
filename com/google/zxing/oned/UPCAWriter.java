package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class UPCAWriter implements Writer {
  private final EAN13Writer subWriter = new EAN13Writer();
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2) throws WriterException {
    return encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, null);
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap) throws WriterException {
    if (paramBarcodeFormat == BarcodeFormat.UPC_A)
      return this.subWriter.encode("0".concat(String.valueOf(paramString)), BarcodeFormat.EAN_13, paramInt1, paramInt2, paramMap); 
    throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(paramBarcodeFormat)));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\UPCAWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */