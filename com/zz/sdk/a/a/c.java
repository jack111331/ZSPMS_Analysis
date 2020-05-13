package com.zz.sdk.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.squareup.picasso.Picasso;
import com.zz.sdk.b.g;
import com.zz.sdk.i.ci;
import java.util.ArrayList;
import java.util.List;

public class c extends BaseAdapter {
  private Context a;
  
  private List b;
  
  public c(Context paramContext, List paramList) {
    this.a = paramContext;
    this.b = paramList;
    if (this.b == null)
      this.b = new ArrayList(); 
  }
  
  public g a(int paramInt) {
    return this.b.get(paramInt);
  }
  
  public int getCount() {
    return this.b.size();
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      paramView = View.inflate(this.a, ci.a(this.a, 2130903131), null);
      d d1 = new d(this, paramView);
      g g1 = a(paramInt);
      d1.a.setText(g1.b);
      d1.b.setText(g1.c);
      Picasso.with(this.a).load(g1.a).resize(128, 128).onlyScaleDown().centerInside().placeholder(ci.a(this.a, 2130837611)).error(ci.a(this.a, 2130837611)).into(d1.c);
      return paramView;
    } 
    d d = (d)paramView.getTag();
    g g = a(paramInt);
    d.a.setText(g.b);
    d.b.setText(g.c);
    Picasso.with(this.a).load(g.a).resize(128, 128).onlyScaleDown().centerInside().placeholder(ci.a(this.a, 2130837611)).error(ci.a(this.a, 2130837611)).into(d.c);
    return paramView;
  }
  
  public void notifyDataSetChanged() {
    super.notifyDataSetChanged();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */