package org.jar.support.v4.view;

import android.view.View;
import android.view.ViewParent;

class ViewParentCompatKitKat {
  public static void notifySubtreeAccessibilityStateChanged(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt) {
    paramViewParent.notifySubtreeAccessibilityStateChanged(paramView1, paramView2, paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\view\ViewParentCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */