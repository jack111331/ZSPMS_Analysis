package com.zz.sdk.i;

import android.content.Context;
import android.os.SystemClock;
import com.zz.sdk.ParamChain;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.aa;
import com.zz.sdk.b.a.ab;
import com.zz.sdk.b.a.ac;
import com.zz.sdk.b.a.ae;
import com.zz.sdk.b.a.af;
import com.zz.sdk.b.a.ag;
import com.zz.sdk.b.a.ah;
import com.zz.sdk.b.a.aj;
import com.zz.sdk.b.a.al;
import com.zz.sdk.b.a.ay;
import com.zz.sdk.b.a.b;
import com.zz.sdk.b.a.c;
import com.zz.sdk.b.a.e;
import com.zz.sdk.b.a.f;
import com.zz.sdk.b.a.g;
import com.zz.sdk.b.a.h;
import com.zz.sdk.b.a.i;
import com.zz.sdk.b.a.j;
import com.zz.sdk.b.a.k;
import com.zz.sdk.b.a.l;
import com.zz.sdk.b.a.m;
import com.zz.sdk.b.a.n;
import com.zz.sdk.b.a.p;
import com.zz.sdk.b.a.q;
import com.zz.sdk.b.a.r;
import com.zz.sdk.b.a.s;
import com.zz.sdk.b.a.v;
import com.zz.sdk.b.a.w;
import com.zz.sdk.b.a.x;
import com.zz.sdk.b.a.y;
import com.zz.sdk.b.a.z;
import com.zz.sdk.b.ac;
import com.zz.sdk.b.c;
import com.zz.sdk.b.h;
import com.zz.sdk.b.i;
import com.zz.sdk.b.o;
import com.zz.sdk.third.a.a;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class t {
  private static final String A = "code";
  
  private static final String B = "client_secret";
  
  private static final String C = "grant_type";
  
  private static final String D = "access_token";
  
  private static final String E = "phone";
  
  private static final String F = "vcode";
  
  private static final String G = "realName";
  
  private static final String H = "idCard";
  
  private static final String I = "phoneCode";
  
  private static final String J = "token";
  
  private static final String K = "platformOrderNum";
  
  private static final String L = "cpOrder";
  
  private static final String M = "email";
  
  private static final String N = "platformOrderNum";
  
  private static final String O = "__pu";
  
  private static final String P = "1";
  
  private static final String Q = "sign";
  
  private static final String R = "source";
  
  private static WeakReference T = null;
  
  public static final String a = "aSN";
  
  public static final String b = "aMSG";
  
  private static final String c = "productId";
  
  private static final String d = "sdkVersion";
  
  private static final String e = "projectId";
  
  private static final String f = "serverId";
  
  private static final String g = "loginName";
  
  private static final String h = "password";
  
  private static final String i = "newPassword";
  
  private static final String j = "deviceNum";
  
  private static final String k = "imsi";
  
  private static final String l = "platform";
  
  private static final String m = "redirect_uri";
  
  private static final String n = "client_id";
  
  private static final String o = "response_type";
  
  private static final String p = "type";
  
  private static final String q = "imei";
  
  private static final String r = "mac";
  
  private static final String s = "androidId";
  
  private static final String t = "AND";
  
  private static final String u = "code";
  
  private static final String v = "1";
  
  private static final String w = "r_role";
  
  private static final String x = "r_sign";
  
  private static final String y = "alias";
  
  private static final String z = "nickName";
  
  private Context S;
  
  public t(Context paramContext) {
    this.S = paramContext;
  }
  
  private e a(Class<e> paramClass, String paramString, int paramInt) {
    try {
      IllegalAccessException illegalAccessException1;
      IllegalAccessException illegalAccessException2;
      e e = paramClass.newInstance();
      try {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        bp.a(stringBuilder.append("get方式url 02:").append(paramString).toString());
        InputStream inputStream = b(paramString, paramInt);
        e e1 = e;
        if (inputStream != null) {
          String str = b(inputStream);
          try {
            JSONObject jSONObject = new JSONObject();
            this(str);
            bp.a(jSONObject);
          } catch (JSONException jSONException) {}
        } else {
          return (e)jSONException;
        } 
        e.a(bh.a((JSONObject)jSONException));
        return e;
      } catch (InstantiationException null) {
        e e1 = e;
        exception.printStackTrace();
        return e1;
      } catch (IllegalAccessException illegalAccessException) {
        e e1 = e;
        illegalAccessException2 = illegalAccessException;
      } catch (Exception null) {
        illegalAccessException1 = illegalAccessException2;
        exception.printStackTrace();
        return (e)illegalAccessException1;
      } 
      bp.a("bad class:" + exception);
      illegalAccessException2.printStackTrace();
      return (e)illegalAccessException1;
    } catch (InstantiationException null) {
      paramString = null;
    } catch (IllegalAccessException illegalAccessException) {
      paramString = null;
      bp.a("bad class:" + exception);
      illegalAccessException.printStackTrace();
      return (e)paramString;
    } catch (Exception exception) {
      paramString = null;
      exception.printStackTrace();
      return (e)paramString;
    } 
    exception.printStackTrace();
    return (e)paramString;
  }
  
  private i a(Class paramClass, String paramString, int paramInt, HashMap paramHashMap) {
    if (paramHashMap.size() > 0) {
      List list = a(paramHashMap);
      return a(paramClass, paramString, list, paramInt);
    } 
    paramHashMap = null;
    return a(paramClass, paramString, (List)paramHashMap, paramInt);
  }
  
  private i a(Class paramClass, String paramString, int paramInt, String[] paramArrayOfString1, String... paramVarArgs1) {
    byte b = 0;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramVarArgs1 != null && paramVarArgs1.length > 0)
      for (byte b1 = 0; b1 < paramVarArgs1.length; b1 += 2)
        hashMap.put(paramVarArgs1[b1], paramVarArgs1[b1 + 1]);  
    if (paramArrayOfString1 != null && paramArrayOfString1.length > 0)
      for (byte b1 = b; b1 < paramArrayOfString1.length; b1 += 2)
        hashMap.put(paramArrayOfString1[b1], paramArrayOfString1[b1 + 1]);  
    if (hashMap.size() > 0) {
      List list = a(hashMap);
      return a(paramClass, paramString, list, paramInt);
    } 
    paramArrayOfString1 = null;
    return a(paramClass, paramString, (List)paramArrayOfString1, paramInt);
  }
  
  private i a(Class<i> paramClass, String paramString, List paramList, int paramInt) {
    try {
      i i = paramClass.newInstance();
      try {
        StringBuilder stringBuilder2 = new StringBuilder();
        this();
        bp.a(stringBuilder2.append("doRequest url:").append(paramString).toString());
        stringBuilder2 = new StringBuilder();
        this();
        bp.a(stringBuilder2.append("doRequest request:").append(paramList).toString());
        InputStream inputStream = a(paramString, paramList, paramInt);
        if (inputStream != null) {
          bp.a("doRequest if parse");
          i.a(a(inputStream));
          return i;
        } 
        bp.a("doRequest else try backup");
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        bp.a(stringBuilder1.append("doRequest first url:").append(paramString).toString());
        i i1 = i;
        if (paramString.contains("https://sdk-api.yingxiong.com/")) {
          paramString = paramString.replace("//", "");
          String str2 = paramString.substring(paramString.indexOf("/") + 1);
          StringBuilder stringBuilder3 = new StringBuilder();
          this();
          String str1 = stringBuilder3.append("https://yx.zhuoyuechenxing.com/").append(str2).toString();
          StringBuilder stringBuilder4 = new StringBuilder();
          this();
          bp.a(stringBuilder4.append("doRequest backup newUrl:").append(str1).toString());
          InputStream inputStream1 = a(str1, paramList, paramInt);
          if (inputStream1 != null) {
            i.a(a(inputStream1));
            v.a(new String[] { "https://yx.zhuoyuechenxing.com/" });
            return i;
          } 
          bp.a("request backup is null");
          i1 = i;
        } 
        return i1;
      } catch (Exception null) {}
    } catch (Exception exception) {
      paramClass = null;
    } 
    bp.a("doRequest e:" + exception.getMessage());
    exception.printStackTrace();
    return (i)paramClass;
  }
  
  public static t a(Context paramContext) {
    t t1;
    if (T == null) {
      t1 = null;
    } else {
      t1 = T.get();
    } 
    t t2 = t1;
    if (t1 == null) {
      t2 = new t(paramContext);
      T = new WeakReference<t>(t2);
    } 
    return t2;
  }
  
  private InputStream a(String paramString, List paramList, int paramInt) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: aload_0
    //   4: getfield S : Landroid/content/Context;
    //   7: invokestatic a : (Landroid/content/Context;)Lorg/apache/http/client/HttpClient;
    //   10: astore #5
    //   12: aload #5
    //   14: ifnonnull -> 22
    //   17: aload #4
    //   19: astore_1
    //   20: aload_1
    //   21: areturn
    //   22: invokestatic getSocketFactory : ()Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   25: new org/apache/http/conn/ssl/AllowAllHostnameVerifier
    //   28: dup
    //   29: invokespecial <init> : ()V
    //   32: invokevirtual setHostnameVerifier : (Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V
    //   35: new org/apache/http/client/methods/HttpPost
    //   38: dup
    //   39: aload_1
    //   40: invokespecial <init> : (Ljava/lang/String;)V
    //   43: astore #6
    //   45: aload_2
    //   46: ifnull -> 67
    //   49: new org/apache/http/client/entity/UrlEncodedFormEntity
    //   52: astore_1
    //   53: aload_1
    //   54: aload_2
    //   55: ldc_w 'utf-8'
    //   58: invokespecial <init> : (Ljava/util/List;Ljava/lang/String;)V
    //   61: aload #6
    //   63: aload_1
    //   64: invokevirtual setEntity : (Lorg/apache/http/HttpEntity;)V
    //   67: aload #6
    //   69: invokestatic a : (Lorg/apache/http/client/methods/HttpRequestBase;)V
    //   72: iconst_0
    //   73: istore #7
    //   75: iload #7
    //   77: iload_3
    //   78: if_icmpge -> 222
    //   81: aload #5
    //   83: aload #6
    //   85: invokeinterface execute : (Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   90: astore_1
    //   91: aload_1
    //   92: invokeinterface getStatusLine : ()Lorg/apache/http/StatusLine;
    //   97: invokeinterface getStatusCode : ()I
    //   102: istore #8
    //   104: new java/lang/StringBuilder
    //   107: astore_2
    //   108: aload_2
    //   109: invokespecial <init> : ()V
    //   112: aload_2
    //   113: ldc_w 'doRequest status:'
    //   116: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: iload #8
    //   121: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   124: invokevirtual toString : ()Ljava/lang/String;
    //   127: invokestatic a : (Ljava/lang/Object;)V
    //   130: iload #8
    //   132: sipush #200
    //   135: if_icmpne -> 167
    //   138: aload_1
    //   139: invokeinterface getEntity : ()Lorg/apache/http/HttpEntity;
    //   144: invokeinterface getContent : ()Ljava/io/InputStream;
    //   149: astore_1
    //   150: goto -> 20
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual printStackTrace : ()V
    //   158: ldc_w 'UnsupportedEncodingException'
    //   161: invokestatic a : (Ljava/lang/Object;)V
    //   164: goto -> 67
    //   167: ldc_w 'doRequest not ok, return null'
    //   170: invokestatic a : (Ljava/lang/Object;)V
    //   173: aload #4
    //   175: astore_1
    //   176: goto -> 20
    //   179: astore_1
    //   180: new java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial <init> : ()V
    //   187: ldc_w 'doRequest e:'
    //   190: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_1
    //   194: invokevirtual getMessage : ()Ljava/lang/String;
    //   197: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual toString : ()Ljava/lang/String;
    //   203: invokestatic a : (Ljava/lang/Object;)V
    //   206: iinc #7, 1
    //   209: ldc2_w 2000
    //   212: invokestatic sleep : (J)V
    //   215: goto -> 75
    //   218: astore_1
    //   219: goto -> 75
    //   222: ldc_w 'doRequest return null'
    //   225: invokestatic a : (Ljava/lang/Object;)V
    //   228: aload #4
    //   230: astore_1
    //   231: goto -> 20
    // Exception table:
    //   from	to	target	type
    //   49	67	153	java/io/UnsupportedEncodingException
    //   81	130	179	java/lang/Exception
    //   138	150	179	java/lang/Exception
    //   167	173	179	java/lang/Exception
    //   209	215	218	java/lang/InterruptedException
  }
  
  private List a(HashMap<String, String> paramHashMap) {
    if (!paramHashMap.containsKey("productId"))
      paramHashMap.put("productId", cv.h(this.S)); 
    if (!paramHashMap.containsKey("projectId"))
      paramHashMap.put("projectId", cv.g(this.S)); 
    if (!paramHashMap.containsKey("serverId"))
      paramHashMap.put("serverId", cv.j(this.S)); 
    if (!paramHashMap.containsKey("deviceNum"))
      paramHashMap.put("deviceNum", cv.n(this.S)); 
    if (!paramHashMap.containsKey("platform"))
      paramHashMap.put("platform", "AND"); 
    if (!paramHashMap.containsKey("sdkVersion"))
      paramHashMap.put("sdkVersion", "3.4.4"); 
    if (!paramHashMap.containsKey("imei"))
      paramHashMap.put("imei", cv.o(this.S)); 
    if (!paramHashMap.containsKey("mac"))
      paramHashMap.put("mac", cv.p(this.S)); 
    if (!paramHashMap.containsKey("androidId"))
      paramHashMap.put("androidId", cv.q(this.S)); 
    if (a.a() && !paramHashMap.containsKey("__pu"))
      paramHashMap.put("__pu", "1"); 
    bh.a(paramHashMap);
    ArrayList<BasicNameValuePair> arrayList = new ArrayList();
    String str = cv.d();
    if (str != null)
      arrayList.add(new BasicNameValuePair("sign", bt.a(paramHashMap, str))); 
    for (Map.Entry<String, String> entry : paramHashMap.entrySet())
      arrayList.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())); 
    arrayList.add(new BasicNameValuePair("market", "AND"));
    return arrayList;
  }
  
  private JSONObject a(InputStream paramInputStream) {
    JSONObject jSONObject;
    String str = b(paramInputStream);
    bp.a("request result:" + str);
    try {
      jSONObject = new JSONObject();
      this(str);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      bp.a("D: error!");
      jSONObject = new JSONObject();
    } 
    return bh.a(jSONObject);
  }
  
  public static void a(t paramt) {}
  
  private InputStream b(String paramString, int paramInt) {
    String str = null;
    HttpClient httpClient = bi.a(this.S);
    if (httpClient == null)
      return (InputStream)str; 
    HttpGet httpGet = new HttpGet(paramString);
    bh.a((HttpRequestBase)httpGet);
    byte b = 0;
    while (true) {
      paramString = str;
      if (b < paramInt) {
        try {
          HttpResponse httpResponse = httpClient.execute((HttpUriRequest)httpGet);
          int i = httpResponse.getStatusLine().getStatusCode();
          StringBuilder stringBuilder = new StringBuilder();
          this();
          bp.a(stringBuilder.append("doGetRequest status:").append(i).toString());
          if (i == 200)
            return httpResponse.getEntity().getContent(); 
        } catch (IOException iOException) {
          bp.a(iOException);
        } 
        SystemClock.sleep(2000L);
        b++;
        continue;
      } 
      return (InputStream)iOException;
    } 
  }
  
  private String b(InputStream paramInputStream) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: ifnonnull -> 10
    //   6: aload_2
    //   7: astore_3
    //   8: aload_3
    //   9: areturn
    //   10: new java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial <init> : ()V
    //   17: astore_3
    //   18: new java/io/BufferedReader
    //   21: dup
    //   22: new java/io/InputStreamReader
    //   25: dup
    //   26: aload_1
    //   27: invokespecial <init> : (Ljava/io/InputStream;)V
    //   30: invokespecial <init> : (Ljava/io/Reader;)V
    //   33: astore #4
    //   35: aload #4
    //   37: invokevirtual readLine : ()Ljava/lang/String;
    //   40: astore #5
    //   42: aload #5
    //   44: ifnull -> 93
    //   47: aload_3
    //   48: aload #5
    //   50: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: goto -> 35
    //   57: astore_3
    //   58: aload #4
    //   60: ifnull -> 68
    //   63: aload #4
    //   65: invokevirtual close : ()V
    //   68: aload_2
    //   69: astore_3
    //   70: aload_1
    //   71: ifnull -> 8
    //   74: aload_1
    //   75: invokevirtual close : ()V
    //   78: aload_2
    //   79: astore_3
    //   80: goto -> 8
    //   83: astore_1
    //   84: aload_1
    //   85: invokevirtual printStackTrace : ()V
    //   88: aload_2
    //   89: astore_3
    //   90: goto -> 8
    //   93: aload_3
    //   94: invokevirtual toString : ()Ljava/lang/String;
    //   97: astore_3
    //   98: aload_3
    //   99: astore_2
    //   100: aload #4
    //   102: ifnull -> 110
    //   105: aload #4
    //   107: invokevirtual close : ()V
    //   110: aload_2
    //   111: astore_3
    //   112: aload_1
    //   113: ifnull -> 8
    //   116: aload_1
    //   117: invokevirtual close : ()V
    //   120: aload_2
    //   121: astore_3
    //   122: goto -> 8
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual printStackTrace : ()V
    //   130: aload_2
    //   131: astore_3
    //   132: goto -> 8
    //   135: astore_3
    //   136: aload_3
    //   137: invokevirtual printStackTrace : ()V
    //   140: goto -> 110
    //   143: astore_3
    //   144: aload_3
    //   145: invokevirtual printStackTrace : ()V
    //   148: goto -> 68
    //   151: astore_2
    //   152: aload #4
    //   154: ifnull -> 162
    //   157: aload #4
    //   159: invokevirtual close : ()V
    //   162: aload_1
    //   163: ifnull -> 170
    //   166: aload_1
    //   167: invokevirtual close : ()V
    //   170: aload_2
    //   171: athrow
    //   172: astore_3
    //   173: aload_3
    //   174: invokevirtual printStackTrace : ()V
    //   177: goto -> 162
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual printStackTrace : ()V
    //   185: goto -> 170
    // Exception table:
    //   from	to	target	type
    //   35	42	57	java/lang/Exception
    //   35	42	151	finally
    //   47	54	57	java/lang/Exception
    //   47	54	151	finally
    //   63	68	143	java/io/IOException
    //   74	78	83	java/io/IOException
    //   93	98	57	java/lang/Exception
    //   93	98	151	finally
    //   105	110	135	java/io/IOException
    //   116	120	125	java/io/IOException
    //   157	162	172	java/io/IOException
    //   166	170	180	java/io/IOException
  }
  
  private List b(HashMap paramHashMap) {
    ArrayList<BasicNameValuePair> arrayList = new ArrayList();
    String str = cv.f();
    if (str != null)
      arrayList.add(new BasicNameValuePair("sign", bt.a(paramHashMap, str))); 
    for (Map.Entry entry : paramHashMap.entrySet())
      arrayList.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())); 
    bp.a("acco_request:" + arrayList);
    return arrayList;
  }
  
  public a a(Context paramContext, String paramString, ParamChain paramParamChain) {
    c c = new c(paramContext, paramParamChain);
    return (a)a(a.class, at.aj.a(), 1, new String[] { 
          "loginName", paramString, "systemVersion", "" + c.e, "deviceType", c.b, "imei", c.d, "imsi", c.c, 
          "latitude", "" + c.i, "longtitude", "" + c.j, "area", "" + c.k, "netType", c.l, "projectId", c.m, 
          "sdkVersion", c.a });
  }
  
  public a a(ac paramac) {
    return (a)a(a.class, at.ah.a(), 1, new String[] { "actionType", "" + paramac.x, "loginName", paramac.v, "memo", "" });
  }
  
  public a a(String paramString1, int paramInt, String paramString2) {
    return (a)a(a.class, at.x.a(), 1, new String[] { "phone", paramString1, "type", paramInt + "", "loginName", paramString2 });
  }
  
  public a a(String paramString1, String paramString2, String paramString3, int paramInt) {
    return (a)a(a.class, at.N.a(), 1, new String[] { "access_token", paramString1, "phone", paramString2, "code", paramString3, "type", String.valueOf(paramInt) });
  }
  
  public a a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {
    return (a)a(a.class, at.O.a(), 1, new String[] { "access_token", paramString1, "oldPhone", paramString2, "newPhone", paramString3, "code", paramString4, "type", String.valueOf(paramInt) });
  }
  
  public a a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    return (a)a(a.class, at.A.a(), 1, new String[] { "access_token", paramString1, "phone", paramString2, "vcode", paramString3, "password", bt.b(paramString4), "source", paramString5 });
  }
  
  public ac a() {
    return (ac)a(ac.class, at.u.a(), a(new HashMap<Object, Object>()), 1);
  }
  
  public af a(o paramo) {
    return (af)a(af.class, at.ac.a(), 2, new String[] { "requestId", "", "serverId", paramo.c, "loginName", paramo.a, "access_token", paramo.q });
  }
  
  public ah a(int paramInt1, int paramInt2) {
    return (ah)a(ah.class, at.ad.a(), 1, new String[] { "rowstart", String.valueOf(paramInt1), "rowcount", String.valueOf(paramInt2) });
  }
  
  public al a(int paramInt, o paramo) {
    // Byte code:
    //   0: iload_1
    //   1: lookupswitch default -> 156, 0 -> 182, 1 -> 189, 2 -> 182, 3 -> 196, 4 -> 196, 5 -> 203, 6 -> 196, 7 -> 217, 9 -> 182, 10 -> 182, 15 -> 224, 17 -> 238, 78 -> 196, 79 -> 196, 80 -> 245, 81 -> 231, 100 -> 189, 1002 -> 210
    //   156: ldc_w 'onkonw type!'
    //   159: invokestatic a : (Ljava/lang/Object;)V
    //   162: ldc_w com/zz/sdk/b/a/al
    //   165: astore_3
    //   166: aload_2
    //   167: iload_1
    //   168: invokevirtual a : (I)Ljava/util/HashMap;
    //   171: astore #4
    //   173: aload #4
    //   175: ifnonnull -> 252
    //   178: aconst_null
    //   179: astore_2
    //   180: aload_2
    //   181: areturn
    //   182: ldc_w com/zz/sdk/b/a/am
    //   185: astore_3
    //   186: goto -> 166
    //   189: ldc_w com/zz/sdk/b/a/ar
    //   192: astore_3
    //   193: goto -> 166
    //   196: ldc_w com/zz/sdk/b/a/au
    //   199: astore_3
    //   200: goto -> 166
    //   203: ldc_w com/zz/sdk/b/a/ap
    //   206: astore_3
    //   207: goto -> 166
    //   210: ldc_w com/zz/sdk/b/a/ap
    //   213: astore_3
    //   214: goto -> 166
    //   217: ldc_w com/zz/sdk/b/a/av
    //   220: astore_3
    //   221: goto -> 166
    //   224: ldc_w com/zz/sdk/b/a/at
    //   227: astore_3
    //   228: goto -> 166
    //   231: ldc_w com/zz/sdk/b/a/as
    //   234: astore_3
    //   235: goto -> 166
    //   238: ldc_w com/zz/sdk/b/a/ao
    //   241: astore_3
    //   242: goto -> 166
    //   245: ldc_w com/zz/sdk/b/a/an
    //   248: astore_3
    //   249: goto -> 166
    //   252: aload_0
    //   253: aload_3
    //   254: new java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial <init> : ()V
    //   261: getstatic com/zz/sdk/i/au.c : Lcom/zz/sdk/i/au;
    //   264: invokevirtual a : ()Ljava/lang/String;
    //   267: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload_2
    //   271: getfield l : Ljava/lang/String;
    //   274: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual toString : ()Ljava/lang/String;
    //   280: aload_0
    //   281: aload #4
    //   283: invokespecial a : (Ljava/util/HashMap;)Ljava/util/List;
    //   286: iconst_1
    //   287: invokespecial a : (Ljava/lang/Class;Ljava/lang/String;Ljava/util/List;I)Lcom/zz/sdk/b/i;
    //   290: checkcast com/zz/sdk/b/a/al
    //   293: astore_2
    //   294: goto -> 180
  }
  
  public ay a(long paramLong) {
    return (ay)a(ay.class, at.aa.a(), 1, new String[] { "access_token", cq.a(this.S).v(), "onlineDuration", String.valueOf(paramLong) });
  }
  
  public e a(String... paramVarArgs) {
    if (paramVarArgs != null && paramVarArgs.length > 0 && paramVarArgs.length % 2 == 0) {
      StringBuilder stringBuilder = new StringBuilder("http://i.yingxiong.com/wcenter/reddot");
      stringBuilder.append("?");
      for (byte b = 0; b < paramVarArgs.length; b += 2) {
        stringBuilder.append(paramVarArgs[b]);
        stringBuilder.append("=");
        stringBuilder.append(paramVarArgs[b + 1]);
        stringBuilder.append("&");
      } 
      return a(e.class, stringBuilder.substring(0, stringBuilder.length() - 1), 2);
    } 
    throw new RuntimeException("参数有问题(为空,长度为0,或者不成一对)");
  }
  
  public g a(String paramString1, String paramString2, int paramInt) {
    return (g)a(g.class, at.f.a(), 1, new String[] { "cmStatus", String.valueOf(paramInt), "loginName", paramString1, "password", bt.b(paramString2) });
  }
  
  public i a(String paramString1, String paramString2, String... paramVarArgs) {
    return (i)a(i.class, at.b.a(), 1, paramVarArgs, new String[] { "loginName", paramString1, "password", bt.b(paramString2), "redirect_uri", "1", "client_id", cv.d(), "response_type", "code" });
  }
  
  public k a(String paramString) {
    return (k)a(k.class, at.n.a(), 1, new String[] { "cdata", paramString, "redirect_uri", "1", "client_id", cv.d(), "response_type", "code" });
  }
  
  public k a(String paramString1, String paramString2) {
    return (k)a(k.class, at.o.a(), 1, new String[] { "phone", paramString1, "token", paramString2, "redirect_uri", "1", "client_id", cv.d(), "response_type", "code" });
  }
  
  public l a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String... paramVarArgs) {
    String str = cv.d(this.S);
    return (l)a(l.class, at.h.a(), 1, paramVarArgs, new String[] { 
          "imsi", str, "loginName", paramString1, "password", bt.b(paramString2), "nickName", paramString5, "realName", paramString3, 
          "idCard", paramString4, "vCode", paramString6, "redirect_uri", "1", "client_id", cv.d(), "response_type", "code", 
          "platform", "AND" });
  }
  
  public l a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String... paramVarArgs) {
    String str = cv.d(this.S);
    return (l)a(l.class, at.q.a(), 1, paramVarArgs, new String[] { 
          "imsi", str, "phone", paramString1, "vcode", paramString2, "password", bt.b(paramString3), "realName", paramString4, 
          "idCard", paramString5, "redirect_uri", "1", "client_id", cv.d(), "response_type", "code", "platform", "AND" });
  }
  
  public m a(a parama, int paramInt) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("type", parama.c());
    hashMap.put("token", parama.e());
    hashMap.put("uid", parama.d());
    hashMap.put("pkg", this.S.getPackageName());
    hashMap.put("response_type", "code");
    hashMap.put("client_id", cv.d());
    hashMap.put("redirect_uri", "1");
    for (Map.Entry entry : parama.g().entrySet())
      hashMap.put(entry.getKey(), (new StringBuilder()).append(entry.getValue()).append("").toString()); 
    return (m)a(m.class, at.k.a(), paramInt, hashMap);
  }
  
  public q a(String paramString1, String paramString2, String paramString3) {
    return (q)a(q.class, at.j.a(), 2, new String[] { "loginName", paramString1, "password", bt.b(paramString2), "newPassword", bt.b(paramString3), "productId", cv.h(this.S) });
  }
  
  public y a(int paramInt) {
    return (y)a(y.class, at.S.a(), 1, new String[] { "access_token", cq.a(this.S).v(), "hasAbl", String.valueOf(paramInt) });
  }
  
  public z a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
    return (z)a(z.class, at.t.a(), 1, new String[] { 
          "access_token", paramString1, "realName", paramString2, "idCard", paramString3, "phone", paramString4, "code", paramString5, 
          "source", paramString6 });
  }
  
  public i a(Class paramClass, String paramString, int paramInt, String... paramVarArgs) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramVarArgs != null && paramVarArgs.length > 0)
      for (byte b = 0; b < paramVarArgs.length; b += 2)
        hashMap.put(paramVarArgs[b], paramVarArgs[b + 1]);  
    if (hashMap.size() > 0) {
      List list = a(hashMap);
      return a(paramClass, paramString, list, paramInt);
    } 
    paramVarArgs = null;
    return a(paramClass, paramString, (List)paramVarArgs, paramInt);
  }
  
  public InputStream a(String paramString, int paramInt, String... paramVarArgs) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramVarArgs != null && paramVarArgs.length > 0)
      for (byte b = 0; b < paramVarArgs.length; b += 2)
        hashMap.put(paramVarArgs[b], paramVarArgs[b + 1]);  
    bp.a("acco_url:" + paramString);
    if (hashMap.size() > 0) {
      List list = b(hashMap);
      return a(paramString, list, paramInt);
    } 
    paramVarArgs = null;
    return a(paramString, (List)paramVarArgs, paramInt);
  }
  
  public String a(String paramString, int paramInt) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      bp.a(stringBuilder.append("get方式url 01:").append(paramString).toString());
      InputStream inputStream = b(paramString, paramInt);
      if (inputStream != null)
        return b(inputStream); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public a b(String paramString1, String paramString2, String paramString3) {
    return (a)a(a.class, at.af.a(), 1, new String[] { "platformOrderNum", paramString1, "payMsg", paramString2, "submitAmount", paramString3 });
  }
  
  public k b(String paramString1, String paramString2) {
    return (k)a(k.class, at.m.a(), 1, new String[] { "phone", paramString1, "code", paramString2, "redirect_uri", "1", "client_id", cv.d(), "response_type", "code" });
  }
  
  public n b(String paramString) {
    return (n)a(n.class, at.d.a(), 1, new String[] { "access_token", paramString });
  }
  
  public r b() {
    return (r)a(r.class, at.a.a(), 1, new String[] { "pkg", this.S.getPackageName() });
  }
  
  public x b(Context paramContext) {
    return (x)a(x.class, at.Y.a(), 1, new String[] { "access_token", cq.a(this.S).v(), "productId", cv.h(paramContext) });
  }
  
  public y b(int paramInt) {
    return (y)a(y.class, at.S.a(), 1, new String[] { "access_token", cq.a(this.S).v(), "isAbl", "1", "hasAbl", String.valueOf(paramInt) });
  }
  
  public y b(int paramInt1, int paramInt2) {
    return (y)a(y.class, at.S.a(), 1, new String[] { "access_token", cq.a(this.S).v(), "gpId", String.valueOf(paramInt1), "hasAbl", String.valueOf(paramInt2) });
  }
  
  public void b(String paramString1, String paramString2, int paramInt) {
    if (!cv.b(500))
      (new Thread(new u(this, paramString1, paramString2, paramInt, cq.a(this.S).v()))).start(); 
  }
  
  public a c(String paramString) {
    return (a)a(a.class, at.ag.a(), 1, new String[] { "platformOrderNum", paramString });
  }
  
  public a c(String paramString1, String paramString2, int paramInt) {
    return (a)a(a.class, at.M.a(), 1, new String[] { "access_token", paramString1, "phone", paramString2, "type", String.valueOf(paramInt) });
  }
  
  public a c(String paramString1, String paramString2, String paramString3) {
    return (a)a(a.class, at.F.a(), 1, new String[] { "phoneCode", paramString1, "loginName", paramString2, "phone", paramString3 });
  }
  
  public ac c() {
    return (ac)a(ac.class, at.w.a(), a(new HashMap<Object, Object>()), 1);
  }
  
  public f c(int paramInt) {
    return (f)a(f.class, at.U.a(), 1, new String[] { "access_token", cq.a(this.S).v(), "gpId", String.valueOf(paramInt) });
  }
  
  public j c(String paramString1, String paramString2) {
    return (j)a(j.class, at.c.a(), 1, new String[] { "code", paramString1, "redirect_uri", "1", "client_id", cv.d(), "client_secret", paramString2, "grant_type", "authorization_code" });
  }
  
  public List c(Context paramContext) {
    h[] arrayOfH;
    byte b2;
    byte b1 = 0;
    ArrayList<h> arrayList = new ArrayList();
    if (cm.b(paramContext, (cq.a(paramContext)).a.o)) {
      b2 = 1;
    } else {
      b2 = 0;
    } 
    y y = a(b2);
    if (y.c()) {
      bp.a("getAvailableGift...getGiftList...success");
      arrayOfH = y.n;
      int i = arrayOfH.length;
      for (b2 = b1; b2 < i; b2++) {
        h h = arrayOfH[b2];
        if (h.k == 1)
          if (h.i == 1) {
            if (h.q < h.r)
              arrayList.add(h); 
          } else {
            arrayList.add(h);
          }  
      } 
    } else {
      bp.a("getAvailableGift...getGiftList...fail:" + arrayOfH.f());
    } 
    return arrayList;
  }
  
  public a d(int paramInt) {
    return (a)a(a.class, at.W.a(), 1, new String[] { "access_token", cq.a(this.S).v(), "showInContact", String.valueOf(paramInt) });
  }
  
  public a d(String paramString1, String paramString2) {
    return (a)a(a.class, at.ab.a(), 1, new String[] { "access_token", cq.a(this.S).v(), "result", paramString1, "reason", paramString2 });
  }
  
  public a d(String paramString1, String paramString2, String paramString3) {
    return (a)a(a.class, at.C.a(), 1, new String[] { "access_token", paramString1, "phone", paramString2, "vcode", paramString3 });
  }
  
  public aa d(Context paramContext) {
    return (aa)a(aa.class, at.Z.a(), 1, new String[] { "access_token", cq.a(this.S).v(), "productId", cv.h(paramContext) });
  }
  
  public ae d(String paramString) {
    return (ae)a(ae.class, at.ae.a(), 1, new String[] { "platformOrderNum", paramString });
  }
  
  public h d() {
    String str = cv.d(this.S);
    return (h)a(h.class, at.i.a(), 1, new String[] { "redirect_uri", "1", "client_id", cv.d(), "response_type", "code", "imsi", str });
  }
  
  public a e(String paramString) {
    return (a)a(a.class, at.p.a(), 1, new String[] { "phone", paramString });
  }
  
  public a e(String paramString1, String paramString2, String paramString3) {
    return (a)a(a.class, at.r.a(), 1, new String[] { "access_token", paramString1, "alias", paramString2, "password", bt.b(paramString3) });
  }
  
  public ag e() {
    return (ag)a(ag.class, at.ai.a(), 2, new String[0]);
  }
  
  public p e(String paramString1, String paramString2) {
    return (p)a(p.class, at.ak.a(), 1, new String[] { "loginName", paramString1, "access_token", paramString2 });
  }
  
  public a f(String paramString) {
    return (a)a(a.class, at.G.a(), 1, new String[] { "phone", paramString });
  }
  
  public a f(String paramString1, String paramString2) {
    return (a)a(a.class, at.E.a(), 1, new String[] { "loginName", paramString1, "phone", paramString2 });
  }
  
  public a f(String paramString1, String paramString2, String paramString3) {
    return (a)a(a.class, at.s.a(), 1, new String[] { "access_token", paramString1, "loginName", paramString2, "phone", paramString3 });
  }
  
  public com.zz.sdk.b.a.t f() {
    return (com.zz.sdk.b.a.t)a(com.zz.sdk.b.a.t.class, at.e.a(), 2, new String[] { "deviceNum", cv.n(this.S) });
  }
  
  public a g(String paramString1, String paramString2) {
    return (a)a(a.class, at.z.a(), 1, new String[] { "access_token", paramString1, "phone", paramString2 });
  }
  
  public a g(String paramString1, String paramString2, String paramString3) {
    return (a)a(a.class, at.y.a(), 1, new String[] { "access_token", paramString1, "realName", paramString2, "idCard", paramString3 });
  }
  
  public ab g(String paramString) {
    return (ab)a(ab.class, at.J.a(), 1, new String[] { "loginName", paramString });
  }
  
  public b g() {
    return (b)a(b.class, at.g.a(), 1, new String[] { "pkg", this.S.getPackageName() });
  }
  
  public a h(String paramString1, String paramString2) {
    return (a)a(a.class, at.B.a(), 1, new String[] { "access_token", paramString1, "phone", paramString2 });
  }
  
  public a h(String paramString1, String paramString2, String paramString3) {
    return (a)a(a.class, at.D.a(), 1, new String[] { "access_token", paramString1, "r_role", paramString2, "r_sign", paramString3 });
  }
  
  public w h(String paramString) {
    return (w)a(w.class, at.L.a(), 1, new String[] { "access_token", paramString });
  }
  
  public y h() {
    return (y)a(y.class, at.T.a(), 1, new String[] { "access_token", cq.a(this.S).v() });
  }
  
  public a i(String paramString) {
    return (a)a(a.class, at.P.a(), 1, new String[] { "email", paramString });
  }
  
  public c i(String paramString1, String paramString2) {
    return (c)a(c.class, at.H.a(), 1, new String[] { "phone", paramString1, "phoneCode", paramString2 });
  }
  
  public v i(String paramString1, String paramString2, String paramString3) {
    return (v)a(v.class, at.I.a(), 1, new String[] { "phone", paramString1, "token", paramString2, "password", bt.b(paramString3) });
  }
  
  public a j(String paramString1, String paramString2, String paramString3) {
    return (a)a(a.class, at.R.a(), 1, new String[] { "email", paramString1, "authCode", paramString2, "password", bt.b(paramString3) });
  }
  
  public ae j(String paramString1, String paramString2) {
    return (ae)a(ae.class, at.ae.a(), 1, new String[] { "platformOrderNum", paramString1, "loginName", paramString2 });
  }
  
  public y j(String paramString) {
    return (y)a(y.class, at.S.a(), 1, new String[] { "access_token", cq.a(this.S).v(), "eventType", paramString });
  }
  
  public aj k(String paramString1, String paramString2) {
    return (aj)a(aj.class, at.v.a(), 1, new String[] { "access_token", paramString1, "loginName", paramString2 });
  }
  
  public s k(String paramString) {
    return (s)a(s.class, at.X.a(), 1, new String[] { "access_token", cq.a(this.S).v(), "source", paramString });
  }
  
  public a l(String paramString1, String paramString2) {
    return (a)a(a.class, at.K.a(), 1, new String[] { "access_token", paramString1, "email", paramString2 });
  }
  
  public a m(String paramString1, String paramString2) {
    return (a)a(a.class, at.Q.a(), 1, new String[] { "email", paramString1, "authCode", paramString2 });
  }
  
  public a n(String paramString1, String paramString2) {
    return (a)a(a.class, at.V.a(), 1, new String[] { "access_token", cq.a(this.S).v(), "contacts", paramString1, "source", paramString2 });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */