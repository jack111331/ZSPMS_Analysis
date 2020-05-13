package com.cmic.sso.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.cmic.sso.sdk.utils.p;

public class LoadingImageView extends ImageView {
  private Animation a = null;
  
  private LinearInterpolator b = null;
  
  public LoadingImageView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public LoadingImageView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public LoadingImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  protected void a() {
    this.a = AnimationUtils.loadAnimation(getContext(), p.b(getContext(), "umcsdk_anim_loading"));
    this.b = new LinearInterpolator();
    this.a.setInterpolator((Interpolator)this.b);
  }
  
  public void b() {
    setVisibility(0);
    startAnimation(this.a);
  }
  
  public void c() {
    setVisibility(8);
    clearAnimation();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\widget\LoadingImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */