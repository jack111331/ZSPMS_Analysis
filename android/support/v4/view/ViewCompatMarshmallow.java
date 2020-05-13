package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;

@TargetApi(23)
@RequiresApi(23)
class ViewCompatMarshmallow {
  public static int getScrollIndicators(View paramView) {
    return paramView.getScrollIndicators();
  }
  
  static void offsetLeftAndRight(View paramView, int paramInt) {
    paramView.offsetLeftAndRight(paramInt);
  }
  
  static void offsetTopAndBottom(View paramView, int paramInt) {
    paramView.offsetTopAndBottom(paramInt);
  }
  
  public static void setScrollIndicators(View paramView, int paramInt) {
    paramView.setScrollIndicators(paramInt);
  }
  
  public static void setScrollIndicators(View paramView, int paramInt1, int paramInt2) {
    paramView.setScrollIndicators(paramInt1, paramInt2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\view\ViewCompatMarshmallow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */