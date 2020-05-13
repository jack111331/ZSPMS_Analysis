package cn.com.chinatelecom.account.api.a;

import java.nio.charset.Charset;

public class d {
  private static final String a = d.class.getSimpleName();
  
  private static final Charset b = Charset.forName("UTF-8");
  
  private static byte[] c = "D@^12S".getBytes(b);
  
  public static String a(byte[] paramArrayOfbyte) {
    String str;
    try {
      int i = paramArrayOfbyte.length;
      byte[] arrayOfByte = new byte[i];
      for (byte b = 0; b < i; b++) {
        arrayOfByte[b] = (byte)paramArrayOfbyte[b];
        byte[] arrayOfByte1 = c;
        int j = arrayOfByte1.length;
        for (byte b1 = 0; b1 < j; b1++)
          arrayOfByte[b] = (byte)(byte)(arrayOfByte1[b1] ^ arrayOfByte[b]); 
      } 
      str = new String(arrayOfByte);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
      str = "";
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */