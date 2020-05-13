package com.alipay.security.mobile.module.a;

import android.os.Environment;
import android.util.Base64;
import com.alipay.security.mobile.module.a.a.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

public final class a {
  public static File a() {
    try {
      String str = new String();
      this(a.a("Z2V0RXh0ZXJuYWxTdG9yYWdlRGlyZWN0b3J5"));
      File file = (File)Environment.class.getMethod(str, new Class[0]).invoke(null, new Object[0]);
    } catch (Exception exception) {
      exception = null;
    } 
    return (File)exception;
  }
  
  public static String a(Throwable paramThrowable) {
    StringWriter stringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(stringWriter));
    return stringWriter.toString();
  }
  
  public static String a(Map<String, String> paramMap, String paramString1, String paramString2) {
    if (paramMap != null) {
      String str = paramMap.get(paramString1);
      if (str != null)
        paramString2 = str; 
    } 
    return paramString2;
  }
  
  public static boolean a(String paramString) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: ifnull -> 15
    //   6: aload_0
    //   7: invokevirtual length : ()I
    //   10: istore_2
    //   11: iload_2
    //   12: ifne -> 19
    //   15: iconst_1
    //   16: istore_3
    //   17: iload_3
    //   18: ireturn
    //   19: iconst_0
    //   20: istore #4
    //   22: iload #4
    //   24: iload_2
    //   25: if_icmpge -> 48
    //   28: iload_1
    //   29: istore_3
    //   30: aload_0
    //   31: iload #4
    //   33: invokevirtual charAt : (I)C
    //   36: invokestatic isWhitespace : (C)Z
    //   39: ifeq -> 17
    //   42: iinc #4, 1
    //   45: goto -> 22
    //   48: iconst_1
    //   49: istore_3
    //   50: goto -> 17
  }
  
  public static boolean a(String paramString1, String paramString2) {
    return (paramString1 == null) ? ((paramString2 == null)) : paramString1.equals(paramString2);
  }
  
  public static String b(String paramString1, String paramString2) {
    try {
      paramString1 = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramString1, paramString2 });
      paramString2 = paramString1;
    } catch (Exception exception) {}
    return paramString2;
  }
  
  public static boolean b(String paramString) {
    return !a(paramString);
  }
  
  public static boolean c(String paramString) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokevirtual getBytes : ()[B
    //   6: astore_0
    //   7: aload_0
    //   8: arraylength
    //   9: istore_2
    //   10: iconst_0
    //   11: istore_3
    //   12: iload_3
    //   13: iload_2
    //   14: if_icmpge -> 56
    //   17: aload_0
    //   18: iload_3
    //   19: baload
    //   20: istore #4
    //   22: iload #4
    //   24: iflt -> 37
    //   27: iload_1
    //   28: istore #5
    //   30: iload #4
    //   32: bipush #31
    //   34: if_icmple -> 47
    //   37: iload #4
    //   39: bipush #127
    //   41: if_icmplt -> 50
    //   44: iload_1
    //   45: istore #5
    //   47: iload #5
    //   49: ireturn
    //   50: iinc #3, 1
    //   53: goto -> 12
    //   56: iconst_1
    //   57: istore #5
    //   59: goto -> 47
  }
  
  public static String d(String paramString) {
    String str = paramString;
    if (paramString == null)
      str = ""; 
    return str;
  }
  
  public static String e(String paramString) {
    String str1;
    String str2 = null;
    byte b = 0;
    try {
      if (a(paramString))
        return str2; 
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
      messageDigest.update(paramString.getBytes("UTF-8"));
      byte[] arrayOfByte = messageDigest.digest();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      while (b < arrayOfByte.length) {
        stringBuilder.append(String.format("%02x", new Object[] { Byte.valueOf(arrayOfByte[b]) }));
        b++;
      } 
      str1 = stringBuilder.toString();
    } catch (Exception exception) {
      str1 = str2;
    } 
    return str1;
  }
  
  public static String f(String paramString) {
    String str;
    try {
      byte[] arrayOfByte2 = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(paramString.length()).array();
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      this(paramString.length());
      GZIPOutputStream gZIPOutputStream = new GZIPOutputStream();
      this(byteArrayOutputStream);
      gZIPOutputStream.write(paramString.getBytes("UTF-8"));
      gZIPOutputStream.close();
      byteArrayOutputStream.close();
      byte[] arrayOfByte1 = new byte[(byteArrayOutputStream.toByteArray()).length + 4];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 4);
      System.arraycopy(byteArrayOutputStream.toByteArray(), 0, arrayOfByte1, 4, (byteArrayOutputStream.toByteArray()).length);
      str = Base64.encodeToString(arrayOfByte1, 8);
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  public static String g(String paramString) {
    String str;
    if (a(paramString))
      return ""; 
    try {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream();
      this(paramString.getBytes("utf-8"));
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      this();
      GZIPOutputStream gZIPOutputStream = new GZIPOutputStream();
      this(byteArrayOutputStream);
      byte[] arrayOfByte = new byte[1024];
      while (true) {
        int i = byteArrayInputStream.read(arrayOfByte, 0, 1024);
        if (i != -1) {
          gZIPOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        gZIPOutputStream.flush();
        gZIPOutputStream.close();
        byte[] arrayOfByte1 = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        return new String(Base64.encode(arrayOfByte1, 2));
      } 
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\security\mobile\module\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */