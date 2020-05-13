package com.zz.sdk.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.zz.sdk.ParamChain;
import com.zz.sdk.i.bi;
import com.zz.sdk.i.bo;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.cv;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class c implements i, Serializable {
  private static final long q = 4L;
  
  public String a = Build.VERSION.SDK;
  
  public String b = Build.PRODUCT;
  
  public String c;
  
  public String d;
  
  public int e;
  
  public int f;
  
  public int g;
  
  public int h;
  
  public double i;
  
  public double j;
  
  public String k;
  
  public String l;
  
  public String m;
  
  public String n;
  
  public String o = "1.0.0";
  
  public String p;
  
  public c(Context paramContext, ParamChain paramParamChain) {
    this.d = (String)paramParamChain.get("global.device.imei", String.class);
    this.c = (String)paramParamChain.get("global.device.imsi", String.class);
    bp.a("DeviceProperties imei --> " + this.d);
    bp.a("DeviceProperties imsi --> " + this.c);
    WindowManager windowManager = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics displayMetrics = new DisplayMetrics();
    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
    this.f = displayMetrics.densityDpi;
    this.g = displayMetrics.widthPixels;
    this.h = displayMetrics.heightPixels;
    PackageManager packageManager = paramContext.getPackageManager();
    this.n = paramContext.getPackageName();
    try {
      this.e = (packageManager.getPackageInfo(paramContext.getPackageName(), 0)).versionCode;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
    try {
      this.m = cv.g(paramContext);
      StringBuilder stringBuilder = new StringBuilder();
      this();
      Log.d("zz_sdk", stringBuilder.append("project id -> ").append(this.m).toString());
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    this.l = bi.b(paramContext);
    if (this.l == null)
      this.l = "3"; 
    Location location = bo.a(paramContext);
    if (location != null) {
      this.j = location.getLongitude();
      String str2 = "" + this.j;
      if (str2.length() > 7)
        this.j = Double.parseDouble(str2.substring(0, 7)); 
      this.i = location.getLatitude();
      String str1 = "" + this.i;
      if (str1.length() > 7)
        this.i = Double.parseDouble(str1.substring(0, 7)); 
      if ("" != null)
        this.k = ""; 
    } 
    this.p = a(paramContext);
  }
  
  private String a(Context paramContext) {
    WifiInfo wifiInfo;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.d);
    WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
    if (wifiManager == null) {
      wifiManager = null;
    } else {
      wifiInfo = wifiManager.getConnectionInfo();
    } 
    if (wifiInfo != null) {
      String str = wifiInfo.getMacAddress();
      if (str != null)
        stringBuilder.append(str); 
    } 
    return cv.a(stringBuilder.toString());
  }
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("a", this.a);
      jSONObject.put("b", this.b);
      jSONObject.put("c", this.c);
      jSONObject.put("d", this.d);
      jSONObject.put("f", this.e);
      jSONObject.put("g", this.f);
      jSONObject.put("h", this.g);
      jSONObject.put("i", this.h);
      jSONObject.put("j", this.i);
      jSONObject.put("k", this.j);
      jSONObject.put("l", this.k);
      jSONObject.put("m", this.l);
      jSONObject.put("n", this.m);
      jSONObject.put("p", this.n);
      jSONObject.put("q", this.o);
      jSONObject.put("r", this.p);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      jSONException = null;
    } 
    return (JSONObject)jSONException;
  }
  
  public void a(JSONObject paramJSONObject) {
    boolean bool = false;
    double d = -500.0D;
    JSONObject jSONObject = null;
    if (paramJSONObject != null)
      try {
        String str1;
        String str2;
        int j;
        double d1;
        if (paramJSONObject.isNull("a")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("a");
        } 
        this.a = str2;
        if (paramJSONObject.isNull("b")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("b");
        } 
        this.b = str2;
        if (paramJSONObject.isNull("c")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("c");
        } 
        this.c = str2;
        if (paramJSONObject.isNull("d")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("d");
        } 
        this.d = str2;
        if (paramJSONObject.isNull("f")) {
          j = -1;
        } else {
          j = paramJSONObject.getInt("f");
        } 
        this.e = j;
        if (paramJSONObject.isNull("g")) {
          j = 240;
        } else {
          j = paramJSONObject.getInt("g");
        } 
        this.f = j;
        if (paramJSONObject.isNull("h")) {
          j = 0;
        } else {
          j = paramJSONObject.getInt("h");
        } 
        this.g = j;
        if (paramJSONObject.isNull("i")) {
          j = bool;
        } else {
          j = paramJSONObject.getInt("i");
        } 
        this.h = j;
        if (paramJSONObject.isNull("j")) {
          d1 = -500.0D;
        } else {
          d1 = paramJSONObject.getDouble("j");
        } 
        this.i = d1;
        if (paramJSONObject.isNull("k")) {
          d1 = d;
        } else {
          d1 = paramJSONObject.getDouble("k");
        } 
        this.j = d1;
        if (paramJSONObject.isNull("l")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("l");
        } 
        this.k = str2;
        if (paramJSONObject.isNull("m")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("m");
        } 
        this.l = str2;
        if (paramJSONObject.isNull("n")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("n");
        } 
        this.m = str2;
        if (paramJSONObject.isNull("p")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("p");
        } 
        this.n = str2;
        if (paramJSONObject.isNull("q")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("q");
        } 
        this.o = str2;
        if (paramJSONObject.isNull("r")) {
          paramJSONObject = jSONObject;
        } else {
          str1 = paramJSONObject.getString("r");
        } 
        this.p = str1;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      }  
  }
  
  public String b() {
    return "a";
  }
  
  public String toString() {
    return "DeviceProperties [sdkVersion=" + this.a + ", type=" + this.b + ", imsi=" + this.c + ", imei=" + this.d + ", versionCode=" + this.e + ", densityDpi=" + this.f + ", displayScreenWidth=" + this.g + ", displayScreenHeight=" + this.h + ", latitude=" + this.i + ", longitude=" + this.j + ", area=" + this.k + ", networkInfo=" + this.l + ", projectId=" + this.m + ", packageName=" + this.n + ", version=" + this.o + ", deviceParams=" + this.p + "]";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */