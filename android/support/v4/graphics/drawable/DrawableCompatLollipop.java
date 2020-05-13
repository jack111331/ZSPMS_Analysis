package android.support.v4.graphics.drawable;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(21)
@RequiresApi(21)
class DrawableCompatLollipop {
  public static void applyTheme(Drawable paramDrawable, Resources.Theme paramTheme) {
    paramDrawable.applyTheme(paramTheme);
  }
  
  public static boolean canApplyTheme(Drawable paramDrawable) {
    return paramDrawable.canApplyTheme();
  }
  
  public static void clearColorFilter(Drawable paramDrawable) {
    paramDrawable.clearColorFilter();
    if (paramDrawable instanceof InsetDrawable) {
      clearColorFilter(((InsetDrawable)paramDrawable).getDrawable());
      return;
    } 
    if (paramDrawable instanceof DrawableWrapper) {
      clearColorFilter(((DrawableWrapper)paramDrawable).getWrappedDrawable());
      return;
    } 
    if (paramDrawable instanceof DrawableContainer) {
      DrawableContainer.DrawableContainerState drawableContainerState = (DrawableContainer.DrawableContainerState)((DrawableContainer)paramDrawable).getConstantState();
      if (drawableContainerState != null) {
        byte b = 0;
        int i = drawableContainerState.getChildCount();
        while (true) {
          if (b < i) {
            Drawable drawable = drawableContainerState.getChild(b);
            if (drawable != null)
              clearColorFilter(drawable); 
            b++;
            continue;
          } 
          return;
        } 
      } 
    } 
  }
  
  public static ColorFilter getColorFilter(Drawable paramDrawable) {
    return paramDrawable.getColorFilter();
  }
  
  public static void inflate(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
  }
  
  public static void setHotspot(Drawable paramDrawable, float paramFloat1, float paramFloat2) {
    paramDrawable.setHotspot(paramFloat1, paramFloat2);
  }
  
  public static void setHotspotBounds(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setTint(Drawable paramDrawable, int paramInt) {
    paramDrawable.setTint(paramInt);
  }
  
  public static void setTintList(Drawable paramDrawable, ColorStateList paramColorStateList) {
    paramDrawable.setTintList(paramColorStateList);
  }
  
  public static void setTintMode(Drawable paramDrawable, PorterDuff.Mode paramMode) {
    paramDrawable.setTintMode(paramMode);
  }
  
  public static Drawable wrapForTinting(Drawable paramDrawable) {
    Drawable drawable = paramDrawable;
    if (!(paramDrawable instanceof TintAwareDrawable))
      drawable = new DrawableWrapperLollipop(paramDrawable); 
    return drawable;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\graphics\drawable\DrawableCompatLollipop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */