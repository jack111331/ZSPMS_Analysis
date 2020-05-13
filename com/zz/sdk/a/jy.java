package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.v;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.Map;

public class jy extends w implements View.OnClickListener {
  private TextView a;
  
  private FancyButton n;
  
  private FancyButton o;
  
  private a p;
  
  public jy(Activity paramActivity) {
    super(paramActivity);
  }
  
  public jy(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  void a() {
    t.a((Context)this.b).b("Agreement", "AgrMain", 1);
    setTitle(2131165473);
    a(this.b.getResources().getColor(ci.a((Context)this.b, 2131034278)));
    e(false);
    f(false);
    this.a = (TextView)findViewById(2131296446);
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
    spannableStringBuilder.append(e(2131165475));
    spannableStringBuilder.setSpan(new jz(this), 5, 15, 33);
    this.a.setText((CharSequence)spannableStringBuilder);
    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FC6475")), 5, 15, 33);
    this.a.setText((CharSequence)spannableStringBuilder);
    spannableStringBuilder.setSpan(new ka(this), 17, 27, 33);
    this.a.setText((CharSequence)spannableStringBuilder);
    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FC6475")), 17, 27, 33);
    this.a.setText((CharSequence)spannableStringBuilder);
    this.a.setMovementMethod(LinkMovementMethod.getInstance());
    this.a.setHighlightColor(this.b.getResources().getColor(ci.a((Context)this.b, 2131034287)));
    this.n = (FancyButton)findViewById(2131296447);
    this.n.setOnClickListener(this);
    this.o = (FancyButton)findViewById(2131296448);
    this.o.setOnClickListener(this);
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.p = (a)a("result_auth_login");
  }
  
  int c() {
    return 2130903082;
  }
  
  public void onBackPressed() {}
  
  public void onClick(View paramView) {
    int i = a(paramView);
    if (i == 2131296447) {
      t.a((Context)this.b).b("Agreement", "AgrRefuse", 1);
      cm.b((Context)this.b, false);
      v v = (cq.a((Context)this.b)).a;
      bv.a(this.b, fr.class, z().a("key_user", (cq.a((Context)this.b)).a), true);
      return;
    } 
    if (i == 2131296448) {
      t.a((Context)this.b).b("Agreement", "AgrAgree", 1);
      cm.b((Context)this.b, true);
      cq.a((Context)this.b, this.p, this.l, null, false);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\jy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */