package org.jar.support.v4.widget;

import android.widget.EdgeEffect;

class EdgeEffectCompatLollipop {
  public static boolean onPull(Object paramObject, float paramFloat1, float paramFloat2) {
    ((EdgeEffect)paramObject).onPull(paramFloat1, paramFloat2);
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\widget\EdgeEffectCompatLollipop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */