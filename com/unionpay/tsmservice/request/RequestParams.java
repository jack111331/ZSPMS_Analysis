package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

public class RequestParams implements Parcelable {
  public static final Parcelable.Creator<RequestParams> CREATOR = new RequestParams$1();
  
  private String mReserve = "";
  
  public RequestParams() {}
  
  public RequestParams(Parcel paramParcel) {
    this.mReserve = paramParcel.readString();
  }
  
  public RequestParams(String paramString) {
    this.mReserve = paramString;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getReserve() {
    return this.mReserve;
  }
  
  public void setReserve(String paramString) {
    this.mReserve = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.mReserve);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\request\RequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */