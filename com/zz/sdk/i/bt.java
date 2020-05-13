package com.zz.sdk.i;

import android.text.TextUtils;
import android.util.Log;
import com.zz.lib.org.myapache.commons.codec.binary.Base64;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class bt {
  public static String a(String paramString) {
    byte[] arrayOfByte = cv.b(paramString).toLowerCase().getBytes();
    if (arrayOfByte.length >= 23) {
      byte b = arrayOfByte[1];
      arrayOfByte[1] = (byte)arrayOfByte[13];
      arrayOfByte[13] = (byte)b;
      b = arrayOfByte[5];
      arrayOfByte[5] = (byte)arrayOfByte[17];
      arrayOfByte[17] = (byte)b;
      b = arrayOfByte[7];
      arrayOfByte[7] = (byte)arrayOfByte[23];
      arrayOfByte[23] = (byte)b;
      return new String(arrayOfByte);
    } 
    Log.d("zz_sdk", "this is wrong......");
    return new String(arrayOfByte);
  }
  
  public static String a(HashMap<String, String> paramHashMap, String paramString) {
    paramHashMap.put("__e__", "1");
    ArrayList<Comparable> arrayList = new ArrayList(paramHashMap.keySet());
    Collections.sort(arrayList);
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < paramHashMap.size(); b++) {
      String str = (String)arrayList.get(b);
      if (!"sign".equals(str) && !"market".equals(str)) {
        String str1 = paramHashMap.get(arrayList.get(b));
        if (str1 != null && str1.length() > 0)
          stringBuilder.append(str).append("=").append(str1).append("&"); 
      } 
    } 
    stringBuilder.append(paramString);
    return a(stringBuilder.toString());
  }
  
  public static void a(List<BasicNameValuePair> paramList, String paramString) {
    boolean bool = false;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("__e__", "1");
    byte b;
    for (b = 0; b < paramList.size(); b++) {
      BasicNameValuePair basicNameValuePair = paramList.get(b);
      String str = basicNameValuePair.getName();
      if (!"sign".equals(str) && !"market".equals(str)) {
        str = basicNameValuePair.getValue();
        if (str != null && str.length() > 0)
          hashMap.put(basicNameValuePair.getName(), basicNameValuePair.getValue()); 
      } 
    } 
    ArrayList<Comparable> arrayList = new ArrayList(hashMap.keySet());
    Collections.sort(arrayList);
    StringBuilder stringBuilder = new StringBuilder();
    for (b = bool; b < hashMap.size(); b++)
      stringBuilder.append((String)arrayList.get(b)).append("=").append((String)hashMap.get(arrayList.get(b))).append("&"); 
    stringBuilder.append(paramString);
    paramList.add(new BasicNameValuePair("sign", a(stringBuilder.toString())));
    paramList.add(new BasicNameValuePair("__e__", "1"));
  }
  
  private static char[] a(char[] paramArrayOfchar, int paramInt) {
    while (true) {
      if (paramInt < paramArrayOfchar.length) {
        char c = paramArrayOfchar[paramInt];
        paramArrayOfchar[paramInt] = (char)paramArrayOfchar[paramInt + 2];
        paramArrayOfchar[paramInt + 2] = (char)c;
        if (paramInt + 6 < paramArrayOfchar.length) {
          paramInt += 4;
          continue;
        } 
      } 
      return paramArrayOfchar;
    } 
  }
  
  public static String b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    char[] arrayOfChar = (new String(Base64.encodeBase64(paramString.getBytes()))).toCharArray();
    a(arrayOfChar, 0);
    a(arrayOfChar, 1);
    return new String(arrayOfChar);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */