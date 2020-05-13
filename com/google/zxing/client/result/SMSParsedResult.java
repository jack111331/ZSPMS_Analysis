package com.google.zxing.client.result;

public final class SMSParsedResult extends ParsedResult {
  private final String body;
  
  private final String[] numbers;
  
  private final String subject;
  
  private final String[] vias;
  
  public SMSParsedResult(String paramString1, String paramString2, String paramString3, String paramString4) {
    super(ParsedResultType.SMS);
    this.numbers = new String[] { paramString1 };
    this.vias = new String[] { paramString2 };
    this.subject = paramString3;
    this.body = paramString4;
  }
  
  public SMSParsedResult(String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString1, String paramString2) {
    super(ParsedResultType.SMS);
    this.numbers = paramArrayOfString1;
    this.vias = paramArrayOfString2;
    this.subject = paramString1;
    this.body = paramString2;
  }
  
  public String getBody() {
    return this.body;
  }
  
  public String getDisplayResult() {
    StringBuilder stringBuilder = new StringBuilder(100);
    maybeAppend(this.numbers, stringBuilder);
    maybeAppend(this.subject, stringBuilder);
    maybeAppend(this.body, stringBuilder);
    return stringBuilder.toString();
  }
  
  public String[] getNumbers() {
    return this.numbers;
  }
  
  public String getSMSURI() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("sms:");
    boolean bool1 = false;
    byte b = 0;
    boolean bool2 = true;
    while (b < this.numbers.length) {
      if (bool2) {
        bool2 = false;
      } else {
        stringBuilder.append(',');
      } 
      stringBuilder.append(this.numbers[b]);
      if (this.vias != null && this.vias[b] != null) {
        stringBuilder.append(";via=");
        stringBuilder.append(this.vias[b]);
      } 
      b++;
    } 
    if (this.body != null) {
      b = 1;
    } else {
      b = 0;
    } 
    bool2 = bool1;
    if (this.subject != null)
      bool2 = true; 
    if (b != 0 || bool2) {
      stringBuilder.append('?');
      if (b != 0) {
        stringBuilder.append("body=");
        stringBuilder.append(this.body);
      } 
      if (bool2) {
        if (b != 0)
          stringBuilder.append('&'); 
        stringBuilder.append("subject=");
        stringBuilder.append(this.subject);
      } 
    } 
    return stringBuilder.toString();
  }
  
  public String getSubject() {
    return this.subject;
  }
  
  public String[] getVias() {
    return this.vias;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\SMSParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */