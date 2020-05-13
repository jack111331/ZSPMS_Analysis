package com.zz.sdk.e;

enum fc implements f {
  a, b, c, d, e, f, g, h, i, j, k, l;
  
  protected static int n;
  
  static {
    n = o.i.a();
  }
  
  public static final fc a(int paramInt) {
    paramInt -= n;
    return (paramInt >= 0 && paramInt < l.ordinal()) ? values()[paramInt] : l;
  }
  
  public final int a() {
    return ordinal() + n;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\fc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */