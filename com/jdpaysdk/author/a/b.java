package com.jdpaysdk.author.a;

import com.jdpaysdk.author.a.a.b;
import com.jdpaysdk.author.a.b.a;
import com.jdpaysdk.author.a.e.c;
import com.jdpaysdk.author.a.f.b;
import okhttp3.Call;
import okhttp3.OkHttpClient;

public class b {
  private static volatile b a;
  
  private OkHttpClient b;
  
  private b c;
  
  public b(OkHttpClient paramOkHttpClient) {
    if (paramOkHttpClient == null) {
      this.b = new OkHttpClient();
    } else {
      this.b = paramOkHttpClient;
    } 
    this.c = b.a();
  }
  
  public static b a() {
    return a(null);
  }
  
  public static b a(OkHttpClient paramOkHttpClient) {
    // Byte code:
    //   0: getstatic com/jdpaysdk/author/a/b.a : Lcom/jdpaysdk/author/a/b;
    //   3: ifnonnull -> 31
    //   6: ldc com/jdpaysdk/author/a/b
    //   8: monitorenter
    //   9: getstatic com/jdpaysdk/author/a/b.a : Lcom/jdpaysdk/author/a/b;
    //   12: ifnonnull -> 28
    //   15: new com/jdpaysdk/author/a/b
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: invokespecial <init> : (Lokhttp3/OkHttpClient;)V
    //   24: aload_1
    //   25: putstatic com/jdpaysdk/author/a/b.a : Lcom/jdpaysdk/author/a/b;
    //   28: ldc com/jdpaysdk/author/a/b
    //   30: monitorexit
    //   31: getstatic com/jdpaysdk/author/a/b.a : Lcom/jdpaysdk/author/a/b;
    //   34: areturn
    //   35: astore_0
    //   36: ldc com/jdpaysdk/author/a/b
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   9	28	35	finally
    //   28	31	35	finally
    //   36	39	35	finally
  }
  
  public static b c() {
    return new b();
  }
  
  public void a(c paramc, a parama) {
    a a1 = parama;
    if (parama == null)
      a1 = a.a; 
    int i = paramc.b().d();
    paramc.a().enqueue(new c(this, a1, i));
  }
  
  public void a(Object paramObject, a parama, int paramInt) {
    if (parama != null)
      this.c.a(new e(this, parama, paramObject, paramInt)); 
  }
  
  public void a(Call paramCall, Exception paramException, a parama, int paramInt) {
    if (parama != null)
      this.c.a(new d(this, parama, paramCall, paramException, paramInt)); 
  }
  
  public OkHttpClient b() {
    return this.b;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */