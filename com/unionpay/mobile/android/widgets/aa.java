package com.unionpay.mobile.android.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;

public abstract class aa extends z {
  protected int a;
  
  protected u b = null;
  
  private a c = null;
  
  public aa(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString) {
    this(paramContext, paramInt, paramJSONObject, paramString, (byte)0);
  }
  
  public aa(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString, byte paramByte) {
    super(paramContext, paramJSONObject, paramString);
    this.a = paramInt;
    c.a(this.d);
    paramContext = getContext();
    paramInt = this.a;
    this.b = new u(paramContext);
    if (this.i) {
      this.b.a();
      this.b.d();
    } 
    this.b.c(i());
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n);
    layoutParams.addRule(15, -1);
    this.m.addView((View)this.b, (ViewGroup.LayoutParams)layoutParams);
    this.b.b(j.a(paramJSONObject, "placeholder"));
    this.b.setFocusable(true);
    this.b.a(new ab(this));
    this.b.a(new ac(this));
    Drawable drawable = c.a(this.d).a(2000, -1, com.unionpay.mobile.android.global.a.v);
    this.b.a(drawable);
    if (this instanceof af) {
      if (!this.i) {
        this.b.a(c.bD.aQ);
      } else {
        this.b.c(this.h + " " + this.g);
      } 
    } else if (this instanceof ap) {
      this.b.a(c.bD.aR);
    } else if (this instanceof ah) {
      this.b.a(c.bD.aT);
    } else if (this instanceof UPWidget) {
      this.b.a(c.bD.aS);
    } else if (this instanceof au) {
      this.b.a(c.bD.aU);
    } else if (this instanceof ao) {
      this.b.a(c.bD.aV);
    } else if (this instanceof e) {
      this.b.a(c.bD.aW);
    } else if (this instanceof ae) {
      this.b.a(c.bD.aX);
    } else if (this instanceof bd) {
      this.b.a(c.bD.aY);
    } else if (this instanceof at) {
      this.b.a(c.bD.aZ);
    } else if (this instanceof av) {
      this.b.a(c.bD.ba);
    } else if (this instanceof f) {
      this.b.a(c.bD.bb);
    } 
    if (this instanceof k) {
      this.b.setBackgroundDrawable(c.a(this.d).a(1011));
      return;
    } 
    this.b.setBackgroundDrawable(c.a(this.d).a(1013));
  }
  
  public String a() {
    return this.b.b();
  }
  
  public void a(Editable paramEditable) {}
  
  public final void a(a parama) {
    this.c = parama;
  }
  
  protected final boolean a(View paramView) {
    boolean bool = true;
    if (paramView == null)
      throw new NullPointerException(); 
    Rect rect2 = new Rect();
    paramView.getGlobalVisibleRect(rect2);
    Log.e("uppay", "v getGlobalVisibleRect():" + rect2.toString());
    Rect rect3 = new Rect();
    ((Activity)this.d).getWindow().getDecorView().findViewById(16908290).getGlobalVisibleRect(rect3);
    int[] arrayOfInt1 = new int[2];
    paramView.getLocationInWindow(arrayOfInt1);
    Log.e("uppay", " locationW = [" + arrayOfInt1[0] + "," + arrayOfInt1[1] + "]");
    int[] arrayOfInt2 = new int[2];
    paramView.getLocationOnScreen(arrayOfInt2);
    Log.e("uppay", " locationS = [" + arrayOfInt2[0] + "," + arrayOfInt2[1] + "]");
    if (arrayOfInt1[1] + paramView.getHeight() + 10 <= rect3.bottom)
      bool = false; 
    paramView = ((Activity)this.d).getWindow().getDecorView().findViewById(16908290);
    Rect rect1 = new Rect();
    paramView.getLocalVisibleRect(rect1);
    Log.e("uppay", " getLocalVisibleRect = " + rect1.toString());
    rect1 = new Rect();
    paramView.getGlobalVisibleRect(rect1);
    Log.e("uppay", " getGlobalVisibleRect = " + rect1.toString());
    return bool;
  }
  
  public final boolean a(u paramu) {
    return (paramu != null && this.b == paramu);
  }
  
  public boolean c() {
    return (a() != null && a().length() != 0);
  }
  
  public final void g() {
    if (this.b != null && !this.i)
      this.b.e(); 
  }
  
  public static interface a {
    void a(u param1u, String param1String);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */