package com.zz.sdk.e;

import android.os.AsyncTask;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.af;
import com.zz.sdk.b.o;
import com.zz.sdk.i.t;

class hx extends AsyncTask {
  g a;
  
  Object b;
  
  protected static AsyncTask a(t paramt, g paramg, Object paramObject, o paramo) {
    hx hx1 = new hx();
    hx1.execute(new Object[] { paramt, paramg, paramObject, paramo });
    return hx1;
  }
  
  protected af a(Object... paramVarArgs) {
    t t = (t)paramVarArgs[0];
    g g1 = (g)paramVarArgs[1];
    Object object = paramVarArgs[2];
    o o = (o)paramVarArgs[3];
    if (o.a == null);
    af af = t.a(o);
    if (!isCancelled()) {
      this.a = g1;
      this.b = object;
    } 
    return af;
  }
  
  protected void a(af paramaf) {
    if (this.a != null)
      this.a.a(this, this.b, (a)paramaf); 
    this.a = null;
    this.b = null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\hx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */