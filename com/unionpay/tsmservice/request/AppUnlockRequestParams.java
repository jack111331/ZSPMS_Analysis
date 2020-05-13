package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.AppID;

public class AppUnlockRequestParams extends RequestParams {
  public static final Parcelable.Creator<AppUnlockRequestParams> CREATOR = new AppUnlockRequestParams$1();
  
  private AppID mAppID;
  
  public AppUnlockRequestParams() {}
  
  public AppUnlockRequestParams(Parcel paramParcel) {
    super(paramParcel);
    this.mAppID = (AppID)paramParcel.readParcelable(AppID.class.getClassLoader());
  }
  
  public AppID getAppID() {
    return this.mAppID;
  }
  
  public void setAppID(AppID paramAppID) {
    this.mAppID = paramAppID;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable((Parcelable)this.mAppID, paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\request\AppUnlockRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */