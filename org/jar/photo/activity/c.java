package org.jar.photo.activity;

import android.os.Handler;
import java.io.File;
import org.jar.bloc.usercenter.d.s;

class c implements Runnable {
  c(ThumbSelectActivity paramThumbSelectActivity) {}
  
  public void run() {
    Handler handler;
    e e;
    if (s.a(new File(ThumbSelectActivity.a(this.a).b())).intValue() > 100.0D || ThumbSelectActivity.a(this.a).c() > 600000) {
      handler = ThumbSelectActivity.b(this.a);
      d d = new d(this);
    } else {
      handler = ThumbSelectActivity.b(this.a);
      e = new e(this);
    } 
    handler.post(e);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\activity\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */