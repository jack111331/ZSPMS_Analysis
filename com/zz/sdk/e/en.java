package com.zz.sdk.e;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;

class en extends BaseExpandableListAdapter {
  en(ej paramej) {}
  
  public Object getChild(int paramInt1, int paramInt2) {
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2) {
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup) {
    FrameLayout frameLayout = new FrameLayout(ej.a(this.a));
    frameLayout.setBackgroundColor(-1);
    LinearLayout linearLayout = new LinearLayout(ej.a(this.a));
    linearLayout.setOrientation(1);
    linearLayout.setPadding(cc.a(10.0F), 0, 0, 0);
    TextView textView1 = new TextView(ej.a(this.a));
    textView1.setBackgroundDrawable(ca.ar.a(ej.a(this.a)));
    textView1.setHeight(1);
    frameLayout.addView((View)textView1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    textView1 = new TextView(ej.a(this.a));
    textView1.setText("订单账号 ：20141091412323");
    TextView textView2 = new TextView(ej.a(this.a));
    textView2.setText("说明 ：充值卡金额符合充值规则");
    linearLayout.addView((View)textView1);
    linearLayout.addView((View)textView2);
    frameLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2, 80));
    frameLayout.setPadding(0, 0, 0, 0);
    return (View)frameLayout;
  }
  
  public int getChildrenCount(int paramInt) {
    return 1;
  }
  
  public Object getGroup(int paramInt) {
    return null;
  }
  
  public int getGroupCount() {
    return 15;
  }
  
  public long getGroupId(int paramInt) {
    return 0L;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup) {
    FrameLayout frameLayout = new FrameLayout(ej.a(this.a));
    LinearLayout linearLayout3 = new LinearLayout(ej.a(this.a));
    linearLayout3.setOrientation(1);
    linearLayout3.setPadding(cc.a(10.0F), cc.a(5.0F), 0, cc.a(5.0F));
    frameLayout.setBackgroundColor(-1);
    TextView textView1 = new TextView(ej.a(this.a));
    textView1.setText("道具 ：100钻石");
    textView1.setTextColor(-16777216);
    TextView textView3 = new TextView(ej.a(this.a));
    textView3.setText("充值卡支付100元");
    linearLayout3.addView((View)textView1);
    linearLayout3.addView((View)textView3);
    frameLayout.addView((View)linearLayout3, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 3));
    LinearLayout linearLayout1 = new LinearLayout(ej.a(this.a));
    linearLayout1.setId(paramInt);
    linearLayout1.setOrientation(0);
    linearLayout1.setPadding(cc.a(2.0F), cc.a(5.0F), 0, cc.a(5.0F));
    LinearLayout linearLayout4 = new LinearLayout(ej.a(this.a));
    linearLayout4.setOrientation(1);
    TextView textView2 = new TextView(ej.a(this.a));
    textView2.setText("已成功");
    textView2.setTextColor(Color.rgb(253, 158, 47));
    textView3 = new TextView(ej.a(this.a));
    textView3.setText("2014-01-09 14:25:10");
    linearLayout4.addView((View)textView2);
    linearLayout4.addView((View)textView3);
    linearLayout1.addView((View)linearLayout4);
    LinearLayout linearLayout2 = new LinearLayout(ej.a(this.a));
    linearLayout2.setGravity(17);
    linearLayout2.setPadding(cc.a(5.0F), cc.a(10.0F), cc.a(5.0F), 0);
    ImageView imageView = new ImageView(ej.a(this.a));
    imageView.setImageDrawable(ca.aT.a(ej.a(this.a)));
    if (paramBoolean)
      imageView.setImageDrawable(ca.aS.a(ej.a(this.a))); 
    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    linearLayout2.addView((View)imageView);
    linearLayout1.addView((View)linearLayout2);
    frameLayout.addView((View)linearLayout1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 5));
    return (View)frameLayout;
  }
  
  public boolean hasStableIds() {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2) {
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\en.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */