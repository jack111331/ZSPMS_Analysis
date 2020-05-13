package com.unionpay.tsmservice.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class HideSafetyKeyboardRequestParams extends RequestParams {
  public static final Parcelable.Creator<HideSafetyKeyboardRequestParams> CREATOR = new HideSafetyKeyboardRequestParams$1();
  
  private Bundle mParams;
  
  public HideSafetyKeyboardRequestParams() {}
  
  public HideSafetyKeyboardRequestParams(Parcel paramParcel) {
    super(paramParcel);
    this.mParams = paramParcel.readBundle();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public Bundle getParams() {
    return this.mParams;
  }
  
  public void setParams(Bundle paramBundle) {
    this.mParams = paramBundle;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeBundle(this.mParams);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\request\HideSafetyKeyboardRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */