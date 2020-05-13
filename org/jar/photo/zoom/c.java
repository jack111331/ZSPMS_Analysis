package org.jar.photo.zoom;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public class c extends Drawable {
  protected Bitmap a;
  
  protected Paint b;
  
  protected int c;
  
  protected int d;
  
  public c(Bitmap paramBitmap) {
    boolean bool;
    this.a = paramBitmap;
    if (this.a != null) {
      this.c = this.a.getWidth();
      bool = this.a.getHeight();
    } else {
      bool = false;
      this.c = 0;
    } 
    this.d = bool;
    this.b = new Paint();
    this.b.setDither(true);
    this.b.setFilterBitmap(true);
  }
  
  public void draw(Canvas paramCanvas) {
    if (this.a != null && !this.a.isRecycled())
      paramCanvas.drawBitmap(this.a, 0.0F, 0.0F, this.b); 
  }
  
  public int getIntrinsicHeight() {
    return this.d;
  }
  
  public int getIntrinsicWidth() {
    return this.c;
  }
  
  public int getMinimumHeight() {
    return this.d;
  }
  
  public int getMinimumWidth() {
    return this.c;
  }
  
  public int getOpacity() {
    return -3;
  }
  
  public void setAlpha(int paramInt) {
    this.b.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.b.setColorFilter(paramColorFilter);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\zoom\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */