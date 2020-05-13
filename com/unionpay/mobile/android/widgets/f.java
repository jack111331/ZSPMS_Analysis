package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter;
import org.json.JSONObject;

public final class f extends aa {
  public f(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString) {
    super(paramContext, paramInt, paramJSONObject, paramString);
    this.b.a((InputFilter)new InputFilter.LengthFilter(32));
  }
  
  public final boolean b() {
    return (a().length() != 0 && a().length() <= 32);
  }
  
  protected final String d() {
    return "_input_certId";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */