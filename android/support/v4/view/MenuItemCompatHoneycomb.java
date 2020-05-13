package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.MenuItem;
import android.view.View;

@TargetApi(11)
@RequiresApi(11)
class MenuItemCompatHoneycomb {
  public static View getActionView(MenuItem paramMenuItem) {
    return paramMenuItem.getActionView();
  }
  
  public static MenuItem setActionView(MenuItem paramMenuItem, int paramInt) {
    return paramMenuItem.setActionView(paramInt);
  }
  
  public static MenuItem setActionView(MenuItem paramMenuItem, View paramView) {
    return paramMenuItem.setActionView(paramView);
  }
  
  public static void setShowAsAction(MenuItem paramMenuItem, int paramInt) {
    paramMenuItem.setShowAsAction(paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\view\MenuItemCompatHoneycomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */