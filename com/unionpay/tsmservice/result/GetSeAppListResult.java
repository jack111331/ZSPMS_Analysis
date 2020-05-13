package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.data.SeAppListItem;

public class GetSeAppListResult implements Parcelable {
  public static final Parcelable.Creator<GetSeAppListResult> CREATOR = new GetSeAppListResult$1();
  
  private String mSeAliasType = "";
  
  private SeAppListItem[] mSeAppList;
  
  public GetSeAppListResult() {}
  
  public GetSeAppListResult(Parcel paramParcel) {
    this.mSeAppList = (SeAppListItem[])paramParcel.createTypedArray(SeAppListItem.CREATOR);
    this.mSeAliasType = paramParcel.readString();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getSeAliasType() {
    return this.mSeAliasType;
  }
  
  public SeAppListItem[] getSeAppList() {
    return this.mSeAppList;
  }
  
  public void setSeAliasType(String paramString) {
    this.mSeAliasType = paramString;
  }
  
  public void setSeAppList(SeAppListItem[] paramArrayOfSeAppListItem) {
    this.mSeAppList = paramArrayOfSeAppListItem;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeTypedArray((Parcelable[])this.mSeAppList, paramInt);
    paramParcel.writeString(this.mSeAliasType);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\result\GetSeAppListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */