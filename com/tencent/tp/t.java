package com.tencent.tp;

import android.content.Context;
import android.os.Looper;
import java.io.File;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

class t {
  private static final String a = "is_enabled2:";
  
  public static int a(String paramString) {
    if (paramString == null)
      return -1; 
    if (paramString.compareTo("initialize") == 0) {
      TssSdkRuntime.initialize2();
    } else if (paramString.startsWith("mt:")) {
      MainThreadDispatcher2.SendCmd(paramString.substring(3));
    } else if (paramString.startsWith("tpgbox_ld:")) {
      e(paramString.substring(10));
    } else if (paramString.startsWith("inf_cl:")) {
      d(paramString.substring(7));
    } else if (paramString.startsWith("getopenid")) {
      b();
    } else if (paramString.startsWith("getapk")) {
      c();
    } else {
      StringBuilder stringBuilder;
      if (paramString.compareTo("get_network") == 0) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("net_type:");
        stringBuilder.append(TssSdkRuntime.getNetWorkType());
      } else {
        if (stringBuilder.startsWith("is_enabled2:"))
          return 0; 
        if (stringBuilder.startsWith("get_device_id")) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("imei:");
          stringBuilder.append(k.a().a(TssSdkRuntime.getAppContext()));
        } else {
          if (stringBuilder.startsWith("is_main_looper")) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
              str = "IsMainThread";
            } else {
              return 0;
            } 
          } else {
            if (str.startsWith("msgbox:") || str.startsWith("hide_msgbox:")) {
              g.a().a(str);
              return 0;
            } 
            if (!str.startsWith("dl_file:"))
              if (str.startsWith("update_adb_enabled_over_usb:")) {
                f(str);
              } else if (str.startsWith("exec|")) {
                b(str);
              } else {
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("*#07#:");
                stringBuilder1.append(str);
                str = stringBuilder1.toString();
                u.a(str);
              }  
            return 0;
          } 
          u.a(str);
        } 
      } 
      String str = str.toString();
      u.a(str);
    } 
    return 0;
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder();
    int i = paramArrayOfbyte.length;
    for (byte b = 0; b < i; b++) {
      stringBuilder.append(String.format("%02x", new Object[] { Integer.valueOf(paramArrayOfbyte[b] & 0xFF) }));
    } 
    return stringBuilder.toString();
  }
  
  private static boolean a() {
    try {
      Object object = j.a("com.tencent.msdk.login.LoginManager", "getInstance", new Class[0], new Object[0]);
      if (object == null)
        return false; 
      String str = (String)j.a("com.tencent.msdk.login.LoginManager", "getCurrentOpenid", object, new Class[0], new Object[0]);
      if (str == null)
        return false; 
      object = new StringBuilder();
      super();
      object.append("open_id_msdk:");
      object.append(str);
      u.a(object.toString());
      return true;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("open_id_msdk:");
      stringBuilder.append(exception.toString());
      u.a(stringBuilder.toString());
      return false;
    } 
  }
  
  private static void b() {
    if (!a())
      u.a("open_id_msdk:openId == null"); 
  }
  
  private static void b(String paramString) {
    if (!paramString.startsWith("exec|"))
      return; 
    String[] arrayOfString1 = paramString.split("\\|");
    if (arrayOfString1.length < 3)
      return; 
    String[] arrayOfString2 = new String[arrayOfString1.length - 1];
    for (int i = 0; i < arrayOfString1.length - 1; i = j) {
      int j = i + 1;
      arrayOfString2[i] = arrayOfString1[j];
    } 
    try {
      Runtime.getRuntime().exec(arrayOfString2);
    } catch (Exception exception) {}
  }
  
  private static void c() {
    Context context = TssSdkRuntime.getAppContext();
    if (context == null)
      return; 
    (new p(context)).execute((Object[])new Void[0]);
  }
  
  private static boolean c(String paramString) {
    if (u.c() == 1)
      return true; 
    try {
      JarFile jarFile = new JarFile(paramString, true);
      try {
        byte[] arrayOfByte = new byte[16384];
        paramString = null;
        Enumeration<JarEntry> enumeration = jarFile.entries();
        while (true) {
          if (enumeration.hasMoreElements()) {
            JarEntry jarEntry = enumeration.nextElement();
            try {
            
            } catch (Throwable throwable1) {
            
            } finally {
              String str = paramString;
              if (str != null)
                try {
                  str.close();
                } catch (Throwable null) {
                  return false;
                }  
            } 
            if (throwable != null)
              try {
                throwable.close();
              } catch (Throwable throwable1) {
                return false;
              }  
            try {
              jarFile.close();
            } catch (Throwable throwable1) {}
          } 
          return true;
        } 
      } finally {
        try {
          jarFile.close();
        } catch (Throwable throwable) {}
      } 
    } catch (Throwable throwable) {
      return false;
    } 
  }
  
  private static void d(String paramString) {
    boolean bool2;
    boolean bool3;
    boolean bool4;
    String[] arrayOfString = paramString.split("\\|");
    if (arrayOfString.length < 3)
      return; 
    boolean bool1 = false;
    if (arrayOfString[0].compareTo("1") == 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (arrayOfString[1].compareTo("1") == 0) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (arrayOfString[2].compareTo("1") == 0) {
      bool4 = true;
    } else {
      bool4 = false;
    } 
    boolean bool5 = bool1;
    if (arrayOfString.length >= 4) {
      bool5 = bool1;
      if (arrayOfString[3].compareTo("1") == 0)
        bool5 = true; 
    } 
    TssSdkSafeScan.scan(bool2, bool3, bool4, bool5);
  }
  
  private static void e(String paramString) {
    String[] arrayOfString = paramString.split("\\|");
    if (arrayOfString.length >= 3 && arrayOfString[0].endsWith(".jar")) {
      String str2 = arrayOfString[0];
      String str3 = arrayOfString[1];
      String str1 = arrayOfString[2];
      String str4 = (TssSdkRuntime.getPackageInfo()).applicationInfo.dataDir;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str4);
      stringBuilder1.append("/files/");
      stringBuilder1.append(str2);
      File file = new File(stringBuilder1.toString());
      if (file.exists() != true)
        return; 
      if (c(file.getAbsolutePath()) != true)
        return; 
      c.a(file.getAbsolutePath(), null);
      if (str3.length() > 1)
        try {
          Class clazz = c.a(str3);
          j.a(clazz, "setPluginInfos", clazz.newInstance(), new Class[] { String.class }, new Object[] { str1 });
        } catch (Exception exception) {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("*#06#:");
          stringBuilder2.append(exception.toString());
          u.a(stringBuilder2.toString());
        }  
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("*#06#:");
    stringBuilder.append(paramString);
    u.a(stringBuilder.toString());
  }
  
  private static void f(String paramString) {
    String str;
    boolean bool;
    Context context = TssSdkRuntime.getAppContext();
    if (context != null) {
      bool = TssSdkRuntime.getAdbEnabledOverUsb(context);
    } else {
      bool = false;
    } 
    if (bool) {
      str = "1";
    } else {
      str = "0";
    } 
    u.a(String.format("update_adb_enabled_over_usb:%s:0:0", new Object[] { str }));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */