package android.support.v4.view;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.support.annotation.RequiresApi;
import android.view.View;

@TargetApi(18)
@RequiresApi(18)
class ViewCompatJellybeanMr2 {
  public static Rect getClipBounds(View paramView) {
    return paramView.getClipBounds();
  }
  
  public static boolean isInLayout(View paramView) {
    return paramView.isInLayout();
  }
  
  public static void setClipBounds(View paramView, Rect paramRect) {
    paramView.setClipBounds(paramRect);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\view\ViewCompatJellybeanMr2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */