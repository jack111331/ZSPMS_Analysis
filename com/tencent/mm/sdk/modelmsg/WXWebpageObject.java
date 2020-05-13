package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;

public class WXWebpageObject implements WXMediaMessage.IMediaObject {
  private static final int LENGTH_LIMIT = 10240;
  
  private static final String TAG = "MicroMsg.SDK.WXWebpageObject";
  
  public String extInfo;
  
  public String webpageUrl;
  
  public WXWebpageObject() {}
  
  public WXWebpageObject(String paramString) {
    this.webpageUrl = paramString;
  }
  
  public boolean checkArgs() {
    if (this.webpageUrl == null || this.webpageUrl.length() == 0 || this.webpageUrl.length() > 10240) {
      a.a("MicroMsg.SDK.WXWebpageObject", "checkArgs fail, webpageUrl is invalid");
      return false;
    } 
    return true;
  }
  
  public void serialize(Bundle paramBundle) {
    paramBundle.putString("_wxwebpageobject_extInfo", this.extInfo);
    paramBundle.putString("_wxwebpageobject_webpageUrl", this.webpageUrl);
  }
  
  public int type() {
    return 5;
  }
  
  public void unserialize(Bundle paramBundle) {
    this.extInfo = paramBundle.getString("_wxwebpageobject_extInfo");
    this.webpageUrl = paramBundle.getString("_wxwebpageobject_webpageUrl");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\modelmsg\WXWebpageObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */