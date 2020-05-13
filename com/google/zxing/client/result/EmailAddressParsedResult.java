package com.google.zxing.client.result;

public final class EmailAddressParsedResult extends ParsedResult {
  private final String[] bccs;
  
  private final String body;
  
  private final String[] ccs;
  
  private final String subject;
  
  private final String[] tos;
  
  EmailAddressParsedResult(String paramString) {
    this(new String[] { paramString }, (String[])null, (String[])null, (String)null, (String)null);
  }
  
  EmailAddressParsedResult(String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString1, String paramString2) {
    super(ParsedResultType.EMAIL_ADDRESS);
    this.tos = paramArrayOfString1;
    this.ccs = paramArrayOfString2;
    this.bccs = paramArrayOfString3;
    this.subject = paramString1;
    this.body = paramString2;
  }
  
  public String[] getBCCs() {
    return this.bccs;
  }
  
  public String getBody() {
    return this.body;
  }
  
  public String[] getCCs() {
    return this.ccs;
  }
  
  public String getDisplayResult() {
    StringBuilder stringBuilder = new StringBuilder(30);
    maybeAppend(this.tos, stringBuilder);
    maybeAppend(this.ccs, stringBuilder);
    maybeAppend(this.bccs, stringBuilder);
    maybeAppend(this.subject, stringBuilder);
    maybeAppend(this.body, stringBuilder);
    return stringBuilder.toString();
  }
  
  @Deprecated
  public String getEmailAddress() {
    return (this.tos == null || this.tos.length == 0) ? null : this.tos[0];
  }
  
  @Deprecated
  public String getMailtoURI() {
    return "mailto:";
  }
  
  public String getSubject() {
    return this.subject;
  }
  
  public String[] getTos() {
    return this.tos;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\EmailAddressParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */