package com.bun.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.support.annotation.Keep;

@Keep
public interface c extends IInterface {
  @Keep
  boolean c();
  
  @Keep
  String getAAID();
  
  @Keep
  String getOAID();
  
  @Keep
  String getVAID();
  
  @Keep
  boolean isSupported();
  
  @Keep
  void shutDown();
  
  @Keep
  public static abstract class a extends Binder implements c {
    @Keep
    public static native c a(IBinder param1IBinder);
    
    @Keep
    private static class a implements c {
      @Keep
      private IBinder a;
      
      @Keep
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      @Keep
      public native IBinder asBinder();
      
      @Keep
      public native boolean c();
      
      @Keep
      public native String getAAID();
      
      @Keep
      public native String getOAID();
      
      @Keep
      public native String getVAID();
      
      @Keep
      public native boolean isSupported();
      
      @Keep
      public native void shutDown();
    }
  }
  
  @Keep
  private static class a implements c {
    @Keep
    private IBinder a;
    
    @Keep
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    @Keep
    public native IBinder asBinder();
    
    @Keep
    public native boolean c();
    
    @Keep
    public native String getAAID();
    
    @Keep
    public native String getOAID();
    
    @Keep
    public native String getVAID();
    
    @Keep
    public native boolean isSupported();
    
    @Keep
    public native void shutDown();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\lib\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */