package com.sina.sso;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface RemoteSSO extends IInterface {
  String getActivityName() throws RemoteException;
  
  String getLoginUserName() throws RemoteException;
  
  String getPackageName() throws RemoteException;
  
  public static abstract class Stub extends Binder implements RemoteSSO {
    private static final String DESCRIPTOR = "com.sina.sso.RemoteSSO";
    
    static final int TRANSACTION_getActivityName = 2;
    
    static final int TRANSACTION_getLoginUserName = 3;
    
    static final int TRANSACTION_getPackageName = 1;
    
    public Stub() {
      attachInterface(this, "com.sina.sso.RemoteSSO");
    }
    
    public static RemoteSSO asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.sina.sso.RemoteSSO");
      return (iInterface != null && iInterface instanceof RemoteSSO) ? (RemoteSSO)iInterface : new Proxy(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 != 1598968902) {
        switch (param1Int1) {
          default:
            return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
          case 3:
            param1Parcel1.enforceInterface("com.sina.sso.RemoteSSO");
            str = getLoginUserName();
            param1Parcel2.writeNoException();
            param1Parcel2.writeString(str);
            return true;
          case 2:
            str.enforceInterface("com.sina.sso.RemoteSSO");
            str = getActivityName();
            param1Parcel2.writeNoException();
            param1Parcel2.writeString(str);
            return true;
          case 1:
            break;
        } 
        str.enforceInterface("com.sina.sso.RemoteSSO");
        String str = getPackageName();
        param1Parcel2.writeNoException();
        param1Parcel2.writeString(str);
        return true;
      } 
      param1Parcel2.writeString("com.sina.sso.RemoteSSO");
      return true;
    }
    
    private static class Proxy implements RemoteSSO {
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public String getActivityName() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.sina.sso.RemoteSSO");
          this.mRemote.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readString();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public String getInterfaceDescriptor() {
        return "com.sina.sso.RemoteSSO";
      }
      
      public String getLoginUserName() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.sina.sso.RemoteSSO");
          this.mRemote.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readString();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public String getPackageName() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.sina.sso.RemoteSSO");
          this.mRemote.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readString();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  private static class Proxy implements RemoteSSO {
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public String getActivityName() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.sina.sso.RemoteSSO");
        this.mRemote.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readString();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public String getInterfaceDescriptor() {
      return "com.sina.sso.RemoteSSO";
    }
    
    public String getLoginUserName() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.sina.sso.RemoteSSO");
        this.mRemote.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readString();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public String getPackageName() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.sina.sso.RemoteSSO");
        this.mRemote.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readString();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\sso\RemoteSSO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */