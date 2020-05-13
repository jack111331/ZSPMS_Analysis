package org.jar.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;

class ViewCompatBase {
  private static final String TAG = "ViewCompatBase";
  
  private static Field sMinHeightField;
  
  private static boolean sMinHeightFieldFetched;
  
  private static Field sMinWidthField;
  
  private static boolean sMinWidthFieldFetched;
  
  static ColorStateList getBackgroundTintList(View paramView) {
    if (paramView instanceof TintableBackgroundView) {
      ColorStateList colorStateList = ((TintableBackgroundView)paramView).getSupportBackgroundTintList();
    } else {
      paramView = null;
    } 
    return (ColorStateList)paramView;
  }
  
  static PorterDuff.Mode getBackgroundTintMode(View paramView) {
    if (paramView instanceof TintableBackgroundView) {
      PorterDuff.Mode mode = ((TintableBackgroundView)paramView).getSupportBackgroundTintMode();
    } else {
      paramView = null;
    } 
    return (PorterDuff.Mode)paramView;
  }
  
  static int getMinimumHeight(View paramView) {
    if (!sMinHeightFieldFetched) {
      try {
        sMinHeightField = View.class.getDeclaredField("mMinHeight");
        sMinHeightField.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {}
      sMinHeightFieldFetched = true;
    } 
    if (sMinHeightField != null)
      try {
        return ((Integer)sMinHeightField.get(paramView)).intValue();
      } catch (Exception exception) {} 
    return 0;
  }
  
  static int getMinimumWidth(View paramView) {
    if (!sMinWidthFieldFetched) {
      try {
        sMinWidthField = View.class.getDeclaredField("mMinWidth");
        sMinWidthField.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {}
      sMinWidthFieldFetched = true;
    } 
    if (sMinWidthField != null)
      try {
        return ((Integer)sMinWidthField.get(paramView)).intValue();
      } catch (Exception exception) {} 
    return 0;
  }
  
  static boolean isAttachedToWindow(View paramView) {
    boolean bool;
    if (paramView.getWindowToken() != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  static boolean isLaidOut(View paramView) {
    boolean bool;
    if (paramView.getWidth() > 0 && paramView.getHeight() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  static void offsetLeftAndRight(View paramView, int paramInt) {
    int i = paramView.getLeft();
    paramView.offsetLeftAndRight(paramInt);
    if (paramInt != 0) {
      ViewParent viewParent = paramView.getParent();
      if (viewParent instanceof View) {
        paramInt = Math.abs(paramInt);
        ((View)viewParent).invalidate(i - paramInt, paramView.getTop(), i + paramView.getWidth() + paramInt, paramView.getBottom());
      } else {
        paramView.invalidate();
      } 
    } 
  }
  
  static void offsetTopAndBottom(View paramView, int paramInt) {
    int i = paramView.getTop();
    paramView.offsetTopAndBottom(paramInt);
    if (paramInt != 0) {
      ViewParent viewParent = paramView.getParent();
      if (viewParent instanceof View) {
        paramInt = Math.abs(paramInt);
        ((View)viewParent).invalidate(paramView.getLeft(), i - paramInt, paramView.getRight(), i + paramView.getHeight() + paramInt);
      } else {
        paramView.invalidate();
      } 
    } 
  }
  
  static void setBackgroundTintList(View paramView, ColorStateList paramColorStateList) {
    if (paramView instanceof TintableBackgroundView)
      ((TintableBackgroundView)paramView).setSupportBackgroundTintList(paramColorStateList); 
  }
  
  static void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode) {
    if (paramView instanceof TintableBackgroundView)
      ((TintableBackgroundView)paramView).setSupportBackgroundTintMode(paramMode); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\view\ViewCompatBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */