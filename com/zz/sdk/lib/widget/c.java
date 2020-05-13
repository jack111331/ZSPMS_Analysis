package com.zz.sdk.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import java.lang.reflect.Method;

public class c extends ListView implements AbsListView.OnScrollListener {
  private static final int q = 0;
  
  private static final int r = 1;
  
  private static final int s = 400;
  
  private static final float t = 2.2F;
  
  private float a = -1.0F;
  
  private Scroller b;
  
  private AbsListView.OnScrollListener c;
  
  private g d;
  
  private j e;
  
  private RelativeLayout f;
  
  private TextView g;
  
  private int h;
  
  private int i;
  
  private boolean j = true;
  
  private boolean k = false;
  
  private i l;
  
  private boolean m = false;
  
  private boolean n;
  
  private int o;
  
  private int p;
  
  private View u;
  
  private boolean v = false;
  
  private Context w;
  
  public c(Context paramContext) {
    super(paramContext);
    this.w = paramContext;
    e();
  }
  
  public c(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.w = paramContext;
    e();
  }
  
  public c(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.w = paramContext;
    e();
  }
  
  private void a(float paramFloat) {
    boolean bool = false;
    int k = (int)(this.e.getVisiableHeight() + paramFloat);
    if (this.k && k < this.h) {
      if (getAdapter() == null || getAdapter().getCount() == getHeaderViewsCount() + getFooterViewsCount())
        bool = true; 
      if (bool)
        this.e.setVisiableHeight(this.h); 
      return;
    } 
    this.e.setVisiableHeight(k);
    if (this.j && !this.k) {
      if (k > this.h) {
        this.e.setState(1);
      } else {
        this.e.setState(0);
      } 
      setSelection(0);
    } 
  }
  
  private void b(float paramFloat) {
    if (getAdapter() != null && getAdapter().getCount() != getHeaderViewsCount() + getFooterViewsCount()) {
      int k = this.l.getBottomMargin() + (int)paramFloat;
      this.l.setBottomMargin(k);
      if (this.m && !this.n) {
        if (k > this.i) {
          this.l.setState(1);
        } else {
          this.l.setState(0);
        } 
        setSelection(this.o - 1);
      } 
    } 
  }
  
  private void e() {
    try {
      Method method = getClass().getMethod("setOverScrollMode", new Class[] { int.class });
      method.setAccessible(true);
      method.invoke(this, new Object[] { Integer.valueOf(2) });
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    setFadingEdgeLength(0);
    setCacheColorHint(0);
    setAlwaysDrawnWithCacheEnabled(true);
    setFooterDividersEnabled(this.m);
    setHeaderDividersEnabled(this.j);
    this.b = new Scroller(this.w, (Interpolator)new DecelerateInterpolator());
    super.setOnScrollListener(this);
    this.e = new j(this.w);
    this.f = this.e.e;
    this.g = this.e.f;
    this.u = (View)this.e.g;
    addHeaderView((View)this.e);
    this.e.getViewTreeObserver().addOnGlobalLayoutListener(new d(this));
    this.l = new i(this.w);
    addFooterView((View)this.l);
    this.l.getViewTreeObserver().addOnGlobalLayoutListener(new e(this));
  }
  
  private void f() {
    if (this.c instanceof h)
      ((h)this.c).a((View)this); 
  }
  
  private void g() {
    int k = this.e.getVisiableHeight();
    if (k == 0) {
      this.e.setVisiableHeight(0);
      return;
    } 
    if (!this.k || k > this.h) {
      byte b;
      if (this.k && k > this.h) {
        b = this.h;
      } else {
        b = 0;
      } 
      this.p = 0;
      this.b.startScroll(0, k, 0, b - k, 400);
      invalidate();
    } 
  }
  
  private void h() {
    int k = this.l.getBottomMargin();
    if (k > 0) {
      this.p = 1;
      this.b.startScroll(0, k, 0, -k, 400);
      invalidate();
    } 
  }
  
  private void i() {
    this.n = true;
    this.l.setState(2);
    if (this.d != null)
      this.d.b(); 
  }
  
  public void a() {
    if (this.k == true) {
      this.k = false;
      g();
    } 
  }
  
  public boolean b() {
    return this.v;
  }
  
  public void c() {
    this.k = true;
    this.e.setState(2);
    if (this.d != null)
      this.d.a(); 
    this.e.setVisiableHeight(this.h);
  }
  
  public void computeScroll() {
    if (this.b.computeScrollOffset()) {
      if (this.p == 0) {
        this.e.setVisiableHeight(this.b.getCurrY());
      } else {
        this.l.setBottomMargin(this.b.getCurrY());
      } 
      postInvalidate();
      f();
    } 
    super.computeScroll();
  }
  
  public void d() {
    if (this.n == true) {
      this.n = false;
      this.l.setState(0);
    } 
  }
  
  protected void layoutChildren() {
    try {
      super.layoutChildren();
    } catch (Exception exception) {}
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
    this.o = paramInt3;
    if (this.m && !this.n && this.v && paramInt1 >= 0 && paramInt3 > 0 && paramInt1 + paramInt2 == paramInt3) {
      i();
      h();
    } 
    if (this.c != null)
      this.c.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3); 
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    if (this.c != null)
      this.c.onScrollStateChanged(paramAbsListView, paramInt); 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield a : F
    //   6: ldc -1.0
    //   8: fcmpl
    //   9: ifne -> 20
    //   12: aload_0
    //   13: aload_1
    //   14: invokevirtual getRawY : ()F
    //   17: putfield a : F
    //   20: aload_1
    //   21: invokevirtual getAction : ()I
    //   24: tableswitch default -> 52, 0 -> 171, 1 -> 52, 2 -> 182
    //   52: aload_0
    //   53: ldc -1.0
    //   55: putfield a : F
    //   58: aload_0
    //   59: invokevirtual getFirstVisiblePosition : ()I
    //   62: ifne -> 119
    //   65: aload_0
    //   66: getfield j : Z
    //   69: ifeq -> 115
    //   72: aload_0
    //   73: getfield e : Lcom/zz/sdk/lib/widget/j;
    //   76: invokevirtual getVisiableHeight : ()I
    //   79: aload_0
    //   80: getfield h : I
    //   83: if_icmple -> 115
    //   86: aload_0
    //   87: iconst_1
    //   88: putfield k : Z
    //   91: aload_0
    //   92: getfield e : Lcom/zz/sdk/lib/widget/j;
    //   95: iconst_2
    //   96: invokevirtual setState : (I)V
    //   99: aload_0
    //   100: getfield d : Lcom/zz/sdk/lib/widget/g;
    //   103: ifnull -> 115
    //   106: aload_0
    //   107: getfield d : Lcom/zz/sdk/lib/widget/g;
    //   110: invokeinterface a : ()V
    //   115: aload_0
    //   116: invokespecial g : ()V
    //   119: aload_0
    //   120: invokevirtual getLastVisiblePosition : ()I
    //   123: aload_0
    //   124: getfield o : I
    //   127: iconst_1
    //   128: isub
    //   129: if_icmpne -> 161
    //   132: aload_0
    //   133: getfield m : Z
    //   136: ifeq -> 157
    //   139: aload_0
    //   140: getfield l : Lcom/zz/sdk/lib/widget/i;
    //   143: invokevirtual getBottomMargin : ()I
    //   146: aload_0
    //   147: getfield i : I
    //   150: if_icmple -> 157
    //   153: aload_0
    //   154: invokespecial i : ()V
    //   157: aload_0
    //   158: invokespecial h : ()V
    //   161: aload_0
    //   162: aload_1
    //   163: invokespecial onTouchEvent : (Landroid/view/MotionEvent;)Z
    //   166: istore_3
    //   167: iload_3
    //   168: istore_2
    //   169: iload_2
    //   170: ireturn
    //   171: aload_0
    //   172: aload_1
    //   173: invokevirtual getRawY : ()F
    //   176: putfield a : F
    //   179: goto -> 161
    //   182: aload_1
    //   183: invokevirtual getRawY : ()F
    //   186: aload_0
    //   187: getfield a : F
    //   190: fsub
    //   191: fstore #4
    //   193: aload_0
    //   194: aload_1
    //   195: invokevirtual getRawY : ()F
    //   198: putfield a : F
    //   201: aload_0
    //   202: invokevirtual getFirstVisiblePosition : ()I
    //   205: ifne -> 241
    //   208: aload_0
    //   209: getfield e : Lcom/zz/sdk/lib/widget/j;
    //   212: invokevirtual getVisiableHeight : ()I
    //   215: ifgt -> 225
    //   218: fload #4
    //   220: fconst_0
    //   221: fcmpl
    //   222: ifle -> 241
    //   225: aload_0
    //   226: fload #4
    //   228: ldc 2.2
    //   230: fdiv
    //   231: invokespecial a : (F)V
    //   234: aload_0
    //   235: invokespecial f : ()V
    //   238: goto -> 161
    //   241: aload_0
    //   242: invokevirtual getLastVisiblePosition : ()I
    //   245: aload_0
    //   246: getfield o : I
    //   249: iconst_1
    //   250: isub
    //   251: if_icmpne -> 161
    //   254: aload_0
    //   255: getfield l : Lcom/zz/sdk/lib/widget/i;
    //   258: invokevirtual getBottomMargin : ()I
    //   261: ifgt -> 271
    //   264: fload #4
    //   266: fconst_0
    //   267: fcmpg
    //   268: ifge -> 161
    //   271: aload_0
    //   272: fload #4
    //   274: fneg
    //   275: ldc 2.2
    //   277: fdiv
    //   278: invokespecial b : (F)V
    //   281: goto -> 161
    //   284: astore_1
    //   285: goto -> 169
    // Exception table:
    //   from	to	target	type
    //   161	167	284	java/lang/Exception
  }
  
  public void setAdapter(ListAdapter paramListAdapter) {
    super.setAdapter(paramListAdapter);
  }
  
  public void setAutoLoadOnBottom(boolean paramBoolean) {
    this.v = paramBoolean;
  }
  
  public void setOnRefreshEventListener(g paramg) {
    this.d = paramg;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener) {
    this.c = paramOnScrollListener;
  }
  
  public void setPullLoadEnable(boolean paramBoolean) {
    if (this.m != paramBoolean) {
      this.m = paramBoolean;
      if (!this.m) {
        this.l.a();
        this.l.setOnClickListener(null);
      } else {
        this.n = false;
        this.l.b();
        this.l.setState(0);
        this.l.setOnClickListener(new f(this));
      } 
      setFooterDividersEnabled(this.m);
    } 
  }
  
  public void setPullRefreshEnable(boolean paramBoolean) {
    if (this.j != paramBoolean) {
      this.j = paramBoolean;
      if (!this.j) {
        this.f.setVisibility(4);
      } else {
        this.f.setVisibility(0);
      } 
      setHeaderDividersEnabled(this.j);
    } 
  }
  
  public void setRefreshTime(String paramString) {
    this.g.setText(paramString);
    this.u.setVisibility(0);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\lib\widget\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */