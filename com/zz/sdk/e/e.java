package com.zz.sdk.e;

enum e implements f {
  a, b, c, d, e, f, g, h, i, j, k, l;
  
  public static final e a(int paramInt) {
    paramInt -= 20130926;
    return (paramInt >= 0 && paramInt < l.ordinal()) ? values()[paramInt] : l;
  }
  
  public final int a() {
    return ordinal() + 20130926;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */