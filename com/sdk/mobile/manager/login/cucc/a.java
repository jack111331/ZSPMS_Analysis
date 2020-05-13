package com.sdk.mobile.manager.login.cucc;

import android.content.Context;
import android.content.Intent;
import com.sdk.base.api.CallBack;
import com.sdk.base.api.OnCustomViewListener;
import com.sdk.base.api.UiOauthListener;
import com.sdk.base.framework.bean.OauthResultMode;
import com.sdk.base.framework.c.c;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.c.b;
import com.sdk.mobile.c.d;
import com.sdk.mobile.manager.login.b;
import java.io.Serializable;

public class a extends SDKManager {
  private static final String b = a.class.getSimpleName();
  
  private static Boolean c = Boolean.valueOf(c.h);
  
  private static volatile a h;
  
  private Context d;
  
  private OnCustomViewListener e;
  
  private OauthResultMode f;
  
  private UiOauthListener g;
  
  private a(Context paramContext) {
    this.d = paramContext;
  }
  
  public static a a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/sdk/mobile/manager/login/cucc/a.h : Lcom/sdk/mobile/manager/login/cucc/a;
    //   3: ifnonnull -> 31
    //   6: ldc com/sdk/mobile/manager/login/cucc/a
    //   8: monitorenter
    //   9: getstatic com/sdk/mobile/manager/login/cucc/a.h : Lcom/sdk/mobile/manager/login/cucc/a;
    //   12: ifnonnull -> 28
    //   15: new com/sdk/mobile/manager/login/cucc/a
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: invokespecial <init> : (Landroid/content/Context;)V
    //   24: aload_1
    //   25: putstatic com/sdk/mobile/manager/login/cucc/a.h : Lcom/sdk/mobile/manager/login/cucc/a;
    //   28: ldc com/sdk/mobile/manager/login/cucc/a
    //   30: monitorexit
    //   31: getstatic com/sdk/mobile/manager/login/cucc/a.h : Lcom/sdk/mobile/manager/login/cucc/a;
    //   34: areturn
    //   35: astore_0
    //   36: ldc com/sdk/mobile/manager/login/cucc/a
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   9	28	35	finally
    //   28	31	35	finally
    //   36	39	35	finally
  }
  
  private b b(int paramInt, CallBack paramCallBack) {
    return new b(this.d, paramInt, new CallBack<Object>(this, paramCallBack) {
          public void onFailed(int param1Int1, int param1Int2, String param1String) {
            this.a.onFailed(param1Int1, param1Int2, param1String);
          }
          
          public void onSuccess(int param1Int1, String param1String1, int param1Int2, Object param1Object, String param1String2) {
            if (param1Int1 == 0)
              a.a(this.b, new OauthResultMode(param1Int1, param1String1, param1Int2, param1Object, param1String2)); 
            this.a.onSuccess(param1Int1, param1String1, param1Int2, null, param1String2);
          }
        });
  }
  
  public void a(int paramInt, CallBack paramCallBack) {
    if (paramInt <= 0) {
      a(paramCallBack, 100002, "超时时间不合法!");
      return;
    } 
    b(paramInt, paramCallBack).a(0);
  }
  
  public void a(OnCustomViewListener paramOnCustomViewListener) {
    this.e = paramOnCustomViewListener;
  }
  
  void a(OauthResultMode paramOauthResultMode, OauthActivity paramOauthActivity) {
    d d;
    if (this.g != null) {
      d = new d(paramOauthActivity);
      if (paramOauthResultMode.getSeq() != null) {
        this.g.onSuccess(paramOauthResultMode, (com.sdk.mobile.c.a)d);
        this.g = null;
        return;
      } 
    } else {
      return;
    } 
    this.g.onFailed(paramOauthResultMode, (com.sdk.mobile.c.a)d);
    this.g = null;
  }
  
  public void a(b paramb, UiOauthListener paramUiOauthListener) {
    if (paramb == null) {
      paramUiOauthListener.onFailed(new OauthResultMode(1, "UiConfig 不能为空", 100002), null);
      return;
    } 
    if (this.f == null) {
      paramUiOauthListener.onFailed(new OauthResultMode(1, "登录结果不能为空！", 100002), null);
      return;
    } 
    Intent intent = new Intent(this.d, OauthActivity.class);
    intent.putExtra("uiConfig", (Serializable)paramb);
    intent.putExtra("resultMode", (Serializable)this.f);
    intent.addFlags(268435456);
    this.d.startActivity(intent);
    this.g = paramUiOauthListener;
    this.f = null;
  }
  
  OnCustomViewListener d() {
    return this.e;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\mobile\manager\login\cucc\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */