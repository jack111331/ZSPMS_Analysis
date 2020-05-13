package com.qiniu.android.storage;

import com.qiniu.android.collect.Config;
import com.qiniu.android.collect.UploadInfoCollector;
import com.qiniu.android.common.Zone;
import com.qiniu.android.http.Client;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.utils.AsyncRun;
import com.qiniu.android.utils.StringUtils;
import java.io.File;
import org.json.JSONObject;

public final class UploadManager {
  private final Client client;
  
  private final Configuration config;
  
  public UploadManager() {
    this((new Configuration.Builder()).build());
  }
  
  public UploadManager(Configuration paramConfiguration) {
    this.config = paramConfiguration;
    this.client = new Client(paramConfiguration.proxy, paramConfiguration.connectTimeout, paramConfiguration.responseTimeout, paramConfiguration.urlConverter, paramConfiguration.dns);
  }
  
  public UploadManager(Recorder paramRecorder) {
    this(paramRecorder, null);
  }
  
  public UploadManager(Recorder paramRecorder, KeyGenerator paramKeyGenerator) {
    this((new Configuration.Builder()).recorder(paramRecorder, paramKeyGenerator).build());
  }
  
  private static ResponseInfo areInvalidArg(String paramString1, byte[] paramArrayOfbyte, File paramFile, String paramString2, UpToken paramUpToken) {
    if (paramFile == null && paramArrayOfbyte == null) {
      paramString1 = "no input data";
    } else if (paramString2 == null || paramString2.equals("")) {
      paramString1 = "no token";
    } else {
      paramString1 = null;
    } 
    return (paramString1 != null) ? ResponseInfo.invalidArgument(paramString1, paramUpToken) : ((paramUpToken == UpToken.NULL || paramUpToken == null) ? ResponseInfo.invalidToken("invalid token") : (((paramFile != null && paramFile.length() == 0L) || (paramArrayOfbyte != null && paramArrayOfbyte.length == 0)) ? ResponseInfo.zeroSize(paramUpToken) : null));
  }
  
  private static boolean areInvalidArg(String paramString1, byte[] paramArrayOfbyte, File paramFile, String paramString2, UpToken paramUpToken, UpCompletionHandler paramUpCompletionHandler) {
    if (paramUpCompletionHandler != null) {
      ResponseInfo responseInfo;
      if (paramFile == null && paramArrayOfbyte == null) {
        paramString2 = "no input data";
      } else if (paramString2 == null || paramString2.equals("")) {
        paramString2 = "no token";
      } else {
        paramString2 = null;
      } 
      if (paramString2 != null) {
        responseInfo = ResponseInfo.invalidArgument(paramString2, paramUpToken);
      } else if (paramUpToken == UpToken.NULL || paramUpToken == null) {
        responseInfo = ResponseInfo.invalidToken("invalid token");
      } else if ((paramFile != null && paramFile.length() == 0L) || (responseInfo != null && responseInfo.length == 0)) {
        responseInfo = ResponseInfo.zeroSize(paramUpToken);
      } else {
        responseInfo = null;
      } 
      if (responseInfo != null) {
        paramUpCompletionHandler.complete(paramString1, responseInfo, null);
        return true;
      } 
      return false;
    } 
    throw new IllegalArgumentException("no UpCompletionHandler");
  }
  
  private static WarpHandler warpHandler(UpCompletionHandler paramUpCompletionHandler, long paramLong) {
    return new WarpHandler(paramUpCompletionHandler, paramLong);
  }
  
  public void put(final File file, final String key, String paramString2, final UpCompletionHandler complete, final UploadOptions options) {
    final UpToken decodedToken = UpToken.parse(paramString2);
    if (areInvalidArg(key, null, file, paramString2, upToken, complete))
      return; 
    this.config.zone.preQuery(paramString2, new Zone.QueryHandler() {
          public void onFailure(int param1Int) {
            ResponseInfo responseInfo;
            if (ResponseInfo.isStatusCodeForBrokenNetwork(param1Int)) {
              responseInfo = ResponseInfo.networkError(param1Int, decodedToken);
            } else {
              responseInfo = ResponseInfo.invalidToken("invalid token");
            } 
            complete.complete(key, responseInfo, null);
          }
          
          public void onSuccess() {
            long l;
            if (file.length() <= UploadManager.this.config.putThreshold) {
              FormUploader.upload(UploadManager.this.client, UploadManager.this.config, file, key, decodedToken, complete, options);
              return;
            } 
            String str = UploadManager.this.config.keyGen.gen(key, file);
            UpCompletionHandler upCompletionHandler = complete;
            if (file != null) {
              l = file.length();
            } else {
              l = 0L;
            } 
            upCompletionHandler = UploadManager.warpHandler(upCompletionHandler, l);
            AsyncRun.runInMain(new ResumeUploader(UploadManager.this.client, UploadManager.this.config, file, key, decodedToken, upCompletionHandler, options, str));
          }
        });
  }
  
  public void put(String paramString1, String paramString2, String paramString3, UpCompletionHandler paramUpCompletionHandler, UploadOptions paramUploadOptions) {
    put(new File(paramString1), paramString2, paramString3, paramUpCompletionHandler, paramUploadOptions);
  }
  
  public void put(final byte[] data, final String key, String paramString2, final UpCompletionHandler complete, final UploadOptions options) {
    final UpToken decodedToken = UpToken.parse(paramString2);
    if (areInvalidArg(key, data, null, paramString2, upToken, complete))
      return; 
    this.config.zone.preQuery(paramString2, new Zone.QueryHandler() {
          public void onFailure(int param1Int) {
            ResponseInfo responseInfo;
            if (ResponseInfo.isStatusCodeForBrokenNetwork(param1Int)) {
              responseInfo = ResponseInfo.networkError(param1Int, decodedToken);
            } else {
              responseInfo = ResponseInfo.invalidToken("invalid token");
            } 
            complete.complete(key, responseInfo, null);
          }
          
          public void onSuccess() {
            FormUploader.upload(UploadManager.this.client, UploadManager.this.config, data, key, decodedToken, complete, options);
          }
        });
  }
  
  public ResponseInfo syncPut(File paramFile, String paramString1, String paramString2, UploadOptions paramUploadOptions) {
    UpToken upToken = UpToken.parse(paramString2);
    ResponseInfo responseInfo = areInvalidArg(paramString1, null, paramFile, paramString2, upToken);
    return (responseInfo != null) ? responseInfo : FormUploader.syncUpload(this.client, this.config, paramFile, paramString1, upToken, paramUploadOptions);
  }
  
  public ResponseInfo syncPut(String paramString1, String paramString2, String paramString3, UploadOptions paramUploadOptions) {
    return syncPut(new File(paramString1), paramString2, paramString3, paramUploadOptions);
  }
  
  public ResponseInfo syncPut(byte[] paramArrayOfbyte, String paramString1, String paramString2, UploadOptions paramUploadOptions) {
    UpToken upToken = UpToken.parse(paramString2);
    ResponseInfo responseInfo = areInvalidArg(paramString1, paramArrayOfbyte, null, paramString2, upToken);
    return (responseInfo != null) ? responseInfo : FormUploader.syncUpload(this.client, this.config, paramArrayOfbyte, paramString1, upToken, paramUploadOptions);
  }
  
  private static class WarpHandler implements UpCompletionHandler {
    final long before = System.currentTimeMillis();
    
    final UpCompletionHandler complete;
    
    final long size;
    
    WarpHandler(UpCompletionHandler param1UpCompletionHandler, long param1Long) {
      this.complete = param1UpCompletionHandler;
      this.size = param1Long;
    }
    
    public void complete(final String key, final ResponseInfo res, final JSONObject response) {
      if (Config.isRecord) {
        final long after = System.currentTimeMillis();
        UploadInfoCollector.handleUpload(res.upToken, new UploadInfoCollector.RecordMsg() {
              public String toRecordMsg() {
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append(res.statusCode);
                stringBuilder1.append("");
                String str2 = stringBuilder1.toString();
                String str1 = res.reqId;
                String str3 = res.host;
                String str4 = res.ip;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(res.port);
                stringBuilder2.append("");
                String str5 = stringBuilder2.toString();
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(after - UploadManager.WarpHandler.this.before);
                stringBuilder3.append("");
                String str6 = stringBuilder3.toString();
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(res.timeStamp);
                stringBuilder4.append("");
                String str7 = stringBuilder4.toString();
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append(UploadManager.WarpHandler.this.size);
                stringBuilder5.append("");
                String str8 = stringBuilder5.toString();
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append(UploadManager.WarpHandler.this.size);
                stringBuilder6.append("");
                return StringUtils.join(new String[] { str2, str1, str3, str4, str5, str6, str7, str8, "block", stringBuilder6.toString() }, ",");
              }
            });
      } 
      AsyncRun.runInMain(new Runnable() {
            public void run() {
              try {
                UploadManager.WarpHandler.this.complete.complete(key, res, response);
              } catch (Throwable throwable) {
                throwable.printStackTrace();
              } 
            }
          });
    }
  }
  
  class null extends UploadInfoCollector.RecordMsg {
    public String toRecordMsg() {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(res.statusCode);
      stringBuilder1.append("");
      String str2 = stringBuilder1.toString();
      String str1 = res.reqId;
      String str3 = res.host;
      String str4 = res.ip;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(res.port);
      stringBuilder2.append("");
      String str5 = stringBuilder2.toString();
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(after - this.this$0.before);
      stringBuilder3.append("");
      String str6 = stringBuilder3.toString();
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append(res.timeStamp);
      stringBuilder4.append("");
      String str7 = stringBuilder4.toString();
      StringBuilder stringBuilder5 = new StringBuilder();
      stringBuilder5.append(this.this$0.size);
      stringBuilder5.append("");
      String str8 = stringBuilder5.toString();
      StringBuilder stringBuilder6 = new StringBuilder();
      stringBuilder6.append(this.this$0.size);
      stringBuilder6.append("");
      return StringUtils.join(new String[] { str2, str1, str3, str4, str5, str6, str7, str8, "block", stringBuilder6.toString() }, ",");
    }
  }
  
  class null implements Runnable {
    public void run() {
      try {
        this.this$0.complete.complete(key, res, response);
      } catch (Throwable throwable) {
        throwable.printStackTrace();
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\storage\UploadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */