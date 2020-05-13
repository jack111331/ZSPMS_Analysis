package com.google.zxing.qrcode.decoder;

public enum ErrorCorrectionLevel {
  H,
  L(1),
  M(0),
  Q(3);
  
  private static final ErrorCorrectionLevel[] FOR_BITS;
  
  private final int bits;
  
  static {
    H = new ErrorCorrectionLevel("H", 3, 2);
    $VALUES = new ErrorCorrectionLevel[] { L, M, Q, H };
    FOR_BITS = new ErrorCorrectionLevel[] { M, L, H, Q };
  }
  
  ErrorCorrectionLevel(int paramInt1) {
    this.bits = paramInt1;
  }
  
  public static ErrorCorrectionLevel forBits(int paramInt) {
    if (paramInt >= 0 && paramInt < FOR_BITS.length)
      return FOR_BITS[paramInt]; 
    throw new IllegalArgumentException();
  }
  
  public int getBits() {
    return this.bits;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\decoder\ErrorCorrectionLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */