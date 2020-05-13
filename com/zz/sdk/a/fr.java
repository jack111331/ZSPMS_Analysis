package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.zz.sdk.a.a.e;
import com.zz.sdk.b.v;
import com.zz.sdk.b.w;
import com.zz.sdk.c.a;
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
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class fr extends w implements View.OnClickListener, c {
  static ArrayList u = new ArrayList();
  
  private e A;
  
  private boolean B;
  
  private v C;
  
  private boolean D = false;
  
  private boolean E = false;
  
  private Runnable F = new fy(this);
  
  private DialogInterface.OnClickListener G = new ft(this);
  
  private Runnable H = new fu(this);
  
  protected FrameLayout a;
  
  protected ImageView n;
  
  protected TextView o;
  
  protected TextView p;
  
  protected TextView q;
  
  protected ImageView r;
  
  protected FancyButton s;
  
  protected FancyButton t;
  
  private cq x;
  
  private boolean y = false;
  
  private PopupWindow z = null;
  
  public fr(Activity paramActivity) {
    super(paramActivity);
  }
  
  public fr(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void F() {
    u.clear();
    v v1 = (v)a("key_user");
    if (v1 != null)
      c(v1); 
    v[] arrayOfV = w.a((Context)this.b).c();
    if (arrayOfV != null && arrayOfV.length != 0) {
      Collections.addAll(u, arrayOfV);
      if (u.size() != 0)
        c(u.get(0)); 
    } else if (v1 != null) {
      u.add(v1);
    } 
    a(this.C);
  }
  
  private PopupWindow G() {
    this.z = new fz(this, (View)this.a, this.a.getMeasuredWidth(), -2, true);
    this.z.setClippingEnabled(true);
    this.z.setTouchable(true);
    this.z.setOutsideTouchable(true);
    this.z.setBackgroundDrawable((Drawable)new BitmapDrawable(this.b.getResources(), (Bitmap)null));
    View view = View.inflate((Context)this.b, ci.a((Context)this.b, 2130903140), null);
    this.z.setContentView(view);
    ListView listView = (ListView)view.findViewById(ci.a((Context)this.b, 2131296653));
    listView.setOnItemClickListener(new gb(this));
    this.A.a(new gc(this));
    listView.setAdapter((ListAdapter)this.A);
    this.z.setFocusable(true);
    return this.z;
  }
  
  private void H() {
    this.E = true;
    F();
    this.x = cq.a((Context)this.b);
    d.b(this.b);
    if (this.y) {
      this.y = false;
      this.k.postDelayed(this.H, 1000L);
    } 
  }
  
  private void a(v paramv) {
    Collections.sort(u, new fs(this));
    if (u.size() != 0)
      ((v)u.get(0)).q = true; 
    ArrayList<v> arrayList = new ArrayList();
    for (byte b = 0; b < u.size(); b++) {
      if (paramv == null) {
        arrayList.add(u.get(b));
      } else if (((v)u.get(b)).toString().equals(paramv.toString())) {
        if (b == 0)
          paramv.q = true; 
      } else {
        arrayList.add(u.get(b));
      } 
    } 
    if (arrayList.size() != 0)
      if (((v)arrayList.get(0)).q) {
        ArrayList<v> arrayList1 = new ArrayList();
        for (v v1 : arrayList) {
          if (!v1.q)
            arrayList1.add(v1); 
        } 
        Collections.sort(arrayList1, new fv(this));
        arrayList1.add(0, arrayList.get(0));
        arrayList.clear();
        arrayList.addAll(arrayList1);
      } else {
        Collections.sort(arrayList, new fw(this));
      }  
    this.A = new e((Context)this.b, arrayList);
    if (paramv != null)
      c(paramv); 
  }
  
  private void b(v paramv) {
    if (paramv != null) {
      for (v v1 : u) {
        if (v1.toString().equals(paramv.toString())) {
          u.remove(v1);
          break;
        } 
      } 
      a(this.C);
    } 
  }
  
  private void c(v paramv) {
    byte b;
    this.C = paramv;
    h.b(this.o, paramv);
    h.a(this.n, paramv);
    TextView textView = this.q;
    if (paramv.q) {
      b = 0;
    } else {
      b = 8;
    } 
    textView.setVisibility(b);
    this.p.setText(this.b.getString(ci.a((Context)this.b, 2131165409), new Object[] { cv.a(paramv.f) }));
  }
  
  private void d(v paramv) {
    c(2131165244);
    a.a().a((Context)this.b, paramv, new ge(this, paramv));
  }
  
  void a() {
    this.x = cq.a((Context)this.b);
    c(false);
    h.a((ImageView)findViewById(2131296360));
    this.a = (FrameLayout)findViewById(2131296640);
    this.n = (ImageView)findViewById(2131296642);
    this.o = (TextView)findViewById(2131296637);
    this.p = (TextView)findViewById(2131296638);
    this.q = (TextView)findViewById(2131296643);
    this.r = (ImageView)findViewById(2131296644);
    this.r.setVisibility(0);
    this.r.setOnClickListener(this);
    this.s = (FancyButton)findViewById(2131296467);
    this.s.setOnClickListener(this);
    this.t = (FancyButton)findViewById(2131296468);
    this.t.setOnClickListener(this);
    if (!this.E)
      H(); 
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
    this.y = false;
    this.k.removeCallbacks(this.H);
    r();
  }
  
  public void a(c paramc, a parama) {
    this.y = false;
    this.k.removeCallbacks(this.H);
    h.a((Context)this.b, this.x, parama, this.l);
    r();
  }
  
  public void a(c paramc, String paramString) {
    this.y = false;
    this.k.removeCallbacks(this.H);
    r();
    a(paramString);
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.B = ((Boolean)a("key_auto_login", Boolean.valueOf(false))).booleanValue();
    this.D = ((Boolean)a("canBack", Boolean.valueOf(false))).booleanValue();
  }
  
  public void a(boolean paramBoolean, PopupWindow paramPopupWindow) {
    if (Build.VERSION.SDK_INT >= 21)
      try {
        Field field = PopupWindow.class.getDeclaredField("mLayoutInScreen");
        field.setAccessible(true);
        field.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
      } catch (Exception exception) {} 
  }
  
  protected boolean b() {
    return true;
  }
  
  int c() {
    return 2130903085;
  }
  
  public void d() {
    super.d();
    d.a(this.b);
  }
  
  public void e() {
    super.e();
    if (!this.E)
      H(); 
  }
  
  public void f() {
    super.f();
    bv.a(this.b, this, false);
  }
  
  protected void n() {
    super.n();
  }
  
  public void onBackPressed() {
    if (this.D)
      super.onBackPressed(); 
  }
  
  public void onClick(View paramView) {
    boolean bool2;
    boolean bool3;
    boolean bool1 = true;
    switch (a(paramView)) {
      default:
        return;
      case 2131296644:
        if (u.size() >= 1) {
          this.z = G();
          this.z.showAsDropDown((View)this.a);
        } 
      case 2131296467:
        t.a((Context)this.b).b("History_platform", "History_Login", 1);
        if (this.C == null)
          a(e(2131165277)); 
        d(this.C);
      case 2131296468:
        break;
    } 
    t.a((Context)this.b).b("Login_platform", "change_account", 1);
    if (c.a.b() && cv.a(c.a.a(), "enabled", "1").equals("1")) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (c.b.b() && cv.a(c.b.a(), "enabled", "1").equals("1")) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (!c.c.b() || !cv.a(c.c.a(), "enabled", "1").equals("1"))
      bool1 = false; 
    boolean bool = cv.a("phone", "enabled", "1").equals("1");
    if (!bool2 && !bool3 && !bool1 && !bool)
      bv.a(this.b, a.class, z()); 
    bv.a(this.b, fe.class, z());
  }
  
  public void s() {
    super.s();
    d.c(this.b);
  }
  
  public void show() {
    super.show();
    if (this.B) {
      this.B = false;
      b(2131165244, true).setOnCancelListener(new fx(this));
      this.k.postDelayed(this.F, 2000L);
    } 
  }
  
  protected boolean v() {
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\fr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */