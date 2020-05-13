package com.sina.weibo.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;

public class ApiUtils {
  public static final int BUILD_INT = 10350;
  
  public static final int BUILD_INT_440 = 10355;
  
  public static final int BUILD_INT_VER_2_2 = 10351;
  
  public static final int BUILD_INT_VER_2_3 = 10352;
  
  public static final int BUILD_INT_VER_2_5 = 10353;
  
  private static final String TAG = "com.sina.weibo.sdk.ApiUtils";
  
  private static boolean containSign(Signature[] paramArrayOfSignature, String paramString) {
    if (paramArrayOfSignature == null || paramString == null)
      return false; 
    int i = paramArrayOfSignature.length;
    for (byte b = 0;; b++) {
      if (b >= i)
        return false; 
      if (paramString.equals(MD5.hexdigest(paramArrayOfSignature[b].toByteArray()))) {
        LogUtil.d(TAG, "check pass");
        return true;
      } 
    } 
  }
  
  public static boolean validateWeiboSign(Context paramContext, String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      return containSign(packageInfo.signatures, "18da2bf10352443a00a5e046d9fca6bd");
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return false;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\ApiUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */