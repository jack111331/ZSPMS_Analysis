package com.ta.utdid2.a.a;

import java.util.regex.Pattern;

public class f {
  private static final Pattern a = Pattern.compile("([\t\r\n])+");
  
  public static int hashCode(String paramString) {
    boolean bool;
    byte b = 0;
    if (paramString.length() > 0) {
      char[] arrayOfChar = paramString.toCharArray();
      int i = 0;
      while (true) {
        bool = i;
        if (b < arrayOfChar.length) {
          i = i * 31 + arrayOfChar[b];
          b++;
          continue;
        } 
        break;
      } 
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static boolean isEmpty(String paramString) {
    return !(paramString != null && paramString.length() > 0);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\t\\utdid2\a\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */