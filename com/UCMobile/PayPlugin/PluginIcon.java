package com.UCMobile.PayPlugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.unionpay.mobile.android.resource.a;
import java.io.InputStream;

public class PluginIcon {
  Bitmap a = null;
  
  int[] b = null;
  
  Context c = null;
  
  private int d;
  
  static {
    System.loadLibrary("ucpayplugin");
  }
  
  public PluginIcon(Context paramContext, int paramInt) {
    this.c = paramContext;
    this.d = paramInt;
    try {
      InputStream inputStream = a.class.getClassLoader().getResourceAsStream("res/drawable/mobilepayplugin.bin");
      BitmapDrawable bitmapDrawable = new BitmapDrawable();
      this(inputStream);
      this.a = bitmapDrawable.getBitmap().copy(Bitmap.Config.ARGB_8888, false);
    } catch (Exception exception) {}
  }
  
  public int getIconHeight() {
    return (this.a != null) ? this.a.getHeight() : 0;
  }
  
  public int[] getIconPixels() {
    int i = 0;
    if (this.b != null)
      return this.b; 
    int j = this.a.getWidth();
    int k = this.a.getHeight();
    int m = this.a.getRowBytes() * k;
    int n = i;
    if (this.a != null) {
      this.b = new int[m];
      this.a.getPixels(this.b, 0, j, 0, 0, j, k);
      n = i;
    } 
    while (n < m) {
      j = this.b[n];
      i = this.b[n];
      this.b[n] = j >> 16 & 0xFF | i << 16 & 0xFF0000 | this.b[n] & 0xFF00FF00;
      n++;
    } 
    return this.b;
  }
  
  public int getIconRowBytes() {
    return (this.a != null) ? this.a.getRowBytes() : 0;
  }
  
  public int getIconWidth() {
    return (this.a != null) ? this.a.getWidth() : 0;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\UCMobile\PayPlugin\PluginIcon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */