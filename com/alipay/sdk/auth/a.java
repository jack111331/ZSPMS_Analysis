package com.alipay.sdk.auth;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

final class a implements DownloadListener {
  a(AuthActivity paramAuthActivity) {}
  
  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {
    try {
      Uri uri = Uri.parse(paramString1);
      Intent intent = new Intent();
      this("android.intent.action.VIEW", uri);
      this.a.startActivity(intent);
    } catch (Throwable throwable) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\auth\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */