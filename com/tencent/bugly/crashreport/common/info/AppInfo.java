package com.tencent.bugly.crashreport.common.info;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class AppInfo {
  private static ActivityManager a;
  
  static {
    "@buglyAllChannel@".split(",");
    "@buglyAllChannelPriority@".split(",");
  }
  
  public static String a(int paramInt) {
    char[] arrayOfChar4;
    char[] arrayOfChar1 = null;
    char[] arrayOfChar2 = null;
    char[] arrayOfChar3 = arrayOfChar2;
    try {
      FileReader fileReader = new FileReader();
      arrayOfChar3 = arrayOfChar2;
      StringBuilder stringBuilder = new StringBuilder();
      arrayOfChar3 = arrayOfChar2;
      this("/proc/");
      arrayOfChar3 = arrayOfChar2;
      stringBuilder.append(paramInt);
      arrayOfChar3 = arrayOfChar2;
      stringBuilder.append("/cmdline");
      arrayOfChar3 = arrayOfChar2;
      this(stringBuilder.toString());
      try {
        arrayOfChar2 = new char[512];
        fileReader.read(arrayOfChar2);
        byte b;
        for (b = 0; b < arrayOfChar2.length && arrayOfChar2[b] != '\000'; b++);
        String str = new String();
        this(arrayOfChar2);
        str = str.substring(0, b);
      } catch (Throwable throwable2) {
      
      } finally {
        Throwable throwable;
        arrayOfChar2 = null;
      } 
    } catch (Throwable throwable) {
      arrayOfChar4 = arrayOfChar1;
    } finally {}
    arrayOfChar3 = arrayOfChar4;
    if (!x.a((Throwable)arrayOfChar2)) {
      arrayOfChar3 = arrayOfChar4;
      arrayOfChar2.printStackTrace();
    } 
    if (arrayOfChar4 != null)
      try {
        arrayOfChar4.close();
      } catch (Throwable throwable) {} 
    return String.valueOf(paramInt);
  }
  
  public static String a(Context paramContext) {
    if (paramContext == null)
      return null; 
    try {
      return paramContext.getPackageName();
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return "fail";
    } 
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder();
    if (paramArrayOfbyte != null && paramArrayOfbyte.length > 0)
      try {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        if (certificateFactory == null)
          return null; 
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream();
        this(paramArrayOfbyte);
        X509Certificate x509Certificate = (X509Certificate)certificateFactory.generateCertificate(byteArrayInputStream);
        if (x509Certificate == null)
          return null; 
        stringBuilder.append("Issuer|");
        Principal principal = x509Certificate.getIssuerDN();
        if (principal != null) {
          stringBuilder.append(principal.toString());
        } else {
          stringBuilder.append("unknown");
        } 
        stringBuilder.append("\n");
        stringBuilder.append("SerialNumber|");
        BigInteger bigInteger = x509Certificate.getSerialNumber();
        if (principal != null) {
          stringBuilder.append(bigInteger.toString(16));
        } else {
          stringBuilder.append("unknown");
        } 
        stringBuilder.append("\n");
        stringBuilder.append("NotBefore|");
        Date date = x509Certificate.getNotBefore();
        if (principal != null) {
          stringBuilder.append(date.toString());
        } else {
          stringBuilder.append("unknown");
        } 
        stringBuilder.append("\n");
        stringBuilder.append("NotAfter|");
        date = x509Certificate.getNotAfter();
        if (principal != null) {
          stringBuilder.append(date.toString());
        } else {
          stringBuilder.append("unknown");
        } 
        stringBuilder.append("\n");
        stringBuilder.append("SHA1|");
        String str2 = z.a(MessageDigest.getInstance("SHA1").digest(x509Certificate.getEncoded()));
        if (str2 != null && str2.length() > 0) {
          stringBuilder.append(str2.toString());
        } else {
          stringBuilder.append("unknown");
        } 
        stringBuilder.append("\n");
        stringBuilder.append("MD5|");
        String str1 = z.a(MessageDigest.getInstance("MD5").digest(x509Certificate.getEncoded()));
        if (str1 != null && str1.length() > 0) {
          stringBuilder.append(str1.toString());
        } else {
          stringBuilder.append("unknown");
        } 
      } catch (CertificateException certificateException) {
        if (!x.a(certificateException))
          certificateException.printStackTrace(); 
      } catch (Throwable throwable) {
        if (!x.a(throwable))
          throwable.printStackTrace(); 
      }  
    return (stringBuilder.length() == 0) ? "unknown" : stringBuilder.toString();
  }
  
  public static List<String> a(Map<String, String> paramMap) {
    if (paramMap == null)
      return null; 
    try {
      String str = paramMap.get("BUGLY_DISABLE");
      if (str == null || str.length() == 0)
        return null; 
      String[] arrayOfString = str.split(",");
      for (byte b = 0; b < arrayOfString.length; b++)
        arrayOfString[b] = arrayOfString[b].trim(); 
      return Arrays.asList(arrayOfString);
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  public static boolean a(Context paramContext, String paramString) {
    if (paramContext == null || paramString == null || paramString.trim().length() <= 0)
      return false; 
    try {
      String[] arrayOfString = (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096)).requestedPermissions;
      if (arrayOfString != null) {
        int i = arrayOfString.length;
        for (byte b = 0; b < i; b++) {
          boolean bool = paramString.equals(arrayOfString[b]);
          if (bool)
            return true; 
        } 
      } 
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
    } 
    return false;
  }
  
  public static PackageInfo b(Context paramContext) {
    try {
      String str = a(paramContext);
      return paramContext.getPackageManager().getPackageInfo(str, 0);
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  public static String c(Context paramContext) {
    if (paramContext == null)
      return null; 
    try {
      PackageManager packageManager = paramContext.getPackageManager();
      ApplicationInfo applicationInfo = paramContext.getApplicationInfo();
      if (packageManager != null && applicationInfo != null) {
        CharSequence charSequence = packageManager.getApplicationLabel(applicationInfo);
        if (charSequence != null)
          return charSequence.toString(); 
      } 
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
    } 
    return null;
  }
  
  public static Map<String, String> d(Context paramContext) {
    Context context = null;
    if (paramContext == null)
      return null; 
    try {
      HashMap<Object, Object> hashMap;
      ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      paramContext = context;
      if (applicationInfo.metaData != null) {
        hashMap = new HashMap<Object, Object>();
        this();
        Object object = applicationInfo.metaData.get("BUGLY_DISABLE");
        if (object != null)
          hashMap.put("BUGLY_DISABLE", object.toString()); 
        object = applicationInfo.metaData.get("BUGLY_APPID");
        if (object != null)
          hashMap.put("BUGLY_APPID", object.toString()); 
        object = applicationInfo.metaData.get("BUGLY_APP_CHANNEL");
        if (object != null)
          hashMap.put("BUGLY_APP_CHANNEL", object.toString()); 
        object = applicationInfo.metaData.get("BUGLY_APP_VERSION");
        if (object != null)
          hashMap.put("BUGLY_APP_VERSION", object.toString()); 
        object = applicationInfo.metaData.get("BUGLY_ENABLE_DEBUG");
        if (object != null)
          hashMap.put("BUGLY_ENABLE_DEBUG", object.toString()); 
        object = applicationInfo.metaData.get("com.tencent.rdm.uuid");
        if (object != null)
          hashMap.put("com.tencent.rdm.uuid", object.toString()); 
      } 
      return (Map)hashMap;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  public static String e(Context paramContext) {
    String str = a(paramContext);
    if (str == null)
      return null; 
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(str, 64);
      if (packageInfo == null)
        return null; 
      Signature[] arrayOfSignature = packageInfo.signatures;
      return (arrayOfSignature == null || arrayOfSignature.length == 0) ? null : a(packageInfo.signatures[0].toByteArray());
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
  
  public static boolean f(Context paramContext) {
    if (paramContext == null)
      return false; 
    if (a == null)
      a = (ActivityManager)paramContext.getSystemService("activity"); 
    try {
      ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
      this();
      a.getMemoryInfo(memoryInfo);
      if (memoryInfo.lowMemory) {
        x.c("Memory is low.", new Object[0]);
        return true;
      } 
      return false;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return false;
    } 
  }
  
  public static String g(Context paramContext) {
    if (paramContext == null)
      return ""; 
    String str = h(paramContext);
    return !z.a(str) ? str : i(paramContext);
  }
  
  private static String h(Context paramContext) {
    Exception exception3;
    String str = "";
    SharedPreferences sharedPreferences = z.a("DENGTA_META", paramContext);
    Exception exception2 = null;
    Properties properties1 = null;
    Properties properties2 = properties1;
    try {
      String str2 = sharedPreferences.getString("key_channelpath", "");
      String str1 = str2;
      properties2 = properties1;
      if (z.a(str2))
        str1 = "channel.ini"; 
      properties2 = properties1;
      StringBuilder stringBuilder = new StringBuilder();
      properties2 = properties1;
      this("[AppInfo] Beacon channel file path: ");
      properties2 = properties1;
      stringBuilder.append(str1);
      properties2 = properties1;
      x.a(stringBuilder.toString(), new Object[0]);
      properties2 = properties1;
      if (!str1.equals("")) {
        String str3;
        Exception exception;
        properties2 = properties1;
        InputStream inputStream = paramContext.getAssets().open(str1);
        try {
          properties2 = new Properties();
          this();
          properties2.load(inputStream);
        } catch (Exception exception4) {
          String str5 = str3;
        } finally {
          exception1 = null;
          Exception exception4 = exception;
        } 
      } else {
        paramContext = null;
      } 
      exception3 = exception1;
    } catch (Exception exception) {
      exception = exception1;
      exception1 = exception2;
      exception3 = exception1;
      x.d("[AppInfo] Failed to get get beacon channel", new Object[0]);
      exception3 = exception;
    } finally {
      if (exception3 != null)
        try {
          exception3.close();
        } catch (IOException iOException) {
          x.a(iOException);
        }  
    } 
    return (String)exception3;
  }
  
  private static String i(Context paramContext) {
    String str1;
    String str2 = "";
    try {
      Object object = (paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128)).metaData.get("CHANNEL_DENGTA");
      str1 = str2;
      if (object != null)
        str1 = object.toString(); 
    } catch (Throwable throwable) {
      x.d("[AppInfo] Failed to read beacon channel from manifest.", new Object[0]);
      x.a(throwable);
      str1 = str2;
    } 
    return str1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\crashreport\common\info\AppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */