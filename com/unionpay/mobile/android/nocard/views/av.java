package com.unionpay.mobile.android.nocard.views;

import android.text.TextUtils;
import android.view.View;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;

final class av implements View.OnClickListener {
  av(at paramat) {}
  
  public final void onClick(View paramView) {
    JSONObject jSONObject = (JSONObject)paramView.getTag();
    String str2 = j.a(jSONObject, "errMsg");
    if (str2 != null && !TextUtils.isEmpty(str2)) {
      this.a.a(str2);
      return;
    } 
    str2 = j.a(jSONObject, "action");
    String str1 = j.a(jSONObject, "value");
    at.a(this.a, str2, str1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */