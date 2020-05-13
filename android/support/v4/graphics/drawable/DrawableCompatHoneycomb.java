package android.support.v4.graphics.drawable;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;

@TargetApi(11)
@RequiresApi(11)
class DrawableCompatHoneycomb {
  public static void jumpToCurrentState(Drawable paramDrawable) {
    paramDrawable.jumpToCurrentState();
  }
  
  public static Drawable wrapForTinting(Drawable paramDrawable) {
    Drawable drawable = paramDrawable;
    if (!(paramDrawable instanceof TintAwareDrawable))
      drawable = new DrawableWrapperHoneycomb(paramDrawable); 
    return drawable;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\graphics\drawable\DrawableCompatHoneycomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */