package com.sina.weibo.sdk.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.Utility;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Iterator;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.RedirectHandler;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

class HttpManager {
  private static final String BOUNDARY = getBoundry();
  
  private static final int BUFFER_SIZE = 8192;
  
  private static final int CONNECTION_TIMEOUT = 25000;
  
  private static final String END_MP_BOUNDARY;
  
  private static final String HTTP_METHOD_GET = "GET";
  
  private static final String HTTP_METHOD_POST = "POST";
  
  private static final String MP_BOUNDARY;
  
  private static final String MULTIPART_FORM_DATA = "multipart/form-data";
  
  private static final int SOCKET_TIMEOUT = 20000;
  
  private static final String TAG = "HttpManager";
  
  private static SSLSocketFactory sSSLSocketFactory;
  
  static {
    StringBuilder stringBuilder = new StringBuilder("--");
    stringBuilder.append(BOUNDARY);
    MP_BOUNDARY = stringBuilder.toString();
    stringBuilder = new StringBuilder("--");
    stringBuilder.append(BOUNDARY);
    stringBuilder.append("--");
    END_MP_BOUNDARY = stringBuilder.toString();
  }
  
  private static void buildParams(OutputStream paramOutputStream, WeiboParameters paramWeiboParameters) throws WeiboException {
    try {
      Set<String> set = paramWeiboParameters.keySet();
      Iterator<String> iterator = set.iterator();
      while (true) {
        StringBuilder stringBuilder;
        Object object;
        if (!iterator.hasNext()) {
          Iterator<String> iterator1 = set.iterator();
          while (true) {
            ByteArrayOutputStream byteArrayOutputStream;
            if (!iterator1.hasNext()) {
              stringBuilder = new StringBuilder();
              this("\r\n");
              stringBuilder.append(END_MP_BOUNDARY);
              paramOutputStream.write(stringBuilder.toString().getBytes());
              return;
            } 
            String str1 = iterator1.next();
            object = stringBuilder.get(str1);
            if (object instanceof Bitmap) {
              StringBuilder stringBuilder1 = new StringBuilder();
              this();
              stringBuilder1.append(MP_BOUNDARY);
              stringBuilder1.append("\r\n");
              stringBuilder1.append("content-disposition: form-data; name=\"");
              stringBuilder1.append(str1);
              stringBuilder1.append("\"; filename=\"file\"\r\n");
              stringBuilder1.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
              paramOutputStream.write(stringBuilder1.toString().getBytes());
              object = object;
              byteArrayOutputStream = new ByteArrayOutputStream();
              this();
              object.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
              paramOutputStream.write(byteArrayOutputStream.toByteArray());
              paramOutputStream.write("\r\n".getBytes());
              continue;
            } 
            if (object instanceof ByteArrayOutputStream) {
              StringBuilder stringBuilder1 = new StringBuilder();
              this();
              stringBuilder1.append(MP_BOUNDARY);
              stringBuilder1.append("\r\n");
              stringBuilder1.append("content-disposition: form-data; name=\"");
              stringBuilder1.append((String)byteArrayOutputStream);
              stringBuilder1.append("\"; filename=\"file\"\r\n");
              stringBuilder1.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
              paramOutputStream.write(stringBuilder1.toString().getBytes());
              byteArrayOutputStream = (ByteArrayOutputStream)object;
              paramOutputStream.write(byteArrayOutputStream.toByteArray());
              paramOutputStream.write("\r\n".getBytes());
              byteArrayOutputStream.close();
            } 
          } 
          break;
        } 
        String str = object.next();
        if (stringBuilder.get(str) instanceof String) {
          StringBuilder stringBuilder1 = new StringBuilder();
          this(100);
          stringBuilder1.setLength(0);
          stringBuilder1.append(MP_BOUNDARY);
          stringBuilder1.append("\r\n");
          stringBuilder1.append("content-disposition: form-data; name=\"");
          stringBuilder1.append(str);
          stringBuilder1.append("\"\r\n\r\n");
          stringBuilder1.append(stringBuilder.get(str));
          stringBuilder1.append("\r\n");
          paramOutputStream.write(stringBuilder1.toString().getBytes());
        } 
      } 
    } catch (IOException iOException) {
      throw new WeiboException(iOException);
    } 
  }
  
  private static native String calcOauthSignNative(Context paramContext, String paramString1, String paramString2);
  
  public static String downloadFile(Context paramContext, String paramString1, String paramString2, String paramString3) throws WeiboException {
    // Byte code:
    //   0: ldc com/sina/weibo/sdk/net/HttpManager
    //   2: monitorenter
    //   3: new java/io/File
    //   6: astore_0
    //   7: aload_0
    //   8: aload_2
    //   9: invokespecial <init> : (Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual exists : ()Z
    //   16: ifne -> 24
    //   19: aload_0
    //   20: invokevirtual mkdirs : ()Z
    //   23: pop
    //   24: new java/io/File
    //   27: astore #4
    //   29: aload #4
    //   31: aload_0
    //   32: aload_3
    //   33: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   36: aload #4
    //   38: invokevirtual exists : ()Z
    //   41: ifeq -> 55
    //   44: aload #4
    //   46: invokevirtual getPath : ()Ljava/lang/String;
    //   49: astore_0
    //   50: ldc com/sina/weibo/sdk/net/HttpManager
    //   52: monitorexit
    //   53: aload_0
    //   54: areturn
    //   55: aload_1
    //   56: invokestatic isValidUrl : (Ljava/lang/String;)Z
    //   59: ifne -> 68
    //   62: ldc com/sina/weibo/sdk/net/HttpManager
    //   64: monitorexit
    //   65: ldc ''
    //   67: areturn
    //   68: invokestatic getNewHttpClient : ()Lorg/apache/http/client/HttpClient;
    //   71: astore #5
    //   73: new java/io/File
    //   76: astore #6
    //   78: new java/lang/StringBuilder
    //   81: astore_0
    //   82: aload_0
    //   83: aload_3
    //   84: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   87: invokespecial <init> : (Ljava/lang/String;)V
    //   90: aload_0
    //   91: ldc '_temp'
    //   93: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload #6
    //   99: aload_2
    //   100: aload_0
    //   101: invokevirtual toString : ()Ljava/lang/String;
    //   104: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload #6
    //   109: invokevirtual exists : ()Z
    //   112: ifeq -> 125
    //   115: aload #6
    //   117: invokevirtual length : ()J
    //   120: lstore #7
    //   122: goto -> 134
    //   125: aload #6
    //   127: invokevirtual createNewFile : ()Z
    //   130: pop
    //   131: lconst_0
    //   132: lstore #7
    //   134: new org/apache/http/client/methods/HttpGet
    //   137: astore_0
    //   138: aload_0
    //   139: aload_1
    //   140: invokespecial <init> : (Ljava/lang/String;)V
    //   143: new java/lang/StringBuilder
    //   146: astore_1
    //   147: aload_1
    //   148: ldc 'bytes='
    //   150: invokespecial <init> : (Ljava/lang/String;)V
    //   153: aload_1
    //   154: lload #7
    //   156: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_1
    //   161: ldc '-'
    //   163: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_0
    //   168: ldc 'RANGE'
    //   170: aload_1
    //   171: invokevirtual toString : ()Ljava/lang/String;
    //   174: invokevirtual setHeader : (Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload #5
    //   179: aload_0
    //   180: invokeinterface execute : (Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   185: astore_0
    //   186: aload_0
    //   187: invokeinterface getStatusLine : ()Lorg/apache/http/StatusLine;
    //   192: invokeinterface getStatusCode : ()I
    //   197: istore #9
    //   199: iload #9
    //   201: sipush #206
    //   204: if_icmpne -> 260
    //   207: aload_0
    //   208: ldc 'Content-Range'
    //   210: invokeinterface getHeaders : (Ljava/lang/String;)[Lorg/apache/http/Header;
    //   215: astore_1
    //   216: aload_1
    //   217: ifnull -> 254
    //   220: aload_1
    //   221: arraylength
    //   222: ifeq -> 254
    //   225: aload_1
    //   226: iconst_0
    //   227: aaload
    //   228: invokeinterface getValue : ()Ljava/lang/String;
    //   233: astore_1
    //   234: aload_1
    //   235: aload_1
    //   236: bipush #47
    //   238: invokevirtual indexOf : (I)I
    //   241: iconst_1
    //   242: iadd
    //   243: invokevirtual substring : (I)Ljava/lang/String;
    //   246: invokestatic parseLong : (Ljava/lang/String;)J
    //   249: lstore #10
    //   251: goto -> 310
    //   254: lconst_0
    //   255: lstore #10
    //   257: goto -> 310
    //   260: iload #9
    //   262: sipush #200
    //   265: if_icmpne -> 554
    //   268: aload_0
    //   269: ldc_w 'Content-Length'
    //   272: invokeinterface getFirstHeader : (Ljava/lang/String;)Lorg/apache/http/Header;
    //   277: astore_1
    //   278: aload_1
    //   279: ifnull -> 303
    //   282: aload_1
    //   283: invokeinterface getValue : ()Ljava/lang/String;
    //   288: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   291: invokevirtual intValue : ()I
    //   294: i2l
    //   295: lstore #10
    //   297: lconst_0
    //   298: lstore #7
    //   300: goto -> 310
    //   303: lconst_0
    //   304: lstore #7
    //   306: lload #7
    //   308: lstore #10
    //   310: aload_0
    //   311: invokeinterface getEntity : ()Lorg/apache/http/HttpEntity;
    //   316: astore_1
    //   317: aload_0
    //   318: ldc_w 'Content-Encoding'
    //   321: invokeinterface getFirstHeader : (Ljava/lang/String;)Lorg/apache/http/Header;
    //   326: astore_0
    //   327: aload_0
    //   328: ifnull -> 367
    //   331: aload_0
    //   332: invokeinterface getValue : ()Ljava/lang/String;
    //   337: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   340: ldc_w 'gzip'
    //   343: invokevirtual indexOf : (Ljava/lang/String;)I
    //   346: iconst_m1
    //   347: if_icmple -> 367
    //   350: new java/util/zip/GZIPInputStream
    //   353: astore_0
    //   354: aload_0
    //   355: aload_1
    //   356: invokeinterface getContent : ()Ljava/io/InputStream;
    //   361: invokespecial <init> : (Ljava/io/InputStream;)V
    //   364: goto -> 374
    //   367: aload_1
    //   368: invokeinterface getContent : ()Ljava/io/InputStream;
    //   373: astore_0
    //   374: new java/io/RandomAccessFile
    //   377: astore_2
    //   378: aload_2
    //   379: aload #6
    //   381: ldc_w 'rw'
    //   384: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   387: aload_2
    //   388: lload #7
    //   390: invokevirtual seek : (J)V
    //   393: sipush #1024
    //   396: newarray byte
    //   398: astore_1
    //   399: aload_0
    //   400: aload_1
    //   401: invokevirtual read : ([B)I
    //   404: istore #9
    //   406: iload #9
    //   408: iconst_m1
    //   409: if_icmpne -> 543
    //   412: aload_2
    //   413: invokevirtual close : ()V
    //   416: aload_0
    //   417: invokevirtual close : ()V
    //   420: lload #10
    //   422: lconst_0
    //   423: lcmp
    //   424: ifeq -> 495
    //   427: aload #6
    //   429: invokevirtual length : ()J
    //   432: lload #10
    //   434: lcmp
    //   435: ifge -> 441
    //   438: goto -> 495
    //   441: aload #6
    //   443: aload #4
    //   445: invokevirtual renameTo : (Ljava/io/File;)Z
    //   448: pop
    //   449: aload #4
    //   451: invokevirtual getPath : ()Ljava/lang/String;
    //   454: astore_0
    //   455: aload #5
    //   457: ifnull -> 490
    //   460: aload #5
    //   462: invokeinterface getConnectionManager : ()Lorg/apache/http/conn/ClientConnectionManager;
    //   467: invokeinterface closeExpiredConnections : ()V
    //   472: aload #5
    //   474: invokeinterface getConnectionManager : ()Lorg/apache/http/conn/ClientConnectionManager;
    //   479: ldc2_w 300
    //   482: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   485: invokeinterface closeIdleConnections : (JLjava/util/concurrent/TimeUnit;)V
    //   490: ldc com/sina/weibo/sdk/net/HttpManager
    //   492: monitorexit
    //   493: aload_0
    //   494: areturn
    //   495: aload #6
    //   497: invokevirtual delete : ()Z
    //   500: pop
    //   501: aload #5
    //   503: ifnull -> 619
    //   506: aload #5
    //   508: invokeinterface getConnectionManager : ()Lorg/apache/http/conn/ClientConnectionManager;
    //   513: invokeinterface closeExpiredConnections : ()V
    //   518: aload #5
    //   520: invokeinterface getConnectionManager : ()Lorg/apache/http/conn/ClientConnectionManager;
    //   525: astore_0
    //   526: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   529: astore_1
    //   530: aload_0
    //   531: ldc2_w 300
    //   534: aload_1
    //   535: invokeinterface closeIdleConnections : (JLjava/util/concurrent/TimeUnit;)V
    //   540: goto -> 619
    //   543: aload_2
    //   544: aload_1
    //   545: iconst_0
    //   546: iload #9
    //   548: invokevirtual write : ([BII)V
    //   551: goto -> 399
    //   554: aload_0
    //   555: invokestatic readRsponse : (Lorg/apache/http/HttpResponse;)Ljava/lang/String;
    //   558: astore_0
    //   559: new com/sina/weibo/sdk/exception/WeiboHttpException
    //   562: astore_1
    //   563: aload_1
    //   564: aload_0
    //   565: iload #9
    //   567: invokespecial <init> : (Ljava/lang/String;I)V
    //   570: aload_1
    //   571: athrow
    //   572: astore_0
    //   573: goto -> 625
    //   576: astore_0
    //   577: aload_0
    //   578: invokevirtual printStackTrace : ()V
    //   581: aload #6
    //   583: invokevirtual delete : ()Z
    //   586: pop
    //   587: aload #5
    //   589: ifnull -> 619
    //   592: aload #5
    //   594: invokeinterface getConnectionManager : ()Lorg/apache/http/conn/ClientConnectionManager;
    //   599: invokeinterface closeExpiredConnections : ()V
    //   604: aload #5
    //   606: invokeinterface getConnectionManager : ()Lorg/apache/http/conn/ClientConnectionManager;
    //   611: astore_0
    //   612: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   615: astore_1
    //   616: goto -> 530
    //   619: ldc com/sina/weibo/sdk/net/HttpManager
    //   621: monitorexit
    //   622: ldc ''
    //   624: areturn
    //   625: aload #5
    //   627: ifnull -> 660
    //   630: aload #5
    //   632: invokeinterface getConnectionManager : ()Lorg/apache/http/conn/ClientConnectionManager;
    //   637: invokeinterface closeExpiredConnections : ()V
    //   642: aload #5
    //   644: invokeinterface getConnectionManager : ()Lorg/apache/http/conn/ClientConnectionManager;
    //   649: ldc2_w 300
    //   652: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   655: invokeinterface closeIdleConnections : (JLjava/util/concurrent/TimeUnit;)V
    //   660: aload_0
    //   661: athrow
    //   662: astore_0
    //   663: ldc com/sina/weibo/sdk/net/HttpManager
    //   665: monitorexit
    //   666: aload_0
    //   667: athrow
    // Exception table:
    //   from	to	target	type
    //   3	24	662	finally
    //   24	50	662	finally
    //   55	62	662	finally
    //   68	107	662	finally
    //   107	122	576	java/io/IOException
    //   107	122	572	finally
    //   125	131	576	java/io/IOException
    //   125	131	572	finally
    //   134	199	576	java/io/IOException
    //   134	199	572	finally
    //   207	216	576	java/io/IOException
    //   207	216	572	finally
    //   220	251	576	java/io/IOException
    //   220	251	572	finally
    //   268	278	576	java/io/IOException
    //   268	278	572	finally
    //   282	297	576	java/io/IOException
    //   282	297	572	finally
    //   310	327	576	java/io/IOException
    //   310	327	572	finally
    //   331	364	576	java/io/IOException
    //   331	364	572	finally
    //   367	374	576	java/io/IOException
    //   367	374	572	finally
    //   374	399	576	java/io/IOException
    //   374	399	572	finally
    //   399	406	576	java/io/IOException
    //   399	406	572	finally
    //   412	420	576	java/io/IOException
    //   412	420	572	finally
    //   427	438	576	java/io/IOException
    //   427	438	572	finally
    //   441	455	576	java/io/IOException
    //   441	455	572	finally
    //   460	490	662	finally
    //   495	501	576	java/io/IOException
    //   495	501	572	finally
    //   506	530	662	finally
    //   530	540	662	finally
    //   543	551	576	java/io/IOException
    //   543	551	572	finally
    //   554	572	576	java/io/IOException
    //   554	572	572	finally
    //   577	587	572	finally
    //   592	616	662	finally
    //   630	660	662	finally
    //   660	662	662	finally
  }
  
  private static String getBoundry() {
    StringBuffer stringBuffer = new StringBuffer();
    for (byte b = 1;; b++) {
      if (b >= 12)
        return stringBuffer.toString(); 
      long l1 = System.currentTimeMillis() + b;
      long l2 = l1 % 3L;
      if (l2 == 0L) {
        stringBuffer.append((char)(int)l1 % 9);
      } else if (l2 == 1L) {
        stringBuffer.append((char)(int)(l1 % 26L + 65L));
      } else {
        stringBuffer.append((char)(int)(l1 % 26L + 97L));
      } 
    } 
  }
  
  private static Certificate getCertificate(String paramString) throws CertificateException, IOException {
    null = CertificateFactory.getInstance("X.509");
    InputStream inputStream = HttpManager.class.getResourceAsStream(paramString);
    try {
      return null.generateCertificate(inputStream);
    } finally {
      if (inputStream != null)
        inputStream.close(); 
    } 
  }
  
  private static HttpClient getNewHttpClient() {
    try {
      BasicHttpParams basicHttpParams = new BasicHttpParams();
      this();
      HttpProtocolParams.setVersion((HttpParams)basicHttpParams, (ProtocolVersion)HttpVersion.HTTP_1_1);
      HttpProtocolParams.setContentCharset((HttpParams)basicHttpParams, "UTF-8");
      SchemeRegistry schemeRegistry = new SchemeRegistry();
      this();
      Scheme scheme = new Scheme();
      this("http", (SocketFactory)PlainSocketFactory.getSocketFactory(), 80);
      schemeRegistry.register(scheme);
      scheme = new Scheme();
      this("https", (SocketFactory)getSSLSocketFactory(), 443);
      schemeRegistry.register(scheme);
      ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager();
      this((HttpParams)basicHttpParams, schemeRegistry);
      HttpConnectionParams.setConnectionTimeout((HttpParams)basicHttpParams, 25000);
      HttpConnectionParams.setSoTimeout((HttpParams)basicHttpParams, 20000);
      return (HttpClient)new DefaultHttpClient((ClientConnectionManager)threadSafeClientConnManager, (HttpParams)basicHttpParams);
    } catch (Exception exception) {
      return (HttpClient)new DefaultHttpClient();
    } 
  }
  
  private static String getOauthSign(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
    StringBuilder stringBuilder = new StringBuilder("");
    if (!TextUtils.isEmpty(paramString1))
      stringBuilder.append(paramString1); 
    if (!TextUtils.isEmpty(paramString2))
      stringBuilder.append(paramString2); 
    if (!TextUtils.isEmpty(paramString3))
      stringBuilder.append(paramString3); 
    return calcOauthSignNative(paramContext, stringBuilder.toString(), paramString4);
  }
  
  private static SSLSocketFactory getSSLSocketFactory() {
    if (sSSLSocketFactory == null)
      try {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        Certificate certificate1 = getCertificate("cacert_cn.cer");
        Certificate certificate2 = getCertificate("cacert_com.cer");
        keyStore.setCertificateEntry("cnca", certificate1);
        keyStore.setCertificateEntry("comca", certificate2);
        SSLSocketFactoryEx sSLSocketFactoryEx = new SSLSocketFactoryEx();
        this(keyStore);
        sSSLSocketFactory = sSLSocketFactoryEx;
        LogUtil.d("HttpManager", "getSSLSocketFactory noraml !!!!!");
      } catch (Exception exception) {
        exception.printStackTrace();
        sSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        LogUtil.d("HttpManager", "getSSLSocketFactory error default !!!!!");
      }  
    return sSSLSocketFactory;
  }
  
  private static String getTimestamp() {
    return String.valueOf(System.currentTimeMillis() / 1000L);
  }
  
  public static String openRedirectUrl4LocationUri(Context paramContext, String paramString1, String paramString2, WeiboParameters paramWeiboParameters) {
    DefaultHttpClient defaultHttpClient1 = null;
    Context context1 = null;
    WeiboParameters weiboParameters = null;
    DefaultHttpClient defaultHttpClient2 = defaultHttpClient1;
    try {
      CustomRedirectHandler customRedirectHandler = new CustomRedirectHandler() {
          public void onReceivedException() {}
          
          public boolean shouldRedirectUrl(String param1String) {
            return true;
          }
        };
      defaultHttpClient2 = defaultHttpClient1;
      super();
      defaultHttpClient2 = defaultHttpClient1;
      defaultHttpClient1 = (DefaultHttpClient)getNewHttpClient();
    } catch (IOException iOException) {
    
    } finally {
      paramContext = null;
    } 
    Context context2 = paramContext;
    WeiboException weiboException = new WeiboException();
    context2 = paramContext;
    this(iOException);
    context2 = paramContext;
    throw weiboException;
  }
  
  public static String openUrl(Context paramContext, String paramString1, String paramString2, WeiboParameters paramWeiboParameters) throws WeiboException {
    paramString1 = readRsponse(requestHttpExecute(paramContext, paramString1, paramString2, paramWeiboParameters));
    StringBuilder stringBuilder = new StringBuilder("Response : ");
    stringBuilder.append(paramString1);
    LogUtil.d("HttpManager", stringBuilder.toString());
    return paramString1;
  }
  
  public static String openUrl4RdirectURL(Context paramContext, String paramString1, String paramString2, WeiboParameters paramWeiboParameters) throws WeiboException {
    RedirectHandler redirectHandler = null;
    Context context2 = null;
    Context context3 = null;
    try {
      DefaultHttpClient defaultHttpClient = (DefaultHttpClient)getNewHttpClient();
    } catch (IOException iOException) {
    
    } finally {
      RedirectHandler redirectHandler1;
      paramContext = null;
    } 
    Context context1 = paramContext;
    WeiboException weiboException = new WeiboException();
    context1 = paramContext;
    this(iOException);
    context1 = paramContext;
    throw weiboException;
  }
  
  private static String readRsponse(HttpResponse paramHttpResponse) throws WeiboException {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: invokeinterface getEntity : ()Lorg/apache/http/HttpEntity;
    //   12: astore_1
    //   13: new java/io/ByteArrayOutputStream
    //   16: dup
    //   17: invokespecial <init> : ()V
    //   20: astore_2
    //   21: aload_1
    //   22: invokeinterface getContent : ()Ljava/io/InputStream;
    //   27: astore_1
    //   28: aload_0
    //   29: ldc_w 'Content-Encoding'
    //   32: invokeinterface getFirstHeader : (Ljava/lang/String;)Lorg/apache/http/Header;
    //   37: astore_0
    //   38: aload_0
    //   39: ifnull -> 73
    //   42: aload_0
    //   43: invokeinterface getValue : ()Ljava/lang/String;
    //   48: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   51: ldc_w 'gzip'
    //   54: invokevirtual indexOf : (Ljava/lang/String;)I
    //   57: iconst_m1
    //   58: if_icmple -> 73
    //   61: new java/util/zip/GZIPInputStream
    //   64: astore_0
    //   65: aload_0
    //   66: aload_1
    //   67: invokespecial <init> : (Ljava/io/InputStream;)V
    //   70: goto -> 75
    //   73: aload_1
    //   74: astore_0
    //   75: aload_0
    //   76: astore_1
    //   77: sipush #8192
    //   80: newarray byte
    //   82: astore_3
    //   83: aload_0
    //   84: astore_1
    //   85: aload_0
    //   86: aload_3
    //   87: invokevirtual read : ([B)I
    //   90: istore #4
    //   92: iload #4
    //   94: iconst_m1
    //   95: if_icmpne -> 185
    //   98: aload_0
    //   99: astore_1
    //   100: new java/lang/String
    //   103: astore_3
    //   104: aload_0
    //   105: astore_1
    //   106: aload_3
    //   107: aload_2
    //   108: invokevirtual toByteArray : ()[B
    //   111: ldc_w 'UTF-8'
    //   114: invokespecial <init> : ([BLjava/lang/String;)V
    //   117: aload_0
    //   118: astore_1
    //   119: new java/lang/StringBuilder
    //   122: astore #5
    //   124: aload_0
    //   125: astore_1
    //   126: aload #5
    //   128: ldc_w 'readRsponse result : '
    //   131: invokespecial <init> : (Ljava/lang/String;)V
    //   134: aload_0
    //   135: astore_1
    //   136: aload #5
    //   138: aload_3
    //   139: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_0
    //   144: astore_1
    //   145: ldc 'HttpManager'
    //   147: aload #5
    //   149: invokevirtual toString : ()Ljava/lang/String;
    //   152: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_0
    //   156: ifnull -> 171
    //   159: aload_0
    //   160: invokevirtual close : ()V
    //   163: goto -> 171
    //   166: astore_0
    //   167: aload_0
    //   168: invokevirtual printStackTrace : ()V
    //   171: aload_2
    //   172: invokevirtual close : ()V
    //   175: goto -> 183
    //   178: astore_0
    //   179: aload_0
    //   180: invokevirtual printStackTrace : ()V
    //   183: aload_3
    //   184: areturn
    //   185: aload_0
    //   186: astore_1
    //   187: aload_2
    //   188: aload_3
    //   189: iconst_0
    //   190: iload #4
    //   192: invokevirtual write : ([BII)V
    //   195: goto -> 83
    //   198: astore_3
    //   199: goto -> 221
    //   202: astore_0
    //   203: goto -> 242
    //   206: astore_3
    //   207: aload_1
    //   208: astore_0
    //   209: goto -> 221
    //   212: astore_0
    //   213: aconst_null
    //   214: astore_1
    //   215: goto -> 242
    //   218: astore_3
    //   219: aconst_null
    //   220: astore_0
    //   221: aload_0
    //   222: astore_1
    //   223: new com/sina/weibo/sdk/exception/WeiboException
    //   226: astore #5
    //   228: aload_0
    //   229: astore_1
    //   230: aload #5
    //   232: aload_3
    //   233: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   236: aload_0
    //   237: astore_1
    //   238: aload #5
    //   240: athrow
    //   241: astore_0
    //   242: aload_1
    //   243: ifnull -> 258
    //   246: aload_1
    //   247: invokevirtual close : ()V
    //   250: goto -> 258
    //   253: astore_1
    //   254: aload_1
    //   255: invokevirtual printStackTrace : ()V
    //   258: aload_2
    //   259: invokevirtual close : ()V
    //   262: goto -> 270
    //   265: astore_1
    //   266: aload_1
    //   267: invokevirtual printStackTrace : ()V
    //   270: aload_0
    //   271: athrow
    // Exception table:
    //   from	to	target	type
    //   21	28	218	java/io/IOException
    //   21	28	212	finally
    //   28	38	206	java/io/IOException
    //   28	38	202	finally
    //   42	70	206	java/io/IOException
    //   42	70	202	finally
    //   77	83	198	java/io/IOException
    //   77	83	241	finally
    //   85	92	198	java/io/IOException
    //   85	92	241	finally
    //   100	104	198	java/io/IOException
    //   100	104	241	finally
    //   106	117	198	java/io/IOException
    //   106	117	241	finally
    //   119	124	198	java/io/IOException
    //   119	124	241	finally
    //   126	134	198	java/io/IOException
    //   126	134	241	finally
    //   136	143	198	java/io/IOException
    //   136	143	241	finally
    //   145	155	198	java/io/IOException
    //   145	155	241	finally
    //   159	163	166	java/io/IOException
    //   171	175	178	java/io/IOException
    //   187	195	198	java/io/IOException
    //   187	195	241	finally
    //   223	228	241	finally
    //   230	236	241	finally
    //   238	241	241	finally
    //   246	250	253	java/io/IOException
    //   258	262	265	java/io/IOException
  }
  
  private static HttpResponse requestHttpExecute(Context paramContext, String paramString1, String paramString2, WeiboParameters paramWeiboParameters) {
    Object object2;
    IOException iOException2;
    Object object3;
    StringBuilder stringBuilder1 = null;
    StringBuilder stringBuilder2 = null;
    StringBuilder stringBuilder3 = null;
    StringBuilder stringBuilder4 = null;
    StringBuilder stringBuilder5 = null;
    try {
      object3 = getNewHttpClient();
      stringBuilder4 = stringBuilder1;
      stringBuilder3 = stringBuilder2;
    } catch (IOException iOException1) {
      paramContext = null;
    } finally {
      paramContext = null;
    } 
    try {
      WeiboException weiboException = new WeiboException();
      this(iOException1);
      throw weiboException;
    } finally {
      iOException1 = null;
      object3 = object2;
    } 
    Context context = paramContext;
    Object object1 = object2;
    if (context != null)
      try {
        context.close();
      } catch (IOException iOException) {} 
    shutdownHttpClient((HttpClient)object3);
    throw object1;
  }
  
  private static void setHttpCommonParam(Context paramContext, WeiboParameters paramWeiboParameters) {
    String str1 = "";
    if (!TextUtils.isEmpty(paramWeiboParameters.getAppKey())) {
      String str = Utility.getAid(paramContext, paramWeiboParameters.getAppKey());
      str1 = str;
      if (!TextUtils.isEmpty(str)) {
        paramWeiboParameters.put("aid", str);
        str1 = str;
      } 
    } 
    String str2 = getTimestamp();
    paramWeiboParameters.put("oauth_timestamp", str2);
    String str3 = "";
    Object object2 = paramWeiboParameters.get("access_token");
    Object object1 = paramWeiboParameters.get("refresh_token");
    Object object3 = paramWeiboParameters.get("phone");
    if (object2 != null && object2 instanceof String) {
      object1 = object2;
    } else if (object1 != null && object1 instanceof String) {
      object1 = object1;
    } else {
      object1 = str3;
      if (object3 != null) {
        object1 = str3;
        if (object3 instanceof String)
          object1 = object3; 
      } 
    } 
    paramWeiboParameters.put("oauth_sign", getOauthSign(paramContext, str1, (String)object1, paramWeiboParameters.getAppKey(), str2));
  }
  
  private static void shutdownHttpClient(HttpClient paramHttpClient) {
    if (paramHttpClient != null)
      try {
        paramHttpClient.getConnectionManager().closeExpiredConnections();
      } catch (Exception exception) {} 
  }
  
  static {
    System.loadLibrary("weibosdkcore");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\net\HttpManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */