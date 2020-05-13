package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.h;

public final class x extends LinearLayout {
  private Context a = null;
  
  private TextView b = null;
  
  private x(Context paramContext, Drawable paramDrawable) {
    super(paramContext);
    this.a = paramContext;
    setOrientation(0);
    Context context = this.a;
    if (paramDrawable != null) {
      ImageView imageView = new ImageView(context);
      imageView.setBackgroundDrawable(paramDrawable);
      int i = b.o;
      LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(i, i);
      layoutParams1.gravity = 16;
      addView((View)imageView, (ViewGroup.LayoutParams)layoutParams1);
    } 
    this.b = new TextView(context);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
    layoutParams.gravity = 16;
    if (paramDrawable != null)
      layoutParams.leftMargin = a.d; 
    addView((View)this.b, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public static x a(Context paramContext, Drawable paramDrawable) {
    x x1 = new x(paramContext, paramDrawable);
    if (x1.b != null)
      x1.b.setTextSize(16.0F); 
    x1.a(h.a(-16758391, -65536));
    return x1;
  }
  
  public final void a(ColorStateList paramColorStateList) {
    if (this.b != null)
      this.b.setTextColor(paramColorStateList); 
  }
  
  public final void a(CharSequence paramCharSequence) {
    if (this.b != null)
      this.b.setText(paramCharSequence); 
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener) {
    if (this.b != null)
      this.b.setOnClickListener(paramOnClickListener); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upwidget\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */