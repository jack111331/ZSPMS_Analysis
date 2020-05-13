package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.data.UpdateInfo;

public class InitResult implements Parcelable {
  public static final Parcelable.Creator<InitResult> CREATOR = new InitResult$1();
  
  private UpdateInfo mUpdateInfo;
  
  public InitResult() {}
  
  public InitResult(Parcel paramParcel) {
    this.mUpdateInfo = (UpdateInfo)paramParcel.readParcelable(UpdateInfo.class.getClassLoader());
  }
  
  public int describeContents() {
    return 0;
  }
  
  public UpdateInfo getUpdateInfo() {
    return this.mUpdateInfo;
  }
  
  public void setUpdateInfo(UpdateInfo paramUpdateInfo) {
    this.mUpdateInfo = paramUpdateInfo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeParcelable((Parcelable)this.mUpdateInfo, paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\result\InitResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */