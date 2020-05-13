package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class Code39Writer extends OneDimensionalCodeWriter {
  private static void toIntArray(int paramInt, int[] paramArrayOfint) {
    for (byte b = 0; b < 9; b++) {
      byte b1 = 1;
      if ((1 << 8 - b & paramInt) != 0)
        b1 = 2; 
      paramArrayOfint[b] = b1;
    } 
  }
  
  private static String tryToConvertToExtendedMode(String paramString) {
    int i = paramString.length();
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < i; b++) {
      char c = paramString.charAt(b);
      if (c != '\000') {
        if (c != ' ') {
          if (c != '@') {
            if (c != '`') {
              switch (c) {
                default:
                  if (c <= '\032') {
                    stringBuilder.append('$');
                    stringBuilder.append((char)(c - 1 + 65));
                    break;
                  } 
                  if (c < ' ') {
                    stringBuilder.append('%');
                    stringBuilder.append((char)(c - 27 + 65));
                    break;
                  } 
                  if (c <= ',' || c == '/' || c == ':') {
                    stringBuilder.append('/');
                    stringBuilder.append((char)(c - 33 + 65));
                    break;
                  } 
                  if (c <= '9') {
                    stringBuilder.append((char)(c - 48 + 48));
                    break;
                  } 
                  if (c <= '?') {
                    stringBuilder.append('%');
                    stringBuilder.append((char)(c - 59 + 70));
                    break;
                  } 
                  if (c <= 'Z') {
                    stringBuilder.append((char)(c - 65 + 65));
                    break;
                  } 
                  if (c <= '_') {
                    stringBuilder.append('%');
                    stringBuilder.append((char)(c - 91 + 75));
                    break;
                  } 
                  if (c <= 'z') {
                    stringBuilder.append('+');
                    stringBuilder.append((char)(c - 97 + 65));
                    break;
                  } 
                  if (c <= '') {
                    stringBuilder.append('%');
                    stringBuilder.append((char)(c - 123 + 80));
                    break;
                  } 
                  stringBuilder = new StringBuilder("Requested content contains a non-encodable character: '");
                  stringBuilder.append(paramString.charAt(b));
                  stringBuilder.append("'");
                  throw new IllegalArgumentException(stringBuilder.toString());
                case '-':
                case '.':
                  stringBuilder.append(c);
                  break;
              } 
            } else {
              stringBuilder.append("%W");
            } 
          } else {
            stringBuilder.append("%V");
          } 
        } else {
        
        } 
      } else {
        stringBuilder.append("%U");
      } 
    } 
    return stringBuilder.toString();
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap) throws WriterException {
    if (paramBarcodeFormat == BarcodeFormat.CODE_39)
      return super.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap); 
    throw new IllegalArgumentException("Can only encode CODE_39, but got ".concat(String.valueOf(paramBarcodeFormat)));
  }
  
  public boolean[] encode(String paramString) {
    int i = paramString.length();
    if (i <= 80) {
      int k;
      String str;
      int j = 0;
      while (true) {
        k = i;
        str = paramString;
        if (j < i) {
          if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(paramString.charAt(j)) < 0) {
            str = tryToConvertToExtendedMode(paramString);
            k = str.length();
            if (k <= 80)
              break; 
            StringBuilder stringBuilder = new StringBuilder("Requested contents should be less than 80 digits long, but got ");
            stringBuilder.append(k);
            stringBuilder.append(" (extended full ASCII mode)");
            throw new IllegalArgumentException(stringBuilder.toString());
          } 
          j++;
          continue;
        } 
        break;
      } 
      int[] arrayOfInt2 = new int[9];
      j = k + 25;
      for (i = 0; i < k; i++) {
        int m = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i));
        toIntArray(Code39Reader.CHARACTER_ENCODINGS[m], arrayOfInt2);
        for (m = 0; m < 9; m++)
          j += arrayOfInt2[m]; 
      } 
      boolean[] arrayOfBoolean = new boolean[j];
      toIntArray(148, arrayOfInt2);
      j = appendPattern(arrayOfBoolean, 0, arrayOfInt2, true);
      int[] arrayOfInt1 = new int[1];
      arrayOfInt1[0] = 1;
      i = j + appendPattern(arrayOfBoolean, j, arrayOfInt1, false);
      for (j = 0; j < k; j++) {
        int m = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(j));
        toIntArray(Code39Reader.CHARACTER_ENCODINGS[m], arrayOfInt2);
        i += appendPattern(arrayOfBoolean, i, arrayOfInt2, true);
        i += appendPattern(arrayOfBoolean, i, arrayOfInt1, false);
      } 
      toIntArray(148, arrayOfInt2);
      appendPattern(arrayOfBoolean, i, arrayOfInt2, true);
      return arrayOfBoolean;
    } 
    throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(i)));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\Code39Writer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */