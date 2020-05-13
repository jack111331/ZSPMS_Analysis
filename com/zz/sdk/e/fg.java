package com.zz.sdk.e;

import android.os.AsyncTask;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.al;
import com.zz.sdk.b.o;
import com.zz.sdk.i.t;

class fg extends AsyncTask {
  g a;
  
  Object b;
  
  static fg a(t paramt, g paramg, Object paramObject, o paramo) {
    fg fg1 = new fg();
    fg1.execute(new Object[] { paramt, paramg, paramObject, paramo });
    return fg1;
  }
  
  protected a a(Object... paramVarArgs) {
    t t = (t)paramVarArgs[0];
    g g1 = (g)paramVarArgs[1];
    Object object = paramVarArgs[2];
    al al = fd.a(t, (o)paramVarArgs[3]);
    if (!isCancelled()) {
      this.a = g1;
      this.b = object;
    } 
    return (a)al;
  }
  
  protected void a(a parama) {
    if (this.a != null)
      this.a.a(this, this.b, parama); 
    this.a = null;
    this.b = null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\fg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */