package com.qiniu.android.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public final class Dns {
  public static String getAddress(String paramString) {
    String[] arrayOfString = getAddresses(paramString);
    return (arrayOfString == null || arrayOfString.length == 0) ? null : arrayOfString[0];
  }
  
  public static String[] getAddresses(String paramString) {
    byte b = 0;
    try {
      InetAddress[] arrayOfInetAddress = InetAddress.getAllByName(paramString);
      String[] arrayOfString = new String[arrayOfInetAddress.length];
      while (b < arrayOfString.length) {
        arrayOfString[b] = arrayOfInetAddress[b].getHostAddress();
        b++;
      } 
      return arrayOfString;
    } catch (UnknownHostException unknownHostException) {
      unknownHostException.printStackTrace();
      return new String[0];
    } 
  }
  
  public static String getAddressesString(String paramString) {
    return StringUtils.join(getAddresses(paramString), ";");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\androi\\utils\Dns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */