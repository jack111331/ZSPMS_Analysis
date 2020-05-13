package com.google.zxing.client.result;

public final class ISBNParsedResult extends ParsedResult {
  private final String isbn;
  
  ISBNParsedResult(String paramString) {
    super(ParsedResultType.ISBN);
    this.isbn = paramString;
  }
  
  public String getDisplayResult() {
    return this.isbn;
  }
  
  public String getISBN() {
    return this.isbn;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\ISBNParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */