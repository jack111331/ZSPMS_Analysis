package com.unionpay.client3.tsm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface ITsmConnection extends IInterface {
  void closeChannel(int paramInt1, int paramInt2) throws RemoteException;
  
  SeAppInfo[] getSeApps(int paramInt) throws RemoteException;
  
  String sendApdu(int paramInt1, String paramString, int paramInt2) throws RemoteException;
  
  public static abstract class Stub extends Binder implements ITsmConnection {
    private static final String DESCRIPTOR = "com.unionpay.client3.tsm.ITsmConnection";
    
    static final int TRANSACTION_closeChannel = 2;
    
    static final int TRANSACTION_getSeApps = 3;
    
    static final int TRANSACTION_sendApdu = 1;
    
    public Stub() {
      attachInterface(this, "com.unionpay.client3.tsm.ITsmConnection");
    }
    
    public static ITsmConnection asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.unionpay.client3.tsm.ITsmConnection");
      return (iInterface != null && iInterface instanceof ITsmConnection) ? (ITsmConnection)iInterface : new Proxy(param1IBinder);
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
          param1Parcel2.writeString("com.unionpay.client3.tsm.ITsmConnection");
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 1:
          param1Parcel1.enforceInterface("com.unionpay.client3.tsm.ITsmConnection");
          str = sendApdu(param1Parcel1.readInt(), param1Parcel1.readString(), param1Parcel1.readInt());
          param1Parcel2.writeNoException();
          param1Parcel2.writeString(str);
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 2:
          str.enforceInterface("com.unionpay.client3.tsm.ITsmConnection");
          closeChannel(str.readInt(), str.readInt());
          param1Parcel2.writeNoException();
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 3:
          break;
      } 
      str.enforceInterface("com.unionpay.client3.tsm.ITsmConnection");
      SeAppInfo[] arrayOfSeAppInfo = getSeApps(str.readInt());
      param1Parcel2.writeNoException();
      param1Parcel2.writeTypedArray((Parcelable[])arrayOfSeAppInfo, 1);
      return SYNTHETIC_LOCAL_VARIABLE_5;
    }
    
    private static class Proxy implements ITsmConnection {
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public void closeChannel(int param2Int1, int param2Int2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.client3.tsm.ITsmConnection");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          this.mRemote.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public String getInterfaceDescriptor() {
        return "com.unionpay.client3.tsm.ITsmConnection";
      }
      
      public SeAppInfo[] getSeApps(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.client3.tsm.ITsmConnection");
          parcel1.writeInt(param2Int);
          this.mRemote.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          return (SeAppInfo[])parcel2.createTypedArray(SeAppInfo.CREATOR);
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public String sendApdu(int param2Int1, String param2String, int param2Int2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.client3.tsm.ITsmConnection");
          parcel1.writeInt(param2Int1);
          parcel1.writeString(param2String);
          parcel1.writeInt(param2Int2);
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
  
  private static class Proxy implements ITsmConnection {
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public void closeChannel(int param1Int1, int param1Int2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.client3.tsm.ITsmConnection");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        this.mRemote.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public String getInterfaceDescriptor() {
      return "com.unionpay.client3.tsm.ITsmConnection";
    }
    
    public SeAppInfo[] getSeApps(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.client3.tsm.ITsmConnection");
        parcel1.writeInt(param1Int);
        this.mRemote.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        return (SeAppInfo[])parcel2.createTypedArray(SeAppInfo.CREATOR);
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public String sendApdu(int param1Int1, String param1String, int param1Int2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.client3.tsm.ITsmConnection");
        parcel1.writeInt(param1Int1);
        parcel1.writeString(param1String);
        parcel1.writeInt(param1Int2);
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\client3\tsm\ITsmConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */