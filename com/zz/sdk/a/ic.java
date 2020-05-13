package com.zz.sdk.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.t;

class ic implements View.OnClickListener {
  ic(hy paramhy) {}
  
  public void onClick(View paramView) {
    boolean bool;
    t.a((Context)this.a.b).b("Bind_platform", "bind_phone_other", 1);
    String str = cq.a((Context)this.a.b).b();
    if (!TextUtils.isEmpty(str)) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool) {
      str = cm.a((Context)this.a.b, "bind_email" + (cq.a((Context)this.a.b)).a.o);
      if (TextUtils.isEmpty(str)) {
        bv.a(this.a.b, by.class, this.a.z().a("key_show_close", Boolean.valueOf(false)).a("key_show_back", Boolean.valueOf(true)).a("key_overlay", Boolean.valueOf(false)));
        return;
      } 
      bv.a(this.a.b, cn.class, this.a.z().a("key_show_close", Boolean.valueOf(false)).a("key_show_back", Boolean.valueOf(true)).a("key_overlay", Boolean.valueOf(false)).a("bind_state", Boolean.valueOf(bool)).a("email", str));
      return;
    } 
    cm.a((Context)this.a.b, "bind_email" + (cq.a((Context)this.a.b)).a.o, "");
    bv.a(this.a.b, cn.class, this.a.z().a("key_show_close", Boolean.valueOf(false)).a("key_show_back", Boolean.valueOf(true)).a("key_overlay", Boolean.valueOf(false)).a("bind_state", Boolean.valueOf(bool)).a("email", str));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */