package com.unionpay.tsmservice.data;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;

public class NinePatchInfo implements Parcelable {
  public static final Parcelable.Creator<NinePatchInfo> CREATOR = new NinePatchInfo$1();
  
  private Bitmap mBitmap;
  
  private byte[] mChunk;
  
  private Rect mPadding;
  
  public NinePatchInfo() {}
  
  public NinePatchInfo(Parcel paramParcel) {
    this.mBitmap = (Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader());
    this.mPadding = (Rect)paramParcel.readParcelable(Rect.class.getClassLoader());
    int i = paramParcel.readInt();
    if (i > 0) {
      this.mChunk = new byte[i];
      paramParcel.readByteArray(this.mChunk);
      return;
    } 
    this.mChunk = null;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public Bitmap getBitmap() {
    return this.mBitmap;
  }
  
  public byte[] getChunk() {
    return this.mChunk;
  }
  
  public Rect getPadding() {
    return this.mPadding;
  }
  
  public void setBitmap(Bitmap paramBitmap) {
    this.mBitmap = paramBitmap;
  }
  
  public void setChunk(byte[] paramArrayOfbyte) {
    this.mChunk = paramArrayOfbyte;
  }
  
  public void setPadding(Rect paramRect) {
    this.mPadding = paramRect;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeParcelable((Parcelable)this.mBitmap, paramInt);
    paramParcel.writeParcelable((Parcelable)this.mPadding, paramInt);
    if (this.mChunk != null) {
      paramParcel.writeInt(this.mChunk.length);
      paramParcel.writeByteArray(this.mChunk);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\data\NinePatchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */