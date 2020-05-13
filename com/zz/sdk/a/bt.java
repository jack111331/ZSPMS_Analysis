package com.zz.sdk.a;

import android.app.Activity;
import android.view.View;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.Map;

public class bt extends w implements View.OnClickListener {
  private static final float a = 480.0F;
  
  private static final float n = 300.0F;
  
  private static final float o = 200.0F;
  
  private static int s;
  
  private static int t;
  
  private bu p;
  
  private FancyButton q;
  
  private FancyButton r;
  
  public bt(Activity paramActivity) {
    super(paramActivity);
  }
  
  public bt(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  public int D() {
    float f1 = 1.0F;
    if (s > 0)
      return s; 
    float f2 = 480.0F / this.v.densityDpi;
    if (f2 > 1.0F)
      f2 = f1; 
    null = Math.min(this.v.widthPixels, this.v.heightPixels);
    s = Math.min((int)((f2 * null) * 0.9D), a(300.0F));
    if (s > null)
      s = null; 
    return s;
  }
  
  public int E() {
    float f1 = 1.0F;
    if (t > 0)
      return t; 
    float f2 = 480.0F / this.v.densityDpi;
    if (f2 > 1.0F)
      f2 = f1; 
    null = Math.min(this.v.widthPixels, this.v.heightPixels);
    t = Math.min((int)((f2 * null) * 0.8D), a(200.0F));
    if (t > null)
      t = null; 
    return t;
  }
  
  void a() {
    a(false);
    this.q = (FancyButton)findViewById(2131296404);
    this.q.setOnClickListener(this);
    this.r = (FancyButton)findViewById(2131296403);
    this.r.setOnClickListener(this);
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.p = (bu)a("callback");
  }
  
  int c() {
    return 2130903068;
  }
  
  public void onClick(View paramView) {
    switch (a(paramView)) {
      default:
        return;
      case 2131296404:
        onBackPressed();
        if (this.p != null)
          this.p.a(); 
      case 2131296403:
        break;
    } 
    onBackPressed();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */