package com.herosdk.listener;

import android.util.Log;
import com.herosdk.d.bb;

public class af implements ISinglePayListener {
  private static String a = "frameLib.SPL";
  
  private ISinglePayListener b = null;
  
  public af(ISinglePayListener paramISinglePayListener) {
    this.b = paramISinglePayListener;
  }
  
  public void onFailed(String paramString1, String paramString2, int paramInt) {
    Log.d(a, "onFailed, msg:" + paramString2);
    bb.a(new ah(this, paramString1, paramString2, paramInt));
  }
  
  public void onSuccess(String paramString1, String paramString2, String paramString3) {
    Log.d(a, "onSuccess");
    bb.a(new ag(this, paramString1, paramString2, paramString3));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */