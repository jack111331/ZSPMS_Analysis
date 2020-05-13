package com.cmic.sso.sdk.utils;

public class i {
  private static i a = null;
  
  private a b;
  
  private b c;
  
  public static i a() {
    // Byte code:
    //   0: getstatic com/cmic/sso/sdk/utils/i.a : Lcom/cmic/sso/sdk/utils/i;
    //   3: ifnonnull -> 30
    //   6: ldc com/cmic/sso/sdk/utils/i
    //   8: monitorenter
    //   9: getstatic com/cmic/sso/sdk/utils/i.a : Lcom/cmic/sso/sdk/utils/i;
    //   12: ifnonnull -> 27
    //   15: new com/cmic/sso/sdk/utils/i
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/cmic/sso/sdk/utils/i.a : Lcom/cmic/sso/sdk/utils/i;
    //   27: ldc com/cmic/sso/sdk/utils/i
    //   29: monitorexit
    //   30: getstatic com/cmic/sso/sdk/utils/i.a : Lcom/cmic/sso/sdk/utils/i;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/cmic/sso/sdk/utils/i
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public void a(a parama) {
    this.b = parama;
  }
  
  public void a(b paramb) {
    this.c = paramb;
  }
  
  public a b() {
    return this.b;
  }
  
  public b c() {
    return this.c;
  }
  
  public void d() {
    if (this.b != null)
      this.b = null; 
  }
  
  public void e() {
    if (this.c != null)
      this.c = null; 
  }
  
  public static interface a {
    void a();
  }
  
  public static interface b {
    void a();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */