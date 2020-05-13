package com.jdpaysdk.author.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.util.ArrayList;
import java.util.List;

public class a {
  public static boolean a(Context paramContext, String paramString) {
    List list = paramContext.getPackageManager().getInstalledPackages(0);
    ArrayList<String> arrayList = new ArrayList();
    if (list != null)
      for (byte b = 0; b < list.size(); b++)
        arrayList.add(((PackageInfo)list.get(b)).packageName);  
    return arrayList.contains(paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */