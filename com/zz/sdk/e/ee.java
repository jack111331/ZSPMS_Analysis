package com.zz.sdk.e;

import android.os.AsyncTask;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.ag;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.t;

class ee extends AsyncTask {
  g a;
  
  Object b;
  
  protected static AsyncTask a(t paramt, g paramg, Object paramObject) {
    ee ee1 = new ee();
    ee1.execute(new Object[] { paramt, paramg, paramObject });
    return ee1;
  }
  
  protected a a(Object... paramVarArgs) {
    t t = (t)paramVarArgs[0];
    g g1 = (g)paramVarArgs[1];
    Object object = paramVarArgs[2];
    bp.a("getPayUrlMessage");
    ag ag = t.e();
    if (!isCancelled()) {
      this.a = g1;
      this.b = object;
    } 
    return (a)ag;
  }
  
  protected void a(a parama) {
    if (this.a != null)
      this.a.a(this, this.b, parama); 
    this.a = null;
    this.b = null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */