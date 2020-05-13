package cn.com.chinatelecom.account.api.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public final class c {
  private static SharedPreferences a(Context paramContext) {
    return paramContext.getSharedPreferences(b(paramContext), 0);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt) {
    if (paramContext != null && !TextUtils.isEmpty(paramString))
      try {
        a(paramContext).edit().putInt(paramString, paramInt).commit();
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong) {
    if (paramContext != null && !TextUtils.isEmpty(paramString))
      try {
        return a(paramContext).edit().putLong(paramString, paramLong).commit();
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return false;
  }
  
  public static int b(Context paramContext, String paramString, int paramInt) {
    int i = paramInt;
    if (paramContext != null) {
      i = paramInt;
      if (!TextUtils.isEmpty(paramString))
        try {
          i = a(paramContext).getInt(paramString, paramInt);
        } catch (Exception exception) {
          exception.printStackTrace();
          i = paramInt;
        }  
    } 
    return i;
  }
  
  public static long b(Context paramContext, String paramString, long paramLong) {
    long l = paramLong;
    if (paramContext != null) {
      l = paramLong;
      if (!TextUtils.isEmpty(paramString))
        try {
          l = a(paramContext).getLong(paramString, paramLong);
        } catch (Exception exception) {
          exception.printStackTrace();
          l = paramLong;
        }  
    } 
    return l;
  }
  
  private static String b(Context paramContext) {
    return "ct_account_api_sdk";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */