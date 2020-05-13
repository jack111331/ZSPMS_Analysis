package com.zz.sdk.e;

import android.os.AsyncTask;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.al;
import com.zz.sdk.b.o;
import com.zz.sdk.i.t;

class hy extends AsyncTask {
  private g a;
  
  private Object b;
  
  protected static AsyncTask a(t paramt, g paramg, Object paramObject, int paramInt, o paramo) {
    hy hy1 = new hy();
    hy1.execute(new Object[] { paramt, paramg, paramObject, Integer.valueOf(paramInt), paramo });
    return hy1;
  }
  
  protected al a(Object... paramVarArgs) {
    t t = (t)paramVarArgs[0];
    g g1 = (g)paramVarArgs[1];
    Object object = paramVarArgs[2];
    al al = t.a(((Integer)paramVarArgs[3]).intValue(), (o)paramVarArgs[4]);
    if (!isCancelled()) {
      this.a = g1;
      this.b = object;
    } 
    return al;
  }
  
  protected void a(al paramal) {
    if (this.a != null)
      this.a.a(this, this.b, (a)paramal); 
    this.a = null;
    this.b = null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\hy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */