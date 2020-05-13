package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.Map;

public class ks extends w implements View.OnClickListener {
  private FancyButton a;
  
  private TextView n;
  
  private String o;
  
  private boolean p;
  
  public ks(Activity paramActivity) {
    super(paramActivity);
  }
  
  public ks(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void a(Context paramContext) {
    cq cq = cq.a((Context)this.b);
    int i = cq.d();
    int j = cq.e();
    if (i == 3 && j == 3)
      this.p = true; 
    if (cq.o() == 1 || cq.o() == 2)
      this.p = true; 
    if (this.p) {
      String str = cq.a((Context)this.b).a();
      if (str != null && str.length() > 0) {
        i = 1;
      } else {
        i = 0;
      } 
      if (cv.h() == null) {
        j = 0;
      } else {
        j = cv.h().j().c();
      } 
      if (j == 0) {
        j = 0;
      } else {
        j = 1;
      } 
      if (i != 0 || j == 0) {
        bv.a((Activity)paramContext, ha.class, bv.a().a("key_show_close", Boolean.valueOf(true)).a("key_show_back", Boolean.valueOf(false)));
        return;
      } 
      bv.a((Activity)paramContext, db.class, bv.a().a("key_show_close", Boolean.valueOf(true)).a("key_show_back", Boolean.valueOf(false)));
      return;
    } 
    bv.d(this.b);
  }
  
  void a() {
    setTitle(2131165392);
    this.a = (FancyButton)findViewById(2131296500);
    this.a.setOnClickListener(this);
    this.n = (TextView)findViewById(2131296499);
    this.n.setText((CharSequence)Html.fromHtml(String.format(e(2131165394), new Object[] { cv.p(this.o) })));
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.o = (String)a("phone");
  }
  
  int c() {
    return 2130903101;
  }
  
  public void onBackPressed() {
    a((Context)this.b);
  }
  
  public void onClick(View paramView) {
    switch (a(paramView)) {
      default:
        return;
      case 2131296500:
        break;
    } 
    t.a((Context)this.b).b("Save_platform", "guest_enter_game", 1);
    a((Context)this.b);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */