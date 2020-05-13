package com.aliyun.sls.android.sdk.core.auth;

@Deprecated
public class PlainTextAKSKCredentialProvider extends CredentialProvider {
  private String accessKeyId;
  
  private String accessKeySecret;
  
  public PlainTextAKSKCredentialProvider(String paramString1, String paramString2) {
    setAccessKeyId(paramString1.trim());
    setAccessKeySecret(paramString2.trim());
  }
  
  public String getAccessKeyId() {
    return this.accessKeyId;
  }
  
  public String getAccessKeySecret() {
    return this.accessKeySecret;
  }
  
  public void setAccessKeyId(String paramString) {
    this.accessKeyId = paramString;
  }
  
  public void setAccessKeySecret(String paramString) {
    this.accessKeySecret = paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\core\auth\PlainTextAKSKCredentialProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */