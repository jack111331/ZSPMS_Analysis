package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.zz.sdk.c.a;
import com.zz.sdk.d.a;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.Map;
import java.util.Timer;

public class hy extends w implements View.OnClickListener, a {
  private static final int t = 60;
  
  private boolean A;
  
  private boolean B;
  
  private int C;
  
  private ContentObserver D;
  
  private Timer E = null;
  
  private int F = 60;
  
  protected EditText a;
  
  protected ImageView n;
  
  protected EditText o;
  
  protected FancyButton p;
  
  protected FancyButton q;
  
  protected TextView r;
  
  public String s;
  
  private int u = 0;
  
  private View x;
  
  private View y;
  
  private t z;
  
  public hy(Activity paramActivity) {
    super(paramActivity);
  }
  
  public hy(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void F() {
    G();
    ih ih = new ih(this);
    this.E = new Timer();
    this.E.schedule(ih, 0L, 1000L);
  }
  
  private void G() {
    if (this.E != null) {
      this.E.purge();
      this.E.cancel();
      this.E = null;
    } 
  }
  
  private void a(String paramString1, int paramInt, String paramString2) {
    this.l.p();
    a.a().a((Context)this.b, paramString1, paramInt, paramString2, new ij(this));
  }
  
  private void a(String paramString1, String paramString2) {
    c(2131165272);
    a.a().c((Context)this.b, this.s, paramString1, paramString2, "", "", new id(this, paramString1));
  }
  
  private void b(String paramString) {
    p();
    a.a().c((Context)this.b, this.s, paramString, new if(this, paramString));
  }
  
  void a() {
    boolean bool;
    this.s = cq.a((Context)this.b).q();
    if (TextUtils.isEmpty(this.s))
      this.s = cq.a((Context)this.b).v(); 
    this.z = t.a((Context)this.b);
    this.C = cq.a((Context)this.b).o();
    if (this.C == 1 || this.C == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    this.A = bool;
    int i = cq.a((Context)this.b).d();
    int j = cq.a((Context)this.b).e();
    if (i == 3 && j == 3)
      this.A = true; 
    d(true);
    this.r = (TextView)findViewById(2131296415);
    setTitle(2131165232);
    this.y = findViewById(2131296352);
    this.x = findViewById(2131296349);
    this.n = (ImageView)findViewById(2131296406);
    this.n.setOnClickListener(this);
    this.a = (EditText)findViewById(2131296392);
    this.a.addTextChangedListener(new hz(this));
    this.a.setOnFocusChangeListener(new ia(this));
    this.o = (EditText)findViewById(2131296407);
    this.o.setOnFocusChangeListener(new ib(this));
    this.p = (FancyButton)findViewById(2131296395);
    this.p.setOnClickListener(this);
    this.q = (FancyButton)findViewById(2131296467);
    this.q.setOnClickListener(this);
    this.a.setText("");
    this.D = h.a((Context)this.b, (TextView)this.a, (TextView)this.o);
    (new il(this, null)).start();
    findViewById(2131296409).setVisibility(0);
    findViewById(2131296410).setOnClickListener(new ic(this));
    t.a((Context)this.b).b("Buoy", "No_Tel_Bind_0", 1);
  }
  
  public void a(Boolean paramBoolean) {
    if (paramBoolean.booleanValue())
      a(this.a.getText().toString(), 1, cq.a((Context)this.b).j()); 
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.B = ((Boolean)a("KEY_NEED_ALIAS", Boolean.valueOf(false))).booleanValue();
  }
  
  int c() {
    return 2130903092;
  }
  
  protected void i() {
    if (this.A) {
      int i;
      if (cv.h() == null) {
        i = 0;
      } else {
        i = cv.h().j().c();
      } 
      if (i == 0) {
        i = 0;
      } else {
        i = 1;
      } 
      if (i == 0) {
        bv.a(this.b, ha.class, bv.a().a("key_show_close", Boolean.valueOf(true)).a("key_show_back", Boolean.valueOf(false)));
        return;
      } 
      bv.a(this.b, db.class, bv.a().a("key_show_close", Boolean.valueOf(true)).a("key_show_back", Boolean.valueOf(false)));
      return;
    } 
    bv.d(this.b);
  }
  
  protected int j() {
    return 2130903142;
  }
  
  protected void l() {
    t.a((Context)this.b).b("Bind_platform", "Bind_cancel", 1);
  }
  
  public void onBackPressed() {
    i();
  }
  
  public void onClick(View paramView) {
    int i = a(paramView);
    if (i == 2131296395) {
      t.a((Context)this.b).b("Bind_platform", "bind_phone_code", 1);
      String str = h.b((TextView)this.a);
      if (str != null) {
        if (this.u < 2) {
          b(str);
          return;
        } 
        (new br((Context)this.b, ci.a((Context)this.b, 2131230726), this)).show();
      } 
      return;
    } 
    if (i == 2131296467) {
      t.a((Context)this.b).b("Bind_platform", "bind_phone_enter", 1);
      String str = h.b((TextView)this.a);
      if (str != null) {
        String str1 = this.o.getText().toString();
        if (TextUtils.isEmpty(str1)) {
          b(2131165249);
          return;
        } 
        a(str, str1);
      } 
      return;
    } 
    if (i == 2131296406)
      this.a.setText(""); 
  }
  
  public void s() {
    super.s();
    try {
      if (this.D != null)
        this.b.getContentResolver().unregisterContentObserver(this.D); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\hy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */