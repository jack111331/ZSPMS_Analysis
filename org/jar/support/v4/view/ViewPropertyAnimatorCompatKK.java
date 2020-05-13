package org.jar.support.v4.view;

import android.animation.ValueAnimator;
import android.view.View;

class ViewPropertyAnimatorCompatKK {
  public static void setUpdateListener(final View view, final ViewPropertyAnimatorUpdateListener listener) {
    if (listener != null) {
      ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            listener.onAnimationUpdate(view);
          }
        };
    } else {
      listener = null;
    } 
    view.animate().setUpdateListener((ValueAnimator.AnimatorUpdateListener)listener);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\view\ViewPropertyAnimatorCompatKK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */