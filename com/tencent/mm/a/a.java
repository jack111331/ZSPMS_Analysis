package com.tencent.mm.a;

import android.util.Base64;
import javax.crypto.Cipher;

public final class a {
  private Cipher j;
  
  public final String h(String paramString) {
    try {
      byte[] arrayOfByte1 = Base64.decode(paramString, 0);
      byte[] arrayOfByte2 = this.j.doFinal(arrayOfByte1);
      String str = new String();
      this(arrayOfByte2, "UTF8");
      paramString = str;
    } catch (Exception exception) {
      paramString = "[des]" + paramString + "|" + exception.toString();
    } 
    return paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */