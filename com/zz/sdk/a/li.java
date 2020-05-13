package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;

public class li extends w implements View.OnClickListener {
  private FancyButton a;
  
  public li(Activity paramActivity) {
    super(paramActivity);
  }
  
  public li(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  void a() {
    t.a((Context)this.b).b("Bind_platform", "Change_Bind_Success", 1);
    this.a = (FancyButton)findViewById(2131296359);
    this.a.setOnClickListener(this);
  }
  
  int c() {
    return 2130903055;
  }
  
  public void onBackPressed() {
    bv.d(this.b);
  }
  
  public void onClick(View paramView) {
    if (a(paramView) == 2131296359)
      bv.d(this.b); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\li.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */