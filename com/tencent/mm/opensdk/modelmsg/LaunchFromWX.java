package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import android.util.Log;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class LaunchFromWX {
  public static class Req extends BaseReq {
    private static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
    
    private static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
    
    private static final String TAG = "MicroMsg.SDK.LaunchFromWX.Req";
    
    public String country;
    
    public String lang;
    
    public String messageAction;
    
    public String messageExt;
    
    public Req() {}
    
    public Req(Bundle param1Bundle) {
      fromBundle(param1Bundle);
    }
    
    public boolean checkArgs() {
      if (this.messageAction != null && this.messageAction.length() > 2048) {
        String str = "checkArgs fail, messageAction is too long";
        Log.e("MicroMsg.SDK.LaunchFromWX.Req", str);
        return false;
      } 
      if (this.messageExt != null && this.messageExt.length() > 2048) {
        String str = "checkArgs fail, messageExt is too long";
        Log.e("MicroMsg.SDK.LaunchFromWX.Req", str);
        return false;
      } 
      return true;
    }
    
    public void fromBundle(Bundle param1Bundle) {
      super.fromBundle(param1Bundle);
      this.messageAction = param1Bundle.getString("_wxobject_message_action");
      this.messageExt = param1Bundle.getString("_wxobject_message_ext");
      this.lang = param1Bundle.getString("_wxapi_launch_req_lang");
      this.country = param1Bundle.getString("_wxapi_launch_req_country");
    }
    
    public int getType() {
      return 6;
    }
    
    public void toBundle(Bundle param1Bundle) {
      super.toBundle(param1Bundle);
      param1Bundle.putString("_wxobject_message_action", this.messageAction);
      param1Bundle.putString("_wxobject_message_ext", this.messageExt);
      param1Bundle.putString("_wxapi_launch_req_lang", this.lang);
      param1Bundle.putString("_wxapi_launch_req_country", this.country);
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
    
    public int getType() {
      return 6;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\modelmsg\LaunchFromWX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */