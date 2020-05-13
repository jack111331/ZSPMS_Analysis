package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.ChecksumException;

public final class ErrorCorrection {
  private final ModulusGF field = ModulusGF.PDF417_GF;
  
  private int[] findErrorLocations(ModulusPoly paramModulusPoly) throws ChecksumException {
    int i = paramModulusPoly.getDegree();
    int[] arrayOfInt = new int[i];
    byte b = 1;
    int j;
    for (j = 0; b < this.field.getSize() && j < i; j = k) {
      int k = j;
      if (paramModulusPoly.evaluateAt(b) == 0) {
        arrayOfInt[j] = this.field.inverse(b);
        k = j + 1;
      } 
      b++;
    } 
    if (j == i)
      return arrayOfInt; 
    throw ChecksumException.getChecksumInstance();
  }
  
  private int[] findErrorMagnitudes(ModulusPoly paramModulusPoly1, ModulusPoly paramModulusPoly2, int[] paramArrayOfint) {
    int i = paramModulusPoly2.getDegree();
    int[] arrayOfInt2 = new int[i];
    byte b;
    for (b = 1; b <= i; b++)
      arrayOfInt2[i - b] = this.field.multiply(b, paramModulusPoly2.getCoefficient(b)); 
    ModulusPoly modulusPoly = new ModulusPoly(this.field, arrayOfInt2);
    i = paramArrayOfint.length;
    int[] arrayOfInt1 = new int[i];
    for (b = 0; b < i; b++) {
      int j = this.field.inverse(paramArrayOfint[b]);
      int k = this.field.subtract(0, paramModulusPoly1.evaluateAt(j));
      j = this.field.inverse(modulusPoly.evaluateAt(j));
      arrayOfInt1[b] = this.field.multiply(k, j);
    } 
    return arrayOfInt1;
  }
  
  private ModulusPoly[] runEuclideanAlgorithm(ModulusPoly paramModulusPoly1, ModulusPoly paramModulusPoly2, int paramInt) throws ChecksumException {
    ModulusPoly modulusPoly1 = paramModulusPoly1;
    ModulusPoly modulusPoly2 = paramModulusPoly2;
    if (paramModulusPoly1.getDegree() < paramModulusPoly2.getDegree()) {
      modulusPoly2 = paramModulusPoly1;
      modulusPoly1 = paramModulusPoly2;
    } 
    ModulusPoly modulusPoly3 = this.field.getZero();
    ModulusPoly modulusPoly4 = this.field.getOne();
    paramModulusPoly2 = modulusPoly1;
    paramModulusPoly1 = modulusPoly2;
    modulusPoly2 = modulusPoly4;
    modulusPoly1 = modulusPoly3;
    while (paramModulusPoly1.getDegree() >= paramInt / 2) {
      if (!paramModulusPoly1.isZero()) {
        modulusPoly3 = this.field.getZero();
        int i = paramModulusPoly1.getCoefficient(paramModulusPoly1.getDegree());
        i = this.field.inverse(i);
        while (paramModulusPoly2.getDegree() >= paramModulusPoly1.getDegree() && !paramModulusPoly2.isZero()) {
          int j = paramModulusPoly2.getDegree() - paramModulusPoly1.getDegree();
          int k = this.field.multiply(paramModulusPoly2.getCoefficient(paramModulusPoly2.getDegree()), i);
          modulusPoly3 = modulusPoly3.add(this.field.buildMonomial(j, k));
          paramModulusPoly2 = paramModulusPoly2.subtract(paramModulusPoly1.multiplyByMonomial(j, k));
        } 
        modulusPoly1 = modulusPoly3.multiply(modulusPoly2).subtract(modulusPoly1).negative();
        modulusPoly3 = paramModulusPoly1;
        paramModulusPoly1 = paramModulusPoly2;
        paramModulusPoly2 = modulusPoly1;
        modulusPoly1 = modulusPoly2;
        modulusPoly2 = paramModulusPoly2;
        paramModulusPoly2 = modulusPoly3;
        continue;
      } 
      throw ChecksumException.getChecksumInstance();
    } 
    paramInt = modulusPoly2.getCoefficient(0);
    if (paramInt != 0) {
      paramInt = this.field.inverse(paramInt);
      return new ModulusPoly[] { modulusPoly2.multiply(paramInt), paramModulusPoly1.multiply(paramInt) };
    } 
    throw ChecksumException.getChecksumInstance();
  }
  
  public int decode(int[] paramArrayOfint1, int paramInt, int[] paramArrayOfint2) throws ChecksumException {
    ModulusPoly modulusPoly2 = new ModulusPoly(this.field, paramArrayOfint1);
    int[] arrayOfInt3 = new int[paramInt];
    boolean bool = false;
    int i = paramInt;
    int j = 0;
    while (i > 0) {
      int k = modulusPoly2.evaluateAt(this.field.exp(i));
      arrayOfInt3[paramInt - i] = k;
      if (k != 0)
        j = 1; 
      i--;
    } 
    if (!j)
      return 0; 
    modulusPoly2 = this.field.getOne();
    if (paramArrayOfint2 != null) {
      j = paramArrayOfint2.length;
      for (i = 0; i < j; i++) {
        int k = paramArrayOfint2[i];
        k = this.field.exp(paramArrayOfint1.length - 1 - k);
        modulusPoly2 = modulusPoly2.multiply(new ModulusPoly(this.field, new int[] { this.field.subtract(0, k), 1 }));
      } 
    } 
    ModulusPoly modulusPoly1 = new ModulusPoly(this.field, arrayOfInt3);
    ModulusPoly[] arrayOfModulusPoly = runEuclideanAlgorithm(this.field.buildMonomial(paramInt, 1), modulusPoly1, paramInt);
    modulusPoly2 = arrayOfModulusPoly[0];
    ModulusPoly modulusPoly3 = arrayOfModulusPoly[1];
    int[] arrayOfInt1 = findErrorLocations(modulusPoly2);
    int[] arrayOfInt2 = findErrorMagnitudes(modulusPoly3, modulusPoly2, arrayOfInt1);
    paramInt = bool;
    while (paramInt < arrayOfInt1.length) {
      i = paramArrayOfint1.length - 1 - this.field.log(arrayOfInt1[paramInt]);
      if (i >= 0) {
        paramArrayOfint1[i] = this.field.subtract(paramArrayOfint1[i], arrayOfInt2[paramInt]);
        paramInt++;
        continue;
      } 
      throw ChecksumException.getChecksumInstance();
    } 
    return arrayOfInt1.length;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\decoder\ec\ErrorCorrection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */