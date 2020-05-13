package com.google.zxing;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;

public abstract class Binarizer {
  private final LuminanceSource source;
  
  protected Binarizer(LuminanceSource paramLuminanceSource) {
    this.source = paramLuminanceSource;
  }
  
  public abstract Binarizer createBinarizer(LuminanceSource paramLuminanceSource);
  
  public abstract BitMatrix getBlackMatrix() throws NotFoundException;
  
  public abstract BitArray getBlackRow(int paramInt, BitArray paramBitArray) throws NotFoundException;
  
  public final int getHeight() {
    return this.source.getHeight();
  }
  
  public final LuminanceSource getLuminanceSource() {
    return this.source;
  }
  
  public final int getWidth() {
    return this.source.getWidth();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\Binarizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */