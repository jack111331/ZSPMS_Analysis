package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class EncryptDataRequestParams extends RequestParams {
  public static final Parcelable.Creator<EncryptDataRequestParams> CREATOR = new EncryptDataRequestParams$1();
  
  private List<String> mData;
  
  public EncryptDataRequestParams() {}
  
  public EncryptDataRequestParams(Parcel paramParcel) {
    super(paramParcel);
    this.mData = new ArrayList<String>();
    paramParcel.readList(this.mData, ClassLoader.getSystemClassLoader());
  }
  
  public List<String> getData() {
    return this.mData;
  }
  
  public void setData(List<String> paramList) {
    this.mData = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeList(this.mData);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\request\EncryptDataRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */