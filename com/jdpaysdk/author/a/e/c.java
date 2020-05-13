package com.jdpaysdk.author.a.e;

import com.jdpaysdk.author.a.b;
import com.jdpaysdk.author.a.b.a;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class c {
  private a a;
  
  private Request b;
  
  private Call c;
  
  private long d;
  
  private long e;
  
  private long f;
  
  private OkHttpClient g;
  
  public c(a parama) {
    this.a = parama;
  }
  
  private Request c(a parama) {
    return this.a.a(parama);
  }
  
  public Call a() {
    return this.c;
  }
  
  public Call a(a parama) {
    long l = 10000L;
    this.b = c(parama);
    if (this.d > 0L || this.e > 0L || this.f > 0L) {
      if (this.d > 0L) {
        l1 = this.d;
      } else {
        l1 = 10000L;
      } 
      this.d = l1;
      if (this.e > 0L) {
        l1 = this.e;
      } else {
        l1 = 10000L;
      } 
      this.e = l1;
      long l1 = l;
      if (this.f > 0L)
        l1 = this.f; 
      this.f = l1;
      this.g = b.a().b().newBuilder().readTimeout(this.d, TimeUnit.MILLISECONDS).writeTimeout(this.e, TimeUnit.MILLISECONDS).connectTimeout(this.f, TimeUnit.MILLISECONDS).build();
      this.c = this.g.newCall(this.b);
      return this.c;
    } 
    this.c = b.a().b().newCall(this.b);
    return this.c;
  }
  
  public a b() {
    return this.a;
  }
  
  public void b(a parama) {
    a(parama);
    if (parama != null)
      parama.a(this.b, b().d()); 
    b.a().a(this, parama);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\a\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */