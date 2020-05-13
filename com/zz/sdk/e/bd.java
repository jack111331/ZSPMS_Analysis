package com.zz.sdk.e;

import android.content.Context;
import com.zz.sdk.ParamChain;
import com.zz.sdk.activity.f;
import com.zz.sdk.i.bp;

public class bd {
  public static bg a(Context paramContext, f paramf, ParamChain paramParamChain) {
    switch (be.a[paramf.ordinal()]) {
      default:
        return null;
      case 1:
        return new bi(paramContext, paramParamChain);
      case 2:
        return new cr(paramContext, paramParamChain);
      case 3:
        return new x(paramContext, paramParamChain);
      case 4:
        break;
    } 
    return new hg(paramContext, paramParamChain);
  }
  
  public static bg a(Context paramContext, String paramString, ClassLoader paramClassLoader, ParamChain paramParamChain) {
    try {
      Class<?> clazz = Class.forName(paramString, true, paramClassLoader);
      if (bg.class.isAssignableFrom(clazz))
        return clazz.getConstructor(new Class[] { Context.class, ParamChain.class }).newInstance(new Object[] { paramContext, paramParamChain }); 
    } catch (Exception exception) {
      bp.a("Cannot instanciate layout [" + paramString + "]");
      exception.printStackTrace();
    } 
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */