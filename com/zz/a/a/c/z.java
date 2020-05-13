package com.zz.a.a.c;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

class z extends a {
  private Object e;
  
  private final WeakReference f;
  
  public z(x paramx, ImageView paramImageView) {
    this.f = new WeakReference<ImageView>(paramImageView);
  }
  
  private ImageView g() {
    ImageView imageView = this.f.get();
    if (this != x.b(imageView))
      imageView = null; 
    return imageView;
  }
  
  protected void a(BitmapDrawable paramBitmapDrawable) {
    if (e() || x.c(this.d))
      paramBitmapDrawable = null; 
    ImageView imageView = g();
    if (paramBitmapDrawable != null && imageView != null)
      x.a(this.d, imageView, (Drawable)paramBitmapDrawable); 
  }
  
  protected void b(BitmapDrawable paramBitmapDrawable) {
    super.b(paramBitmapDrawable);
    synchronized (x.a(this.d)) {
      x.a(this.d).notifyAll();
      return;
    } 
  }
  
  protected BitmapDrawable e(Object... paramVarArgs) {
    Object object = null;
    this.e = paramVarArgs[0];
    String str = String.valueOf(this.e);
    synchronized (x.a(this.d)) {
      while (this.d.c) {
        boolean bool = e();
        if (!bool)
          try {
            x.a(this.d).wait();
          } catch (InterruptedException interruptedException) {} 
      } 
      if (x.b(this.d) != null && !e() && g() != null && !x.c(this.d)) {
        null = x.b(this.d).b(str);
      } else {
        null = null;
      } 
      Object object1 = null;
      if (null == null) {
        object1 = null;
        if (!e()) {
          object1 = null;
          if (g() != null) {
            object1 = null;
            if (!x.c(this.d))
              object1 = this.d.a(paramVarArgs[0]); 
          } 
        } 
      } 
      null = object;
      if (object1 != null) {
        BitmapDrawable bitmapDrawable;
        if (ac.c()) {
          bitmapDrawable = new BitmapDrawable(this.d.d, (Bitmap)object1);
        } else {
          bitmapDrawable = new ab(this.d.d, (Bitmap)object1);
        } 
        null = bitmapDrawable;
        if (x.b(this.d) != null) {
          x.b(this.d).a(str, bitmapDrawable);
          null = bitmapDrawable;
        } 
      } 
      return (BitmapDrawable)null;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */