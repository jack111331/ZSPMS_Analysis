package com.herosdk.d;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

class aa implements Runnable {
  aa(x paramx, Activity paramActivity) {}
  
  public void run() {
    Toast.makeText((Context)this.a, "初始化失败，请在init之前调用setInitListener", 1).show();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */