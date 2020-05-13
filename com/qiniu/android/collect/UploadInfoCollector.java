package com.qiniu.android.collect;

import com.qiniu.android.http.UserAgent;
import com.qiniu.android.storage.UpToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class UploadInfoCollector {
  private static OkHttpClient httpClient;
  
  private static UploadInfoCollector httpCollector;
  
  private static ExecutorService singleServer;
  
  private long lastUpload;
  
  private File recordFile = null;
  
  private final String recordFileName;
  
  private final String serverURL;
  
  private UploadInfoCollector(String paramString1, String paramString2) {
    this.recordFileName = paramString1;
    this.serverURL = paramString2;
    try {
      reset0();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void clean() {
    try {
      if (singleServer != null)
        singleServer.shutdown(); 
    } catch (Exception exception) {}
    singleServer = null;
    httpClient = null;
    try {
      getHttpCollector().clean0();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    httpCollector = null;
  }
  
  private void clean0() {
    try {
      if (this.recordFile != null) {
        this.recordFile.delete();
      } else {
        File file = new File();
        this(getRecordDir(Config.recordDir), this.recordFileName);
        file.delete();
      } 
    } catch (Exception exception) {}
    this.recordFile = null;
  }
  
  private static OkHttpClient getHttpClient() {
    if (httpClient == null) {
      OkHttpClient.Builder builder = new OkHttpClient.Builder();
      builder.connectTimeout(10L, TimeUnit.SECONDS);
      builder.readTimeout(15L, TimeUnit.SECONDS);
      builder.writeTimeout(((Config.interval / 2 + 1) * 60 - 10), TimeUnit.SECONDS);
      httpClient = builder.build();
    } 
    return httpClient;
  }
  
  private static UploadInfoCollector getHttpCollector() {
    if (httpCollector == null)
      httpCollector = new UploadInfoCollector("_qiniu_record_file_hs5z9lo7anx03", "https://uplog.qbox.me/log/3"); 
    return httpCollector;
  }
  
  private File getRecordDir(String paramString) {
    return new File(paramString);
  }
  
  private void handle0(final UpToken upToken, final RecordMsg record) {
    if (singleServer != null && !singleServer.isShutdown()) {
      Runnable runnable = new Runnable() {
          public void run() {
            if (Config.isRecord)
              try {
                UploadInfoCollector.this.tryRecode(record.toRecordMsg(), UploadInfoCollector.this.recordFile);
              } catch (Throwable throwable) {} 
          }
        };
      singleServer.submit(runnable);
      if (Config.isUpload && upToken != UpToken.NULL) {
        Runnable runnable1 = new Runnable() {
            public void run() {
              if (Config.isRecord && Config.isUpload)
                try {
                  UploadInfoCollector.this.tryUploadAndClean(upToken, UploadInfoCollector.this.recordFile);
                } catch (Throwable throwable) {} 
            }
          };
        singleServer.submit(runnable1);
      } 
    } 
  }
  
  public static void handleHttp(UpToken paramUpToken, RecordMsg paramRecordMsg) {
    try {
      if (Config.isRecord)
        getHttpCollector().handle0(paramUpToken, paramRecordMsg); 
    } catch (Throwable throwable) {}
  }
  
  public static void handleUpload(UpToken paramUpToken, RecordMsg paramRecordMsg) {
    handleHttp(paramUpToken, paramRecordMsg);
  }
  
  private void initRecordFile(File paramFile) throws IOException {
    if (paramFile != null) {
      if (!paramFile.exists()) {
        if (paramFile.mkdirs())
          return; 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("mkdir failed: ");
        stringBuilder1.append(paramFile.getAbsolutePath());
        throw new IOException(stringBuilder1.toString());
      } 
      if (paramFile.isDirectory()) {
        this.recordFile = new File(paramFile, this.recordFileName);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramFile.getAbsolutePath());
      stringBuilder.append(" is not a dir");
      throw new IOException(stringBuilder.toString());
    } 
    throw new IOException("record's dir is not setted");
  }
  
  private boolean isOk(Response paramResponse) {
    boolean bool;
    if (paramResponse.isSuccessful() && paramResponse.header("X-Reqid") != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static void reset() {
    try {
      getHttpCollector().reset0();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private void reset0() throws IOException {
    if (Config.isRecord)
      initRecordFile(getRecordDir(Config.recordDir)); 
    if (!Config.isRecord && singleServer != null)
      singleServer.shutdown(); 
    if (Config.isRecord && (singleServer == null || singleServer.isShutdown()))
      singleServer = Executors.newSingleThreadExecutor(); 
  }
  
  private void tryRecode(String paramString, File paramFile) {
    if (Config.isRecord && paramFile.length() < Config.maxRecordFileSize) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("\n");
      writeToFile(paramFile, stringBuilder.toString(), true);
    } 
  }
  
  private void tryUploadAndClean(UpToken paramUpToken, File paramFile) {
    if (Config.isUpload && paramFile.length() > Config.uploadThreshold) {
      long l = (new Date()).getTime();
      if (l > this.lastUpload + (Config.interval * 60 * 1000)) {
        this.lastUpload = l;
        if (upload(paramUpToken, paramFile)) {
          writeToFile(paramFile, "", false);
          writeToFile(paramFile, "", false);
        } 
      } 
    } 
  }
  
  private boolean upload(UpToken paramUpToken, File paramFile) {
    try {
      OkHttpClient okHttpClient = getHttpClient();
      RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), paramFile);
      Request.Builder builder = new Request.Builder();
      this();
      builder = builder.url(this.serverURL);
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("UpToken ");
      stringBuilder.append(paramUpToken.token);
      Response response = okHttpClient.newCall(builder.addHeader("Authorization", stringBuilder.toString()).addHeader("User-Agent", UserAgent.instance().getUa(paramUpToken.accessKey)).post(requestBody).build()).execute();
      try {
        boolean bool = isOk(response);
      } finally {
        try {
          response.body().close();
        } catch (Exception exception) {}
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return false;
    } 
  }
  
  private static void writeToFile(File paramFile, String paramString, boolean paramBoolean) {
    File file1 = null;
    File file2 = null;
    File file3 = null;
    File file4 = file3;
    try {
      FileOutputStream fileOutputStream = new FileOutputStream();
      file4 = file3;
      this(paramFile, paramBoolean);
    } catch (FileNotFoundException null) {
    
    } catch (IOException iOException) {
      paramFile = file1;
      file4 = paramFile;
      iOException.printStackTrace();
    } finally {
      File file;
      paramFile = null;
    } 
    file4 = paramFile;
    iOException.printStackTrace();
    if (paramFile != null) {
      paramFile.close();
      return;
    } 
  }
  
  public static abstract class RecordMsg {
    public abstract String toRecordMsg();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\collect\UploadInfoCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */