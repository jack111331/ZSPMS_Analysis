package org.jar.support.v4.view;

import android.view.MotionEvent;

class MotionEventCompatEclair {
  public static int findPointerIndex(MotionEvent paramMotionEvent, int paramInt) {
    return paramMotionEvent.findPointerIndex(paramInt);
  }
  
  public static int getPointerCount(MotionEvent paramMotionEvent) {
    return paramMotionEvent.getPointerCount();
  }
  
  public static int getPointerId(MotionEvent paramMotionEvent, int paramInt) {
    return paramMotionEvent.getPointerId(paramInt);
  }
  
  public static float getX(MotionEvent paramMotionEvent, int paramInt) {
    return paramMotionEvent.getX(paramInt);
  }
  
  public static float getY(MotionEvent paramMotionEvent, int paramInt) {
    return paramMotionEvent.getY(paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\view\MotionEventCompatEclair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */