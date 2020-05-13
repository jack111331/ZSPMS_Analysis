package com.zz.sdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import com.zz.sdk.ParamChain;
import com.zz.sdk.SDKManager;
import com.zz.sdk.a.bs;
import com.zz.sdk.a.bv;
import com.zz.sdk.e.bd;
import com.zz.sdk.e.bg;
import com.zz.sdk.g.a;
import com.zz.sdk.i.ba;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.f;
import java.util.Stack;

public class BaseActivity extends Activity {
  static final String a = "zz_sdk";
  
  static final boolean b = false;
  
  private static ParamChain h;
  
  private static final String i = "devicesyn";
  
  bg c;
  
  private final Stack d = new Stack();
  
  private String e;
  
  private ParamChain f;
  
  private Stack g;
  
  private View a(boolean paramBoolean) {
    if (this.d != null && this.d.size() > 0) {
      bg bg1 = this.d.peek();
      if (bg1.h() && !bg1.c(paramBoolean)) {
        View view = bg1.getMainView();
        if (view != null)
          return view; 
      } 
    } 
    return null;
  }
  
  public static final ParamChain a() {
    // Byte code:
    //   0: ldc com/zz/sdk/activity/BaseActivity
    //   2: monitorenter
    //   3: getstatic com/zz/sdk/activity/BaseActivity.h : Lcom/zz/sdk/ParamChain;
    //   6: ifnonnull -> 25
    //   9: invokestatic a : ()Lcom/zz/sdk/ParamChain;
    //   12: ldc com/zz/sdk/activity/BaseActivity
    //   14: invokevirtual getName : ()Ljava/lang/String;
    //   17: invokeinterface grow : (Ljava/lang/String;)Lcom/zz/sdk/ParamChain;
    //   22: putstatic com/zz/sdk/activity/BaseActivity.h : Lcom/zz/sdk/ParamChain;
    //   25: getstatic com/zz/sdk/activity/BaseActivity.h : Lcom/zz/sdk/ParamChain;
    //   28: astore_0
    //   29: ldc com/zz/sdk/activity/BaseActivity
    //   31: monitorexit
    //   32: aload_0
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/zz/sdk/activity/BaseActivity
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   3	25	34	finally
    //   25	29	34	finally
  }
  
  private boolean a(f paramf, ParamChain paramParamChain) {
    this.c = bd.a((Context)this, paramf, paramParamChain);
    return b(this.c);
  }
  
  private boolean a(ClassLoader paramClassLoader, String paramString, ParamChain paramParamChain) {
    return b(bd.a(getBaseContext(), paramString, paramClassLoader, paramParamChain));
  }
  
  private boolean b(bg parambg) {
    if (parambg != null) {
      a(parambg);
      return true;
    } 
    return false;
  }
  
  private void d() {
    cv.a((Context)this, getCurrentFocus());
  }
  
  private View e() {
    View view = a(true);
    if (view == null) {
      if (this.d != null && this.d.size() > 1) {
        d();
        bg bg1 = this.d.pop();
        if (bg1.h())
          bg1.n(); 
        bg1 = this.d.peek();
        bg1.l();
        View view1 = bg1.getMainView();
        setContentView(view1);
        view1.requestFocus();
        return view1;
      } 
      bp.a("ChargeActivity exit");
      finish();
      view = null;
    } 
    return view;
  }
  
  protected void a(Activity paramActivity) {
    Log.d("zz_sdk", SDKManager.getVersionDesc());
    Log.d("zz_sdk", "PJ=" + SDKManager.getProjectId((Context)this) + " PD=" + SDKManager.getProductId((Context)this) + " SV=" + SDKManager.getGameServerId((Context)this));
  }
  
  protected void a(bg parambg) {
    if (this.d.size() > 0) {
      bg bg1 = this.d.peek();
      if (bg1.h()) {
        View view1 = bg1.getMainView();
        if (view1 != null)
          view1.clearFocus(); 
        bg1.k();
      } 
    } 
    d();
    this.d.push(parambg);
    parambg.j();
    View view = parambg.getMainView();
    setContentView(view);
    view.requestFocus();
    if (this.d.size() > 1);
  }
  
  protected void b() {
    if (this.d != null && !this.d.isEmpty())
      while (!this.d.isEmpty()) {
        bg bg1 = this.d.pop();
        if (bg1.h())
          bg1.n(); 
      }  
    this.e = null;
    if (this.f != null) {
      this.f.autoRelease();
      this.f = null;
    } 
  }
  
  protected boolean b(Activity paramActivity) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: invokevirtual getIntent : ()Landroid/content/Intent;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull -> 369
    //   11: aload_0
    //   12: aload_3
    //   13: ldc 'global.ui_activity_name'
    //   15: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   18: putfield e : Ljava/lang/String;
    //   21: aload_0
    //   22: getfield e : Ljava/lang/String;
    //   25: ifnull -> 369
    //   28: invokestatic a : ()Lcom/zz/sdk/ParamChain;
    //   31: ldc com/zz/sdk/activity/BaseActivity
    //   33: invokevirtual getName : ()Ljava/lang/String;
    //   36: invokeinterface getParent : (Ljava/lang/String;)Lcom/zz/sdk/ParamChain;
    //   41: aload_0
    //   42: getfield e : Ljava/lang/String;
    //   45: invokeinterface remove : (Ljava/lang/String;)Ljava/lang/Object;
    //   50: astore_3
    //   51: aload_3
    //   52: instanceof com/zz/sdk/ParamChain
    //   55: ifeq -> 369
    //   58: aload_3
    //   59: checkcast com/zz/sdk/ParamChain
    //   62: astore_3
    //   63: aload_3
    //   64: ifnonnull -> 69
    //   67: iload_2
    //   68: ireturn
    //   69: aload_0
    //   70: aload_3
    //   71: invokeinterface grow : ()Lcom/zz/sdk/ParamChain;
    //   76: putfield f : Lcom/zz/sdk/ParamChain;
    //   79: aload_0
    //   80: getfield f : Lcom/zz/sdk/ParamChain;
    //   83: ldc 'global.ui_activity_instance'
    //   85: aload_1
    //   86: getstatic com/zz/sdk/h.b : Lcom/zz/sdk/h;
    //   89: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;Lcom/zz/sdk/h;)Z
    //   94: pop
    //   95: aload_0
    //   96: getfield f : Lcom/zz/sdk/ParamChain;
    //   99: ldc 'global.key_layout_factory.host'
    //   101: new com/zz/sdk/activity/a
    //   104: dup
    //   105: aload_0
    //   106: invokespecial <init> : (Lcom/zz/sdk/activity/BaseActivity;)V
    //   109: getstatic com/zz/sdk/h.b : Lcom/zz/sdk/h;
    //   112: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;Lcom/zz/sdk/h;)Z
    //   117: pop
    //   118: aload_0
    //   119: new java/util/Stack
    //   122: dup
    //   123: invokespecial <init> : ()V
    //   126: putfield g : Ljava/util/Stack;
    //   129: aload_0
    //   130: getfield f : Lcom/zz/sdk/ParamChain;
    //   133: ldc 'global.caller.login_auto_start'
    //   135: ldc java/lang/Boolean
    //   137: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   142: checkcast java/lang/Boolean
    //   145: astore #4
    //   147: aload_0
    //   148: getfield f : Lcom/zz/sdk/ParamChain;
    //   151: ldc 'global.caller.login_auto_start'
    //   153: invokeinterface remove : (Ljava/lang/String;)Ljava/lang/Object;
    //   158: pop
    //   159: aload_0
    //   160: getfield f : Lcom/zz/sdk/ParamChain;
    //   163: ldc_w 'global.ui_view_type'
    //   166: ldc_w com/zz/sdk/activity/f
    //   169: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   174: checkcast com/zz/sdk/activity/f
    //   177: astore_1
    //   178: aload_1
    //   179: ifnull -> 194
    //   182: aload_0
    //   183: aload_1
    //   184: aload_0
    //   185: getfield f : Lcom/zz/sdk/ParamChain;
    //   188: invokespecial a : (Lcom/zz/sdk/activity/f;Lcom/zz/sdk/ParamChain;)Z
    //   191: ifne -> 203
    //   194: ldc_w 'bad root view'
    //   197: invokestatic b : (Ljava/lang/Object;)V
    //   200: goto -> 67
    //   203: aload_1
    //   204: getstatic com/zz/sdk/activity/f.a : Lcom/zz/sdk/activity/f;
    //   207: if_acmpne -> 287
    //   210: aload_0
    //   211: getfield c : Lcom/zz/sdk/e/bg;
    //   214: checkcast com/zz/sdk/e/bi
    //   217: bipush #8
    //   219: invokevirtual setVisibility : (I)V
    //   222: aload_0
    //   223: getfield f : Lcom/zz/sdk/ParamChain;
    //   226: ldc_w 'global.caller.is_platform'
    //   229: ldc java/lang/Boolean
    //   231: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   236: checkcast java/lang/Boolean
    //   239: astore_3
    //   240: aload_3
    //   241: ifnonnull -> 319
    //   244: iconst_0
    //   245: istore_2
    //   246: iload_2
    //   247: ifne -> 336
    //   250: aload #4
    //   252: ifnonnull -> 327
    //   255: iconst_0
    //   256: istore_2
    //   257: aload_0
    //   258: ldc_w com/zz/sdk/a/ds
    //   261: invokestatic a : ()Lcom/zz/sdk/a/bx;
    //   264: ldc_w 'key_layout_main'
    //   267: aload_0
    //   268: getfield c : Lcom/zz/sdk/e/bg;
    //   271: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   274: ldc_w 'key_auto_login'
    //   277: iload_2
    //   278: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   281: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   284: invokestatic a : (Landroid/app/Activity;Ljava/lang/Class;Ljava/util/Map;)V
    //   287: aload_1
    //   288: getstatic com/zz/sdk/activity/f.b : Lcom/zz/sdk/activity/f;
    //   291: if_acmpne -> 314
    //   294: aload_0
    //   295: ldc_w com/zz/sdk/a/bm
    //   298: invokestatic a : ()Lcom/zz/sdk/a/bx;
    //   301: ldc_w 'payLayout'
    //   304: aload_0
    //   305: getfield c : Lcom/zz/sdk/e/bg;
    //   308: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   311: invokestatic a : (Landroid/app/Activity;Ljava/lang/Class;Ljava/util/Map;)V
    //   314: iconst_1
    //   315: istore_2
    //   316: goto -> 67
    //   319: aload_3
    //   320: invokevirtual booleanValue : ()Z
    //   323: istore_2
    //   324: goto -> 246
    //   327: aload #4
    //   329: invokevirtual booleanValue : ()Z
    //   332: istore_2
    //   333: goto -> 257
    //   336: aload_0
    //   337: ldc_w com/zz/sdk/a/kt
    //   340: invokestatic a : ()Lcom/zz/sdk/a/bx;
    //   343: ldc_w 'key_show_back'
    //   346: iconst_0
    //   347: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   350: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   353: ldc_w 'key_layout_main'
    //   356: aload_0
    //   357: getfield c : Lcom/zz/sdk/e/bg;
    //   360: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/zz/sdk/a/bx;
    //   363: invokestatic a : (Landroid/app/Activity;Ljava/lang/Class;Ljava/util/Map;)V
    //   366: goto -> 287
    //   369: aconst_null
    //   370: astore_3
    //   371: goto -> 63
  }
  
  protected void c() {
    if (a(false) == null)
      finish(); 
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (this.g.isEmpty() || !((a)this.g.peek()).a(paramInt1, paramInt2, paramIntent)) {
      bv.a(this, paramInt1, paramInt2, paramIntent);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    } 
  }
  
  public void onBackPressed() {
    if ((this.g.isEmpty() || !((a)this.g.peek()).m()) && e() == null)
      super.onBackPressed(); 
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    if (this.g.isEmpty() || !((a)this.g.peek()).a(paramConfiguration)) {
      if (paramConfiguration.orientation == 2);
      bv.a(this, paramConfiguration);
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    getWindow().setFlags(1024, 1024);
    super.onCreate(paramBundle);
    a(this);
    if (!b(this))
      c(); 
  }
  
  protected void onDestroy() {
    super.onDestroy();
    bv.i(this);
    b();
    if (bs.a != null)
      bs.a = null; 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (!this.g.isEmpty()) {
      Boolean bool = ((a)this.g.peek()).a(paramInt, paramKeyEvent);
      if (bool != null)
        return bool.booleanValue(); 
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    bv.a(this, paramIntent);
  }
  
  protected void onPause() {
    super.onPause();
    bv.h(this);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {
    switch (paramInt) {
      default:
        return;
      case 123:
        break;
    } 
    bp.a("BaseActivity_onPermissionResult:" + paramArrayOfString.toString());
    paramInt = 0;
    while (true) {
      if (paramInt < paramArrayOfString.length) {
        String str = paramArrayOfString[paramInt];
        bp.a("BaseActivity_onPermissionResult:" + str);
        if (paramArrayOfint[0] == 0) {
          if ("android.permission.READ_EXTERNAL_STORAGE".equals(str)) {
            cq.a((Context)this).a((Context)this, false);
          } else if (!"android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
            if ("android.permission.CALL_PHONE".equals(str)) {
              str = (bs.a((Context)this)).p;
              if (!TextUtils.isEmpty(str))
                f.a((Context)this, str); 
            } else if ("android.permission.READ_PHONE_STATE".equals(str)) {
              SDKManager.getInstance((Context)this).init_device((Context)this, a());
            } 
          } 
        } else if ("android.permission.READ_EXTERNAL_STORAGE".equals(str)) {
          cv.a((Context)this, "需要读取外部存储权限哦~", false);
        } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
          cv.a((Context)this, "需要读写外部存储权限哦~", false);
        } else if ("android.permission.CALL_PHONE".equals(str)) {
          cv.a((Context)this, "需要拨号权限哦~", false);
        } else if ("android.permission.READ_PHONE_STATE".equals(str)) {
          ba.a((Context)this, a());
        } else if ("android.permission.ACCESS_FINE_LOCATION".equals(str)) {
          cv.a((Context)this, "需要获取您的位置~", false);
        } 
        paramInt++;
      } 
    } 
  }
  
  protected void onResume() {
    super.onResume();
    bv.g(this);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\activity\BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */