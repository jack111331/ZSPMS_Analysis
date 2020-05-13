package com.bun.miitmdid.c.b;

import android.content.Context;
import android.os.IBinder;
import android.support.annotation.Keep;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
import com.asus.msa.sdid.IDIDBinderStatusListener;
import com.asus.msa.sdid.SupplementaryDIDManager;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

@Keep
public class a implements IDIDBinderStatusListener, InnerIdSupplier {
  @Keep
  private SupplierListener a;
  
  @Keep
  private String b = "";
  
  @Keep
  private String c = "";
  
  @Keep
  private String d = "";
  
  @Keep
  private String e = "";
  
  @Keep
  private SupplementaryDIDManager f;
  
  @Keep
  private boolean g = false;
  
  @Keep
  private boolean h = false;
  
  @Keep
  public a(Context paramContext, SupplierListener paramSupplierListener) {
    this.a = paramSupplierListener;
    this.f = new SupplementaryDIDManager(paramContext);
  }
  
  @Keep
  public native void a(IDidAidlInterface paramIDidAidlInterface);
  
  @Keep
  public native void a(SupplierListener paramSupplierListener);
  
  @Keep
  public native boolean a();
  
  @Keep
  public native IBinder asBinder();
  
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\miitmdid\c\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */