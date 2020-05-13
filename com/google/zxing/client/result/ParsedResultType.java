package com.google.zxing.client.result;

public enum ParsedResultType {
  ADDRESSBOOK, CALENDAR, EMAIL_ADDRESS, GEO, ISBN, PRODUCT, SMS, TEL, TEXT, URI, VIN, WIFI;
  
  static {
    TEXT = new ParsedResultType("TEXT", 4);
    GEO = new ParsedResultType("GEO", 5);
    TEL = new ParsedResultType("TEL", 6);
    SMS = new ParsedResultType("SMS", 7);
    CALENDAR = new ParsedResultType("CALENDAR", 8);
    WIFI = new ParsedResultType("WIFI", 9);
    ISBN = new ParsedResultType("ISBN", 10);
    VIN = new ParsedResultType("VIN", 11);
    $VALUES = new ParsedResultType[] { 
        ADDRESSBOOK, EMAIL_ADDRESS, PRODUCT, URI, TEXT, GEO, TEL, SMS, CALENDAR, WIFI, 
        ISBN, VIN };
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\ParsedResultType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */