package com.zz.sdk;

import com.zz.sdk.b.a.ac;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.t;

class j extends Thread {
  j(SDKManager paramSDKManager) {}
  
  public void run() {
    bp.b("浮标请求远程状态");
    ac ac = t.a(SDKManager.a(this.a)).c();
    if (ac.c()) {
      if (ac.n == 1) {
        SDKManager.showFloatRemote = true;
        bp.b("浮标远程配置状态: 开启");
        return;
      } 
      SDKManager.showFloatRemote = false;
      bp.b("浮标远程配置状态: 关闭");
      return;
    } 
    bp.b("浮标远程配置状态: 获取失败");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */