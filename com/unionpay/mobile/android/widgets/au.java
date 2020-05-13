package com.unionpay.mobile.android.widgets;

import android.content.Context;
import org.json.JSONObject;

public final class au extends aa {
  public au(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString) {
    super(paramContext, paramInt, paramJSONObject, paramString);
  }
  
  public final boolean b() {
    String str;
    if (this.i)
      return true; 
    if (a() != null) {
      str = a();
    } else {
      str = "";
    } 
    return (this.j != null && this.j.length() > 0) ? str.matches(this.j) : ((str.length() > 0 && str.length() <= 64));
  }
  
  protected final String d() {
    return "login_user";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */