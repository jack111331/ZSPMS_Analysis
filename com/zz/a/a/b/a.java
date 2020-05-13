package com.zz.a.a.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.zz.a.a.c.ab;

public class a extends ImageView {
  public a(Context paramContext) {
    super(paramContext);
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private static void a(Drawable paramDrawable, boolean paramBoolean) {
    if (paramDrawable instanceof ab) {
      ((ab)paramDrawable).a(paramBoolean);
      return;
    } 
    if (paramDrawable instanceof LayerDrawable) {
      LayerDrawable layerDrawable = (LayerDrawable)paramDrawable;
      byte b = 0;
      int i = layerDrawable.getNumberOfLayers();
      while (true) {
        if (b < i) {
          a(layerDrawable.getDrawable(b), paramBoolean);
          b++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  protected void onDetachedFromWindow() {
    setImageDrawable(null);
    super.onDetachedFromWindow();
  }
  
  public void setImageDrawable(Drawable paramDrawable) {
    Drawable drawable = getDrawable();
    super.setImageDrawable(paramDrawable);
    a(paramDrawable, true);
    a(drawable, false);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */