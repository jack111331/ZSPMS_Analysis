package com.herosdk.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.herosdk.error.ErrorUtils;

public class ax {
  private static String a;
  
  public static void a(Context paramContext, String paramString, Object paramObject) {
    ba.a().a(new ay(paramObject, paramContext, paramString));
  }
  
  public static Object b(Context paramContext, String paramString, Object paramObject) {
    Context context1;
    Context context2 = null;
    try {
      a = o.b("GMd7603UXo3NK1vNHEDhyg==", o.b());
      String str = paramObject.getClass().getSimpleName();
      SharedPreferences sharedPreferences = paramContext.getSharedPreferences(a, 0);
      if ("String".equals(str))
        return sharedPreferences.getString(paramString, (String)paramObject); 
      if ("Integer".equals(str))
        return Integer.valueOf(sharedPreferences.getInt(paramString, ((Integer)paramObject).intValue())); 
      if ("Boolean".equals(str))
        return Boolean.valueOf(sharedPreferences.getBoolean(paramString, ((Boolean)paramObject).booleanValue())); 
      if ("Float".equals(str))
        return Float.valueOf(sharedPreferences.getFloat(paramString, ((Float)paramObject).floatValue())); 
      paramContext = context2;
      if ("Long".equals(str)) {
        long l = sharedPreferences.getLong(paramString, ((Long)paramObject).longValue());
        Long long_ = Long.valueOf(l);
      } 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      context1 = context2;
    } 
    return context1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */