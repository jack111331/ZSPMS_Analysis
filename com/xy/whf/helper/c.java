package com.xy.whf.helper;

import android.util.Base64;

public class c {
  public static String a(String paramString) {
    return Base64.encodeToString(paramString.getBytes(), 0);
  }
  
  private static char[] a(char[] paramArrayOfchar, int... paramVarArgs) {
    for (byte b = 1; b < paramVarArgs.length; b += 2) {
      int i = paramVarArgs[b - 1];
      int j = paramVarArgs[b];
      char c1 = paramArrayOfchar[i];
      paramArrayOfchar[i] = (char)paramArrayOfchar[j];
      paramArrayOfchar[j] = (char)c1;
    } 
    return paramArrayOfchar;
  }
  
  public static String b(String paramString) {
    return new String(Base64.decode(paramString.getBytes(), 0));
  }
  
  public static String c(String paramString) {
    String str1;
    String str2 = paramString;
    try {
      if (paramString.length() > 51) {
        char[] arrayOfChar = a(paramString.toCharArray(), new int[] { 33, 1, 42, 10, 50, 18, 51, 19 });
        str2 = new String();
        this(arrayOfChar);
      } 
      paramString = b(str2);
    } catch (Exception exception) {
      exception.printStackTrace();
      str1 = "";
    } 
    return str1;
  }
  
  public static String d(String paramString) {
    String str;
    try {
      String str1 = a(paramString);
      paramString = str1;
      if (str1.length() > 51) {
        char[] arrayOfChar = a(str1.toCharArray(), new int[] { 1, 33, 10, 42, 18, 50, 19, 51 });
        paramString = new String();
        this(arrayOfChar);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      str = "";
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\helper\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */