package com.herosdk.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;

public class i extends Dialog {
  private static final float a = 480.0F;
  
  private static final float b = 330.0F;
  
  private static final float c = 330.0F;
  
  private static int d;
  
  private static int e;
  
  protected final DisplayMetrics l;
  
  protected Context m;
  
  public i(Context paramContext) {
    super(paramContext);
    this.m = paramContext;
    this.l = this.m.getResources().getDisplayMetrics();
    b();
  }
  
  public i(Context paramContext, int paramInt) {
    super(paramContext, paramInt);
    this.m = paramContext;
    this.l = this.m.getResources().getDisplayMetrics();
    b();
  }
  
  public i(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener) {
    super(paramContext, paramBoolean, paramOnCancelListener);
    this.m = paramContext;
    this.l = this.m.getResources().getDisplayMetrics();
    b();
  }
  
  private void b() {
    getWindow().setSoftInputMode(2);
    getWindow().setFlags(1024, 1024);
  }
  
  public int A() {
    float f1 = 1.0F;
    if (d > 0)
      return d; 
    float f2 = 480.0F / this.l.densityDpi;
    if (f2 <= 1.0F)
      f1 = f2; 
    null = Math.min(this.l.widthPixels, this.l.heightPixels);
    d = Math.min((int)((f1 * null) * 0.9D), a(330.0F));
    if (d < 860)
      d = (int)('͜' * 1.1F); 
    if (d > null)
      d = null; 
    return d;
  }
  
  public int a() {
    float f1 = 1.0F;
    if (e > 0)
      return e; 
    float f2 = 480.0F / this.l.densityDpi;
    if (f2 <= 1.0F)
      f1 = f2; 
    null = Math.min(this.l.widthPixels, this.l.heightPixels);
    e = Math.min((int)((f1 * null) * 0.8D), a(330.0F));
    if (e < 860)
      e = 860; 
    if (e > null)
      e = null; 
    return e;
  }
  
  protected int a(float paramFloat) {
    return (int)(this.l.density * paramFloat);
  }
  
  public void show() {
    super.show();
    getWindow().setLayout(A(), a());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */