package org.jar.support.v4.view;

import android.view.View;
import android.view.ViewGroup;

public class NestedScrollingParentHelper {
  private int mNestedScrollAxes;
  
  private final ViewGroup mViewGroup;
  
  public NestedScrollingParentHelper(ViewGroup paramViewGroup) {
    this.mViewGroup = paramViewGroup;
  }
  
  public int getNestedScrollAxes() {
    return this.mNestedScrollAxes;
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt) {
    this.mNestedScrollAxes = paramInt;
  }
  
  public void onStopNestedScroll(View paramView) {
    this.mNestedScrollAxes = 0;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\view\NestedScrollingParentHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */