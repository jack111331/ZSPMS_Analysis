package com.zz.sdk.floatdlg.a;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.zz.sdk.b.h;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cv;

public class p extends BaseAdapter {
  private Context a;
  
  private h[] b;
  
  public p(Context paramContext, h[] paramArrayOfh) {
    this.a = paramContext;
    this.b = paramArrayOfh;
  }
  
  private void a(h paramh) {
    try {
      ((ClipboardManager)this.a.getSystemService("clipboard")).setText(paramh.v);
      cv.r(this.a.getString(ci.a(this.a, 2131165468)));
    } catch (Exception exception) {}
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
    View view;
    r r;
    if (paramView == null) {
      r = new r(this);
      view = LayoutInflater.from(this.a).inflate(ci.a(this.a, 2130903124), null, true);
      r.a(r, (TextView)view.findViewById(ci.a(this.a, 2131296607)));
      r.b(r, (TextView)view.findViewById(ci.a(this.a, 2131296609)));
      r.c(r, (TextView)view.findViewById(ci.a(this.a, 2131296611)));
      r.d(r, (TextView)view.findViewById(ci.a(this.a, 2131296613)));
      r.a(r, (Button)view.findViewById(ci.a(this.a, 2131296614)));
      view.setTag(r);
    } else {
      r = (r)paramView.getTag();
      view = paramView;
    } 
    h h1 = this.b[paramInt];
    r.a(r).setText(h1.f);
    r.b(r).setText(String.valueOf(h1.u));
    paramInt = (int)Math.ceil((h1.s - System.currentTimeMillis()) / 1000.0D / 60.0D / 60.0D / 24.0D);
    if (h1.s == -1L) {
      String str1 = "无限制";
      r.c(r).setText(str1);
      r.d(r).setText(h1.v);
      r.e(r).setOnClickListener(new q(this, h1));
      return view;
    } 
    if (paramInt <= 0) {
      String str1 = "已过期";
      r.c(r).setText(str1);
      r.d(r).setText(h1.v);
      r.e(r).setOnClickListener(new q(this, h1));
      return view;
    } 
    String str = String.valueOf(paramInt) + "天";
    r.c(r).setText(str);
    r.d(r).setText(h1.v);
    r.e(r).setOnClickListener(new q(this, h1));
    return view;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */