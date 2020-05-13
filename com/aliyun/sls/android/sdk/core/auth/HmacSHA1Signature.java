package com.aliyun.sls.android.sdk.core.auth;

import com.aliyun.sls.android.sdk.SLSLog;
import com.aliyun.sls.android.sdk.utils.BinaryUtil;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSHA1Signature {
  private static final String ALGORITHM = "HmacSHA1";
  
  private static final String DEFAULT_ENCODING = "UTF-8";
  
  private static final Object LOCK = new Object();
  
  private static final String VERSION = "1";
  
  private static Mac macInstance;
  
  private byte[] sign(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    try {
      Mac mac;
      if (macInstance == null)
        synchronized (LOCK) {
          if (macInstance == null)
            macInstance = Mac.getInstance(getAlgorithm()); 
        }  
      try {
        mac = (Mac)macInstance.clone();
      } catch (CloneNotSupportedException cloneNotSupportedException) {
        mac = Mac.getInstance(getAlgorithm());
      } 
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramArrayOfbyte1, getAlgorithm());
      mac.init(secretKeySpec);
      return mac.doFinal(paramArrayOfbyte2);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new RuntimeException("Unsupported algorithm: HmacSHA1");
    } catch (InvalidKeyException invalidKeyException) {
      throw new RuntimeException("key must not be null");
    } 
  }
  
  public String computeSignature(String paramString1, String paramString2) {
    SLSLog.logDebug(getAlgorithm(), false);
    SLSLog.logDebug(getVersion(), false);
    try {
      return BinaryUtil.toBase64String(sign(paramString1.getBytes("UTF-8"), paramString2.getBytes("UTF-8")));
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new RuntimeException("Unsupported algorithm: UTF-8");
    } 
  }
  
  public String getAlgorithm() {
    return "HmacSHA1";
  }
  
  public String getVersion() {
    return "1";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\core\auth\HmacSHA1Signature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */