package com.alipay.sdk.packet;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.sdk.data.c;
import com.alipay.sdk.net.a;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.tid.b;
import com.alipay.sdk.util.a;
import com.alipay.sdk.util.b;
import com.alipay.sdk.util.k;
import com.alipay.sdk.util.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicHeader;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d {
  public static final String a = "msp-gzip";
  
  public static final String b = "Msp-Param";
  
  public static final String c = "Operation-Type";
  
  public static final String d = "content-type";
  
  public static final String e = "Version";
  
  public static final String f = "AppId";
  
  public static final String g = "des-mode";
  
  public static final String h = "namespace";
  
  public static final String i = "api_name";
  
  public static final String j = "api_version";
  
  public static final String k = "data";
  
  public static final String l = "params";
  
  public static final String m = "public_key";
  
  public static final String n = "device";
  
  public static final String o = "action";
  
  public static final String p = "type";
  
  public static final String q = "method";
  
  private static a t;
  
  protected boolean r = true;
  
  protected boolean s = true;
  
  private b a(Context paramContext) throws Throwable {
    return a(paramContext, "", k.a(paramContext), true);
  }
  
  private b a(Context paramContext, String paramString1, String paramString2) throws Throwable {
    return a(paramContext, paramString1, paramString2, true);
  }
  
  public static String a(HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2) throws JSONException {
    JSONObject jSONObject2 = new JSONObject();
    JSONObject jSONObject3 = new JSONObject();
    for (Map.Entry<String, String> entry : paramHashMap1.entrySet())
      jSONObject3.put((String)entry.getKey(), entry.getValue()); 
    JSONObject jSONObject1 = new JSONObject();
    for (Map.Entry<String, String> entry : paramHashMap2.entrySet())
      jSONObject1.put((String)entry.getKey(), entry.getValue()); 
    jSONObject3.put("params", jSONObject1);
    jSONObject2.put("data", jSONObject3);
    return jSONObject2.toString();
  }
  
  private static String a(HttpResponse paramHttpResponse, String paramString) {
    HttpResponse httpResponse = null;
    if (paramHttpResponse == null)
      return (String)httpResponse; 
    Header[] arrayOfHeader = paramHttpResponse.getAllHeaders();
    paramHttpResponse = httpResponse;
    if (arrayOfHeader != null) {
      paramHttpResponse = httpResponse;
      if (arrayOfHeader.length > 0) {
        int i = arrayOfHeader.length;
        byte b = 0;
        while (true) {
          paramHttpResponse = httpResponse;
          if (b < i) {
            Header header = arrayOfHeader[b];
            if (header != null) {
              String str = header.getName();
              if (str != null && str.equalsIgnoreCase(paramString))
                return header.getValue(); 
            } 
            b++;
            continue;
          } 
          return (String)paramHttpResponse;
        } 
      } 
    } 
    return (String)paramHttpResponse;
  }
  
  public static JSONObject a(String paramString1, String paramString2) throws JSONException {
    JSONObject jSONObject1 = new JSONObject();
    JSONObject jSONObject2 = new JSONObject();
    jSONObject2.put("type", paramString1);
    jSONObject2.put("method", paramString2);
    jSONObject1.put("action", jSONObject2);
    return jSONObject1;
  }
  
  private static boolean a(String paramString) {
    boolean bool2;
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString))
      return bool1; 
    try {
      JSONObject jSONObject2 = new JSONObject();
      this(paramString);
      JSONObject jSONObject1 = jSONObject2.getJSONObject("data");
      bool2 = bool1;
      if (jSONObject1.has("params")) {
        String str = jSONObject1.getJSONObject("params").optString("public_key", null);
        bool2 = bool1;
        if (!TextUtils.isEmpty(str)) {
          b.a();
          c.a().a(str);
          bool2 = true;
        } 
      } 
    } catch (JSONException jSONException) {
      bool2 = bool1;
    } 
    return bool2;
  }
  
  private static boolean a(HttpResponse paramHttpResponse) {
    String str;
    HttpResponse httpResponse = null;
    if (paramHttpResponse == null) {
      paramHttpResponse = httpResponse;
      return Boolean.valueOf((String)paramHttpResponse).booleanValue();
    } 
    Header[] arrayOfHeader = paramHttpResponse.getAllHeaders();
    paramHttpResponse = httpResponse;
    if (arrayOfHeader != null) {
      paramHttpResponse = httpResponse;
      if (arrayOfHeader.length > 0) {
        int i = arrayOfHeader.length;
        byte b = 0;
        while (true) {
          paramHttpResponse = httpResponse;
          if (b < i) {
            Header header = arrayOfHeader[b];
            if (header != null) {
              str = header.getName();
              if (str != null && str.equalsIgnoreCase("msp-gzip")) {
                str = header.getValue();
                return Boolean.valueOf(str).booleanValue();
              } 
            } 
            b++;
            continue;
          } 
          return Boolean.valueOf(str).booleanValue();
        } 
      } 
    } 
    return Boolean.valueOf(str).booleanValue();
  }
  
  private static a b(Context paramContext, String paramString) {
    if (t == null) {
      t = new a(paramContext, paramString);
      return t;
    } 
    if (!TextUtils.equals(paramString, t.b))
      t.b = paramString; 
    return t;
  }
  
  private static byte[] b(HttpResponse paramHttpResponse) throws IllegalStateException, IOException {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: sipush #1024
    //   5: newarray byte
    //   7: astore_2
    //   8: aload_0
    //   9: invokeinterface getEntity : ()Lorg/apache/http/HttpEntity;
    //   14: invokeinterface getContent : ()Ljava/io/InputStream;
    //   19: astore_3
    //   20: new java/io/ByteArrayOutputStream
    //   23: astore #4
    //   25: aload #4
    //   27: invokespecial <init> : ()V
    //   30: aload_3
    //   31: aload_2
    //   32: invokevirtual read : ([B)I
    //   35: istore #5
    //   37: iload #5
    //   39: iconst_m1
    //   40: if_icmpeq -> 77
    //   43: aload #4
    //   45: aload_2
    //   46: iconst_0
    //   47: iload #5
    //   49: invokevirtual write : ([BII)V
    //   52: goto -> 30
    //   55: astore_0
    //   56: aload #4
    //   58: astore_1
    //   59: aload_3
    //   60: ifnull -> 67
    //   63: aload_3
    //   64: invokevirtual close : ()V
    //   67: aload_1
    //   68: ifnull -> 75
    //   71: aload_1
    //   72: invokevirtual close : ()V
    //   75: aload_0
    //   76: athrow
    //   77: aload #4
    //   79: invokevirtual toByteArray : ()[B
    //   82: astore_0
    //   83: aload_3
    //   84: ifnull -> 91
    //   87: aload_3
    //   88: invokevirtual close : ()V
    //   91: aload #4
    //   93: invokevirtual close : ()V
    //   96: aload_0
    //   97: areturn
    //   98: astore_3
    //   99: goto -> 91
    //   102: astore_3
    //   103: goto -> 96
    //   106: astore_3
    //   107: goto -> 67
    //   110: astore_3
    //   111: goto -> 75
    //   114: astore_0
    //   115: aconst_null
    //   116: astore_3
    //   117: goto -> 59
    //   120: astore_0
    //   121: goto -> 59
    // Exception table:
    //   from	to	target	type
    //   8	20	114	finally
    //   20	30	120	finally
    //   30	37	55	finally
    //   43	52	55	finally
    //   63	67	106	java/lang/Exception
    //   71	75	110	java/lang/Exception
    //   77	83	55	finally
    //   87	91	98	java/lang/Exception
    //   91	96	102	java/lang/Exception
  }
  
  public b a(Context paramContext, String paramString) throws Throwable {
    return a(paramContext, paramString, k.a(paramContext), true);
  }
  
  public final b a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean) throws Throwable {
    // Byte code:
    //   0: aconst_null
    //   1: astore #5
    //   3: iconst_0
    //   4: istore #6
    //   6: new com/alipay/sdk/packet/e
    //   9: dup
    //   10: aload_0
    //   11: getfield s : Z
    //   14: invokespecial <init> : (Z)V
    //   17: astore #7
    //   19: new com/alipay/sdk/packet/b
    //   22: astore #8
    //   24: aload #8
    //   26: aload_0
    //   27: invokevirtual c : ()Ljava/lang/String;
    //   30: aload_0
    //   31: aload_2
    //   32: aload_0
    //   33: invokevirtual a : ()Lorg/json/JSONObject;
    //   36: invokevirtual a : (Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    //   39: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload #7
    //   44: aload #8
    //   46: aload_0
    //   47: getfield r : Z
    //   50: invokevirtual a : (Lcom/alipay/sdk/packet/b;Z)Lcom/alipay/sdk/packet/c;
    //   53: astore #8
    //   55: getstatic com/alipay/sdk/packet/d.t : Lcom/alipay/sdk/net/a;
    //   58: ifnonnull -> 204
    //   61: new com/alipay/sdk/net/a
    //   64: astore #9
    //   66: aload #9
    //   68: aload_1
    //   69: aload_3
    //   70: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;)V
    //   73: aload #9
    //   75: putstatic com/alipay/sdk/packet/d.t : Lcom/alipay/sdk/net/a;
    //   78: getstatic com/alipay/sdk/packet/d.t : Lcom/alipay/sdk/net/a;
    //   81: astore #10
    //   83: aload_0
    //   84: aload #8
    //   86: getfield a : Z
    //   89: aload_2
    //   90: invokevirtual a : (ZLjava/lang/String;)Ljava/util/List;
    //   93: astore #9
    //   95: aload #10
    //   97: aload #8
    //   99: getfield b : [B
    //   102: aload #9
    //   104: invokevirtual a : ([BLjava/util/List;)Lorg/apache/http/HttpResponse;
    //   107: astore #9
    //   109: aload #9
    //   111: ifnonnull -> 230
    //   114: aload #5
    //   116: astore #8
    //   118: aload #8
    //   120: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Boolean;
    //   123: invokevirtual booleanValue : ()Z
    //   126: istore #11
    //   128: aload #9
    //   130: invokestatic b : (Lorg/apache/http/HttpResponse;)[B
    //   133: astore #8
    //   135: new com/alipay/sdk/packet/c
    //   138: astore #5
    //   140: aload #5
    //   142: iload #11
    //   144: aload #8
    //   146: invokespecial <init> : (Z[B)V
    //   149: aload #7
    //   151: aload #5
    //   153: invokevirtual a : (Lcom/alipay/sdk/packet/c;)Lcom/alipay/sdk/packet/b;
    //   156: astore #5
    //   158: aload #5
    //   160: astore #8
    //   162: aload #5
    //   164: ifnull -> 201
    //   167: aload #5
    //   169: astore #8
    //   171: aload #5
    //   173: getfield a : Ljava/lang/String;
    //   176: invokestatic a : (Ljava/lang/String;)Z
    //   179: ifeq -> 201
    //   182: aload #5
    //   184: astore #8
    //   186: iload #4
    //   188: ifeq -> 201
    //   191: aload_0
    //   192: aload_1
    //   193: aload_2
    //   194: aload_3
    //   195: iconst_0
    //   196: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Lcom/alipay/sdk/packet/b;
    //   199: astore #8
    //   201: aload #8
    //   203: areturn
    //   204: aload_3
    //   205: getstatic com/alipay/sdk/packet/d.t : Lcom/alipay/sdk/net/a;
    //   208: getfield b : Ljava/lang/String;
    //   211: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   214: ifne -> 78
    //   217: getstatic com/alipay/sdk/packet/d.t : Lcom/alipay/sdk/net/a;
    //   220: aload_3
    //   221: putfield b : Ljava/lang/String;
    //   224: goto -> 78
    //   227: astore_1
    //   228: aload_1
    //   229: athrow
    //   230: aload #9
    //   232: invokeinterface getAllHeaders : ()[Lorg/apache/http/Header;
    //   237: astore #10
    //   239: aload #5
    //   241: astore #8
    //   243: aload #10
    //   245: ifnull -> 118
    //   248: aload #5
    //   250: astore #8
    //   252: aload #10
    //   254: arraylength
    //   255: ifle -> 118
    //   258: aload #10
    //   260: arraylength
    //   261: istore #12
    //   263: aload #5
    //   265: astore #8
    //   267: iload #6
    //   269: iload #12
    //   271: if_icmpge -> 118
    //   274: aload #10
    //   276: iload #6
    //   278: aaload
    //   279: astore #13
    //   281: aload #13
    //   283: ifnull -> 322
    //   286: aload #13
    //   288: invokeinterface getName : ()Ljava/lang/String;
    //   293: astore #8
    //   295: aload #8
    //   297: ifnull -> 322
    //   300: aload #8
    //   302: ldc 'msp-gzip'
    //   304: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   307: ifeq -> 322
    //   310: aload #13
    //   312: invokeinterface getValue : ()Ljava/lang/String;
    //   317: astore #8
    //   319: goto -> 118
    //   322: iinc #6, 1
    //   325: goto -> 263
    // Exception table:
    //   from	to	target	type
    //   19	78	227	java/lang/Throwable
    //   78	109	227	java/lang/Throwable
    //   118	158	227	java/lang/Throwable
    //   171	182	227	java/lang/Throwable
    //   191	201	227	java/lang/Throwable
    //   204	224	227	java/lang/Throwable
    //   230	239	227	java/lang/Throwable
    //   252	263	227	java/lang/Throwable
    //   286	295	227	java/lang/Throwable
    //   300	319	227	java/lang/Throwable
  }
  
  public String a(String paramString, JSONObject paramJSONObject) {
    b b = b.a();
    b b1 = b.a();
    JSONObject jSONObject = b.a(new JSONObject(), paramJSONObject);
    try {
      String str2;
      String str4;
      jSONObject.put("tid", b1.a);
      c c = c.a();
      Context context1 = (b.a()).a;
      a a1 = a.a(context1);
      if (TextUtils.isEmpty(c.a)) {
        String str13 = l.b();
        str4 = l.c();
        String str12 = l.f(context1);
        String str14 = k.a(context1);
        str14 = str14.substring(0, str14.indexOf("://"));
        String str15 = l.g(context1);
        TextView textView = new TextView();
        this(context1);
        String str16 = Float.toString(textView.getTextSize());
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        c.a = stringBuilder1.append("Msp/15.5.2").append(" (").append(str13).append(";").append(str4).append(";").append(str12).append(";").append(str14).append(";").append(str15).append(";").append(str16).toString();
      } 
      String str8 = (a.b(context1)).p;
      String str7 = a1.a();
      String str6 = a1.b();
      Context context2 = (b.a()).a;
      SharedPreferences sharedPreferences1 = context2.getSharedPreferences("virtualImeiAndImsi", 0);
      String str1 = sharedPreferences1.getString("virtual_imsi", null);
      String str3 = str1;
      if (TextUtils.isEmpty(str1)) {
        if (TextUtils.isEmpty((b.a()).a)) {
          str1 = b.a().c();
          if (TextUtils.isEmpty(str1)) {
            str1 = c.b();
          } else {
            str1 = str1.substring(3, 18);
          } 
        } else {
          str1 = a.a(context2).a();
        } 
        sharedPreferences1.edit().putString("virtual_imsi", str1).commit();
        str3 = str1;
      } 
      Context context3 = (b.a()).a;
      SharedPreferences sharedPreferences2 = context3.getSharedPreferences("virtualImeiAndImsi", 0);
      String str5 = sharedPreferences2.getString("virtual_imei", null);
      str1 = str5;
      if (TextUtils.isEmpty(str5)) {
        if (TextUtils.isEmpty((b.a()).a)) {
          str1 = c.b();
        } else {
          str1 = a.a(context3).b();
        } 
        sharedPreferences2.edit().putString("virtual_imei", str1).commit();
      } 
      if (b1 != null)
        c.c = b1.b; 
      String str10 = Build.MANUFACTURER.replace(";", " ");
      String str9 = Build.MODEL.replace(";", " ");
      boolean bool = b.b();
      String str11 = a1.a;
      WifiInfo wifiInfo2 = ((WifiManager)context1.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
      if (wifiInfo2 != null) {
        str4 = wifiInfo2.getSSID();
      } else {
        str4 = "-1";
      } 
      WifiInfo wifiInfo1 = ((WifiManager)context1.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
      if (wifiInfo1 != null) {
        str2 = wifiInfo1.getBSSID();
      } else {
        str2 = "00";
      } 
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append(c.a).append(";").append(str8).append(";").append("-1;-1").append(";").append("1").append(";").append(str7).append(";").append(str6).append(";").append(c.c).append(";").append(str10).append(";").append(str9).append(";").append(bool).append(";").append(str11).append(";-1;-1;").append(c.b).append(";").append(str3).append(";").append(str1).append(";").append(str4).append(";").append(str2);
      if (b1 != null) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        this();
        hashMap.put("tid", b1.a);
        hashMap.put("utdid", b.a().c());
        String str = c.b(context1, hashMap);
        if (!TextUtils.isEmpty(str))
          stringBuilder.append(";").append(str); 
      } 
      stringBuilder.append(")");
      jSONObject.put("user_agent", stringBuilder.toString());
      jSONObject.put("has_alipay", l.c(b.a));
      jSONObject.put("has_msp_app", l.b(b.a));
      jSONObject.put("external_info", paramString);
      jSONObject.put("app_key", "2014052600006128");
      jSONObject.put("utdid", b.c());
      jSONObject.put("new_client_key", b1.b);
      c.a();
      jSONObject.put("pa", c.a(b.a));
    } catch (Throwable throwable) {}
    return jSONObject.toString();
  }
  
  public List<Header> a(boolean paramBoolean, String paramString) {
    ArrayList<BasicHeader> arrayList = new ArrayList();
    arrayList.add(new BasicHeader("msp-gzip", String.valueOf(paramBoolean)));
    arrayList.add(new BasicHeader("Operation-Type", "alipay.msp.cashier.dispatch.bytes"));
    arrayList.add(new BasicHeader("content-type", "application/octet-stream"));
    arrayList.add(new BasicHeader("Version", "2.0"));
    arrayList.add(new BasicHeader("AppId", "TAOBAO"));
    arrayList.add(new BasicHeader("Msp-Param", a.a(paramString)));
    arrayList.add(new BasicHeader("des-mode", "CBC"));
    return (List)arrayList;
  }
  
  public abstract JSONObject a() throws JSONException;
  
  public String b() {
    return "4.9.0";
  }
  
  public String c() throws JSONException {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("device", Build.MODEL);
    hashMap.put("namespace", "com.alipay.mobilecashier");
    hashMap.put("api_name", "com.alipay.mcpay");
    hashMap.put("api_version", b());
    return a((HashMap)hashMap, new HashMap<String, String>());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\packet\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */