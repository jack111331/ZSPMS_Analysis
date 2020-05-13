package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import com.zz.sdk.SDKManager;
import com.zz.sdk.i.bg;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;

public class kr extends w implements View.OnClickListener {
  private FancyButton a;
  
  private FancyButton n;
  
  private CheckBox o;
  
  public kr(Activity paramActivity) {
    super(paramActivity);
  }
  
  public kr(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  void a() {
    bp.a("ShakeDialog...initView");
    a(false);
    bg.b = false;
    this.a = (FancyButton)findViewById(2131296631);
    this.a.setOnClickListener(this);
    this.n = (FancyButton)findViewById(2131296632);
    this.n.setOnClickListener(this);
    this.o = (CheckBox)findViewById(2131296633);
  }
  
  int c() {
    return 2130903129;
  }
  
  public void onClick(View paramView) {
    Boolean bool;
    String str;
    switch (a(paramView)) {
      default:
        return;
      case 2131296631:
        str = cq.a((Context)this.b).w();
        bool = Boolean.valueOf(this.o.isChecked());
        if (bool.booleanValue())
          cm.a((Context)this.b, bg.c + str, bool.booleanValue()); 
        SDKManager.tryHideFloat(cv.i());
        bg.b = true;
        i();
      case 2131296632:
        break;
    } 
    bg.b = true;
    i();
  }
  
  public void s() {
    super.s();
    bp.a("ShakeDialog...onDestroy");
    bg.b = true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\kr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */