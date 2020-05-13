package com.unionpay.mobile.android.pro.views;

import android.text.TextUtils;
import android.view.View;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;

final class n implements View.OnClickListener {
  n(k paramk) {}
  
  public final void onClick(View paramView) {
    JSONObject jSONObject = (JSONObject)paramView.getTag();
    String str1 = j.a(jSONObject, "errMsg");
    if (str1 != null && !TextUtils.isEmpty(str1)) {
      k.d(this.a, str1);
      return;
    } 
    str1 = j.a(jSONObject, "action");
    String str2 = j.a(jSONObject, "value");
    k.a(this.a, str1, str2 + ",\"carrier_tp\":\"7\"");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\views\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */