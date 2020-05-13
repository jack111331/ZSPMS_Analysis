package com.tencent.mm.sdk.b;

import com.tencent.mm.a.a;

public final class d {
  private final a E;
  
  private c<String, String> F;
  
  public final String i(String paramString) {
    String str2 = paramString;
    try {
      if (paramString.startsWith("!")) {
        if (this.F.a(paramString)) {
          str2 = this.F.get(paramString);
          return str2;
        } 
        str2 = paramString.substring(1);
        try {
          String[] arrayOfString = str2.split("@");
          if (arrayOfString.length > 1) {
            String str4 = arrayOfString[0];
            int i = Integer.valueOf(arrayOfString[0]).intValue();
            String str3 = str2.substring(str4.length() + 1, str4.length() + 1 + i);
            String str5 = str2.substring(i + str4.length() + 1);
            StringBuilder stringBuilder = new StringBuilder();
            this();
            str3 = stringBuilder.append(this.E.h(str3)).append(str5).toString();
            this.F.put(paramString, str3);
            return str3;
          } 
          paramString = str2;
        } catch (Exception exception) {
          String str = str2;
        } 
        return (String)exception;
      } 
    } catch (Exception exception1) {
      Exception exception2 = exception;
      exception = exception1;
      exception.printStackTrace();
      str2 = "[td]" + exception2;
    } 
    String str1 = str2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */