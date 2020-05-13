package com.zz.sdk.e;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.zz.sdk.i.a;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.cg;

public class ft extends BaseAdapter implements SpinnerAdapter {
  private Context a;
  
  private Double[] b;
  
  private int c;
  
  public ft(Context paramContext, Double[] paramArrayOfDouble) {
    this.a = paramContext;
    this.b = paramArrayOfDouble;
  }
  
  public void a(int paramInt) {
    this.c = paramInt;
    notifyDataSetChanged();
  }
  
  public int getCount() {
    return this.b.length;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    TextView textView = new TextView(this.a);
    if (paramInt == 0) {
      textView.setText("请选择指定的充值服务");
    } else {
      String str;
      if (a.a()) {
        str = cg.bP.a();
      } else {
        str = cg.bO.a();
      } 
      textView.setText(String.format(str, new Object[] { Integer.valueOf(this.b[paramInt].intValue()), Integer.valueOf(this.b[paramInt].intValue()) }));
    } 
    textView.setGravity(16);
    textView.setBackgroundDrawable((Drawable)ca.a(this.a, ca.aX, ca.aY));
    if (paramInt == this.c) {
      textView.setTextColor(-1);
      textView.setBackgroundDrawable(ca.aY.a(this.a));
      textView.setPressed(true);
    } 
    textView.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-1, -1));
    textView.setPadding(cc.a(5.0F), 0, 0, 0);
    return (View)textView;
  }
  
  public Object getItem(int paramInt) {
    return this.b[paramInt];
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt) {
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    String str;
    TextView textView = new TextView(this.a);
    if (paramInt == 0) {
      textView.setText("请选择指定的充值服务");
      return (View)textView;
    } 
    if (a.a()) {
      str = cg.bP.a();
    } else {
      str = cg.bO.a();
    } 
    textView.setText(String.format(str, new Object[] { Integer.valueOf(this.b[paramInt].intValue()), Integer.valueOf(this.b[paramInt].intValue()) }));
    return (View)textView;
  }
  
  public int getViewTypeCount() {
    return 0;
  }
  
  public boolean hasStableIds() {
    return false;
  }
  
  public boolean isEmpty() {
    return false;
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */