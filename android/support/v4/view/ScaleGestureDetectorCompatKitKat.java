package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.ScaleGestureDetector;

@TargetApi(19)
@RequiresApi(19)
class ScaleGestureDetectorCompatKitKat {
  public static boolean isQuickScaleEnabled(Object paramObject) {
    return ((ScaleGestureDetector)paramObject).isQuickScaleEnabled();
  }
  
  public static void setQuickScaleEnabled(Object paramObject, boolean paramBoolean) {
    ((ScaleGestureDetector)paramObject).setQuickScaleEnabled(paramBoolean);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\view\ScaleGestureDetectorCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */