package com.zz.sdk.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.zz.sdk.b.v;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e extends BaseAdapter {
  private Context a;
  
  private List b;
  
  private g c;
  
  public e(Context paramContext, ArrayList paramArrayList) {
    this.a = paramContext;
    this.b = new ArrayList();
    this.b.addAll(paramArrayList);
    this.b.add(null);
  }
  
  public v a(int paramInt) {
    return this.b.get(paramInt);
  }
  
  public void a(g paramg) {
    this.c = paramg;
  }
  
  public void a(v paramv) {
    v v1;
    Iterator<v> iterator = this.b.iterator();
    while (true) {
      v1 = paramv;
      if (iterator.hasNext()) {
        v1 = iterator.next();
        if (v1 != null) {
          if (!v1.toString().equals(paramv.toString())) {
            if (v1.b.equalsIgnoreCase(paramv.b) && v1.h == paramv.h) {
              v1.c = paramv.c;
              v1.h = paramv.h;
              v1 = null;
              break;
            } 
            continue;
          } 
          return;
        } 
        continue;
      } 
      break;
    } 
    if (v1 != null)
      this.b.add(v1); 
    notifyDataSetChanged();
  }
  
  public void b(v paramv) {
    if (paramv != null) {
      for (v v1 : this.b) {
        if (v1 != null && v1.toString().equals(paramv.toString())) {
          this.b.remove(v1);
          break;
        } 
      } 
      notifyDataSetChanged();
    } 
  }
  
  public int getCount() {
    return this.b.size();
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    h h;
    if (paramView == null) {
      paramView = View.inflate(this.a, ci.a(this.a, 2130903133), null);
      h = new h(this, paramView);
    } else {
      h = (h)paramView.getTag();
    } 
    v v = a(paramInt);
    if (v == null) {
      h.h.setVisibility(4);
      h.i.setVisibility(0);
      return paramView;
    } 
    h.h.setVisibility(0);
    h.i.setVisibility(4);
    h.b(h.b, v);
    h.a(h.a, v);
    if (v.q) {
      h.d.setVisibility(0);
    } else {
      h.d.setVisibility(8);
    } 
    h.c.setText(this.a.getString(ci.a(this.a, 2131165409), new Object[] { cv.a(v.f) }));
    h.e.setVisibility(0);
    h.e.setOnClickListener(new f(this, paramInt));
    return paramView;
  }
  
  public void notifyDataSetChanged() {
    super.notifyDataSetChanged();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */