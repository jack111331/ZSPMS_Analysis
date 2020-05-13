package com.zz.sdk.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import com.zz.sdk.b.v;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class br extends BaseAdapter implements Filterable {
  public static final int a = 1;
  
  private int b = -1;
  
  private Context c;
  
  private bt d;
  
  private List e = new ArrayList();
  
  private int f = -1;
  
  private int g = -1;
  
  private final Object h = new Object();
  
  private bv i;
  
  public br(Context paramContext, v[] paramArrayOfv) {
    int i = paramArrayOfv.length;
    for (byte b = 0; b < i; b++) {
      v v1 = paramArrayOfv[b];
      bu bu = new bu();
      bu.a = v1.b;
      bu.b = v1.c;
      this.b++;
      this.e.add(v1);
      if (this.g == -1)
        this.g = 1; 
    } 
    this.c = paramContext;
    if (this.g == -1)
      this.g = 1; 
  }
  
  public String a(int paramInt) {
    null = getItem(paramInt);
    return (null instanceof v) ? ((v)null).b : null;
  }
  
  public void a(v paramv) {
    if (paramv != null) {
      for (v v1 : this.e) {
        if (v1 != null && v1.toString().equals(paramv.toString())) {
          this.e.remove(v1);
          break;
        } 
      } 
      notifyDataSetChanged();
    } 
  }
  
  public void a(bv parambv) {
    this.i = parambv;
  }
  
  public String b(int paramInt) {
    null = getItem(paramInt);
    return (null instanceof v) ? ((v)null).c : null;
  }
  
  public void b(v paramv) {
    v v1;
    Iterator<v> iterator = this.e.iterator();
    while (true) {
      v1 = paramv;
      if (iterator.hasNext()) {
        v1 = iterator.next();
        if (!v1.b.equals(paramv.b) || !v1.c.equals(paramv.c)) {
          if (v1.b.equalsIgnoreCase(paramv.b)) {
            v1.c = paramv.c;
            v1.b = paramv.b;
            v1 = null;
            break;
          } 
          continue;
        } 
        return;
      } 
      break;
    } 
    if (v1 != null)
      this.e.add(v1); 
    notifyDataSetChanged();
  }
  
  public int getCount() {
    return this.e.size();
  }
  
  public Filter getFilter() {
    if (this.d == null)
      this.d = new bt(this, null); 
    return this.d;
  }
  
  public Object getItem(int paramInt) {
    return this.e.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      paramView = View.inflate(this.c, ci.a(this.c, 2130903132), null);
      bw bw1 = new bw(this, paramView);
      v v1 = (v)getItem(paramInt);
      bw1.a.setText(v1.b);
      bw1.b.setText(this.c.getString(ci.a(this.c, 2131165409), new Object[] { cv.a(v1.f) }));
      bw1.c.setOnClickListener(new bs(this, paramInt));
      return paramView;
    } 
    bw bw = (bw)paramView.getTag();
    v v = (v)getItem(paramInt);
    bw.a.setText(v.b);
    bw.b.setText(this.c.getString(ci.a(this.c, 2131165409), new Object[] { cv.a(v.f) }));
    bw.c.setOnClickListener(new bs(this, paramInt));
    return paramView;
  }
  
  public void notifyDataSetChanged() {
    super.notifyDataSetChanged();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */