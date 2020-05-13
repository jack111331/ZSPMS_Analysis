package com.unionpay.mobile.android.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.utils.k;
import org.json.JSONObject;

public final class UPWidget extends aa implements u.b {
  private static final int o = a.t / 3;
  
  protected int c = 0;
  
  private long p;
  
  private boolean q = true;
  
  private String r = null;
  
  private boolean s = false;
  
  private ViewTreeObserver.OnGlobalLayoutListener t = new aw(this);
  
  private bb u = null;
  
  private View.OnClickListener v = new ax(this);
  
  public UPWidget(Context paramContext, long paramLong, int paramInt, JSONObject paramJSONObject, String paramString) {
    super(paramContext, paramInt, paramJSONObject, paramString);
    this.p = paramLong;
    this.b.a(this);
    this.b.a((InputFilter)new InputFilter.LengthFilter(6));
    this.b.f();
    this.b.d();
    e();
  }
  
  private native void appendOnce(long paramLong, String paramString);
  
  private native void clearAll(long paramLong);
  
  private native void deleteOnce(long paramLong);
  
  private native String getMsg(long paramLong);
  
  private native String getMsgExtra(long paramLong, String paramString);
  
  private void w() {
    if (x() != null)
      x().getViewTreeObserver().removeGlobalOnLayoutListener(this.t); 
    if (this.u != null && this.u.b())
      this.u.a(); 
  }
  
  private View x() {
    return ((Activity)this.d).findViewById(8888);
  }
  
  public final String a() {
    return this.q ? getMsgExtra(this.p, this.r) : getMsg(this.p);
  }
  
  public final void a(long paramLong) {
    this.p = paramLong;
  }
  
  public final void a(boolean paramBoolean) {
    this.s = paramBoolean;
    if (paramBoolean) {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.b.getWindowToken(), 0);
      boolean bool = true;
      int i = x().getRootView().getHeight();
      int j = x().getHeight();
      Rect rect = new Rect();
      getWindowVisibleDisplayFrame(rect);
      if (i - j != rect.top)
        bool = false; 
      if (bool) {
        l();
        return;
      } 
      if (!j()) {
        k.a("uppay", "key board is closing..");
        k.a("uppay", "registerKeyboardDissmisslisner() +++");
        if (x() != null)
          x().getViewTreeObserver().addOnGlobalLayoutListener(this.t); 
        k.a("uppay", "registerKeyboardDissmisslisner() ---");
      } 
      return;
    } 
    w();
  }
  
  public final void a_() {
    if (this.s && !j())
      l(); 
  }
  
  public final void b(String paramString) {
    this.r = paramString;
  }
  
  public final void b(boolean paramBoolean) {
    this.q = paramBoolean;
  }
  
  public final boolean b() {
    return (this.c == 6);
  }
  
  public final boolean c() {
    k.a("uppay", "emptyCheck() +++ ");
    k.a("uppay", "mPINCounts =  " + this.c);
    k.a("uppay", "emptyCheck() --- ");
    return (this.c != 0);
  }
  
  protected final String d() {
    return "_bank_pwd";
  }
  
  public final void e() {
    clearAll(this.p);
    this.c = 0;
  }
  
  public final boolean j() {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (this.u != null) {
      bool2 = bool1;
      if (this.u.b())
        bool2 = true; 
    } 
    return bool2;
  }
  
  public final void k() {
    k.a("uppay", "closeCustomKeyboard() +++");
    if (j())
      w(); 
    k.a("uppay", "closeCustomKeyboard() ---");
  }
  
  public final void l() {
    if (this.s && !j()) {
      this.u = new bb(getContext(), this.v, (View)this);
      this.u.a((View)this);
      int i = this.c;
      String str = "";
      for (byte b1 = 0; b1 < i; b1++)
        str = str + "*"; 
      this.b.c(str);
      this.b.b(str.length());
    } 
  }
  
  protected final void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    k();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\UPWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */