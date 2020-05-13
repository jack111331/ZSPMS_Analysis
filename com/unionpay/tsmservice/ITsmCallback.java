package com.unionpay.tsmservice;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITsmCallback extends IInterface {
  void onError(String paramString1, String paramString2) throws RemoteException;
  
  void onResult(Bundle paramBundle) throws RemoteException;
  
  public static abstract class Stub extends Binder implements ITsmCallback {
    public Stub() {
      attachInterface(this, "com.unionpay.tsmservice.ITsmCallback");
    }
    
    public static ITsmCallback asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.unionpay.tsmservice.ITsmCallback");
      return (iInterface != null && iInterface instanceof ITsmCallback) ? (ITsmCallback)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      switch (param1Int1) {
        default:
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
        case 1598968902:
          param1Parcel2.writeString("com.unionpay.tsmservice.ITsmCallback");
          return true;
        case 1:
          param1Parcel1.enforceInterface("com.unionpay.tsmservice.ITsmCallback");
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
      param1Parcel1.enforceInterface("com.unionpay.tsmservice.ITsmCallback");
      onError(param1Parcel1.readString(), param1Parcel1.readString());
      param1Parcel2.writeNoException();
      return true;
    }
    
    private static final class a implements ITsmCallback {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public final IBinder asBinder() {
        return this.a;
      }
      
      public final void onError(String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmCallback");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final void onResult(Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmCallback");
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  private static final class a implements ITsmCallback {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public final IBinder asBinder() {
      return this.a;
    }
    
    public final void onError(String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmCallback");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final void onResult(Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmCallback");
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\ITsmCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */