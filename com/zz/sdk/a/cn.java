package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zz.sdk.c.a;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.Map;

public class cn extends w implements View.OnClickListener {
  protected TextView a;
  
  protected FancyButton n;
  
  protected FancyButton o;
  
  protected TextView p;
  
  private boolean q;
  
  private String r;
  
  public cn(Activity paramActivity) {
    super(paramActivity);
  }
  
  private void F() {
    c(2131165272);
    a.a().f((Context)this.b, cq.a((Context)this.b).v(), this.r, new co(this));
  }
  
  void a() {
    setTitle(2131165328);
    this.a = (TextView)findViewById(2131296415);
    String str = cv.p(this.r);
    this.a.setText((CharSequence)Html.fromHtml(String.format(e(2131165337), new Object[] { str })));
    this.p = (TextView)findViewById(2131296410);
    this.n = (FancyButton)findViewById(2131296419);
    this.n.setOnClickListener(this);
    this.o = (FancyButton)findViewById(2131296420);
    this.o.setOnClickListener(this);
    if (this.q) {
      this.n.setVisibility(8);
      this.o.setBackgroundColor(this.b.getResources().getColor(ci.a((Context)this.b, 2131034273)));
      this.o.setBorderColor(this.b.getResources().getColor(ci.a((Context)this.b, 2131034273)));
      this.o.setFocusBackgroundColor(this.b.getResources().getColor(ci.a((Context)this.b, 2131034274)));
      LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams)this.p.getLayoutParams();
      layoutParams1.bottomMargin = a(10.0F);
      this.p.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
      return;
    } 
    this.n.setVisibility(0);
    this.o.setBackgroundColor(this.b.getResources().getColor(ci.a((Context)this.b, 2131034284)));
    this.o.setBorderColor(this.b.getResources().getColor(ci.a((Context)this.b, 2131034284)));
    this.o.setFocusBackgroundColor(this.b.getResources().getColor(ci.a((Context)this.b, 2131034280)));
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.p.getLayoutParams();
    layoutParams.bottomMargin = 0;
    this.p.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.q = ((Boolean)a("bind_state", Boolean.valueOf(false))).booleanValue();
    this.r = (String)a("email");
  }
  
  int c() {
    return 2130903072;
  }
  
  public void onClick(View paramView) {
    int i = a(paramView);
    if (i == 2131296419) {
      if (TextUtils.isEmpty(this.r)) {
        Log.e("zz_sdk", "EmailResetDialog email is null");
        a(e(2131165340));
        return;
      } 
      F();
      return;
    } 
    if (i == 2131296420)
      bv.a(this.b, cq.class, z().a("key_show_back", Boolean.valueOf(false))); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */