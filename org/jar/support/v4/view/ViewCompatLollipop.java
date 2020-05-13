package org.jar.support.v4.view;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;

@TargetApi(21)
class ViewCompatLollipop {
  private static ThreadLocal<Rect> sThreadLocalRect;
  
  public static WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat) {
    WindowInsetsCompat windowInsetsCompat = paramWindowInsetsCompat;
    if (paramWindowInsetsCompat instanceof WindowInsetsCompatApi21) {
      WindowInsets windowInsets2 = ((WindowInsetsCompatApi21)paramWindowInsetsCompat).unwrap();
      WindowInsets windowInsets1 = paramView.dispatchApplyWindowInsets(windowInsets2);
      windowInsetsCompat = paramWindowInsetsCompat;
      if (windowInsets1 != windowInsets2)
        windowInsetsCompat = new WindowInsetsCompatApi21(windowInsets1); 
    } 
    return windowInsetsCompat;
  }
  
  public static boolean dispatchNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    return paramView.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public static boolean dispatchNestedPreFling(View paramView, float paramFloat1, float paramFloat2) {
    return paramView.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public static boolean dispatchNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2) {
    return paramView.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2);
  }
  
  public static boolean dispatchNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint) {
    return paramView.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
  }
  
  static ColorStateList getBackgroundTintList(View paramView) {
    return paramView.getBackgroundTintList();
  }
  
  static PorterDuff.Mode getBackgroundTintMode(View paramView) {
    return paramView.getBackgroundTintMode();
  }
  
  public static float getElevation(View paramView) {
    return paramView.getElevation();
  }
  
  private static Rect getEmptyTempRect() {
    if (sThreadLocalRect == null)
      sThreadLocalRect = new ThreadLocal<Rect>(); 
    Rect rect1 = sThreadLocalRect.get();
    Rect rect2 = rect1;
    if (rect1 == null) {
      rect2 = new Rect();
      sThreadLocalRect.set(rect2);
    } 
    rect2.setEmpty();
    return rect2;
  }
  
  public static String getTransitionName(View paramView) {
    return paramView.getTransitionName();
  }
  
  public static float getTranslationZ(View paramView) {
    return paramView.getTranslationZ();
  }
  
  public static float getZ(View paramView) {
    return paramView.getZ();
  }
  
  public static boolean hasNestedScrollingParent(View paramView) {
    return paramView.hasNestedScrollingParent();
  }
  
  public static boolean isImportantForAccessibility(View paramView) {
    return paramView.isImportantForAccessibility();
  }
  
  public static boolean isNestedScrollingEnabled(View paramView) {
    return paramView.isNestedScrollingEnabled();
  }
  
  static void offsetLeftAndRight(View paramView, int paramInt) {
    boolean bool;
    Rect rect = getEmptyTempRect();
    ViewParent viewParent = paramView.getParent();
    if (viewParent instanceof View) {
      View view = (View)viewParent;
      rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
      bool = rect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()) ^ true;
    } else {
      bool = false;
    } 
    ViewCompatHC.offsetLeftAndRight(paramView, paramInt);
    if (bool && rect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))
      ((View)viewParent).invalidate(rect); 
  }
  
  static void offsetTopAndBottom(View paramView, int paramInt) {
    boolean bool;
    Rect rect = getEmptyTempRect();
    ViewParent viewParent = paramView.getParent();
    if (viewParent instanceof View) {
      View view = (View)viewParent;
      rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
      bool = rect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()) ^ true;
    } else {
      bool = false;
    } 
    ViewCompatHC.offsetTopAndBottom(paramView, paramInt);
    if (bool && rect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))
      ((View)viewParent).invalidate(rect); 
  }
  
  public static WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat) {
    WindowInsetsCompat windowInsetsCompat = paramWindowInsetsCompat;
    if (paramWindowInsetsCompat instanceof WindowInsetsCompatApi21) {
      WindowInsets windowInsets2 = ((WindowInsetsCompatApi21)paramWindowInsetsCompat).unwrap();
      WindowInsets windowInsets1 = paramView.onApplyWindowInsets(windowInsets2);
      windowInsetsCompat = paramWindowInsetsCompat;
      if (windowInsets1 != windowInsets2)
        windowInsetsCompat = new WindowInsetsCompatApi21(windowInsets1); 
    } 
    return windowInsetsCompat;
  }
  
  public static void requestApplyInsets(View paramView) {
    paramView.requestApplyInsets();
  }
  
  static void setBackgroundTintList(View paramView, ColorStateList paramColorStateList) {
    paramView.setBackgroundTintList(paramColorStateList);
    if (Build.VERSION.SDK_INT == 21) {
      boolean bool;
      Drawable drawable = paramView.getBackground();
      if (paramView.getBackgroundTintList() != null && paramView.getBackgroundTintMode() != null) {
        bool = true;
      } else {
        bool = false;
      } 
      if (drawable != null && bool) {
        if (drawable.isStateful())
          drawable.setState(paramView.getDrawableState()); 
        paramView.setBackground(drawable);
      } 
    } 
  }
  
  static void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode) {
    paramView.setBackgroundTintMode(paramMode);
    if (Build.VERSION.SDK_INT == 21) {
      boolean bool;
      Drawable drawable = paramView.getBackground();
      if (paramView.getBackgroundTintList() != null && paramView.getBackgroundTintMode() != null) {
        bool = true;
      } else {
        bool = false;
      } 
      if (drawable != null && bool) {
        if (drawable.isStateful())
          drawable.setState(paramView.getDrawableState()); 
        paramView.setBackground(drawable);
      } 
    } 
  }
  
  public static void setElevation(View paramView, float paramFloat) {
    paramView.setElevation(paramFloat);
  }
  
  public static void setNestedScrollingEnabled(View paramView, boolean paramBoolean) {
    paramView.setNestedScrollingEnabled(paramBoolean);
  }
  
  public static void setOnApplyWindowInsetsListener(View paramView, final OnApplyWindowInsetsListener listener) {
    if (listener == null) {
      paramView.setOnApplyWindowInsetsListener(null);
    } else {
      paramView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            public WindowInsets onApplyWindowInsets(View param1View, WindowInsets param1WindowInsets) {
              WindowInsetsCompatApi21 windowInsetsCompatApi21 = new WindowInsetsCompatApi21(param1WindowInsets);
              return ((WindowInsetsCompatApi21)listener.onApplyWindowInsets(param1View, windowInsetsCompatApi21)).unwrap();
            }
          });
    } 
  }
  
  public static void setTransitionName(View paramView, String paramString) {
    paramView.setTransitionName(paramString);
  }
  
  public static void setTranslationZ(View paramView, float paramFloat) {
    paramView.setTranslationZ(paramFloat);
  }
  
  public static boolean startNestedScroll(View paramView, int paramInt) {
    return paramView.startNestedScroll(paramInt);
  }
  
  public static void stopNestedScroll(View paramView) {
    paramView.stopNestedScroll();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\view\ViewCompatLollipop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */