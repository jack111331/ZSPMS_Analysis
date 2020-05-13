package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseReq;

public class JumpToBizProfile {
  public static final int JUMP_TO_HARD_WARE_BIZ_PROFILE = 1;
  
  public static final int JUMP_TO_NORMAL_BIZ_PROFILE = 0;
  
  public static class Req extends BaseReq {
    private static final int EXT_MSG_LENGTH = 1024;
    
    private static final String TAG = "MicroMsg.SDK.JumpToBizProfile.Req";
    
    public String extMsg;
    
    public int profileType = 0;
    
    public String toUserName;
    
    public boolean checkArgs() {
      null = false;
      if (this.toUserName == null || this.toUserName.length() == 0) {
        a.a("MicroMsg.SDK.JumpToBizProfile.Req", "checkArgs fail, toUserName is invalid");
        return null;
      } 
      if (this.extMsg != null && this.extMsg.length() > 1024) {
        a.a("MicroMsg.SDK.JumpToBizProfile.Req", "ext msg is not null, while the length exceed 1024 bytes");
        return null;
      } 
      if (this.profileType == 1 && (this.extMsg == null || this.extMsg.length() == 0)) {
        a.a("MicroMsg.SDK.JumpToBizProfile.Req", "scene is jump to hardware profile, while extmsg is null");
        return null;
      } 
      return true;
    }
    
    public void fromBundle(Bundle param1Bundle) {
      super.fromBundle(param1Bundle);
      this.toUserName = param1Bundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name");
      this.extMsg = param1Bundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg");
    }
    
    public int getType() {
      return 7;
    }
    
    public void toBundle(Bundle param1Bundle) {
      super.toBundle(param1Bundle);
      param1Bundle.putString("_wxapi_jump_to_biz_profile_req_to_user_name", this.toUserName);
      param1Bundle.putString("_wxapi_jump_to_biz_profile_req_ext_msg", this.extMsg);
      param1Bundle.putInt("_wxapi_jump_to_biz_profile_req_scene", 0);
      param1Bundle.putInt("_wxapi_jump_to_biz_profile_req_profile_type", this.profileType);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\modelbiz\JumpToBizProfile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */