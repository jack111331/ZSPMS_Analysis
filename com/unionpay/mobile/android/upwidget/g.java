package com.unionpay.mobile.android.upwidget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.unionpay.mobile.android.global.b;
import java.util.ArrayList;

public final class g extends LinearLayout {
  private Context a;
  
  private c b;
  
  private ArrayList<AdapterView.OnItemClickListener> c = new ArrayList<AdapterView.OnItemClickListener>();
  
  private ArrayList<View.OnClickListener> d = new ArrayList<View.OnClickListener>();
  
  private AdapterView.OnItemClickListener e = new h(this);
  
  private View.OnClickListener f = new i(this);
  
  public g(Context paramContext, c paramc) {
    super(paramContext);
    this.a = paramContext;
    this.b = paramc;
    RelativeLayout relativeLayout = new RelativeLayout(this.a);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams1.addRule(12, -1);
    LinearLayout linearLayout1 = new LinearLayout(this.a);
    linearLayout1.setOrientation(1);
    linearLayout1.setBackgroundColor(-1);
    linearLayout1.setId(linearLayout1.hashCode());
    relativeLayout.addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams1);
    layoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    LinearLayout linearLayout2 = new LinearLayout(this.a);
    layoutParams1.addRule(10, -1);
    layoutParams1.addRule(2, linearLayout1.getId());
    relativeLayout.addView((View)linearLayout2, (ViewGroup.LayoutParams)layoutParams1);
    linearLayout2.setOnClickListener(this.f);
    int i = com.unionpay.mobile.android.utils.g.a(this.a, 1.0F);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
    int j = b.a;
    layoutParams.bottomMargin = j;
    layoutParams.topMargin = j;
    layoutParams = new LinearLayout.LayoutParams(-1, i);
    linearLayout2 = new LinearLayout(this.a);
    linearLayout2.setBackgroundColor(-3355444);
    linearLayout1.addView((View)linearLayout2, (ViewGroup.LayoutParams)layoutParams);
    new LinearLayout.LayoutParams(-1, -2);
    ListView listView = new ListView(this.a);
    listView.setDivider(null);
    a(listView, (ListAdapter)this.b);
    listView.setAdapter((ListAdapter)this.b);
    listView.setCacheColorHint(-1);
    listView.setOnItemClickListener(this.e);
    new LinearLayout.LayoutParams(-1, -2);
    linearLayout1.addView((View)listView);
    addView((View)relativeLayout);
  }
  
  private void a(ListView paramListView, ListAdapter paramListAdapter) {
    if (paramListView != null && paramListAdapter != null) {
      ViewGroup.LayoutParams layoutParams = paramListView.getLayoutParams();
      if (layoutParams != null) {
        int k;
        Rect rect = new Rect();
        ((Activity)this.a).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.height();
        byte b = 0;
        int j = 0;
        while (true) {
          k = j;
          if (b < paramListAdapter.getCount()) {
            View view = paramListAdapter.getView(b, null, (ViewGroup)paramListView);
            view.measure(0, 0);
            j += view.getMeasuredHeight();
            k = j;
            if (j <= i) {
              b++;
              continue;
            } 
          } 
          break;
        } 
        layoutParams.height = Math.min(k, i);
        paramListView.setLayoutParams(layoutParams);
      } 
    } 
  }
  
  public final void a(View.OnClickListener paramOnClickListener) {
    this.d.add(paramOnClickListener);
  }
  
  public final void a(AdapterView.OnItemClickListener paramOnItemClickListener) {
    this.c.add(paramOnItemClickListener);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upwidget\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */