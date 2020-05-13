package com.tencent.open.utils;

public final class k implements Cloneable {
  private int a;
  
  public k(int paramInt) {
    this.a = paramInt;
  }
  
  public k(byte[] paramArrayOfbyte) {
    this(paramArrayOfbyte, 0);
  }
  
  public k(byte[] paramArrayOfbyte, int paramInt) {
    this.a = paramArrayOfbyte[paramInt + 1] << 8 & 0xFF00;
    this.a += paramArrayOfbyte[paramInt] & 0xFF;
  }
  
  public byte[] a() {
    return new byte[] { (byte)(this.a & 0xFF), (byte)((this.a & 0xFF00) >> 8) };
  }
  
  public int b() {
    return this.a;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramObject != null) {
      if (!(paramObject instanceof k))
        return bool1; 
    } else {
      return bool2;
    } 
    bool2 = bool1;
    if (this.a == ((k)paramObject).b())
      bool2 = true; 
    return bool2;
  }
  
  public int hashCode() {
    return this.a;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\ope\\utils\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */