package com.herosdk.d;

import android.util.Log;
import com.herosdk.a.f;
import com.herosdk.a.n;
import com.herosdk.listener.ICommonListener;
import java.util.Map;

final class bg implements Runnable {
  bg(int paramInt, ICommonListener paramICommonListener) {}
  
  public void run() {
    if (this.a == 1) {
      Log.d("frameLib", "idSH 01");
      f.a(x.a().x(), n.class, (Map)f.a().a("key_show_close", Boolean.valueOf(true)).a("key_show_back", Boolean.valueOf(false)).a("key_callback", this.b));
      return;
    } 
    if (this.a == 2) {
      Log.d("frameLib", "idSH 02");
      f.a(x.a().x(), n.class, (Map)f.a().a("key_show_close", Boolean.valueOf(false)).a("key_show_back", Boolean.valueOf(false)).a("key_callback", this.b));
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */