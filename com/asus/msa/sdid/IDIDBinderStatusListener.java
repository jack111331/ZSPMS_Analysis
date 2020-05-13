package com.asus.msa.sdid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

@Keep
public interface IDIDBinderStatusListener extends IInterface {
  @Keep
  void a(IDidAidlInterface paramIDidAidlInterface);
  
  @Keep
  void b();
  
  @Keep
  public static abstract class Stub extends Binder implements IDIDBinderStatusListener {
    @Keep
    public Stub() {
      attachInterface(this, "com.asus.msa.sdid.IDIDBinderStatusListener");
    }
    
    @Keep
    public native IBinder asBinder();
    
    @Keep
    public native boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2);
    
    @Keep
    public static class Proxy implements IDIDBinderStatusListener {
      @Keep
      public IBinder a;
      
      @Keep
      public native void a(IDidAidlInterface param2IDidAidlInterface);
      
      @Keep
      public native IBinder asBinder();
      
      @Keep
      public native void b();
    }
  }
  
  @Keep
  public static class Proxy implements IDIDBinderStatusListener {
    @Keep
    public IBinder a;
    
    @Keep
    public native void a(IDidAidlInterface param1IDidAidlInterface);
    
    @Keep
    public native IBinder asBinder();
    
    @Keep
    public native void b();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\asus\msa\sdid\IDIDBinderStatusListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */