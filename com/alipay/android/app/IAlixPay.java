package com.alipay.android.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IAlixPay extends IInterface {
  String Pay(String paramString) throws RemoteException;
  
  String prePay(String paramString) throws RemoteException;
  
  void registerCallback(IRemoteServiceCallback paramIRemoteServiceCallback) throws RemoteException;
  
  String test() throws RemoteException;
  
  void unregisterCallback(IRemoteServiceCallback paramIRemoteServiceCallback) throws RemoteException;
  
  public static abstract class Stub extends Binder implements IAlixPay {
    private static final String DESCRIPTOR = "com.alipay.android.app.IAlixPay";
    
    static final int TRANSACTION_Pay = 1;
    
    static final int TRANSACTION_prePay = 5;
    
    static final int TRANSACTION_registerCallback = 3;
    
    static final int TRANSACTION_test = 2;
    
    static final int TRANSACTION_unregisterCallback = 4;
    
    public Stub() {
      attachInterface(this, "com.alipay.android.app.IAlixPay");
    }
    
    public static IAlixPay asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.alipay.android.app.IAlixPay");
      return (iInterface != null && iInterface instanceof IAlixPay) ? (IAlixPay)iInterface : new a(param1IBinder);
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
          param1Parcel2.writeString("com.alipay.android.app.IAlixPay");
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 1:
          param1Parcel1.enforceInterface("com.alipay.android.app.IAlixPay");
          str = Pay(param1Parcel1.readString());
          param1Parcel2.writeNoException();
          param1Parcel2.writeString(str);
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 2:
          str.enforceInterface("com.alipay.android.app.IAlixPay");
          str = test();
          param1Parcel2.writeNoException();
          param1Parcel2.writeString(str);
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 3:
          str.enforceInterface("com.alipay.android.app.IAlixPay");
          registerCallback(IRemoteServiceCallback.Stub.asInterface(str.readStrongBinder()));
          param1Parcel2.writeNoException();
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 4:
          str.enforceInterface("com.alipay.android.app.IAlixPay");
          unregisterCallback(IRemoteServiceCallback.Stub.asInterface(str.readStrongBinder()));
          param1Parcel2.writeNoException();
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 5:
          break;
      } 
      str.enforceInterface("com.alipay.android.app.IAlixPay");
      String str = prePay(str.readString());
      param1Parcel2.writeNoException();
      param1Parcel2.writeString(str);
      return SYNTHETIC_LOCAL_VARIABLE_5;
    }
    
    private static final class a implements IAlixPay {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      private static String a() {
        return "com.alipay.android.app.IAlixPay";
      }
      
      public final String Pay(String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
          parcel1.writeString(param2String);
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          param2String = parcel2.readString();
          return param2String;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final IBinder asBinder() {
        return this.a;
      }
      
      public final String prePay(String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
          parcel1.writeString(param2String);
          this.a.transact(5, parcel1, parcel2, 0);
          parcel2.readException();
          param2String = parcel2.readString();
          return param2String;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final void registerCallback(IRemoteServiceCallback param2IRemoteServiceCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
          if (param2IRemoteServiceCallback != null) {
            IBinder iBinder = param2IRemoteServiceCallback.asBinder();
          } else {
            param2IRemoteServiceCallback = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2IRemoteServiceCallback);
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final String test() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readString();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final void unregisterCallback(IRemoteServiceCallback param2IRemoteServiceCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
          if (param2IRemoteServiceCallback != null) {
            IBinder iBinder = param2IRemoteServiceCallback.asBinder();
          } else {
            param2IRemoteServiceCallback = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2IRemoteServiceCallback);
          this.a.transact(4, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  private static final class a implements IAlixPay {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    private static String a() {
      return "com.alipay.android.app.IAlixPay";
    }
    
    public final String Pay(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        parcel1.writeString(param1String);
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        param1String = parcel2.readString();
        return param1String;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final IBinder asBinder() {
      return this.a;
    }
    
    public final String prePay(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        parcel1.writeString(param1String);
        this.a.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        param1String = parcel2.readString();
        return param1String;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final void registerCallback(IRemoteServiceCallback param1IRemoteServiceCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        if (param1IRemoteServiceCallback != null) {
          IBinder iBinder = param1IRemoteServiceCallback.asBinder();
        } else {
          param1IRemoteServiceCallback = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1IRemoteServiceCallback);
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final String test() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readString();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final void unregisterCallback(IRemoteServiceCallback param1IRemoteServiceCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        if (param1IRemoteServiceCallback != null) {
          IBinder iBinder = param1IRemoteServiceCallback.asBinder();
        } else {
          param1IRemoteServiceCallback = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1IRemoteServiceCallback);
        this.a.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\android\app\IAlixPay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */