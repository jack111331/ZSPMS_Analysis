package com.zz.sdk.i;

import android.content.Context;
import com.zz.sdk.b.ac;

public class by implements Runnable {
  private Context a;
  
  private ac b;
  
  public by(Context paramContext, ac paramac) {
    this.a = paramContext;
    this.b = paramac;
  }
  
  public void run() {
    this.b.a(this.a);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */