package com.zz.a.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;

public class t {
  public int a = 5120;
  
  public int b = 10485760;
  
  public File c;
  
  public Bitmap.CompressFormat d = r.f();
  
  public int e = 70;
  
  public boolean f = true;
  
  public boolean g = true;
  
  public boolean h = false;
  
  public t(Context paramContext, String paramString) {
    this.c = r.a(paramContext, paramString);
  }
  
  public void a(float paramFloat) {
    if (paramFloat < 0.05F || paramFloat > 0.8F)
      throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.05 and 0.8 (inclusive)"); 
    this.a = Math.round((float)Runtime.getRuntime().maxMemory() * paramFloat / 1024.0F);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */