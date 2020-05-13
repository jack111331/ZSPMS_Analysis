package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

public class SendApduRequestParams extends RequestParams {
  public static final Parcelable.Creator<SendApduRequestParams> CREATOR = new SendApduRequestParams$1();
  
  private String channel;
  
  private String hexApdu;
  
  public SendApduRequestParams() {}
  
  public SendApduRequestParams(Parcel paramParcel) {
    super(paramParcel);
    this.channel = paramParcel.readString();
    this.hexApdu = paramParcel.readString();
  }
  
  public String getChannel() {
    return this.channel;
  }
  
  public String getHexApdu() {
    return this.hexApdu;
  }
  
  public void setChannel(String paramString) {
    this.channel = paramString;
  }
  
  public void setHexApdu(String paramString) {
    this.hexApdu = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.channel);
    paramParcel.writeString(this.hexApdu);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\request\SendApduRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */