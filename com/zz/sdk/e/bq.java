package com.zz.sdk.e;

import android.os.AsyncTask;
import com.zz.sdk.b.a.a;
import com.zz.sdk.i.cq;

class bq extends AsyncTask {
  private g a;
  
  private Object b;
  
  protected static AsyncTask a(cq paramcq, g paramg, Object paramObject, String paramString1, String paramString2) {
    bq bq1 = new bq();
    bq1.execute(new Object[] { paramcq, paramg, paramObject, paramString1, paramString2 });
    return bq1;
  }
  
  protected a a(Object... paramVarArgs) {
    cq cq = (cq)paramVarArgs[0];
    g g1 = (g)paramVarArgs[1];
    Object object = paramVarArgs[2];
    a a = cq.b((String)paramVarArgs[3], (String)paramVarArgs[4]);
    if (!isCancelled()) {
      this.a = g1;
      this.b = object;
    } 
    return a;
  }
  
  protected void a(a parama) {
    if (this.a != null)
      this.a.a(this, this.b, parama); 
    this.a = null;
    this.b = null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */