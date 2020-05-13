package com.herosdk.d;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.herosdk.common.NativeUtils;
import com.herosdk.error.ErrorUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class o {
  private static final String a = "frameLib.eus";
  
  private static String b = "";
  
  public static String a(String paramString) {
    return c(paramString, "md5");
  }
  
  @SuppressLint({"TrulyRandom"})
  public static String a(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString2)) {
      Log.e("frameLib.eus", "asek empty error");
      return "";
    } 
    Exception exception2 = null;
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramString2.getBytes(), "AES");
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(1, secretKeySpec);
      byte[] arrayOfByte = cipher.doFinal(paramString1.getBytes());
      String str = Base64.encodeToString(arrayOfByte, 0);
    } catch (Exception exception1) {
      ErrorUtils.printExceptionInfo(exception1);
      exception1 = exception2;
    } 
    return (String)exception1;
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    StringBuffer stringBuffer = new StringBuffer();
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.reset();
      messageDigest.update(paramArrayOfbyte);
      paramArrayOfbyte = messageDigest.digest();
      for (byte b = 0; b < paramArrayOfbyte.length; b++) {
        if (Integer.toHexString(paramArrayOfbyte[b] & 0xFF).length() == 1) {
          stringBuffer.append("0").append(Integer.toHexString(paramArrayOfbyte[b] & 0xFF));
        } else {
          stringBuffer.append(Integer.toHexString(paramArrayOfbyte[b] & 0xFF));
        } 
      } 
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      ErrorUtils.printExceptionInfo(noSuchAlgorithmException);
    } 
    return stringBuffer.toString();
  }
  
  public static String a(byte[] paramArrayOfbyte, String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_2
    //   3: astore_3
    //   4: aload_0
    //   5: ifnull -> 15
    //   8: aload_0
    //   9: arraylength
    //   10: ifne -> 17
    //   13: aload_2
    //   14: astore_3
    //   15: aload_3
    //   16: areturn
    //   17: aload_1
    //   18: ifnull -> 33
    //   21: aload_1
    //   22: astore_3
    //   23: aload_1
    //   24: invokevirtual trim : ()Ljava/lang/String;
    //   27: invokevirtual length : ()I
    //   30: ifne -> 36
    //   33: ldc 'MD5'
    //   35: astore_3
    //   36: aload_3
    //   37: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/MessageDigest;
    //   40: astore_1
    //   41: aload_1
    //   42: invokevirtual reset : ()V
    //   45: aload_1
    //   46: aload_0
    //   47: invokevirtual update : ([B)V
    //   50: aload_1
    //   51: invokevirtual digest : ()[B
    //   54: invokestatic b : ([B)Ljava/lang/String;
    //   57: astore_3
    //   58: goto -> 15
    //   61: astore_0
    //   62: aload_0
    //   63: invokestatic printExceptionInfo : (Ljava/lang/Throwable;)V
    //   66: aload_2
    //   67: astore_3
    //   68: goto -> 15
    // Exception table:
    //   from	to	target	type
    //   36	58	61	java/lang/Exception
  }
  
  public static void a() {
    try {
      byte[] arrayOfByte = ao.b(ao.b(NativeUtils.gpvk()), Base64.decode(NativeUtils.gask(), 2));
      String str = new String();
      this(arrayOfByte);
      b = str;
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      b = "";
    } 
  }
  
  public static String b() {
    return b;
  }
  
  public static String b(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString2)) {
      Log.e("frameLib.eus", "asdk empty error");
      return "";
    } 
    Exception exception2 = null;
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramString2.getBytes(), "AES");
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(2, secretKeySpec);
      byte[] arrayOfByte = cipher.doFinal(Base64.decode(paramString1, 0));
      String str = new String(arrayOfByte);
    } catch (Exception exception1) {
      ErrorUtils.printExceptionInfo(exception1);
      exception1 = exception2;
    } 
    return (String)exception1;
  }
  
  private static String b(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < paramArrayOfbyte.length; b++)
      stringBuilder.append(Integer.toHexString(paramArrayOfbyte[b] & 0xFF | 0x100).substring(1, 3)); 
    return stringBuilder.toString();
  }
  
  public static String c() {
    return b("qGC0LppBnc9y0bekkXTcoMGd1HL8B/RsChZ+giutZxs=", b);
  }
  
  private static String c(String paramString1, String paramString2) {
    String str1 = null;
    String str2 = str1;
    if (paramString1 != null) {
      if (paramString1.trim().length() == 0)
        return str1; 
    } else {
      return str2;
    } 
    try {
      str2 = a(paramString1.getBytes("UTF-8"), paramString2);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      ErrorUtils.printExceptionInfo(unsupportedEncodingException);
      str2 = str1;
    } 
    return str2;
  }
  
  public static String d() {
    return b("pT4pzJyXp99qNORm2Cb8MQ==", b);
  }
  
  public static String e() {
    return b("Mlh8MIhK7mImNp35I4qKJQ==", b);
  }
  
  public static String f() {
    return b("OYXpgObRMi/EhEe5UB0VEg==", b);
  }
  
  public static String g() {
    return b("5pF7EhkkbBa2xPbSS6Bm8A==", b);
  }
  
  public static String h() {
    return b("qq2Y8FchUTwKq462ew+SIQ==", b);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */