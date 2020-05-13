package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class ImageObject extends BaseMediaObject {
  public static final Parcelable.Creator<ImageObject> CREATOR = new Parcelable.Creator<ImageObject>() {
      public ImageObject createFromParcel(Parcel param1Parcel) {
        return new ImageObject(param1Parcel);
      }
      
      public ImageObject[] newArray(int param1Int) {
        return new ImageObject[param1Int];
      }
    };
  
  private static final int DATA_SIZE = 2097152;
  
  public byte[] imageData;
  
  public String imagePath;
  
  public ImageObject() {}
  
  public ImageObject(Parcel paramParcel) {
    this.imageData = paramParcel.createByteArray();
    this.imagePath = paramParcel.readString();
  }
  
  public boolean checkArgs() {
    if (this.imageData == null && this.imagePath == null) {
      LogUtil.e("Weibo.ImageObject", "imageData and imagePath are null");
      return false;
    } 
    if (this.imageData != null && this.imageData.length > 2097152) {
      LogUtil.e("Weibo.ImageObject", "imageData is too large");
      return false;
    } 
    if (this.imagePath != null && this.imagePath.length() > 512) {
      LogUtil.e("Weibo.ImageObject", "imagePath is too length");
      return false;
    } 
    if (this.imagePath != null) {
      File file = new File(this.imagePath);
      try {
        if (!file.exists() || file.length() == 0L || file.length() > 10485760L) {
          LogUtil.e("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
          return false;
        } 
      } catch (SecurityException securityException) {
        LogUtil.e("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
        return false;
      } 
    } 
    return true;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public int getObjType() {
    return 2;
  }
  
  public final void setImageObject(Bitmap paramBitmap) {
    Bitmap bitmap1 = null;
    Exception exception1 = null;
    Exception exception2 = exception1;
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      exception2 = exception1;
      this();
      try {
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
        this.imageData = byteArrayOutputStream.toByteArray();
      } catch (Exception exception) {
        ByteArrayOutputStream byteArrayOutputStream1 = byteArrayOutputStream;
      } finally {
        paramBitmap = null;
      } 
    } catch (Exception exception3) {
      paramBitmap = bitmap1;
    } finally {}
    Bitmap bitmap2 = paramBitmap;
    exception3.printStackTrace();
    bitmap2 = paramBitmap;
    LogUtil.e("Weibo.ImageObject", "put thumb failed");
    if (paramBitmap != null)
      paramBitmap.close(); 
  }
  
  protected BaseMediaObject toExtraMediaObject(String paramString) {
    return this;
  }
  
  protected String toExtraMediaString() {
    return "";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeByteArray(this.imageData);
    paramParcel.writeString(this.imagePath);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\api\ImageObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */