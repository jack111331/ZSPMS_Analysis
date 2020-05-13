package com.unity3d.player;

import android.util.Log;

final class g {
  protected static boolean a;
  
  protected static void Log(int paramInt, String paramString) {
    if (a)
      return; 
    if (paramInt == 6)
      Log.e("Unity", paramString); 
    if (paramInt == 5)
      Log.w("Unity", paramString); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */