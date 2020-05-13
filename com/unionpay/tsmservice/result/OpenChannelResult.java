package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;

public class OpenChannelResult implements Parcelable {
  public static final Parcelable.Creator<OpenChannelResult> CREATOR = new OpenChannelResult$1();
  
  private String channel;
  
  private String outHexApdu;
  
  public OpenChannelResult() {}
  
  public OpenChannelResult(Parcel paramParcel) {
    this.outHexApdu = paramParcel.readString();
    this.channel = paramParcel.readString();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getChannel() {
    return this.channel;
  }
  
  public String getOutHexApdu() {
    return this.outHexApdu;
  }
  
  public void setChannel(String paramString) {
    this.channel = paramString;
  }
  
  public void setOutHexApdu(String paramString) {
    this.outHexApdu = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.outHexApdu);
    paramParcel.writeString(this.channel);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\result\OpenChannelResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */