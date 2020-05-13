package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public abstract class OneDimensionalCodeWriter implements Writer {
  protected static int appendPattern(boolean[] paramArrayOfboolean, int paramInt, int[] paramArrayOfint, boolean paramBoolean) {
    int i = paramArrayOfint.length;
    byte b = 0;
    int j = 0;
    while (b < i) {
      int k = paramArrayOfint[b];
      byte b1 = 0;
      while (b1 < k) {
        paramArrayOfboolean[paramInt] = paramBoolean;
        b1++;
        paramInt++;
      } 
      j += k;
      if (!paramBoolean) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      b++;
    } 
    return j;
  }
  
  private static BitMatrix renderResult(boolean[] paramArrayOfboolean, int paramInt1, int paramInt2, int paramInt3) {
    int i = paramArrayOfboolean.length;
    int j = paramInt3 + i;
    int k = Math.max(paramInt1, j);
    paramInt3 = Math.max(1, paramInt2);
    j = k / j;
    paramInt1 = (k - i * j) / 2;
    BitMatrix bitMatrix = new BitMatrix(k, paramInt3);
    paramInt2 = 0;
    while (paramInt2 < i) {
      if (paramArrayOfboolean[paramInt2])
        bitMatrix.setRegion(paramInt1, 0, j, paramInt3); 
      paramInt2++;
      paramInt1 += j;
    } 
    return bitMatrix;
  }
  
  public final BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2) throws WriterException {
    return encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, null);
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap) throws WriterException {
    if (!paramString.isEmpty()) {
      if (paramInt1 >= 0 && paramInt2 >= 0) {
        int i = getDefaultMargin();
        int j = i;
        if (paramMap != null) {
          j = i;
          if (paramMap.containsKey(EncodeHintType.MARGIN))
            j = Integer.parseInt(paramMap.get(EncodeHintType.MARGIN).toString()); 
        } 
        return renderResult(encode(paramString), paramInt1, paramInt2, j);
      } 
      StringBuilder stringBuilder = new StringBuilder("Negative size is not allowed. Input: ");
      stringBuilder.append(paramInt1);
      stringBuilder.append('x');
      stringBuilder.append(paramInt2);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("Found empty contents");
  }
  
  public abstract boolean[] encode(String paramString);
  
  public int getDefaultMargin() {
    return 10;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\OneDimensionalCodeWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */