package com.herosdk.d;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

final class aw implements Runnable {
  aw(Activity paramActivity) {}
  
  public void run() {
    Toast.makeText((Context)this.a, "账号截图已保存至相册", 0).show();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */