package com.xy.whf.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.Properties;

@SuppressLint({"PrivateApi"})
public class DeviceHelper {
  private static final String[] a;
  
  private static String b;
  
  private static String c;
  
  private static boolean d;
  
  private static boolean e;
  
  static {
    // Byte code:
    //   0: iconst_4
    //   1: anewarray java/lang/String
    //   4: dup
    //   5: iconst_0
    //   6: ldc 'm9'
    //   8: aastore
    //   9: dup
    //   10: iconst_1
    //   11: ldc 'M9'
    //   13: aastore
    //   14: dup
    //   15: iconst_2
    //   16: ldc 'mx'
    //   18: aastore
    //   19: dup
    //   20: iconst_3
    //   21: ldc 'MX'
    //   23: aastore
    //   24: putstatic com/xy/whf/helper/DeviceHelper.a : [Ljava/lang/String;
    //   27: iconst_0
    //   28: putstatic com/xy/whf/helper/DeviceHelper.d : Z
    //   31: iconst_0
    //   32: putstatic com/xy/whf/helper/DeviceHelper.e : Z
    //   35: new java/util/Properties
    //   38: dup
    //   39: invokespecial <init> : ()V
    //   42: astore_0
    //   43: getstatic android/os/Build$VERSION.SDK_INT : I
    //   46: bipush #26
    //   48: if_icmpge -> 88
    //   51: new java/io/FileInputStream
    //   54: astore_1
    //   55: new java/io/File
    //   58: astore_2
    //   59: aload_2
    //   60: invokestatic getRootDirectory : ()Ljava/io/File;
    //   63: ldc 'build.prop'
    //   65: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   68: aload_1
    //   69: aload_2
    //   70: invokespecial <init> : (Ljava/io/File;)V
    //   73: aload_1
    //   74: astore_2
    //   75: aload_0
    //   76: aload_1
    //   77: invokevirtual load : (Ljava/io/InputStream;)V
    //   80: aload_1
    //   81: ifnull -> 88
    //   84: aload_1
    //   85: invokevirtual close : ()V
    //   88: ldc 'android.os.SystemProperties'
    //   90: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   93: ldc 'get'
    //   95: iconst_1
    //   96: anewarray java/lang/Class
    //   99: dup
    //   100: iconst_0
    //   101: ldc java/lang/String
    //   103: aastore
    //   104: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   107: astore_2
    //   108: aload_0
    //   109: aload_2
    //   110: ldc 'ro.miui.ui.version.name'
    //   112: invokestatic a : (Ljava/util/Properties;Ljava/lang/reflect/Method;Ljava/lang/String;)Ljava/lang/String;
    //   115: putstatic com/xy/whf/helper/DeviceHelper.b : Ljava/lang/String;
    //   118: aload_0
    //   119: aload_2
    //   120: ldc 'ro.build.display.id'
    //   122: invokestatic a : (Ljava/util/Properties;Ljava/lang/reflect/Method;Ljava/lang/String;)Ljava/lang/String;
    //   125: putstatic com/xy/whf/helper/DeviceHelper.c : Ljava/lang/String;
    //   128: return
    //   129: astore_2
    //   130: aload_2
    //   131: invokevirtual printStackTrace : ()V
    //   134: goto -> 88
    //   137: astore_3
    //   138: aconst_null
    //   139: astore_1
    //   140: aload_1
    //   141: astore_2
    //   142: new java/lang/StringBuilder
    //   145: astore #4
    //   147: aload_1
    //   148: astore_2
    //   149: aload #4
    //   151: invokespecial <init> : ()V
    //   154: aload_1
    //   155: astore_2
    //   156: aload #4
    //   158: ldc 'read file error:'
    //   160: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_3
    //   164: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   167: invokevirtual toString : ()Ljava/lang/String;
    //   170: invokestatic b : (Ljava/lang/String;)V
    //   173: aload_1
    //   174: ifnull -> 88
    //   177: aload_1
    //   178: invokevirtual close : ()V
    //   181: goto -> 88
    //   184: astore_2
    //   185: aload_2
    //   186: invokevirtual printStackTrace : ()V
    //   189: goto -> 88
    //   192: astore_1
    //   193: aconst_null
    //   194: astore_2
    //   195: aload_2
    //   196: ifnull -> 203
    //   199: aload_2
    //   200: invokevirtual close : ()V
    //   203: aload_1
    //   204: athrow
    //   205: astore_2
    //   206: aload_2
    //   207: invokevirtual printStackTrace : ()V
    //   210: goto -> 203
    //   213: astore_2
    //   214: new java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial <init> : ()V
    //   221: ldc 'read SystemProperties error:'
    //   223: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_2
    //   227: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   230: invokevirtual toString : ()Ljava/lang/String;
    //   233: invokestatic b : (Ljava/lang/String;)V
    //   236: goto -> 128
    //   239: astore_1
    //   240: goto -> 195
    //   243: astore_3
    //   244: goto -> 140
    // Exception table:
    //   from	to	target	type
    //   51	73	137	java/lang/Exception
    //   51	73	192	finally
    //   75	80	243	java/lang/Exception
    //   75	80	239	finally
    //   84	88	129	java/lang/Exception
    //   88	128	213	java/lang/Exception
    //   142	147	239	finally
    //   149	154	239	finally
    //   156	173	239	finally
    //   177	181	184	java/lang/Exception
    //   199	203	205	java/lang/Exception
  }
  
  @Nullable
  private static String a(Properties paramProperties, Method paramMethod, String paramString) {
    String str1 = paramProperties.getProperty(paramString);
    if (str1 == null)
      try {
        String str = (String)paramMethod.invoke(null, new Object[] { paramString });
        str1 = str;
      } catch (Exception exception) {} 
    String str2 = str1;
    if (str1 != null)
      str2 = str1.toLowerCase(); 
    return str2;
  }
  
  static boolean a() {
    return !TextUtils.isEmpty(b);
  }
  
  private static boolean a(Context paramContext) {
    return (((paramContext.getResources().getConfiguration()).screenLayout & 0xF) >= 3);
  }
  
  private static boolean a(String[] paramArrayOfString) {
    boolean bool = false;
    String str = Build.BOARD;
    if (str == null)
      return bool; 
    int i = paramArrayOfString.length;
    byte b = 0;
    while (true) {
      boolean bool1 = bool;
      if (b < i) {
        if (str.equals(paramArrayOfString[b]))
          return true; 
        b++;
        continue;
      } 
      return bool1;
    } 
  }
  
  static boolean b() {
    return "v5".equals(b);
  }
  
  static boolean c() {
    return "v6".equals(b);
  }
  
  public static boolean isFlyme() {
    return (!TextUtils.isEmpty(c) && c.contains("flyme"));
  }
  
  public static boolean isMIUIV7() {
    return "v7".equals(b);
  }
  
  public static boolean isMIUIV8() {
    return "v8".equals(b);
  }
  
  public static boolean isMIUIV9() {
    return "v9".equals(b);
  }
  
  public static boolean isMeizu() {
    return (a(a) || isFlyme());
  }
  
  public static boolean isTablet(Context paramContext) {
    if (d)
      return e; 
    e = a(paramContext);
    d = true;
    return e;
  }
  
  public static boolean isXiaomi() {
    return "xiaomi".equals(Build.MANUFACTURER.toLowerCase());
  }
  
  public static boolean isZTKC2016() {
    String str = Build.MODEL;
    return (str != null && str.toLowerCase().contains("zte c2016"));
  }
  
  public static boolean isZUKZ1() {
    String str = Build.MODEL;
    return (str != null && str.toLowerCase().contains("zuk z1"));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\helper\DeviceHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */