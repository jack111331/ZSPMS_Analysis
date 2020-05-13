package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;

public class SeAppListItem implements Parcelable {
  public static final Parcelable.Creator<SeAppListItem> CREATOR = new SeAppListItem$1();
  
  private AppDetail mAppDetail;
  
  public SeAppListItem() {}
  
  public SeAppListItem(Parcel paramParcel) {
    this.mAppDetail = (AppDetail)paramParcel.readParcelable(AppDetail.class.getClassLoader());
  }
  
  public int describeContents() {
    return 0;
  }
  
  public AppDetail getAppDetail() {
    return this.mAppDetail;
  }
  
  public void setAppDetail(AppDetail paramAppDetail) {
    this.mAppDetail = paramAppDetail;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeParcelable(this.mAppDetail, paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\data\SeAppListItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */