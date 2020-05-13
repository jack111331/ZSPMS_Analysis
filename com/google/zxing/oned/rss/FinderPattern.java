package com.google.zxing.oned.rss;

import com.google.zxing.ResultPoint;

public final class FinderPattern {
  private final ResultPoint[] resultPoints;
  
  private final int[] startEnd;
  
  private final int value;
  
  public FinderPattern(int paramInt1, int[] paramArrayOfint, int paramInt2, int paramInt3, int paramInt4) {
    this.value = paramInt1;
    this.startEnd = paramArrayOfint;
    float f1 = paramInt2;
    float f2 = paramInt4;
    this.resultPoints = new ResultPoint[] { new ResultPoint(f1, f2), new ResultPoint(paramInt3, f2) };
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof FinderPattern))
      return false; 
    paramObject = paramObject;
    return (this.value == ((FinderPattern)paramObject).value);
  }
  
  public ResultPoint[] getResultPoints() {
    return this.resultPoints;
  }
  
  public int[] getStartEnd() {
    return this.startEnd;
  }
  
  public int getValue() {
    return this.value;
  }
  
  public int hashCode() {
    return this.value;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\FinderPattern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */