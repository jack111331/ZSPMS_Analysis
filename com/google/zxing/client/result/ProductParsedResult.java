package com.google.zxing.client.result;

public final class ProductParsedResult extends ParsedResult {
  private final String normalizedProductID;
  
  private final String productID;
  
  ProductParsedResult(String paramString) {
    this(paramString, paramString);
  }
  
  ProductParsedResult(String paramString1, String paramString2) {
    super(ParsedResultType.PRODUCT);
    this.productID = paramString1;
    this.normalizedProductID = paramString2;
  }
  
  public String getDisplayResult() {
    return this.productID;
  }
  
  public String getNormalizedProductID() {
    return this.normalizedProductID;
  }
  
  public String getProductID() {
    return this.productID;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\ProductParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */