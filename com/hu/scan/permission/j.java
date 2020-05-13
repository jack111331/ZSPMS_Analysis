package com.hu.scan.permission;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class j {
  public static final String a = "android.permission.READ_CALENDAR";
  
  public static final String b = "android.permission.WRITE_CALENDAR";
  
  public static final String c = "android.permission.CAMERA";
  
  public static final String d = "android.permission.READ_CONTACTS";
  
  public static final String e = "android.permission.WRITE_CONTACTS";
  
  public static final String f = "android.permission.GET_ACCOUNTS";
  
  public static final String g = "android.permission.ACCESS_FINE_LOCATION";
  
  public static final String h = "android.permission.ACCESS_COARSE_LOCATION";
  
  public static final String i = "android.permission.RECORD_AUDIO";
  
  public static final String j = "android.permission.READ_PHONE_STATE";
  
  public static final String k = "android.permission.CALL_PHONE";
  
  public static final String l = "android.permission.READ_CALL_LOG";
  
  public static final String m = "android.permission.WRITE_CALL_LOG";
  
  public static final String n = "com.android.voicemail.permission.ADD_VOICEMAIL";
  
  public static final String o = "android.permission.USE_SIP";
  
  public static final String p = "android.permission.PROCESS_OUTGOING_CALLS";
  
  public static final String q = "android.permission.BODY_SENSORS";
  
  public static final String r = "android.permission.SEND_SMS";
  
  public static final String s = "android.permission.RECEIVE_SMS";
  
  public static final String t = "android.permission.READ_SMS";
  
  public static final String u = "android.permission.RECEIVE_WAP_PUSH";
  
  public static final String v = "android.permission.RECEIVE_MMS";
  
  public static final String w = "android.permission.READ_EXTERNAL_STORAGE";
  
  public static final String x = "android.permission.WRITE_EXTERNAL_STORAGE";
  
  public static List<String> a(Context paramContext, List<String> paramList) {
    ArrayList<Context> arrayList = new ArrayList();
    Iterator<String> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      switch ((String)iterator.next()) {
        default:
          continue;
        case "android.permission.READ_EXTERNAL_STORAGE":
        case "android.permission.WRITE_EXTERNAL_STORAGE":
          null = "存储空间";
          if (!arrayList.contains("存储空间"))
            break; 
          continue;
        case "android.permission.SEND_SMS":
        case "android.permission.RECEIVE_SMS":
        case "android.permission.READ_SMS":
        case "android.permission.RECEIVE_WAP_PUSH":
        case "android.permission.RECEIVE_MMS":
          null = "短信";
          if (!arrayList.contains("短信"))
            break; 
          continue;
        case "android.permission.BODY_SENSORS":
          null = "身体传感器";
          if (!arrayList.contains("身体传感器"))
            break; 
          continue;
        case "android.permission.READ_PHONE_STATE":
        case "android.permission.CALL_PHONE":
        case "android.permission.READ_CALL_LOG":
        case "android.permission.WRITE_CALL_LOG":
        case "android.permission.USE_SIP":
        case "android.permission.PROCESS_OUTGOING_CALLS":
          null = "电话";
          if (!arrayList.contains("电话"))
            break; 
          continue;
        case "android.permission.RECORD_AUDIO":
          null = "麦克风";
          if (!arrayList.contains("麦克风"))
            break; 
          continue;
        case "android.permission.ACCESS_FINE_LOCATION":
        case "android.permission.ACCESS_COARSE_LOCATION":
          null = "位置信息";
          if (!arrayList.contains("位置信息"))
            break; 
          continue;
        case "android.permission.READ_CONTACTS":
        case "android.permission.WRITE_CONTACTS":
        case "android.permission.GET_ACCOUNTS":
          null = "通讯录";
          if (!arrayList.contains("通讯录"))
            break; 
          continue;
        case "android.permission.CAMERA":
          null = "相机";
          if (!arrayList.contains("相机"))
            break; 
          continue;
        case "android.permission.READ_CALENDAR":
        case "android.permission.WRITE_CALENDAR":
          null = "日历";
          if (!arrayList.contains("日历"))
            break; 
          continue;
      } 
      arrayList.add(paramContext);
    } 
    return (List)arrayList;
  }
  
  public static List<String> a(Context paramContext, String... paramVarArgs) {
    return a(paramContext, Arrays.asList(paramVarArgs));
  }
  
  public static List<String> a(Context paramContext, String[]... paramVarArgs) {
    ArrayList<String> arrayList = new ArrayList();
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++)
      arrayList.addAll(Arrays.asList(paramVarArgs[b])); 
    return a(paramContext, arrayList);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */