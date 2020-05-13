package com.unionpay.mobile.android.pro.views;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.model.a;
import com.unionpay.mobile.android.model.b;

final class w implements Handler.Callback {
  w(v paramv) {}
  
  public final boolean handleMessage(Message paramMessage) {
    a a;
    switch (paramMessage.what) {
      default:
        return true;
      case 2000:
        if (paramMessage.obj != null) {
          a = (a)paramMessage.obj;
          if (a != null)
            v.a(this.a, a); 
        } 
        v.a(this.a, (v.a(this.a)).ap);
      case 2001:
        break;
    } 
    if ("1003100020".equalsIgnoreCase((String)((Message)a).obj))
      if (b.bm)
        v.b(this.a);  
    if (b.bm)
      v.a(this.a, (v.c(this.a)).ap, "fail"); 
    v.b(this.a, (v.d(this.a)).ap);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\views\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */