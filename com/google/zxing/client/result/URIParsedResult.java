package com.google.zxing.client.result;

import java.util.regex.Pattern;

public final class URIParsedResult extends ParsedResult {
  private static final Pattern USER_IN_HOST = Pattern.compile(":/*([^/@]+)@[^/]+");
  
  private final String title;
  
  private final String uri;
  
  public URIParsedResult(String paramString1, String paramString2) {
    super(ParsedResultType.URI);
    this.uri = massageURI(paramString1);
    this.title = paramString2;
  }
  
  private static boolean isColonFollowedByPortNumber(String paramString, int paramInt) {
    int i = paramInt + 1;
    int j = paramString.indexOf('/', i);
    paramInt = j;
    if (j < 0)
      paramInt = paramString.length(); 
    return ResultParser.isSubstringOfDigits(paramString, i, paramInt - i);
  }
  
  private static String massageURI(String paramString) {
    String str = paramString.trim();
    int i = str.indexOf(':');
    if (i >= 0) {
      paramString = str;
      return isColonFollowedByPortNumber(str, i) ? "http://".concat(String.valueOf(str)) : paramString;
    } 
    return "http://".concat(String.valueOf(str));
  }
  
  public String getDisplayResult() {
    StringBuilder stringBuilder = new StringBuilder(30);
    maybeAppend(this.title, stringBuilder);
    maybeAppend(this.uri, stringBuilder);
    return stringBuilder.toString();
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public String getURI() {
    return this.uri;
  }
  
  public boolean isPossiblyMaliciousURI() {
    return USER_IN_HOST.matcher(this.uri).find();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\URIParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */