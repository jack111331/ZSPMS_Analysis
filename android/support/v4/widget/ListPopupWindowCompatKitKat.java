package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ListPopupWindow;

@TargetApi(19)
@RequiresApi(19)
class ListPopupWindowCompatKitKat {
  public static View.OnTouchListener createDragToOpenListener(Object paramObject, View paramView) {
    return ((ListPopupWindow)paramObject).createDragToOpenListener(paramView);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\widget\ListPopupWindowCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */