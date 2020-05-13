package com.tencent.connect.auth;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.d;
import com.tencent.open.utils.e;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.h;
import com.tencent.open.utils.i;
import com.tencent.open.web.security.JniInterface;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthAgent extends BaseApi {
  public static final String SECURE_LIB_ARM64_FILE_NAME = "libwbsafeedit_64";
  
  public static final String SECURE_LIB_ARM_FILE_NAME = "libwbsafeedit";
  
  public static String SECURE_LIB_FILE_NAME = "libwbsafeedit";
  
  public static String SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
  
  public static final String SECURE_LIB_X86_64_FILE_NAME = "libwbsafeedit_x86_64";
  
  public static final String SECURE_LIB_X86_FILE_NAME = "libwbsafeedit_x86";
  
  private IUiListener c;
  
  private String d;
  
  private WeakReference<Activity> e;
  
  static {
    String str = Build.CPU_ABI;
    if (str != null && !str.equals("")) {
      if (str.equalsIgnoreCase("arm64-v8a")) {
        SECURE_LIB_FILE_NAME = "libwbsafeedit_64";
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        f.c("openSDK_LOG.AuthAgent", "is arm64-v8a architecture");
        return;
      } 
      if (str.equalsIgnoreCase("x86")) {
        SECURE_LIB_FILE_NAME = "libwbsafeedit_x86";
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        f.c("openSDK_LOG.AuthAgent", "is x86 architecture");
        return;
      } 
      if (str.equalsIgnoreCase("x86_64")) {
        SECURE_LIB_FILE_NAME = "libwbsafeedit_x86_64";
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        f.c("openSDK_LOG.AuthAgent", "is x86_64 architecture");
        return;
      } 
      SECURE_LIB_FILE_NAME = "libwbsafeedit";
      SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
      f.c("openSDK_LOG.AuthAgent", "is arm(default) architecture");
      return;
    } 
    SECURE_LIB_FILE_NAME = "libwbsafeedit";
    SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
    f.c("openSDK_LOG.AuthAgent", "is arm(default) architecture");
  }
  
  public AuthAgent(QQToken paramQQToken) {
    super(paramQQToken);
  }
  
  private int a(boolean paramBoolean, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- start");
    CookieSyncManager.createInstance(d.a());
    Bundle bundle = a();
    if (paramBoolean)
      bundle.putString("isadd", "1"); 
    bundle.putString("scope", this.d);
    bundle.putString("client_id", this.b.getAppId());
    if (isOEM) {
      bundle.putString("pf", "desktop_m_qq-" + installChannel + "-" + "android" + "-" + registerChannel + "-" + businessId);
      String str = (System.currentTimeMillis() / 1000L) + "";
      bundle.putString("sign", g.b(d.a(), str));
      bundle.putString("time", str);
      bundle.putString("display", "mobile");
      bundle.putString("response_type", "token");
      bundle.putString("redirect_uri", "auth://tauth.qq.com/");
      bundle.putString("cancel_display", "1");
      bundle.putString("switch", "1");
      bundle.putString("status_userip", i.a());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(f.a().a(d.a(), "https://openmobile.qq.com/oauth2.0/m_authorize?"));
      stringBuilder1.append(HttpUtils.encodeUrl(bundle));
      str1 = stringBuilder1.toString();
      paramIUiListener = new c(this, d.a(), paramIUiListener, true, false);
      f.b("openSDK_LOG.AuthAgent", "OpenUi, showDialog TDialog");
      h.a(new Runnable(this, str1, paramIUiListener) {
            public void run() {
              g.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 3);
              JniInterface.loadSo();
              if (AuthAgent.e(this.c) != null) {
                Activity activity = AuthAgent.e(this.c).get();
                if (activity != null)
                  activity.runOnUiThread(new Runnable(this, activity) {
                        public void run() {
                          if (JniInterface.isJniOk) {
                            a a = new a((Context)this.a, "action_login", this.b.a, this.b.b, AuthAgent.f(this.b.c));
                            if (!this.a.isFinishing())
                              a.show(); 
                            return;
                          } 
                          f.d("openSDK_LOG.AuthAgent", "OpenUi, secure so load failed, goto download QQ.");
                          TDialog tDialog = new TDialog((Context)this.a, "", AuthAgent.a(this.b.c, ""), null, AuthAgent.g(this.b.c));
                          if (!this.a.isFinishing())
                            tDialog.show(); 
                        }
                      }); 
              } 
            }
          });
      f.c("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- end");
      return 2;
    } 
    str1.putString("pf", "openmobile_android");
    String str2 = (System.currentTimeMillis() / 1000L) + "";
    str1.putString("sign", g.b(d.a(), str2));
    str1.putString("time", str2);
    str1.putString("display", "mobile");
    str1.putString("response_type", "token");
    str1.putString("redirect_uri", "auth://tauth.qq.com/");
    str1.putString("cancel_display", "1");
    str1.putString("switch", "1");
    str1.putString("status_userip", i.a());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(f.a().a(d.a(), "https://openmobile.qq.com/oauth2.0/m_authorize?"));
    stringBuilder.append(HttpUtils.encodeUrl((Bundle)str1));
    String str1 = stringBuilder.toString();
    paramIUiListener = new c(this, d.a(), paramIUiListener, true, false);
    f.b("openSDK_LOG.AuthAgent", "OpenUi, showDialog TDialog");
    h.a(new Runnable(this, str1, paramIUiListener) {
          public void run() {
            g.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 3);
            JniInterface.loadSo();
            if (AuthAgent.e(this.c) != null) {
              Activity activity = AuthAgent.e(this.c).get();
              if (activity != null)
                activity.runOnUiThread(new Runnable(this, activity) {
                      public void run() {
                        if (JniInterface.isJniOk) {
                          a a = new a((Context)this.a, "action_login", this.b.a, this.b.b, AuthAgent.f(this.b.c));
                          if (!this.a.isFinishing())
                            a.show(); 
                          return;
                        } 
                        f.d("openSDK_LOG.AuthAgent", "OpenUi, secure so load failed, goto download QQ.");
                        TDialog tDialog = new TDialog((Context)this.a, "", AuthAgent.a(this.b.c, ""), null, AuthAgent.g(this.b.c));
                        if (!this.a.isFinishing())
                          tDialog.show(); 
                      }
                    }); 
            } 
          }
        });
    f.c("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- end");
    return 2;
  }
  
  private boolean a(Activity paramActivity, Fragment paramFragment, boolean paramBoolean) {
    f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- start");
    Intent intent = b("com.tencent.open.agent.AgentActivity");
    if (intent != null) {
      Bundle bundle = a();
      if (paramBoolean)
        bundle.putString("isadd", "1"); 
      bundle.putString("scope", this.d);
      bundle.putString("client_id", this.b.getAppId());
      if (isOEM) {
        bundle.putString("pf", "desktop_m_qq-" + installChannel + "-" + "android" + "-" + registerChannel + "-" + businessId);
      } else {
        bundle.putString("pf", "openmobile_android");
      } 
      bundle.putString("need_pay", "1");
      bundle.putString("oauth_app_name", g.a(d.a()));
      intent.putExtra("key_action", "action_login");
      intent.putExtra("key_params", bundle);
      intent.putExtra("appid", this.b.getAppId());
      if (a(intent)) {
        this.c = new b(this, this.c);
        UIListenerManager.getInstance().setListenerWithRequestcode(11101, this.c);
        if (paramFragment != null) {
          f.b("openSDK_LOG.AuthAgent", "startAssitActivity fragment");
          a(paramFragment, intent, 11101);
        } else {
          f.b("openSDK_LOG.AuthAgent", "startAssitActivity activity");
          a(paramActivity, intent, 11101);
        } 
        f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- end, found activity for loginIntent");
        d.a().a(0, "LOGIN_CHECK_SDK", "1000", this.b.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
        return true;
      } 
    } 
    d.a().a(1, "LOGIN_CHECK_SDK", "1000", this.b.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "startActionActivity fail");
    f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- end, no target activity for loginIntent");
    return false;
  }
  
  protected void a(IUiListener paramIUiListener) {
    f.c("openSDK_LOG.AuthAgent", "reportDAU() -- start");
    String str2 = this.b.getAccessToken();
    String str3 = this.b.getOpenId();
    String str4 = this.b.getAppId();
    String str5 = "";
    String str1 = str5;
    if (!TextUtils.isEmpty(str2)) {
      str1 = str5;
      if (!TextUtils.isEmpty(str3)) {
        str1 = str5;
        if (!TextUtils.isEmpty(str4))
          str1 = i.f("tencent&sdk&qazxc***14969%%" + str2 + str4 + str3 + "qzone3.4"); 
      } 
    } 
    if (TextUtils.isEmpty(str1)) {
      f.e("openSDK_LOG.AuthAgent", "reportDAU -- encrytoken is null");
      return;
    } 
    Bundle bundle = a();
    bundle.putString("encrytoken", str1);
    HttpUtils.requestAsync(this.b, d.a(), "https://openmobile.qq.com/user/user_login_statis", bundle, "POST", null);
    f.c("openSDK_LOG.AuthAgent", "reportDAU() -- end");
  }
  
  protected void b(IUiListener paramIUiListener) {
    Bundle bundle = a();
    bundle.putString("reqType", "checkLogin");
    BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(this, new a(this, paramIUiListener));
    HttpUtils.requestAsync(this.b, d.a(), "https://openmobile.qq.com/v3/user/get_info", bundle, "GET", (IRequestListener)tempRequestListener);
  }
  
  public int doLogin(Activity paramActivity, String paramString, IUiListener paramIUiListener) {
    return doLogin(paramActivity, paramString, paramIUiListener, false, (Fragment)null);
  }
  
  public int doLogin(Activity paramActivity, String paramString, IUiListener paramIUiListener, boolean paramBoolean, Fragment paramFragment) {
    this.d = paramString;
    this.e = new WeakReference<Activity>(paramActivity);
    this.c = paramIUiListener;
    if (!e.a((Context)paramActivity, this.b.getAppId()).b("C_LoginWeb") && a(paramActivity, paramFragment, paramBoolean)) {
      f.c("openSDK_LOG.AuthAgent", "OpenUi, showUi, return Constants.UI_ACTIVITY");
      d.a().a(this.b.getOpenId(), this.b.getAppId(), "2", "1", "5", "0", "0", "0");
      return 1;
    } 
    d.a().a(this.b.getOpenId(), this.b.getAppId(), "2", "1", "5", "1", "0", "0");
    f.d("openSDK_LOG.AuthAgent", "doLogin startActivity fail show dialog.");
    this.c = new b(this, this.c);
    return a(paramBoolean, this.c);
  }
  
  public void releaseResource() {
    this.c = null;
  }
  
  private class a implements IUiListener {
    IUiListener a;
    
    public a(AuthAgent this$0, IUiListener param1IUiListener) {
      this.a = param1IUiListener;
    }
    
    public void onCancel() {
      if (this.a != null)
        this.a.onCancel(); 
    }
    
    public void onComplete(Object param1Object) {
      if (param1Object == null) {
        f.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data is null");
        return;
      } 
      param1Object = param1Object;
      try {
        int i = param1Object.getInt("ret");
        if (i == 0) {
          param1Object = "success";
        } else {
          param1Object = param1Object.getString("msg");
        } 
        if (this.a != null) {
          IUiListener iUiListener = this.a;
          JSONObject jSONObject = new JSONObject();
          this();
          iUiListener.onComplete(jSONObject.put("ret", i).put("msg", param1Object));
        } 
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        f.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data format error");
      } 
    }
    
    public void onError(UiError param1UiError) {
      if (this.a != null)
        this.a.onError(param1UiError); 
    }
  }
  
  private class b implements IUiListener {
    IUiListener a;
    
    private final String c = "sendinstall";
    
    private final String d = "installwording";
    
    private final String e = "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";
    
    public b(AuthAgent this$0, IUiListener param1IUiListener) {
      this.a = param1IUiListener;
    }
    
    private Drawable a(String param1String, Context param1Context) {
      AssetManager assetManager = param1Context.getApplicationContext().getAssets();
      try {
        InputStream inputStream = assetManager.open(param1String);
        if (inputStream == null)
          return null; 
        boolean bool = param1String.endsWith(".9.png");
        if (bool) {
          try {
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            if (bitmap != null) {
              byte[] arrayOfByte = bitmap.getNinePatchChunk();
              NinePatch.isNinePatchChunk(arrayOfByte);
              NinePatchDrawable ninePatchDrawable = new NinePatchDrawable();
              Rect rect = new Rect();
              this();
              this(bitmap, arrayOfByte, rect, null);
              return (Drawable)ninePatchDrawable;
            } 
          } catch (OutOfMemoryError outOfMemoryError) {
            outOfMemoryError.printStackTrace();
            outOfMemoryError = null;
            if (outOfMemoryError != null) {
              byte[] arrayOfByte = outOfMemoryError.getNinePatchChunk();
              NinePatch.isNinePatchChunk(arrayOfByte);
              NinePatchDrawable ninePatchDrawable = new NinePatchDrawable();
              Rect rect = new Rect();
              this();
              this((Bitmap)outOfMemoryError, arrayOfByte, rect, null);
              return (Drawable)ninePatchDrawable;
            } 
          } 
          return null;
        } 
      } catch (IOException iOException) {
        param1String = null;
        iOException.printStackTrace();
        return (Drawable)param1String;
      } 
      Drawable drawable = Drawable.createFromStream((InputStream)iOException, param1String);
      try {
        iOException.close();
      } catch (IOException iOException1) {}
      return drawable;
    }
    
    private View a(Context param1Context, Drawable param1Drawable, String param1String, View.OnClickListener param1OnClickListener1, View.OnClickListener param1OnClickListener2) {
      DisplayMetrics displayMetrics = new DisplayMetrics();
      ((WindowManager)param1Context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
      float f = displayMetrics.density;
      RelativeLayout relativeLayout = new RelativeLayout(param1Context);
      ImageView imageView = new ImageView(param1Context);
      imageView.setImageDrawable(param1Drawable);
      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
      imageView.setId(1);
      int i = (int)(60.0F * f);
      int j = (int)(60.0F * f);
      int k = (int)(14.0F * f);
      int m = (int)(18.0F * f);
      int n = (int)(6.0F * f);
      k = (int)(18.0F * f);
      RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, j);
      layoutParams2.addRule(9);
      layoutParams2.setMargins(0, m, n, k);
      relativeLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams2);
      TextView textView = new TextView(param1Context);
      textView.setText(param1String);
      textView.setTextSize(14.0F);
      textView.setGravity(3);
      textView.setIncludeFontPadding(false);
      textView.setPadding(0, 0, 0, 0);
      textView.setLines(2);
      textView.setId(5);
      textView.setMinWidth((int)(185.0F * f));
      RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams3.addRule(1, 1);
      layoutParams3.addRule(6, 1);
      j = (int)(10.0F * f);
      layoutParams3.setMargins(0, 0, (int)(5.0F * f), 0);
      relativeLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams3);
      View view = new View(param1Context);
      view.setBackgroundColor(Color.rgb(214, 214, 214));
      view.setId(3);
      layoutParams3 = new RelativeLayout.LayoutParams(-2, 2);
      layoutParams3.addRule(3, 1);
      layoutParams3.addRule(5, 1);
      layoutParams3.addRule(7, 5);
      layoutParams3.setMargins(0, 0, 0, (int)(12.0F * f));
      relativeLayout.addView(view, (ViewGroup.LayoutParams)layoutParams3);
      LinearLayout linearLayout = new LinearLayout(param1Context);
      layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams3.addRule(5, 1);
      layoutParams3.addRule(7, 5);
      layoutParams3.addRule(3, 3);
      Button button2 = new Button(param1Context);
      button2.setText("跳过");
      button2.setBackgroundDrawable(a("buttonNegt.png", param1Context));
      button2.setTextColor(Color.rgb(36, 97, 131));
      button2.setTextSize(20.0F);
      button2.setOnClickListener(param1OnClickListener2);
      button2.setId(4);
      LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, (int)(45.0F * f));
      layoutParams4.rightMargin = (int)(14.0F * f);
      layoutParams4.leftMargin = (int)(4.0F * f);
      layoutParams4.weight = 1.0F;
      linearLayout.addView((View)button2, (ViewGroup.LayoutParams)layoutParams4);
      Button button1 = new Button(param1Context);
      button1.setText("确定");
      button1.setTextSize(20.0F);
      button1.setTextColor(Color.rgb(255, 255, 255));
      button1.setBackgroundDrawable(a("buttonPost.png", param1Context));
      button1.setOnClickListener(param1OnClickListener1);
      LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(0, (int)(45.0F * f));
      layoutParams1.weight = 1.0F;
      layoutParams1.rightMargin = (int)(4.0F * f);
      linearLayout.addView((View)button1, (ViewGroup.LayoutParams)layoutParams1);
      relativeLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams3);
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int)(279.0F * f), (int)(163.0F * f));
      relativeLayout.setPadding((int)(14.0F * f), 0, (int)(12.0F * f), (int)(12.0F * f));
      relativeLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      relativeLayout.setBackgroundColor(Color.rgb(247, 251, 247));
      PaintDrawable paintDrawable = new PaintDrawable(Color.rgb(247, 251, 247));
      paintDrawable.setCornerRadius(f * 5.0F);
      relativeLayout.setBackgroundDrawable((Drawable)paintDrawable);
      return (View)relativeLayout;
    }
    
    private void a(String param1String, IUiListener param1IUiListener, Object param1Object) {
      Drawable drawable = null;
      if (AuthAgent.e(this.b) != null) {
        Activity activity = AuthAgent.e(this.b).get();
        if (activity != null) {
          Dialog dialog = new Dialog((Context)activity);
          dialog.requestWindowFeature(1);
          PackageManager packageManager = activity.getPackageManager();
          try {
            PackageInfo packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
          } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
            nameNotFoundException = null;
          } 
          if (nameNotFoundException != null)
            drawable = ((PackageInfo)nameNotFoundException).applicationInfo.loadIcon(packageManager); 
          a a2 = new a(this, dialog, param1IUiListener, param1Object) {
              public void onClick(View param2View) {
                this.c.a();
                if (this.d != null && this.d.isShowing())
                  this.d.dismiss(); 
                if (this.a != null)
                  this.a.onComplete(this.b); 
              }
            };
          a a1 = new a(this, dialog, param1IUiListener, param1Object) {
              public void onClick(View param2View) {
                if (this.d != null && this.d.isShowing())
                  this.d.dismiss(); 
                if (this.a != null)
                  this.a.onComplete(this.b); 
              }
            };
          ColorDrawable colorDrawable = new ColorDrawable();
          colorDrawable.setAlpha(0);
          dialog.getWindow().setBackgroundDrawable((Drawable)colorDrawable);
          dialog.setContentView(a((Context)activity, drawable, param1String, a2, a1));
          dialog.setOnCancelListener(new DialogInterface.OnCancelListener(this, param1IUiListener, param1Object) {
                public void onCancel(DialogInterface param2DialogInterface) {
                  if (this.a != null)
                    this.a.onComplete(this.b); 
                }
              });
          if (activity != null && !activity.isFinishing())
            dialog.show(); 
        } 
      } 
    }
    
    protected void a() {
      Bundle bundle = AuthAgent.h(this.b);
      if (AuthAgent.e(this.b) != null) {
        Activity activity = AuthAgent.e(this.b).get();
        if (activity != null)
          HttpUtils.requestAsync(AuthAgent.i(this.b), (Context)activity, "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", bundle, "POST", null); 
      } 
    }
    
    public void onCancel() {
      if (this.a != null)
        this.a.onCancel(); 
    }
    
    public void onComplete(Object param1Object) {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: iconst_0
      //   3: istore_3
      //   4: aload_1
      //   5: ifnull -> 106
      //   8: aload_1
      //   9: checkcast org/json/JSONObject
      //   12: astore #4
      //   14: aload #4
      //   16: ifnull -> 106
      //   19: aload #4
      //   21: ldc 'sendinstall'
      //   23: invokevirtual getInt : (Ljava/lang/String;)I
      //   26: iconst_1
      //   27: if_icmpne -> 32
      //   30: iconst_1
      //   31: istore_3
      //   32: iload_3
      //   33: istore_2
      //   34: aload #4
      //   36: ldc 'installwording'
      //   38: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
      //   41: astore #4
      //   43: aload #4
      //   45: invokestatic decode : (Ljava/lang/String;)Ljava/lang/String;
      //   48: astore #4
      //   50: ldc_w 'openSDK_LOG.AuthAgent'
      //   53: new java/lang/StringBuilder
      //   56: dup
      //   57: invokespecial <init> : ()V
      //   60: ldc_w ' WORDING = '
      //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   66: aload #4
      //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   71: ldc_w 'xx'
      //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   77: invokevirtual toString : ()Ljava/lang/String;
      //   80: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
      //   83: iload_3
      //   84: ifeq -> 128
      //   87: aload #4
      //   89: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   92: ifne -> 128
      //   95: aload_0
      //   96: aload #4
      //   98: aload_0
      //   99: getfield a : Lcom/tencent/tauth/IUiListener;
      //   102: aload_1
      //   103: invokespecial a : (Ljava/lang/String;Lcom/tencent/tauth/IUiListener;Ljava/lang/Object;)V
      //   106: return
      //   107: astore #4
      //   109: ldc_w 'openSDK_LOG.AuthAgent'
      //   112: ldc_w 'FeedConfirmListener onComplete There is no value for sendinstall.'
      //   115: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
      //   118: ldc_w ''
      //   121: astore #4
      //   123: iload_2
      //   124: istore_3
      //   125: goto -> 43
      //   128: aload_0
      //   129: getfield a : Lcom/tencent/tauth/IUiListener;
      //   132: ifnull -> 106
      //   135: aload_0
      //   136: getfield a : Lcom/tencent/tauth/IUiListener;
      //   139: aload_1
      //   140: invokeinterface onComplete : (Ljava/lang/Object;)V
      //   145: goto -> 106
      // Exception table:
      //   from	to	target	type
      //   19	30	107	org/json/JSONException
      //   34	43	107	org/json/JSONException
    }
    
    public void onError(UiError param1UiError) {
      if (this.a != null)
        this.a.onError(param1UiError); 
    }
    
    private abstract class a implements View.OnClickListener {
      Dialog d;
      
      a(AuthAgent.b this$0, Dialog param2Dialog) {
        this.d = param2Dialog;
      }
    }
  }
  
  class null extends b.a {
    null(AuthAgent this$0, Dialog param1Dialog, IUiListener param1IUiListener, Object param1Object) {
      super((AuthAgent.b)this$0, param1Dialog);
    }
    
    public void onClick(View param1View) {
      this.c.a();
      if (this.d != null && this.d.isShowing())
        this.d.dismiss(); 
      if (this.a != null)
        this.a.onComplete(this.b); 
    }
  }
  
  class null extends b.a {
    null(AuthAgent this$0, Dialog param1Dialog, IUiListener param1IUiListener, Object param1Object) {
      super((AuthAgent.b)this$0, param1Dialog);
    }
    
    public void onClick(View param1View) {
      if (this.d != null && this.d.isShowing())
        this.d.dismiss(); 
      if (this.a != null)
        this.a.onComplete(this.b); 
    }
  }
  
  class null implements DialogInterface.OnCancelListener {
    null(AuthAgent this$0, IUiListener param1IUiListener, Object param1Object) {}
    
    public void onCancel(DialogInterface param1DialogInterface) {
      if (this.a != null)
        this.a.onComplete(this.b); 
    }
  }
  
  private abstract class a implements View.OnClickListener {
    Dialog d;
    
    a(AuthAgent this$0, Dialog param1Dialog) {
      this.d = param1Dialog;
    }
  }
  
  private class c implements IUiListener {
    private final IUiListener b;
    
    private final boolean c;
    
    private final Context d;
    
    public c(AuthAgent this$0, Context param1Context, IUiListener param1IUiListener, boolean param1Boolean1, boolean param1Boolean2) {
      this.d = param1Context;
      this.b = param1IUiListener;
      this.c = param1Boolean1;
      f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener()");
    }
    
    public void onCancel() {
      f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onCancel");
      this.b.onCancel();
      f.b();
    }
    
    public void onComplete(Object param1Object) {
      f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete");
      param1Object = param1Object;
      try {
        String str1 = param1Object.getString("access_token");
        String str2 = param1Object.getString("expires_in");
        String str3 = param1Object.getString("openid");
        if (str1 != null && AuthAgent.a(this.a) != null && str3 != null) {
          AuthAgent.b(this.a).setAccessToken(str1, str2);
          AuthAgent.c(this.a).setOpenId(str3);
          com.tencent.connect.a.a.d(this.d, AuthAgent.d(this.a));
        } 
        str2 = param1Object.getString("pf");
        if (str2 != null)
          try {
            this.d.getSharedPreferences("pfStore", 0).edit().putString("pf", str2).commit();
          } catch (Exception exception) {} 
        if (this.c)
          CookieSyncManager.getInstance().sync(); 
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", (Throwable)jSONException);
      } 
      this.b.onComplete(param1Object);
      this.a.releaseResource();
      f.b();
    }
    
    public void onError(UiError param1UiError) {
      f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onError");
      this.b.onError(param1UiError);
      f.b();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\connect\auth\AuthAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */