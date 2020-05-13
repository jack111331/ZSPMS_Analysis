package com.cmic.sso.sdk.b.b;

import android.content.Context;
import android.os.Bundle;
import com.cmic.sso.sdk.b.a.i;
import com.cmic.sso.sdk.b.c.a;
import com.cmic.sso.sdk.utils.aa;
import com.cmic.sso.sdk.utils.ac;
import com.cmic.sso.sdk.utils.o;
import com.cmic.sso.sdk.utils.y;

public class c extends a {
  private c() {}
  
  public c(Context paramContext) {
    super(paramContext);
  }
  
  public void b(Context paramContext, Bundle paramBundle, b paramb) {
    i i = new i();
    i.b("1.0");
    i.c("quick_login_android_5.6.5.1");
    i.d(paramBundle.getString("appid"));
    i.e(ac.a());
    i.f(y.a());
    i.g("3");
    i.h(paramBundle.getString("phonenumber"));
    String str = ac.a();
    i.i(o.a().a(str));
    i.a("2.0");
    i.j(i.a(paramBundle.getString("appkey"), str, o.a()));
    str = paramBundle.getString("interfacetype", "");
    paramBundle.putString("interfacetype", str + "sendsms;");
    str = aa.j(paramContext) + "rs/sendsms";
    a.a(aa.a(paramContext, aa.j(paramContext)));
    a(str, i, false, paramBundle, paramb);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\b\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */