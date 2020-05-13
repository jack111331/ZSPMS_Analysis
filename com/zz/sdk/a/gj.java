package com.zz.sdk.a;

import android.view.View;
import android.view.ViewGroup;
import com.zz.sdk.d.b;

class gj implements Runnable {
  gj(gh paramgh) {}
  
  public void run() {
    b b = bv.a(gh.b(this.a));
    if (gh.c(this.a) != b)
      try {
        View view1;
        gh.a(this.a, b);
        b = null;
        if (gh.c(this.a) != null)
          view1 = gh.c(this.a).x(); 
        View view2 = view1;
        if (view1 == null)
          view2 = gh.b(this.a).getWindow().getDecorView(); 
        if (view2 != null)
          (gh.d(this.a)).token = view2.getWindowToken(); 
        gh.f(this.a).updateViewLayout(gh.e(this.a), (ViewGroup.LayoutParams)gh.d(this.a));
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    gh.h(this.a).postDelayed(gh.g(this.a), 500L);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\gj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */