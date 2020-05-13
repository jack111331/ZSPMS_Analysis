package com.zz.sdk.i;

import android.content.Context;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zz.sdk.b.a.ab;

final class i extends Thread {
  i(Context paramContext, Handler paramHandler, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, LinearLayout paramLinearLayout3) {}
  
  public void run() {
    ab ab = t.a(this.a).g("1");
    if (ab.c()) {
      h.b(ab);
      this.b.post(new j(this, ab));
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */