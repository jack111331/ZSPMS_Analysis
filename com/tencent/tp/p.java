package com.tencent.tp;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import java.util.List;

public class p extends AsyncTask {
  private static long a;
  
  private Context b;
  
  public p(Context paramContext) {
    this.b = paramContext;
  }
  
  public static void a(Context paramContext) {
    u.a("i_beg");
    try {
      b(paramContext);
    } catch (Throwable throwable) {}
    u.a("i_end");
  }
  
  public static void b(Context paramContext) {
    long l = System.currentTimeMillis() / 1000L;
    if (l - a < 180L)
      return; 
    a = l;
    List list = k.a().m(paramContext);
    if (list == null)
      return; 
    for (PackageInfo packageInfo : list) {
      String str;
      if (packageInfo == null)
        continue; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("apk_name=");
      stringBuilder.append(packageInfo.applicationInfo.packageName);
      stringBuilder.append("|apk_path=");
      stringBuilder.append(packageInfo.applicationInfo.sourceDir);
      stringBuilder.append("|is_sys=");
      if ((packageInfo.applicationInfo.flags & 0x1) > 0) {
        str = "1";
      } else {
        str = "0";
      } 
      stringBuilder.append(str);
      stringBuilder.append("|is_ext=");
      if (packageInfo.packageName == null) {
        str = "1";
      } else {
        str = "0";
      } 
      stringBuilder.append(str);
      u.a(stringBuilder.toString());
    } 
  }
  
  protected Void a(Void... paramVarArgs) {
    a(this.b);
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */