package com.zz.sdk.e;

enum ch implements f {
  a, b, c, d, e;
  
  protected static final int f;
  
  static {
    f = e.l.a();
  }
  
  public static ch a(int paramInt) {
    paramInt -= f;
    return (paramInt >= 0 && paramInt < e.ordinal()) ? values()[paramInt] : e;
  }
  
  public int a() {
    return ordinal() + f;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */