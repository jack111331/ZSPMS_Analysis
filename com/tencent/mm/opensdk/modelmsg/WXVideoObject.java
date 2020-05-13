package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import android.util.Log;

public class WXVideoObject implements WXMediaMessage.IMediaObject {
  private static final int LENGTH_LIMIT = 10240;
  
  private static final String TAG = "MicroMsg.SDK.WXVideoObject";
  
  public String videoLowBandUrl;
  
  public String videoUrl;
  
  public boolean checkArgs() {
    if ((this.videoUrl == null || this.videoUrl.length() == 0) && (this.videoLowBandUrl == null || this.videoLowBandUrl.length() == 0)) {
      String str = "both arguments are null";
      Log.e("MicroMsg.SDK.WXVideoObject", str);
      return false;
    } 
    if (this.videoUrl != null && this.videoUrl.length() > 10240) {
      String str = "checkArgs fail, videoUrl is too long";
      Log.e("MicroMsg.SDK.WXVideoObject", str);
      return false;
    } 
    if (this.videoLowBandUrl != null && this.videoLowBandUrl.length() > 10240) {
      String str = "checkArgs fail, videoLowBandUrl is too long";
      Log.e("MicroMsg.SDK.WXVideoObject", str);
      return false;
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\modelmsg\WXVideoObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */