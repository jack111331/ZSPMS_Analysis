package com.tencent.mm.opensdk.diffdev;

public interface OAuthListener {
  void onAuthFinish(OAuthErrCode paramOAuthErrCode, String paramString);
  
  void onAuthGotQrcode(String paramString, byte[] paramArrayOfbyte);
  
  void onQrcodeScanned();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\diffdev\OAuthListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */