package com.google.zxing.qrcode.encoder;

final class BlockPair {
  private final byte[] dataBytes;
  
  private final byte[] errorCorrectionBytes;
  
  BlockPair(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    this.dataBytes = paramArrayOfbyte1;
    this.errorCorrectionBytes = paramArrayOfbyte2;
  }
  
  public byte[] getDataBytes() {
    return this.dataBytes;
  }
  
  public byte[] getErrorCorrectionBytes() {
    return this.errorCorrectionBytes;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\encoder\BlockPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */