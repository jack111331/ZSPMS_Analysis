package com.zz.sdk.a;

import android.content.Context;
import com.zz.sdk.i.ci;

class ju implements Runnable {
  ju(jt paramjt) {}
  
  public void run() {
    jl.h(this.a.a).setText(this.a.a.b.getString(ci.a((Context)this.a.a.b, 2131165247), new Object[] { jl.k(this.a.a) + "" }));
    if (jl.k(this.a.a) == 0) {
      jl.l(this.a.a);
      jl.a(this.a.a, 90);
      if (!jl.m(this.a.a)) {
        jl.h(this.a.a).setText(this.a.a.e(2131165218));
      } else {
        jl.h(this.a.a).setText(this.a.a.e(2131165219));
      } 
      jl.h(this.a.a).setEnabled(true);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */