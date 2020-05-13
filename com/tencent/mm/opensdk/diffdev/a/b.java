package com.tencent.mm.opensdk.diffdev.a;

import android.util.Log;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.Iterator;

final class b implements OAuthListener {
  b(a parama) {}
  
  public final void onAuthFinish(OAuthErrCode paramOAuthErrCode, String paramString) {
    Log.d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", new Object[] { paramOAuthErrCode.toString(), paramString }));
    a.c(this.k);
    ArrayList arrayList = new ArrayList();
    arrayList.addAll(a.a(this.k));
    Iterator<OAuthListener> iterator = arrayList.iterator();
    while (iterator.hasNext())
      ((OAuthListener)iterator.next()).onAuthFinish(paramOAuthErrCode, paramString); 
  }
  
  public final void onAuthGotQrcode(String paramString, byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder("onAuthGotQrcode, qrcodeImgPath = ");
    stringBuilder.append(paramString);
    Log.d("MicroMsg.SDK.ListenerWrapper", stringBuilder.toString());
    ArrayList arrayList = new ArrayList();
    arrayList.addAll(a.a(this.k));
    Iterator<OAuthListener> iterator = arrayList.iterator();
    while (iterator.hasNext())
      ((OAuthListener)iterator.next()).onAuthGotQrcode(paramString, paramArrayOfbyte); 
  }
  
  public final void onQrcodeScanned() {
    Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
    if (a.b(this.k) != null)
      a.b(this.k).post(new c(this)); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\diffdev\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */