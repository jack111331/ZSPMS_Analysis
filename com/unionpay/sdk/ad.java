package com.unionpay.sdk;

import android.os.Message;
import java.util.HashMap;

final class ad implements Runnable {
  ad(int paramInt, String paramString) {}
  
  public final void run() {
    try {
      if (w.a) {
        String str;
        w.a a = new w.a();
        this();
        a.a.put("apiType", Integer.valueOf(this.a));
        a.a.put("occurTime", String.valueOf(System.currentTimeMillis()));
        HashMap<String, String> hashMap = a.a;
        if (this.b == null) {
          str = "";
        } else {
          str = k.a(this.b);
        } 
        hashMap.put("pageName", str);
        Message.obtain(aw.a(), 102, a).sendToTarget();
      } 
    } catch (Throwable throwable) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */