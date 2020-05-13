package cn.com.chinatelecom.account.api.a;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class b {
  private static String a = "RSA/ECB/PKCS1Padding";
  
  public static String a(String paramString, RSAPublicKey paramRSAPublicKey) {
    String str;
    try {
      paramString = c.a(a(paramRSAPublicKey, paramString.getBytes()));
    } catch (Exception exception) {
      exception.printStackTrace();
      str = "";
    } 
    return str;
  }
  
  public static PublicKey a(String paramString) {
    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(a.a(paramString));
    return KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
  }
  
  public static byte[] a(RSAPublicKey paramRSAPublicKey, byte[] paramArrayOfbyte) {
    if (paramRSAPublicKey == null)
      throw new Exception("加密公钥为空, 请设置"); 
    try {
      Cipher cipher = Cipher.getInstance(a);
      cipher.init(1, paramRSAPublicKey);
      return cipher.doFinal(paramArrayOfbyte);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new Exception("无此加密算法");
    } catch (NoSuchPaddingException null) {
      null.printStackTrace();
      return null;
    } catch (InvalidKeyException invalidKeyException) {
      throw new Exception("加密公钥非法,请检查");
    } catch (IllegalBlockSizeException illegalBlockSizeException) {
      throw new Exception("明文长度非法");
    } catch (BadPaddingException badPaddingException) {
      throw new Exception("明文数据已损坏");
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */