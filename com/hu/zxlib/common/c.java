package com.hu.zxlib.common;

import android.app.Activity;
import com.hu.scan.permission.b;
import com.hu.scan.permission.n;

final class c implements Runnable {
  c(Activity paramActivity, String paramString) {}
  
  public void run() {
    try {
      n n = b.b(this.a).a(new String[] { "android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE" });
      e e = new e();
      this(this);
      n = n.a(e);
      d d = new d();
      this(this);
      n.b(d).a();
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\common\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */