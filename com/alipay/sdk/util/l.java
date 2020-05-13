package com.alipay.sdk.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.app.i;
import com.alipay.sdk.app.j;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"SetJavaScriptEnabled", "DefaultLocale"})
public final class l {
  static final String a = "com.alipay.android.app";
  
  public static final int b = 99;
  
  public static final int c = 73;
  
  private static final String d = "com.eg.android.AlipayGphone";
  
  private static final String e = "com.eg.android.AlipayGphoneRC";
  
  public static WebView a(Activity paramActivity, String paramString1, String paramString2) {
    Context context = paramActivity.getApplicationContext();
    if (!TextUtils.isEmpty(paramString2)) {
      CookieSyncManager.createInstance(context).sync();
      CookieManager.getInstance().setCookie(paramString1, paramString2);
      CookieSyncManager.getInstance().sync();
    } 
    LinearLayout linearLayout = new LinearLayout(context);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
    linearLayout.setOrientation(1);
    paramActivity.setContentView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams);
    WebView webView = new WebView(context);
    layoutParams.weight = 1.0F;
    webView.setVisibility(0);
    linearLayout.addView((View)webView, (ViewGroup.LayoutParams)layoutParams);
    WebSettings webSettings = webView.getSettings();
    webSettings.setUserAgentString(webSettings.getUserAgentString() + e(context));
    webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
    webSettings.setSupportMultipleWindows(true);
    webSettings.setJavaScriptEnabled(true);
    webSettings.setSavePassword(false);
    webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    webSettings.setMinimumFontSize(webSettings.getMinimumFontSize() + 8);
    webSettings.setAllowFileAccess(false);
    webSettings.setTextSize(WebSettings.TextSize.NORMAL);
    webView.setVerticalScrollbarOverlay(true);
    webView.setDownloadListener(new m(context));
    if (Build.VERSION.SDK_INT >= 7)
      try {
        Method method = webView.getSettings().getClass().getMethod("setDomStorageEnabled", new Class[] { boolean.class });
        if (method != null)
          method.invoke(webView.getSettings(), new Object[] { Boolean.valueOf(true) }); 
      } catch (Exception exception) {} 
    try {
      webView.removeJavascriptInterface("searchBoxJavaBridge_");
      webView.removeJavascriptInterface("accessibility");
      webView.removeJavascriptInterface("accessibilityTraversal");
      if (Build.VERSION.SDK_INT >= 19)
        webView.getSettings().setCacheMode(2); 
    } catch (Throwable throwable) {
      try {
        Method method = webView.getClass().getMethod("removeJavascriptInterface", new Class[0]);
        if (method != null) {
          method.invoke(webView, new Object[] { "searchBoxJavaBridge_" });
          method.invoke(webView, new Object[] { "accessibility" });
          method.invoke(webView, new Object[] { "accessibilityTraversal" });
        } 
        if (Build.VERSION.SDK_INT >= 19)
          webView.getSettings().setCacheMode(2); 
      } catch (Throwable throwable1) {
        if (Build.VERSION.SDK_INT >= 19)
          webView.getSettings().setCacheMode(2); 
      } 
      webView.loadUrl(paramString1);
      return webView;
    } 
  }
  
  public static a a(Context paramContext) {
    return a(paramContext, a());
  }
  
  private static a a(Context paramContext, String paramString) {
    Context context = null;
    try {
      PackageInfo packageInfo1 = paramContext.getPackageManager().getPackageInfo(paramString, 192);
      PackageInfo packageInfo2 = packageInfo1;
      if (!a(packageInfo1)) {
        try {
          packageInfo2 = c(paramContext, paramString);
          if (!a(packageInfo2))
            return (a)context; 
        } catch (Throwable throwable) {
          com.alipay.sdk.app.statistic.a.a("auth", "GetInstalledPackagesEx", throwable);
          packageInfo2 = packageInfo1;
          if (!a(packageInfo2))
            return (a)context; 
        } 
        paramContext = context;
        return a;
      } 
    } catch (Throwable throwable) {
      com.alipay.sdk.app.statistic.a.a("auth", "GetPackageInfoEx", throwable);
      if (!a((PackageInfo)null)) {
        try {
          PackageInfo packageInfo = c(paramContext, paramString);
        } catch (Throwable throwable1) {
          com.alipay.sdk.app.statistic.a.a("auth", "GetInstalledPackagesEx", throwable1);
          throwable = null;
        } 
      } else {
        throwable = null;
      } 
    } finally {
      if (!a((PackageInfo)null))
        try {
          c(paramContext, paramString);
        } catch (Throwable throwable) {
          com.alipay.sdk.app.statistic.a.a("auth", "GetInstalledPackagesEx", throwable);
        }  
    } 
  }
  
  public static String a() {
    return EnvUtils.isSandBox() ? "com.eg.android.AlipayGphoneRC" : "com.eg.android.AlipayGphone";
  }
  
  public static String a(String paramString1, String paramString2, String paramString3) {
    String str;
    try {
      int i = paramString3.indexOf(paramString1);
      int j = paramString1.length() + i;
      if (j <= paramString1.length())
        return ""; 
      i = 0;
      if (!TextUtils.isEmpty(paramString2))
        i = paramString3.indexOf(paramString2, j); 
      if (i <= 0)
        return paramString3.substring(j); 
      paramString1 = paramString3.substring(j, i);
    } catch (Throwable throwable) {
      str = "";
    } 
    return str;
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    try {
      CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream();
      this(paramArrayOfbyte);
      String str = ((X509Certificate)certificateFactory.generateCertificate(byteArrayInputStream)).getPublicKey().toString();
      if (str.indexOf("modulus") != -1)
        return str.substring(str.indexOf("modulus") + 8, str.lastIndexOf(",")).trim(); 
    } catch (Exception exception) {
      com.alipay.sdk.app.statistic.a.a("auth", "GetPublicKeyFromSignEx", exception);
    } 
    return null;
  }
  
  public static Map<String, String> a(String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (String str : paramString.split("&")) {
      int i = str.indexOf("=", 1);
      hashMap.put(str.substring(0, i), URLDecoder.decode(str.substring(i + 1)));
    } 
    return (Map)hashMap;
  }
  
  private static boolean a(PackageInfo paramPackageInfo) {
    String str1;
    String str2 = "";
    boolean bool = false;
    if (paramPackageInfo == null) {
      str1 = "" + "info == null";
    } else if (((PackageInfo)str1).signatures == null) {
      str1 = "" + "info.signatures == null";
    } else if (((PackageInfo)str1).signatures.length <= 0) {
      str1 = "" + "info.signatures.length <= 0";
    } else {
      bool = true;
      str1 = str2;
    } 
    if (!bool)
      com.alipay.sdk.app.statistic.a.a("auth", "NotIncludeSignatures", str1); 
    return bool;
  }
  
  public static boolean a(WebView paramWebView, String paramString, Activity paramActivity) {
    if (!TextUtils.isEmpty(paramString)) {
      j j1;
      Intent intent;
      j j2;
      if (paramString.toLowerCase().startsWith("alipays://platformapi/startApp?".toLowerCase()) || paramString.toLowerCase().startsWith("intent://platformapi/startapp?".toLowerCase())) {
        try {
          a a = a((Context)paramActivity);
          if (a != null && !a.a()) {
            String str = paramString;
            if (paramString.startsWith("intent://platformapi/startapp"))
              str = paramString.replaceFirst("intent://platformapi/startapp\\?", "alipays://platformapi/startApp?"); 
            intent = new Intent();
            this("android.intent.action.VIEW", Uri.parse(str));
            paramActivity.startActivity(intent);
          } 
        } catch (Throwable throwable) {}
        return true;
      } 
      if (TextUtils.equals((CharSequence)intent, "sdklite://h5quit") || TextUtils.equals((CharSequence)intent, "http://m.alipay.com/?action=h5quit")) {
        i.a = i.a();
        paramActivity.finish();
        return true;
      } 
      if (intent.startsWith("sdklite://h5quit?result=")) {
        try {
          String str = intent.substring(intent.indexOf("sdklite://h5quit?result=") + 24);
          int i = Integer.parseInt(str.substring(str.lastIndexOf("&end_code=") + 10));
          if (i == j.a.h || i == j.g.h) {
            String str1;
            if (com.alipay.sdk.cons.a.r) {
              StringBuilder stringBuilder = new StringBuilder();
              this();
              str1 = URLDecoder.decode((String)intent);
              String str3 = URLDecoder.decode(str1);
              str3 = str3.substring(str3.indexOf("sdklite://h5quit?result=") + 24, str3.lastIndexOf("&end_code=")).split("&return_url=")[0];
              int j = str1.indexOf("&return_url=") + 12;
              stringBuilder.append(str3).append("&return_url=").append(str1.substring(j, str1.indexOf("&", j))).append(str1.substring(str1.indexOf("&", j)));
              String str2 = stringBuilder.toString();
            } else {
              str = URLDecoder.decode(str1);
              str = str.substring(str.indexOf("sdklite://h5quit?result=") + 24, str.lastIndexOf("&end_code="));
            } 
            j2 = j.a(i);
            i.a = i.a(j2.h, j2.i, str);
          } else {
            j1 = j.a(j.b.h);
            i.a = i.a(j1.h, j1.i, "");
          } 
          paramActivity.runOnUiThread(new n(paramActivity));
        } catch (Exception exception) {
          j1 = j.a(j.e.h);
          i.a = i.a(j1.h, j1.i, "");
        } 
        return true;
      } 
      j1.loadUrl((String)j2);
    } 
    return true;
  }
  
  private static PackageInfo b(Context paramContext, String paramString) throws PackageManager.NameNotFoundException {
    return paramContext.getPackageManager().getPackageInfo(paramString, 192);
  }
  
  private static a b(PackageInfo paramPackageInfo) {
    if (paramPackageInfo == null)
      return null; 
    a a = new a();
    a.a = paramPackageInfo.signatures;
    a.b = paramPackageInfo.versionCode;
    return a;
  }
  
  public static String b() {
    return "Android " + Build.VERSION.RELEASE;
  }
  
  public static String b(String paramString1, String paramString2, String paramString3) {
    String str;
    try {
      int i = paramString3.indexOf(paramString1);
      int j = paramString1.length() + i;
      i = 0;
      if (!TextUtils.isEmpty(paramString2))
        i = paramString3.indexOf(paramString2, j); 
      if (i <= 0)
        return paramString3.substring(j); 
      paramString1 = paramString3.substring(j, i);
    } catch (Throwable throwable) {
      str = "";
    } 
    return str;
  }
  
  public static boolean b(Context paramContext) {
    boolean bool = false;
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo("com.alipay.android.app", 128);
      if (packageInfo != null)
        bool = true; 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
    return bool;
  }
  
  public static boolean b(String paramString) {
    return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(paramString).matches();
  }
  
  private static PackageInfo c(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   4: sipush #192
    //   7: invokevirtual getInstalledPackages : (I)Ljava/util/List;
    //   10: invokeinterface iterator : ()Ljava/util/Iterator;
    //   15: astore_2
    //   16: aload_2
    //   17: invokeinterface hasNext : ()Z
    //   22: ifeq -> 48
    //   25: aload_2
    //   26: invokeinterface next : ()Ljava/lang/Object;
    //   31: checkcast android/content/pm/PackageInfo
    //   34: astore_0
    //   35: aload_0
    //   36: getfield packageName : Ljava/lang/String;
    //   39: aload_1
    //   40: invokevirtual equals : (Ljava/lang/Object;)Z
    //   43: ifeq -> 16
    //   46: aload_0
    //   47: areturn
    //   48: aconst_null
    //   49: astore_0
    //   50: goto -> 46
  }
  
  public static String c() {
    String str1 = e();
    int i = str1.indexOf("-");
    String str2 = str1;
    if (i != -1)
      str2 = str1.substring(0, i); 
    i = str2.indexOf("\n");
    str1 = str2;
    if (i != -1)
      str1 = str2.substring(0, i); 
    return "Linux " + str1;
  }
  
  public static boolean c(Context paramContext) {
    boolean bool = false;
    try {
      String str = a();
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(str, 128);
      if (packageInfo != null) {
        int i = packageInfo.versionCode;
        if (i > 73)
          bool = true; 
      } 
    } catch (Throwable throwable) {
      com.alipay.sdk.app.statistic.a.a("biz", "CheckClientExistEx", throwable);
    } 
    return bool;
  }
  
  @SuppressLint({"InlinedApi"})
  private static boolean c(PackageInfo paramPackageInfo) {
    int i = paramPackageInfo.applicationInfo.flags;
    return ((i & 0x1) == 0 && (i & 0x80) == 0);
  }
  
  public static String d() {
    Random random = new Random();
    StringBuilder stringBuilder = new StringBuilder();
    byte b = 0;
    while (b < 24) {
      switch (random.nextInt(3)) {
        case 0:
          stringBuilder.append(String.valueOf((char)(int)Math.round(Math.random() * 25.0D + 65.0D)));
          b++;
          break;
        case 1:
          stringBuilder.append(String.valueOf((char)(int)Math.round(Math.random() * 25.0D + 97.0D)));
          b++;
          break;
        case 2:
          stringBuilder.append(String.valueOf((new Random()).nextInt(10)));
          b++;
          break;
      } 
    } 
    return stringBuilder.toString();
  }
  
  public static boolean d(Context paramContext) {
    boolean bool = false;
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(a(), 128);
      if (packageInfo != null) {
        int i = packageInfo.versionCode;
        if (i < 99)
          bool = true; 
      } 
    } catch (Throwable throwable) {}
    return bool;
  }
  
  private static String e() {
    try {
      BufferedReader bufferedReader = new BufferedReader();
      null = new FileReader();
      this("/proc/version");
      this(null, 256);
      try {
        String str = bufferedReader.readLine();
        bufferedReader.close();
        Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(str);
      } finally {
        bufferedReader.close();
      } 
    } catch (IOException iOException) {
      return "Unavailable";
    } 
    if (SYNTHETIC_LOCAL_VARIABLE_0.groupCount() < 4)
      return "Unavailable"; 
    StringBuilder stringBuilder = new StringBuilder();
    this(SYNTHETIC_LOCAL_VARIABLE_0.group(1));
    return stringBuilder.append("\n").append(SYNTHETIC_LOCAL_VARIABLE_0.group(2)).append(" ").append(SYNTHETIC_LOCAL_VARIABLE_0.group(3)).append("\n").append(SYNTHETIC_LOCAL_VARIABLE_0.group(4)).toString();
  }
  
  public static String e(Context paramContext) {
    String str2 = b();
    String str3 = c();
    String str4 = f(paramContext);
    String str1 = g(paramContext);
    return " (" + str2 + ";" + str3 + ";" + str4 + ";;" + str1 + ")(sdk android)";
  }
  
  private static String f() {
    return "-1;-1";
  }
  
  public static String f(Context paramContext) {
    return (paramContext.getResources().getConfiguration()).locale.toString();
  }
  
  public static String g(Context paramContext) {
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(displayMetrics.widthPixels);
    stringBuilder.append("*");
    stringBuilder.append(displayMetrics.heightPixels);
    return stringBuilder.toString();
  }
  
  public static String h(Context paramContext) {
    String str2 = "";
    try {
      Iterator<ActivityManager.RunningAppProcessInfo> iterator = ((ActivityManager)paramContext.getApplicationContext().getSystemService("activity")).getRunningAppProcesses().iterator();
      String str = str2;
      while (true) {
        str2 = str;
        if (iterator.hasNext()) {
          StringBuilder stringBuilder1;
          ActivityManager.RunningAppProcessInfo runningAppProcessInfo = iterator.next();
          if (runningAppProcessInfo.processName.equals(a())) {
            stringBuilder1 = new StringBuilder();
            this();
            str = stringBuilder1.append(str).append("#M").toString();
            continue;
          } 
          String str3 = ((ActivityManager.RunningAppProcessInfo)stringBuilder1).processName;
          StringBuilder stringBuilder2 = new StringBuilder();
          this();
          if (str3.startsWith(stringBuilder2.append(a()).append(":").toString())) {
            StringBuilder stringBuilder4 = new StringBuilder();
            this();
            StringBuilder stringBuilder3 = stringBuilder4.append(str).append("#");
            String str5 = ((ActivityManager.RunningAppProcessInfo)stringBuilder1).processName;
            stringBuilder1 = new StringBuilder();
            this();
            String str4 = stringBuilder3.append(str5.replace(stringBuilder1.append(a()).append(":").toString(), "")).toString();
          } 
          continue;
        } 
        break;
      } 
    } catch (Throwable throwable) {
      str2 = "";
    } 
    String str1 = str2;
    if (str2.length() > 0)
      str1 = str2.substring(1); 
    str2 = str1;
    if (str1.length() == 0)
      str2 = "N"; 
    return str2;
  }
  
  public static String i(Context paramContext) {
    StringBuilder stringBuilder;
    try {
      List<PackageInfo> list = paramContext.getPackageManager().getInstalledPackages(0);
      stringBuilder = new StringBuilder();
      this();
      for (byte b = 0; b < list.size(); b++) {
        PackageInfo packageInfo = list.get(b);
        int i = packageInfo.applicationInfo.flags;
        if ((i & 0x1) == 0 && (i & 0x80) == 0) {
          i = 1;
        } else {
          i = 0;
        } 
        if (i != 0)
          if (packageInfo.packageName.equals(a())) {
            stringBuilder.append(packageInfo.packageName).append(packageInfo.versionCode).append("-");
          } else if (!packageInfo.packageName.contains("theme") && !packageInfo.packageName.startsWith("com.google.") && !packageInfo.packageName.startsWith("com.android.")) {
            stringBuilder.append(packageInfo.packageName).append("-");
          }  
      } 
    } catch (Throwable throwable) {
      com.alipay.sdk.app.statistic.a.a("biz", "GetInstalledAppEx", throwable);
      return "";
    } 
    return stringBuilder.toString();
  }
  
  private static DisplayMetrics j(Context paramContext) {
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
    return displayMetrics;
  }
  
  private static String k(Context paramContext) {
    String str = k.a(paramContext);
    return str.substring(0, str.indexOf("://"));
  }
  
  public static final class a {
    public Signature[] a;
    
    public int b;
    
    public final boolean a() {
      boolean bool1 = false;
      boolean bool2 = bool1;
      if (this.a != null) {
        if (this.a.length <= 0)
          return bool1; 
      } else {
        return bool2;
      } 
      byte b = 0;
      while (true) {
        bool2 = bool1;
        if (b < this.a.length) {
          String str = l.a(this.a[b].toByteArray());
          if (str != null && !TextUtils.equals(str, "b6cbad6cbd5ed0d209afc69ad3b7a617efaae9b3c47eabe0be42d924936fa78c8001b1fd74b079e5ff9690061dacfa4768e981a526b9ca77156ca36251cf2f906d105481374998a7e6e6e18f75ca98b8ed2eaf86ff402c874cca0a263053f22237858206867d210020daa38c48b20cc9dfd82b44a51aeb5db459b22794e2d649")) {
            bool2 = true;
            com.alipay.sdk.app.statistic.a.a("biz", "PublicKeyUnmatch", str);
            return bool2;
          } 
          b++;
          continue;
        } 
        return bool2;
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sd\\util\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */