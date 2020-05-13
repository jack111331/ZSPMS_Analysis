package com.zz.sdk.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.View;
import com.zz.sdk.i.ci;

public class lj extends Dialog {
  private static final float a = 480.0F;
  
  private static final float b = 350.0F;
  
  private static final float c = 350.0F;
  
  private static int d;
  
  private static int e;
  
  private static int f;
  
  protected final DisplayMetrics v;
  
  protected Context w;
  
  public lj(Context paramContext) {
    super(paramContext);
    this.w = paramContext;
    this.v = this.w.getResources().getDisplayMetrics();
    a();
  }
  
  public lj(Context paramContext, int paramInt) {
    super(paramContext, paramInt);
    this.w = paramContext;
    this.v = this.w.getResources().getDisplayMetrics();
    a();
  }
  
  public lj(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener) {
    super(paramContext, paramBoolean, paramOnCancelListener);
    this.w = paramContext;
    this.v = this.w.getResources().getDisplayMetrics();
    a();
  }
  
  private void a() {
    getWindow().setSoftInputMode(2);
    getWindow().setFlags(1024, 1024);
  }
  
  private int b() {
    if (f <= 0) {
      View view = View.inflate(this.w, ci.a(this.w, 2130903095), null);
      view.measure(0, 0);
      f = view.getMeasuredHeight() + a(60.0F);
    } 
    return f;
  }
  
  public int D() {
    float f1 = 1.0F;
    if (d > 0)
      return d; 
    float f2 = 480.0F / this.v.densityDpi;
    if (f2 <= 1.0F)
      f1 = f2; 
    int i = Math.min(this.v.widthPixels, this.v.heightPixels);
    d = Math.min((int)((f1 * i) * 0.9D), a(350.0F));
    null = b();
    if (d < null)
      d = (int)(null * 1.1F); 
    if (d > i)
      d = i; 
    return d;
  }
  
  public int E() {
    float f1 = 1.0F;
    if (e > 0)
      return e; 
    float f2 = 480.0F / this.v.densityDpi;
    if (f2 <= 1.0F)
      f1 = f2; 
    null = Math.min(this.v.widthPixels, this.v.heightPixels);
    e = Math.min((int)((f1 * null) * 0.8D), a(350.0F));
    int i = b();
    if (e < i)
      e = i; 
    if (e > null)
      e = null; 
    return e;
  }
  
  protected int a(float paramFloat) {
    return (int)(this.v.density * paramFloat);
  }
  
  public void show() {
    super.show();
    getWindow().setLayout(D(), E());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\lj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */