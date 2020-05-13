package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.nocard.utils.f;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.upwidget.w;
import com.unionpay.mobile.android.widgets.ay;
import org.json.JSONObject;

public final class af extends b implements a.b {
  private TextView r = null;
  
  private View.OnClickListener s = null;
  
  private a t = null;
  
  private int u = 0;
  
  public af(Context paramContext) {
    super(paramContext);
    this.s = new ag(this);
    setBackgroundColor(-1052684);
    e();
  }
  
  public final void a(a.a parama) {}
  
  public final void a(JSONObject paramJSONObject) {
    switch (this.u) {
      default:
        return;
      case 1:
        break;
    } 
    this.b.c();
    f.c(this.a, paramJSONObject);
    int i = f.b(this.a, paramJSONObject);
    if (i != 0)
      b(i); 
    if (this.t != null)
      this.t.f(); 
    d(13);
  }
  
  public final void a(boolean paramBoolean) {
    if (this.r != null) {
      TextView textView = this.r;
      if (!paramBoolean) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      textView.setEnabled(paramBoolean);
    } 
  }
  
  protected final void b() {
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    String str = c.bD.m;
    ay ay = new ay(this.d, str, this);
    layoutParams.addRule(13, -1);
    this.k.addView((View)ay, (ViewGroup.LayoutParams)layoutParams);
  }
  
  protected final void c() {
    boolean bool1 = true;
    this.o.a(this);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams1.addRule(10, -1);
    layoutParams1.topMargin = a.f;
    this.t = new a(this.d, this.a.X, this, "");
    this.t.setOrientation(1);
    this.t.setId(this.t.hashCode());
    this.m.addView((View)this.t, (ViewGroup.LayoutParams)layoutParams1);
    w w = w.a(this.d, this.a.Y, this.c.a(1017));
    if (w != null) {
      w.setId(w.hashCode());
      w.a(new ah(this, w.a()));
      RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
      layoutParams.addRule(3, this.t.getId());
      int j = a.d;
      layoutParams.bottomMargin = j;
      layoutParams.topMargin = j;
      layoutParams.leftMargin = a.d;
      this.m.addView((View)w, (ViewGroup.LayoutParams)layoutParams);
    } 
    this.r = new TextView(this.d);
    this.r.setText(c.bD.n);
    this.r.setTextSize(b.i);
    this.r.setTextColor(p());
    this.r.setGravity(17);
    TextView textView = this.r;
    boolean bool2 = bool1;
    if (this.t != null)
      if (this.t.e()) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }  
    textView.setEnabled(bool2);
    int i = a.n;
    Drawable drawable = this.c.a(2008);
    this.r.setBackgroundDrawable(drawable);
    this.r.setOnClickListener(this.s);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, i);
    if (w != null) {
      i = w.getId();
    } else {
      i = this.t.getId();
    } 
    layoutParams2.addRule(3, i);
    layoutParams2.topMargin = a.f;
    this.m.addView((View)this.r, (ViewGroup.LayoutParams)layoutParams2);
  }
  
  public final void c(String paramString) {}
  
  public final void c(String paramString1, String paramString2) {}
  
  public final void u() {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */