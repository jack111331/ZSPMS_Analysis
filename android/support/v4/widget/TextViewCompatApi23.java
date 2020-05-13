package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.widget.TextView;

@TargetApi(23)
@RequiresApi(23)
class TextViewCompatApi23 {
  public static void setTextAppearance(@NonNull TextView paramTextView, @StyleRes int paramInt) {
    paramTextView.setTextAppearance(paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\widget\TextViewCompatApi23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */