package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.content.res.Resources;

public class p {
  public static int a(Context paramContext, String paramString) {
    int i = a(paramContext, paramString, "drawable");
    if (i == 0)
      throw new Resources.NotFoundException(paramString); 
    return i;
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2) {
    return paramContext.getResources().getIdentifier(paramString1, paramString2, paramContext.getPackageName());
  }
  
  public static int b(Context paramContext, String paramString) {
    int i = a(paramContext, paramString, "anim");
    if (i == 0)
      throw new Resources.NotFoundException(paramString); 
    return i;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */