package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.Cipher;

public class g {
  static String a(Context paramContext, String paramString) {
    null = b(paramContext);
    return (null != null) ? a.a(null, paramString) : null;
  }
  
  public static boolean a(Context paramContext) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc com/cmic/sso/sdk/utils/g
    //   4: monitorenter
    //   5: ldc 'AndroidKeyStore'
    //   7: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/KeyStore;
    //   10: astore_2
    //   11: aload_2
    //   12: aconst_null
    //   13: invokevirtual load : (Ljava/security/KeyStore$LoadStoreParameter;)V
    //   16: aload_2
    //   17: ldc 'CMCC_SDK'
    //   19: invokevirtual getCertificate : (Ljava/lang/String;)Ljava/security/cert/Certificate;
    //   22: astore_2
    //   23: aload_2
    //   24: ifnull -> 47
    //   27: ldc com/cmic/sso/sdk/utils/g
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: astore_0
    //   33: ldc 'KeystoreUtil'
    //   35: aload_0
    //   36: invokevirtual getMessage : ()Ljava/lang/String;
    //   39: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   42: iconst_0
    //   43: istore_1
    //   44: goto -> 27
    //   47: getstatic android/os/Build$VERSION.SDK_INT : I
    //   50: istore_3
    //   51: iload_3
    //   52: bipush #23
    //   54: if_icmplt -> 142
    //   57: ldc 'RSA'
    //   59: ldc 'AndroidKeyStore'
    //   61: invokestatic getInstance : (Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyPairGenerator;
    //   64: astore_0
    //   65: new android/security/keystore/KeyGenParameterSpec$Builder
    //   68: astore_2
    //   69: aload_2
    //   70: ldc 'CMCC_SDK'
    //   72: iconst_3
    //   73: invokespecial <init> : (Ljava/lang/String;I)V
    //   76: aload_0
    //   77: aload_2
    //   78: iconst_2
    //   79: anewarray java/lang/String
    //   82: dup
    //   83: iconst_0
    //   84: ldc 'SHA-256'
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: ldc 'SHA-512'
    //   91: aastore
    //   92: invokevirtual setDigests : ([Ljava/lang/String;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   95: iconst_1
    //   96: anewarray java/lang/String
    //   99: dup
    //   100: iconst_0
    //   101: ldc 'PKCS1Padding'
    //   103: aastore
    //   104: invokevirtual setEncryptionPaddings : ([Ljava/lang/String;)Landroid/security/keystore/KeyGenParameterSpec$Builder;
    //   107: invokevirtual build : ()Landroid/security/keystore/KeyGenParameterSpec;
    //   110: invokevirtual initialize : (Ljava/security/spec/AlgorithmParameterSpec;)V
    //   113: ldc2_w 1000
    //   116: invokestatic sleep : (J)V
    //   119: aload_0
    //   120: invokevirtual generateKeyPair : ()Ljava/security/KeyPair;
    //   123: pop
    //   124: goto -> 27
    //   127: astore_0
    //   128: ldc 'KeystoreUtil'
    //   130: aload_0
    //   131: invokevirtual getMessage : ()Ljava/lang/String;
    //   134: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   137: iconst_0
    //   138: istore_1
    //   139: goto -> 27
    //   142: invokestatic getInstance : ()Ljava/util/Calendar;
    //   145: astore #4
    //   147: invokestatic getInstance : ()Ljava/util/Calendar;
    //   150: astore_2
    //   151: aload_2
    //   152: iconst_1
    //   153: bipush #30
    //   155: invokevirtual add : (II)V
    //   158: getstatic android/os/Build$VERSION.SDK_INT : I
    //   161: bipush #18
    //   163: if_icmplt -> 270
    //   166: new android/security/KeyPairGeneratorSpec$Builder
    //   169: astore #5
    //   171: aload #5
    //   173: aload_0
    //   174: invokespecial <init> : (Landroid/content/Context;)V
    //   177: aload #5
    //   179: ldc 'CMCC_SDK'
    //   181: invokevirtual setAlias : (Ljava/lang/String;)Landroid/security/KeyPairGeneratorSpec$Builder;
    //   184: astore_0
    //   185: new javax/security/auth/x500/X500Principal
    //   188: astore #5
    //   190: aload #5
    //   192: ldc 'CN=CMCC_SDK'
    //   194: invokespecial <init> : (Ljava/lang/String;)V
    //   197: aload_0
    //   198: aload #5
    //   200: invokevirtual setSubject : (Ljavax/security/auth/x500/X500Principal;)Landroid/security/KeyPairGeneratorSpec$Builder;
    //   203: getstatic java/math/BigInteger.TEN : Ljava/math/BigInteger;
    //   206: invokevirtual setSerialNumber : (Ljava/math/BigInteger;)Landroid/security/KeyPairGeneratorSpec$Builder;
    //   209: aload #4
    //   211: invokevirtual getTime : ()Ljava/util/Date;
    //   214: invokevirtual setStartDate : (Ljava/util/Date;)Landroid/security/KeyPairGeneratorSpec$Builder;
    //   217: aload_2
    //   218: invokevirtual getTime : ()Ljava/util/Date;
    //   221: invokevirtual setEndDate : (Ljava/util/Date;)Landroid/security/KeyPairGeneratorSpec$Builder;
    //   224: invokevirtual build : ()Landroid/security/KeyPairGeneratorSpec;
    //   227: astore_0
    //   228: ldc 'RSA'
    //   230: ldc 'AndroidKeyStore'
    //   232: invokestatic getInstance : (Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyPairGenerator;
    //   235: astore_2
    //   236: aload_2
    //   237: aload_0
    //   238: invokevirtual initialize : (Ljava/security/spec/AlgorithmParameterSpec;)V
    //   241: ldc2_w 1000
    //   244: invokestatic sleep : (J)V
    //   247: aload_2
    //   248: invokevirtual generateKeyPair : ()Ljava/security/KeyPair;
    //   251: pop
    //   252: goto -> 27
    //   255: astore_0
    //   256: ldc 'KeystoreUtil'
    //   258: aload_0
    //   259: invokevirtual getMessage : ()Ljava/lang/String;
    //   262: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   265: iconst_0
    //   266: istore_1
    //   267: goto -> 27
    //   270: iconst_0
    //   271: istore_1
    //   272: goto -> 27
    //   275: astore_0
    //   276: ldc com/cmic/sso/sdk/utils/g
    //   278: monitorexit
    //   279: aload_0
    //   280: athrow
    // Exception table:
    //   from	to	target	type
    //   5	23	32	java/lang/Exception
    //   5	23	275	finally
    //   33	42	275	finally
    //   47	51	275	finally
    //   57	124	127	java/lang/Exception
    //   57	124	275	finally
    //   128	137	275	finally
    //   142	158	275	finally
    //   158	252	255	java/lang/Exception
    //   158	252	275	finally
    //   256	265	275	finally
  }
  
  private static byte[] a() {
    byte[] arrayOfByte = new byte[16];
    (new SecureRandom()).nextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  static String b(Context paramContext, String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      byte[] arrayOfByte = b(paramContext);
      if (arrayOfByte != null)
        return a.b(arrayOfByte, paramString); 
    } 
    return null;
  }
  
  private static byte[] b(Context paramContext) {
    Context context = null;
    try {
      PublicKey publicKey;
      KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
      keyStore.load(null);
      if (TextUtils.isEmpty(c(paramContext))) {
        if (!a(paramContext))
          return (byte[])context; 
        byte[] arrayOfByte = a();
        publicKey = keyStore.getCertificate("CMCC_SDK").getPublicKey();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKey);
        c(paramContext, Base64.encodeToString(cipher.doFinal(arrayOfByte), 0));
        return arrayOfByte;
      } 
      String str = c(paramContext);
      if (!TextUtils.isEmpty(str)) {
        byte[] arrayOfByte1;
        byte[] arrayOfByte2 = Base64.decode(str, 0);
        PrivateKey privateKey = (PrivateKey)publicKey.getKey("CMCC_SDK", null);
        Context context1 = context;
        if (privateKey != null) {
          Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
          cipher.init(2, privateKey);
          arrayOfByte1 = cipher.doFinal(arrayOfByte2);
        } 
        return arrayOfByte1;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return (byte[])context;
    } 
    return null;
  }
  
  private static String c(Context paramContext) {
    return r.b(paramContext, "AES_KEY", "");
  }
  
  private static void c(Context paramContext, String paramString) {
    r.a(paramContext, "AES_KEY", paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */