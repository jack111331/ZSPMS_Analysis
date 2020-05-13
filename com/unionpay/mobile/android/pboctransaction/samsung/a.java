package com.unionpay.mobile.android.pboctransaction.samsung;

import android.text.TextUtils;
import com.unionpay.mobile.android.pboctransaction.e;
import java.security.PrivateKey;
import javax.crypto.Cipher;

public final class a {
  public static String a(PrivateKey paramPrivateKey, String paramString) {
    String str1 = "";
    String str2 = str1;
    if (!TextUtils.isEmpty(paramString)) {
      if (paramPrivateKey == null)
        return str1; 
    } else {
      return str2;
    } 
    try {
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      byte[] arrayOfByte = new byte[245];
      System.arraycopy(paramString.getBytes(), 0, arrayOfByte, 0, (paramString.getBytes()).length);
      cipher.init(1, paramPrivateKey);
      String str = e.a(cipher.doFinal(arrayOfByte));
    } catch (Exception exception) {
      exception.printStackTrace();
      str2 = str1;
    } 
    return str2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\samsung\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */