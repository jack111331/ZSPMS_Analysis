package com.unionpay.mobile.android.pro.views;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.hce.a;
import org.json.JSONObject;

final class b implements Handler.Callback {
  b(a parama) {}
  
  public final boolean handleMessage(Message paramMessage) {
    Bundle bundle;
    switch (paramMessage.what) {
      default:
        return true;
      case 2004:
        a.a(this.a).removeMessages(2006);
        bundle = (Bundle)paramMessage.obj;
        if (bundle != null)
          if (bundle.getBoolean("success")) {
            String str = a.a(bundle.getString("result"), a.b(this.a).f());
            try {
              JSONObject jSONObject = new JSONObject();
              this(str);
              a a1 = this.a;
              if (!a.d(jSONObject)) {
                a.b(this.a, (a.d(this.a)).ap);
                return false;
              } 
            } catch (Exception exception) {
              a.a(this.a, (a.c(this.a)).ap);
              exception.printStackTrace();
              return false;
            } 
            a.a(this.a, (a.e(this.a).a()).b, a.f(this.a));
          } else {
            a.c(this.a, (a.g(this.a)).ap);
          }  
      case 2006:
        break;
    } 
    a.d(this.a, (a.h(this.a)).ap);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\views\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */