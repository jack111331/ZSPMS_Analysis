package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

final class UPCEANExtension2Support {
  private final int[] decodeMiddleCounters = new int[4];
  
  private final StringBuilder decodeRowStringBuffer = new StringBuilder();
  
  private int decodeMiddle(BitArray paramBitArray, int[] paramArrayOfint, StringBuilder paramStringBuilder) throws NotFoundException {
    int[] arrayOfInt = this.decodeMiddleCounters;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int i = paramBitArray.getSize();
    int j = paramArrayOfint[1];
    byte b = 0;
    int k;
    for (k = 0; b < 2 && j < i; k = i1) {
      int m = UPCEANReader.decodeDigit(paramBitArray, arrayOfInt, j, UPCEANReader.L_AND_G_PATTERNS);
      paramStringBuilder.append((char)(m % 10 + 48));
      int n = arrayOfInt.length;
      int i1;
      for (i1 = 0; i1 < n; i1++)
        j += arrayOfInt[i1]; 
      i1 = k;
      if (m >= 10)
        i1 = 1 << 1 - b | k; 
      if (b != 1)
        j = paramBitArray.getNextUnset(paramBitArray.getNextSet(j)); 
      b++;
    } 
    if (paramStringBuilder.length() == 2) {
      if (Integer.parseInt(paramStringBuilder.toString()) % 4 == k)
        return j; 
      throw NotFoundException.getNotFoundInstance();
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static Map<ResultMetadataType, Object> parseExtensionString(String paramString) {
    if (paramString.length() != 2)
      return null; 
    EnumMap<ResultMetadataType, Object> enumMap = new EnumMap<ResultMetadataType, Object>(ResultMetadataType.class);
    enumMap.put(ResultMetadataType.ISSUE_NUMBER, Integer.valueOf(paramString));
    return enumMap;
  }
  
  Result decodeRow(int paramInt, BitArray paramBitArray, int[] paramArrayOfint) throws NotFoundException {
    StringBuilder stringBuilder = this.decodeRowStringBuffer;
    stringBuilder.setLength(0);
    int i = decodeMiddle(paramBitArray, paramArrayOfint, stringBuilder);
    String str = stringBuilder.toString();
    Map<ResultMetadataType, Object> map = parseExtensionString(str);
    float f1 = (paramArrayOfint[0] + paramArrayOfint[1]) / 2.0F;
    float f2 = paramInt;
    ResultPoint resultPoint1 = new ResultPoint(f1, f2);
    ResultPoint resultPoint2 = new ResultPoint(i, f2);
    BarcodeFormat barcodeFormat = BarcodeFormat.UPC_EAN_EXTENSION;
    Result result = new Result(str, null, new ResultPoint[] { resultPoint1, resultPoint2 }, barcodeFormat);
    if (map != null)
      result.putAllMetadata(map); 
    return result;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\UPCEANExtension2Support.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */