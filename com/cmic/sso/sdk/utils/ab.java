package com.cmic.sso.sdk.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class ab {
  public static String a() {
    StringBuilder stringBuilder1 = new StringBuilder();
    try {
      Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
      while (enumeration.hasMoreElements()) {
        Enumeration<InetAddress> enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
        while (enumeration1.hasMoreElements()) {
          InetAddress inetAddress = enumeration1.nextElement();
          if (!inetAddress.isLoopbackAddress() && inetAddress instanceof java.net.Inet4Address)
            stringBuilder1.append(inetAddress.getHostAddress()).append(","); 
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
    StringBuilder stringBuilder3 = stringBuilder1.delete(stringBuilder1.length() - 1, stringBuilder1.length());
    StringBuilder stringBuilder2 = new StringBuilder();
    this();
    h.b("UmcIPUtils", stringBuilder2.append("IPV4 ip：").append(stringBuilder3).toString());
    return stringBuilder3.toString();
  }
  
  public static String b() {
    StringBuilder stringBuilder1 = new StringBuilder();
    try {
      Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
      while (enumeration.hasMoreElements()) {
        Enumeration<InetAddress> enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
        while (enumeration1.hasMoreElements()) {
          InetAddress inetAddress = enumeration1.nextElement();
          if (!inetAddress.isLoopbackAddress() && inetAddress instanceof java.net.Inet6Address && !inetAddress.isLinkLocalAddress())
            stringBuilder1.append(inetAddress.getHostAddress()).append(","); 
        } 
      } 
    } catch (SocketException socketException) {
      socketException.printStackTrace();
      return "";
    } 
    if (stringBuilder1.length() > 1)
      stringBuilder1 = stringBuilder1.delete(stringBuilder1.length() - 1, stringBuilder1.length()); 
    StringBuilder stringBuilder2 = new StringBuilder();
    this();
    h.b("UmcIPUtils", stringBuilder2.append("IPV6 ip：").append(stringBuilder1).toString());
    return stringBuilder1.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */