package com.herosdk.d;

import android.content.Context;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.herosdk.bean.a;
import com.herosdk.common.PsoUtils;
import com.herosdk.listener.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class m {
  private static final String b = "frameLib.diu";
  
  private static Context u = null;
  
  private static volatile m x;
  
  List<a> a = new ArrayList<a>();
  
  private String c = "";
  
  private String d = "";
  
  private String e = "";
  
  private String f = "";
  
  private String g = "";
  
  private String h = "";
  
  private String i = "";
  
  private String j = "";
  
  private String k = "";
  
  private String l = "";
  
  private String m = "";
  
  private String n = "";
  
  private String o = "";
  
  private String p = "";
  
  private long q = 0L;
  
  private int r = 0;
  
  private int s = 0;
  
  private final int t = 8192;
  
  private int v = 0;
  
  private e w = null;
  
  private m() {
    try {
      w();
      this.j = d(u);
      this.k = e(u);
      this.l = f(u);
      this.m = g(u);
      this.i = h(u);
      this.p = i(u);
      this.d = Build.MODEL;
      this.e = "Android";
      this.f = String.valueOf(Build.VERSION.SDK_INT);
      this.g = String.valueOf(Build.VERSION.RELEASE);
      this.h = Locale.getDefault().getLanguage();
      this.n = y();
      this.o = a();
      this.q = A();
      z();
    } catch (Exception exception) {}
  }
  
  private long A() {
    long l;
    try {
      FileReader fileReader = new FileReader();
      this("/proc/meminfo");
      BufferedReader bufferedReader = new BufferedReader();
      this(fileReader, 8192);
      l = Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue();
      bufferedReader.close();
    } catch (Exception exception) {
      l = 0L;
    } 
    return l;
  }
  
  public static m a(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: putstatic com/herosdk/d/m.u : Landroid/content/Context;
    //   4: getstatic com/herosdk/d/m.x : Lcom/herosdk/d/m;
    //   7: ifnonnull -> 34
    //   10: ldc com/herosdk/d/m
    //   12: monitorenter
    //   13: getstatic com/herosdk/d/m.x : Lcom/herosdk/d/m;
    //   16: ifnonnull -> 31
    //   19: new com/herosdk/d/m
    //   22: astore_0
    //   23: aload_0
    //   24: invokespecial <init> : ()V
    //   27: aload_0
    //   28: putstatic com/herosdk/d/m.x : Lcom/herosdk/d/m;
    //   31: ldc com/herosdk/d/m
    //   33: monitorexit
    //   34: getstatic com/herosdk/d/m.x : Lcom/herosdk/d/m;
    //   37: areturn
    //   38: astore_0
    //   39: ldc com/herosdk/d/m
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Exception table:
    //   from	to	target	type
    //   13	31	38	finally
    //   31	34	38	finally
    //   39	42	38	finally
  }
  
  private String d(Context paramContext) {
    String str;
    try {
      if (!an.a(paramContext, "android.permission.READ_PHONE_STATE"))
        return ""; 
      str = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  private String e(Context paramContext) {
    String str;
    try {
      str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  private String f(Context paramContext) {
    String str;
    try {
      if (!an.a(paramContext, "android.permission.READ_PHONE_STATE"))
        return ""; 
      str = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  private String g(Context paramContext) {
    String str;
    try {
      if (!an.a(paramContext, "android.permission.READ_PHONE_STATE"))
        return ""; 
      str = ((TelephonyManager)paramContext.getSystemService("phone")).getSimSerialNumber();
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  private String h(Context paramContext) {
    String str;
    try {
      if (!an.a(paramContext, "android.permission.READ_PHONE_STATE"))
        return ""; 
      str = ((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso();
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  private String i(Context paramContext) {
    String str;
    try {
      if (!an.a(paramContext, "android.permission.READ_PHONE_STATE"))
        return ""; 
      str = ((TelephonyManager)paramContext.getSystemService("phone")).getLine1Number();
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  private void w() {
    String str;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      str = stringBuilder.append(Environment.getExternalStorageDirectory()).append(File.separator).append(o.b("vtLFG4aTIQUi6VkqQrwe1w==", o.b())).toString();
    } catch (Exception exception) {
      str = "";
    } 
    try {
      String str1 = o.b("L9NdjZLAUc6iyI1X1ogB1Q==", o.b());
      String str2 = o.b("KivS0tlt8YPK/ZztjITXRQ==", o.b());
      this.c = p.a().a(str, str1, str2);
      if (TextUtils.isEmpty(this.c)) {
        String str3 = o.b("mjFthguaMCSZKXU7vmht+Q==", o.b());
        this.c = (String)ax.b(u, str3, "");
        if (TextUtils.isEmpty(this.c)) {
          this.c = b(u);
          p.a().a(str, str1, str2, this.c);
          ax.a(u, str3, this.c);
          return;
        } 
      } else {
        return;
      } 
      p.a().a(str, str1, str2, this.c);
    } catch (Exception exception) {
      this.c = b(u);
    } 
  }
  
  private String x() {
    String str;
    try {
      Class<?> clazz = Class.forName("android.os.SystemProperties");
      str = (String)clazz.getMethod("get", new Class[] { String.class, String.class }).invoke(clazz, new Object[] { "ro.serialno", "unknown" });
    } catch (Exception exception) {
      str = "null";
    } 
    return str;
  }
  
  private String y() {
    try {
      WifiManager wifiManager = (WifiManager)u.getSystemService("wifi");
      if (wifiManager != null) {
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        return TextUtils.isEmpty(wifiInfo.getMacAddress()) ? "" : wifiInfo.getMacAddress();
      } 
    } catch (Exception exception) {}
    return "";
  }
  
  private void z() {
    try {
      Display display = ((WindowManager)u.getSystemService("window")).getDefaultDisplay();
      DisplayMetrics displayMetrics = new DisplayMetrics();
      this();
      display.getMetrics(displayMetrics);
      this.r = displayMetrics.widthPixels;
      this.s = displayMetrics.heightPixels;
    } catch (Exception exception) {}
  }
  
  public String a() {
    String str1 = "";
    String str2 = str1;
    try {
      FileReader fileReader = new FileReader();
      str2 = str1;
      this("/proc/cpuinfo");
      str2 = str1;
      BufferedReader bufferedReader = new BufferedReader();
      str2 = str1;
      this(fileReader, 8192);
      str2 = str1;
      String[] arrayOfString = bufferedReader.readLine().split("\\s+");
      byte b = 2;
      while (true) {
        String str;
        str2 = str1;
        if (b < arrayOfString.length) {
          str2 = str1;
          StringBuilder stringBuilder = new StringBuilder();
          str2 = str1;
          this();
          str2 = str1;
          String str3 = stringBuilder.append(str1).append(arrayOfString[b]).toString();
          str1 = str3;
          str2 = str3;
          if (b < arrayOfString.length - 1) {
            str2 = str3;
            StringBuilder stringBuilder1 = new StringBuilder();
            str2 = str3;
            this();
            str2 = str3;
            str = stringBuilder1.append(str3).append(" ").toString();
          } 
          b++;
          continue;
        } 
        str2 = str;
        bufferedReader.close();
        return str;
      } 
    } catch (Exception exception) {}
    return str2;
  }
  
  public void a(int paramInt) {
    this.v = paramInt;
  }
  
  public void a(Context paramContext, String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      Log.d("frameLib.diu", "=>qPS...if return");
      return;
    } 
    try {
      PackageManager packageManager = paramContext.getPackageManager();
      Method method = packageManager.getClass().getDeclaredMethod("getPackageSizeInfo", new Class[] { String.class, int.class, IPackageStatsObserver.class });
      int i = Process.myUid() / 100000;
      PsoUtils psoUtils = new PsoUtils();
      this();
      method.invoke(packageManager, new Object[] { paramString, Integer.valueOf(i), psoUtils });
    } catch (NoSuchMethodException noSuchMethodException) {
      try {
        PackageManager packageManager = paramContext.getPackageManager();
        Method method = packageManager.getClass().getDeclaredMethod("getPackageSizeInfo", new Class[] { String.class, IPackageStatsObserver.class });
        PsoUtils psoUtils = new PsoUtils();
        this();
        method.invoke(packageManager, new Object[] { paramString, psoUtils });
      } catch (Exception exception) {
        Log.d("frameLib.diu", "=>qPS second...e");
        this.v = 0;
      } 
    } catch (Exception exception) {
      Log.d("frameLib.diu", "=>qPS first...e");
      this.v = 0;
    } 
  }
  
  public void a(e parame) {
    this.w = parame;
  }
  
  public String b() {
    return this.c;
  }
  
  public String b(Context paramContext) {
    String str;
    try {
      String str1 = d(paramContext);
      String str2 = e(paramContext);
      str = x();
      StringBuilder stringBuilder1 = new StringBuilder();
      this();
      String str3 = stringBuilder1.append(Build.BRAND).append(Build.BOARD).append(Build.PRODUCT).append(Build.MANUFACTURER).toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      this();
      str = o.a(stringBuilder2.append(o.b()).append(str1).append(str2).append(str).append(str3).toString());
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  public String c() {
    return this.d;
  }
  
  public void c(Context paramContext) {
    ba.a().a(new n(this, paramContext));
  }
  
  public String d() {
    return this.e;
  }
  
  public String e() {
    return this.f;
  }
  
  public String f() {
    return this.g;
  }
  
  public String g() {
    return this.h;
  }
  
  public String h() {
    return this.i;
  }
  
  public String i() {
    return this.j;
  }
  
  public String j() {
    return this.k;
  }
  
  public String k() {
    return this.l;
  }
  
  public String l() {
    return this.m;
  }
  
  public String m() {
    return this.n;
  }
  
  public String n() {
    return this.o;
  }
  
  public String o() {
    return this.p;
  }
  
  public int p() {
    return this.r;
  }
  
  public int q() {
    return this.s;
  }
  
  public long r() {
    return this.q;
  }
  
  public JSONArray s() {
    JSONArray jSONArray = new JSONArray();
    byte b = 0;
    while (true) {
      if (b < this.a.size()) {
        try {
          JSONObject jSONObject = new JSONObject();
          this();
          jSONObject.put("name", ((a)this.a.get(b)).a());
          jSONObject.put("pkg", ((a)this.a.get(b)).b());
          jSONObject.put("size", ((a)this.a.get(b)).c());
          jSONArray.put(jSONObject);
        } catch (Exception exception) {}
        b++;
        continue;
      } 
      return jSONArray;
    } 
  }
  
  public List<a> t() {
    return this.a;
  }
  
  public int u() {
    return this.v;
  }
  
  public e v() {
    return this.w;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */