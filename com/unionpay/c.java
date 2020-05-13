package com.unionpay;

import android.os.Bundle;

final class c implements UPQuerySEPayInfoCallback {
  public final void onError(String paramString1, String paramString2, String paramString3, String paramString4) {
    UPPayAssistEx.c(paramString2);
    UPPayAssistEx.n();
  }
  
  public final void onResult(String paramString1, String paramString2, int paramInt, Bundle paramBundle) {
    UPPayAssistEx.c(paramString2);
    UPPayAssistEx.n();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */