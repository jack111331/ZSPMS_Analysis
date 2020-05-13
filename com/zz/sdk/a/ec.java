package com.zz.sdk.a;

import android.content.Context;
import com.zz.sdk.i.cv;
import com.zz.sdk.lib.widget.q;

class ec implements q {
  ec(eb parameb) {}
  
  public void a() {
    cv.a((Context)this.a.b, eb.a(this.a).findFocus());
    if (eb.b(this.a) != null) {
      String str1 = eb.a(this.a).getCode();
      if (eb.c(this.a).equals("phoneLogin")) {
        eb.a(this.a, eb.b(this.a), str1);
        return;
      } 
      if (eb.c(this.a).equals("newPhoneBind")) {
        eb.b(this.a, eb.b(this.a), str1);
        return;
      } 
      if (eb.c(this.a).equals("phoneBind")) {
        eb.b(this.a, eb.b(this.a), str1);
        return;
      } 
      if (eb.c(this.a).equals("forgetPwd")) {
        eb.c(this.a, eb.b(this.a), str1);
        return;
      } 
      if (eb.c(this.a).equals("upgradeAccount"))
        eb.d(this.a, eb.b(this.a), str1); 
      return;
    } 
    String str = eb.a(this.a).getCode();
    if (eb.c(this.a).equals("emailForgetPwd"))
      eb.e(this.a, eb.d(this.a), str); 
  }
  
  public void a(boolean paramBoolean) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */