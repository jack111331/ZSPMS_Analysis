package com.tencent.mm.sdk.openapi;

import android.util.Log;
import com.tencent.wxop.stat.e;

class WXApiImplV10$ActivityLifecycleCb$1 implements Runnable {
  public void run() {
    if (WXApiImplV10.access$100() != null && WXApiImplV10.ActivityLifecycleCb.access$200(WXApiImplV10.ActivityLifecycleCb.this)) {
      Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", "WXStat trigger onBackground");
      e.d(WXApiImplV10.ActivityLifecycleCb.access$300(WXApiImplV10.ActivityLifecycleCb.this), "onBackground_WX");
      WXApiImplV10.ActivityLifecycleCb.access$202(WXApiImplV10.ActivityLifecycleCb.this, false);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\openapi\WXApiImplV10$ActivityLifecycleCb$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */