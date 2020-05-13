package com.zz.sdk.floatdlg.b;

import android.os.Message;
import com.zz.sdk.b.a.aa;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.t;

class az implements Runnable {
  az(ax paramax) {}
  
  public void run() {
    aa aa = t.a(ax.b(this.a)).d(ax.b(this.a));
    if (aa.c()) {
      Message message = new Message();
      message.what = 101;
      message.obj = aa;
      ax.c(this.a).sendMessage(message);
      return;
    } 
    bp.a("获取礼包状态失败：" + aa.f());
    cv.r(this.a.getString(ci.a(ax.b(this.a)).a(2131165467)));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */