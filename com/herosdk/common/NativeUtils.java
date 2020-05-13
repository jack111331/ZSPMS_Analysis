package com.herosdk.common;

public class NativeUtils {
  static {
    System.loadLibrary("huclayer");
  }
  
  public static native String gask();
  
  public static native String gpvk();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\common\NativeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */