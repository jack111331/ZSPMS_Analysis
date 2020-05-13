package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

public class GetVendorPayStatusRequestParams extends RequestParams {
  public static final Parcelable.Creator<GetVendorPayStatusRequestParams> CREATOR = new GetVendorPayStatusRequestParams$1();
  
  public GetVendorPayStatusRequestParams() {}
  
  public GetVendorPayStatusRequestParams(Parcel paramParcel) {
    super(paramParcel);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\request\GetVendorPayStatusRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */