package com.chuanglan.shanyan_sdk.tool;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.MessageDigest;

public class f {
  public static String a(Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      PackageInfo packageInfo = packageManager.getPackageInfo(paramContext.getPackageName(), 64);
      if (packageInfo != null)
        return packageInfo.packageName; 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException = null;
      if (nameNotFoundException != null)
        return ((PackageInfo)nameNotFoundException).packageName; 
    } 
    return "-1";
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    StringBuffer stringBuffer = new StringBuffer();
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.reset();
      messageDigest.update(paramArrayOfbyte);
      paramArrayOfbyte = messageDigest.digest();
      int i = paramArrayOfbyte.length;
      for (byte b = 0; b < i; b++) {
        byte b1 = paramArrayOfbyte[b];
        if (Integer.toHexString(b1 & 0xFF).length() == 1) {
          stringBuffer.append("0").append(Integer.toHexString(b1 & 0xFF));
        } else {
          stringBuffer.append(Integer.toHexString(b1 & 0xFF));
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return stringBuffer.toString();
  }
  
  public static boolean a(Context paramContext, String paramString) {
    return (paramContext.checkCallingOrSelfPermission(paramString) == 0);
  }
  
  public static String b(Context paramContext) {
    String str2 = "-1";
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      PackageInfo packageInfo = packageManager.getPackageInfo(paramContext.getPackageName(), 64);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      packageManager = null;
    } 
    String str1 = str2;
    if (packageManager != null) {
      Signature[] arrayOfSignature = ((PackageInfo)packageManager).signatures;
      str1 = str2;
      if (arrayOfSignature != null) {
        str1 = str2;
        if (arrayOfSignature.length > 0)
          str1 = a(arrayOfSignature[0].toByteArray()).toUpperCase(); 
      } 
    } 
    return str1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\tool\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */