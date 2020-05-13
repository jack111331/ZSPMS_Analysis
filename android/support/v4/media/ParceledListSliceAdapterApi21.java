package android.support.v4.media;

import android.annotation.TargetApi;
import android.media.browse.MediaBrowser;
import android.support.annotation.RequiresApi;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@TargetApi(21)
@RequiresApi(21)
class ParceledListSliceAdapterApi21 {
  private static Constructor sConstructor;
  
  static {
    try {
      sConstructor = Class.forName("android.content.pm.ParceledListSlice").getConstructor(new Class[] { List.class });
      return;
    } catch (ClassNotFoundException classNotFoundException) {
    
    } catch (NoSuchMethodException noSuchMethodException) {}
    noSuchMethodException.printStackTrace();
  }
  
  static Object newInstance(List<MediaBrowser.MediaItem> paramList) {
    try {
      return sConstructor.newInstance(new Object[] { paramList });
    } catch (InstantiationException instantiationException) {
    
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (InvocationTargetException null) {}
    null.printStackTrace();
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\media\ParceledListSliceAdapterApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */