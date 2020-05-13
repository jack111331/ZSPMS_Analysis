package com.unionpay.client3.tsm;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITsmConnectionCallback extends IInterface {
  void onError(String paramString1, String paramString2) throws RemoteException;
  
  void onResult(Bundle paramBundle) throws RemoteException;
  
  public static abstract class Stub extends Binder implements ITsmConnectionCallback {
    private static final String DESCRIPTOR = "com.unionpay.client3.tsm.ITsmConnectionCallback";
    
    static final int TRANSACTION_onError = 2;
    
    static final int TRANSACTION_onResult = 1;
    
    public Stub() {
      attachInterface(this, "com.unionpay.client3.tsm.ITsmConnectionCallback");
    }
    
    public static ITsmConnectionCallback asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.unionpay.client3.tsm.ITsmConnectionCallback");
      return (iInterface != null && iInterface instanceof ITsmConnectionCallback) ? (ITsmConnectionCallback)iInterface : new Proxy(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      switch (param1Int1) {
        default:
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
        case 1598968902:
          param1Parcel2.writeString("com.unionpay.client3.tsm.ITsmConnectionCallback");
          return true;
        case 1:
          param1Parcel1.enforceInterface("com.unionpay.client3.tsm.ITsmConnectionCallback");
          if (param1Parcel1.readInt() != 0) {
            Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1);
          } else {
            param1Parcel1 = null;
          } 
          onResult((Bundle)param1Parcel1);
          param1Parcel2.writeNoException();
          return true;
        case 2:
          break;
      } 
      param1Parcel1.enforceInterface("com.unionpay.client3.tsm.ITsmConnectionCallback");
      onError(param1Parcel1.readString(), param1Parcel1.readString());
      param1Parcel2.writeNoException();
      return true;
    }
    
    private static class Proxy implements ITsmConnectionCallback {
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor() {
        return "com.unionpay.client3.tsm.ITsmConnectionCallback";
      }
      
      public void onError(String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.client3.tsm.ITsmConnectionCallback");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          this.mRemote.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onResult(Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.client3.tsm.ITsmConnectionCallback");
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
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
  
  private static class Proxy implements ITsmConnectionCallback {
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public String getInterfaceDescriptor() {
      return "com.unionpay.client3.tsm.ITsmConnectionCallback";
    }
    
    public void onError(String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.client3.tsm.ITsmConnectionCallback");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        this.mRemote.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onResult(Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.client3.tsm.ITsmConnectionCallback");
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\client3\tsm\ITsmConnectionCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */