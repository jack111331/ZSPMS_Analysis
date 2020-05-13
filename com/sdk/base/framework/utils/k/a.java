package com.sdk.base.framework.utils.k;

import android.text.TextUtils;

public class a {
  public static long a(String paramString1, String paramString2) {
    long l = 0L;
    if (TextUtils.isEmpty(paramString1))
      return 0L; 
    int i = paramString1.length();
    if (i < 100)
      return (paramString1.getBytes(paramString2)).length; 
    byte b = 0;
    while (true) {
      if (b < i) {
        int j = b + 100;
        if (j >= i)
          j = i; 
        l += (a(paramString1, b, j).getBytes(paramString2)).length;
        b += 100;
        continue;
      } 
      return l;
    } 
  }
  
  public static Boolean a(String paramString) {
    return (paramString == null || paramString.length() == 0 || paramString.trim().length() == 0 || paramString.equals("null") || paramString.equals("")) ? Boolean.valueOf(true) : Boolean.valueOf(false);
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2) {
    return new String(paramString.substring(paramInt1, paramInt2));
  }
  
  public static boolean a(String... paramVarArgs) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: ifnonnull -> 10
    //   6: iload_1
    //   7: istore_2
    //   8: iload_2
    //   9: ireturn
    //   10: aload_0
    //   11: arraylength
    //   12: istore_3
    //   13: iconst_0
    //   14: istore #4
    //   16: iload #4
    //   18: iload_3
    //   19: if_icmpge -> 61
    //   22: aload_0
    //   23: iload #4
    //   25: aaload
    //   26: astore #5
    //   28: aload #5
    //   30: ifnull -> 42
    //   33: aload #5
    //   35: invokevirtual length : ()I
    //   38: iconst_1
    //   39: if_icmpge -> 55
    //   42: iload_1
    //   43: istore_2
    //   44: aload #5
    //   46: invokestatic a : (Ljava/lang/String;)Ljava/lang/Boolean;
    //   49: invokevirtual booleanValue : ()Z
    //   52: ifne -> 8
    //   55: iinc #4, 1
    //   58: goto -> 16
    //   61: iconst_0
    //   62: istore_2
    //   63: goto -> 8
  }
  
  public static Boolean b(String paramString) {
    return (paramString == null || paramString.length() == 0 || paramString.trim().length() == 0 || paramString.equals("null") || paramString.equals("")) ? Boolean.valueOf(false) : Boolean.valueOf(true);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\k\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */