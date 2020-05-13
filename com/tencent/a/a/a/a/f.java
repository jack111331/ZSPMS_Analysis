package com.tencent.a.a.a.a;

import android.content.Context;

public abstract class f {
  protected Context e = null;
  
  protected f(Context paramContext) {
    this.e = paramContext;
  }
  
  public final void a(c paramc) {
    if (paramc != null) {
      String str = paramc.toString();
      if (a())
        b(h.g(str)); 
    } 
  }
  
  protected abstract boolean a();
  
  protected abstract String b();
  
  protected abstract void b(String paramString);
  
  public final c e() {
    String str;
    c c = null;
    if (a()) {
      str = h.f(b());
    } else {
      str = null;
    } 
    if (str != null)
      c = c.c(str); 
    return c;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\a\a\a\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */