package com.chuanglan.shanyan_sdk.tool;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.chuanglan.shanyan_sdk.OneKeyLoginManager;
import com.chuanglan.shanyan_sdk.b;
import com.chuanglan.shanyan_sdk.utils.L;
import com.chuanglan.shanyan_sdk.utils.LCMResource;
import com.cmic.sso.sdk.AuthRegisterViewConfig;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.utils.rglistener.CustomInterface;
import com.cmic.sso.sdk.widget.LoadingImageView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class a {
  private static a a;
  
  private static WeakReference<Activity> h;
  
  private Button A;
  
  private RelativeLayout B;
  
  private Application.ActivityLifecycleCallbacks b = null;
  
  private ShanYanUIConfig c;
  
  private ArrayList<com.chuanglan.shanyan_sdk.view.a> d;
  
  private RelativeLayout e;
  
  private RelativeLayout f;
  
  private Context g = null;
  
  private LinearLayout i;
  
  private Boolean j = Boolean.valueOf(true);
  
  private Boolean k = Boolean.valueOf(false);
  
  private RelativeLayout l;
  
  private View m;
  
  private View n;
  
  private View o;
  
  private View p;
  
  private CheckBox q;
  
  private CheckBox r;
  
  private CheckBox s;
  
  private LoadingImageView t;
  
  private RelativeLayout u;
  
  private Button v;
  
  private ImageView w;
  
  private ImageView x;
  
  private CheckBox y;
  
  private RelativeLayout z;
  
  private a(Context paramContext) {
    if (paramContext != null)
      this.g = paramContext.getApplicationContext(); 
  }
  
  public static a a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/chuanglan/shanyan_sdk/tool/a.a : Lcom/chuanglan/shanyan_sdk/tool/a;
    //   3: ifnonnull -> 31
    //   6: ldc com/chuanglan/shanyan_sdk/tool/a
    //   8: monitorenter
    //   9: getstatic com/chuanglan/shanyan_sdk/tool/a.a : Lcom/chuanglan/shanyan_sdk/tool/a;
    //   12: ifnonnull -> 28
    //   15: new com/chuanglan/shanyan_sdk/tool/a
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: invokespecial <init> : (Landroid/content/Context;)V
    //   24: aload_1
    //   25: putstatic com/chuanglan/shanyan_sdk/tool/a.a : Lcom/chuanglan/shanyan_sdk/tool/a;
    //   28: ldc com/chuanglan/shanyan_sdk/tool/a
    //   30: monitorexit
    //   31: getstatic com/chuanglan/shanyan_sdk/tool/a.a : Lcom/chuanglan/shanyan_sdk/tool/a;
    //   34: areturn
    //   35: astore_0
    //   36: ldc com/chuanglan/shanyan_sdk/tool/a
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   9	28	35	finally
    //   28	31	35	finally
    //   36	39	35	finally
  }
  
  private static List<View> b(View paramView) {
    ArrayList<View> arrayList = new ArrayList();
    if (paramView instanceof ViewGroup) {
      ViewGroup viewGroup = (ViewGroup)paramView;
      for (byte b = 0; b < viewGroup.getChildCount(); b++) {
        paramView = viewGroup.getChildAt(b);
        arrayList.add(paramView);
        arrayList.addAll(b(paramView));
      } 
    } 
    return arrayList;
  }
  
  private void c() {
    this.c = l.a(this.g).a();
    if (this.d == null)
      this.d = new ArrayList<com.chuanglan.shanyan_sdk.view.a>(); 
    if (this.c.getCustomViews() != null) {
      this.d.clear();
      this.d.addAll(this.c.getCustomViews());
      for (byte b = 0; b < this.d.size(); b++) {
        if (((com.chuanglan.shanyan_sdk.view.a)this.d.get(b)).b) {
          if (((com.chuanglan.shanyan_sdk.view.a)this.d.get(b)).c.getParent() != null)
            this.f.removeView(((com.chuanglan.shanyan_sdk.view.a)this.d.get(b)).c); 
          this.f.addView(((com.chuanglan.shanyan_sdk.view.a)this.d.get(b)).c);
        } else {
          if (((com.chuanglan.shanyan_sdk.view.a)this.d.get(b)).c.getParent() != null)
            this.e.removeView(((com.chuanglan.shanyan_sdk.view.a)this.d.get(b)).c); 
          this.e.addView(((com.chuanglan.shanyan_sdk.view.a)this.d.get(b)).c);
        } 
        ((com.chuanglan.shanyan_sdk.view.a)this.d.get(b)).c.setOnClickListener(new View.OnClickListener(this, b) {
              public void onClick(View param1View) {
                if (((com.chuanglan.shanyan_sdk.view.a)a.A(this.b).get(this.a)).a)
                  this.b.b(); 
                if (((com.chuanglan.shanyan_sdk.view.a)a.A(this.b).get(this.a)).d != null)
                  ((com.chuanglan.shanyan_sdk.view.a)a.A(this.b).get(this.a)).d.onClick(a.b(this.b), param1View); 
              }
            });
      } 
    } 
    if (this.c.getLoadingView() != null) {
      this.m = this.c.getLoadingView();
      this.m.setVisibility(8);
      if (this.m.getParent() != null)
        this.e.removeView(this.m); 
      this.e.addView(this.m);
    } 
  }
  
  public void a() {
    this.c = l.a(this.g).a();
    if (this.b == null) {
      this.b = new Application.ActivityLifecycleCallbacks(this) {
          void a(View param1View) {
            try {
              Method method = View.class.getDeclaredMethod("getListenerInfo", new Class[0]);
              method.setAccessible(true);
              Object object = method.invoke(param1View, new Object[0]);
              Field field = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
              field.setAccessible(true);
              View.OnClickListener onClickListener = (View.OnClickListener)field.get(object);
              a a1 = new a();
              this(this, onClickListener);
              field.set(object, a1);
            } catch (Exception exception) {
              exception.printStackTrace();
              L.d("ExceptionLogger", "OnClickListener()Exception == " + exception.toString());
            } 
          }
          
          public void onActivityCreated(Activity param1Activity, Bundle param1Bundle) {
            L.d("ActivityLifecycleLogger", param1Activity + "onActivityCreated--->" + param1Activity.getLocalClassName());
            if (param1Activity instanceof com.cmic.sso.sdk.activity.LoginAuthActivity || param1Activity instanceof com.sdk.mobile.manager.login.cucc.OauthActivity) {
              b.r = false;
              b.L = System.currentTimeMillis();
              b.M = SystemClock.uptimeMillis();
              a.a(this.a, Boolean.valueOf(a.a(this.a).isCheckBoxHidden()));
              a.b(this.a, Boolean.valueOf(a.a(this.a).isPrivacyState()));
              OneKeyLoginManager.getInstance().ShanyanAuthListenerGetPhoneCode(1000, "授权页拉起成功");
              L.d("ProcessLogger", "授权页拉起成功===code=1000");
              long l1 = SystemClock.uptimeMillis();
              long l2 = b.J;
              long l3 = SystemClock.uptimeMillis();
              long l4 = b.Q;
              e.a().a(1000, 3, "3", "1", "授权页拉起成功", b.I + "", l3 - l4, l1 - l2, "1000", "授权页拉起成功", false, false);
            } 
            if (param1Activity instanceof com.sdk.mobile.manager.login.cucc.OauthActivity)
              a.a(new WeakReference<Activity>(param1Activity)); 
            if (param1Activity instanceof com.cmic.sso.sdk.activity.LoginAuthActivity) {
              if (a.a(this.a).getLoadingView() != null) {
                a.a(this.a, a.a(this.a).getLoadingView());
              } else {
                LayoutInflater layoutInflater = LayoutInflater.from(a.b(this.a));
                a.a(this.a, layoutInflater.inflate(LCMResource.getInstance(a.b(this.a)).getLayoutForId("oauth_loading_dialog"), null));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                a.c(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
              } 
              a.c(this.a).setVisibility(8);
              m.a(a.b(this.a), "view_dialog", a.c(this.a), 0);
              ImageView imageView2 = new ImageView(a.b(this.a));
              imageView2.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
              if (a.a(this.a).getLogoImgPath() != null) {
                imageView2.setImageDrawable(a.a(this.a).getLogoImgPath());
              } else {
                imageView2.setImageResource(a.b(this.a).getResources().getIdentifier("umcsdk_mobile_logo", "drawable", a.b(this.a).getPackageName()));
              } 
              imageView2.setEnabled(false);
              if (a.a(this.a).isLogoHidden()) {
                imageView2.setVisibility(8);
              } else {
                imageView2.setVisibility(0);
                m.a(a.b(this.a), "logoImageView", (View)imageView2, 0);
                m.b(a.b(this.a), (View)imageView2, a.a(this.a).getLogoOffsetX(), a.a(this.a).getLogoOffsetY(), a.a(this.a).getLogoOffsetBottomY(), a.a(this.a).getLogoWidth(), a.a(this.a).getLogoHeight());
              } 
              a.b(this.a, LayoutInflater.from(a.b(this.a)).inflate(LCMResource.getInstance(a.b(this.a)).getLayoutForId("cmcc_navigationbar_back_layout"), null));
              RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
              a.d(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
              ImageView imageView1 = (ImageView)a.d(this.a).findViewById(LCMResource.getInstance(a.b(this.a)).getId("shanyan_navigationbar_back"));
              if (a.a(this.a).getNavReturnImgPath() != null)
                imageView1.setImageDrawable(a.a(this.a).getNavReturnImgPath()); 
              if (a.a(this.a).isNavReturnImgHidden()) {
                a.d(this.a).setVisibility(8);
              } else {
                a.d(this.a).setVisibility(0);
                AuthnHelper.getInstance(a.b(this.a)).addAuthRegistViewConfig("cmcc_navigationbar_back", (new AuthRegisterViewConfig.Builder()).setView(a.d(this.a)).setRootViewId(1).setCustomInterface(new CustomInterface(this) {
                        public void onClick(Context param2Context) {
                          a.e(this.a.a).performClick();
                        }
                      }).build());
                m.a(a.b(this.a), a.d(this.a), a.a(this.a).getNavReturnBtnOffsetX(), a.a(this.a).getNavReturnBtnOffsetY(), a.a(this.a).getNavReturnBtnOffsetRightX(), a.a(this.a).getReturnBtnWidth(), a.a(this.a).getReturnBtnHeight(), imageView1);
              } 
              a.c(this.a, LayoutInflater.from(a.b(this.a)).inflate(LCMResource.getInstance(a.b(this.a)).getLayoutForId("shanyan_privacy_layout"), null));
              RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
              a.f(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
              a.a(this.a, (RelativeLayout)a.f(this.a).findViewById(LCMResource.getInstance(a.b(this.a)).getId("shanyan_privacy_checkbox_rootlayout")));
              a.a(this.a, (CheckBox)a.f(this.a).findViewById(LCMResource.getInstance(a.b(this.a)).getId("shanyan_privacy_checkbox")));
              TextView textView = (TextView)a.f(this.a).findViewById(LCMResource.getInstance(a.b(this.a)).getId("shanyan_privacy_text"));
              textView.setTextSize(a.a(this.a).getPrivacyTextSize());
              m.a(a.b(this.a), "shanyan_privacy_layout", a.f(this.a), 0);
              a.h(this.a).setOnClickListener(new View.OnClickListener(this) {
                    public void onClick(View param2View) {
                      a.g(this.a.a).performClick();
                    }
                  });
              b.a(a.b(this.a), textView, "中国移动认证服务条款", a.a(this.a).getClauseName(), a.a(this.a).getClauseNameTwo(), "http://wap.cmpassport.com/resources/html/contract.html", a.a(this.a).getClauseUrl(), a.a(this.a).getClauseUrlTwo(), a.a(this.a).getClauseColor(), a.a(this.a).getClauseBaseColor(), a.f(this.a), a.a(this.a).getPrivacyOffsetY(), a.a(this.a).getPrivacyOffsetBottomY(), a.a(this.a).getPrivacyOffsetX(), "CMCC");
            } 
          }
          
          public void onActivityDestroyed(Activity param1Activity) {
            L.d("ActivityLifecycleLogger", param1Activity + "onActivityDestroyed--->" + param1Activity.getLocalClassName());
            try {
              if (param1Activity instanceof com.sdk.mobile.manager.login.cucc.OauthActivity || param1Activity instanceof com.cmic.sso.sdk.activity.LoginAuthActivity || param1Activity instanceof com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity) {
                ((Application)a.b(this.a)).unregisterActivityLifecycleCallbacks(a.y(this.a));
                a.d(this.a, (CheckBox)null);
                a.a(this.a, (LoadingImageView)null);
                a.b(this.a, (ImageView)null);
                a.b(this.a, (View)null);
                a.d(this.a, (View)null);
                a.c(this.a, (View)null);
                a.a(this.a, (CheckBox)null);
                a.a(this.a, (RelativeLayout)null);
                if (AuthnHelper.getInstance(param1Activity.getApplicationContext()) != null && AuthnHelper.getInstance(param1Activity.getApplicationContext()).getAuthRegistViewConfigList() != null) {
                  AuthnHelper.getInstance(param1Activity.getApplicationContext()).getAuthRegistViewConfigList().clear();
                  if (a.a(this.a).getCustomViews() != null)
                    a.a(this.a).getCustomViews().clear(); 
                } 
              } 
              if (param1Activity instanceof com.sdk.mobile.manager.login.cucc.OauthActivity) {
                if (a.j(this.a) != null)
                  a.j(this.a).removeAllViews(); 
                if (a.z(this.a) != null)
                  a.z(this.a).removeAllViews(); 
                a.e(this.a, null);
                a.c(this.a, (RelativeLayout)null);
                a.a(this.a, (LinearLayout)null);
                a.b(this.a, (RelativeLayout)null);
                a.f(this.a, null);
                a.c(this.a, (CheckBox)null);
                a.a(this.a, (View)null);
                a.a(this.a, (Button)null);
                a.b(this.a, (Button)null);
                a.b(this.a, (CheckBox)null);
                a.a(this.a, (ImageView)null);
                a.d(this.a, (RelativeLayout)null);
              } 
              b.r = true;
            } catch (Exception exception) {
              b.r = true;
              exception.printStackTrace();
              L.d("ExceptionLogger", "onActivityDestroyed()Exception == " + exception.toString());
            } 
          }
          
          public void onActivityPaused(Activity param1Activity) {
            L.d("ActivityLifecycleLogger", param1Activity + "onActivityPaused--->" + param1Activity.getLocalClassName());
          }
          
          @SuppressLint({"ResourceType"})
          public void onActivityResumed(Activity param1Activity) {
            // Byte code:
            //   0: ldc 'ActivityLifecycleLogger'
            //   2: new java/lang/StringBuilder
            //   5: dup
            //   6: invokespecial <init> : ()V
            //   9: aload_1
            //   10: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //   13: ldc_w 'onActivityResumed--->'
            //   16: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   19: aload_1
            //   20: invokevirtual getLocalClassName : ()Ljava/lang/String;
            //   23: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   26: invokevirtual toString : ()Ljava/lang/String;
            //   29: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
            //   32: aload_1
            //   33: instanceof com/sdk/mobile/manager/login/cucc/OauthActivity
            //   36: ifne -> 46
            //   39: aload_1
            //   40: instanceof com/cmic/sso/sdk/activity/LoginAuthActivity
            //   43: ifeq -> 117
            //   46: iconst_1
            //   47: putstatic com/chuanglan/shanyan_sdk/b.q : Z
            //   50: aload_0
            //   51: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   54: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   57: invokevirtual isDialogTheme : ()Z
            //   60: ifeq -> 117
            //   63: aload_1
            //   64: aload_0
            //   65: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   68: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   71: invokevirtual getDialogWidth : ()I
            //   74: aload_0
            //   75: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   78: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   81: invokevirtual getDialogHeight : ()I
            //   84: aload_0
            //   85: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   88: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   91: invokevirtual getDialogX : ()I
            //   94: aload_0
            //   95: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   98: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   101: invokevirtual getDialogY : ()I
            //   104: aload_0
            //   105: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   108: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   111: invokevirtual isDialogBottom : ()Z
            //   114: invokestatic a : (Landroid/app/Activity;IIIIZ)V
            //   117: aload_1
            //   118: instanceof com/sdk/mobile/manager/login/cucc/OauthActivity
            //   121: ifeq -> 285
            //   124: aload_1
            //   125: invokevirtual getWindow : ()Landroid/view/Window;
            //   128: invokevirtual getDecorView : ()Landroid/view/View;
            //   131: invokestatic a : (Landroid/view/View;)Ljava/util/List;
            //   134: invokeinterface iterator : ()Ljava/util/Iterator;
            //   139: astore_2
            //   140: aload_2
            //   141: invokeinterface hasNext : ()Z
            //   146: ifeq -> 285
            //   149: aload_2
            //   150: invokeinterface next : ()Ljava/lang/Object;
            //   155: checkcast android/view/View
            //   158: astore_3
            //   159: aload_0
            //   160: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   163: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   166: invokestatic getInstance : (Landroid/content/Context;)Lcom/chuanglan/shanyan_sdk/utils/LCMResource;
            //   169: ldc_w 'sysdk_cucc_login_layout'
            //   172: invokevirtual getId : (Ljava/lang/String;)I
            //   175: aload_3
            //   176: invokevirtual getId : ()I
            //   179: if_icmpne -> 728
            //   182: aload_0
            //   183: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   186: aload_3
            //   187: checkcast android/widget/RelativeLayout
            //   190: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;Landroid/widget/RelativeLayout;)Landroid/widget/RelativeLayout;
            //   193: pop
            //   194: aload_0
            //   195: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   198: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   201: invokevirtual getAuthBGImgPath : ()Landroid/graphics/drawable/Drawable;
            //   204: ifnull -> 686
            //   207: aload_0
            //   208: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   211: invokestatic i : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/RelativeLayout;
            //   214: aload_0
            //   215: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   218: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   221: invokevirtual getAuthBGImgPath : ()Landroid/graphics/drawable/Drawable;
            //   224: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
            //   227: goto -> 140
            //   230: astore_2
            //   231: aload_2
            //   232: invokevirtual printStackTrace : ()V
            //   235: invokestatic a : ()Lcom/chuanglan/shanyan_sdk/tool/h;
            //   238: sipush #1014
            //   241: new java/lang/StringBuilder
            //   244: dup
            //   245: invokespecial <init> : ()V
            //   248: ldc_w 'onActivityResumed()'
            //   251: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   254: aload_2
            //   255: invokevirtual toString : ()Ljava/lang/String;
            //   258: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   261: invokevirtual toString : ()Ljava/lang/String;
            //   264: iconst_3
            //   265: ldc ''
            //   267: aload_2
            //   268: invokevirtual toString : ()Ljava/lang/String;
            //   271: invokestatic uptimeMillis : ()J
            //   274: getstatic com/chuanglan/shanyan_sdk/b.M : J
            //   277: lsub
            //   278: invokevirtual a : (ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;J)V
            //   281: aload_1
            //   282: invokevirtual finish : ()V
            //   285: aload_1
            //   286: instanceof com/cmic/sso/sdk/activity/LoginAuthActivity
            //   289: ifeq -> 685
            //   292: aload_1
            //   293: invokevirtual getWindow : ()Landroid/view/Window;
            //   296: invokevirtual getDecorView : ()Landroid/view/View;
            //   299: invokestatic a : (Landroid/view/View;)Ljava/util/List;
            //   302: astore_2
            //   303: iconst_0
            //   304: istore #4
            //   306: aload_2
            //   307: invokeinterface iterator : ()Ljava/util/Iterator;
            //   312: astore_3
            //   313: aload_3
            //   314: invokeinterface hasNext : ()Z
            //   319: ifeq -> 685
            //   322: aload_3
            //   323: invokeinterface next : ()Ljava/lang/Object;
            //   328: checkcast android/view/View
            //   331: astore_2
            //   332: aload_2
            //   333: instanceof android/widget/RelativeLayout
            //   336: ifeq -> 3376
            //   339: iload #4
            //   341: ifne -> 371
            //   344: aload_0
            //   345: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   348: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   351: invokevirtual getAuthBGImgPath : ()Landroid/graphics/drawable/Drawable;
            //   354: ifnull -> 2685
            //   357: aload_2
            //   358: aload_0
            //   359: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   362: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   365: invokevirtual getAuthBGImgPath : ()Landroid/graphics/drawable/Drawable;
            //   368: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
            //   371: iinc #4, 1
            //   374: aload_2
            //   375: instanceof android/widget/TextView
            //   378: ifeq -> 489
            //   381: aload_2
            //   382: checkcast android/widget/TextView
            //   385: astore #5
            //   387: ldc_w '中国移动提供认证服务'
            //   390: aload #5
            //   392: invokevirtual getText : ()Ljava/lang/CharSequence;
            //   395: invokevirtual contentEquals : (Ljava/lang/CharSequence;)Z
            //   398: ifeq -> 489
            //   401: aload #5
            //   403: invokevirtual getParent : ()Landroid/view/ViewParent;
            //   406: checkcast android/widget/RelativeLayout
            //   409: astore #6
            //   411: aload #5
            //   413: aload_0
            //   414: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   417: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   420: invokevirtual getSloganTextSize : ()I
            //   423: i2f
            //   424: invokevirtual setTextSize : (F)V
            //   427: aload_0
            //   428: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   431: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   434: aload #6
            //   436: aload_0
            //   437: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   440: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   443: invokevirtual getSloganOffsetX : ()I
            //   446: aload_0
            //   447: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   450: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   453: invokevirtual getSloganOffsetY : ()I
            //   456: aload_0
            //   457: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   460: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   463: invokevirtual getSloganOffsetBottomY : ()I
            //   466: invokestatic a : (Landroid/content/Context;Landroid/view/View;III)V
            //   469: aload_0
            //   470: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   473: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   476: invokevirtual isSloganHidden : ()Z
            //   479: ifeq -> 2721
            //   482: aload #6
            //   484: bipush #8
            //   486: invokevirtual setVisibility : (I)V
            //   489: aload_2
            //   490: invokevirtual getId : ()I
            //   493: sipush #26214
            //   496: if_icmpne -> 2730
            //   499: aload_0
            //   500: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   503: aload_2
            //   504: checkcast android/widget/ImageView
            //   507: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;Landroid/widget/ImageView;)Landroid/widget/ImageView;
            //   510: pop
            //   511: aload_0
            //   512: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   515: invokestatic e : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/ImageView;
            //   518: bipush #8
            //   520: invokevirtual setVisibility : (I)V
            //   523: aload_2
            //   524: invokevirtual getParent : ()Landroid/view/ViewParent;
            //   527: checkcast android/view/View
            //   530: invokestatic a : (Landroid/view/View;)Ljava/util/List;
            //   533: invokeinterface iterator : ()Ljava/util/Iterator;
            //   538: astore #5
            //   540: aload #5
            //   542: invokeinterface hasNext : ()Z
            //   547: ifeq -> 2730
            //   550: aload #5
            //   552: invokeinterface next : ()Ljava/lang/Object;
            //   557: checkcast android/view/View
            //   560: astore #6
            //   562: aload #6
            //   564: instanceof android/widget/TextView
            //   567: ifeq -> 540
            //   570: aload #6
            //   572: checkcast android/widget/TextView
            //   575: astore #6
            //   577: aload_0
            //   578: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   581: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   584: invokevirtual getNavText : ()Ljava/lang/String;
            //   587: ifnull -> 540
            //   590: aload_0
            //   591: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   594: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   597: invokevirtual getNavText : ()Ljava/lang/String;
            //   600: aload #6
            //   602: invokevirtual getText : ()Ljava/lang/CharSequence;
            //   605: invokevirtual contentEquals : (Ljava/lang/CharSequence;)Z
            //   608: ifeq -> 540
            //   611: aload #6
            //   613: aload_0
            //   614: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   617: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   620: invokevirtual getNavTextSize : ()I
            //   623: i2f
            //   624: invokevirtual setTextSize : (F)V
            //   627: goto -> 540
            //   630: astore_2
            //   631: aload_2
            //   632: invokevirtual printStackTrace : ()V
            //   635: invokestatic a : ()Lcom/chuanglan/shanyan_sdk/tool/h;
            //   638: sipush #1014
            //   641: new java/lang/StringBuilder
            //   644: dup
            //   645: invokespecial <init> : ()V
            //   648: ldc_w 'onActivityResumed()'
            //   651: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   654: aload_2
            //   655: invokevirtual toString : ()Ljava/lang/String;
            //   658: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   661: invokevirtual toString : ()Ljava/lang/String;
            //   664: iconst_3
            //   665: ldc ''
            //   667: aload_2
            //   668: invokevirtual toString : ()Ljava/lang/String;
            //   671: invokestatic uptimeMillis : ()J
            //   674: getstatic com/chuanglan/shanyan_sdk/b.M : J
            //   677: lsub
            //   678: invokevirtual a : (ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;J)V
            //   681: aload_1
            //   682: invokevirtual finish : ()V
            //   685: return
            //   686: aload_0
            //   687: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   690: invokestatic i : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/RelativeLayout;
            //   693: aload_0
            //   694: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   697: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   700: invokevirtual getResources : ()Landroid/content/res/Resources;
            //   703: ldc_w 'authbackground_image'
            //   706: ldc_w 'drawable'
            //   709: aload_0
            //   710: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   713: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   716: invokevirtual getPackageName : ()Ljava/lang/String;
            //   719: invokevirtual getIdentifier : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
            //   722: invokevirtual setBackgroundResource : (I)V
            //   725: goto -> 140
            //   728: aload_0
            //   729: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   732: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   735: invokestatic getInstance : (Landroid/content/Context;)Lcom/chuanglan/shanyan_sdk/utils/LCMResource;
            //   738: ldc_w 'shanyan_navigationbar_include'
            //   741: invokevirtual getId : (Ljava/lang/String;)I
            //   744: aload_3
            //   745: invokevirtual getId : ()I
            //   748: if_icmpne -> 840
            //   751: aload_0
            //   752: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   755: aload_3
            //   756: checkcast android/widget/RelativeLayout
            //   759: invokestatic c : (Lcom/chuanglan/shanyan_sdk/tool/a;Landroid/widget/RelativeLayout;)Landroid/widget/RelativeLayout;
            //   762: pop
            //   763: aload_0
            //   764: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   767: invokestatic j : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/RelativeLayout;
            //   770: aload_0
            //   771: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   774: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   777: invokevirtual getNavColor : ()I
            //   780: invokevirtual setBackgroundColor : (I)V
            //   783: aload_0
            //   784: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   787: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   790: invokevirtual isAuthNavTransparent : ()Z
            //   793: ifeq -> 810
            //   796: aload_0
            //   797: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   800: invokestatic j : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/RelativeLayout;
            //   803: invokevirtual getBackground : ()Landroid/graphics/drawable/Drawable;
            //   806: iconst_0
            //   807: invokevirtual setAlpha : (I)V
            //   810: aload_0
            //   811: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   814: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   817: invokevirtual isAuthNavHidden : ()Z
            //   820: ifeq -> 832
            //   823: aload_3
            //   824: bipush #8
            //   826: invokevirtual setVisibility : (I)V
            //   829: goto -> 140
            //   832: aload_3
            //   833: iconst_0
            //   834: invokevirtual setVisibility : (I)V
            //   837: goto -> 140
            //   840: aload_0
            //   841: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   844: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   847: invokestatic getInstance : (Landroid/content/Context;)Lcom/chuanglan/shanyan_sdk/utils/LCMResource;
            //   850: ldc_w 'shanyan_navigationbar_title'
            //   853: invokevirtual getId : (Ljava/lang/String;)I
            //   856: aload_3
            //   857: invokevirtual getId : ()I
            //   860: if_icmpne -> 914
            //   863: aload_3
            //   864: checkcast android/widget/TextView
            //   867: astore_3
            //   868: aload_3
            //   869: aload_0
            //   870: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   873: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   876: invokevirtual getNavText : ()Ljava/lang/String;
            //   879: invokevirtual setText : (Ljava/lang/CharSequence;)V
            //   882: aload_3
            //   883: aload_0
            //   884: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   887: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   890: invokevirtual getNavTextColor : ()I
            //   893: invokevirtual setTextColor : (I)V
            //   896: aload_3
            //   897: aload_0
            //   898: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   901: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   904: invokevirtual getNavTextSize : ()I
            //   907: i2f
            //   908: invokevirtual setTextSize : (F)V
            //   911: goto -> 140
            //   914: aload_0
            //   915: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   918: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   921: invokestatic getInstance : (Landroid/content/Context;)Lcom/chuanglan/shanyan_sdk/utils/LCMResource;
            //   924: ldc_w 'oauth_back'
            //   927: invokevirtual getId : (Ljava/lang/String;)I
            //   930: aload_3
            //   931: invokevirtual getId : ()I
            //   934: if_icmpne -> 952
            //   937: aload_0
            //   938: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   941: aload_3
            //   942: checkcast android/widget/Button
            //   945: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;Landroid/widget/Button;)Landroid/widget/Button;
            //   948: pop
            //   949: goto -> 140
            //   952: aload_0
            //   953: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   956: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   959: invokestatic getInstance : (Landroid/content/Context;)Lcom/chuanglan/shanyan_sdk/utils/LCMResource;
            //   962: ldc_w 'shanyan_navigationbar_back'
            //   965: invokevirtual getId : (Ljava/lang/String;)I
            //   968: aload_3
            //   969: invokevirtual getId : ()I
            //   972: if_icmpne -> 1097
            //   975: aload_0
            //   976: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   979: aload_3
            //   980: checkcast android/widget/ImageView
            //   983: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;Landroid/widget/ImageView;)Landroid/widget/ImageView;
            //   986: pop
            //   987: aload_0
            //   988: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   991: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   994: invokevirtual getNavReturnImgPath : ()Landroid/graphics/drawable/Drawable;
            //   997: ifnull -> 1020
            //   1000: aload_0
            //   1001: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1004: invokestatic k : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/ImageView;
            //   1007: aload_0
            //   1008: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1011: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1014: invokevirtual getNavReturnImgPath : ()Landroid/graphics/drawable/Drawable;
            //   1017: invokevirtual setImageDrawable : (Landroid/graphics/drawable/Drawable;)V
            //   1020: aload_0
            //   1021: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1024: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   1027: aload_0
            //   1028: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1031: invokestatic l : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/RelativeLayout;
            //   1034: aload_0
            //   1035: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1038: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1041: invokevirtual getNavReturnBtnOffsetX : ()I
            //   1044: aload_0
            //   1045: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1048: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1051: invokevirtual getNavReturnBtnOffsetY : ()I
            //   1054: aload_0
            //   1055: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1058: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1061: invokevirtual getNavReturnBtnOffsetRightX : ()I
            //   1064: aload_0
            //   1065: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1068: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1071: invokevirtual getReturnBtnWidth : ()I
            //   1074: aload_0
            //   1075: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1078: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1081: invokevirtual getReturnBtnHeight : ()I
            //   1084: aload_0
            //   1085: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1088: invokestatic k : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/ImageView;
            //   1091: invokestatic a : (Landroid/content/Context;Landroid/view/View;IIIIILandroid/widget/ImageView;)V
            //   1094: goto -> 140
            //   1097: aload_0
            //   1098: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1101: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   1104: invokestatic getInstance : (Landroid/content/Context;)Lcom/chuanglan/shanyan_sdk/utils/LCMResource;
            //   1107: ldc_w 'shanyan_navigationbar_back_root'
            //   1110: invokevirtual getId : (Ljava/lang/String;)I
            //   1113: aload_3
            //   1114: invokevirtual getId : ()I
            //   1117: if_icmpne -> 1199
            //   1120: aload_0
            //   1121: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1124: aload_3
            //   1125: checkcast android/widget/RelativeLayout
            //   1128: invokestatic d : (Lcom/chuanglan/shanyan_sdk/tool/a;Landroid/widget/RelativeLayout;)Landroid/widget/RelativeLayout;
            //   1131: pop
            //   1132: aload_0
            //   1133: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1136: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1139: invokevirtual isNavReturnImgHidden : ()Z
            //   1142: ifeq -> 1160
            //   1145: aload_0
            //   1146: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1149: invokestatic l : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/RelativeLayout;
            //   1152: bipush #8
            //   1154: invokevirtual setVisibility : (I)V
            //   1157: goto -> 140
            //   1160: aload_0
            //   1161: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1164: invokestatic l : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/RelativeLayout;
            //   1167: iconst_0
            //   1168: invokevirtual setVisibility : (I)V
            //   1171: aload_0
            //   1172: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1175: invokestatic l : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/RelativeLayout;
            //   1178: astore_3
            //   1179: new com/chuanglan/shanyan_sdk/tool/a$1$3
            //   1182: astore #5
            //   1184: aload #5
            //   1186: aload_0
            //   1187: invokespecial <init> : (Lcom/chuanglan/shanyan_sdk/tool/a$1;)V
            //   1190: aload_3
            //   1191: aload #5
            //   1193: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
            //   1196: goto -> 140
            //   1199: aload_0
            //   1200: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1203: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   1206: invokestatic getInstance : (Landroid/content/Context;)Lcom/chuanglan/shanyan_sdk/utils/LCMResource;
            //   1209: ldc_w 'oauth_logo'
            //   1212: invokevirtual getId : (Ljava/lang/String;)I
            //   1215: aload_3
            //   1216: invokevirtual getId : ()I
            //   1219: if_icmpne -> 1345
            //   1222: aload_3
            //   1223: checkcast android/widget/ImageView
            //   1226: astore_3
            //   1227: aload_0
            //   1228: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1231: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1234: invokevirtual getLogoImgPath : ()Landroid/graphics/drawable/Drawable;
            //   1237: ifnull -> 1254
            //   1240: aload_3
            //   1241: aload_0
            //   1242: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1245: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1248: invokevirtual getLogoImgPath : ()Landroid/graphics/drawable/Drawable;
            //   1251: invokevirtual setImageDrawable : (Landroid/graphics/drawable/Drawable;)V
            //   1254: aload_0
            //   1255: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1258: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   1261: aload_3
            //   1262: aload_0
            //   1263: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1266: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1269: invokevirtual getLogoOffsetX : ()I
            //   1272: aload_0
            //   1273: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1276: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1279: invokevirtual getLogoOffsetY : ()I
            //   1282: aload_0
            //   1283: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1286: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1289: invokevirtual getLogoOffsetBottomY : ()I
            //   1292: aload_0
            //   1293: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1296: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1299: invokevirtual getLogoWidth : ()I
            //   1302: aload_0
            //   1303: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1306: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1309: invokevirtual getLogoHeight : ()I
            //   1312: invokestatic b : (Landroid/content/Context;Landroid/view/View;IIIII)V
            //   1315: aload_0
            //   1316: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1319: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1322: invokevirtual isLogoHidden : ()Z
            //   1325: ifeq -> 1337
            //   1328: aload_3
            //   1329: bipush #8
            //   1331: invokevirtual setVisibility : (I)V
            //   1334: goto -> 140
            //   1337: aload_3
            //   1338: iconst_0
            //   1339: invokevirtual setVisibility : (I)V
            //   1342: goto -> 140
            //   1345: aload_0
            //   1346: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1349: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   1352: invokestatic getInstance : (Landroid/content/Context;)Lcom/chuanglan/shanyan_sdk/utils/LCMResource;
            //   1355: ldc_w 'oauth_mobile_et'
            //   1358: invokevirtual getId : (Ljava/lang/String;)I
            //   1361: aload_3
            //   1362: invokevirtual getId : ()I
            //   1365: if_icmpne -> 1466
            //   1368: aload_3
            //   1369: checkcast android/widget/EditText
            //   1372: astore_3
            //   1373: aload_3
            //   1374: aload_0
            //   1375: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1378: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1381: invokevirtual getNumberColor : ()I
            //   1384: invokevirtual setTextColor : (I)V
            //   1387: aload_3
            //   1388: aload_0
            //   1389: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1392: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1395: invokevirtual getNumberSize : ()I
            //   1398: i2f
            //   1399: invokevirtual setTextSize : (F)V
            //   1402: aload_0
            //   1403: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1406: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   1409: aload_3
            //   1410: aload_0
            //   1411: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1414: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1417: invokevirtual getNumFieldOffsetX : ()I
            //   1420: aload_0
            //   1421: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1424: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1427: invokevirtual getNumFieldOffsetY : ()I
            //   1430: aload_0
            //   1431: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1434: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1437: invokevirtual getNumFieldOffsetBottomY : ()I
            //   1440: aload_0
            //   1441: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1444: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1447: invokevirtual getNumFieldWidth : ()I
            //   1450: aload_0
            //   1451: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1454: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1457: invokevirtual getNumFieldHeight : ()I
            //   1460: invokestatic b : (Landroid/content/Context;Landroid/view/View;IIIII)V
            //   1463: goto -> 140
            //   1466: aload_0
            //   1467: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1470: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   1473: invokestatic getInstance : (Landroid/content/Context;)Lcom/chuanglan/shanyan_sdk/utils/LCMResource;
            //   1476: ldc_w 'oauth_login'
            //   1479: invokevirtual getId : (Ljava/lang/String;)I
            //   1482: aload_3
            //   1483: invokevirtual getId : ()I
            //   1486: if_icmpne -> 1676
            //   1489: aload_0
            //   1490: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1493: aload_3
            //   1494: checkcast android/widget/Button
            //   1497: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;Landroid/widget/Button;)Landroid/widget/Button;
            //   1500: pop
            //   1501: aload_0
            //   1502: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1505: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1508: invokevirtual getLogBtnBackgroundPath : ()Landroid/graphics/drawable/Drawable;
            //   1511: ifnull -> 1534
            //   1514: aload_0
            //   1515: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1518: invokestatic n : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/Button;
            //   1521: aload_0
            //   1522: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1525: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1528: invokevirtual getLogBtnBackgroundPath : ()Landroid/graphics/drawable/Drawable;
            //   1531: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
            //   1534: aload_0
            //   1535: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1538: invokestatic n : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/Button;
            //   1541: aload_0
            //   1542: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1545: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1548: invokevirtual getLogBtnText : ()Ljava/lang/String;
            //   1551: invokevirtual setText : (Ljava/lang/CharSequence;)V
            //   1554: aload_0
            //   1555: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1558: invokestatic n : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/Button;
            //   1561: aload_0
            //   1562: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1565: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1568: invokevirtual getLogBtnTextColor : ()I
            //   1571: invokevirtual setTextColor : (I)V
            //   1574: aload_0
            //   1575: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1578: invokestatic n : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/Button;
            //   1581: aload_0
            //   1582: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1585: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1588: invokevirtual getLogBtnTextSize : ()I
            //   1591: i2f
            //   1592: invokevirtual setTextSize : (F)V
            //   1595: aload_0
            //   1596: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1599: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   1602: aload_0
            //   1603: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1606: invokestatic n : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/Button;
            //   1609: aload_0
            //   1610: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1613: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1616: invokevirtual getLogBtnOffsetX : ()I
            //   1619: aload_0
            //   1620: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1623: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1626: invokevirtual getLogBtnOffsetY : ()I
            //   1629: aload_0
            //   1630: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1633: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1636: invokevirtual getLogBtnOffsetBottomY : ()I
            //   1639: aload_0
            //   1640: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1643: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1646: invokevirtual getLogBtnWidth : ()I
            //   1649: aload_0
            //   1650: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1653: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1656: invokevirtual getLogBtnHeight : ()I
            //   1659: invokestatic a : (Landroid/content/Context;Landroid/view/View;IIIII)V
            //   1662: aload_0
            //   1663: aload_0
            //   1664: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1667: invokestatic n : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/Button;
            //   1670: invokevirtual a : (Landroid/view/View;)V
            //   1673: goto -> 140
            //   1676: aload_0
            //   1677: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1680: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   1683: invokestatic getInstance : (Landroid/content/Context;)Lcom/chuanglan/shanyan_sdk/utils/LCMResource;
            //   1686: ldc_w 'brand'
            //   1689: invokevirtual getId : (Ljava/lang/String;)I
            //   1692: aload_3
            //   1693: invokevirtual getId : ()I
            //   1696: if_icmpne -> 1804
            //   1699: aload_3
            //   1700: checkcast android/widget/TextView
            //   1703: astore_3
            //   1704: aload_3
            //   1705: aload_0
            //   1706: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1709: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1712: invokevirtual getSloganTextColor : ()I
            //   1715: invokevirtual setTextColor : (I)V
            //   1718: aload_3
            //   1719: aload_0
            //   1720: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1723: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1726: invokevirtual getSloganTextSize : ()I
            //   1729: i2f
            //   1730: invokevirtual setTextSize : (F)V
            //   1733: aload_0
            //   1734: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1737: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   1740: aload_3
            //   1741: aload_0
            //   1742: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1745: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1748: invokevirtual getSloganOffsetX : ()I
            //   1751: aload_0
            //   1752: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1755: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1758: invokevirtual getSloganOffsetY : ()I
            //   1761: aload_0
            //   1762: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1765: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1768: invokevirtual getSloganOffsetBottomY : ()I
            //   1771: invokestatic a : (Landroid/content/Context;Landroid/view/View;III)V
            //   1774: aload_0
            //   1775: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1778: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   1781: invokevirtual isSloganHidden : ()Z
            //   1784: ifeq -> 1796
            //   1787: aload_3
            //   1788: bipush #8
            //   1790: invokevirtual setVisibility : (I)V
            //   1793: goto -> 140
            //   1796: aload_3
            //   1797: iconst_0
            //   1798: invokevirtual setVisibility : (I)V
            //   1801: goto -> 140
            //   1804: aload_0
            //   1805: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1808: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   1811: invokestatic getInstance : (Landroid/content/Context;)Lcom/chuanglan/shanyan_sdk/utils/LCMResource;
            //   1814: ldc_w 'protocol'
            //   1817: invokevirtual getId : (Ljava/lang/String;)I
            //   1820: aload_3
            //   1821: invokevirtual getId : ()I
            //   1824: if_icmpne -> 1842
            //   1827: aload_0
            //   1828: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1831: aload_3
            //   1832: checkcast android/widget/LinearLayout
            //   1835: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;Landroid/widget/LinearLayout;)Landroid/widget/LinearLayout;
            //   1838: pop
            //   1839: goto -> 140
            //   1842: aload_0
            //   1843: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1846: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   1849: invokestatic getInstance : (Landroid/content/Context;)Lcom/chuanglan/shanyan_sdk/utils/LCMResource;
            //   1852: ldc_w 'is_agree'
            //   1855: invokevirtual getId : (Ljava/lang/String;)I
            //   1858: aload_3
            //   1859: invokevirtual getId : ()I
            //   1862: if_icmpne -> 1917
            //   1865: aload_0
            //   1866: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1869: aload_3
            //   1870: checkcast android/widget/CheckBox
            //   1873: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;Landroid/widget/CheckBox;)Landroid/widget/CheckBox;
            //   1876: pop
            //   1877: aload_0
            //   1878: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1881: invokestatic o : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   1884: bipush #8
            //   1886: invokevirtual setVisibility : (I)V
            //   1889: aload_0
            //   1890: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1893: invokestatic o : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   1896: astore_3
            //   1897: new com/chuanglan/shanyan_sdk/tool/a$1$4
            //   1900: astore #5
            //   1902: aload #5
            //   1904: aload_0
            //   1905: invokespecial <init> : (Lcom/chuanglan/shanyan_sdk/tool/a$1;)V
            //   1908: aload_3
            //   1909: aload #5
            //   1911: invokevirtual setOnCheckedChangeListener : (Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
            //   1914: goto -> 140
            //   1917: aload_0
            //   1918: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1921: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   1924: invokestatic getInstance : (Landroid/content/Context;)Lcom/chuanglan/shanyan_sdk/utils/LCMResource;
            //   1927: ldc_w 'shanyan_privacy_checkbox'
            //   1930: invokevirtual getId : (Ljava/lang/String;)I
            //   1933: aload_3
            //   1934: invokevirtual getId : ()I
            //   1937: if_icmpne -> 2317
            //   1940: aload_0
            //   1941: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1944: aload_3
            //   1945: checkcast android/widget/CheckBox
            //   1948: invokestatic c : (Lcom/chuanglan/shanyan_sdk/tool/a;Landroid/widget/CheckBox;)Landroid/widget/CheckBox;
            //   1951: pop
            //   1952: aload_0
            //   1953: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1956: invokestatic p : (Lcom/chuanglan/shanyan_sdk/tool/a;)Ljava/lang/Boolean;
            //   1959: invokevirtual booleanValue : ()Z
            //   1962: ifeq -> 2128
            //   1965: aload_0
            //   1966: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1969: invokestatic q : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   1972: bipush #8
            //   1974: invokevirtual setVisibility : (I)V
            //   1977: aload_0
            //   1978: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1981: invokestatic q : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   1984: iconst_1
            //   1985: invokevirtual setChecked : (Z)V
            //   1988: aload_0
            //   1989: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   1992: invokestatic o : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   1995: iconst_1
            //   1996: invokevirtual setChecked : (Z)V
            //   1999: aload_0
            //   2000: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2003: invokestatic r : (Lcom/chuanglan/shanyan_sdk/tool/a;)Ljava/lang/Boolean;
            //   2006: invokevirtual booleanValue : ()Z
            //   2009: ifeq -> 2184
            //   2012: aload_0
            //   2013: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2016: invokestatic q : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   2019: iconst_1
            //   2020: invokevirtual setChecked : (Z)V
            //   2023: aload_0
            //   2024: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2027: invokestatic o : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   2030: iconst_1
            //   2031: invokevirtual setChecked : (Z)V
            //   2034: aload_0
            //   2035: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2038: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2041: invokevirtual getCheckedImgPath : ()Landroid/graphics/drawable/Drawable;
            //   2044: ifnull -> 2142
            //   2047: aload_0
            //   2048: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2051: invokestatic q : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   2054: aload_0
            //   2055: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2058: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2061: invokevirtual getCheckedImgPath : ()Landroid/graphics/drawable/Drawable;
            //   2064: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
            //   2067: aload_0
            //   2068: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2071: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2074: invokevirtual getLogBtnBackgroundPath : ()Landroid/graphics/drawable/Drawable;
            //   2077: ifnull -> 2100
            //   2080: aload_0
            //   2081: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2084: invokestatic n : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/Button;
            //   2087: aload_0
            //   2088: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2091: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2094: invokevirtual getLogBtnBackgroundPath : ()Landroid/graphics/drawable/Drawable;
            //   2097: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
            //   2100: aload_0
            //   2101: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2104: invokestatic q : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   2107: astore_3
            //   2108: new com/chuanglan/shanyan_sdk/tool/a$1$5
            //   2111: astore #5
            //   2113: aload #5
            //   2115: aload_0
            //   2116: invokespecial <init> : (Lcom/chuanglan/shanyan_sdk/tool/a$1;)V
            //   2119: aload_3
            //   2120: aload #5
            //   2122: invokevirtual setOnCheckedChangeListener : (Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
            //   2125: goto -> 140
            //   2128: aload_0
            //   2129: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2132: invokestatic q : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   2135: iconst_0
            //   2136: invokevirtual setVisibility : (I)V
            //   2139: goto -> 1999
            //   2142: aload_0
            //   2143: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2146: invokestatic q : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   2149: aload_0
            //   2150: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2153: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   2156: invokevirtual getResources : ()Landroid/content/res/Resources;
            //   2159: ldc_w 'umcsdk_check_image'
            //   2162: ldc_w 'drawable'
            //   2165: aload_0
            //   2166: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2169: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   2172: invokevirtual getPackageName : ()Ljava/lang/String;
            //   2175: invokevirtual getIdentifier : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
            //   2178: invokevirtual setBackgroundResource : (I)V
            //   2181: goto -> 2067
            //   2184: aload_0
            //   2185: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2188: invokestatic q : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   2191: iconst_0
            //   2192: invokevirtual setChecked : (Z)V
            //   2195: aload_0
            //   2196: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2199: invokestatic o : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   2202: iconst_0
            //   2203: invokevirtual setChecked : (Z)V
            //   2206: aload_0
            //   2207: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2210: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2213: invokevirtual getUncheckedImgPath : ()Landroid/graphics/drawable/Drawable;
            //   2216: ifnull -> 2275
            //   2219: aload_0
            //   2220: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2223: invokestatic q : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   2226: aload_0
            //   2227: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2230: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2233: invokevirtual getUncheckedImgPath : ()Landroid/graphics/drawable/Drawable;
            //   2236: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
            //   2239: aload_0
            //   2240: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2243: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2246: invokevirtual getLogBtnBackgroundPath : ()Landroid/graphics/drawable/Drawable;
            //   2249: ifnull -> 2100
            //   2252: aload_0
            //   2253: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2256: invokestatic n : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/Button;
            //   2259: aload_0
            //   2260: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2263: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2266: invokevirtual getLogBtnBackgroundPath : ()Landroid/graphics/drawable/Drawable;
            //   2269: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
            //   2272: goto -> 2100
            //   2275: aload_0
            //   2276: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2279: invokestatic q : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   2282: aload_0
            //   2283: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2286: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   2289: invokevirtual getResources : ()Landroid/content/res/Resources;
            //   2292: ldc_w 'umcsdk_uncheck_image'
            //   2295: ldc_w 'drawable'
            //   2298: aload_0
            //   2299: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2302: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   2305: invokevirtual getPackageName : ()Ljava/lang/String;
            //   2308: invokevirtual getIdentifier : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
            //   2311: invokevirtual setBackgroundResource : (I)V
            //   2314: goto -> 2239
            //   2317: aload_0
            //   2318: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2321: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   2324: invokestatic getInstance : (Landroid/content/Context;)Lcom/chuanglan/shanyan_sdk/utils/LCMResource;
            //   2327: ldc_w 'shanyan_privacy_text'
            //   2330: invokevirtual getId : (Ljava/lang/String;)I
            //   2333: aload_3
            //   2334: invokevirtual getId : ()I
            //   2337: if_icmpne -> 2480
            //   2340: aload_3
            //   2341: checkcast android/widget/TextView
            //   2344: astore_3
            //   2345: aload_3
            //   2346: aload_0
            //   2347: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2350: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2353: invokevirtual getPrivacyTextSize : ()I
            //   2356: i2f
            //   2357: invokevirtual setTextSize : (F)V
            //   2360: aload_0
            //   2361: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2364: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   2367: aload_3
            //   2368: ldc_w '中国联通认证服务协议'
            //   2371: aload_0
            //   2372: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2375: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2378: invokevirtual getClauseName : ()Ljava/lang/String;
            //   2381: aload_0
            //   2382: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2385: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2388: invokevirtual getClauseNameTwo : ()Ljava/lang/String;
            //   2391: ldc_w 'https://ms.zzx9.cn/html/oauth/protocol.html'
            //   2394: aload_0
            //   2395: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2398: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2401: invokevirtual getClauseUrl : ()Ljava/lang/String;
            //   2404: aload_0
            //   2405: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2408: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2411: invokevirtual getClauseUrlTwo : ()Ljava/lang/String;
            //   2414: aload_0
            //   2415: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2418: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2421: invokevirtual getClauseColor : ()I
            //   2424: aload_0
            //   2425: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2428: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2431: invokevirtual getClauseBaseColor : ()I
            //   2434: aload_0
            //   2435: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2438: invokestatic s : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/LinearLayout;
            //   2441: aload_0
            //   2442: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2445: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2448: invokevirtual getPrivacyOffsetY : ()I
            //   2451: aload_0
            //   2452: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2455: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2458: invokevirtual getPrivacyOffsetBottomY : ()I
            //   2461: aload_0
            //   2462: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2465: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2468: invokevirtual getPrivacyOffsetX : ()I
            //   2471: ldc_w 'CUCC'
            //   2474: invokestatic a : (Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILandroid/view/View;IIILjava/lang/String;)V
            //   2477: goto -> 140
            //   2480: aload_0
            //   2481: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2484: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   2487: invokestatic getInstance : (Landroid/content/Context;)Lcom/chuanglan/shanyan_sdk/utils/LCMResource;
            //   2490: ldc_w 'sy_cucc_boby'
            //   2493: invokevirtual getId : (Ljava/lang/String;)I
            //   2496: aload_3
            //   2497: invokevirtual getId : ()I
            //   2500: if_icmpne -> 2525
            //   2503: aload_0
            //   2504: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2507: aload_3
            //   2508: checkcast android/widget/RelativeLayout
            //   2511: invokestatic e : (Lcom/chuanglan/shanyan_sdk/tool/a;Landroid/widget/RelativeLayout;)Landroid/widget/RelativeLayout;
            //   2514: pop
            //   2515: aload_0
            //   2516: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2519: invokestatic t : (Lcom/chuanglan/shanyan_sdk/tool/a;)V
            //   2522: goto -> 140
            //   2525: aload_0
            //   2526: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2529: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   2532: invokestatic getInstance : (Landroid/content/Context;)Lcom/chuanglan/shanyan_sdk/utils/LCMResource;
            //   2535: ldc_w 'shanyan_privacy_checkbox_rootlayout'
            //   2538: invokevirtual getId : (Ljava/lang/String;)I
            //   2541: aload_3
            //   2542: invokevirtual getId : ()I
            //   2545: if_icmpne -> 2626
            //   2548: aload_0
            //   2549: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2552: aload_3
            //   2553: checkcast android/widget/RelativeLayout
            //   2556: invokestatic f : (Lcom/chuanglan/shanyan_sdk/tool/a;Landroid/widget/RelativeLayout;)Landroid/widget/RelativeLayout;
            //   2559: pop
            //   2560: aload_0
            //   2561: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2564: invokestatic p : (Lcom/chuanglan/shanyan_sdk/tool/a;)Ljava/lang/Boolean;
            //   2567: invokevirtual booleanValue : ()Z
            //   2570: ifeq -> 2612
            //   2573: aload_0
            //   2574: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2577: invokestatic u : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/RelativeLayout;
            //   2580: bipush #8
            //   2582: invokevirtual setVisibility : (I)V
            //   2585: aload_0
            //   2586: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2589: invokestatic u : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/RelativeLayout;
            //   2592: astore #5
            //   2594: new com/chuanglan/shanyan_sdk/tool/a$1$6
            //   2597: astore_3
            //   2598: aload_3
            //   2599: aload_0
            //   2600: invokespecial <init> : (Lcom/chuanglan/shanyan_sdk/tool/a$1;)V
            //   2603: aload #5
            //   2605: aload_3
            //   2606: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
            //   2609: goto -> 140
            //   2612: aload_0
            //   2613: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2616: invokestatic u : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/RelativeLayout;
            //   2619: iconst_0
            //   2620: invokevirtual setVisibility : (I)V
            //   2623: goto -> 2585
            //   2626: aload_0
            //   2627: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2630: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   2633: invokestatic getInstance : (Landroid/content/Context;)Lcom/chuanglan/shanyan_sdk/utils/LCMResource;
            //   2636: ldc_w 'shanyan_onkeylogin_loading'
            //   2639: invokevirtual getId : (Ljava/lang/String;)I
            //   2642: aload_3
            //   2643: invokevirtual getId : ()I
            //   2646: if_icmpne -> 140
            //   2649: aload_0
            //   2650: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2653: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2656: invokevirtual getLoadingView : ()Landroid/view/View;
            //   2659: ifnonnull -> 140
            //   2662: aload_0
            //   2663: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2666: aload_3
            //   2667: invokestatic d : (Lcom/chuanglan/shanyan_sdk/tool/a;Landroid/view/View;)Landroid/view/View;
            //   2670: pop
            //   2671: aload_0
            //   2672: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2675: invokestatic v : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/view/View;
            //   2678: aconst_null
            //   2679: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
            //   2682: goto -> 140
            //   2685: aload_2
            //   2686: aload_0
            //   2687: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2690: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   2693: invokevirtual getResources : ()Landroid/content/res/Resources;
            //   2696: ldc_w 'authbackground_image'
            //   2699: ldc_w 'drawable'
            //   2702: aload_0
            //   2703: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2706: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   2709: invokevirtual getPackageName : ()Ljava/lang/String;
            //   2712: invokevirtual getIdentifier : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
            //   2715: invokevirtual setBackgroundResource : (I)V
            //   2718: goto -> 371
            //   2721: aload #6
            //   2723: iconst_0
            //   2724: invokevirtual setVisibility : (I)V
            //   2727: goto -> 489
            //   2730: aload_2
            //   2731: invokevirtual getId : ()I
            //   2734: sipush #4369
            //   2737: if_icmpne -> 2759
            //   2740: aload_0
            //   2741: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2744: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2747: invokevirtual isAuthNavHidden : ()Z
            //   2750: ifeq -> 3095
            //   2753: aload_2
            //   2754: bipush #8
            //   2756: invokevirtual setVisibility : (I)V
            //   2759: aload_2
            //   2760: instanceof com/cmic/sso/sdk/widget/LoadingImageView
            //   2763: ifeq -> 2784
            //   2766: aload_0
            //   2767: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2770: aload_2
            //   2771: checkcast com/cmic/sso/sdk/widget/LoadingImageView
            //   2774: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;Lcom/cmic/sso/sdk/widget/LoadingImageView;)Lcom/cmic/sso/sdk/widget/LoadingImageView;
            //   2777: pop
            //   2778: aload_2
            //   2779: bipush #8
            //   2781: invokevirtual setVisibility : (I)V
            //   2784: aload_2
            //   2785: invokevirtual getId : ()I
            //   2788: sipush #13107
            //   2791: if_icmpne -> 2855
            //   2794: aload_0
            //   2795: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2798: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   2801: aload_2
            //   2802: aload_0
            //   2803: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2806: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2809: invokevirtual getNumFieldOffsetX : ()I
            //   2812: aload_0
            //   2813: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2816: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2819: invokevirtual getNumFieldOffsetY : ()I
            //   2822: aload_0
            //   2823: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2826: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2829: invokevirtual getNumFieldOffsetBottomY : ()I
            //   2832: aload_0
            //   2833: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2836: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2839: invokevirtual getNumFieldWidth : ()I
            //   2842: aload_0
            //   2843: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2846: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2849: invokevirtual getNumFieldHeight : ()I
            //   2852: invokestatic b : (Landroid/content/Context;Landroid/view/View;IIIII)V
            //   2855: aload_2
            //   2856: instanceof android/widget/CheckBox
            //   2859: ifeq -> 2929
            //   2862: aload_2
            //   2863: invokevirtual getParent : ()Landroid/view/ViewParent;
            //   2866: invokeinterface getParent : ()Landroid/view/ViewParent;
            //   2871: checkcast android/view/View
            //   2874: astore #5
            //   2876: aload #5
            //   2878: invokevirtual getId : ()I
            //   2881: iconst_m1
            //   2882: if_icmpne -> 2892
            //   2885: aload #5
            //   2887: bipush #8
            //   2889: invokevirtual setVisibility : (I)V
            //   2892: aload_0
            //   2893: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2896: aload_2
            //   2897: checkcast android/widget/CheckBox
            //   2900: invokestatic d : (Lcom/chuanglan/shanyan_sdk/tool/a;Landroid/widget/CheckBox;)Landroid/widget/CheckBox;
            //   2903: pop
            //   2904: aload_0
            //   2905: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2908: invokestatic p : (Lcom/chuanglan/shanyan_sdk/tool/a;)Ljava/lang/Boolean;
            //   2911: invokevirtual booleanValue : ()Z
            //   2914: ifeq -> 3103
            //   2917: aload_0
            //   2918: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2921: invokestatic h : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/RelativeLayout;
            //   2924: bipush #8
            //   2926: invokevirtual setVisibility : (I)V
            //   2929: aload_2
            //   2930: invokevirtual getId : ()I
            //   2933: sipush #17476
            //   2936: if_icmpne -> 3354
            //   2939: aload_0
            //   2940: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2943: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2946: invokevirtual getLogBtnBackgroundPath : ()Landroid/graphics/drawable/Drawable;
            //   2949: ifnull -> 2966
            //   2952: aload_2
            //   2953: aload_0
            //   2954: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2957: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2960: invokevirtual getLogBtnBackgroundPath : ()Landroid/graphics/drawable/Drawable;
            //   2963: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
            //   2966: aload_0
            //   2967: aload_2
            //   2968: invokevirtual a : (Landroid/view/View;)V
            //   2971: aload_0
            //   2972: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2975: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   2978: aload_2
            //   2979: aload_0
            //   2980: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2983: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2986: invokevirtual getLogBtnOffsetX : ()I
            //   2989: aload_0
            //   2990: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   2993: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   2996: invokevirtual getLogBtnOffsetY : ()I
            //   2999: aload_0
            //   3000: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3003: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   3006: invokevirtual getLogBtnOffsetBottomY : ()I
            //   3009: aload_0
            //   3010: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3013: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   3016: invokevirtual getLogBtnWidth : ()I
            //   3019: aload_0
            //   3020: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3023: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   3026: invokevirtual getLogBtnHeight : ()I
            //   3029: invokestatic a : (Landroid/content/Context;Landroid/view/View;IIIII)V
            //   3032: aload_2
            //   3033: invokestatic a : (Landroid/view/View;)Ljava/util/List;
            //   3036: invokeinterface iterator : ()Ljava/util/Iterator;
            //   3041: astore #5
            //   3043: aload #5
            //   3045: invokeinterface hasNext : ()Z
            //   3050: ifeq -> 3354
            //   3053: aload #5
            //   3055: invokeinterface next : ()Ljava/lang/Object;
            //   3060: checkcast android/view/View
            //   3063: astore #6
            //   3065: aload #6
            //   3067: instanceof android/widget/TextView
            //   3070: ifeq -> 3043
            //   3073: aload #6
            //   3075: checkcast android/widget/TextView
            //   3078: aload_0
            //   3079: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3082: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   3085: invokevirtual getLogBtnTextSize : ()I
            //   3088: i2f
            //   3089: invokevirtual setTextSize : (F)V
            //   3092: goto -> 3043
            //   3095: aload_2
            //   3096: iconst_0
            //   3097: invokevirtual setVisibility : (I)V
            //   3100: goto -> 2759
            //   3103: aload_0
            //   3104: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3107: invokestatic h : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/RelativeLayout;
            //   3110: iconst_0
            //   3111: invokevirtual setVisibility : (I)V
            //   3114: aload_0
            //   3115: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3118: invokestatic r : (Lcom/chuanglan/shanyan_sdk/tool/a;)Ljava/lang/Boolean;
            //   3121: invokevirtual booleanValue : ()Z
            //   3124: ifeq -> 3254
            //   3127: aload_0
            //   3128: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3131: invokestatic w : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   3134: iconst_1
            //   3135: invokevirtual setChecked : (Z)V
            //   3138: aload_0
            //   3139: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3142: invokestatic g : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   3145: iconst_1
            //   3146: invokevirtual setChecked : (Z)V
            //   3149: aload_0
            //   3150: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3153: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   3156: invokevirtual getCheckedImgPath : ()Landroid/graphics/drawable/Drawable;
            //   3159: ifnull -> 3212
            //   3162: aload_0
            //   3163: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3166: invokestatic g : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   3169: aload_0
            //   3170: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3173: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   3176: invokevirtual getCheckedImgPath : ()Landroid/graphics/drawable/Drawable;
            //   3179: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
            //   3182: aload_0
            //   3183: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3186: invokestatic g : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   3189: astore #6
            //   3191: new com/chuanglan/shanyan_sdk/tool/a$1$7
            //   3194: astore #5
            //   3196: aload #5
            //   3198: aload_0
            //   3199: invokespecial <init> : (Lcom/chuanglan/shanyan_sdk/tool/a$1;)V
            //   3202: aload #6
            //   3204: aload #5
            //   3206: invokevirtual setOnCheckedChangeListener : (Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
            //   3209: goto -> 2929
            //   3212: aload_0
            //   3213: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3216: invokestatic g : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   3219: aload_0
            //   3220: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3223: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   3226: invokevirtual getResources : ()Landroid/content/res/Resources;
            //   3229: ldc_w 'umcsdk_check_image'
            //   3232: ldc_w 'drawable'
            //   3235: aload_0
            //   3236: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3239: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   3242: invokevirtual getPackageName : ()Ljava/lang/String;
            //   3245: invokevirtual getIdentifier : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
            //   3248: invokevirtual setBackgroundResource : (I)V
            //   3251: goto -> 3182
            //   3254: aload_0
            //   3255: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3258: invokestatic w : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   3261: iconst_0
            //   3262: invokevirtual setChecked : (Z)V
            //   3265: aload_0
            //   3266: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3269: invokestatic g : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   3272: iconst_0
            //   3273: invokevirtual setChecked : (Z)V
            //   3276: aload_0
            //   3277: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3280: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   3283: invokevirtual getUncheckedImgPath : ()Landroid/graphics/drawable/Drawable;
            //   3286: ifnull -> 3312
            //   3289: aload_0
            //   3290: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3293: invokestatic g : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   3296: aload_0
            //   3297: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3300: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/a;)Lcom/chuanglan/shanyan_sdk/tool/ShanYanUIConfig;
            //   3303: invokevirtual getUncheckedImgPath : ()Landroid/graphics/drawable/Drawable;
            //   3306: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
            //   3309: goto -> 3182
            //   3312: aload_0
            //   3313: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3316: invokestatic g : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/widget/CheckBox;
            //   3319: aload_0
            //   3320: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3323: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   3326: invokevirtual getResources : ()Landroid/content/res/Resources;
            //   3329: ldc_w 'umcsdk_uncheck_image'
            //   3332: ldc_w 'drawable'
            //   3335: aload_0
            //   3336: getfield a : Lcom/chuanglan/shanyan_sdk/tool/a;
            //   3339: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/a;)Landroid/content/Context;
            //   3342: invokevirtual getPackageName : ()Ljava/lang/String;
            //   3345: invokevirtual getIdentifier : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
            //   3348: invokevirtual setBackgroundResource : (I)V
            //   3351: goto -> 3182
            //   3354: aload_2
            //   3355: invokevirtual getId : ()I
            //   3358: sipush #8738
            //   3361: if_icmpne -> 3373
            //   3364: aload_2
            //   3365: checkcast android/widget/ImageView
            //   3368: bipush #8
            //   3370: invokevirtual setVisibility : (I)V
            //   3373: goto -> 313
            //   3376: goto -> 374
            // Exception table:
            //   from	to	target	type
            //   124	140	230	java/lang/Exception
            //   140	227	230	java/lang/Exception
            //   292	303	630	java/lang/Exception
            //   306	313	630	java/lang/Exception
            //   313	339	630	java/lang/Exception
            //   344	371	630	java/lang/Exception
            //   374	489	630	java/lang/Exception
            //   489	540	630	java/lang/Exception
            //   540	627	630	java/lang/Exception
            //   686	725	230	java/lang/Exception
            //   728	810	230	java/lang/Exception
            //   810	829	230	java/lang/Exception
            //   832	837	230	java/lang/Exception
            //   840	911	230	java/lang/Exception
            //   914	949	230	java/lang/Exception
            //   952	1020	230	java/lang/Exception
            //   1020	1094	230	java/lang/Exception
            //   1097	1157	230	java/lang/Exception
            //   1160	1196	230	java/lang/Exception
            //   1199	1254	230	java/lang/Exception
            //   1254	1334	230	java/lang/Exception
            //   1337	1342	230	java/lang/Exception
            //   1345	1463	230	java/lang/Exception
            //   1466	1534	230	java/lang/Exception
            //   1534	1673	230	java/lang/Exception
            //   1676	1793	230	java/lang/Exception
            //   1796	1801	230	java/lang/Exception
            //   1804	1839	230	java/lang/Exception
            //   1842	1914	230	java/lang/Exception
            //   1917	1999	230	java/lang/Exception
            //   1999	2067	230	java/lang/Exception
            //   2067	2100	230	java/lang/Exception
            //   2100	2125	230	java/lang/Exception
            //   2128	2139	230	java/lang/Exception
            //   2142	2181	230	java/lang/Exception
            //   2184	2239	230	java/lang/Exception
            //   2239	2272	230	java/lang/Exception
            //   2275	2314	230	java/lang/Exception
            //   2317	2477	230	java/lang/Exception
            //   2480	2522	230	java/lang/Exception
            //   2525	2585	230	java/lang/Exception
            //   2585	2609	230	java/lang/Exception
            //   2612	2623	230	java/lang/Exception
            //   2626	2682	230	java/lang/Exception
            //   2685	2718	630	java/lang/Exception
            //   2721	2727	630	java/lang/Exception
            //   2730	2759	630	java/lang/Exception
            //   2759	2784	630	java/lang/Exception
            //   2784	2855	630	java/lang/Exception
            //   2855	2892	630	java/lang/Exception
            //   2892	2929	630	java/lang/Exception
            //   2929	2966	630	java/lang/Exception
            //   2966	3043	630	java/lang/Exception
            //   3043	3092	630	java/lang/Exception
            //   3095	3100	630	java/lang/Exception
            //   3103	3182	630	java/lang/Exception
            //   3182	3209	630	java/lang/Exception
            //   3212	3251	630	java/lang/Exception
            //   3254	3309	630	java/lang/Exception
            //   3312	3351	630	java/lang/Exception
            //   3354	3373	630	java/lang/Exception
          }
          
          public void onActivitySaveInstanceState(Activity param1Activity, Bundle param1Bundle) {
            L.d("ActivityLifecycleLogger", param1Activity + "onActivitySaveInstanceState--->" + param1Activity.getLocalClassName());
          }
          
          public void onActivityStarted(Activity param1Activity) {
            L.d("ActivityLifecycleLogger", param1Activity + "onActivityStarted--->" + param1Activity.getLocalClassName());
          }
          
          public void onActivityStopped(Activity param1Activity) {
            L.d("ActivityLifecycleLogger", param1Activity + "onActivityStopped--->" + param1Activity.getLocalClassName());
          }
          
          class a implements View.OnClickListener {
            private View.OnClickListener b;
            
            public void onClick(View param2View) {
              try {
                b.N = System.currentTimeMillis();
                b.O = SystemClock.uptimeMillis();
                if (this.b != null)
                  this.b.onClick(param2View); 
                switch (param2View.getId()) {
                  default:
                    if (a.q(this.a.a).isChecked()) {
                      a.v(this.a.a).setVisibility(0);
                      a.v(this.a.a).setOnClickListener(null);
                      if (a.x(this.a.a) != null)
                        a.x(this.a.a).setVisibility(8); 
                      return;
                    } 
                    break;
                  case 17476:
                    if (a.w(this.a.a).isChecked()) {
                      a.c(this.a.a).setVisibility(0);
                      a.c(this.a.a).setOnClickListener(null);
                      a.c(this.a.a).bringToFront();
                      if (a.x(this.a.a) != null)
                        a.x(this.a.a).setVisibility(8); 
                      return;
                    } 
                    a.c(this.a.a).setVisibility(8);
                    if (a.x(this.a.a) != null)
                      a.x(this.a.a).setVisibility(8); 
                    return;
                  case 2131165225:
                    a.q(this.a.a).performClick();
                    return;
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
                L.d("ExceptionLogger", "onClick()Exception == " + exception.toString());
                return;
              } 
              a.v(this.a.a).setVisibility(8);
              if (a.x(this.a.a) != null)
                a.x(this.a.a).setVisibility(8); 
            }
          }
        };
    } else {
      ((Application)this.g).unregisterActivityLifecycleCallbacks(this.b);
    } 
    ((Application)this.g).registerActivityLifecycleCallbacks(this.b);
  }
  
  public void b() {
    if (h != null && h.get() != null)
      ((Activity)h.get()).finish(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\tool\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */