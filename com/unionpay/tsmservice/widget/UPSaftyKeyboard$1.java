package com.unionpay.tsmservice.widget;

import android.os.Handler;
import android.os.Message;

final class UPSaftyKeyboard$1 implements Handler.Callback {
  UPSaftyKeyboard$1(UPSaftyKeyboard paramUPSaftyKeyboard) {}
  
  public final boolean handleMessage(Message paramMessage) {
    boolean bool1 = true;
    switch (paramMessage.what) {
      default:
        return false;
      case 0:
        null = bool1;
        if (UPSaftyKeyboard.a(this.a) != null) {
          UPSaftyKeyboard.a(this.a).onShow();
          null = bool1;
        } 
        return null;
      case 1:
        if (UPSaftyKeyboard.b(this.a) != null)
          UPSaftyKeyboard.b(this.a).onHide(); 
        UPSaftyKeyboard.c(this.a);
        return bool1;
      case 2:
        break;
    } 
    boolean bool2 = bool1;
    if (UPSaftyKeyboard.d(this.a) != null) {
      UPSaftyKeyboard.a(this.a, paramMessage.arg1);
      UPSaftyKeyboard.d(this.a).onEditorChanged(UPSaftyKeyboard.e(this.a));
      bool2 = bool1;
    } 
    return bool2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\widget\UPSaftyKeyboard$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */