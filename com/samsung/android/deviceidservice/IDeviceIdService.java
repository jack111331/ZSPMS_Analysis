package com.samsung.android.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.annotation.Keep;

@Keep
public interface IDeviceIdService extends IInterface {
  @Keep
  String getAAID(String paramString);
  
  @Keep
  String getOAID();
  
  @Keep
  String getVAID(String paramString);
  
  @Keep
  public static abstract class Stub extends Binder implements IDeviceIdService {
    @Keep
    public Stub() {
      attachInterface(this, "com.samsung.android.deviceidservice.IDeviceIdService");
    }
    
    @Keep
    public static native IDeviceIdService a(IBinder param1IBinder);
    
    @Keep
    public native IBinder asBinder();
    
    @Keep
    public native boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2);
    
    @Keep
    private static class Proxy implements IDeviceIdService {
      @Keep
      private IBinder a;
      
      @Keep
      Proxy(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      @Keep
      public native IBinder asBinder();
      
      @Keep
      public native String getAAID(String param2String);
      
      @Keep
      public native String getOAID();
      
      @Keep
      public native String getVAID(String param2String);
    }
  }
  
  @Keep
  private static class Proxy implements IDeviceIdService {
    @Keep
    private IBinder a;
    
    @Keep
    Proxy(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    @Keep
    public native IBinder asBinder();
    
    @Keep
    public native String getAAID(String param1String);
    
    @Keep
    public native String getOAID();
    
    @Keep
    public native String getVAID(String param1String);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\samsung\android\deviceidservice\IDeviceIdService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */