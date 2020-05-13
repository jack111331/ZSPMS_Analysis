package com.xy.whf.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xy.whf.helper.e;

public class ToastView extends RelativeLayout {
  private TextView mMsgTv;
  
  public ToastView(Context paramContext) {
    super(paramContext);
    initView(paramContext);
  }
  
  public ToastView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  public ToastView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private void initView(Context paramContext) {
    RelativeLayout relativeLayout = new RelativeLayout(paramContext);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    int i = e.a(paramContext, 20);
    layoutParams2.leftMargin = i;
    layoutParams2.rightMargin = i;
    relativeLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    RoundDrawable roundDrawable = new RoundDrawable();
    roundDrawable.setIsRadiusAdjustBounds(false);
    roundDrawable.setCornerRadius(e.a(paramContext, 10));
    roundDrawable.setStroke(e.a(paramContext, 1), Color.parseColor("#00CBFF"));
    roundDrawable.setBgData(ContextCompat.getColorStateList(paramContext, 17170443));
    if (Build.VERSION.SDK_INT > 15) {
      relativeLayout.setBackground((Drawable)roundDrawable);
    } else {
      relativeLayout.setBackgroundDrawable((Drawable)roundDrawable);
    } 
    this.mMsgTv = new TextView(paramContext);
    int j = e.a(paramContext, 8);
    i = e.a(paramContext, 12);
    this.mMsgTv.setGravity(17);
    this.mMsgTv.setPadding(i, j, i, j);
    this.mMsgTv.setMaxLines(5);
    this.mMsgTv.setLineSpacing(1.0F, 1.2F);
    this.mMsgTv.setTextSize(13.0F);
    this.mMsgTv.setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams1.addRule(13);
    relativeLayout.addView((View)this.mMsgTv, (ViewGroup.LayoutParams)layoutParams1);
    addView((View)relativeLayout);
  }
  
  public TextView getMsgTv() {
    return this.mMsgTv;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\widget\ToastView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */