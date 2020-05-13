package com.alipay.apmobilesecuritysdk.otherid;

import android.content.Context;

public class UmidSdkWrapper {
  private static final String UMIDTOKEN_FILE_NAME = "xxxwww_v2";
  
  private static final String UMIDTOKEN_KEY_NAME = "umidtk";
  
  private static volatile String cachedUmidToken = "";
  
  private static volatile boolean initUmidFinished = false;
  
  private static String compatUmidBug(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic a : (Ljava/lang/String;)Z
    //   4: ifne -> 18
    //   7: aload_1
    //   8: astore_2
    //   9: aload_1
    //   10: ldc '000000000000000000000000'
    //   12: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Z
    //   15: ifeq -> 57
    //   18: aload_0
    //   19: invokestatic getUtdid : (Landroid/content/Context;)Ljava/lang/String;
    //   22: astore_1
    //   23: aload_1
    //   24: astore_0
    //   25: aload_1
    //   26: ifnull -> 43
    //   29: aload_1
    //   30: astore_0
    //   31: aload_1
    //   32: ldc '?'
    //   34: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   37: ifeq -> 43
    //   40: ldc ''
    //   42: astore_0
    //   43: aload_0
    //   44: astore_1
    //   45: aload_0
    //   46: invokestatic a : (Ljava/lang/String;)Z
    //   49: ifeq -> 55
    //   52: ldc ''
    //   54: astore_1
    //   55: aload_1
    //   56: astore_2
    //   57: aload_2
    //   58: areturn
  }
  
  public static String getSecurityToken(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/otherid/UmidSdkWrapper
    //   2: monitorenter
    //   3: getstatic com/alipay/apmobilesecuritysdk/otherid/UmidSdkWrapper.cachedUmidToken : Ljava/lang/String;
    //   6: astore_0
    //   7: ldc com/alipay/apmobilesecuritysdk/otherid/UmidSdkWrapper
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/alipay/apmobilesecuritysdk/otherid/UmidSdkWrapper
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static String startUmidTaskSync(Context paramContext, int paramInt) {
    return "";
  }
  
  private static void updateLocalUmidToken(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/otherid/UmidSdkWrapper
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic b : (Ljava/lang/String;)Z
    //   7: ifeq -> 23
    //   10: aload_0
    //   11: ldc 'xxxwww_v2'
    //   13: ldc 'umidtk'
    //   15: aload_1
    //   16: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_1
    //   20: putstatic com/alipay/apmobilesecuritysdk/otherid/UmidSdkWrapper.cachedUmidToken : Ljava/lang/String;
    //   23: ldc com/alipay/apmobilesecuritysdk/otherid/UmidSdkWrapper
    //   25: monitorexit
    //   26: return
    //   27: astore_0
    //   28: ldc com/alipay/apmobilesecuritysdk/otherid/UmidSdkWrapper
    //   30: monitorexit
    //   31: aload_0
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   3	23	27	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\otherid\UmidSdkWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */