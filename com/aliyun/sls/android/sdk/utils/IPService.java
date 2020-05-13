package com.aliyun.sls.android.sdk.utils;

import android.os.Handler;
import android.os.Message;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class IPService {
  public static final String DEFAULT_URL = "https://api.ipify.org?format=text";
  
  public static final int HANDLER_MESSAGE_GETIP_CODE = 1530101;
  
  private static IPService instance;
  
  private String TAG = "IPService";
  
  private FutureTask<String> futureTask;
  
  private String convertInputStreamToString(InputStream paramInputStream) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    String str = "";
    while (true) {
      String str1 = bufferedReader.readLine();
      if (str1 != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str1);
        str = stringBuilder.toString();
        continue;
      } 
      if (paramInputStream != null)
        paramInputStream.close(); 
      return str;
    } 
  }
  
  public static IPService getInstance() {
    if (instance == null)
      instance = new IPService(); 
    return instance;
  }
  
  public void asyncGetIp(String paramString, final Handler handler) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    this.futureTask = new FutureTask<String>(new IP(paramString)) {
        protected void done() {
          try {
            String str = IPService.this.futureTask.get();
            if (handler != null) {
              Message message = Message.obtain(handler);
              message.what = 1530101;
              message.obj = str;
              message.sendToTarget();
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
          } 
        }
      };
    executorService.execute(this.futureTask);
  }
  
  public String syncGetIp(String paramString) throws Exception {
    Future<?> future = Executors.newSingleThreadExecutor().submit(new IP(paramString));
    try {
      return (String)future.get();
    } catch (Exception exception) {
      throw exception;
    } 
  }
  
  public class IP implements Callable<String> {
    private String uri = null;
    
    public IP(String param1String) {
      this.uri = param1String;
    }
    
    public String call() throws Exception {
      try {
        URL uRL = new URL();
        this(this.uri);
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(15000);
        int i = httpURLConnection.getResponseCode();
        if (i == 200) {
          BufferedInputStream bufferedInputStream = new BufferedInputStream();
          this(httpURLConnection.getInputStream());
          return IPService.this.convertInputStreamToString(bufferedInputStream);
        } 
        Exception exception = new Exception();
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("statusCode : ");
        stringBuilder.append(i);
        this(stringBuilder.toString());
        throw exception;
      } catch (Exception exception) {
        throw exception;
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sd\\utils\IPService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */