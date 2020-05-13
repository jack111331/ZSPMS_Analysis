package com.yingxiong.until;

import android.util.Log;
import com.yingxiong.common.ConfigSDK;
import org.json.JSONArray;
import org.json.JSONException;

public class MLog {
  private static String endLog = "\n\n\n--     温馨提示：业务事件传值必须按照规范传不能遗漏      --\n-                    RecordSDK V1.0 LOG End               -\n-----------------------------------------------------------";
  
  private static LogMode logMode;
  
  private static String startLog = "    \n-----------------------------------------------------------\n-                    RecordSDK V1.0 LOG Begin             -\n--          温馨提示：所有传参的值必须是字符串类型       --\n\n\n";
  
  static {
    try {
      LogMode logMode;
      if (ConfigSDK.instance().getDebugMode()) {
        logMode = LogMode.NORMAL;
      } else {
        logMode = LogMode.NONE;
      } 
      logMode = logMode;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void e(String paramString1, String paramString2) {
    if (interceptLog(paramString1, paramString2))
      return; 
    printLog(6, paramString1, paramString2);
  }
  
  private static boolean interceptLog(String paramString1, String paramString2) {
    switch (logMode) {
      case ALL:
        printLog(5, paramString1, paramString2);
      case NONE:
        return true;
    } 
    return false;
  }
  
  private static boolean isJSONValid(String paramString) {
    try {
    
    } catch (JSONException jSONException) {
      try {
        new JSONArray(paramString);
        return true;
      } catch (JSONException jSONException1) {
        return false;
      } 
    } 
    return true;
  }
  
  private static void printLog(int paramInt, String paramString1, String paramString2) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append(startLog);
      stringBuilder.append(paramString2);
      stringBuilder.append(endLog);
      paramString2 = stringBuilder.toString();
      switch (paramInt) {
        default:
          Log.d(paramString1, paramString2);
          return;
        case 6:
          Log.e(paramString1, paramString2);
          return;
        case 5:
          Log.w(paramString1, paramString2);
          return;
        case 4:
          Log.i(paramString1, paramString2);
          return;
        case 3:
          if (isJSONValid(paramString2)) {
            Log.i(paramString1, paramString2);
          } else {
            Log.d(paramString1, paramString2);
          } 
          return;
        case 2:
          break;
      } 
      Log.v(paramString1, paramString2);
    } catch (Exception exception) {
      exception.printStackTrace();
      Log.w(paramString1, exception.toString());
    } 
  }
  
  enum LogMode {
    ALL, NONE, NORMAL;
    
    static {
      ALL = new LogMode("ALL", 2);
      $VALUES = new LogMode[] { NORMAL, NONE, ALL };
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\yingxion\\until\MLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */