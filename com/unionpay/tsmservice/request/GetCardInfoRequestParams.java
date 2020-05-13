package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

public class GetCardInfoRequestParams extends RequestParams implements Parcelable {
  public static final Parcelable.Creator<GetCardInfoRequestParams> CREATOR = new GetCardInfoRequestParams$1();
  
  private String[] mAppAID;
  
  public GetCardInfoRequestParams() {}
  
  public GetCardInfoRequestParams(Parcel paramParcel) {
    super(paramParcel);
    this.mAppAID = paramParcel.createStringArray();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String[] getAppAID() {
    return this.mAppAID;
  }
  
  public void setAppAID(String[] paramArrayOfString) {
    this.mAppAID = paramArrayOfString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeStringArray(this.mAppAID);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\request\GetCardInfoRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */