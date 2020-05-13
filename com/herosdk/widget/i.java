package com.herosdk.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.herosdk.d.au;
import java.util.Arrays;

public class i {
  private View a;
  
  private Context b;
  
  private GradientDrawable c = new GradientDrawable();
  
  private GradientDrawable d = new GradientDrawable();
  
  private int e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private boolean p;
  
  private boolean q;
  
  private boolean r;
  
  private boolean s;
  
  private ColorStateList t;
  
  private float[] u = new float[8];
  
  public i(View paramView, Context paramContext, AttributeSet paramAttributeSet) {
    this.a = paramView;
    this.b = paramContext;
    if (paramView instanceof android.view.ViewGroup)
      paramView.setWillNotDraw(false); 
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet) {
    int[] arrayOfInt = new int[13];
    arrayOfInt[0] = au.b(paramContext, "hu_rv_backgroundColor");
    arrayOfInt[1] = au.b(paramContext, "hu_rv_backgroundPressColor");
    arrayOfInt[2] = au.b(paramContext, "hu_rv_cornerRadius");
    arrayOfInt[3] = au.b(paramContext, "hu_rv_strokeWidth");
    arrayOfInt[4] = au.b(paramContext, "hu_rv_strokeColor");
    arrayOfInt[5] = au.b(paramContext, "hu_rv_strokePressColor");
    arrayOfInt[6] = au.b(paramContext, "hu_rv_textPressColor");
    arrayOfInt[7] = au.b(paramContext, "hu_rv_isRadiusHalfHeight");
    arrayOfInt[8] = au.b(paramContext, "hu_rv_isWidthHeightEqual");
    arrayOfInt[9] = au.b(paramContext, "hu_rv_cornerRadius_TL");
    arrayOfInt[10] = au.b(paramContext, "hu_rv_cornerRadius_TR");
    arrayOfInt[11] = au.b(paramContext, "hu_rv_cornerRadius_BL");
    arrayOfInt[12] = au.b(paramContext, "hu_rv_cornerRadius_BR");
    Arrays.sort(arrayOfInt);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt, 0, 0);
    this.e = typedArray.getColor(Arrays.binarySearch(arrayOfInt, au.b(paramContext, "hu_rv_backgroundColor")), 0);
    this.f = typedArray.getColor(Arrays.binarySearch(arrayOfInt, au.b(paramContext, "hu_rv_backgroundPressColor")), 2147483647);
    this.g = typedArray.getDimensionPixelSize(Arrays.binarySearch(arrayOfInt, au.b(paramContext, "hu_rv_cornerRadius")), 0);
    this.l = typedArray.getDimensionPixelSize(Arrays.binarySearch(arrayOfInt, au.b(paramContext, "hu_rv_strokeWidth")), 0);
    this.m = typedArray.getColor(Arrays.binarySearch(arrayOfInt, au.b(paramContext, "hu_rv_strokeColor")), 0);
    this.n = typedArray.getColor(Arrays.binarySearch(arrayOfInt, au.b(paramContext, "hu_rv_strokePressColor")), 2147483647);
    this.o = typedArray.getColor(Arrays.binarySearch(arrayOfInt, au.b(paramContext, "hu_rv_textPressColor")), 2147483647);
    this.p = typedArray.getBoolean(Arrays.binarySearch(arrayOfInt, au.b(paramContext, "hu_rv_isRadiusHalfHeight")), false);
    this.q = typedArray.getBoolean(Arrays.binarySearch(arrayOfInt, au.b(paramContext, "hu_rv_isWidthHeightEqual")), false);
    this.h = typedArray.getDimensionPixelSize(Arrays.binarySearch(arrayOfInt, au.b(paramContext, "hu_rv_cornerRadius_TL")), 0);
    this.i = typedArray.getDimensionPixelSize(Arrays.binarySearch(arrayOfInt, au.b(paramContext, "hu_rv_cornerRadius_TR")), 0);
    this.j = typedArray.getDimensionPixelSize(Arrays.binarySearch(arrayOfInt, au.b(paramContext, "hu_rv_cornerRadius_BL")), 0);
    this.k = typedArray.getDimensionPixelSize(Arrays.binarySearch(arrayOfInt, au.b(paramContext, "hu_rv_cornerRadius_BR")), 0);
    typedArray.recycle();
  }
  
  public int a() {
    return this.e;
  }
  
  protected int a(float paramFloat) {
    return (int)((this.b.getResources().getDisplayMetrics()).density * paramFloat + 0.5F);
  }
  
  public void a(int paramInt) {
    this.e = paramInt;
    this.a.invalidate();
  }
  
  protected void a(Canvas paramCanvas) {
    int j = this.a.getWidth();
    int k = this.a.getHeight();
    if (this.p)
      this.g = k / 2; 
    if (!this.r) {
      this.c.setColor(this.e);
      if (this.h > 0 || this.i > 0 || this.k > 0 || this.j > 0) {
        this.u[0] = this.h;
        this.u[1] = this.h;
        this.u[2] = this.i;
        this.u[3] = this.i;
        this.u[4] = this.k;
        this.u[5] = this.k;
        this.u[6] = this.j;
        this.u[7] = this.j;
        this.c.setCornerRadii(this.u);
      } else {
        this.c.setCornerRadius(this.g);
      } 
      this.c.setStroke(this.l, this.m);
      this.c.setBounds(0, 0, j, k);
      this.c.draw(paramCanvas);
      return;
    } 
    if (this.f == Integer.MAX_VALUE)
      this.f = this.e; 
    this.d.setColor(this.f);
    if (this.h > 0 || this.i > 0 || this.k > 0 || this.j > 0) {
      this.u[0] = this.h;
      this.u[1] = this.h;
      this.u[2] = this.i;
      this.u[3] = this.i;
      this.u[4] = this.k;
      this.u[5] = this.k;
      this.u[6] = this.j;
      this.u[7] = this.j;
      this.d.setCornerRadii(this.u);
    } else {
      this.d.setCornerRadius(this.g);
    } 
    if (this.n == Integer.MAX_VALUE)
      this.n = this.m; 
    this.d.setStroke(this.l, this.n);
    this.d.setBounds(0, 0, j, k);
    this.d.draw(paramCanvas);
  }
  
  protected void a(MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getAction() == 0) {
      if (this.s) {
        this.r = true;
        if (this.a instanceof TextView && this.o != Integer.MAX_VALUE) {
          this.t = ((TextView)this.a).getTextColors();
          ((TextView)this.a).setTextColor(this.o);
        } 
        this.a.invalidate();
      } 
      return;
    } 
    if ((paramMotionEvent.getAction() == 3 || paramMotionEvent.getAction() == 1 || !this.a.isPressed()) && this.s) {
      this.r = false;
      if (this.a instanceof TextView && this.o != Integer.MAX_VALUE)
        ((TextView)this.a).setTextColor(this.t); 
      this.a.invalidate();
    } 
  }
  
  protected void a(View.OnClickListener paramOnClickListener) {
    boolean bool;
    if (this.a.isEnabled() && paramOnClickListener != null) {
      bool = true;
    } else {
      bool = false;
    } 
    this.s = bool;
  }
  
  protected void a(View.OnLongClickListener paramOnLongClickListener) {
    boolean bool;
    if (this.a.isEnabled() && paramOnLongClickListener != null) {
      bool = true;
    } else {
      bool = false;
    } 
    this.s = bool;
  }
  
  public void a(boolean paramBoolean) {
    this.p = paramBoolean;
    this.a.invalidate();
  }
  
  public int b() {
    return this.f;
  }
  
  protected int b(float paramFloat) {
    return (int)((this.b.getResources().getDisplayMetrics()).scaledDensity * paramFloat + 0.5F);
  }
  
  public void b(int paramInt) {
    this.f = paramInt;
    this.a.invalidate();
  }
  
  public void b(boolean paramBoolean) {
    this.q = paramBoolean;
    this.a.requestLayout();
  }
  
  public int c() {
    return this.g;
  }
  
  public void c(int paramInt) {
    this.g = a(paramInt);
    this.a.invalidate();
  }
  
  public int d() {
    return this.l;
  }
  
  public void d(int paramInt) {
    this.l = a(paramInt);
    this.a.invalidate();
  }
  
  public int e() {
    return this.m;
  }
  
  public void e(int paramInt) {
    this.m = paramInt;
    this.a.invalidate();
  }
  
  public int f() {
    return this.n;
  }
  
  public void f(int paramInt) {
    this.n = paramInt;
    this.a.invalidate();
  }
  
  public int g() {
    return this.o;
  }
  
  public void g(int paramInt) {
    this.o = paramInt;
    this.a.invalidate();
  }
  
  public void h(int paramInt) {
    this.h = paramInt;
    this.a.invalidate();
  }
  
  public boolean h() {
    return this.p;
  }
  
  public void i(int paramInt) {
    this.i = paramInt;
    this.a.invalidate();
  }
  
  public boolean i() {
    return this.q;
  }
  
  public int j() {
    return this.h;
  }
  
  public void j(int paramInt) {
    this.j = paramInt;
    this.a.invalidate();
  }
  
  public int k() {
    return this.i;
  }
  
  public void k(int paramInt) {
    this.k = paramInt;
    this.a.invalidate();
  }
  
  public int l() {
    return this.j;
  }
  
  public int m() {
    return this.k;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\widget\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */