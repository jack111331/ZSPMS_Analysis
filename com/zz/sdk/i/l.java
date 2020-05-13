package com.zz.sdk.i;

import android.view.View;
import android.widget.Toast;
import com.zz.sdk.SDKManager;

final class l implements View.OnClickListener {
  l(View paramView) {}
  
  public void onClick(View paramView) {
    if (h.d() != 0L && System.currentTimeMillis() - h.d() > 500L)
      h.a(0); 
    h.e();
    if (h.f() == 1) {
      h.a(System.currentTimeMillis());
      return;
    } 
    if (h.f() == 2) {
      h.b(System.currentTimeMillis());
      if (h.g() - h.d() < 500L)
        Toast.makeText(this.a.getContext(), SDKManager.getVersionDesc(), 0).show(); 
      h.a(0);
      h.a(0L);
      h.b(0L);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */