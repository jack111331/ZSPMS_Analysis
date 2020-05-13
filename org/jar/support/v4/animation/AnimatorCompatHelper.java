package org.jar.support.v4.animation;

import android.os.Build;
import android.view.View;

public final class AnimatorCompatHelper {
  private static final AnimatorProvider IMPL;
  
  static {
    if (Build.VERSION.SDK_INT >= 12) {
      IMPL = new HoneycombMr1AnimatorCompatProvider();
    } else {
      IMPL = new DonutAnimatorCompatProvider();
    } 
  }
  
  public static void clearInterpolator(View paramView) {
    IMPL.clearInterpolator(paramView);
  }
  
  public static ValueAnimatorCompat emptyValueAnimator() {
    return IMPL.emptyValueAnimator();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\animation\AnimatorCompatHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */