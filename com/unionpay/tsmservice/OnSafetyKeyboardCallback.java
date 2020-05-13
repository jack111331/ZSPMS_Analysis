package com.unionpay.tsmservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface OnSafetyKeyboardCallback extends IInterface {
  void onEditorChanged(int paramInt) throws RemoteException;
  
  void onHide() throws RemoteException;
  
  void onShow() throws RemoteException;
  
  public static abstract class Stub extends Binder implements OnSafetyKeyboardCallback {
    public Stub() {
      attachInterface(this, "com.unionpay.tsmservice.OnSafetyKeyboardCallback");
    }
    
    public static OnSafetyKeyboardCallback asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
      return (iInterface != null && iInterface instanceof OnSafetyKeyboardCallback) ? (OnSafetyKeyboardCallback)iInterface : new a(param1IBinder);
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
          param1Parcel2.writeString("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 1:
          param1Parcel1.enforceInterface("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
          onShow();
          param1Parcel2.writeNoException();
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 2:
          param1Parcel1.enforceInterface("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
          onHide();
          param1Parcel2.writeNoException();
          return SYNTHETIC_LOCAL_VARIABLE_5;
        case 3:
          break;
      } 
      param1Parcel1.enforceInterface("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
      onEditorChanged(param1Parcel1.readInt());
      param1Parcel2.writeNoException();
      return SYNTHETIC_LOCAL_VARIABLE_5;
    }
    
    private static final class a implements OnSafetyKeyboardCallback {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public final IBinder asBinder() {
        return this.a;
      }
      
      public final void onEditorChanged(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
          parcel1.writeInt(param2Int);
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final void onHide() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final void onShow() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
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
  
  private static final class a implements OnSafetyKeyboardCallback {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public final IBinder asBinder() {
      return this.a;
    }
    
    public final void onEditorChanged(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
        parcel1.writeInt(param1Int);
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final void onHide() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final void onShow() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\OnSafetyKeyboardCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */