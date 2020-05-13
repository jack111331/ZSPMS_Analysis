package com.google.zxing.oned.rss.expanded.decoders;

final class DecodedChar extends DecodedObject {
  static final char FNC1 = '$';
  
  private final char value;
  
  DecodedChar(int paramInt, char paramChar) {
    super(paramInt);
    this.value = (char)paramChar;
  }
  
  char getValue() {
    return this.value;
  }
  
  boolean isFNC1() {
    return (this.value == '$');
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\DecodedChar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */