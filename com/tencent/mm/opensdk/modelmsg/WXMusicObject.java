package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import android.util.Log;

public class WXMusicObject implements WXMediaMessage.IMediaObject {
  private static final int LENGTH_LIMIT = 10240;
  
  private static final String TAG = "MicroMsg.SDK.WXMusicObject";
  
  public String musicDataUrl;
  
  public String musicLowBandDataUrl;
  
  public String musicLowBandUrl;
  
  public String musicUrl;
  
  public boolean checkArgs() {
    if ((this.musicUrl == null || this.musicUrl.length() == 0) && (this.musicLowBandUrl == null || this.musicLowBandUrl.length() == 0)) {
      String str = "both arguments are null";
      Log.e("MicroMsg.SDK.WXMusicObject", str);
      return false;
    } 
    if (this.musicUrl != null && this.musicUrl.length() > 10240) {
      String str = "checkArgs fail, musicUrl is too long";
      Log.e("MicroMsg.SDK.WXMusicObject", str);
      return false;
    } 
    if (this.musicLowBandUrl != null && this.musicLowBandUrl.length() > 10240) {
      String str = "checkArgs fail, musicLowBandUrl is too long";
      Log.e("MicroMsg.SDK.WXMusicObject", str);
      return false;
    } 
    return true;
  }
  
  public void serialize(Bundle paramBundle) {
    paramBundle.putString("_wxmusicobject_musicUrl", this.musicUrl);
    paramBundle.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
    paramBundle.putString("_wxmusicobject_musicDataUrl", this.musicDataUrl);
    paramBundle.putString("_wxmusicobject_musicLowBandDataUrl", this.musicLowBandDataUrl);
  }
  
  public int type() {
    return 3;
  }
  
  public void unserialize(Bundle paramBundle) {
    this.musicUrl = paramBundle.getString("_wxmusicobject_musicUrl");
    this.musicLowBandUrl = paramBundle.getString("_wxmusicobject_musicLowBandUrl");
    this.musicDataUrl = paramBundle.getString("_wxmusicobject_musicDataUrl");
    this.musicLowBandDataUrl = paramBundle.getString("_wxmusicobject_musicLowBandDataUrl");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\modelmsg\WXMusicObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */