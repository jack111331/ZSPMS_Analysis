package com.herosdk.b;

import android.util.Log;
import com.herosdk.listener.ICommonListener;

class h implements ICommonListener {
  h(g paramg) {}
  
  public void onFailed(int paramInt, String paramString) {
    Log.d(a.b(), "rom id status failed code:" + paramInt + ",msg:" + paramString);
  }
  
  public void onSuccess(int paramInt, String paramString) {
    Log.d(a.b(), "rom id status success");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */