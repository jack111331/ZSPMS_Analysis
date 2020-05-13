package android.support.v4.app;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;

public abstract class FragmentContainer {
  @Nullable
  public abstract View onFindViewById(@IdRes int paramInt);
  
  public abstract boolean onHasView();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\app\FragmentContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */