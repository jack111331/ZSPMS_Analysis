package com.google.zxing.client.result;

public final class WifiParsedResult extends ParsedResult {
  private final String anonymousIdentity;
  
  private final String eapMethod;
  
  private final boolean hidden;
  
  private final String identity;
  
  private final String networkEncryption;
  
  private final String password;
  
  private final String phase2Method;
  
  private final String ssid;
  
  public WifiParsedResult(String paramString1, String paramString2, String paramString3) {
    this(paramString1, paramString2, paramString3, false);
  }
  
  public WifiParsedResult(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    this(paramString1, paramString2, paramString3, paramBoolean, null, null, null, null);
  }
  
  public WifiParsedResult(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5, String paramString6, String paramString7) {
    super(ParsedResultType.WIFI);
    this.ssid = paramString2;
    this.networkEncryption = paramString1;
    this.password = paramString3;
    this.hidden = paramBoolean;
    this.identity = paramString4;
    this.anonymousIdentity = paramString5;
    this.eapMethod = paramString6;
    this.phase2Method = paramString7;
  }
  
  public String getAnonymousIdentity() {
    return this.anonymousIdentity;
  }
  
  public String getDisplayResult() {
    StringBuilder stringBuilder = new StringBuilder(80);
    maybeAppend(this.ssid, stringBuilder);
    maybeAppend(this.networkEncryption, stringBuilder);
    maybeAppend(this.password, stringBuilder);
    maybeAppend(Boolean.toString(this.hidden), stringBuilder);
    return stringBuilder.toString();
  }
  
  public String getEapMethod() {
    return this.eapMethod;
  }
  
  public String getIdentity() {
    return this.identity;
  }
  
  public String getNetworkEncryption() {
    return this.networkEncryption;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public String getPhase2Method() {
    return this.phase2Method;
  }
  
  public String getSsid() {
    return this.ssid;
  }
  
  public boolean isHidden() {
    return this.hidden;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\WifiParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */