package com.herosdk.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.herosdk.HeroSdk;
import com.herosdk.bean.OrderInfo;
import com.herosdk.bean.RoleInfo;
import com.herosdk.d.bb;
import com.herosdk.d.k;
import com.herosdk.d.m;
import com.herosdk.d.o;
import com.herosdk.d.q;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class aq {
  private static final int b = 12000;
  
  private static final int c = 2;
  
  private static String d = "frameLib.hr";
  
  protected ai a = null;
  
  private List<String> e = null;
  
  private HashMap<String, String> f = null;
  
  private HashMap<String, List<String>> g = null;
  
  private int h = 0;
  
  private int i = 0;
  
  public aq() {
    this.e = new ArrayList<String>();
    this.a = (new aj()).a(12000).b(12000).a();
  }
  
  private ar a(String paramString, ap[] paramArrayOfap) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifne -> 11
    //   7: aload_2
    //   8: ifnonnull -> 21
    //   11: new java/lang/Exception
    //   14: dup
    //   15: ldc 'h p p is null error'
    //   17: invokespecial <init> : (Ljava/lang/String;)V
    //   20: athrow
    //   21: aload_0
    //   22: getfield e : Ljava/util/List;
    //   25: ifnonnull -> 39
    //   28: aload_0
    //   29: new java/util/ArrayList
    //   32: dup
    //   33: invokespecial <init> : ()V
    //   36: putfield e : Ljava/util/List;
    //   39: aload_0
    //   40: getfield e : Ljava/util/List;
    //   43: invokeinterface size : ()I
    //   48: ifne -> 66
    //   51: aload_1
    //   52: ldc 'login'
    //   54: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   57: ifeq -> 66
    //   60: ldc2_w 2000
    //   63: invokestatic sleep : (J)V
    //   66: aload_0
    //   67: getfield e : Ljava/util/List;
    //   70: invokeinterface size : ()I
    //   75: ifne -> 82
    //   78: aload_0
    //   79: invokevirtual a : ()V
    //   82: new java/lang/Exception
    //   85: dup
    //   86: ldc '网络异常：所有服务器轮询完毕并且全部失败'
    //   88: invokespecial <init> : (Ljava/lang/String;)V
    //   91: astore_3
    //   92: aload_0
    //   93: getfield h : I
    //   96: istore #4
    //   98: ldc ''
    //   100: astore #5
    //   102: aconst_null
    //   103: astore #6
    //   105: iconst_0
    //   106: istore #7
    //   108: iload #4
    //   110: aload_0
    //   111: getfield h : I
    //   114: if_icmpeq -> 143
    //   117: aload_3
    //   118: astore #8
    //   120: aload #6
    //   122: astore #9
    //   124: iload #4
    //   126: aload_0
    //   127: getfield e : Ljava/util/List;
    //   130: invokeinterface size : ()I
    //   135: irem
    //   136: aload_0
    //   137: getfield h : I
    //   140: if_icmpeq -> 455
    //   143: aload_0
    //   144: getfield e : Ljava/util/List;
    //   147: iload #4
    //   149: aload_0
    //   150: getfield e : Ljava/util/List;
    //   153: invokeinterface size : ()I
    //   158: irem
    //   159: invokeinterface get : (I)Ljava/lang/Object;
    //   164: checkcast java/lang/String
    //   167: astore #9
    //   169: aload #6
    //   171: astore #5
    //   173: new java/lang/StringBuilder
    //   176: astore #8
    //   178: aload #6
    //   180: astore #5
    //   182: aload #8
    //   184: invokespecial <init> : ()V
    //   187: aload #6
    //   189: astore #5
    //   191: aload #8
    //   193: aload #9
    //   195: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_1
    //   199: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual toString : ()Ljava/lang/String;
    //   205: astore #10
    //   207: aload #6
    //   209: astore #5
    //   211: new com/herosdk/b/an
    //   214: astore #8
    //   216: aload #6
    //   218: astore #5
    //   220: aload #8
    //   222: invokespecial <init> : ()V
    //   225: iconst_0
    //   226: istore #11
    //   228: aload #6
    //   230: astore #5
    //   232: iload #11
    //   234: aload_2
    //   235: arraylength
    //   236: if_icmpge -> 269
    //   239: aload #6
    //   241: astore #5
    //   243: aload #8
    //   245: aload_2
    //   246: iload #11
    //   248: aaload
    //   249: invokevirtual a : ()Ljava/lang/String;
    //   252: aload_2
    //   253: iload #11
    //   255: aaload
    //   256: invokevirtual b : ()Ljava/lang/String;
    //   259: invokevirtual a : (Ljava/lang/String;Ljava/lang/Object;)Lcom/herosdk/b/an;
    //   262: pop
    //   263: iinc #11, 1
    //   266: goto -> 228
    //   269: aload #6
    //   271: astore #5
    //   273: new com/herosdk/b/au
    //   276: astore #12
    //   278: aload #6
    //   280: astore #5
    //   282: aload #12
    //   284: invokespecial <init> : ()V
    //   287: aload #6
    //   289: astore #5
    //   291: aload #12
    //   293: aload #10
    //   295: invokevirtual a : (Ljava/lang/String;)Lcom/herosdk/b/au;
    //   298: aload #8
    //   300: invokevirtual a : ()Lcom/herosdk/b/am;
    //   303: invokevirtual a : (Lcom/herosdk/b/am;)Lcom/herosdk/b/au;
    //   306: invokevirtual b : ()Lcom/herosdk/b/au;
    //   309: invokevirtual c : ()Lcom/herosdk/b/at;
    //   312: astore #10
    //   314: aload #6
    //   316: astore #5
    //   318: aload_0
    //   319: invokespecial b : ()V
    //   322: aload #6
    //   324: astore #5
    //   326: aload_0
    //   327: getfield g : Ljava/util/HashMap;
    //   330: ifnull -> 386
    //   333: aload #6
    //   335: astore #5
    //   337: aload_0
    //   338: getfield g : Ljava/util/HashMap;
    //   341: invokevirtual isEmpty : ()Z
    //   344: ifne -> 386
    //   347: aload #6
    //   349: astore #5
    //   351: new com/herosdk/b/al
    //   354: astore #8
    //   356: aload #6
    //   358: astore #5
    //   360: aload #8
    //   362: invokespecial <init> : ()V
    //   365: aload #6
    //   367: astore #5
    //   369: aload #10
    //   371: aload #8
    //   373: aload_0
    //   374: getfield g : Ljava/util/HashMap;
    //   377: invokevirtual a : (Ljava/util/Map;)Lcom/herosdk/b/al;
    //   380: invokevirtual a : ()Lcom/herosdk/b/ak;
    //   383: invokevirtual a : (Lcom/herosdk/b/ak;)V
    //   386: aload #6
    //   388: astore #5
    //   390: aload_0
    //   391: getfield a : Lcom/herosdk/b/ai;
    //   394: aload #10
    //   396: invokevirtual a : (Lcom/herosdk/b/at;)Lcom/herosdk/b/ai;
    //   399: invokevirtual c : ()Lcom/herosdk/b/ar;
    //   402: astore #6
    //   404: aload #6
    //   406: astore #5
    //   408: aload #6
    //   410: invokevirtual b : ()Z
    //   413: istore #7
    //   415: aload #9
    //   417: astore #5
    //   419: aload_3
    //   420: astore #9
    //   422: aload #6
    //   424: astore_3
    //   425: aload #9
    //   427: astore #6
    //   429: iload #7
    //   431: ifeq -> 479
    //   434: invokestatic a : ()Lcom/herosdk/d/x;
    //   437: aload #5
    //   439: invokevirtual h : (Ljava/lang/String;)V
    //   442: aload_0
    //   443: iload #4
    //   445: putfield h : I
    //   448: aload_3
    //   449: astore #9
    //   451: aload #6
    //   453: astore #8
    //   455: iload #7
    //   457: iconst_1
    //   458: if_icmpne -> 495
    //   461: aload #9
    //   463: areturn
    //   464: astore #9
    //   466: aload #6
    //   468: astore_3
    //   469: aload #9
    //   471: astore #6
    //   473: iconst_0
    //   474: istore #7
    //   476: goto -> 429
    //   479: iinc #4, 1
    //   482: aload_3
    //   483: astore #9
    //   485: aload #6
    //   487: astore_3
    //   488: aload #9
    //   490: astore #6
    //   492: goto -> 108
    //   495: new java/lang/Exception
    //   498: dup
    //   499: aload #8
    //   501: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   504: athrow
    //   505: astore #6
    //   507: goto -> 66
    //   510: astore #6
    //   512: aload #5
    //   514: astore_3
    //   515: aload #9
    //   517: astore #5
    //   519: goto -> 473
    // Exception table:
    //   from	to	target	type
    //   60	66	505	java/lang/Exception
    //   143	169	464	java/lang/Exception
    //   173	178	510	java/lang/Exception
    //   182	187	510	java/lang/Exception
    //   191	207	510	java/lang/Exception
    //   211	216	510	java/lang/Exception
    //   220	225	510	java/lang/Exception
    //   232	239	510	java/lang/Exception
    //   243	263	510	java/lang/Exception
    //   273	278	510	java/lang/Exception
    //   282	287	510	java/lang/Exception
    //   291	314	510	java/lang/Exception
    //   318	322	510	java/lang/Exception
    //   326	333	510	java/lang/Exception
    //   337	347	510	java/lang/Exception
    //   351	356	510	java/lang/Exception
    //   360	365	510	java/lang/Exception
    //   369	386	510	java/lang/Exception
    //   390	404	510	java/lang/Exception
    //   408	415	510	java/lang/Exception
  }
  
  private ar b(String paramString, ap[] paramArrayOfap) {
    boolean bool2;
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString) || paramArrayOfap == null)
      throw new Exception("h n f s is null error"); 
    ar ar1 = null;
    Exception exception2 = new Exception("网络请求失败");
    ar ar2 = ar1;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      ar2 = ar1;
      this();
      ar2 = ar1;
      paramString = stringBuilder.append(o.b("cuSSObOhwrSpP5VgZW0SZn5dNPtwWWKm2BiU9VFBZgY=", o.b())).append(paramString).toString();
      ar2 = ar1;
      an an = new an();
      ar2 = ar1;
      this();
      byte b = 0;
      while (true) {
        ar2 = ar1;
        if (b < paramArrayOfap.length) {
          ar2 = ar1;
          an.a(paramArrayOfap[b].a(), paramArrayOfap[b].b());
          b++;
          continue;
        } 
        ar2 = ar1;
        au au = new au();
        ar2 = ar1;
        this();
        ar2 = ar1;
        at at = au.a(paramString).a(an.a()).b().c();
        ar2 = ar1;
        b();
        ar2 = ar1;
        if (this.g != null) {
          ar2 = ar1;
          if (!this.g.isEmpty()) {
            ar2 = ar1;
            al al = new al();
            ar2 = ar1;
            this();
            ar2 = ar1;
            at.a(al.a(this.g).a());
          } 
        } 
        ar2 = ar1;
        ar ar = this.a.a(at).c();
        ar2 = ar;
        bool2 = ar.b();
        ar2 = ar;
        exception1 = exception2;
        if (bool2 == true)
          return ar2; 
        throw new Exception(exception1);
      } 
    } catch (Exception exception1) {
      bool2 = bool1;
    } 
    if (bool2 == true)
      return ar2; 
    throw new Exception(exception1);
  }
  
  private void b() {
    try {
      if (this.f != null) {
        Iterator<Map.Entry> iterator = this.f.entrySet().iterator();
        if (iterator != null)
          while (true) {
            if (iterator.hasNext()) {
              Map.Entry entry = iterator.next();
              String str2 = (String)entry.getKey();
              String str1 = (String)entry.getValue();
              if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str1))
                a(str2, str1); 
              continue;
            } 
            return;
          }  
      } 
    } catch (Exception exception) {
      this.g = null;
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public ar a(Context paramContext) {
    this.i = 0;
    String str1 = o.b("oNx1c0mcCL27pgBYYj8M0FYYbhJW17PED+M1cKtehET7JKO+UV14BPrzL2Oho226", o.b());
    String str2 = str1;
    if (x.a().R())
      str2 = bb.a(str1); 
    a(str2);
    a();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("active", bb.d(paramContext));
    m m = m.a(paramContext);
    hashMap.put("osn", m.d());
    hashMap.put("ccd", m.h());
    hashMap.put("ssn", m.l());
    hashMap.put("wmc", m.m());
    hashMap.put("ctp", m.n());
    hashMap.put("mbn", m.o());
    hashMap.put("tm", String.valueOf(m.r()));
    return a("/v1/sys/init.lg", ao.b(paramContext, (HashMap)hashMap));
  }
  
  public ar a(Context paramContext, Object paramObject) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("apps", paramObject);
    return a("/v1/sys/updpkg.lg", ao.b(paramContext, (HashMap)hashMap));
  }
  
  public ar a(Context paramContext, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("accessToken", ao.a);
    hashMap.put("orderId", paramString);
    return a("/v1/pay/checkOrder.lg", ao.b(paramContext, (HashMap)hashMap));
  }
  
  public ar a(Context paramContext, String paramString1, String paramString2) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("accessToken", ao.a);
    hashMap.put("oId", paramString1);
    hashMap.put("ok", paramString2);
    return a("/v1/pay/noticeSuccess.lg", ao.b(paramContext, (HashMap)hashMap));
  }
  
  public ar a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("accessToken", ao.a);
    hashMap.put("orderId", paramString1);
    hashMap.put("goodsId", paramString2);
    hashMap.put("channelCustomMsg", paramString3);
    return a("/v1/pay/buyYsGoods.lg", ao.b(paramContext, (HashMap)hashMap));
  }
  
  public ar a(Context paramContext, String paramString1, String paramString2, String paramString3, OrderInfo paramOrderInfo, RoleInfo paramRoleInfo, String paramString4) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("accessToken", ao.a);
    hashMap.put("uid", paramString1);
    hashMap.put("username", paramString2);
    hashMap.put("channelToken", paramString3);
    hashMap.put("cpOrder", paramOrderInfo.getCpOrderId());
    hashMap.put("goodsId", paramOrderInfo.getGoodsId());
    hashMap.put("amount", Double.valueOf(paramOrderInfo.getAmount()));
    hashMap.put("callbackUrl", paramOrderInfo.getCallbackUrl());
    hashMap.put("customMsg", paramOrderInfo.getExtraParams());
    hashMap.put("channelCustomMsg", paramString4);
    hashMap.put("serverId", paramRoleInfo.getServerId());
    hashMap.put("serverName", paramRoleInfo.getServerName());
    hashMap.put("roleId", paramRoleInfo.getRoleId());
    hashMap.put("roleName", paramRoleInfo.getRoleName());
    hashMap.put("roleBalance", paramRoleInfo.getRoleBalance());
    hashMap.put("roleLevel", paramRoleInfo.getRoleLevel());
    hashMap.put("vipLevel", paramRoleInfo.getVipLevel());
    hashMap.put("partyName", paramRoleInfo.getPartyName());
    hashMap.put("idStat", String.valueOf(x.a().U()));
    return a("/v1/pay/order.lg", ao.b(paramContext, (HashMap)hashMap));
  }
  
  public ar a(Context paramContext, String paramString1, String paramString2, String paramString3, RoleInfo paramRoleInfo) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("taskId", String.valueOf(System.currentTimeMillis()));
    hashMap.put("accessToken", ao.a);
    hashMap.put("uid", paramString1);
    hashMap.put("username", paramString2);
    hashMap.put("token", paramString3);
    hashMap.put("serverId", paramRoleInfo.getServerId());
    hashMap.put("serverName", paramRoleInfo.getServerName());
    hashMap.put("roleId", paramRoleInfo.getRoleId());
    hashMap.put("roleName", paramRoleInfo.getRoleName());
    hashMap.put("roleBalance", paramRoleInfo.getRoleBalance());
    hashMap.put("roleLevel", paramRoleInfo.getRoleLevel());
    hashMap.put("vipLevel", paramRoleInfo.getVipLevel());
    hashMap.put("partyName", paramRoleInfo.getPartyName());
    return a("/v1/role/active.lg", ao.b(paramContext, (HashMap)hashMap));
  }
  
  public ar a(Context paramContext, String paramString1, String paramString2, String paramString3, RoleInfo paramRoleInfo, int paramInt) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("accessToken", ao.a);
    hashMap.put("uid", paramString1);
    hashMap.put("username", paramString2);
    hashMap.put("token", paramString3);
    hashMap.put("serverId", paramRoleInfo.getServerId());
    hashMap.put("serverName", paramRoleInfo.getServerName());
    hashMap.put("roleId", paramRoleInfo.getRoleId());
    hashMap.put("roleName", paramRoleInfo.getRoleName());
    hashMap.put("roleBalance", paramRoleInfo.getRoleBalance());
    hashMap.put("roleLevel", paramRoleInfo.getRoleLevel());
    hashMap.put("vipLevel", paramRoleInfo.getVipLevel());
    hashMap.put("partyName", paramRoleInfo.getPartyName());
    hashMap.put("type", String.valueOf(paramInt));
    return a("/v1/role/attr.lg", ao.b(paramContext, (HashMap)hashMap));
  }
  
  public ar a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("cUid", paramString1);
    hashMap.put("cName", paramString2);
    hashMap.put("cToken", paramString3);
    hashMap.put("channelCustomMsg", paramString4);
    return a("/v1/login/checklgn.lg", ao.b(paramContext, (HashMap)hashMap));
  }
  
  public void a() {
    try {
      Log.d(d, "abh");
      if (this.e == null) {
        ArrayList<String> arrayList = new ArrayList();
        this();
        this.e = arrayList;
      } 
      if (x.a().c() == 0) {
        this.e.add(o.b("bpjBC0NGbbxubXfpxlrnfnZNq4RbQgy2DZf3qGN+9QE=", o.b()));
        return;
      } 
      String str = o.b("h266OFbxYt3UDb1W6MZM1W8r/5CVnb71fQOiETjHL8g=", o.b());
      str = k.a().a(str);
      if (!TextUtils.isEmpty(str) && !this.e.contains(str)) {
        Log.d(d, "abh...a h");
        this.e.add(str);
      } 
      str = o.b("h266OFbxYt3UDb1W6MZM1do9ciP066hLvpPqflrKmiQ=", o.b());
      str = k.a().a(str);
      if (!TextUtils.isEmpty(str) && !this.e.contains(str)) {
        Log.d(d, "abh...a h2");
        this.e.add(str);
      } 
    } catch (Exception exception) {}
  }
  
  public void a(String paramString) {
    try {
      Log.d(d, "ias");
      String str1 = k.a().j();
      int i = k.a().d();
      if (str1.equals("10029") || (str1.equals("10081") && (i == 75 || i == 100))) {
        str1 = o.b("qjVVU4zr+ciZI2ZFFtrsQvEA3lHh/9ge0twyObUbAB0=", o.b());
        paramString = str1;
        if (x.a().R())
          paramString = bb.a(str1); 
        this.e.add(paramString);
        Log.d(d, "ias...add fzd, return");
        return;
      } 
      Boolean bool = Boolean.valueOf(false);
      String str2 = x.a().a(o.b("huRajOckWeNe1zD+MtGlAm8r/5CVnb71fQOiETjHL8g=", o.b()));
      if (!TextUtils.isEmpty(str2)) {
        String str;
        if (x.a().R()) {
          str = bb.a(str2);
        } else {
          str = str2;
        } 
        this.e.add(str);
        Boolean bool1 = Boolean.valueOf(true);
      } 
      str2 = x.a().a(o.b("huRajOckWeNe1zD+MtGlAhHJR3tMq1o6YRnt9gZigE4=", o.b()));
      if (!TextUtils.isEmpty(str2)) {
        String str;
        if (x.a().R()) {
          str = bb.a(str2);
        } else {
          str = str2;
        } 
        this.e.add(str);
        bool = Boolean.valueOf(true);
      } 
      if (bool.booleanValue()) {
        Log.d(d, "ias...add hop, return");
        return;
      } 
      i = this.i + 1;
      this.i = i;
      if (i <= 2) {
        URL uRL = new URL();
        StringBuilder stringBuilder = new StringBuilder();
        this();
        this(stringBuilder.append(paramString).append(System.currentTimeMillis()).toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setConnectTimeout(12000);
        httpURLConnection.setReadTimeout(12000);
        httpURLConnection.setUseCaches(true);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.addRequestProperty("Connection", "Keep-Alive");
        httpURLConnection.connect();
        if (httpURLConnection.getResponseCode() == 200) {
          Log.d(d, "ias success");
          String str = q.a(httpURLConnection.getInputStream());
          if (!TextUtils.isEmpty(str)) {
            paramString = str.substring(0, str.indexOf("&")).trim();
            str = str.substring(str.indexOf("&") + 1).trim();
            if (paramString.equals(ao.a(o.b("UhFxKSaT9Ma8JdgpXP/66q4Pk/VoP6IMgpknfNnaiN0=", o.b()), new String[] { "data", str }))) {
              paramString = ao.b(str);
              JSONObject jSONObject = new JSONObject();
              this(paramString);
              JSONArray jSONArray = jSONObject.optJSONArray("list");
              if (jSONArray != null) {
                this.e.clear();
                paramString = HeroSdk.getInstance().getCustomParams("test_server_url");
                if (!TextUtils.isEmpty(paramString))
                  this.e.add(paramString); 
                for (i = 0; i < jSONArray.length(); i++) {
                  JSONObject jSONObject1 = (JSONObject)jSONArray.get(i);
                  paramString = jSONObject1.optString("url");
                  jSONObject1 = jSONObject1.optJSONObject("header");
                  if (jSONObject1 != null) {
                    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                    this();
                    this.f = (HashMap)hashMap;
                    Iterator<String> iterator = jSONObject1.keys();
                    if (iterator != null)
                      while (iterator.hasNext()) {
                        String str3 = iterator.next();
                        String str4 = jSONObject1.optString(str3);
                        this.f.put(str3, str4);
                      }  
                  } 
                  if (x.a().R())
                    paramString = bb.a(paramString); 
                  this.e.add(paramString);
                } 
              } 
            } else {
              Log.d(d, "ias failed");
            } 
          } 
        } 
        httpURLConnection.disconnect();
      } 
    } catch (UnknownHostException unknownHostException) {
      Log.d(d, "ias...continue");
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void a(String paramString1, String paramString2) {
    try {
      ArrayList<String> arrayList;
      HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
      this();
      this.g = (HashMap)hashMap1;
      if (this.g.containsKey(paramString1)) {
        List list = this.g.get(paramString1);
      } else {
        hashMap1 = null;
      } 
      HashMap<Object, Object> hashMap2 = hashMap1;
      if (hashMap1 == null) {
        arrayList = new ArrayList();
        this();
      } 
      arrayList.add(paramString2);
      this.g.put(paramString1, arrayList);
    } catch (Exception exception) {
      this.g = null;
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public ar b(Context paramContext) {
    return a("/v1/sys/splhend.lg", ao.b(paramContext, new HashMap<String, Object>()));
  }
  
  public ar b(Context paramContext, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("err", paramString);
    return a("/v1/statistics/err.lg", ao.b(paramContext, (HashMap)hashMap));
  }
  
  public ar b(Context paramContext, String paramString1, String paramString2) {
    Log.d(d, "identifyStatus");
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("accessToken", ao.a);
    hashMap.put("realName", paramString1);
    hashMap.put("idCard", paramString2);
    return a("/v1/user/idcard.lg", ao.b(paramContext, (HashMap)hashMap));
  }
  
  public ar c(Context paramContext) {
    return a("/v1/sys/getnak.lg", ao.b(paramContext, new HashMap<String, Object>()));
  }
  
  public ar c(Context paramContext, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("countType", paramString);
    return a("/v1/statistics/count.lg", ao.b(paramContext, (HashMap)hashMap));
  }
  
  public ar d(Context paramContext, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("countType", paramString);
    return b("/maidian/feedback", ao.c(paramContext, (HashMap)hashMap));
  }
  
  public ar e(Context paramContext, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("errType", paramString);
    return a("/v1/statistics/lgnfb.lg", ao.b(paramContext, (HashMap)hashMap));
  }
  
  public ar f(Context paramContext, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("accessToken", ao.a);
    hashMap.put("channelCustomMsg", paramString);
    return a("/v1/pay/queryYsBalance.lg", ao.b(paramContext, (HashMap)hashMap));
  }
  
  public ar g(Context paramContext, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("accessToken", ao.a);
    hashMap.put("channelCustomMsg", paramString);
    return a("/v1/user/cidcard.lg", ao.b(paramContext, (HashMap)hashMap));
  }
  
  public ar h(Context paramContext, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("result", paramString);
    hashMap.put("accessToken", ao.a);
    return a("/v1/user/count.lg", ao.b(paramContext, (HashMap)hashMap));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */