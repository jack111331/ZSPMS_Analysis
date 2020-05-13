package com.zz.sdk.floatdlg.a;

import android.content.ClipboardManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.zz.sdk.b.a.f;
import com.zz.sdk.floatdlg.b.as;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cv;

class k implements Runnable {
  k(j paramj, f paramf) {}
  
  public void run() {
    try {
      ((FragmentActivity)h.b(this.b.c)).getSupportFragmentManager().beginTransaction().replace(2131296257, (Fragment)as.a(this.b.a)).addToBackStack(null).commit();
      ((ClipboardManager)h.b(this.b.c).getSystemService("clipboard")).setText(this.a.g());
      cv.r(h.b(this.b.c).getString(ci.a(h.b(this.b.c), 2131165469)));
      h.c(this.b.c);
      h.d(this.b.c).a();
      h h = this.b.c;
      l l = new l();
      this(this);
      h.a(h, l);
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */