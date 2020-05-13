package com.xy.whf.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.TrafficStats;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
  private static long a(int paramInt) {
    File file = new File(new File("/proc/uid_stat/" + paramInt), "tcp_snd");
    String str1 = "0";
    String str2 = str1;
    try {
      BufferedReader bufferedReader = new BufferedReader();
      str2 = str1;
      FileReader fileReader = new FileReader();
      str2 = str1;
      this(file);
      str2 = str1;
      this(fileReader);
      while (true) {
        str2 = str1;
        String str = bufferedReader.readLine();
        if (str != null) {
          str1 = str;
          continue;
        } 
        break;
      } 
    } catch (Exception exception) {
      str1 = str2;
    } 
    return Long.parseLong(str1);
  }
  
  public static JSONArray a(Context paramContext) {
    JSONArray jSONArray = new JSONArray();
    try {
      List list = paramContext.getPackageManager().getInstalledPackages(0);
      if (list != null && list.size() > 0)
        for (PackageInfo packageInfo : list) {
          JSONObject jSONObject = new JSONObject();
          this();
          if ((packageInfo.applicationInfo.flags & 0x1) == 0) {
            jSONObject.put("app_name", packageInfo.applicationInfo.loadLabel(paramContext.getPackageManager()).toString());
            jSONObject.put("package_name", packageInfo.packageName);
            jSONObject.put("app_version", packageInfo.versionName);
            long l1 = TrafficStats.getUidTxBytes(packageInfo.applicationInfo.uid);
            long l2 = TrafficStats.getUidRxBytes(packageInfo.applicationInfo.uid);
            long l3 = l1;
            if (l1 <= 0L)
              l3 = a(packageInfo.applicationInfo.uid); 
            if (l2 <= 0L)
              l2 = b(packageInfo.applicationInfo.uid); 
            StringBuilder stringBuilder = new StringBuilder();
            this();
            jSONObject.put("tx_bytes", stringBuilder.append("").append(l3).toString());
            stringBuilder = new StringBuilder();
            this();
            jSONObject.put("rx_bytes", stringBuilder.append("").append(l2).toString());
            jSONArray.put(jSONObject);
          } 
        }  
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return jSONArray;
  }
  
  private static long b(int paramInt) {
    File file = new File(new File("/proc/uid_stat/" + paramInt), "tcp_rcv");
    String str1 = "0";
    String str2 = str1;
    try {
      BufferedReader bufferedReader = new BufferedReader();
      str2 = str1;
      FileReader fileReader = new FileReader();
      str2 = str1;
      this(file);
      str2 = str1;
      this(fileReader);
      while (true) {
        str2 = str1;
        String str = bufferedReader.readLine();
        if (str != null) {
          str1 = str;
          continue;
        } 
        break;
      } 
    } catch (Exception exception) {
      str1 = str2;
    } 
    return Long.parseLong(str1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */