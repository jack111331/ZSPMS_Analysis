package com.unionpay.mobile.tsm.connect;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IInitCallback extends IInterface {
  void initFailed() throws RemoteException;
  
  void initSucceed() throws RemoteException;
  
  public static abstract class Stub extends Binder implements IInitCallback {
    private static final String DESCRIPTOR = "com.unionpay.mobile.tsm.connect.IInitCallback";
    
    static final int TRANSACTION_initFailed = 2;
    
    static final int TRANSACTION_initSucceed = 1;
    
    public Stub() {
      attachInterface(this, "com.unionpay.mobile.tsm.connect.IInitCallback");
    }
    
    public static IInitCallback asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.unionpay.mobile.tsm.connect.IInitCallback");
      return (iInterface != null && iInterface instanceof IInitCallback) ? (IInitCallback)iInterface : new Proxy(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      null = true;
      switch (param1Int1) {
        default:
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
        case 1598968902:
          param1Parcel2.writeString("com.unionpay.mobile.tsm.connect.IInitCallback");
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 1:
          param1Parcel1.enforceInterface("com.unionpay.mobile.tsm.connect.IInitCallback");
          initSucceed();
          param1Parcel2.writeNoException();
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 2:
          break;
      } 
      param1Parcel1.enforceInterface("com.unionpay.mobile.tsm.connect.IInitCallback");
      initFailed();
      param1Parcel2.writeNoException();
      return SYNTHETIC_LOCAL_VARIABLE_5;
    }
    
    private static class Proxy implements IInitCallback {
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor() {
        return "com.unionpay.mobile.tsm.connect.IInitCallback";
      }
      
      public void initFailed() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.mobile.tsm.connect.IInitCallback");
          this.mRemote.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void initSucceed() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.mobile.tsm.connect.IInitCallback");
          this.mRemote.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  private static class Proxy implements IInitCallback {
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public String getInterfaceDescriptor() {
      return "com.unionpay.mobile.tsm.connect.IInitCallback";
    }
    
    public void initFailed() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.mobile.tsm.connect.IInitCallback");
        this.mRemote.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void initSucceed() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.mobile.tsm.connect.IInitCallback");
        this.mRemote.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\tsm\connect\IInitCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */