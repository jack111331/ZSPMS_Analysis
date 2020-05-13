package com.aliyun.sls.android.sdk.core;

import com.aliyun.sls.android.sdk.ClientConfiguration;
import com.aliyun.sls.android.sdk.LogException;
import com.aliyun.sls.android.sdk.ResponseParsers;
import com.aliyun.sls.android.sdk.SLSLog;
import com.aliyun.sls.android.sdk.core.auth.CredentialProvider;
import com.aliyun.sls.android.sdk.core.auth.FederationToken;
import com.aliyun.sls.android.sdk.core.auth.PlainTextAKSKCredentialProvider;
import com.aliyun.sls.android.sdk.core.auth.StsTokenCredentialProvider;
import com.aliyun.sls.android.sdk.core.callback.CompletedCallback;
import com.aliyun.sls.android.sdk.core.http.HttpMethod;
import com.aliyun.sls.android.sdk.core.parser.ResponseParser;
import com.aliyun.sls.android.sdk.model.LogGroup;
import com.aliyun.sls.android.sdk.request.PostLogRequest;
import com.aliyun.sls.android.sdk.result.PostLogResult;
import com.aliyun.sls.android.sdk.utils.Utils;
import com.aliyun.sls.android.sdk.utils.VersionInfoUtils;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

public class RequestOperation {
  private static ExecutorService executorService = Executors.newFixedThreadPool(5);
  
  private CredentialProvider credentialProvider;
  
  private volatile URI endpoint;
  
  private OkHttpClient innerClient;
  
  private int maxRetryCount = 2;
  
  public RequestOperation(final URI endpoint, CredentialProvider paramCredentialProvider, ClientConfiguration paramClientConfiguration) {
    this.endpoint = endpoint;
    this.credentialProvider = paramCredentialProvider;
    OkHttpClient.Builder builder = (new OkHttpClient.Builder()).followRedirects(false).followSslRedirects(false).retryOnConnectionFailure(false).cache(null).hostnameVerifier(new HostnameVerifier() {
          public boolean verify(String param1String, SSLSession param1SSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(endpoint.getHost(), param1SSLSession);
          }
        });
    if (paramClientConfiguration != null) {
      Dispatcher dispatcher = new Dispatcher();
      dispatcher.setMaxRequests(paramClientConfiguration.getMaxConcurrentRequest());
      builder.connectTimeout(paramClientConfiguration.getConnectionTimeout(), TimeUnit.MILLISECONDS).readTimeout(paramClientConfiguration.getSocketTimeout(), TimeUnit.MILLISECONDS).writeTimeout(paramClientConfiguration.getSocketTimeout(), TimeUnit.MILLISECONDS).dispatcher(dispatcher);
      if (paramClientConfiguration.getProxyHost() != null && paramClientConfiguration.getProxyPort() != 0)
        builder.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(paramClientConfiguration.getProxyHost(), paramClientConfiguration.getProxyPort()))); 
      this.maxRetryCount = paramClientConfiguration.getMaxErrorRetry();
    } 
    this.innerClient = builder.build();
  }
  
  private void buildHeaders(PostLogRequest paramPostLogRequest, RequestMessage paramRequestMessage) throws LogException {
    StringBuilder stringBuilder = null;
    if (paramPostLogRequest != null && paramRequestMessage != null) {
      LogGroup logGroup = paramPostLogRequest.mLogGroup;
      String str2 = paramPostLogRequest.mLogStoreName;
      String str3 = paramPostLogRequest.mProject;
      String str1 = paramPostLogRequest.logContentType;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str3);
      stringBuilder1.append(".");
      stringBuilder1.append(this.endpoint.getHost());
      String str4 = stringBuilder1.toString();
      Map<String, String> map = paramRequestMessage.headers;
      map.put("x-log-apiversion", "0.6.0");
      map.put("x-log-signaturemethod", "hmac-sha1");
      map.put("x-log-compresstype", "deflate");
      map.put("Content-Type", str1);
      map.put("Date", Utils.GetMGTTime());
      map.put("Host", str4);
      try {
        FederationToken federationToken;
        String str5;
        String str7;
        byte[] arrayOfByte2 = logGroup.LogGroupToJsonString().getBytes("UTF-8");
        byte[] arrayOfByte1 = Utils.GzipFrom(arrayOfByte2);
        paramRequestMessage.setUploadData(arrayOfByte1);
        map.put("Content-MD5", Utils.ParseToMd5U32(arrayOfByte1));
        map.put("Content-Length", String.valueOf(arrayOfByte1.length));
        map.put("x-log-bodyrawsize", String.valueOf(arrayOfByte2.length));
        StringBuilder stringBuilder5 = new StringBuilder("POST\n");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(map.get("Content-MD5"));
        stringBuilder2.append("\n");
        stringBuilder5.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(map.get("Content-Type"));
        stringBuilder2.append("\n");
        stringBuilder5.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(map.get("Date"));
        stringBuilder2.append("\n");
        stringBuilder5.append(stringBuilder2.toString());
        stringBuilder2 = stringBuilder;
        if (this.credentialProvider instanceof StsTokenCredentialProvider)
          federationToken = ((StsTokenCredentialProvider)this.credentialProvider).getFederationToken(); 
        if (federationToken == null) {
          str7 = "";
        } else {
          str7 = federationToken.getSecurityToken();
        } 
        if (str7 != null && str7 != "") {
          map.put("x-acs-security-token", str7);
          stringBuilder = new StringBuilder();
          stringBuilder.append("x-acs-security-token:");
          stringBuilder.append(str7);
          stringBuilder.append("\n");
          stringBuilder5.append(stringBuilder.toString());
        } 
        stringBuilder5.append("x-log-apiversion:0.6.0\n");
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("x-log-bodyrawsize:");
        stringBuilder4.append(map.get("x-log-bodyrawsize"));
        stringBuilder4.append("\n");
        stringBuilder5.append(stringBuilder4.toString());
        stringBuilder5.append("x-log-compresstype:deflate\n");
        stringBuilder5.append("x-log-signaturemethod:hmac-sha1\n");
        stringBuilder4 = new StringBuilder();
        stringBuilder4.append("/logstores/");
        stringBuilder4.append(str2);
        stringBuilder4.append("/shards/lb");
        stringBuilder5.append(stringBuilder4.toString());
        String str8 = stringBuilder5.toString();
        String str6 = "---initValue---";
        if (this.credentialProvider instanceof StsTokenCredentialProvider) {
          str5 = Utils.sign(federationToken.getTempAK(), federationToken.getTempSK(), str8);
        } else {
          str5 = str6;
          if (this.credentialProvider instanceof PlainTextAKSKCredentialProvider)
            str5 = Utils.sign(((PlainTextAKSKCredentialProvider)this.credentialProvider).getAccessKeyId(), ((PlainTextAKSKCredentialProvider)this.credentialProvider).getAccessKeySecret(), str8); 
        } 
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("signed content: ");
        stringBuilder3.append(str8);
        stringBuilder3.append("   \n ---------   signature: ");
        stringBuilder3.append(str5);
        SLSLog.logDebug(stringBuilder3.toString(), false);
        map.put("Authorization", str5);
        map.put("User-Agent", VersionInfoUtils.getUserAgent());
        return;
      } catch (Exception exception) {
        throw new LogException("", "postLogRequest or requestMessage is not null", null, "");
      } 
    } 
    throw new LogException("", "postLogRequest or requestMessage when buildheaders is not null", null, "");
  }
  
  private void buildUrl(PostLogRequest paramPostLogRequest, RequestMessage paramRequestMessage) throws LogException {
    if (paramPostLogRequest != null && paramRequestMessage != null) {
      String str2 = paramPostLogRequest.mLogStoreName;
      String str3 = paramPostLogRequest.mProject;
      String str1 = this.endpoint.getScheme();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str3);
      stringBuilder2.append(".");
      stringBuilder2.append(this.endpoint.getHost());
      String str4 = stringBuilder2.toString();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append("://");
      stringBuilder1.append(str4);
      stringBuilder1.append("/logstores/");
      stringBuilder1.append(str2);
      stringBuilder1.append("/shards/lb");
      paramRequestMessage.url = stringBuilder1.toString();
      paramRequestMessage.method = HttpMethod.POST;
      return;
    } 
    throw new LogException("", "postLogRequest or requestMessage when buildUrl is not null", null, "");
  }
  
  public OkHttpClient getInnerClient() {
    return this.innerClient;
  }
  
  public AsyncTask<PostLogResult> postLog(PostLogRequest paramPostLogRequest, CompletedCallback<PostLogRequest, PostLogResult> paramCompletedCallback) throws LogException {
    RequestMessage requestMessage = new RequestMessage();
    try {
      buildUrl(paramPostLogRequest, requestMessage);
      buildHeaders(paramPostLogRequest, requestMessage);
      ResponseParsers.PostLogResponseParser postLogResponseParser = new ResponseParsers.PostLogResponseParser();
      ExecutionContext<PostLogRequest> executionContext = new ExecutionContext<PostLogRequest>(getInnerClient(), paramPostLogRequest);
      if (paramCompletedCallback != null)
        executionContext.setCompletedCallback(paramCompletedCallback); 
      RequestTask<Result> requestTask = new RequestTask<Result>(requestMessage, (ResponseParser)postLogResponseParser, executionContext, this.maxRetryCount);
      return AsyncTask.wrapRequestTask(executorService.submit(requestTask), executionContext);
    } catch (LogException logException) {
      throw logException;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\core\RequestOperation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */