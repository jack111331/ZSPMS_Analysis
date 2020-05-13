package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@TargetApi(24)
@RequiresApi(24)
class MediaControllerCompatApi24 {
  public static class TransportControls extends MediaControllerCompatApi23.TransportControls {
    public static void prepare(Object param1Object) {
      ((MediaController.TransportControls)param1Object).prepare();
    }
    
    public static void prepareFromMediaId(Object param1Object, String param1String, Bundle param1Bundle) {
      ((MediaController.TransportControls)param1Object).prepareFromMediaId(param1String, param1Bundle);
    }
    
    public static void prepareFromSearch(Object param1Object, String param1String, Bundle param1Bundle) {
      ((MediaController.TransportControls)param1Object).prepareFromSearch(param1String, param1Bundle);
    }
    
    public static void prepareFromUri(Object param1Object, Uri param1Uri, Bundle param1Bundle) {
      ((MediaController.TransportControls)param1Object).prepareFromUri(param1Uri, param1Bundle);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\media\session\MediaControllerCompatApi24.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */