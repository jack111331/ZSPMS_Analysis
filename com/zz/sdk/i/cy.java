package com.zz.sdk.i;

import android.app.Activity;
import android.content.Context;
import com.zz.sdk.floatdlg.c.a;

final class cy implements Runnable {
  public void run() {
    Activity activity = cv.i();
    if (cv.l() == null)
      cv.a(new a((Context)activity)); 
    cv.l().a(new cz(this, activity));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */