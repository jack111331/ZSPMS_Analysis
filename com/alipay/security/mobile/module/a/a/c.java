package com.alipay.security.mobile.module.a.a;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public final class c {
  private static String a = new String("idnjfhncnsfuobcnt847y929o449u474w7j3h22aoddc98euk#%&&)*&^%#");
  
  public static String a() {
    String str = new String();
    for (byte b = 0; b < a.length() - 1; b += 4)
      str = str + a.charAt(b); 
    return str;
  }
  
  public static String a(String paramString1, String paramString2) {
    try {
      PBEKeySpec pBEKeySpec = a(paramString1);
      byte[] arrayOfByte2 = paramString2.getBytes();
      byte[] arrayOfByte3 = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(pBEKeySpec).getEncoded();
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(arrayOfByte3, "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      IvParameterSpec ivParameterSpec = new IvParameterSpec();
      this(new byte[cipher.getBlockSize()]);
      cipher.init(1, secretKeySpec, ivParameterSpec);
      byte[] arrayOfByte1 = pBEKeySpec.getSalt();
      ByteBuffer byteBuffer = ByteBuffer.allocate(arrayOfByte1.length + cipher.getOutputSize(arrayOfByte2.length));
      byteBuffer.put(arrayOfByte1);
      cipher.doFinal(ByteBuffer.wrap(arrayOfByte2), byteBuffer);
      String str = b(byteBuffer.array());
      paramString1 = str;
    } catch (Exception exception) {}
    return paramString1;
  }
  
  private static PBEKeySpec a(String paramString) {
    Class<?> clazz = Class.forName(new String(a.a("amF2YS5zZWN1cml0eS5TZWN1cmVSYW5kb20=")));
    Object object = clazz.newInstance();
    byte[] arrayOfByte = new byte[16];
    Method method = clazz.getMethod("nextBytes", new Class[] { arrayOfByte.getClass() });
    method.setAccessible(true);
    method.invoke(object, new Object[] { arrayOfByte });
    return new PBEKeySpec(paramString.toCharArray(), arrayOfByte, 10, 128);
  }
  
  private static byte[] a(byte[] paramArrayOfbyte) {
    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    Class<?> clazz = Class.forName(new String(a.a("amF2YS5zZWN1cml0eS5TZWN1cmVSYW5kb20=")));
    Object object = clazz.getMethod("getInstance", new Class[] { String.class, String.class }).invoke(null, new Object[] { "SHA1PRNG", "Crypto" });
    Method method = clazz.getMethod("setSeed", new Class[] { paramArrayOfbyte.getClass() });
    method.setAccessible(true);
    method.invoke(object, new Object[] { paramArrayOfbyte });
    KeyGenerator.class.getMethod("init", new Class[] { int.class, clazz }).invoke(keyGenerator, new Object[] { Integer.valueOf(128), object });
    return keyGenerator.generateKey().getEncoded();
  }
  
  private static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramArrayOfbyte1, "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      IvParameterSpec ivParameterSpec = new IvParameterSpec();
      this(new byte[cipher.getBlockSize()]);
      cipher.init(1, secretKeySpec, ivParameterSpec);
      byte[] arrayOfByte = cipher.doFinal(paramArrayOfbyte2);
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (byte[])throwable;
  }
  
  public static String b(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic a : (Ljava/lang/String;)Ljavax/crypto/spec/PBEKeySpec;
    //   4: astore_2
    //   5: aload_1
    //   6: invokestatic b : (Ljava/lang/String;)[B
    //   9: astore_3
    //   10: aload_3
    //   11: arraylength
    //   12: bipush #16
    //   14: if_icmpgt -> 113
    //   17: aconst_null
    //   18: astore_3
    //   19: aload_3
    //   20: ifnonnull -> 217
    //   23: new java/lang/Exception
    //   26: astore_3
    //   27: aload_3
    //   28: invokespecial <init> : ()V
    //   31: aload_3
    //   32: athrow
    //   33: astore_3
    //   34: aload_0
    //   35: invokevirtual getBytes : ()[B
    //   38: invokestatic a : ([B)[B
    //   41: astore_3
    //   42: aload_1
    //   43: invokestatic b : (Ljava/lang/String;)[B
    //   46: astore_0
    //   47: new javax/crypto/spec/SecretKeySpec
    //   50: astore_1
    //   51: aload_1
    //   52: aload_3
    //   53: ldc 'AES'
    //   55: invokespecial <init> : ([BLjava/lang/String;)V
    //   58: ldc 'AES/CBC/PKCS5Padding'
    //   60: invokestatic getInstance : (Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   63: astore_2
    //   64: new javax/crypto/spec/IvParameterSpec
    //   67: astore_3
    //   68: aload_3
    //   69: aload_2
    //   70: invokevirtual getBlockSize : ()I
    //   73: newarray byte
    //   75: invokespecial <init> : ([B)V
    //   78: aload_2
    //   79: iconst_2
    //   80: aload_1
    //   81: aload_3
    //   82: invokevirtual init : (ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   85: aload_2
    //   86: aload_0
    //   87: invokevirtual doFinal : ([B)[B
    //   90: astore_1
    //   91: new java/lang/String
    //   94: astore_0
    //   95: aload_0
    //   96: aload_1
    //   97: invokespecial <init> : ([B)V
    //   100: aload_0
    //   101: invokestatic c : (Ljava/lang/String;)Z
    //   104: istore #4
    //   106: iload #4
    //   108: ifeq -> 243
    //   111: aload_0
    //   112: areturn
    //   113: new javax/crypto/spec/PBEKeySpec
    //   116: astore #5
    //   118: aload #5
    //   120: aload_2
    //   121: invokevirtual getPassword : ()[C
    //   124: aload_3
    //   125: bipush #16
    //   127: invokestatic copyOf : ([BI)[B
    //   130: bipush #10
    //   132: sipush #128
    //   135: invokespecial <init> : ([C[BII)V
    //   138: ldc 'PBKDF2WithHmacSHA1'
    //   140: invokestatic getInstance : (Ljava/lang/String;)Ljavax/crypto/SecretKeyFactory;
    //   143: aload #5
    //   145: invokevirtual generateSecret : (Ljava/security/spec/KeySpec;)Ljavax/crypto/SecretKey;
    //   148: invokeinterface getEncoded : ()[B
    //   153: astore #5
    //   155: new javax/crypto/spec/SecretKeySpec
    //   158: astore_2
    //   159: aload_2
    //   160: aload #5
    //   162: ldc 'AES'
    //   164: invokespecial <init> : ([BLjava/lang/String;)V
    //   167: ldc 'AES/CBC/PKCS5Padding'
    //   169: invokestatic getInstance : (Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   172: astore #6
    //   174: new javax/crypto/spec/IvParameterSpec
    //   177: astore #5
    //   179: aload #5
    //   181: aload #6
    //   183: invokevirtual getBlockSize : ()I
    //   186: newarray byte
    //   188: invokespecial <init> : ([B)V
    //   191: aload #6
    //   193: iconst_2
    //   194: aload_2
    //   195: aload #5
    //   197: invokevirtual init : (ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   200: aload #6
    //   202: aload_3
    //   203: bipush #16
    //   205: aload_3
    //   206: arraylength
    //   207: bipush #16
    //   209: isub
    //   210: invokevirtual doFinal : ([BII)[B
    //   213: astore_3
    //   214: goto -> 19
    //   217: new java/lang/String
    //   220: astore_2
    //   221: aload_2
    //   222: aload_3
    //   223: invokespecial <init> : ([B)V
    //   226: aload_2
    //   227: invokestatic c : (Ljava/lang/String;)Z
    //   230: istore #4
    //   232: iload #4
    //   234: ifeq -> 34
    //   237: aload_2
    //   238: astore_0
    //   239: goto -> 111
    //   242: astore_0
    //   243: aconst_null
    //   244: astore_0
    //   245: goto -> 111
    // Exception table:
    //   from	to	target	type
    //   0	17	33	java/lang/Exception
    //   23	33	33	java/lang/Exception
    //   34	106	242	java/lang/Exception
    //   113	214	33	java/lang/Exception
    //   217	232	33	java/lang/Exception
  }
  
  private static String b(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return ""; 
    StringBuffer stringBuffer = new StringBuffer(paramArrayOfbyte.length * 2);
    for (byte b = 0; b < paramArrayOfbyte.length; b++) {
      byte b1 = paramArrayOfbyte[b];
      stringBuffer.append("0123456789ABCDEF".charAt(b1 >> 4 & 0xF)).append("0123456789ABCDEF".charAt(b1 & 0xF));
    } 
    return stringBuffer.toString();
  }
  
  private static byte[] b(String paramString) {
    int i = paramString.length() / 2;
    byte[] arrayOfByte = new byte[i];
    for (byte b = 0; b < i; b++)
      arrayOfByte[b] = Integer.valueOf(paramString.substring(b * 2, b * 2 + 2), 16).byteValue(); 
    return arrayOfByte;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\security\mobile\module\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */