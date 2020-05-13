package com.unionpay.sdk;

import android.app.Activity;
import android.content.Context;
import java.lang.reflect.Method;

final class af implements i {
  af(Context paramContext) {}
  
  public final void a(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) {
    paramObject = paramMethod.getName();
    if (this.a instanceof Activity) {
      if (paramObject.equalsIgnoreCase("activityPaused")) {
        w.a((Activity)this.a);
        return;
      } 
    } else {
      return;
    } 
    if (paramObject.equalsIgnoreCase("activityIdle"))
      w.b((Activity)this.a); 
  }
  
  public final void a(Object paramObject1, Method paramMethod, Object[] paramArrayOfObject, Object paramObject2) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */