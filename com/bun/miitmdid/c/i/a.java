package com.bun.miitmdid.c.i;

import android.content.Context;
import android.support.annotation.Keep;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;
import com.heytap.openid.sdk.OpenIDSDK;

@Keep
public class a implements InnerIdSupplier {
  @Keep
  private Context a;
  
  @Keep
  public a(Context paramContext) {
    OpenIDSDK.d(paramContext);
    this.a = paramContext;
  }
  
  @Keep
  public native void a(SupplierListener paramSupplierListener);
  
  @Keep
  public native boolean a();
  
  @Keep
  public native String getAAID();
  
  @Keep
  public native String getOAID();
  
  @Keep
  public native String getUDID();
  
  @Keep
  public native String getVAID();
  
  @Keep
  public native boolean isSupported();
  
  @Keep
  public native void shutDown();
  
  @Keep
  class a implements Runnable {
    @Keep
    a(a this$0, SupplierListener param1SupplierListener) {}
    
    @Keep
    public native void run();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\miitmdid\c\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */