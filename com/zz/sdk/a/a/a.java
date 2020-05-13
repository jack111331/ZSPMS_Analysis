package com.zz.sdk.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.zz.sdk.b.e;
import com.zz.sdk.i.ci;
import java.util.ArrayList;
import java.util.List;

public class a extends BaseAdapter {
  private Context a;
  
  private List b;
  
  public a(Context paramContext, List paramList) {
    this.a = paramContext;
    this.b = paramList;
    if (this.b == null)
      this.b = new ArrayList(); 
  }
  
  public e a(int paramInt) {
    return this.b.get(paramInt);
  }
  
  public int getCount() {
    return this.b.size();
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    b b;
    if (paramView == null) {
      paramView = View.inflate(this.a, ci.a(this.a, 2130903130), null);
      b = new b(this, paramView);
    } else {
      b = (b)paramView.getTag();
    } 
    e e = a(paramInt);
    b.a.setText(e.b);
    b.b.setImageResource(ci.a(this.a, e.a));
    if (e.d == 0) {
      b.c.setVisibility(8);
      return paramView;
    } 
    if (e.d == 1) {
      b.c.setVisibility(0);
      b.c.setImageResource(ci.a(this.a, 2130837642));
      return paramView;
    } 
    if (e.d == 2) {
      b.c.setVisibility(0);
      b.c.setImageResource(ci.a(this.a, 2130837648));
    } 
    return paramView;
  }
  
  public void notifyDataSetChanged() {
    super.notifyDataSetChanged();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */