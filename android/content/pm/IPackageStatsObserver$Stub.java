package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class IPackageStatsObserver$Stub extends Binder implements IPackageStatsObserver {
  private static final String DESCRIPTOR = "android.content.pm.IPackageStatsObserver";
  
  static final int TRANSACTION_onGetStatsCompleted = 1;
  
  public IPackageStatsObserver$Stub() {
    attachInterface(this, "android.content.pm.IPackageStatsObserver");
  }
  
  public static IPackageStatsObserver asInterface(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("android.content.pm.IPackageStatsObserver");
    return (iInterface != null && iInterface instanceof IPackageStatsObserver) ? (IPackageStatsObserver)iInterface : new IPackageStatsObserver$Stub$Proxy(paramIBinder);
  }
  
  public IBinder asBinder() {
    return (IBinder)this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
    boolean bool = true;
    if (paramInt1 != 1) {
      if (paramInt1 != 1598968902)
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2); 
      paramParcel2.writeString("android.content.pm.IPackageStatsObserver");
      return bool;
    } 
    paramParcel1.enforceInterface("android.content.pm.IPackageStatsObserver");
    if (paramParcel1.readInt() != 0) {
      PackageStats packageStats = (PackageStats)PackageStats.CREATOR.createFromParcel(paramParcel1);
    } else {
      paramParcel2 = null;
    } 
    if (paramParcel1.readInt() != 0) {
      null = true;
    } else {
      null = false;
    } 
    onGetStatsCompleted((PackageStats)paramParcel2, null);
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\content\pm\IPackageStatsObserver$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */