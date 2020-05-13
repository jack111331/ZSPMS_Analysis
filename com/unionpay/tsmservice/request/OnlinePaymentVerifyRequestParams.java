package com.unionpay.tsmservice.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class OnlinePaymentVerifyRequestParams extends RequestParams {
  public static final Parcelable.Creator<OnlinePaymentVerifyRequestParams> CREATOR = new OnlinePaymentVerifyRequestParams$1();
  
  private String mAId;
  
  private String mOrderNumber;
  
  private Bundle mResource;
  
  public OnlinePaymentVerifyRequestParams() {}
  
  public OnlinePaymentVerifyRequestParams(Parcel paramParcel) {
    super(paramParcel);
    this.mResource = paramParcel.readBundle();
    this.mOrderNumber = paramParcel.readString();
    this.mAId = paramParcel.readString();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getAId() {
    return this.mAId;
  }
  
  public String getOrderNumber() {
    return this.mOrderNumber;
  }
  
  public Bundle getResource() {
    return this.mResource;
  }
  
  public void setAId(String paramString) {
    this.mAId = paramString;
  }
  
  public void setOrderNumber(String paramString) {
    this.mOrderNumber = paramString;
  }
  
  public void setResource(Bundle paramBundle) {
    this.mResource = paramBundle;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeBundle(this.mResource);
    paramParcel.writeString(this.mOrderNumber);
    paramParcel.writeString(this.mAId);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\request\OnlinePaymentVerifyRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */