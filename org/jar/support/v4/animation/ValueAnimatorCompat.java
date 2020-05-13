package org.jar.support.v4.animation;

import android.view.View;

public interface ValueAnimatorCompat {
  void addListener(AnimatorListenerCompat paramAnimatorListenerCompat);
  
  void addUpdateListener(AnimatorUpdateListenerCompat paramAnimatorUpdateListenerCompat);
  
  void cancel();
  
  float getAnimatedFraction();
  
  void setDuration(long paramLong);
  
  void setTarget(View paramView);
  
  void start();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\animation\ValueAnimatorCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */