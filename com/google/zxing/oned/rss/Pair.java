package com.google.zxing.oned.rss;

final class Pair extends DataCharacter {
  private int count;
  
  private final FinderPattern finderPattern;
  
  Pair(int paramInt1, int paramInt2, FinderPattern paramFinderPattern) {
    super(paramInt1, paramInt2);
    this.finderPattern = paramFinderPattern;
  }
  
  int getCount() {
    return this.count;
  }
  
  FinderPattern getFinderPattern() {
    return this.finderPattern;
  }
  
  void incrementCount() {
    this.count++;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\Pair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */