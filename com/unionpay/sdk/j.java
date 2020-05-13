package com.unionpay.sdk;

import android.content.Context;
import android.location.Location;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class j {
  public static List a(Context paramContext) {
    ArrayList arrayList = new ArrayList();
    if (k.b && (!k.a(23) || paramContext.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0));
    return arrayList;
  }
  
  public static String b(Context paramContext) {
    List list = a(paramContext);
    StringBuffer stringBuffer = new StringBuffer();
    for (Location location : list) {
      String str;
      StringBuffer stringBuffer1 = stringBuffer.append(location.getLatitude()).append(',').append(location.getLongitude()).append(',');
      if (location.hasAltitude()) {
        Double double_ = Double.valueOf(location.getAltitude());
      } else {
        str = "";
      } 
      stringBuffer1 = stringBuffer1.append(str).append(',').append(location.getTime()).append(',');
      if (location.hasAccuracy()) {
        Float float_ = Float.valueOf(location.getAccuracy());
      } else {
        str = "";
      } 
      stringBuffer1 = stringBuffer1.append(str).append(',');
      if (location.hasBearing()) {
        Float float_ = Float.valueOf(location.getBearing());
      } else {
        str = "";
      } 
      stringBuffer1 = stringBuffer1.append(str).append(',');
      if (location.hasSpeed()) {
        Float float_ = Float.valueOf(location.getSpeed());
      } else {
        str = "";
      } 
      stringBuffer1.append(str).append(',').append(location.getProvider()).append(':');
    } 
    return stringBuffer.toString();
  }
  
  public static JSONArray c(Context paramContext) {
    List list = a(paramContext);
    JSONArray jSONArray = new JSONArray();
    for (Location location : list) {
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.put("lat", location.getLatitude());
        jSONObject.put("lng", location.getLongitude());
        jSONObject.put("ts", location.getTime());
        if (k.a(17))
          jSONObject.put("elapsed", location.getElapsedRealtimeNanos()); 
        if (location.hasAltitude())
          jSONObject.put("altitude", location.getAltitude()); 
        if (location.hasAccuracy())
          jSONObject.put("accurate", location.getAccuracy()); 
        if (location.hasBearing())
          jSONObject.put("bearing", location.getBearing()); 
        if (location.hasSpeed())
          jSONObject.put("speed", location.getSpeed()); 
        jSONObject.put("provider", location.getProvider());
        jSONArray.put(jSONObject);
      } catch (Throwable throwable) {}
    } 
    return jSONArray;
  }
  
  public static JSONArray d(Context paramContext) {
    return null;
  }
  
  public static Long[][] e(Context paramContext) {
    return new Long[3][];
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */