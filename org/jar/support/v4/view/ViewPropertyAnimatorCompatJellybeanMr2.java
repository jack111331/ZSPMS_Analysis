package org.jar.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;

class ViewPropertyAnimatorCompatJellybeanMr2 {
  public static Interpolator getInterpolator(View paramView) {
    return (Interpolator)paramView.animate().getInterpolator();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\view\ViewPropertyAnimatorCompatJellybeanMr2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */