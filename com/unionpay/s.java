package com.unionpay;

import android.content.Context;
import com.unionpay.utils.UPUtils;

final class s implements ac {
  s(UPPayWapActivity paramUPPayWapActivity) {}
  
  public final void a(String paramString, ad paramad) {
    String str = UPUtils.a((Context)this.a, paramString);
    if (paramad != null) {
      UPPayWapActivity uPPayWapActivity = this.a;
      paramad.a(UPPayWapActivity.a("0", "success", str));
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */