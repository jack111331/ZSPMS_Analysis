package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityEvent;

@TargetApi(19)
@RequiresApi(19)
class AccessibilityEventCompatKitKat {
  public static int getContentChangeTypes(AccessibilityEvent paramAccessibilityEvent) {
    return paramAccessibilityEvent.getContentChangeTypes();
  }
  
  public static void setContentChangeTypes(AccessibilityEvent paramAccessibilityEvent, int paramInt) {
    paramAccessibilityEvent.setContentChangeTypes(paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\view\accessibility\AccessibilityEventCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */