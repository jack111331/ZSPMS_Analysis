package com.zz.sdk.i;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

final class m implements Handler.Callback {
  m(TextView paramTextView) {}
  
  public boolean handleMessage(Message paramMessage) {
    null = true;
    if (paramMessage.what == 1) {
      this.a.setText(String.valueOf(paramMessage.obj));
      return null;
    } 
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */