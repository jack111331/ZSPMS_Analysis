package com.zz.sdk.floatdlg.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.zz.sdk.b.h;
import com.zz.sdk.i.ci;

public class s extends BaseAdapter {
  private Context a;
  
  private h[] b;
  
  private String c;
  
  public s(Context paramContext, h[] paramArrayOfh, String paramString) {
    this.a = paramContext;
    this.b = paramArrayOfh;
    this.c = paramString;
  }
  
  public int getCount() {
    return this.b.length;
  }
  
  public Object getItem(int paramInt) {
    return this.b[paramInt];
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      t t1 = new t(this);
      paramView = LayoutInflater.from(this.a).inflate(ci.a(this.a, 2130903128), null, true);
      t.a(t1, (TextView)paramView.findViewById(ci.a(this.a, 2131296628)));
      t.b(t1, (TextView)paramView.findViewById(ci.a(this.a, 2131296629)));
      paramView.setTag(t1);
      h h2 = this.b[paramInt];
      t.a(t1).setText(h2.f);
      t.b(t1).setText(h2.b);
      return paramView;
    } 
    t t = (t)paramView.getTag();
    h h1 = this.b[paramInt];
    t.a(t).setText(h1.f);
    t.b(t).setText(h1.b);
    return paramView;
  }
  
  public boolean isEnabled(int paramInt) {
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */