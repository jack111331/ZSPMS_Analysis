package com.zz.sdk.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.zz.sdk.b.e;
import com.zz.sdk.i.ci;
import java.util.ArrayList;
import java.util.List;

public class m extends BaseAdapter {
  private Context a;
  
  private List b;
  
  public m(Context paramContext, List paramList) {
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
    if (paramView == null) {
      paramView = View.inflate(this.a, ci.a(this.a, 2130903136), null);
      n n1 = new n(this, paramView);
      e e1 = a(paramInt);
      n1.a.setText(e1.b);
      n1.b.setImageResource(ci.a(this.a, e1.a));
      return paramView;
    } 
    n n = (n)paramView.getTag();
    e e = a(paramInt);
    n.a.setText(e.b);
    n.b.setImageResource(ci.a(this.a, e.a));
    return paramView;
  }
  
  public void notifyDataSetChanged() {
    super.notifyDataSetChanged();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */