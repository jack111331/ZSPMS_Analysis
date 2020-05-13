package com.zz.sdk.e;

import android.text.TextUtils;
import com.zz.sdk.ParamChain;
import com.zz.sdk.i.a.a;

class hu implements Runnable {
  hu(ht paramht, String paramString) {}
  
  public void run() {
    byte b = 0;
    String str = (new a(this.a)).a;
    if (!TextUtils.equals(str, "9000") && !TextUtils.equals(str, "8000"))
      if (TextUtils.equals(str, "6001")) {
        b = 2;
      } else {
        b = 1;
      }  
    ParamChain paramChain = this.b.b.getEnv();
    if (paramChain != null) {
      hg.a(this.b.b, paramChain, b);
      this.b.b.o();
      hg.e(this.b.b, b);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\hu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */