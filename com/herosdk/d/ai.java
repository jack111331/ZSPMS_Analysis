package com.herosdk.d;

import android.text.TextUtils;
import android.util.Log;
import com.herosdk.HeroSdk;
import com.herosdk.listener.ISinglePayListener;
import java.util.List;

class ai implements ISinglePayListener {
  ai(x paramx, List paramList) {}
  
  public void onFailed(String paramString1, String paramString2, int paramInt) {
    Log.d("frameLib.mus", "ccsp...oF");
    x.a(this.b);
  }
  
  public void onSuccess(String paramString1, String paramString2, String paramString3) {
    Log.d("frameLib.mus", "ccsp if...onSuccess");
    if (!TextUtils.isEmpty(paramString3)) {
      if (HeroSdk.getInstance().getSinglePayListener() != null) {
        Log.d("frameLib.mus", "ccsp if...onSuccess,return");
        HeroSdk.getInstance().getSinglePayListener().onSuccess(paramString1, paramString2, paramString3);
      } 
    } else {
      Log.d("frameLib.mus", "ccsp if...onSuccess sk is empty");
      e.a().a(paramString1);
    } 
    x.a(this.b);
    this.b.a(this.a);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */