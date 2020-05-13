package com.bun.miitmdid.core;

import android.content.Context;
import android.support.annotation.Keep;
import com.bun.miitmdid.a.b;
import com.bun.supplier.IIdentifierListener;
import com.bun.supplier.IdSupplier;
import com.bun.supplier.SupplierListener;

@Keep
public class MdidSdk implements SupplierListener {
  @Keep
  private IIdentifierListener _InnerListener;
  
  @Keep
  private b _setting;
  
  @Keep
  public MdidSdk() {
    try {
      com.bun.lib.a.a(true);
    } catch (Exception exception) {
      com.bun.lib.a.b("mdidsdk", "extractor exception!", exception);
    } 
  }
  
  @Keep
  public MdidSdk(boolean paramBoolean) {
    try {
      com.bun.lib.a.a(paramBoolean);
    } catch (Exception exception) {
      com.bun.lib.a.b("mdidsdk", "extractor exception!", exception);
    } 
  }
  
  @Keep
  private native int _InnerFailed(int paramInt, IdSupplier paramIdSupplier);
  
  @Keep
  public native int InitSdk(Context paramContext, IIdentifierListener paramIIdentifierListener);
  
  @Keep
  public native void OnSupport(boolean paramBoolean, IdSupplier paramIdSupplier);
  
  @Keep
  public native void UnInitSdk();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\miitmdid\core\MdidSdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */