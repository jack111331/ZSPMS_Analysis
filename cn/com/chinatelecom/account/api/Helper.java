package cn.com.chinatelecom.account.api;

import android.content.Context;

public final class Helper {
  static {
    System.loadLibrary("CtaApiLib");
  }
  
  public static native String cemnetwul();
  
  public static native String cemppmul();
  
  public static native String cepahsul();
  
  public static native String cinetw(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5);
  
  public static native byte[] dnenwret(byte[] paramArrayOfbyte, String paramString);
  
  public static native String dnepah(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4);
  
  public static native String dnepmo(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4);
  
  public static native byte[] dnepmret(byte[] paramArrayOfbyte, String paramString);
  
  public static native String testEncrypt(String paramString1, String paramString2);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\Helper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */