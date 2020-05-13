package com.zz.sdk.e;

import android.os.AsyncTask;
import com.zz.sdk.b.a.a;
import com.zz.sdk.i.t;

class fr extends AsyncTask {
  g a;
  
  Object b;
  
  static fr a(t paramt, g paramg, Object paramObject, String paramString1, String paramString2) {
    fr fr1 = new fr();
    fr1.execute(new Object[] { paramt, paramg, paramObject, paramString1, paramString2 });
    return fr1;
  }
  
  protected a a(Object... paramVarArgs) {
    t t = (t)paramVarArgs[0];
    g g1 = (g)paramVarArgs[1];
    Object object = paramVarArgs[2];
    String str2 = (String)paramVarArgs[3];
    String str1 = (String)paramVarArgs[4];
    if (!isCancelled()) {
      this.a = g1;
      this.b = object;
    } 
    return null;
  }
  
  protected void a(a parama) {
    if (this.a != null)
      this.a.a(this, this.b, parama); 
    this.a = null;
    this.b = null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\fr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */