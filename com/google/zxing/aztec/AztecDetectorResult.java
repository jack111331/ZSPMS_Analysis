package com.google.zxing.aztec;

import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;

public final class AztecDetectorResult extends DetectorResult {
  private final boolean compact;
  
  private final int nbDatablocks;
  
  private final int nbLayers;
  
  public AztecDetectorResult(BitMatrix paramBitMatrix, ResultPoint[] paramArrayOfResultPoint, boolean paramBoolean, int paramInt1, int paramInt2) {
    super(paramBitMatrix, paramArrayOfResultPoint);
    this.compact = paramBoolean;
    this.nbDatablocks = paramInt1;
    this.nbLayers = paramInt2;
  }
  
  public int getNbDatablocks() {
    return this.nbDatablocks;
  }
  
  public int getNbLayers() {
    return this.nbLayers;
  }
  
  public boolean isCompact() {
    return this.compact;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\aztec\AztecDetectorResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */