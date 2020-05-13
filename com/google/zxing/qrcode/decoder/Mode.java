package com.google.zxing.qrcode.decoder;

public enum Mode {
  ALPHANUMERIC,
  BYTE,
  ECI,
  FNC1_FIRST_POSITION,
  FNC1_SECOND_POSITION,
  HANZI,
  KANJI,
  NUMERIC,
  STRUCTURED_APPEND,
  TERMINATOR(new int[] { 0, 0, 0 }, 0);
  
  private final int bits;
  
  private final int[] characterCountBitsForVersions;
  
  static {
    NUMERIC = new Mode("NUMERIC", 1, new int[] { 10, 12, 14 }, 1);
    ALPHANUMERIC = new Mode("ALPHANUMERIC", 2, new int[] { 9, 11, 13 }, 2);
    STRUCTURED_APPEND = new Mode("STRUCTURED_APPEND", 3, new int[] { 0, 0, 0 }, 3);
    BYTE = new Mode("BYTE", 4, new int[] { 8, 16, 16 }, 4);
    ECI = new Mode("ECI", 5, new int[] { 0, 0, 0 }, 7);
    KANJI = new Mode("KANJI", 6, new int[] { 8, 10, 12 }, 8);
    FNC1_FIRST_POSITION = new Mode("FNC1_FIRST_POSITION", 7, new int[] { 0, 0, 0 }, 5);
    FNC1_SECOND_POSITION = new Mode("FNC1_SECOND_POSITION", 8, new int[] { 0, 0, 0 }, 9);
    HANZI = new Mode("HANZI", 9, new int[] { 8, 10, 12 }, 13);
    $VALUES = new Mode[] { TERMINATOR, NUMERIC, ALPHANUMERIC, STRUCTURED_APPEND, BYTE, ECI, KANJI, FNC1_FIRST_POSITION, FNC1_SECOND_POSITION, HANZI };
  }
  
  Mode(int[] paramArrayOfint, int paramInt1) {
    this.characterCountBitsForVersions = paramArrayOfint;
    this.bits = paramInt1;
  }
  
  public static Mode forBits(int paramInt) {
    switch (paramInt) {
      default:
        throw new IllegalArgumentException();
      case 13:
        return HANZI;
      case 9:
        return FNC1_SECOND_POSITION;
      case 8:
        return KANJI;
      case 7:
        return ECI;
      case 5:
        return FNC1_FIRST_POSITION;
      case 4:
        return BYTE;
      case 3:
        return STRUCTURED_APPEND;
      case 2:
        return ALPHANUMERIC;
      case 1:
        return NUMERIC;
      case 0:
        break;
    } 
    return TERMINATOR;
  }
  
  public int getBits() {
    return this.bits;
  }
  
  public int getCharacterCountBits(Version paramVersion) {
    int i = paramVersion.getVersionNumber();
    if (i <= 9) {
      i = 0;
    } else if (i <= 26) {
      i = 1;
    } else {
      i = 2;
    } 
    return this.characterCountBitsForVersions[i];
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\decoder\Mode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */