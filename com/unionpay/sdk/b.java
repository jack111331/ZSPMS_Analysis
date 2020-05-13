package com.unionpay.sdk;

import android.content.Context;
import android.preference.PreferenceManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class b {
  public static int a = 60000;
  
  public static int b = 60000;
  
  public static volatile HashMap c = new HashMap<Object, Object>();
  
  private static Context d = null;
  
  private static volatile HashMap e = new HashMap<Object, Object>();
  
  public static d a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfbyte) {
    d = paramContext;
    a(paramString1, paramString2);
    return a(paramString1, paramString3, paramString4, paramArrayOfbyte);
  }
  
  private static d a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfbyte) {
    d d3;
    d d1 = new d();
    d d2 = d1;
    try {
      d d;
      if (a(paramString1, 2) != null) {
        d2 = d1;
        d = a(a(paramString1, 2), paramString2, paramString3, paramArrayOfbyte, paramString1);
        d d4 = d;
        d2 = d;
        if (d.a == 600) {
          d2 = d;
          a(paramString1, (String)null, 2);
          d4 = d;
        } 
        return d4;
      } 
      d3 = d1;
      d2 = d1;
      if (a(paramString1, 1) != null) {
        d2 = d1;
        d1 = a(a(paramString1, 1), (String)d, paramString3, paramArrayOfbyte, paramString1);
        d3 = d1;
        d2 = d1;
        if (d1.a != 600) {
          d2 = d1;
          a(paramString1, a(paramString1, 1), 2);
          d2 = d1;
          String str = a(paramString1, 1);
          d3 = d1;
          if (str != null) {
            d3 = d1;
            d2 = d1;
            if (!str.equalsIgnoreCase(a(paramString1, 3))) {
              d3 = d1;
              d2 = d1;
              if (d != null) {
                d2 = d1;
                PreferenceManager.getDefaultSharedPreferences(d).edit().putString(k.d(paramString1), a(paramString1, 1)).apply();
                d2 = d1;
                a(paramString1, a(paramString1, 1), 3);
                d3 = d1;
              } 
            } 
          } 
        } 
      } 
      d1 = d3;
      d2 = d3;
      if (d3.a == 600) {
        d1 = d3;
        d2 = d3;
        if (a(paramString1, 3) != null) {
          d2 = d3;
          d3 = a(a(paramString1, 3), (String)d, paramString3, paramArrayOfbyte, paramString1);
          d1 = d3;
          d2 = d3;
          if (d3.a != 600) {
            d2 = d3;
            a(paramString1, a(paramString1, 3), 2);
            d1 = d3;
          } 
        } 
      } 
      d3 = d1;
      d2 = d1;
      if (d1.a == 600) {
        d2 = d1;
        d = a(a(paramString1, 4), (String)d, paramString3, paramArrayOfbyte, paramString1);
        d3 = d;
        d2 = d;
        if (d.a != 600) {
          d2 = d;
          a(paramString1, a(paramString1, 4), 2);
          d3 = d;
        } 
      } 
    } catch (Throwable throwable) {
      d3 = d2;
    } 
    return d3;
  }
  
  private static d a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfbyte, String paramString4) {
    d d;
    try {
      URL uRL;
      if (paramString2.startsWith("https://"))
        c.put(Long.valueOf(Thread.currentThread().getId()), paramString4); 
      if (paramString2.toLowerCase().startsWith("https") && paramString3.trim().isEmpty()) {
        uRL = new URL();
        this(paramString2);
      } else {
        URL uRL1 = new URL();
        this(paramString2);
        uRL = uRL1;
        if (!f.a())
          uRL = new URL(uRL1.getProtocol(), paramString1, uRL1.getPort(), uRL1.getFile()); 
      } 
      URLConnection uRLConnection2 = a(uRL, paramString4, true);
      if (uRLConnection2 == null) {
        d d1 = new d();
        this(600, "");
        return d1;
      } 
      URLConnection uRLConnection1 = uRLConnection2;
      if (paramString2.toLowerCase().startsWith("https")) {
        uRLConnection1 = uRLConnection2;
        if (!paramString3.trim().isEmpty())
          uRLConnection1 = a(uRLConnection2, paramString3); 
      } 
      d = a(paramArrayOfbyte, uRLConnection1);
    } catch (Throwable throwable) {
      d = new d(600, "");
    } 
    return d;
  }
  
  private static d a(byte[] paramArrayOfbyte, URLConnection paramURLConnection) {
    char c;
    InputStream inputStream1 = null;
    InputStream inputStream2 = null;
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0 || paramURLConnection == null)
      return new d(600, ""); 
    HttpURLConnection httpURLConnection = (HttpURLConnection)paramURLConnection;
    StringBuffer stringBuffer = new StringBuffer();
    try {
    
    } catch (Throwable throwable1) {
    
    } finally {
      paramURLConnection = null;
      inputStream2 = inputStream1;
      if (paramURLConnection != null)
        try {
          paramURLConnection.close();
        } catch (Throwable null) {} 
      if (inputStream2 != null)
        try {
          inputStream2.close();
        } catch (Throwable null) {} 
      if (httpURLConnection != null)
        try {
          httpURLConnection.disconnect();
        } catch (Throwable throwable) {} 
      a = 60000;
      b = 60000;
    } 
    if (throwable != null)
      try {
        throwable.close();
      } catch (Throwable throwable1) {} 
    if (paramArrayOfbyte != null)
      try {
        paramArrayOfbyte.close();
      } catch (Throwable throwable1) {} 
    if (httpURLConnection != null)
      try {
        httpURLConnection.disconnect();
      } catch (Throwable throwable1) {} 
    a = 60000;
    b = 60000;
    d d = new d(c, stringBuffer.toString());
  }
  
  private static String a(String paramString, int paramInt) {
    // Byte code:
    //   0: ldc com/unionpay/sdk/b
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic b : (Ljava/lang/String;)Z
    //   7: ifne -> 22
    //   10: getstatic com/unionpay/sdk/b.e : Ljava/util/HashMap;
    //   13: aload_0
    //   14: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifne -> 29
    //   22: aconst_null
    //   23: astore_0
    //   24: ldc com/unionpay/sdk/b
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: getstatic com/unionpay/sdk/b.e : Ljava/util/HashMap;
    //   32: aload_0
    //   33: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast com/unionpay/sdk/b$a
    //   39: astore_0
    //   40: aload_0
    //   41: ifnonnull -> 49
    //   44: aconst_null
    //   45: astore_0
    //   46: goto -> 24
    //   49: iload_1
    //   50: tableswitch default -> 80, 1 -> 85, 2 -> 93, 3 -> 101, 4 -> 109
    //   80: aconst_null
    //   81: astore_0
    //   82: goto -> 24
    //   85: aload_0
    //   86: getfield b : Ljava/lang/String;
    //   89: astore_0
    //   90: goto -> 24
    //   93: aload_0
    //   94: getfield d : Ljava/lang/String;
    //   97: astore_0
    //   98: goto -> 24
    //   101: aload_0
    //   102: getfield c : Ljava/lang/String;
    //   105: astore_0
    //   106: goto -> 24
    //   109: aload_0
    //   110: getfield a : Ljava/lang/String;
    //   113: astore_0
    //   114: goto -> 24
    //   117: astore_0
    //   118: ldc com/unionpay/sdk/b
    //   120: monitorexit
    //   121: aload_0
    //   122: athrow
    // Exception table:
    //   from	to	target	type
    //   3	18	117	finally
    //   29	40	117	finally
    //   85	90	117	finally
    //   93	98	117	finally
    //   101	106	117	finally
    //   109	114	117	finally
  }
  
  public static String a(String paramString, File paramFile) {
    return b(paramString, (String)null, paramFile);
  }
  
  public static String a(String paramString1, String paramString2, File paramFile) {
    return b(paramString1, paramString2, paramFile);
  }
  
  public static String a(String paramString1, String paramString2, boolean paramBoolean) {
    return b(paramString1, paramString2, paramBoolean);
  }
  
  public static String a(String paramString, boolean paramBoolean) {
    return b(paramString, (String)null, paramBoolean);
  }
  
  private static URLConnection a(URL paramURL, String paramString, boolean paramBoolean) {
    try {
      URLConnection uRLConnection = paramURL.openConnection();
      uRLConnection.setRequestProperty("Accept-Encoding", "");
      uRLConnection.setRequestProperty("User-Agent", "");
      if (paramString != null) {
        uRLConnection.setRequestProperty("Host", paramString);
        uRLConnection.setRequestProperty("Content-Type", "");
      } 
      uRLConnection.setDoInput(true);
      if (paramBoolean)
        uRLConnection.setDoOutput(true); 
      uRLConnection.setConnectTimeout(a);
      uRLConnection.setReadTimeout(b);
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (URLConnection)throwable;
  }
  
  private static X509Certificate a(String paramString) {
    if (paramString == null || paramString.trim().isEmpty())
      return null; 
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramString.getBytes());
    try {
      X509Certificate x509Certificate = (X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
      try {
        byteArrayInputStream.close();
      } catch (Throwable throwable) {}
    } catch (Exception exception) {
      try {
        throwable.close();
        exception = null;
      } catch (Throwable throwable1) {
        throwable1 = null;
      } 
    } finally {}
    return (X509Certificate)paramString;
  }
  
  private static HttpsURLConnection a(URLConnection paramURLConnection, String paramString) {
    try {
      SSLContext sSLContext;
      HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection)paramURLConnection;
      if (k.a(16)) {
        sSLContext = SSLContext.getInstance("TLSv1.2");
      } else {
        sSLContext = SSLContext.getInstance("TLSv1");
      } 
      b b1 = new b();
      this(a(paramString));
      sSLContext.init(null, new TrustManager[] { b1 }, null);
      an an = new an();
      this();
      httpsURLConnection2.setHostnameVerifier(an);
      httpsURLConnection2.setSSLSocketFactory(sSLContext.getSocketFactory());
      HttpsURLConnection httpsURLConnection1 = httpsURLConnection2;
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (HttpsURLConnection)throwable;
  }
  
  public static SSLSocketFactory a(boolean paramBoolean, X509Certificate paramX509Certificate) {
    Throwable throwable2 = null;
    try {
      SSLContext sSLContext = SSLContext.getInstance("TLS");
      if (paramBoolean && paramX509Certificate != null) {
        b b1 = new b();
        this(paramX509Certificate);
        sSLContext.init(null, new TrustManager[] { b1 }, null);
      } else {
        sSLContext.init(null, null, null);
      } 
      SSLSocketFactory sSLSocketFactory = sSLContext.getSocketFactory();
    } catch (Throwable throwable1) {
      throwable1 = throwable2;
    } 
    return (SSLSocketFactory)throwable1;
  }
  
  private static void a(String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/unionpay/sdk/b
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic b : (Ljava/lang/String;)Z
    //   7: ifne -> 22
    //   10: getstatic com/unionpay/sdk/b.e : Ljava/util/HashMap;
    //   13: aload_0
    //   14: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifeq -> 26
    //   22: ldc com/unionpay/sdk/b
    //   24: monitorexit
    //   25: return
    //   26: new com/unionpay/sdk/b$a
    //   29: astore_3
    //   30: aload_3
    //   31: invokespecial <init> : ()V
    //   34: aload_3
    //   35: aload_0
    //   36: putfield e : Ljava/lang/String;
    //   39: aload_3
    //   40: aload_1
    //   41: putfield a : Ljava/lang/String;
    //   44: aload_3
    //   45: getstatic com/unionpay/sdk/b.d : Landroid/content/Context;
    //   48: invokestatic getDefaultSharedPreferences : (Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   51: aload_0
    //   52: invokestatic d : (Ljava/lang/String;)Ljava/lang/String;
    //   55: aconst_null
    //   56: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   61: putfield c : Ljava/lang/String;
    //   64: aload_3
    //   65: aload_0
    //   66: invokestatic getByName : (Ljava/lang/String;)Ljava/net/InetAddress;
    //   69: invokevirtual getHostAddress : ()Ljava/lang/String;
    //   72: putfield b : Ljava/lang/String;
    //   75: getstatic com/unionpay/sdk/b.e : Ljava/util/HashMap;
    //   78: aload_0
    //   79: aload_3
    //   80: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: goto -> 22
    //   87: astore_0
    //   88: ldc com/unionpay/sdk/b
    //   90: monitorexit
    //   91: aload_0
    //   92: athrow
    //   93: astore_1
    //   94: goto -> 75
    // Exception table:
    //   from	to	target	type
    //   3	18	87	finally
    //   26	64	87	finally
    //   64	75	93	java/lang/Throwable
    //   64	75	87	finally
    //   75	84	87	finally
  }
  
  private static void a(String paramString1, String paramString2, int paramInt) {
    // Byte code:
    //   0: ldc com/unionpay/sdk/b
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic b : (Ljava/lang/String;)Z
    //   7: ifne -> 22
    //   10: getstatic com/unionpay/sdk/b.e : Ljava/util/HashMap;
    //   13: aload_0
    //   14: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   17: istore_3
    //   18: iload_3
    //   19: ifne -> 26
    //   22: ldc com/unionpay/sdk/b
    //   24: monitorexit
    //   25: return
    //   26: getstatic com/unionpay/sdk/b.e : Ljava/util/HashMap;
    //   29: aload_0
    //   30: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast com/unionpay/sdk/b$a
    //   36: astore_0
    //   37: iload_2
    //   38: tableswitch default -> 68, 1 -> 71, 2 -> 85, 3 -> 93, 4 -> 101
    //   68: goto -> 22
    //   71: aload_0
    //   72: aload_1
    //   73: putfield b : Ljava/lang/String;
    //   76: goto -> 22
    //   79: astore_0
    //   80: ldc com/unionpay/sdk/b
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    //   85: aload_0
    //   86: aload_1
    //   87: putfield d : Ljava/lang/String;
    //   90: goto -> 22
    //   93: aload_0
    //   94: aload_1
    //   95: putfield c : Ljava/lang/String;
    //   98: goto -> 22
    //   101: aload_0
    //   102: aload_1
    //   103: putfield a : Ljava/lang/String;
    //   106: goto -> 22
    // Exception table:
    //   from	to	target	type
    //   3	18	79	finally
    //   26	37	79	finally
    //   71	76	79	finally
    //   85	90	79	finally
    //   93	98	79	finally
    //   101	106	79	finally
  }
  
  private static byte[] a(InputStream paramInputStream) {
    byte[] arrayOfByte1;
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte3 = arrayOfByte2;
    try {
      GZIPInputStream gZIPInputStream = new GZIPInputStream();
      arrayOfByte3 = arrayOfByte2;
      this(paramInputStream);
      arrayOfByte3 = arrayOfByte2;
      arrayOfByte1 = new byte[1024];
      arrayOfByte3 = arrayOfByte2;
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      arrayOfByte3 = arrayOfByte2;
      this();
      while (true) {
        arrayOfByte3 = arrayOfByte2;
        int i = gZIPInputStream.read(arrayOfByte1, 0, arrayOfByte1.length);
        if (i != -1) {
          arrayOfByte3 = arrayOfByte2;
          byteArrayOutputStream.write(arrayOfByte1, 0, i);
          continue;
        } 
        arrayOfByte3 = arrayOfByte2;
        arrayOfByte1 = byteArrayOutputStream.toByteArray();
        arrayOfByte3 = arrayOfByte1;
        byteArrayOutputStream.flush();
        arrayOfByte3 = arrayOfByte1;
        byteArrayOutputStream.close();
        arrayOfByte3 = arrayOfByte1;
        gZIPInputStream.close();
        return arrayOfByte1;
      } 
    } catch (Throwable throwable) {
      arrayOfByte1 = arrayOfByte3;
    } 
    return arrayOfByte1;
  }
  
  private static String b(String paramString1, String paramString2, File paramFile) {
    // Byte code:
    //   0: new java/net/URL
    //   3: astore_3
    //   4: aload_3
    //   5: aload_0
    //   6: invokespecial <init> : (Ljava/lang/String;)V
    //   9: aload_3
    //   10: aconst_null
    //   11: iconst_0
    //   12: invokestatic a : (Ljava/net/URL;Ljava/lang/String;Z)Ljava/net/URLConnection;
    //   15: checkcast java/net/HttpURLConnection
    //   18: astore #4
    //   20: aload_0
    //   21: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   24: ldc 'https'
    //   26: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   29: ifeq -> 264
    //   32: aload_1
    //   33: invokestatic b : (Ljava/lang/String;)Z
    //   36: ifne -> 264
    //   39: getstatic com/unionpay/sdk/b.c : Ljava/util/HashMap;
    //   42: invokestatic currentThread : ()Ljava/lang/Thread;
    //   45: invokevirtual getId : ()J
    //   48: invokestatic valueOf : (J)Ljava/lang/Long;
    //   51: aload_3
    //   52: invokevirtual getHost : ()Ljava/lang/String;
    //   55: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   58: pop
    //   59: aload #4
    //   61: aload_1
    //   62: invokestatic a : (Ljava/net/URLConnection;Ljava/lang/String;)Ljavax/net/ssl/HttpsURLConnection;
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual getResponseCode : ()I
    //   70: sipush #200
    //   73: if_icmpne -> 206
    //   76: aload_0
    //   77: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   80: astore_1
    //   81: new java/io/FileOutputStream
    //   84: astore #4
    //   86: aload #4
    //   88: aload_2
    //   89: invokespecial <init> : (Ljava/io/File;)V
    //   92: ldc_w 'MD5'
    //   95: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/MessageDigest;
    //   98: astore_2
    //   99: sipush #4096
    //   102: newarray byte
    //   104: astore_3
    //   105: aload_1
    //   106: aload_3
    //   107: invokevirtual read : ([B)I
    //   110: istore #5
    //   112: iload #5
    //   114: iconst_m1
    //   115: if_icmpeq -> 168
    //   118: aload #4
    //   120: aload_3
    //   121: iconst_0
    //   122: iload #5
    //   124: invokevirtual write : ([BII)V
    //   127: aload_2
    //   128: aload_3
    //   129: iconst_0
    //   130: iload #5
    //   132: invokevirtual update : ([BII)V
    //   135: goto -> 105
    //   138: astore_2
    //   139: aload #4
    //   141: invokevirtual close : ()V
    //   144: aload_1
    //   145: invokevirtual close : ()V
    //   148: aload_2
    //   149: athrow
    //   150: astore_1
    //   151: aload_0
    //   152: astore #4
    //   154: aload #4
    //   156: ifnull -> 164
    //   159: aload #4
    //   161: invokevirtual disconnect : ()V
    //   164: aconst_null
    //   165: astore_2
    //   166: aload_2
    //   167: areturn
    //   168: aload #4
    //   170: invokevirtual close : ()V
    //   173: aload_1
    //   174: invokevirtual close : ()V
    //   177: aload_2
    //   178: invokevirtual digest : ()[B
    //   181: invokestatic a : ([B)Ljava/lang/String;
    //   184: astore_1
    //   185: aload_1
    //   186: astore_2
    //   187: aload_0
    //   188: ifnull -> 166
    //   191: aload_0
    //   192: invokevirtual disconnect : ()V
    //   195: aload_1
    //   196: astore_2
    //   197: goto -> 166
    //   200: astore_0
    //   201: aload_1
    //   202: astore_2
    //   203: goto -> 166
    //   206: aload_0
    //   207: ifnull -> 164
    //   210: aload_0
    //   211: invokevirtual disconnect : ()V
    //   214: goto -> 164
    //   217: astore_0
    //   218: goto -> 164
    //   221: astore_1
    //   222: aconst_null
    //   223: astore_0
    //   224: aload_0
    //   225: ifnull -> 232
    //   228: aload_0
    //   229: invokevirtual disconnect : ()V
    //   232: aload_1
    //   233: athrow
    //   234: astore_0
    //   235: goto -> 164
    //   238: astore_0
    //   239: goto -> 232
    //   242: astore_1
    //   243: aload #4
    //   245: astore_0
    //   246: goto -> 224
    //   249: astore_1
    //   250: goto -> 224
    //   253: astore_0
    //   254: aconst_null
    //   255: astore #4
    //   257: goto -> 154
    //   260: astore_0
    //   261: goto -> 154
    //   264: aload #4
    //   266: astore_0
    //   267: goto -> 66
    // Exception table:
    //   from	to	target	type
    //   0	20	253	java/lang/Throwable
    //   0	20	221	finally
    //   20	66	260	java/lang/Throwable
    //   20	66	242	finally
    //   66	99	150	java/lang/Throwable
    //   66	99	249	finally
    //   99	105	138	finally
    //   105	112	138	finally
    //   118	135	138	finally
    //   139	150	150	java/lang/Throwable
    //   139	150	249	finally
    //   159	164	234	java/lang/Throwable
    //   168	185	150	java/lang/Throwable
    //   168	185	249	finally
    //   191	195	200	java/lang/Throwable
    //   210	214	217	java/lang/Throwable
    //   228	232	238	java/lang/Throwable
  }
  
  private static String b(String paramString1, String paramString2, boolean paramBoolean) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore #4
    //   5: aconst_null
    //   6: astore #5
    //   8: aload_0
    //   9: invokestatic b : (Ljava/lang/String;)Z
    //   12: ifeq -> 19
    //   15: aconst_null
    //   16: astore_0
    //   17: aload_0
    //   18: areturn
    //   19: new java/lang/StringBuffer
    //   22: dup
    //   23: invokespecial <init> : ()V
    //   26: astore #6
    //   28: new java/net/URL
    //   31: astore #7
    //   33: aload #7
    //   35: aload_0
    //   36: invokespecial <init> : (Ljava/lang/String;)V
    //   39: aload #7
    //   41: aconst_null
    //   42: iconst_0
    //   43: invokestatic a : (Ljava/net/URL;Ljava/lang/String;Z)Ljava/net/URLConnection;
    //   46: checkcast java/net/HttpURLConnection
    //   49: astore #8
    //   51: aload_0
    //   52: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   55: ldc 'https'
    //   57: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   60: ifeq -> 370
    //   63: aload_1
    //   64: invokestatic b : (Ljava/lang/String;)Z
    //   67: ifne -> 370
    //   70: getstatic com/unionpay/sdk/b.c : Ljava/util/HashMap;
    //   73: invokestatic currentThread : ()Ljava/lang/Thread;
    //   76: invokevirtual getId : ()J
    //   79: invokestatic valueOf : (J)Ljava/lang/Long;
    //   82: aload #7
    //   84: invokevirtual getHost : ()Ljava/lang/String;
    //   87: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   90: pop
    //   91: aload #8
    //   93: aload_1
    //   94: invokestatic a : (Ljava/net/URLConnection;Ljava/lang/String;)Ljavax/net/ssl/HttpsURLConnection;
    //   97: astore_0
    //   98: aload_0
    //   99: ldc_w 'GET'
    //   102: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   105: aload_0
    //   106: invokevirtual getResponseCode : ()I
    //   109: sipush #200
    //   112: if_icmpne -> 252
    //   115: iload_2
    //   116: ifeq -> 172
    //   119: new java/lang/String
    //   122: astore_1
    //   123: aload_1
    //   124: aload_0
    //   125: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   128: invokestatic a : (Ljava/io/InputStream;)[B
    //   131: ldc_w 'utf-8'
    //   134: invokespecial <init> : ([BLjava/lang/String;)V
    //   137: aload #6
    //   139: aload_1
    //   140: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   143: pop
    //   144: aload #5
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull -> 155
    //   151: aload_1
    //   152: invokevirtual close : ()V
    //   155: aload_0
    //   156: ifnull -> 163
    //   159: aload_0
    //   160: invokevirtual disconnect : ()V
    //   163: aload #6
    //   165: invokevirtual toString : ()Ljava/lang/String;
    //   168: astore_0
    //   169: goto -> 17
    //   172: new java/io/InputStreamReader
    //   175: astore_1
    //   176: aload_1
    //   177: aload_0
    //   178: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   181: invokespecial <init> : (Ljava/io/InputStream;)V
    //   184: new java/io/BufferedReader
    //   187: dup
    //   188: aload_1
    //   189: invokespecial <init> : (Ljava/io/Reader;)V
    //   192: astore_1
    //   193: aload_1
    //   194: invokevirtual readLine : ()Ljava/lang/String;
    //   197: astore #8
    //   199: aload #8
    //   201: ifnull -> 249
    //   204: aload #6
    //   206: ldc_w '/n'
    //   209: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   212: pop
    //   213: aload #6
    //   215: aload #8
    //   217: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   220: pop
    //   221: goto -> 193
    //   224: astore #8
    //   226: aload_1
    //   227: ifnull -> 234
    //   230: aload_1
    //   231: invokevirtual close : ()V
    //   234: aload_0
    //   235: ifnull -> 163
    //   238: aload_0
    //   239: invokevirtual disconnect : ()V
    //   242: goto -> 163
    //   245: astore_0
    //   246: goto -> 163
    //   249: goto -> 147
    //   252: aload_0
    //   253: ifnull -> 260
    //   256: aload_0
    //   257: invokevirtual disconnect : ()V
    //   260: aconst_null
    //   261: astore_0
    //   262: goto -> 17
    //   265: astore_1
    //   266: aconst_null
    //   267: astore_0
    //   268: aload #4
    //   270: astore #8
    //   272: aload #8
    //   274: ifnull -> 282
    //   277: aload #8
    //   279: invokevirtual close : ()V
    //   282: aload_0
    //   283: ifnull -> 290
    //   286: aload_0
    //   287: invokevirtual disconnect : ()V
    //   290: aload_1
    //   291: athrow
    //   292: astore_0
    //   293: goto -> 260
    //   296: astore_1
    //   297: goto -> 155
    //   300: astore_0
    //   301: goto -> 163
    //   304: astore_1
    //   305: goto -> 234
    //   308: astore #8
    //   310: goto -> 282
    //   313: astore_0
    //   314: goto -> 290
    //   317: astore_1
    //   318: aload #8
    //   320: astore_0
    //   321: aload #4
    //   323: astore #8
    //   325: goto -> 272
    //   328: astore_1
    //   329: aload #4
    //   331: astore #8
    //   333: goto -> 272
    //   336: astore #4
    //   338: aload_1
    //   339: astore #8
    //   341: aload #4
    //   343: astore_1
    //   344: goto -> 272
    //   347: astore_0
    //   348: aconst_null
    //   349: astore_0
    //   350: aload_3
    //   351: astore_1
    //   352: goto -> 226
    //   355: astore_0
    //   356: aload #8
    //   358: astore_0
    //   359: aload_3
    //   360: astore_1
    //   361: goto -> 226
    //   364: astore_1
    //   365: aload_3
    //   366: astore_1
    //   367: goto -> 226
    //   370: aload #8
    //   372: astore_0
    //   373: goto -> 98
    // Exception table:
    //   from	to	target	type
    //   28	51	347	java/lang/Throwable
    //   28	51	265	finally
    //   51	98	355	java/lang/Throwable
    //   51	98	317	finally
    //   98	115	364	java/lang/Throwable
    //   98	115	328	finally
    //   119	144	364	java/lang/Throwable
    //   119	144	328	finally
    //   151	155	296	java/lang/Throwable
    //   159	163	300	java/lang/Throwable
    //   172	193	364	java/lang/Throwable
    //   172	193	328	finally
    //   193	199	224	java/lang/Throwable
    //   193	199	336	finally
    //   204	221	224	java/lang/Throwable
    //   204	221	336	finally
    //   230	234	304	java/lang/Throwable
    //   238	242	245	java/lang/Throwable
    //   256	260	292	java/lang/Throwable
    //   277	282	308	java/lang/Throwable
    //   286	290	313	java/lang/Throwable
  }
  
  static final class a {
    String a = null;
    
    String b = null;
    
    String c = null;
    
    String d = null;
    
    String e = null;
  }
  
  static final class b implements X509TrustManager {
    X509Certificate a;
    
    b(X509Certificate param1X509Certificate) {
      this.a = param1X509Certificate;
    }
    
    public final void checkClientTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) {}
    
    public final void checkServerTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) {
      Throwable throwable;
      String str;
      if (param1ArrayOfX509Certificate.length == 0)
        throw new CertificateException("No server certificate found!"); 
      if (!param1ArrayOfX509Certificate[0].getIssuerDN().equals(this.a.getSubjectDN()))
        throw new CertificateException("Parent certificate of server was different than expected signing certificate"); 
      try {
        String str1 = param1ArrayOfX509Certificate[0].getSubjectDN().getName();
        int i = str1.indexOf("CN=");
        param1String = str1;
        if (i >= 0) {
          str1 = str1.substring(i + 3);
          i = str1.indexOf(",");
          param1String = str1;
          if (i >= 0)
            param1String = str1.substring(0, i); 
        } 
        String[] arrayOfString = param1String.split("\\.");
        if (arrayOfString.length >= 2) {
          StringBuilder stringBuilder = new StringBuilder();
          this();
          str = stringBuilder.append(arrayOfString[arrayOfString.length - 2]).append(".").append(arrayOfString[arrayOfString.length - 1]).toString();
        } 
        if (!b.c.containsKey(Long.valueOf(Thread.currentThread().getId()))) {
          throwable = new CertificateException();
          this("No valid host provided!");
          throw throwable;
        } 
      } catch (Throwable null) {
        if (throwable instanceof CertificateException)
          throw new CertificateException(throwable); 
      } 
      if (!((String)b.c.get(Long.valueOf(Thread.currentThread().getId()))).endsWith(str)) {
        throwable = new CertificateException();
        this("Server certificate has incorrect host name!");
        throw throwable;
      } 
      throwable[0].verify(this.a.getPublicKey());
      throwable[0].checkValidity();
    }
    
    public final X509Certificate[] getAcceptedIssuers() {
      return null;
    }
  }
  
  public static class d {
    public int a;
    
    public String b;
    
    d() {
      this(600, "");
    }
    
    d(int param1Int, String param1String) {
      this.a = param1Int;
      this.b = param1String;
    }
    
    public int a() {
      return this.a;
    }
    
    public String b() {
      return this.b;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */