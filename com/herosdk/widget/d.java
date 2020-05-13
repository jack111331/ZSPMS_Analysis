package com.herosdk.widget;

enum d implements e {
  a, b, c, d, e, f;
  
  public static final d a(int paramInt) {
    paramInt -= 20190130;
    return (paramInt >= 0 && paramInt < f.ordinal()) ? values()[paramInt] : f;
  }
  
  public final int a() {
    return ordinal() + 20190130;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\widget\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */