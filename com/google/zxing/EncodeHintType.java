package com.google.zxing;

public enum EncodeHintType {
  AZTEC_LAYERS, CHARACTER_SET, DATA_MATRIX_SHAPE, ERROR_CORRECTION, GS1_FORMAT, MARGIN, MAX_SIZE, MIN_SIZE, PDF417_COMPACT, PDF417_COMPACTION, PDF417_DIMENSIONS, QR_VERSION;
  
  static {
    CHARACTER_SET = new EncodeHintType("CHARACTER_SET", 1);
    DATA_MATRIX_SHAPE = new EncodeHintType("DATA_MATRIX_SHAPE", 2);
    MIN_SIZE = new EncodeHintType("MIN_SIZE", 3);
    MAX_SIZE = new EncodeHintType("MAX_SIZE", 4);
    MARGIN = new EncodeHintType("MARGIN", 5);
    PDF417_COMPACT = new EncodeHintType("PDF417_COMPACT", 6);
    PDF417_COMPACTION = new EncodeHintType("PDF417_COMPACTION", 7);
    PDF417_DIMENSIONS = new EncodeHintType("PDF417_DIMENSIONS", 8);
    AZTEC_LAYERS = new EncodeHintType("AZTEC_LAYERS", 9);
    QR_VERSION = new EncodeHintType("QR_VERSION", 10);
    GS1_FORMAT = new EncodeHintType("GS1_FORMAT", 11);
    $VALUES = new EncodeHintType[] { 
        ERROR_CORRECTION, CHARACTER_SET, DATA_MATRIX_SHAPE, MIN_SIZE, MAX_SIZE, MARGIN, PDF417_COMPACT, PDF417_COMPACTION, PDF417_DIMENSIONS, AZTEC_LAYERS, 
        QR_VERSION, GS1_FORMAT };
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\EncodeHintType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */