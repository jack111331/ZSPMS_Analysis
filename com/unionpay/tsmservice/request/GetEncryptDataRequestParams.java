package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

public class GetEncryptDataRequestParams extends RequestParams {
  public static final Parcelable.Creator<GetEncryptDataRequestParams> CREATOR = new GetEncryptDataRequestParams$1();
  
  private String mPan;
  
  private int mType;
  
  public GetEncryptDataRequestParams() {}
  
  public GetEncryptDataRequestParams(Parcel paramParcel) {
    super(paramParcel);
    this.mType = paramParcel.readInt();
    this.mPan = paramParcel.readString();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getPan() {
    return this.mPan;
  }
  
  public int getType() {
    return this.mType;
  }
  
  public void setPan(String paramString) {
    this.mPan = paramString;
  }
  
  public void setType(int paramInt) {
    this.mType = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mType);
    paramParcel.writeString(this.mPan);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\request\GetEncryptDataRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */