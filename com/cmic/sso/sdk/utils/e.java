package com.cmic.sso.sdk.utils;

import android.net.Network;
import android.os.Bundle;
import android.text.TextUtils;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
  private Network a;
  
  private String b;
  
  private String c = "";
  
  private int d = 1;
  
  private String e = null;
  
  private Bundle f;
  
  private void a(com.cmic.sso.sdk.b.a.e parame, Bundle paramBundle) {
    String str1 = ab.a();
    String str2 = ab.b();
    paramBundle.putString("ipv4List", str1);
    paramBundle.putString("ipv6List", str2);
    com.cmic.sso.sdk.b.a.e.a a = parame.b();
    if (!paramBundle.getBoolean("isCloseIpv4", false))
      a.a(ab.a()); 
    if (!paramBundle.getBoolean("isCloseIpv6", true))
      a.b(ab.b()); 
    a.v(a.w(paramBundle.getString("appkey")));
    parame.a(a);
  }
  
  private void a(String paramString1, int paramInt, a parama, HttpURLConnection paramHttpURLConnection, Network paramNetwork, String paramString2, String paramString3, String paramString4) {
    String str;
    Bundle bundle;
    StringBuilder stringBuilder;
    if (paramInt == 302 || paramInt == 301) {
      try {
        paramString4 = this.f.getString("interfacecode", "");
        Bundle bundle1 = this.f;
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        bundle1.putString("interfacecode", stringBuilder1.append(paramString4).append(String.valueOf(paramInt)).append(";").toString());
        str = paramHttpURLConnection.getHeaderField("Location");
        if (this.e == null)
          this.e = paramHttpURLConnection.getHeaderField("pplocation"); 
        if (!TextUtils.isEmpty(str)) {
          String str1 = this.f.getString("interfacetype", "");
          if ("2".equals(this.f.getString("operatorType", "0"))) {
            Bundle bundle2 = this.f;
            stringBuilder1 = new StringBuilder();
            this();
            bundle2.putString("interfacetype", stringBuilder1.append(str1).append("getUnicomMobile;").toString());
          } else {
            bundle = this.f;
            stringBuilder = new StringBuilder();
            this();
            bundle.putString("interfacetype", stringBuilder.append(str1).append("getTelecomMobile;").toString());
          } 
          a(str, "", parama, paramNetwork, "GET");
          return;
        } 
      } catch (Exception exception) {
        com.cmic.sso.sdk.c.a.a.add(exception);
        String str1 = paramString1;
        if (TextUtils.isEmpty(paramString1))
          str1 = "网络异常"; 
        parama.a("200028", str1, this.c);
        return;
      } 
      parama.a("200038", "电信重定向失败", this.c);
      return;
    } 
    if (paramInt != 200) {
      String str1;
      StringBuilder stringBuilder1 = new StringBuilder();
      this();
      h.a("HttpUtils", stringBuilder1.append("http response code is not 200 ---").append(paramInt).toString());
      this.d++;
      if (this.d <= 3 && (!k.a(this.b) || bundle.contains("logReport"))) {
        a((String)bundle, str, parama, paramNetwork, (String)stringBuilder);
        return;
      } 
      if (paramInt == 0) {
        stringBuilder1 = new StringBuilder();
        this();
        parama.a(stringBuilder1.append(paramInt).append("").toString(), "请求出错", this.c);
        return;
      } 
      if (paramInt == Integer.valueOf("200050").intValue()) {
        parama.a("200050", "EOF异常", this.c);
        return;
      } 
      if (paramInt == Integer.valueOf("200072").intValue()) {
        parama.a("200072", "ca根证书校验失败", this.c);
        return;
      } 
      if (paramInt == Integer.valueOf("102507").intValue()) {
        stringBuilder1 = new StringBuilder();
        this();
        parama.a(stringBuilder1.append(paramInt).append("").toString(), paramString1, this.c);
        return;
      } 
      if (TextUtils.isEmpty(paramString1)) {
        str1 = "网络异常";
      } else {
        str1 = paramString1;
      } 
      parama.a("200028", str1, this.c);
      return;
    } 
    boolean bool = TextUtils.isEmpty(this.e);
    if (!bool) {
      try {
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        h.b("HttpUtils", stringBuilder1.append("电信取号结果 = ").append(paramString1).toString());
        JSONObject jSONObject = new JSONObject();
        this(paramString1);
        String str1 = jSONObject.optString("result", "0");
        str = this.f.getString("interfacecode", "");
        Bundle bundle1 = this.f;
        StringBuilder stringBuilder2 = new StringBuilder();
        this();
        bundle1.putString("interfacecode", stringBuilder2.append(str).append(str1).append(";").toString());
        if (!TextUtils.isEmpty(jSONObject.getString("result")) && "0".equals(jSONObject.getString("result"))) {
          StringBuilder stringBuilder4 = new StringBuilder();
          this();
          h.c("HttpUtils", stringBuilder4.append("pplocation").append(this.e).toString());
          stringBuilder4 = new StringBuilder();
          this();
          String str2 = stringBuilder4.append("http://www.cmpassport.com/unisdk/").append(this.e).append("&data=").append(jSONObject.getString("data")).toString();
          String str3 = this.f.getString("interfacetype", "");
          Bundle bundle2 = this.f;
          stringBuilder2 = new StringBuilder();
          this();
          bundle2.putString("interfacetype", stringBuilder2.append(str3).append("getNewTelecomPhoneNumberNotify;").toString());
          this.e = null;
          StringBuilder stringBuilder3 = new StringBuilder();
          this();
          h.c("HttpUtils", stringBuilder3.append("location").append(str2).toString());
          a(str2, "", parama, paramNetwork, "GET");
          return;
        } 
      } catch (JSONException jSONException) {
        com.cmic.sso.sdk.c.a.a.add(jSONException);
        parama.a("200039", "电信取号接口失败", this.c);
        return;
      } 
      parama.a("200039", "电信取号接口失败", this.c);
      return;
    } 
    parama.a(paramString1, this.c);
  }
  
  private <T extends com.cmic.sso.sdk.b.a.h> void a(String paramString1, T paramT, a parama, String paramString2) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #5
    //   3: iconst_0
    //   4: istore #6
    //   6: ldc 'HttpUtils'
    //   8: ldc 'in  wifiNetwork'
    //   10: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   13: aconst_null
    //   14: invokestatic a : (Landroid/content/Context;)Lcom/cmic/sso/sdk/utils/ad;
    //   17: astore #7
    //   19: getstatic android/os/Build$VERSION.SDK_INT : I
    //   22: bipush #21
    //   24: if_icmplt -> 151
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield a : Landroid/net/Network;
    //   32: aload #7
    //   34: new com/cmic/sso/sdk/utils/e$1
    //   37: dup
    //   38: aload_0
    //   39: invokespecial <init> : (Lcom/cmic/sso/sdk/utils/e;)V
    //   42: invokevirtual a : (Lcom/cmic/sso/sdk/utils/ad$a;)V
    //   45: aload_0
    //   46: getfield a : Landroid/net/Network;
    //   49: ifnonnull -> 100
    //   52: iload #6
    //   54: iconst_1
    //   55: iadd
    //   56: istore #5
    //   58: ldc2_w 50
    //   61: invokestatic sleep : (J)V
    //   64: ldc 'HttpUtils'
    //   66: ldc_w 'waiting for newtwork'
    //   69: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   72: iload #5
    //   74: istore #6
    //   76: iload #5
    //   78: bipush #60
    //   80: if_icmple -> 45
    //   83: aload_3
    //   84: ldc_w '200024'
    //   87: ldc_w '数据网络切换失败'
    //   90: aload_0
    //   91: getfield c : Ljava/lang/String;
    //   94: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   99: return
    //   100: aload_0
    //   101: invokestatic a : ()Ljava/lang/String;
    //   104: putfield c : Ljava/lang/String;
    //   107: aload_1
    //   108: ldc_w 'getPrePhonescrip'
    //   111: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   114: ifeq -> 129
    //   117: aload_0
    //   118: aload_2
    //   119: checkcast com/cmic/sso/sdk/b/a/e
    //   122: aload_0
    //   123: getfield f : Landroid/os/Bundle;
    //   126: invokespecial a : (Lcom/cmic/sso/sdk/b/a/e;Landroid/os/Bundle;)V
    //   129: aload_0
    //   130: aload_1
    //   131: aload_2
    //   132: invokevirtual a : ()Lorg/json/JSONObject;
    //   135: invokevirtual toString : ()Ljava/lang/String;
    //   138: aload_3
    //   139: aload_0
    //   140: getfield a : Landroid/net/Network;
    //   143: aload #4
    //   145: invokespecial a : (Ljava/lang/String;Ljava/lang/String;Lcom/cmic/sso/sdk/utils/e$a;Landroid/net/Network;Ljava/lang/String;)V
    //   148: goto -> 99
    //   151: getstatic com/cmic/sso/sdk/utils/ad.a : Landroid/net/ConnectivityManager;
    //   154: iconst_0
    //   155: ldc_w 'enableHIPRI'
    //   158: invokevirtual startUsingNetworkFeature : (ILjava/lang/String;)I
    //   161: pop
    //   162: iload #5
    //   164: istore #6
    //   166: iload #6
    //   168: bipush #30
    //   170: if_icmpge -> 196
    //   173: getstatic com/cmic/sso/sdk/utils/ad.a : Landroid/net/ConnectivityManager;
    //   176: iconst_5
    //   177: invokevirtual getNetworkInfo : (I)Landroid/net/NetworkInfo;
    //   180: invokevirtual getState : ()Landroid/net/NetworkInfo$State;
    //   183: getstatic android/net/NetworkInfo$State.CONNECTED : Landroid/net/NetworkInfo$State;
    //   186: invokevirtual compareTo : (Ljava/lang/Enum;)I
    //   189: istore #5
    //   191: iload #5
    //   193: ifne -> 303
    //   196: aload_1
    //   197: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   200: invokestatic a : (Ljava/lang/String;)I
    //   203: istore #6
    //   205: getstatic com/cmic/sso/sdk/utils/ad.a : Landroid/net/ConnectivityManager;
    //   208: iconst_5
    //   209: iload #6
    //   211: invokevirtual requestRouteToHost : (II)Z
    //   214: istore #8
    //   216: ldc 'HttpUtils'
    //   218: new java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial <init> : ()V
    //   225: ldc_w '切换数据网络结果 >>> '
    //   228: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: iload #8
    //   233: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   236: invokevirtual toString : ()Ljava/lang/String;
    //   239: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   242: iload #8
    //   244: ifeq -> 337
    //   247: ldc 'HttpUtils'
    //   249: ldc_w '切换网络成功'
    //   252: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload_0
    //   256: invokestatic a : ()Ljava/lang/String;
    //   259: putfield c : Ljava/lang/String;
    //   262: aload_1
    //   263: ldc_w 'getPrePhonescrip'
    //   266: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   269: ifeq -> 284
    //   272: aload_0
    //   273: aload_2
    //   274: checkcast com/cmic/sso/sdk/b/a/e
    //   277: aload_0
    //   278: getfield f : Landroid/os/Bundle;
    //   281: invokespecial a : (Lcom/cmic/sso/sdk/b/a/e;Landroid/os/Bundle;)V
    //   284: aload_0
    //   285: aload_1
    //   286: aload_2
    //   287: invokevirtual a : ()Lorg/json/JSONObject;
    //   290: invokevirtual toString : ()Ljava/lang/String;
    //   293: aload_3
    //   294: aconst_null
    //   295: aload #4
    //   297: invokespecial a : (Ljava/lang/String;Ljava/lang/String;Lcom/cmic/sso/sdk/utils/e$a;Landroid/net/Network;Ljava/lang/String;)V
    //   300: goto -> 99
    //   303: ldc2_w 1000
    //   306: invokestatic sleep : (J)V
    //   309: iinc #6, 1
    //   312: goto -> 166
    //   315: astore #7
    //   317: getstatic com/cmic/sso/sdk/c/a.a : Ljava/util/ArrayList;
    //   320: aload #7
    //   322: invokevirtual add : (Ljava/lang/Object;)Z
    //   325: pop
    //   326: ldc 'HttpUtils'
    //   328: ldc_w 'check hipri failed'
    //   331: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   334: goto -> 196
    //   337: ldc 'HttpUtils'
    //   339: ldc_w '切换网络失败or无数据网络'
    //   342: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_3
    //   346: ldc_w '200024'
    //   349: ldc_w '数据网络切换失败'
    //   352: aload_0
    //   353: getfield c : Ljava/lang/String;
    //   356: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   361: goto -> 99
    // Exception table:
    //   from	to	target	type
    //   173	191	315	java/lang/InterruptedException
    //   303	309	315	java/lang/InterruptedException
  }
  
  private void a(String paramString1, String paramString2, a parama, Network paramNetwork, String paramString3) {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Ljava/lang/String;
    //   4: invokestatic a : (Ljava/lang/String;)Z
    //   7: ifeq -> 30
    //   10: aload_1
    //   11: ldc 'logReport'
    //   13: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   16: ifne -> 30
    //   19: aload_1
    //   20: ldc_w 'Config'
    //   23: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   26: ifne -> 30
    //   29: return
    //   30: aconst_null
    //   31: astore #6
    //   33: aconst_null
    //   34: astore #7
    //   36: new java/lang/StringBuilder
    //   39: astore #8
    //   41: aload #8
    //   43: invokespecial <init> : ()V
    //   46: ldc 'HttpUtils'
    //   48: aload #8
    //   50: ldc_w 'try '
    //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield d : I
    //   60: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   63: ldc_w ' http reqeust, url: '
    //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_1
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual toString : ()Ljava/lang/String;
    //   76: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   79: new java/net/URL
    //   82: astore #8
    //   84: aload #8
    //   86: aload_1
    //   87: invokespecial <init> : (Ljava/lang/String;)V
    //   90: getstatic android/os/Build$VERSION.SDK_INT : I
    //   93: bipush #21
    //   95: if_icmplt -> 598
    //   98: aload #4
    //   100: ifnull -> 598
    //   103: aload #4
    //   105: aload #8
    //   107: invokevirtual openConnection : (Ljava/net/URL;)Ljava/net/URLConnection;
    //   110: checkcast java/net/HttpURLConnection
    //   113: astore #9
    //   115: ldc 'HttpUtils'
    //   117: ldc_w 'is network null?不为空'
    //   120: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_1
    //   124: ldc_w 'https'
    //   127: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   130: ifeq -> 146
    //   133: aload #9
    //   135: checkcast javax/net/ssl/HttpsURLConnection
    //   138: aload_0
    //   139: getfield f : Landroid/os/Bundle;
    //   142: aload_1
    //   143: invokestatic a : (Ljavax/net/ssl/HttpsURLConnection;Landroid/os/Bundle;Ljava/lang/String;)V
    //   146: aload #9
    //   148: sipush #15000
    //   151: invokevirtual setConnectTimeout : (I)V
    //   154: aload #9
    //   156: sipush #19000
    //   159: invokevirtual setReadTimeout : (I)V
    //   162: aload #9
    //   164: ldc_w 'traceId'
    //   167: aload_0
    //   168: getfield b : Ljava/lang/String;
    //   171: invokevirtual addRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload_0
    //   175: getfield f : Landroid/os/Bundle;
    //   178: ifnull -> 221
    //   181: aload #9
    //   183: ldc_w 'appid'
    //   186: aload_0
    //   187: getfield f : Landroid/os/Bundle;
    //   190: ldc_w 'appid'
    //   193: ldc ''
    //   195: invokevirtual getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   198: invokevirtual addRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload #9
    //   203: ldc_w 'interfaceVersion'
    //   206: aload_0
    //   207: getfield f : Landroid/os/Bundle;
    //   210: ldc_w 'interfaceVersion'
    //   213: ldc ''
    //   215: invokevirtual getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   218: invokevirtual addRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   221: aload #9
    //   223: ldc_w 'sdkVersion'
    //   226: ldc_w 'quick_login_android_5.6.5.1'
    //   229: invokevirtual addRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload #9
    //   234: iconst_0
    //   235: invokevirtual setUseCaches : (Z)V
    //   238: aload #9
    //   240: ldc_w 'Content-Type'
    //   243: ldc_w 'application/json'
    //   246: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   249: aload_1
    //   250: ldc_w 'preGetMobile'
    //   253: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   256: ifeq -> 270
    //   259: aload #9
    //   261: ldc_w 'Content-Type'
    //   264: ldc_w 'application/x-www-form-urlencoded'
    //   267: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload_1
    //   271: ldc_w 'getPrePhonescrip'
    //   274: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   277: ifeq -> 291
    //   280: aload #9
    //   282: ldc_w 'defendEOF'
    //   285: ldc_w '1'
    //   288: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   291: aload #9
    //   293: ldc_w 'Charset'
    //   296: ldc_w 'UTF-8'
    //   299: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   302: aload #9
    //   304: iconst_1
    //   305: invokevirtual setDoInput : (Z)V
    //   308: aload #9
    //   310: iconst_0
    //   311: invokevirtual setInstanceFollowRedirects : (Z)V
    //   314: aload #5
    //   316: ldc_w 'POST'
    //   319: invokevirtual equals : (Ljava/lang/Object;)Z
    //   322: ifeq -> 619
    //   325: aload #9
    //   327: ldc_w 'POST'
    //   330: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   333: aload #9
    //   335: iconst_1
    //   336: invokevirtual setDoOutput : (Z)V
    //   339: new java/io/DataOutputStream
    //   342: astore #8
    //   344: aload #8
    //   346: aload #9
    //   348: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   351: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   354: aload_2
    //   355: ldc_w 'UTF-8'
    //   358: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   361: astore #7
    //   363: aload #8
    //   365: aload #7
    //   367: iconst_0
    //   368: aload #7
    //   370: arraylength
    //   371: invokevirtual write : ([BII)V
    //   374: aload #8
    //   376: invokevirtual flush : ()V
    //   379: aload #9
    //   381: invokevirtual getResponseCode : ()I
    //   384: istore #10
    //   386: new java/io/BufferedReader
    //   389: astore #7
    //   391: new java/io/InputStreamReader
    //   394: astore #11
    //   396: aload #11
    //   398: aload #9
    //   400: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   403: invokespecial <init> : (Ljava/io/InputStream;)V
    //   406: aload #7
    //   408: aload #11
    //   410: invokespecial <init> : (Ljava/io/Reader;)V
    //   413: new java/lang/StringBuilder
    //   416: astore #11
    //   418: aload #11
    //   420: ldc ''
    //   422: invokespecial <init> : (Ljava/lang/String;)V
    //   425: aload #7
    //   427: invokevirtual readLine : ()Ljava/lang/String;
    //   430: astore #6
    //   432: aload #6
    //   434: ifnull -> 642
    //   437: new java/lang/String
    //   440: astore #12
    //   442: aload #12
    //   444: aload #6
    //   446: invokevirtual getBytes : ()[B
    //   449: ldc_w 'utf-8'
    //   452: invokespecial <init> : ([BLjava/lang/String;)V
    //   455: aload #11
    //   457: aload #12
    //   459: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: goto -> 425
    //   466: astore #9
    //   468: aload #9
    //   470: invokevirtual printStackTrace : ()V
    //   473: getstatic com/cmic/sso/sdk/c/a.a : Ljava/util/ArrayList;
    //   476: aload #9
    //   478: invokevirtual add : (Ljava/lang/Object;)Z
    //   481: pop
    //   482: aload #9
    //   484: instanceof javax/net/ssl/SSLHandshakeException
    //   487: ifne -> 498
    //   490: aload #9
    //   492: instanceof java/security/cert/CertPathValidatorException
    //   495: ifeq -> 530
    //   498: aload_0
    //   499: getfield f : Landroid/os/Bundle;
    //   502: ldc_w 'isNeedToGetCert'
    //   505: iconst_1
    //   506: invokevirtual putBoolean : (Ljava/lang/String;Z)V
    //   509: aload_0
    //   510: aconst_null
    //   511: ldc '200072'
    //   513: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   516: invokevirtual intValue : ()I
    //   519: aload_3
    //   520: aconst_null
    //   521: aload #4
    //   523: aload_2
    //   524: aload_1
    //   525: aload #5
    //   527: invokespecial a : (Ljava/lang/String;ILcom/cmic/sso/sdk/utils/e$a;Ljava/net/HttpURLConnection;Landroid/net/Network;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   530: aload #9
    //   532: instanceof java/io/EOFException
    //   535: ifeq -> 708
    //   538: aload_0
    //   539: aconst_null
    //   540: ldc '200050'
    //   542: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   545: invokevirtual intValue : ()I
    //   548: aload_3
    //   549: aconst_null
    //   550: aload #4
    //   552: aload_2
    //   553: aload_1
    //   554: aload #5
    //   556: invokespecial a : (Ljava/lang/String;ILcom/cmic/sso/sdk/utils/e$a;Ljava/net/HttpURLConnection;Landroid/net/Network;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   559: aload #8
    //   561: ifnull -> 569
    //   564: aload #8
    //   566: invokevirtual close : ()V
    //   569: aload #7
    //   571: ifnull -> 29
    //   574: aload #7
    //   576: invokevirtual close : ()V
    //   579: goto -> 29
    //   582: astore_1
    //   583: getstatic com/cmic/sso/sdk/c/a.a : Ljava/util/ArrayList;
    //   586: aload_1
    //   587: invokevirtual add : (Ljava/lang/Object;)Z
    //   590: pop
    //   591: aload_1
    //   592: invokevirtual printStackTrace : ()V
    //   595: goto -> 29
    //   598: aload #8
    //   600: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   603: checkcast java/net/HttpURLConnection
    //   606: astore #9
    //   608: ldc 'HttpUtils'
    //   610: ldc_w 'is network null?为空'
    //   613: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   616: goto -> 123
    //   619: aload #5
    //   621: ldc 'GET'
    //   623: invokevirtual equals : (Ljava/lang/Object;)Z
    //   626: ifeq -> 636
    //   629: aload #9
    //   631: ldc 'GET'
    //   633: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   636: aconst_null
    //   637: astore #8
    //   639: goto -> 379
    //   642: aload #11
    //   644: invokevirtual toString : ()Ljava/lang/String;
    //   647: astore #6
    //   649: aload #8
    //   651: ifnull -> 659
    //   654: aload #8
    //   656: invokevirtual close : ()V
    //   659: aload #7
    //   661: ifnull -> 669
    //   664: aload #7
    //   666: invokevirtual close : ()V
    //   669: aload_0
    //   670: aload #6
    //   672: iload #10
    //   674: aload_3
    //   675: aload #9
    //   677: aload #4
    //   679: aload_2
    //   680: aload_1
    //   681: aload #5
    //   683: invokespecial a : (Ljava/lang/String;ILcom/cmic/sso/sdk/utils/e$a;Ljava/net/HttpURLConnection;Landroid/net/Network;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   686: goto -> 29
    //   689: astore #8
    //   691: getstatic com/cmic/sso/sdk/c/a.a : Ljava/util/ArrayList;
    //   694: aload #8
    //   696: invokevirtual add : (Ljava/lang/Object;)Z
    //   699: pop
    //   700: aload #8
    //   702: invokevirtual printStackTrace : ()V
    //   705: goto -> 669
    //   708: aload_0
    //   709: aconst_null
    //   710: iconst_m1
    //   711: aload_3
    //   712: aconst_null
    //   713: aload #4
    //   715: aload_2
    //   716: aload_1
    //   717: aload #5
    //   719: invokespecial a : (Ljava/lang/String;ILcom/cmic/sso/sdk/utils/e$a;Ljava/net/HttpURLConnection;Landroid/net/Network;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   722: aload #8
    //   724: ifnull -> 732
    //   727: aload #8
    //   729: invokevirtual close : ()V
    //   732: aload #7
    //   734: ifnull -> 29
    //   737: aload #7
    //   739: invokevirtual close : ()V
    //   742: goto -> 29
    //   745: astore_1
    //   746: getstatic com/cmic/sso/sdk/c/a.a : Ljava/util/ArrayList;
    //   749: aload_1
    //   750: invokevirtual add : (Ljava/lang/Object;)Z
    //   753: pop
    //   754: aload_1
    //   755: invokevirtual printStackTrace : ()V
    //   758: goto -> 29
    //   761: astore_1
    //   762: aload #6
    //   764: astore_3
    //   765: aload #7
    //   767: astore_2
    //   768: aload_2
    //   769: ifnull -> 776
    //   772: aload_2
    //   773: invokevirtual close : ()V
    //   776: aload_3
    //   777: ifnull -> 784
    //   780: aload_3
    //   781: invokevirtual close : ()V
    //   784: aload_1
    //   785: athrow
    //   786: astore_2
    //   787: getstatic com/cmic/sso/sdk/c/a.a : Ljava/util/ArrayList;
    //   790: aload_2
    //   791: invokevirtual add : (Ljava/lang/Object;)Z
    //   794: pop
    //   795: aload_2
    //   796: invokevirtual printStackTrace : ()V
    //   799: goto -> 784
    //   802: astore_1
    //   803: aload #8
    //   805: astore_2
    //   806: aload #6
    //   808: astore_3
    //   809: goto -> 768
    //   812: astore_1
    //   813: aload #8
    //   815: astore_2
    //   816: aload #6
    //   818: astore_3
    //   819: goto -> 768
    //   822: astore_1
    //   823: aload #8
    //   825: astore_2
    //   826: aload #7
    //   828: astore_3
    //   829: goto -> 768
    //   832: astore_1
    //   833: aload #8
    //   835: astore_2
    //   836: aload #7
    //   838: astore_3
    //   839: goto -> 768
    //   842: astore #9
    //   844: aconst_null
    //   845: astore #8
    //   847: aconst_null
    //   848: astore #7
    //   850: goto -> 468
    //   853: astore #9
    //   855: aconst_null
    //   856: astore #7
    //   858: goto -> 468
    //   861: astore #9
    //   863: aconst_null
    //   864: astore #7
    //   866: goto -> 468
    // Exception table:
    //   from	to	target	type
    //   36	98	842	java/lang/Exception
    //   36	98	761	finally
    //   103	123	842	java/lang/Exception
    //   103	123	761	finally
    //   123	146	842	java/lang/Exception
    //   123	146	761	finally
    //   146	221	842	java/lang/Exception
    //   146	221	761	finally
    //   221	270	842	java/lang/Exception
    //   221	270	761	finally
    //   270	291	842	java/lang/Exception
    //   270	291	761	finally
    //   291	354	842	java/lang/Exception
    //   291	354	761	finally
    //   354	379	853	java/lang/Exception
    //   354	379	802	finally
    //   379	413	861	java/lang/Exception
    //   379	413	812	finally
    //   413	425	466	java/lang/Exception
    //   413	425	822	finally
    //   425	432	466	java/lang/Exception
    //   425	432	822	finally
    //   437	463	466	java/lang/Exception
    //   437	463	822	finally
    //   468	498	832	finally
    //   498	530	832	finally
    //   530	559	832	finally
    //   564	569	582	java/io/IOException
    //   574	579	582	java/io/IOException
    //   598	616	842	java/lang/Exception
    //   598	616	761	finally
    //   619	636	842	java/lang/Exception
    //   619	636	761	finally
    //   642	649	466	java/lang/Exception
    //   642	649	822	finally
    //   654	659	689	java/io/IOException
    //   664	669	689	java/io/IOException
    //   708	722	832	finally
    //   727	732	745	java/io/IOException
    //   737	742	745	java/io/IOException
    //   772	776	786	java/io/IOException
    //   780	784	786	java/io/IOException
  }
  
  private static void a(HttpsURLConnection paramHttpsURLConnection, Bundle paramBundle, String paramString) {
    if (!paramBundle.getBoolean("CLOSE_CERT_VERIFY", true) && !paramString.contains("https://config.cmpassport.com/client/uniConfig"))
      paramHttpsURLConnection.setSSLSocketFactory((new com.cmic.sso.sdk.b.c.a(paramBundle)).a().getSocketFactory()); 
  }
  
  public <T extends com.cmic.sso.sdk.b.a.h> void a(String paramString1, T paramT, boolean paramBoolean, a parama, String paramString2, String paramString3, Bundle paramBundle) {
    this.f = paramBundle;
    this.b = paramString3;
    if (!k.a(paramString3) || paramString1.contains("logReport") || paramString1.contains("Config")) {
      h.c("HttpUtils", "使用wifi下取号？？？？？？？" + paramBoolean);
      if (paramBoolean) {
        a(paramString1, paramT, parama, paramString2);
        return;
      } 
      if (paramString1.contains("getPrePhonescrip"))
        a((com.cmic.sso.sdk.b.a.e)paramT, paramBundle); 
      a(paramString1, paramT.a().toString(), parama, null, paramString2);
    } 
  }
  
  public static interface a {
    void a(String param1String1, String param1String2);
    
    void a(String param1String1, String param1String2, String param1String3);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */