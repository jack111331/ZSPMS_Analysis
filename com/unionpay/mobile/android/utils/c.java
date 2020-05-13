package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
  private static String a = "[{\"type\":\"app\",\"sort\":100,\"package_info\":[{\"schema\":\"com.unionpay.uppay\",\"version\":\".*\",\"sign\":\"23137B5BE6AEF6682B41E6536F08367E0949A1CC\",\"sort\":101}],\"need_install\":true,\"install_msg\":\"�Ƿ����ذ�װ��������֧������\",\"url\":\"https://mobile.unionpay.com/getclient?platform=android&type=securepayplugin\",\"download_app\":\"UPPayPluginEx.apk\",\"download_title\":\"��������֧������\",\"download_desp\":\"��������֧������\",\"md5\":\"D75BB2802E61738A9A03BF014F927D9A\"},{\"type\":\"jar\",\"sort\":200}]";
  
  private static SimpleDateFormat b = new SimpleDateFormat("yyyyMMddhhmmss");
  
  private static HashMap<String, String> c = new d();
  
  private static long[] d = new long[256];
  
  static {
    for (byte b = 0; b < 'Ā'; b++) {
      long l = b;
      for (byte b1 = 0; b1 < 8; b1++) {
        long l1;
        if (((int)l & 0x1) != 0) {
          l1 = -7661587058870466123L;
        } else {
          l1 = 0L;
        } 
        l = l >> 1L ^ l1;
      } 
      d[b] = l;
    } 
  }
  
  public static String a() {
    return b.format(new Date(System.currentTimeMillis()));
  }
  
  public static String a(Context paramContext) {
    String str2 = "";
    String str3 = PreferenceUtils.a(paramContext, "configs");
    String str4 = PreferenceUtils.a(paramContext, "mode");
    String str5 = PreferenceUtils.a(paramContext, "or");
    String str1 = str2;
    if (!TextUtils.isEmpty(str3)) {
      str1 = str2;
      if (!TextUtils.isEmpty(str4)) {
        str1 = str2;
        if (!TextUtils.isEmpty(str5))
          try {
            boolean bool;
            JSONObject jSONObject = new JSONObject();
            this(str3);
            str3 = j.a(jSONObject, "sign");
            try {
              bool = Integer.parseInt(str4);
            } catch (NumberFormatException numberFormatException) {
              bool = false;
            } 
            str1 = new String();
            this(Base64.decode(jSONObject.getString("configs"), 2));
            StringBuilder stringBuilder = new StringBuilder();
            this();
            str5 = b(f(stringBuilder.append(str1).append(str5).toString()));
            boolean bool1 = PreferenceUtils.forConfig(bool, str3).equals(str5);
            if (!bool1)
              str1 = ""; 
          } catch (JSONException jSONException) {
            str1 = str2;
          }  
      } 
    } 
    try {
      JSONArray jSONArray = new JSONArray();
      this(str1);
      int i = jSONArray.length();
      for (byte b = 0; b < i; b++) {
        Object object = j.b(jSONArray, b);
        if (object != null) {
          object = object;
          if ("app".equals(j.a((JSONObject)object, "type")))
            return new String(Base64.decode(j.a((JSONObject)object, "ca"), 2)); 
        } 
      } 
    } catch (JSONException jSONException) {
      str1 = "";
    } 
    return str1;
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
    for (byte b = 0; b < paramArrayOfbyte.length; b++) {
      String str1 = Integer.toHexString(paramArrayOfbyte[b]);
      int i = str1.length();
      String str2 = str1;
      if (i == 1)
        str2 = "0" + str1; 
      str1 = str2;
      if (i > 2)
        str1 = str2.substring(i - 2, i); 
      stringBuilder.append(str1.toUpperCase());
      if (b < paramArrayOfbyte.length - 1)
        stringBuilder.append(':'); 
    } 
    return stringBuilder.toString();
  }
  
  public static boolean a(Context paramContext, String paramString) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (!TextUtils.isEmpty(paramString))
      try {
        paramContext.getPackageManager().getPackageInfo(paramString, 0);
        bool2 = true;
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        bool2 = bool1;
      } catch (RuntimeException runtimeException) {
        bool2 = bool1;
      }  
    return bool2;
  }
  
  public static boolean a(String paramString) {
    return paramString.matches("[0-9A-Fa-f]+");
  }
  
  public static String b(Context paramContext) {
    String str = f.b(paramContext);
    str = c.get(str);
    if (TextUtils.isEmpty(str))
      str = "1000"; 
    return str;
  }
  
  public static String b(Context paramContext, String paramString) {
    NoSuchAlgorithmException noSuchAlgorithmException = null;
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      PackageInfo packageInfo = packageManager.getPackageInfo(paramString, 64);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException.printStackTrace();
      nameNotFoundException = null;
    } 
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(((PackageInfo)nameNotFoundException).signatures[0].toByteArray());
    try {
      CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");
    } catch (CertificateException null) {
      certificateException.printStackTrace();
      certificateException = null;
    } 
    try {
      X509Certificate x509Certificate = (X509Certificate)certificateException.generateCertificate(byteArrayInputStream);
    } catch (CertificateException certificateException) {
      certificateException.printStackTrace();
      certificateException = null;
    } 
    try {
      String str = a(MessageDigest.getInstance("SHA1").digest(certificateException.getEncoded()));
    } catch (NoSuchAlgorithmException noSuchAlgorithmException1) {
      noSuchAlgorithmException1.printStackTrace();
      noSuchAlgorithmException1 = noSuchAlgorithmException;
    } catch (CertificateEncodingException certificateEncodingException) {
      certificateEncodingException.printStackTrace();
      NoSuchAlgorithmException noSuchAlgorithmException1 = noSuchAlgorithmException;
    } 
  }
  
  public static String b(String paramString) {
    char[] arrayOfChar = "0123456789ABCDEF".toCharArray();
    StringBuilder stringBuilder = new StringBuilder("");
    for (byte b : paramString.getBytes()) {
      stringBuilder.append(arrayOfChar[(b & 0xF0) >> 4]);
      stringBuilder.append(arrayOfChar[b & 0xF]);
    } 
    return stringBuilder.toString().trim();
  }
  
  public static String c(String paramString) {
    String str;
    try {
      BigDecimal bigDecimal2 = new BigDecimal();
      this(paramString);
      BigDecimal bigDecimal1 = new BigDecimal();
      this("100");
      str = bigDecimal2.divide(bigDecimal1).toString();
    } catch (Exception exception) {
      str = "1";
    } 
    return str;
  }
  
  public static String d(String paramString) {
    boolean bool = false;
    StringBuilder stringBuilder = new StringBuilder();
    byte b;
    for (b = 0; b < paramString.length() / 3; b++)
      stringBuilder.append("cmd"); 
    for (b = 0; b < paramString.length() % 3; b++)
      stringBuilder.append("cmd".charAt(b)); 
    byte[] arrayOfByte3 = paramString.getBytes();
    byte[] arrayOfByte2 = stringBuilder.toString().getBytes();
    byte[] arrayOfByte1 = new byte[paramString.length()];
    for (b = bool; b < arrayOfByte3.length; b++)
      arrayOfByte1[b] = (byte)(byte)(arrayOfByte3[b] ^ arrayOfByte2[b]); 
    return b.a(arrayOfByte1);
  }
  
  public static String e(String paramString) {
    byte b1 = 0;
    if (paramString == null || paramString.length() == 0) {
      long l1 = 0L;
      return Long.toHexString(l1);
    } 
    byte[] arrayOfByte = new byte[paramString.length() * 2];
    char[] arrayOfChar = paramString.toCharArray();
    int i = arrayOfChar.length;
    int j = 0;
    byte b2;
    for (b2 = 0; b2 < i; b2++) {
      char c1 = arrayOfChar[b2];
      int k = j + 1;
      arrayOfByte[j] = (byte)(byte)(c1 & 0xFF);
      j = k + 1;
      arrayOfByte[k] = (byte)(byte)(c1 >> 8);
    } 
    long l = -1L;
    j = arrayOfByte.length;
    b2 = b1;
    while (true) {
      long l1 = l;
      if (b2 < j) {
        b1 = arrayOfByte[b2];
        l = l >> 8L ^ d[(b1 ^ (int)l) & 0xFF];
        b2++;
        continue;
      } 
      return Long.toHexString(l1);
    } 
  }
  
  private static String f(String paramString) {
    try {
      byte[] arrayOfByte = paramString.getBytes();
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
      messageDigest.reset();
      messageDigest.update(arrayOfByte);
      String str = b.a(messageDigest.digest());
    } catch (Exception exception) {
      exception = null;
    } 
    return (String)exception;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\utils\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */