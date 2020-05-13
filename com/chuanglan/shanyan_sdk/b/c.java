package com.chuanglan.shanyan_sdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import com.chuanglan.shanyan_sdk.utils.AbObtainUtil;
import com.chuanglan.shanyan_sdk.utils.L;
import com.chuanglan.shanyan_sdk.utils.SPTool;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONObject;

class c {
  private String a;
  
  private URL b = null;
  
  private Context c;
  
  private Map<String, String> d;
  
  c(String paramString, Context paramContext) {
    this.a = paramString;
    this.c = paramContext;
    this.d = new HashMap<String, String>();
  }
  
  private HttpURLConnection a(HttpURLConnection paramHttpURLConnection) {
    for (Map.Entry<String, String> entry : this.d.entrySet())
      paramHttpURLConnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue()); 
    return paramHttpURLConnection;
  }
  
  private void a(f paramf, Map<String, String> paramMap, b paramb, Boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #8
    //   3: aconst_null
    //   4: astore #9
    //   6: aload #8
    //   8: astore #10
    //   10: new java/net/URL
    //   13: astore #11
    //   15: aload #8
    //   17: astore #10
    //   19: aload #11
    //   21: aload_0
    //   22: getfield a : Ljava/lang/String;
    //   25: invokespecial <init> : (Ljava/lang/String;)V
    //   28: aload #8
    //   30: astore #10
    //   32: aload #11
    //   34: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   37: checkcast javax/net/ssl/HttpsURLConnection
    //   40: astore #8
    //   42: ldc '0'
    //   44: aload_0
    //   45: getfield c : Landroid/content/Context;
    //   48: ldc 'ssl'
    //   50: ldc '1'
    //   52: invokestatic get : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast java/lang/String
    //   58: invokevirtual equals : (Ljava/lang/Object;)Z
    //   61: ifeq -> 69
    //   64: aload #8
    //   66: invokestatic b : (Ljavax/net/ssl/HttpsURLConnection;)V
    //   69: aload #8
    //   71: iload #6
    //   73: invokevirtual setConnectTimeout : (I)V
    //   76: aload #8
    //   78: iload #7
    //   80: invokevirtual setReadTimeout : (I)V
    //   83: aload_0
    //   84: aload #8
    //   86: invokespecial a : (Ljavax/net/ssl/HttpsURLConnection;)V
    //   89: aload_1
    //   90: getstatic com/chuanglan/shanyan_sdk/b/f.a : Lcom/chuanglan/shanyan_sdk/b/f;
    //   93: if_acmpne -> 120
    //   96: aload #8
    //   98: ldc 'GET'
    //   100: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   103: aload_3
    //   104: aload #8
    //   106: invokevirtual a : (Ljavax/net/ssl/HttpsURLConnection;)V
    //   109: aload #8
    //   111: ifnull -> 119
    //   114: aload #8
    //   116: invokevirtual disconnect : ()V
    //   119: return
    //   120: aload #4
    //   122: invokevirtual booleanValue : ()Z
    //   125: ifeq -> 348
    //   128: aload #8
    //   130: ldc 'POST'
    //   132: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   135: aload_0
    //   136: aload_2
    //   137: invokespecial b : (Ljava/util/Map;)[B
    //   140: astore #4
    //   142: invokestatic getUUID : ()Ljava/lang/String;
    //   145: astore #9
    //   147: aload #9
    //   149: iconst_0
    //   150: bipush #16
    //   152: invokevirtual substring : (II)Ljava/lang/String;
    //   155: astore_1
    //   156: aload #9
    //   158: bipush #16
    //   160: invokevirtual substring : (I)Ljava/lang/String;
    //   163: astore #10
    //   165: aload #5
    //   167: iconst_1
    //   168: invokevirtual substring : (I)Ljava/lang/String;
    //   171: astore #11
    //   173: aload #5
    //   175: iconst_0
    //   176: iconst_1
    //   177: invokevirtual substring : (II)Ljava/lang/String;
    //   180: astore_2
    //   181: aload #9
    //   183: invokevirtual getBytes : ()[B
    //   186: aload #11
    //   188: invokestatic loadPublicKey : (Ljava/lang/String;)Ljava/security/PublicKey;
    //   191: invokestatic encryptData : ([BLjava/security/PublicKey;)Ljava/lang/String;
    //   194: astore #5
    //   196: aload #4
    //   198: aload_1
    //   199: aload #10
    //   201: invokestatic aesEncrypt : ([BLjava/lang/String;Ljava/lang/String;)[B
    //   204: astore_1
    //   205: aload #8
    //   207: ldc 'Content-Type'
    //   209: ldc 'application/json'
    //   211: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   214: aload #8
    //   216: ldc 'Content-Encoding'
    //   218: ldc 'gzip'
    //   220: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   223: new java/lang/StringBuilder
    //   226: astore #4
    //   228: aload #4
    //   230: invokespecial <init> : ()V
    //   233: aload #8
    //   235: ldc 'Data-Key'
    //   237: aload #4
    //   239: aload_2
    //   240: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload #5
    //   245: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual toString : ()Ljava/lang/String;
    //   251: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   254: aload #5
    //   256: invokestatic isEmpty : (Ljava/lang/String;)Z
    //   259: ifeq -> 282
    //   262: aload_3
    //   263: iconst_0
    //   264: newarray byte
    //   266: invokevirtual a : ([B)V
    //   269: aload #8
    //   271: ifnull -> 119
    //   274: aload #8
    //   276: invokevirtual disconnect : ()V
    //   279: goto -> 119
    //   282: aload #8
    //   284: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   287: astore_2
    //   288: aload_1
    //   289: ifnull -> 341
    //   292: aload_2
    //   293: aload_1
    //   294: invokevirtual write : ([B)V
    //   297: aload_2
    //   298: invokevirtual flush : ()V
    //   301: aload_2
    //   302: invokevirtual close : ()V
    //   305: goto -> 103
    //   308: astore_2
    //   309: aload #8
    //   311: astore_1
    //   312: aload_1
    //   313: astore #10
    //   315: aload_3
    //   316: aload_2
    //   317: invokevirtual toString : ()Ljava/lang/String;
    //   320: aload_2
    //   321: invokevirtual getClass : ()Ljava/lang/Class;
    //   324: invokevirtual getName : ()Ljava/lang/String;
    //   327: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   330: aload_1
    //   331: ifnull -> 119
    //   334: aload_1
    //   335: invokevirtual disconnect : ()V
    //   338: goto -> 119
    //   341: iconst_0
    //   342: newarray byte
    //   344: astore_1
    //   345: goto -> 292
    //   348: aload #8
    //   350: ldc 'POST'
    //   352: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   355: aload_0
    //   356: aload_2
    //   357: invokespecial a : (Ljava/util/Map;)[B
    //   360: astore_1
    //   361: aload #8
    //   363: ldc 'Content-Type'
    //   365: ldc 'application/x-www-form-urlencoded'
    //   367: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   370: aload #8
    //   372: ldc 'Content-Length'
    //   374: aload_1
    //   375: arraylength
    //   376: invokestatic toString : (I)Ljava/lang/String;
    //   379: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   382: aload #8
    //   384: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   387: astore_2
    //   388: aload_2
    //   389: aload_1
    //   390: invokevirtual write : ([B)V
    //   393: aload_2
    //   394: invokevirtual flush : ()V
    //   397: aload_2
    //   398: invokevirtual close : ()V
    //   401: goto -> 103
    //   404: astore_1
    //   405: aload #8
    //   407: astore #10
    //   409: aload #10
    //   411: ifnull -> 419
    //   414: aload #10
    //   416: invokevirtual disconnect : ()V
    //   419: aload_1
    //   420: athrow
    //   421: astore_1
    //   422: goto -> 409
    //   425: astore_2
    //   426: aload #9
    //   428: astore_1
    //   429: goto -> 312
    // Exception table:
    //   from	to	target	type
    //   10	15	425	java/lang/Exception
    //   10	15	421	finally
    //   19	28	425	java/lang/Exception
    //   19	28	421	finally
    //   32	42	425	java/lang/Exception
    //   32	42	421	finally
    //   42	69	308	java/lang/Exception
    //   42	69	404	finally
    //   69	103	308	java/lang/Exception
    //   69	103	404	finally
    //   103	109	308	java/lang/Exception
    //   103	109	404	finally
    //   120	269	308	java/lang/Exception
    //   120	269	404	finally
    //   282	288	308	java/lang/Exception
    //   282	288	404	finally
    //   292	305	308	java/lang/Exception
    //   292	305	404	finally
    //   315	330	421	finally
    //   341	345	308	java/lang/Exception
    //   341	345	404	finally
    //   348	401	308	java/lang/Exception
    //   348	401	404	finally
  }
  
  private void a(HttpsURLConnection paramHttpsURLConnection) {
    for (Map.Entry<String, String> entry : this.d.entrySet())
      paramHttpsURLConnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue()); 
  }
  
  private byte[] a(Map<String, String> paramMap) {
    String str;
    if (paramMap == null)
      return new byte[0]; 
    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry<String, String> entry : paramMap.entrySet()) {
      stringBuilder.append(URLEncoder.encode((String)entry.getKey(), "utf-8"));
      stringBuilder.append("=");
      stringBuilder.append(URLEncoder.encode((String)entry.getValue(), "utf-8"));
      stringBuilder.append("&");
    } 
    if (stringBuilder.length() > 0) {
      str = stringBuilder.substring(0, stringBuilder.length() - 1);
    } else {
      str = stringBuilder.toString();
    } 
    return str.getBytes("utf-8");
  }
  
  private void b(f paramf, Map<String, String> paramMap, b paramb, Boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #8
    //   3: aconst_null
    //   4: astore #9
    //   6: aload #8
    //   8: astore #10
    //   10: new java/net/URL
    //   13: astore #11
    //   15: aload #8
    //   17: astore #10
    //   19: aload #11
    //   21: aload_0
    //   22: getfield a : Ljava/lang/String;
    //   25: invokespecial <init> : (Ljava/lang/String;)V
    //   28: aload #8
    //   30: astore #10
    //   32: aload #11
    //   34: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   37: checkcast java/net/HttpURLConnection
    //   40: astore #8
    //   42: aload #8
    //   44: iload #6
    //   46: invokevirtual setConnectTimeout : (I)V
    //   49: aload #8
    //   51: iload #7
    //   53: invokevirtual setReadTimeout : (I)V
    //   56: aload_0
    //   57: aload #8
    //   59: invokespecial a : (Ljava/net/HttpURLConnection;)Ljava/net/HttpURLConnection;
    //   62: pop
    //   63: aload_1
    //   64: getstatic com/chuanglan/shanyan_sdk/b/f.a : Lcom/chuanglan/shanyan_sdk/b/f;
    //   67: if_acmpne -> 94
    //   70: aload #8
    //   72: ldc 'GET'
    //   74: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   77: aload_3
    //   78: aload #8
    //   80: invokevirtual a : (Ljava/net/HttpURLConnection;)V
    //   83: aload #8
    //   85: ifnull -> 93
    //   88: aload #8
    //   90: invokevirtual disconnect : ()V
    //   93: return
    //   94: aload #4
    //   96: invokevirtual booleanValue : ()Z
    //   99: ifeq -> 322
    //   102: aload #8
    //   104: ldc 'POST'
    //   106: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   109: aload_0
    //   110: aload_2
    //   111: invokespecial b : (Ljava/util/Map;)[B
    //   114: astore_1
    //   115: invokestatic getUUID : ()Ljava/lang/String;
    //   118: astore #11
    //   120: aload #11
    //   122: iconst_0
    //   123: bipush #16
    //   125: invokevirtual substring : (II)Ljava/lang/String;
    //   128: astore #4
    //   130: aload #11
    //   132: bipush #16
    //   134: invokevirtual substring : (I)Ljava/lang/String;
    //   137: astore #10
    //   139: aload #5
    //   141: iconst_1
    //   142: invokevirtual substring : (I)Ljava/lang/String;
    //   145: astore #9
    //   147: aload #5
    //   149: iconst_0
    //   150: iconst_1
    //   151: invokevirtual substring : (II)Ljava/lang/String;
    //   154: astore_2
    //   155: aload #11
    //   157: invokevirtual getBytes : ()[B
    //   160: aload #9
    //   162: invokestatic loadPublicKey : (Ljava/lang/String;)Ljava/security/PublicKey;
    //   165: invokestatic encryptData : ([BLjava/security/PublicKey;)Ljava/lang/String;
    //   168: astore #5
    //   170: aload_1
    //   171: aload #4
    //   173: aload #10
    //   175: invokestatic aesEncrypt : ([BLjava/lang/String;Ljava/lang/String;)[B
    //   178: astore_1
    //   179: aload #8
    //   181: ldc 'Content-Type'
    //   183: ldc 'application/json'
    //   185: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload #8
    //   190: ldc 'Content-Encoding'
    //   192: ldc 'gzip'
    //   194: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   197: new java/lang/StringBuilder
    //   200: astore #4
    //   202: aload #4
    //   204: invokespecial <init> : ()V
    //   207: aload #8
    //   209: ldc 'Data-Key'
    //   211: aload #4
    //   213: aload_2
    //   214: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload #5
    //   219: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual toString : ()Ljava/lang/String;
    //   225: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload #5
    //   230: invokestatic isEmpty : (Ljava/lang/String;)Z
    //   233: ifeq -> 256
    //   236: aload_3
    //   237: iconst_0
    //   238: newarray byte
    //   240: invokevirtual a : ([B)V
    //   243: aload #8
    //   245: ifnull -> 93
    //   248: aload #8
    //   250: invokevirtual disconnect : ()V
    //   253: goto -> 93
    //   256: aload #8
    //   258: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   261: astore_2
    //   262: aload_1
    //   263: ifnull -> 315
    //   266: aload_2
    //   267: aload_1
    //   268: invokevirtual write : ([B)V
    //   271: aload_2
    //   272: invokevirtual flush : ()V
    //   275: aload_2
    //   276: invokevirtual close : ()V
    //   279: goto -> 77
    //   282: astore_2
    //   283: aload #8
    //   285: astore_1
    //   286: aload_1
    //   287: astore #10
    //   289: aload_3
    //   290: aload_2
    //   291: invokevirtual toString : ()Ljava/lang/String;
    //   294: aload_2
    //   295: invokevirtual getClass : ()Ljava/lang/Class;
    //   298: invokevirtual getName : ()Ljava/lang/String;
    //   301: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload_1
    //   305: ifnull -> 93
    //   308: aload_1
    //   309: invokevirtual disconnect : ()V
    //   312: goto -> 93
    //   315: iconst_0
    //   316: newarray byte
    //   318: astore_1
    //   319: goto -> 266
    //   322: aload #8
    //   324: ldc 'POST'
    //   326: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   329: aload_0
    //   330: aload_2
    //   331: invokespecial a : (Ljava/util/Map;)[B
    //   334: astore_2
    //   335: aload #8
    //   337: ldc 'Content-Type'
    //   339: ldc 'application/x-www-form-urlencoded'
    //   341: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   344: aload #8
    //   346: ldc 'Content-Length'
    //   348: aload_2
    //   349: arraylength
    //   350: invokestatic toString : (I)Ljava/lang/String;
    //   353: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload #8
    //   358: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   361: astore_1
    //   362: aload_1
    //   363: aload_2
    //   364: invokevirtual write : ([B)V
    //   367: aload_1
    //   368: invokevirtual flush : ()V
    //   371: aload_1
    //   372: invokevirtual close : ()V
    //   375: goto -> 77
    //   378: astore_1
    //   379: aload #8
    //   381: astore #10
    //   383: aload #10
    //   385: ifnull -> 393
    //   388: aload #10
    //   390: invokevirtual disconnect : ()V
    //   393: aload_1
    //   394: athrow
    //   395: astore_1
    //   396: goto -> 383
    //   399: astore_2
    //   400: aload #9
    //   402: astore_1
    //   403: goto -> 286
    // Exception table:
    //   from	to	target	type
    //   10	15	399	java/lang/Exception
    //   10	15	395	finally
    //   19	28	399	java/lang/Exception
    //   19	28	395	finally
    //   32	42	399	java/lang/Exception
    //   32	42	395	finally
    //   42	77	282	java/lang/Exception
    //   42	77	378	finally
    //   77	83	282	java/lang/Exception
    //   77	83	378	finally
    //   94	243	282	java/lang/Exception
    //   94	243	378	finally
    //   256	262	282	java/lang/Exception
    //   256	262	378	finally
    //   266	279	282	java/lang/Exception
    //   266	279	378	finally
    //   289	304	395	finally
    //   315	319	282	java/lang/Exception
    //   315	319	378	finally
    //   322	375	282	java/lang/Exception
    //   322	375	378	finally
  }
  
  private static void b(HttpsURLConnection paramHttpsURLConnection) {
    try {
      X509TrustManager x509TrustManager = new X509TrustManager() {
          @SuppressLint({"TrustAllX509TrustManager"})
          public void checkClientTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) {}
          
          @SuppressLint({"TrustAllX509TrustManager"})
          public void checkServerTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) {}
          
          public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
          }
        };
      super();
      SSLContext sSLContext = SSLContext.getInstance("TLS");
      SecureRandom secureRandom = new SecureRandom();
      this();
      sSLContext.init(null, new TrustManager[] { x509TrustManager }, secureRandom);
      HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
      HostnameVerifier hostnameVerifier = new HostnameVerifier() {
          @SuppressLint({"BadHostnameVerifier"})
          public boolean verify(String param1String, SSLSession param1SSLSession) {
            return true;
          }
        };
      super();
      HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
    } catch (Exception exception) {
      exception.printStackTrace();
      L.d("ExceptionLogger", "handleSSLHandshake()Exception == " + exception.toString());
    } 
  }
  
  private byte[] b(Map<String, String> paramMap) {
    return (paramMap == null) ? new byte[0] : AbObtainUtil.compressForGzip((new JSONObject(paramMap)).toString());
  }
  
  public void a(b paramb) {
    a(f.a, null, paramb, Boolean.valueOf(false), "");
  }
  
  void a(f paramf, Map<String, String> paramMap, b paramb, Boolean paramBoolean, String paramString) {
    int i = ((Integer)SPTool.get(this.c, "initTimeOut", Integer.valueOf(4))).intValue() * 1000 / 2;
    int j = ((Integer)SPTool.get(this.c, "initTimeOut", Integer.valueOf(4))).intValue() * 1000 / 2;
    if (this.a.startsWith("https")) {
      a(paramf, paramMap, paramb, paramBoolean, paramString, i, j);
      return;
    } 
    b(paramf, paramMap, paramb, paramBoolean, paramString, i, j);
  }
  
  public void a(Map<String, String> paramMap, b paramb, Boolean paramBoolean, String paramString) {
    a(f.b, paramMap, paramb, paramBoolean, paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */