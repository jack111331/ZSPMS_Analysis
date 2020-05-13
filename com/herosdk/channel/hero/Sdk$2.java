package com.herosdk.channel.hero;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.zz.sdk.LoginCallbackInfo;

class Sdk$2 extends Handler {
  Sdk$2(Sdk paramSdk) {}
  
  public void handleMessage(Message paramMessage) {
    String str;
    switch (paramMessage.what) {
      default:
        return;
      case 2014:
        if (paramMessage.arg1 == 0) {
          if (paramMessage.arg2 == 0) {
            if (paramMessage.obj instanceof LoginCallbackInfo) {
              Sdk.e = ((LoginCallbackInfo)paramMessage.obj).accessToken;
              if (!TextUtils.isEmpty(Sdk.e)) {
                this.a.showFloat();
                if (Sdk.f)
                  User.getInstance().loginSuccess(Sdk.a(this.a), "", "", Sdk.e); 
                User.getInstance().switchAccountSuccess(Sdk.a(this.a), "", "", Sdk.e);
              } 
            } 
            Log.d(this.a.g, " ! 登录成功，但没有用户数据");
          } 
          if (paramMessage.arg2 == 2) {
            this.a.hideFloat();
            if (Sdk.f)
              User.getInstance().loginCancel(); 
            User.getInstance().switchAccountCancel();
          } 
          if (paramMessage.arg2 != 3) {
            if (Sdk.f)
              User.getInstance().loginFailed(" ! 未知登录结果，请检查：s=" + paramMessage.arg2 + " info:" + paramMessage.obj); 
            User.getInstance().switchAccountFailed(" ! 未知登录结果，请检查：s=" + paramMessage.arg2 + " info:" + paramMessage.obj);
          } 
        } 
        if (Sdk.f)
          User.getInstance().loginFailed(" # 未知类型 t=" + paramMessage.arg1 + " s=" + paramMessage.arg2 + " info:" + paramMessage.obj); 
        User.getInstance().switchAccountFailed(" # 未知类型 t=" + paramMessage.arg1 + " s=" + paramMessage.arg2 + " info:" + paramMessage.obj);
      case 2015:
        break;
    } 
    if (paramMessage.arg1 == 1) {
      Message message;
      if (paramMessage.arg2 == 3)
        Log.d(this.a.g, "pay finish, do nothing"); 
      if (paramMessage.obj instanceof com.zz.sdk.PaymentCallbackInfo) {
        message = (Message)paramMessage.obj;
      } else {
        message = null;
      } 
      if (paramMessage.arg2 == 0)
        Pay.getInstance().paySuccess(); 
      if (paramMessage.arg2 == 1) {
        Pay pay = Pay.getInstance();
        StringBuilder stringBuilder = (new StringBuilder()).append(" ! 充值失败, 详细信息: ");
        paramMessage = message;
        if (message == null)
          str = "未知"; 
        pay.payFailed(stringBuilder.append(str).toString());
      } 
      if (((Message)str).arg2 == 2)
        Pay.getInstance().payCancel(); 
      Pay.getInstance().payFailed(" ! 未知登录结果，请检查：s=" + ((Message)str).arg2 + " info:" + ((Message)str).obj);
    } 
    Pay.getInstance().payFailed(" # 未知类型 t=" + ((Message)str).arg1 + " s=" + ((Message)str).arg2 + " info:" + ((Message)str).obj);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\channel\hero\Sdk$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */