package com.zz.a.c;

public class e {
  public static final String a(Object... paramVarArgs) {
    String[] arrayOfString = new String[paramVarArgs.length];
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++) {
      String str;
      if (paramVarArgs == null) {
        str = null;
      } else {
        str = paramVarArgs.toString();
      } 
      arrayOfString[b] = str;
    } 
    return a(arrayOfString);
  }
  
  public static final String a(String[] paramArrayOfString) {
    if (paramArrayOfString == null)
      return ""; 
    StringBuffer stringBuffer = new StringBuffer();
    byte b = 0;
    int i = paramArrayOfString.length;
    while (b < i) {
      if (b > 0)
        stringBuffer.append("&"); 
      stringBuffer.append(f.a(paramArrayOfString[b]));
      b++;
    } 
    return d.b(stringBuffer.toString());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */