package com.unionpay.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.CellLocation;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Enumeration;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class f {
  static TelephonyManager a;
  
  static boolean b;
  
  static long c;
  
  private static final String[] d = new String[] { 
      "UNKNOWN", "GPRS", "EDGE", "UMTS", "CDMA", "EVDO_0", "EVDO_A", "1xRTT", "HSDPA", "HSUPA", 
      "HSPA", "IDEN", "EVDO_B", "LTE", "EHRPD", "HSPAP" };
  
  private static final String[] e = new String[] { "NONE", "GSM", "CDMA", "SIP" };
  
  static {
    b = false;
    c = -300000L;
  }
  
  private static JSONArray A(Context paramContext) {
    // Byte code:
    //   0: new org/json/JSONArray
    //   3: astore_1
    //   4: aload_1
    //   5: invokespecial <init> : ()V
    //   8: aload_0
    //   9: ldc 'phone'
    //   11: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   14: checkcast android/telephony/TelephonyManager
    //   17: astore_2
    //   18: ldc 'com.android.internal.telephony.Phone'
    //   20: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   23: astore_0
    //   24: aload_0
    //   25: ldc 'GEMINI_SIM_1'
    //   27: invokevirtual getField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   30: astore_3
    //   31: aload_3
    //   32: iconst_1
    //   33: invokevirtual setAccessible : (Z)V
    //   36: aload_3
    //   37: aconst_null
    //   38: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   41: checkcast java/lang/Integer
    //   44: astore_3
    //   45: aload_0
    //   46: ldc 'GEMINI_SIM_2'
    //   48: invokevirtual getField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   51: astore_0
    //   52: aload_0
    //   53: iconst_1
    //   54: invokevirtual setAccessible : (Z)V
    //   57: aload_0
    //   58: aconst_null
    //   59: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   62: checkcast java/lang/Integer
    //   65: astore_0
    //   66: ldc android/telephony/TelephonyManager
    //   68: ldc 'getDeviceIdGemini'
    //   70: iconst_1
    //   71: anewarray java/lang/Class
    //   74: dup
    //   75: iconst_0
    //   76: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   79: aastore
    //   80: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   83: astore #4
    //   85: aload_2
    //   86: ifnull -> 94
    //   89: aload #4
    //   91: ifnonnull -> 112
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: areturn
    //   98: astore_0
    //   99: iconst_1
    //   100: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   103: astore_0
    //   104: iconst_0
    //   105: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   108: astore_3
    //   109: goto -> 66
    //   112: aload #4
    //   114: aload_2
    //   115: iconst_1
    //   116: anewarray java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload_3
    //   122: aastore
    //   123: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast java/lang/String
    //   129: invokevirtual trim : ()Ljava/lang/String;
    //   132: astore #5
    //   134: aload #4
    //   136: aload_2
    //   137: iconst_1
    //   138: anewarray java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: aload_0
    //   144: aastore
    //   145: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   148: checkcast java/lang/String
    //   151: invokevirtual trim : ()Ljava/lang/String;
    //   154: astore #4
    //   156: aload #5
    //   158: invokestatic b : (Ljava/lang/String;)Ljava/lang/Boolean;
    //   161: invokevirtual booleanValue : ()Z
    //   164: ifeq -> 183
    //   167: aload_1
    //   168: ldc android/telephony/TelephonyManager
    //   170: aload_2
    //   171: aload_3
    //   172: aload #5
    //   174: ldc 'Gemini'
    //   176: invokestatic a : (Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;
    //   179: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   182: pop
    //   183: aload #4
    //   185: invokestatic b : (Ljava/lang/String;)Ljava/lang/Boolean;
    //   188: invokevirtual booleanValue : ()Z
    //   191: ifeq -> 210
    //   194: aload_1
    //   195: ldc android/telephony/TelephonyManager
    //   197: aload_2
    //   198: aload_0
    //   199: aload #4
    //   201: ldc 'Gemini'
    //   203: invokestatic a : (Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;
    //   206: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   209: pop
    //   210: aload_1
    //   211: astore_0
    //   212: goto -> 96
    //   215: astore_0
    //   216: aconst_null
    //   217: astore_0
    //   218: goto -> 96
    // Exception table:
    //   from	to	target	type
    //   0	24	215	java/lang/Throwable
    //   24	66	98	java/lang/Throwable
    //   66	85	215	java/lang/Throwable
    //   99	109	215	java/lang/Throwable
    //   112	183	215	java/lang/Throwable
    //   183	210	215	java/lang/Throwable
  }
  
  private static JSONArray B(Context paramContext) {
    try {
      Integer integer;
      JSONArray jSONArray2 = new JSONArray();
      this();
      TelephonyManager telephonyManager1 = (TelephonyManager)paramContext.getSystemService("phone");
      Class<?> clazz = Class.forName("com.android.internal.telephony.Phone");
      try {
        Field field2 = clazz.getField("GEMINI_SIM_1");
        field2.setAccessible(true);
        integer = (Integer)field2.get(null);
        Field field1 = clazz.getField("GEMINI_SIM_2");
        field1.setAccessible(true);
        Integer integer1 = (Integer)field1.get(null);
      } catch (Throwable throwable1) {}
      Method method = TelephonyManager.class.getMethod("getDefault", new Class[] { int.class });
      TelephonyManager telephonyManager2 = (TelephonyManager)method.invoke(telephonyManager1, new Object[] { integer });
      telephonyManager1 = (TelephonyManager)method.invoke(telephonyManager1, new Object[] { throwable1 });
      String str2 = telephonyManager2.getDeviceId().trim();
      String str1 = telephonyManager1.getDeviceId().trim();
      if (b(str2).booleanValue()) {
        JSONObject jSONObject = a(telephonyManager2, str2);
        if (jSONObject != null)
          jSONArray2.put(jSONObject); 
      } 
      if (b(str1).booleanValue()) {
        JSONObject jSONObject = a(telephonyManager1, str1);
        if (jSONObject != null)
          jSONArray2.put(jSONObject); 
      } 
      JSONArray jSONArray1 = jSONArray2;
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (JSONArray)throwable;
  }
  
  private static JSONArray C(Context paramContext) {
    try {
      JSONArray jSONArray2 = new JSONArray();
      this();
      Class<?> clazz = Class.forName("com.android.internal.telephony.PhoneFactory");
      String str3 = (String)clazz.getMethod("getServiceName", new Class[] { String.class, int.class }).invoke(clazz, new Object[] { "phone", Integer.valueOf(1) });
      TelephonyManager telephonyManager2 = (TelephonyManager)paramContext.getSystemService("phone");
      String str2 = telephonyManager2.getDeviceId().trim();
      TelephonyManager telephonyManager1 = (TelephonyManager)paramContext.getSystemService(str3);
      String str1 = telephonyManager1.getDeviceId().trim();
      if (b(str2).booleanValue()) {
        JSONObject jSONObject = a(telephonyManager2, str2);
        if (jSONObject != null)
          jSONArray2.put(jSONObject); 
      } 
      if (b(str1).booleanValue()) {
        JSONObject jSONObject = a(telephonyManager1, str1);
        if (jSONObject != null)
          jSONArray2.put(jSONObject); 
      } 
      JSONArray jSONArray1 = jSONArray2;
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (JSONArray)throwable;
  }
  
  private static JSONArray D(Context paramContext) {
    try {
      JSONArray jSONArray2 = new JSONArray();
      this();
      Class<?> clazz = Class.forName("android.telephony.MSimTelephonyManager");
      Object object = paramContext.getSystemService("phone_msim");
      Integer integer1 = Integer.valueOf(0);
      Integer integer2 = Integer.valueOf(1);
      Method method = clazz.getMethod("getDeviceId", new Class[] { int.class });
      String str2 = ((String)method.invoke(object, new Object[] { integer1 })).trim();
      String str1 = ((String)method.invoke(object, new Object[] { integer2 })).trim();
      if (b(str2).booleanValue())
        jSONArray2.put(a(clazz, object, integer1, str2, "")); 
      if (b(str1).booleanValue())
        jSONArray2.put(a(clazz, object, integer2, str1, "")); 
      JSONArray jSONArray1 = jSONArray2;
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (JSONArray)throwable;
  }
  
  private static Boolean a(String paramString) {
    Boolean bool;
    try {
      byte b1;
      if (paramString.length() > 0) {
        b1 = paramString.charAt(0);
      } else {
        b1 = 48;
      } 
      Boolean bool1 = Boolean.valueOf(true);
      for (byte b2 = 0;; b2++) {
        bool = bool1;
        if (b2 < paramString.length()) {
          if (b1 != paramString.charAt(b2))
            return Boolean.valueOf(false); 
        } else {
          return bool;
        } 
      } 
    } catch (Throwable throwable) {
      bool = Boolean.valueOf(false);
    } 
    return bool;
  }
  
  private static String a(int paramInt) {
    return (paramInt >= 0 && paramInt < d.length) ? d[paramInt] : String.valueOf(paramInt);
  }
  
  private static JSONArray a(BitSet paramBitSet) {
    int i = paramBitSet.cardinality();
    if (paramBitSet != null && i > 0) {
      JSONArray jSONArray = new JSONArray();
      i = paramBitSet.nextSetBit(0);
      while (true) {
        if (i >= 0) {
          jSONArray.put(i);
          i = paramBitSet.nextSetBit(i + 1);
          continue;
        } 
        return null;
      } 
    } 
    return null;
  }
  
  public static JSONObject a(int paramInt1, int paramInt2) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("lat", paramInt1);
      jSONObject.put("lng", paramInt2);
      jSONObject.put("unit", "qd");
    } catch (Throwable throwable) {}
    return jSONObject;
  }
  
  private static JSONObject a(TelephonyManager paramTelephonyManager, SubscriptionManager paramSubscriptionManager, int paramInt) {
    JSONObject jSONObject = new JSONObject();
    try {
      if (k.a(22)) {
        SubscriptionInfo subscriptionInfo = paramSubscriptionManager.getActiveSubscriptionInfoForSimSlotIndex(paramInt);
        if (subscriptionInfo != null) {
          String str;
          if (subscriptionInfo.getIccId() == null) {
            str = "";
          } else {
            str = subscriptionInfo.getIccId();
          } 
          jSONObject.put("simSerialNumber", str);
          CharSequence charSequence = new StringBuilder();
          this();
          jSONObject.put("simOperator", charSequence.append(subscriptionInfo.getMcc()).append("0").append(subscriptionInfo.getMnc()).toString());
          if (subscriptionInfo.getCarrierName() == null) {
            String str1 = "";
          } else {
            charSequence = subscriptionInfo.getCarrierName();
          } 
          jSONObject.put("simOperatorName", charSequence);
          if (subscriptionInfo.getCountryIso() == null) {
            charSequence = "";
          } else {
            charSequence = subscriptionInfo.getCountryIso();
          } 
          jSONObject.put("simCountryIso", charSequence);
          paramInt = subscriptionInfo.getSubscriptionId();
          Method method = paramTelephonyManager.getClass().getMethod("getSubscriberId", new Class[] { int.class });
          method.setAccessible(true);
          Object object2 = method.invoke(paramTelephonyManager, new Object[] { Integer.valueOf(paramInt) });
          Object object1 = object2;
          if (object2 == null)
            object1 = ""; 
          jSONObject.put("subscriberId", object1);
        } 
      } 
    } catch (Throwable throwable) {}
    return jSONObject;
  }
  
  private static JSONObject a(TelephonyManager paramTelephonyManager, String paramString) {
    try {
      String str;
      JSONObject jSONObject2 = new JSONObject();
      this();
      jSONObject2.put("imei", paramString.trim());
      if (paramTelephonyManager.getSubscriberId() == null) {
        paramString = "";
      } else {
        paramString = paramTelephonyManager.getSubscriberId();
      } 
      jSONObject2.put("subscriberId", paramString);
      if (paramTelephonyManager.getSimSerialNumber() == null) {
        paramString = "";
      } else {
        paramString = paramTelephonyManager.getSimSerialNumber();
      } 
      jSONObject2.put("simSerialNumber", paramString);
      jSONObject2.put("dataState", paramTelephonyManager.getDataState());
      jSONObject2.put("networkType", a(paramTelephonyManager.getNetworkType()));
      jSONObject2.put("networkOperator", paramTelephonyManager.getNetworkOperator());
      jSONObject2.put("phoneType", b(paramTelephonyManager.getPhoneType()));
      if (paramTelephonyManager.getSimOperator() == null) {
        paramString = "";
      } else {
        paramString = paramTelephonyManager.getSimOperator();
      } 
      jSONObject2.put("simOperator", paramString);
      if (paramTelephonyManager.getSimOperatorName() == null) {
        paramString = "";
      } else {
        paramString = paramTelephonyManager.getSimOperatorName();
      } 
      jSONObject2.put("simOperatorName", paramString);
      if (paramTelephonyManager.getSimCountryIso() == null) {
        str = "";
      } else {
        str = str.getSimCountryIso();
      } 
      jSONObject2.put("simCountryIso", str);
      JSONObject jSONObject1 = jSONObject2;
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (JSONObject)throwable;
  }
  
  private static JSONObject a(Class paramClass, Object paramObject, Integer paramInteger, String paramString1, String paramString2) {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("imei", paramString1);
    try {
      String str;
      StringBuilder stringBuilder = new StringBuilder();
      this("getSubscriberId");
      Method method = paramClass.getMethod(stringBuilder.append(paramString2).toString(), new Class[] { int.class });
      if (method.invoke(paramObject, new Object[] { paramInteger }) == null) {
        str = "";
      } else {
        str = ((String)str.invoke(paramObject, new Object[] { paramInteger })).trim();
      } 
      jSONObject.put("subscriberId", str);
    } catch (Throwable throwable) {}
    try {
      String str;
      StringBuilder stringBuilder = new StringBuilder();
      this("getSimSerialNumber");
      Method method = paramClass.getMethod(stringBuilder.append(paramString2).toString(), new Class[] { int.class });
      if (method.invoke(paramObject, new Object[] { paramInteger }) == null) {
        str = "";
      } else {
        str = ((String)str.invoke(paramObject, new Object[] { paramInteger })).trim();
      } 
      jSONObject.put("simSerialNumber", str);
    } catch (Throwable throwable) {}
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this("getDataState");
      jSONObject.put("dataState", paramClass.getMethod(stringBuilder.append(paramString2).toString(), new Class[] { int.class }).invoke(paramObject, new Object[] { paramInteger }));
    } catch (Throwable throwable) {}
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this("getNetworkType");
      jSONObject.put("networkType", a(((Integer)paramClass.getMethod(stringBuilder.append(paramString2).toString(), new Class[] { int.class }).invoke(paramObject, new Object[] { paramInteger })).intValue()));
    } catch (Throwable throwable) {}
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this("getNetworkOperator");
      jSONObject.put("networkOperator", paramClass.getMethod(stringBuilder.append(paramString2).toString(), new Class[] { int.class }).invoke(paramObject, new Object[] { paramInteger }));
    } catch (Throwable throwable) {}
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this("getPhoneType");
      jSONObject.put("phoneType", b(((Integer)paramClass.getMethod(stringBuilder.append(paramString2).toString(), new Class[] { int.class }).invoke(paramObject, new Object[] { paramInteger })).intValue()));
    } catch (Throwable throwable) {}
    try {
      String str;
      StringBuilder stringBuilder = new StringBuilder();
      this("getSimOperator");
      Method method = paramClass.getMethod(stringBuilder.append(paramString2).toString(), new Class[] { int.class });
      if (method.invoke(paramObject, new Object[] { paramInteger }) == null) {
        str = "";
      } else {
        str = ((String)str.invoke(paramObject, new Object[] { paramInteger })).trim();
      } 
      jSONObject.put("simOperator", str);
    } catch (Throwable throwable) {}
    try {
      String str;
      StringBuilder stringBuilder = new StringBuilder();
      this("getSimOperatorName");
      Method method = paramClass.getMethod(stringBuilder.append(paramString2).toString(), new Class[] { int.class });
      if (method.invoke(paramObject, new Object[] { paramInteger }) == null) {
        str = "";
      } else {
        str = ((String)str.invoke(paramObject, new Object[] { paramInteger })).trim();
      } 
      jSONObject.put("simOperatorName", str);
    } catch (Throwable throwable) {}
    return jSONObject;
  }
  
  private static void a(Context paramContext) {
    try {
      a = (TelephonyManager)paramContext.getSystemService("phone");
    } catch (Throwable throwable) {}
  }
  
  public static boolean a() {
    boolean bool = true;
    try {
      if (k.a(11)) {
        if (TextUtils.isEmpty(System.getProperty("http.proxyHost")))
          bool = false; 
        return bool;
      } 
      boolean bool1 = TextUtils.isEmpty(Proxy.getDefaultHost());
      if (bool1)
        bool = false; 
    } catch (Throwable throwable) {
      bool = false;
    } 
    return bool;
  }
  
  private static Boolean b(String paramString) {
    try {
      Integer integer = Integer.valueOf(paramString.length());
      if (integer.intValue() > 10 && integer.intValue() < 20 && !a(paramString.trim()).booleanValue())
        return Boolean.valueOf(true); 
    } catch (Throwable throwable) {}
    return Boolean.valueOf(false);
  }
  
  private static String b(int paramInt) {
    return (paramInt >= 0 && paramInt < e.length) ? e[paramInt] : String.valueOf(paramInt);
  }
  
  public static String b(Context paramContext) {
    try {
      Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
      while (enumeration.hasMoreElements()) {
        Enumeration<InetAddress> enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
        while (enumeration1.hasMoreElements()) {
          InetAddress inetAddress = enumeration1.nextElement();
          if (!inetAddress.isLoopbackAddress() && inetAddress instanceof java.net.Inet4Address)
            return inetAddress.getHostAddress().toString(); 
        } 
      } 
    } catch (Throwable throwable) {}
    return null;
  }
  
  public static boolean c(Context paramContext) {
    try {
      if (k.b(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
        ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
        NetworkInfo networkInfo2 = connectivityManager.getActiveNetworkInfo();
        if (networkInfo2 != null)
          return networkInfo2.isConnected(); 
        NetworkInfo networkInfo1 = connectivityManager.getNetworkInfo(0);
        if (networkInfo1 == null || !networkInfo1.getState().equals(NetworkInfo.State.UNKNOWN))
          return false; 
      } 
      if (SystemClock.elapsedRealtime() - c > 300000L) {
        Socket socket;
        c = SystemClock.elapsedRealtime();
        paramContext = null;
        Context context = paramContext;
        try {
          Socket socket1;
          if (a()) {
            context = paramContext;
            Socket socket3 = new Socket();
            context = paramContext;
            this(Proxy.getDefaultHost(), Proxy.getDefaultPort());
            socket1 = socket3;
          } else {
            Socket socket3 = socket1;
            socket1 = new Socket("140.207.168.45", 80);
          } 
          socket = socket1;
        } catch (Throwable throwable) {
          Socket socket1 = socket;
          b = false;
        } finally {
          Socket socket1 = null;
          if (socket1 != null)
            try {
              socket1.close();
            } catch (Throwable throwable) {} 
        } 
      } 
    } catch (Throwable throwable) {}
    boolean bool = b;
  }
  
  public static boolean d(Context paramContext) {
    try {
      if (k.b(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
        NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo != null) {
          boolean bool = networkInfo.isAvailable();
          if (bool)
            return true; 
        } 
        return false;
      } 
    } catch (Throwable throwable) {}
    return false;
  }
  
  public static boolean e(Context paramContext) {
    boolean bool;
    try {
      bool = ((WifiManager)paramContext.getSystemService("wifi")).isWifiEnabled();
    } catch (Throwable throwable) {
      bool = false;
    } 
    return bool;
  }
  
  public static boolean f(Context paramContext) {
    boolean bool = false;
    try {
      if (a == null)
        a(paramContext); 
      int i = a.getSimState();
      if (i == 5)
        bool = true; 
    } catch (Throwable throwable) {}
    return bool;
  }
  
  public static boolean g(Context paramContext) {
    try {
      if (k.b(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
        NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo != null && 1 == networkInfo.getType()) {
          boolean bool = networkInfo.isConnected();
          if (bool)
            return true; 
        } 
        return false;
      } 
    } catch (Throwable throwable) {}
    return false;
  }
  
  public static boolean h(Context paramContext) {
    boolean bool = false;
    try {
      if (a == null)
        a(paramContext); 
      int i = a.getDataState();
      if (i == 2)
        bool = true; 
    } catch (Throwable throwable) {}
    return bool;
  }
  
  public static String i(Context paramContext) {
    return !c(paramContext) ? "OFFLINE" : (g(paramContext) ? "WIFI" : j(paramContext));
  }
  
  public static String j(Context paramContext) {
    String str1;
    String str2 = d[0];
    try {
      if (a == null)
        a(paramContext); 
      str1 = a(a.getNetworkType());
    } catch (Throwable throwable) {
      str1 = str2;
    } 
    return str1;
  }
  
  public static String k(Context paramContext) {
    try {
      if (a == null)
        a(paramContext); 
      String str = a.getNetworkOperator();
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  public static String l(Context paramContext) {
    try {
      if (a == null)
        a(paramContext); 
      String str = a.getSimOperator();
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  public static String m(Context paramContext) {
    try {
      if (a == null)
        a(paramContext); 
      String str = a.getNetworkCountryIso();
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  public static String n(Context paramContext) {
    try {
      if (a == null)
        a(paramContext); 
      String str = a.getSimCountryIso();
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  public static String o(Context paramContext) {
    String str2;
    String str1 = null;
    try {
      if (k.a(23) && paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0)
        return str1; 
      str2 = str1;
      if (k.b(paramContext, "android.permission.READ_PHONE_STATE")) {
        str2 = str1;
        if (Build.VERSION.SDK_INT >= 18) {
          if (a == null)
            a(paramContext); 
          str2 = a.getGroupIdLevel1();
        } 
      } 
    } catch (Throwable throwable) {
      str2 = str1;
    } 
    return str2;
  }
  
  public static String p(Context paramContext) {
    try {
      if (a == null)
        a(paramContext); 
      String str = a.getNetworkOperatorName();
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  public static String q(Context paramContext) {
    try {
      if (a == null)
        a(paramContext); 
      String str = a.getSimOperatorName();
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  public static JSONArray r(Context paramContext) {
    JSONArray jSONArray = new JSONArray();
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("type", "wifi");
      jSONObject.put("available", e(paramContext));
      jSONObject.put("connected", g(paramContext));
      jSONObject.put("current", w(paramContext));
      jSONObject.put("scannable", x(paramContext));
      jSONObject.put("configured", u(paramContext));
      jSONArray.put(jSONObject);
    } catch (Throwable throwable) {}
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("type", "cellular");
      jSONObject.put("available", f(paramContext));
      jSONObject.put("connected", h(paramContext));
      jSONObject.put("current", s(paramContext));
      jSONObject.put("scannable", t(paramContext));
      jSONArray.put(jSONObject);
    } catch (Throwable throwable) {}
    return (jSONArray.length() > 0) ? jSONArray : null;
  }
  
  public static JSONArray s(Context paramContext) {
    try {
      if (!k.b)
        return null; 
      if (k.a(23) && paramContext.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0)
        return null; 
      if (k.b(paramContext, "android.permission.ACCESS_COARSE_LOCATION") || k.b(paramContext, "android.permission.ACCESS_FINE_LOCATION")) {
        if (a == null)
          a(paramContext); 
        JSONObject jSONObject = new JSONObject();
        this();
        if (k.d || k.e) {
          GsmCellLocation gsmCellLocation;
          CellLocation cellLocation = a.getCellLocation();
          if (cellLocation instanceof GsmCellLocation) {
            gsmCellLocation = (GsmCellLocation)cellLocation;
            if (gsmCellLocation != null) {
              jSONObject.put("systemId", gsmCellLocation.getLac());
              jSONObject.put("networkId", gsmCellLocation.getCid());
              if (k.a(9))
                jSONObject.put("basestationId", gsmCellLocation.getPsc()); 
            } 
          } else if (gsmCellLocation instanceof CdmaCellLocation) {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation)gsmCellLocation;
            if (cdmaCellLocation != null) {
              jSONObject.put("systemId", cdmaCellLocation.getSystemId());
              jSONObject.put("networkId", cdmaCellLocation.getNetworkId());
              jSONObject.put("basestationId", cdmaCellLocation.getBaseStationId());
              jSONObject.put("location", a(cdmaCellLocation.getBaseStationLatitude(), cdmaCellLocation.getBaseStationLongitude()));
            } 
          } 
        } 
        jSONObject.put("type", j(paramContext));
        jSONObject.put("mcc", k(paramContext));
        jSONObject.put("operator", p(paramContext));
        jSONObject.put("country", m(paramContext));
        JSONArray jSONArray = new JSONArray();
        this();
        jSONArray.put(jSONObject);
        return jSONArray;
      } 
    } catch (Throwable throwable) {}
    return null;
  }
  
  public static JSONArray t(Context paramContext) {
    // Byte code:
    //   0: getstatic com/unionpay/sdk/k.b : Z
    //   3: ifne -> 10
    //   6: aconst_null
    //   7: astore_0
    //   8: aload_0
    //   9: areturn
    //   10: bipush #23
    //   12: invokestatic a : (I)Z
    //   15: ifeq -> 33
    //   18: aload_0
    //   19: ldc_w 'android.permission.ACCESS_COARSE_LOCATION'
    //   22: invokevirtual checkSelfPermission : (Ljava/lang/String;)I
    //   25: ifeq -> 33
    //   28: aconst_null
    //   29: astore_0
    //   30: goto -> 8
    //   33: aload_0
    //   34: ldc_w 'android.permission.ACCESS_COARSE_LOCATION'
    //   37: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)Z
    //   40: ifne -> 53
    //   43: aload_0
    //   44: ldc_w 'android.permission.ACCESS_FINE_LOCATION'
    //   47: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)Z
    //   50: ifeq -> 788
    //   53: getstatic com/unionpay/sdk/f.a : Landroid/telephony/TelephonyManager;
    //   56: ifnonnull -> 63
    //   59: aload_0
    //   60: invokestatic a : (Landroid/content/Context;)V
    //   63: new org/json/JSONArray
    //   66: astore_1
    //   67: aload_1
    //   68: invokespecial <init> : ()V
    //   71: bipush #17
    //   73: invokestatic a : (I)Z
    //   76: ifeq -> 617
    //   79: getstatic com/unionpay/sdk/f.a : Landroid/telephony/TelephonyManager;
    //   82: invokevirtual getAllCellInfo : ()Ljava/util/List;
    //   85: astore_0
    //   86: aload_0
    //   87: ifnull -> 766
    //   90: aload_0
    //   91: invokeinterface iterator : ()Ljava/util/Iterator;
    //   96: astore_2
    //   97: aload_2
    //   98: invokeinterface hasNext : ()Z
    //   103: ifeq -> 766
    //   106: aload_2
    //   107: invokeinterface next : ()Ljava/lang/Object;
    //   112: checkcast android/telephony/CellInfo
    //   115: astore_0
    //   116: new org/json/JSONObject
    //   119: astore_3
    //   120: aload_3
    //   121: invokespecial <init> : ()V
    //   124: aload_3
    //   125: ldc_w 'registered'
    //   128: aload_0
    //   129: invokevirtual isRegistered : ()Z
    //   132: invokevirtual put : (Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   135: pop
    //   136: aload_3
    //   137: ldc_w 'ts'
    //   140: aload_0
    //   141: invokevirtual getTimeStamp : ()J
    //   144: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   147: pop
    //   148: aload_0
    //   149: instanceof android/telephony/CellInfoGsm
    //   152: ifeq -> 339
    //   155: aload_0
    //   156: checkcast android/telephony/CellInfoGsm
    //   159: astore_0
    //   160: aload_0
    //   161: invokevirtual getCellIdentity : ()Landroid/telephony/CellIdentityGsm;
    //   164: astore #4
    //   166: aload #4
    //   168: invokevirtual getLac : ()I
    //   171: istore #5
    //   173: aload #4
    //   175: invokevirtual getCid : ()I
    //   178: istore #6
    //   180: aload #4
    //   182: invokevirtual getMcc : ()I
    //   185: istore #7
    //   187: aload #4
    //   189: invokevirtual getMnc : ()I
    //   192: istore #8
    //   194: aload_0
    //   195: invokevirtual getCellSignalStrength : ()Landroid/telephony/CellSignalStrengthGsm;
    //   198: astore #4
    //   200: iconst_m1
    //   201: istore #9
    //   203: ldc 'GSM'
    //   205: astore_0
    //   206: iload #5
    //   208: iconst_m1
    //   209: if_icmpeq -> 222
    //   212: aload_3
    //   213: ldc_w 'systemId'
    //   216: iload #5
    //   218: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   221: pop
    //   222: iload #6
    //   224: iconst_m1
    //   225: if_icmpeq -> 238
    //   228: aload_3
    //   229: ldc_w 'networkId'
    //   232: iload #6
    //   234: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   237: pop
    //   238: iload #9
    //   240: iconst_m1
    //   241: if_icmpeq -> 254
    //   244: aload_3
    //   245: ldc_w 'basestationId'
    //   248: iload #9
    //   250: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   253: pop
    //   254: iload #7
    //   256: iconst_m1
    //   257: if_icmpeq -> 270
    //   260: aload_3
    //   261: ldc_w 'mcc'
    //   264: iload #7
    //   266: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   269: pop
    //   270: iload #8
    //   272: iconst_m1
    //   273: if_icmpeq -> 286
    //   276: aload_3
    //   277: ldc_w 'mnc'
    //   280: iload #8
    //   282: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   285: pop
    //   286: aload #4
    //   288: ifnull -> 317
    //   291: aload_3
    //   292: ldc_w 'asuLevel'
    //   295: aload #4
    //   297: invokevirtual getAsuLevel : ()I
    //   300: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   303: pop
    //   304: aload_3
    //   305: ldc_w 'dbm'
    //   308: aload #4
    //   310: invokevirtual getDbm : ()I
    //   313: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   316: pop
    //   317: aload_3
    //   318: ldc_w 'type'
    //   321: aload_0
    //   322: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   325: pop
    //   326: aload_1
    //   327: aload_3
    //   328: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   331: pop
    //   332: goto -> 97
    //   335: astore_0
    //   336: goto -> 97
    //   339: aload_0
    //   340: instanceof android/telephony/CellInfoCdma
    //   343: ifeq -> 492
    //   346: aload_0
    //   347: checkcast android/telephony/CellInfoCdma
    //   350: astore #4
    //   352: aload #4
    //   354: invokevirtual getCellIdentity : ()Landroid/telephony/CellIdentityCdma;
    //   357: astore_0
    //   358: aload_0
    //   359: invokevirtual getSystemId : ()I
    //   362: istore #5
    //   364: aload_0
    //   365: invokevirtual getNetworkId : ()I
    //   368: istore #6
    //   370: aload_0
    //   371: invokevirtual getBasestationId : ()I
    //   374: istore #9
    //   376: aload #4
    //   378: invokevirtual getCellSignalStrength : ()Landroid/telephony/CellSignalStrengthCdma;
    //   381: astore #4
    //   383: aload_3
    //   384: ldc_w 'cdmaDbm'
    //   387: aload #4
    //   389: invokevirtual getCdmaDbm : ()I
    //   392: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   395: pop
    //   396: aload_3
    //   397: ldc_w 'cdmaDbm'
    //   400: aload #4
    //   402: invokevirtual getCdmaDbm : ()I
    //   405: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   408: pop
    //   409: aload_3
    //   410: ldc_w 'cdmaEcio'
    //   413: aload #4
    //   415: invokevirtual getCdmaEcio : ()I
    //   418: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   421: pop
    //   422: aload_3
    //   423: ldc_w 'evdoDbm'
    //   426: aload #4
    //   428: invokevirtual getEvdoDbm : ()I
    //   431: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   434: pop
    //   435: aload_3
    //   436: ldc_w 'evdoEcio'
    //   439: aload #4
    //   441: invokevirtual getEvdoEcio : ()I
    //   444: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   447: pop
    //   448: aload_3
    //   449: ldc_w 'evdoSnr'
    //   452: aload #4
    //   454: invokevirtual getEvdoSnr : ()I
    //   457: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   460: pop
    //   461: aload_3
    //   462: ldc_w 'location'
    //   465: aload_0
    //   466: invokevirtual getLatitude : ()I
    //   469: aload_0
    //   470: invokevirtual getLongitude : ()I
    //   473: invokestatic a : (II)Lorg/json/JSONObject;
    //   476: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   479: pop
    //   480: iconst_m1
    //   481: istore #7
    //   483: iconst_m1
    //   484: istore #8
    //   486: ldc 'CDMA'
    //   488: astore_0
    //   489: goto -> 206
    //   492: aload_0
    //   493: instanceof android/telephony/CellInfoWcdma
    //   496: ifeq -> 555
    //   499: aload_0
    //   500: checkcast android/telephony/CellInfoWcdma
    //   503: astore #4
    //   505: aload #4
    //   507: invokevirtual getCellIdentity : ()Landroid/telephony/CellIdentityWcdma;
    //   510: astore_0
    //   511: aload_0
    //   512: invokevirtual getLac : ()I
    //   515: istore #5
    //   517: aload_0
    //   518: invokevirtual getCid : ()I
    //   521: istore #6
    //   523: aload_0
    //   524: invokevirtual getPsc : ()I
    //   527: istore #9
    //   529: aload_0
    //   530: invokevirtual getMcc : ()I
    //   533: istore #7
    //   535: aload_0
    //   536: invokevirtual getMnc : ()I
    //   539: istore #8
    //   541: aload #4
    //   543: invokevirtual getCellSignalStrength : ()Landroid/telephony/CellSignalStrengthWcdma;
    //   546: astore #4
    //   548: ldc_w 'WCDMA'
    //   551: astore_0
    //   552: goto -> 206
    //   555: aload_0
    //   556: instanceof android/telephony/CellInfoLte
    //   559: ifeq -> 793
    //   562: aload_0
    //   563: checkcast android/telephony/CellInfoLte
    //   566: astore #4
    //   568: aload #4
    //   570: invokevirtual getCellIdentity : ()Landroid/telephony/CellIdentityLte;
    //   573: astore_0
    //   574: aload_0
    //   575: invokevirtual getTac : ()I
    //   578: istore #5
    //   580: aload_0
    //   581: invokevirtual getPci : ()I
    //   584: istore #6
    //   586: aload_0
    //   587: invokevirtual getCi : ()I
    //   590: istore #9
    //   592: aload_0
    //   593: invokevirtual getMcc : ()I
    //   596: istore #7
    //   598: aload_0
    //   599: invokevirtual getMnc : ()I
    //   602: istore #8
    //   604: aload #4
    //   606: invokevirtual getCellSignalStrength : ()Landroid/telephony/CellSignalStrengthLte;
    //   609: astore #4
    //   611: ldc 'LTE'
    //   613: astore_0
    //   614: goto -> 206
    //   617: iconst_5
    //   618: invokestatic a : (I)Z
    //   621: ifeq -> 766
    //   624: getstatic com/unionpay/sdk/k.d : Z
    //   627: ifne -> 636
    //   630: getstatic com/unionpay/sdk/k.e : Z
    //   633: ifeq -> 766
    //   636: getstatic com/unionpay/sdk/f.a : Landroid/telephony/TelephonyManager;
    //   639: invokevirtual getNeighboringCellInfo : ()Ljava/util/List;
    //   642: astore_0
    //   643: aload_0
    //   644: ifnull -> 766
    //   647: aload_0
    //   648: invokeinterface iterator : ()Ljava/util/Iterator;
    //   653: astore_0
    //   654: aload_0
    //   655: invokeinterface hasNext : ()Z
    //   660: ifeq -> 766
    //   663: aload_0
    //   664: invokeinterface next : ()Ljava/lang/Object;
    //   669: checkcast android/telephony/NeighboringCellInfo
    //   672: astore_2
    //   673: new org/json/JSONObject
    //   676: astore #4
    //   678: aload #4
    //   680: invokespecial <init> : ()V
    //   683: aload #4
    //   685: ldc_w 'systemId'
    //   688: aload_2
    //   689: invokevirtual getLac : ()I
    //   692: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   695: pop
    //   696: aload #4
    //   698: ldc_w 'netId'
    //   701: aload_2
    //   702: invokevirtual getCid : ()I
    //   705: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   708: pop
    //   709: aload #4
    //   711: ldc_w 'basestationId'
    //   714: aload_2
    //   715: invokevirtual getPsc : ()I
    //   718: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   721: pop
    //   722: aload #4
    //   724: ldc_w 'asuLevel'
    //   727: aload_2
    //   728: invokevirtual getRssi : ()I
    //   731: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   734: pop
    //   735: aload #4
    //   737: ldc_w 'type'
    //   740: aload_2
    //   741: invokevirtual getNetworkType : ()I
    //   744: invokestatic a : (I)Ljava/lang/String;
    //   747: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   750: pop
    //   751: aload_1
    //   752: aload #4
    //   754: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   757: pop
    //   758: goto -> 654
    //   761: astore #4
    //   763: goto -> 654
    //   766: aload_1
    //   767: invokevirtual length : ()I
    //   770: istore #8
    //   772: iload #8
    //   774: ifle -> 782
    //   777: aload_1
    //   778: astore_0
    //   779: goto -> 8
    //   782: aconst_null
    //   783: astore_0
    //   784: goto -> 8
    //   787: astore_0
    //   788: aconst_null
    //   789: astore_0
    //   790: goto -> 8
    //   793: aconst_null
    //   794: astore_0
    //   795: aconst_null
    //   796: astore #4
    //   798: iconst_m1
    //   799: istore #8
    //   801: iconst_m1
    //   802: istore #7
    //   804: iconst_m1
    //   805: istore #9
    //   807: iconst_m1
    //   808: istore #6
    //   810: iconst_m1
    //   811: istore #5
    //   813: goto -> 206
    // Exception table:
    //   from	to	target	type
    //   53	63	787	java/lang/Throwable
    //   63	86	787	java/lang/Throwable
    //   90	97	787	java/lang/Throwable
    //   97	116	787	java/lang/Throwable
    //   116	200	335	java/lang/Throwable
    //   212	222	335	java/lang/Throwable
    //   228	238	335	java/lang/Throwable
    //   244	254	335	java/lang/Throwable
    //   260	270	335	java/lang/Throwable
    //   276	286	335	java/lang/Throwable
    //   291	317	335	java/lang/Throwable
    //   317	332	335	java/lang/Throwable
    //   339	480	335	java/lang/Throwable
    //   492	548	335	java/lang/Throwable
    //   555	611	335	java/lang/Throwable
    //   617	636	787	java/lang/Throwable
    //   636	643	787	java/lang/Throwable
    //   647	654	787	java/lang/Throwable
    //   654	673	787	java/lang/Throwable
    //   673	758	761	java/lang/Throwable
    //   766	772	787	java/lang/Throwable
  }
  
  public static JSONArray u(Context paramContext) {
    try {
      if (!k.b)
        return null; 
      if (k.b(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
        List list = ((WifiManager)paramContext.getSystemService("wifi")).getConfiguredNetworks();
        if (list != null) {
          JSONArray jSONArray = new JSONArray();
          this();
          for (WifiConfiguration wifiConfiguration : list) {
            try {
              JSONObject jSONObject = new JSONObject();
              this();
              jSONObject.put("networkId", wifiConfiguration.networkId);
              jSONObject.put("priority", wifiConfiguration.priority);
              jSONObject.put("name", wifiConfiguration.SSID);
              jSONObject.put("id", wifiConfiguration.BSSID);
              jSONObject.put("allowedKeyManagement", a(wifiConfiguration.allowedKeyManagement));
              jSONObject.put("allowedAuthAlgorithms", a(wifiConfiguration.allowedAuthAlgorithms));
              jSONObject.put("allowedGroupCiphers", a(wifiConfiguration.allowedGroupCiphers));
              jSONObject.put("allowedPairwiseCiphers", a(wifiConfiguration.allowedPairwiseCiphers));
              jSONArray.put(jSONObject);
            } catch (Throwable throwable) {}
          } 
          int i = jSONArray.length();
          if (i <= 0)
            jSONArray = null; 
          return jSONArray;
        } 
      } 
    } catch (Throwable throwable) {}
    return null;
  }
  
  public static String v(Context paramContext) {
    Context context = null;
    try {
      if (!k.b)
        return (String)context; 
      if (k.b(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
        WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
        if (wifiManager.isWifiEnabled() && g(paramContext)) {
          WifiInfo wifiInfo = wifiManager.getConnectionInfo();
          if (wifiInfo != null) {
            String str = wifiInfo.getBSSID();
            if (str != null) {
              try {
                String str1 = wifiInfo.getSSID();
              } catch (Throwable null) {}
              return (String)throwable;
            } 
          } 
        } 
      } 
      paramContext = null;
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  public static JSONArray w(Context paramContext) {
    try {
      if (!k.b)
        return null; 
      if (k.b(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
        WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
        if (wifiManager.isWifiEnabled()) {
          WifiInfo wifiInfo = wifiManager.getConnectionInfo();
          if (wifiInfo != null && wifiInfo.getBSSID() != null) {
            String str = wifiInfo.getBSSID();
            JSONArray jSONArray = new JSONArray();
            this();
            JSONObject jSONObject = new JSONObject();
            this();
            try {
              jSONObject.put("name", wifiInfo.getSSID());
              jSONObject.put("id", str);
              jSONObject.put("level", wifiInfo.getRssi());
              jSONObject.put("hidden", wifiInfo.getHiddenSSID());
              jSONObject.put("ip", wifiInfo.getIpAddress());
              jSONObject.put("speed", wifiInfo.getLinkSpeed());
              jSONObject.put("networkId", wifiInfo.getNetworkId());
              jSONObject.put("mac", wifiInfo.getMacAddress());
              DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
              if (dhcpInfo != null) {
                JSONObject jSONObject1 = new JSONObject();
                this();
                jSONObject1.put("dns1", dhcpInfo.dns1);
                jSONObject1.put("dns2", dhcpInfo.dns2);
                jSONObject1.put("gw", dhcpInfo.gateway);
                jSONObject1.put("ip", dhcpInfo.ipAddress);
                jSONObject1.put("mask", dhcpInfo.netmask);
                jSONObject1.put("server", dhcpInfo.serverAddress);
                jSONObject1.put("leaseDuration", dhcpInfo.leaseDuration);
                jSONObject.put("dhcp", jSONObject1);
              } 
              jSONArray.put(jSONObject);
            } catch (Throwable throwable) {}
            return jSONArray;
          } 
        } 
      } 
    } catch (Throwable throwable) {}
    return null;
  }
  
  public static JSONArray x(Context paramContext) {
    // Byte code:
    //   0: getstatic com/unionpay/sdk/k.b : Z
    //   3: ifeq -> 18
    //   6: getstatic com/unionpay/sdk/k.d : Z
    //   9: ifne -> 22
    //   12: getstatic com/unionpay/sdk/k.e : Z
    //   15: ifne -> 22
    //   18: aconst_null
    //   19: astore_0
    //   20: aload_0
    //   21: areturn
    //   22: aload_0
    //   23: ldc_w 'android.permission.ACCESS_WIFI_STATE'
    //   26: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)Z
    //   29: ifeq -> 321
    //   32: aload_0
    //   33: ldc_w 'wifi'
    //   36: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   39: checkcast android/net/wifi/WifiManager
    //   42: astore_1
    //   43: aload_1
    //   44: invokevirtual isWifiEnabled : ()Z
    //   47: ifne -> 65
    //   50: getstatic android/os/Build$VERSION.SDK_INT : I
    //   53: bipush #18
    //   55: if_icmplt -> 321
    //   58: aload_1
    //   59: invokevirtual isScanAlwaysAvailable : ()Z
    //   62: ifeq -> 321
    //   65: aload_0
    //   66: ldc_w 'android.permission.CHANGE_WIFI_STATE'
    //   69: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)Z
    //   72: istore_2
    //   73: iload_2
    //   74: ifeq -> 135
    //   77: new java/lang/Object
    //   80: astore_3
    //   81: aload_3
    //   82: invokespecial <init> : ()V
    //   85: new android/content/IntentFilter
    //   88: astore #4
    //   90: aload #4
    //   92: ldc_w 'android.net.wifi.SCAN_RESULTS'
    //   95: invokespecial <init> : (Ljava/lang/String;)V
    //   98: new com/unionpay/sdk/ao
    //   101: astore #5
    //   103: aload #5
    //   105: aload_3
    //   106: aload_0
    //   107: invokespecial <init> : (Ljava/lang/Object;Landroid/content/Context;)V
    //   110: aload_0
    //   111: aload #5
    //   113: aload #4
    //   115: invokevirtual registerReceiver : (Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   118: pop
    //   119: aload_1
    //   120: invokevirtual startScan : ()Z
    //   123: pop
    //   124: aload_3
    //   125: monitorenter
    //   126: aload_3
    //   127: ldc2_w 2000
    //   130: invokevirtual wait : (J)V
    //   133: aload_3
    //   134: monitorexit
    //   135: aload_1
    //   136: invokevirtual getScanResults : ()Ljava/util/List;
    //   139: astore_1
    //   140: aload_1
    //   141: ifnull -> 321
    //   144: new org/json/JSONArray
    //   147: astore_0
    //   148: aload_0
    //   149: invokespecial <init> : ()V
    //   152: aload_1
    //   153: invokeinterface iterator : ()Ljava/util/Iterator;
    //   158: astore_1
    //   159: aload_1
    //   160: invokeinterface hasNext : ()Z
    //   165: ifeq -> 317
    //   168: aload_1
    //   169: invokeinterface next : ()Ljava/lang/Object;
    //   174: checkcast android/net/wifi/ScanResult
    //   177: astore_3
    //   178: aload_3
    //   179: getfield level : I
    //   182: bipush #-85
    //   184: if_icmplt -> 159
    //   187: new org/json/JSONObject
    //   190: dup
    //   191: invokespecial <init> : ()V
    //   194: astore #4
    //   196: aload #4
    //   198: ldc_w 'id'
    //   201: aload_3
    //   202: getfield BSSID : Ljava/lang/String;
    //   205: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   208: pop
    //   209: aload #4
    //   211: ldc_w 'name'
    //   214: aload_3
    //   215: getfield SSID : Ljava/lang/String;
    //   218: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   221: pop
    //   222: aload #4
    //   224: ldc_w 'level'
    //   227: aload_3
    //   228: getfield level : I
    //   231: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   234: pop
    //   235: aload #4
    //   237: ldc_w 'freq'
    //   240: aload_3
    //   241: getfield frequency : I
    //   244: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   247: pop
    //   248: bipush #17
    //   250: invokestatic a : (I)Z
    //   253: ifeq -> 294
    //   256: aload #4
    //   258: ldc_w 'ts'
    //   261: aload_3
    //   262: getfield timestamp : J
    //   265: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload #4
    //   271: ldc_w 'scanTs'
    //   274: invokestatic currentTimeMillis : ()J
    //   277: invokestatic elapsedRealtime : ()J
    //   280: lsub
    //   281: aload_3
    //   282: getfield timestamp : J
    //   285: ldc2_w 1000
    //   288: ldiv
    //   289: ladd
    //   290: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   293: pop
    //   294: aload_0
    //   295: aload #4
    //   297: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   300: pop
    //   301: goto -> 159
    //   304: astore_3
    //   305: goto -> 159
    //   308: astore_0
    //   309: aload_3
    //   310: monitorexit
    //   311: aload_0
    //   312: athrow
    //   313: astore_0
    //   314: goto -> 135
    //   317: goto -> 20
    //   320: astore_0
    //   321: aconst_null
    //   322: astore_0
    //   323: goto -> 20
    // Exception table:
    //   from	to	target	type
    //   22	65	320	java/lang/Throwable
    //   65	73	320	java/lang/Throwable
    //   77	126	313	java/lang/Throwable
    //   126	135	308	finally
    //   135	140	320	java/lang/Throwable
    //   144	159	320	java/lang/Throwable
    //   159	196	320	java/lang/Throwable
    //   196	294	304	java/lang/Throwable
    //   294	301	304	java/lang/Throwable
    //   309	313	313	java/lang/Throwable
  }
  
  public static JSONArray y(Context paramContext) {
    JSONArray jSONArray = new JSONArray();
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      ArrayList<String> arrayList = new ArrayList();
      this();
      if (k.a(22)) {
        SubscriptionManager subscriptionManager = (SubscriptionManager)paramContext.getSystemService("telephony_subscription_service");
        try {
          JSONObject jSONObject = a(telephonyManager, subscriptionManager, 0);
          jSONObject.put("imei", telephonyManager.getDeviceId());
          jSONArray.put(jSONObject);
        } catch (Throwable throwable1) {}
        try {
          JSONObject jSONObject = a(telephonyManager, subscriptionManager, 1);
          if (k.a(23) && telephonyManager.getPhoneCount() == 2) {
            String str1 = telephonyManager.getDeviceId(1);
          } else {
            subscriptionManager = null;
          } 
          jSONObject.put("imei", subscriptionManager);
          if (jSONObject.length() > 0)
            jSONArray.put(jSONObject); 
        } catch (Throwable throwable) {}
        return jSONArray;
      } 
      String str = telephonyManager.getDeviceId();
      if (b(str.trim()).booleanValue()) {
        arrayList.add(str.trim());
        JSONObject jSONObject = a(telephonyManager, str);
        if (jSONObject != null)
          jSONArray.put(jSONObject); 
      } 
      try {
        TelephonyManager telephonyManager1 = (TelephonyManager)throwable.getSystemService("phone1");
        String str1 = telephonyManager1.getDeviceId();
        if (str1 != null && b(str1).booleanValue() && !arrayList.contains(str1)) {
          arrayList.add(str1);
          JSONObject jSONObject = a(telephonyManager1, str1);
          if (jSONObject != null)
            jSONArray.put(jSONObject); 
        } 
        try {
          TelephonyManager telephonyManager2 = (TelephonyManager)throwable.getSystemService("phone2");
          String str2 = telephonyManager2.getDeviceId();
          if (str2 != null && b(str2).booleanValue() && !arrayList.contains(str2)) {
            arrayList.add(str2);
            JSONObject jSONObject = a(telephonyManager2, str2);
            if (jSONObject != null)
              jSONArray.put(jSONObject); 
          } 
          JSONArray jSONArray3 = D((Context)throwable);
          JSONArray jSONArray2 = C((Context)throwable);
          if (jSONArray2 == null)
            jSONArray2 = jSONArray3; 
          jSONArray3 = B((Context)throwable);
          if (jSONArray3 != null)
            jSONArray2 = jSONArray3; 
          JSONArray jSONArray1 = A((Context)throwable);
          if (jSONArray1 != null)
            jSONArray2 = jSONArray1; 
          if (jSONArray2 != null && jSONArray2.length() > 0) {
            byte b = 0;
            while (true) {
              if (b < jSONArray2.length()) {
                JSONObject jSONObject = jSONArray2.getJSONObject(b);
                String str3 = jSONObject.getString("imei");
                if (!arrayList.contains(str3)) {
                  arrayList.add(str3);
                  jSONArray.put(jSONObject);
                } 
                b++;
                continue;
              } 
              return jSONArray;
            } 
          } 
        } catch (Throwable throwable1) {}
      } catch (Throwable throwable1) {}
    } catch (Throwable throwable) {}
    return jSONArray;
  }
  
  public static JSONObject z(Context paramContext) {
    Throwable throwable2 = null;
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      try {
        TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        jSONObject.put("dataState", telephonyManager.getDataState());
        jSONObject.put("networkType", a(telephonyManager.getNetworkType()));
        jSONObject.put("networkOperator", telephonyManager.getNetworkOperator());
        jSONObject.put("phoneType", b(telephonyManager.getPhoneType()));
        JSONObject jSONObject1 = jSONObject;
      } catch (Throwable throwable) {
        JSONObject jSONObject1 = jSONObject;
      } 
    } catch (Throwable throwable1) {
      throwable1 = throwable2;
    } 
    return (JSONObject)throwable1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */