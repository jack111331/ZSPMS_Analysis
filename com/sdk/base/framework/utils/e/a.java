package com.sdk.base.framework.utils.e;

import android.content.Context;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.f.b;

public class a {
  private static final String a = a.class.getSimpleName();
  
  private static Boolean b = Boolean.valueOf(c.h);
  
  public static int a(Context paramContext, String paramString1, String paramString2) {
    boolean bool;
    try {
      bool = paramContext.getResources().getIdentifier(paramString2, paramString1, paramContext.getPackageName());
    } catch (Exception exception) {
      b.d(a, "获取" + paramString1 + "《" + paramString2 + "》失败！\n" + exception.toString(), b);
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */