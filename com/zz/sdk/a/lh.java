package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;

public class lh extends w implements View.OnClickListener {
  private TextView a;
  
  private TextView n;
  
  private FancyButton o;
  
  private FancyButton p;
  
  public lh(Activity paramActivity) {
    super(paramActivity);
  }
  
  public lh(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  void a() {
    t.a((Context)this.b).b("Bind_platform", "Change_Bind_Main", 1);
    setTitle("换绑手机");
    this.a = (TextView)findViewById(2131296355);
    this.a.setText((String)a("boundAccount"));
    this.n = (TextView)findViewById(2131296356);
    this.n.setText(cq.a((Context)this.b).k());
    this.o = (FancyButton)findViewById(2131296357);
    this.o.setOnClickListener(this);
    this.p = (FancyButton)findViewById(2131296358);
    this.p.setOnClickListener(this);
  }
  
  int c() {
    return 2130903054;
  }
  
  public void onClick(View paramView) {
    int i = a(paramView);
    if (i == 2131296357) {
      bv.e(this.b);
      return;
    } 
    if (i == 2131296358) {
      t.a((Context)this.b).b("Bind_platform", "Change_Bind_Next", 1);
      bv.a(this.b, ky.class, bv.a().a("key_show_close", Boolean.valueOf(false)).a("key_show_back", Boolean.valueOf(false)).a("phone", a("phone")));
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\lh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */