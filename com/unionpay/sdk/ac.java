package com.unionpay.sdk;

import android.os.Message;

final class ac implements Runnable {
  ac(String paramString, boolean paramBoolean) {}
  
  public final void run() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this("onPause being called! pageName: ");
      ay.a(stringBuilder.append(this.a).toString());
      w.a a = new w.a();
      this();
      a.a.put("isPageOrSession", Boolean.valueOf(this.b));
      a.a.put("apiType", Integer.valueOf(3));
      a.a.put("occurTime", String.valueOf(System.currentTimeMillis()));
      a.a.put("pageName", this.a);
      Message.obtain(aw.a(), 102, a).sendToTarget();
    } catch (Throwable throwable) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */