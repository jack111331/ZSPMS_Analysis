package com.yingxiong.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import com.yingxiong.recordsdk.RecordSDK;
import com.yingxiong.until.MLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

public class ConfigSDK {
  public static String DEVICEID_TYPE = "0";
  
  @SuppressLint({"StaticFieldLeak"})
  private static Context context;
  
  private static final String fileAddressMac = "/sys/class/net/wlan0/address";
  
  @SuppressLint({"StaticFieldLeak"})
  private static volatile ConfigSDK mConfig;
  
  private static final String marshmallowMacAddress = "02:00:00:00:00:00";
  
  private static String crunchifyGetStringFromStream(InputStream paramInputStream) throws IOException {
    if (paramInputStream != null) {
      StringWriter stringWriter = new StringWriter();
      char[] arrayOfChar = new char[2048];
      try {
        BufferedReader bufferedReader = new BufferedReader();
        InputStreamReader inputStreamReader = new InputStreamReader();
        this(paramInputStream, "UTF-8");
        this(inputStreamReader);
        while (true) {
          int i = bufferedReader.read(arrayOfChar);
          if (i != -1) {
            stringWriter.write(arrayOfChar, 0, i);
            continue;
          } 
          return stringWriter.toString();
        } 
      } finally {
        paramInputStream.close();
      } 
    } 
    return "No Contents";
  }
  
  private static String getAddressMacByFile(WifiManager paramWifiManager) throws Exception {
    int i = paramWifiManager.getWifiState();
    boolean bool = true;
    paramWifiManager.setWifiEnabled(true);
    FileInputStream fileInputStream = new FileInputStream(new File("/sys/class/net/wlan0/address"));
    String str = crunchifyGetStringFromStream(fileInputStream);
    fileInputStream.close();
    if (3 != i)
      bool = false; 
    paramWifiManager.setWifiEnabled(bool);
    return str;
  }
  
  private static String getAdressMacByInterface() {
    try {
      Iterator<NetworkInterface> iterator = Collections.<NetworkInterface>list(NetworkInterface.getNetworkInterfaces()).iterator();
      while (iterator.hasNext()) {
        NetworkInterface networkInterface = iterator.next();
        if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
          byte[] arrayOfByte = networkInterface.getHardwareAddress();
          if (arrayOfByte == null)
            return ""; 
          StringBuilder stringBuilder = new StringBuilder();
          this();
          int i = arrayOfByte.length;
          for (byte b = 0; b < i; b++) {
            stringBuilder.append(String.format("%02X:", new Object[] { Byte.valueOf(arrayOfByte[b]) }));
          } 
          if (stringBuilder.length() > 0)
            stringBuilder.deleteCharAt(stringBuilder.length() - 1); 
          return stringBuilder.toString();
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public static void init(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: putstatic com/yingxiong/common/ConfigSDK.context : Landroid/content/Context;
    //   4: getstatic com/yingxiong/common/ConfigSDK.mConfig : Lcom/yingxiong/common/ConfigSDK;
    //   7: ifnonnull -> 43
    //   10: ldc com/yingxiong/common/ConfigSDK
    //   12: monitorenter
    //   13: getstatic com/yingxiong/common/ConfigSDK.mConfig : Lcom/yingxiong/common/ConfigSDK;
    //   16: ifnonnull -> 31
    //   19: new com/yingxiong/common/ConfigSDK
    //   22: astore_0
    //   23: aload_0
    //   24: invokespecial <init> : ()V
    //   27: aload_0
    //   28: putstatic com/yingxiong/common/ConfigSDK.mConfig : Lcom/yingxiong/common/ConfigSDK;
    //   31: ldc com/yingxiong/common/ConfigSDK
    //   33: monitorexit
    //   34: goto -> 43
    //   37: astore_0
    //   38: ldc com/yingxiong/common/ConfigSDK
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    //   43: return
    // Exception table:
    //   from	to	target	type
    //   13	31	37	finally
    //   31	34	37	finally
    //   38	41	37	finally
  }
  
  public static ConfigSDK instance() {
    // Byte code:
    //   0: ldc com/yingxiong/common/ConfigSDK
    //   2: monitorenter
    //   3: getstatic com/yingxiong/common/ConfigSDK.mConfig : Lcom/yingxiong/common/ConfigSDK;
    //   6: ifnonnull -> 42
    //   9: ldc com/yingxiong/common/ConfigSDK
    //   11: monitorenter
    //   12: getstatic com/yingxiong/common/ConfigSDK.mConfig : Lcom/yingxiong/common/ConfigSDK;
    //   15: ifnonnull -> 30
    //   18: new com/yingxiong/common/ConfigSDK
    //   21: astore_0
    //   22: aload_0
    //   23: invokespecial <init> : ()V
    //   26: aload_0
    //   27: putstatic com/yingxiong/common/ConfigSDK.mConfig : Lcom/yingxiong/common/ConfigSDK;
    //   30: ldc com/yingxiong/common/ConfigSDK
    //   32: monitorexit
    //   33: goto -> 42
    //   36: astore_0
    //   37: ldc com/yingxiong/common/ConfigSDK
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    //   42: getstatic com/yingxiong/common/ConfigSDK.mConfig : Lcom/yingxiong/common/ConfigSDK;
    //   45: astore_0
    //   46: ldc com/yingxiong/common/ConfigSDK
    //   48: monitorexit
    //   49: aload_0
    //   50: areturn
    //   51: astore_0
    //   52: ldc com/yingxiong/common/ConfigSDK
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   3	12	51	finally
    //   12	30	36	finally
    //   30	33	36	finally
    //   37	40	36	finally
    //   40	42	51	finally
    //   42	46	51	finally
  }
  
  public static String md5(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    try {
      byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
      StringBuilder stringBuilder = new StringBuilder();
      this();
      int i = arrayOfByte.length;
      for (byte b = 0; b < i; b++) {
        String str1;
        String str2 = Integer.toHexString(arrayOfByte[b] & 0xFF);
        paramString = str2;
        if (str2.length() == 1) {
          StringBuilder stringBuilder1 = new StringBuilder();
          this();
          stringBuilder1.append("0");
          stringBuilder1.append(str2);
          str1 = stringBuilder1.toString();
        } 
        stringBuilder.append(str1);
      } 
      return stringBuilder.toString();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      noSuchAlgorithmException.printStackTrace();
      return "";
    } 
  }
  
  private String readApplicationMetaData(Context paramContext, String paramString) {
    String str1;
    String str2 = "";
    try {
      Bundle bundle = (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 128)).applicationInfo.metaData;
      str1 = str2;
      if (bundle != null) {
        Object object = bundle.get(paramString);
        if (object instanceof String) {
          str1 = (String)object;
        } else if (object instanceof Integer) {
          StringBuilder stringBuilder = new StringBuilder();
          this();
          stringBuilder.append(object);
          stringBuilder.append("");
          String str = stringBuilder.toString();
        } else {
          str1 = str2;
          if (object instanceof Boolean) {
            StringBuilder stringBuilder = new StringBuilder();
            this();
            stringBuilder.append(object);
            stringBuilder.append("");
            String str = stringBuilder.toString();
          } 
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      str1 = str2;
    } 
    return str1;
  }
  
  public static long string2Time(String paramString) {
    long l;
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
      this("yyyy-MM-dd HH:mm:ss");
      l = simpleDateFormat.parse(paramString).getTime();
    } catch (Exception exception) {
      exception.printStackTrace();
      l = 0L;
    } 
    return l;
  }
  
  public static String utc2Local(String paramString) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    try {
      Date date = simpleDateFormat.parse(paramString);
    } catch (ParseException parseException) {
      parseException.printStackTrace();
      parseException = null;
    } 
    simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    simpleDateFormat.setTimeZone(TimeZone.getTimeZone(RecordSDK.TIME_ZONE_STRING));
    return simpleDateFormat.format(Long.valueOf(parseException.getTime()));
  }
  
  public CharSequence GetUTCTime() {
    Calendar calendar = Calendar.getInstance();
    calendar.add(14, -(calendar.get(15) + calendar.get(16)));
    return DateFormat.format("yyyy-MM-dd HH:mm:ss", calendar);
  }
  
  public String geSystemVersion() {
    try {
      return Build.VERSION.RELEASE;
    } catch (Exception exception) {
      return "0";
    } 
  }
  
  public long getAPNType() {
    NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
    if (networkInfo == null)
      return 0L; 
    int i = networkInfo.getType();
    byte b = 4;
    if (i == 1) {
      b = 1;
    } else if (i == 0) {
      i = networkInfo.getSubtype();
      TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
      if (i != 13 || telephonyManager.isNetworkRoaming()) {
        if (i == 3 || i == 8 || (i == 5 && !telephonyManager.isNetworkRoaming())) {
          b = 3;
          return b;
        } 
        if (i != 1 && i != 2 && i == 4)
          telephonyManager.isNetworkRoaming(); 
        b = 2;
      } 
    } else {
      b = 0;
    } 
    return b;
  }
  
  public String getAccessKeySecret() {
    return readApplicationMetaData(context, "bdcAccessKeySecret");
  }
  
  public String getAccesskeyID() {
    return readApplicationMetaData(context, "bdcAccesskeyID");
  }
  
  public String getAdresseMAC() {
    String str;
    WifiManager wifiManager = (WifiManager)context.getSystemService("wifi");
    WifiInfo wifiInfo = wifiManager.getConnectionInfo();
    if (wifiInfo != null && "02:00:00:00:00:00".equals(wifiInfo.getMacAddress()))
      try {
        str = getAdressMacByInterface();
        return (str != null) ? str : getAddressMacByFile(wifiManager);
      } catch (Exception exception) {
        exception.printStackTrace();
        return "02:00:00:00:00:00";
      }  
    return (str != null && str.getMacAddress() != null) ? str.getMacAddress() : "";
  }
  
  public String getAndroidId() {
    try {
      return Settings.System.getString(context.getContentResolver(), "android_id");
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  public String getAppKey() {
    return readApplicationMetaData(context, "appKey");
  }
  
  public String getAppSecret() {
    return readApplicationMetaData(context, "productId");
  }
  
  public String getAppVersionName() {
    try {
      PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException.printStackTrace();
      nameNotFoundException = null;
    } 
    return (nameNotFoundException != null) ? ((PackageInfo)nameNotFoundException).versionName : "10000";
  }
  
  public String getChannelCode() {
    return readApplicationMetaData(context, "channelCode");
  }
  
  public boolean getDebugMode() {
    return readApplicationMetaData(context, "debugMode").equals("true");
  }
  
  @SuppressLint({"HardwareIds", "MissingPermission"})
  public String getDeviceId() {
    // Byte code:
    //   0: getstatic com/yingxiong/common/ConfigSDK.context : Landroid/content/Context;
    //   3: astore_1
    //   4: getstatic com/yingxiong/common/ConfigSDK.context : Landroid/content/Context;
    //   7: astore_2
    //   8: aload_1
    //   9: ldc_w 'phone'
    //   12: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   15: checkcast android/telephony/TelephonyManager
    //   18: invokevirtual getDeviceId : ()Ljava/lang/String;
    //   21: astore_1
    //   22: goto -> 33
    //   25: astore_2
    //   26: aload_2
    //   27: invokevirtual printStackTrace : ()V
    //   30: ldc ''
    //   32: astore_1
    //   33: getstatic com/yingxiong/action/RecordAction.OAID : Ljava/lang/String;
    //   36: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   39: ifne -> 46
    //   42: getstatic com/yingxiong/action/RecordAction.OAID : Ljava/lang/String;
    //   45: astore_1
    //   46: getstatic com/yingxiong/common/ConfigSDK.context : Landroid/content/Context;
    //   49: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   52: ldc_w 'android_id'
    //   55: invokestatic getString : (Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   58: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   61: ifeq -> 72
    //   64: aload_0
    //   65: invokevirtual getAdresseMAC : ()Ljava/lang/String;
    //   68: astore_2
    //   69: goto -> 96
    //   72: getstatic com/yingxiong/common/ConfigSDK.context : Landroid/content/Context;
    //   75: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   78: ldc_w 'android_id'
    //   81: invokestatic getString : (Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   84: astore_2
    //   85: goto -> 96
    //   88: astore_2
    //   89: aload_2
    //   90: invokevirtual printStackTrace : ()V
    //   93: ldc ''
    //   95: astore_2
    //   96: aload_1
    //   97: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   100: ifeq -> 114
    //   103: ldc_w '2'
    //   106: putstatic com/yingxiong/common/ConfigSDK.DEVICEID_TYPE : Ljava/lang/String;
    //   109: aload_2
    //   110: astore_1
    //   111: goto -> 137
    //   114: getstatic com/yingxiong/action/RecordAction.OAID : Ljava/lang/String;
    //   117: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   120: ifne -> 132
    //   123: ldc_w '1'
    //   126: putstatic com/yingxiong/common/ConfigSDK.DEVICEID_TYPE : Ljava/lang/String;
    //   129: goto -> 137
    //   132: ldc '0'
    //   134: putstatic com/yingxiong/common/ConfigSDK.DEVICEID_TYPE : Ljava/lang/String;
    //   137: aload_1
    //   138: areturn
    //   139: astore_2
    //   140: aload_2
    //   141: invokevirtual printStackTrace : ()V
    //   144: aconst_null
    //   145: areturn
    // Exception table:
    //   from	to	target	type
    //   0	22	25	java/lang/Exception
    //   26	30	139	java/lang/Exception
    //   33	46	139	java/lang/Exception
    //   46	69	88	java/lang/Exception
    //   72	85	88	java/lang/Exception
    //   89	93	139	java/lang/Exception
    //   96	109	139	java/lang/Exception
    //   114	129	139	java/lang/Exception
    //   132	137	139	java/lang/Exception
  }
  
  public String getDeviceKey() {
    SharedPreferences.Editor editor;
    String str;
    SharedPreferences sharedPreferences = context.getSharedPreferences("recorddata", 0);
    try {
      str = getEventUuid();
    } catch (Exception exception) {
      exception.printStackTrace();
      str = md5(getTalkId());
    } 
    if (TextUtils.isEmpty(sharedPreferences.getString("device_key", null))) {
      editor = sharedPreferences.edit();
      editor.putString("device_key", str);
      editor.commit();
      return str;
    } 
    return editor.getString("device_key", "");
  }
  
  public String getEndPoint() {
    return readApplicationMetaData(context, "endpoint");
  }
  
  public String getEventUuid() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append(getTalkId());
      stringBuilder.append(getPhoneInfo());
      stringBuilder.append(getDeviceId());
      return md5(stringBuilder.toString());
    } catch (Exception exception) {
      exception.printStackTrace();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getTalkId());
      stringBuilder.append(getUserAgent());
      return md5(stringBuilder.toString());
    } 
  }
  
  @SuppressLint({"HardwareIds", "MissingPermission"})
  public String getIme() {
    try {
      Context context1 = context;
      Context context2 = context;
      String str = ((TelephonyManager)context1.getSystemService("phone")).getDeviceId();
    } catch (Exception null) {
      try {
        exception.printStackTrace();
        return "";
      } catch (Exception exception) {
        exception.printStackTrace();
        return null;
      } 
    } 
    return (String)exception;
  }
  
  public String getLogStoreName() {
    return readApplicationMetaData(context, "logStoreName");
  }
  
  public String getMediaChannelCode() {
    return readApplicationMetaData(context, "mediaChannelCode");
  }
  
  public String getPhoneDisplay() {
    try {
      DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
      int i = displayMetrics.widthPixels;
      int j = displayMetrics.heightPixels;
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append(String.valueOf(i));
      stringBuilder.append("*");
      stringBuilder.append(String.valueOf(j));
      return stringBuilder.toString();
    } catch (Exception exception) {
      return "1080*1920";
    } 
  }
  
  public String getPhoneInfo() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append(Build.MANUFACTURER);
      stringBuilder.append("-");
      stringBuilder.append(Build.MODEL);
      return stringBuilder.toString();
    } catch (Exception exception) {
      return "0";
    } 
  }
  
  public String getPhoneTime(long paramLong) {
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
      this("yyyy-MM-dd", Locale.CHINA);
      Date date = new Date();
      this(paramLong);
      return simpleDateFormat.format(date);
    } catch (Exception exception) {
      return "0";
    } 
  }
  
  public long getPhoneTimeForLong() {
    try {
      if (!RecordSDK.isUTC) {
        Date date = new Date();
        this();
        return date.getTime();
      } 
      return string2Time(utc2Local(GetUTCTime().toString()));
    } catch (Exception exception) {
      return 0L;
    } 
  }
  
  public String getProjectName() {
    return readApplicationMetaData(context, "logProjectName");
  }
  
  public String getTalkId() {
    try {
      Date date = new Date();
      this();
      long l = date.getTime() / 1000L;
      return String.valueOf(l);
    } catch (Exception exception) {
      return String.valueOf(0);
    } 
  }
  
  public String getUserAgent() {
    try {
      String str = System.getProperty("http.agent");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("User Agent:\n");
      stringBuilder.append(str);
      MLog.e("andly", stringBuilder.toString());
      return str.toString().trim();
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\yingxiong\common\ConfigSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */