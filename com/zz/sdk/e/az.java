package com.zz.sdk.e;

import android.os.AsyncTask;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.ah;
import com.zz.sdk.i.t;

class az extends AsyncTask {
  g a;
  
  Object b;
  
  protected static AsyncTask a(t paramt, g paramg, Object paramObject, int paramInt1, int paramInt2) {
    az az1 = new az();
    az1.execute(new Object[] { paramt, paramg, paramObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return az1;
  }
  
  protected a a(Object... paramVarArgs) {
    t t = (t)paramVarArgs[0];
    g g1 = (g)paramVarArgs[1];
    Object object = paramVarArgs[2];
    ah ah = t.a(((Integer)paramVarArgs[3]).intValue(), ((Integer)paramVarArgs[4]).intValue());
    if (!isCancelled()) {
      this.a = g1;
      this.b = object;
    } 
    return (a)ah;
  }
  
  protected void a(a parama) {
    if (this.a != null)
      this.a.a(this, this.b, parama); 
    this.a = null;
    this.b = null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */