package com.unionpay.a;

import com.unionpay.utils.h;
import java.util.HashMap;

public final class d {
  private int a = 1;
  
  private String b;
  
  private HashMap c;
  
  private byte[] d;
  
  public d(String paramString) {
    this.b = paramString;
    this.c = null;
    this.d = null;
  }
  
  public final int a() {
    return this.a;
  }
  
  public final void a(String paramString) {
    h.b("uppay", "encrypt postData: " + paramString);
    if (paramString != null)
      this.d = paramString.getBytes(); 
  }
  
  public final String b() {
    return this.b;
  }
  
  public final HashMap c() {
    return this.c;
  }
  
  public final byte[] d() {
    return this.d;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */