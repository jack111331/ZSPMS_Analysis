package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import java.io.File;

public class WXEmojiObject implements WXMediaMessage.IMediaObject {
  private static final int CONTENT_LENGTH_LIMIT = 10485760;
  
  private static final String TAG = "MicroMsg.SDK.WXEmojiObject";
  
  public byte[] emojiData;
  
  public String emojiPath;
  
  public WXEmojiObject() {
    this.emojiData = null;
    this.emojiPath = null;
  }
  
  public WXEmojiObject(String paramString) {
    this.emojiPath = paramString;
  }
  
  public WXEmojiObject(byte[] paramArrayOfbyte) {
    this.emojiData = paramArrayOfbyte;
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
    if ((this.emojiData == null || this.emojiData.length == 0) && (this.emojiPath == null || this.emojiPath.length() == 0)) {
      a.a("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, both arguments is null");
      return null;
    } 
    if (this.emojiData != null && this.emojiData.length > 10485760) {
      a.a("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiData is too large");
      return null;
    } 
    if (this.emojiPath != null && getFileSize(this.emojiPath) > 10485760) {
      a.a("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiSize is too large");
      return null;
    } 
    return true;
  }
  
  public void serialize(Bundle paramBundle) {
    paramBundle.putByteArray("_wxemojiobject_emojiData", this.emojiData);
    paramBundle.putString("_wxemojiobject_emojiPath", this.emojiPath);
  }
  
  public void setEmojiData(byte[] paramArrayOfbyte) {
    this.emojiData = paramArrayOfbyte;
  }
  
  public void setEmojiPath(String paramString) {
    this.emojiPath = paramString;
  }
  
  public int type() {
    return 8;
  }
  
  public void unserialize(Bundle paramBundle) {
    this.emojiData = paramBundle.getByteArray("_wxemojiobject_emojiData");
    this.emojiPath = paramBundle.getString("_wxemojiobject_emojiPath");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\modelmsg\WXEmojiObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */