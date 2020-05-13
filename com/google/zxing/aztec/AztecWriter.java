package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.aztec.encoder.AztecCode;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.common.BitMatrix;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public final class AztecWriter implements Writer {
  private static BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Charset paramCharset, int paramInt3, int paramInt4) {
    if (paramBarcodeFormat == BarcodeFormat.AZTEC)
      return renderResult(Encoder.encode(paramString.getBytes(paramCharset), paramInt3, paramInt4), paramInt1, paramInt2); 
    throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(paramBarcodeFormat)));
  }
  
  private static BitMatrix renderResult(AztecCode paramAztecCode, int paramInt1, int paramInt2) {
    BitMatrix bitMatrix = paramAztecCode.getMatrix();
    if (bitMatrix != null) {
      int i = bitMatrix.getWidth();
      int j = bitMatrix.getHeight();
      paramInt1 = Math.max(paramInt1, i);
      int k = Math.max(paramInt2, j);
      int m = Math.min(paramInt1 / i, k / j);
      int n = (paramInt1 - i * m) / 2;
      paramInt2 = (k - j * m) / 2;
      BitMatrix bitMatrix1 = new BitMatrix(paramInt1, k);
      paramInt1 = 0;
      while (paramInt1 < j) {
        k = n;
        byte b = 0;
        while (b < i) {
          if (bitMatrix.get(b, paramInt1))
            bitMatrix1.setRegion(k, paramInt2, m, m); 
          b++;
          k += m;
        } 
        paramInt1++;
        paramInt2 += m;
      } 
      return bitMatrix1;
    } 
    throw new IllegalStateException();
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2) {
    return encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, null);
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap) {
    Charset charset1;
    boolean bool;
    Charset charset2 = StandardCharsets.ISO_8859_1;
    int i = 33;
    if (paramMap != null) {
      if (paramMap.containsKey(EncodeHintType.CHARACTER_SET))
        charset2 = Charset.forName(paramMap.get(EncodeHintType.CHARACTER_SET).toString()); 
      if (paramMap.containsKey(EncodeHintType.ERROR_CORRECTION))
        i = Integer.parseInt(paramMap.get(EncodeHintType.ERROR_CORRECTION).toString()); 
      if (paramMap.containsKey(EncodeHintType.AZTEC_LAYERS)) {
        bool = Integer.parseInt(paramMap.get(EncodeHintType.AZTEC_LAYERS).toString());
        charset1 = charset2;
      } else {
        charset1 = charset2;
        bool = false;
      } 
    } else {
      charset1 = charset2;
      i = 33;
      bool = false;
    } 
    return encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, charset1, i, bool);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\aztec\AztecWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */