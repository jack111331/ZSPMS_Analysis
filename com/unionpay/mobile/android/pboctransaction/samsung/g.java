package com.unionpay.mobile.android.pboctransaction.samsung;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.model.a;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.tsmservice.data.SeAppListItem;
import com.unionpay.tsmservice.data.VirtualCardInfo;
import com.unionpay.tsmservice.result.GetSeAppListResult;
import java.util.ArrayList;

final class g implements Handler.Callback {
  g(f paramf) {}
  
  public final boolean handleMessage(Message paramMessage) {
    Message message3;
    Bundle bundle;
    String str2;
    VirtualCardInfo virtualCardInfo;
    a a;
    Message message2;
    String str3;
    int i;
    switch (paramMessage.what) {
      default:
        return false;
      case 1000:
        f.a(this.a).removeMessages(4);
        k.c("uppay", "init success");
        f.a(this.a, true);
        this.a.h = true;
      case 1014:
        f.a(this.a).removeMessages(4);
        k.c("uppay", "list success");
        if (f.b(this.a) != null) {
          ArrayList arrayList = new ArrayList();
          SeAppListItem[] arrayOfSeAppListItem = ((GetSeAppListResult)paramMessage.obj).getSeAppList();
          if (arrayOfSeAppListItem != null && arrayOfSeAppListItem.length > 0) {
            ArrayList<a> arrayList1 = new ArrayList();
            byte b = 0;
            while (true) {
              if (b < arrayOfSeAppListItem.length) {
                if (arrayOfSeAppListItem[b] != null && arrayOfSeAppListItem[b].getAppDetail() != null && arrayOfSeAppListItem[b].getAppDetail().getAppID() != null) {
                  boolean bool;
                  f f1 = this.a;
                  str3 = arrayOfSeAppListItem[b].getAppDetail().getAppID().getAppAid();
                  if (str3 != null && str3.length() > 16 && !"06".equalsIgnoreCase(str3.substring(14, 16))) {
                    bool = false;
                  } else {
                    bool = true;
                  } 
                  if (!bool)
                    arrayList1.add(new a(1, arrayOfSeAppListItem[b].getAppDetail().getAppID().getAppAid(), "", arrayOfSeAppListItem[b].getAppDetail().getMpan(), 1)); 
                } 
                b++;
                continue;
              } 
              message3 = f.a(this.a).obtainMessage(8, arrayList1);
              f.b(this.a).sendMessage(message3);
            } 
          } 
          break;
        } 
      case 1011:
        k.c("uppay", "channel success");
        bundle = (Bundle)message3.obj;
        f.a(this.a, bundle.getString("channel"));
        f.b(this.a, bundle.getString("apdu"));
      case 1012:
        k.c("uppay", "apdu success version 3.3.1");
        f.a(this.a).removeMessages(3);
        f.c(this.a, (String)((Message)bundle).obj);
      case 1013:
        k.c("uppay", "close channel success");
        f.d(this.a, "success");
      case 1:
        f.a(this.a).removeMessages(4);
        k.c("uppay", "msg error");
        i = ((Message)bundle).arg1;
        str2 = (String)((Message)bundle).obj;
        f.a(this.a, i, str2);
      case 4:
        k.c("uppay", "timeout");
        i = ((Message)str2).arg1;
        f.a(this.a, i, "");
      case 1015:
        f.a(this.a).removeMessages(4);
        k.c("uppay-spay", "get spay list call back");
        virtualCardInfo = (VirtualCardInfo)((Message)str2).obj;
        a = new a(32, virtualCardInfo.getAppID().getAppAid(), "", virtualCardInfo.getCardNo(), 1);
        message2 = f.b(this.a).obtainMessage(2000, a);
        f.b(this.a).sendMessage(message2);
      case 3:
        k.c("uppay-spay", "send apdu time out");
        f.c(this.a);
      case 1016:
        f.a(this.a).removeMessages(4);
        k.c("uppay-spay", "check spay support");
        f.d(this.a).a(true);
      case 1018:
        f.a(this.a).removeMessages(4);
        f.b(this.a, ((Bundle)message2.obj).getBoolean("KEY_SUCCESS_VENDOR"));
        k.c("uppay-spay", "mIsVendorStateReady: " + f.e(this.a));
        k.c("uppay-spay", "get vendor pay status");
        f.d(this.a).a(true);
    } 
    String str1 = str3;
    Message message1 = f.a(this.a).obtainMessage(8, str1);
    f.b(this.a).sendMessage(message1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\samsung\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */