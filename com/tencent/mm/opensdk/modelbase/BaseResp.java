package com.tencent.mm.opensdk.modelbase;

import android.os.Bundle;

public abstract class BaseResp {
  public int errCode;
  
  public String errStr;
  
  public String openId;
  
  public String transaction;
  
  public abstract boolean checkArgs();
  
  public void fromBundle(Bundle paramBundle) {
    this.errCode = paramBundle.getInt("_wxapi_baseresp_errcode");
    this.errStr = paramBundle.getString("_wxapi_baseresp_errstr");
    this.transaction = paramBundle.getString("_wxapi_baseresp_transaction");
    this.openId = paramBundle.getString("_wxapi_baseresp_openId");
  }
  
  public abstract int getType();
  
  public void toBundle(Bundle paramBundle) {
    paramBundle.putInt("_wxapi_command_type", getType());
    paramBundle.putInt("_wxapi_baseresp_errcode", this.errCode);
    paramBundle.putString("_wxapi_baseresp_errstr", this.errStr);
    paramBundle.putString("_wxapi_baseresp_transaction", this.transaction);
    paramBundle.putString("_wxapi_baseresp_openId", this.openId);
  }
  
  public static interface ErrCode {
    public static final int ERR_AUTH_DENIED = -4;
    
    public static final int ERR_BAN = -6;
    
    public static final int ERR_COMM = -1;
    
    public static final int ERR_OK = 0;
    
    public static final int ERR_SENT_FAILED = -3;
    
    public static final int ERR_UNSUPPORT = -5;
    
    public static final int ERR_USER_CANCEL = -2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\modelbase\BaseResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */