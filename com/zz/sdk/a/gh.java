package com.zz.sdk.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.zz.sdk.b.v;
import com.zz.sdk.d.b;
import com.zz.sdk.e.bi;
import com.zz.sdk.i.a;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;

public class gh {
  public static final long a = 1500L;
  
  public static final long b = 500L;
  
  public static boolean c = true;
  
  private ImageView d;
  
  private TextView e;
  
  private v f;
  
  private Handler g = new Handler();
  
  private boolean h;
  
  private Activity i;
  
  private bi j;
  
  private WindowManager k;
  
  private WindowManager.LayoutParams l;
  
  private View m;
  
  private View n;
  
  private b o = null;
  
  private Runnable p = new gi(this);
  
  private Runnable q = new gj(this);
  
  public gh(Activity paramActivity, bi parambi, boolean paramBoolean) {
    this.i = paramActivity;
    this.j = parambi;
    this.h = paramBoolean;
    b();
  }
  
  private View a(View paramView, int paramInt) {
    return paramView.findViewById(ci.a((Context)this.i, paramInt));
  }
  
  private void a() {
    bv.a(this.i, fr.class, bv.a().a("key_user", this.f).a("key_layout_main", this.j), true);
    a(true);
  }
  
  private void a(boolean paramBoolean) {
    try {
      this.g.removeCallbacks(this.q);
      if (this.k != null) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this.n, "translationY", new float[] { 0.0F, -this.m.getMeasuredHeight() });
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        this();
        objectAnimator.setInterpolator((TimeInterpolator)decelerateInterpolator);
        objectAnimator.setDuration(500L);
        gl gl = new gl();
        this(this, paramBoolean);
        objectAnimator.addListener(gl);
        objectAnimator.start();
        return;
      } 
      if (!paramBoolean && (this.h || bv.b(this.i) <= 0))
        bv.d(this.i); 
    } catch (Exception exception) {}
  }
  
  private void b() {
    this.m = View.inflate((Context)this.i, ci.a((Context)this.i, 2130903137), null);
    this.n = a(this.m, 2131296400);
    this.d = (ImageView)a(this.m, 2131296646);
    this.e = (TextView)a(this.m, 2131296415);
    ((FancyButton)a(this.m, 2131296502)).setOnClickListener(new gm(this));
    this.k = this.i.getWindowManager();
    this.l = new WindowManager.LayoutParams(-2, -2, 2, 8, -2);
    this.l.flags = 1064;
    this.l.gravity = 49;
    this.l.x = 0;
    this.l.y = 0;
  }
  
  private void b(v paramv) {
    int i = cv.t((Context)this.i);
    this.f = paramv;
    h.a(this.d, paramv);
    String str2 = "";
    String str3 = str2;
    if (i == 2)
      if (paramv.i == 1) {
        str3 = "" + "手机号 ";
      } else if (paramv.h == 1) {
        str3 = "" + "手机号 ";
      } else if (paramv.i == 3) {
        str3 = "" + "游客 ";
      } else {
        str3 = str2;
        if (paramv.i != 5) {
          str3 = str2;
          if (paramv.i != 6) {
            str3 = str2;
            if (paramv.i != 7)
              if (a.a()) {
                str3 = "" + this.i.getString(ci.a((Context)this.i, 2131165410)) + " ";
              } else {
                str3 = "" + this.i.getString(ci.a((Context)this.i, 2131165186)) + " ";
              }  
          } 
        } 
      }  
    String str1 = str3 + h.b(paramv);
    this.e.setText(str1);
  }
  
  public void a(v paramv) {
    if (paramv == null) {
      a();
      return;
    } 
    b(paramv);
    try {
      this.m.measure(0, 0);
      this.k.addView(this.m, (ViewGroup.LayoutParams)this.l);
      ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this.n, "translationY", new float[] { -this.m.getMeasuredHeight(), 0.0F });
      DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
      this();
      objectAnimator.setInterpolator((TimeInterpolator)decelerateInterpolator);
      objectAnimator.setDuration(500L);
      gk gk = new gk();
      this(this);
      objectAnimator.addListener(gk);
      objectAnimator.start();
    } catch (Exception exception) {
      bp.a("添加浮标出错");
      bp.a(exception);
      c = false;
      this.g.postDelayed(this.p, 1500L);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\gh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */