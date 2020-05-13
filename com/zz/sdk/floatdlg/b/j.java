package com.zz.sdk.floatdlg.b;

import com.zz.sdk.b.a.a;
import com.zz.sdk.i.bd;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;

class j implements Runnable {
  j(i parami, a parama) {}
  
  public void run() {
    try {
      String str;
      h.c();
      if (this.a != null && this.a.c()) {
        cv.r(this.b.b.getString(ci.a(a.c(this.b.b)).a(2131165274)));
        cq.a(a.c(this.b.b)).a(this.b.a);
        if ((a.b(this.b.b)).length > 0)
          a.f(this.b.b); 
        this.b.b.getActivity().getSupportFragmentManager().popBackStack();
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      this();
      StringBuilder stringBuilder2 = stringBuilder1.append(this.b.b.getString(ci.a(a.c(this.b.b)).a(2131165285)));
      if (this.a != null) {
        stringBuilder1 = new StringBuilder();
        this();
        str = stringBuilder1.append(":").append(this.a.f()).toString();
      } else {
        str = "";
      } 
      cv.r(stringBuilder2.append(str).toString());
    } catch (Exception exception) {
      bd.b(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */