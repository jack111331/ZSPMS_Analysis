package com.unionpay;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.unionpay.a.d;
import com.unionpay.b.b;
import com.unionpay.utils.UPUtils;
import com.unionpay.utils.b;
import com.unionpay.utils.e;
import com.unionpay.utils.g;
import com.unionpay.utils.h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UPPayAssistEx {
  private static String A;
  
  private static boolean B = false;
  
  private static int C = 0;
  
  private static Context D;
  
  private static String E;
  
  private static String F;
  
  private static String G;
  
  private static String H;
  
  private static String I;
  
  private static boolean J = false;
  
  private static String K;
  
  private static int L = 0;
  
  private static boolean M = false;
  
  private static d N;
  
  private static Handler O;
  
  private static String P;
  
  public static final int PLUGIN_NOT_FOUND = -1;
  
  public static final int PLUGIN_VALID = 0;
  
  private static String Q;
  
  private static String R;
  
  private static JSONArray S;
  
  private static IntentFilter T;
  
  private static BroadcastReceiver U;
  
  private static final Handler.Callback V;
  
  private static String a = "SpId";
  
  private static String b = "paydata";
  
  private static String c = "SysProvide";
  
  private static String d = "UseTestMode";
  
  private static String e = "SecurityChipType";
  
  private static String f = "uppayuri";
  
  private static String g = "resultIntentAction";
  
  private static String h = "reqOriginalId";
  
  private static String i = "wapurl";
  
  private static String j = "dlgstyle";
  
  private static String k = "com.unionpay.uppay";
  
  private static String l = "com.unionpay.uppay.PayActivity";
  
  private static String m = "ex_mode";
  
  private static String n = "server";
  
  private static String o = "source";
  
  private static String p = "samsung_out";
  
  private static String q = "se_type";
  
  private static String r = "se_title_logo";
  
  private static String s = "se_loading_logo";
  
  private static String t = "se_title_bg_color";
  
  private static String u = "02";
  
  private static String v;
  
  private static String w;
  
  private static String x;
  
  private static String y = "";
  
  private static String z = "";
  
  static {
    A = "";
    B = false;
    C = 10;
    E = "";
    F = null;
    G = null;
    H = "";
    I = "";
    J = false;
    K = "";
    L = 0;
    M = false;
    N = null;
    O = null;
    P = "application/vnd.android.package-archive";
    Q = "http://mobile.unionpay.com/getclient?platform=android&type=securepayplugin";
    R = "[{\"type\":\"app\",\"sort\":100,\"package_info\":[{\"schema\":\"com.unionpay.uppay\",\"version\":\".*\",\"sign\":\"23137B5BE6AEF6682B41E6536F08367E0949A1CC\",\"sort\":101},{\"schema\":\"com.unionpay.tsmservice\",\"version\":\"^[1-9].*|^0[2-9].*|^01\\.[1-9].*|^01\\.0[1-9].*|^01\\.00\\.[2-9].*|^01\\.00\\.1[012789].*|^01\\.00\\.0[8-9].*\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":102}],\"need_install\":false,\"install_msg\":\"请先安装银联在线支付服务，安装完成后重新发起付款\",\"url\":\"https://mobile.unionpay.com/getclient?platform=android&type=securepayplugin\",\"download_app\":\"UPPayPluginEx.apk\",\"download_title\":\"银联在线支付服务\",\"download_desp\":\"正在下载银联在线支付服务…\",\"md5\":\"D75BB2802E61738A9A03BF014F927D9A\"},{\"type\":\"jar\",\"sort\":200}]";
    T = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
    U = new a();
    V = new b();
  }
  
  private static int a(Activity paramActivity, String paramString1, String paramString2) {
    boolean bool1 = true;
    boolean bool2 = false;
    try {
      String[] arrayOfString = new String[27];
      arrayOfString[0] = "30820267308201d0a00302010202044";
      arrayOfString[1] = "ecb7d98300d06092a8";
      arrayOfString[2] = "64886f70d01010505003078310b30090603550";
      arrayOfString[3] = "406130238363111300f060355040813085";
      arrayOfString[4] = "368616e676";
      arrayOfString[5] = "861693111300f060355040713085368616e67686169311730";
      arrayOfString[6] = "15060355040a130e4368696e6120556e696f6e50617931173015060355040b130e4";
      arrayOfString[7] = "368696e612055";
      arrayOfString[8] = "6e696f6e5061793111300f06035504031308556e696f6e5061";
      arrayOfString[9] = "79301e170d3131313132323130343634385a170d333631313135313034";
      arrayOfString[10] = "3634385a3078310b300906035504061302383631";
      arrayOfString[11] = "11300f060355040813085368616e67686169311130";
      arrayOfString[12] = "0f060355040713085368616e676861693117";
      arrayOfString[13] = "3015060355040a130e4368696e6120556e696";
      arrayOfString[14] = "f6e50617931173015060355040b130e4368696e6120556e696";
      arrayOfString[15] = "f6e5061793111300f06035504031308556e696f6e50617930819f300d060";
      arrayOfString[16] = "92a864886f70d010101050003818d0030818902818100c42e6236d5054ffccaa";
      arrayOfString[17] = "a430ecd929d562";
      arrayOfString[18] = "b1ff56cef0e21c87260c63ce3ca868bf5974c14";
      arrayOfString[19] = "d9255940da7b6cd07483f4b4243fd1825b2705";
      arrayOfString[20] = "08eb9b5c67474d027fa03ce35109b11604083ab6bb4df2c46240f879f";
      arrayOfString[21] = "8cc1d6ed5e1b2cc00489215aec3fc2eac008e767b0215981cb5e";
      arrayOfString[22] = "e94ddc285669ec06b8a405dd4341eac4ea7030203010001300d06092a864886f70d010105050003818";
      arrayOfString[23] = "1001a3e74c601e3beb1b7ae4f9ab2872a0aaf1dbc2cba89c7528cd";
      arrayOfString[24] = "54aa526e7a37d8ba2311a1d3d2ab79b3fbeaf3ebb9e7da9e7cdd9be1ae5a53595f47";
      arrayOfString[25] = "b1fdf62b0f540fca5458b063af9354925a6c3505a18ff164b6b195f6e517eaee1fb783";
      arrayOfString[26] = "64c2f89fdffa16729c9779f99562bc189d2ce4722ba0faedb11aa22d0d9db228fda";
      PackageManager packageManager = paramActivity.getPackageManager();
      packageManager.getActivityInfo(paramActivity.getComponentName(), 128);
      packageManager.getApplicationInfo("com.unionpay.uppay", 8192);
      PackageInfo packageInfo = packageManager.getPackageInfo("com.unionpay.uppay", 4160);
      String str2 = packageInfo.signatures[0].toCharsString();
      int i = arrayOfString.length;
      String str1 = "";
      byte b;
      for (b = 0; b < i; b++) {
        String str = arrayOfString[b];
        StringBuilder stringBuilder = new StringBuilder();
        this();
        str1 = stringBuilder.append(str1).append(str).toString();
      } 
      if (str2 != null && str2.equals(str1) && packageInfo.versionCode >= 31) {
        b = bool1;
      } else {
        b = 0;
      } 
      if (b != 0) {
        Bundle bundle = new Bundle();
        this();
        bundle.putInt(h, 1);
        bundle.putString(f, paramString1);
        bundle.putString(g, paramString2);
        Intent intent = new Intent();
        this();
        intent.putExtras(bundle);
        intent.setClassName(k, l);
        paramActivity.startActivity(intent);
        return bool2;
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return -1;
    } 
    return -1;
  }
  
  private static int a(Context paramContext, UPQuerySEPayInfoCallback paramUPQuerySEPayInfoCallback, boolean paramBoolean) {
    return (new b(paramContext, paramUPQuerySEPayInfoCallback, paramBoolean)).a();
  }
  
  private static int a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
    D = paramContext;
    E = paramString3;
    F = paramString1;
    G = paramString2;
    H = paramString4;
    A = paramString6;
    z = paramString5;
    v = null;
    w = null;
    x = null;
    if (TextUtils.isEmpty(paramString6)) {
      if (TextUtils.isEmpty(UPUtils.a(paramContext, "se_type"))) {
        c c = new c();
        if (a(D, c, false) == 0)
          return 0; 
      } 
    } else {
      y = paramString6;
    } 
    r();
    return 0;
  }
  
  private static String a(Context paramContext, String paramString) {
    try {
      InputStream inputStream = paramContext.getAssets().open(paramString);
      String str = paramContext.getFilesDir().getAbsolutePath();
      if (str != null) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        str = stringBuilder.append(str).append(File.separator).append(paramString).toString();
        File file = new File();
        this(str);
        String str1 = str;
        if (!file.exists()) {
          FileOutputStream fileOutputStream = paramContext.openFileOutput(paramString, 1);
          byte[] arrayOfByte = new byte[1024];
          while (true) {
            int i = inputStream.read(arrayOfByte);
            if (i > 0) {
              fileOutputStream.write(arrayOfByte, 0, i);
              continue;
            } 
            fileOutputStream.close();
            inputStream.close();
            str1 = str;
            break;
          } 
        } 
        return str1;
      } 
    } catch (Exception exception) {}
    return "";
  }
  
  static String a(Context paramContext, boolean paramBoolean) {
    int i = 0;
    JSONObject jSONObject = new JSONObject();
    try {
      int k = Integer.parseInt(H);
      i = k;
    } catch (NumberFormatException numberFormatException) {
    
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      str1 = jSONObject.toString();
      h.b("uppay", "init: " + str1);
      return str1;
    } catch (PatternSyntaxException patternSyntaxException) {
      patternSyntaxException.printStackTrace();
      str1 = jSONObject.toString();
      h.b("uppay", "init: " + str1);
      return str1;
    } 
    if (!paramBoolean)
      jSONObject.put("tn", UPUtils.forWap(i, b.a(E))); 
    jSONObject.put("imei", e.b((Context)str1));
    if (Locale.getDefault().toString().startsWith("zh")) {
      str5 = "zh_CN";
    } else {
      str5 = "en_US";
    } 
    jSONObject.put("locale", str5);
    jSONObject.put("terminal_version", "3.3.8");
    i = (str1.getResources().getDisplayMetrics()).widthPixels;
    int j = (str1.getResources().getDisplayMetrics()).heightPixels;
    StringBuilder stringBuilder = new StringBuilder();
    this();
    String str5;
    String str3;
    String str2;
    jSONObject.put("terminal_resolution", stringBuilder.append(i).append("*").append(j).toString().trim());
    jSONObject.put("os_name", "android");
    jSONObject.put("os_version", Build.VERSION.RELEASE.trim());
    String str4 = Build.MODEL.trim();
    if (str4 != null)
      str4.replace(" ", ""); 
    jSONObject.put("device_model", str4);
    jSONObject.put("mac", e.a((Context)str1));
    try {
      jSONObject.put("time_zone", TimeZone.getDefault().getDisplayName(false, 0));
    } catch (Exception exception) {}
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)str1.getSystemService("connectivity")).getActiveNetworkInfo();
      if (networkInfo != null && networkInfo.isAvailable()) {
        if (networkInfo.getType() == 0) {
          if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            StringBuilder stringBuilder1 = new StringBuilder();
            this("mobile:");
            str3 = stringBuilder1.append(networkInfo.getExtraInfo()).toString();
          } else {
            str3 = "mobile";
          } 
        } else if (str3.getType() == 1) {
          str3 = "wifi";
        } else {
          str3 = "other";
        } 
      } else {
        str3 = "disConnect";
      } 
      jSONObject.put("network_mode", str3);
    } catch (Exception exception) {}
    try {
      jSONObject.put("imsi", e.c((Context)str1));
    } catch (Exception exception) {}
    try {
      jSONObject.put("baseband_version", e(e.a()));
    } catch (Exception exception) {}
    try {
      File file = new File();
      this("/system/bin/su");
      if (file.exists()) {
        str3 = "1";
      } else {
        str3 = "0";
      } 
      jSONObject.put("root", str3);
    } catch (Exception exception) {}
    try {
      StringBuffer stringBuffer = new StringBuffer();
      this("000");
      if (Build.VERSION.SDK_INT >= 10) {
        NfcAdapter nfcAdapter = ((NfcManager)str1.getSystemService("nfc")).getDefaultAdapter();
        if (nfcAdapter != null) {
          if (nfcAdapter.isEnabled()) {
            stringBuffer.setCharAt(0, '1');
          } else {
            stringBuffer.setCharAt(0, '2');
          } 
          if (Build.VERSION.SDK_INT >= 19 && str1.getPackageManager().hasSystemFeature("android.hardware.nfc.hce"))
            stringBuffer.setCharAt(1, '1'); 
        } 
      } 
      jSONObject.put("support_map", stringBuffer.toString());
    } catch (Exception exception) {}
    jSONObject.put("country", e(Locale.getDefault().getCountry()));
    str4 = ((Activity)str1).getPackageName();
    if (str4 == null)
      str4 = ""; 
    jSONObject.put("package", e(str4));
    Location location2 = e.d((Context)str1);
    if (location2 != null) {
      str3 = Double.valueOf(location2.getLatitude()).toString();
    } else {
      str3 = "";
    } 
    jSONObject.put("latitude", e(str3));
    Location location1 = e.d((Context)str1);
    if (location1 != null) {
      str2 = Double.valueOf(location1.getLongitude()).toString();
    } else {
      str2 = "";
    } 
    jSONObject.put("longitude", e(str2));
    jSONObject.put("tel", e(e.e((Context)str1)));
    if (paramBoolean)
      try {
        Class.forName("com.unionpay.uppay.PayActivity");
        jSONObject.put("has_sdk", "1");
      } catch (ClassNotFoundException classNotFoundException) {} 
    jSONObject.put("seType", b.d(y));
    String str1 = jSONObject.toString();
    h.b("uppay", "init: " + str1);
    return str1;
  }
  
  static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    boolean bool = true;
    String str = a(paramContext, paramString2);
    if (str != null && !TextUtils.isEmpty(str)) {
      Intent intent = new Intent("android.intent.action.VIEW");
      intent.setDataAndType(Uri.parse("file:" + str), "application/vnd.android.package-archive");
      paramContext.startActivity(intent);
    } else {
      bool = false;
    } 
    if (!bool) {
      I = paramString5;
      K = paramString2;
      if (!J)
        try {
          paramContext.registerReceiver(U, T);
          DownloadManager downloadManager = (DownloadManager)paramContext.getSystemService("download");
          DownloadManager.Request request = new DownloadManager.Request();
          this(Uri.parse(paramString1));
          request.setMimeType(P);
          request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, paramString2);
          request.setTitle(paramString3);
          request.setDescription(paramString4);
          request.setNotificationVisibility(1);
          UPUtils.a(paramContext, downloadManager.enqueue(request), "id");
          J = true;
        } catch (Exception exception) {} 
    } 
  }
  
  static void a(String paramString) {
    Bundle bundle = new Bundle();
    a(E, bundle, H);
    bundle.putString(a, F);
    bundle.putString(c, G);
    bundle.putString(b, E);
    bundle.putString(o, z);
    bundle.putString(q, A);
    if (!TextUtils.isEmpty(A)) {
      bundle.putString(r, v);
      bundle.putString(s, w);
      bundle.putString(t, x);
    } 
    bundle.putString(n, paramString);
    bundle.putBoolean(j, B);
    bundle.putInt(h, 2);
    try {
      Class<?> clazz = Class.forName("com.unionpay.uppay.PayActivity");
      Intent intent = new Intent();
      this();
      intent.putExtras(bundle);
      intent.setClass(D, clazz);
      if (D instanceof Activity) {
        ((Activity)D).startActivityForResult(intent, C);
        return;
      } 
      intent.addFlags(268435456);
      D.startActivity(intent);
    } catch (ClassNotFoundException classNotFoundException) {}
  }
  
  private static void a(String paramString1, Bundle paramBundle, String paramString2) {
    if (paramString1 != null && paramString1.trim().length() > 0) {
      if (paramString1.trim().charAt(0) == '<') {
        if (paramString2 != null && paramString2.trim().equalsIgnoreCase("00")) {
          paramBundle.putBoolean(d, false);
          return;
        } 
        paramBundle.putBoolean(d, true);
        return;
      } 
      paramBundle.putString(m, paramString2);
    } 
  }
  
  private static JSONArray b(JSONArray paramJSONArray, String paramString) {
    boolean bool = false;
    ArrayList<JSONObject> arrayList = new ArrayList();
    byte b;
    for (b = 0; b < paramJSONArray.length(); b++)
      arrayList.add(paramJSONArray.optJSONObject(b)); 
    Collections.sort(arrayList, new i(paramString));
    paramJSONArray = new JSONArray();
    for (b = bool; b < arrayList.size(); b++)
      paramJSONArray.put(arrayList.get(b)); 
    return paramJSONArray;
  }
  
  public static boolean checkInstalled(Context paramContext) {
    boolean bool;
    String str1 = R;
    String str2 = UPUtils.a(paramContext, "configs");
    String str3 = UPUtils.a(paramContext, "mode");
    String str4 = UPUtils.a(paramContext, "or");
    String str5 = str1;
    if (!TextUtils.isEmpty(str2)) {
      str5 = str1;
      if (!TextUtils.isEmpty(str3)) {
        str5 = str1;
        if (!TextUtils.isEmpty(str4))
          try {
            boolean bool1;
            System.loadLibrary("entryexpro");
            JSONObject jSONObject = new JSONObject();
            this(str2);
            String str7 = g.a(jSONObject, "sign");
            try {
              bool1 = Integer.parseInt(str3);
            } catch (NumberFormatException numberFormatException) {
              bool1 = false;
            } 
            str3 = new String();
            this(Base64.decode(jSONObject.getString("configs"), 2));
            str2 = new String();
            this(Base64.decode(jSONObject.getString("sePayConf"), 2));
            String str6 = str2;
            if (TextUtils.isEmpty(str2))
              str6 = ""; 
            StringBuilder stringBuilder = new StringBuilder();
            this();
            str6 = b.a(UPUtils.a(stringBuilder.append(str3).append(str6).append(str4).toString()));
            bool = UPUtils.forConfig(bool1, str7).equals(str6);
            if (bool)
              str1 = str3; 
            str6 = str1;
          } catch (JSONException jSONException) {
            str5 = str1;
          }  
      } 
    } 
    try {
      JSONArray jSONArray = new JSONArray();
      this(str5);
      int i = jSONArray.length();
      for (byte b = 0; b < i; b++) {
        Object object = g.a(jSONArray, b);
        if (object != null) {
          object = object;
          if ("app".equals(g.a((JSONObject)object, "type"))) {
            object = b(g.c((JSONObject)object, "package_info"), "sort");
            if (object != null && object.length() > 0) {
              int j = object.length();
              for (byte b1 = 0; b1 < j; b1++) {
                Object object1 = g.a((JSONArray)object, b1);
                if (object1 != null) {
                  JSONObject jSONObject = (JSONObject)object1;
                  object1 = g.a(jSONObject, "schema");
                  str2 = g.a(jSONObject, "sign");
                  String str = g.a(jSONObject, "version");
                  if (b.a(paramContext, (String)object1) && str2.equalsIgnoreCase(b.b(paramContext, (String)object1)) && b.c(paramContext, (String)object1).matches(str))
                    return true; 
                } 
              } 
            } 
          } 
        } 
      } 
    } catch (JSONException jSONException) {
      bool = false;
    } 
    return bool;
  }
  
  private static void d(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject();
      this(paramString);
      v = jSONObject.getString("titleLogo");
      w = jSONObject.getString("loadingLogo");
      x = jSONObject.getString("backGroundColor");
    } catch (JSONException jSONException) {}
  }
  
  private static String e(String paramString) {
    return (paramString != null) ? Pattern.compile("[\":,\\[\\]{}]").matcher(paramString).replaceAll("").trim() : "";
  }
  
  public static int getSEPayInfo(Context paramContext, UPQuerySEPayInfoCallback paramUPQuerySEPayInfoCallback) {
    return a(paramContext, paramUPQuerySEPayInfoCallback, true);
  }
  
  public static boolean installUPPayPlugin(Context paramContext) {
    null = true;
    try {
      InputStream inputStream = paramContext.getAssets().open("UPPayPluginEx.apk");
      String str = paramContext.getFilesDir().getAbsolutePath();
      if (str != null) {
        StringBuilder stringBuilder2 = new StringBuilder();
        this();
        str = stringBuilder2.append(str).append(File.separator).append("UPPayPluginEx.apk").toString();
        File file = new File();
        this(str);
        if (!file.exists()) {
          FileOutputStream fileOutputStream = paramContext.openFileOutput("UPPayPluginEx.apk", 1);
          byte[] arrayOfByte = new byte[1024];
          while (true) {
            int i = inputStream.read(arrayOfByte);
            if (i > 0) {
              fileOutputStream.write(arrayOfByte, 0, i);
              continue;
            } 
            fileOutputStream.close();
            inputStream.close();
            break;
          } 
        } 
        Intent intent = new Intent();
        this("android.intent.action.VIEW");
        StringBuilder stringBuilder1 = new StringBuilder();
        this("file:");
        intent.setDataAndType(Uri.parse(stringBuilder1.append(str).toString()), "application/vnd.android.package-archive");
        paramContext.startActivity(intent);
        return null;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return false;
  }
  
  private static int r() {
    boolean bool = false;
    if (D == null)
      return 1; 
    if (!TextUtils.isEmpty(z) || !TextUtils.isEmpty(A)) {
      B = true;
      if (u.equalsIgnoreCase(A))
        z = p; 
    } else {
      B = false;
    } 
    L = 0;
    M = false;
    System.loadLibrary("entryexpro");
    String str1 = UPUtils.a(D, "configs");
    String str2 = UPUtils.a(D, "mode");
    String str3 = UPUtils.a(D, "or");
    if (!TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3))
      try {
        boolean bool1;
        JSONObject jSONObject = new JSONObject();
        this(str1);
        str1 = g.a(jSONObject, "sign");
        try {
          bool1 = Integer.parseInt(str2);
        } catch (NumberFormatException numberFormatException) {
          bool1 = false;
        } 
        String str5 = new String();
        this(Base64.decode(jSONObject.getString("configs"), 2));
        str2 = new String();
        this(Base64.decode(jSONObject.getString("sePayConf"), 2));
        String str4 = str2;
        if (TextUtils.isEmpty(str2))
          str4 = ""; 
        h.a("uppay", str5);
        StringBuilder stringBuilder = new StringBuilder();
        this();
        str4 = b.a(UPUtils.a(stringBuilder.append(str5).append(str4).append(str3).toString()));
        if (UPUtils.forConfig(bool1, str1).equals(str4)) {
          R = str5;
          if (!TextUtils.isEmpty(y)) {
            Context context = D;
            stringBuilder = new StringBuilder();
            this("se_configs");
            String str = UPUtils.a(context, stringBuilder.append(y).toString());
            if (!TextUtils.isEmpty(str))
              d(str); 
          } 
        } 
      } catch (JSONException jSONException) {} 
    try {
      JSONArray jSONArray = new JSONArray();
      this(R);
      S = b(jSONArray, "sort");
      Context context = D;
      try {
        int i = Integer.parseInt(H);
        str2 = UPUtils.forUrl(i);
        h.b("uppay", "url: " + str2);
        N = new d(str2);
        String str = a(context, false);
        h.b("uppay", "postdata: " + str);
        N.a(str);
        O = new Handler(V);
        (new d()).start();
        i = bool;
      } catch (NumberFormatException numberFormatException) {
        boolean bool1 = false;
      } 
    } catch (JSONException jSONException) {}
  }
  
  public static int startPay(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
    return a(paramContext, paramString1, paramString2, paramString3, paramString4, "", "");
  }
  
  public static void startPayByJAR(Context paramContext, Class paramClass, String paramString1, String paramString2, String paramString3, String paramString4) {
    startPay(paramContext, paramString1, paramString2, paramString3, paramString4);
  }
  
  public static int startPayFromBrowser(Activity paramActivity, String paramString1, String paramString2) {
    return a(paramActivity, paramString1, paramString2);
  }
  
  public static int startSEPay(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    return a(paramContext, paramString1, paramString2, paramString3, paramString4, "", paramString5);
  }
  
  public static void startSamsungPay(Context paramContext, Class paramClass, String paramString1, String paramString2, String paramString3, String paramString4) {
    a(paramContext, paramString1, paramString2, paramString3, paramString4, p, u);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\UPPayAssistEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */