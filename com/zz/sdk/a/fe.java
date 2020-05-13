package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zz.sdk.SDKManager;
import com.zz.sdk.c.a;
import com.zz.sdk.i.a;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import com.zz.sdk.third.a.a;
import com.zz.sdk.third.b.c;
import com.zz.sdk.third.c;
import com.zz.sdk.third.d;

public class fe extends w implements View.OnClickListener, c {
  protected EditText a;
  
  private cq n;
  
  private boolean o = false;
  
  private FrameLayout p;
  
  private View q;
  
  private LinearLayout r;
  
  private FancyButton s;
  
  private TextView t;
  
  private RelativeLayout u;
  
  private Runnable x = new ff(this);
  
  public fe(Activity paramActivity) {
    super(paramActivity);
  }
  
  public fe(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void F() {
    LinearLayout linearLayout = (LinearLayout)findViewById(2131296465);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(linearLayout.getLayoutParams());
    layoutParams.setMargins(0, 30, 0, 0);
    linearLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  private void G() {
    h.a((Context)this.b, false);
    (new Handler()).postDelayed(new fi(this), 1000L);
  }
  
  private void H() {
    c(2131165244);
    a.a().a(this.n, new fp(this));
  }
  
  private void b(String paramString) {
    p();
    a.a().b((Context)this.b, paramString, new fn(this, paramString));
  }
  
  void a() {
    byte b2;
    byte b1 = 1;
    boolean bool = false;
    this.n = cq.a((Context)this.b);
    findViewById(2131296455).setOnClickListener(this);
    findViewById(2131296457).setOnClickListener(this);
    findViewById(2131296408).setOnClickListener(this);
    this.s = (FancyButton)findViewById(2131296452);
    this.s.setOnClickListener(this);
    this.t = (TextView)findViewById(2131296453);
    this.t.setOnClickListener(this);
    this.r = (LinearLayout)findViewById(2131296450);
    this.u = (RelativeLayout)findViewById(2131296451);
    View view1 = findViewById(2131296460);
    view1.setOnClickListener(this);
    View view2 = findViewById(2131296462);
    view2.setOnClickListener(this);
    this.q = findViewById(2131296349);
    this.a = (EditText)findViewById(2131296392);
    this.a.addTextChangedListener(new fg(this));
    this.a.setOnFocusChangeListener(new fh(this));
    findViewById(2131296466).setOnClickListener(this);
    h.a((ImageView)findViewById(2131296360));
    SDKManager sDKManager = SDKManager.getInstance((Context)this.b);
    if (c.a.b() && cv.a(c.a.a(), "enabled", "1").equals("1")) {
      b2 = 1;
    } else {
      b2 = 0;
    } 
    if (!c.b.b() || !cv.a(c.b.a(), "enabled", "1").equals("1"))
      b1 = 0; 
    cv.a("phone", "enabled", "1").equals("1");
    sDKManager.getStatusAuthentication();
    boolean bool1 = cv.a("tourist", "enabled", "1").equals("1");
    if (!bool1) {
      view1.setVisibility(8);
      view2.setVisibility(0);
      findViewById(2131296466).setVisibility(8);
      F();
    } else if (this.n.a != null) {
      view1.setVisibility(8);
      view2.setVisibility(0);
      findViewById(2131296466).setVisibility(8);
      F();
    } else {
      view1.setVisibility(0);
      view2.setVisibility(8);
      findViewById(2131296466).setVisibility(0);
    } 
    if (cv.a("phoneQK", "enabled", "0").equals("1")) {
      this.r.setVisibility(8);
      this.u.setVisibility(0);
    } 
    View view3 = findViewById(2131296456);
    if (b2) {
      b2 = 0;
    } else {
      b2 = 8;
    } 
    view3.setVisibility(b2);
    view3 = findViewById(2131296454);
    if (b1) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    view3.setVisibility(b1);
    view3 = findViewById(2131296459);
    if (bool1) {
      b1 = bool;
    } else {
      b1 = 8;
    } 
    view3.setVisibility(b1);
    ImageView imageView = (ImageView)findViewById(2131296463);
    TextView textView = (TextView)findViewById(2131296464);
    if (a.a()) {
      imageView.setImageResource(ci.a((Context)this.b, 2130837663));
      textView.setText(ci.a((Context)this.b, 2131165410));
      return;
    } 
    imageView.setImageResource(ci.a((Context)this.b, 2130837659));
    textView.setText(ci.a((Context)this.b, 2131165186));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {
    super.a(paramInt1, paramInt2, paramIntent);
    d.a(this.b, paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Intent paramIntent) {
    super.a(paramIntent);
    d.a(this.b, paramIntent);
  }
  
  public void a(c paramc) {
    this.o = false;
    this.k.removeCallbacks(this.x);
    r();
  }
  
  public void a(c paramc, a parama) {
    this.o = false;
    this.k.removeCallbacks(this.x);
    h.a((Context)this.b, this.n, parama, this.l);
  }
  
  public void a(c paramc, String paramString) {
    this.o = false;
    this.k.removeCallbacks(this.x);
    r();
    a(paramString);
  }
  
  protected boolean b() {
    return true;
  }
  
  int c() {
    return 2130903084;
  }
  
  public void d() {
    super.d();
    d.a(this.b);
  }
  
  public void e() {
    super.e();
    d.b(this.b);
    if (this.o) {
      this.o = false;
      this.k.postDelayed(this.x, 1000L);
    } 
  }
  
  public void onClick(View paramView) {
    String str;
    switch (a(paramView)) {
      default:
        return;
      case 2131296455:
        t.a((Context)this.b).b("Login_main", "wechat_click", 1);
        this.o = true;
        b((CharSequence)null, true);
        d.a(this.b, c.b, this);
      case 2131296457:
        t.a((Context)this.b).b("Login_main", "qq_click", 1);
        this.o = true;
        b((CharSequence)null, true);
        d.a(this.b, c.a, this);
      case 2131296408:
        t.a((Context)this.b).b("Login_main", "platform_phone_next", 1);
        str = h.b((TextView)this.a);
        if (str != null)
          b(str); 
      case 2131296452:
        t.a((Context)this.b).b("Login_platform", "Login_phone_qk", 1);
        G();
      case 2131296453:
        t.a((Context)this.b).b("Login_platform", "Login_phone_input", 1);
        this.r.setVisibility(0);
        this.u.setVisibility(8);
      case 2131296460:
        t.a((Context)this.b).b("Login_main", "auto_register", 1);
        H();
      case 2131296462:
        t.a((Context)this.b).b("Login_main", "account_click", 1);
        bv.a(this.b, a.class, z());
      case 2131296466:
        break;
    } 
    t.a((Context)this.b).b("Login_main", "account_click", 1);
    bv.a(this.b, a.class, z());
  }
  
  public void s() {
    super.s();
    d.c(this.b);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\fe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */