package com.ta.utdid2.a.a;

public class g {
  public static String get(String paramString1, String paramString2) {
    String str;
    try {
      Class<?> clazz = Class.forName("android.os.SystemProperties");
      paramString1 = (String)clazz.getMethod("get", new Class[] { String.class, String.class }).invoke(clazz.newInstance(), new Object[] { paramString1, paramString2 });
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\t\\utdid2\a\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */