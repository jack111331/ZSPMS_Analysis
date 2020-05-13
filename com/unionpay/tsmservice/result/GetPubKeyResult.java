package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;

public class GetPubKeyResult implements Parcelable {
  public static final Parcelable.Creator<GetPubKeyResult> CREATOR = new GetPubKeyResult$1();
  
  private String key;
  
  public GetPubKeyResult() {}
  
  public GetPubKeyResult(Parcel paramParcel) {
    this.key = paramParcel.readString();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getKey() {
    return this.key;
  }
  
  public void setKey(String paramString) {
    this.key = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.key);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\result\GetPubKeyResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */