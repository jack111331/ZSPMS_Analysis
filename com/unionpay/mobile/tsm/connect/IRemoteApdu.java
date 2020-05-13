package com.unionpay.mobile.tsm.connect;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IRemoteApdu extends IInterface {
  void closeChannel(int paramInt) throws RemoteException;
  
  void init() throws RemoteException;
  
  void registerCallback(IInitCallback paramIInitCallback) throws RemoteException;
  
  String writeApdu(String paramString, int paramInt) throws RemoteException;
  
  public static abstract class Stub extends Binder implements IRemoteApdu {
    private static final String DESCRIPTOR = "com.unionpay.mobile.tsm.connect.IRemoteApdu";
    
    static final int TRANSACTION_closeChannel = 2;
    
    static final int TRANSACTION_init = 3;
    
    static final int TRANSACTION_registerCallback = 4;
    
    static final int TRANSACTION_writeApdu = 1;
    
    public Stub() {
      attachInterface(this, "com.unionpay.mobile.tsm.connect.IRemoteApdu");
    }
    
    public static IRemoteApdu asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.unionpay.mobile.tsm.connect.IRemoteApdu");
      return (iInterface != null && iInterface instanceof IRemoteApdu) ? (IRemoteApdu)iInterface : new Proxy(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      String str;
      null = true;
      switch (param1Int1) {
        default:
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
        case 1598968902:
          param1Parcel2.writeString("com.unionpay.mobile.tsm.connect.IRemoteApdu");
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 1:
          param1Parcel1.enforceInterface("com.unionpay.mobile.tsm.connect.IRemoteApdu");
          str = writeApdu(param1Parcel1.readString(), param1Parcel1.readInt());
          param1Parcel2.writeNoException();
          param1Parcel2.writeString(str);
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 2:
          str.enforceInterface("com.unionpay.mobile.tsm.connect.IRemoteApdu");
          closeChannel(str.readInt());
          param1Parcel2.writeNoException();
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 3:
          str.enforceInterface("com.unionpay.mobile.tsm.connect.IRemoteApdu");
          init();
          param1Parcel2.writeNoException();
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 4:
          break;
      } 
      str.enforceInterface("com.unionpay.mobile.tsm.connect.IRemoteApdu");
      registerCallback(IInitCallback.Stub.asInterface(str.readStrongBinder()));
      param1Parcel2.writeNoException();
      return SYNTHETIC_LOCAL_VARIABLE_5;
    }
    
    private static class Proxy implements IRemoteApdu {
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public void closeChannel(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.mobile.tsm.connect.IRemoteApdu");
          parcel1.writeInt(param2Int);
          this.mRemote.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public String getInterfaceDescriptor() {
        return "com.unionpay.mobile.tsm.connect.IRemoteApdu";
      }
      
      public void init() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.mobile.tsm.connect.IRemoteApdu");
          this.mRemote.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void registerCallback(IInitCallback param2IInitCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.mobile.tsm.connect.IRemoteApdu");
          if (param2IInitCallback != null) {
            IBinder iBinder = param2IInitCallback.asBinder();
          } else {
            param2IInitCallback = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2IInitCallback);
          this.mRemote.transact(4, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public String writeApdu(String param2String, int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.mobile.tsm.connect.IRemoteApdu");
          parcel1.writeString(param2String);
          parcel1.writeInt(param2Int);
          this.mRemote.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          param2String = parcel2.readString();
          return param2String;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  private static class Proxy implements IRemoteApdu {
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public void closeChannel(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.mobile.tsm.connect.IRemoteApdu");
        parcel1.writeInt(param1Int);
        this.mRemote.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public String getInterfaceDescriptor() {
      return "com.unionpay.mobile.tsm.connect.IRemoteApdu";
    }
    
    public void init() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.mobile.tsm.connect.IRemoteApdu");
        this.mRemote.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void registerCallback(IInitCallback param1IInitCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.mobile.tsm.connect.IRemoteApdu");
        if (param1IInitCallback != null) {
          IBinder iBinder = param1IInitCallback.asBinder();
        } else {
          param1IInitCallback = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1IInitCallback);
        this.mRemote.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public String writeApdu(String param1String, int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.mobile.tsm.connect.IRemoteApdu");
        parcel1.writeString(param1String);
        parcel1.writeInt(param1Int);
        this.mRemote.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        param1String = parcel2.readString();
        return param1String;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\tsm\connect\IRemoteApdu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */