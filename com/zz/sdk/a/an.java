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

public class an extends w implements View.OnClickListener, a {
  private static final int s = 90;
  
  protected EditText a;
  
  protected FancyButton n;
  
  public String o;
  
  private TextView p;
  
  private v q;
  
  private boolean r = false;
  
  private View t;
  
  private String u;
  
  private Timer x = null;
  
  private int y = 90;
  
  public an(Activity paramActivity) {
    super(paramActivity);
  }
  
  public an(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void F() {
    G();
    at at = new at(this);
    this.x = new Timer();
    this.x.schedule(at, 0L, 1000L);
  }
  
  private void G() {
    if (this.x != null) {
      this.x.purge();
      this.x.cancel();
      this.x = null;
      this.r = true;
    } 
  }
  
  private void a(String paramString1, int paramInt, String paramString2) {
    this.l.p();
    a.a().a((Context)this.b, paramString1, paramInt, paramString2, new av(this));
  }
  
  private void a(String paramString1, String paramString2) {
    c(2131165272);
    a.a().a((Context)this.b, this.o, paramString1, paramString2, 5, new ap(this, paramString1));
  }
  
  private void b(String paramString) {
    p();
    a.a().a((Context)this.b, this.o, paramString, 5, new ar(this));
  }
  
  void a() {
    setTitle(2131165363);
    this.p = (TextView)findViewById(2131296405);
    String str = cv.p(cv.q(this.u));
    str = String.format(e(2131165362), new Object[] { str });
    this.p.setText((CharSequence)Html.fromHtml(str));
    findViewById(2131296408).setOnClickListener(this);
    this.t = findViewById(2131296352);
    this.a = (EditText)findViewById(2131296407);
    this.a.setOnFocusChangeListener(new ao(this));
    this.n = (FancyButton)findViewById(2131296395);
    this.n.setOnClickListener(this);
    findViewById(2131296410).setOnClickListener(this);
  }
  
  public void a(Boolean paramBoolean) {
    if (paramBoolean.booleanValue())
      a(this.u, 5, cq.a((Context)this.b).j()); 
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.q = (cq.a((Context)this.b)).a;
    this.o = cq.a((Context)this.b).v();
    if (this.q.i == 1) {
      this.u = cq.a((Context)this.b).a();
      if (TextUtils.isEmpty(this.u))
        this.u = this.q.b; 
      return;
    } 
    this.u = cq.a((Context)this.b).a();
  }
  
  int c() {
    return 2130903065;
  }
  
  public void onClick(View paramView) {
    int i = a(paramView);
    if (i == 2131296395) {
      String str = h.b((Context)this.b, this.u);
      if (str != null) {
        if (!this.r) {
          b(str);
          return;
        } 
        (new br((Context)this.b, ci.a((Context)this.b, 2131230726), this)).show();
      } 
      return;
    } 
    if (i == 2131296408) {
      String str = h.b((Context)this.b, this.u);
      if (str != null) {
        String str1 = this.a.getText().toString();
        if (TextUtils.isEmpty(str1)) {
          b(2131165249);
          return;
        } 
        a(str, str1);
      } 
      return;
    } 
    if (i == 2131296410)
      bv.a(this.b, gt.class, z()); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */