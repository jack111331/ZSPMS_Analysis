package com.zz.sdk.a;

import android.app.Activity;
import android.view.View;
import java.util.Map;

public class ht extends w {
  private boolean a;
  
  public ht(Activity paramActivity) {
    super(paramActivity);
  }
  
  public ht(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  void a() {}
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.a = ((Boolean)a("key_overlay", Boolean.valueOf(true))).booleanValue();
  }
  
  protected boolean b() {
    return this.a;
  }
  
  int c() {
    return 0;
  }
  
  protected View o() {
    return (View)a("key_old_view");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */