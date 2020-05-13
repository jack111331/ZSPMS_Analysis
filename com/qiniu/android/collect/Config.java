package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;

public final class Config {
  public static int interval = 10;
  
  public static boolean isRecord = true;
  
  public static boolean isUpload = true;
  
  public static int maxRecordFileSize = 2097152;
  
  public static String recordDir;
  
  public static final String serverURL = "https://uplog.qbox.me/log/3";
  
  public static int uploadThreshold = 4096;
  
  static {
    try {
      recordDir = ContextGetter.applicationContext().getCacheDir().getAbsolutePath();
    } catch (Throwable throwable) {
      throwable.fillInStackTrace();
    } 
  }
  
  public static void normal() {
    uploadThreshold = 4096;
    interval = 10;
  }
  
  public static void quick() {
    uploadThreshold = 1024;
    interval = 2;
  }
  
  public static void slow() {
    uploadThreshold = 153600;
    interval = 300;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\collect\Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */