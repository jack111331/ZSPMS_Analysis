package com.unionpay.mobile.android.hce.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface b extends IInterface {
  void a(String paramString) throws RemoteException;
  
  void a(String paramString1, String paramString2) throws RemoteException;
  
  public static abstract class a extends Binder implements b {
    public a() {
      attachInterface(this, "com.unionpay.mobile.android.hce.service.IHCECallback");
    }
    
    public static b a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.unionpay.mobile.android.hce.service.IHCECallback");
      return (iInterface != null && iInterface instanceof b) ? (b)iInterface : new a(param1IBinder);
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
          param1Parcel2.writeString("com.unionpay.mobile.android.hce.service.IHCECallback");
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 1:
          param1Parcel1.enforceInterface("com.unionpay.mobile.android.hce.service.IHCECallback");
          a(param1Parcel1.readString(), param1Parcel1.readString());
          param1Parcel2.writeNoException();
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 2:
          break;
      } 
      param1Parcel1.enforceInterface("com.unionpay.mobile.android.hce.service.IHCECallback");
      a(param1Parcel1.readString());
      param1Parcel2.writeNoException();
      return SYNTHETIC_LOCAL_VARIABLE_5;
    }
    
    private static final class a implements b {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public final void a(String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.mobile.android.hce.service.IHCECallback");
          parcel1.writeString(param2String);
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final void a(String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.mobile.android.hce.service.IHCECallback");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final IBinder asBinder() {
        return this.a;
      }
    }
  }
  
  private static final class a implements b {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public final void a(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.mobile.android.hce.service.IHCECallback");
        parcel1.writeString(param1String);
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final void a(String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.mobile.android.hce.service.IHCECallback");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final IBinder asBinder() {
      return this.a;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\hce\service\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */