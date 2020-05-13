package com.zz.sdk.a;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

class hs implements DownloadListener {
  hs(hp paramhp) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {
    try {
      Intent intent = new Intent();
      this("android.intent.action.VIEW");
      intent.setData(Uri.parse(paramString1));
      this.a.b.startActivity(intent);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\hs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */