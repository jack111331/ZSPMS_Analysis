package com.alipay.security.mobile.module.b;

import android.app.KeyguardManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.alipay.security.mobile.module.a.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
  private static b a = new b();
  
  private static String A() {
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
    return "";
  }
  
  public static b a() {
    return a;
  }
  
  private static String a(BluetoothAdapter paramBluetoothAdapter) {
    try {
      Field field = BluetoothAdapter.class.getDeclaredField("mService");
      field.setAccessible(true);
      Object object = field.get(paramBluetoothAdapter);
      if (object == null)
        return null; 
      Method method = object.getClass().getDeclaredMethod("getAddress", new Class[0]);
      method.setAccessible(true);
      object = method.invoke(object, new Object[0]);
      if (object != null && object instanceof String)
        return (String)object; 
    } catch (Throwable throwable) {}
    return null;
  }
  
  public static String a(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'android.permission.READ_PHONE_STATE'
    //   3: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   6: ifeq -> 14
    //   9: ldc ''
    //   11: astore_0
    //   12: aload_0
    //   13: areturn
    //   14: aload_0
    //   15: ifnull -> 50
    //   18: aload_0
    //   19: ldc 'phone'
    //   21: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   24: checkcast android/telephony/TelephonyManager
    //   27: astore_0
    //   28: aload_0
    //   29: ifnull -> 50
    //   32: aload_0
    //   33: invokevirtual getDeviceId : ()Ljava/lang/String;
    //   36: astore_1
    //   37: aload_1
    //   38: astore_0
    //   39: aload_1
    //   40: ifnonnull -> 12
    //   43: ldc ''
    //   45: astore_0
    //   46: goto -> 12
    //   49: astore_0
    //   50: aconst_null
    //   51: astore_1
    //   52: goto -> 37
    // Exception table:
    //   from	to	target	type
    //   18	28	49	java/lang/Throwable
    //   32	37	49	java/lang/Throwable
  }
  
  private static boolean a(Context paramContext, String paramString) {
    boolean bool2;
    boolean bool1 = true;
    if (paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (bool2)
      bool1 = false; 
    return bool1;
  }
  
  public static String b() {
    long l = 0L;
    try {
      File file = Environment.getDataDirectory();
      StatFs statFs = new StatFs();
      this(file.getPath());
      long l1 = statFs.getBlockSize();
      int i = statFs.getAvailableBlocks();
      l = i * l1;
    } catch (Throwable throwable) {}
    return String.valueOf(l);
  }
  
  public static String b(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'android.permission.READ_PHONE_STATE'
    //   3: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   6: ifeq -> 14
    //   9: ldc ''
    //   11: astore_1
    //   12: aload_1
    //   13: areturn
    //   14: aload_0
    //   15: ifnull -> 50
    //   18: aload_0
    //   19: ldc 'phone'
    //   21: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   24: checkcast android/telephony/TelephonyManager
    //   27: astore_0
    //   28: aload_0
    //   29: ifnull -> 50
    //   32: aload_0
    //   33: invokevirtual getSubscriberId : ()Ljava/lang/String;
    //   36: astore_0
    //   37: aload_0
    //   38: astore_1
    //   39: aload_0
    //   40: ifnonnull -> 12
    //   43: ldc ''
    //   45: astore_1
    //   46: goto -> 12
    //   49: astore_0
    //   50: ldc ''
    //   52: astore_0
    //   53: goto -> 37
    // Exception table:
    //   from	to	target	type
    //   18	28	49	java/lang/Throwable
    //   32	37	49	java/lang/Throwable
  }
  
  public static String c() {
    long l1 = 0L;
    long l2 = l1;
    try {
      if ("mounted".equals(Environment.getExternalStorageState())) {
        File file = a.a();
        StatFs statFs = new StatFs();
        this(file.getPath());
        l2 = statFs.getBlockSize();
        int i = statFs.getAvailableBlocks();
        l2 = i * l2;
      } 
    } catch (Throwable throwable) {
      l2 = l1;
    } 
    return String.valueOf(l2);
  }
  
  public static String c(Context paramContext) {
    int i = 0;
    try {
      int j = Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on", 0);
      i = j;
    } catch (Throwable throwable) {}
    return (i == 1) ? "1" : "0";
  }
  
  public static String d() {
    return "";
  }
  
  public static String d(Context paramContext) {
    boolean bool = true;
    JSONObject jSONObject = new JSONObject();
    try {
      AudioManager audioManager = (AudioManager)paramContext.getSystemService("audio");
      if (audioManager.getRingerMode() != 0)
        bool = false; 
      int i = audioManager.getStreamVolume(0);
      int j = audioManager.getStreamVolume(1);
      int k = audioManager.getStreamVolume(2);
      int m = audioManager.getStreamVolume(3);
      int n = audioManager.getStreamVolume(4);
      jSONObject.put("ringermode", String.valueOf(bool));
      jSONObject.put("call", String.valueOf(i));
      jSONObject.put("system", String.valueOf(j));
      jSONObject.put("ring", String.valueOf(k));
      jSONObject.put("music", String.valueOf(m));
      jSONObject.put("alarm", String.valueOf(n));
    } catch (Throwable throwable) {}
    return jSONObject.toString();
  }
  
  public static String e() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: aconst_null
    //   3: astore_1
    //   4: new java/io/FileInputStream
    //   7: astore_2
    //   8: new java/io/File
    //   11: astore_3
    //   12: aload_3
    //   13: ldc '/proc/cpuinfo'
    //   15: invokespecial <init> : (Ljava/lang/String;)V
    //   18: aload_2
    //   19: aload_3
    //   20: invokespecial <init> : (Ljava/io/File;)V
    //   23: new java/io/InputStreamReader
    //   26: astore #4
    //   28: aload #4
    //   30: aload_2
    //   31: invokespecial <init> : (Ljava/io/InputStream;)V
    //   34: new java/io/LineNumberReader
    //   37: astore_1
    //   38: aload_1
    //   39: aload #4
    //   41: invokespecial <init> : (Ljava/io/Reader;)V
    //   44: iconst_1
    //   45: istore #5
    //   47: iload #5
    //   49: bipush #100
    //   51: if_icmpge -> 304
    //   54: aload_1
    //   55: invokevirtual readLine : ()Ljava/lang/String;
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull -> 304
    //   63: aload_3
    //   64: ldc 'Serial'
    //   66: invokevirtual indexOf : (Ljava/lang/String;)I
    //   69: iflt -> 118
    //   72: aload_3
    //   73: aload_3
    //   74: ldc ':'
    //   76: invokevirtual indexOf : (Ljava/lang/String;)I
    //   79: iconst_1
    //   80: iadd
    //   81: aload_3
    //   82: invokevirtual length : ()I
    //   85: invokevirtual substring : (II)Ljava/lang/String;
    //   88: invokevirtual trim : ()Ljava/lang/String;
    //   91: astore_3
    //   92: aload_1
    //   93: invokevirtual close : ()V
    //   96: aload #4
    //   98: invokevirtual close : ()V
    //   101: aload_2
    //   102: invokevirtual close : ()V
    //   105: aload_3
    //   106: astore_2
    //   107: aload_2
    //   108: astore_3
    //   109: aload_2
    //   110: ifnonnull -> 116
    //   113: ldc ''
    //   115: astore_3
    //   116: aload_3
    //   117: areturn
    //   118: iinc #5, 1
    //   121: goto -> 47
    //   124: astore_2
    //   125: aload_3
    //   126: astore_2
    //   127: goto -> 107
    //   130: astore_2
    //   131: aconst_null
    //   132: astore_2
    //   133: aconst_null
    //   134: astore_3
    //   135: aload_1
    //   136: astore #4
    //   138: aload_2
    //   139: ifnull -> 146
    //   142: aload_2
    //   143: invokevirtual close : ()V
    //   146: aload #4
    //   148: ifnull -> 156
    //   151: aload #4
    //   153: invokevirtual close : ()V
    //   156: aload_3
    //   157: ifnull -> 297
    //   160: aload_3
    //   161: invokevirtual close : ()V
    //   164: ldc_w '0000000000000000'
    //   167: astore_2
    //   168: goto -> 107
    //   171: astore_2
    //   172: ldc_w '0000000000000000'
    //   175: astore_2
    //   176: goto -> 107
    //   179: astore_3
    //   180: aconst_null
    //   181: astore #4
    //   183: aconst_null
    //   184: astore_2
    //   185: aload_0
    //   186: astore_1
    //   187: aload_1
    //   188: ifnull -> 195
    //   191: aload_1
    //   192: invokevirtual close : ()V
    //   195: aload #4
    //   197: ifnull -> 205
    //   200: aload #4
    //   202: invokevirtual close : ()V
    //   205: aload_2
    //   206: ifnull -> 213
    //   209: aload_2
    //   210: invokevirtual close : ()V
    //   213: aload_3
    //   214: athrow
    //   215: astore_1
    //   216: goto -> 96
    //   219: astore #4
    //   221: goto -> 101
    //   224: astore_2
    //   225: goto -> 146
    //   228: astore_2
    //   229: goto -> 156
    //   232: astore_1
    //   233: goto -> 195
    //   236: astore #4
    //   238: goto -> 205
    //   241: astore_2
    //   242: goto -> 213
    //   245: astore_3
    //   246: aconst_null
    //   247: astore #4
    //   249: aload_0
    //   250: astore_1
    //   251: goto -> 187
    //   254: astore_3
    //   255: aload_0
    //   256: astore_1
    //   257: goto -> 187
    //   260: astore_3
    //   261: goto -> 187
    //   264: astore_3
    //   265: aconst_null
    //   266: astore #4
    //   268: aload_2
    //   269: astore_3
    //   270: aload #4
    //   272: astore_2
    //   273: aload_1
    //   274: astore #4
    //   276: goto -> 138
    //   279: astore_3
    //   280: aconst_null
    //   281: astore_1
    //   282: aload_2
    //   283: astore_3
    //   284: aload_1
    //   285: astore_2
    //   286: goto -> 138
    //   289: astore_3
    //   290: aload_2
    //   291: astore_3
    //   292: aload_1
    //   293: astore_2
    //   294: goto -> 138
    //   297: ldc_w '0000000000000000'
    //   300: astore_2
    //   301: goto -> 107
    //   304: ldc_w '0000000000000000'
    //   307: astore_3
    //   308: goto -> 92
    // Exception table:
    //   from	to	target	type
    //   4	23	130	java/lang/Throwable
    //   4	23	179	finally
    //   23	34	264	java/lang/Throwable
    //   23	34	245	finally
    //   34	44	279	java/lang/Throwable
    //   34	44	254	finally
    //   54	59	289	java/lang/Throwable
    //   54	59	260	finally
    //   63	92	289	java/lang/Throwable
    //   63	92	260	finally
    //   92	96	215	java/lang/Throwable
    //   96	101	219	java/lang/Throwable
    //   101	105	124	java/lang/Throwable
    //   142	146	224	java/lang/Throwable
    //   151	156	228	java/lang/Throwable
    //   160	164	171	java/lang/Throwable
    //   191	195	232	java/lang/Throwable
    //   200	205	236	java/lang/Throwable
    //   209	213	241	java/lang/Throwable
  }
  
  public static String e(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 45
    //   4: aload_0
    //   5: ldc 'phone'
    //   7: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   10: checkcast android/telephony/TelephonyManager
    //   13: astore_0
    //   14: aload_0
    //   15: ifnull -> 45
    //   18: aload_0
    //   19: invokevirtual getNetworkOperatorName : ()Ljava/lang/String;
    //   22: astore_0
    //   23: aload_0
    //   24: ifnull -> 39
    //   27: aload_0
    //   28: astore_1
    //   29: ldc_w 'null'
    //   32: aload_0
    //   33: invokevirtual equals : (Ljava/lang/Object;)Z
    //   36: ifeq -> 42
    //   39: ldc ''
    //   41: astore_1
    //   42: aload_1
    //   43: areturn
    //   44: astore_0
    //   45: aconst_null
    //   46: astore_0
    //   47: goto -> 23
    // Exception table:
    //   from	to	target	type
    //   4	14	44	java/lang/Throwable
    //   18	23	44	java/lang/Throwable
  }
  
  public static String f(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 103
    //   4: aload_0
    //   5: ldc_w 'sensor'
    //   8: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   11: checkcast android/hardware/SensorManager
    //   14: astore_0
    //   15: aload_0
    //   16: ifnull -> 103
    //   19: aload_0
    //   20: iconst_m1
    //   21: invokevirtual getSensorList : (I)Ljava/util/List;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnull -> 103
    //   29: aload_1
    //   30: invokeinterface size : ()I
    //   35: ifle -> 103
    //   38: new java/lang/StringBuilder
    //   41: astore_0
    //   42: aload_0
    //   43: invokespecial <init> : ()V
    //   46: aload_1
    //   47: invokeinterface iterator : ()Ljava/util/Iterator;
    //   52: astore_1
    //   53: aload_1
    //   54: invokeinterface hasNext : ()Z
    //   59: ifeq -> 116
    //   62: aload_1
    //   63: invokeinterface next : ()Ljava/lang/Object;
    //   68: checkcast android/hardware/Sensor
    //   71: astore_2
    //   72: aload_0
    //   73: aload_2
    //   74: invokevirtual getName : ()Ljava/lang/String;
    //   77: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_0
    //   82: aload_2
    //   83: invokevirtual getVersion : ()I
    //   86: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_0
    //   91: aload_2
    //   92: invokevirtual getVendor : ()Ljava/lang/String;
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: goto -> 53
    //   102: astore_0
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: astore_1
    //   107: aload_0
    //   108: ifnonnull -> 114
    //   111: ldc ''
    //   113: astore_1
    //   114: aload_1
    //   115: areturn
    //   116: aload_0
    //   117: invokevirtual toString : ()Ljava/lang/String;
    //   120: invokestatic e : (Ljava/lang/String;)Ljava/lang/String;
    //   123: astore_0
    //   124: goto -> 105
    // Exception table:
    //   from	to	target	type
    //   4	15	102	java/lang/Throwable
    //   19	25	102	java/lang/Throwable
    //   29	53	102	java/lang/Throwable
    //   53	99	102	java/lang/Throwable
    //   116	124	102	java/lang/Throwable
  }
  
  public static String g() {
    String str = x();
    if (a.a(str))
      str = y(); 
    return str;
  }
  
  public static String g(Context paramContext) {
    JSONArray jSONArray = new JSONArray();
    if (paramContext != null)
      try {
        SensorManager sensorManager = (SensorManager)paramContext.getSystemService("sensor");
        if (sensorManager != null) {
          List list = sensorManager.getSensorList(-1);
          if (list != null && list.size() > 0)
            for (Sensor sensor : list) {
              if (sensor != null) {
                JSONObject jSONObject = new JSONObject();
                this();
                jSONObject.put("name", sensor.getName());
                jSONObject.put("version", sensor.getVersion());
                jSONObject.put("vendor", sensor.getVendor());
                jSONArray.put(jSONObject);
              } 
            }  
        } 
      } catch (Throwable throwable) {} 
    return jSONArray.toString();
  }
  
  public static String h() {
    FileReader fileReader;
    BufferedReader bufferedReader;
    String[] arrayOfString = null;
    try {
      FileReader fileReader1 = new FileReader();
      this("/proc/cpuinfo");
      try {
      
      } catch (Throwable null) {
      
      } finally {
        bufferedReader = null;
        if (throwable != null)
          try {
            throwable.close();
          } catch (Throwable throwable1) {} 
        if (bufferedReader != null)
          try {
            bufferedReader.close();
          } catch (Throwable throwable) {} 
      } 
      if (throwable != null)
        try {
          throwable.close();
        } catch (Throwable throwable1) {} 
    } catch (Throwable throwable) {
      throwable = null;
      if (throwable != null)
        try {
          throwable.close();
        } catch (Throwable throwable1) {} 
    } finally {
      arrayOfString = null;
      fileReader = null;
    } 
    if (fileReader != null)
      try {
        fileReader.close();
      } catch (Throwable throwable) {} 
    if (bufferedReader != null)
      try {
        bufferedReader.close();
      } catch (Throwable throwable) {} 
    throw arrayOfString;
  }
  
  public static String h(Context paramContext) {
    String str;
    try {
      DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      str = stringBuilder.append(Integer.toString(displayMetrics.widthPixels)).append("*").append(Integer.toString(displayMetrics.heightPixels)).toString();
    } catch (Throwable throwable) {
      str = "";
    } 
    return str;
  }
  
  public static String i() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: lconst_0
    //   3: lstore_1
    //   4: new java/io/FileReader
    //   7: astore_3
    //   8: aload_3
    //   9: ldc_w '/proc/meminfo'
    //   12: invokespecial <init> : (Ljava/lang/String;)V
    //   15: new java/io/BufferedReader
    //   18: astore #4
    //   20: aload #4
    //   22: aload_3
    //   23: sipush #8192
    //   26: invokespecial <init> : (Ljava/io/Reader;I)V
    //   29: aload #4
    //   31: invokevirtual readLine : ()Ljava/lang/String;
    //   34: astore_0
    //   35: lload_1
    //   36: lstore #5
    //   38: aload_0
    //   39: ifnull -> 61
    //   42: aload_0
    //   43: ldc_w '\s+'
    //   46: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   49: iconst_1
    //   50: aaload
    //   51: invokestatic parseInt : (Ljava/lang/String;)I
    //   54: istore #7
    //   56: iload #7
    //   58: i2l
    //   59: lstore #5
    //   61: aload_3
    //   62: invokevirtual close : ()V
    //   65: aload #4
    //   67: invokevirtual close : ()V
    //   70: lload #5
    //   72: invokestatic valueOf : (J)Ljava/lang/String;
    //   75: areturn
    //   76: astore_3
    //   77: aconst_null
    //   78: astore_3
    //   79: aload_3
    //   80: ifnull -> 87
    //   83: aload_3
    //   84: invokevirtual close : ()V
    //   87: lload_1
    //   88: lstore #5
    //   90: aload_0
    //   91: ifnull -> 70
    //   94: aload_0
    //   95: invokevirtual close : ()V
    //   98: lload_1
    //   99: lstore #5
    //   101: goto -> 70
    //   104: astore_0
    //   105: lload_1
    //   106: lstore #5
    //   108: goto -> 70
    //   111: astore_0
    //   112: aconst_null
    //   113: astore #8
    //   115: aconst_null
    //   116: astore_3
    //   117: aload #8
    //   119: ifnull -> 127
    //   122: aload #8
    //   124: invokevirtual close : ()V
    //   127: aload_3
    //   128: ifnull -> 135
    //   131: aload_3
    //   132: invokevirtual close : ()V
    //   135: aload_0
    //   136: athrow
    //   137: astore_0
    //   138: goto -> 65
    //   141: astore_0
    //   142: goto -> 70
    //   145: astore_3
    //   146: goto -> 87
    //   149: astore #4
    //   151: goto -> 127
    //   154: astore_3
    //   155: goto -> 135
    //   158: astore_0
    //   159: aconst_null
    //   160: astore #4
    //   162: aload_3
    //   163: astore #8
    //   165: aload #4
    //   167: astore_3
    //   168: goto -> 117
    //   171: astore_0
    //   172: aload_3
    //   173: astore #8
    //   175: aload #4
    //   177: astore_3
    //   178: goto -> 117
    //   181: astore #4
    //   183: goto -> 79
    //   186: astore_0
    //   187: aload #4
    //   189: astore_0
    //   190: goto -> 79
    // Exception table:
    //   from	to	target	type
    //   4	15	76	java/lang/Throwable
    //   4	15	111	finally
    //   15	29	181	java/lang/Throwable
    //   15	29	158	finally
    //   29	35	186	java/lang/Throwable
    //   29	35	171	finally
    //   42	56	186	java/lang/Throwable
    //   42	56	171	finally
    //   61	65	137	java/lang/Throwable
    //   65	70	141	java/lang/Throwable
    //   83	87	145	java/lang/Throwable
    //   94	98	104	java/lang/Throwable
    //   122	127	149	java/lang/Throwable
    //   131	135	154	java/lang/Throwable
  }
  
  public static String i(Context paramContext) {
    String str;
    try {
      DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      str = stringBuilder.append(displayMetrics.widthPixels).toString();
    } catch (Throwable throwable) {
      str = "";
    } 
    return str;
  }
  
  public static String j() {
    long l = 0L;
    try {
      File file = Environment.getDataDirectory();
      StatFs statFs = new StatFs();
      this(file.getPath());
      long l1 = statFs.getBlockSize();
      int i = statFs.getBlockCount();
      l = i * l1;
    } catch (Throwable throwable) {}
    return String.valueOf(l);
  }
  
  public static String j(Context paramContext) {
    String str;
    try {
      DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      str = stringBuilder.append(displayMetrics.heightPixels).toString();
    } catch (Throwable throwable) {
      str = "";
    } 
    return str;
  }
  
  public static String k() {
    long l1 = 0L;
    long l2 = l1;
    try {
      if ("mounted".equals(Environment.getExternalStorageState())) {
        File file = Environment.getExternalStorageDirectory();
        StatFs statFs = new StatFs();
        this(file.getPath());
        l2 = statFs.getBlockSize();
        int i = statFs.getBlockCount();
        l2 = i * l2;
      } 
    } catch (Throwable throwable) {
      l2 = l1;
    } 
    return String.valueOf(l2);
  }
  
  public static String k(Context paramContext) {
    String str;
    if (a(paramContext, "android.permission.ACCESS_WIFI_STATE"))
      return ""; 
    try {
      String str1 = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      if (str1 != null) {
        String str2;
        try {
          if (str1.length() != 0) {
            String str3 = str1;
            if ("02:00:00:00:00:00".equals(str1))
              str3 = w(); 
            return str3;
          } 
          str2 = w();
        } catch (Throwable throwable) {
          str2 = str1;
        } 
        return str2;
      } 
      str = w();
    } catch (Throwable throwable) {
      str = "";
    } 
    return str;
  }
  
  public static String l() {
    String str1;
    try {
      Class<?> clazz = Class.forName("android.os.SystemProperties");
      Object object = clazz.newInstance();
      str1 = (String)clazz.getMethod("get", new Class[] { String.class, String.class }).invoke(object, new Object[] { "gsm.version.baseband", "no message" });
    } catch (Throwable throwable) {
      str1 = "";
    } 
    String str2 = str1;
    if (str1 == null)
      str2 = ""; 
    return str2;
  }
  
  public static String l(Context paramContext) {
    String str;
    if (a(paramContext, "android.permission.READ_PHONE_STATE"))
      return ""; 
    try {
      String str1 = ((TelephonyManager)paramContext.getSystemService("phone")).getSimSerialNumber();
      if (str1 != null) {
        String str2 = str1;
        if (str1 != null) {
          str2 = str1;
          try {
            if (str1.length() == 0)
              str2 = ""; 
          } catch (Throwable throwable) {
            str2 = str1;
          } 
        } 
        return str2;
      } 
      str = "";
    } catch (Throwable throwable) {
      str = "";
    } 
    return str;
  }
  
  public static String m() {
    String str1 = "";
    try {
      String str = Build.SERIAL;
      str1 = str;
    } catch (Throwable throwable) {}
    String str2 = str1;
    if (str1 == null)
      str2 = ""; 
    return str2;
  }
  
  public static String m(Context paramContext) {
    String str1;
    String str2 = "";
    try {
      str1 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    } catch (Throwable throwable) {
      str1 = str2;
    } 
    str2 = str1;
    if (str1 == null)
      str2 = ""; 
    return str2;
  }
  
  public static String n() {
    String str1 = "";
    try {
      String str = Locale.getDefault().toString();
      str1 = str;
    } catch (Throwable throwable) {}
    String str2 = str1;
    if (str1 == null)
      str2 = ""; 
    return str2;
  }
  
  public static String n(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 'android.permission.BLUETOOTH'
    //   4: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   7: ifeq -> 15
    //   10: ldc ''
    //   12: astore_0
    //   13: aload_0
    //   14: areturn
    //   15: invokestatic z : ()Ljava/lang/String;
    //   18: astore_1
    //   19: aload_1
    //   20: ifnull -> 46
    //   23: aload_1
    //   24: astore_2
    //   25: aload_1
    //   26: invokevirtual length : ()I
    //   29: ifeq -> 46
    //   32: aload_1
    //   33: astore_3
    //   34: aload_1
    //   35: astore_2
    //   36: ldc_w '02:00:00:00:00:00'
    //   39: aload_1
    //   40: invokevirtual equals : (Ljava/lang/Object;)Z
    //   43: ifeq -> 59
    //   46: aload_1
    //   47: astore_2
    //   48: aload_0
    //   49: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   52: ldc_w 'bluetooth_address'
    //   55: invokestatic getString : (Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   58: astore_3
    //   59: aload_3
    //   60: astore_0
    //   61: aload_3
    //   62: ifnonnull -> 13
    //   65: ldc ''
    //   67: astore_0
    //   68: goto -> 13
    //   71: astore_0
    //   72: aload_2
    //   73: astore_0
    //   74: goto -> 13
    // Exception table:
    //   from	to	target	type
    //   25	32	71	java/lang/Throwable
    //   36	46	71	java/lang/Throwable
    //   48	59	71	java/lang/Throwable
  }
  
  public static String o() {
    String str1 = "";
    try {
      String str = TimeZone.getDefault().getDisplayName(false, 0);
      str1 = str;
    } catch (Throwable throwable) {}
    String str2 = str1;
    if (str1 == null)
      str2 = ""; 
    return str2;
  }
  
  public static String o(Context paramContext) {
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (telephonyManager != null) {
        int i = telephonyManager.getNetworkType();
        return String.valueOf(i);
      } 
    } catch (Throwable throwable) {}
    return "";
  }
  
  public static String p() {
    String str;
    try {
      long l = System.currentTimeMillis() - SystemClock.elapsedRealtime();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      str = stringBuilder.append(l - l % 1000L).toString();
    } catch (Throwable throwable) {
      str = "";
    } 
    return str;
  }
  
  public static String p(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 'android.permission.ACCESS_WIFI_STATE'
    //   4: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   7: ifeq -> 15
    //   10: ldc ''
    //   12: astore_1
    //   13: aload_1
    //   14: areturn
    //   15: aload_0
    //   16: ldc_w 'wifi'
    //   19: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   22: checkcast android/net/wifi/WifiManager
    //   25: astore_0
    //   26: aload_0
    //   27: invokevirtual isWifiEnabled : ()Z
    //   30: ifeq -> 54
    //   33: aload_0
    //   34: invokevirtual getConnectionInfo : ()Landroid/net/wifi/WifiInfo;
    //   37: invokevirtual getBSSID : ()Ljava/lang/String;
    //   40: astore_0
    //   41: aload_0
    //   42: astore_1
    //   43: aload_0
    //   44: ifnonnull -> 13
    //   47: ldc ''
    //   49: astore_1
    //   50: goto -> 13
    //   53: astore_0
    //   54: ldc ''
    //   56: astore_0
    //   57: goto -> 41
    // Exception table:
    //   from	to	target	type
    //   15	41	53	java/lang/Throwable
  }
  
  public static String q() {
    String str;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      str = stringBuilder.append(SystemClock.elapsedRealtime()).toString();
    } catch (Throwable throwable) {
      str = "";
    } 
    return str;
  }
  
  public static Map<String, Integer> q(Context paramContext) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    try {
      List list = paramContext.getPackageManager().getInstalledPackages(0);
      if (list != null && list.size() > 0)
        for (PackageInfo packageInfo : list)
          hashMap.put(packageInfo.packageName, Integer.valueOf(packageInfo.applicationInfo.uid));  
    } catch (Throwable throwable) {}
    return (Map)hashMap;
  }
  
  public static String r() {
    byte b1 = 0;
    try {
      StringBuilder stringBuilder1 = new StringBuilder();
      this();
      StringBuilder stringBuilder2 = new StringBuilder();
      this();
      stringBuilder1.append(stringBuilder2.append("00").append(":").toString());
      while (b1 < 7) {
        (new String[7])[0] = "/dev/qemu_pipe";
        (new String[7])[1] = "/dev/socket/qemud";
        (new String[7])[2] = "/system/lib/libc_malloc_debug_qemu.so";
        (new String[7])[3] = "/sys/qemu_trace";
        (new String[7])[4] = "/system/bin/qemu-props";
        (new String[7])[5] = "/dev/socket/genyd";
        (new String[7])[6] = "/dev/socket/baseband_genyd";
        String str = (new String[7])[b1];
        File file = new File();
        this(str);
        if (file.exists()) {
          stringBuilder1.append("1");
        } else {
          stringBuilder1.append("0");
        } 
        b1++;
      } 
    } catch (Throwable throwable) {
      return "";
    } 
    return SYNTHETIC_LOCAL_VARIABLE_1.toString();
  }
  
  public static String r(Context paramContext) {
    String str1;
    String str2 = "";
    try {
      String str3 = u(paramContext);
      String str4 = A();
      str1 = str2;
      if (a.b(str3)) {
        str1 = str2;
        if (a.b(str4)) {
          StringBuilder stringBuilder = new StringBuilder();
          this();
          String str = stringBuilder.append(str3).append(":").append(A()).toString();
        } 
      } 
    } catch (Throwable throwable) {
      str1 = str2;
    } 
    return str1;
  }
  
  public static String s() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("00");
    stringBuilder.append(":");
    for (byte b1 = 0; b1; b1++) {
      (new String[1])[0] = "dalvik.system.Taint";
      String str = (new String[1])[0];
      try {
        Class.forName(str);
        stringBuilder.append("1");
      } catch (Throwable throwable) {
        stringBuilder.append("0");
      } 
    } 
    return stringBuilder.toString();
  }
  
  public static String s(Context paramContext) {
    String str;
    try {
      if (!((KeyguardManager)paramContext.getSystemService("keyguard")).isKeyguardSecure())
        return "0:0"; 
      byte b1 = 0;
      long l = 0L;
      while (true) {
        if (b1 < 5) {
          (new String[5])[0] = "/data/system/password.key";
          (new String[5])[1] = "/data/system/gesture.key";
          (new String[5])[2] = "/data/system/gatekeeper.password.key";
          (new String[5])[3] = "/data/system/gatekeeper.gesture.key";
          (new String[5])[4] = "/data/system/gatekeeper.pattern.key";
          str = (new String[5])[b1];
          long l1 = -1L;
          try {
            File file = new File();
            this(str);
            long l2 = file.lastModified();
            l1 = l2;
          } catch (Throwable throwable) {}
          l = Math.max(l1, l);
          b1++;
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        this("1:");
        return stringBuilder.append(l).toString();
      } 
    } catch (Throwable throwable) {
      str = "";
    } 
    return str;
  }
  
  public static String t() {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_0
    //   8: new java/util/LinkedHashMap
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: astore_1
    //   16: aload_1
    //   17: ldc_w '/system/build.prop'
    //   20: ldc_w 'ro.product.name=sdk'
    //   23: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   28: pop
    //   29: aload_1
    //   30: ldc_w '/proc/tty/drivers'
    //   33: ldc_w 'goldfish'
    //   36: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: aload_1
    //   43: ldc '/proc/cpuinfo'
    //   45: ldc_w 'goldfish'
    //   48: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   53: pop
    //   54: aload_0
    //   55: new java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial <init> : ()V
    //   62: ldc_w '00'
    //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc ':'
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual toString : ()Ljava/lang/String;
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_1
    //   81: invokeinterface keySet : ()Ljava/util/Set;
    //   86: invokeinterface iterator : ()Ljava/util/Iterator;
    //   91: astore_2
    //   92: aload_2
    //   93: invokeinterface hasNext : ()Z
    //   98: ifeq -> 266
    //   101: aload_2
    //   102: invokeinterface next : ()Ljava/lang/Object;
    //   107: checkcast java/lang/String
    //   110: astore_3
    //   111: aconst_null
    //   112: astore #4
    //   114: new java/io/LineNumberReader
    //   117: astore #5
    //   119: new java/io/InputStreamReader
    //   122: astore #6
    //   124: new java/io/FileInputStream
    //   127: astore #7
    //   129: aload #7
    //   131: aload_3
    //   132: invokespecial <init> : (Ljava/lang/String;)V
    //   135: aload #6
    //   137: aload #7
    //   139: invokespecial <init> : (Ljava/io/InputStream;)V
    //   142: aload #5
    //   144: aload #6
    //   146: invokespecial <init> : (Ljava/io/Reader;)V
    //   149: aload #5
    //   151: invokevirtual readLine : ()Ljava/lang/String;
    //   154: astore #4
    //   156: aload #4
    //   158: ifnull -> 291
    //   161: aload #4
    //   163: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   166: aload_1
    //   167: aload_3
    //   168: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   173: checkcast java/lang/CharSequence
    //   176: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   179: istore #8
    //   181: iload #8
    //   183: ifeq -> 149
    //   186: bipush #49
    //   188: istore #9
    //   190: iload #9
    //   192: istore #10
    //   194: aload_0
    //   195: iload #10
    //   197: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload #5
    //   203: invokevirtual close : ()V
    //   206: goto -> 92
    //   209: astore #5
    //   211: goto -> 92
    //   214: astore #5
    //   216: aconst_null
    //   217: astore #5
    //   219: aload_0
    //   220: bipush #48
    //   222: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload #5
    //   228: ifnull -> 92
    //   231: aload #5
    //   233: invokevirtual close : ()V
    //   236: goto -> 92
    //   239: astore #5
    //   241: goto -> 92
    //   244: astore #5
    //   246: aload_0
    //   247: bipush #48
    //   249: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload #4
    //   255: ifnull -> 263
    //   258: aload #4
    //   260: invokevirtual close : ()V
    //   263: aload #5
    //   265: athrow
    //   266: aload_0
    //   267: invokevirtual toString : ()Ljava/lang/String;
    //   270: areturn
    //   271: astore_1
    //   272: goto -> 263
    //   275: astore_1
    //   276: aload #5
    //   278: astore #4
    //   280: aload_1
    //   281: astore #5
    //   283: goto -> 246
    //   286: astore #4
    //   288: goto -> 219
    //   291: bipush #48
    //   293: istore #9
    //   295: iload #9
    //   297: istore #10
    //   299: goto -> 194
    // Exception table:
    //   from	to	target	type
    //   114	149	214	java/lang/Throwable
    //   114	149	244	finally
    //   149	156	286	java/lang/Throwable
    //   149	156	275	finally
    //   161	181	286	java/lang/Throwable
    //   161	181	275	finally
    //   201	206	209	java/lang/Throwable
    //   231	236	239	java/lang/Throwable
    //   258	263	271	java/lang/Throwable
  }
  
  public static String t(Context paramContext) {
    String str;
    try {
      IntentFilter intentFilter = new IntentFilter();
      this("android.intent.action.BATTERY_CHANGED");
      Intent intent = paramContext.registerReceiver(null, intentFilter);
      int i = intent.getIntExtra("level", -1);
      int j = intent.getIntExtra("status", -1);
      if (j == 2 || j == 5) {
        j = 1;
      } else {
        j = 0;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      this();
      if (j != 0) {
        str = "1";
      } else {
        str = "0";
      } 
      str = stringBuilder.append(str).append(":").append(i).toString();
    } catch (Throwable throwable) {
      str = "";
    } 
    return str;
  }
  
  public static String u() {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_0
    //   8: aload_0
    //   9: new java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: ldc_w '00'
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc ':'
    //   24: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual toString : ()Ljava/lang/String;
    //   30: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: new java/util/LinkedHashMap
    //   37: dup
    //   38: invokespecial <init> : ()V
    //   41: astore_1
    //   42: aload_1
    //   43: ldc_w 'BRAND'
    //   46: ldc_w 'generic'
    //   49: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: aload_1
    //   56: ldc_w 'BOARD'
    //   59: ldc_w 'unknown'
    //   62: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   67: pop
    //   68: aload_1
    //   69: ldc_w 'DEVICE'
    //   72: ldc_w 'generic'
    //   75: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   80: pop
    //   81: aload_1
    //   82: ldc_w 'HARDWARE'
    //   85: ldc_w 'goldfish'
    //   88: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   93: pop
    //   94: aload_1
    //   95: ldc_w 'PRODUCT'
    //   98: ldc_w 'sdk'
    //   101: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: aload_1
    //   108: ldc_w 'MODEL'
    //   111: ldc_w 'sdk'
    //   114: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: pop
    //   120: aload_1
    //   121: invokeinterface keySet : ()Ljava/util/Set;
    //   126: invokeinterface iterator : ()Ljava/util/Iterator;
    //   131: astore_2
    //   132: aload_2
    //   133: invokeinterface hasNext : ()Z
    //   138: ifeq -> 250
    //   141: aload_2
    //   142: invokeinterface next : ()Ljava/lang/Object;
    //   147: checkcast java/lang/String
    //   150: astore_3
    //   151: ldc_w android/os/Build
    //   154: aload_3
    //   155: invokevirtual getField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   158: aconst_null
    //   159: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   162: checkcast java/lang/String
    //   165: astore #4
    //   167: aload_1
    //   168: aload_3
    //   169: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   174: checkcast java/lang/String
    //   177: astore_3
    //   178: aload #4
    //   180: ifnull -> 266
    //   183: aload #4
    //   185: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   188: astore #4
    //   190: aload #4
    //   192: ifnull -> 255
    //   195: aload #4
    //   197: aload_3
    //   198: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   201: istore #5
    //   203: iload #5
    //   205: ifeq -> 255
    //   208: bipush #49
    //   210: istore #6
    //   212: iload #6
    //   214: istore #7
    //   216: aload_0
    //   217: iload #7
    //   219: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: goto -> 132
    //   226: astore #4
    //   228: aload_0
    //   229: bipush #48
    //   231: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: goto -> 132
    //   238: astore #4
    //   240: aload_0
    //   241: bipush #48
    //   243: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload #4
    //   249: athrow
    //   250: aload_0
    //   251: invokevirtual toString : ()Ljava/lang/String;
    //   254: areturn
    //   255: bipush #48
    //   257: istore #6
    //   259: iload #6
    //   261: istore #7
    //   263: goto -> 216
    //   266: aconst_null
    //   267: astore #4
    //   269: goto -> 190
    // Exception table:
    //   from	to	target	type
    //   151	178	226	java/lang/Throwable
    //   151	178	238	finally
    //   183	190	226	java/lang/Throwable
    //   183	190	238	finally
    //   195	203	226	java/lang/Throwable
    //   195	203	238	finally
  }
  
  private static String u(Context paramContext) {
    Context context1;
    Context context2 = null;
    if (a(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
      return ""; 
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      paramContext = context2;
      if (networkInfo != null) {
        if (networkInfo.getType() == 1)
          return "WIFI"; 
        if (networkInfo.getType() == 0) {
          int i = networkInfo.getSubtype();
          return (i == 4 || i == 1 || i == 2 || i == 7 || i == 11) ? "2G" : ((i == 3 || i == 5 || i == 6 || i == 8 || i == 9 || i == 10 || i == 12 || i == 14 || i == 15) ? "3G" : ((i == 13) ? "4G" : "UNKNOW"));
        } 
        paramContext = null;
      } 
    } catch (Throwable throwable) {
      context1 = context2;
    } 
    return (String)context1;
  }
  
  public static String v() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("00" + ":");
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
    linkedHashMap.put("ro.hardware", "goldfish");
    linkedHashMap.put("ro.kernel.qemu", "1");
    linkedHashMap.put("ro.product.device", "generic");
    linkedHashMap.put("ro.product.model", "sdk");
    linkedHashMap.put("ro.product.brand", "generic");
    linkedHashMap.put("ro.product.name", "sdk");
    linkedHashMap.put("ro.build.fingerprint", "test-keys");
    linkedHashMap.put("ro.product.manufacturer", "unknow");
    Iterator<String> iterator = linkedHashMap.keySet().iterator();
    while (true) {
      if (iterator.hasNext()) {
        byte b1;
        String str1 = iterator.next();
        String str2 = (String)linkedHashMap.get(str1);
        str1 = a.b(str1, "");
        if (str1 != null && str1.contains(str2)) {
          byte b2 = 49;
          b1 = b2;
        } else {
          byte b2 = 48;
          b1 = b2;
        } 
        stringBuilder.append(b1);
        continue;
      } 
      return stringBuilder.toString();
    } 
  }
  
  private static String w() {
    // Byte code:
    //   0: invokestatic getNetworkInterfaces : ()Ljava/util/Enumeration;
    //   3: invokestatic list : (Ljava/util/Enumeration;)Ljava/util/ArrayList;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull -> 155
    //   11: aload_0
    //   12: invokeinterface iterator : ()Ljava/util/Iterator;
    //   17: astore_0
    //   18: aload_0
    //   19: invokeinterface hasNext : ()Z
    //   24: ifeq -> 155
    //   27: aload_0
    //   28: invokeinterface next : ()Ljava/lang/Object;
    //   33: checkcast java/net/NetworkInterface
    //   36: astore_1
    //   37: aload_1
    //   38: ifnull -> 18
    //   41: aload_1
    //   42: invokevirtual getName : ()Ljava/lang/String;
    //   45: ifnull -> 18
    //   48: aload_1
    //   49: invokevirtual getName : ()Ljava/lang/String;
    //   52: ldc_w 'wlan0'
    //   55: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   58: ifeq -> 18
    //   61: aload_1
    //   62: invokevirtual getHardwareAddress : ()[B
    //   65: astore_1
    //   66: aload_1
    //   67: ifnonnull -> 76
    //   70: ldc_w '02:00:00:00:00:00'
    //   73: astore_0
    //   74: aload_0
    //   75: areturn
    //   76: new java/lang/StringBuilder
    //   79: astore_0
    //   80: aload_0
    //   81: invokespecial <init> : ()V
    //   84: aload_1
    //   85: arraylength
    //   86: istore_2
    //   87: iconst_0
    //   88: istore_3
    //   89: iload_3
    //   90: iload_2
    //   91: if_icmpge -> 128
    //   94: aload_0
    //   95: ldc_w '%02X:'
    //   98: iconst_1
    //   99: anewarray java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: aload_1
    //   105: iload_3
    //   106: baload
    //   107: sipush #255
    //   110: iand
    //   111: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   114: aastore
    //   115: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   118: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: iinc #3, 1
    //   125: goto -> 89
    //   128: aload_0
    //   129: invokevirtual length : ()I
    //   132: ifle -> 146
    //   135: aload_0
    //   136: aload_0
    //   137: invokevirtual length : ()I
    //   140: iconst_1
    //   141: isub
    //   142: invokevirtual deleteCharAt : (I)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_0
    //   147: invokevirtual toString : ()Ljava/lang/String;
    //   150: astore_0
    //   151: goto -> 74
    //   154: astore_0
    //   155: ldc_w '02:00:00:00:00:00'
    //   158: astore_0
    //   159: goto -> 74
    // Exception table:
    //   from	to	target	type
    //   0	7	154	java/lang/Throwable
    //   11	18	154	java/lang/Throwable
    //   18	37	154	java/lang/Throwable
    //   41	66	154	java/lang/Throwable
    //   76	87	154	java/lang/Throwable
    //   94	122	154	java/lang/Throwable
    //   128	146	154	java/lang/Throwable
    //   146	151	154	java/lang/Throwable
  }
  
  private static String x() {
    FileReader fileReader;
    BufferedReader bufferedReader;
    String str = null;
    try {
      FileReader fileReader1 = new FileReader();
      this("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
      try {
        BufferedReader bufferedReader1;
      } catch (Throwable null) {
      
      } finally {
        bufferedReader = null;
        if (bufferedReader != null)
          try {
            bufferedReader.close();
          } catch (Throwable throwable) {} 
        if (fileReader != null)
          try {
            fileReader.close();
          } catch (Throwable null) {} 
      } 
      if (str != null)
        try {
          str.close();
        } catch (Throwable throwable) {} 
    } catch (Throwable null) {
      fileReader = null;
      if (str != null)
        try {
          str.close();
        } catch (Throwable throwable) {} 
    } finally {
      str = null;
      fileReader = null;
    } 
    if (bufferedReader != null)
      try {
        bufferedReader.close();
      } catch (Throwable throwable) {} 
    if (fileReader != null)
      try {
        fileReader.close();
      } catch (Throwable throwable) {} 
    throw str;
  }
  
  private static String y() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: ldc ''
    //   4: astore_1
    //   5: new java/io/FileReader
    //   8: astore_2
    //   9: aload_2
    //   10: ldc '/proc/cpuinfo'
    //   12: invokespecial <init> : (Ljava/lang/String;)V
    //   15: new java/io/BufferedReader
    //   18: astore_3
    //   19: aload_3
    //   20: aload_2
    //   21: sipush #8192
    //   24: invokespecial <init> : (Ljava/io/Reader;I)V
    //   27: aload_3
    //   28: invokevirtual readLine : ()Ljava/lang/String;
    //   31: astore #4
    //   33: aload_1
    //   34: astore_0
    //   35: aload #4
    //   37: ifnull -> 85
    //   40: aload #4
    //   42: invokestatic a : (Ljava/lang/String;)Z
    //   45: ifne -> 27
    //   48: aload #4
    //   50: ldc ':'
    //   52: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   55: astore_0
    //   56: aload_0
    //   57: ifnull -> 27
    //   60: aload_0
    //   61: arraylength
    //   62: iconst_1
    //   63: if_icmple -> 27
    //   66: aload_0
    //   67: iconst_0
    //   68: aaload
    //   69: ldc_w 'BogoMIPS'
    //   72: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   75: ifeq -> 27
    //   78: aload_0
    //   79: iconst_1
    //   80: aaload
    //   81: invokevirtual trim : ()Ljava/lang/String;
    //   84: astore_0
    //   85: aload_2
    //   86: invokevirtual close : ()V
    //   89: aload_3
    //   90: invokevirtual close : ()V
    //   93: aload_0
    //   94: areturn
    //   95: astore_2
    //   96: aconst_null
    //   97: astore_2
    //   98: aload_0
    //   99: ifnull -> 106
    //   102: aload_0
    //   103: invokevirtual close : ()V
    //   106: aload_1
    //   107: astore_0
    //   108: aload_2
    //   109: ifnull -> 93
    //   112: aload_2
    //   113: invokevirtual close : ()V
    //   116: aload_1
    //   117: astore_0
    //   118: goto -> 93
    //   121: astore_2
    //   122: aload_1
    //   123: astore_0
    //   124: goto -> 93
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_1
    //   130: aconst_null
    //   131: astore_2
    //   132: aload_2
    //   133: ifnull -> 140
    //   136: aload_2
    //   137: invokevirtual close : ()V
    //   140: aload_1
    //   141: ifnull -> 148
    //   144: aload_1
    //   145: invokevirtual close : ()V
    //   148: aload_0
    //   149: athrow
    //   150: astore_2
    //   151: goto -> 89
    //   154: astore_2
    //   155: goto -> 93
    //   158: astore_0
    //   159: goto -> 106
    //   162: astore_2
    //   163: goto -> 140
    //   166: astore_2
    //   167: goto -> 148
    //   170: astore_0
    //   171: aconst_null
    //   172: astore_1
    //   173: goto -> 132
    //   176: astore_0
    //   177: aload_3
    //   178: astore_1
    //   179: goto -> 132
    //   182: astore_0
    //   183: aconst_null
    //   184: astore_3
    //   185: aload_2
    //   186: astore_0
    //   187: aload_3
    //   188: astore_2
    //   189: goto -> 98
    //   192: astore_0
    //   193: aload_2
    //   194: astore_0
    //   195: aload_3
    //   196: astore_2
    //   197: goto -> 98
    // Exception table:
    //   from	to	target	type
    //   5	15	95	java/lang/Throwable
    //   5	15	127	finally
    //   15	27	182	java/lang/Throwable
    //   15	27	170	finally
    //   27	33	192	java/lang/Throwable
    //   27	33	176	finally
    //   40	56	192	java/lang/Throwable
    //   40	56	176	finally
    //   60	85	192	java/lang/Throwable
    //   60	85	176	finally
    //   85	89	150	java/lang/Throwable
    //   89	93	154	java/lang/Throwable
    //   102	106	158	java/lang/Throwable
    //   112	116	121	java/lang/Throwable
    //   136	140	162	java/lang/Throwable
    //   144	148	166	java/lang/Throwable
  }
  
  private static String z() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: invokestatic getDefaultAdapter : ()Landroid/bluetooth/BluetoothAdapter;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnull -> 24
    //   10: aload_1
    //   11: astore_0
    //   12: aload_1
    //   13: invokevirtual isEnabled : ()Z
    //   16: ifne -> 24
    //   19: ldc ''
    //   21: astore_0
    //   22: aload_0
    //   23: areturn
    //   24: aload_1
    //   25: astore_0
    //   26: aload_1
    //   27: invokevirtual getAddress : ()Ljava/lang/String;
    //   30: astore_2
    //   31: aload_2
    //   32: astore_0
    //   33: aload_1
    //   34: astore_2
    //   35: aload_0
    //   36: ifnull -> 51
    //   39: aload_0
    //   40: astore_1
    //   41: aload_0
    //   42: ldc_w '00:00:00:00:00'
    //   45: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   48: ifeq -> 56
    //   51: aload_2
    //   52: invokestatic a : (Landroid/bluetooth/BluetoothAdapter;)Ljava/lang/String;
    //   55: astore_1
    //   56: aload_1
    //   57: astore_0
    //   58: aload_1
    //   59: ifnonnull -> 22
    //   62: ldc ''
    //   64: astore_0
    //   65: goto -> 22
    //   68: astore_1
    //   69: ldc ''
    //   71: astore_1
    //   72: aload_0
    //   73: astore_2
    //   74: aload_1
    //   75: astore_0
    //   76: goto -> 35
    //   79: astore_1
    //   80: aload_0
    //   81: astore_1
    //   82: goto -> 56
    // Exception table:
    //   from	to	target	type
    //   2	6	68	java/lang/Throwable
    //   12	19	68	java/lang/Throwable
    //   26	31	68	java/lang/Throwable
    //   51	56	79	java/lang/Throwable
  }
  
  public final String f() {
    String str;
    try {
      File file = new File();
      this("/sys/devices/system/cpu/");
      c c = new c();
      this(this);
      int i = (file.listFiles(c)).length;
      str = String.valueOf(i);
    } catch (Throwable throwable) {
      str = "1";
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\security\mobile\module\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */