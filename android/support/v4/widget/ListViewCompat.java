package android.support.v4.widget;

import android.os.Build;
import android.support.annotation.NonNull;
import android.widget.ListView;

public final class ListViewCompat {
  public static void scrollListBy(@NonNull ListView paramListView, int paramInt) {
    if (Build.VERSION.SDK_INT >= 19) {
      ListViewCompatKitKat.scrollListBy(paramListView, paramInt);
      return;
    } 
    ListViewCompatGingerbread.scrollListBy(paramListView, paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\widget\ListViewCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */