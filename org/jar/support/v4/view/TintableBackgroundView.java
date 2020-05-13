package org.jar.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import org.jar.support.annotation.Nullable;

public interface TintableBackgroundView {
  @Nullable
  ColorStateList getSupportBackgroundTintList();
  
  @Nullable
  PorterDuff.Mode getSupportBackgroundTintMode();
  
  void setSupportBackgroundTintList(@Nullable ColorStateList paramColorStateList);
  
  void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode paramMode);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\view\TintableBackgroundView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */