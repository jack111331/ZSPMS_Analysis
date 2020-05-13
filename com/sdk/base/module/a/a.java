package com.sdk.base.module.a;

import android.content.Context;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.handler.CrashHandler;

public class a {
  private static final String a = a.class.getName();
  
  private static final Boolean b = Boolean.valueOf(c.h);
  
  private static a c;
  
  private Context d;
  
  private a(Context paramContext) {
    this.d = paramContext;
  }
  
  public static a a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/sdk/base/module/a/a.c : Lcom/sdk/base/module/a/a;
    //   3: ifnonnull -> 25
    //   6: ldc com/sdk/base/module/a/a
    //   8: monitorenter
    //   9: new com/sdk/base/module/a/a
    //   12: astore_1
    //   13: aload_1
    //   14: aload_0
    //   15: invokespecial <init> : (Landroid/content/Context;)V
    //   18: aload_1
    //   19: putstatic com/sdk/base/module/a/a.c : Lcom/sdk/base/module/a/a;
    //   22: ldc com/sdk/base/module/a/a
    //   24: monitorexit
    //   25: getstatic com/sdk/base/module/a/a.c : Lcom/sdk/base/module/a/a;
    //   28: areturn
    //   29: astore_0
    //   30: ldc com/sdk/base/module/a/a
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   9	25	29	finally
    //   30	33	29	finally
  }
  
  private void a(String paramString) {
    if (com.sdk.base.framework.utils.k.a.b(paramString).booleanValue())
      com.sdk.base.framework.utils.a.a.a(this.d, "api_key", paramString); 
  }
  
  private void b(String paramString) {
    com.sdk.base.framework.utils.a.a.a(this.d, "public_key", paramString);
  }
  
  public void a(Boolean paramBoolean, String paramString1, String paramString2) {
    b(paramString2);
    a(paramString1);
    CrashHandler.a().a(this.d);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\module\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */