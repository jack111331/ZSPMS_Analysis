package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.zz.sdk.a.a.i;
import com.zz.sdk.b.a.r;
import com.zz.sdk.c.a;
import com.zz.sdk.d.a;
import com.zz.sdk.e.bg;
import com.zz.sdk.e.cr;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.EditTextWithDel;
import com.zz.sdk.lib.widget.a;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.List;
import java.util.Map;
import java.util.Timer;

public class db extends w implements View.OnClickListener, a {
  private static final int L = 60;
  
  private FancyButton A;
  
  private GridView B;
  
  private i C;
  
  private boolean D = false;
  
  private bg E;
  
  private boolean F = false;
  
  private int G;
  
  private int H;
  
  private int I;
  
  private int J;
  
  private int K = 0;
  
  private Timer M = null;
  
  private int N = 60;
  
  private int a;
  
  private int n;
  
  private String o;
  
  private String p;
  
  private String q;
  
  private String r;
  
  private Handler s = new Handler();
  
  private t t;
  
  private EditTextWithDel u;
  
  private EditTextWithDel x;
  
  private EditTextWithDel y;
  
  private EditTextWithDel z;
  
  public db(Activity paramActivity) {
    super(paramActivity);
  }
  
  private void F() {
    (new a((Context)this.b)).b(e(2131165299)).a(e(2131165300)).b(e(2131165251), new dc(this)).show();
  }
  
  private void G() {
    this.o = this.u.getText().toString().trim();
    Pair pair = cq.e(this.o);
    if (!((Boolean)pair.first).booleanValue()) {
      a((String)pair.second + "");
      return;
    } 
    this.p = this.x.getText().toString().trim();
    pair = cq.p(this.p);
    if (!((Boolean)pair.first).booleanValue()) {
      a((String)pair.second + "");
      return;
    } 
    this.q = this.y.getText().toString().trim();
    pair = cq.k(this.q);
    if (!((Boolean)pair.first).booleanValue()) {
      a((CharSequence)pair.second);
      return;
    } 
    this.r = this.z.getText().toString();
    if (TextUtils.isEmpty(this.r)) {
      b(2131165249);
      return;
    } 
    b(e(2131165272));
    (new Thread(new dd(this))).start();
  }
  
  private void H() {
    I();
    dj dj = new dj(this);
    this.M = new Timer();
    this.M.schedule(dj, 0L, 1000L);
  }
  
  private void I() {
    if (this.M != null) {
      this.M.purge();
      this.M.cancel();
      this.M = null;
    } 
  }
  
  private void a(String paramString1, int paramInt, String paramString2) {
    this.l.p();
    a.a().a((Context)this.b, paramString1, paramInt, paramString2, new dl(this));
  }
  
  private void a(String paramString1, String paramString2, String paramString3) {
    Pair pair = cq.k(paramString1);
    if (!((Boolean)pair.first).booleanValue()) {
      a((CharSequence)pair.second);
      return;
    } 
    p();
    a.a().d((Context)this.b, paramString3, paramString2, paramString1, new dh(this));
  }
  
  public int D() {
    return -1;
  }
  
  public int E() {
    return -1;
  }
  
  void a() {
    A();
    this.t = t.a((Context)this.b);
    this.u = (EditTextWithDel)findViewById(2131296431);
    this.x = (EditTextWithDel)findViewById(2131296432);
    this.y = (EditTextWithDel)findViewById(2131296433);
    this.z = (EditTextWithDel)findViewById(2131296434);
    this.A = (FancyButton)findViewById(2131296435);
    this.A.setOnClickListener(this);
    findViewById(2131296436).setOnClickListener(this);
    this.B = (GridView)findViewById(2131296430);
    this.B.setSelector((Drawable)new ColorDrawable(0));
    r r = cv.h();
    if (r != null) {
      List list = r.j().d();
      if (list.size() > 0)
        this.B.setNumColumns(list.size()); 
      this.C = new i((Context)this.b, list);
      this.B.setAdapter((ListAdapter)this.C);
    } 
  }
  
  public void a(Configuration paramConfiguration) {
    if (this.D) {
      bv.d(this.b);
      return;
    } 
    bv.a(this.b, db.class, bv.a().a("key_show_close", Boolean.valueOf(true)).a("key_show_back", Boolean.valueOf(false)).a("isUserPlatform", Boolean.valueOf(this.F)).a("payIcValidate", Integer.valueOf(this.n)).a("payLayout", this.E).a("realnameType", Integer.valueOf(this.G)), true);
  }
  
  public void a(Boolean paramBoolean) {
    a(this.y.getText().toString().trim(), 4, cq.a((Context)this.b).j());
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.E = (bg)paramMap.get("payLayout");
    Object object = paramMap.get("realnameType");
    if (object != null)
      this.G = ((Integer)object).intValue(); 
    paramMap = (Map)paramMap.get("payIcValidate");
    if (paramMap != null)
      this.n = ((Integer)paramMap).intValue(); 
    cq cq = cq.a((Context)this.b);
    this.a = cq.o();
    this.F = ((Boolean)a("isUserPlatform", Boolean.valueOf(false))).booleanValue();
    this.H = cq.d();
    this.I = cq.e();
    this.J = cq.f();
  }
  
  int c() {
    return 2130903078;
  }
  
  protected void i() {
    t.a((Context)this.b).b("Verify_platform", "Verify_cancel", 1);
    if (this.F) {
      bv.e(this.b);
      return;
    } 
    if (this.H == 3)
      if (this.G == 0) {
        if (this.I == 3) {
          F();
          return;
        } 
      } else if (this.G == 1 && this.J == 3) {
        if (this.E != null && this.E instanceof cr)
          ((cr)this.E).e(true); 
        return;
      }  
    if (this.n != 0) {
      if (this.n == 2) {
        if (this.E != null && this.E instanceof cr)
          ((cr)this.E).e(true); 
        return;
      } 
      bv.f(this.b);
      return;
    } 
    if (this.a == 2) {
      F();
      return;
    } 
    bv.d(this.b);
  }
  
  protected void n() {
    super.n();
    setTitle(2131165230);
  }
  
  public void onBackPressed() {
    i();
  }
  
  public void onClick(View paramView) {
    switch (a(paramView)) {
      default:
        return;
      case 2131296436:
        t.a((Context)this.b).b("Verify_platform", "Verify_verify", 1);
        G();
      case 2131296435:
        break;
    } 
    String str = h.b((TextView)this.y);
    if (str != null) {
      if (this.K < 2) {
        String str2 = cq.a((Context)this.b).q();
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
          str1 = cq.a((Context)this.b).v(); 
        a(str, cq.a((Context)this.b).j(), str1);
      } 
      (new br((Context)this.b, ci.a((Context)this.b, 2131230726), this)).show();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */