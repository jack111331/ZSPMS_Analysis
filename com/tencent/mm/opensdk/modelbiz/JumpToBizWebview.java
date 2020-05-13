package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import android.util.Log;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public final class JumpToBizWebview {
  public static class Req extends BaseReq {
    private static final int EXT_MSG_LENGTH = 1024;
    
    private static final String TAG = "MicroMsg.SDK.JumpToBizWebview.Req";
    
    public String extMsg;
    
    public int scene = 1;
    
    public String toUserName;
    
    public int webType;
    
    public boolean checkArgs() {
      if (this.toUserName == null || this.toUserName.length() <= 0) {
        String str = "checkArgs fail, toUserName is invalid";
        Log.e("MicroMsg.SDK.JumpToBizWebview.Req", str);
        return false;
      } 
      if (this.extMsg != null && this.extMsg.length() > 1024) {
        String str = "ext msg is not null, while the length exceed 1024 bytes";
        Log.e("MicroMsg.SDK.JumpToBizWebview.Req", str);
        return false;
      } 
      return true;
    }
    
    public int getType() {
      return 8;
    }
    
    public void toBundle(Bundle param1Bundle) {
      super.toBundle(param1Bundle);
      param1Bundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", this.toUserName);
      param1Bundle.putString("_wxapi_jump_to_biz_webview_req_ext_msg", this.extMsg);
      param1Bundle.putInt("_wxapi_jump_to_biz_webview_req_web_type", this.webType);
      param1Bundle.putInt("_wxapi_jump_to_biz_webview_req_scene", this.scene);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\modelbiz\JumpToBizWebview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */