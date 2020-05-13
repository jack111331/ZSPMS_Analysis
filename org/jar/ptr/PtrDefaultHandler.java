package org.jar.ptr;

import android.os.Build;
import android.view.View;
import android.widget.AbsListView;

public abstract class PtrDefaultHandler implements PtrHandler {
  public static boolean canChildScrollUp(View paramView) {
    AbsListView absListView;
    if (Build.VERSION.SDK_INT < 14) {
      boolean bool = paramView instanceof AbsListView;
      boolean bool1 = true;
      boolean bool2 = true;
      if (bool) {
        absListView = (AbsListView)paramView;
        if (absListView.getChildCount() > 0) {
          bool1 = bool2;
          if (absListView.getFirstVisiblePosition() <= 0) {
            if (absListView.getChildAt(0).getTop() < absListView.getPaddingTop())
              return bool2; 
          } else {
            return bool1;
          } 
        } 
        return false;
      } 
      if (absListView.getScrollY() <= 0)
        bool1 = false; 
      return bool1;
    } 
    return absListView.canScrollVertically(-1);
  }
  
  public static boolean checkContentCanBePulledDown(PtrFrameLayout paramPtrFrameLayout, View paramView1, View paramView2) {
    return canChildScrollUp(paramView1) ^ true;
  }
  
  public boolean checkCanDoRefresh(PtrFrameLayout paramPtrFrameLayout, View paramView1, View paramView2) {
    return checkContentCanBePulledDown(paramPtrFrameLayout, paramView1, paramView2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\ptr\PtrDefaultHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */