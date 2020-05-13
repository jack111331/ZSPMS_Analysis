package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import android.util.Log;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public final class JumpToBizTempSession {
  public static final int SHOW_CHAT = 1;
  
  public static final int SHOW_MENU = 0;
  
  public static class Req extends BaseReq {
    private static final int MAX_SESSION_FROM_LENGTH = 1024;
    
    private static final String TAG = "MicroMsg.SDK.JumpToBizTempSession.Req";
    
    public String sessionFrom;
    
    public int showType;
    
    public String toUserName;
    
    public boolean checkArgs() {
      if (this.toUserName == null || this.toUserName.length() <= 0) {
        String str = "checkArgs fail, toUserName is invalid";
        Log.e("MicroMsg.SDK.JumpToBizTempSession.Req", str);
        return false;
      } 
      if (this.sessionFrom == null || this.sessionFrom.length() > 1024) {
        String str = "checkArgs fail, sessionFrom is invalid";
        Log.e("MicroMsg.SDK.JumpToBizTempSession.Req", str);
        return false;
      } 
      return true;
    }
    
    public int getType() {
      return 10;
    }
    
    public void toBundle(Bundle param1Bundle) {
      super.toBundle(param1Bundle);
      param1Bundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", this.toUserName);
      param1Bundle.putString("_wxapi_jump_to_biz_webview_req_session_from", this.sessionFrom);
      param1Bundle.putInt("_wxapi_jump_to_biz_webview_req_show_type", this.showType);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\modelbiz\JumpToBizTempSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */