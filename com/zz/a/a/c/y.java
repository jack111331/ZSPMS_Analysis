package com.zz.a.a.c;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

class y extends BitmapDrawable {
  private final WeakReference a;
  
  public y(Resources paramResources, Bitmap paramBitmap, z paramz) {
    super(paramResources, paramBitmap);
    this.a = new WeakReference<z>(paramz);
  }
  
  public z a() {
    return this.a.get();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */