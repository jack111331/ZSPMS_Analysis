package com.tencent.wxop.stat.b;

import java.io.File;

final class p {
  private static int aI = -1;
  
  public static boolean a() {
    boolean bool = true;
    if (aI != 1) {
      if (aI == 0)
        return false; 
      String[] arrayOfString = new String[6];
      arrayOfString[0] = "/bin";
      arrayOfString[1] = "/system/bin/";
      arrayOfString[2] = "/system/xbin/";
      arrayOfString[3] = "/system/sbin/";
      arrayOfString[4] = "/sbin/";
      arrayOfString[5] = "/vendor/bin/";
      for (byte b = 0;; b++) {
        try {
          if (b < arrayOfString.length) {
            File file = new File();
            StringBuilder stringBuilder = new StringBuilder();
            this();
            this(stringBuilder.append(arrayOfString[b]).append("su").toString());
            if (file.exists()) {
              aI = 1;
              return bool;
            } 
            continue;
          } 
        } catch (Exception exception) {}
        aI = 0;
        return false;
      } 
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\b\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */