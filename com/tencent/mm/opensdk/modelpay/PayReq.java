package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import android.util.Log;
import com.tencent.mm.opensdk.b.a;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public class PayReq extends BaseReq {
  private static final int EXTDATA_MAX_LENGTH = 1024;
  
  private static final String TAG = "MicroMsg.PaySdk.PayReq";
  
  public String appId;
  
  public String extData;
  
  public String nonceStr;
  
  public Options options;
  
  public String packageValue;
  
  public String partnerId;
  
  public String prepayId;
  
  public String sign;
  
  public String signType;
  
  public String timeStamp;
  
  public boolean checkArgs() {
    if (this.appId == null || this.appId.length() == 0) {
      String str = "checkArgs fail, invalid appId";
      Log.e("MicroMsg.PaySdk.PayReq", str);
      return false;
    } 
    if (this.partnerId == null || this.partnerId.length() == 0) {
      String str = "checkArgs fail, invalid partnerId";
      Log.e("MicroMsg.PaySdk.PayReq", str);
      return false;
    } 
    if (this.prepayId == null || this.prepayId.length() == 0) {
      String str = "checkArgs fail, invalid prepayId";
      Log.e("MicroMsg.PaySdk.PayReq", str);
      return false;
    } 
    if (this.nonceStr == null || this.nonceStr.length() == 0) {
      String str = "checkArgs fail, invalid nonceStr";
      Log.e("MicroMsg.PaySdk.PayReq", str);
      return false;
    } 
    if (this.timeStamp == null || this.timeStamp.length() == 0) {
      String str = "checkArgs fail, invalid timeStamp";
      Log.e("MicroMsg.PaySdk.PayReq", str);
      return false;
    } 
    if (this.packageValue == null || this.packageValue.length() == 0) {
      String str = "checkArgs fail, invalid packageValue";
      Log.e("MicroMsg.PaySdk.PayReq", str);
      return false;
    } 
    if (this.sign == null || this.sign.length() == 0) {
      String str = "checkArgs fail, invalid sign";
      Log.e("MicroMsg.PaySdk.PayReq", str);
      return false;
    } 
    if (this.extData != null && this.extData.length() > 1024) {
      String str = "checkArgs fail, extData length too long";
      Log.e("MicroMsg.PaySdk.PayReq", str);
      return false;
    } 
    return true;
  }
  
  public void fromBundle(Bundle paramBundle) {
    super.fromBundle(paramBundle);
    this.appId = a.b(paramBundle, "_wxapi_payreq_appid");
    this.partnerId = a.b(paramBundle, "_wxapi_payreq_partnerid");
    this.prepayId = a.b(paramBundle, "_wxapi_payreq_prepayid");
    this.nonceStr = a.b(paramBundle, "_wxapi_payreq_noncestr");
    this.timeStamp = a.b(paramBundle, "_wxapi_payreq_timestamp");
    this.packageValue = a.b(paramBundle, "_wxapi_payreq_packagevalue");
    this.sign = a.b(paramBundle, "_wxapi_payreq_sign");
    this.extData = a.b(paramBundle, "_wxapi_payreq_extdata");
    this.signType = a.b(paramBundle, "_wxapi_payreq_sign_type");
    this.options = new Options();
    this.options.fromBundle(paramBundle);
  }
  
  public int getType() {
    return 5;
  }
  
  public void toBundle(Bundle paramBundle) {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_payreq_appid", this.appId);
    paramBundle.putString("_wxapi_payreq_partnerid", this.partnerId);
    paramBundle.putString("_wxapi_payreq_prepayid", this.prepayId);
    paramBundle.putString("_wxapi_payreq_noncestr", this.nonceStr);
    paramBundle.putString("_wxapi_payreq_timestamp", this.timeStamp);
    paramBundle.putString("_wxapi_payreq_packagevalue", this.packageValue);
    paramBundle.putString("_wxapi_payreq_sign", this.sign);
    paramBundle.putString("_wxapi_payreq_extdata", this.extData);
    paramBundle.putString("_wxapi_payreq_sign_type", this.signType);
    if (this.options != null)
      this.options.toBundle(paramBundle); 
  }
  
  public static class Options {
    public static final int INVALID_FLAGS = -1;
    
    public String callbackClassName;
    
    public int callbackFlags = -1;
    
    public void fromBundle(Bundle param1Bundle) {
      this.callbackClassName = a.b(param1Bundle, "_wxapi_payoptions_callback_classname");
      this.callbackFlags = a.a(param1Bundle, "_wxapi_payoptions_callback_flags");
    }
    
    public void toBundle(Bundle param1Bundle) {
      param1Bundle.putString("_wxapi_payoptions_callback_classname", this.callbackClassName);
      param1Bundle.putInt("_wxapi_payoptions_callback_flags", this.callbackFlags);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\modelpay\PayReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */