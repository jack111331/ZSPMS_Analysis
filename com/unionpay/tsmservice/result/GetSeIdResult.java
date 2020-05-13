package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;

public class GetSeIdResult implements Parcelable {
  public static final Parcelable.Creator<GetSeIdResult> CREATOR = new GetSeIdResult$1();
  
  private String mSeId;
  
  public GetSeIdResult() {}
  
  public GetSeIdResult(Parcel paramParcel) {
    this.mSeId = paramParcel.readString();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getSeId() {
    return this.mSeId;
  }
  
  public void setSeId(String paramString) {
    this.mSeId = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.mSeId);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\result\GetSeIdResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */