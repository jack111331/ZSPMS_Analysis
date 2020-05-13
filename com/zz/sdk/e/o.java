package com.zz.sdk.e;

enum o implements f {
  a, b, c, d, e, f, g, h, i;
  
  protected static final int j;
  
  static {
    j = e.l.a();
  }
  
  public static o a(int paramInt) {
    paramInt -= j;
    return (paramInt >= 0 && paramInt < i.ordinal()) ? values()[paramInt] : i;
  }
  
  public final int a() {
    return ordinal() + j;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */