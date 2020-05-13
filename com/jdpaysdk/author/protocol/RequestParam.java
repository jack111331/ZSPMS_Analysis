package com.jdpaysdk.author.protocol;

public abstract class RequestParam {
  public final void encrypt() {
    onEncrypt();
  }
  
  protected void onEncrypt() {}
  
  public String pack(String paramString) {
    return paramString;
  }
  
  public String unpack(String paramString) {
    return paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\protocol\RequestParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */