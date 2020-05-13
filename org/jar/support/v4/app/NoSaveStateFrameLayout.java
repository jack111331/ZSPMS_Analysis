package org.jar.support.v4.app;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

class NoSaveStateFrameLayout extends FrameLayout {
  public NoSaveStateFrameLayout(Context paramContext) {
    super(paramContext);
  }
  
  static ViewGroup wrap(View paramView) {
    NoSaveStateFrameLayout noSaveStateFrameLayout = new NoSaveStateFrameLayout(paramView.getContext());
    ViewGroup.LayoutParams layoutParams = paramView.getLayoutParams();
    if (layoutParams != null)
      noSaveStateFrameLayout.setLayoutParams(layoutParams); 
    paramView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    noSaveStateFrameLayout.addView(paramView);
    return (ViewGroup)noSaveStateFrameLayout;
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray) {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray) {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\app\NoSaveStateFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */