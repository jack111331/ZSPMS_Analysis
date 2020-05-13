package com.zz.sdk.e;

import android.os.AsyncTask;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.p;
import com.zz.sdk.i.t;

class n extends AsyncTask {
  private static p a = null;
  
  private static n b = null;
  
  private g c;
  
  private Object d;
  
  protected static boolean a() {
    return (b != null);
  }
  
  protected static boolean a(g paramg, Object paramObject) {
    if (b != null) {
      b.c = paramg;
      b.d = paramObject;
      return true;
    } 
    return false;
  }
  
  protected static boolean a(t paramt, g paramg, Object paramObject, String paramString1, String paramString2) {
    null = false;
    if (b != null) {
      b.c = paramg;
      b.d = paramObject;
      return null;
    } 
    if (a != null) {
      p p1 = a;
      a = null;
      if (p1.c()) {
        paramg.a(null, paramObject, (a)p1);
        return null;
      } 
    } 
    b = new n();
    b.execute(new Object[] { paramt, paramString1, paramString2 });
    b.c = paramg;
    b.d = paramObject;
    return true;
  }
  
  protected static boolean b(g paramg, Object paramObject) {
    if (b != null && b.c == paramg && b.d == paramObject) {
      b.c = null;
      b.d = null;
      return true;
    } 
    return false;
  }
  
  protected p a(Object... paramVarArgs) {
    return ((t)paramVarArgs[0]).e((String)paramVarArgs[1], (String)paramVarArgs[2]);
  }
  
  protected void a(p paramp) {
    b = null;
    if (this.c != null) {
      a = null;
      this.c.a(this, this.d, (a)paramp);
    } else {
      a = paramp;
    } 
    this.c = null;
    this.d = null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */