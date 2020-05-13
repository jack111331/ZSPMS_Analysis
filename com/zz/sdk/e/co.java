package com.zz.sdk.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.zz.sdk.b.k;
import com.zz.sdk.i.cc;

public class co extends BaseAdapter {
  private int a = -1;
  
  private Context b;
  
  private k[] c;
  
  private int d;
  
  public co(Context paramContext, k[] paramArrayOfk) {
    this.b = paramContext;
    this.d = cc.o.a();
    this.c = paramArrayOfk;
  }
  
  protected void a() {
    this.a = 0;
    this.c = null;
  }
  
  protected void a(int paramInt) {
    this.a = paramInt;
    notifyDataSetChanged();
  }
  
  protected void a(k[] paramArrayOfk) {
    this.c = paramArrayOfk;
    notifyDataSetInvalidated();
  }
  
  public k b(int paramInt) {
    return (this.c == null || paramInt < 0 || paramInt >= this.c.length) ? null : this.c[paramInt];
  }
  
  public int getCount() {
    return (this.c == null) ? 0 : this.c.length;
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    cp cp;
    if (!(paramView instanceof cp)) {
      cp = new cp(this, this.b);
      cq cq1 = new cq(this, cp);
      cp.setTag(cq1);
      cq1.a(b(paramInt), paramInt);
      return (View)cp;
    } 
    cq cq = (cq)cp.getTag();
    cq.a(b(paramInt), paramInt);
    return (View)cp;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */