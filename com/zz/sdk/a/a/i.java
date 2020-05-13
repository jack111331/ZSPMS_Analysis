package com.zz.sdk.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.squareup.picasso.Picasso;
import com.zz.sdk.b.a.ax;
import com.zz.sdk.i.ci;
import java.util.ArrayList;
import java.util.List;

public class i extends BaseAdapter {
  private Context a;
  
  private List b;
  
  public i(Context paramContext, List paramList) {
    this.a = paramContext;
    this.b = new ArrayList();
    if (paramList != null)
      this.b.addAll(paramList); 
  }
  
  public ax a(int paramInt) {
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
      paramView = View.inflate(this.a, ci.a(this.a, 2130903134), null);
      j j1 = new j(this, paramView);
      ax ax1 = a(paramInt);
      j1.a.setText(ax1.b);
      Picasso.with(this.a).load(ax1.c).into(j1.b);
      return paramView;
    } 
    j j = (j)paramView.getTag();
    ax ax = a(paramInt);
    j.a.setText(ax.b);
    Picasso.with(this.a).load(ax.c).into(j.b);
    return paramView;
  }
  
  public void notifyDataSetChanged() {
    super.notifyDataSetChanged();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */