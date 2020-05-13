package com.zz.sdk.floatdlg.b;

import android.content.ClipboardManager;
import com.zz.sdk.i.cv;

class aw implements Runnable {
  aw(as paramas, String paramString1, String paramString2) {}
  
  public void run() {
    try {
      ((ClipboardManager)this.c.getActivity().getSystemService("clipboard")).setText(this.a);
      cv.r(this.b);
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */