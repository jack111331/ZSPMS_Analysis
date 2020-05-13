package com.zz.sdk.lib.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

public class m extends TextView {
  public m(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public m(Context paramContext, @Nullable AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public m(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  @TargetApi(21)
  public m(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a();
  }
  
  private void a() {
    setEllipsize(TextUtils.TruncateAt.MARQUEE);
    setSingleLine(true);
    setSelected(true);
    setFocusable(true);
    setFocusableInTouchMode(true);
    setMarqueeRepeatLimit(-1);
  }
  
  public boolean isFocused() {
    return true;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect) {
    if (paramBoolean)
      super.onFocusChanged(paramBoolean, paramInt, paramRect); 
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    if (paramBoolean)
      super.onWindowFocusChanged(paramBoolean); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\lib\widget\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */