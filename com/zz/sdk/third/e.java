package com.zz.sdk.third;

import android.app.Activity;
import com.zz.sdk.i.bp;
import java.util.Map;

public class e {
  public static b a(Activity paramActivity, c paramc, Map paramMap) {
    try {
      Class<a> clazz = paramc.c();
      if (clazz == null)
        return null; 
      a a = clazz.getConstructor(new Class[] { Activity.class }).newInstance(new Object[] { paramActivity });
      try {
        a.a(paramMap);
      } catch (Exception exception) {}
    } catch (Exception exception) {
      paramActivity = null;
    } 
    return (b)paramActivity;
  }
  
  public static b a(Activity paramActivity, Class<a> paramClass, Map paramMap) {
    try {
      a a = paramClass.getConstructor(new Class[] { Activity.class }).newInstance(new Object[] { paramActivity });
      try {
        a.a(paramMap);
        return a;
      } catch (Exception null) {}
    } catch (Exception exception) {
      paramActivity = null;
    } 
    bp.a("ThirdFactory createThird exception " + exception.toString());
    return (b)paramActivity;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\third\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */