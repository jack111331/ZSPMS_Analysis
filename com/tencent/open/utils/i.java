package com.tencent.open.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.open.a.f;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import org.json.JSONException;
import org.json.JSONObject;

public class i {
  private static String a = "";
  
  private static String b = "";
  
  private static String c = "";
  
  private static String d = "";
  
  private static int e = -1;
  
  private static String f;
  
  private static String g = "0123456789ABCDEF";
  
  private static char a(int paramInt) {
    paramInt &= 0xF;
    if (paramInt < 10) {
      paramInt = (char)(paramInt + 48);
      return paramInt;
    } 
    paramInt = (char)(paramInt - 10 + 97);
    return paramInt;
  }
  
  public static Bundle a(String paramString) {
    byte b = 0;
    Bundle bundle1 = new Bundle();
    Bundle bundle2 = bundle1;
    if (paramString != null)
      try {
        String[] arrayOfString = paramString.split("&");
        int j = arrayOfString.length;
        while (true) {
          bundle2 = bundle1;
          if (b < j) {
            String[] arrayOfString1 = arrayOfString[b].split("=");
            if (arrayOfString1.length == 2)
              bundle1.putString(URLDecoder.decode(arrayOfString1[0]), URLDecoder.decode(arrayOfString1[1])); 
            b++;
            continue;
          } 
          break;
        } 
      } catch (Exception exception) {
        bundle2 = null;
      }  
    return bundle2;
  }
  
  public static Bundle a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
    return a(paramString1, paramString3, paramString4, paramString2, paramString5, paramString6, "", "", "", "", "", "");
  }
  
  public static Bundle a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9) {
    Bundle bundle = new Bundle();
    bundle.putString("platform", "1");
    bundle.putString("result", paramString1);
    bundle.putString("code", paramString2);
    bundle.putString("tmcost", paramString3);
    bundle.putString("rate", paramString4);
    bundle.putString("cmd", paramString5);
    bundle.putString("uin", paramString6);
    bundle.putString("appid", paramString7);
    bundle.putString("share_type", paramString8);
    bundle.putString("detail", paramString9);
    bundle.putString("os_ver", Build.VERSION.RELEASE);
    bundle.putString("network", com.tencent.open.b.a.a(d.a()));
    bundle.putString("apn", com.tencent.open.b.a.b(d.a()));
    bundle.putString("model_name", Build.MODEL);
    bundle.putString("sdk_ver", "3.3.0.lite");
    bundle.putString("packagename", d.b());
    bundle.putString("app_ver", d(d.a(), d.b()));
    return bundle;
  }
  
  public static Bundle a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12) {
    Bundle bundle = new Bundle();
    bundle.putString("openid", paramString1);
    bundle.putString("report_type", paramString2);
    bundle.putString("act_type", paramString3);
    bundle.putString("via", paramString4);
    bundle.putString("app_id", paramString5);
    bundle.putString("result", paramString6);
    bundle.putString("type", paramString7);
    bundle.putString("login_status", paramString8);
    bundle.putString("need_user_auth", paramString9);
    bundle.putString("to_uin", paramString10);
    bundle.putString("call_source", paramString11);
    bundle.putString("to_type", paramString12);
    return bundle;
  }
  
  public static String a() {
    try {
      Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
      while (enumeration != null && enumeration.hasMoreElements()) {
        Enumeration<InetAddress> enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
        while (enumeration1.hasMoreElements()) {
          InetAddress inetAddress = enumeration1.nextElement();
          if (!inetAddress.isLoopbackAddress())
            return inetAddress.getHostAddress().toString(); 
        } 
      } 
    } catch (SocketException socketException) {
      f.a("openSDK_LOG.Util", "getUserIp SocketException ", socketException);
    } 
    return "";
  }
  
  public static final String a(Context paramContext) {
    if (paramContext != null) {
      CharSequence charSequence = paramContext.getPackageManager().getApplicationLabel(paramContext.getApplicationInfo());
      if (charSequence != null)
        return charSequence.toString(); 
    } 
    return null;
  }
  
  public static final String a(String paramString1, int paramInt, String paramString2, String paramString3) {
    String str;
    byte b = 0;
    if (TextUtils.isEmpty(paramString1))
      return ""; 
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString2;
    } else {
      str = "UTF-8";
    } 
    paramString2 = paramString1;
    try {
      if ((paramString1.getBytes(str)).length > paramInt) {
        int j = 0;
        while (true) {
          paramString2 = paramString1;
          if (b < paramString1.length()) {
            int k = (paramString1.substring(b, b + 1).getBytes(str)).length;
            if (j + k > paramInt) {
              paramString2 = paramString1.substring(0, b);
              paramString1 = paramString2;
              paramString2 = paramString1;
              try {
                if (!TextUtils.isEmpty(paramString3)) {
                  StringBuilder stringBuilder = new StringBuilder();
                  this();
                  String str1 = stringBuilder.append(paramString1).append(paramString3).toString();
                } 
              } catch (Exception null) {}
              return (String)exception;
            } 
            j += k;
            b++;
            continue;
          } 
          return (String)exception;
        } 
      } 
    } catch (Exception exception) {}
    return (String)exception;
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return null; 
    StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
    for (byte b = 0; b < paramArrayOfbyte.length; b++) {
      String str1 = Integer.toString(paramArrayOfbyte[b] & 0xFF, 16);
      String str2 = str1;
      if (str1.length() == 1)
        str2 = "0" + str1; 
      stringBuilder.append(str2);
    } 
    return stringBuilder.toString();
  }
  
  public static JSONObject a(JSONObject paramJSONObject, String paramString) {
    JSONObject jSONObject = paramJSONObject;
    if (paramJSONObject == null)
      jSONObject = new JSONObject(); 
    if (paramString != null) {
      String[] arrayOfString = paramString.split("&");
      int j = arrayOfString.length;
      for (byte b = 0;; b++) {
        if (b < j) {
          String[] arrayOfString1 = arrayOfString[b].split("=");
          if (arrayOfString1.length == 2) {
            try {
              arrayOfString1[0] = URLDecoder.decode(arrayOfString1[0]);
              arrayOfString1[1] = URLDecoder.decode(arrayOfString1[1]);
            } catch (Exception exception) {
            
            } catch (JSONException jSONException) {
              f.e("openSDK_LOG.Util", "decodeUrlToJson has exception: " + jSONException.getMessage());
              b++;
              continue;
            } 
            jSONObject.put((String)jSONException[0], jSONException[1]);
          } 
        } else {
          return jSONObject;
        } 
      } 
    } 
    return jSONObject;
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    Intent intent = new Intent();
    intent.setComponent(new ComponentName(paramString1, paramString2));
    intent.setAction("android.intent.action.VIEW");
    intent.addFlags(1073741824);
    intent.addFlags(268435456);
    intent.setData(Uri.parse(paramString3));
    paramContext.startActivity(intent);
  }
  
  public static boolean a(Context paramContext, String paramString) {
    boolean bool2;
    boolean bool1 = false;
    try {
      bool2 = f(paramContext);
      if (bool2) {
        try {
          a(paramContext, "com.tencent.mtt", "com.tencent.mtt.MainActivity", paramString);
          bool2 = true;
        } catch (Exception exception) {}
      } else {
        a(paramContext, "com.android.browser", "com.android.browser.BrowserActivity", paramString);
        bool2 = true;
      } 
    } catch (Exception exception) {
      bool2 = false;
    } 
    if (bool2) {
      try {
        a(paramContext, "com.android.browser", "com.android.browser.BrowserActivity", paramString);
        bool2 = true;
      } catch (Exception exception) {}
      return bool2;
    } 
    try {
      a(paramContext, "com.google.android.browser", "com.android.browser.BrowserActivity", paramString);
      bool2 = true;
    } catch (Exception exception) {}
    return bool2;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean) {
    boolean bool = false;
    if (d(paramContext) && g.a(paramContext, "com.tencent.minihd.qq") != null)
      return true; 
    if (!paramBoolean) {
      if (g.c(paramContext, "4.1") < 0 && g.a(paramContext, "com.tencent.tim") == null) {
        paramBoolean = bool;
        return (g.a(paramContext, "com.tencent.qim") != null) ? true : paramBoolean;
      } 
    } else {
      if (g.c(paramContext, "4.1") < 0) {
        paramBoolean = bool;
        if (g.a(paramContext, "com.tencent.tim") != null)
          paramBoolean = true; 
        return paramBoolean;
      } 
      paramBoolean = true;
    } 
    return true;
  }
  
  public static Bundle b(String paramString) {
    Bundle bundle;
    paramString = paramString.replace("auth://", "http://");
    try {
      URL uRL = new URL();
      this(paramString);
      bundle = a(uRL.getQuery());
      bundle.putAll(a(uRL.getRef()));
    } catch (MalformedURLException malformedURLException) {
      bundle = new Bundle();
    } 
    return bundle;
  }
  
  public static void b(Context paramContext, String paramString) {
    if (paramContext != null)
      try {
        PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 0);
        b = packageInfo.versionName;
        a = b.substring(0, b.lastIndexOf('.'));
        d = b.substring(b.lastIndexOf('.') + 1, b.length());
        e = packageInfo.versionCode;
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        f.e("openSDK_LOG.Util", "getPackageInfo has exception: " + nameNotFoundException.getMessage());
      } catch (Exception exception) {
        f.e("openSDK_LOG.Util", "getPackageInfo has exception: " + exception.getMessage());
      }  
  }
  
  public static boolean b() {
    File file = null;
    if (Environment.getExternalStorageState().equals("mounted"))
      file = Environment.getExternalStorageDirectory(); 
    return (file != null);
  }
  
  public static boolean b(Context paramContext) {
    boolean bool1 = false;
    ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (connectivityManager == null)
      return true; 
    NetworkInfo[] arrayOfNetworkInfo = connectivityManager.getAllNetworkInfo();
    boolean bool2 = bool1;
    if (arrayOfNetworkInfo != null) {
      byte b = 0;
      while (true) {
        bool2 = bool1;
        if (b < arrayOfNetworkInfo.length) {
          if (arrayOfNetworkInfo[b].isConnectedOrConnecting())
            return true; 
          b++;
          continue;
        } 
        return bool2;
      } 
    } 
    return bool2;
  }
  
  public static String c(Context paramContext) {
    if (paramContext == null)
      return ""; 
    try {
      LocationManager locationManager = (LocationManager)paramContext.getSystemService("location");
      Criteria criteria = new Criteria();
      this();
      criteria.setCostAllowed(false);
      criteria.setAccuracy(2);
      String str = locationManager.getBestProvider(criteria, true);
      if (str != null) {
        Location location = locationManager.getLastKnownLocation(str);
        if (location == null)
          return ""; 
        double d1 = location.getLatitude();
        double d2 = location.getLongitude();
        StringBuilder stringBuilder = new StringBuilder();
        this();
        f = stringBuilder.append(d1).append("*").append(d2).toString();
        return f;
      } 
    } catch (Exception exception) {
      f.b("openSDK_LOG.Util", "getLocation>>>", exception);
    } 
    return "";
  }
  
  public static String c(Context paramContext, String paramString) {
    if (paramContext == null)
      return ""; 
    b(paramContext, paramString);
    return b;
  }
  
  public static JSONObject c(String paramString) {
    JSONObject jSONObject;
    paramString = paramString.replace("auth://", "http://");
    try {
      URL uRL = new URL();
      this(paramString);
      jSONObject = a((JSONObject)null, uRL.getQuery());
      a(jSONObject, uRL.getRef());
    } catch (MalformedURLException malformedURLException) {
      jSONObject = new JSONObject();
    } 
    return jSONObject;
  }
  
  public static String d(Context paramContext, String paramString) {
    if (paramContext == null)
      return ""; 
    b(paramContext, paramString);
    return a;
  }
  
  public static JSONObject d(String paramString) throws JSONException {
    String str = paramString;
    if (paramString.equals("false"))
      str = "{value : false}"; 
    paramString = str;
    if (str.equals("true"))
      paramString = "{value : true}"; 
    str = paramString;
    if (paramString.contains("allback("))
      str = paramString.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim(); 
    paramString = str;
    if (str.contains("online[0]="))
      paramString = "{online:" + str.charAt(str.length() - 2) + "}"; 
    return new JSONObject(paramString);
  }
  
  public static boolean d(Context paramContext) {
    double d = 0.0D;
    try {
      DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
      float f1 = displayMetrics.widthPixels / displayMetrics.xdpi;
      float f2 = displayMetrics.heightPixels / displayMetrics.ydpi;
      double d1 = Math.pow(f1, 2.0D);
      d1 = Math.sqrt(Math.pow(f2, 2.0D) + d1);
      d = d1;
    } catch (Throwable throwable) {}
    return (d > 6.5D);
  }
  
  public static String e(Context paramContext, String paramString) {
    if (paramContext == null)
      return ""; 
    c = d(paramContext, paramString);
    return c;
  }
  
  public static boolean e(Context paramContext) {
    return (g.c(paramContext, "5.9.5") >= 0 || g.a(paramContext, "com.tencent.tim") != null);
  }
  
  public static boolean e(String paramString) {
    return (paramString == null || paramString.length() == 0);
  }
  
  public static String f(String paramString) {
    String str;
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(i(paramString));
      byte[] arrayOfByte = messageDigest.digest();
      str = paramString;
      if (arrayOfByte != null) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        int j = arrayOfByte.length;
        for (byte b = 0; b < j; b++) {
          byte b1 = arrayOfByte[b];
          stringBuilder.append(a(b1 >>> 4));
          stringBuilder.append(a(b1));
        } 
        String str1 = stringBuilder.toString();
      } 
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      f.e("openSDK_LOG.Util", "encrypt has exception: " + noSuchAlgorithmException.getMessage());
      str = paramString;
    } 
    return str;
  }
  
  private static boolean f(Context paramContext) {
    boolean bool2;
    boolean bool1 = false;
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
      String str = packageInfo.versionName;
      bool2 = bool1;
      if (g.a(str, "4.3") >= 0) {
        bool2 = bool1;
        if (!str.startsWith("4.4")) {
          Signature[] arrayOfSignature = packageInfo.signatures;
          bool2 = bool1;
          if (arrayOfSignature != null)
            try {
              MessageDigest messageDigest = MessageDigest.getInstance("MD5");
              messageDigest.update(arrayOfSignature[0].toByteArray());
              String str1 = a(messageDigest.digest());
              messageDigest.reset();
              boolean bool = str1.equals("d8391a394d4a179e6fe7bdb8a301258b");
              bool2 = bool1;
              if (bool)
                bool2 = true; 
            } catch (NoSuchAlgorithmException noSuchAlgorithmException) {} 
        } 
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      bool2 = bool1;
    } 
    return bool2;
  }
  
  public static boolean f(Context paramContext, String paramString) {
    boolean bool1 = true;
    if (d(paramContext) && g.a(paramContext, "com.tencent.minihd.qq") != null) {
      bool2 = false;
    } else {
      bool2 = true;
    } 
    null = bool2;
    if (bool2) {
      null = bool2;
      if (g.a(paramContext, "com.tencent.tim") != null)
        null = false; 
    } 
    boolean bool2 = null;
    if (null) {
      bool2 = null;
      if (g.a(paramContext, "com.tencent.qim") != null)
        bool2 = false; 
    } 
    return bool2 ? ((g.c(paramContext, paramString) < 0) ? bool1 : false) : bool2;
  }
  
  public static boolean g(Context paramContext, String paramString) {
    boolean bool2;
    boolean bool1 = true;
    if (d(paramContext) && g.a(paramContext, "com.tencent.minihd.qq") != null) {
      bool2 = false;
    } else {
      bool2 = true;
    } 
    null = bool2;
    if (bool2) {
      null = bool2;
      if (g.a(paramContext, "com.tencent.tim") != null)
        null = false; 
    } 
    if (null) {
      if (g.c(paramContext, paramString) < 0)
        return bool1; 
    } else {
      return null;
    } 
    return false;
  }
  
  public static final boolean g(String paramString) {
    boolean bool = false;
    if (paramString != null && (paramString.startsWith("http://") || paramString.startsWith("https://")))
      bool = true; 
    return bool;
  }
  
  public static boolean h(String paramString) {
    boolean bool1 = false;
    if (paramString == null)
      return bool1; 
    File file = new File(paramString);
    boolean bool2 = bool1;
    if (file != null) {
      bool2 = bool1;
      if (file.exists())
        bool2 = true; 
    } 
    return bool2;
  }
  
  public static byte[] i(String paramString) {
    try {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException = null;
    } 
    return (byte[])unsupportedEncodingException;
  }
  
  public static class a {
    public String a;
    
    public long b;
    
    public long c;
    
    public a(String param1String, int param1Int) {
      this.a = param1String;
      this.b = param1Int;
      if (this.a != null)
        this.c = this.a.length(); 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\ope\\utils\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */