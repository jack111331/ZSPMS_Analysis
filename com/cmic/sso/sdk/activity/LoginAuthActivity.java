package com.cmic.sso.sdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.cmic.sso.sdk.AuthRegisterViewConfig;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.TokenListener;
import com.cmic.sso.sdk.utils.aa;
import com.cmic.sso.sdk.utils.ac;
import com.cmic.sso.sdk.utils.d;
import com.cmic.sso.sdk.utils.h;
import com.cmic.sso.sdk.utils.i;
import com.cmic.sso.sdk.utils.k;
import com.cmic.sso.sdk.utils.p;
import com.cmic.sso.sdk.utils.r;
import com.cmic.sso.sdk.utils.x;
import com.cmic.sso.sdk.utils.z;
import com.cmic.sso.sdk.widget.LoadingImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginAuthActivity extends Activity implements View.OnClickListener {
  protected static final String a = LoginAuthActivity.class.getSimpleName();
  
  private Handler b;
  
  private Context c;
  
  private RelativeLayout d;
  
  private b e;
  
  private com.cmic.sso.sdk.widget.a f;
  
  private com.cmic.sso.sdk.widget.a g;
  
  private com.cmic.sso.sdk.widget.a h;
  
  private Bundle i;
  
  private com.cmic.sso.sdk.auth.a j;
  
  private String k = "";
  
  private CheckBox l;
  
  private ImageView m;
  
  private LoadingImageView n;
  
  private LinearLayout o;
  
  private RelativeLayout p;
  
  private RelativeLayout q;
  
  private RelativeLayout r;
  
  private RelativeLayout s;
  
  private TextView t;
  
  private long u = 0L;
  
  private int v = 0;
  
  private a w = null;
  
  private TokenListener x;
  
  private boolean y = true;
  
  private LinearLayout z;
  
  private void a(String paramString1, String paramString2, Bundle paramBundle, JSONObject paramJSONObject) {
    try {
      if (this.e != null)
        this.b.removeCallbacks(this.e); 
      if ("103000".equals(paramString1)) {
        if (AuthnHelper.getInstance((Context)this) != null && k.e(paramBundle.getString("traceId")) != null) {
          long l1 = r.b(this.c, "phonebetweentimes", 0L);
          long l2 = r.b(this.c, "tokenbetweentimes", 0L);
          StringBuilder stringBuilder = new StringBuilder();
          this();
          paramBundle.putString("phonebetweentimes", stringBuilder.append(l1).append("").toString());
          stringBuilder = new StringBuilder();
          this();
          paramBundle.putString("tokenbetweentimes", stringBuilder.append(l2).append("").toString());
          AuthnHelper.getInstance((Context)this).callBackResult(paramString1, paramString2, paramBundle, paramJSONObject, null);
        } 
        return;
      } 
      if ("200020".equals(paramString1)) {
        if (AuthnHelper.getInstance((Context)this) != null) {
          if (k.e(paramBundle.getString("traceId")) != null) {
            long l2 = r.b(this.c, "phonebetweentimes", 0L);
            long l1 = r.b(this.c, "tokenbetweentimes", 0L);
            StringBuilder stringBuilder = new StringBuilder();
            this();
            paramBundle.putString("phonebetweentimes", stringBuilder.append(l2).append("").toString());
            stringBuilder = new StringBuilder();
            this();
            paramBundle.putString("tokenbetweentimes", stringBuilder.append(l1).append("").toString());
            AuthnHelper.getInstance((Context)this).callBackResult(paramString1, paramString2, paramBundle, paramJSONObject, null);
            a();
            return;
          } 
          a();
        } 
        return;
      } 
    } catch (Exception exception) {
      h.a(a, "CallbackResult:未知错误");
      exception.printStackTrace();
      return;
    } 
    AuthnHelper.getInstance((Context)this).callBackResult((String)exception, paramString2, paramBundle, paramJSONObject, null);
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean) {
      d.a("authPageOut");
    } else {
      d.a("authPageReturn");
    } 
    a("200020", "用户取消登录", this.i, (JSONObject)null);
  }
  
  private void b() {
    this.c = (Context)this;
    this.i = getIntent().getExtras();
    if (this.i == null)
      this.i = new Bundle(); 
    this.x = k.e(this.i.getString("traceId", ""));
    DisplayMetrics displayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    this.b = new Handler(getMainLooper());
    this.w = new a(this);
    this.k = this.i.getString("securityphone");
    h.b(a, "mSecurityPhone value is " + this.k);
    this.f = new com.cmic.sso.sdk.widget.a(this.c, 16973840, "http://wap.cmpassport.com/resources/html/contract.html");
    this.f.setOnKeyListener(new DialogInterface.OnKeyListener(this) {
          public boolean onKey(DialogInterface param1DialogInterface, int param1Int, KeyEvent param1KeyEvent) {
            if (param1Int == 4 && param1KeyEvent.getRepeatCount() == 0)
              LoginAuthActivity.a(this.a).dismiss(); 
            return false;
          }
        });
    if (!TextUtils.isEmpty(AuthnHelper.getInstance(this.c).getAuthThemeConfig().getClauseUrl())) {
      this.g = new com.cmic.sso.sdk.widget.a(this.c, 16973840, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getClauseUrl());
      this.g.setOnKeyListener(new DialogInterface.OnKeyListener(this) {
            public boolean onKey(DialogInterface param1DialogInterface, int param1Int, KeyEvent param1KeyEvent) {
              if (param1Int == 4 && param1KeyEvent.getRepeatCount() == 0)
                LoginAuthActivity.b(this.a).dismiss(); 
              return false;
            }
          });
    } 
    if (!TextUtils.isEmpty(AuthnHelper.getInstance(this.c).getAuthThemeConfig().getClauseUrlTwo())) {
      this.h = new com.cmic.sso.sdk.widget.a(this.c, 16973840, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getClauseUrlTwo());
      this.h.setOnKeyListener(new DialogInterface.OnKeyListener(this) {
            public boolean onKey(DialogInterface param1DialogInterface, int param1Int, KeyEvent param1KeyEvent) {
              if (param1Int == 4 && param1KeyEvent.getRepeatCount() == 0)
                LoginAuthActivity.c(this.a).dismiss(); 
              return false;
            }
          });
    } 
    i.a().a(new i.a(this) {
          public void a() {
            if (LoginAuthActivity.d(this.a) != null)
              LoginAuthActivity.e(this.a).removeCallbacks(LoginAuthActivity.d(this.a)); 
            if (LoginAuthActivity.a(this.a) != null && LoginAuthActivity.a(this.a).isShowing())
              LoginAuthActivity.a(this.a).dismiss(); 
            if (LoginAuthActivity.b(this.a) != null && LoginAuthActivity.b(this.a).isShowing())
              LoginAuthActivity.b(this.a).dismiss(); 
            LoginAuthActivity.a(this.a, true);
          }
        });
  }
  
  private void c() {
    if (AuthnHelper.getInstance(this.c).getAuthThemeConfig().getLogoOffsetY_B() == 0) {
      z.a((View)this.m, z.a(this.c, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getLogoOffsetY()), 0, 0, 0);
    } else {
      z.a((View)this.m, 0, 0, 0, z.a(this.c, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getLogoOffsetY_B()));
    } 
    if (AuthnHelper.getInstance(this.c).getAuthThemeConfig().getNumFieldOffsetY_B() == 0) {
      z.a((View)this.p, z.a(this.c, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getNumFieldOffsetY()), 0, 0, 0);
    } else {
      z.a((View)this.p, 0, 0, 0, z.a(this.c, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getNumFieldOffsetY_B()));
    } 
    if (AuthnHelper.getInstance(this.c).getAuthThemeConfig().getSwitchOffsetY_B() == 0) {
      z.a((View)this.t, z.a(this.c, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getSwitchAccOffsetY()), 0, 0, 0);
    } else {
      z.a((View)this.t, 0, 0, 0, z.a(this.c, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getSwitchOffsetY_B()));
    } 
    int i = (getResources().getConfiguration()).orientation;
    if (i == 2) {
      if (AuthnHelper.getInstance(this.c).getAuthThemeConfig().getLogBtnOffsetY_B() == 0) {
        z.a((View)this.d, z.a(this.c, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getLogBtnOffsetY()), z.a(this.c, 146.0F), z.a(this.c, 146.0F), 0);
      } else {
        z.a((View)this.d, 0, z.a(this.c, 146.0F), z.a(this.c, 146.0F), z.a(this.c, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getLogBtnOffsetY_B()));
      } 
    } else if (i == 1) {
      if (AuthnHelper.getInstance(this.c).getAuthThemeConfig().getLogBtnOffsetY_B() == 0) {
        z.a((View)this.d, z.a(this.c, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getLogBtnOffsetY()), z.a(this.c, 46.0F), z.a(this.c, 46.0F), 0);
      } else {
        z.a((View)this.d, 0, z.a(this.c, 46.0F), z.a(this.c, 46.0F), z.a(this.c, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getLogBtnOffsetY_B()));
      } 
    } 
    if (AuthnHelper.getInstance(this.c).getAuthThemeConfig().getPrivacyOffsetY() == 0) {
      z.a((View)this.o, 0, z.a(this.c, 52.0F), z.a(this.c, 52.0F), z.a(this.c, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getPrivacyOffsetY_B()));
    } else {
      z.a((View)this.o, z.a(this.c, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getPrivacyOffsetY()), z.a(this.c, 52.0F), z.a(this.c, 52.0F), 0);
    } 
    if (AuthnHelper.getInstance(this.c).getAuthThemeConfig().getSloganOffsetY_B() == 0) {
      z.a((View)this.s, z.a(this.c, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getSloganOffsetY()), 0, 0, 0);
      return;
    } 
    z.a((View)this.s, 0, 0, 0, z.a(this.c, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getSloganOffsetY_B()));
  }
  
  private void d() {
    try {
      Iterator<String> iterator = AuthnHelper.getInstance(this.c).getAuthRegistViewConfigList().keySet().iterator();
      while (true) {
        if (iterator.hasNext()) {
          String str = iterator.next();
          try {
            View view = ((AuthRegisterViewConfig)AuthnHelper.getInstance(this.c).getAuthRegistViewConfigList().get(str)).getView();
            View.OnClickListener onClickListener = new View.OnClickListener() {
                public void onClick(View param1View) {
                  ((AuthRegisterViewConfig)AuthnHelper.getInstance(LoginAuthActivity.f(this.b)).getAuthRegistViewConfigList().get(this.a)).getCustomInterface().onClick(LoginAuthActivity.f(this.b).getApplicationContext());
                  if (this.a.contains("umcskd_authority_finish")) {
                    d.a("authPageOut");
                    this.b.finish();
                  } 
                }
              };
            super(this, str);
            view.setOnClickListener(onClickListener);
            if (((AuthRegisterViewConfig)AuthnHelper.getInstance(this.c).getAuthRegistViewConfigList().get(str)).getRootViewId() == 1) {
              this.q.addView(view);
              continue;
            } 
          } catch (Exception exception) {
            com.cmic.sso.sdk.c.a.a.add(exception);
            h.a(a, "动态注册失败");
            continue;
          } 
        } else {
          return;
        } 
        this.r.addView((View)exception);
      } 
    } catch (Exception exception) {
      com.cmic.sso.sdk.c.a.a.add(exception);
      h.a(a, "动态加载失败-doRegisterView");
      exception.printStackTrace();
    } 
  }
  
  private void e() {
    HashMap hashMap = AuthnHelper.getInstance(this.c).getAuthRegistViewConfigList();
    if (hashMap != null) {
      for (String str : hashMap.keySet()) {
        View view;
        try {
          view = ((AuthRegisterViewConfig)AuthnHelper.getInstance(this.c).getAuthRegistViewConfigList().get(str)).getView();
          if (((AuthRegisterViewConfig)AuthnHelper.getInstance(this.c).getAuthRegistViewConfigList().get(str)).getRootViewId() == 1) {
            this.q.removeView(view);
            continue;
          } 
        } catch (Exception exception) {
          com.cmic.sso.sdk.c.a.a.add(exception);
          h.a(a, "控件反注册失败");
          continue;
        } 
        this.r.removeView(view);
      } 
      AuthnHelper.getInstance(this.c).removeAuthRegisterViewConfig();
    } 
  }
  
  private void f() {
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().addFlags(67108864);
      getWindow().addFlags(134217728);
    } 
    RelativeLayout relativeLayout = new RelativeLayout((Context)this);
    relativeLayout.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    String str = AuthnHelper.getInstance(this.c).getAuthThemeConfig().getAuthBGImgPath();
    try {
      relativeLayout.setBackgroundResource(p.a(this.c, str));
    } catch (Exception exception) {
      relativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
    } 
    setContentView((View)relativeLayout);
    relativeLayout.setFitsSystemWindows(true);
    relativeLayout.setClipToPadding(true);
    try {
      String str1 = AuthnHelper.getInstance(this.c).getAuthThemeConfig().getNavText();
      View.OnClickListener onClickListener = new View.OnClickListener() {
          public void onClick(View param1View) {
            LoginAuthActivity.a(this.a, false);
          }
        };
      super(this);
      this.q = z.a((Context)this, 4369, 26214, str1, onClickListener);
      relativeLayout.addView((View)this.q);
      if (AuthnHelper.getInstance(this.c).getAuthThemeConfig().getAuthNavTransparent())
        this.q.getBackground().setAlpha(0); 
      RelativeLayout relativeLayout1 = new RelativeLayout();
      this((Context)this);
      this.r = relativeLayout1;
      RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams();
      this(-1, -1);
      layoutParams.addRule(3, this.q.getId());
      this.r.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      relativeLayout.addView((View)this.r);
      relativeLayout.addView((View)g());
      d();
      h();
      this.r.addView((View)this.p);
      this.r.addView((View)this.t);
      this.r.addView((View)i());
      this.r.addView((View)k());
      this.r.addView((View)j());
      c();
      this.d.setOnClickListener(this);
      this.t.setOnClickListener(this);
      this.z.setOnClickListener(this);
      CheckBox checkBox = this.l;
      CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            if (param1Boolean) {
              LoginAuthActivity.g(this.a).setEnabled(true);
              try {
                LoginAuthActivity.h(this.a).setBackgroundResource(p.a((Context)this.a, AuthnHelper.getInstance(LoginAuthActivity.f(this.a)).getAuthThemeConfig().getCheckedImgPath()));
              } catch (Exception exception) {
                LoginAuthActivity.h(this.a).setBackgroundResource(p.a((Context)this.a, "umcsdk_check_image"));
              } 
              return;
            } 
            LoginAuthActivity.g(this.a).setEnabled(true);
            try {
              LoginAuthActivity.h(this.a).setBackgroundResource(p.a((Context)this.a, AuthnHelper.getInstance(LoginAuthActivity.f(this.a)).getAuthThemeConfig().getUncheckedImgPath()));
            } catch (Exception exception) {
              LoginAuthActivity.h(this.a).setBackgroundResource(p.a((Context)this.a, "umcsdk_uncheck_image"));
            } 
          }
        };
      super(this);
      checkBox.setOnCheckedChangeListener(onCheckedChangeListener);
      m();
      try {
        if (AuthnHelper.getInstance(this.c).getAuthThemeConfig().getPrivacyState()) {
          this.l.setChecked(true);
          this.l.setBackgroundResource(p.a((Context)this, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getCheckedImgPath()));
          this.d.setEnabled(true);
          return;
        } 
        this.l.setChecked(false);
        this.d.setEnabled(true);
        this.l.setBackgroundResource(p.a((Context)this, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getUncheckedImgPath()));
      } catch (Exception exception) {}
    } catch (Exception exception) {
      com.cmic.sso.sdk.c.a.a.add(exception);
      exception.printStackTrace();
      h.a(a, exception.toString());
      a("200040", "UI资源加载异常", this.i, (JSONObject)null);
    } 
  }
  
  private ImageView g() {
    byte b1 = 0;
    this.m = new ImageView((Context)this);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(z.a(this.c, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getLogoWidth()), z.a(this.c, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getLogoHeight()));
    if (AuthnHelper.getInstance(this.c).getAuthThemeConfig().getLogoOffsetY_B() == 0) {
      h.b(a, "logo_top");
      layoutParams.addRule(10, -1);
    } else {
      h.b(a, "logo_buttom");
      layoutParams.addRule(12, -1);
    } 
    layoutParams.setMargins(0, z.a(this.c, 126.0F), 0, 0);
    layoutParams.addRule(14, -1);
    this.m.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.m.setId(8738);
    try {
      this.m.setBackgroundResource(p.a((Context)this, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getLogoImgPath()));
    } catch (Exception exception) {
      this.m.setBackgroundResource(p.a((Context)this, "umcsdk_mobile_logo"));
    } 
    ImageView imageView = this.m;
    if (AuthnHelper.getInstance(this.c).getAuthThemeConfig().isLogoHidden())
      b1 = 4; 
    imageView.setVisibility(b1);
    return this.m;
  }
  
  private void h() {
    byte b1 = 0;
    this.p = new RelativeLayout((Context)this);
    this.p.setId(13107);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    if (AuthnHelper.getInstance(this.c).getAuthThemeConfig().getNumFieldOffsetY_B() == 0) {
      h.b(a, "numberField_top");
      layoutParams1.addRule(10, -1);
    } else {
      h.b(a, "numberField_buttom");
      layoutParams1.addRule(12, -1);
    } 
    layoutParams1.setMargins(0, z.a(this.c, 210.0F), 0, 0);
    this.p.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    TextView textView1 = new TextView((Context)this);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(13);
    textView1.setGravity(15);
    try {
      textView1.setTextSize(2, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getNumberSize());
    } catch (Exception exception) {
      textView1.setTextSize(2, 18.0F);
    } 
    textView1.setText(this.k);
    textView1.setId(30583);
    this.p.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams2);
    this.t = new TextView((Context)this);
    layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(14);
    if (AuthnHelper.getInstance(this.c).getAuthThemeConfig().getSwitchOffsetY_B() == 0) {
      h.b(a, "switch_top");
      layoutParams2.addRule(10, -1);
    } else {
      h.b(a, "switch_buttom");
      layoutParams2.addRule(12, -1);
    } 
    layoutParams2.setMargins(z.a(this.c, 18.0F), z.a(this.c, 300.0F), 0, 0);
    this.t.setGravity(15);
    this.t.setTextSize(2, 14.0F);
    this.t.setText("切换账号");
    this.t.setId(21845);
    TextView textView2 = this.t;
    if (AuthnHelper.getInstance(this.c).getAuthThemeConfig().isSwitchAccHidden())
      b1 = 4; 
    textView2.setVisibility(b1);
    this.t.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    try {
      this.t.setTextColor(AuthnHelper.getInstance(this.c).getAuthThemeConfig().getSwitchAccTextColor());
    } catch (Exception exception) {
      this.t.setTextColor(-13460749);
    } 
    try {
      textView1.setTextColor(AuthnHelper.getInstance(this.c).getAuthThemeConfig().getNumberColor());
    } catch (Exception exception) {
      textView1.setTextColor(-13421773);
    } 
  }
  
  private RelativeLayout i() {
    this.d = new RelativeLayout((Context)this);
    this.d.setId(17476);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, z.a(this.c, 36.0F));
    if (AuthnHelper.getInstance(this.c).getAuthThemeConfig().getLogBtnOffsetY_B() == 0) {
      h.b(a, "logBtn_top");
      layoutParams1.addRule(10, -1);
    } else {
      h.b(a, "logBtn_buttom");
      layoutParams1.addRule(12, -1);
    } 
    layoutParams1.setMargins(z.a(this.c, 46.0F), z.a(this.c, 250.0F), z.a(this.c, 46.0F), 0);
    layoutParams1.addRule(13);
    this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    TextView textView = new TextView((Context)this);
    textView.setTextSize(2, 15.0F);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(13);
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.d.addView((View)textView);
    this.n = new LoadingImageView(this.c);
    this.n.setBackgroundResource(p.a(this.c, "umcsdk_load_dot_white"));
    this.n.setVisibility(8);
    layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(15);
    layoutParams2.addRule(11, -1);
    layoutParams2.rightMargin = z.a(this.c, 12.0F);
    this.d.addView((View)this.n, (ViewGroup.LayoutParams)layoutParams2);
    textView.setText(AuthnHelper.getInstance(this.c).getAuthThemeConfig().getLogBtnText());
    try {
      textView.setTextColor(AuthnHelper.getInstance(this.c).getAuthThemeConfig().getLogBtnTextColor());
    } catch (Exception exception) {
      textView.setTextColor(-1);
    } 
    try {
      this.d.setBackgroundResource(p.a(this.c, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getLogBtnBackgroundPath()));
    } catch (Exception exception) {
      exception.printStackTrace();
      this.d.setBackgroundResource(p.a(this.c, "umcsdk_login_btn_bg"));
    } 
  }
  
  private RelativeLayout j() {
    this.s = new RelativeLayout((Context)this);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    if (AuthnHelper.getInstance(this.c).getAuthThemeConfig().getSloganOffsetY_B() == 0) {
      h.b(a, "slogan_top");
      layoutParams1.addRule(10, -1);
    } else {
      h.b(a, "slogan_bottom");
      layoutParams1.addRule(12, -1);
    } 
    layoutParams1.setMargins(0, z.a(this.c, 500.0F), 0, 0);
    this.s.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    TextView textView = new TextView((Context)this);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(14);
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    textView.setTextSize(2, 10.0F);
    textView.setText("中国移动提供认证服务");
    this.s.addView((View)textView);
    try {
      textView.setTextColor(AuthnHelper.getInstance(this.c).getAuthThemeConfig().getSloganTextColor());
    } catch (Exception exception) {
      textView.setTextColor(-1707458484);
    } 
    return this.s;
  }
  
  private LinearLayout k() {
    this.o = new LinearLayout((Context)this);
    this.o.setOrientation(0);
    this.o.setHorizontalGravity(1);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    if (AuthnHelper.getInstance(this.c).getAuthThemeConfig().getPrivacyOffsetY() == 0) {
      h.b(a, "privacy_buttom");
      layoutParams.addRule(12, -1);
    } else {
      h.b(a, "privacy_top");
      layoutParams.addRule(10, -1);
    } 
    layoutParams.setMargins(z.a(this.c, 42.0F), 0, z.a(this.c, 52.0F), z.a(this.c, 50.0F));
    this.o.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(z.a(this.c, 30.0F), z.a(this.c, 30.0F));
    this.z = new LinearLayout((Context)this);
    this.z.setOrientation(0);
    this.z.setId(34952);
    this.z.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.l = new CheckBox((Context)this);
    this.l.setChecked(false);
    layoutParams1 = new LinearLayout.LayoutParams(z.a(this.c, 9.0F), z.a(this.c, 9.0F));
    layoutParams1.setMargins(z.a(this.c, 20.0F), z.a(this.c, 2.0F), 0, 0);
    this.l.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.z.addView((View)this.l);
    this.o.addView((View)this.z);
    TextView textView = new TextView((Context)this);
    textView.setTextSize(2, 10.0F);
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
    layoutParams2.setMargins(z.a(this.c, 5.0F), 0, 0, z.a(this.c, 5.0F));
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.o.addView((View)textView);
    textView.setTextColor(AuthnHelper.getInstance(this.c).getAuthThemeConfig().getClauseBaseColor());
    textView.setText((CharSequence)z.a((Context)this, l(), this.f, this.g, this.h));
    textView.setLineSpacing(8.0F, 1.0F);
    textView.setHighlightColor(getResources().getColor(17170445));
    textView.setMovementMethod(LinkMovementMethod.getInstance());
    this.l.setButtonDrawable((Drawable)new ColorDrawable());
    try {
      this.l.setBackgroundResource(p.a((Context)this, AuthnHelper.getInstance(this.c).getAuthThemeConfig().getUncheckedImgPath()));
    } catch (Exception exception) {
      this.l.setBackgroundResource(p.a((Context)this, "umcsdk_uncheck_image"));
    } 
    return this.o;
  }
  
  private String l() {
    return (!TextUtils.isEmpty(AuthnHelper.getInstance(this.c).getAuthThemeConfig().getClauseName()) && !TextUtils.isEmpty(AuthnHelper.getInstance(this.c).getAuthThemeConfig().getClauseNameTwo())) ? ("登录即同意中国移动认证服务条款和" + AuthnHelper.getInstance(this.c).getAuthThemeConfig().getClauseName() + "、" + AuthnHelper.getInstance(this.c).getAuthThemeConfig().getClauseNameTwo() + "并使用本机号码登录") : (!TextUtils.isEmpty(AuthnHelper.getInstance(this.c).getAuthThemeConfig().getClauseName()) ? ("登录即同意中国移动认证服务条款和" + AuthnHelper.getInstance(this.c).getAuthThemeConfig().getClauseName() + "并使用本机号码登录") : (!TextUtils.isEmpty(AuthnHelper.getInstance(this.c).getAuthThemeConfig().getClauseNameTwo()) ? ("登录即同意中国移动认证服务条款和" + AuthnHelper.getInstance(this.c).getAuthThemeConfig().getClauseNameTwo() + "并使用本机号码登录") : ("登录即同意中国移动认证服务条款" + "并使用本机号码登录")));
  }
  
  private void m() {
    this.n.c();
    this.d.setClickable(true);
    this.l.setClickable(true);
  }
  
  private void n() {
    this.n.b();
    this.d.setClickable(false);
    this.l.setClickable(false);
  }
  
  private void o() {
    if (this.v >= 5) {
      Toast.makeText(this.c, "网络不稳定,请返回重试其他登录方式", 1).show();
      this.d.setClickable(true);
      return;
    } 
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    StringBuilder stringBuilder = new StringBuilder();
    int i = arrayOfStackTraceElement.length;
    for (byte b1 = 0; b1 < i; b1++) {
      StackTraceElement stackTraceElement = arrayOfStackTraceElement[b1];
      h.a("stack", stackTraceElement.getClassName());
      String str1 = stackTraceElement.getClassName();
      if (!TextUtils.isEmpty(str1) && str1.contains("com.cmic.sso.sdk.activity") && !stringBuilder.toString().contains(str1))
        stringBuilder.append(str1).append(";"); 
    } 
    this.i.putString("caller", stringBuilder.toString());
    String str = this.i.getString("traceId", "");
    if (!TextUtils.isEmpty(str) && k.a(str)) {
      str = ac.b();
      this.i.putString("traceId", str);
      k.a(str, this.x);
    } 
    n();
    this.e = new b(this, this.i);
    this.b.postDelayed(this.e, 5000L);
    x.a(new x.a(this) {
          protected void a() {
            if (!LoginAuthActivity.j(this.a)) {
              LoginAuthActivity.l(this.a).a(LoginAuthActivity.k(this.a), String.valueOf(3), new com.cmic.sso.sdk.auth.b(this) {
                    public void a(String param2String1, String param2String2, Bundle param2Bundle, JSONObject param2JSONObject) {
                      if ("103000".equals(param2String1)) {
                        LoginAuthActivity.l(this.a.a).a(LoginAuthActivity.k(this.a.a), new com.cmic.sso.sdk.auth.b(this) {
                              public void a(String param3String1, String param3String2, Bundle param3Bundle, JSONObject param3JSONObject) {
                                if ("103000".equals(param3String1)) {
                                  d.a("authClickSuccess");
                                  LoginAuthActivity.b(this.a.a.a, true);
                                } else {
                                  LoginAuthActivity.b(this.a.a.a, false);
                                  d.a("authClickFailed");
                                } 
                                LoginAuthActivity.a(this.a.a.a, param3String1, param3String2, param3Bundle, param3JSONObject);
                                try {
                                  Thread.sleep(1000L);
                                } catch (InterruptedException interruptedException) {
                                  interruptedException.printStackTrace();
                                } 
                                LoginAuthActivity.i(this.a.a.a).sendEmptyMessage(13);
                              }
                            });
                        return;
                      } 
                      LoginAuthActivity.b(this.a.a, false);
                      LoginAuthActivity.a(this.a.a, param2String1, param2String2, param2Bundle, param2JSONObject);
                      try {
                        Thread.sleep(1000L);
                      } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                      } 
                      LoginAuthActivity.i(this.a.a).sendEmptyMessage(13);
                    }
                  }true);
              return;
            } 
            LoginAuthActivity.l(this.a).a(LoginAuthActivity.k(this.a), new com.cmic.sso.sdk.auth.b(this) {
                  public void a(String param2String1, String param2String2, Bundle param2Bundle, JSONObject param2JSONObject) {
                    if ("103000".equals(param2String1)) {
                      d.a("authClickSuccess");
                      LoginAuthActivity.b(this.a.a, true);
                    } else {
                      LoginAuthActivity.b(this.a.a, false);
                      d.a("authClickFailed");
                    } 
                    LoginAuthActivity.a(this.a.a, param2String1, param2String2, param2Bundle, param2JSONObject);
                    try {
                      Thread.sleep(1000L);
                    } catch (InterruptedException interruptedException) {
                      interruptedException.printStackTrace();
                    } 
                    LoginAuthActivity.i(this.a.a).sendEmptyMessage(13);
                  }
                });
          }
        });
  }
  
  public void a() {
    if (this.e != null)
      this.b.removeCallbacks(this.e); 
    if (this.f != null && this.f.isShowing())
      this.f.dismiss(); 
    if (this.g != null && this.g.isShowing())
      this.g.dismiss(); 
    finish();
  }
  
  public void onClick(View paramView) {
    String str;
    switch (paramView.getId()) {
      default:
        return;
      case 17476:
        if (!this.l.isChecked())
          Toast.makeText(this.c, "请同意服务条款", 1).show(); 
        this.v++;
        o();
      case 34952:
        if (this.l.isChecked())
          this.l.setChecked(false); 
        this.l.setChecked(true);
      case 21845:
        try {
          if (aa.e(this.c))
            Toast.makeText(this.c, "服务器繁忙，请稍后重试", 1).show(); 
        } catch (Exception exception) {
          exception.printStackTrace();
          a("200025", "发生未知错误", this.i, (JSONObject)null);
        } 
        str = this.i.getString("authTypeInput");
        if (!TextUtils.isEmpty(str) && str.contains("2")) {
          str = this.i.getString("traceId", "");
          if (!TextUtils.isEmpty(str) && k.a(str)) {
            str = ac.b();
            this.i.putString("traceId", str);
            k.a(str, this.x);
          } 
          this.i.putBoolean("isLoginSwitch", true);
          this.i.putString("PGWResultCode", "200068");
          this.i.putString("transCode", "0");
          ac.b((Context)this, this.i);
          d.a("auth2SMS");
          a();
        } 
        a("200060", "第三方登录方式", this.i, (JSONObject)null);
      case 26214:
        break;
    } 
    a(false);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    try {
      d.a("authPageIn");
      this.u = System.currentTimeMillis();
      this.j = com.cmic.sso.sdk.auth.a.a((Context)this);
      b();
      f();
    } catch (Exception exception) {
      com.cmic.sso.sdk.c.a.a.add(exception);
      h.a(a, exception.toString());
      exception.printStackTrace();
      a("200025", "发生未知错误", this.i, (JSONObject)null);
    } 
  }
  
  protected void onDestroy() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      d.a("timeOnAuthPage", stringBuilder.append(System.currentTimeMillis() - this.u).append("").toString());
      if (this.l.isChecked()) {
        d.a("authPrivacyState", "1");
      } else {
        d.a("authPrivacyState", "0");
      } 
      if (!this.i.getBoolean("isLoginSwitch", false)) {
        stringBuilder = new StringBuilder();
        this();
        d.a("timeOnAuthPage", stringBuilder.append(System.currentTimeMillis() - this.u).append("").toString());
        d.a(this.c, this.i);
        d.a();
      } 
      e();
      i.a().d();
      this.w.removeCallbacksAndMessages(null);
    } catch (Exception exception) {
      h.a(a, "LoginAuthActivity clear failed");
      com.cmic.sso.sdk.c.a.a.add(exception);
      exception.printStackTrace();
    } 
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4 && paramKeyEvent.getRepeatCount() == 0)
      a(false); 
    return true;
  }
  
  protected void onResume() {
    super.onResume();
    if (this.i != null)
      this.i.putString("loginMethod", "loginAuth"); 
  }
  
  private static class a extends Handler {
    WeakReference<LoginAuthActivity> a;
    
    a(LoginAuthActivity param1LoginAuthActivity) {
      this.a = new WeakReference<LoginAuthActivity>(param1LoginAuthActivity);
    }
    
    private void a(Message param1Message) {
      LoginAuthActivity loginAuthActivity = this.a.get();
      if (loginAuthActivity != null) {
        switch (param1Message.what) {
          default:
            return;
          case 13:
            break;
        } 
        LoginAuthActivity.m(loginAuthActivity);
      } 
    }
    
    public void handleMessage(Message param1Message) {
      try {
        a(param1Message);
      } catch (Exception exception) {
        com.cmic.sso.sdk.c.a.a.add(exception);
        exception.printStackTrace();
      } 
    }
  }
  
  private class b implements Runnable {
    private Bundle b;
    
    b(LoginAuthActivity this$0, Bundle param1Bundle) {
      this.b = param1Bundle;
    }
    
    public void run() {
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.put("resultCode", "102507");
        jSONObject.put("resultString", "请求超时");
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      LoginAuthActivity.b(this.a, false);
      d.a("authClickFailed");
      LoginAuthActivity.i(this.a).sendEmptyMessage(13);
      LoginAuthActivity.a(this.a, "102507", "请求超时", this.b, jSONObject);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\activity\LoginAuthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */