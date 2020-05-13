package com.sdk.mobile.c.a;

import android.view.View;
import com.sdk.mobile.c.a;
import com.sdk.mobile.manager.login.ctc.OauthActivityCtc;

public class b implements a {
  private OauthActivityCtc a;
  
  public b(OauthActivityCtc paramOauthActivityCtc) {
    this.a = paramOauthActivityCtc;
  }
  
  public View a(int paramInt) {
    return this.a.findViewById(paramInt);
  }
  
  public String a() {
    return this.a.a();
  }
  
  public void b() {
    this.a.b();
  }
  
  public void c() {
    this.a.finish();
  }
  
  public void d() {
    this.a.c();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\mobile\c\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */