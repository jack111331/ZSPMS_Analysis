package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;

final class Amount$1 implements Parcelable.Creator<Amount> {
  public final Amount createFromParcel(Parcel paramParcel) {
    return new Amount(paramParcel);
  }
  
  public final Amount[] newArray(int paramInt) {
    return new Amount[paramInt];
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\data\Amount$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */