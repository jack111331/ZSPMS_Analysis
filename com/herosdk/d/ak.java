package com.herosdk.d;

import android.content.Context;
import android.util.Log;
import com.herosdk.widget.c;

class ak implements Runnable {
  ak(x paramx, Context paramContext) {}
  
  public void run() {
    if (x.b(this.b) != null && x.b(this.b).isShowing()) {
      Log.d("frameLib.mus", "slpd...return");
      return;
    } 
    try {
      String str1 = x.a().n().b();
      String str2 = str1.substring(str1.lastIndexOf("|") + 1);
      str1 = str2.substring(0, str2.indexOf(","));
      String str3 = str2.substring(str2.indexOf(",") + 1, str2.lastIndexOf(","));
      str2 = str2.substring(str2.lastIndexOf(",") + 1);
      c.a.clear();
      c.a.add(str1);
      c.a.add(str3);
      c.a.add(str2);
    } catch (Exception exception) {
      c.a.clear();
      c.a.add("看不到登录框");
      c.a.add("登录失败");
      c.a.add("其他");
    } 
    x.a(this.b, new c(this.a));
    x.b(this.b).setCanceledOnTouchOutside(false);
    x.b(this.b).setCancelable(false);
    x.b(this.b).a(new al(this));
    x.b(this.b).show();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */