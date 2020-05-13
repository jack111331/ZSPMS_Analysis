package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public class Code93Writer extends OneDimensionalCodeWriter {
  private static int appendPattern(boolean[] paramArrayOfboolean, int paramInt, int[] paramArrayOfint) {
    int i = paramArrayOfint.length;
    int j = paramInt;
    paramInt = 0;
    while (paramInt < i) {
      boolean bool;
      if (paramArrayOfint[paramInt] != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      paramArrayOfboolean[j] = bool;
      paramInt++;
      j++;
    } 
    return 9;
  }
  
  @Deprecated
  protected static int appendPattern(boolean[] paramArrayOfboolean, int paramInt, int[] paramArrayOfint, boolean paramBoolean) {
    return appendPattern(paramArrayOfboolean, paramInt, paramArrayOfint);
  }
  
  private static int computeChecksumIndex(String paramString, int paramInt) {
    int i = paramString.length() - 1;
    int j = 0;
    int k = 1;
    while (i >= 0) {
      j += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(paramString.charAt(i)) * k;
      int m = k + 1;
      k = m;
      if (m > paramInt)
        k = 1; 
      i--;
    } 
    return j % 47;
  }
  
  private static void toIntArray(int paramInt, int[] paramArrayOfint) {
    for (byte b = 0; b < 9; b++) {
      boolean bool = true;
      if ((1 << 8 - b & paramInt) == 0)
        bool = false; 
      paramArrayOfint[b] = bool;
    } 
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap) throws WriterException {
    if (paramBarcodeFormat == BarcodeFormat.CODE_93)
      return super.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap); 
    throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(paramBarcodeFormat)));
  }
  
  public boolean[] encode(String paramString) {
    int i = paramString.length();
    if (i <= 80) {
      int[] arrayOfInt = new int[9];
      int j = paramString.length();
      toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], arrayOfInt);
      boolean[] arrayOfBoolean = new boolean[(j + 2 + 2) * 9 + 1];
      int k = 0;
      j = appendPattern(arrayOfBoolean, 0, arrayOfInt);
      while (k < i) {
        int m = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(paramString.charAt(k));
        toIntArray(Code93Reader.CHARACTER_ENCODINGS[m], arrayOfInt);
        j += appendPattern(arrayOfBoolean, j, arrayOfInt);
        k++;
      } 
      k = computeChecksumIndex(paramString, 20);
      toIntArray(Code93Reader.CHARACTER_ENCODINGS[k], arrayOfInt);
      j += appendPattern(arrayOfBoolean, j, arrayOfInt);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(k));
      k = computeChecksumIndex(stringBuilder.toString(), 15);
      toIntArray(Code93Reader.CHARACTER_ENCODINGS[k], arrayOfInt);
      j += appendPattern(arrayOfBoolean, j, arrayOfInt);
      toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], arrayOfInt);
      arrayOfBoolean[j + appendPattern(arrayOfBoolean, j, arrayOfInt)] = true;
      return arrayOfBoolean;
    } 
    throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(i)));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\Code93Writer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */