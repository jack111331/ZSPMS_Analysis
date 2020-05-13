package com.herosdk.d;

import android.util.Log;
import com.herosdk.bean.c;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.f;

class z implements f {
  z(x paramx) {}
  
  public void a(int paramInt, String paramString) {
    Log.d("frameLib.mus", "rei...f code:" + paramInt + ",msg:" + paramString);
    x.a().a(2);
    x.a().a(paramInt, paramString);
  }
  
  public void a(c paramc) {
    try {
      Log.d("frameLib.mus", "rei...s");
      x.a().a(paramc);
      x.a().a(1);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */