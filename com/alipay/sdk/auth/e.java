package com.alipay.sdk.auth;

import android.content.Context;
import android.webkit.SslErrorHandler;
import com.alipay.sdk.widget.d;

final class e implements Runnable {
  e(AuthActivity.b paramb, SslErrorHandler paramSslErrorHandler) {}
  
  public final void run() {
    d.a((Context)this.b.a, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new f(this), "退出", new g(this));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\auth\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */