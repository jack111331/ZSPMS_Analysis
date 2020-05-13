package com.zz.sdk.e;

import android.content.Context;
import com.zz.sdk.b.o;
import com.zz.sdk.i.t;

class fe extends Thread {
  o a = this.c;
  
  t b = t.a(this.d);
  
  fe(fd paramfd, String paramString, o paramo, Context paramContext) {
    super(paramString);
  }
  
  public void run() {
    fd.a(this.b, this.a);
    this.a = null;
    this.b = null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\fe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */