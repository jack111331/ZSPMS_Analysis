package com.unionpay.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
  private static SimpleDateFormat a = new SimpleDateFormat("yyyyMMddhhmmss");
  
  private static HashMap b = new c();
  
  public static String a(Context paramContext) {
    String str2 = "";
    String str3 = UPUtils.a(paramContext, "configs");
    String str4 = UPUtils.a(paramContext, "mode");
    String str5 = UPUtils.a(paramContext, "or");
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
            str3 = g.a(jSONObject, "sign");
            try {
              bool = Integer.parseInt(str4);
            } catch (NumberFormatException numberFormatException) {
              bool = false;
            } 
            str1 = new String();
            this(Base64.decode(jSONObject.getString("configs"), 2));
            StringBuilder stringBuilder = new StringBuilder();
            this();
            str5 = a(UPUtils.a(stringBuilder.append(str1).append(str5).toString()));
            boolean bool1 = UPUtils.forConfig(bool, str3).equals(str5);
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
      for (byte b1 = 0; b1 < i; b1++) {
        Object object = g.a(jSONArray, b1);
        if (object != null) {
          object = object;
          if ("app".equals(g.a((JSONObject)object, "type")))
            return new String(Base64.decode(g.a((JSONObject)object, "ca"), 2)); 
        } 
      } 
    } catch (JSONException jSONException) {
      str1 = "";
    } 
    return str1;
  }
  
  public static String a(String paramString) {
    char[] arrayOfChar = "0123456789ABCDEF".toCharArray();
    StringBuilder stringBuilder = new StringBuilder("");
    for (byte b1 : paramString.getBytes()) {
      stringBuilder.append(arrayOfChar[(b1 & 0xF0) >> 4]);
      stringBuilder.append(arrayOfChar[b1 & 0xF]);
    } 
    return stringBuilder.toString().trim();
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
    for (byte b1 = 0; b1 < paramArrayOfbyte.length; b1++) {
      String str1 = Integer.toHexString(paramArrayOfbyte[b1]);
      int i = str1.length();
      String str2 = str1;
      if (i == 1)
        str2 = "0" + str1; 
      str1 = str2;
      if (i > 2)
        str1 = str2.substring(i - 2, i); 
      stringBuilder.append(str1.toUpperCase());
      if (b1 < paramArrayOfbyte.length - 1)
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
      }  
    return bool2;
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
    null = new File(paramString);
    FileInputStream fileInputStream = new FileInputStream(null);
    try {
      MappedByteBuffer mappedByteBuffer = fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, null.length());
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(mappedByteBuffer);
      BigInteger bigInteger = new BigInteger();
      this(1, messageDigest.digest());
      return bigInteger.toString(16);
    } catch (Exception null) {
      exception.printStackTrace();
      return (String)exception;
    } finally {
      try {
        iOException.close();
      } catch (IOException iOException1) {
        iOException1.printStackTrace();
      } 
    } 
  }
  
  public static String c(Context paramContext, String paramString) {
    String str1 = "";
    String str2 = str1;
    if (!TextUtils.isEmpty(paramString))
      try {
        str2 = (paramContext.getPackageManager().getPackageInfo(paramString, 0)).versionName;
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        str2 = str1;
      }  
    return str2;
  }
  
  public static void c(String paramString) {
    File file = new File(paramString);
    if (file.exists()) {
      if (file.isFile()) {
        file.delete();
      } else if (file.isDirectory()) {
        File[] arrayOfFile = file.listFiles();
        int i = arrayOfFile.length;
        byte b1 = 0;
        while (true) {
          if (b1 < i) {
            c(arrayOfFile[b1].getPath());
            b1++;
            continue;
          } 
          file.delete();
          return;
        } 
      } 
    } else {
      return;
    } 
    file.delete();
  }
  
  public static String d(String paramString) {
    if (!TextUtils.isEmpty((CharSequence)b.get(paramString)))
      paramString = (String)b.get(paramString); 
    return paramString;
  }
  
  public static final boolean e(String paramString) {
    return !!Pattern.compile("[^0-9]+").matcher(paramString).matches();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpa\\utils\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */