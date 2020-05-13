package com.zz.sdk.b;

public enum l {
  a(0, "成功"),
  b(0, "支付成功"),
  c(1, "用户不存在"),
  d(1, "产生订单失败");
  
  private static final int h = 1000;
  
  private final int e;
  
  private final int f;
  
  private final String g;
  
  l(int paramInt1, int paramInt2, String paramString1) {
    this.e = paramInt1;
    this$enum$index = paramInt2;
    if (paramInt2 < 0)
      this$enum$index = ordinal(); 
    this.f = this$enum$index;
    this.g = paramString1;
  }
  
  l(int paramInt1, String paramString1) {
    this.e = paramInt1;
    this.g = paramString1;
    this.f = ordinal() + 1000;
  }
  
  public int a() {
    return this.e;
  }
  
  public int b() {
    return this.f;
  }
  
  public String c() {
    return this.g;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */