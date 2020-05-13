package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.AppID;

public class GetTransElementsRequestParams extends RequestParams {
  public static final Parcelable.Creator<GetTransElementsRequestParams> CREATOR = new GetTransElementsRequestParams$1();
  
  public static final String TRANS_TYPE_DELETE = "0112";
  
  public static final String TRANS_TYPE_DOWNLOAD_APPLY = "0101";
  
  private AppID mAppID;
  
  private String mTransType;
  
  public GetTransElementsRequestParams() {}
  
  public GetTransElementsRequestParams(Parcel paramParcel) {
    super(paramParcel);
    this.mAppID = (AppID)paramParcel.readParcelable(AppID.class.getClassLoader());
    this.mTransType = paramParcel.readString();
  }
  
  public AppID getAppID() {
    return this.mAppID;
  }
  
  public String getTransType() {
    return this.mTransType;
  }
  
  public void setAppID(AppID paramAppID) {
    this.mAppID = paramAppID;
  }
  
  public void setTransType(String paramString) {
    this.mTransType = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable((Parcelable)this.mAppID, paramInt);
    paramParcel.writeString(this.mTransType);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\request\GetTransElementsRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */