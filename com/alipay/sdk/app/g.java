package com.alipay.sdk.app;

import com.alipay.sdk.util.H5PayResultModel;

final class g implements Runnable {
  g(PayTask paramPayTask, String paramString, boolean paramBoolean, H5PayCallback paramH5PayCallback) {}
  
  public final void run() {
    H5PayResultModel h5PayResultModel = this.d.h5Pay(this.a, this.b);
    this.c.onPayResult(h5PayResultModel);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\app\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */