package com.unionpay.mobile.android.pro.views;

import android.text.TextUtils;
import android.view.View;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;

final class aa implements View.OnClickListener {
  aa(y paramy) {}
  
  public final void onClick(View paramView) {
    String str1;
    JSONObject jSONObject = (JSONObject)paramView.getTag();
    String str2 = j.a(jSONObject, "errMsg");
    if (str2 != null && !TextUtils.isEmpty(str2)) {
      y.d(this.a, str2);
      return;
    } 
    str2 = j.a(jSONObject, "action");
    String str3 = j.a(jSONObject, "value");
    if ((y.m(this.a)).br) {
      str1 = "10";
    } else {
      str1 = "2";
    } 
    y.a(this.a, str2, str3 + ",\"carrier_tp\":" + str1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\views\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */