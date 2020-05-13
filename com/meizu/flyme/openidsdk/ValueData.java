package com.meizu.flyme.openidsdk;

import android.support.annotation.Keep;

@Keep
public class ValueData {
  @Keep
  public String a;
  
  @Keep
  public int b;
  
  @Keep
  public long c;
  
  @Keep
  public ValueData(String paramString, int paramInt) {
    this.a = paramString;
    this.b = paramInt;
    this.c = System.currentTimeMillis() + 86400000L;
  }
  
  @Keep
  public native String toString();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\meizu\flyme\openidsdk\ValueData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */