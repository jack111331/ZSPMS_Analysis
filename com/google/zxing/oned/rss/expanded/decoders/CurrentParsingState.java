package com.google.zxing.oned.rss.expanded.decoders;

final class CurrentParsingState {
  private State encoding = State.NUMERIC;
  
  private int position = 0;
  
  int getPosition() {
    return this.position;
  }
  
  void incrementPosition(int paramInt) {
    this.position += paramInt;
  }
  
  boolean isAlpha() {
    return (this.encoding == State.ALPHA);
  }
  
  boolean isIsoIec646() {
    return (this.encoding == State.ISO_IEC_646);
  }
  
  boolean isNumeric() {
    return (this.encoding == State.NUMERIC);
  }
  
  void setAlpha() {
    this.encoding = State.ALPHA;
  }
  
  void setIsoIec646() {
    this.encoding = State.ISO_IEC_646;
  }
  
  void setNumeric() {
    this.encoding = State.NUMERIC;
  }
  
  void setPosition(int paramInt) {
    this.position = paramInt;
  }
  
  private enum State {
    ALPHA, ISO_IEC_646, NUMERIC;
    
    static {
      $VALUES = new State[] { NUMERIC, ALPHA, ISO_IEC_646 };
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\CurrentParsingState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */