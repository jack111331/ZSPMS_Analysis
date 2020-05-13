package com.bun.miitmdid.supplier.msa;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.bun.lib.sysParamters;
import com.bun.miitmdid.c.e.a;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

@Keep
public class b implements a, InnerIdSupplier {
  @Keep
  public SupplierListener a;
  
  @Keep
  private MsaClient b;
  
  @Keep
  public b(Context paramContext) {
    if (MsaClient.CheckService(paramContext)) {
      String str = sysParamters.g();
      if (!TextUtils.isEmpty(str))
        MsaClient.StartMsaKlService(paramContext, str); 
      this.b = new MsaClient(paramContext, this);
    } 
  }
  
  @Keep
  public native void a(SupplierListener paramSupplierListener);
  
  @Keep
  public native void a(boolean paramBoolean);
  
  @Keep
  public native boolean a();
  
  @Keep
  public native void b();
  
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\miitmdid\supplier\msa\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */