package com.zz.sdk.e;

import android.content.Intent;
import com.zz.sdk.g.b;
import com.zz.sdk.i.bp;
import org.json.JSONObject;

class cl extends b {
  static final String a = "JDP_PAY_SUCCESS";
  
  static final String b = "JDP_PAY_FAIL";
  
  static final String c = "JDP_PAY_CANCEL";
  
  private cl(cj paramcj) {}
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramIntent != null) {
      String str = paramIntent.getStringExtra("jdpay_Result");
    } else {
      paramIntent = null;
    } 
    bp.b("pay_result=" + paramIntent);
    if (1024 == paramInt2 && paramIntent != null && this.d.h()) {
      try {
        JSONObject jSONObject = new JSONObject();
        this((String)paramIntent);
        String str = jSONObject.optString("payStatus", "JDP_PAY_FAIL");
        this.d.g();
        if ("JDP_PAY_SUCCESS".equalsIgnoreCase(str)) {
          cj.a(this.d);
        } else if ("JDP_PAY_FAIL".equalsIgnoreCase(str)) {
          cj.b(this.d);
        } else if ("JDP_PAY_CANCEL".equalsIgnoreCase(str)) {
          cj.c(this.d);
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
        cj.b(this.d);
      } 
      return true;
    } 
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */