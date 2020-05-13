package com.asus.msa.SupplementaryDID;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.annotation.Keep;

@Keep
public interface IDidAidlInterface extends IInterface {
  @Keep
  boolean a();
  
  @Keep
  String getAAID();
  
  @Keep
  String getOAID();
  
  @Keep
  String getUDID();
  
  @Keep
  String getVAID();
  
  @Keep
  public static abstract class Stub extends Binder implements IDidAidlInterface {
    @Keep
    public Stub() {
      attachInterface(this, "com.asus.msa.SupplementaryDID.IDidAidlInterface");
    }
    
    @Keep
    public static native IDidAidlInterface a(IBinder param1IBinder);
    
    @Keep
    public native IBinder asBinder();
    
    @Keep
    public native boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2);
    
    @Keep
    public static class Proxy implements IDidAidlInterface {
      @Keep
      public IBinder a;
      
      @Keep
      public Proxy(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      @Keep
      public native boolean a();
      
      @Keep
      public native IBinder asBinder();
      
      @Keep
      public native String getAAID();
      
      @Keep
      public native String getOAID();
      
      @Keep
      public native String getUDID();
      
      @Keep
      public native String getVAID();
    }
  }
  
  @Keep
  public static class Proxy implements IDidAidlInterface {
    @Keep
    public IBinder a;
    
    @Keep
    public Proxy(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    @Keep
    public native boolean a();
    
    @Keep
    public native IBinder asBinder();
    
    @Keep
    public native String getAAID();
    
    @Keep
    public native String getOAID();
    
    @Keep
    public native String getUDID();
    
    @Keep
    public native String getVAID();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\asus\msa\SupplementaryDID\IDidAidlInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */