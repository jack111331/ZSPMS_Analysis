package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityEvent;

@TargetApi(16)
@RequiresApi(16)
class AccessibilityEventCompatJellyBean {
  public static int getAction(AccessibilityEvent paramAccessibilityEvent) {
    return paramAccessibilityEvent.getAction();
  }
  
  public static int getMovementGranularity(AccessibilityEvent paramAccessibilityEvent) {
    return paramAccessibilityEvent.getMovementGranularity();
  }
  
  public static void setAction(AccessibilityEvent paramAccessibilityEvent, int paramInt) {
    paramAccessibilityEvent.setAction(paramInt);
  }
  
  public static void setMovementGranularity(AccessibilityEvent paramAccessibilityEvent, int paramInt) {
    paramAccessibilityEvent.setMovementGranularity(paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\view\accessibility\AccessibilityEventCompatJellyBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */