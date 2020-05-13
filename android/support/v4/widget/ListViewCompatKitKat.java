package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.widget.ListView;

@TargetApi(19)
@RequiresApi(19)
class ListViewCompatKitKat {
  static void scrollListBy(ListView paramListView, int paramInt) {
    paramListView.scrollListBy(paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\widget\ListViewCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */