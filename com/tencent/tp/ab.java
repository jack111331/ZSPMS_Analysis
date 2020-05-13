package com.tencent.tp;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Process;
import com.tencent.tp.a.a;
import java.util.List;

class ab {
  public ab(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void a(Context paramContext) {
    Process.setThreadPriority(10);
    Throwable throwable1 = null;
    try {
      aa aa = new aa();
      this();
    } catch (Throwable throwable2) {
      try {
        u.c("EXCEPTION:CRETAE_INFO_REPORT_OBJ");
      } catch (Throwable throwable) {}
      throwable2 = null;
    } 
    if (throwable2 == null)
      return; 
    try {
      throwable2.a(paramContext);
    } catch (Throwable throwable) {
      try {
        u.c("EXCEPTION:INIT_INFO_REPORT_OBJ");
        throwable2 = throwable1;
      } catch (Throwable throwable3) {
        throwable2 = throwable1;
      } 
    } 
    try {
      throwable2.a();
    } catch (Throwable throwable) {
      try {
        u.c("EXCEPTION:REPORT_DEVICES_INFO");
      } catch (Throwable throwable3) {}
    } 
  }
  
  public void a(Context paramContext, boolean paramBoolean) {
    List list = k.a().m(paramContext);
    if (list == null)
      return; 
    for (PackageInfo packageInfo : list) {
      if (packageInfo == null || (paramBoolean && (packageInfo.applicationInfo.flags & 0x1) > 0))
        continue; 
      String str1 = packageInfo.applicationInfo.packageName;
      String str2 = (new a(paramContext, str1)).a();
      if (str2 == null)
        continue; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("moduls=");
      stringBuilder.append(str2);
      stringBuilder.append("|name=");
      stringBuilder.append(str1);
      u.a(stringBuilder.toString());
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */