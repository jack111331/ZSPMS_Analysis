package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;

public class WXVideoObject implements WXMediaMessage.IMediaObject {
  private static final int LENGTH_LIMIT = 10240;
  
  private static final String TAG = "MicroMsg.SDK.WXVideoObject";
  
  public String videoLowBandUrl;
  
  public String videoUrl;
  
  public boolean checkArgs() {
    null = false;
    if ((this.videoUrl == null || this.videoUrl.length() == 0) && (this.videoLowBandUrl == null || this.videoLowBandUrl.length() == 0)) {
      a.a("MicroMsg.SDK.WXVideoObject", "both arguments are null");
      return null;
    } 
    if (this.videoUrl != null && this.videoUrl.length() > 10240) {
      a.a("MicroMsg.SDK.WXVideoObject", "checkArgs fail, videoUrl is too long");
      return null;
    } 
    if (this.videoLowBandUrl != null && this.videoLowBandUrl.length() > 10240) {
      a.a("MicroMsg.SDK.WXVideoObject", "checkArgs fail, videoLowBandUrl is too long");
      return null;
    } 
    return true;
  }
  
  public void serialize(Bundle paramBundle) {
    paramBundle.putString("_wxvideoobject_videoUrl", this.videoUrl);
    paramBundle.putString("_wxvideoobject_videoLowBandUrl", this.videoLowBandUrl);
  }
  
  public int type() {
    return 4;
  }
  
  public void unserialize(Bundle paramBundle) {
    this.videoUrl = paramBundle.getString("_wxvideoobject_videoUrl");
    this.videoLowBandUrl = paramBundle.getString("_wxvideoobject_videoLowBandUrl");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\modelmsg\WXVideoObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */