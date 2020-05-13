package cn.gov.pbc.tsm.client.mobile.android.bank.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

public interface a extends IInterface {
  String a(String paramString) throws RemoteException;
  
  Map a(String paramString1, String paramString2) throws RemoteException;
  
  boolean a() throws RemoteException;
  
  byte[] a(byte[] paramArrayOfbyte) throws RemoteException;
  
  byte[] a(byte[] paramArrayOfbyte, String paramString) throws RemoteException;
  
  boolean b() throws RemoteException;
  
  boolean b(String paramString) throws RemoteException;
  
  byte[] b(byte[] paramArrayOfbyte) throws RemoteException;
  
  String c() throws RemoteException;
  
  String d() throws RemoteException;
  
  public static abstract class a extends Binder implements a {
    public static a a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
      return (iInterface != null && iInterface instanceof a) ? (a)iInterface : new a(param1IBinder);
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      byte[] arrayOfByte2;
      String str2;
      Map map;
      byte[] arrayOfByte1;
      boolean bool;
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = false;
      null = true;
      switch (param1Int1) {
        default:
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
        case 1598968902:
          param1Parcel2.writeString("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          return SYNTHETIC_LOCAL_VARIABLE_8;
        case 1:
          param1Parcel1.enforceInterface("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          arrayOfByte2 = a(param1Parcel1.createByteArray());
          param1Parcel2.writeNoException();
          param1Parcel2.writeByteArray(arrayOfByte2);
          return SYNTHETIC_LOCAL_VARIABLE_8;
        case 2:
          arrayOfByte2.enforceInterface("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          arrayOfByte2 = b(arrayOfByte2.createByteArray());
          param1Parcel2.writeNoException();
          param1Parcel2.writeByteArray(arrayOfByte2);
          return SYNTHETIC_LOCAL_VARIABLE_8;
        case 3:
          arrayOfByte2.enforceInterface("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          str2 = a(arrayOfByte2.readString());
          param1Parcel2.writeNoException();
          param1Parcel2.writeString(str2);
          return SYNTHETIC_LOCAL_VARIABLE_8;
        case 4:
          str2.enforceInterface("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          bool = a();
          param1Parcel2.writeNoException();
          param1Int1 = bool3;
          if (bool)
            param1Int1 = 1; 
          param1Parcel2.writeInt(param1Int1);
          return SYNTHETIC_LOCAL_VARIABLE_8;
        case 5:
          str2.enforceInterface("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          bool = b();
          param1Parcel2.writeNoException();
          param1Int1 = bool1;
          if (bool)
            param1Int1 = 1; 
          param1Parcel2.writeInt(param1Int1);
          return SYNTHETIC_LOCAL_VARIABLE_8;
        case 6:
          str2.enforceInterface("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          map = a(str2.readString(), str2.readString());
          param1Parcel2.writeNoException();
          param1Parcel2.writeMap(map);
          return SYNTHETIC_LOCAL_VARIABLE_8;
        case 7:
          map.enforceInterface("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          arrayOfByte1 = a(map.createByteArray(), map.readString());
          param1Parcel2.writeNoException();
          param1Parcel2.writeByteArray(arrayOfByte1);
          return SYNTHETIC_LOCAL_VARIABLE_8;
        case 8:
          arrayOfByte1.enforceInterface("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          bool = b(arrayOfByte1.readString());
          param1Parcel2.writeNoException();
          param1Int1 = bool2;
          if (bool)
            param1Int1 = 1; 
          param1Parcel2.writeInt(param1Int1);
          return SYNTHETIC_LOCAL_VARIABLE_8;
        case 9:
          arrayOfByte1.enforceInterface("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          str1 = c();
          param1Parcel2.writeNoException();
          param1Parcel2.writeString(str1);
          return SYNTHETIC_LOCAL_VARIABLE_8;
        case 10:
          break;
      } 
      str1.enforceInterface("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
      String str1 = d();
      param1Parcel2.writeNoException();
      param1Parcel2.writeString(str1);
      return SYNTHETIC_LOCAL_VARIABLE_8;
    }
    
    private static final class a implements a {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public final String a(String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          parcel1.writeString(param2String);
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          param2String = parcel2.readString();
          return param2String;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final Map a(String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          this.a.transact(6, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readHashMap(getClass().getClassLoader());
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final boolean a() throws RemoteException {
        boolean bool = false;
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          this.a.transact(4, parcel1, parcel2, 0);
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
      
      public final byte[] a(byte[] param2ArrayOfbyte) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          parcel1.writeByteArray(param2ArrayOfbyte);
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          param2ArrayOfbyte = parcel2.createByteArray();
          return param2ArrayOfbyte;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final byte[] a(byte[] param2ArrayOfbyte, String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          parcel1.writeByteArray(param2ArrayOfbyte);
          parcel1.writeString(param2String);
          this.a.transact(7, parcel1, parcel2, 0);
          parcel2.readException();
          param2ArrayOfbyte = parcel2.createByteArray();
          return param2ArrayOfbyte;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final IBinder asBinder() {
        return this.a;
      }
      
      public final boolean b() throws RemoteException {
        boolean bool = false;
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          this.a.transact(5, parcel1, parcel2, 0);
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
      
      public final boolean b(String param2String) throws RemoteException {
        boolean bool = false;
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          parcel1.writeString(param2String);
          this.a.transact(8, parcel1, parcel2, 0);
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
      
      public final byte[] b(byte[] param2ArrayOfbyte) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          parcel1.writeByteArray(param2ArrayOfbyte);
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          param2ArrayOfbyte = parcel2.createByteArray();
          return param2ArrayOfbyte;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final String c() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          this.a.transact(9, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readString();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public final String d() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
          this.a.transact(10, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readString();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  private static final class a implements a {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public final String a(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
        parcel1.writeString(param1String);
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        param1String = parcel2.readString();
        return param1String;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final Map a(String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        this.a.transact(6, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readHashMap(getClass().getClassLoader());
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final boolean a() throws RemoteException {
      boolean bool = false;
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
        this.a.transact(4, parcel1, parcel2, 0);
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
    
    public final byte[] a(byte[] param1ArrayOfbyte) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
        parcel1.writeByteArray(param1ArrayOfbyte);
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        param1ArrayOfbyte = parcel2.createByteArray();
        return param1ArrayOfbyte;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final byte[] a(byte[] param1ArrayOfbyte, String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
        parcel1.writeByteArray(param1ArrayOfbyte);
        parcel1.writeString(param1String);
        this.a.transact(7, parcel1, parcel2, 0);
        parcel2.readException();
        param1ArrayOfbyte = parcel2.createByteArray();
        return param1ArrayOfbyte;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final IBinder asBinder() {
      return this.a;
    }
    
    public final boolean b() throws RemoteException {
      boolean bool = false;
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
        this.a.transact(5, parcel1, parcel2, 0);
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
    
    public final boolean b(String param1String) throws RemoteException {
      boolean bool = false;
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
        parcel1.writeString(param1String);
        this.a.transact(8, parcel1, parcel2, 0);
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
    
    public final byte[] b(byte[] param1ArrayOfbyte) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
        parcel1.writeByteArray(param1ArrayOfbyte);
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        param1ArrayOfbyte = parcel2.createByteArray();
        return param1ArrayOfbyte;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final String c() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
        this.a.transact(9, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readString();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public final String d() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
        this.a.transact(10, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readString();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\gov\pbc\tsm\client\mobile\android\bank\service\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */