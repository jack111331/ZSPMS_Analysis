package com.herosdk.listener;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.herosdk.HeroSdk;
import com.herosdk.d.e;

class ab implements ISinglePayListener {
  ab(y paramy, String paramString) {}
  
  public void onFailed(String paramString1, String paramString2, int paramInt) {
    if (paramInt == 2) {
      Log.d(y.a(), "cspr...ongoing");
      (new Handler(Looper.getMainLooper())).postDelayed(new ac(this, paramString1, paramString2, paramInt), 3000L);
      return;
    } 
    Log.d(y.a(), "=>cspr...onFailed,return");
    y.a(this.b, 0);
    if (HeroSdk.getInstance().getSinglePayListener() != null) {
      e.a().a(paramString1, paramString2);
      HeroSdk.getInstance().getSinglePayListener().onFailed(paramString1, paramString2, paramInt);
    } 
  }
  
  public void onSuccess(String paramString1, String paramString2, String paramString3) {
    Log.d(y.a(), "cspr...onSuccess");
    y.a(this.b, 0);
    if (!TextUtils.isEmpty(paramString3)) {
      if (HeroSdk.getInstance().getSinglePayListener() != null) {
        Log.d(y.a(), "cspr...onSuccess,return");
        e.a().a(paramString1, paramString2);
        HeroSdk.getInstance().getSinglePayListener().onSuccess(paramString1, paramString2, paramString3);
      } 
      return;
    } 
    Log.d(y.a(), "cspr...onSuccess status key is empty");
    e.a().a(paramString1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */