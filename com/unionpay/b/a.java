package com.unionpay.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.unionpay.tsmservice.ITsmCallback;
import com.unionpay.tsmservice.result.VendorPayStatusResult;
import com.unionpay.utils.h;

public final class a extends ITsmCallback.Stub {
  private int a = 4000;
  
  private Handler b;
  
  public a(Handler paramHandler) {
    this.b = paramHandler;
  }
  
  public final void onError(String paramString1, String paramString2) {
    h.b("uppay", "errorCode:" + paramString1 + ", errorDesc:" + paramString2);
    this.b.sendMessage(Message.obtain(this.b, 1, this.a, 0, paramString1 + paramString2));
  }
  
  public final void onResult(Bundle paramBundle) {
    switch (this.a) {
      default:
        return;
      case 4000:
        break;
    } 
    h.b("uppay-spay", "query vendor pay status callback");
    paramBundle.setClassLoader(VendorPayStatusResult.class.getClassLoader());
    paramBundle = ((VendorPayStatusResult)paramBundle.get("result")).getVendorPayStatusResult();
    this.b.sendMessage(Message.obtain(this.b, 4000, paramBundle));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */