package com.zz.sdk.e;

enum ef implements f {
  a, b, c, d, e;
  
  protected static int f;
  
  static {
    f = o.i.a();
  }
  
  public static final ef a(int paramInt) {
    paramInt -= f;
    return (paramInt >= 0 && paramInt < e.ordinal()) ? values()[paramInt] : e;
  }
  
  public final int a() {
    return ordinal() + f;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */