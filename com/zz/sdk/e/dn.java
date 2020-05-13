package com.zz.sdk.e;

import android.content.Context;
import android.os.AsyncTask;
import com.zz.sdk.ParamChain;
import com.zz.sdk.b.a.a;
import com.zz.sdk.i.cq;

class dn extends AsyncTask {
  g a;
  
  Object b;
  
  protected static AsyncTask a(Context paramContext, g paramg, Object paramObject, ParamChain paramParamChain, boolean paramBoolean) {
    dn dn1 = new dn();
    dn1.execute(new Object[] { paramContext, paramg, paramObject, paramParamChain, Boolean.valueOf(paramBoolean) });
    return dn1;
  }
  
  protected a a(Object... paramVarArgs) {
    Context context = (Context)paramVarArgs[0];
    g g1 = (g)paramVarArgs[1];
    Object object = paramVarArgs[2];
    a a = cq.a((ParamChain)paramVarArgs[3], context, ((Boolean)paramVarArgs[4]).booleanValue());
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */