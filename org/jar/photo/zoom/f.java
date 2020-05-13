package org.jar.photo.zoom;

class f implements Runnable {
  f(ImageViewTouchBase paramImageViewTouchBase, float paramFloat1, long paramLong, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {}
  
  public void run() {
    long l = System.currentTimeMillis();
    float f1 = Math.min(this.a, (float)(l - this.b));
    float f2 = (float)this.g.k.b(f1, 0.0D, this.c, this.a);
    this.g.b(this.d + f2, this.e, this.f);
    if (f1 < this.a) {
      this.g.o.post(this);
    } else {
      this.g.a(this.g.getScale());
      this.g.a(true, true);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\zoom\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */