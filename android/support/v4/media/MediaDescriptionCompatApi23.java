package android.support.v4.media;

import android.annotation.TargetApi;
import android.media.MediaDescription;
import android.net.Uri;
import android.support.annotation.RequiresApi;

@TargetApi(23)
@RequiresApi(23)
class MediaDescriptionCompatApi23 extends MediaDescriptionCompatApi21 {
  public static Uri getMediaUri(Object paramObject) {
    return ((MediaDescription)paramObject).getMediaUri();
  }
  
  static class Builder extends MediaDescriptionCompatApi21.Builder {
    public static void setMediaUri(Object param1Object, Uri param1Uri) {
      ((MediaDescription.Builder)param1Object).setMediaUri(param1Uri);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\media\MediaDescriptionCompatApi23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */