package com.google.zxing.pdf417.encoder;

public enum Compaction {
  AUTO, BYTE, NUMERIC, TEXT;
  
  static {
    BYTE = new Compaction("BYTE", 2);
    NUMERIC = new Compaction("NUMERIC", 3);
    $VALUES = new Compaction[] { AUTO, TEXT, BYTE, NUMERIC };
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\encoder\Compaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */