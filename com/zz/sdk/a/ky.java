package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.zz.sdk.c.a;
import com.zz.sdk.d.a;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.Map;
import java.util.Timer;

public class ky extends w implements View.OnClickListener, a {
  private static final int a = 60;
  
  private int n = 0;
  
  private TextView o;
  
  private EditText p;
  
  private EditText q;
  
  private FancyButton r;
  
  private FancyButton s;
  
  private FancyButton t;
  
  private String u;
  
  private String x;
  
  private Timer y = null;
  
  private int z = 60;
  
  public ky(Activity paramActivity) {
    super(paramActivity);
  }
  
  public ky(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void F() {
    p();
    a.a().d((Context)this.b, this.x, this.u, new lb(this));
  }
  
  private void G() {
    H();
    ld ld = new ld(this);
    this.y = new Timer();
    this.y.schedule(ld, 0L, 1000L);
  }
  
  private void H() {
    if (this.y != null) {
      this.y.purge();
      this.y.cancel();
      this.y = null;
    } 
  }
  
  private void a(String paramString1, int paramInt, String paramString2) {
    this.l.p();
    a.a().a((Context)this.b, paramString1, paramInt, paramString2, new lf(this));
  }
  
  private void b(String paramString) {
    t.a((Context)this.b).b("Bind_platform", "Change_Bind_Confirm", 1);
    c(2131165272);
    a.a().c((Context)this.b, this.x, this.u, paramString, new kz(this));
  }
  
  void a() {
    t.a((Context)this.b).b("Bind_platform", "Change_Bind_Ing", 1);
    this.x = cq.a((Context)this.b).q();
    if (TextUtils.isEmpty(this.x))
      this.x = cq.a((Context)this.b).v(); 
    setTitle("换绑手机");
    this.o = (TextView)findViewById(2131296347);
    this.o.setText(cq.a((Context)this.b).k());
    this.p = (EditText)findViewById(2131296348);
    this.p.setText(this.u);
    this.q = (EditText)findViewById(2131296350);
    this.r = (FancyButton)findViewById(2131296351);
    this.r.setOnClickListener(this);
    this.s = (FancyButton)findViewById(2131296353);
    this.s.setOnClickListener(this);
    this.t = (FancyButton)findViewById(2131296354);
    this.t.setOnClickListener(this);
  }
  
  public void a(Boolean paramBoolean) {
    if (paramBoolean.booleanValue())
      a(this.p.getText().toString(), 7, cq.a((Context)this.b).j()); 
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.u = (String)a("phone");
  }
  
  int c() {
    return 2130903053;
  }
  
  public void onBackPressed() {
    bv.d(this.b);
  }
  
  public void onClick(View paramView) {
    int i = a(paramView);
    if (i == 2131296351) {
      if (this.n < 2) {
        F();
        return;
      } 
      (new br((Context)this.b, ci.a((Context)this.b, 2131230726), this)).show();
      return;
    } 
    if (i == 2131296353) {
      bv.d(this.b);
      return;
    } 
    if (i == 2131296354) {
      String str = this.q.getText().toString();
      if (TextUtils.isEmpty(str)) {
        b(2131165249);
        return;
      } 
      b(str);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */