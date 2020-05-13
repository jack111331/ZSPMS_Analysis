package com.unionpay.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.InflaterInputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.json.JSONObject;

public class k {
  public static boolean b = true;
  
  public static String c = "TDLog";
  
  public static boolean d = false;
  
  public static boolean e = false;
  
  private static String f = "ge";
  
  private static String g = "tp";
  
  private static String h = "rop";
  
  private static final ExecutorService i = Executors.newSingleThreadExecutor();
  
  private static final byte[] j = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
      101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
      111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
      121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
      56, 57, 43, 47 };
  
  private static byte[] k = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };
  
  public static String a() {
    return null;
  }
  
  public static String a(Context paramContext, String paramString) {
    try {
      InputStream inputStream = paramContext.getAssets().open(paramString);
      byte[] arrayOfByte = new byte[inputStream.available()];
      inputStream.read(arrayOfByte);
      inputStream.close();
      String str = new String();
      this(arrayOfByte);
      JSONObject jSONObject = new JSONObject();
      this(str);
      str = jSONObject.getString("td_channel_id");
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  public static final String a(String paramString) {
    String str = paramString;
    if (paramString.length() > 256)
      str = paramString.substring(0, 256); 
    return str;
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder();
    int i = paramArrayOfbyte.length;
    for (byte b = 0; b < i; b++) {
      int j = paramArrayOfbyte[b] & 0xFF;
      if (j < 16)
        stringBuilder.append('0'); 
      stringBuilder.append(Integer.toHexString(j));
    } 
    return stringBuilder.toString();
  }
  
  public static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    String str;
    byte[] arrayOfByte = b(paramArrayOfbyte, paramInt1, paramInt2);
    try {
      str = new String();
      this(arrayOfByte, "US-ASCII");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      str = new String(arrayOfByte);
    } 
    return str;
  }
  
  public static void a(Class paramClass, i parami, String paramString1, String paramString2) {
    Field field = paramClass.getDeclaredField(paramString1);
    field.setAccessible(true);
    Object object = field.get(null);
    Class<?> clazz = Class.forName(paramString2);
    aq aq = new aq(parami, object);
    field.set(null, Proxy.newProxyInstance(paramClass.getClass().getClassLoader(), new Class[] { clazz }, aq));
  }
  
  public static void a(Object paramObject, i parami, String paramString1, String paramString2) {
    Field field = paramObject.getClass().getDeclaredField(paramString1);
    field.setAccessible(true);
    Object object = field.get(paramObject);
    Class<?> clazz = Class.forName(paramString2);
    ap ap = new ap(parami, object);
    field.set(paramObject, Proxy.newProxyInstance(paramObject.getClass().getClassLoader(), new Class[] { clazz }, ap));
  }
  
  public static boolean a(int paramInt) {
    return (Build.VERSION.SDK_INT >= paramInt);
  }
  
  public static boolean a(Context paramContext) {
    return false;
  }
  
  private static byte[] a(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2, int paramInt3) {
    boolean bool1;
    boolean bool2;
    int i = 0;
    byte[] arrayOfByte = j;
    if (paramInt2 > 0) {
      bool1 = paramArrayOfbyte1[paramInt1] << 24 >>> 8;
    } else {
      bool1 = false;
    } 
    if (paramInt2 > 1) {
      bool2 = paramArrayOfbyte1[paramInt1 + 1] << 24 >>> 16;
    } else {
      bool2 = false;
    } 
    if (paramInt2 > 2)
      i = paramArrayOfbyte1[paramInt1 + 2] << 24 >>> 24; 
    paramInt1 = i | bool2 | bool1;
    switch (paramInt2) {
      default:
        return paramArrayOfbyte2;
      case 3:
        paramArrayOfbyte2[paramInt3] = (byte)arrayOfByte[paramInt1 >>> 18];
        paramArrayOfbyte2[paramInt3 + 1] = (byte)arrayOfByte[paramInt1 >>> 12 & 0x3F];
        paramArrayOfbyte2[paramInt3 + 2] = (byte)arrayOfByte[paramInt1 >>> 6 & 0x3F];
        paramArrayOfbyte2[paramInt3 + 3] = (byte)arrayOfByte[paramInt1 & 0x3F];
      case 2:
        paramArrayOfbyte2[paramInt3] = (byte)arrayOfByte[paramInt1 >>> 18];
        paramArrayOfbyte2[paramInt3 + 1] = (byte)arrayOfByte[paramInt1 >>> 12 & 0x3F];
        paramArrayOfbyte2[paramInt3 + 2] = (byte)arrayOfByte[paramInt1 >>> 6 & 0x3F];
        paramArrayOfbyte2[paramInt3 + 3] = (byte)61;
      case 1:
        break;
    } 
    paramArrayOfbyte2[paramInt3] = (byte)arrayOfByte[paramInt1 >>> 18];
    paramArrayOfbyte2[paramInt3 + 1] = (byte)arrayOfByte[paramInt1 >>> 12 & 0x3F];
    paramArrayOfbyte2[paramInt3 + 2] = (byte)61;
    paramArrayOfbyte2[paramInt3 + 3] = (byte)61;
  }
  
  public static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    SecureRandom secureRandom = new SecureRandom();
    DESKeySpec dESKeySpec = new DESKeySpec(paramArrayOfbyte1);
    SecretKey secretKey = SecretKeyFactory.getInstance("DES").generateSecret(dESKeySpec);
    Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    cipher.init(2, secretKey, new IvParameterSpec(new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 }, ), secureRandom);
    InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(cipher.doFinal(paramArrayOfbyte2)));
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    while (true) {
      int i = inflaterInputStream.read();
      if (i != -1) {
        byteArrayOutputStream.write(i);
        continue;
      } 
      return byteArrayOutputStream.toByteArray();
    } 
  }
  
  public static byte[] a(int[] paramArrayOfint1, int[] paramArrayOfint2) {
    for (byte b = 0; b < paramArrayOfint1.length; b++) {
      paramArrayOfint1[b] = paramArrayOfint1[b] * paramArrayOfint2[paramArrayOfint2.length - 1 - b] - paramArrayOfint1[paramArrayOfint1.length - 1 - b] * paramArrayOfint2[b] + "kiG9w0BAQUFADCBqjELMAkGA0JFSUpJTkcxEDAOBgNVBAcMB0JFSUpJTkcxFjAUBgNVB".charAt(b);
      paramArrayOfint2[b] = paramArrayOfint2[b] * paramArrayOfint1[paramArrayOfint1.length - 1 - b] + paramArrayOfint2[paramArrayOfint2.length - 1 - b] * paramArrayOfint1[b] - "kiG9w0BAQUFADCBqjELMAkGA0JFSUpJTkcxEDAOBgNVBAcMB0JFSUpJTkcxFjAUBgNVB".charAt("kiG9w0BAQUFADCBqjELMAkGA0JFSUpJTkcxEDAOBgNVBAcMB0JFSUpJTkcxFjAUBgNVB".length() - 1 - b);
    } 
    return (Arrays.toString(paramArrayOfint1) + Arrays.hashCode(paramArrayOfint2)).getBytes();
  }
  
  public static String b(byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: iconst_0
    //   4: aload_0
    //   5: arraylength
    //   6: invokestatic a : ([BII)Ljava/lang/String;
    //   9: astore_0
    //   10: getstatic com/unionpay/sdk/k.a : Z
    //   13: ifne -> 49
    //   16: aload_0
    //   17: ifnonnull -> 49
    //   20: new java/lang/AssertionError
    //   23: dup
    //   24: invokespecial <init> : ()V
    //   27: athrow
    //   28: astore_2
    //   29: aload_1
    //   30: astore_0
    //   31: getstatic com/unionpay/sdk/k.a : Z
    //   34: ifne -> 10
    //   37: new java/lang/AssertionError
    //   40: dup
    //   41: aload_2
    //   42: invokevirtual getMessage : ()Ljava/lang/String;
    //   45: invokespecial <init> : (Ljava/lang/Object;)V
    //   48: athrow
    //   49: aload_0
    //   50: areturn
    // Exception table:
    //   from	to	target	type
    //   2	10	28	java/io/IOException
  }
  
  public static boolean b(Context paramContext, String paramString) {
    boolean bool = false;
    try {
      int i = paramContext.checkCallingOrSelfPermission(paramString);
      if (i == 0)
        bool = true; 
    } catch (Throwable throwable) {}
    return bool;
  }
  
  public static final boolean b(String paramString) {
    return (paramString == null || "".equals(paramString.trim()));
  }
  
  public static byte[] b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramArrayOfbyte == null)
      throw new NullPointerException("Cannot serialize a null array."); 
    if (paramInt1 < 0)
      throw new IllegalArgumentException("Cannot have negative offset: " + paramInt1); 
    if (paramInt2 < 0)
      throw new IllegalArgumentException("Cannot have length offset: " + paramInt2); 
    if (paramInt1 + paramInt2 > paramArrayOfbyte.length)
      throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfbyte.length) })); 
    int i = paramInt2 / 3;
    if (paramInt2 % 3 > 0) {
      b = 4;
    } else {
      b = 0;
    } 
    byte[] arrayOfByte = new byte[b + i * 4];
    byte b = 0;
    i = 0;
    while (i < paramInt2 - 2) {
      a(paramArrayOfbyte, i + paramInt1, 3, arrayOfByte, b);
      i += 3;
      b += 4;
    } 
    int j = b;
    if (i < paramInt2) {
      a(paramArrayOfbyte, i + paramInt1, paramInt2 - i, arrayOfByte, b);
      j = b + 4;
    } 
    if (j <= arrayOfByte.length - 1) {
      paramArrayOfbyte = new byte[j];
      System.arraycopy(arrayOfByte, 0, paramArrayOfbyte, 0, j);
      return paramArrayOfbyte;
    } 
    return arrayOfByte;
  }
  
  public static byte[] b(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    try {
      DESKeySpec dESKeySpec = new DESKeySpec();
      this(paramArrayOfbyte2);
      SecretKey secretKey = SecretKeyFactory.getInstance("DES").generateSecret(dESKeySpec);
      Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      IvParameterSpec ivParameterSpec = new IvParameterSpec();
      this(k);
      cipher.init(1, secretKey, ivParameterSpec);
      paramArrayOfbyte1 = cipher.doFinal(paramArrayOfbyte1);
    } catch (Exception exception) {
      exception = null;
    } 
    return (byte[])exception;
  }
  
  public static String c(Context paramContext, String paramString) {
    try {
      Iterator<String> iterator;
      Bundle bundle = (paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128)).metaData;
      if (bundle != null) {
        iterator = bundle.keySet().iterator();
        while (iterator.hasNext()) {
          if (((String)iterator.next()).equalsIgnoreCase(paramString))
            return String.valueOf(bundle.get(paramString)); 
        } 
      } 
      bundle = null;
      while (iterator.hasNext()) {
        if (((String)iterator.next()).equalsIgnoreCase(paramString))
          return String.valueOf(bundle.get(paramString)); 
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException = null;
    } 
    return (String)nameNotFoundException;
  }
  
  public static String c(String paramString) {
    try {
      paramString = a(MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8")));
    } catch (Exception exception) {
      exception = null;
    } 
    return (String)exception;
  }
  
  public static byte[] c(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    try {
      DESKeySpec dESKeySpec = new DESKeySpec();
      this(paramArrayOfbyte2);
      SecretKey secretKey = SecretKeyFactory.getInstance("DES").generateSecret(dESKeySpec);
      Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      IvParameterSpec ivParameterSpec = new IvParameterSpec();
      this(k);
      cipher.init(2, secretKey, ivParameterSpec);
      paramArrayOfbyte1 = cipher.doFinal(paramArrayOfbyte1);
    } catch (Exception exception) {
      exception = null;
    } 
    return (byte[])exception;
  }
  
  public static String d(String paramString) {
    String str1;
    String str2 = null;
    if (paramString == null)
      return str2; 
    try {
      paramString = a(MessageDigest.getInstance("SHA-256").digest(paramString.getBytes("UTF-8")));
    } catch (Exception exception) {
      str1 = str2;
    } 
    return str1;
  }
  
  public static FileChannel d(Context paramContext, String paramString) {
    Throwable throwable1;
    Throwable throwable2 = null;
    try {
      File file2 = new File();
      File file1 = paramContext.getFilesDir();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      this(file1, stringBuilder.append(paramString).append("td.lock").toString());
      if (!file2.exists())
        file2.createNewFile(); 
      RandomAccessFile randomAccessFile = new RandomAccessFile();
      this(file2, "rw");
      try {
        return randomAccessFile.getChannel();
      } catch (Throwable throwable) {}
    } catch (Throwable null) {
      throwable1 = null;
    } 
    try {
      throwable1.close();
      throwable1 = throwable2;
    } catch (Exception exception) {
      throwable1 = throwable2;
    } 
    return (FileChannel)throwable1;
  }
  
  public static void execute(Runnable paramRunnable) {
    i.execute(paramRunnable);
  }
  
  static {
    boolean bool;
    if (!k.class.desiredAssertionStatus()) {
      bool = true;
    } else {
      bool = false;
    } 
    a = bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */