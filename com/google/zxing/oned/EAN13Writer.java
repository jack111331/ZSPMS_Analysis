package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class EAN13Writer extends UPCEANWriter {
  private static final int CODE_WIDTH = 95;
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap) throws WriterException {
    if (paramBarcodeFormat == BarcodeFormat.EAN_13)
      return super.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap); 
    throw new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(paramBarcodeFormat)));
  }
  
  public boolean[] encode(String paramString) {
    int i = paramString.length();
    switch (i) {
      default:
        throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got ".concat(String.valueOf(i)));
      case 13:
        try {
          if (UPCEANReader.checkStandardUPCEANChecksum(paramString))
            break; 
          IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
          this("Contents do not pass checksum");
          throw illegalArgumentException;
        } catch (FormatException null) {
          throw new IllegalArgumentException("Illegal contents");
        } 
      case 12:
        try {
          i = UPCEANReader.getStandardUPCEANChecksum((CharSequence)formatException);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append((String)formatException);
          stringBuilder.append(i);
          String str = stringBuilder.toString();
        } catch (FormatException formatException) {
          throw new IllegalArgumentException(formatException);
        } 
        break;
    } 
    i = Character.digit(formatException.charAt(0), 10);
    int j = EAN13Reader.FIRST_DIGIT_ENCODINGS[i];
    boolean[] arrayOfBoolean = new boolean[95];
    int k = appendPattern(arrayOfBoolean, 0, UPCEANReader.START_END_PATTERN, true) + 0;
    for (i = 1; i <= 6; i++) {
      int m = Character.digit(formatException.charAt(i), 10);
      int n = m;
      if ((j >> 6 - i & 0x1) == 1)
        n = m + 10; 
      k += appendPattern(arrayOfBoolean, k, UPCEANReader.L_AND_G_PATTERNS[n], false);
    } 
    i = k + appendPattern(arrayOfBoolean, k, UPCEANReader.MIDDLE_PATTERN, false);
    for (k = 7; k <= 12; k++) {
      int m = Character.digit(formatException.charAt(k), 10);
      i += appendPattern(arrayOfBoolean, i, UPCEANReader.L_PATTERNS[m], true);
    } 
    appendPattern(arrayOfBoolean, i, UPCEANReader.START_END_PATTERN, true);
    return arrayOfBoolean;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\EAN13Writer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */