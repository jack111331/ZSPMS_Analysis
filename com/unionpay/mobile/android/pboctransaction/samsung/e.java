package com.unionpay.mobile.android.pboctransaction.samsung;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.tsmservice.ITsmCallback;
import com.unionpay.tsmservice.data.VirtualCardInfo;
import com.unionpay.tsmservice.result.CheckSSamsungPayResult;
import com.unionpay.tsmservice.result.GetCardInfoBySpayResult;
import com.unionpay.tsmservice.result.GetSeAppListResult;
import com.unionpay.tsmservice.result.InitResult;
import com.unionpay.tsmservice.result.OpenChannelResult;
import com.unionpay.tsmservice.result.SendApduResult;
import com.unionpay.tsmservice.result.VendorPayStatusResult;

public final class e extends ITsmCallback.Stub {
  private int a;
  
  private Handler b;
  
  public e(int paramInt, Handler paramHandler) {
    this.a = paramInt;
    this.b = paramHandler;
  }
  
  public final void onError(String paramString1, String paramString2) throws RemoteException {
    Bundle bundle;
    Log.e("uppay", "errorCode:" + paramString1 + ", errorDesc:" + paramString2);
    if ("1003700023".equals(paramString1) && this.a == 1018) {
      k.c("uppay", "error 100370023 from get vendor pay status");
      bundle = new Bundle();
      bundle.putBoolean("KEY_SUCCESS_VENDOR", false);
      this.b.sendMessage(Message.obtain(this.b, 1018, bundle));
      return;
    } 
    this.b.sendMessage(Message.obtain(this.b, 1, this.a, 0, bundle));
  }
  
  public final void onResult(Bundle paramBundle) throws RemoteException {
    GetSeAppListResult getSeAppListResult;
    String str1;
    VirtualCardInfo virtualCardInfo;
    OpenChannelResult openChannelResult;
    String str2;
    Bundle bundle2;
    switch (this.a) {
      default:
        return;
      case 1000:
        paramBundle.setClassLoader(InitResult.class.getClassLoader());
        this.b.sendMessage(Message.obtain(this.b, 1000, paramBundle));
      case 1014:
        paramBundle.setClassLoader(GetSeAppListResult.class.getClassLoader());
        getSeAppListResult = (GetSeAppListResult)paramBundle.get("result");
        this.b.sendMessage(Message.obtain(this.b, 1014, getSeAppListResult));
      case 1011:
        getSeAppListResult.setClassLoader(OpenChannelResult.class.getClassLoader());
        openChannelResult = (OpenChannelResult)getSeAppListResult.get("result");
        str1 = openChannelResult.getChannel();
        str2 = openChannelResult.getOutHexApdu();
        bundle2 = new Bundle();
        bundle2.putString("channel", str1);
        bundle2.putString("apdu", str2);
        this.b.sendMessage(Message.obtain(this.b, 1011, bundle2));
      case 1012:
        str1.setClassLoader(SendApduResult.class.getClassLoader());
        str1 = ((SendApduResult)str1.get("result")).getOutHexApdu();
        this.b.sendMessage(Message.obtain(this.b, 1012, str1));
      case 1013:
        this.b.sendMessage(Message.obtain(this.b, 1013, ""));
      case 1015:
        str1.setClassLoader(GetCardInfoBySpayResult.class.getClassLoader());
        virtualCardInfo = ((GetCardInfoBySpayResult)str1.get("result")).getVirtualCardInfo();
        this.b.sendMessage(Message.obtain(this.b, 1015, virtualCardInfo));
      case 1016:
        k.c("uppay-spay", "check spay support callback");
        virtualCardInfo.setClassLoader(CheckSSamsungPayResult.class.getClassLoader());
        virtualCardInfo.get("result");
        this.b.sendMessage(Message.obtain(this.b, 1016, ""));
      case 1018:
        break;
    } 
    k.c("uppay-spay", "get vendor pay status callback");
    virtualCardInfo.setClassLoader(VendorPayStatusResult.class.getClassLoader());
    Bundle bundle1 = ((VendorPayStatusResult)virtualCardInfo.get("result")).getVendorPayStatusResult();
    bundle1.putBoolean("KEY_SUCCESS_VENDOR", true);
    this.b.sendMessage(Message.obtain(this.b, 1018, bundle1));
    k.c("unpay", "result vendorPayStatusResult max card num reached:" + bundle1.getBoolean("maxCardNumReached"));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\samsung\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */