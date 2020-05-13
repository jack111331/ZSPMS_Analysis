package com.tencent.mm.opensdk.constants;

public final class Build {
  public static final int EMOJI_SUPPORTED_SDK_INT = 553844737;
  
  public static final int FAVORITE_SUPPPORTED_SDK_INT = 570425345;
  
  public static final int MESSAGE_ACTION_SUPPPORTED_SDK_INT = 570490883;
  
  public static final int MIN_SDK_INT = 553713665;
  
  public static final int MUSIC_DATA_URL_SUPPORTED_SDK_INT = 553910273;
  
  public static final int OPENID_SUPPORTED_SDK_INT = 570425345;
  
  public static final int PAY_SUPPORTED_SDK_INT = 570425345;
  
  public static final int SCAN_QRCODE_AUTH_SUPPORTED_SDK_INT = 587268097;
  
  public static final int SDK_INT = 603979778;
  
  public static final String SDK_VERSION_NAME = "android 4.0.2";
  
  public static final int TIMELINE_SUPPORTED_SDK_INT = 553779201;
  
  private Build() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append(" should not be instantiated");
    throw new RuntimeException(stringBuilder.toString());
  }
  
  public static int getMajorVersion() {
    return 4;
  }
  
  public static int getMinorVersion() {
    return 0;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\constants\Build.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */