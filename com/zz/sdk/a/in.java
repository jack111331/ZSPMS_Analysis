package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.zz.sdk.c.a;
import com.zz.sdk.d.a;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.Timer;

public class in extends w implements View.OnClickListener, a {
  private static final int s = 90;
  
  protected EditText a;
  
  protected ImageView n;
  
  protected EditText o;
  
  protected FancyButton p;
  
  protected FancyButton q;
  
  private boolean r = false;
  
  private ContentObserver t;
  
  private View u;
  
  private View x;
  
  private Timer y = null;
  
  private int z = 90;
  
  public in(Activity paramActivity) {
    super(paramActivity);
  }
  
  public in(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void F() {
    G();
    iv iv = new iv(this);
    this.y = new Timer();
    this.y.schedule(iv, 0L, 1000L);
  }
  
  private void G() {
    if (this.y != null) {
      this.y.purge();
      this.y.cancel();
      this.y = null;
      this.r = true;
    } 
  }
  
  private void a(String paramString1, int paramInt, String paramString2) {
    this.l.p();
    a.a().a((Context)this.b, paramString1, paramInt, paramString2, new ix(this));
  }
  
  private void a(String paramString1, String paramString2) {
    p();
    a.a().e((Context)this.b, paramString1, paramString2, new ir(this, paramString1));
  }
  
  private void b(String paramString) {
    p();
    a.a().d((Context)this.b, paramString, new it(this, paramString));
  }
  
  void a() {
    setTitle(2131165404);
    this.n = (ImageView)findViewById(2131296406);
    this.n.setOnClickListener(this);
    this.a = (EditText)findViewById(2131296392);
    this.u = findViewById(2131296349);
    this.x = findViewById(2131296352);
    this.a.addTextChangedListener(new io(this));
    this.a.setOnFocusChangeListener(new ip(this));
    this.o = (EditText)findViewById(2131296407);
    this.o.setOnFocusChangeListener(new iq(this));
    this.p = (FancyButton)findViewById(2131296395);
    this.p.setOnClickListener(this);
    this.q = (FancyButton)findViewById(2131296467);
    findViewById(2131296418).setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.a.setText("");
    this.t = h.a((Context)this.b, (TextView)this.a, (TextView)this.o);
  }
  
  public void a(Boolean paramBoolean) {
    if (paramBoolean.booleanValue())
      a(this.a.getText().toString(), 2, cq.a((Context)this.b).j()); 
  }
  
  int c() {
    return 2130903093;
  }
  
  public void onClick(View paramView) {
    int i = a(paramView);
    if (i == 2131296395) {
      t.a((Context)this.b).b("Login_platform", "platform_forget_code", 1);
      String str = h.b((TextView)this.a);
      if (str != null) {
        if (!this.r) {
          b(str);
          return;
        } 
        (new br((Context)this.b, ci.a((Context)this.b, 2131230726), this)).show();
      } 
      return;
    } 
    if (i == 2131296467) {
      t.a((Context)this.b).b("Forget_platform", "forget_pass_next", 1);
      String str = h.b((TextView)this.a);
      if (str != null)
        b(str); 
      return;
    } 
    if (i == 2131296406) {
      this.a.setText("");
      return;
    } 
    if (i == 2131296418) {
      t.a((Context)this.b).b("Forget_platform", "forget_pass_problem", 1);
      bv.a(this.b, gt.class, z());
    } 
  }
  
  public void s() {
    super.s();
    try {
      if (this.t != null)
        this.b.getContentResolver().unregisterContentObserver(this.t); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\in.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */