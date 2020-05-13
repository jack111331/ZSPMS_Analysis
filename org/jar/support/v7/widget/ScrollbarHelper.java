package org.jar.support.v7.widget;

import android.view.View;

class ScrollbarHelper {
  static int computeScrollExtent(RecyclerView.State paramState, OrientationHelper paramOrientationHelper, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean) {
    if (paramLayoutManager.getChildCount() == 0 || paramState.getItemCount() == 0 || paramView1 == null || paramView2 == null)
      return 0; 
    if (!paramBoolean)
      return Math.abs(paramLayoutManager.getPosition(paramView1) - paramLayoutManager.getPosition(paramView2)) + 1; 
    int i = paramOrientationHelper.getDecoratedEnd(paramView2);
    int j = paramOrientationHelper.getDecoratedStart(paramView1);
    return Math.min(paramOrientationHelper.getTotalSpace(), i - j);
  }
  
  static int computeScrollOffset(RecyclerView.State paramState, OrientationHelper paramOrientationHelper, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean1, boolean paramBoolean2) {
    if (paramLayoutManager.getChildCount() == 0 || paramState.getItemCount() == 0 || paramView1 == null || paramView2 == null)
      return 0; 
    int i = Math.min(paramLayoutManager.getPosition(paramView1), paramLayoutManager.getPosition(paramView2));
    int j = Math.max(paramLayoutManager.getPosition(paramView1), paramLayoutManager.getPosition(paramView2));
    if (paramBoolean2) {
      i = Math.max(0, paramState.getItemCount() - j - 1);
    } else {
      i = Math.max(0, i);
    } 
    if (!paramBoolean1)
      return i; 
    int k = Math.abs(paramOrientationHelper.getDecoratedEnd(paramView2) - paramOrientationHelper.getDecoratedStart(paramView1));
    j = Math.abs(paramLayoutManager.getPosition(paramView1) - paramLayoutManager.getPosition(paramView2));
    float f = k / (j + 1);
    return Math.round(i * f + (paramOrientationHelper.getStartAfterPadding() - paramOrientationHelper.getDecoratedStart(paramView1)));
  }
  
  static int computeScrollRange(RecyclerView.State paramState, OrientationHelper paramOrientationHelper, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean) {
    if (paramLayoutManager.getChildCount() == 0 || paramState.getItemCount() == 0 || paramView1 == null || paramView2 == null)
      return 0; 
    if (!paramBoolean)
      return paramState.getItemCount(); 
    int i = paramOrientationHelper.getDecoratedEnd(paramView2);
    int j = paramOrientationHelper.getDecoratedStart(paramView1);
    int k = Math.abs(paramLayoutManager.getPosition(paramView1) - paramLayoutManager.getPosition(paramView2));
    return (int)((i - j) / (k + 1) * paramState.getItemCount());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v7\widget\ScrollbarHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */