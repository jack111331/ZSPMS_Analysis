package com.unionpay.client3.tsm;

import android.os.Bundle;

public interface ITsmTransCallback {
  void onFailed(int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  void onSuccess(int paramInt1, int paramInt2, Bundle paramBundle);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\client3\tsm\ITsmTransCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */