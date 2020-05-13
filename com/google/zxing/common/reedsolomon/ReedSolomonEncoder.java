package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

public final class ReedSolomonEncoder {
  private final List<GenericGFPoly> cachedGenerators;
  
  private final GenericGF field;
  
  public ReedSolomonEncoder(GenericGF paramGenericGF) {
    this.field = paramGenericGF;
    this.cachedGenerators = new ArrayList<GenericGFPoly>();
    this.cachedGenerators.add(new GenericGFPoly(paramGenericGF, new int[] { 1 }));
  }
  
  private GenericGFPoly buildGenerator(int paramInt) {
    if (paramInt >= this.cachedGenerators.size()) {
      GenericGFPoly genericGFPoly = this.cachedGenerators.get(this.cachedGenerators.size() - 1);
      for (int i = this.cachedGenerators.size(); i <= paramInt; i++) {
        genericGFPoly = genericGFPoly.multiply(new GenericGFPoly(this.field, new int[] { 1, this.field.exp(i - 1 + this.field.getGeneratorBase()) }));
        this.cachedGenerators.add(genericGFPoly);
      } 
    } 
    return this.cachedGenerators.get(paramInt);
  }
  
  public void encode(int[] paramArrayOfint, int paramInt) {
    if (paramInt != 0) {
      int i = paramArrayOfint.length - paramInt;
      if (i > 0) {
        GenericGFPoly genericGFPoly = buildGenerator(paramInt);
        int[] arrayOfInt = new int[i];
        System.arraycopy(paramArrayOfint, 0, arrayOfInt, 0, i);
        arrayOfInt = (new GenericGFPoly(this.field, arrayOfInt)).multiplyByMonomial(paramInt, 1).divide(genericGFPoly)[1].getCoefficients();
        int j = paramInt - arrayOfInt.length;
        for (paramInt = 0; paramInt < j; paramInt++)
          paramArrayOfint[i + paramInt] = 0; 
        System.arraycopy(arrayOfInt, 0, paramArrayOfint, i + j, arrayOfInt.length);
        return;
      } 
      throw new IllegalArgumentException("No data bytes provided");
    } 
    throw new IllegalArgumentException("No error correction bytes");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\common\reedsolomon\ReedSolomonEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */