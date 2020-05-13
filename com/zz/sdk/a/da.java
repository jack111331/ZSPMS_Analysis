package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.zz.sdk.b.a.r;
import com.zz.sdk.i.a;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.t;
import java.util.Map;

public class da extends w implements View.OnClickListener {
  private String a;
  
  public da(Activity paramActivity) {
    super(paramActivity);
  }
  
  void a() {
    setTitle(2131165240);
    findViewById(2131296422).setOnClickListener(this);
    findViewById(2131296424).setOnClickListener(this);
    findViewById(2131296426).setOnClickListener(this);
    findViewById(2131296427).setOnClickListener(this);
    findViewById(2131296429).setOnClickListener(this);
    findViewById(2131296428).setOnClickListener(this);
    if (a.a()) {
      findViewById(2131296422).setVisibility(8);
      findViewById(2131296425).setVisibility(0);
    } 
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.a = (String)a("account");
  }
  
  int c() {
    return 2130903076;
  }
  
  public void onClick(View paramView) {
    int i = a(paramView);
    if (i == 2131296424) {
      t.a((Context)this.b).b("Forget_platform", "forget_platform_sms", 1);
      bv.a(this.b, in.class, z());
      return;
    } 
    if (i == 2131296426) {
      t.a((Context)this.b).b("Forget_platform", "forget_platform_email", 1);
      bv.a(this.b, cd.class, z());
      return;
    } 
    if (i == 2131296427) {
      t.a((Context)this.b).b("Forget_platform", "forget_platform_customer", 1);
      bv.a(this.b, hv.class, z().a("account", this.a));
      return;
    } 
    if (i == 2131296429) {
      bv.b(this.b, a.class);
      onBackPressed();
      return;
    } 
    if (i == 2131296428) {
      bv.a(this.b, gt.class, z());
      return;
    } 
    if (i == 2131296422) {
      t.a((Context)this.b).b("Forget_platform", "forget_platform_self", 1);
      r r = cv.h();
      if (r == null || TextUtils.isEmpty(r.n())) {
        bp.b("ResultConf or FindPwdURL is NULL");
        return;
      } 
      bp.a("token: " + cq.a((Context)this.b).v());
      cv.d((Context)this.b, "http://kf.zhengyuetech.com/Mobile/autoService?id=33&token=8bb5c9");
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */