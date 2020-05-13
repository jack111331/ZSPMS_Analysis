package com.unionpay.tsmservice.result;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class OnlinePaymentVerifyResult implements Parcelable {
  public static final Parcelable.Creator<OnlinePaymentVerifyResult> CREATOR = new OnlinePaymentVerifyResult$1();
  
  private Bundle mResultData;
  
  public OnlinePaymentVerifyResult() {}
  
  public OnlinePaymentVerifyResult(Parcel paramParcel) {
    this.mResultData = paramParcel.readBundle();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public Bundle getResultData() {
    return this.mResultData;
  }
  
  public void setResultData(Bundle paramBundle) {
    this.mResultData = paramBundle;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeBundle(this.mResultData);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\result\OnlinePaymentVerifyResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */