package com.herosdk.b;

import android.util.Log;
import com.herosdk.listener.ICommonListener;

class w implements ICommonListener {
  w(u paramu) {}
  
  public void onFailed(int paramInt, String paramString) {}
  
  public void onSuccess(int paramInt, String paramString) {
    Log.d(a.b(), "p id status success...repay");
    this.a.f.b(this.a.c, this.a.b, this.a.d, this.a.e, this.a.a);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */