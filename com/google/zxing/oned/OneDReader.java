package com.google.zxing.oned;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public abstract class OneDReader implements Reader {
  private Result doDecode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException {
    int m;
    int i = paramBinaryBitmap.getWidth();
    int j = paramBinaryBitmap.getHeight();
    BitArray bitArray = new BitArray(i);
    if (paramMap != null && paramMap.containsKey(DecodeHintType.TRY_HARDER)) {
      k = 1;
    } else {
      k = 0;
    } 
    if (k) {
      m = 8;
    } else {
      m = 5;
    } 
    int n = Math.max(1, j >> m);
    if (k) {
      m = j;
    } else {
      m = 15;
    } 
    int i1 = j / 2;
    int i2 = 0;
    int k = i;
    i = i2;
    label67: while (true) {
      if (i < m) {
        i2 = i + 1;
        int i3 = i2 / 2;
        if ((i & 0x1) == 0) {
          i = 1;
        } else {
          i = 0;
        } 
        if (i != 0) {
          i = i3;
        } else {
          i = -i3;
        } 
        i3 = i * n + i1;
        if (i3 >= 0 && i3 < j) {
          try {
            BitArray bitArray1 = paramBinaryBitmap.getBlackRow(i3, bitArray);
            i = 0;
            while (true) {
              if (i < 2) {
                Map<DecodeHintType, ?> map = paramMap;
                if (i == 1) {
                  bitArray1.reverse();
                  map = paramMap;
                  if (paramMap != null) {
                    map = paramMap;
                    if (paramMap.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) {
                      map = new EnumMap<DecodeHintType, Object>(DecodeHintType.class);
                      map.putAll(paramMap);
                      map.remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                    } 
                  } 
                } 
                try {
                  Result result = decodeRow(i3, bitArray1, map);
                  if (i == 1) {
                    result.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(180));
                    ResultPoint[] arrayOfResultPoint = result.getResultPoints();
                    if (arrayOfResultPoint != null) {
                      ResultPoint resultPoint = new ResultPoint();
                      float f1 = k;
                      float f2 = arrayOfResultPoint[0].getX();
                      try {
                        this(f1 - f2 - 1.0F, arrayOfResultPoint[0].getY());
                        arrayOfResultPoint[0] = resultPoint;
                        try {
                          arrayOfResultPoint[1] = new ResultPoint(f1 - arrayOfResultPoint[1].getX() - 1.0F, arrayOfResultPoint[1].getY());
                          return result;
                        } catch (ReaderException null) {}
                      } catch (ReaderException readerException) {}
                    } else {
                      return (Result)readerException;
                    } 
                  } else {
                    return (Result)readerException;
                  } 
                } catch (ReaderException readerException) {}
                i++;
                paramMap = map;
                continue;
              } 
              bitArray = bitArray1;
              i = i2;
              continue label67;
            } 
          } catch (NotFoundException notFoundException) {
            continue;
          } 
          break;
        } 
      } 
      throw NotFoundException.getNotFoundInstance();
    } 
  }
  
  protected static float patternMatchVariance(int[] paramArrayOfint1, int[] paramArrayOfint2, float paramFloat) {
    int i = paramArrayOfint1.length;
    boolean bool = false;
    byte b = 0;
    int j = 0;
    int k = 0;
    while (b < i) {
      j += paramArrayOfint1[b];
      k += paramArrayOfint2[b];
      b++;
    } 
    if (j < k)
      return Float.POSITIVE_INFINITY; 
    float f1 = j;
    float f2 = f1 / k;
    float f3 = 0.0F;
    for (k = bool; k < i; k++) {
      j = paramArrayOfint1[k];
      float f4 = paramArrayOfint2[k] * f2;
      float f5 = j;
      if (f5 > f4) {
        f4 = f5 - f4;
      } else {
        f4 -= f5;
      } 
      if (f4 > paramFloat * f2)
        return Float.POSITIVE_INFINITY; 
      f3 += f4;
    } 
    return f3 / f1;
  }
  
  protected static void recordPattern(BitArray paramBitArray, int paramInt, int[] paramArrayOfint) throws NotFoundException {
    int i = paramArrayOfint.length;
    Arrays.fill(paramArrayOfint, 0, i, 0);
    int j = paramBitArray.getSize();
    if (paramInt < j) {
      int k = paramBitArray.get(paramInt) ^ true;
      int m = 0;
      int n = paramInt;
      paramInt = m;
      while (true) {
        m = paramInt;
        if (n < j) {
          if (paramBitArray.get(n) != k) {
            paramArrayOfint[paramInt] = paramArrayOfint[paramInt] + 1;
          } else {
            m = ++paramInt;
            if (paramInt != i) {
              paramArrayOfint[paramInt] = 1;
              if (k == 0) {
                k = 1;
              } else {
                k = 0;
              } 
            } else {
              break;
            } 
          } 
          n++;
          continue;
        } 
        break;
      } 
      if (m == i || (m == i - 1 && n == j))
        return; 
      throw NotFoundException.getNotFoundInstance();
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  protected static void recordPatternInReverse(BitArray paramBitArray, int paramInt, int[] paramArrayOfint) throws NotFoundException {
    int i = paramArrayOfint.length;
    boolean bool = paramBitArray.get(paramInt);
    while (paramInt > 0 && i >= 0) {
      int j = paramInt - 1;
      paramInt = j;
      if (paramBitArray.get(j) != bool) {
        i--;
        if (!bool) {
          bool = true;
          paramInt = j;
          continue;
        } 
        bool = false;
        paramInt = j;
      } 
    } 
    if (i < 0) {
      recordPattern(paramBitArray, paramInt + 1, paramArrayOfint);
      return;
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap) throws NotFoundException, FormatException {
    return decode(paramBinaryBitmap, null);
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException, FormatException {
    try {
      return doDecode(paramBinaryBitmap, paramMap);
    } catch (NotFoundException notFoundException) {
      ResultPoint[] arrayOfResultPoint;
      int i;
      boolean bool = false;
      if (paramMap != null && paramMap.containsKey(DecodeHintType.TRY_HARDER)) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i && paramBinaryBitmap.isRotateSupported()) {
        paramBinaryBitmap = paramBinaryBitmap.rotateCounterClockwise();
        Result result = doDecode(paramBinaryBitmap, paramMap);
        Map map = result.getResultMetadata();
        int j = 270;
        i = j;
        if (map != null) {
          i = j;
          if (map.containsKey(ResultMetadataType.ORIENTATION))
            i = (((Integer)map.get(ResultMetadataType.ORIENTATION)).intValue() + 270) % 360; 
        } 
        result.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(i));
        arrayOfResultPoint = result.getResultPoints();
        if (arrayOfResultPoint != null) {
          j = paramBinaryBitmap.getHeight();
          for (i = bool; i < arrayOfResultPoint.length; i++)
            arrayOfResultPoint[i] = new ResultPoint(j - arrayOfResultPoint[i].getY() - 1.0F, arrayOfResultPoint[i].getX()); 
        } 
        return result;
      } 
      throw arrayOfResultPoint;
    } 
  }
  
  public abstract Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException;
  
  public void reset() {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\OneDReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */