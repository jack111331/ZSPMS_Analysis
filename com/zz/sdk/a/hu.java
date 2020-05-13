package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.zz.sdk.e.bg;
import com.zz.sdk.e.cr;
import com.zz.sdk.i.ci;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.Map;

public class hu extends w implements View.OnClickListener {
  private static final float a = 480.0F;
  
  private static final float n = 300.0F;
  
  private static final float o = 200.0F;
  
  private static int t;
  
  private static int u;
  
  private TextView p;
  
  private FancyButton q;
  
  private FancyButton r;
  
  private bg s;
  
  public hu(Activity paramActivity) {
    super(paramActivity, ci.a((Context)paramActivity, 2131230726));
  }
  
  public hu(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  public int D() {
    float f1 = 1.0F;
    if (t > 0)
      return t; 
    float f2 = 480.0F / this.v.densityDpi;
    if (f2 > 1.0F)
      f2 = f1; 
    null = Math.min(this.v.widthPixels, this.v.heightPixels);
    t = Math.min((int)((f2 * null) * 0.9D), a(300.0F));
    if (t > null)
      t = null; 
    return t;
  }
  
  public int E() {
    float f1 = 1.0F;
    if (u > 0)
      return u; 
    float f2 = 480.0F / this.v.densityDpi;
    if (f2 <= 1.0F)
      f1 = f2; 
    null = Math.min(this.v.widthPixels, this.v.heightPixels);
    u = Math.min((int)((f1 * null) * 0.8D), a(200.0F));
    if (u > null)
      u = null; 
    return u;
  }
  
  void a() {
    a(false);
    this.p = (TextView)findViewById(2131296486);
    this.q = (FancyButton)findViewById(2131296404);
    this.q.setOnClickListener(this);
    this.r = (FancyButton)findViewById(2131296403);
    this.r.setOnClickListener(this);
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.s = (bg)paramMap.get("payLayout");
  }
  
  int c() {
    return 2130903090;
  }
  
  public void onBackPressed() {
    bv.a(this);
  }
  
  public void onClick(View paramView) {
    switch (a(paramView)) {
      default:
        return;
      case 2131296404:
        bv.a(this);
      case 2131296403:
        break;
    } 
    bv.a(this);
    if (this.s != null && this.s instanceof cr)
      ((cr)this.s).e(true); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\hu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */