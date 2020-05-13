package com.google.zxing.pdf417.decoder.ec;

final class ModulusPoly {
  private final int[] coefficients;
  
  private final ModulusGF field;
  
  ModulusPoly(ModulusGF paramModulusGF, int[] paramArrayOfint) {
    if (paramArrayOfint.length != 0) {
      this.field = paramModulusGF;
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
  
  ModulusPoly add(ModulusPoly paramModulusPoly) {
    if (this.field.equals(paramModulusPoly.field)) {
      if (isZero())
        return paramModulusPoly; 
      if (paramModulusPoly.isZero())
        return this; 
      int[] arrayOfInt2 = this.coefficients;
      int[] arrayOfInt3 = paramModulusPoly.coefficients;
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
        arrayOfInt2[j] = this.field.add(arrayOfInt4[j - i], arrayOfInt1[j]); 
      return new ModulusPoly(this.field, arrayOfInt2);
    } 
    throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
  }
  
  int evaluateAt(int paramInt) {
    int i = 0;
    if (paramInt == 0)
      return getCoefficient(0); 
    int j = 1;
    if (paramInt == 1) {
      int[] arrayOfInt = this.coefficients;
      int n = arrayOfInt.length;
      paramInt = 0;
      while (i < n) {
        j = arrayOfInt[i];
        paramInt = this.field.add(paramInt, j);
        i++;
      } 
      return paramInt;
    } 
    int k = this.coefficients[0];
    int m = this.coefficients.length;
    for (i = j; i < m; i++)
      k = this.field.add(this.field.multiply(paramInt, k), this.coefficients[i]); 
    return k;
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
  
  ModulusPoly multiply(int paramInt) {
    if (paramInt == 0)
      return this.field.getZero(); 
    if (paramInt == 1)
      return this; 
    int i = this.coefficients.length;
    int[] arrayOfInt = new int[i];
    for (byte b = 0; b < i; b++)
      arrayOfInt[b] = this.field.multiply(this.coefficients[b], paramInt); 
    return new ModulusPoly(this.field, arrayOfInt);
  }
  
  ModulusPoly multiply(ModulusPoly paramModulusPoly) {
    if (this.field.equals(paramModulusPoly.field)) {
      if (isZero() || paramModulusPoly.isZero())
        return this.field.getZero(); 
      int[] arrayOfInt2 = this.coefficients;
      int i = arrayOfInt2.length;
      int[] arrayOfInt1 = paramModulusPoly.coefficients;
      int j = arrayOfInt1.length;
      int[] arrayOfInt3 = new int[i + j - 1];
      for (byte b = 0; b < i; b++) {
        int k = arrayOfInt2[b];
        for (byte b1 = 0; b1 < j; b1++) {
          int m = b + b1;
          arrayOfInt3[m] = this.field.add(arrayOfInt3[m], this.field.multiply(k, arrayOfInt1[b1]));
        } 
      } 
      return new ModulusPoly(this.field, arrayOfInt3);
    } 
    throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
  }
  
  ModulusPoly multiplyByMonomial(int paramInt1, int paramInt2) {
    if (paramInt1 >= 0) {
      if (paramInt2 == 0)
        return this.field.getZero(); 
      int i = this.coefficients.length;
      int[] arrayOfInt = new int[paramInt1 + i];
      for (paramInt1 = 0; paramInt1 < i; paramInt1++)
        arrayOfInt[paramInt1] = this.field.multiply(this.coefficients[paramInt1], paramInt2); 
      return new ModulusPoly(this.field, arrayOfInt);
    } 
    throw new IllegalArgumentException();
  }
  
  ModulusPoly negative() {
    int i = this.coefficients.length;
    int[] arrayOfInt = new int[i];
    for (byte b = 0; b < i; b++)
      arrayOfInt[b] = this.field.subtract(0, this.coefficients[b]); 
    return new ModulusPoly(this.field, arrayOfInt);
  }
  
  ModulusPoly subtract(ModulusPoly paramModulusPoly) {
    if (this.field.equals(paramModulusPoly.field))
      return paramModulusPoly.isZero() ? this : add(paramModulusPoly.negative()); 
    throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
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
        if (i == 0 || k != 1)
          stringBuilder.append(k); 
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\decoder\ec\ModulusPoly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */