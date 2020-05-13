package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.KeyEvent;

@TargetApi(11)
@RequiresApi(11)
class KeyEventCompatHoneycomb {
  public static boolean isCtrlPressed(KeyEvent paramKeyEvent) {
    return paramKeyEvent.isCtrlPressed();
  }
  
  public static boolean metaStateHasModifiers(int paramInt1, int paramInt2) {
    return KeyEvent.metaStateHasModifiers(paramInt1, paramInt2);
  }
  
  public static boolean metaStateHasNoModifiers(int paramInt) {
    return KeyEvent.metaStateHasNoModifiers(paramInt);
  }
  
  public static int normalizeMetaState(int paramInt) {
    return KeyEvent.normalizeMetaState(paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\view\KeyEventCompatHoneycomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */