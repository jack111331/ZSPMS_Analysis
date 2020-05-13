package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.Map;

public final class ByQuadrantReader implements Reader {
  private final Reader delegate;
  
  public ByQuadrantReader(Reader paramReader) {
    this.delegate = paramReader;
  }
  
  private static void makeAbsolute(ResultPoint[] paramArrayOfResultPoint, int paramInt1, int paramInt2) {
    if (paramArrayOfResultPoint != null)
      for (byte b = 0; b < paramArrayOfResultPoint.length; b++) {
        ResultPoint resultPoint = paramArrayOfResultPoint[b];
        paramArrayOfResultPoint[b] = new ResultPoint(resultPoint.getX() + paramInt1, resultPoint.getY() + paramInt2);
      }  
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap) throws NotFoundException, ChecksumException, FormatException {
    return decode(paramBinaryBitmap, null);
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException {
    int i = paramBinaryBitmap.getWidth();
    int j = paramBinaryBitmap.getHeight();
    i /= 2;
    j /= 2;
    try {
      return this.delegate.decode(paramBinaryBitmap.crop(0, 0, i, j), paramMap);
    } catch (NotFoundException notFoundException) {
      try {
        Result result = this.delegate.decode(paramBinaryBitmap.crop(i, 0, i, j), paramMap);
        makeAbsolute(result.getResultPoints(), i, 0);
        return result;
      } catch (NotFoundException notFoundException1) {
        try {
          Result result = this.delegate.decode(paramBinaryBitmap.crop(0, j, i, j), paramMap);
          makeAbsolute(result.getResultPoints(), 0, j);
          return result;
        } catch (NotFoundException notFoundException2) {
          try {
            Result result = this.delegate.decode(paramBinaryBitmap.crop(i, j, i, j), paramMap);
            makeAbsolute(result.getResultPoints(), i, j);
            return result;
          } catch (NotFoundException notFoundException3) {
            int k = i / 2;
            int m = j / 2;
            paramBinaryBitmap = paramBinaryBitmap.crop(k, m, i, j);
            Result result = this.delegate.decode(paramBinaryBitmap, paramMap);
            makeAbsolute(result.getResultPoints(), k, m);
            return result;
          } 
        } 
      } 
    } 
  }
  
  public void reset() {
    this.delegate.reset();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\multi\ByQuadrantReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */