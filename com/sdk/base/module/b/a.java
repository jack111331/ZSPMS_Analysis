package com.sdk.base.module.b;

import android.content.Context;
import com.sdk.base.framework.c.b;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.d.a;
import com.sdk.base.module.manager.SDKManager;

public class a<T> extends a<T> {
  private b e;
  
  public a(Context paramContext, com.sdk.base.framework.b.a<T> parama, b paramb) {
    super(paramContext, parama, paramb);
    this.e = paramb;
    a(paramb);
  }
  
  private void a(b paramb) {
    if (c.i) {
      String str = SDKManager.a();
      if (com.sdk.base.framework.utils.k.a.b(str).booleanValue()) {
        this.c = str;
        this.d = str;
        return;
      } 
      this.d = c.a.a.a();
      return;
    } 
    this.d = c.a.a.a();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\module\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */