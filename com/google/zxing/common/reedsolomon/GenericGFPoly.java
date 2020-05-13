package com.google.zxing.common.reedsolomon;

final class GenericGFPoly {
  private final int[] coefficients;
  
  private final GenericGF field;
  
  GenericGFPoly(GenericGF paramGenericGF, int[] paramArrayOfint) {
    if (paramArrayOfint.length != 0) {
      this.field = paramGenericGF;
      int i = paramArrayOfint.length;
      if (i > 1 && paramArrayOfint[0] == 0) {
        byte b;
        for (b = 1; b < i && paramArrayOfint[b] == 0; b++);
        if (b == i) {
          this.coefficients = new int[] { 0 };
          return;
        } 
        this.coefficients = new int[i - b];
        System.arraycopy(paramArrayOfint, b, this.coefficients, 0, this.coefficients.length);
        return;
      } 
      this.coefficients = paramArrayOfint;
      return;
    } 
    throw new IllegalArgumentException();
  }
  
  GenericGFPoly addOrSubtract(GenericGFPoly paramGenericGFPoly) {
    if (this.field.equals(paramGenericGFPoly.field)) {
      if (isZero())
        return paramGenericGFPoly; 
      if (paramGenericGFPoly.isZero())
        return this; 
      int[] arrayOfInt2 = this.coefficients;
      int[] arrayOfInt3 = paramGenericGFPoly.coefficients;
      int[] arrayOfInt4 = arrayOfInt2;
      int[] arrayOfInt1 = arrayOfInt3;
      if (arrayOfInt2.length > arrayOfInt3.length) {
        arrayOfInt4 = arrayOfInt3;
        arrayOfInt1 = arrayOfInt2;
      } 
      arrayOfInt2 = new int[arrayOfInt1.length];
      int i = arrayOfInt1.length - arrayOfInt4.length;
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, i);
      for (int j = i; j < arrayOfInt1.length; j++)
        arrayOfInt2[j] = GenericGF.addOrSubtract(arrayOfInt4[j - i], arrayOfInt1[j]); 
      return new GenericGFPoly(this.field, arrayOfInt2);
    } 
    throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
  }
  
  GenericGFPoly[] divide(GenericGFPoly paramGenericGFPoly) {
    if (this.field.equals(paramGenericGFPoly.field)) {
      if (!paramGenericGFPoly.isZero()) {
        GenericGFPoly genericGFPoly1 = this.field.getZero();
        int i = paramGenericGFPoly.getCoefficient(paramGenericGFPoly.getDegree());
        int j = this.field.inverse(i);
        GenericGFPoly genericGFPoly2;
        for (genericGFPoly2 = this; genericGFPoly2.getDegree() >= paramGenericGFPoly.getDegree() && !genericGFPoly2.isZero(); genericGFPoly2 = genericGFPoly2.addOrSubtract(genericGFPoly)) {
          i = genericGFPoly2.getDegree() - paramGenericGFPoly.getDegree();
          int k = this.field.multiply(genericGFPoly2.getCoefficient(genericGFPoly2.getDegree()), j);
          GenericGFPoly genericGFPoly = paramGenericGFPoly.multiplyByMonomial(i, k);
          genericGFPoly1 = genericGFPoly1.addOrSubtract(this.field.buildMonomial(i, k));
        } 
        return new GenericGFPoly[] { genericGFPoly1, genericGFPoly2 };
      } 
      throw new IllegalArgumentException("Divide by 0");
    } 
    throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
  }
  
  int evaluateAt(int paramInt) {
    byte b = 0;
    if (paramInt == 0)
      return getCoefficient(0); 
    boolean bool = true;
    if (paramInt == 1) {
      int[] arrayOfInt = this.coefficients;
      int k = arrayOfInt.length;
      paramInt = 0;
      while (b < k) {
        paramInt = GenericGF.addOrSubtract(paramInt, arrayOfInt[b]);
        b++;
      } 
      return paramInt;
    } 
    int i = this.coefficients[0];
    int j = this.coefficients.length;
    for (b = bool; b < j; b++)
      i = GenericGF.addOrSubtract(this.field.multiply(paramInt, i), this.coefficients[b]); 
    return i;
  }
  
  int getCoefficient(int paramInt) {
    return this.coefficients[this.coefficients.length - 1 - paramInt];
  }
  
  int[] getCoefficients() {
    return this.coefficients;
  }
  
  int getDegree() {
    return this.coefficients.length - 1;
  }
  
  boolean isZero() {
    return (this.coefficients[0] == 0);
  }
  
  GenericGFPoly multiply(int paramInt) {
    if (paramInt == 0)
      return this.field.getZero(); 
    if (paramInt == 1)
      return this; 
    int i = this.coefficients.length;
    int[] arrayOfInt = new int[i];
    for (byte b = 0; b < i; b++)
      arrayOfInt[b] = this.field.multiply(this.coefficients[b], paramInt); 
    return new GenericGFPoly(this.field, arrayOfInt);
  }
  
  GenericGFPoly multiply(GenericGFPoly paramGenericGFPoly) {
    if (this.field.equals(paramGenericGFPoly.field)) {
      if (isZero() || paramGenericGFPoly.isZero())
        return this.field.getZero(); 
      int[] arrayOfInt2 = this.coefficients;
      int i = arrayOfInt2.length;
      int[] arrayOfInt1 = paramGenericGFPoly.coefficients;
      int j = arrayOfInt1.length;
      int[] arrayOfInt3 = new int[i + j - 1];
      for (byte b = 0; b < i; b++) {
        int k = arrayOfInt2[b];
        for (byte b1 = 0; b1 < j; b1++) {
          int m = b + b1;
          arrayOfInt3[m] = GenericGF.addOrSubtract(arrayOfInt3[m], this.field.multiply(k, arrayOfInt1[b1]));
        } 
      } 
      return new GenericGFPoly(this.field, arrayOfInt3);
    } 
    throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
  }
  
  GenericGFPoly multiplyByMonomial(int paramInt1, int paramInt2) {
    if (paramInt1 >= 0) {
      if (paramInt2 == 0)
        return this.field.getZero(); 
      int i = this.coefficients.length;
      int[] arrayOfInt = new int[paramInt1 + i];
      for (paramInt1 = 0; paramInt1 < i; paramInt1++)
        arrayOfInt[paramInt1] = this.field.multiply(this.coefficients[paramInt1], paramInt2); 
      return new GenericGFPoly(this.field, arrayOfInt);
    } 
    throw new IllegalArgumentException();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(getDegree() * 8);
    for (int i = getDegree(); i >= 0; i--) {
      int j = getCoefficient(i);
      if (j != 0) {
        int k;
        if (j < 0) {
          stringBuilder.append(" - ");
          k = -j;
        } else {
          k = j;
          if (stringBuilder.length() > 0) {
            stringBuilder.append(" + ");
            k = j;
          } 
        } 
        if (i == 0 || k != 1) {
          k = this.field.log(k);
          if (k == 0) {
            stringBuilder.append('1');
          } else if (k == 1) {
            stringBuilder.append('a');
          } else {
            stringBuilder.append("a^");
            stringBuilder.append(k);
          } 
        } 
        if (i != 0)
          if (i == 1) {
            stringBuilder.append('x');
          } else {
            stringBuilder.append("x^");
            stringBuilder.append(i);
          }  
      } 
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\common\reedsolomon\GenericGFPoly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */