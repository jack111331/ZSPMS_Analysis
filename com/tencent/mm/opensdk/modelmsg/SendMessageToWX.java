package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import android.util.Log;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class SendMessageToWX {
  public static class Req extends BaseReq {
    private static final int FAV_CONTENT_LENGTH_LIMIT = 26214400;
    
    private static final String TAG = "MicroMsg.SDK.SendMessageToWX.Req";
    
    public static final int WXSceneFavorite = 2;
    
    public static final int WXSceneSession = 0;
    
    public static final int WXSceneTimeline = 1;
    
    public WXMediaMessage message;
    
    public int scene;
    
    public Req() {}
    
    public Req(Bundle param1Bundle) {
      fromBundle(param1Bundle);
    }
    
    public boolean checkArgs() {
      if (this.message == null) {
        Log.e("MicroMsg.SDK.SendMessageToWX.Req", "checkArgs fail ,message is null");
        return false;
      } 
      if (this.message.mediaObject.type() == 6 && this.scene == 2)
        ((WXFileObject)this.message.mediaObject).setContentLengthLimit(26214400); 
      return this.message.checkArgs();
    }
    
    public void fromBundle(Bundle param1Bundle) {
      super.fromBundle(param1Bundle);
      this.message = WXMediaMessage.Builder.fromBundle(param1Bundle);
      this.scene = param1Bundle.getInt("_wxapi_sendmessagetowx_req_scene");
    }
    
    public int getType() {
      return 2;
    }
    
    public void toBundle(Bundle param1Bundle) {
      super.toBundle(param1Bundle);
      param1Bundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
      param1Bundle.putInt("_wxapi_sendmessagetowx_req_scene", this.scene);
    }
  }
  
  public static class Resp extends BaseResp {
    public Resp() {}
    
    public Resp(Bundle param1Bundle) {
      fromBundle(param1Bundle);
    }
    
    public boolean checkArgs() {
      return true;
    }
    
    public void fromBundle(Bundle param1Bundle) {
      super.fromBundle(param1Bundle);
    }
    
    public int getType() {
      return 2;
    }
    
    public void toBundle(Bundle param1Bundle) {
      super.toBundle(param1Bundle);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\modelmsg\SendMessageToWX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */