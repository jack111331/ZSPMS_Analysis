package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

final class SendApduRequestParams$1 implements Parcelable.Creator<SendApduRequestParams> {
  public final SendApduRequestParams createFromParcel(Parcel paramParcel) {
    return new SendApduRequestParams(paramParcel);
  }
  
  public final SendApduRequestParams[] newArray(int paramInt) {
    return new SendApduRequestParams[paramInt];
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\request\SendApduRequestParams$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */