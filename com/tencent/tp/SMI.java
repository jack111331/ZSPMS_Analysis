package com.tencent.tp;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.SensorManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SMI implements e {
  private static final String a = "android.permission.READ_PHONE_STATE";
  
  private static String b;
  
  private static String c;
  
  private String a(String paramString) {
    if (paramString == null)
      return ""; 
    if (paramString.contains("Tencent"))
      return paramString; 
    byte[] arrayOfByte = null;
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramString.getBytes());
      byte[] arrayOfByte1 = messageDigest.digest();
      arrayOfByte = arrayOfByte1;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {}
    if (arrayOfByte == null)
      return paramString; 
    paramString = a(arrayOfByte);
    return paramString.substring(0, paramString.length() / 2);
  }
  
  private String a(byte[] paramArrayOfbyte) {
    char[] arrayOfChar = new char[16];
    arrayOfChar[0] = '0';
    arrayOfChar[1] = '1';
    arrayOfChar[2] = '2';
    arrayOfChar[3] = '3';
    arrayOfChar[4] = '4';
    arrayOfChar[5] = '5';
    arrayOfChar[6] = '6';
    arrayOfChar[7] = '7';
    arrayOfChar[8] = '8';
    arrayOfChar[9] = '9';
    arrayOfChar[10] = 'a';
    arrayOfChar[11] = 'b';
    arrayOfChar[12] = 'c';
    arrayOfChar[13] = 'd';
    arrayOfChar[14] = 'e';
    arrayOfChar[15] = 'f';
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < paramArrayOfbyte.length; b++) {
      byte b1 = paramArrayOfbyte[b];
      byte b2 = paramArrayOfbyte[b];
      stringBuilder.append(arrayOfChar[(b1 & 0xF0) >> 4]);
      stringBuilder.append(arrayOfChar[b2 & 0xF]);
    } 
    return stringBuilder.toString();
  }
  
  public String a(Context paramContext) {
    String str;
    if (b != null)
      return b; 
    if (!w.a(paramContext, "android.permission.READ_PHONE_STATE")) {
      str = "NO_PERMISSION_MANIFEST";
      b = str;
      return b;
    } 
    if (!w.b((Context)str, "android.permission.READ_PHONE_STATE")) {
      str = "NO_PERMISSION_SDK_23";
      b = str;
      return b;
    } 
    if (str != null) {
      try {
        b = ((TelephonyManager)str.getSystemService("phone")).getDeviceId();
        b = a(b);
      } catch (Exception exception) {
        b = null;
      } 
      return b;
    } 
    return b;
  }
  
  public String b(Context paramContext) {
    if (paramContext != null) {
      try {
        WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
        if (wifiManager != null) {
          WifiInfo wifiInfo = wifiManager.getConnectionInfo();
          if (wifiInfo != null)
            return a(wifiInfo.getSSID()); 
        } 
        String str = "null";
      } catch (Throwable throwable) {
        String str = "null";
      } 
    } else {
      paramContext = null;
    } 
    return (String)paramContext;
  }
  
  public String c(Context paramContext) {
    WifiManager wifiManager = null;
    WifiInfo wifiInfo = null;
    if (paramContext != null) {
      WifiInfo wifiInfo1;
      try {
        wifiManager = (WifiManager)paramContext.getSystemService("wifi");
        wifiInfo1 = wifiInfo;
        if (wifiManager != null) {
          wifiInfo1 = wifiManager.getConnectionInfo();
          if (wifiInfo1 != null) {
            String str1 = wifiInfo1.getMacAddress();
            String str2 = str1;
            if (str1 != null)
              str2 = a(str1.replace(":", " ")); 
          } else {
            wifiInfo1 = null;
          } 
        } 
      } catch (Throwable throwable) {
        wifiInfo1 = wifiInfo;
      } 
      if (wifiInfo1 != null) {
        WifiInfo wifiInfo2 = wifiInfo1;
        return (String)(wifiInfo1.equals(a("02 00 00 00 00 00")) ? j(paramContext) : wifiInfo2);
      } 
    } else {
      return (String)wifiManager;
    } 
    return j(paramContext);
  }
  
  public String d(Context paramContext) {
    if (paramContext != null) {
      try {
        WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
        if (wifiManager != null) {
          WifiInfo wifiInfo = wifiManager.getConnectionInfo();
          if (wifiInfo != null) {
            String str4 = wifiInfo.getBSSID();
            String str2 = str4;
            if (str4 != null)
              str2 = str4.replace(":", " "); 
            StringBuilder stringBuilder2 = new StringBuilder();
            this();
            stringBuilder2.append(str2);
            stringBuilder2.append("(");
            String str3 = stringBuilder2.toString();
            StringBuilder stringBuilder1 = new StringBuilder();
            this();
            stringBuilder1.append(str3);
            stringBuilder1.append(wifiInfo.getSSID().replace("\"", ""));
            str3 = stringBuilder1.toString();
            stringBuilder1 = new StringBuilder();
            this();
            stringBuilder1.append(str3);
            stringBuilder1.append(")");
            String str1 = stringBuilder1.toString();
            return a(str1);
          } 
        } 
        String str = "null";
      } catch (Throwable throwable) {
        String str = "null";
      } 
    } else {
      paramContext = null;
    } 
    return a((String)paramContext);
  }
  
  public String e(Context paramContext) {
    String str;
    if (c != null)
      return c; 
    if (!w.a(paramContext, "android.permission.READ_PHONE_STATE")) {
      str = "NO_PERMISSION_MANIFEST";
      c = str;
      return c;
    } 
    if (Build.VERSION.SDK_INT >= 23 && !w.b((Context)str, "android.permission.READ_PHONE_STATE")) {
      str = "NO_PERMISSION_SDK_23";
      c = str;
      return c;
    } 
    if (str != null) {
      try {
        c = ((TelephonyManager)str.getSystemService("phone")).getSubscriberId();
        c = a(c);
      } catch (Throwable throwable) {
        c = null;
      } 
      return c;
    } 
    return c;
  }
  
  public String f(Context paramContext) {
    if (Build.VERSION.SDK_INT > 8)
      try {
        Field[] arrayOfField = Build.class.getFields();
        byte b = 0;
        while (true) {
          if (b < arrayOfField.length) {
            if (arrayOfField[b].getName().equals("SERIAL")) {
              Field field = arrayOfField[b];
              break;
            } 
            b++;
            continue;
          } 
          arrayOfField = null;
          break;
        } 
        if (arrayOfField != null)
          return a(arrayOfField.get(Build.class).toString()); 
      } catch (Throwable throwable) {} 
    return null;
  }
  
  public String g(Context paramContext) {
    String str1 = null;
    String str2 = str1;
    if (paramContext != null)
      try {
        str2 = a(Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
      } catch (Throwable throwable) {
        str2 = str1;
      }  
    return str2;
  }
  
  public String h(Context paramContext) {
    return "";
  }
  
  public String i(Context paramContext) {
    try {
      String str = Build.BRAND;
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  public String j(Context paramContext) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic getNetworkInterfaces : ()Ljava/util/Enumeration;
    //   5: astore_3
    //   6: aconst_null
    //   7: astore #4
    //   9: aload #4
    //   11: astore_1
    //   12: aload #4
    //   14: astore #5
    //   16: aload_1
    //   17: astore #6
    //   19: aload_3
    //   20: invokeinterface hasMoreElements : ()Z
    //   25: ifeq -> 271
    //   28: aload_3
    //   29: invokeinterface nextElement : ()Ljava/lang/Object;
    //   34: checkcast java/net/NetworkInterface
    //   37: astore #5
    //   39: aload #5
    //   41: invokevirtual getClass : ()Ljava/lang/Class;
    //   44: invokevirtual getMethods : ()[Ljava/lang/reflect/Method;
    //   47: astore #6
    //   49: iconst_0
    //   50: istore #7
    //   52: iload #7
    //   54: aload #6
    //   56: arraylength
    //   57: if_icmpge -> 92
    //   60: aload #6
    //   62: iload #7
    //   64: aaload
    //   65: invokevirtual getName : ()Ljava/lang/String;
    //   68: ldc 'getHardwareAddress'
    //   70: invokevirtual equals : (Ljava/lang/Object;)Z
    //   73: ifeq -> 86
    //   76: aload #6
    //   78: iload #7
    //   80: aaload
    //   81: astore #6
    //   83: goto -> 95
    //   86: iinc #7, 1
    //   89: goto -> 52
    //   92: aconst_null
    //   93: astore #6
    //   95: aload #6
    //   97: ifnonnull -> 102
    //   100: aconst_null
    //   101: areturn
    //   102: aload #6
    //   104: aload #5
    //   106: iconst_0
    //   107: anewarray java/lang/Object
    //   110: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   113: checkcast [B
    //   116: astore #8
    //   118: aload #8
    //   120: ifnull -> 12
    //   123: aload #8
    //   125: arraylength
    //   126: ifne -> 132
    //   129: goto -> 12
    //   132: new java/lang/StringBuilder
    //   135: astore #6
    //   137: aload #6
    //   139: invokespecial <init> : ()V
    //   142: aload #8
    //   144: arraylength
    //   145: istore #9
    //   147: iconst_0
    //   148: istore #7
    //   150: iload #7
    //   152: iload #9
    //   154: if_icmpge -> 190
    //   157: aload #6
    //   159: ldc_w '%02x '
    //   162: iconst_1
    //   163: anewarray java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: aload #8
    //   170: iload #7
    //   172: baload
    //   173: invokestatic valueOf : (B)Ljava/lang/Byte;
    //   176: aastore
    //   177: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: iinc #7, 1
    //   187: goto -> 150
    //   190: aload #6
    //   192: invokevirtual length : ()I
    //   195: ifle -> 211
    //   198: aload #6
    //   200: aload #6
    //   202: invokevirtual length : ()I
    //   205: iconst_1
    //   206: isub
    //   207: invokevirtual deleteCharAt : (I)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload #6
    //   213: invokevirtual toString : ()Ljava/lang/String;
    //   216: astore #6
    //   218: aload #5
    //   220: invokevirtual getName : ()Ljava/lang/String;
    //   223: ldc_w 'wlan0'
    //   226: invokevirtual equals : (Ljava/lang/Object;)Z
    //   229: ifeq -> 239
    //   232: aload #6
    //   234: astore #4
    //   236: goto -> 12
    //   239: aload #5
    //   241: invokevirtual getName : ()Ljava/lang/String;
    //   244: ldc_w 'eth1'
    //   247: invokevirtual equals : (Ljava/lang/Object;)Z
    //   250: istore #10
    //   252: iload #10
    //   254: ifeq -> 12
    //   257: aload #6
    //   259: astore_1
    //   260: goto -> 12
    //   263: astore_1
    //   264: aconst_null
    //   265: astore #5
    //   267: aload #5
    //   269: astore #6
    //   271: aload #5
    //   273: ifnull -> 283
    //   276: aload_0
    //   277: aload #5
    //   279: invokespecial a : (Ljava/lang/String;)Ljava/lang/String;
    //   282: areturn
    //   283: aload_2
    //   284: astore_1
    //   285: aload #6
    //   287: ifnull -> 297
    //   290: aload_0
    //   291: aload #6
    //   293: invokespecial a : (Ljava/lang/String;)Ljava/lang/String;
    //   296: astore_1
    //   297: aload_1
    //   298: areturn
    //   299: astore #6
    //   301: aload #4
    //   303: astore #5
    //   305: aload_1
    //   306: astore #6
    //   308: goto -> 271
    //   311: astore #6
    //   313: goto -> 12
    // Exception table:
    //   from	to	target	type
    //   2	6	263	java/lang/Throwable
    //   19	49	299	java/lang/Throwable
    //   52	76	299	java/lang/Throwable
    //   102	118	311	java/lang/Throwable
    //   123	129	299	java/lang/Throwable
    //   132	147	299	java/lang/Throwable
    //   157	184	299	java/lang/Throwable
    //   190	211	299	java/lang/Throwable
    //   211	232	299	java/lang/Throwable
    //   239	252	299	java/lang/Throwable
  }
  
  public String k(Context paramContext) {
    Method method = null;
    if (paramContext != null) {
      String str1 = "X";
      String str2 = "X";
      StringBuffer stringBuffer = new StringBuffer();
      if (Build.VERSION.SDK_INT >= 10) {
        String str3;
        String str4;
        String str5;
        try {
          Method method1;
          Class<?> clazz1 = Class.forName("android.hardware.Camera");
          int i = ((Integer)clazz1.getMethod("getNumberOfCameras", new Class[0]).invoke(clazz1, new Object[0])).intValue();
          if (i == 0) {
            str1 = "N";
            str2 = "N";
          } 
          Class<?> clazz2 = Class.forName("android.hardware.Camera$CameraInfo");
          Object object = clazz2.newInstance();
          Method[] arrayOfMethod = clazz1.getMethods();
          int j = arrayOfMethod.length;
          byte b = 0;
          while (true) {
            method1 = method;
            if (b < j) {
              if (arrayOfMethod[b].getName().equals("getCameraInfo")) {
                method1 = arrayOfMethod[b];
                break;
              } 
              b++;
              continue;
            } 
            break;
          } 
          Field field1 = clazz2.getField("facing");
          Field field2 = clazz2.getField("CAMERA_FACING_BACK");
          Field field3 = clazz2.getField("CAMERA_FACING_FRONT");
          str5 = str1;
          str4 = str2;
          if (method1 != null) {
            str4 = str1;
            b = 0;
            for (str1 = str2; b < i; str1 = str2) {
              method1.invoke(clazz1, new Object[] { Integer.valueOf(b), object });
              j = field1.getInt(object);
              int k = field2.getInt(object);
              int m = field3.getInt(object);
              if (j == k) {
                str1 = "Y";
                str2 = str1;
                if (i == 1) {
                  str4 = "N";
                  str2 = str1;
                } 
              } else {
                str2 = str1;
                if (j == m) {
                  str5 = "Y";
                  str4 = str5;
                  str2 = str1;
                  if (i == 1) {
                    str2 = "N";
                    str4 = str5;
                  } 
                } 
              } 
              b++;
            } 
            str5 = str4;
            str4 = str1;
          } 
        } catch (Throwable throwable) {
          str4 = "E";
          str5 = "E";
        } 
        try {
          SensorManager sensorManager = (SensorManager)paramContext.getSystemService("sensor");
          if (sensorManager.getDefaultSensor(1) == null) {
            str3 = "N";
          } else {
            str3 = "Y";
          } 
          if (sensorManager.getDefaultSensor(4) != null) {
            String str = "Y";
          } else {
            String str = "N";
          } 
        } catch (Throwable throwable) {
          str3 = "E";
          str1 = "E";
        } 
        stringBuffer.append(str4);
        stringBuffer.append(str5);
        stringBuffer.append(str3);
        stringBuffer.append(str1);
        return stringBuffer.toString();
      } 
    } 
    return null;
  }
  
  public String l(Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    if (packageManager != null)
      try {
        Intent intent = new Intent();
        this("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        null = (packageManager.resolveActivity(intent, 65536)).activityInfo.packageName;
        PackageInfo packageInfo = packageManager.getPackageInfo(null, 64);
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(ac.a(packageInfo.signatures[0].toByteArray()));
        stringBuilder.append("(");
        stringBuilder.append(null);
        stringBuilder.append(")");
        return stringBuilder.toString();
      } catch (Throwable throwable) {} 
    return null;
  }
  
  public List m(Context paramContext) {
    if (paramContext == null)
      return new ArrayList(); 
    PackageManager packageManager = paramContext.getPackageManager();
    if (packageManager == null)
      return new ArrayList(); 
    List<PackageInfo> list = packageManager.getInstalledPackages(0);
    try {
      HashSet<String> hashSet = new HashSet();
      this();
      Iterator iterator = list.iterator();
      while (iterator.hasNext())
        hashSet.add(((PackageInfo)iterator.next()).packageName); 
      Intent intent = new Intent();
      this("android.intent.action.MAIN");
      for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 1)) {
        if (!hashSet.add(resolveInfo.activityInfo.applicationInfo.packageName))
          continue; 
        PackageInfo packageInfo = new PackageInfo();
        this();
        packageInfo.applicationInfo = resolveInfo.activityInfo.applicationInfo;
        packageInfo.packageName = null;
        list.add(packageInfo);
      } 
    } catch (Throwable throwable) {}
    return list;
  }
  
  public List n(Context paramContext) {
    if (paramContext == null)
      return new ArrayList(); 
    ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
    return (activityManager == null) ? new ArrayList() : activityManager.getRunningServices(10000);
  }
  
  public List o(Context paramContext) {
    return new ArrayList();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\SMI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */