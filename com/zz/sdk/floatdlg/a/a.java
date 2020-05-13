package com.zz.sdk.floatdlg.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.zz.sdk.b.d;
import com.zz.sdk.i.ci;

public class a extends BaseAdapter {
  private Context a;
  
  private d[] b;
  
  public a(Context paramContext, d[] paramArrayOfd) {
    this.a = paramContext;
    this.b = paramArrayOfd;
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
      b b1 = new b(this);
      paramView = LayoutInflater.from(this.a).inflate(ci.a(this.a, 2130903115), null, true);
      b.a(b1, (TextView)paramView.findViewById(ci.a(this.a, 2131296547)));
      b.b(b1, (TextView)paramView.findViewById(ci.a(this.a, 2131296548)));
      b.c(b1, (TextView)paramView.findViewById(ci.a(this.a, 2131296549)));
      paramView.setTag(b1);
      d d2 = this.b[paramInt];
      b.a(b1).setText(d2.d);
      b.b(b1).setText(d2.f);
      b.c(b1).setText(d2.h);
      return paramView;
    } 
    b b = (b)paramView.getTag();
    d d1 = this.b[paramInt];
    b.a(b).setText(d1.d);
    b.b(b).setText(d1.f);
    b.c(b).setText(d1.h);
    return paramView;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */