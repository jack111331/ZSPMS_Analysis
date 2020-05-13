package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import java.io.File;

public class WXFileObject implements WXMediaMessage.IMediaObject {
  private static final int CONTENT_LENGTH_LIMIT = 10485760;
  
  private static final String TAG = "MicroMsg.SDK.WXFileObject";
  
  private int contentLengthLimit = 10485760;
  
  public byte[] fileData;
  
  public String filePath;
  
  public WXFileObject() {
    this.fileData = null;
    this.filePath = null;
  }
  
  public WXFileObject(String paramString) {
    this.filePath = paramString;
  }
  
  public WXFileObject(byte[] paramArrayOfbyte) {
    this.fileData = paramArrayOfbyte;
  }
  
  private int getFileSize(String paramString) {
    byte b = 0;
    int i = b;
    if (paramString != null) {
      if (paramString.length() == 0)
        return b; 
    } else {
      return i;
    } 
    File file = new File(paramString);
    i = b;
    if (file.exists())
      i = (int)file.length(); 
    return i;
  }
  
  public boolean checkArgs() {
    null = false;
    if ((this.fileData == null || this.fileData.length == 0) && (this.filePath == null || this.filePath.length() == 0)) {
      a.a("MicroMsg.SDK.WXFileObject", "checkArgs fail, both arguments is null");
      return null;
    } 
    if (this.fileData != null && this.fileData.length > this.contentLengthLimit) {
      a.a("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileData is too large");
      return null;
    } 
    if (this.filePath != null && getFileSize(this.filePath) > this.contentLengthLimit) {
      a.a("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileSize is too large");
      return null;
    } 
    return true;
  }
  
  public void serialize(Bundle paramBundle) {
    paramBundle.putByteArray("_wxfileobject_fileData", this.fileData);
    paramBundle.putString("_wxfileobject_filePath", this.filePath);
  }
  
  public void setContentLengthLimit(int paramInt) {
    this.contentLengthLimit = paramInt;
  }
  
  public void setFileData(byte[] paramArrayOfbyte) {
    this.fileData = paramArrayOfbyte;
  }
  
  public void setFilePath(String paramString) {
    this.filePath = paramString;
  }
  
  public int type() {
    return 6;
  }
  
  public void unserialize(Bundle paramBundle) {
    this.fileData = paramBundle.getByteArray("_wxfileobject_fileData");
    this.filePath = paramBundle.getString("_wxfileobject_filePath");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\modelmsg\WXFileObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */