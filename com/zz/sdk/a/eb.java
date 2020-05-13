package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.zz.sdk.c.a;
import com.zz.sdk.d.a;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cp;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.SecurityCodeView;
import java.util.Map;
import java.util.Timer;

public class eb extends w implements View.OnClickListener, a {
  public static final String a = "phoneLogin";
  
  public static final String n = "newPhoneBind";
  
  public static final String o = "phoneBind";
  
  public static final String p = "upgradeAccount";
  
  public static final String q = "forgetPwd";
  
  public static final String r = "emailForgetPwd";
  
  private static final int x = 60;
  
  private TextView A;
  
  private SecurityCodeView B;
  
  private Timer C = null;
  
  private int D = 60;
  
  private String s;
  
  private String t;
  
  private String u;
  
  private int y = 0;
  
  private TextView z;
  
  public eb(Activity paramActivity) {
    super(paramActivity);
  }
  
  public eb(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void F() {
    G();
    ep ep = new ep(this);
    this.C = new Timer();
    this.C.schedule(ep, 0L, 1000L);
  }
  
  private void G() {
    if (this.C != null) {
      this.C.purge();
      this.C.cancel();
      this.C = null;
    } 
  }
  
  private void a(String paramString1, int paramInt, String paramString2) {
    this.l.p();
    a.a().a((Context)this.b, paramString1, paramInt, paramString2, new ef(this));
  }
  
  private void a(String paramString1, String paramString2) {
    c(2131165272);
    a.a().c((Context)this.b, cq.a((Context)this.b).v(), paramString1, paramString2, "", "", new eh(this, paramString1));
  }
  
  private void b(String paramString) {
    p();
    et et = new et(this, paramString, new er(this));
    cp.a().a(et);
  }
  
  private void b(String paramString1, String paramString2) {
    c(2131165272);
    a.a().c((Context)this.b, cq.a((Context)this.b).v(), paramString1, paramString2, "", "", new ej(this, paramString1));
  }
  
  private void c(String paramString) {
    p();
    a.a().f((Context)this.b, paramString, new eu(this));
  }
  
  private void c(String paramString1, String paramString2) {
    p();
    a.a().e((Context)this.b, paramString1, paramString2, new el(this, paramString1));
  }
  
  private void d(String paramString1, String paramString2) {
    p();
    a.a().h((Context)this.b, paramString1, paramString2, new en(this, paramString1, paramString2));
  }
  
  private void e(String paramString1, String paramString2) {
    c(2131165244);
    a.a().b((Context)this.b, paramString1, paramString2, new ed(this));
  }
  
  void a() {
    findViewById(2131296445).setOnClickListener(this);
    this.B = (SecurityCodeView)findViewById(2131296444);
    this.B.setInputCompleteListener(new ec(this));
    TextView textView = (TextView)findViewById(2131296442);
    this.z = (TextView)findViewById(2131296402);
    if (this.u.equals("emailForgetPwd")) {
      textView.setText(e(2131165423));
      this.z.setText((CharSequence)Html.fromHtml(e(2131165422) + cv.p(this.t)));
    } else {
      textView.setText(e(2131165353));
      this.z.setText((CharSequence)Html.fromHtml(e(2131165354) + cv.p(this.s)));
    } 
    this.A = (TextView)findViewById(2131296443);
    this.A.setOnClickListener(this);
    F();
    this.A.setEnabled(false);
  }
  
  public void a(Boolean paramBoolean) {
    byte b = 1;
    if (paramBoolean.booleanValue()) {
      byte b1;
      if (this.u.equals("phoneLogin")) {
        b1 = 3;
      } else {
        b1 = b;
        if (!this.u.equals("newPhoneBind")) {
          b1 = b;
          if (!this.u.equals("phoneBind"))
            if (this.u.equals("forgetPwd")) {
              b1 = 2;
            } else {
              b1 = b;
              if (this.u.equals("upgradeAccount"))
                b1 = b; 
            }  
        } 
      } 
      a(this.s, b1, cq.a((Context)this.b).j());
    } 
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.s = (String)a("phone");
    this.u = (String)a("action");
    this.t = (String)a("email");
  }
  
  int c() {
    return 2130903081;
  }
  
  public void onClick(View paramView) {
    int i = a(paramView);
    if (i == 2131296445) {
      if (this.u.equals("phoneLogin")) {
        t.a((Context)this.b).b("Login_platform", "login_code_problem", 1);
        bv.a(this.b, gt.class, z());
        return;
      } 
      if (this.u.equals("newPhoneBind")) {
        t.a((Context)this.b).b("Bind_platform", "bind_code_problem", 1);
        bv.a(this.b, dn.class, z());
        return;
      } 
      if (this.u.equals("phoneBind")) {
        t.a((Context)this.b).b("Bind_platform", "bind_code_problem", 1);
        bv.a(this.b, gt.class, z());
        return;
      } 
      if (this.u.equals("forgetPwd")) {
        t.a((Context)this.b).b("Forget_platform", "pass_code_problem", 1);
        bv.a(this.b, gt.class, z());
        return;
      } 
      if (this.u.equals("upgradeAccount")) {
        t.a((Context)this.b).b("Bind_platform", "bind_code_problem", 1);
        bv.a(this.b, gt.class, z());
        return;
      } 
      if (this.u.equals("emailForgetPwd")) {
        t.a((Context)this.b).b("Forget_platform", "email_code_problem", 1);
        bv.a(this.b, gt.class, z());
      } 
      return;
    } 
    if (i == 2131296443) {
      if (this.y < 2) {
        if (this.u.equals("phoneLogin")) {
          t.a((Context)this.b).b("Login_platform", "login_code_resend", 1);
        } else if (this.u.equals("newPhoneBind") || this.u.equals("phoneBind") || this.u.equals("upgradeAccount")) {
          t.a((Context)this.b).b("Bind_platform", "bind_code_resend", 1);
        } else if (this.u.equals("forgetPwd")) {
          t.a((Context)this.b).b("Forget_platform", "pass_code_resend", 1);
        } else if (this.u.equals("emailForgetPwd")) {
          t.a((Context)this.b).b("Forget_platform", "email_code_resend", 1);
          c(this.t);
          return;
        } 
        b(this.s);
        return;
      } 
      if (this.u.equals("phoneLogin")) {
        t.a((Context)this.b).b("Login_platform", "login_code_voice", 1);
      } else if (this.u.equals("newPhoneBind") || this.u.equals("phoneBind") || this.u.equals("upgradeAccount")) {
        t.a((Context)this.b).b("Bind_platform", "bind_code_voice", 1);
      } else if (this.u.equals("forgetPwd")) {
        t.a((Context)this.b).b("Forget_platform", "pass_code_voice", 1);
      } else if (this.u.equals("emailForgetPwd")) {
        t.a((Context)this.b).b("Forget_platform", "email_code_resend", 1);
        c(this.t);
        return;
      } 
      (new br((Context)this.b, ci.a((Context)this.b, 2131230726), this)).show();
    } 
  }
  
  public void s() {
    super.s();
    G();
  }
  
  public void show() {
    super.show();
    getWindow().setSoftInputMode(5);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\eb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */