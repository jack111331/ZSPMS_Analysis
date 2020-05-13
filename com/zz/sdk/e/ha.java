package com.zz.sdk.e;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class ha extends PagerAdapter {
  Context a;
  
  private List b;
  
  public ha(List paramList) {
    this.b = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
    paramViewGroup.removeView(this.b.get(paramInt));
  }
  
  public int getCount() {
    return this.b.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
    paramViewGroup.addView(this.b.get(paramInt), 0);
    return this.b.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject) {
    return (paramView == paramObject);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */