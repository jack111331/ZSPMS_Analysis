package com.tencent.mm.sdk.modelmsg;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import java.io.ByteArrayOutputStream;

public final class WXMediaMessage {
  public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
  
  private static final int DESCRIPTION_LENGTH_LIMIT = 1024;
  
  private static final int MEDIA_TAG_NAME_LENGTH_LIMIT = 64;
  
  private static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
  
  private static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
  
  private static final String TAG = "MicroMsg.SDK.WXMediaMessage";
  
  public static final int THUMB_LENGTH_LIMIT = 32768;
  
  private static final int TITLE_LENGTH_LIMIT = 512;
  
  public String description;
  
  public IMediaObject mediaObject;
  
  public String mediaTagName;
  
  public String messageAction;
  
  public String messageExt;
  
  public int sdkVer;
  
  public byte[] thumbData;
  
  public String title;
  
  public WXMediaMessage() {
    this(null);
  }
  
  public WXMediaMessage(IMediaObject paramIMediaObject) {
    this.mediaObject = paramIMediaObject;
  }
  
  final boolean checkArgs() {
    null = false;
    if (getType() == 8 && (this.thumbData == null || this.thumbData.length == 0)) {
      a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, thumbData should not be null when send emoji");
      return null;
    } 
    if (this.thumbData != null && this.thumbData.length > 32768) {
      a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, thumbData is invalid");
      return null;
    } 
    if (this.title != null && this.title.length() > 512) {
      a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, title is invalid");
      return null;
    } 
    if (this.description != null && this.description.length() > 1024) {
      a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, description is invalid");
      return null;
    } 
    if (this.mediaObject == null) {
      a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, mediaObject is null");
      return null;
    } 
    if (this.mediaTagName != null && this.mediaTagName.length() > 64) {
      a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, mediaTagName is too long");
      return null;
    } 
    if (this.messageAction != null && this.messageAction.length() > 2048) {
      a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, messageAction is too long");
      return null;
    } 
    if (this.messageExt != null && this.messageExt.length() > 2048) {
      a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, messageExt is too long");
      return null;
    } 
    return this.mediaObject.checkArgs();
  }
  
  public final int getType() {
    return (this.mediaObject == null) ? 0 : this.mediaObject.type();
  }
  
  public final void setThumbImage(Bitmap paramBitmap) {
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      this();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
      this.thumbData = byteArrayOutputStream.toByteArray();
      byteArrayOutputStream.close();
    } catch (Exception exception) {
      exception.printStackTrace();
      a.a("MicroMsg.SDK.WXMediaMessage", "put thumb failed");
    } 
  }
  
  public static class Builder {
    public static final String KEY_IDENTIFIER = "_wxobject_identifier_";
    
    public static WXMediaMessage fromBundle(Bundle param1Bundle) {
      WXMediaMessage wXMediaMessage = new WXMediaMessage();
      wXMediaMessage.sdkVer = param1Bundle.getInt("_wxobject_sdkVer");
      wXMediaMessage.title = param1Bundle.getString("_wxobject_title");
      wXMediaMessage.description = param1Bundle.getString("_wxobject_description");
      wXMediaMessage.thumbData = param1Bundle.getByteArray("_wxobject_thumbdata");
      wXMediaMessage.mediaTagName = param1Bundle.getString("_wxobject_mediatagname");
      wXMediaMessage.messageAction = param1Bundle.getString("_wxobject_message_action");
      wXMediaMessage.messageExt = param1Bundle.getString("_wxobject_message_ext");
      String str = pathOldToNew(param1Bundle.getString("_wxobject_identifier_"));
      if (str != null && str.length() > 0)
        try {
          wXMediaMessage.mediaObject = (WXMediaMessage.IMediaObject)Class.forName(str).newInstance();
          wXMediaMessage.mediaObject.unserialize(param1Bundle);
        } catch (Exception exception) {
          exception.printStackTrace();
          a.a("MicroMsg.SDK.WXMediaMessage", "get media object from bundle failed: unknown ident " + str + ", ex = " + exception.getMessage());
        }  
      return wXMediaMessage;
    }
    
    private static String pathNewToOld(String param1String) {
      if (param1String == null || param1String.length() == 0) {
        a.a("MicroMsg.SDK.WXMediaMessage", "pathNewToOld fail, newPath is null");
        return param1String;
      } 
      return param1String.replace("com.tencent.mm.sdk.modelmsg", "com.tencent.mm.sdk.openapi");
    }
    
    private static String pathOldToNew(String param1String) {
      if (param1String == null || param1String.length() == 0) {
        a.a("MicroMsg.SDK.WXMediaMessage", "pathOldToNew fail, oldPath is null");
        return param1String;
      } 
      return param1String.replace("com.tencent.mm.sdk.openapi", "com.tencent.mm.sdk.modelmsg");
    }
    
    public static Bundle toBundle(WXMediaMessage param1WXMediaMessage) {
      Bundle bundle = new Bundle();
      bundle.putInt("_wxobject_sdkVer", param1WXMediaMessage.sdkVer);
      bundle.putString("_wxobject_title", param1WXMediaMessage.title);
      bundle.putString("_wxobject_description", param1WXMediaMessage.description);
      bundle.putByteArray("_wxobject_thumbdata", param1WXMediaMessage.thumbData);
      if (param1WXMediaMessage.mediaObject != null) {
        bundle.putString("_wxobject_identifier_", pathNewToOld(param1WXMediaMessage.mediaObject.getClass().getName()));
        param1WXMediaMessage.mediaObject.serialize(bundle);
      } 
      bundle.putString("_wxobject_mediatagname", param1WXMediaMessage.mediaTagName);
      bundle.putString("_wxobject_message_action", param1WXMediaMessage.messageAction);
      bundle.putString("_wxobject_message_ext", param1WXMediaMessage.messageExt);
      return bundle;
    }
  }
  
  public static interface IMediaObject {
    public static final int TYPE_APPDATA = 7;
    
    public static final int TYPE_CARD_SHARE = 16;
    
    public static final int TYPE_DEVICE_ACCESS = 12;
    
    public static final int TYPE_EMOJI = 8;
    
    public static final int TYPE_EMOTICON_GIFT = 11;
    
    public static final int TYPE_EMOTICON_SHARED = 15;
    
    public static final int TYPE_FILE = 6;
    
    public static final int TYPE_IMAGE = 2;
    
    public static final int TYPE_LOCATION_SHARE = 17;
    
    public static final int TYPE_MALL_PRODUCT = 13;
    
    public static final int TYPE_MUSIC = 3;
    
    public static final int TYPE_OLD_TV = 14;
    
    public static final int TYPE_PRODUCT = 10;
    
    public static final int TYPE_RECORD = 19;
    
    public static final int TYPE_TEXT = 1;
    
    public static final int TYPE_TV = 20;
    
    public static final int TYPE_UNKNOWN = 0;
    
    public static final int TYPE_URL = 5;
    
    public static final int TYPE_VIDEO = 4;
    
    boolean checkArgs();
    
    void serialize(Bundle param1Bundle);
    
    int type();
    
    void unserialize(Bundle param1Bundle);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\modelmsg\WXMediaMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */