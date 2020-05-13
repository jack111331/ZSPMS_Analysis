package cn.com.chinatelecom.account.api.a;

public class c {
  private static final char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < paramArrayOfbyte.length; b++)
      stringBuilder.append(a[paramArrayOfbyte[b] >> 4 & 0xF]).append(a[paramArrayOfbyte[b] & 0xF]); 
    return stringBuilder.toString();
  }
  
  public static byte[] a(String paramString) {
    if (paramString == null)
      return null; 
    char[] arrayOfChar = paramString.toCharArray();
    int i = arrayOfChar.length / 2;
    byte[] arrayOfByte = new byte[i];
    byte b = 0;
    while (true) {
      if (b < i) {
        int j = Character.digit(arrayOfChar[b * 2], 16) << 4 | Character.digit(arrayOfChar[b * 2 + 1], 16);
        int k = j;
        if (j > 127)
          k = j - 256; 
        arrayOfByte[b] = (byte)(byte)k;
        b++;
        continue;
      } 
      return arrayOfByte;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */