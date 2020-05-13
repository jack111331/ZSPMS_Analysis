package com.unionpay.tsmservice;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITsmActivityCallback extends IInterface {
  void startActivity(String paramString1, String paramString2, int paramInt, Bundle paramBundle) throws RemoteException;
  
  public static abstract class Stub extends Binder implements ITsmActivityCallback {
    public Stub() {
      attachInterface(this, "com.unionpay.tsmservice.ITsmActivityCallback");
    }
    
    public static ITsmActivityCallback asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.unionpay.tsmservice.ITsmActivityCallback");
      return (iInterface != null && iInterface instanceof ITsmActivityCallback) ? (ITsmActivityCallback)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      switch (param1Int1) {
        default:
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
        case 1598968902:
          param1Parcel2.writeString("com.unionpay.tsmservice.ITsmActivityCallback");
          return true;
        case 1:
          break;
      } 
      param1Parcel1.enforceInterface("com.unionpay.tsmservice.ITsmActivityCallback");
      String str1 = param1Parcel1.readString();
      String str2 = param1Parcel1.readString();
      param1Int1 = param1Parcel1.readInt();
      if (param1Parcel1.readInt() != 0) {
        Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1);
      } else {
        param1Parcel1 = null;
      } 
      startActivity(str1, str2, param1Int1, (Bundle)param1Parcel1);
      param1Parcel2.writeNoException();
      return true;
    }
    
    private static final class a implements ITsmActivityCallback {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public final IBinder asBinder() {
        return this.a;
      }
      
      public final void startActivity(String param2String1, String param2String2, int param2Int, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmActivityCallback");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          parcel1.writeInt(param2Int);
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
  
  private static final class a implements ITsmActivityCallback {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public final IBinder asBinder() {
      return this.a;
    }
    
    public final void startActivity(String param1String1, String param1String2, int param1Int, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmActivityCallback");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        parcel1.writeInt(param1Int);
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\ITsmActivityCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */