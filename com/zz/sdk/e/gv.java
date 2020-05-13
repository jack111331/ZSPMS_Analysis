package com.zz.sdk.e;

enum gv implements f {
  a, b, c, d, e, f, g, h, i, j, k, l, n, o, p;
  
  protected static int q;
  
  static {
    q = o.i.a();
  }
  
  public static final gv a(int paramInt) {
    paramInt -= q;
    return (paramInt >= 0 && paramInt < p.ordinal()) ? values()[paramInt] : p;
  }
  
  public final int a() {
    return ordinal() + q;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\gv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */