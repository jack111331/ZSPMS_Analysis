package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.a.f;
import com.tencent.tauth.IRequestListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpUtils {
  private static int a(Context paramContext) {
    int i = -1;
    if (Build.VERSION.SDK_INT < 11) {
      if (paramContext != null) {
        i = Proxy.getPort(paramContext);
        int k = i;
        if (i < 0)
          k = Proxy.getDefaultPort(); 
        return k;
      } 
      return Proxy.getDefaultPort();
    } 
    String str = System.getProperty("http.proxyPort");
    int j = i;
    if (!TextUtils.isEmpty(str))
      try {
        j = Integer.parseInt(str);
      } catch (NumberFormatException numberFormatException) {
        j = i;
      }  
    return j;
  }
  
  private static String a(HttpResponse paramHttpResponse) throws IllegalStateException, IOException {
    InputStream inputStream1;
    InputStream inputStream2 = paramHttpResponse.getEntity().getContent();
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    Header header = paramHttpResponse.getFirstHeader("Content-Encoding");
    if (header != null && header.getValue().toLowerCase().indexOf("gzip") > -1) {
      inputStream1 = new GZIPInputStream(inputStream2);
    } else {
      inputStream1 = inputStream2;
    } 
    byte[] arrayOfByte = new byte[512];
    while (true) {
      int i = inputStream1.read(arrayOfByte);
      if (i != -1) {
        byteArrayOutputStream.write(arrayOfByte, 0, i);
        continue;
      } 
      String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
      inputStream1.close();
      return str;
    } 
  }
  
  private static void a(Context paramContext, QQToken paramQQToken, String paramString) {
    if (paramString.indexOf("add_share") > -1 || paramString.indexOf("upload_pic") > -1 || paramString.indexOf("add_topic") > -1 || paramString.indexOf("set_user_face") > -1 || paramString.indexOf("add_t") > -1 || paramString.indexOf("add_pic_t") > -1 || paramString.indexOf("add_pic_url") > -1 || paramString.indexOf("add_video") > -1)
      com.tencent.connect.a.a.a(paramContext, paramQQToken, "requireApi", new String[] { paramString }); 
  }
  
  private static String b(Context paramContext) {
    if (Build.VERSION.SDK_INT < 11) {
      if (paramContext != null) {
        String str2 = Proxy.getHost(paramContext);
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
          str1 = Proxy.getDefaultHost(); 
        return str1;
      } 
      return Proxy.getDefaultHost();
    } 
    return System.getProperty("http.proxyHost");
  }
  
  public static String encodePostBody(Bundle paramBundle, String paramString) {
    if (paramBundle == null)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    int i = paramBundle.size();
    Iterator<String> iterator = paramBundle.keySet().iterator();
    byte b = -1;
    while (iterator.hasNext()) {
      String str = iterator.next();
      b++;
      Object object = paramBundle.get(str);
      if (!(object instanceof String))
        continue; 
      stringBuilder.append("Content-Disposition: form-data; name=\"" + str + "\"" + "\r\n" + "\r\n" + (String)object);
      if (b < i - 1)
        stringBuilder.append("\r\n--" + paramString + "\r\n"); 
    } 
    return stringBuilder.toString();
  }
  
  public static String encodeUrl(Bundle paramBundle) {
    if (paramBundle == null)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<String> iterator = paramBundle.keySet().iterator();
    byte b = 1;
    while (iterator.hasNext()) {
      String str = iterator.next();
      Object object = paramBundle.get(str);
      if (object instanceof String || object instanceof String[]) {
        String[] arrayOfString;
        if (object instanceof String[]) {
          byte b1;
          if (b) {
            b1 = 0;
          } else {
            stringBuilder.append("&");
            b1 = b;
          } 
          stringBuilder.append(URLEncoder.encode(str) + "=");
          arrayOfString = paramBundle.getStringArray(str);
          b = b1;
          if (arrayOfString != null) {
            for (b = 0; b < arrayOfString.length; b++) {
              if (b == 0) {
                stringBuilder.append(URLEncoder.encode(arrayOfString[b]));
              } else {
                stringBuilder.append(URLEncoder.encode("," + arrayOfString[b]));
              } 
            } 
            b = b1;
          } 
          continue;
        } 
        if (b != 0) {
          b = 0;
        } else {
          stringBuilder.append("&");
        } 
        stringBuilder.append(URLEncoder.encode((String)arrayOfString) + "=" + URLEncoder.encode(paramBundle.getString((String)arrayOfString)));
      } 
    } 
    return stringBuilder.toString();
  }
  
  public static int getErrorCodeFromException(IOException paramIOException) {
    return (paramIOException instanceof java.io.CharConversionException) ? -20 : ((paramIOException instanceof java.nio.charset.MalformedInputException) ? -21 : ((paramIOException instanceof java.nio.charset.UnmappableCharacterException) ? -22 : ((paramIOException instanceof org.apache.http.client.HttpResponseException) ? -23 : ((paramIOException instanceof java.nio.channels.ClosedChannelException) ? -24 : ((paramIOException instanceof org.apache.http.ConnectionClosedException) ? -25 : ((paramIOException instanceof java.io.EOFException) ? -26 : ((paramIOException instanceof java.nio.channels.FileLockInterruptionException) ? -27 : ((paramIOException instanceof java.io.FileNotFoundException) ? -28 : ((paramIOException instanceof java.net.HttpRetryException) ? -29 : ((paramIOException instanceof ConnectTimeoutException) ? -7 : ((paramIOException instanceof SocketTimeoutException) ? -8 : ((paramIOException instanceof java.util.InvalidPropertiesFormatException) ? -30 : ((paramIOException instanceof org.apache.http.MalformedChunkCodingException) ? -31 : ((paramIOException instanceof MalformedURLException) ? -3 : ((paramIOException instanceof org.apache.http.NoHttpResponseException) ? -32 : ((paramIOException instanceof java.io.InvalidClassException) ? -33 : ((paramIOException instanceof java.io.InvalidObjectException) ? -34 : ((paramIOException instanceof java.io.NotActiveException) ? -35 : ((paramIOException instanceof java.io.NotSerializableException) ? -36 : ((paramIOException instanceof java.io.OptionalDataException) ? -37 : ((paramIOException instanceof java.io.StreamCorruptedException) ? -38 : ((paramIOException instanceof java.io.WriteAbortedException) ? -39 : ((paramIOException instanceof java.net.ProtocolException) ? -40 : ((paramIOException instanceof javax.net.ssl.SSLHandshakeException) ? -41 : ((paramIOException instanceof javax.net.ssl.SSLKeyException) ? -42 : ((paramIOException instanceof javax.net.ssl.SSLPeerUnverifiedException) ? -43 : ((paramIOException instanceof javax.net.ssl.SSLProtocolException) ? -44 : ((paramIOException instanceof java.net.BindException) ? -45 : ((paramIOException instanceof java.net.ConnectException) ? -46 : ((paramIOException instanceof java.net.NoRouteToHostException) ? -47 : ((paramIOException instanceof java.net.PortUnreachableException) ? -48 : ((paramIOException instanceof java.io.SyncFailedException) ? -49 : ((paramIOException instanceof java.io.UTFDataFormatException) ? -50 : ((paramIOException instanceof UnknownHostException) ? -51 : ((paramIOException instanceof java.net.UnknownServiceException) ? -52 : ((paramIOException instanceof java.io.UnsupportedEncodingException) ? -53 : ((paramIOException instanceof java.util.zip.ZipException) ? -54 : -2)))))))))))))))))))))))))))))))))))));
  }
  
  public static HttpClient getHttpClient(Context paramContext, String paramString1, String paramString2) {
    int i = 0;
    SchemeRegistry schemeRegistry = new SchemeRegistry();
    schemeRegistry.register(new Scheme("http", (SocketFactory)PlainSocketFactory.getSocketFactory(), 80));
    if (Build.VERSION.SDK_INT < 16) {
      try {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        a a = new a();
        this(keyStore);
        a.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        Scheme scheme = new Scheme();
        this("https", (SocketFactory)a, 443);
        schemeRegistry.register(scheme);
      } catch (Exception exception) {
        schemeRegistry.register(new Scheme("https", (SocketFactory)SSLSocketFactory.getSocketFactory(), 443));
      } 
    } else {
      schemeRegistry.register(new Scheme("https", (SocketFactory)SSLSocketFactory.getSocketFactory(), 443));
    } 
    BasicHttpParams basicHttpParams = new BasicHttpParams();
    if (paramContext != null) {
      e e = e.a(paramContext, paramString1);
    } else {
      paramString1 = null;
    } 
    if (paramString1 != null) {
      j = paramString1.a("Common_HttpConnectionTimeout");
      i = paramString1.a("Common_SocketConnectionTimeout");
    } else {
      j = 0;
    } 
    int k = j;
    if (!j)
      k = 15000; 
    int j = i;
    if (i == 0)
      j = 30000; 
    HttpConnectionParams.setConnectionTimeout((HttpParams)basicHttpParams, k);
    HttpConnectionParams.setSoTimeout((HttpParams)basicHttpParams, j);
    HttpProtocolParams.setVersion((HttpParams)basicHttpParams, (ProtocolVersion)HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset((HttpParams)basicHttpParams, "UTF-8");
    HttpProtocolParams.setUserAgent((HttpParams)basicHttpParams, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
    DefaultHttpClient defaultHttpClient = new DefaultHttpClient((ClientConnectionManager)new ThreadSafeClientConnManager((HttpParams)basicHttpParams, schemeRegistry), (HttpParams)basicHttpParams);
    c c = getProxy(paramContext);
    if (c != null) {
      HttpHost httpHost = new HttpHost(c.a, c.b);
      defaultHttpClient.getParams().setParameter("http.route.default-proxy", httpHost);
    } 
    return (HttpClient)defaultHttpClient;
  }
  
  public static c getProxy(Context paramContext) {
    if (paramContext == null)
      return null; 
    ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (connectivityManager == null)
      return null; 
    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
    if (networkInfo == null)
      return null; 
    if (networkInfo.getType() == 0) {
      String str = b(paramContext);
      int i = a(paramContext);
      if (!TextUtils.isEmpty(str) && i >= 0)
        return new c(str, i); 
    } 
    return null;
  }
  
  public static i.a openUrl2(Context paramContext, String paramString1, String paramString2, Bundle paramBundle) throws MalformedURLException, IOException, NetworkUnavailableException, HttpStatusException {
    boolean bool;
    if (paramContext != null) {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager != null) {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isAvailable())
          throw new NetworkUnavailableException("network unavailable"); 
      } 
    } 
    if (paramBundle != null) {
      paramBundle = new Bundle(paramBundle);
    } else {
      paramBundle = new Bundle();
    } 
    String str = paramBundle.getString("appid_for_getting_config");
    paramBundle.remove("appid_for_getting_config");
    HttpClient httpClient = getHttpClient(paramContext, str, paramString1);
    if (paramString2.equals("GET")) {
      String str1;
      paramString2 = encodeUrl(paramBundle);
      bool = paramString2.length();
      f.a("openSDK_LOG.HttpUtils", "-->openUrl2 before url =" + paramString1);
      if (paramString1.indexOf("?") == -1) {
        str1 = paramString1 + "?";
      } else {
        str1 = paramString1 + "&";
      } 
      f.a("openSDK_LOG.HttpUtils", "-->openUrl2 encodedParam =" + paramString2 + " -- url = " + str1);
      HttpGet httpGet = new HttpGet(str1 + paramString2);
      httpGet.addHeader("Accept-Encoding", "gzip");
      bool += 0;
    } else if (paramString2.equals("POST")) {
      HttpPost httpPost = new HttpPost(paramString1);
      httpPost.addHeader("Accept-Encoding", "gzip");
      Bundle bundle = new Bundle();
      for (String str1 : paramBundle.keySet()) {
        Object object = paramBundle.get(str1);
        if (object instanceof byte[])
          bundle.putByteArray(str1, (byte[])object); 
      } 
      if (!paramBundle.containsKey("method"))
        paramBundle.putString("method", paramString2); 
      httpPost.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
      httpPost.setHeader("Connection", "Keep-Alive");
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      byteArrayOutputStream.write(i.i("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
      byteArrayOutputStream.write(i.i(encodePostBody(paramBundle, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
      if (!bundle.isEmpty()) {
        int k = bundle.size();
        byteArrayOutputStream.write(i.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
        Iterator<String> iterator = bundle.keySet().iterator();
        int j = -1;
        while (iterator.hasNext()) {
          String str1 = iterator.next();
          int m = j + 1;
          byteArrayOutputStream.write(i.i("Content-Disposition: form-data; name=\"" + str1 + "\"; filename=\"" + str1 + "\"" + "\r\n"));
          byteArrayOutputStream.write(i.i("Content-Type: content/unknown\r\n\r\n"));
          byte[] arrayOfByte1 = bundle.getByteArray(str1);
          if (arrayOfByte1 != null)
            byteArrayOutputStream.write(arrayOfByte1); 
          j = m;
          if (m < k - 1) {
            byteArrayOutputStream.write(i.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
            j = m;
          } 
        } 
      } 
      byteArrayOutputStream.write(i.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
      bool = arrayOfByte.length + 0;
      byteArrayOutputStream.close();
      httpPost.setEntity((HttpEntity)new ByteArrayEntity(arrayOfByte));
    } else {
      paramContext = null;
      bool = false;
    } 
    HttpResponse httpResponse = httpClient.execute((HttpUriRequest)paramContext);
    int i = httpResponse.getStatusLine().getStatusCode();
    if (i == 200)
      return new i.a(a(httpResponse), bool); 
    throw new HttpStatusException("http status code error:" + i);
  }
  
  public static JSONObject request(QQToken paramQQToken, Context paramContext, String paramString1, Bundle paramBundle, String paramString2) throws IOException, JSONException, NetworkUnavailableException, HttpStatusException {
    // Byte code:
    //   0: ldc_w 'openSDK_LOG.HttpUtils'
    //   3: ldc_w 'OpenApi request'
    //   6: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_2
    //   10: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   13: ldc_w 'http'
    //   16: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   19: ifne -> 550
    //   22: new java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial <init> : ()V
    //   29: invokestatic a : ()Lcom/tencent/open/utils/f;
    //   32: aload_1
    //   33: ldc_w 'https://openmobile.qq.com/'
    //   36: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_2
    //   43: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual toString : ()Ljava/lang/String;
    //   49: astore #5
    //   51: new java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial <init> : ()V
    //   58: invokestatic a : ()Lcom/tencent/open/utils/f;
    //   61: aload_1
    //   62: ldc_w 'https://openmobile.qq.com/'
    //   65: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_2
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual toString : ()Ljava/lang/String;
    //   78: astore #6
    //   80: aload_1
    //   81: aload_0
    //   82: aload_2
    //   83: invokestatic a : (Landroid/content/Context;Lcom/tencent/connect/auth/QQToken;Ljava/lang/String;)V
    //   86: invokestatic elapsedRealtime : ()J
    //   89: lstore #7
    //   91: aload_1
    //   92: aload_0
    //   93: invokevirtual getAppId : ()Ljava/lang/String;
    //   96: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/open/utils/e;
    //   99: ldc_w 'Common_HttpRetryCount'
    //   102: invokevirtual a : (Ljava/lang/String;)I
    //   105: istore #9
    //   107: ldc_w 'OpenConfig_test'
    //   110: new java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial <init> : ()V
    //   117: ldc_w 'config 1:Common_HttpRetryCount            config_value:'
    //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: iload #9
    //   125: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   128: ldc_w '   appid:'
    //   131: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_0
    //   135: invokevirtual getAppId : ()Ljava/lang/String;
    //   138: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc_w '     url:'
    //   144: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload #6
    //   149: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual toString : ()Ljava/lang/String;
    //   155: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   158: iload #9
    //   160: ifne -> 291
    //   163: iconst_3
    //   164: istore #9
    //   166: ldc_w 'OpenConfig_test'
    //   169: new java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial <init> : ()V
    //   176: ldc_w 'config 1:Common_HttpRetryCount            result_value:'
    //   179: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: iload #9
    //   184: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   187: ldc_w '   appid:'
    //   190: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_0
    //   194: invokevirtual getAppId : ()Ljava/lang/String;
    //   197: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w '     url:'
    //   203: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload #6
    //   208: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual toString : ()Ljava/lang/String;
    //   214: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   217: iconst_0
    //   218: istore #10
    //   220: aconst_null
    //   221: astore_0
    //   222: iload #10
    //   224: iconst_1
    //   225: iadd
    //   226: istore #11
    //   228: aload_1
    //   229: aload #5
    //   231: aload #4
    //   233: aload_3
    //   234: invokestatic openUrl2 : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Lcom/tencent/open/utils/i$a;
    //   237: astore #12
    //   239: aload #12
    //   241: getfield a : Ljava/lang/String;
    //   244: invokestatic d : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   247: astore_2
    //   248: aload_2
    //   249: ldc_w 'ret'
    //   252: invokevirtual getInt : (Ljava/lang/String;)I
    //   255: istore #10
    //   257: aload #12
    //   259: getfield b : J
    //   262: lstore #13
    //   264: aload #12
    //   266: getfield c : J
    //   269: lstore #15
    //   271: aload_2
    //   272: astore_0
    //   273: invokestatic a : ()Lcom/tencent/open/b/g;
    //   276: aload #6
    //   278: lload #7
    //   280: lload #13
    //   282: lload #15
    //   284: iload #10
    //   286: invokevirtual a : (Ljava/lang/String;JJJI)V
    //   289: aload_0
    //   290: areturn
    //   291: goto -> 166
    //   294: astore_0
    //   295: bipush #-4
    //   297: istore #10
    //   299: goto -> 257
    //   302: astore #12
    //   304: aload_2
    //   305: astore_0
    //   306: aload #12
    //   308: astore_2
    //   309: aload_2
    //   310: invokevirtual printStackTrace : ()V
    //   313: bipush #-7
    //   315: istore #10
    //   317: iload #11
    //   319: iload #9
    //   321: if_icmpge -> 345
    //   324: invokestatic elapsedRealtime : ()J
    //   327: lstore #7
    //   329: lconst_0
    //   330: lstore #15
    //   332: iload #11
    //   334: iload #9
    //   336: if_icmplt -> 543
    //   339: lconst_0
    //   340: lstore #13
    //   342: goto -> 273
    //   345: invokestatic a : ()Lcom/tencent/open/b/g;
    //   348: aload #6
    //   350: lload #7
    //   352: lconst_0
    //   353: lconst_0
    //   354: bipush #-7
    //   356: invokevirtual a : (Ljava/lang/String;JJJI)V
    //   359: aload_2
    //   360: athrow
    //   361: astore #12
    //   363: aload_2
    //   364: astore_0
    //   365: aload #12
    //   367: astore_2
    //   368: aload_2
    //   369: invokevirtual printStackTrace : ()V
    //   372: bipush #-8
    //   374: istore #10
    //   376: iload #11
    //   378: iload #9
    //   380: if_icmpge -> 391
    //   383: invokestatic elapsedRealtime : ()J
    //   386: lstore #7
    //   388: goto -> 329
    //   391: invokestatic a : ()Lcom/tencent/open/b/g;
    //   394: aload #6
    //   396: lload #7
    //   398: lconst_0
    //   399: lconst_0
    //   400: bipush #-8
    //   402: invokevirtual a : (Ljava/lang/String;JJJI)V
    //   405: aload_2
    //   406: athrow
    //   407: astore_0
    //   408: aload_0
    //   409: invokevirtual printStackTrace : ()V
    //   412: aload_0
    //   413: invokevirtual getMessage : ()Ljava/lang/String;
    //   416: astore_1
    //   417: aload_1
    //   418: ldc_w 'http status code error:'
    //   421: ldc ''
    //   423: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   426: invokestatic parseInt : (Ljava/lang/String;)I
    //   429: istore #10
    //   431: invokestatic a : ()Lcom/tencent/open/b/g;
    //   434: aload #6
    //   436: lload #7
    //   438: lconst_0
    //   439: lconst_0
    //   440: iload #10
    //   442: invokevirtual a : (Ljava/lang/String;JJJI)V
    //   445: aload_0
    //   446: athrow
    //   447: astore_1
    //   448: aload_1
    //   449: invokevirtual printStackTrace : ()V
    //   452: bipush #-9
    //   454: istore #10
    //   456: goto -> 431
    //   459: astore_0
    //   460: aload_0
    //   461: invokevirtual printStackTrace : ()V
    //   464: aload_0
    //   465: athrow
    //   466: astore_0
    //   467: aload_0
    //   468: invokevirtual printStackTrace : ()V
    //   471: invokestatic a : ()Lcom/tencent/open/b/g;
    //   474: aload #6
    //   476: lload #7
    //   478: lconst_0
    //   479: lconst_0
    //   480: bipush #-3
    //   482: invokevirtual a : (Ljava/lang/String;JJJI)V
    //   485: aload_0
    //   486: athrow
    //   487: astore_0
    //   488: aload_0
    //   489: invokevirtual printStackTrace : ()V
    //   492: aload_0
    //   493: invokestatic getErrorCodeFromException : (Ljava/io/IOException;)I
    //   496: istore #10
    //   498: invokestatic a : ()Lcom/tencent/open/b/g;
    //   501: aload #6
    //   503: lload #7
    //   505: lconst_0
    //   506: lconst_0
    //   507: iload #10
    //   509: invokevirtual a : (Ljava/lang/String;JJJI)V
    //   512: aload_0
    //   513: athrow
    //   514: astore_0
    //   515: aload_0
    //   516: invokevirtual printStackTrace : ()V
    //   519: invokestatic a : ()Lcom/tencent/open/b/g;
    //   522: aload #6
    //   524: lload #7
    //   526: lconst_0
    //   527: lconst_0
    //   528: bipush #-4
    //   530: invokevirtual a : (Ljava/lang/String;JJJI)V
    //   533: aload_0
    //   534: athrow
    //   535: astore_2
    //   536: goto -> 368
    //   539: astore_2
    //   540: goto -> 309
    //   543: iload #11
    //   545: istore #10
    //   547: goto -> 222
    //   550: aload_2
    //   551: astore #6
    //   553: aload_2
    //   554: astore #5
    //   556: goto -> 80
    // Exception table:
    //   from	to	target	type
    //   228	248	539	org/apache/http/conn/ConnectTimeoutException
    //   228	248	535	java/net/SocketTimeoutException
    //   228	248	407	com/tencent/open/utils/HttpUtils$HttpStatusException
    //   228	248	459	com/tencent/open/utils/HttpUtils$NetworkUnavailableException
    //   228	248	466	java/net/MalformedURLException
    //   228	248	487	java/io/IOException
    //   228	248	514	org/json/JSONException
    //   248	257	294	org/json/JSONException
    //   248	257	302	org/apache/http/conn/ConnectTimeoutException
    //   248	257	361	java/net/SocketTimeoutException
    //   248	257	407	com/tencent/open/utils/HttpUtils$HttpStatusException
    //   248	257	459	com/tencent/open/utils/HttpUtils$NetworkUnavailableException
    //   248	257	466	java/net/MalformedURLException
    //   248	257	487	java/io/IOException
    //   257	271	302	org/apache/http/conn/ConnectTimeoutException
    //   257	271	361	java/net/SocketTimeoutException
    //   257	271	407	com/tencent/open/utils/HttpUtils$HttpStatusException
    //   257	271	459	com/tencent/open/utils/HttpUtils$NetworkUnavailableException
    //   257	271	466	java/net/MalformedURLException
    //   257	271	487	java/io/IOException
    //   257	271	514	org/json/JSONException
    //   417	431	447	java/lang/Exception
  }
  
  public static void requestAsync(QQToken paramQQToken, Context paramContext, String paramString1, Bundle paramBundle, String paramString2, IRequestListener paramIRequestListener) {
    f.a("openSDK_LOG.HttpUtils", "OpenApi requestAsync");
    (new Thread(paramQQToken, paramContext, paramString1, paramBundle, paramString2, paramIRequestListener) {
        public void run() {
          try {
            JSONObject jSONObject = HttpUtils.request(this.a, this.b, this.c, this.d, this.e);
            if (this.f != null) {
              this.f.onComplete(jSONObject);
              f.b("openSDK_LOG.HttpUtils", "OpenApi onComplete");
            } 
          } catch (MalformedURLException malformedURLException) {
            if (this.f != null) {
              this.f.onMalformedURLException(malformedURLException);
              f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync MalformedURLException", malformedURLException);
            } 
          } catch (ConnectTimeoutException connectTimeoutException) {
            if (this.f != null) {
              this.f.onConnectTimeoutException(connectTimeoutException);
              f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onConnectTimeoutException", (Throwable)connectTimeoutException);
            } 
          } catch (SocketTimeoutException socketTimeoutException) {
            if (this.f != null) {
              this.f.onSocketTimeoutException(socketTimeoutException);
              f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onSocketTimeoutException", socketTimeoutException);
            } 
          } catch (NetworkUnavailableException networkUnavailableException) {
            if (this.f != null) {
              this.f.onNetworkUnavailableException(networkUnavailableException);
              f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onNetworkUnavailableException", networkUnavailableException);
            } 
          } catch (HttpStatusException httpStatusException) {
            if (this.f != null) {
              this.f.onHttpStatusException(httpStatusException);
              f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onHttpStatusException", httpStatusException);
            } 
          } catch (IOException iOException) {
            if (this.f != null) {
              this.f.onIOException(iOException);
              f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync IOException", iOException);
            } 
          } catch (JSONException jSONException) {
            if (this.f != null) {
              this.f.onJSONException(jSONException);
              f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync JSONException", (Throwable)jSONException);
            } 
          } catch (Exception exception) {}
        }
      }).start();
  }
  
  public static class HttpStatusException extends Exception {
    public static final String ERROR_INFO = "http status code error:";
    
    public HttpStatusException(String param1String) {
      super(param1String);
    }
  }
  
  public static class NetworkUnavailableException extends Exception {
    public static final String ERROR_INFO = "network unavailable";
    
    public NetworkUnavailableException(String param1String) {
      super(param1String);
    }
  }
  
  public static class a extends SSLSocketFactory {
    private final SSLContext a = SSLContext.getInstance("TLS");
    
    public a(KeyStore param1KeyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
      super(param1KeyStore);
      try {
        HttpUtils.b b = new HttpUtils.b();
        this();
      } catch (Exception exception) {
        exception = null;
      } 
      this.a.init(null, new TrustManager[] { (TrustManager)exception }, null);
    }
    
    public Socket createSocket() throws IOException {
      return this.a.getSocketFactory().createSocket();
    }
    
    public Socket createSocket(Socket param1Socket, String param1String, int param1Int, boolean param1Boolean) throws IOException, UnknownHostException {
      return this.a.getSocketFactory().createSocket(param1Socket, param1String, param1Int, param1Boolean);
    }
  }
  
  public static class b implements X509TrustManager {
    X509TrustManager a;
    
    b() throws Exception {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial <init> : ()V
      //   4: ldc 'JKS'
      //   6: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/KeyStore;
      //   9: astore_1
      //   10: aload_1
      //   11: ifnull -> 115
      //   14: new java/io/FileInputStream
      //   17: astore_2
      //   18: aload_2
      //   19: ldc 'trustedCerts'
      //   21: invokespecial <init> : (Ljava/lang/String;)V
      //   24: aload_1
      //   25: aload_2
      //   26: ldc 'passphrase'
      //   28: invokevirtual toCharArray : ()[C
      //   31: invokevirtual load : (Ljava/io/InputStream;[C)V
      //   34: ldc 'SunX509'
      //   36: ldc 'SunJSSE'
      //   38: invokestatic getInstance : (Ljava/lang/String;Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
      //   41: astore_3
      //   42: aload_3
      //   43: aload_1
      //   44: invokevirtual init : (Ljava/security/KeyStore;)V
      //   47: aload_3
      //   48: invokevirtual getTrustManagers : ()[Ljavax/net/ssl/TrustManager;
      //   51: astore_3
      //   52: aload_3
      //   53: astore_1
      //   54: aload_2
      //   55: ifnull -> 64
      //   58: aload_2
      //   59: invokevirtual close : ()V
      //   62: aload_3
      //   63: astore_1
      //   64: iconst_0
      //   65: istore #4
      //   67: iload #4
      //   69: aload_1
      //   70: arraylength
      //   71: if_icmpge -> 144
      //   74: aload_1
      //   75: iload #4
      //   77: aaload
      //   78: instanceof javax/net/ssl/X509TrustManager
      //   81: ifeq -> 138
      //   84: aload_0
      //   85: aload_1
      //   86: iload #4
      //   88: aaload
      //   89: checkcast javax/net/ssl/X509TrustManager
      //   92: putfield a : Ljavax/net/ssl/X509TrustManager;
      //   95: return
      //   96: astore_1
      //   97: aconst_null
      //   98: astore_1
      //   99: goto -> 10
      //   102: astore_1
      //   103: aconst_null
      //   104: astore_3
      //   105: aload_3
      //   106: ifnull -> 113
      //   109: aload_3
      //   110: invokevirtual close : ()V
      //   113: aload_1
      //   114: athrow
      //   115: invokestatic getDefaultAlgorithm : ()Ljava/lang/String;
      //   118: invokestatic getInstance : (Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
      //   121: astore_1
      //   122: aload_1
      //   123: aconst_null
      //   124: checkcast java/security/KeyStore
      //   127: invokevirtual init : (Ljava/security/KeyStore;)V
      //   130: aload_1
      //   131: invokevirtual getTrustManagers : ()[Ljavax/net/ssl/TrustManager;
      //   134: astore_1
      //   135: goto -> 64
      //   138: iinc #4, 1
      //   141: goto -> 67
      //   144: new java/lang/Exception
      //   147: dup
      //   148: ldc 'Couldn't initialize'
      //   150: invokespecial <init> : (Ljava/lang/String;)V
      //   153: athrow
      //   154: astore_1
      //   155: aload_2
      //   156: astore_3
      //   157: goto -> 105
      // Exception table:
      //   from	to	target	type
      //   4	10	96	java/lang/Exception
      //   14	24	102	finally
      //   24	52	154	finally
    }
    
    public void checkClientTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {
      this.a.checkClientTrusted(param1ArrayOfX509Certificate, param1String);
    }
    
    public void checkServerTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {
      this.a.checkServerTrusted(param1ArrayOfX509Certificate, param1String);
    }
    
    public X509Certificate[] getAcceptedIssuers() {
      return this.a.getAcceptedIssuers();
    }
  }
  
  public static class c {
    public final String a;
    
    public final int b;
    
    private c(String param1String, int param1Int) {
      this.a = param1String;
      this.b = param1Int;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\ope\\utils\HttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */