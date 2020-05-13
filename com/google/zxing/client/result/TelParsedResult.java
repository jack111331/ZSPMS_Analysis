package com.google.zxing.client.result;

public final class TelParsedResult extends ParsedResult {
  private final String number;
  
  private final String telURI;
  
  private final String title;
  
  public TelParsedResult(String paramString1, String paramString2, String paramString3) {
    super(ParsedResultType.TEL);
    this.number = paramString1;
    this.telURI = paramString2;
    this.title = paramString3;
  }
  
  public String getDisplayResult() {
    StringBuilder stringBuilder = new StringBuilder(20);
    maybeAppend(this.number, stringBuilder);
    maybeAppend(this.title, stringBuilder);
    return stringBuilder.toString();
  }
  
  public String getNumber() {
    return this.number;
  }
  
  public String getTelURI() {
    return this.telURI;
  }
  
  public String getTitle() {
    return this.title;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\TelParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */