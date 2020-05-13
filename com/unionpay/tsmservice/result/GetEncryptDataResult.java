package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;

public class GetEncryptDataResult implements Parcelable {
  public static final Parcelable.Creator<GetEncryptDataResult> CREATOR = new GetEncryptDataResult$1();
  
  private String mData;
  
  public GetEncryptDataResult() {}
  
  public GetEncryptDataResult(Parcel paramParcel) {
    this.mData = paramParcel.readString();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getData() {
    return this.mData;
  }
  
  public void setData(String paramString) {
    this.mData = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.mData);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\result\GetEncryptDataResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */