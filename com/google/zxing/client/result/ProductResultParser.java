package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.oned.UPCEReader;

public final class ProductResultParser extends ResultParser {
  public ProductParsedResult parse(Result paramResult) {
    String str1;
    BarcodeFormat barcodeFormat = paramResult.getBarcodeFormat();
    if (barcodeFormat != BarcodeFormat.UPC_A && barcodeFormat != BarcodeFormat.UPC_E && barcodeFormat != BarcodeFormat.EAN_8 && barcodeFormat != BarcodeFormat.EAN_13)
      return null; 
    String str2 = getMassagedText(paramResult);
    if (!isStringOfDigits(str2, str2.length()))
      return null; 
    if (barcodeFormat == BarcodeFormat.UPC_E && str2.length() == 8) {
      str1 = UPCEReader.convertUPCEtoUPCA(str2);
    } else {
      str1 = str2;
    } 
    return new ProductParsedResult(str2, str1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\ProductResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */