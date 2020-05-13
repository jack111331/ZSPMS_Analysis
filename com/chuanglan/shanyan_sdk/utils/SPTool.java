package com.chuanglan.shanyan_sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SPTool {
  public static final String AUTHPAGE_FLAG = "authPageFlag";
  
  public static final String CLIENT_APPID = "clientAppId";
  
  public static final String CLIENT_APPKEY = "clientAppkey";
  
  public static final String CMCC_APPID = "cmccAppid";
  
  public static final String CMCC_APPKEY = "cmccAppkey";
  
  public static final String CMCC_FN = "cmccfn";
  
  public static final String CMCC_PREFLAG = "cmccPreFlag";
  
  public static final String CMCC_SWITCH = "cmccSwitch";
  
  public static final String CTCC_ACCESSCODE = "ctcc_accessCode";
  
  public static final String CTCC_APPID = "ctccAppid";
  
  public static final String CTCC_APPKEY = "ctccAppkey";
  
  public static final String CTCC_NUMBER = "ctcc_number";
  
  public static final String CTCC_PREFLAG = "ctccPreFlag";
  
  public static final String CTCC_SWITCH = "ctccSwitch";
  
  public static final String CUCC_APPID = "cuccAppid";
  
  public static final String CUCC_APPKEY = "cuccAppkey";
  
  public static final String CUCC_PREFLAG = "cuccPreFlag";
  
  public static final String CUCC_SWITCH = "cuccSwitch";
  
  public static final String DID = "DID";
  
  public static final String GETPHONEINFOTIMEOUT = "getPhoneInfoTimeOut";
  
  public static final String INITTIME_START = "initTimestart";
  
  public static final String INIT_TIMEOUT = "initTimeOut";
  
  public static final String INT_FLAG = "initFlag";
  
  public static final String METHOD_TIMEOUT = "sto";
  
  public static final String OPENLOGINAUTHTIMEOUT = "openLoginAuthTimeOut";
  
  public static final String OPERATOR_SWITCH = "ispStatus";
  
  public static final String PKS = "pks";
  
  public static final String PREFAIL_FLAG = "preFailFlag";
  
  public static final String REPORT_COUNT = "reportCount";
  
  public static final String REPORT_FAIL_COUNT = "report_fail_count";
  
  public static final String REPORT_FLAG = "reportFlag";
  
  public static final String REPORT_MAX = "reportMax";
  
  public static final String REPORT_TIMESTART = "reportTimestart";
  
  public static final String SIM_OPERATOR = "SIMOperator";
  
  public static final String SIM_SERIAL = "SIMSerial";
  
  public static final String SINGLE_APPID = "appId";
  
  public static final String SINGLE_APPKEY = "appKey";
  
  public static final String SSL_SWITCH = "ssl";
  
  public static final String TIME_END = "timeend";
  
  public static final String USER_DISABLED_SWITCH = "accOff";
  
  public static final String UUID = "uuid";
  
  private static final String a = "share_data";
  
  public static final String authorizationStartTime = "authorizationStartTime";
  
  public static Object get(Context paramContext, String paramString, Object paramObject) {
    Context context1;
    Context context2 = null;
    try {
      SharedPreferences sharedPreferences = paramContext.getSharedPreferences("share_data", 0);
      if (paramObject instanceof String)
        return sharedPreferences.getString(paramString, (String)paramObject); 
      if (paramObject instanceof Integer)
        return Integer.valueOf(sharedPreferences.getInt(paramString, ((Integer)paramObject).intValue())); 
      if (paramObject instanceof Boolean)
        return Boolean.valueOf(sharedPreferences.getBoolean(paramString, ((Boolean)paramObject).booleanValue())); 
      if (paramObject instanceof Float)
        return Float.valueOf(sharedPreferences.getFloat(paramString, ((Float)paramObject).floatValue())); 
      paramContext = context2;
      if (paramObject instanceof Long) {
        long l = sharedPreferences.getLong(paramString, ((Long)paramObject).longValue());
        Long long_ = Long.valueOf(l);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      context1 = context2;
    } 
    return context1;
  }
  
  public static void put(Context paramContext, String paramString, Object paramObject) {
    try {
      SharedPreferences.Editor editor = paramContext.getSharedPreferences("share_data", 0).edit();
      if (paramObject instanceof String) {
        editor.putString(paramString, (String)paramObject);
      } else if (paramObject instanceof Integer) {
        editor.putInt(paramString, ((Integer)paramObject).intValue());
      } else if (paramObject instanceof Boolean) {
        editor.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
      } else if (paramObject instanceof Float) {
        editor.putFloat(paramString, ((Float)paramObject).floatValue());
      } else if (paramObject instanceof Long) {
        editor.putLong(paramString, ((Long)paramObject).longValue());
      } else {
        editor.putString(paramString, paramObject.toString());
      } 
      SharedPreferencesCompat.a(editor);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private static class SharedPreferencesCompat {
    private static final Method a = a();
    
    private static Method a() {
      try {
        Method method = SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
      } catch (NoSuchMethodException noSuchMethodException) {
        noSuchMethodException.printStackTrace();
        noSuchMethodException = null;
      } 
      return (Method)noSuchMethodException;
    }
    
    static void a(SharedPreferences.Editor param1Editor) {
      try {
        if (a != null) {
          a.invoke(param1Editor, new Object[0]);
          return;
        } 
      } catch (IllegalArgumentException illegalArgumentException) {
        illegalArgumentException.printStackTrace();
      } catch (IllegalAccessException illegalAccessException) {
        illegalAccessException.printStackTrace();
      } catch (InvocationTargetException invocationTargetException) {
        invocationTargetException.printStackTrace();
      } 
      param1Editor.commit();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sd\\utils\SPTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */