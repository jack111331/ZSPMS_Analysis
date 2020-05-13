package com.google.zxing.oned.rss.expanded.decoders;

abstract class DecodedObject {
  private final int newPosition;
  
  DecodedObject(int paramInt) {
    this.newPosition = paramInt;
  }
  
  final int getNewPosition() {
    return this.newPosition;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\DecodedObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */