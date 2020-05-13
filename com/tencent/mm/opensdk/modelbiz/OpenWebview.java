package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import java.net.URLEncoder;

public class OpenWebview {
  public static class Req extends BaseReq {
    private static final int MAX_URL_LENGHT = 10240;
    
    public String url;
    
    public boolean checkArgs() {
      return (this.url == null || this.url.length() < 0) ? false : (!(this.url.length() > 10240));
    }
    
    public int getType() {
      return 12;
    }
    
    public void toBundle(Bundle param1Bundle) {
      super.toBundle(param1Bundle);
      param1Bundle.putString("_wxapi_jump_to_webview_url", URLEncoder.encode(this.url));
    }
  }
  
  public static class Resp extends BaseResp {
    public String result;
    
    public Resp() {}
    
    public Resp(Bundle param1Bundle) {
      fromBundle(param1Bundle);
    }
    
    public boolean checkArgs() {
      return true;
    }
    
    public void fromBundle(Bundle param1Bundle) {
      super.fromBundle(param1Bundle);
      this.result = param1Bundle.getString("_wxapi_open_webview_result");
    }
    
    public int getType() {
      return 12;
    }
    
    public void toBundle(Bundle param1Bundle) {
      super.toBundle(param1Bundle);
      param1Bundle.putString("_wxapi_open_webview_result", this.result);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\modelbiz\OpenWebview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */