package com.unionpay.tsmservice.result;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class VendorPayStatusResult implements Parcelable {
  public static final Parcelable.Creator<VendorPayStatusResult> CREATOR = new VendorPayStatusResult$1();
  
  private Bundle mStatus;
  
  public VendorPayStatusResult() {}
  
  public VendorPayStatusResult(Parcel paramParcel) {
    this.mStatus = paramParcel.readBundle();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public Bundle getVendorPayStatusResult() {
    return this.mStatus;
  }
  
  public void setVendorPayStatusResult(Bundle paramBundle) {
    this.mStatus = paramBundle;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeBundle(this.mStatus);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\result\VendorPayStatusResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */