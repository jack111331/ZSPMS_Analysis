package com.zz.sdk.h;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.zz.sdk.activity.FloatActivity;
import com.zz.sdk.i.bg;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.v;

public class f implements View.OnTouchListener, n {
  private static final String A = "lie_y";
  
  private static final int B = 100;
  
  private static f C = null;
  
  private static final int s = 0;
  
  private static final int t = 1;
  
  private static final int u = 2;
  
  private static final int v = 3;
  
  private static final String x = "show";
  
  private static final String y = "lie";
  
  private static final String z = "lie_x";
  
  private g D;
  
  private boolean E;
  
  private View F;
  
  private float G;
  
  private float H;
  
  private long I;
  
  private boolean J = true;
  
  private int K;
  
  private int L;
  
  private boolean M = false;
  
  boolean a = false;
  
  private Context b = null;
  
  private Activity c = null;
  
  private View d = null;
  
  private WindowManager e = null;
  
  private WindowManager.LayoutParams f = null;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m = 150;
  
  private int n;
  
  private int o = 0;
  
  private boolean p = false;
  
  private int q;
  
  private int r;
  
  private int w = 0;
  
  private f(Activity paramActivity) {
    bp.a("FloatService");
    DisplayMetrics displayMetrics = paramActivity.getResources().getDisplayMetrics();
    this.g = displayMetrics.widthPixels;
    this.h = displayMetrics.heightPixels;
    this.m = cv.a((Context)paramActivity);
    this.b = paramActivity.getBaseContext();
    this.c = paramActivity;
    a();
  }
  
  public static f a(Activity paramActivity) {
    if (C != null)
      C.b(); 
    C = new f(paramActivity);
    return C;
  }
  
  private void a(int paramInt) {
    bp.a("FloatService...startFloatActivity num:" + paramInt);
    Intent intent = new Intent(this.b, FloatActivity.class);
    intent.setFlags(268435456);
    intent.putExtra("num", paramInt);
    this.b.startActivity(intent);
  }
  
  public static f b(Activity paramActivity) {
    if (C == null)
      C = new f(paramActivity); 
    return C;
  }
  
  private void b(int paramInt1, int paramInt2) {
    bp.a("FloatService...refreshView x:" + paramInt1);
    bp.a("FloatService...refreshView y:" + paramInt2);
    this.f.x = paramInt1;
    this.f.y = paramInt2;
    try {
      this.e.updateViewLayout(this.d, (ViewGroup.LayoutParams)this.f);
    } catch (Exception exception) {}
  }
  
  private void c(int paramInt1, int paramInt2) {
    int i = 0;
    bp.a("FloatService...location x:" + paramInt1);
    bp.a("FloatService...location y:" + paramInt2);
    if (paramInt2 < this.m) {
      if (paramInt1 <= this.o) {
        p();
        paramInt1 -= this.l;
      } else {
        q();
        paramInt1 = this.g - paramInt1 - this.l;
      } 
      this.w = 1;
      i = 0;
      paramInt2 = paramInt1;
      paramInt1 = i;
    } else if (paramInt2 > this.n) {
      if (paramInt1 <= this.o) {
        p();
        paramInt1 -= this.l;
      } else {
        q();
        paramInt1 = this.g - paramInt1 - this.l;
      } 
      i = this.h;
      int j = this.i;
      this.w = 3;
      paramInt2 = paramInt1;
      paramInt1 = i - j;
    } else if (paramInt1 >= this.o) {
      q();
      paramInt1 = paramInt2 - this.k;
      this.w = 2;
      paramInt2 = i;
    } else {
      p();
      this.w = 0;
      paramInt1 = paramInt2 - this.k;
      paramInt2 = i;
    } 
    this.q = paramInt2;
    this.r = paramInt1;
    o();
    bp.a("FloatService...refreshView...10");
    n();
    k();
    this.D.c.sendEmptyMessageDelayed(1, 2000L);
  }
  
  private void k() {
    bp.a("FloatService...saveLocation");
    cm.a(this.b, "show", this.D.g());
    cm.a(this.b, "lie", this.w);
    cm.a(this.b, "lie_x", this.q);
    cm.a(this.b, "lie_y", this.r);
  }
  
  private void l() {
    bp.a("FloatService...swapWidthHeight");
    DisplayMetrics displayMetrics = this.c.getResources().getDisplayMetrics();
    this.g = displayMetrics.widthPixels;
    this.h = displayMetrics.heightPixels;
    this.o = this.g / 2;
  }
  
  private boolean m() {
    return ((this.b.getResources().getConfiguration()).orientation == 2);
  }
  
  private void n() {
    b(this.q, this.r);
  }
  
  private void o() {
    bp.a("FloatService...limitBorder");
    if (this.q < 0)
      this.q = 0; 
    if (this.r < 0)
      this.r = 0; 
    if (this.q > this.g - this.j)
      this.q = this.g - this.j; 
    if (this.r > this.h - this.i)
      this.r = this.h - this.i; 
  }
  
  private void p() {
    bp.a("FloatService...showRight");
    this.f.gravity = 8388659;
    if (!this.M) {
      bp.a("FloatService...showRight...if");
      bg.h = Boolean.valueOf(true);
      bg.i = this.q;
      bg.j = this.r;
      this.D.m();
      this.M = true;
    } 
  }
  
  private void q() {
    bp.a("FloatService...showLeft");
    this.f.gravity = 8388661;
    if (this.M) {
      bp.a("FloatService...showLeft...if");
      bg.h = Boolean.valueOf(false);
      bg.i = this.q;
      bg.j = this.r;
      this.D.n();
      this.M = false;
    } 
  }
  
  public void a() {
    bp.a("FloatService...onCreate");
    this.e = this.c.getWindowManager();
    this.f = new WindowManager.LayoutParams(-2, -2, 1000, 8, -2);
    this.f.flags = 552;
    this.f.x = this.q;
    this.f.y = this.r;
    this.D = g.a(this.c);
    this.D.a(this);
    this.d = this.D.i();
    this.F = this.D.k();
    this.d.setOnTouchListener(this);
    this.D.j().setOnTouchListener(this);
    this.j = this.D.e();
    this.i = this.D.f();
    this.k = this.i / 2;
    this.l = this.j / 2;
    this.m += this.i;
    this.n = this.h - this.m;
    this.o = this.g / 2;
  }
  
  public void a(int paramInt1, int paramInt2) {
    bp.a("FloatService...initLocation");
    if (m() && !this.E) {
      l();
      this.E = true;
    } else if (!m() && this.E) {
      l();
      this.E = false;
    } 
    this.n = this.h - this.m;
    p();
    if (this.D.a())
      this.D.a(90, 0, 0); 
    c(paramInt1, paramInt2);
    this.J = true;
  }
  
  public void a(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public void b() {
    bp.a("FloatService...onDestroy");
    if (!this.a)
      d(); 
    this.D.c();
    this.e = null;
  }
  
  public boolean c() {
    return this.a;
  }
  
  public void d() {
    bp.a("FloatService...hide");
    this.a = true;
    if (this.e != null)
      try {
        this.e.removeView(this.d);
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public void e() {
    boolean bool;
    bp.a("FloatService...show");
    this.a = false;
    if (Build.VERSION.SDK_INT >= 17) {
      bp.a("float show...if");
      if (this.c.isDestroyed())
        this.e = null; 
    } else if (this.c.isFinishing()) {
      this.e = null;
    } 
    this.q = cm.b(this.b, "lie_x", 0);
    int i = this.h / 4;
    if (m())
      i = this.h / 2; 
    this.r = cm.b(this.b, "lie_y", i);
    this.w = cm.b(this.b, "lie", this.w);
    this.D.a(cm.b(this.b, "show", this.D.g()));
    if (!this.D.g()) {
      bool = true;
    } else {
      bool = false;
    } 
    this.M = bool;
    if (this.e != null) {
      this.f.x = this.q;
      this.f.y = this.r;
    } else {
      a();
    } 
    try {
      this.e.addView(this.d, (ViewGroup.LayoutParams)this.f);
    } catch (Exception exception) {
      bp.a("添加浮标logo出错:");
      bp.a(exception);
    } 
    if (this.D.g()) {
      p();
    } else {
      q();
    } 
    bp.a("FloatService...refreshView...07");
    n();
    this.J = true;
    this.D.c.sendEmptyMessageDelayed(1, 2000L);
    if (v.q && v.r)
      c.a(); 
  }
  
  public void f() {
    bp.a("FloatService...onClickService");
    a(2);
  }
  
  public void g() {
    bp.a("FloatService...onClickSafe");
    a(1);
  }
  
  public void h() {
    bp.a("FloatService...floatShowHalf");
    if (!this.a) {
      c.b();
      this.p = true;
      switch (this.w) {
        default:
          if (!this.a) {
            bp.a("FloatService...refreshView...06");
            b(-this.j / 2, this.r);
            return;
          } 
          break;
        case 1:
          bp.a("FloatService...refreshView...03");
          b(this.q, -this.i / 2);
          return;
        case 2:
          bp.a("FloatService...refreshView...04");
          b(-this.j / 2, this.r);
          return;
        case 3:
          bp.a("FloatService...refreshView...05");
          b(this.q, this.h - this.i / 2);
          return;
      } 
      bp.a("FloatService...floatShowHalf...else do nothing");
    } 
  }
  
  public int i() {
    return this.j;
  }
  
  public g j() {
    return this.D;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    String str;
    int i;
    int j;
    boolean bool = true;
    bp.a("FloatService...onTouch");
    if (System.currentTimeMillis() - this.I < 200L)
      return bool; 
    this.D.p();
    c.b();
    if (this.D.h()) {
      this.D.o();
      this.G = paramMotionEvent.getRawX();
      this.H = paramMotionEvent.getRawY();
      return false;
    } 
    this.F.setAlpha(1.0F);
    if (this.p) {
      bp.a("FloatService...refreshView...isHalf");
      switch (paramMotionEvent.getAction()) {
        default:
          return bool;
        case 0:
          bp.a("FloatService...refreshView...isHalf ACTION_DOWN");
          n();
          return bool;
        case 2:
          bp.a("FloatService...refreshView...isHalf ACTION_MOVE");
          this.p = false;
          return bool;
        case 1:
          break;
      } 
      bp.a("FloatService...refreshView...isHalf ACTION_UP");
      this.D.a(0);
      this.I = System.currentTimeMillis();
      this.p = false;
      boolean bool1 = bool;
      if (this.D.a()) {
        this.D.a(90, 0, 0);
        bool1 = bool;
      } 
      return bool1;
    } 
    switch (paramMotionEvent.getAction()) {
      default:
        return bool;
      case 0:
        bp.a("FloatService...onTouch ACTION_DOWN");
        this.G = paramMotionEvent.getRawX();
        this.H = paramMotionEvent.getRawY();
        this.K = (int)paramMotionEvent.getRawX();
        this.L = (int)paramMotionEvent.getRawY();
        paramView.setFocusable(true);
        this.J = true;
        return bool;
      case 2:
        bp.a("FloatService...onTouch ACTION_MOVE");
        i = (int)paramMotionEvent.getRawX();
        j = (int)paramMotionEvent.getRawY();
        if (!this.J) {
          bp.a("FloatService...refreshView...01");
          b(i - this.l, j - this.k);
          if (i >= bg.d && i <= bg.e && j >= bg.f && j <= bg.g) {
            str = cq.a(this.b).w();
            if (!Boolean.valueOf(cm.b(this.b, bg.c + str, false)).booleanValue()) {
              if (bg.b) {
                bp.a("FloatService...onTouch ACTION_MOVE start ShakeDialog");
                d();
              } else {
                bp.a("FloatService...onTouch ACTION_MOVE start ShakeDialog...do nothing");
              } 
            } else {
              bp.a("FloatService...onTouch ACTION_MOVE hide");
              d();
            } 
            a.b();
            return bool;
          } 
          a.a();
          return bool;
        } 
        if (Math.abs(i - this.G) > 20.0F || Math.abs(j - this.H) > 20.0F) {
          this.J = false;
          if (!this.D.g()) {
            this.f.gravity = 8388659;
            bp.a("FloatService...refreshView...09");
            n();
          } 
          bp.a("FloatService...refreshView...02");
          b(i - this.l, j - this.k);
          return bool;
        } 
        this.J = true;
        return bool;
      case 1:
        bp.a("FloatService...onTouch ACTION_UP");
        j = (int)paramMotionEvent.getRawX();
        i = (int)paramMotionEvent.getRawY();
        if (j - this.K == 0 && i - this.L == 0) {
          this.D.onClick((View)str);
          return bool;
        } 
        this.J = true;
        this.f.flags = 552;
        c(j, i);
        str.setFocusable(false);
        a.b();
        return bool;
      case 3:
        break;
    } 
    bp.a("FloatService...onTouch ACTION_CANCEL");
    str.setPressed(false);
    str.setFocusable(false);
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\h\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */