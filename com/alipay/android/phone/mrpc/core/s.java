package com.alipay.android.phone.mrpc.core;

import android.content.Context;

public final class s {
  private static Boolean a = null;
  
  public static final boolean a(Context paramContext) {
    boolean bool2;
    boolean bool1 = false;
    if (a != null)
      return a.booleanValue(); 
    try {
      if (((paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 0)).flags & 0x2) != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Boolean bool = Boolean.valueOf(bool2);
      a = bool;
      bool2 = bool.booleanValue();
    } catch (Exception exception) {
      bool2 = bool1;
    } 
    return bool2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\android\phone\mrpc\core\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */