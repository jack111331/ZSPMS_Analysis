package com.zz.sdk.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.zz.sdk.b.k;
import com.zz.sdk.b.m;
import com.zz.sdk.i.a;
import com.zz.sdk.i.aq;
import com.zz.sdk.i.cg;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.n;
import java.util.Collections;
import java.util.LinkedList;

public class bx extends BaseAdapter {
  private LinkedList a = new LinkedList();
  
  private Context b;
  
  private t c;
  
  private ce d;
  
  private ci e;
  
  public bx(Context paramContext, LinkedList<?> paramLinkedList) {
    this.b = paramContext;
    this.c = new t(paramContext);
    this.a = paramLinkedList;
    Collections.reverse(paramLinkedList);
  }
  
  public bx(Context paramContext, LinkedList<?> paramLinkedList, ce paramce) {
    this.b = paramContext;
    this.c = new t(paramContext);
    this.d = paramce;
    this.a = paramLinkedList;
    Collections.reverse(paramLinkedList);
  }
  
  private void a(m paramm, cd paramcd) {
    String str2;
    paramcd.a.setText("道具： " + paramm.c() + "元");
    int i = cv.a(paramm.f(), 82);
    String str3 = paramm.c();
    paramcd.b.setText(k.a(i) + "充值" + str3 + "元");
    String str4 = paramm.d();
    paramcd.c.setText("" + str4);
    str3 = paramm.e();
    paramcd.d.setText(str3);
    String str5 = paramm.g();
    aq aq = aq.a(str5);
    switch (cc.a[aq.ordinal()]) {
      default:
        paramcd.f.setText("(未知)" + str5);
        paramcd.f.setTextColor(-16777216);
        paramcd.e.setVisibility(0);
        str1 = paramm.a();
        paramcd.e.setOnClickListener(new bz(this, str4, str5, str1));
        return;
      case 1:
      case 2:
        paramcd.f.setText("正在充值中...");
        paramcd.f.setTextColor(-7829368);
        paramcd.e.setVisibility(0);
        str1 = str1.a();
        paramcd.e.setOnClickListener(new bz(this, str4, str5, str1));
        return;
      case 3:
        paramcd.f.setText("已成功");
        paramcd.f.setTextColor(Color.rgb(60, 179, 113));
        paramcd.e.setVisibility(8);
        str1 = str1.a();
        paramcd.e.setOnClickListener(new bz(this, str4, str5, str1));
        return;
      case 4:
        if (a.a()) {
          str2 = cg.c.a();
        } else {
          str2 = cg.b.a();
        } 
        paramcd.f.setText("充值为" + str2);
        paramcd.f.setTextColor(Color.rgb(60, 179, 113));
        paramcd.e.setVisibility(8);
        str1 = str1.a();
        paramcd.e.setOnClickListener(new bz(this, str4, str5, str1));
        return;
      case 5:
        paramcd.f.setText("订单异常,请联系客服");
        paramcd.f.setTextColor(-16776961);
        paramcd.e.setVisibility(0);
        str1 = str1.a();
        paramcd.e.setOnClickListener(new bz(this, str4, str5, str1));
        return;
      case 6:
        paramcd.f.setText("下单失败");
        paramcd.f.setTextColor(-65536);
        paramcd.e.setVisibility(8);
        str1 = str1.a();
        paramcd.e.setOnClickListener(new bz(this, str4, str5, str1));
        return;
      case 7:
        break;
    } 
    paramcd.f.setText("支付失败");
    paramcd.f.setTextColor(-65536);
    paramcd.e.setVisibility(8);
    String str1 = str1.a();
    paramcd.e.setOnClickListener(new bz(this, str4, str5, str1));
  }
  
  public void a(ci paramci) {
    this.e = paramci;
  }
  
  @SuppressLint({"SimpleDateFormat"})
  public void a(String paramString1, String paramString2, String paramString3) {
    (new Thread(new ca(this, paramString1, paramString3))).start();
  }
  
  public int getCount() {
    return this.a.size();
  }
  
  public Object getItem(int paramInt) {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  @SuppressLint({"SimpleDateFormat"})
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    n n;
    if (paramView == null) {
      n = new n(this.b);
      cd cd1 = new cd(this);
      cd1.a = n.getTxtevent();
      cd1.b = n.getTxtTopright();
      cd1.c = n.getTxtNum();
      cd1.d = n.getTxtTime();
      cd1.e = n.getTxtquery();
      cv.a((View)cd1.e, 40, 40, 20, 20);
      cd1.f = n.getTxts();
      n.setTag(cd1);
      a(this.a.get(paramInt), cd1);
      n.setOnClickListener(new by(this, paramInt));
      return (View)n;
    } 
    cd cd = (cd)n.getTag();
    a(this.a.get(paramInt), cd);
    n.setOnClickListener(new by(this, paramInt));
    return (View)n;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */