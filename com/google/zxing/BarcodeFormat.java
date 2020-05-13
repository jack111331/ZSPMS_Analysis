package com.google.zxing;

public enum BarcodeFormat {
  AZTEC, CODABAR, CODE_128, CODE_39, CODE_93, DATA_MATRIX, EAN_13, EAN_8, ITF, MAXICODE, PDF_417, QR_CODE, RSS_14, RSS_EXPANDED, UPC_A, UPC_E, UPC_EAN_EXTENSION;
  
  static {
    CODE_128 = new BarcodeFormat("CODE_128", 4);
    DATA_MATRIX = new BarcodeFormat("DATA_MATRIX", 5);
    EAN_8 = new BarcodeFormat("EAN_8", 6);
    EAN_13 = new BarcodeFormat("EAN_13", 7);
    ITF = new BarcodeFormat("ITF", 8);
    MAXICODE = new BarcodeFormat("MAXICODE", 9);
    PDF_417 = new BarcodeFormat("PDF_417", 10);
    QR_CODE = new BarcodeFormat("QR_CODE", 11);
    RSS_14 = new BarcodeFormat("RSS_14", 12);
    RSS_EXPANDED = new BarcodeFormat("RSS_EXPANDED", 13);
    UPC_A = new BarcodeFormat("UPC_A", 14);
    UPC_E = new BarcodeFormat("UPC_E", 15);
    UPC_EAN_EXTENSION = new BarcodeFormat("UPC_EAN_EXTENSION", 16);
    $VALUES = new BarcodeFormat[] { 
        AZTEC, CODABAR, CODE_39, CODE_93, CODE_128, DATA_MATRIX, EAN_8, EAN_13, ITF, MAXICODE, 
        PDF_417, QR_CODE, RSS_14, RSS_EXPANDED, UPC_A, UPC_E, UPC_EAN_EXTENSION };
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\BarcodeFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */