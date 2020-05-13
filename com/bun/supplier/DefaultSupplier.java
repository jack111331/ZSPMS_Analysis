package com.bun.supplier;

import android.support.annotation.Keep;

@Keep
public class DefaultSupplier implements IdSupplier {
  @Keep
  public String getAAID() {
    return "";
  }
  
  @Keep
  public String getOAID() {
    return "";
  }
  
  @Keep
  public String getVAID() {
    return "";
  }
  
  @Keep
  public boolean isSupported() {
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\supplier\DefaultSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */