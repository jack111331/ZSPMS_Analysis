package com.alipay.sdk.util;

public enum d {
  a(0, "WIFI"),
  b(1, "unicom2G"),
  c(2, "mobile2G"),
  d(4, "telecom2G"),
  e(5, "telecom3G"),
  f(6, "telecom3G"),
  g(12, "telecom3G"),
  h(8, "unicom3G"),
  i(3, "unicom3G"),
  j(13, "LTE"),
  k(11, "IDEN"),
  l(9, "HSUPA"),
  m(10, "HSPA"),
  n(15, "HSPAP"),
  o(-1, "none");
  
  public String p;
  
  private int q;
  
  d(int paramInt1, String paramString1) {
    this.q = paramInt1;
    this.p = paramString1;
  }
  
  private int a() {
    return this.q;
  }
  
  public static d a(int paramInt) {
    // Byte code:
    //   0: invokestatic values : ()[Lcom/alipay/sdk/util/d;
    //   3: astore_1
    //   4: aload_1
    //   5: arraylength
    //   6: istore_2
    //   7: iconst_0
    //   8: istore_3
    //   9: iload_3
    //   10: iload_2
    //   11: if_icmpge -> 37
    //   14: aload_1
    //   15: iload_3
    //   16: aaload
    //   17: astore #4
    //   19: aload #4
    //   21: getfield q : I
    //   24: iload_0
    //   25: if_icmpne -> 31
    //   28: aload #4
    //   30: areturn
    //   31: iinc #3, 1
    //   34: goto -> 9
    //   37: getstatic com/alipay/sdk/util/d.o : Lcom/alipay/sdk/util/d;
    //   40: astore #4
    //   42: goto -> 28
  }
  
  private String b() {
    return this.p;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sd\\util\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */