package com.zz.sdk.i;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class bf {
  private static final String a = "kwmxhalqho#wjnz@@";
  
  private static String a(String paramString) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
      messageDigest.update(paramString.getBytes());
      StringBuffer stringBuffer = new StringBuffer();
      this();
      byte[] arrayOfByte = messageDigest.digest();
      for (byte b = 0; b < arrayOfByte.length; b++) {
        byte b1 = arrayOfByte[b];
        int i = b1;
        if (b1 < 0)
          i = b1 + 256; 
        if (i < 16)
          stringBuffer.append("0"); 
        stringBuffer.append(Integer.toHexString(i));
      } 
      String str = stringBuffer.toString();
    } catch (Exception exception) {
      exception = null;
    } 
    return (String)exception;
  }
  
  private static String a(HashMap paramHashMap) {
    return a(paramHashMap, "kwmxhalqho#wjnz@@");
  }
  
  private static String a(HashMap paramHashMap, String paramString) {
    ArrayList<Comparable> arrayList = new ArrayList(paramHashMap.keySet());
    Collections.sort(arrayList);
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < paramHashMap.size(); b++) {
      String str1 = (String)arrayList.get(b);
      if (!"sign".equals(str1) && !"market".equals(str1)) {
        String str2 = (String)paramHashMap.get(arrayList.get(b));
        stringBuilder.append(str1).append("=").append(str2);
      } 
    } 
    stringBuilder.append(paramString);
    bp.a("FloatWindow encodeMd5Parameter: " + stringBuilder.toString());
    String str = a(paramString);
    StringBuffer stringBuffer = new StringBuffer(cv.b(stringBuilder.toString()));
    stringBuffer.append(str);
    str = cv.b(stringBuffer.toString());
    bp.a("FloatWindow sign:" + str);
    return str;
  }
  
  public static String a(String... paramVarArgs) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramVarArgs != null && paramVarArgs.length > 0)
      for (byte b = 0; b < paramVarArgs.length; b += 2)
        hashMap.put(paramVarArgs[b], paramVarArgs[b + 1]);  
    return a(hashMap);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */