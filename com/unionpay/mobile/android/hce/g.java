package com.unionpay.mobile.android.hce;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.utils.k;

final class g implements Handler.Callback {
  g(f paramf) {}
  
  public final boolean handleMessage(Message paramMessage) {
    String str2;
    Bundle bundle;
    d d1;
    switch (paramMessage.what) {
      default:
        return false;
      case 2001:
        f.a(this.a);
        this.a.b();
      case 2002:
        str2 = (String)paramMessage.obj;
        f.a(this.a, str2);
      case 2003:
        bundle = (Bundle)((Message)str2).obj;
        if (bundle != null) {
          String str3 = bundle.getString("pkgName");
          boolean bool = bundle.getBoolean("success");
          String str4 = bundle.getString("result");
          String str5 = bundle.getString("reserved");
          k.c("yitong", "result: " + str4);
          d d = (d)f.b(this.a).get(str3);
          d1 = d;
          if (d == null)
            d1 = new d(str3); 
          if (bool) {
            d1.a(str4);
            d1.b(str5);
          } 
          d1.e();
          f.b(this.a).put(str3, d1);
          f.a(this.a, str3);
        } 
      case 2006:
        object = ((Message)d1).obj;
        break;
      case 2005:
        break;
    } 
    String str1 = (String)((Message)d1).obj;
    d d2 = (d)f.b(this.a).get(str1);
    Object object = f.c(this.a).get(str1);
    d2.f();
    f.b(this.a).put(str1, d2);
    object.e();
    f.c(this.a).put(str1, object);
    f.a(this.a, str1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\hce\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */