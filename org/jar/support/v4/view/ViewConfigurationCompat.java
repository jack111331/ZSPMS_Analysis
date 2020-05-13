package org.jar.support.v4.view;

import android.os.Build;
import android.view.ViewConfiguration;

public final class ViewConfigurationCompat {
  static final ViewConfigurationVersionImpl IMPL;
  
  static {
    if (Build.VERSION.SDK_INT >= 14) {
      IMPL = new IcsViewConfigurationVersionImpl();
    } else if (Build.VERSION.SDK_INT >= 11) {
      IMPL = new HoneycombViewConfigurationVersionImpl();
    } else if (Build.VERSION.SDK_INT >= 8) {
      IMPL = new FroyoViewConfigurationVersionImpl();
    } else {
      IMPL = new BaseViewConfigurationVersionImpl();
    } 
  }
  
  public static int getScaledPagingTouchSlop(ViewConfiguration paramViewConfiguration) {
    return IMPL.getScaledPagingTouchSlop(paramViewConfiguration);
  }
  
  public static boolean hasPermanentMenuKey(ViewConfiguration paramViewConfiguration) {
    return IMPL.hasPermanentMenuKey(paramViewConfiguration);
  }
  
  static class BaseViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
    public int getScaledPagingTouchSlop(ViewConfiguration param1ViewConfiguration) {
      return param1ViewConfiguration.getScaledTouchSlop();
    }
    
    public boolean hasPermanentMenuKey(ViewConfiguration param1ViewConfiguration) {
      return true;
    }
  }
  
  static class FroyoViewConfigurationVersionImpl extends BaseViewConfigurationVersionImpl {
    public int getScaledPagingTouchSlop(ViewConfiguration param1ViewConfiguration) {
      return ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(param1ViewConfiguration);
    }
  }
  
  static class HoneycombViewConfigurationVersionImpl extends FroyoViewConfigurationVersionImpl {
    public boolean hasPermanentMenuKey(ViewConfiguration param1ViewConfiguration) {
      return false;
    }
  }
  
  static class IcsViewConfigurationVersionImpl extends HoneycombViewConfigurationVersionImpl {
    public boolean hasPermanentMenuKey(ViewConfiguration param1ViewConfiguration) {
      return ViewConfigurationCompatICS.hasPermanentMenuKey(param1ViewConfiguration);
    }
  }
  
  static interface ViewConfigurationVersionImpl {
    int getScaledPagingTouchSlop(ViewConfiguration param1ViewConfiguration);
    
    boolean hasPermanentMenuKey(ViewConfiguration param1ViewConfiguration);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\view\ViewConfigurationCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */