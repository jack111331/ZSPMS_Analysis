package com.aliyun.sls.android.sdk.core.auth;

public class StsTokenCredentialProvider extends CredentialProvider {
  private String accessKeyId;
  
  private String secretKeyId;
  
  private String securityToken;
  
  public StsTokenCredentialProvider(String paramString1, String paramString2, String paramString3) {
    setAccessKeyId(paramString1.trim());
    setSecretKeyId(paramString2.trim());
    setSecurityToken(paramString3.trim());
  }
  
  public String getAccessKeyId() {
    return this.accessKeyId;
  }
  
  public FederationToken getFederationToken() {
    return new FederationToken(this.accessKeyId, this.secretKeyId, this.securityToken, Long.MAX_VALUE);
  }
  
  public String getSecretKeyId() {
    return this.secretKeyId;
  }
  
  public String getSecurityToken() {
    return this.securityToken;
  }
  
  public void setAccessKeyId(String paramString) {
    this.accessKeyId = paramString;
  }
  
  public void setSecretKeyId(String paramString) {
    this.secretKeyId = paramString;
  }
  
  public void setSecurityToken(String paramString) {
    this.securityToken = paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\core\auth\StsTokenCredentialProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */