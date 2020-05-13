package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class UPCEWriter extends UPCEANWriter {
  private static final int CODE_WIDTH = 51;
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap) throws WriterException {
    if (paramBarcodeFormat == BarcodeFormat.UPC_E)
      return super.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap); 
    throw new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(paramBarcodeFormat)));
  }
  
  public boolean[] encode(String paramString) {
    int i = paramString.length();
    switch (i) {
      default:
        throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(i)));
      case 8:
        try {
          if (UPCEANReader.checkStandardUPCEANChecksum(paramString))
            break; 
          IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
          this("Contents do not pass checksum");
          throw illegalArgumentException;
        } catch (FormatException null) {
          throw new IllegalArgumentException("Illegal contents");
        } 
      case 7:
        try {
          i = UPCEANReader.getStandardUPCEANChecksum(UPCEReader.convertUPCEtoUPCA((String)formatException));
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append((String)formatException);
          stringBuilder.append(i);
          String str = stringBuilder.toString();
        } catch (FormatException formatException) {
          throw new IllegalArgumentException(formatException);
        } 
        break;
    } 
    int j = Character.digit(formatException.charAt(0), 10);
    if (j == 0 || j == 1) {
      i = Character.digit(formatException.charAt(7), 10);
      int k = UPCEReader.NUMSYS_AND_CHECK_DIGIT_PATTERNS[j][i];
      boolean[] arrayOfBoolean = new boolean[51];
      j = appendPattern(arrayOfBoolean, 0, UPCEANReader.START_END_PATTERN, true) + 0;
      for (i = 1; i <= 6; i++) {
        int m = Character.digit(formatException.charAt(i), 10);
        int n = m;
        if ((k >> 6 - i & 0x1) == 1)
          n = m + 10; 
        j += appendPattern(arrayOfBoolean, j, UPCEANReader.L_AND_G_PATTERNS[n], false);
      } 
      appendPattern(arrayOfBoolean, j, UPCEANReader.END_PATTERN, false);
      return arrayOfBoolean;
    } 
    throw new IllegalArgumentException("Number system must be 0 or 1");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\UPCEWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */