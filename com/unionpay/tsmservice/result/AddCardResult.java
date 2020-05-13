package com.unionpay.tsmservice.result;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class AddCardResult implements Parcelable {
  public static final Parcelable.Creator<AddCardResult> CREATOR = new AddCardResult$1();
  
  private Bundle mBankCardInfo;
  
  public AddCardResult() {}
  
  public AddCardResult(Parcel paramParcel) {
    this.mBankCardInfo = paramParcel.readBundle();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public Bundle getBankCardInfo() {
    return this.mBankCardInfo;
  }
  
  public void setBankCardInfo(Bundle paramBundle) {
    this.mBankCardInfo = paramBundle;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeBundle(this.mBankCardInfo);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\result\AddCardResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */