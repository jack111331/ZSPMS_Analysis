package com.tencent.wxop.stat.b;

public class h {
  static {
    boolean bool;
    if (!h.class.desiredAssertionStatus()) {
      bool = true;
    } else {
      bool = false;
    } 
    cH = bool;
  }
  
  public static byte[] d(byte[] paramArrayOfbyte) {
    int i = paramArrayOfbyte.length;
    j j = new j(new byte[i * 3 / 4]);
    if (!j.a(paramArrayOfbyte, i))
      throw new IllegalArgumentException("bad base-64"); 
    if (j.g == j.cI.length)
      return j.cI; 
    paramArrayOfbyte = new byte[j.g];
    System.arraycopy(j.cI, 0, paramArrayOfbyte, 0, j.g);
    return paramArrayOfbyte;
  }
  
  public static byte[] e(byte[] paramArrayOfbyte) {
    int i = paramArrayOfbyte.length;
    k k = new k();
    int j = i / 3 * 4;
    if (k.ba) {
      int n = j;
      if (i % 3 > 0)
        n = j + 4; 
    } 
    int m = j;
    switch (i % 3) {
      case 0:
        j = m;
        if (k.bb) {
          j = m;
          if (i > 0) {
            int n = (i - 1) / 57;
            if (k.cP) {
              j = 2;
            } else {
              break;
            } 
            j = m + j * (n + 1);
          } 
        } 
        k.cI = new byte[j];
        k.a(paramArrayOfbyte, i);
        if (!cH && k.g != j)
          throw new AssertionError(); 
        return k.cI;
      default:
        m = j;
      case 1:
        m = j + 2;
      case 2:
        m = j + 3;
    } 
    j = 1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */