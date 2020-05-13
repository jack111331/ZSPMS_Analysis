package com.google.zxing.pdf417.decoder.ec;

public final class ModulusGF {
  public static final ModulusGF PDF417_GF = new ModulusGF(929, 3);
  
  private final int[] expTable;
  
  private final int[] logTable;
  
  private final int modulus;
  
  private final ModulusPoly one;
  
  private final ModulusPoly zero;
  
  private ModulusGF(int paramInt1, int paramInt2) {
    this.modulus = paramInt1;
    this.expTable = new int[paramInt1];
    this.logTable = new int[paramInt1];
    byte b = 0;
    int i = 1;
    while (b < paramInt1) {
      this.expTable[b] = i;
      i = i * paramInt2 % paramInt1;
      b++;
    } 
    for (paramInt2 = 0; paramInt2 < paramInt1 - 1; paramInt2++)
      this.logTable[this.expTable[paramInt2]] = paramInt2; 
    this.zero = new ModulusPoly(this, new int[] { 0 });
    this.one = new ModulusPoly(this, new int[] { 1 });
  }
  
  int add(int paramInt1, int paramInt2) {
    return (paramInt1 + paramInt2) % this.modulus;
  }
  
  ModulusPoly buildMonomial(int paramInt1, int paramInt2) {
    if (paramInt1 >= 0) {
      if (paramInt2 == 0)
        return this.zero; 
      int[] arrayOfInt = new int[paramInt1 + 1];
      arrayOfInt[0] = paramInt2;
      return new ModulusPoly(this, arrayOfInt);
    } 
    throw new IllegalArgumentException();
  }
  
  int exp(int paramInt) {
    return this.expTable[paramInt];
  }
  
  ModulusPoly getOne() {
    return this.one;
  }
  
  int getSize() {
    return this.modulus;
  }
  
  ModulusPoly getZero() {
    return this.zero;
  }
  
  int inverse(int paramInt) {
    if (paramInt != 0)
      return this.expTable[this.modulus - this.logTable[paramInt] - 1]; 
    throw new ArithmeticException();
  }
  
  int log(int paramInt) {
    if (paramInt != 0)
      return this.logTable[paramInt]; 
    throw new IllegalArgumentException();
  }
  
  int multiply(int paramInt1, int paramInt2) {
    return (paramInt1 == 0 || paramInt2 == 0) ? 0 : this.expTable[(this.logTable[paramInt1] + this.logTable[paramInt2]) % (this.modulus - 1)];
  }
  
  int subtract(int paramInt1, int paramInt2) {
    return (this.modulus + paramInt1 - paramInt2) % this.modulus;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\decoder\ec\ModulusGF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */