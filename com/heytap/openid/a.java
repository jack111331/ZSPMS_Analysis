package com.heytap.openid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.support.annotation.Keep;

@Keep
public interface a extends IInterface {
  @Keep
  public static abstract class a extends Binder implements a {
    @Keep
    public static native a a(IBinder param1IBinder);
    
    @Keep
    private static class a implements a {
      @Keep
      public IBinder a;
      
      @Keep
      public a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      @Keep
      public native String a(String param2String1, String param2String2, String param2String3);
      
      @Keep
      public native IBinder asBinder();
    }
  }
  
  @Keep
  private static class a implements a {
    @Keep
    public IBinder a;
    
    @Keep
    public a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    @Keep
    public native String a(String param1String1, String param1String2, String param1String3);
    
    @Keep
    public native IBinder asBinder();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\heytap\openid\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */