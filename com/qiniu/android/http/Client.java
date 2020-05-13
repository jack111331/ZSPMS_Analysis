package com.qiniu.android.http;

import com.qiniu.android.storage.UpCancellationSignal;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.utils.AsyncRun;
import com.qiniu.android.utils.StringMap;
import com.qiniu.android.utils.StringUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

public final class Client {
  public static final String ContentTypeHeader = "Content-Type";
  
  public static final String DefaultMime = "application/octet-stream";
  
  public static final String FormMime = "application/x-www-form-urlencoded";
  
  public static final String JsonMime = "application/json";
  
  private final UrlConverter converter;
  
  private OkHttpClient httpClient;
  
  public Client() {
    this(null, 10, 30, null, null);
  }
  
  public Client(ProxyConfiguration paramProxyConfiguration, int paramInt1, int paramInt2, UrlConverter paramUrlConverter, final Dns dns) {
    this.converter = paramUrlConverter;
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    if (paramProxyConfiguration != null) {
      builder.proxy(paramProxyConfiguration.proxy());
      if (paramProxyConfiguration.user != null && paramProxyConfiguration.password != null)
        builder.proxyAuthenticator(paramProxyConfiguration.authenticator()); 
    } 
    if (dns != null)
      builder.dns(new Dns() {
            public List<InetAddress> lookup(String param1String) throws UnknownHostException {
              try {
                return dns.lookup(param1String);
              } catch (Exception exception) {
                exception.printStackTrace();
                return Dns.SYSTEM.lookup(param1String);
              } 
            }
          }); 
    builder.networkInterceptors().add(new Interceptor() {
          public Response intercept(Interceptor.Chain param1Chain) throws IOException {
            String str;
            Request request = param1Chain.request();
            long l1 = System.currentTimeMillis();
            Response response = param1Chain.proceed(request);
            long l2 = System.currentTimeMillis();
            Client.ResponseTag responseTag = (Client.ResponseTag)request.tag();
            try {
              str = param1Chain.connection().socket().getRemoteSocketAddress().toString();
            } catch (Exception exception) {
              exception.printStackTrace();
              str = "";
            } 
            responseTag.ip = str;
            responseTag.duration = l2 - l1;
            return response;
          }
        });
    builder.connectTimeout(paramInt1, TimeUnit.SECONDS);
    builder.readTimeout(paramInt2, TimeUnit.SECONDS);
    builder.writeTimeout(0L, TimeUnit.SECONDS);
    this.httpClient = builder.build();
  }
  
  private void asyncMultipartPost(String paramString1, StringMap paramStringMap, UpToken paramUpToken, long paramLong, ProgressHandler paramProgressHandler, String paramString2, RequestBody paramRequestBody, CompletionHandler paramCompletionHandler, CancellationHandler paramCancellationHandler) {
    // Byte code:
    //   0: aload_0
    //   1: getfield converter : Lcom/qiniu/android/http/UrlConverter;
    //   4: ifnull -> 21
    //   7: aload_0
    //   8: getfield converter : Lcom/qiniu/android/http/UrlConverter;
    //   11: aload_1
    //   12: invokeinterface convert : (Ljava/lang/String;)Ljava/lang/String;
    //   17: astore_1
    //   18: goto -> 21
    //   21: new okhttp3/MultipartBody$Builder
    //   24: dup
    //   25: invokespecial <init> : ()V
    //   28: astore #11
    //   30: aload #11
    //   32: ldc 'file'
    //   34: aload #7
    //   36: aload #8
    //   38: invokevirtual addFormDataPart : (Ljava/lang/String;Ljava/lang/String;Lokhttp3/RequestBody;)Lokhttp3/MultipartBody$Builder;
    //   41: pop
    //   42: aload_2
    //   43: new com/qiniu/android/http/Client$6
    //   46: dup
    //   47: aload_0
    //   48: aload #11
    //   50: invokespecial <init> : (Lcom/qiniu/android/http/Client;Lokhttp3/MultipartBody$Builder;)V
    //   53: invokevirtual forEach : (Lcom/qiniu/android/utils/StringMap$Consumer;)V
    //   56: aload #11
    //   58: ldc 'multipart/form-data'
    //   60: invokestatic parse : (Ljava/lang/String;)Lokhttp3/MediaType;
    //   63: invokevirtual setType : (Lokhttp3/MediaType;)Lokhttp3/MultipartBody$Builder;
    //   66: pop
    //   67: aload #11
    //   69: invokevirtual build : ()Lokhttp3/MultipartBody;
    //   72: astore #7
    //   74: aload #6
    //   76: ifnonnull -> 87
    //   79: aload #7
    //   81: astore_2
    //   82: aload #10
    //   84: ifnull -> 103
    //   87: new com/qiniu/android/http/CountingRequestBody
    //   90: dup
    //   91: aload #7
    //   93: aload #6
    //   95: lload #4
    //   97: aload #10
    //   99: invokespecial <init> : (Lokhttp3/RequestBody;Lcom/qiniu/android/http/ProgressHandler;JLcom/qiniu/android/http/CancellationHandler;)V
    //   102: astore_2
    //   103: aload_0
    //   104: new okhttp3/Request$Builder
    //   107: dup
    //   108: invokespecial <init> : ()V
    //   111: aload_1
    //   112: invokevirtual url : (Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   115: aload_2
    //   116: invokevirtual post : (Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;
    //   119: aconst_null
    //   120: aload_3
    //   121: lload #4
    //   123: aload #9
    //   125: invokevirtual asyncSend : (Lokhttp3/Request$Builder;Lcom/qiniu/android/utils/StringMap;Lcom/qiniu/android/storage/UpToken;JLcom/qiniu/android/http/CompletionHandler;)V
    //   128: return
  }
  
  private static JSONObject buildJsonResp(byte[] paramArrayOfbyte) throws Exception {
    String str = new String(paramArrayOfbyte, "utf-8");
    return StringUtils.isNullOrEmpty(str) ? new JSONObject() : new JSONObject(str);
  }
  
  private static ResponseInfo buildResponseInfo(Response paramResponse, String paramString, long paramLong1, UpToken paramUpToken, long paramLong2) {
    String str2;
    byte[] arrayOfByte;
    int i = paramResponse.code();
    String str1 = paramResponse.header("X-Reqid");
    JSONObject jSONObject = null;
    if (str1 == null) {
      str2 = null;
    } else {
      str2 = str1.trim().split(",")[0];
    } 
    try {
      arrayOfByte = paramResponse.body().bytes();
      str1 = null;
    } catch (IOException iOException) {
      String str = iOException.getMessage();
      arrayOfByte = null;
    } 
    if (ctype(paramResponse).equals("application/json") && arrayOfByte != null) {
      try {
        jSONObject = buildJsonResp(arrayOfByte);
        try {
          if (paramResponse.code() != 200) {
            String str4 = new String();
            this(arrayOfByte, "utf-8");
            String str3 = jSONObject.optString("error", str4);
            str1 = str3;
          } 
        } catch (Exception null) {}
      } catch (Exception exception) {
        jSONObject = null;
      } 
      if (paramResponse.code() < 300)
        str1 = exception.getMessage(); 
    } 
    if (exception == null) {
      str1 = "null body";
    } else {
      str1 = new String((byte[])exception);
    } 
    HttpUrl httpUrl = paramResponse.request().url();
    return ResponseInfo.create(jSONObject, i, str2, paramResponse.header("X-Log"), via(paramResponse), httpUrl.host(), httpUrl.encodedPath(), paramString, httpUrl.port(), paramLong1, getContentLength(paramResponse), str1, paramUpToken, paramLong2);
  }
  
  private static String ctype(Response paramResponse) {
    MediaType mediaType = paramResponse.body().contentType();
    if (mediaType == null)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(mediaType.type());
    stringBuilder.append("/");
    stringBuilder.append(mediaType.subtype());
    return stringBuilder.toString();
  }
  
  private static long getContentLength(Response paramResponse) {
    try {
      RequestBody requestBody = paramResponse.request().body();
      return (requestBody == null) ? 0L : requestBody.contentLength();
    } catch (Throwable throwable) {
      return -1L;
    } 
  }
  
  private static void onRet(Response paramResponse, String paramString, long paramLong1, UpToken paramUpToken, long paramLong2, final CompletionHandler complete) {
    AsyncRun.runInMain(new Runnable() {
          public void run() {
            complete.complete(info, info.response);
          }
        });
  }
  
  private ResponseInfo send(final Request.Builder requestBuilder, StringMap paramStringMap) {
    if (paramStringMap != null)
      paramStringMap.forEach(new StringMap.Consumer() {
            public void accept(String param1String, Object param1Object) {
              requestBuilder.header(param1String, param1Object.toString());
            }
          }); 
    requestBuilder.header("User-Agent", UserAgent.instance().getUa(""));
    System.currentTimeMillis();
    ResponseTag responseTag = new ResponseTag();
    Request request = requestBuilder.tag(responseTag).build();
    try {
      Response response = this.httpClient.newCall(request).execute();
      return buildResponseInfo(response, responseTag.ip, responseTag.duration, UpToken.NULL, 0L);
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return ResponseInfo.create(null, -1, "", "", "", request.url().host(), request.url().encodedPath(), responseTag.ip, request.url().port(), responseTag.duration, -1L, iOException.getMessage(), UpToken.NULL, 0L);
    } 
  }
  
  private ResponseInfo syncMultipartPost(String paramString1, StringMap paramStringMap, UpToken paramUpToken, long paramLong, String paramString2, RequestBody paramRequestBody) {
    final MultipartBody.Builder mb = new MultipartBody.Builder();
    builder.addFormDataPart("file", paramString2, paramRequestBody);
    paramStringMap.forEach(new StringMap.Consumer() {
          public void accept(String param1String, Object param1Object) {
            mb.addFormDataPart(param1String, param1Object.toString());
          }
        });
    builder.setType(MediaType.parse("multipart/form-data"));
    MultipartBody multipartBody = builder.build();
    return syncSend((new Request.Builder()).url(paramString1).post((RequestBody)multipartBody), null, paramUpToken, paramLong);
  }
  
  private static String via(Response paramResponse) {
    String str2 = paramResponse.header("X-Via", "");
    if (!str2.equals(""))
      return str2; 
    str2 = paramResponse.header("X-Px", "");
    if (!str2.equals(""))
      return str2; 
    String str1 = paramResponse.header("Fw-Via", "");
    return !str1.equals("") ? str1 : str1;
  }
  
  public void asyncGet(String paramString, StringMap paramStringMap, UpToken paramUpToken, CompletionHandler paramCompletionHandler) {
    asyncSend((new Request.Builder()).get().url(paramString), paramStringMap, paramUpToken, 0L, paramCompletionHandler);
  }
  
  public void asyncMultipartPost(String paramString, PostArgs paramPostArgs, UpToken paramUpToken, ProgressHandler paramProgressHandler, CompletionHandler paramCompletionHandler, CancellationHandler paramCancellationHandler) {
    RequestBody requestBody;
    long l;
    if (paramPostArgs.file != null) {
      requestBody = RequestBody.create(MediaType.parse(paramPostArgs.mimeType), paramPostArgs.file);
      l = paramPostArgs.file.length();
    } else {
      requestBody = RequestBody.create(MediaType.parse(paramPostArgs.mimeType), paramPostArgs.data);
      l = paramPostArgs.data.length;
    } 
    asyncMultipartPost(paramString, paramPostArgs.params, paramUpToken, l, paramProgressHandler, paramPostArgs.fileName, requestBody, paramCompletionHandler, paramCancellationHandler);
  }
  
  public void asyncPost(String paramString, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, StringMap paramStringMap, UpToken paramUpToken, long paramLong, ProgressHandler paramProgressHandler, CompletionHandler paramCompletionHandler, CancellationHandler paramCancellationHandler) {
    RequestBody requestBody;
    String str;
    if (this.converter != null) {
      str = this.converter.convert(paramString);
    } else {
      str = paramString;
    } 
    if (paramArrayOfbyte != null && paramArrayOfbyte.length > 0) {
      MediaType mediaType2 = MediaType.parse("application/octet-stream");
      MediaType mediaType1 = mediaType2;
      if (paramStringMap != null) {
        Object object = paramStringMap.get("Content-Type");
        mediaType1 = mediaType2;
        if (object != null)
          mediaType1 = MediaType.parse(object.toString()); 
      } 
      requestBody = RequestBody.create(mediaType1, paramArrayOfbyte, paramInt1, paramInt2);
    } else {
      requestBody = RequestBody.create(null, new byte[0]);
    } 
    if (paramProgressHandler != null || paramCancellationHandler != null)
      requestBody = new CountingRequestBody(requestBody, paramProgressHandler, paramLong, paramCancellationHandler); 
    asyncSend((new Request.Builder()).url(str).post(requestBody), paramStringMap, paramUpToken, paramLong, paramCompletionHandler);
  }
  
  public void asyncPost(String paramString, byte[] paramArrayOfbyte, StringMap paramStringMap, UpToken paramUpToken, long paramLong, ProgressHandler paramProgressHandler, CompletionHandler paramCompletionHandler, UpCancellationSignal paramUpCancellationSignal) {
    asyncPost(paramString, paramArrayOfbyte, 0, paramArrayOfbyte.length, paramStringMap, paramUpToken, paramLong, paramProgressHandler, paramCompletionHandler, (CancellationHandler)paramUpCancellationSignal);
  }
  
  public void asyncSend(final Request.Builder requestBuilder, StringMap paramStringMap, final UpToken upToken, final long totalSize, final CompletionHandler complete) {
    if (paramStringMap != null)
      paramStringMap.forEach(new StringMap.Consumer() {
            public void accept(String param1String, Object param1Object) {
              requestBuilder.header(param1String, param1Object.toString());
            }
          }); 
    if (upToken != null) {
      requestBuilder.header("User-Agent", UserAgent.instance().getUa(upToken.accessKey));
    } else {
      requestBuilder.header("User-Agent", UserAgent.instance().getUa("pandora"));
    } 
    final ResponseTag tag = new ResponseTag();
    this.httpClient.newCall(requestBuilder.tag(responseTag).build()).enqueue(new Callback() {
          public void onFailure(Call param1Call, IOException param1IOException) {
            byte b;
            param1IOException.printStackTrace();
            String str = param1IOException.getMessage();
            if (param1IOException instanceof CancellationHandler.CancellationException) {
              b = -2;
            } else if (param1IOException instanceof UnknownHostException) {
              b = -1003;
            } else if (str != null && str.indexOf("Broken pipe") == 0) {
              b = -1005;
            } else if (param1IOException instanceof java.net.SocketTimeoutException) {
              b = -1001;
            } else if (param1IOException instanceof java.net.ConnectException) {
              b = -1004;
            } else {
              b = -1;
            } 
            HttpUrl httpUrl = param1Call.request().url();
            ResponseInfo responseInfo = ResponseInfo.create(null, b, "", "", "", httpUrl.host(), httpUrl.encodedPath(), "", httpUrl.port(), tag.duration, -1L, param1IOException.getMessage(), upToken, totalSize);
            complete.complete(responseInfo, null);
          }
          
          public void onResponse(Call param1Call, Response param1Response) throws IOException {
            Client.ResponseTag responseTag = (Client.ResponseTag)param1Response.request().tag();
            Client.onRet(param1Response, responseTag.ip, responseTag.duration, upToken, totalSize, complete);
          }
        });
  }
  
  public ResponseInfo syncGet(String paramString, StringMap paramStringMap) {
    return send((new Request.Builder()).get().url(paramString), paramStringMap);
  }
  
  public ResponseInfo syncMultipartPost(String paramString, PostArgs paramPostArgs, UpToken paramUpToken) {
    RequestBody requestBody;
    long l;
    if (paramPostArgs.file != null) {
      requestBody = RequestBody.create(MediaType.parse(paramPostArgs.mimeType), paramPostArgs.file);
      l = paramPostArgs.file.length();
    } else {
      requestBody = RequestBody.create(MediaType.parse(paramPostArgs.mimeType), paramPostArgs.data);
      l = paramPostArgs.data.length;
    } 
    return syncMultipartPost(paramString, paramPostArgs.params, paramUpToken, l, paramPostArgs.fileName, requestBody);
  }
  
  public ResponseInfo syncSend(final Request.Builder requestBuilder, StringMap paramStringMap, UpToken paramUpToken, long paramLong) {
    byte b;
    if (paramStringMap != null)
      paramStringMap.forEach(new StringMap.Consumer() {
            public void accept(String param1String, Object param1Object) {
              requestBuilder.header(param1String, param1Object.toString());
            }
          }); 
    requestBuilder.header("User-Agent", UserAgent.instance().getUa(paramUpToken.accessKey));
    ResponseTag responseTag = new ResponseTag();
    try {
      Request request = requestBuilder.tag(responseTag).build();
      try {
        return buildResponseInfo(this.httpClient.newCall(request).execute(), responseTag.ip, responseTag.duration, paramUpToken, paramLong);
      } catch (Exception null) {}
    } catch (Exception exception) {
      paramStringMap = null;
    } 
    exception.printStackTrace();
    String str = exception.getMessage();
    if (exception instanceof UnknownHostException) {
      b = -1003;
    } else if (str != null && str.indexOf("Broken pipe") == 0) {
      b = -1005;
    } else if (exception instanceof java.net.SocketTimeoutException) {
      b = -1001;
    } else if (exception instanceof java.net.ConnectException) {
      b = -1004;
    } else {
      b = -1;
    } 
    HttpUrl httpUrl = paramStringMap.url();
    return ResponseInfo.create(null, b, "", "", "", httpUrl.host(), httpUrl.encodedPath(), "", httpUrl.port(), 0L, 0L, exception.getMessage(), paramUpToken, paramLong);
  }
  
  private static class ResponseTag {
    public long duration = -1L;
    
    public String ip = "";
    
    private ResponseTag() {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\http\Client.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */