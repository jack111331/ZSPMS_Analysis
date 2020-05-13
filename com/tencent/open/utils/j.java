package com.tencent.open.utils;

public final class j implements Cloneable {
  private long a;
  
  public j(long paramLong) {
    this.a = paramLong;
  }
  
  public byte[] a() {
    return new byte[] { (byte)(int)(this.a & 0xFFL), (byte)(int)((this.a & 0xFF00L) >> 8L), (byte)(int)((this.a & 0xFF0000L) >> 16L), (byte)(int)((this.a & 0xFF000000L) >> 24L) };
  }
  
  public long b() {
    return this.a;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramObject != null) {
      if (!(paramObject instanceof j))
        return bool1; 
    } else {
      return bool2;
    } 
    bool2 = bool1;
    if (this.a == ((j)paramObject).b())
      bool2 = true; 
    return bool2;
  }
  
  public int hashCode() {
    return (int)this.a;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\ope\\utils\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */