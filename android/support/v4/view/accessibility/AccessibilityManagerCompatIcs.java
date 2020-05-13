package android.support.v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

@TargetApi(14)
@RequiresApi(14)
class AccessibilityManagerCompatIcs {
  public static boolean addAccessibilityStateChangeListener(AccessibilityManager paramAccessibilityManager, AccessibilityStateChangeListenerWrapper paramAccessibilityStateChangeListenerWrapper) {
    return paramAccessibilityManager.addAccessibilityStateChangeListener(paramAccessibilityStateChangeListenerWrapper);
  }
  
  public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager paramAccessibilityManager, int paramInt) {
    return paramAccessibilityManager.getEnabledAccessibilityServiceList(paramInt);
  }
  
  public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager paramAccessibilityManager) {
    return paramAccessibilityManager.getInstalledAccessibilityServiceList();
  }
  
  public static boolean isTouchExplorationEnabled(AccessibilityManager paramAccessibilityManager) {
    return paramAccessibilityManager.isTouchExplorationEnabled();
  }
  
  public static boolean removeAccessibilityStateChangeListener(AccessibilityManager paramAccessibilityManager, AccessibilityStateChangeListenerWrapper paramAccessibilityStateChangeListenerWrapper) {
    return paramAccessibilityManager.removeAccessibilityStateChangeListener(paramAccessibilityStateChangeListenerWrapper);
  }
  
  static interface AccessibilityStateChangeListenerBridge {
    void onAccessibilityStateChanged(boolean param1Boolean);
  }
  
  public static class AccessibilityStateChangeListenerWrapper implements AccessibilityManager.AccessibilityStateChangeListener {
    Object mListener;
    
    AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerBridge mListenerBridge;
    
    public AccessibilityStateChangeListenerWrapper(Object param1Object, AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerBridge param1AccessibilityStateChangeListenerBridge) {
      this.mListener = param1Object;
      this.mListenerBridge = param1AccessibilityStateChangeListenerBridge;
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = false;
      if (this != param1Object) {
        boolean bool1 = bool;
        if (param1Object != null) {
          bool1 = bool;
          if (getClass() == param1Object.getClass()) {
            param1Object = param1Object;
            if (this.mListener == null) {
              if (((AccessibilityStateChangeListenerWrapper)param1Object).mListener != null)
                return bool; 
            } else {
              return this.mListener.equals(((AccessibilityStateChangeListenerWrapper)param1Object).mListener);
            } 
          } else {
            return bool1;
          } 
        } else {
          return bool1;
        } 
      } 
      return true;
    }
    
    public int hashCode() {
      return (this.mListener == null) ? 0 : this.mListener.hashCode();
    }
    
    public void onAccessibilityStateChanged(boolean param1Boolean) {
      this.mListenerBridge.onAccessibilityStateChanged(param1Boolean);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\view\accessibility\AccessibilityManagerCompatIcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */