package com.zz.sdk.i;

public enum au implements aj {
  a(av.a, "sdksrv/"),
  b(a, "auth/"),
  c(av.b, "sdksrv/"),
  d(a, "c1/auth/"),
  e(a, "c1/"),
  f(a, "c1/auth/email/"),
  g(a, "c1/product/giftpkg/"),
  h(a, "c1/user/heartbeat/"),
  i;
  
  private av j;
  
  private au k;
  
  private String l;
  
  au(av paramav, au paramau, String paramString1) {
    this.j = paramav;
    this.k = paramau;
    this.l = paramString1;
  }
  
  public String a() {
    return (this.k != null) ? (this.k.a() + this.l) : ((this.j != null) ? (this.j.a() + this.l) : this.l);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */