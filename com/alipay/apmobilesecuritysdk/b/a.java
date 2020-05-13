package com.alipay.apmobilesecuritysdk.b;

public final class a {
  private static a b = new a();
  
  private int a = 0;
  
  public static a a() {
    return b;
  }
  
  public final void a(int paramInt) {
    this.a = paramInt;
  }
  
  public final int b() {
    return this.a;
  }
  
  public final String c() {
    String str = null;
    if (!com.alipay.security.mobile.module.a.a.b(null)) {
      switch (this.a) {
        default:
          return "https://mobilegw.alipay.com/mgw.htm";
        case 1:
          return "http://mobilegw.stable.alipay.net/mgw.htm";
        case 3:
          return "http://mobilegw-1-64.test.alipay.net/mgw.htm";
        case 2:
          return "https://mobilegw.alipay.com/mgw.htm";
        case 4:
          break;
      } 
      str = "http://mobilegw.aaa.alipay.net/mgw.htm";
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */