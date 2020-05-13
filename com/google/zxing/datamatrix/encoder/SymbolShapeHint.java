package com.google.zxing.datamatrix.encoder;

public enum SymbolShapeHint {
  FORCE_NONE, FORCE_RECTANGLE, FORCE_SQUARE;
  
  static {
    FORCE_RECTANGLE = new SymbolShapeHint("FORCE_RECTANGLE", 2);
    $VALUES = new SymbolShapeHint[] { FORCE_NONE, FORCE_SQUARE, FORCE_RECTANGLE };
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\encoder\SymbolShapeHint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */