package com.xy.whf.a;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.xy.whf.helper.LangHelper;
import com.xy.whf.helper.PermissionHelper;
import com.xy.whf.helper.h;
import java.util.List;

public class g {
  private static g a;
  
  private LocationManager b;
  
  private LocationListener c = null;
  
  private Context d;
  
  private g(Context paramContext) {
    this.d = paramContext;
  }
  
  private Location a() {
    Location location1 = null;
    Location location2 = location1;
    if (this.b != null) {
      location2 = location1;
      if (PermissionHelper.a(this.d, "android.permission.ACCESS_FINE_LOCATION")) {
        location2 = this.b.getLastKnownLocation("gps");
        location1 = location2;
        if (location2 == null)
          location1 = this.b.getLastKnownLocation("network"); 
        location2 = location1;
        if (location1 == null)
          location2 = this.b.getLastKnownLocation("passive"); 
      } 
    } 
    return location2;
  }
  
  public static g a(Context paramContext) {
    if (a == null)
      a = new g(paramContext); 
    return a;
  }
  
  private String a(LocationManager paramLocationManager) {
    List list = paramLocationManager.getAllProviders();
    if (!LangHelper.isNullOrEmpty(list)) {
      if (list.contains("gps"))
        return "gps"; 
      if (list.contains("network"))
        return "network"; 
    } 
    return "passive";
  }
  
  private void a(Location paramLocation, b paramb) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 291
    //   4: new org/json/JSONObject
    //   7: astore_3
    //   8: aload_3
    //   9: invokespecial <init> : ()V
    //   12: new java/lang/StringBuilder
    //   15: astore #4
    //   17: aload #4
    //   19: invokespecial <init> : ()V
    //   22: aload_3
    //   23: ldc 'longitude'
    //   25: aload #4
    //   27: ldc ''
    //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: invokevirtual getLongitude : ()D
    //   36: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   39: invokevirtual toString : ()Ljava/lang/String;
    //   42: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   45: pop
    //   46: new java/lang/StringBuilder
    //   49: astore #4
    //   51: aload #4
    //   53: invokespecial <init> : ()V
    //   56: aload_3
    //   57: ldc 'latitude'
    //   59: aload #4
    //   61: ldc ''
    //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual getLatitude : ()D
    //   70: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   73: invokevirtual toString : ()Ljava/lang/String;
    //   76: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   79: pop
    //   80: new android/location/Geocoder
    //   83: astore #5
    //   85: aload #5
    //   87: aload_0
    //   88: getfield d : Landroid/content/Context;
    //   91: invokespecial <init> : (Landroid/content/Context;)V
    //   94: new java/util/ArrayList
    //   97: astore #4
    //   99: aload #4
    //   101: invokespecial <init> : ()V
    //   104: aload #5
    //   106: aload_1
    //   107: invokevirtual getLatitude : ()D
    //   110: aload_1
    //   111: invokevirtual getLongitude : ()D
    //   114: iconst_1
    //   115: invokevirtual getFromLocation : (DDI)Ljava/util/List;
    //   118: astore_1
    //   119: ldc ''
    //   121: astore #6
    //   123: ldc ''
    //   125: astore #4
    //   127: ldc ''
    //   129: astore #5
    //   131: ldc ''
    //   133: astore #7
    //   135: aload_1
    //   136: invokestatic isNullOrEmpty : (Ljava/lang/Object;)Z
    //   139: ifne -> 229
    //   142: aload_1
    //   143: iconst_0
    //   144: invokeinterface get : (I)Ljava/lang/Object;
    //   149: checkcast android/location/Address
    //   152: astore_1
    //   153: aload_1
    //   154: invokevirtual getCountryName : ()Ljava/lang/String;
    //   157: astore #6
    //   159: aload_1
    //   160: invokevirtual getAdminArea : ()Ljava/lang/String;
    //   163: astore #4
    //   165: aload_1
    //   166: invokevirtual getLocality : ()Ljava/lang/String;
    //   169: astore #5
    //   171: new java/lang/StringBuilder
    //   174: astore #7
    //   176: aload #7
    //   178: invokespecial <init> : ()V
    //   181: iconst_0
    //   182: istore #8
    //   184: iload #8
    //   186: aload_1
    //   187: invokevirtual getMaxAddressLineIndex : ()I
    //   190: if_icmpge -> 222
    //   193: aload #7
    //   195: aload_1
    //   196: iload #8
    //   198: invokevirtual getAddressLine : (I)Ljava/lang/String;
    //   201: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: iinc #8, 1
    //   208: goto -> 184
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual printStackTrace : ()V
    //   216: aload #4
    //   218: astore_1
    //   219: goto -> 119
    //   222: aload #7
    //   224: invokevirtual toString : ()Ljava/lang/String;
    //   227: astore #7
    //   229: aload_3
    //   230: ldc 'country'
    //   232: aload #6
    //   234: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   237: pop
    //   238: aload_3
    //   239: ldc 'province'
    //   241: aload #4
    //   243: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   246: pop
    //   247: aload_3
    //   248: ldc 'city'
    //   250: aload #5
    //   252: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   255: pop
    //   256: aload_3
    //   257: ldc 'detail_address'
    //   259: aload #7
    //   261: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   264: pop
    //   265: aload_2
    //   266: aload_3
    //   267: iconst_0
    //   268: invokeinterface a : (Ljava/lang/Object;I)V
    //   273: aload_0
    //   274: getfield c : Landroid/location/LocationListener;
    //   277: ifnull -> 291
    //   280: aload_0
    //   281: getfield b : Landroid/location/LocationManager;
    //   284: aload_0
    //   285: getfield c : Landroid/location/LocationListener;
    //   288: invokevirtual removeUpdates : (Landroid/location/LocationListener;)V
    //   291: return
    //   292: astore_1
    //   293: aload_1
    //   294: invokevirtual printStackTrace : ()V
    //   297: goto -> 291
    // Exception table:
    //   from	to	target	type
    //   4	104	292	java/lang/Exception
    //   104	119	211	java/lang/Exception
    //   135	181	292	java/lang/Exception
    //   184	205	292	java/lang/Exception
    //   212	216	292	java/lang/Exception
    //   222	229	292	java/lang/Exception
    //   229	291	292	java/lang/Exception
  }
  
  public void a(b paramb) {
    try {
      LocationListener locationListener;
      String str;
      if (PermissionHelper.a(this.d, "android.permission.ACCESS_FINE_LOCATION")) {
        locationListener = new LocationListener() {
            public void onLocationChanged(Location param1Location) {
              h.a("onLocationChanged:" + param1Location);
              g.a(this.b, param1Location, this.a);
            }
            
            public void onProviderDisabled(String param1String) {
              h.a("onProviderDisabled:" + param1String);
            }
            
            public void onProviderEnabled(String param1String) {
              h.a("onProviderEnabled:" + param1String);
            }
            
            public void onStatusChanged(String param1String, int param1Int, Bundle param1Bundle) {
              h.a("onStatusChanged:" + param1String + "  " + param1Int + "  " + param1Bundle);
            }
          };
        super(this, paramb);
        str = a(this.b);
        Location location = a();
        if (location != null && location.getLongitude() != 0.0D) {
          a(location, paramb);
          return;
        } 
      } else {
        return;
      } 
      this.b.requestLocationUpdates(str, 2000L, 2.0F, locationListener);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */