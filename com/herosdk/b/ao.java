package com.herosdk.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.herosdk.c.c;
import com.herosdk.d.b;
import com.herosdk.d.bb;
import com.herosdk.d.k;
import com.herosdk.d.m;
import com.herosdk.d.o;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ao {
  public static String a = "";
  
  private static final String b = "frameLib.hus";
  
  private static final String c = "sign";
  
  public static String a(String paramString) {
    String str = paramString;
    if (paramString.length() > 51)
      str = new String(a(paramString.toCharArray(), new int[] { 1, 7, 26, 4, 14, 38, 43, 51 })); 
    return new String(Base64.decode(str.getBytes(), 2));
  }
  
  public static String a(String paramString, Map<String, String> paramMap) {
    ArrayList<Comparable> arrayList = new ArrayList(paramMap.keySet());
    arrayList.remove("sign");
    Collections.sort(arrayList);
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < arrayList.size(); b++) {
      String str1 = (String)arrayList.get(b);
      String str2 = ((String)paramMap.get(str1)).toString();
      if (str1 != null && str1.length() > 0)
        stringBuilder.append(str1).append("=").append(str2).append('&'); 
    } 
    stringBuilder.append(paramString);
    return o.a(stringBuilder.toString());
  }
  
  public static String a(String paramString, String... paramVarArgs) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (byte b = 1; b < paramVarArgs.length; b += 2) {
      if (paramVarArgs[b] != null && paramVarArgs[b - 1] != null)
        hashMap.put(paramVarArgs[b - 1], paramVarArgs[b]); 
    } 
    return a(paramString, (Map)hashMap);
  }
  
  public static String a(Map<String, Object> paramMap) {
    byte[] arrayOfByte;
    ArrayList<Comparable> arrayList = new ArrayList(paramMap.keySet());
    JSONObject jSONObject = new JSONObject();
    Collections.sort(arrayList);
    for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
      String str = (String)entry.getKey();
      if (str == null)
        throw new NullPointerException("key == null"); 
      jSONObject.put(str, entry.getValue());
    } 
    String str2 = x.a().z();
    if (!TextUtils.isEmpty(str2)) {
      arrayOfByte = b.b(jSONObject.toString(), str2);
    } else {
      arrayOfByte = jSONObject.toString().getBytes();
    } 
    String str3 = Base64.encodeToString(arrayOfByte, 2);
    String str1 = str3;
    if (str3.length() > 51)
      str1 = new String(a(str3.toCharArray(), new int[] { 1, 33, 10, 42, 18, 50, 19, 51 })); 
    return str1;
  }
  
  public static void a(Context paramContext, HashMap<String, Object> paramHashMap) {
    if (paramContext == null) {
      Log.e("frameLib.hus", "context is null, return");
      return;
    } 
    if (paramHashMap == null) {
      Log.e("frameLib.hus", "mapParams is null, return");
      return;
    } 
    try {
      String str;
      m m = m.a(paramContext);
      paramHashMap.put("cid", String.valueOf(k.a().d()));
      paramHashMap.put("channel", k.a().b());
      paramHashMap.put("pk", x.a().y());
      paramHashMap.put("vc", String.valueOf(bb.a(paramContext)));
      paramHashMap.put("vn", bb.b(paramContext));
      paramHashMap.put("svc", "204");
      paramHashMap.put("svn", "2.0.4");
      paramHashMap.put("cn", x.a().w());
      paramHashMap.put("plat", "0");
      paramHashMap.put("dn", m.b());
      paramHashMap.put("imei", m.i());
      paramHashMap.put("adid", m.j());
      paramHashMap.put("imsi", m.k());
      paramHashMap.put("lang", m.g());
      paramHashMap.put("ov", m.e());
      paramHashMap.put("ovn", m.f());
      paramHashMap.put("om", m.c());
      paramHashMap.put("osh", String.valueOf(m.q()));
      paramHashMap.put("osw", String.valueOf(m.p()));
      paramHashMap.put("nt", String.valueOf(c.a()));
      if (k.a().f() == true) {
        str = "1";
      } else {
        str = "0";
      } 
      paramHashMap.put("debug", str);
      paramHashMap.put("pjtId", x.a().b(paramContext));
      paramHashMap.put("smd5", bb.c(paramContext));
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static char[] a(char[] paramArrayOfchar, int... paramVarArgs) {
    for (byte b = 1; b < paramVarArgs.length; b += 2) {
      int i = paramVarArgs[b - 1];
      int j = paramVarArgs[b];
      char c = paramArrayOfchar[i];
      paramArrayOfchar[i] = (char)paramArrayOfchar[j];
      paramArrayOfchar[j] = (char)c;
    } 
    return paramArrayOfchar;
  }
  
  public static String b(String paramString) {
    String str = paramString;
    if (paramString.length() > 51)
      str = new String(a(paramString.toCharArray(), new int[] { 1, 33, 10, 42, 18, 50, 19, 51 })); 
    return new String(Base64.decode(str.getBytes(), 2));
  }
  
  public static ap[] b(Context paramContext, HashMap<String, Object> paramHashMap) {
    try {
      ap ap1;
      a(paramContext, paramHashMap);
      String str1 = k.a().i();
      String str3 = k.a().j();
      String str4 = a(paramHashMap);
      String str2 = String.valueOf(bb.a());
      String str5 = x.a().A();
      if (!TextUtils.isEmpty(str5)) {
        String str = a(str1, new String[] { "pcode", str3, "data", str4, "timestamp", str2, "_e_", str5 });
        arrayOfAp = new ap[5];
        ap ap = new ap();
        this("pcode", str3);
        arrayOfAp[0] = ap;
        ap2 = new ap();
        this("data", str4);
        arrayOfAp[1] = ap2;
        ap3 = new ap();
        this("sign", str);
        arrayOfAp[2] = ap3;
        ap3 = new ap();
        this("timestamp", str2);
        arrayOfAp[3] = ap3;
        ap1 = new ap();
        this("_e_", str5);
        arrayOfAp[4] = ap1;
        return arrayOfAp;
      } 
      str5 = a((String)arrayOfAp, new String[] { "pcode", (String)ap2, "data", (String)ap3, "timestamp", (String)ap1 });
      ap[] arrayOfAp = new ap[4];
      ap ap4 = new ap();
      this("pcode", (String)ap2);
      arrayOfAp[0] = ap4;
      ap ap2 = new ap();
      this("data", (String)ap3);
      arrayOfAp[1] = ap2;
      ap ap3 = new ap();
      this("sign", str5);
      arrayOfAp[2] = ap3;
      arrayOfAp[3] = new ap("timestamp", (String)ap1);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      exception = null;
    } 
    return (ap[])exception;
  }
  
  public static String c(String paramString) {
    String str1;
    String str2 = "";
    try {
      String str3 = b(paramString);
      str2 = str3;
      String str4 = x.a().z();
      paramString = str3;
      str2 = str3;
      if (!TextUtils.isEmpty(str4)) {
        str2 = str3;
        paramString = b.c(str3.getBytes(), str4);
      } 
    } catch (Exception exception) {
      str1 = str2;
    } 
    return str1;
  }
  
  public static ap[] c(Context paramContext, HashMap<String, Object> paramHashMap) {
    try {
      a(paramContext, paramHashMap);
      String str1 = k.a().i();
      String str3 = k.a().j();
      String str4 = a(paramHashMap);
      String str2 = String.valueOf(bb.a());
      if (!TextUtils.isEmpty(x.a().A())) {
        String str = a(str1, new String[] { "pcode", str3, "data", str4, "timestamp", str2 });
        arrayOfAp = new ap[4];
        ap ap = new ap();
        this("pcode", str3);
        arrayOfAp[0] = ap;
        ap1 = new ap();
        this("data", str4);
        arrayOfAp[1] = ap1;
        ap2 = new ap();
        this("sign", str);
        arrayOfAp[2] = ap2;
        ap2 = new ap();
        this("timestamp", str2);
        arrayOfAp[3] = ap2;
        return arrayOfAp;
      } 
      String str5 = a((String)arrayOfAp, new String[] { "pcode", (String)ap1, "data", (String)ap2, "timestamp", str2 });
      ap[] arrayOfAp = new ap[4];
      ap ap3 = new ap();
      this("pcode", (String)ap1);
      arrayOfAp[0] = ap3;
      ap ap1 = new ap();
      this("data", (String)ap2);
      arrayOfAp[1] = ap1;
      ap ap2 = new ap();
      this("sign", str5);
      arrayOfAp[2] = ap2;
      arrayOfAp[3] = new ap("timestamp", str2);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      exception = null;
    } 
    return (ap[])exception;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */