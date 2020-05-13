package com.tencent.mm.opensdk.modelmsg;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class WXImageObject implements WXMediaMessage.IMediaObject {
  private static final int CONTENT_LENGTH_LIMIT = 10485760;
  
  private static final int PATH_LENGTH_LIMIT = 10240;
  
  private static final String TAG = "MicroMsg.SDK.WXImageObject";
  
  public byte[] imageData;
  
  public String imagePath;
  
  public WXImageObject() {}
  
  public WXImageObject(Bitmap paramBitmap) {
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      this();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
      this.imageData = byteArrayOutputStream.toByteArray();
      byteArrayOutputStream.close();
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("WXImageObject <init>, exception:");
      stringBuilder.append(exception.getMessage());
      Log.e("MicroMsg.SDK.WXImageObject", stringBuilder.toString());
      return;
    } 
  }
  
  public WXImageObject(byte[] paramArrayOfbyte) {
    this.imageData = paramArrayOfbyte;
  }
  
  private int getFileSize(String paramString) {
    if (paramString == null || paramString.length() == 0)
      return 0; 
    File file = new File(paramString);
    return !file.exists() ? 0 : (int)file.length();
  }
  
  public boolean checkArgs() {
    if ((this.imageData == null || this.imageData.length == 0) && (this.imagePath == null || this.imagePath.length() == 0)) {
      String str = "checkArgs fail, all arguments are null";
      Log.e("MicroMsg.SDK.WXImageObject", str);
      return false;
    } 
    if (this.imageData != null && this.imageData.length > 10485760) {
      String str = "checkArgs fail, content is too large";
      Log.e("MicroMsg.SDK.WXImageObject", str);
      return false;
    } 
    if (this.imagePath != null && this.imagePath.length() > 10240) {
      String str = "checkArgs fail, path is invalid";
      Log.e("MicroMsg.SDK.WXImageObject", str);
      return false;
    } 
    if (this.imagePath != null && getFileSize(this.imagePath) > 10485760) {
      String str = "checkArgs fail, image content is too large";
      Log.e("MicroMsg.SDK.WXImageObject", str);
      return false;
    } 
    return true;
  }
  
  public void serialize(Bundle paramBundle) {
    paramBundle.putByteArray("_wximageobject_imageData", this.imageData);
    paramBundle.putString("_wximageobject_imagePath", this.imagePath);
  }
  
  public void setImagePath(String paramString) {
    this.imagePath = paramString;
  }
  
  public int type() {
    return 2;
  }
  
  public void unserialize(Bundle paramBundle) {
    this.imageData = paramBundle.getByteArray("_wximageobject_imageData");
    this.imagePath = paramBundle.getString("_wximageobject_imagePath");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\modelmsg\WXImageObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */