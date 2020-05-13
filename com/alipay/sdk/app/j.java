package com.alipay.sdk.app;

public enum j {
  a(9000, "处理成功"),
  b(4000, "系统繁忙，请稍后再试"),
  c(6001, "用户取消"),
  d(6002, "网络连接异常"),
  e(4001, "参数错误"),
  f(5000, "重复请求"),
  g(8000, "支付结果确认中");
  
  public int h;
  
  public String i;
  
  j(int paramInt1, String paramString1) {
    this.h = paramInt1;
    this.i = paramString1;
  }
  
  private int a() {
    return this.h;
  }
  
  public static j a(int paramInt) {
    switch (paramInt) {
      default:
        return b;
      case 9000:
        return a;
      case 6001:
        return c;
      case 6002:
        return d;
      case 4001:
        return e;
      case 8000:
        return g;
      case 5000:
        break;
    } 
    return f;
  }
  
  private void a(String paramString) {
    this.i = paramString;
  }
  
  private String b() {
    return this.i;
  }
  
  private void b(int paramInt) {
    this.h = paramInt;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\app\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */