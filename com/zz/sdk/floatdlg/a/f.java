package com.zz.sdk.floatdlg.a;

import android.content.ClipboardManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.zz.sdk.b.h;
import com.zz.sdk.floatdlg.b.as;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cv;

class f implements Runnable {
  f(c paramc, String paramString, h paramh) {}
  
  public void run() {
    try {
      ((ClipboardManager)c.a(this.c).getSystemService("clipboard")).setText(this.a);
      cv.r(c.a(this.c).getString(ci.a(c.a(this.c), 2131165469)));
      c.b(this.c).a();
      ((FragmentActivity)c.a(this.c)).getSupportFragmentManager().beginTransaction().replace(2131296257, (Fragment)as.a(this.b)).addToBackStack(null).commit();
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */