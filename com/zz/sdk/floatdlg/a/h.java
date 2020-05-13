package com.zz.sdk.floatdlg.a;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.zz.sdk.floatdlg.b.as;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.t;

public class h extends BaseAdapter {
  private com.zz.sdk.b.h[] a;
  
  private Context b;
  
  private t c;
  
  private n d;
  
  public h(Context paramContext, com.zz.sdk.b.h[] paramArrayOfh) {
    this.b = paramContext;
    this.a = paramArrayOfh;
  }
  
  private void a() {
    (new Thread(new m(this))).start();
  }
  
  private void a(com.zz.sdk.b.h paramh, o paramo) {
    switch (paramh.k) {
      default:
        return;
      case 1:
        if (paramh.i == 1) {
          if (cm.b(this.b, cq.a(this.b).s())) {
            long l = cv.v(this.b);
            if (System.currentTimeMillis() - cm.a(this.b) <= l)
              if (paramh.q < paramh.r)
                b(paramh, paramo);  
            if (this.b instanceof FragmentActivity)
              ((FragmentActivity)this.b).getSupportFragmentManager().beginTransaction().replace(2131296257, (Fragment)as.a(paramh)).addToBackStack(null).commit(); 
          } 
          if (this.b instanceof FragmentActivity)
            ((FragmentActivity)this.b).getSupportFragmentManager().beginTransaction().replace(2131296257, (Fragment)as.a(paramh)).addToBackStack(null).commit(); 
        } 
        b(paramh, paramo);
      case 0:
        break;
    } 
    if (this.b instanceof FragmentActivity)
      ((FragmentActivity)this.b).getSupportFragmentManager().beginTransaction().replace(2131296257, (Fragment)as.a(paramh)).addToBackStack(null).commit(); 
  }
  
  private void a(o paramo) {
    o.e(paramo).setText(ci.a(this.b, 2131165436));
    o.e(paramo).setBackgroundResource(ci.a(this.b, 2130837563));
    o.e(paramo).setEnabled(false);
  }
  
  private void a(Runnable paramRunnable) {
    cv.a(paramRunnable);
  }
  
  private void b(com.zz.sdk.b.h paramh, o paramo) {
    this.c = t.a(this.b);
    (new Thread(new j(this, paramh, paramo))).start();
  }
  
  private void b(o paramo) {
    o.e(paramo).setText(ci.a(this.b, 2131165435));
    o.e(paramo).setBackgroundResource(ci.a(this.b, 2130837565));
    o.e(paramo).setEnabled(true);
  }
  
  private void c(o paramo) {
    o.e(paramo).setText(ci.a(this.b, 2131165434));
    o.e(paramo).setBackgroundResource(ci.a(this.b, 2130837562));
    o.e(paramo).setEnabled(true);
  }
  
  public void a(n paramn) {
    this.d = paramn;
  }
  
  public int getCount() {
    return this.a.length;
  }
  
  public Object getItem(int paramInt) {
    return this.a[paramInt];
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    o o;
    if (paramView == null) {
      o = new o(this);
      paramView = LayoutInflater.from(this.b).inflate(ci.a(this.b, 2130903118), null, true);
      o.a(o, (TextView)paramView.findViewById(ci.a(this.b, 2131296552)));
      o.a(o, (ProgressBar)paramView.findViewById(ci.a(this.b, 2131296553)));
      o.b(o, (TextView)paramView.findViewById(ci.a(this.b, 2131296554)));
      o.c(o, (TextView)paramView.findViewById(ci.a(this.b, 2131296556)));
      o.a(o, (Button)paramView.findViewById(ci.a(this.b, 2131296555)));
      paramView.setTag(o);
    } else {
      o = (o)paramView.getTag();
    } 
    com.zz.sdk.b.h h1 = this.a[paramInt];
    o.a(o).setText(h1.f);
    paramInt = h1.o * 100 / h1.p;
    o.b(o).setProgress(paramInt);
    o.c(o).setText("剩余" + paramInt + "%");
    o.d(o).setText(h1.b);
    o.e(o).setOnClickListener(new i(this, h1, o));
    switch (h1.k) {
      default:
        return paramView;
      case 1:
        if (h1.i == 1) {
          if (cm.b(this.b, cq.a(this.b).s())) {
            long l = cv.v(this.b);
            if (System.currentTimeMillis() - cm.a(this.b) <= l) {
              if (h1.q < h1.r)
                c(o); 
              a(o);
            } 
            b(o);
          } 
          b(o);
        } 
        c(o);
      case 0:
        break;
    } 
    if (h1.q >= h1.r)
      a(o); 
    b(o);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */