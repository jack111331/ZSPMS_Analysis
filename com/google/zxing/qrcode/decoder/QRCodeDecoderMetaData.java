package com.google.zxing.qrcode.decoder;

import com.google.zxing.ResultPoint;

public final class QRCodeDecoderMetaData {
  private final boolean mirrored;
  
  QRCodeDecoderMetaData(boolean paramBoolean) {
    this.mirrored = paramBoolean;
  }
  
  public void applyMirroredCorrection(ResultPoint[] paramArrayOfResultPoint) {
    if (!this.mirrored || paramArrayOfResultPoint == null || paramArrayOfResultPoint.length < 3)
      return; 
    ResultPoint resultPoint = paramArrayOfResultPoint[0];
    paramArrayOfResultPoint[0] = paramArrayOfResultPoint[2];
    paramArrayOfResultPoint[2] = resultPoint;
  }
  
  public boolean isMirrored() {
    return this.mirrored;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\decoder\QRCodeDecoderMetaData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */