package com.bun.miitmdid.c.f;

import android.content.Context;
import android.support.annotation.Keep;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

@Keep
public class a implements InnerIdSupplier {
  @Keep
  private Context a;
  
  @Keep
  public a(Context paramContext) {
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
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\miitmdid\c\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */