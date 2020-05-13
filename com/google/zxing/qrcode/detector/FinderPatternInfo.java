package com.google.zxing.qrcode.detector;

public final class FinderPatternInfo {
  private final FinderPattern bottomLeft;
  
  private final FinderPattern topLeft;
  
  private final FinderPattern topRight;
  
  public FinderPatternInfo(FinderPattern[] paramArrayOfFinderPattern) {
    this.bottomLeft = paramArrayOfFinderPattern[0];
    this.topLeft = paramArrayOfFinderPattern[1];
    this.topRight = paramArrayOfFinderPattern[2];
  }
  
  public FinderPattern getBottomLeft() {
    return this.bottomLeft;
  }
  
  public FinderPattern getTopLeft() {
    return this.topLeft;
  }
  
  public FinderPattern getTopRight() {
    return this.topRight;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\detector\FinderPatternInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */