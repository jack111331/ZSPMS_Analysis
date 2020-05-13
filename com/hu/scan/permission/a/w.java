package com.hu.scan.permission.a;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.support.a.aa;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;

public final class w implements n {
  public boolean a(@aa Context paramContext, @aa List<String> paramList) {
    if (Build.VERSION.SDK_INT < 23)
      return true; 
    for (String str : paramList) {
      if (paramContext.checkPermission(str, Process.myPid(), Process.myUid()) == -1)
        return false; 
      str = AppOpsManager.permissionToOp(str);
      if (!TextUtils.isEmpty(str) && ((AppOpsManager)paramContext.getSystemService(AppOpsManager.class)).noteProxyOp(str, paramContext.getPackageName()) != 0)
        return false; 
    } 
    return true;
  }
  
  public boolean a(@aa Context paramContext, @aa String... paramVarArgs) {
    return a(paramContext, Arrays.asList(paramVarArgs));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\a\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */