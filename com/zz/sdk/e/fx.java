package com.zz.sdk.e;

enum fx implements f {
  a, b, c, d, e, f, g, h;
  
  protected static int i;
  
  static {
    i = o.i.a();
  }
  
  public static final fx a(int paramInt) {
    paramInt -= i;
    return (paramInt >= 0 && paramInt < h.ordinal()) ? values()[paramInt] : h;
  }
  
  public final int a() {
    return ordinal() + i;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\fx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */