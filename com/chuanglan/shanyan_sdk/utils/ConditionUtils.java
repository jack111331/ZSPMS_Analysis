package com.chuanglan.shanyan_sdk.utils;

import android.content.Context;
import com.chuanglan.shanyan_sdk.tool.g;
import com.chuanglan.shanyan_sdk.tool.h;
import com.chuanglan.shanyan_sdk.tool.k;

public class ConditionUtils {
  private static void a(int paramInt1, String paramString, int paramInt2) {
    switch (paramInt2) {
      default:
        h.a().a(paramInt1, paramString, paramInt2, paramInt1 + "", "check_error", 0L);
        return;
      case 1:
        g.a().a(paramInt1, paramInt2, paramString, "-1", paramInt1 + "", "check_error");
        return;
      case 2:
        break;
    } 
    k.a().a(paramInt1, paramString, paramInt2, paramInt1 + "", "check_error", 0L, true);
  }
  
  public static boolean isConditionsPermit(Context paramContext, int paramInt1, int paramInt2) {
    boolean bool = false;
    try {
      if (AppNetworkMgr.getMobileDataState(paramContext, null) || AppNetworkMgr.isWifiByType(paramContext)) {
        if (paramInt2 == 1)
          return true; 
        if (!AppSysMgr.getOperatorType(paramContext).equals("Unknown_Operator"))
          return true; 
        a(1020, "非三大运营商，无法使用一键登录功能", paramInt1);
        return bool;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      a(1014, "步骤" + paramInt1 + "出现异常：" + exception.toString(), paramInt1);
      return bool;
    } 
    a(1008, "未开启网络", paramInt1);
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sd\\utils\ConditionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */