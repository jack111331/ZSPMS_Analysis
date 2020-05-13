package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter;
import org.json.JSONObject;

public final class e extends aa {
  public e(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString) {
    super(paramContext, paramInt, paramJSONObject, paramString);
    this.b.a((InputFilter)new InputFilter.LengthFilter(3));
    this.b.a(18);
  }
  
  public final boolean b() {
    return (3 == a().length());
  }
  
  protected final String d() {
    return "_input_cvn2";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */