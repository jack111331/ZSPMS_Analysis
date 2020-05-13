package com.tencent.mm.sdk.modelbase;

import android.os.Bundle;

public abstract class BaseReq {
  public String openId;
  
  public String transaction;
  
  public abstract boolean checkArgs();
  
  public void fromBundle(Bundle paramBundle) {
    this.transaction = paramBundle.getString("_wxapi_basereq_transaction");
    this.openId = paramBundle.getString("_wxapi_basereq_openid");
  }
  
  public abstract int getType();
  
  public void toBundle(Bundle paramBundle) {
    paramBundle.putInt("_wxapi_command_type", getType());
    paramBundle.putString("_wxapi_basereq_transaction", this.transaction);
    paramBundle.putString("_wxapi_basereq_openid", this.openId);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\modelbase\BaseReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */