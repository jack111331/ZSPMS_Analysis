package okhttp3.internal.http;

public final class HeaderParser {
  public static int parseSeconds(String paramString, int paramInt) {
    try {
      long l = Long.parseLong(paramString);
      if (l > 2147483647L)
        return Integer.MAX_VALUE; 
      if (l < 0L)
        return 0; 
      paramInt = (int)l;
    } catch (NumberFormatException numberFormatException) {}
    return paramInt;
  }
  
  public static int skipUntil(String paramString1, int paramInt, String paramString2) {
    while (true) {
      if (paramInt >= paramString1.length() || paramString2.indexOf(paramString1.charAt(paramInt)) != -1)
        return paramInt; 
      paramInt++;
    } 
  }
  
  public static int skipWhitespace(String paramString, int paramInt) {
    while (true) {
      if (paramInt < paramString.length()) {
        char c = paramString.charAt(paramInt);
        if (c == ' ' || c == '\t') {
          paramInt++;
          continue;
        } 
      } 
      return paramInt;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\http\HeaderParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */