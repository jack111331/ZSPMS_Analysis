package com.herosdk.activity;

import android.webkit.DownloadListener;

class e implements DownloadListener {
  e(HuwActivity paramHuwActivity) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {
    HuwActivity.a(this.a, paramString1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\activity\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */