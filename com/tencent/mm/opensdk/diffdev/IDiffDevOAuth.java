package com.tencent.mm.opensdk.diffdev;

public interface IDiffDevOAuth {
  void addListener(OAuthListener paramOAuthListener);
  
  boolean auth(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, OAuthListener paramOAuthListener);
  
  void detach();
  
  void removeAllListeners();
  
  void removeListener(OAuthListener paramOAuthListener);
  
  boolean stopAuth();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\diffdev\IDiffDevOAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */