package com.tencent.mm.opensdk.b;

import java.security.MessageDigest;

public final class b {
  public static final String c(byte[] paramArrayOfbyte) {
    char[] arrayOfChar = new char[16];
    arrayOfChar[0] = '0';
    arrayOfChar[1] = '1';
    arrayOfChar[2] = '2';
    arrayOfChar[3] = '3';
    arrayOfChar[4] = '4';
    arrayOfChar[5] = '5';
    arrayOfChar[6] = '6';
    arrayOfChar[7] = '7';
    arrayOfChar[8] = '8';
    arrayOfChar[9] = '9';
    arrayOfChar[10] = 'a';
    arrayOfChar[11] = 'b';
    arrayOfChar[12] = 'c';
    arrayOfChar[13] = 'd';
    arrayOfChar[14] = 'e';
    arrayOfChar[15] = 'f';
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramArrayOfbyte);
      paramArrayOfbyte = messageDigest.digest();
      int i = paramArrayOfbyte.length;
      char[] arrayOfChar1 = new char[i * 2];
      byte b1 = 0;
      int j = 0;
      while (b1 < i) {
        byte b2 = paramArrayOfbyte[b1];
        int k = j + 1;
        arrayOfChar1[j] = (char)arrayOfChar[b2 >>> 4 & 0xF];
        j = k + 1;
        arrayOfChar1[k] = (char)arrayOfChar[b2 & 0xF];
        b1++;
      } 
      return new String(arrayOfChar1);
    } catch (Exception exception) {
      return null;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */