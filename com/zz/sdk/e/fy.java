package com.zz.sdk.e;

import android.content.Intent;
import com.zz.sdk.g.b;

class fy extends b {
  public static final int a = 10;
  
  static final String b = "pay_result";
  
  static final String c = "success";
  
  static final String d = "fail";
  
  static final String e = "cancel";
  
  private fy(fu paramfu) {}
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramIntent != null) {
      String str = paramIntent.getStringExtra("pay_result");
    } else {
      paramIntent = null;
    } 
    if (paramInt1 == 10 && this.f.h()) {
      this.f.g();
      if ("success".equalsIgnoreCase((String)paramIntent)) {
        fu.b(this.f);
      } else if ("fail".equalsIgnoreCase((String)paramIntent)) {
        fu.c(this.f);
      } else if ("cancel".equalsIgnoreCase((String)paramIntent)) {
        fu.d(this.f);
      } 
      return true;
    } 
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\fy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */