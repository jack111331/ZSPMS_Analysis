package android.support.v4.widget;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.widget.CompoundButton;

@TargetApi(23)
@RequiresApi(23)
class CompoundButtonCompatApi23 {
  static Drawable getButtonDrawable(CompoundButton paramCompoundButton) {
    return paramCompoundButton.getButtonDrawable();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\widget\CompoundButtonCompatApi23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */