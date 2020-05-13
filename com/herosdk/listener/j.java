package com.herosdk.listener;

import android.util.Log;

class j implements Runnable {
  j(i parami, int paramInt, String paramString) {}
  
  public void run() {
    if (i.a(this.c) != null) {
      Log.d(i.a(), "onResult...if");
      i.a(this.c).onResult(this.a, this.b);
      return;
    } 
    Log.d(i.a(), "onResult...else");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */