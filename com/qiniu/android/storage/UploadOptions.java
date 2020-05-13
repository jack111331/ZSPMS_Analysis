package com.qiniu.android.storage;

import android.os.Looper;
import android.util.Log;
import com.qiniu.android.utils.AndroidNetwork;
import java.util.HashMap;
import java.util.Map;

public final class UploadOptions {
  final UpCancellationSignal cancellationSignal;
  
  final boolean checkCrc;
  
  final String mimeType;
  
  final NetReadyHandler netReadyHandler;
  
  final Map<String, String> params;
  
  final UpProgressHandler progressHandler;
  
  public UploadOptions(Map<String, String> paramMap, String paramString, boolean paramBoolean, UpProgressHandler paramUpProgressHandler, UpCancellationSignal paramUpCancellationSignal) {
    this(paramMap, paramString, paramBoolean, paramUpProgressHandler, paramUpCancellationSignal, null);
  }
  
  public UploadOptions(Map<String, String> paramMap, String paramString, boolean paramBoolean, UpProgressHandler paramUpProgressHandler, UpCancellationSignal paramUpCancellationSignal, NetReadyHandler paramNetReadyHandler) {
    this.params = filterParam(paramMap);
    this.mimeType = mime(paramString);
    this.checkCrc = paramBoolean;
    if (paramUpProgressHandler == null)
      paramUpProgressHandler = new UpProgressHandler() {
          public void progress(String param1String, double param1Double) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(param1Double);
            Log.d("Qiniu.UploadProgress", stringBuilder.toString());
          }
        }; 
    this.progressHandler = paramUpProgressHandler;
    if (paramUpCancellationSignal == null)
      paramUpCancellationSignal = new UpCancellationSignal() {
          public boolean isCancelled() {
            return false;
          }
        }; 
    this.cancellationSignal = paramUpCancellationSignal;
    if (paramNetReadyHandler == null)
      paramNetReadyHandler = new NetReadyHandler() {
          public void waitReady() {
            if (Thread.currentThread() == Looper.getMainLooper().getThread())
              return; 
            for (byte b = 0; b < 6; b++) {
              try {
                Thread.sleep(500L);
              } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
              } 
              if (AndroidNetwork.isNetWorkReady())
                return; 
            } 
          }
        }; 
    this.netReadyHandler = paramNetReadyHandler;
  }
  
  static UploadOptions defaultOptions() {
    return new UploadOptions(null, null, false, null, null);
  }
  
  private static Map<String, String> filterParam(Map<String, String> paramMap) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramMap == null)
      return (Map)hashMap; 
    for (Map.Entry<String, String> entry : paramMap.entrySet()) {
      if (((String)entry.getKey()).startsWith("x:") && entry.getValue() != null && !((String)entry.getValue()).equals(""))
        hashMap.put(entry.getKey(), entry.getValue()); 
    } 
    return (Map)hashMap;
  }
  
  private static String mime(String paramString) {
    return (paramString == null || paramString.equals("")) ? "application/octet-stream" : paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\storage\UploadOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */