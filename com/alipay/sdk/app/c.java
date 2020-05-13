package com.alipay.sdk.app;

import android.content.Context;
import android.webkit.SslErrorHandler;
import com.alipay.sdk.widget.d;

final class c implements Runnable {
  c(b paramb, SslErrorHandler paramSslErrorHandler) {}
  
  public final void run() {
    d.a((Context)b.a(this.b), "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，可能存在风险，请选择是否继续？", "继续", new d(this), "退出", new e(this));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\app\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */