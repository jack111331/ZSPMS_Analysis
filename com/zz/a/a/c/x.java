package com.zz.a.a.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.ImageView;
import com.zz.sdk.ParamChain;

public abstract class x {
  private static final String a = "ImageWorker";
  
  private static final int b = 200;
  
  private static final int k = 0;
  
  private static final int l = 1;
  
  private static final int m = 2;
  
  private static final int n = 3;
  
  protected boolean c = false;
  
  protected Resources d;
  
  private r e;
  
  private t f;
  
  private Bitmap g;
  
  private boolean h = true;
  
  private boolean i = false;
  
  private final Object j = new Object();
  
  protected x(Context paramContext) {
    this.d = paramContext.getResources();
  }
  
  public static void a(ImageView paramImageView) {
    z z = c(paramImageView);
    if (z != null)
      z.a(true); 
  }
  
  private void a(ImageView paramImageView, Drawable paramDrawable) {
    TransitionDrawable transitionDrawable;
    if (this.h) {
      transitionDrawable = new TransitionDrawable(new Drawable[] { (Drawable)new ColorDrawable(17170445), paramDrawable });
      paramImageView.setBackgroundDrawable((Drawable)new BitmapDrawable(this.d, this.g));
      paramImageView.setImageDrawable((Drawable)transitionDrawable);
      transitionDrawable.startTransition(200);
      return;
    } 
    paramImageView.setImageDrawable((Drawable)transitionDrawable);
  }
  
  public static boolean b(Object paramObject, ImageView paramImageView) {
    boolean bool = true;
    z z = c(paramImageView);
    null = bool;
    if (z != null) {
      Object object = z.a(z);
      if (object == null || !object.equals(paramObject)) {
        z.a(true);
        return bool;
      } 
    } else {
      return null;
    } 
    return false;
  }
  
  private static z c(ImageView paramImageView) {
    if (paramImageView != null) {
      Drawable drawable = paramImageView.getDrawable();
      if (drawable instanceof y)
        return ((y)drawable).a(); 
    } 
    return null;
  }
  
  protected abstract Bitmap a(Object paramObject);
  
  protected void a() {
    if (this.e != null)
      this.e.a(); 
  }
  
  public void a(Bitmap paramBitmap) {
    this.g = paramBitmap;
  }
  
  public void a(FragmentActivity paramFragmentActivity, String paramString) {
    this.f = new t((Context)paramFragmentActivity, paramString);
    this.e = r.a(paramFragmentActivity.getSupportFragmentManager(), this.f);
    (new aa(this)).c(new Object[] { Integer.valueOf(1) });
  }
  
  public void a(FragmentManager paramFragmentManager, t paramt) {
    this.f = paramt;
    this.e = r.a(paramFragmentManager, this.f);
    (new aa(this)).c(new Object[] { Integer.valueOf(1) });
  }
  
  public void a(ParamChain paramParamChain, t paramt) {
    this.f = paramt;
    this.e = r.a(paramParamChain, this.f);
    (new aa(this)).c(new Object[] { Integer.valueOf(1) });
  }
  
  public void a(Object paramObject, ImageView paramImageView) {
    if (paramObject != null) {
      BitmapDrawable bitmapDrawable = null;
      if (this.e != null)
        bitmapDrawable = this.e.a(String.valueOf(paramObject)); 
      if (bitmapDrawable != null) {
        paramImageView.setImageDrawable((Drawable)bitmapDrawable);
        return;
      } 
      if (b(paramObject, paramImageView)) {
        z z = new z(this, paramImageView);
        paramImageView.setImageDrawable((Drawable)new y(this.d, this.g, z));
        z.a(a.c, new Object[] { paramObject });
      } 
    } 
  }
  
  public void a(boolean paramBoolean) {
    this.h = paramBoolean;
  }
  
  protected void b() {
    if (this.e != null)
      this.e.b(); 
  }
  
  public void b(int paramInt) {
    this.g = BitmapFactory.decodeResource(this.d, paramInt);
  }
  
  public void b(boolean paramBoolean) {
    this.i = paramBoolean;
    c(false);
  }
  
  protected void c() {
    if (this.e != null)
      this.e.c(); 
  }
  
  public void c(boolean paramBoolean) {
    synchronized (this.j) {
      this.c = paramBoolean;
      if (!this.c)
        this.j.notifyAll(); 
      return;
    } 
  }
  
  protected void d() {
    if (this.e != null) {
      this.e.d();
      this.e = null;
    } 
  }
  
  protected r f() {
    return this.e;
  }
  
  public void g() {
    (new aa(this)).c(new Object[] { Integer.valueOf(0) });
  }
  
  public void h() {
    (new aa(this)).c(new Object[] { Integer.valueOf(2) });
  }
  
  public void i() {
    (new aa(this)).c(new Object[] { Integer.valueOf(3) });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */