package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.j;
import java.util.ArrayList;
import org.json.JSONObject;

public final class k extends aa {
  private final String c = "[A-Za-z0-9]{8,32}";
  
  private ArrayList<View.OnClickListener> o = new ArrayList<View.OnClickListener>();
  
  private ArrayList<View.OnClickListener> p = new ArrayList<View.OnClickListener>();
  
  private TextView q = null;
  
  private boolean r = true;
  
  private String s = null;
  
  private String t = null;
  
  private View.OnClickListener u = new l(this);
  
  public k(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString) {
    super(paramContext, paramInt, paramJSONObject, paramString);
    this.s = j.a(paramJSONObject, "button_label");
    this.t = j.a(paramJSONObject, "button_action");
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, b.n);
    layoutParams1.addRule(9, -1);
    layoutParams1.addRule(15, -1);
    this.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.q = new TextView(getContext());
    this.q.setGravity(17);
    this.q.setText(this.s);
    this.q.setTextColor(h.a(-10705958, -5846275, -5846275, -6710887));
    this.q.setTextSize(b.k);
    this.q.setOnClickListener(this.u);
    a(false);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
    this.b.a((View)this.q, layoutParams);
  }
  
  public final void a(View.OnClickListener paramOnClickListener) {
    this.o.add(paramOnClickListener);
  }
  
  public final void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.q.setText(c.bD.B);
      this.r = false;
      return;
    } 
    this.q.setText(this.s);
    this.r = true;
  }
  
  public final void b(View.OnClickListener paramOnClickListener) {
    this.p.add(paramOnClickListener);
  }
  
  public final boolean b() {
    boolean bool = true;
    if (!this.i && 6 != a().length())
      bool = false; 
    return bool;
  }
  
  protected final String d() {
    return "_input_coupon";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */