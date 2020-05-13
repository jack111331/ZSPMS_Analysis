package com.zz.sdk.a;

import android.content.DialogInterface;
import com.zz.sdk.i.cv;

class df implements DialogInterface.OnDismissListener {
  df(de paramde) {}
  
  public void onDismiss(DialogInterface paramDialogInterface) {
    if (db.f(this.a.b.a)) {
      bv.e(this.a.b.a.b);
      return;
    } 
    if (db.g(this.a.b.a) == 3) {
      if (db.h(this.a.b.a) == 0 && db.i(this.a.b.a) == 3) {
        bv.d(this.a.b.a.b);
        return;
      } 
      if (db.h(this.a.b.a) == 1 && db.j(this.a.b.a) == 3) {
        if (cv.h().l() == 0) {
          bv.f(this.a.b.a.b);
          return;
        } 
        if (this.a.a.h() != 0) {
          bv.f(this.a.b.a.b);
          return;
        } 
        bv.f(this.a.b.a.b);
        return;
      } 
    } 
    if (db.k(this.a.b.a) != 0) {
      if (cv.h().l() == 0) {
        bv.f(this.a.b.a.b);
        return;
      } 
      if (this.a.a.h() != 0) {
        bv.f(this.a.b.a.b);
        return;
      } 
      bv.f(this.a.b.a.b);
      return;
    } 
    bv.d(this.a.b.a.b);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */