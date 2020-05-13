package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

public class InitRequestParams extends RequestParams {
  public static final Parcelable.Creator<InitRequestParams> CREATOR = new InitRequestParams$1();
  
  private String mSignature = "";
  
  public InitRequestParams() {}
  
  public InitRequestParams(Parcel paramParcel) {
    super(paramParcel);
    this.mSignature = paramParcel.readString();
  }
  
  public String getSignature() {
    return this.mSignature;
  }
  
  public void setSignature(String paramString) {
    this.mSignature = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mSignature);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\request\InitRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */