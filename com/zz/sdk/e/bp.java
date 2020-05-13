package com.zz.sdk.e;

public enum bp implements f {
  a, b;
  
  protected static final int c;
  
  static {
    c = e.l.a();
  }
  
  public static final bp a(int paramInt) {
    paramInt -= c;
    return (paramInt >= 0 && paramInt < b.ordinal()) ? values()[paramInt] : b;
  }
  
  public final int a() {
    return ordinal() + c;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */