package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.zz.sdk.b.v;
import com.zz.sdk.c.a;
import com.zz.sdk.d.a;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.Map;
import java.util.Timer;

public class kh extends w implements View.OnClickListener, a {
  private static final int t = 90;
  
  protected FancyButton a;
  
  protected EditText n;
  
  private TextView o;
  
  private View p;
  
  private v q;
  
  private String r;
  
  private boolean s = false;
  
  private Timer u = null;
  
  private int x = 90;
  
  public kh(Activity paramActivity) {
    super(paramActivity);
  }
  
  public kh(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void F() {
    G();
    kn kn = new kn(this);
    this.u = new Timer();
    this.u.schedule(kn, 0L, 1000L);
  }
  
  private void G() {
    if (this.u != null) {
      this.u.purge();
      this.u.cancel();
      this.u = null;
      this.s = true;
    } 
  }
  
  private void a(String paramString1, int paramInt, String paramString2) {
    this.l.p();
    a.a().a((Context)this.b, paramString1, paramInt, paramString2, new kp(this));
  }
  
  private void a(String paramString1, String paramString2) {
    p();
    a.a().e((Context)this.b, paramString1, paramString2, new kj(this, paramString1));
  }
  
  private void b(String paramString) {
    p();
    a.a().d((Context)this.b, paramString, new kl(this));
  }
  
  void a() {
    setTitle(2131165218);
    findViewById(2131296408).setOnClickListener(this);
    this.o = (TextView)findViewById(2131296405);
    String str = cv.p(cv.q(this.r));
    str = String.format(e(2131165355), new Object[] { str });
    this.o.setText((CharSequence)Html.fromHtml(str));
    this.n = (EditText)findViewById(2131296407);
    this.n.setOnFocusChangeListener(new ki(this));
    this.p = findViewById(2131296352);
    this.a = (FancyButton)findViewById(2131296395);
    this.a.setOnClickListener(this);
  }
  
  public void a(Boolean paramBoolean) {
    if (paramBoolean.booleanValue())
      a(this.r, 2, cq.a((Context)this.b).j()); 
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.q = (cq.a((Context)this.b)).a;
    this.r = cq.a((Context)this.b).a();
    if (TextUtils.isEmpty(this.r))
      this.r = this.q.b; 
  }
  
  int c() {
    return 2130903077;
  }
  
  public void onClick(View paramView) {
    int i = a(paramView);
    if (i == 2131296395) {
      String str = h.b((Context)this.b, this.r);
      if (str != null) {
        if (!this.s) {
          b(str);
          return;
        } 
        (new br((Context)this.b, ci.a((Context)this.b, 2131230726), this)).show();
      } 
      return;
    } 
    if (i == 2131296408 && this.r != null) {
      String str = this.n.getText().toString();
      if (TextUtils.isEmpty(str)) {
        b(2131165249);
        return;
      } 
      a(this.r, str);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\kh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */