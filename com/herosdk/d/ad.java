package com.herosdk.d;

import android.util.Log;

class ad implements Runnable {
  ad(ac paramac, String paramString) {}
  
  public void run() {
    try {
      if (Integer.parseInt(this.a.substring(this.a.indexOf(":") + 1, this.a.indexOf(","))) == 1) {
        Log.d("frameLib.mus", "dhl but new add forbidden");
        String str = this.a.substring(this.a.lastIndexOf(":") + 1);
        bb.a(this.b.b, str, Boolean.valueOf(false));
        return;
      } 
    } catch (Exception exception) {}
    this.b.a.onFailed(this.a);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */