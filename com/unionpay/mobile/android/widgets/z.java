package com.unionpay.mobile.android.widgets;

import android.content.Context;
import org.json.JSONObject;

public abstract class z extends ba implements ba.a {
  public z(Context paramContext, JSONObject paramJSONObject, String paramString) {
    super(paramContext, paramJSONObject, paramString);
  }
  
  public String h() {
    StringBuffer stringBuffer = new StringBuffer();
    if (n() != null && a() != null) {
      stringBuffer.append("\"");
      stringBuffer.append(n());
      stringBuffer.append("\":");
      stringBuffer.append("\"");
      stringBuffer.append(a());
      stringBuffer.append("\"");
    } 
    return stringBuffer.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */