package com.zz.sdk.i;

import android.os.Build;
import com.zz.sdk.b.a.a;

class u implements Runnable {
  u(t paramt, String paramString1, String paramString2, int paramInt, String paramString3) {}
  
  public void run() {
    this.e.a(a.class, at.al.a(), 1, new String[] { 
          "sid", cv.j(t.b(this.e)), "vo", Build.VERSION.RELEASE, "devNum", cv.n(t.b(this.e)), "key", this.a, "type", this.b, 
          "value", String.valueOf(this.c), "time", String.valueOf(System.currentTimeMillis() / 1000L), "access_token", this.d });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */