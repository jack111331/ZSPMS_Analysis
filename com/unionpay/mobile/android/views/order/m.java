package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.nocard.views.bh;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.widgets.ad;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m extends RelativeLayout {
  private Context a;
  
  private ImageView b;
  
  private LinearLayout c;
  
  private LinearLayout d;
  
  private Drawable e;
  
  private Drawable f;
  
  public m(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
    int i = g.a(paramContext, 10.0F);
    setPadding(i, i, i, i);
    setBackgroundColor(-1);
    setOnClickListener(new n(this));
    int j = g.a(paramContext, 15.0F);
    this.b = new ImageView(paramContext);
    this.b.setId(this.b.hashCode());
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(j, j);
    layoutParams2.addRule(11, -1);
    layoutParams2.addRule(12, -1);
    addView((View)this.b, (ViewGroup.LayoutParams)layoutParams2);
    this.c = new LinearLayout(paramContext);
    this.c.setOrientation(1);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams1.rightMargin = i;
    layoutParams1.addRule(9, -1);
    layoutParams1.addRule(15, -1);
    layoutParams1.addRule(0, this.b.getId());
    addView((View)this.c, (ViewGroup.LayoutParams)layoutParams1);
  }
  
  public final void a(Drawable paramDrawable1, Drawable paramDrawable2) {
    this.e = paramDrawable1;
    this.f = paramDrawable2;
  }
  
  public final void a(boolean paramBoolean, JSONArray paramJSONArray, JSONObject paramJSONObject) {
    int j;
    int i = 2;
    this.c.removeAllViews();
    if (this.f != null)
      this.b.setBackgroundDrawable(this.f); 
    if (paramJSONArray == null || paramJSONArray.length() == 0) {
      j = 0;
    } else {
      j = 1;
    } 
    if (!paramBoolean && paramJSONArray != null)
      if (paramJSONArray.length() > 2) {
        j = i;
      } else {
        j = paramJSONArray.length();
      }  
    if (paramJSONArray == null || j == 0) {
      k.c("uppay", "init order detail = null!!!");
      return;
    } 
    LinearLayout linearLayout = bh.a(this.a, paramJSONArray, 0, j);
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
    this.c.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams2);
    i = paramJSONArray.length();
    this.d = bh.a(this.a, paramJSONArray, j, i);
    if (paramJSONObject != null) {
      ad ad = new ad(this.a, paramJSONObject, "");
      ad.g();
      ad.a(b.m);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
      layoutParams.topMargin = g.a(this.a, 8.0F);
      this.d.addView((View)ad, (ViewGroup.LayoutParams)layoutParams);
    } 
    this.d.setVisibility(8);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    this.c.addView((View)this.d, (ViewGroup.LayoutParams)layoutParams1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\views\order\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */