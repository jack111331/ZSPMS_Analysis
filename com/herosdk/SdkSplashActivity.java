package com.herosdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.herosdk.b.a;
import com.herosdk.common.PluginNode;
import com.herosdk.common.PluginUtils;
import com.herosdk.d.o;
import com.herosdk.d.v;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import com.herosdk.error.b;
import java.util.ArrayList;
import java.util.List;

public abstract class SdkSplashActivity extends Activity {
  private static final String a = "frameLib.Splash";
  
  private ImageView b;
  
  private boolean c = false;
  
  private RelativeLayout d;
  
  private List<Integer> e = new ArrayList<Integer>();
  
  private void a() {
    Log.d("frameLib.Splash", "ssa");
    byte b = 0;
    if (getResources().getIdentifier(o.g() + Character.MIN_VALUE, o.h(), getPackageName()) == 0) {
      onSplashStop();
      return;
    } 
    while (true) {
      int i = getResources().getIdentifier(o.g() + b, o.h(), getPackageName());
      b++;
      if (i == 0) {
        d();
        return;
      } 
      this.e.add(Integer.valueOf(i));
    } 
  }
  
  private void a(int paramInt) {
    Log.d("frameLib.Splash", "i:" + paramInt);
    if (this.e.size() > paramInt) {
      if (!this.c) {
        this.c = true;
        this.b.setImageResource(((Integer)this.e.get(paramInt)).intValue());
        Animation animation = c();
        animation.setAnimationListener(new m(this, paramInt));
        this.d.startAnimation(animation);
        this.d.setVisibility(0);
      } 
      return;
    } 
    onSplashStop();
  }
  
  private void b() {
    this.d = new RelativeLayout((Context)this);
    this.d.setBackgroundColor(0);
    this.d.setVisibility(4);
    this.b = new ImageView((Context)this);
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.d.addView((View)this.b, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    setContentView((View)this.d, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
  }
  
  private Animation c() {
    Log.d("frameLib.Splash", "ga");
    AlphaAnimation alphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation1.setInterpolator((Interpolator)new DecelerateInterpolator());
    alphaAnimation1.setDuration(600L);
    AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation2.setInterpolator((Interpolator)new AccelerateInterpolator());
    alphaAnimation2.setStartOffset(1200L);
    alphaAnimation2.setDuration(600L);
    AnimationSet animationSet = new AnimationSet(false);
    animationSet.addAnimation((Animation)alphaAnimation1);
    animationSet.addAnimation((Animation)alphaAnimation2);
    return (Animation)animationSet;
  }
  
  private void d() {
    Log.d("frameLib.Splash", "sa");
    b();
    a(0);
  }
  
  private void e() {
    try {
      Log.d("frameLib.Splash", "dMSB...begin");
      Class<?> clazz = Class.forName("com.zz.sdk.SDKManager");
      clazz.getDeclaredMethod("burialPoint", new Class[] { Activity.class, String.class, String.class, int.class }).invoke(clazz, new Object[] { this, "Splash_platform", "splash_game", Integer.valueOf(1) });
      Log.d("frameLib.Splash", "dMSB...end");
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void doSplashInit(Activity paramActivity) {
    try {
      Log.d("frameLib.Splash", "dSplhI");
      x.a().a(0);
      x.a().e(false);
      x.a().f(false);
      a a = a.a();
      n n = new n();
      this(this, paramActivity);
      a.a((Context)paramActivity, n);
    } catch (Exception exception) {}
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    Log.d("frameLib.Splash", "onActivityResult");
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    a();
  }
  
  protected void onCreate(Bundle paramBundle) {
    boolean bool = true;
    Log.d("frameLib.Splash", "onCreate");
    super.onCreate(paramBundle);
    x.a().a(this);
    b.a().a((Context)this);
    v.a(this).a();
    doSplashInit(this);
    if (HeroSdk.getInstance().getChannelId() == 18 && HeroSdk.getInstance().callExtendApi(this, 12))
      e(); 
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    x x = x.a();
    if ((getResources().getConfiguration()).orientation != 2)
      bool = false; 
    x.a(bool);
    try {
      PluginUtils.getInstance().invokePlugin(PluginNode.ON_SPLASH_CREATE, new Object[] { this });
      if (HeroSdk.getInstance().getChannelId() == 35) {
        if (x.a().a(this, 20181)) {
          Log.d("frameLib.Splash", "onCreate...first action,return");
          return;
        } 
        Log.d("frameLib.Splash", "onCreate...first action,do nothing");
      } 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      if (HeroSdk.getInstance().getChannelId() == 35) {
        if (x.a().a(this, 20181)) {
          Log.d("frameLib.Splash", "onCreate...first action,return");
          return;
        } 
        Log.d("frameLib.Splash", "onCreate...first action,do nothing");
      } 
    } 
    if (x.a().a(this, 8)) {
      Log.d("frameLib.Splash", "onCreate return second action");
      return;
    } 
    a();
  }
  
  protected void onDestroy() {
    Log.d("frameLib.Splash", "onDestroy");
    super.onDestroy();
    try {
      x.a().d(true);
      if (x.a().G() == 1)
        x.a().d(this); 
      PluginUtils.getInstance().invokePlugin(PluginNode.ON_SPLASH_DESTROY, new Object[] { this });
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  protected void onNewIntent(Intent paramIntent) {
    Log.e("frameLib.Splash", "onNewIntent");
    super.onNewIntent(paramIntent);
    if (HeroSdk.getInstance().getChannelId() == 35)
      HeroSdk.getInstance().onNewIntent(this, paramIntent); 
  }
  
  public abstract void onSplashStop();
  
  public void ssa() {
    a();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\SdkSplashActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */