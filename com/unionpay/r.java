package com.unionpay;

import android.content.Context;
import com.unionpay.utils.UPUtils;
import java.util.Iterator;
import org.json.JSONObject;

final class r implements ac {
  r(UPPayWapActivity paramUPPayWapActivity) {}
  
  public final void a(String paramString, ad paramad) {
    try {
      JSONObject jSONObject = new JSONObject();
      this(paramString);
      Iterator<String> iterator = jSONObject.keys();
      while (iterator.hasNext()) {
        paramString = iterator.next();
        UPUtils.a((Context)this.a, jSONObject.getString(paramString), paramString);
      } 
    } catch (Exception exception) {
      if (paramad != null) {
        UPPayWapActivity uPPayWapActivity = this.a;
        paramad.a(UPPayWapActivity.a("1", exception.getMessage(), (String)null));
      } 
      return;
    } 
    if (paramad != null) {
      UPPayWapActivity uPPayWapActivity = this.a;
      paramad.a(UPPayWapActivity.a("0", "success", (String)null));
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */