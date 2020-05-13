package com.zz.sdk.floatdlg.b;

import android.support.v4.app.FragmentTransaction;
import com.zz.sdk.a.bv;
import com.zz.sdk.b.a.z;
import com.zz.sdk.i.bg;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.i.v;

class bi implements Runnable {
  bi(bh parambh, z paramz) {}
  
  public void run() {
    try {
      if (this.a.h() == 1)
        bg.l = true; 
      if (v.B)
        bv.f(cv.i()); 
      bg.k = true;
      cq.a(be.c(this.b.a)).a(this.a.g());
      h.c();
      cv.r(this.b.a.getString(ci.a(be.c(this.b.a), 2131165286)));
      if (be.b(this.b.a) != null && (be.b(this.b.a)).length > 0)
        be.l(this.b.a); 
      FragmentTransaction fragmentTransaction = this.b.a.getActivity().getSupportFragmentManager().beginTransaction();
      br br = new br();
      this();
      fragmentTransaction.replace(2131296257, br).commit();
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */