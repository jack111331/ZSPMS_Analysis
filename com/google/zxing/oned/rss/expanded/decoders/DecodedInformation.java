package com.google.zxing.oned.rss.expanded.decoders;

final class DecodedInformation extends DecodedObject {
  private final String newString;
  
  private final boolean remaining;
  
  private final int remainingValue;
  
  DecodedInformation(int paramInt, String paramString) {
    super(paramInt);
    this.newString = paramString;
    this.remaining = false;
    this.remainingValue = 0;
  }
  
  DecodedInformation(int paramInt1, String paramString, int paramInt2) {
    super(paramInt1);
    this.remaining = true;
    this.remainingValue = paramInt2;
    this.newString = paramString;
  }
  
  String getNewString() {
    return this.newString;
  }
  
  int getRemainingValue() {
    return this.remainingValue;
  }
  
  boolean isRemaining() {
    return this.remaining;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\DecodedInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */