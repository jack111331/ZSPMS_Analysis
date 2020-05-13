package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;

public final class w extends LinearLayout {
  private String a = null;
  
  private x b = null;
  
  private w(Context paramContext, String paramString1, String paramString2, Drawable paramDrawable) {
    super(paramContext);
    setOrientation(0);
    this.a = paramString2;
    this.b = x.a(paramContext, paramDrawable);
    this.b.a((CharSequence)Html.fromHtml(String.format("<u>%s</u>", new Object[] { paramString1 })));
    ColorStateList colorStateList = h.a(-13601621, -15909519);
    this.b.a(colorStateList);
    addView((View)this.b);
  }
  
  public static final w a(Context paramContext, JSONObject paramJSONObject, Drawable paramDrawable) {
    w w1 = null;
    if (paramJSONObject != null)
      w1 = new w(paramContext, j.a(paramJSONObject, "label"), j.a(paramJSONObject, "href"), paramDrawable); 
    return w1;
  }
  
  public final String a() {
    return this.a;
  }
  
  public final void a(View.OnClickListener paramOnClickListener) {
    if (this.b != null)
      this.b.setOnClickListener(paramOnClickListener); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upwidget\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */