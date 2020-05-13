package com.bun.supplier;

import android.support.annotation.Keep;

@Keep
public interface IRemoteIdSupplier extends InnerIdSupplier {
  @Keep
  String getAAID(String paramString);
  
  @Keep
  String getVAID(String paramString);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\supplier\IRemoteIdSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */