package com.google.zxing.common.reedsolomon;

public final class ReedSolomonDecoder {
  private final GenericGF field;
  
  public ReedSolomonDecoder(GenericGF paramGenericGF) {
    this.field = paramGenericGF;
  }
  
  private int[] findErrorLocations(GenericGFPoly paramGenericGFPoly) throws ReedSolomonException {
    int i = paramGenericGFPoly.getDegree();
    int j = 0;
    byte b = 1;
    if (i == 1)
      return new int[] { paramGenericGFPoly.getCoefficient(1) }; 
    int[] arrayOfInt = new int[i];
    while (b < this.field.getSize() && j < i) {
      int k = j;
      if (paramGenericGFPoly.evaluateAt(b) == 0) {
        arrayOfInt[j] = this.field.inverse(b);
        k = j + 1;
      } 
      b++;
      j = k;
    } 
    if (j == i)
      return arrayOfInt; 
    throw new ReedSolomonException("Error locator degree does not match number of roots");
  }
  
  private int[] findErrorMagnitudes(GenericGFPoly paramGenericGFPoly, int[] paramArrayOfint) {
    int i = paramArrayOfint.length;
    int[] arrayOfInt = new int[i];
    for (byte b = 0; b < i; b++) {
      int j = this.field.inverse(paramArrayOfint[b]);
      byte b1 = 0;
      int k;
      for (k = 1; b1 < i; k = m) {
        int m = k;
        if (b != b1) {
          m = this.field.multiply(paramArrayOfint[b1], j);
          if ((m & 0x1) == 0) {
            m |= 0x1;
          } else {
            m &= 0xFFFFFFFE;
          } 
          m = this.field.multiply(k, m);
        } 
        b1++;
      } 
      arrayOfInt[b] = this.field.multiply(paramGenericGFPoly.evaluateAt(j), this.field.inverse(k));
      if (this.field.getGeneratorBase() != 0)
        arrayOfInt[b] = this.field.multiply(arrayOfInt[b], j); 
    } 
    return arrayOfInt;
  }
  
  private GenericGFPoly[] runEuclideanAlgorithm(GenericGFPoly paramGenericGFPoly1, GenericGFPoly paramGenericGFPoly2, int paramInt) throws ReedSolomonException {
    GenericGFPoly genericGFPoly1 = paramGenericGFPoly1;
    GenericGFPoly genericGFPoly2 = paramGenericGFPoly2;
    if (paramGenericGFPoly1.getDegree() < paramGenericGFPoly2.getDegree()) {
      genericGFPoly2 = paramGenericGFPoly1;
      genericGFPoly1 = paramGenericGFPoly2;
    } 
    GenericGFPoly genericGFPoly3 = this.field.getZero();
    GenericGFPoly genericGFPoly4 = this.field.getOne();
    paramGenericGFPoly2 = genericGFPoly1;
    paramGenericGFPoly1 = genericGFPoly2;
    genericGFPoly2 = genericGFPoly4;
    genericGFPoly1 = genericGFPoly3;
    while (paramGenericGFPoly1.getDegree() >= paramInt / 2) {
      if (!paramGenericGFPoly1.isZero()) {
        genericGFPoly3 = this.field.getZero();
        int i = paramGenericGFPoly1.getCoefficient(paramGenericGFPoly1.getDegree());
        i = this.field.inverse(i);
        while (paramGenericGFPoly2.getDegree() >= paramGenericGFPoly1.getDegree() && !paramGenericGFPoly2.isZero()) {
          int j = paramGenericGFPoly2.getDegree() - paramGenericGFPoly1.getDegree();
          int k = this.field.multiply(paramGenericGFPoly2.getCoefficient(paramGenericGFPoly2.getDegree()), i);
          genericGFPoly3 = genericGFPoly3.addOrSubtract(this.field.buildMonomial(j, k));
          paramGenericGFPoly2 = paramGenericGFPoly2.addOrSubtract(paramGenericGFPoly1.multiplyByMonomial(j, k));
        } 
        genericGFPoly1 = genericGFPoly3.multiply(genericGFPoly2).addOrSubtract(genericGFPoly1);
        if (paramGenericGFPoly2.getDegree() < paramGenericGFPoly1.getDegree()) {
          genericGFPoly3 = paramGenericGFPoly1;
          paramGenericGFPoly1 = paramGenericGFPoly2;
          paramGenericGFPoly2 = genericGFPoly1;
          genericGFPoly1 = genericGFPoly2;
          genericGFPoly2 = paramGenericGFPoly2;
          paramGenericGFPoly2 = genericGFPoly3;
          continue;
        } 
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
      } 
      throw new ReedSolomonException("r_{i-1} was zero");
    } 
    paramInt = genericGFPoly2.getCoefficient(0);
    if (paramInt != 0) {
      paramInt = this.field.inverse(paramInt);
      return new GenericGFPoly[] { genericGFPoly2.multiply(paramInt), paramGenericGFPoly1.multiply(paramInt) };
    } 
    throw new ReedSolomonException("sigmaTilde(0) was zero");
  }
  
  public void decode(int[] paramArrayOfint, int paramInt) throws ReedSolomonException {
    GenericGFPoly genericGFPoly1 = new GenericGFPoly(this.field, paramArrayOfint);
    int[] arrayOfInt2 = new int[paramInt];
    boolean bool1 = false;
    int i = 0;
    boolean bool2 = true;
    while (i < paramInt) {
      GenericGF genericGF = this.field;
      int j = genericGFPoly1.evaluateAt(genericGF.exp(genericGF.getGeneratorBase() + i));
      arrayOfInt2[paramInt - 1 - i] = j;
      if (j != 0)
        bool2 = false; 
      i++;
    } 
    if (bool2)
      return; 
    genericGFPoly1 = new GenericGFPoly(this.field, arrayOfInt2);
    GenericGFPoly[] arrayOfGenericGFPoly = runEuclideanAlgorithm(this.field.buildMonomial(paramInt, 1), genericGFPoly1, paramInt);
    genericGFPoly1 = arrayOfGenericGFPoly[0];
    GenericGFPoly genericGFPoly2 = arrayOfGenericGFPoly[1];
    int[] arrayOfInt1 = findErrorLocations(genericGFPoly1);
    int[] arrayOfInt3 = findErrorMagnitudes(genericGFPoly2, arrayOfInt1);
    paramInt = bool1;
    while (paramInt < arrayOfInt1.length) {
      i = paramArrayOfint.length - 1 - this.field.log(arrayOfInt1[paramInt]);
      if (i >= 0) {
        paramArrayOfint[i] = GenericGF.addOrSubtract(paramArrayOfint[i], arrayOfInt3[paramInt]);
        paramInt++;
        continue;
      } 
      throw new ReedSolomonException("Bad error location");
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\common\reedsolomon\ReedSolomonDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */