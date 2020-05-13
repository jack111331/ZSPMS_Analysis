package com.unionpay.utils;

import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class d {
  private static byte[] a(int paramInt, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    if (paramArrayOfbyte1 == null || (paramArrayOfbyte1.length != 8 && paramArrayOfbyte1.length != 16 && paramArrayOfbyte1.length != 24))
      throw new IllegalArgumentException(); 
    if (paramArrayOfbyte2 == null)
      throw new IllegalArgumentException(); 
    Cipher cipher = Cipher.getInstance("DESede/ECB/NoPadding");
    byte[] arrayOfByte = new byte[24];
    if (paramArrayOfbyte1.length == 8) {
      System.arraycopy(paramArrayOfbyte1, 0, arrayOfByte, 0, 8);
      System.arraycopy(paramArrayOfbyte1, 0, arrayOfByte, 8, 8);
      System.arraycopy(paramArrayOfbyte1, 0, arrayOfByte, 16, 8);
    } else if (paramArrayOfbyte1.length == 16) {
      System.arraycopy(paramArrayOfbyte1, 0, arrayOfByte, 0, 16);
      System.arraycopy(paramArrayOfbyte1, 0, arrayOfByte, 16, 8);
    } else {
      System.arraycopy(paramArrayOfbyte1, 0, arrayOfByte, 0, 24);
    } 
    paramArrayOfbyte1 = paramArrayOfbyte2;
    if (paramArrayOfbyte2.length % 8 != 0) {
      paramArrayOfbyte1 = new byte[(paramArrayOfbyte2.length / 8 + 1) * 8];
      System.arraycopy(paramArrayOfbyte2, 0, paramArrayOfbyte1, 0, paramArrayOfbyte2.length);
      Arrays.fill(paramArrayOfbyte1, paramArrayOfbyte2.length, paramArrayOfbyte1.length, (byte)0);
    } 
    if (paramInt != 0) {
      paramInt = 1;
      cipher.init(paramInt, new SecretKeySpec(arrayOfByte, "DESede"));
      return cipher.doFinal(paramArrayOfbyte1);
    } 
    paramInt = 2;
    cipher.init(paramInt, new SecretKeySpec(arrayOfByte, "DESede"));
    return cipher.doFinal(paramArrayOfbyte1);
  }
  
  public static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    return a(1, paramArrayOfbyte1, paramArrayOfbyte2);
  }
  
  public static byte[] b(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    return a(0, paramArrayOfbyte1, paramArrayOfbyte2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpa\\utils\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */