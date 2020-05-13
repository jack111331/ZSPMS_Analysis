package com.zz.sdk.floatdlg.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.zz.sdk.b.h;
import com.zz.sdk.floatdlg.b.ae;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.t;
import java.util.List;

public class c extends BaseAdapter {
  private ae a;
  
  private Context b;
  
  private List c;
  
  private int d = 2;
  
  public c(ae paramae, List paramList) {
    this.a = paramae;
    this.b = (Context)paramae.getActivity();
    this.c = paramList;
  }
  
  private void a(h paramh) {
    try {
      t t = t.a(this.b);
      Thread thread = new Thread();
      e e = new e();
      this(this, t, paramh);
      this(e);
      thread.start();
    } catch (Exception exception) {}
  }
  
  private void a(String paramString, h paramh) {
    cv.a(new f(this, paramString, paramh));
  }
  
  public int getCount() {
    return (this.c.size() < this.d) ? this.c.size() : (this.a.b() ? this.c.size() : this.d);
  }
  
  public Object getItem(int paramInt) {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    g g;
    if (paramView == null) {
      g = new g(this);
      paramView = LayoutInflater.from(this.b).inflate(ci.a(this.b, 2130903114), null, true);
      g.a(g, (TextView)paramView.findViewById(ci.a(this.b, 2131296544)));
      g.b(g, (TextView)paramView.findViewById(ci.a(this.b, 2131296546)));
      g.a(g, (Button)paramView.findViewById(ci.a(this.b, 2131296545)));
      paramView.setTag(g);
    } else {
      g = (g)paramView.getTag();
    } 
    h h = this.c.get(paramInt);
    g.a(g).setText(h.f);
    g.b(g).setText(h.b);
    if (h.k == 1) {
      if (cm.b(this.b, cq.a(this.b).s())) {
        long l = cv.v(this.b);
        if (System.currentTimeMillis() - cm.a(this.b) <= l) {
          if (h.q < h.r) {
            g.c(g).setText(this.b.getString(ci.a(this.b, 2131165434)));
            g.c(g).setBackgroundResource(ci.a(this.b, 2130837562));
            g.c(g).setEnabled(true);
            g.c(g).setOnClickListener(new d(this, h));
            return paramView;
          } 
        } else {
          g.c(g).setOnClickListener(new d(this, h));
          return paramView;
        } 
        g.c(g).setText(this.b.getString(ci.a(this.b, 2131165436)));
        g.c(g).setBackgroundResource(ci.a(this.b, 2130837563));
        g.c(g).setEnabled(false);
        g.c(g).setOnClickListener(new d(this, h));
        return paramView;
      } 
      g.c(g).setText(this.b.getString(ci.a(this.b, 2131165434)));
      g.c(g).setBackgroundResource(ci.a(this.b, 2130837563));
      g.c(g).setEnabled(false);
      g.c(g).setOnClickListener(new d(this, h));
      return paramView;
    } 
    if (h.q >= h.r) {
      g.c(g).setText(this.b.getString(ci.a(this.b, 2131165436)));
      g.c(g).setBackgroundResource(ci.a(this.b, 2130837563));
      g.c(g).setEnabled(false);
      g.c(g).setOnClickListener(new d(this, h));
      return paramView;
    } 
    g.c(g).setText(this.b.getString(ci.a(this.b, 2131165434)));
    g.c(g).setBackgroundResource(ci.a(this.b, 2130837563));
    g.c(g).setEnabled(false);
    g.c(g).setOnClickListener(new d(this, h));
    return paramView;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */