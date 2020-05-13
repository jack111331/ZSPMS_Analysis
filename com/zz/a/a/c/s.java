package com.zz.a.a.c;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.LruCache;
import java.lang.ref.SoftReference;

class s extends LruCache {
  s(r paramr, int paramInt) {
    super(paramInt);
  }
  
  protected int a(String paramString, BitmapDrawable paramBitmapDrawable) {
    int i = r.a(paramBitmapDrawable) / 1024;
    int j = i;
    if (i == 0)
      j = 1; 
    return j;
  }
  
  protected void a(boolean paramBoolean, String paramString, BitmapDrawable paramBitmapDrawable1, BitmapDrawable paramBitmapDrawable2) {
    if (ab.class.isInstance(paramBitmapDrawable1)) {
      ((ab)paramBitmapDrawable1).b(false);
      return;
    } 
    if (ac.c())
      r.a(this.a).add(new SoftReference<Bitmap>(paramBitmapDrawable1.getBitmap())); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */