package com.alipay.android.app;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IRemoteServiceCallback extends IInterface {
  boolean isHideLoadingScreen() throws RemoteException;
  
  void payEnd(boolean paramBoolean, String paramString) throws RemoteException;
  
  void startActivity(String paramString1, String paramString2, int paramInt, Bundle paramBundle) throws RemoteException;
  
  public static abstract class Stub extends Binder implements IRemoteServiceCallback {
    private static final String DESCRIPTOR = "com.alipay.android.app.IRemoteServiceCallback";
    
    static final int TRANSACTION_isHideLoadingScreen = 3;
    
    static final int TRANSACTION_payEnd = 2;
    
    static final int TRANSACTION_startActivity = 1;
    
    public Stub() {
      attachInterface(this, "com.alipay.android.app.IRemoteServiceCallback");
    }
    
    public static IRemoteServiceCallback asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.alipay.android.app.IRemoteServiceCallback");
      return (iInterface != null && iInterface instanceof IRemoteServiceCallback) ? (IRemoteServiceCallback)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      String str1;
      String str2;
      boolean bool1 = false;
      null = false;
      boolean bool2 = true;
      switch (param1Int1) {
        default:
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
        case 1598968902:
          param1Parcel2.writeString("com.alipay.android.app.IRemoteServiceCallback");
          return bool2;
        case 1:
          param1Parcel1.enforceInterface("com.alipay.android.app.IRemoteServiceCallback");
          str1 = param1Parcel1.readString();
          str2 = param1Parcel1.readString();
          param1Int1 = param1Parcel1.readInt();
          if (param1Parcel1.readInt() != 0) {
            Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1);
          } else {
            param1Parcel1 = null;
          } 
          startActivity(str1, str2, param1Int1, (Bundle)param1Parcel1);
          param1Parcel2.writeNoException();
          return bool2;
        case 2:
          param1Parcel1.enforceInterface("com.alipay.android.app.IRemoteServiceCallback");
          if (param1Parcel1.readInt() != 0)
            null = true; 
          payEnd(null, param1Parcel1.readString());
          param1Parcel2.writeNoException();
          return bool2;
        case 3:
          break;
      } 
      param1Parcel1.enforceInterface("com.alipay.android.app.IRemoteServiceCallback");
      null = isHideLoadingScreen();
      param1Parcel2.writeNoException();
      param1Int1 = bool1;
      if (null)
        param1Int1 = 1; 
      param1Parcel2.writeInt(param1Int1);
      return bool2;
    }
    
    private static final class a implements IRemoteServiceCallback {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      private static String a() {
        return "com.alipay.android.app.IRemoteServiceCallback";
      }
      
      public final IBinder asBinder() {
        return this.a;
      }
      
      public final boolean isHideLoadingScreen() throws RemoteException {
        boolean bool = false;
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alipay.android.app.IRemoteServiceCallback");
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          int i = parcel2.readInt();
          if (i != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final void payEnd(boolean param2Boolean, String param2String) throws RemoteException {
        boolean bool = false;
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alipay.android.app.IRemoteServiceCallback");
          if (param2Boolean)
            bool = true; 
          parcel1.writeInt(bool);
          parcel1.writeString(param2String);
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final void startActivity(String param2String1, String param2String2, int param2Int, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alipay.android.app.IRemoteServiceCallback");
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
  
  private static final class a implements IRemoteServiceCallback {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    private static String a() {
      return "com.alipay.android.app.IRemoteServiceCallback";
    }
    
    public final IBinder asBinder() {
      return this.a;
    }
    
    public final boolean isHideLoadingScreen() throws RemoteException {
      boolean bool = false;
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alipay.android.app.IRemoteServiceCallback");
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        if (i != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final void payEnd(boolean param1Boolean, String param1String) throws RemoteException {
      boolean bool = false;
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alipay.android.app.IRemoteServiceCallback");
        if (param1Boolean)
          bool = true; 
        parcel1.writeInt(bool);
        parcel1.writeString(param1String);
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final void startActivity(String param1String1, String param1String2, int param1Int, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alipay.android.app.IRemoteServiceCallback");
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\android\app\IRemoteServiceCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */