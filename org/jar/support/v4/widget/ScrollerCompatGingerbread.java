package org.jar.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

class ScrollerCompatGingerbread {
  public static void abortAnimation(Object paramObject) {
    ((OverScroller)paramObject).abortAnimation();
  }
  
  public static boolean computeScrollOffset(Object paramObject) {
    return ((OverScroller)paramObject).computeScrollOffset();
  }
  
  public static Object createScroller(Context paramContext, Interpolator paramInterpolator) {
    OverScroller overScroller;
    if (paramInterpolator != null) {
      overScroller = new OverScroller(paramContext, paramInterpolator);
    } else {
      overScroller = new OverScroller((Context)overScroller);
    } 
    return overScroller;
  }
  
  public static void fling(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
    ((OverScroller)paramObject).fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public static void fling(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10) {
    ((OverScroller)paramObject).fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
  }
  
  public static int getCurrX(Object paramObject) {
    return ((OverScroller)paramObject).getCurrX();
  }
  
  public static int getCurrY(Object paramObject) {
    return ((OverScroller)paramObject).getCurrY();
  }
  
  public static int getFinalX(Object paramObject) {
    return ((OverScroller)paramObject).getFinalX();
  }
  
  public static int getFinalY(Object paramObject) {
    return ((OverScroller)paramObject).getFinalY();
  }
  
  public static boolean isFinished(Object paramObject) {
    return ((OverScroller)paramObject).isFinished();
  }
  
  public static boolean isOverScrolled(Object paramObject) {
    return ((OverScroller)paramObject).isOverScrolled();
  }
  
  public static void notifyHorizontalEdgeReached(Object paramObject, int paramInt1, int paramInt2, int paramInt3) {
    ((OverScroller)paramObject).notifyHorizontalEdgeReached(paramInt1, paramInt2, paramInt3);
  }
  
  public static void notifyVerticalEdgeReached(Object paramObject, int paramInt1, int paramInt2, int paramInt3) {
    ((OverScroller)paramObject).notifyVerticalEdgeReached(paramInt1, paramInt2, paramInt3);
  }
  
  public static boolean springBack(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    return ((OverScroller)paramObject).springBack(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public static void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    ((OverScroller)paramObject).startScroll(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    ((OverScroller)paramObject).startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\widget\ScrollerCompatGingerbread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */