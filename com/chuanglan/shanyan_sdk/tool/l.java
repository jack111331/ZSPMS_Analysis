package com.chuanglan.shanyan_sdk.tool;

import android.content.Context;

public class l {
  private static l a;
  
  private ShanYanUIConfig b;
  
  private l(Context paramContext) {
    if (paramContext != null)
      paramContext.getApplicationContext(); 
  }
  
  public static l a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/chuanglan/shanyan_sdk/tool/l.a : Lcom/chuanglan/shanyan_sdk/tool/l;
    //   3: ifnonnull -> 31
    //   6: ldc com/chuanglan/shanyan_sdk/tool/l
    //   8: monitorenter
    //   9: getstatic com/chuanglan/shanyan_sdk/tool/l.a : Lcom/chuanglan/shanyan_sdk/tool/l;
    //   12: ifnonnull -> 28
    //   15: new com/chuanglan/shanyan_sdk/tool/l
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: invokespecial <init> : (Landroid/content/Context;)V
    //   24: aload_1
    //   25: putstatic com/chuanglan/shanyan_sdk/tool/l.a : Lcom/chuanglan/shanyan_sdk/tool/l;
    //   28: ldc com/chuanglan/shanyan_sdk/tool/l
    //   30: monitorexit
    //   31: getstatic com/chuanglan/shanyan_sdk/tool/l.a : Lcom/chuanglan/shanyan_sdk/tool/l;
    //   34: areturn
    //   35: astore_0
    //   36: ldc com/chuanglan/shanyan_sdk/tool/l
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   9	28	35	finally
    //   28	31	35	finally
    //   36	39	35	finally
  }
  
  public ShanYanUIConfig a() {
    if (this.b == null)
      this.b = (new ShanYanUIConfig.Builder()).build(); 
    return this.b;
  }
  
  public void a(ShanYanUIConfig paramShanYanUIConfig) {
    this.b = paramShanYanUIConfig;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\tool\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */