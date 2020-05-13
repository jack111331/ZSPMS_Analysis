package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;

public class SendApduResult implements Parcelable {
  public static final Parcelable.Creator<SendApduResult> CREATOR = new SendApduResult$1();
  
  private String outHexApdu;
  
  public SendApduResult() {}
  
  public SendApduResult(Parcel paramParcel) {
    this.outHexApdu = paramParcel.readString();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getOutHexApdu() {
    return this.outHexApdu;
  }
  
  public void setOutHexApdu(String paramString) {
    this.outHexApdu = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.outHexApdu);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\result\SendApduResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */