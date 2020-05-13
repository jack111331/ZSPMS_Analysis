package com.sdk.mobile.manager.a.b;

import android.content.Context;
import com.sdk.base.api.CallBack;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.c.b;

public class a extends SDKManager {
  private static volatile a b;
  
  private Context c;
  
  private a(Context paramContext) {
    this.c = paramContext;
  }
  
  public static a a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/sdk/mobile/manager/a/b/a.b : Lcom/sdk/mobile/manager/a/b/a;
    //   3: ifnonnull -> 31
    //   6: ldc com/sdk/mobile/manager/a/b/a
    //   8: monitorenter
    //   9: getstatic com/sdk/mobile/manager/a/b/a.b : Lcom/sdk/mobile/manager/a/b/a;
    //   12: ifnonnull -> 28
    //   15: new com/sdk/mobile/manager/a/b/a
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: invokespecial <init> : (Landroid/content/Context;)V
    //   24: aload_1
    //   25: putstatic com/sdk/mobile/manager/a/b/a.b : Lcom/sdk/mobile/manager/a/b/a;
    //   28: ldc com/sdk/mobile/manager/a/b/a
    //   30: monitorexit
    //   31: getstatic com/sdk/mobile/manager/a/b/a.b : Lcom/sdk/mobile/manager/a/b/a;
    //   34: areturn
    //   35: astore_0
    //   36: ldc com/sdk/mobile/manager/a/b/a
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   9	28	35	finally
    //   28	31	35	finally
    //   36	39	35	finally
  }
  
  public <T> void a(int paramInt, CallBack<T> paramCallBack) {
    if (paramInt <= 0) {
      a(paramCallBack, 100002, "超时时间不合法");
      return;
    } 
    (new b(this.c, paramInt, paramCallBack)).a(1);
  }
  
  public <T> void a(String paramString, int paramInt, CallBack<T> paramCallBack) {
    if (paramInt <= 0) {
      a(paramCallBack, 100002, "超时时间不合法");
      return;
    } 
    if (com.sdk.base.framework.utils.k.a.a(paramString).booleanValue()) {
      a(paramCallBack, 100002, "授权码不能为空！");
      return;
    } 
    (new b(this.c, paramInt, paramCallBack)).a(paramString);
  }
  
  public <T> void a(String paramString1, String paramString2, int paramInt, CallBack<T> paramCallBack) {
    if (paramInt <= 0) {
      a(paramCallBack, 100002, "超时时间不合法");
      return;
    } 
    if (com.sdk.base.framework.utils.k.a.a(paramString1).booleanValue()) {
      a(paramCallBack, 100002, "授权码不能为空！");
      return;
    } 
    if (com.sdk.base.framework.utils.k.a.a(paramString2).booleanValue()) {
      a(paramCallBack, 100002, "置换手机号不能为空！");
      return;
    } 
    (new b(this.c, paramInt, paramCallBack)).a(paramString1, paramString2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\mobile\manager\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */