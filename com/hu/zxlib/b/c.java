package com.hu.zxlib.b;

import android.os.AsyncTask;

final class c extends AsyncTask<Object, Object, Object> {
  private c(a parama) {}
  
  protected Object doInBackground(Object... paramVarArgs) {
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException interruptedException) {}
    this.a.a();
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */