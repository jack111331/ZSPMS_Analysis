package com.zz.sdk.e;

import android.os.Handler;
import android.os.Message;
import com.zz.sdk.i.bp;

class am extends Handler {
  am(al paramal) {}
  
  public void handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        return;
      case 2015:
        break;
    } 
    if (paramMessage.arg1 == 1) {
      Message message;
      if (paramMessage.obj instanceof com.zz.sdk.PaymentCallbackInfo) {
        message = (Message)paramMessage.obj;
      } else {
        message = null;
      } 
      if (paramMessage.arg2 == 0) {
        StringBuilder stringBuilder = (new StringBuilder()).append(" - 充值成功, 详细信息: ");
        paramMessage = message;
        if (message == null)
          str = "未知"; 
        str = stringBuilder.append(str).toString();
        al.a(this.a, al.a(this.a));
      } else {
        String str1;
        if (((Message)str).arg2 == 1) {
          StringBuilder stringBuilder = (new StringBuilder()).append(" ! 充值失败, 详细信息: ");
          Message message1 = message;
          if (message == null)
            str1 = "未知"; 
          str1 = stringBuilder.append(str1).toString();
        } else if (((Message)str1).arg2 == 2) {
          StringBuilder stringBuilder = (new StringBuilder()).append(" - 充值取消, 详细信息: ");
          Message message1 = message;
          if (message == null)
            str = "未知"; 
          str = stringBuilder.append(str).toString();
        } else if (((Message)str).arg2 == 3) {
          str = " ! 充值业务结束。";
        } else {
          str = " ! 未知登录结果，请检查：s=" + ((Message)str).arg2 + " info:" + ((Message)str).obj;
        } 
      } 
      bp.a("float pay, tips:" + str);
    } 
    String str = " # 未知类型 t=" + ((Message)str).arg1 + " s=" + ((Message)str).arg2 + " info:" + ((Message)str).obj;
    bp.a("float pay, tips:" + str);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */