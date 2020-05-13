package com.qiniu.android.storage;

import com.qiniu.android.http.Client;
import com.qiniu.android.http.CompletionHandler;
import com.qiniu.android.http.ProgressHandler;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.utils.AndroidNetwork;
import com.qiniu.android.utils.Crc32;
import com.qiniu.android.utils.StringMap;
import com.qiniu.android.utils.StringUtils;
import com.qiniu.android.utils.UrlSafeBase64;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ResumeUploader implements Runnable {
  private final byte[] chunkBuffer;
  
  private final Client client;
  
  private final UpCompletionHandler completionHandler;
  
  private final Configuration config;
  
  private final String[] contexts;
  
  private long crc32;
  
  private File f;
  
  private RandomAccessFile file;
  
  private final StringMap headers;
  
  private final String key;
  
  private final long modifyTime;
  
  private final UploadOptions options;
  
  private final String recorderKey;
  
  private UpToken token;
  
  private final long totalSize;
  
  ResumeUploader(Client paramClient, Configuration paramConfiguration, File paramFile, String paramString1, UpToken paramUpToken, final UpCompletionHandler completionHandler, UploadOptions paramUploadOptions, String paramString2) {
    this.client = paramClient;
    this.config = paramConfiguration;
    this.f = paramFile;
    this.recorderKey = paramString2;
    this.totalSize = paramFile.length();
    this.key = paramString1;
    StringMap stringMap = new StringMap();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("UpToken ");
    stringBuilder.append(paramUpToken.token);
    this.headers = stringMap.put("Authorization", stringBuilder.toString());
    this.file = null;
    this.completionHandler = new UpCompletionHandler() {
        public void complete(String param1String, ResponseInfo param1ResponseInfo, JSONObject param1JSONObject) {
          if (ResumeUploader.this.file != null)
            try {
              ResumeUploader.this.file.close();
            } catch (IOException iOException) {
              iOException.printStackTrace();
            }  
          completionHandler.complete(param1String, param1ResponseInfo, param1JSONObject);
        }
      };
    if (paramUploadOptions == null)
      paramUploadOptions = UploadOptions.defaultOptions(); 
    this.options = paramUploadOptions;
    this.chunkBuffer = new byte[paramConfiguration.chunkSize];
    this.contexts = new String[(int)((this.totalSize + 4194304L - 1L) / 4194304L)];
    this.modifyTime = paramFile.lastModified();
    this.token = paramUpToken;
  }
  
  private long calcBlockSize(long paramLong) {
    long l = this.totalSize - paramLong;
    paramLong = 4194304L;
    if (l < 4194304L)
      paramLong = l; 
    return paramLong;
  }
  
  private long calcPutSize(long paramLong) {
    paramLong = this.totalSize - paramLong;
    if (paramLong >= this.config.chunkSize)
      paramLong = this.config.chunkSize; 
    return paramLong;
  }
  
  private boolean isCancelled() {
    return this.options.cancellationSignal.isCancelled();
  }
  
  private static boolean isChunkOK(ResponseInfo paramResponseInfo, JSONObject paramJSONObject) {
    boolean bool;
    if (paramResponseInfo.statusCode == 200 && paramResponseInfo.error == null && (paramResponseInfo.hasReqId() || isChunkResOK(paramJSONObject))) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private static boolean isChunkResOK(JSONObject paramJSONObject) {
    try {
      paramJSONObject.getString("ctx");
      paramJSONObject.getLong("crc32");
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private static boolean isNotChunkToQiniu(ResponseInfo paramResponseInfo, JSONObject paramJSONObject) {
    boolean bool;
    if (paramResponseInfo.statusCode < 500 && paramResponseInfo.statusCode >= 200 && !paramResponseInfo.hasReqId() && !isChunkResOK(paramJSONObject)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private void makeBlock(String paramString, long paramLong, int paramInt1, int paramInt2, ProgressHandler paramProgressHandler, CompletionHandler paramCompletionHandler, UpCancellationSignal paramUpCancellationSignal) {
    String str = String.format(Locale.ENGLISH, "/mkblk/%d", new Object[] { Integer.valueOf(paramInt1) });
    try {
      this.file.seek(paramLong);
      this.file.read(this.chunkBuffer, 0, paramInt2);
      this.crc32 = Crc32.bytes(this.chunkBuffer, 0, paramInt2);
      post(String.format("%s%s", new Object[] { paramString, str }), this.chunkBuffer, 0, paramInt2, paramProgressHandler, paramCompletionHandler, paramUpCancellationSignal);
      return;
    } catch (IOException iOException) {
      this.completionHandler.complete(this.key, ResponseInfo.fileError(iOException, this.token), null);
      return;
    } 
  }
  
  private void makeFile(String paramString, CompletionHandler paramCompletionHandler, UpCancellationSignal paramUpCancellationSignal) {
    String str1 = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", new Object[] { UrlSafeBase64.encodeToString(this.options.mimeType), UrlSafeBase64.encodeToString(this.f.getName()) });
    String str2 = "";
    if (this.key != null)
      str2 = String.format("/key/%s", new Object[] { UrlSafeBase64.encodeToString(this.key) }); 
    String str3 = "";
    if (this.options.params.size() != 0) {
      String[] arrayOfString = new String[this.options.params.size()];
      Iterator<Map.Entry> iterator = this.options.params.entrySet().iterator();
      for (byte b = 0; iterator.hasNext(); b++) {
        Map.Entry entry = iterator.next();
        arrayOfString[b] = String.format(Locale.ENGLISH, "%s/%s", new Object[] { entry.getKey(), UrlSafeBase64.encodeToString((String)entry.getValue()) });
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("/");
      stringBuilder.append(StringUtils.join(arrayOfString, "/"));
      str3 = stringBuilder.toString();
    } 
    str2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", new Object[] { Long.valueOf(this.totalSize), str1, str2, str3 });
    byte[] arrayOfByte = StringUtils.join(this.contexts, ",").getBytes();
    post(String.format("%s%s", new Object[] { paramString, str2 }), arrayOfByte, 0, arrayOfByte.length, null, paramCompletionHandler, paramUpCancellationSignal);
  }
  
  private URI newURI(URI paramURI, String paramString) {
    try {
      return new URI(paramURI.getScheme(), null, paramURI.getHost(), paramURI.getPort(), paramString, null, null);
    } catch (URISyntaxException uRISyntaxException) {
      uRISyntaxException.printStackTrace();
      return paramURI;
    } 
  }
  
  private void nextTask(final long offset, final int retried, String paramString) {
    final ResponseInfo upHost;
    if (isCancelled()) {
      responseInfo = ResponseInfo.cancelled(this.token);
      this.completionHandler.complete(this.key, responseInfo, null);
      return;
    } 
    if (offset == this.totalSize) {
      makeFile((String)responseInfo, new CompletionHandler() {
            public void complete(ResponseInfo param1ResponseInfo, JSONObject param1JSONObject) {
              if (param1ResponseInfo.isNetworkBroken() && !AndroidNetwork.isNetWorkReady()) {
                ResumeUploader.this.options.netReadyHandler.waitReady();
                if (!AndroidNetwork.isNetWorkReady()) {
                  ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, param1ResponseInfo, param1JSONObject);
                  return;
                } 
              } 
              if (param1ResponseInfo.isOK()) {
                ResumeUploader.this.removeRecord();
                ResumeUploader.this.options.progressHandler.progress(ResumeUploader.this.key, 1.0D);
                ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, param1ResponseInfo, param1JSONObject);
                return;
              } 
              if (param1ResponseInfo.needRetry() && retried < ResumeUploader.this.config.retryMax + 1) {
                String str = ResumeUploader.this.config.zone.upHost(ResumeUploader.this.token.token, ResumeUploader.this.config.useHttps, upHost);
                if (str != null) {
                  ResumeUploader.this.nextTask(offset, retried + 1, str);
                  return;
                } 
              } 
              ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, param1ResponseInfo, param1JSONObject);
            }
          }this.options.cancellationSignal);
      return;
    } 
    final int chunkSize = (int)calcPutSize(offset);
    ProgressHandler progressHandler = new ProgressHandler() {
        public void onProgress(long param1Long1, long param1Long2) {
          double d1 = (offset + param1Long1);
          double d2 = param1Long2;
          Double.isNaN(d1);
          Double.isNaN(d2);
          d2 = d1 / d2;
          d1 = d2;
          if (d2 > 0.95D)
            d1 = 0.95D; 
          ResumeUploader.this.options.progressHandler.progress(ResumeUploader.this.key, d1);
        }
      };
    CompletionHandler completionHandler = new CompletionHandler() {
        public void complete(ResponseInfo param1ResponseInfo, JSONObject param1JSONObject) {
          if (param1ResponseInfo.isNetworkBroken() && !AndroidNetwork.isNetWorkReady()) {
            ResumeUploader.this.options.netReadyHandler.waitReady();
            if (!AndroidNetwork.isNetWorkReady()) {
              ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, param1ResponseInfo, param1JSONObject);
              return;
            } 
          } 
          if (param1ResponseInfo.isCancelled()) {
            ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, param1ResponseInfo, param1JSONObject);
            return;
          } 
          if (!ResumeUploader.isChunkOK(param1ResponseInfo, param1JSONObject)) {
            String str = ResumeUploader.this.config.zone.upHost(ResumeUploader.this.token.token, ResumeUploader.this.config.useHttps, upHost);
            if (param1ResponseInfo.statusCode == 701 && retried < ResumeUploader.this.config.retryMax) {
              ResumeUploader.this.nextTask(offset / 4194304L * 4194304L, retried + 1, upHost);
              return;
            } 
            if (str != null && (ResumeUploader.isNotChunkToQiniu(param1ResponseInfo, param1JSONObject) || param1ResponseInfo.needRetry()) && retried < ResumeUploader.this.config.retryMax) {
              ResumeUploader.this.nextTask(offset, retried + 1, str);
              return;
            } 
            ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, param1ResponseInfo, param1JSONObject);
            return;
          } 
          if (param1JSONObject == null && retried < ResumeUploader.this.config.retryMax) {
            String str = ResumeUploader.this.config.zone.upHost(ResumeUploader.this.token.token, ResumeUploader.this.config.useHttps, upHost);
            ResumeUploader.this.nextTask(offset, retried + 1, str);
            return;
          } 
          try {
            String str = param1JSONObject.getString("ctx");
            try {
              long l1 = param1JSONObject.getLong("crc32");
            } catch (Exception null) {}
          } catch (Exception exception) {
            param1ResponseInfo = null;
          } 
          exception.printStackTrace();
          long l = 0L;
        }
      };
    if (offset % 4194304L == 0L) {
      makeBlock((String)responseInfo, offset, (int)calcBlockSize(offset), i, progressHandler, completionHandler, this.options.cancellationSignal);
      return;
    } 
    putChunk((String)responseInfo, offset, i, this.contexts[(int)(offset / 4194304L)], progressHandler, completionHandler, this.options.cancellationSignal);
  }
  
  private void post(String paramString, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, ProgressHandler paramProgressHandler, CompletionHandler paramCompletionHandler, UpCancellationSignal paramUpCancellationSignal) {
    this.client.asyncPost(paramString, paramArrayOfbyte, paramInt1, paramInt2, this.headers, this.token, this.totalSize, paramProgressHandler, paramCompletionHandler, paramUpCancellationSignal);
  }
  
  private void putChunk(String paramString1, long paramLong, int paramInt, String paramString2, ProgressHandler paramProgressHandler, CompletionHandler paramCompletionHandler, UpCancellationSignal paramUpCancellationSignal) {
    int i = (int)(paramLong % 4194304L);
    paramString2 = String.format(Locale.ENGLISH, "/bput/%s/%d", new Object[] { paramString2, Integer.valueOf(i) });
    try {
      this.file.seek(paramLong);
      this.file.read(this.chunkBuffer, 0, paramInt);
      this.crc32 = Crc32.bytes(this.chunkBuffer, 0, paramInt);
      post(String.format("%s%s", new Object[] { paramString1, paramString2 }), this.chunkBuffer, 0, paramInt, paramProgressHandler, paramCompletionHandler, paramUpCancellationSignal);
      return;
    } catch (IOException iOException) {
      this.completionHandler.complete(this.key, ResponseInfo.fileError(iOException, this.token), null);
      return;
    } 
  }
  
  private void record(long paramLong) {
    if (this.config.recorder == null || paramLong == 0L)
      return; 
    String str = String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", new Object[] { Long.valueOf(this.totalSize), Long.valueOf(paramLong), Long.valueOf(this.modifyTime), StringUtils.jsonJoin(this.contexts) });
    this.config.recorder.set(this.recorderKey, str.getBytes());
  }
  
  private long recoveryFromRecord() {
    if (this.config.recorder == null)
      return 0L; 
    byte[] arrayOfByte = this.config.recorder.get(this.recorderKey);
    if (arrayOfByte == null)
      return 0L; 
    String str = new String(arrayOfByte);
    try {
      JSONObject jSONObject = new JSONObject(str);
      long l1 = jSONObject.optLong("offset", 0L);
      long l2 = jSONObject.optLong("modify_time", 0L);
      long l3 = jSONObject.optLong("size", 0L);
      JSONArray jSONArray = jSONObject.optJSONArray("contexts");
      if (l1 == 0L || l2 != this.modifyTime || l3 != this.totalSize || jSONArray == null || jSONArray.length() == 0)
        return 0L; 
      for (byte b = 0; b < jSONArray.length(); b++)
        this.contexts[b] = jSONArray.optString(b); 
      return l1;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return 0L;
    } 
  }
  
  private void removeRecord() {
    if (this.config.recorder != null)
      this.config.recorder.del(this.recorderKey); 
  }
  
  public void run() {
    long l = recoveryFromRecord();
    try {
      RandomAccessFile randomAccessFile = new RandomAccessFile();
      this(this.f, "r");
      this.file = randomAccessFile;
      nextTask(l, 0, this.config.zone.upHost(this.token.token, this.config.useHttps, null));
      return;
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
      this.completionHandler.complete(this.key, ResponseInfo.fileError(fileNotFoundException, this.token), null);
      return;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\storage\ResumeUploader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */