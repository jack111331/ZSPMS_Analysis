package com.unity3d.player;

import android.os.Build;

public final class j {
  static final boolean a;
  
  static final boolean b;
  
  static final boolean c;
  
  static final e d;
  
  static {
    e e1;
    int i = Build.VERSION.SDK_INT;
    boolean bool1 = false;
    if (i >= 19) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    a = bool2;
    if (Build.VERSION.SDK_INT >= 21) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    b = bool2;
    boolean bool2 = bool1;
    if (Build.VERSION.SDK_INT >= 23)
      bool2 = true; 
    c = bool2;
    if (bool2) {
      e1 = new h();
    } else {
      e1 = null;
    } 
    d = e1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */