package com.aliyun.sls.android.sdk.core;

import com.aliyun.sls.android.sdk.LogException;
import com.aliyun.sls.android.sdk.SLSLog;
import com.aliyun.sls.android.sdk.core.http.HttpMethod;
import com.aliyun.sls.android.sdk.core.parser.ResponseParser;
import com.aliyun.sls.android.sdk.core.retry.RetryHandler;
import com.aliyun.sls.android.sdk.utils.Utils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

public class RequestTask<T extends Result> implements Callable<T> {
  private OkHttpClient client;
  
  private ExecutionContext context;
  
  private int currentRetryCount = 0;
  
  private RequestMessage message;
  
  private ResponseParser<T> responseParser;
  
  private RetryHandler retryHandler;
  
  public RequestTask(RequestMessage paramRequestMessage, ResponseParser<T> paramResponseParser, ExecutionContext paramExecutionContext, int paramInt) {
    this.responseParser = paramResponseParser;
    this.message = paramRequestMessage;
    this.context = paramExecutionContext;
    this.client = paramExecutionContext.getClient();
    this.retryHandler = new RetryHandler(paramInt);
  }
  
  public T call() throws Exception {
    StringBuilder stringBuilder1;
    Object object = null;
    try {
      SLSLog.logDebug("[call] - ");
      if (!this.context.getCancellationHandler().isCancelled()) {
        boolean bool;
        stringBuilder1 = (StringBuilder)new Request.Builder();
        this();
        stringBuilder1 = (StringBuilder)stringBuilder1.url(this.message.url);
        for (String str1 : this.message.getHeaders().keySet())
          stringBuilder1 = (StringBuilder)stringBuilder1.addHeader(str1, this.message.getHeaders().get(str1)); 
        String str = this.message.getHeaders().get("Content-Type");
        switch (this.message.getMethod()) {
          case DELETE:
            stringBuilder1 = (StringBuilder)stringBuilder1.delete();
            break;
          case HEAD:
            stringBuilder1 = (StringBuilder)stringBuilder1.head();
            break;
          case GET:
            stringBuilder1 = (StringBuilder)stringBuilder1.get();
            break;
          case POST:
          case PUT:
            if (str != null) {
              bool = true;
            } else {
              bool = false;
            } 
            Utils.assertTrue(bool, "Content type can't be null when upload!");
            if (this.message.getUploadData() != null) {
              String str1 = this.message.getMethod().toString();
              DataRequestBody dataRequestBody = new DataRequestBody();
              this(this, this.message.getUploadData(), str);
              stringBuilder1 = (StringBuilder)stringBuilder1.method(str1, dataRequestBody);
              break;
            } 
            if (this.message.getUploadFilePath() != null) {
              String str1 = this.message.getMethod().toString();
              DataRequestBody dataRequestBody = new DataRequestBody();
              File file = new File();
              this(this.message.getUploadFilePath());
              this(this, file, str);
              stringBuilder1 = (StringBuilder)stringBuilder1.method(str1, dataRequestBody);
              break;
            } 
            if (this.message.getUploadInputStream() != null) {
              String str1 = this.message.getMethod().toString();
              DataRequestBody dataRequestBody = new DataRequestBody();
              this(this, this.message.getUploadInputStream(), this.message.getReadStreamLength(), str);
              stringBuilder1 = (StringBuilder)stringBuilder1.method(str1, dataRequestBody);
              break;
            } 
            stringBuilder1 = (StringBuilder)stringBuilder1.method(this.message.getMethod().toString(), RequestBody.create(null, new byte[0]));
            break;
        } 
        Request request = stringBuilder1.build();
        Call call = this.client.newCall(request);
        try {
          this.context.getCancellationHandler().setCall(call);
          Response response = call.execute();
          try {
            Map map = response.headers().toMultimap();
            StringBuilder stringBuilder3 = new StringBuilder();
            this();
            stringBuilder3.append("response:---------------------\n");
            StringBuilder stringBuilder4 = new StringBuilder();
            this();
            stringBuilder4.append("response code : ");
            stringBuilder4.append(response.code());
            stringBuilder4.append(" for url : ");
            stringBuilder4.append(request.url());
            stringBuilder4.append("\n");
            stringBuilder3.append(stringBuilder4.toString());
            byte[] arrayOfByte = response.body().bytes();
            if (arrayOfByte != null && arrayOfByte.length > 0) {
              String str1 = new String();
              this(arrayOfByte, "utf-8");
              StringBuilder stringBuilder = new StringBuilder();
              this();
              stringBuilder.append("response body : ");
              stringBuilder.append(str1);
              stringBuilder.append("\n");
              stringBuilder3.append(stringBuilder.toString());
            } else {
              stringBuilder3.append("response body is null \n");
            } 
            for (String str1 : map.keySet()) {
              StringBuilder stringBuilder = new StringBuilder();
              this();
              stringBuilder.append("responseHeader [");
              stringBuilder.append(str1);
              stringBuilder.append("]: ");
              stringBuilder3.append(stringBuilder.toString());
              stringBuilder = new StringBuilder();
              this();
              stringBuilder.append(((List<String>)map.get(str1)).get(0));
              stringBuilder.append("\n");
              stringBuilder3.append(stringBuilder.toString());
            } 
            SLSLog.logDebug(stringBuilder3.toString());
            stringBuilder3 = null;
            Response response1 = response;
          } catch (Exception null) {}
        } catch (Exception null) {
          stringBuilder1 = null;
        } 
      } else {
        stringBuilder1 = (StringBuilder)new InterruptedIOException();
        this("This task is cancelled!");
        throw stringBuilder1;
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = null;
      stringBuilder1 = stringBuilder;
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("Encounter local execpiton: ");
    stringBuilder2.append(exception.toString());
    SLSLog.logError(stringBuilder2.toString());
    if (SLSLog.isEnableLog())
      exception.printStackTrace(); 
    LogException logException = new LogException("", exception.getMessage(), exception.getCause(), "");
    stringBuilder2 = stringBuilder1;
  }
  
  class DataRequestBody extends RequestBody {
    private static final int SEGMENT_SIZE = 2048;
    
    private long contentLength;
    
    private String contentType;
    
    private byte[] data;
    
    private File file;
    
    private InputStream inputStream;
    
    public DataRequestBody(File param1File, String param1String) {
      this.file = param1File;
      this.contentType = param1String;
      this.contentLength = param1File.length();
    }
    
    public DataRequestBody(InputStream param1InputStream, long param1Long, String param1String) {
      this.inputStream = param1InputStream;
      this.contentType = param1String;
      this.contentLength = param1Long;
    }
    
    public DataRequestBody(byte[] param1ArrayOfbyte, String param1String) {
      this.data = param1ArrayOfbyte;
      this.contentType = param1String;
      this.contentLength = param1ArrayOfbyte.length;
    }
    
    public long contentLength() throws IOException {
      return this.contentLength;
    }
    
    public MediaType contentType() {
      return MediaType.parse(this.contentType);
    }
    
    public void writeTo(BufferedSink param1BufferedSink) throws IOException {
      Source source;
      if (this.file != null) {
        source = Okio.source(this.file);
      } else if (this.data != null) {
        source = Okio.source(new ByteArrayInputStream(this.data));
      } else if (this.inputStream != null) {
        source = Okio.source(this.inputStream);
      } else {
        source = null;
      } 
      long l = 0L;
      while (l < this.contentLength) {
        long l1 = Math.min(this.contentLength - l, 2048L);
        l1 = source.read(param1BufferedSink.buffer(), l1);
        if (l1 == -1L)
          break; 
        l += l1;
        param1BufferedSink.flush();
      } 
      if (source != null)
        source.close(); 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\core\RequestTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */