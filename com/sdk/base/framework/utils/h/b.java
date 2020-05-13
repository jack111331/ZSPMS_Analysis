package com.sdk.base.framework.utils.h;

import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.a;
import com.sdk.base.framework.utils.i.c;
import com.sdk.base.framework.utils.k.a;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class b extends a {
  public static String a;
  
  private static final String b = b.class.getSimpleName();
  
  private static Boolean c;
  
  static {
    a = "RSA/ECB/PKCS1Padding";
    c = Boolean.valueOf(c.h);
  }
  
  public static String a(String paramString1, String paramString2) {
    RSAPublicKey rSAPublicKey = (RSAPublicKey)a.a(paramString2);
    if (a.a(paramString1).booleanValue())
      throw new Exception("rsaAes key is null"); 
    return (new String(a(rSAPublicKey, c.a(paramString1)), Charset.defaultCharset())).trim();
  }
  
  public static byte[] a(RSAPublicKey paramRSAPublicKey, byte[] paramArrayOfbyte) {
    if (paramRSAPublicKey == null)
      throw new Exception("解密公钥为空, 请设置"); 
    try {
      Cipher cipher = Cipher.getInstance(a);
      cipher.init(2, paramRSAPublicKey);
      return cipher.doFinal(paramArrayOfbyte);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new NoSuchAlgorithmException("无此解密算法");
    } catch (NoSuchPaddingException noSuchPaddingException) {
      throw new NoSuchPaddingException("解密出错！不支持该填充机制");
    } catch (InvalidKeyException invalidKeyException) {
      throw new InvalidKeyException("解密公钥非法,请检查");
    } catch (IllegalBlockSizeException illegalBlockSizeException) {
      throw new IllegalBlockSizeException("密文长度非法");
    } catch (BadPaddingException badPaddingException) {
      throw new BadPaddingException("密文数据已损坏");
    } 
  }
  
  public static String b(String paramString1, String paramString2) {
    PublicKey publicKey = a.a(paramString1);
    Cipher cipher = Cipher.getInstance(a);
    cipher.init(1, publicKey);
    return c.a(cipher.doFinal(paramString2.getBytes(Charset.defaultCharset()))).toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */