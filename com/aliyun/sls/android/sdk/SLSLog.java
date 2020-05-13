package com.aliyun.sls.android.sdk;

import android.util.Log;

public class SLSLog {
  private static final String TAG = "OSS-Android-SDK";
  
  private static boolean enableLog;
  
  public static void disableLog() {
    enableLog = false;
  }
  
  public static void enableLog() {
    enableLog = true;
  }
  
  public static boolean isEnableLog() {
    return enableLog;
  }
  
  private static void log2Local(String paramString, boolean paramBoolean) {}
  
  public static void logDebug(String paramString) {
    logDebug("OSS-Android-SDK", paramString);
  }
  
  public static void logDebug(String paramString1, String paramString2) {
    logDebug(paramString1, paramString2, true);
  }
  
  public static void logDebug(String paramString1, String paramString2, boolean paramBoolean) {
    if (enableLog) {
      Log.d(paramString1, paramString2);
      log2Local(paramString2, paramBoolean);
    } 
  }
  
  public static void logDebug(String paramString, boolean paramBoolean) {
    logDebug("OSS-Android-SDK", paramString, paramBoolean);
  }
  
  public static void logError(String paramString) {
    logError("OSS-Android-SDK", paramString);
  }
  
  public static void logError(String paramString1, String paramString2) {
    logDebug(paramString1, paramString2, true);
  }
  
  public static void logError(String paramString1, String paramString2, boolean paramBoolean) {
    if (enableLog) {
      Log.d(paramString1, paramString2);
      log2Local(paramString2, paramBoolean);
    } 
  }
  
  public static void logError(String paramString, boolean paramBoolean) {
    logError("OSS-Android-SDK", paramString, paramBoolean);
  }
  
  public static void logInfo(String paramString) {
    logInfo(paramString, true);
  }
  
  public static void logInfo(String paramString, boolean paramBoolean) {
    if (enableLog) {
      Log.i("OSS-Android-SDK", paramString);
      log2Local(paramString, paramBoolean);
    } 
  }
  
  public static void logThrowable2Local(Throwable paramThrowable) {}
  
  public static void logVerbose(String paramString) {
    logVerbose(paramString, true);
  }
  
  public static void logVerbose(String paramString, boolean paramBoolean) {
    if (enableLog) {
      Log.v("OSS-Android-SDK", paramString);
      log2Local(paramString, paramBoolean);
    } 
  }
  
  public static void logWarn(String paramString) {
    logWarn(paramString, true);
  }
  
  public static void logWarn(String paramString, boolean paramBoolean) {
    if (enableLog) {
      Log.w("OSS-Android-SDK", paramString);
      log2Local(paramString, paramBoolean);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\SLSLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */