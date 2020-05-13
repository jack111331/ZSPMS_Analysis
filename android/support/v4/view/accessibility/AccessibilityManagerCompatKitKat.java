package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityManager;

@TargetApi(19)
@RequiresApi(19)
class AccessibilityManagerCompatKitKat {
  public static boolean addTouchExplorationStateChangeListener(AccessibilityManager paramAccessibilityManager, Object paramObject) {
    return paramAccessibilityManager.addTouchExplorationStateChangeListener((AccessibilityManager.TouchExplorationStateChangeListener)paramObject);
  }
  
  public static Object newTouchExplorationStateChangeListener(final TouchExplorationStateChangeListenerBridge bridge) {
    return new AccessibilityManager.TouchExplorationStateChangeListener() {
        public void onTouchExplorationStateChanged(boolean param1Boolean) {
          bridge.onTouchExplorationStateChanged(param1Boolean);
        }
      };
  }
  
  public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager paramAccessibilityManager, Object paramObject) {
    return paramAccessibilityManager.removeTouchExplorationStateChangeListener((AccessibilityManager.TouchExplorationStateChangeListener)paramObject);
  }
  
  static interface TouchExplorationStateChangeListenerBridge {
    void onTouchExplorationStateChanged(boolean param1Boolean);
  }
  
  public static class TouchExplorationStateChangeListenerWrapper implements AccessibilityManager.TouchExplorationStateChangeListener {
    final Object mListener;
    
    final AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerBridge mListenerBridge;
    
    public TouchExplorationStateChangeListenerWrapper(Object param1Object, AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerBridge param1TouchExplorationStateChangeListenerBridge) {
      this.mListener = param1Object;
      this.mListenerBridge = param1TouchExplorationStateChangeListenerBridge;
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
              if (((TouchExplorationStateChangeListenerWrapper)param1Object).mListener != null)
                return bool; 
            } else {
              return this.mListener.equals(((TouchExplorationStateChangeListenerWrapper)param1Object).mListener);
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
    
    public void onTouchExplorationStateChanged(boolean param1Boolean) {
      this.mListenerBridge.onTouchExplorationStateChanged(param1Boolean);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\view\accessibility\AccessibilityManagerCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */