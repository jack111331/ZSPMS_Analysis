package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.zz.sdk.b.v;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cv;
import java.util.Map;

public class cq extends w implements View.OnClickListener {
  private static final float a = 480.0F;
  
  private static final float n = 300.0F;
  
  private static final float o = 220.0F;
  
  private static int r;
  
  private static int s;
  
  private com.zz.sdk.i.cq p;
  
  private v q;
  
  public cq(Activity paramActivity) {
    super(paramActivity, ci.a((Context)paramActivity, 2131230726));
  }
  
  public cq(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  public int D() {
    float f1 = 1.0F;
    if (r > 0)
      return r; 
    float f2 = 480.0F / this.v.densityDpi;
    if (f2 <= 1.0F)
      f1 = f2; 
    null = Math.min(this.v.widthPixels, this.v.heightPixels);
    r = Math.min((int)((f1 * null) * 0.9D), a(300.0F));
    if (r > null)
      r = null; 
    return r;
  }
  
  public int E() {
    float f1 = 1.0F;
    if (s > 0)
      return s; 
    float f2 = 480.0F / this.v.densityDpi;
    if (f2 > 1.0F)
      f2 = f1; 
    null = Math.min(this.v.widthPixels, this.v.heightPixels);
    s = Math.min((int)((f2 * null) * 0.8D), a(220.0F));
    if (s > null)
      s = null; 
    return s;
  }
  
  void a() {
    String str;
    setTitle(2131165341);
    a(this.b.getResources().getColor(ci.a((Context)this.b, 2131034279)));
    findViewById(2131296383).setOnClickListener(this);
    findViewById(2131296397).setOnClickListener(this);
    TextView textView = (TextView)findViewById(2131296405);
    if (this.q.i == 1) {
      str = cv.p(cv.q(this.q.b));
    } else {
      str = com.zz.sdk.i.cq.a((Context)this.b).a();
      if (!TextUtils.isEmpty(str)) {
        str = cv.p(cv.q(str));
      } else {
        str = cv.p(this.p.k());
      } 
    } 
    textView.setText((CharSequence)Html.fromHtml(String.format(e(2131165342), new Object[] { str })));
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.p = com.zz.sdk.i.cq.a((Context)this.b);
    this.q = (com.zz.sdk.i.cq.a((Context)this.b)).a;
  }
  
  int c() {
    return 2130903073;
  }
  
  public void onClick(View paramView) {
    int i = a(paramView);
    if (i == 2131296397) {
      i();
      return;
    } 
    if (i == 2131296383)
      bv.a(this.b, ci.class, z().a("key_show_close", Boolean.valueOf(false)).a("key_show_back", Boolean.valueOf(true)), true); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */