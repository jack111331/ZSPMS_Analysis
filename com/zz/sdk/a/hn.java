package com.zz.sdk.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.cm;

class hn extends Handler {
  hn(hl paramhl) {}
  
  public void handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        return;
      case 0:
        hl.d(this.a);
        Toast.makeText((Context)this.a.b, this.a.e(2131165292), 0).show();
        bp.a("CachedLoginName:" + hl.a(this.a).j());
        cm.a((Context)this.a.b, hl.a(this.a).j(), "saved");
        hl.a(this.a, (Context)this.a.b);
      case 1:
        hl.d(this.a);
        Toast.makeText((Context)this.a.b, this.a.e(2131165293), 0).show();
        hl.a(this.a, (Context)this.a.b);
      case 2:
        break;
    } 
    hl.d(this.a);
    Toast.makeText((Context)this.a.b, this.a.e(2131165294), 1).show();
    hl.a(this.a, (Context)this.a.b);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\hn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */