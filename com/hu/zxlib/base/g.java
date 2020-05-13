package com.hu.zxlib.base;

import android.os.AsyncTask;
import android.util.Log;

final class g extends AsyncTask<Object, Object, Object> {
  private g(e parame) {}
  
  protected Object doInBackground(Object... paramVarArgs) {
    try {
      Thread.sleep(300000L);
      Log.i(e.e(), "Finishing activity due to inactivity");
      e.b(this.a).finish();
    } catch (InterruptedException interruptedException) {}
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\base\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */