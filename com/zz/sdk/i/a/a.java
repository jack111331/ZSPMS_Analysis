package com.zz.sdk.i.a;

public class a {
  public String a;
  
  public String b;
  
  public String c;
  
  public a(String paramString) {
    try {
      for (String str : paramString.split(";")) {
        if (str.startsWith("resultStatus"))
          this.a = a(str, "resultStatus"); 
        if (str.startsWith("result"))
          this.b = a(str, "result"); 
        if (str.startsWith("memo"))
          this.c = a(str, "memo"); 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private String a(String paramString1, String paramString2) {
    paramString2 = paramString2 + "={";
    int i = paramString1.indexOf(paramString2);
    return paramString1.substring(paramString2.length() + i, paramString1.lastIndexOf("}"));
  }
  
  public String toString() {
    return "resultStatus={" + this.a + "};memo={" + this.c + "};result={" + this.b + "}";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */