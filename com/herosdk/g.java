package com.herosdk;

import com.herosdk.d.bb;
import com.herosdk.listener.IPayListener;

class g implements IPayListener {
  g(f paramf) {}
  
  public void onCancel(String paramString) {
    bb.a(new j(this, paramString));
  }
  
  public void onFailed(String paramString1, String paramString2) {
    bb.a(new i(this, paramString1, paramString2));
  }
  
  public void onSuccess(String paramString1, String paramString2, String paramString3) {
    bb.a(new h(this, paramString1, paramString3, paramString2));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */