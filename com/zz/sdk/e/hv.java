package com.zz.sdk.e;

enum hv implements f {
  A, B, a, b, c, d, e, f, g, h, i, j, k, l, n, o, p, q, r, s, t, u, v, w, x, y, z;
  
  protected static int C;
  
  static {
    A = new hv("TV_PAY_ACTIVITY", 25);
    B = new hv("_MAX_", 26);
    D = new hv[] { 
        a, b, c, d, e, f, g, h, i, j, 
        k, l, n, o, p, q, r, s, t, u, 
        v, w, x, y, z, A, B };
    C = o.i.a();
  }
  
  public static final hv a(int paramInt) {
    paramInt -= C;
    return (paramInt >= 0 && paramInt < B.ordinal()) ? values()[paramInt] : B;
  }
  
  public final int a() {
    return ordinal() + C;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\hv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */