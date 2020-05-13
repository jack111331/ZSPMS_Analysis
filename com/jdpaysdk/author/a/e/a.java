package com.jdpaysdk.author.a.e;

import java.util.Map;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;

public abstract class a {
  protected String a;
  
  protected Object b;
  
  protected Map<String, String> c;
  
  protected Map<String, String> d;
  
  protected int e;
  
  protected Request.Builder f = new Request.Builder();
  
  protected a(String paramString, Object paramObject, Map<String, String> paramMap1, Map<String, String> paramMap2, int paramInt) {
    this.a = paramString;
    this.b = paramObject;
    this.c = paramMap1;
    this.d = paramMap2;
    this.e = paramInt;
    if (paramString == null)
      com.jdpaysdk.author.a.f.a.a("url can not be null.", new Object[0]); 
    e();
  }
  
  private void e() {
    this.f.url(this.a).tag(this.b);
    c();
  }
  
  public Request a(com.jdpaysdk.author.a.b.a parama) {
    return a(a(a(), parama));
  }
  
  protected abstract Request a(RequestBody paramRequestBody);
  
  protected abstract RequestBody a();
  
  protected RequestBody a(RequestBody paramRequestBody, com.jdpaysdk.author.a.b.a parama) {
    return paramRequestBody;
  }
  
  public c b() {
    return new c(this);
  }
  
  protected void c() {
    Headers.Builder builder = new Headers.Builder();
    if (this.d != null && !this.d.isEmpty()) {
      for (String str : this.d.keySet())
        builder.add(str, this.d.get(str)); 
      this.f.headers(builder.build());
    } 
  }
  
  public int d() {
    return this.e;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\a\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */