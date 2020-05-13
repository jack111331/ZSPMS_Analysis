package com.zz.sdk.e;

import android.os.AsyncTask;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.al;
import com.zz.sdk.b.o;
import com.zz.sdk.i.t;

class fb extends AsyncTask {
  g a;
  
  Object b;
  
  static fb a(t paramt, g paramg, Object paramObject, o paramo) {
    fb fb1 = new fb();
    fb1.execute(new Object[] { paramt, paramg, paramObject, paramo });
    return fb1;
  }
  
  protected al a(Object... paramVarArgs) {
    t t = (t)paramVarArgs[0];
    g g1 = (g)paramVarArgs[1];
    Object object = paramVarArgs[2];
    al al = t.a(1002, (o)paramVarArgs[3]);
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\fb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */