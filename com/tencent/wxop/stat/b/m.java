package com.tencent.wxop.stat.b;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

final class m {
  static int D() {
    byte b2;
    byte b1 = 0;
    String str = "";
    try {
      ProcessBuilder processBuilder = new ProcessBuilder();
      this(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq" });
      InputStream inputStream = processBuilder.start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (inputStream.read(arrayOfByte) != -1) {
        StringBuilder stringBuilder2 = new StringBuilder();
        this();
        StringBuilder stringBuilder1 = stringBuilder2.append(str);
        String str2 = new String();
        this(arrayOfByte);
        str1 = stringBuilder1.append(str2).toString();
      } 
      inputStream.close();
      String str1 = str1.trim();
      b2 = b1;
      if (str1.length() > 0)
        b2 = Integer.valueOf(str1).intValue(); 
    } catch (Throwable throwable) {
      l.K().b(throwable);
      b2 = b1;
    } 
    return b2 * 1000;
  }
  
  static int aA() {
    byte b2;
    byte b1 = 0;
    String str = "";
    try {
      ProcessBuilder processBuilder = new ProcessBuilder();
      this(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" });
      InputStream inputStream = processBuilder.start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (inputStream.read(arrayOfByte) != -1) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder = stringBuilder.append(str);
        str = new String();
        this(arrayOfByte);
        str = stringBuilder.append(str).toString();
      } 
      inputStream.close();
      str = str.trim();
      b2 = b1;
      if (str.length() > 0)
        b2 = Integer.valueOf(str).intValue(); 
    } catch (Exception exception) {
      l.K().b(exception);
      b2 = b1;
    } 
    return b2 * 1000;
  }
  
  static String ax() {
    byte b = 2;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    try {
      FileReader fileReader = new FileReader();
      this("/proc/cpuinfo");
      BufferedReader bufferedReader = new BufferedReader();
      this(fileReader, 8192);
      String[] arrayOfString1 = bufferedReader.readLine().split("\\s+");
      while (b < arrayOfString1.length) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        arrayOfString[0] = stringBuilder.append(arrayOfString[0]).append(arrayOfString1[b]).append(" ").toString();
        b++;
      } 
      bufferedReader.close();
    } catch (IOException iOException) {}
    return arrayOfString[0];
  }
  
  static int r() {
    boolean bool;
    try {
      File file = new File();
      this("/sys/devices/system/cpu/");
      n n = new n();
      this();
      bool = (file.listFiles(n)).length;
    } catch (Exception exception) {
      exception.printStackTrace();
      bool = true;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\b\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */