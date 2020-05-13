package org.jar.support.v4.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

@TargetApi(14)
class EdgeEffectCompatIcs {
  public static boolean draw(Object paramObject, Canvas paramCanvas) {
    return ((EdgeEffect)paramObject).draw(paramCanvas);
  }
  
  public static void finish(Object paramObject) {
    ((EdgeEffect)paramObject).finish();
  }
  
  public static boolean isFinished(Object paramObject) {
    return ((EdgeEffect)paramObject).isFinished();
  }
  
  public static Object newEdgeEffect(Context paramContext) {
    return new EdgeEffect(paramContext);
  }
  
  public static boolean onAbsorb(Object paramObject, int paramInt) {
    ((EdgeEffect)paramObject).onAbsorb(paramInt);
    return true;
  }
  
  public static boolean onPull(Object paramObject, float paramFloat) {
    ((EdgeEffect)paramObject).onPull(paramFloat);
    return true;
  }
  
  public static boolean onRelease(Object paramObject) {
    paramObject = paramObject;
    paramObject.onRelease();
    return paramObject.isFinished();
  }
  
  public static void setSize(Object paramObject, int paramInt1, int paramInt2) {
    ((EdgeEffect)paramObject).setSize(paramInt1, paramInt2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\widget\EdgeEffectCompatIcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */