package com.zz.sdk.i;

import android.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.json.JSONObject;

public class bc {
  static String a = "DES";
  
  static String b = "MD5";
  
  static String c = "A/=B";
  
  public static String a(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
    int i = paramArrayOfbyte.length;
    for (byte b = 0; b < i; b++) {
      byte b1 = paramArrayOfbyte[b];
      if ((b1 & 0xF0) != 0) {
        stringBuilder.append(Integer.toHexString(b1 & 0xFF));
      } else {
        stringBuilder.append("0").append(Integer.toHexString(b1 & 0xF));
      } 
    } 
    return stringBuilder.toString().toUpperCase();
  }
  
  public static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, String paramString) {
    try {
      DESKeySpec dESKeySpec = new DESKeySpec();
      this(paramString.getBytes());
      SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(a);
      Cipher cipher = Cipher.getInstance(a);
      cipher.init(2, secretKeyFactory.generateSecret(dESKeySpec));
      String str2 = new String();
      this(cipher.doFinal(paramArrayOfbyte, paramInt1, paramInt2), "utf-8");
      String str1 = str2;
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (String)exception;
  }
  
  public static String a(byte[]... paramVarArgs) {
    String str;
    try {
      MessageDigest messageDigest = MessageDigest.getInstance(b);
      messageDigest.reset();
      int i = paramVarArgs.length;
      for (byte b = 0; b < i; b++)
        messageDigest.update(paramVarArgs[b]); 
      str = a(messageDigest.digest());
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      noSuchAlgorithmException.printStackTrace();
      str = "";
    } 
    return str;
  }
  
  public static final void a(String[] paramArrayOfString) {
    byte b = 4;
    if (paramArrayOfString.length > 0) {
      BufferedReader bufferedReader;
      int i;
      try {
        i = Integer.parseInt(paramArrayOfString[0]);
        if (i == 0) {
          System.out.println(b(paramArrayOfString[1], paramArrayOfString[2]));
          return;
        } 
        if (i == 1) {
          System.out.println(c(paramArrayOfString[1], paramArrayOfString[2]));
          return;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
        return;
      } 
      if (i == 4) {
        if (exception[1].matches("[A-Za-z0-9+/]*==")) {
          System.out.println(c((String)exception[1], (String)exception[2]));
          return;
        } 
        System.out.println((String)exception[1]);
        return;
      } 
      if (i == 5) {
        Exception exception1 = exception[2];
        File file = new File();
        this((String)exception[1]);
        bufferedReader = new BufferedReader();
        FileReader fileReader = new FileReader();
        this(file);
        this(fileReader);
        while (true) {
          String str = bufferedReader.readLine();
          if (str != null) {
            String[] arrayOfString = str.split(":");
            if (arrayOfString.length == 4 && arrayOfString[3].matches("[A-Za-z0-9+/]*==")) {
              for (i = 0; i < 3; i++) {
                System.out.print(arrayOfString[i]);
                System.out.print(':');
              } 
              System.out.println(c(arrayOfString[3], (String)exception1));
              continue;
            } 
            System.out.println(str);
            continue;
          } 
          bufferedReader.close();
          return;
        } 
      } 
      if (i == 6) {
        BufferedReader bufferedReader1 = bufferedReader[2];
        File file = new File();
        this((String)bufferedReader[1]);
        BufferedReader bufferedReader2 = bufferedReader[3];
        if ("a".equals(bufferedReader2)) {
          i = 1;
        } else if ("A".equals(bufferedReader2)) {
          i = 2;
        } else if ("d".equals(bufferedReader2)) {
          i = 3;
        } else {
          i = 0;
        } 
        if (i > 0) {
          JSONObject jSONObject;
          if (file.isFile() && file.canRead()) {
            BufferedReader bufferedReader3 = new BufferedReader();
            FileReader fileReader = new FileReader();
            this(file);
            this(fileReader);
            String str1 = c(bufferedReader3.readLine(), (String)bufferedReader1);
          } else {
            file = null;
          } 
          if (file == null) {
            jSONObject = new JSONObject();
            this();
          } else {
            jSONObject = new JSONObject((String)jSONObject);
          } 
          if (i == 1 || i == 2) {
            for (b = 5; b < bufferedReader.length; b += 2) {
              BufferedReader bufferedReader3 = bufferedReader[b - 1];
              bufferedReader2 = bufferedReader[b];
              if (i == 2 || !jSONObject.has((String)bufferedReader3))
                jSONObject.put((String)bufferedReader3, bufferedReader2); 
            } 
          } else if (i == 3) {
            for (i = b; i < bufferedReader.length; i++)
              jSONObject.remove((String)bufferedReader[i]); 
          } 
          String str = b(jSONObject.toString(), (String)bufferedReader1);
          System.out.print(str);
        } 
      } 
      return;
    } 
    System.out.println("0 [msg] [key] - encrypt");
    System.out.println("1 [msg] [key] - decrypt");
    System.out.println("4 [msg] [key] - try-decrypt");
    System.out.println("5 [file] [key] - try-decrypt-file");
    System.out.println("6 [file] [key] [a/A/d [KEY VALUE]{N}] - try-modify-JSON-file: add/Add Focus/delete");
  }
  
  public static byte[] a(String paramString1, String paramString2) {
    try {
      DESKeySpec dESKeySpec = new DESKeySpec();
      this(paramString2.getBytes());
      SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(a);
      Cipher cipher = Cipher.getInstance(a);
      cipher.init(1, secretKeyFactory.generateSecret(dESKeySpec));
      byte[] arrayOfByte = cipher.doFinal(paramString1.getBytes("utf-8"));
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (byte[])exception;
  }
  
  public static String b(String paramString1, String paramString2) {
    byte[] arrayOfByte = a(paramString1, b + paramString2 + c + a);
    paramString1 = a(new byte[][] { arrayOfByte, paramString2.getBytes(), c.getBytes() });
    paramString2 = Base64.encodeToString(arrayOfByte, 3);
    return paramString2 + c.charAt(1) + paramString1 + "==";
  }
  
  public static String c(String paramString1, String paramString2) {
    int i = paramString1.lastIndexOf(c.charAt(1));
    String str = paramString1.substring(i + 1, paramString1.length() - 2);
    null = Base64.decode(paramString1.substring(0, i), 3);
    return (i > 0 && i < paramString1.length() - 2 && str.equals(a(new byte[][] { null, paramString2.getBytes(), c.getBytes() }))) ? a(null, 0, null.length, b + paramString2 + c + a) : null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */