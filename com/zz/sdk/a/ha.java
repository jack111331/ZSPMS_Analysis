package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import com.zz.sdk.c.a;
import com.zz.sdk.d.a;
import com.zz.sdk.e.bg;
import com.zz.sdk.e.cr;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import com.zz.sdk.i.v;
import com.zz.sdk.lib.widget.EditTextWithDel;
import com.zz.sdk.lib.widget.a;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.Map;
import java.util.Timer;

public class ha extends w implements View.OnClickListener, a {
  private static int P = 0;
  
  private static int Q = 0;
  
  private static final float a = 480.0F;
  
  private static final float n = 400.0F;
  
  private static final float o = 650.0F;
  
  private int A;
  
  private int B;
  
  private FancyButton C;
  
  private FancyButton D;
  
  private EditTextWithDel E;
  
  private EditTextWithDel F;
  
  private EditTextWithDel G;
  
  private EditTextWithDel H;
  
  private bg I;
  
  private boolean J = false;
  
  private int K;
  
  private int L;
  
  private int M;
  
  private int N;
  
  private boolean O = false;
  
  private int p = 0;
  
  private Timer q = null;
  
  private int r = 60;
  
  private String s;
  
  private String t;
  
  private String u;
  
  private String x;
  
  private Handler y = new Handler();
  
  private t z;
  
  public ha(Activity paramActivity) {
    this(paramActivity, ci.a((Context)paramActivity, 2131230726));
  }
  
  public ha(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void F() {
    (new a((Context)this.b)).b(e(2131165299)).a(e(2131165300)).b(e(2131165251), new hb(this)).show();
  }
  
  private void G() {
    this.s = this.E.getText().toString().trim();
    Pair pair = cq.e(this.s);
    if (!((Boolean)pair.first).booleanValue()) {
      a((String)pair.second + "");
      return;
    } 
    this.t = this.F.getText().toString().trim();
    pair = cq.p(this.t);
    if (!((Boolean)pair.first).booleanValue()) {
      a((CharSequence)pair.second);
      return;
    } 
    b(e(2131165272));
    (new Thread(new hc(this))).start();
  }
  
  private void H() {
    I();
    hh hh = new hh(this);
    this.q = new Timer();
    this.q.schedule(hh, 0L, 1000L);
  }
  
  private void I() {
    if (this.q != null) {
      this.q.purge();
      this.q.cancel();
      this.q = null;
    } 
  }
  
  public static int a(float paramFloat1, float paramFloat2) {
    return (int)(paramFloat1 * paramFloat2 + 0.5F);
  }
  
  public static int a(Context paramContext, int paramInt) {
    float f = (paramContext.getResources().getDisplayMetrics()).density;
    return a(paramInt, f);
  }
  
  private void a(String paramString1, int paramInt, String paramString2) {
    this.l.p();
    a.a().a((Context)this.b, paramString1, paramInt, paramString2, new hj(this));
  }
  
  private void a(String paramString1, String paramString2, String paramString3) {
    Pair pair = cq.e(paramString2);
    if (!((Boolean)pair.first).booleanValue()) {
      a((String)pair.second + "");
      return;
    } 
    pair = cq.k(paramString1);
    if (!((Boolean)pair.first).booleanValue()) {
      a((CharSequence)pair.second);
      return;
    } 
    p();
    a.a().d((Context)this.b, paramString3, paramString2, paramString1, new hf(this));
  }
  
  public int D() {
    float f1 = 1.0F;
    if (P > 0)
      return P; 
    float f2 = 480.0F / this.v.densityDpi;
    if (f2 <= 1.0F)
      f1 = f2; 
    null = Math.min(this.v.widthPixels, this.v.heightPixels);
    P = Math.min((int)((f1 * null) * 0.9D), a(400.0F));
    if (P > null)
      P = null; 
    return P;
  }
  
  public int E() {
    float f1 = 1.0F;
    if (Q > 0)
      return Q; 
    float f2 = 480.0F / this.v.densityDpi;
    if (f2 <= 1.0F)
      f1 = f2; 
    null = Math.min(this.v.widthPixels, this.v.heightPixels);
    Q = Math.min((int)((f1 * null) * 0.8D), a(650.0F));
    if (Q > null)
      Q = null; 
    return Q;
  }
  
  void a() {
    setTitle(2131165403);
    cq.a((Context)this.b);
    this.z = t.a((Context)this.b);
    this.E = (EditTextWithDel)findViewById(2131296389);
    this.F = (EditTextWithDel)findViewById(2131296390);
    this.G = (EditTextWithDel)findViewById(2131296392);
    this.H = (EditTextWithDel)findViewById(2131296394);
    this.D = (FancyButton)findViewById(2131296383);
    this.D.setOnClickListener(this);
    this.C = (FancyButton)findViewById(2131296395);
    this.C.setOnClickListener(this);
    findViewById(2131296391).setVisibility(8);
    findViewById(2131296393).setVisibility(8);
    this.F.setImeOptions(6);
    findViewById(2131296387).setOnClickListener(this);
    t.a((Context)this.b).b("Buoy", "No_Tel_Auth_0", 1);
  }
  
  public void a(Boolean paramBoolean) {
    a(this.G.getText().toString().trim(), 4, cq.a((Context)this.b).j());
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.I = (bg)paramMap.get("payLayout");
    Object object = paramMap.get("realnameType");
    if (object != null)
      this.K = ((Integer)object).intValue(); 
    paramMap = (Map)paramMap.get("payIcValidate");
    if (paramMap != null)
      this.B = ((Integer)paramMap).intValue(); 
    cq cq = cq.a((Context)this.b);
    this.A = cq.o();
    this.J = ((Boolean)a("isUserPlatform", Boolean.valueOf(false))).booleanValue();
    this.L = cq.d();
    this.M = cq.e();
    this.N = cq.f();
    v.B = true;
    this.O = ((Boolean)a("forbid_back", Boolean.valueOf(false))).booleanValue();
  }
  
  int c() {
    return 2130903059;
  }
  
  protected void i() {
    t.a((Context)this.b).b("Verify_platform", "Verify_cancel", 1);
    if (this.J) {
      bv.e(this.b);
      return;
    } 
    if (this.L == 3)
      if (this.K == 0) {
        if (this.M == 3) {
          if (cm.b((Context)this.b) && !h.c((Context)this.b)) {
            F();
            return;
          } 
          cm.a((Context)this.b, true);
          bv.d(this.b);
          return;
        } 
      } else if (this.K == 1 && this.N == 3) {
        if (this.I != null && this.I instanceof cr)
          ((cr)this.I).e(true); 
        return;
      }  
    if (this.B != 0) {
      if (this.B == 2) {
        if (this.I != null && this.I instanceof cr)
          ((cr)this.I).e(true); 
        return;
      } 
      bv.f(this.b);
      return;
    } 
    if (this.A == 2) {
      if (cm.b((Context)this.b) && !h.c((Context)this.b)) {
        F();
        return;
      } 
      cm.a((Context)this.b, true);
      bv.d(this.b);
      return;
    } 
    bv.d(this.b);
  }
  
  public void onBackPressed() {
    if (this.O) {
      F();
      return;
    } 
    i();
  }
  
  public void onClick(View paramView) {
    switch (a(paramView)) {
      default:
        return;
      case 2131296383:
        t.a((Context)this.b).b("Verify_platform", "Verify_verify", 1);
        G();
      case 2131296395:
        t.a((Context)this.b).b("Verify_platform", "Verify_code", 1);
        if (h.b((TextView)this.G) != null) {
          if (this.p < 2) {
            String str2 = cq.a((Context)this.b).q();
            String str1 = str2;
            if (TextUtils.isEmpty(str2))
              str1 = cq.a((Context)this.b).v(); 
            a(this.G.getText().toString().trim(), this.E.getText().toString().trim(), str1);
          } 
          (new br((Context)this.b, ci.a((Context)this.b, 2131230726), this)).show();
        } 
      case 2131296387:
        break;
    } 
    i();
  }
  
  public void s() {
    super.s();
    v.B = false;
  }
  
  public void show() {
    super.show();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */