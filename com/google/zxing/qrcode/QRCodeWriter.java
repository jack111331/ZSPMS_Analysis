package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Map;

public final class QRCodeWriter implements Writer {
  private static final int QUIET_ZONE_SIZE = 4;
  
  private static BitMatrix renderResult(QRCode paramQRCode, int paramInt1, int paramInt2, int paramInt3) {
    ByteMatrix byteMatrix = paramQRCode.getMatrix();
    if (byteMatrix != null) {
      int i = byteMatrix.getWidth();
      int j = byteMatrix.getHeight();
      int k = paramInt3 << 1;
      paramInt3 = i + k;
      int m = k + j;
      paramInt1 = Math.max(paramInt1, paramInt3);
      k = Math.max(paramInt2, m);
      int n = Math.min(paramInt1 / paramInt3, k / m);
      m = (paramInt1 - i * n) / 2;
      paramInt2 = (k - j * n) / 2;
      BitMatrix bitMatrix = new BitMatrix(paramInt1, k);
      paramInt1 = 0;
      while (paramInt1 < j) {
        paramInt3 = m;
        k = 0;
        while (k < i) {
          if (byteMatrix.get(k, paramInt1) == 1)
            bitMatrix.setRegion(paramInt3, paramInt2, n, n); 
          k++;
          paramInt3 += n;
        } 
        paramInt1++;
        paramInt2 += n;
      } 
      return bitMatrix;
    } 
    throw new IllegalStateException();
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2) throws WriterException {
    return encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, null);
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap) throws WriterException {
    if (!paramString.isEmpty()) {
      ErrorCorrectionLevel errorCorrectionLevel;
      if (paramBarcodeFormat == BarcodeFormat.QR_CODE) {
        if (paramInt1 >= 0 && paramInt2 >= 0) {
          errorCorrectionLevel = ErrorCorrectionLevel.L;
          byte b = 4;
          int i = b;
          ErrorCorrectionLevel errorCorrectionLevel1 = errorCorrectionLevel;
          if (paramMap != null) {
            if (paramMap.containsKey(EncodeHintType.ERROR_CORRECTION))
              errorCorrectionLevel = ErrorCorrectionLevel.valueOf(paramMap.get(EncodeHintType.ERROR_CORRECTION).toString()); 
            i = b;
            errorCorrectionLevel1 = errorCorrectionLevel;
            if (paramMap.containsKey(EncodeHintType.MARGIN)) {
              i = Integer.parseInt(paramMap.get(EncodeHintType.MARGIN).toString());
              errorCorrectionLevel1 = errorCorrectionLevel;
            } 
          } 
          return renderResult(Encoder.encode(paramString, errorCorrectionLevel1, paramMap), paramInt1, paramInt2, i);
        } 
        StringBuilder stringBuilder = new StringBuilder("Requested dimensions are too small: ");
        stringBuilder.append(paramInt1);
        stringBuilder.append('x');
        stringBuilder.append(paramInt2);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(errorCorrectionLevel)));
    } 
    throw new IllegalArgumentException("Found empty contents");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\QRCodeWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */