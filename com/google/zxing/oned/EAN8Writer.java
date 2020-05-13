package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class EAN8Writer extends UPCEANWriter {
  private static final int CODE_WIDTH = 67;
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap) throws WriterException {
    if (paramBarcodeFormat == BarcodeFormat.EAN_8)
      return super.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap); 
    throw new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(paramBarcodeFormat)));
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
    boolean[] arrayOfBoolean = new boolean[67];
    i = appendPattern(arrayOfBoolean, 0, UPCEANReader.START_END_PATTERN, true) + 0;
    byte b;
    for (b = 0; b <= 3; b++) {
      int j = Character.digit(formatException.charAt(b), 10);
      i += appendPattern(arrayOfBoolean, i, UPCEANReader.L_PATTERNS[j], false);
    } 
    i += appendPattern(arrayOfBoolean, i, UPCEANReader.MIDDLE_PATTERN, false);
    for (b = 4; b <= 7; b++) {
      int j = Character.digit(formatException.charAt(b), 10);
      i += appendPattern(arrayOfBoolean, i, UPCEANReader.L_PATTERNS[j], true);
    } 
    appendPattern(arrayOfBoolean, i, UPCEANReader.START_END_PATTERN, true);
    return arrayOfBoolean;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\EAN8Writer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */