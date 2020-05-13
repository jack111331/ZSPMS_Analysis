package com.tencent.tp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class TssJavaMethod {
  private static ITssJavaMethod2 a;
  
  public static String runtime_sdk_version = "4.2.20(2019/11/28)-jar-version";
  
  static {
    b();
  }
  
  private static String a(byte[] paramArrayOfbyte) {
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
    StringBuffer stringBuffer = new StringBuffer(paramArrayOfbyte.length * 2);
    for (byte b = 0; b < paramArrayOfbyte.length; b++) {
      stringBuffer.append(arrayOfChar[(paramArrayOfbyte[b] & 0xF0) >> 4]);
      stringBuffer.append(arrayOfChar[paramArrayOfbyte[b] & 0xF]);
    } 
    return stringBuffer.toString();
  }
  
  private static boolean a() {
    if (TssJavaMethod.class.getName().equals("com.tencent.tp.TssJavaMethod") != true)
      return false; 
    if (TssSdkRuntime.getPackageInfo() == null)
      return false; 
    String str1 = (TssSdkRuntime.getPackageInfo()).applicationInfo.dataDir;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append("/files/tersafeupdate2.jar");
    File file = new File(stringBuilder.toString());
    if (file.exists() != true)
      return false; 
    byte[] arrayOfByte = null;
    String str2 = null;
    try {
      JarFile jarFile = new JarFile();
      this(file.getAbsoluteFile(), true);
      try {
        if (!a(jarFile))
          return false; 
      } catch (Exception exception1) {
      
      } finally {
        stringBuilder = null;
        if (exception != null)
          try {
            exception.close();
          } catch (IOException exception) {} 
      } 
      throw stringBuilder;
    } catch (Exception exception1) {
    
    } finally {
      stringBuilder = null;
      str1 = null;
      if (exception != null)
        try {
          exception.close();
        } catch (IOException iOException1) {} 
    } 
    if (stringBuilder != null)
      try {
        stringBuilder.close();
      } catch (IOException iOException1) {} 
    if (iOException != null)
      try {
        iOException.close();
      } catch (IOException iOException1) {} 
    return false;
  }
  
  private static boolean a(JarFile paramJarFile) {
    boolean bool;
    try {
      byte[] arrayOfByte = new byte[4096];
      Enumeration<JarEntry> enumeration = paramJarFile.entries();
      MessageDigest messageDigest = null;
      boolean bool1 = false;
      while (true) {
        bool = bool1;
        try {
          if (enumeration.hasMoreElements()) {
            Certificate[] arrayOfCertificate1;
            JarEntry jarEntry = enumeration.nextElement();
            if (jarEntry.isDirectory() || jarEntry.getName().startsWith("META-INF/"))
              continue; 
            Certificate[] arrayOfCertificate2 = a(paramJarFile, jarEntry, arrayOfByte);
            if (arrayOfCertificate2 == null)
              return false; 
            if (messageDigest == null) {
              messageDigest = MessageDigest.getInstance("MD5");
              messageDigest.update(arrayOfCertificate2[0].getEncoded());
              bool = bool1;
              if ("2BD6F965D7704D957A7AF1462EC17E5F".compareToIgnoreCase(a(messageDigest.digest())) == 0)
                bool = true; 
              arrayOfCertificate1 = arrayOfCertificate2;
              bool1 = bool;
              continue;
            } 
            byte b = 0;
            while (b < arrayOfCertificate1.length) {
              int i = 0;
              while (true) {
                if (i < arrayOfCertificate2.length) {
                  if (arrayOfCertificate1[b] != null && arrayOfCertificate1[b].equals(arrayOfCertificate2[i])) {
                    i = 1;
                    break;
                  } 
                  i++;
                  continue;
                } 
                i = 0;
                break;
              } 
              if (i != 0) {
                int j = arrayOfCertificate1.length;
                i = arrayOfCertificate2.length;
                if (j == i) {
                  b++;
                  continue;
                } 
              } 
              return false;
            } 
            continue;
          } 
        } catch (NoSuchAlgorithmException|java.security.cert.CertificateEncodingException noSuchAlgorithmException) {
          bool = bool1;
        } 
        return bool;
      } 
    } catch (NoSuchAlgorithmException|java.security.cert.CertificateEncodingException noSuchAlgorithmException) {
      bool = false;
    } 
    return bool;
  }
  
  private static Certificate[] a(JarFile paramJarFile, JarEntry paramJarEntry, byte[] paramArrayOfbyte) {
    try {
      BufferedInputStream bufferedInputStream = new BufferedInputStream();
      this(paramJarFile.getInputStream(paramJarEntry));
      while (bufferedInputStream.read(paramArrayOfbyte, 0, paramArrayOfbyte.length) != -1);
      bufferedInputStream.close();
      if (paramJarEntry != null) {
        Certificate[] arrayOfCertificate = paramJarEntry.getCertificates();
      } else {
        paramJarFile = null;
      } 
      return (Certificate[])paramJarFile;
    } catch (IOException|RuntimeException iOException) {
      return null;
    } 
  }
  
  private static void b() {
    if (a == null) {
      try {
        if (a() != true) {
          a = null;
        } else {
          Class<ITssJavaMethod2> clazz = c.a("com.tencent.up_tp.TssJavaMethodImp2");
          if (clazz != null) {
            a = clazz.newInstance();
          } else {
            Exception exception = new Exception();
            this("com.tencent.up_tp.TssJavaMethodImp2 not found");
            throw exception;
          } 
        } 
      } catch (Exception exception) {
        if (u.c() == 1)
          try {
            StringBuilder stringBuilder = new StringBuilder();
            this();
            stringBuilder.append("*#06#:");
            stringBuilder.append(exception.toString());
            u.b(stringBuilder.toString());
          } catch (Exception exception1) {} 
      } 
      if (a == null)
        a = new s(); 
    } 
  }
  
  public static void initialize() {
    if (a != null)
      a.initialize(); 
  }
  
  public static void invokeForceUpdateRootkitAppRequest() {
    if (a != null)
      a.invokeForceUpdateRootkitAppRequest(); 
  }
  
  public static void invokeRootkitAppRequest() {
    if (a != null)
      a.invokeRootkitAppRequest(); 
  }
  
  public static void invokeRootkitIsRunningTip() {
    if (a != null)
      a.invokeRootkitIsRunningTip(); 
  }
  
  public static void scan() {
    if (a != null)
      a.scan(); 
  }
  
  public static void sendCmd(String paramString) {
    if (a != null)
      a.sendCmd(paramString); 
  }
  
  public static int sendCmdEx(String paramString) {
    return (a != null) ? a.sendCmd(paramString) : 0;
  }
  
  public static void showMsgBoxEx() {
    if (a != null)
      a.showMsgBoxEx(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\TssJavaMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */