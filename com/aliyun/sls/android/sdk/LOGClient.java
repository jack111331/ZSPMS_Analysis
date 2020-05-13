package com.aliyun.sls.android.sdk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.sls.android.sdk.core.AsyncTask;
import com.aliyun.sls.android.sdk.core.RequestOperation;
import com.aliyun.sls.android.sdk.core.auth.CredentialProvider;
import com.aliyun.sls.android.sdk.core.callback.CompletedCallback;
import com.aliyun.sls.android.sdk.model.LogGroup;
import com.aliyun.sls.android.sdk.request.PostLogRequest;
import com.aliyun.sls.android.sdk.result.PostLogResult;
import com.aliyun.sls.android.sdk.utils.Base64Kit;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.Deflater;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class LOGClient {
  private URI endpointURI;
  
  private String mAccessKeyID;
  
  private String mAccessKeySecret;
  
  private String mAccessToken;
  
  private String mEndPoint;
  
  private String mHttpType;
  
  private String mProject;
  
  private RequestOperation requestOperation;
  
  public LOGClient(String paramString, CredentialProvider paramCredentialProvider, ClientConfiguration paramClientConfiguration) {
    try {
      String str1;
      String str2 = paramString.trim();
      paramString = str2;
      if (!str2.startsWith("http")) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("http://");
        stringBuilder.append(str2);
        str1 = stringBuilder.toString();
      } 
      URI uRI = new URI();
      this(str1);
      this.endpointURI = uRI;
      if (paramCredentialProvider != null) {
        uRI = this.endpointURI;
        ClientConfiguration clientConfiguration = paramClientConfiguration;
        if (paramClientConfiguration == null)
          clientConfiguration = ClientConfiguration.getDefaultConf(); 
        this.requestOperation = new RequestOperation(uRI, paramCredentialProvider, clientConfiguration);
        return;
      } 
      throw new IllegalArgumentException("CredentialProvider can't be null.");
    } catch (URISyntaxException uRISyntaxException) {
      throw new IllegalArgumentException("Endpoint must be a string like 'http://cn-****.log.aliyuncs.com',or your cname like 'http://image.cnamedomain.com'!");
    } 
  }
  
  public LOGClient(String paramString1, String paramString2, String paramString3, String paramString4) {
    this.mHttpType = "http://";
    if (paramString1 != "") {
      this.mEndPoint = paramString1;
      if (this.mEndPoint.startsWith("http://")) {
        this.mEndPoint = this.mEndPoint.substring(7);
      } else if (this.mEndPoint.startsWith("https://")) {
        this.mEndPoint = this.mEndPoint.substring(8);
        this.mHttpType = "https://";
      } 
      while (this.mEndPoint.endsWith("/"))
        this.mEndPoint = this.mEndPoint.substring(0, this.mEndPoint.length() - 1); 
      if (paramString2 != "") {
        this.mAccessKeyID = paramString2;
        if (paramString3 != "") {
          this.mAccessKeySecret = paramString3;
          if (paramString4 != "") {
            this.mProject = paramString4;
            this.mAccessToken = "";
            return;
          } 
          throw new NullPointerException("projectName is null");
        } 
        throw new NullPointerException("accessKeySecret is null");
      } 
      throw new NullPointerException("accessKeyID is null");
    } 
    throw new NullPointerException("endpoint is null");
  }
  
  private void CheckError(String paramString1, String paramString2) throws LogException {
    try {
      JSONObject jSONObject = JSON.parseObject(paramString1);
      if (jSONObject != null && jSONObject.containsKey("errorCode") && jSONObject.containsKey("errorMessage")) {
        LogException logException = new LogException();
        this(jSONObject.getString("errorCode"), jSONObject.getString("errorMessage"), paramString2);
        throw logException;
      } 
    } catch (JSONException jSONException) {}
  }
  
  public static String GetMGTTime() {
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return simpleDateFormat.format(calendar.getTime());
  }
  
  private byte[] GzipFrom(byte[] paramArrayOfbyte) throws LogException {
    Deflater deflater = new Deflater();
    Exception exception = null;
    ByteArrayOutputStream byteArrayOutputStream1 = null;
    ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream1;
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      byteArrayOutputStream2 = byteArrayOutputStream1;
    } catch (Exception exception1) {
    
    } finally {
      deflater.end();
      try {
        if (byteArrayOutputStream2.size() != 0)
          byteArrayOutputStream2.close(); 
      } catch (IOException iOException) {}
    } 
    byte[] arrayOfByte = paramArrayOfbyte;
    LogException logException = new LogException();
    arrayOfByte = paramArrayOfbyte;
    this("LogClientError", "fail to zip data", "");
    arrayOfByte = paramArrayOfbyte;
    throw logException;
  }
  
  private String ParseToMd5U32From(byte[] paramArrayOfbyte) throws LogException {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      BigInteger bigInteger = new BigInteger();
      this(1, messageDigest.digest(paramArrayOfbyte));
      String str = bigInteger.toString(16).toUpperCase();
      StringBuilder stringBuilder2 = new StringBuilder();
      this();
      for (byte b = 0; str.length() + b < 32; b++)
        stringBuilder2.append("0"); 
      StringBuilder stringBuilder1 = new StringBuilder();
      this();
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder1.append(str);
      return stringBuilder1.toString();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new LogException("LogClientError", "Not Supported signature method MD5", noSuchAlgorithmException, "");
    } 
  }
  
  public static String hmac_sha1(String paramString1, String paramString2) throws Exception {
    byte[] arrayOfByte2 = paramString2.getBytes("UTF-8");
    byte[] arrayOfByte1 = paramString1.getBytes("UTF-8");
    Mac mac = Mac.getInstance("HmacSHA1");
    mac.init(new SecretKeySpec(arrayOfByte2, "HmacSHA1"));
    return new String(Base64Kit.encode(mac.doFinal(arrayOfByte1)));
  }
  
  public String GetEndPoint() {
    return this.mEndPoint;
  }
  
  public Map<String, String> GetHttpHeadersFrom(String paramString, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) throws LogException {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("x-log-apiversion", "0.6.0");
    hashMap.put("x-log-signaturemethod", "hmac-sha1");
    hashMap.put("Content-Type", "application/json");
    hashMap.put("Date", GetMGTTime());
    hashMap.put("Content-MD5", ParseToMd5U32From(paramArrayOfbyte2));
    hashMap.put("Content-Length", String.valueOf(paramArrayOfbyte2.length));
    hashMap.put("x-log-bodyrawsize", String.valueOf(paramArrayOfbyte1.length));
    hashMap.put("x-log-compresstype", "deflate");
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.mProject);
    stringBuilder1.append(".");
    stringBuilder1.append(this.mEndPoint);
    hashMap.put("Host", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder("POST\n");
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append((String)hashMap.get("Content-MD5"));
    stringBuilder3.append("\n");
    stringBuilder1.append(stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append((String)hashMap.get("Content-Type"));
    stringBuilder3.append("\n");
    stringBuilder1.append(stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append((String)hashMap.get("Date"));
    stringBuilder3.append("\n");
    stringBuilder1.append(stringBuilder3.toString());
    String str = this.mAccessToken;
    if (str != null && str != "") {
      hashMap.put("x-acs-security-token", str);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("x-acs-security-token:");
      stringBuilder.append((String)hashMap.get("x-acs-security-token"));
      stringBuilder.append("\n");
      stringBuilder1.append(stringBuilder.toString());
    } 
    stringBuilder1.append("x-log-apiversion:0.6.0\n");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("x-log-bodyrawsize:");
    stringBuilder2.append((String)hashMap.get("x-log-bodyrawsize"));
    stringBuilder2.append("\n");
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder1.append("x-log-compresstype:deflate\n");
    stringBuilder1.append("x-log-signaturemethod:hmac-sha1\n");
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("/logstores/");
    stringBuilder2.append(paramString);
    stringBuilder2.append("/shards/lb");
    stringBuilder1.append(stringBuilder2.toString());
    paramString = stringBuilder1.toString();
    try {
      paramString = hmac_sha1(paramString, this.mAccessKeySecret);
      stringBuilder1 = new StringBuilder();
      this();
      stringBuilder1.append("LOG ");
      stringBuilder1.append(this.mAccessKeyID);
      stringBuilder1.append(":");
      stringBuilder1.append(paramString);
      hashMap.put("Authorization", stringBuilder1.toString());
      return (Map)hashMap;
    } catch (Exception exception) {
      throw new LogException("LogClientError", "fail to get encode signature", exception, "");
    } 
  }
  
  public String GetKeyID() {
    return this.mAccessKeyID;
  }
  
  public String GetKeySecret() {
    return this.mAccessKeySecret;
  }
  
  public String GetToken() {
    return this.mAccessToken;
  }
  
  public void HttpPostRequest(String paramString, Map<String, String> paramMap, byte[] paramArrayOfbyte) throws LogException {
    try {
      URL uRL = new URL(paramString);
      try {
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        try {
          httpURLConnection.setRequestMethod("POST");
          httpURLConnection.setDoOutput(true);
          for (Map.Entry<String, String> entry : paramMap.entrySet())
            httpURLConnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue()); 
          try {
            DataOutputStream dataOutputStream = new DataOutputStream();
            this(httpURLConnection.getOutputStream());
            dataOutputStream.write(paramArrayOfbyte);
            dataOutputStream.flush();
            dataOutputStream.close();
            try {
              int i = httpURLConnection.getResponseCode();
              String str = httpURLConnection.getHeaderField("x-log-requestid");
              paramString = str;
              if (str == null)
                paramString = ""; 
              if (i != 200) {
                InputStream inputStream = httpURLConnection.getErrorStream();
                if (inputStream != null) {
                  BufferedReader bufferedReader = new BufferedReader();
                  InputStreamReader inputStreamReader = new InputStreamReader();
                  this(inputStream);
                  this(inputStreamReader);
                  StringBuffer stringBuffer = new StringBuffer();
                  this();
                  while (true) {
                    String str1 = bufferedReader.readLine();
                    if (str1 != null) {
                      stringBuffer.append(str1);
                      continue;
                    } 
                    bufferedReader.close();
                    CheckError(stringBuffer.toString(), paramString);
                    LogException logException1 = new LogException();
                    StringBuilder stringBuilder1 = new StringBuilder();
                    this();
                    stringBuilder1.append("Response code:");
                    stringBuilder1.append(String.valueOf(i));
                    stringBuilder1.append("\nMessage:");
                    stringBuilder1.append(stringBuffer.toString());
                    this("LogServerError", stringBuilder1.toString(), paramString);
                    throw logException1;
                  } 
                } 
                LogException logException = new LogException();
                StringBuilder stringBuilder = new StringBuilder();
                this();
                stringBuilder.append("Response code:");
                stringBuilder.append(String.valueOf(i));
                stringBuilder.append("\nMessage: fail to connect to the server");
                this("LogServerError", stringBuilder.toString(), paramString);
                throw logException;
              } 
              return;
            } catch (IOException iOException) {
              throw new LogException("LogServerError", "Failed to parse response data", "");
            } 
          } catch (IOException iOException1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("fail to post data to URL:");
            stringBuilder.append((String)iOException);
            throw new LogException("LogClientError", stringBuilder.toString(), iOException1, "");
          } 
        } catch (ProtocolException protocolException) {
          throw new LogException("LogClientError", "fail to set http request method to  POST", protocolException, "");
        } 
      } catch (IOException iOException) {
        throw new LogException("LogClientError", "fail to create HttpURLConnection", iOException, "");
      } 
    } catch (MalformedURLException malformedURLException) {
      throw new LogException("LogClientError", "illegal post url", malformedURLException, "");
    } 
  }
  
  public void PostLog(LogGroup paramLogGroup, String paramString) throws LogException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.mHttpType);
    stringBuilder.append(this.mProject);
    stringBuilder.append(".");
    stringBuilder.append(this.mEndPoint);
    stringBuilder.append("/logstores/");
    stringBuilder.append(paramString);
    stringBuilder.append("/shards/lb");
    String str = stringBuilder.toString();
    try {
      byte[] arrayOfByte2 = paramLogGroup.LogGroupToJsonString().getBytes("UTF-8");
      byte[] arrayOfByte1 = GzipFrom(arrayOfByte2);
      HttpPostRequest(str, GetHttpHeadersFrom(paramString, arrayOfByte2, arrayOfByte1), arrayOfByte1);
      return;
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new LogException("LogClientError", "Failed to pass log to utf-8 bytes", unsupportedEncodingException, "");
    } 
  }
  
  public void SetToken(String paramString) {
    this.mAccessToken = paramString;
  }
  
  public AsyncTask<PostLogResult> asyncPostLog(PostLogRequest paramPostLogRequest, CompletedCallback<PostLogRequest, PostLogResult> paramCompletedCallback) throws LogException {
    return this.requestOperation.postLog(paramPostLogRequest, paramCompletedCallback);
  }
  
  public PostLogResult syncPostLog(PostLogRequest paramPostLogRequest, CompletedCallback<PostLogRequest, PostLogResult> paramCompletedCallback) throws LogException {
    return (PostLogResult)this.requestOperation.postLog(paramPostLogRequest, paramCompletedCallback).getResult();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\LOGClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */