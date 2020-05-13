package com.zz.sdk.e;

import android.os.AsyncTask;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.al;
import com.zz.sdk.b.o;
import com.zz.sdk.i.t;

class gw extends AsyncTask {
  private g a;
  
  private Object b;
  
  protected static AsyncTask a(t paramt, g paramg, int paramInt, o paramo) {
    gw gw1 = new gw();
    gw1.execute(new Object[] { paramt, paramg, Integer.valueOf(paramInt), paramo });
    return gw1;
  }
  
  protected al a(Object... paramVarArgs) {
    t t = (t)paramVarArgs[0];
    g g1 = (g)paramVarArgs[1];
    al al = t.a(6, (o)paramVarArgs[3]);
    if (!isCancelled())
      this.a = g1; 
    return al;
  }
  
  protected void a(al paramal) {
    if (this.a != null)
      this.a.a(this, this.b, (a)paramal); 
    this.a = null;
    this.b = null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\gw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */