package com.sdk.base.framework.c;

import android.content.Context;
import android.os.Build;
import com.sdk.base.framework.bean.AInfo;
import com.sdk.base.framework.bean.KInfo;
import com.sdk.base.framework.bean.PInfo;
import com.sdk.base.framework.bean.SInfo;
import com.sdk.base.framework.utils.app.AppUtils;
import com.sdk.base.framework.utils.b.b;
import com.sdk.base.module.config.BaseConfig;
import java.util.ArrayList;

public class a {
  private static boolean a = false;
  
  private static String b = "";
  
  private static String c = "";
  
  public static AInfo a(Context paramContext) {
    AInfo aInfo = new AInfo();
    aInfo.setN(AppUtils.getAppLable(paramContext));
    aInfo.setC(AppUtils.getVersionCode(paramContext));
    aInfo.setV(AppUtils.getVersionName(paramContext));
    if (a) {
      aInfo.setPk(c);
      aInfo.setMd5(b);
      return aInfo;
    } 
    aInfo.setPk(AppUtils.getPackageName(paramContext));
    aInfo.setMd5(AppUtils.getAppMd5(paramContext));
    return aInfo;
  }
  
  public static SInfo a() {
    SInfo sInfo = new SInfo();
    sInfo.setN(BaseConfig.n);
    sInfo.setC(BaseConfig.c);
    sInfo.setV(BaseConfig.v);
    sInfo.setCm(BaseConfig.cm);
    return sInfo;
  }
  
  public static ArrayList<KInfo> b(Context paramContext) {
    return com.sdk.base.framework.utils.b.a.a(paramContext);
  }
  
  public static PInfo c(Context paramContext) {
    PInfo pInfo = new PInfo();
    pInfo.setN(Build.MODEL);
    pInfo.setOs("Android");
    pInfo.setC(Build.VERSION.RELEASE);
    pInfo.setMac(b.b(paramContext));
    pInfo.setImei(b.a(paramContext));
    return pInfo;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */