package com.unionpay.mobile.android.hce.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface a extends IInterface {
  String a(String paramString1, String paramString2, b paramb) throws RemoteException;
  
  void a(String paramString1, String paramString2, String paramString3, b paramb) throws RemoteException;
  
  public static abstract class a extends Binder implements a {
    public static a a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.unionpay.mobile.android.hce.service.IHCEBankService");
      return (iInterface != null && iInterface instanceof a) ? (a)iInterface : new a(param1IBinder);
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      String str;
      null = true;
      switch (param1Int1) {
        default:
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
        case 1598968902:
          param1Parcel2.writeString("com.unionpay.mobile.android.hce.service.IHCEBankService");
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 1:
          param1Parcel1.enforceInterface("com.unionpay.mobile.android.hce.service.IHCEBankService");
          str = a(param1Parcel1.readString(), param1Parcel1.readString(), b.a.a(param1Parcel1.readStrongBinder()));
          param1Parcel2.writeNoException();
          param1Parcel2.writeString(str);
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 2:
          break;
      } 
      str.enforceInterface("com.unionpay.mobile.android.hce.service.IHCEBankService");
      a(str.readString(), str.readString(), str.readString(), b.a.a(str.readStrongBinder()));
      param1Parcel2.writeNoException();
      return SYNTHETIC_LOCAL_VARIABLE_5;
    }
    
    private static final class a implements a {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public final String a(String param2String1, String param2String2, b param2b) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.mobile.android.hce.service.IHCEBankService");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          if (param2b != null) {
            IBinder iBinder = param2b.asBinder();
            parcel1.writeStrongBinder(iBinder);
            this.a.transact(1, parcel1, parcel2, 0);
            parcel2.readException();
            return parcel2.readString();
          } 
          param2String1 = null;
          parcel1.writeStrongBinder((IBinder)param2String1);
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          param2String1 = parcel2.readString();
          return param2String1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final void a(String param2String1, String param2String2, String param2String3, b param2b) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.mobile.android.hce.service.IHCEBankService");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          parcel1.writeString(param2String3);
          if (param2b != null) {
            IBinder iBinder = param2b.asBinder();
          } else {
            param2String1 = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2String1);
          this.a.transact(2, parcel1, parcel2, 0);
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
  
  private static final class a implements a {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public final String a(String param1String1, String param1String2, b param1b) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.mobile.android.hce.service.IHCEBankService");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        if (param1b != null) {
          IBinder iBinder = param1b.asBinder();
          parcel1.writeStrongBinder(iBinder);
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readString();
        } 
        param1String1 = null;
        parcel1.writeStrongBinder((IBinder)param1String1);
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        param1String1 = parcel2.readString();
        return param1String1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final void a(String param1String1, String param1String2, String param1String3, b param1b) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.mobile.android.hce.service.IHCEBankService");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        parcel1.writeString(param1String3);
        if (param1b != null) {
          IBinder iBinder = param1b.asBinder();
        } else {
          param1String1 = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1String1);
        this.a.transact(2, parcel1, parcel2, 0);
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\hce\service\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */