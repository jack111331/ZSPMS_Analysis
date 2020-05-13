package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;

public final class at extends aa {
  private int c = 0;
  
  public at(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString) {
    super(paramContext, paramInt, paramJSONObject, paramString);
    String str = j.a(paramJSONObject, "maxLength");
    if (str != null && str.length() > 0) {
      this.c = Integer.getInteger(str).intValue();
    } else {
      this.c = 23;
    } 
    this.b.a((InputFilter)new InputFilter.LengthFilter(this.c));
  }
  
  public final boolean b() {
    boolean bool = true;
    if (!this.i && this.c < a().length())
      bool = false; 
    return bool;
  }
  
  protected final String d() {
    return "_input_text";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */