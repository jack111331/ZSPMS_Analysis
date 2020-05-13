package org.jar.photo.zoom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import org.jar.support.v4.view.ViewPager;

public class PreviewViewPager extends ViewPager {
  public PreviewViewPager(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
    return (paramView instanceof ImageViewTouch) ? ((((ImageViewTouch)paramView).a(paramInt1) || super.canScroll(paramView, paramBoolean, paramInt1, paramInt2, paramInt3))) : super.canScroll(paramView, paramBoolean, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\zoom\PreviewViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */