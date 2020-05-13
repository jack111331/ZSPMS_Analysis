package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.b.d;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class CreateChatroom {
  public static class Req extends BaseReq {
    public String chatroomName;
    
    public String chatroomNickName;
    
    public String extMsg;
    
    public String groupId = "";
    
    public boolean checkArgs() {
      return !d.a(this.groupId);
    }
    
    public int getType() {
      return 14;
    }
    
    public void toBundle(Bundle param1Bundle) {
      super.toBundle(param1Bundle);
      param1Bundle.putString("_wxapi_create_chatroom_group_id", this.groupId);
      param1Bundle.putString("_wxapi_create_chatroom_chatroom_name", this.chatroomName);
      param1Bundle.putString("_wxapi_create_chatroom_chatroom_nickname", this.chatroomNickName);
      param1Bundle.putString("_wxapi_create_chatroom_ext_msg", this.extMsg);
      param1Bundle.putString("_wxapi_basereq_openid", this.openId);
    }
  }
  
  public static class Resp extends BaseResp {
    public String extMsg;
    
    public Resp() {}
    
    public Resp(Bundle param1Bundle) {
      fromBundle(param1Bundle);
    }
    
    public boolean checkArgs() {
      return true;
    }
    
    public void fromBundle(Bundle param1Bundle) {
      super.fromBundle(param1Bundle);
      this.extMsg = param1Bundle.getString("_wxapi_create_chatroom_ext_msg");
    }
    
    public int getType() {
      return 14;
    }
    
    public void toBundle(Bundle param1Bundle) {
      super.toBundle(param1Bundle);
      param1Bundle.putString("_wxapi_create_chatroom_ext_msg", this.extMsg);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\modelbiz\CreateChatroom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */