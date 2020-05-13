package com.alipay.sdk.protocol;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.tid.a;
import com.alipay.sdk.util.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class b {
  public a a;
  
  public String[] b;
  
  private String c;
  
  private b(String paramString) {
    this.c = paramString;
  }
  
  private b(String paramString, a parama) {
    this.c = paramString;
    this.a = parama;
  }
  
  private String a() {
    return this.c;
  }
  
  public static List<b> a(JSONObject paramJSONObject) {
    ArrayList<b> arrayList = new ArrayList();
    if (paramJSONObject != null) {
      String[] arrayOfString;
      String str = paramJSONObject.optString("name", "");
      paramJSONObject = null;
      if (!TextUtils.isEmpty(str))
        arrayOfString = str.split(";"); 
      byte b1 = 0;
      while (true) {
        if (b1 < arrayOfString.length) {
          a a1 = a.a(arrayOfString[b1]);
          if (a1 != a.a) {
            b b2 = new b(arrayOfString[b1], a1);
            b2.b = a(arrayOfString[b1]);
            arrayList.add(b2);
          } 
          b1++;
          continue;
        } 
        return arrayList;
      } 
    } 
    return arrayList;
  }
  
  private static void a(b paramb) {
    String[] arrayOfString = paramb.b;
    if (arrayOfString.length == 3 && TextUtils.equals("tid", arrayOfString[0])) {
      Context context = (com.alipay.sdk.sys.b.a()).a;
      com.alipay.sdk.tid.b b1 = com.alipay.sdk.tid.b.a();
      if (!TextUtils.isEmpty(arrayOfString[1]) && !TextUtils.isEmpty(arrayOfString[2])) {
        b1.a = arrayOfString[1];
        b1.b = arrayOfString[2];
        a a1 = new a(context);
        try {
          a1.a(a.a(context).a(), a.a(context).b(), b1.a, b1.b);
          return;
        } catch (Exception exception) {
          return;
        } finally {
          a1.close();
        } 
      } 
    } 
  }
  
  private static String[] a(String paramString) {
    ArrayList<String> arrayList = new ArrayList();
    int i = paramString.indexOf('(');
    int j = paramString.lastIndexOf(')');
    if (i == -1 || j == -1 || j <= i)
      return null; 
    null = paramString.substring(i + 1, j).split(",");
    if (null != null)
      for (i = 0; i < null.length; i++) {
        if (!TextUtils.isEmpty(null[i]))
          arrayList.add(null[i].trim().replaceAll("'", "").replaceAll("\"", "")); 
      }  
    return arrayList.<String>toArray(new String[0]);
  }
  
  private a b() {
    return this.a;
  }
  
  private static String[] b(String paramString) {
    String[] arrayOfString = null;
    if (!TextUtils.isEmpty(paramString))
      arrayOfString = paramString.split(";"); 
    return arrayOfString;
  }
  
  private String[] c() {
    return this.b;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\protocol\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */