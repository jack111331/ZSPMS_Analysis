package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import java.util.Map;

public class cr extends w implements View.OnClickListener {
  protected TextView a;
  
  private TextView n;
  
  private String o;
  
  private boolean p;
  
  public cr(Activity paramActivity) {
    super(paramActivity);
  }
  
  private void F() {
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
        bv.a(this.b, ha.class, bv.a().a("key_show_close", Boolean.valueOf(true)).a("key_show_back", Boolean.valueOf(false)));
        return;
      } 
      bv.a(this.b, db.class, bv.a().a("key_show_close", Boolean.valueOf(true)).a("key_show_back", Boolean.valueOf(false)));
      return;
    } 
    bv.d(this.b);
  }
  
  void a() {
    setTitle(2131165328);
    this.a = (TextView)findViewById(2131296410);
    this.a.setText((CharSequence)Html.fromHtml(e(2131165338) + cv.p(this.o)));
    this.n = (TextView)findViewById(2131296421);
    String str = cq.a((Context)this.b).s();
    this.n.setText((CharSequence)Html.fromHtml(e(2131165343) + cv.p(str)));
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.o = (String)a("email");
  }
  
  int c() {
    return 2130903074;
  }
  
  public void onBackPressed() {
    if (C()) {
      super.onBackPressed();
      return;
    } 
    F();
  }
  
  public void onClick(View paramView) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */