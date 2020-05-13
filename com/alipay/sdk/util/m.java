package com.alipay.sdk.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

final class m implements DownloadListener {
  m(Context paramContext) {}
  
  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {
    try {
      Uri uri = Uri.parse(paramString1);
      Intent intent = new Intent();
      this("android.intent.action.VIEW", uri);
      intent.setFlags(268435456);
      this.a.startActivity(intent);
    } catch (Throwable throwable) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sd\\util\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */