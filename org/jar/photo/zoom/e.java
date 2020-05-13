package org.jar.photo.zoom;

import android.graphics.RectF;

class e implements Runnable {
  double a = 0.0D;
  
  double b = 0.0D;
  
  e(ImageViewTouchBase paramImageViewTouchBase, double paramDouble1, long paramLong, double paramDouble2, double paramDouble3) {}
  
  public void run() {
    long l = System.currentTimeMillis();
    double d1 = Math.min(this.c, (l - this.d));
    double d2 = this.g.k.a(d1, 0.0D, this.e, this.c);
    double d3 = this.g.k.a(d1, 0.0D, this.f, this.c);
    this.g.a(d2 - this.a, d3 - this.b);
    this.a = d2;
    this.b = d3;
    if (d1 < this.c) {
      this.g.o.post(this);
    } else {
      RectF rectF = this.g.a(this.g.m, true, true);
      if (rectF.left != 0.0F || rectF.top != 0.0F)
        this.g.d(rectF.left, rectF.top); 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\zoom\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */