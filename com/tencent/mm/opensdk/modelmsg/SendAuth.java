package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import android.util.Log;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public final class SendAuth {
  public static class Req extends BaseReq {
    private static final int LENGTH_LIMIT = 1024;
    
    private static final String TAG = "MicroMsg.SDK.SendAuth.Req";
    
    public String scope;
    
    public String state;
    
    public Req() {}
    
    public Req(Bundle param1Bundle) {
      fromBundle(param1Bundle);
    }
    
    public boolean checkArgs() {
      if (this.scope == null || this.scope.length() == 0 || this.scope.length() > 1024) {
        String str = "checkArgs fail, scope is invalid";
        Log.e("MicroMsg.SDK.SendAuth.Req", str);
        return false;
      } 
      if (this.state != null && this.state.length() > 1024) {
        String str = "checkArgs fail, state is invalid";
        Log.e("MicroMsg.SDK.SendAuth.Req", str);
        return false;
      } 
      return true;
    }
    
    public void fromBundle(Bundle param1Bundle) {
      super.fromBundle(param1Bundle);
      this.scope = param1Bundle.getString("_wxapi_sendauth_req_scope");
      this.state = param1Bundle.getString("_wxapi_sendauth_req_state");
    }
    
    public int getType() {
      return 1;
    }
    
    public void toBundle(Bundle param1Bundle) {
      super.toBundle(param1Bundle);
      param1Bundle.putString("_wxapi_sendauth_req_scope", this.scope);
      param1Bundle.putString("_wxapi_sendauth_req_state", this.state);
    }
  }
  
  public static class Resp extends BaseResp {
    private static final int LENGTH_LIMIT = 1024;
    
    private static final String TAG = "MicroMsg.SDK.SendAuth.Resp";
    
    public String code;
    
    public String country;
    
    public String lang;
    
    public String state;
    
    public String url;
    
    public Resp() {}
    
    public Resp(Bundle param1Bundle) {
      fromBundle(param1Bundle);
    }
    
    public boolean checkArgs() {
      if (this.state != null && this.state.length() > 1024) {
        Log.e("MicroMsg.SDK.SendAuth.Resp", "checkArgs fail, state is invalid");
        return false;
      } 
      return true;
    }
    
    public void fromBundle(Bundle param1Bundle) {
      super.fromBundle(param1Bundle);
      this.code = param1Bundle.getString("_wxapi_sendauth_resp_token");
      this.state = param1Bundle.getString("_wxapi_sendauth_resp_state");
      this.url = param1Bundle.getString("_wxapi_sendauth_resp_url");
      this.lang = param1Bundle.getString("_wxapi_sendauth_resp_lang");
      this.country = param1Bundle.getString("_wxapi_sendauth_resp_country");
    }
    
    public int getType() {
      return 1;
    }
    
    public void toBundle(Bundle param1Bundle) {
      super.toBundle(param1Bundle);
      param1Bundle.putString("_wxapi_sendauth_resp_token", this.code);
      param1Bundle.putString("_wxapi_sendauth_resp_state", this.state);
      param1Bundle.putString("_wxapi_sendauth_resp_url", this.url);
      param1Bundle.putString("_wxapi_sendauth_resp_lang", this.lang);
      param1Bundle.putString("_wxapi_sendauth_resp_country", this.country);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\modelmsg\SendAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */