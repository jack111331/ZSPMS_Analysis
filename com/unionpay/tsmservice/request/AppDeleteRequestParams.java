package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.AppID;
import java.util.HashMap;
import java.util.Map;

public class AppDeleteRequestParams extends RequestParams {
  public static final Parcelable.Creator<AppDeleteRequestParams> CREATOR = new AppDeleteRequestParams$1();
  
  private AppID mAppID;
  
  private HashMap<String, String> mParams;
  
  public AppDeleteRequestParams() {}
  
  public AppDeleteRequestParams(Parcel paramParcel) {
    super(paramParcel);
    this.mAppID = (AppID)paramParcel.readParcelable(AppID.class.getClassLoader());
    this.mParams = paramParcel.readHashMap(HashMap.class.getClassLoader());
  }
  
  public AppID getAppID() {
    return this.mAppID;
  }
  
  public Map<String, String> getParams() {
    return this.mParams;
  }
  
  public void setAppID(AppID paramAppID) {
    this.mAppID = paramAppID;
  }
  
  public void setParams(HashMap<String, String> paramHashMap) {
    this.mParams = paramHashMap;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable((Parcelable)this.mAppID, paramInt);
    paramParcel.writeMap(this.mParams);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\request\AppDeleteRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */