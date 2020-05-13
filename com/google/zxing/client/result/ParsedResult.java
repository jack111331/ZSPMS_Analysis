package com.google.zxing.client.result;

public abstract class ParsedResult {
  private final ParsedResultType type;
  
  protected ParsedResult(ParsedResultType paramParsedResultType) {
    this.type = paramParsedResultType;
  }
  
  public static void maybeAppend(String paramString, StringBuilder paramStringBuilder) {
    if (paramString != null && !paramString.isEmpty()) {
      if (paramStringBuilder.length() > 0)
        paramStringBuilder.append('\n'); 
      paramStringBuilder.append(paramString);
    } 
  }
  
  public static void maybeAppend(String[] paramArrayOfString, StringBuilder paramStringBuilder) {
    if (paramArrayOfString != null) {
      int i = paramArrayOfString.length;
      for (byte b = 0; b < i; b++)
        maybeAppend(paramArrayOfString[b], paramStringBuilder); 
    } 
  }
  
  public abstract String getDisplayResult();
  
  public final ParsedResultType getType() {
    return this.type;
  }
  
  public final String toString() {
    return getDisplayResult();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\ParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */