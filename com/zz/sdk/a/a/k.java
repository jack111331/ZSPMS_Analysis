package com.zz.sdk.a.a;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.zz.sdk.i.ci;
import java.util.ArrayList;
import java.util.List;

public class k extends BaseAdapter {
  private Context a;
  
  private List b;
  
  public k(Context paramContext, List paramList) {
    this.a = paramContext;
    this.b = paramList;
    if (this.b == null)
      this.b = new ArrayList(); 
  }
  
  public String a(int paramInt) {
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
      paramView = View.inflate(this.a, ci.a(this.a, 2130903135), null);
      l l1 = new l(this, paramView);
      String str1 = a(paramInt);
      l1.a.setText((CharSequence)Html.fromHtml(str1));
      return paramView;
    } 
    l l = (l)paramView.getTag();
    String str = a(paramInt);
    l.a.setText((CharSequence)Html.fromHtml(str));
    return paramView;
  }
  
  public void notifyDataSetChanged() {
    super.notifyDataSetChanged();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */