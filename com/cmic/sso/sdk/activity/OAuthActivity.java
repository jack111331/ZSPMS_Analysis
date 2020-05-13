package com.cmic.sso.sdk.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.cmic.sso.sdk.a.b;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.b;
import com.cmic.sso.sdk.b.b.b;
import com.cmic.sso.sdk.b.b.c;
import com.cmic.sso.sdk.utils.d;
import com.cmic.sso.sdk.utils.h;
import com.cmic.sso.sdk.utils.i;
import com.cmic.sso.sdk.utils.m;
import com.cmic.sso.sdk.utils.p;
import com.cmic.sso.sdk.utils.q;
import com.cmic.sso.sdk.utils.r;
import com.cmic.sso.sdk.utils.x;
import com.cmic.sso.sdk.utils.z;
import com.cmic.sso.sdk.widget.LoadingImageView;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class OAuthActivity extends Activity {
  protected static final String a = OAuthActivity.class.getSimpleName();
  
  private static a q = null;
  
  private EditText b;
  
  private EditText c;
  
  private RelativeLayout d;
  
  private TextView e;
  
  private LoadingImageView f;
  
  private TextView g;
  
  private Bundle h;
  
  private String i = "";
  
  private String j = "";
  
  private String k;
  
  private String l = "未知错误";
  
  private int m = 0;
  
  private boolean n = false;
  
  private boolean o = false;
  
  private int p = 0;
  
  private JSONObject r = new JSONObject();
  
  private Context s;
  
  private long t = 0L;
  
  private boolean u = false;
  
  private void A() {
    r.a((Context)this, "validated", false);
    q.sendEmptyMessage(42);
  }
  
  private void B() {
    this.b.setText(this.i);
    this.c.setText(this.j);
    if (TextUtils.isEmpty(this.i) || TextUtils.isEmpty(this.j))
      this.d.setEnabled(false); 
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            d.a("SMSClick");
            OAuthActivity.r(this.a);
          }
        });
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            OAuthActivity.s(this.a);
          }
        });
    this.b.addTextChangedListener(new TextWatcher(this) {
          public void afterTextChanged(Editable param1Editable) {}
          
          public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          
          public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
            boolean bool2;
            boolean bool1 = true;
            OAuthActivity.c(this.a, OAuthActivity.t(this.a).getText().toString().trim());
            RelativeLayout relativeLayout = OAuthActivity.v(this.a);
            if (!TextUtils.isEmpty(OAuthActivity.u(this.a)) && OAuthActivity.u(this.a).length() == 6 && !TextUtils.isEmpty(param1CharSequence.toString().trim()) && param1CharSequence.toString().trim().length() == 11) {
              bool2 = true;
            } else {
              bool2 = false;
            } 
            relativeLayout.setEnabled(bool2);
            TextView textView = OAuthActivity.x(this.a);
            if (param1CharSequence.toString().trim().length() == 11 && OAuthActivity.w(this.a) <= 0) {
              bool2 = bool1;
            } else {
              bool2 = false;
            } 
            textView.setEnabled(bool2);
          }
        });
    this.c.addTextChangedListener(new TextWatcher(this) {
          public void afterTextChanged(Editable param1Editable) {}
          
          public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          
          public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
            boolean bool;
            OAuthActivity.d(this.a, OAuthActivity.y(this.a).getText().toString().trim());
            RelativeLayout relativeLayout = OAuthActivity.v(this.a);
            if (!TextUtils.isEmpty(OAuthActivity.z(this.a)) && OAuthActivity.z(this.a).length() == 11 && !TextUtils.isEmpty(param1CharSequence.toString().trim()) && param1CharSequence.toString().trim().length() == 6) {
              bool = true;
            } else {
              bool = false;
            } 
            relativeLayout.setEnabled(bool);
          }
        });
    a(this.n);
    this.j = this.c.getText().toString().trim();
    if (!TextUtils.isEmpty(this.i) && !TextUtils.isEmpty(this.j) && this.j.length() == 6)
      this.d.setEnabled(true); 
  }
  
  private int a(int paramInt) {
    return (int)((i().getResources().getDisplayMetrics()).density * paramInt + 0.5F);
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.f.b();
      this.d.setClickable(false);
      this.b.setEnabled(false);
      this.c.setEnabled(false);
      this.g.setClickable(false);
      return;
    } 
    this.f.c();
    this.d.setClickable(true);
    this.b.setEnabled(true);
    this.c.setEnabled(true);
    this.g.setClickable(true);
  }
  
  private ViewGroup b() {
    LinearLayout linearLayout = new LinearLayout(i());
    linearLayout.setOrientation(1);
    linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    if (!TextUtils.isEmpty(AuthnHelper.getInstance(i()).getAuthThemeConfig().getSmsBGImgPath())) {
      linearLayout.setBackgroundResource(p.a(i(), AuthnHelper.getInstance(i()).getAuthThemeConfig().getSmsBGImgPath()));
    } else {
      linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
    } 
    RelativeLayout relativeLayout = z.a(i(), 69905, 139810, AuthnHelper.getInstance(i()).getAuthThemeConfig().getSmsNavText(), new View.OnClickListener(this) {
          public void onClick(View param1View) {
            d.a("SMSPageReturn");
            OAuthActivity.a(this.a);
          }
        });
    linearLayout.addView((View)relativeLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, a(50)));
    if (AuthnHelper.getInstance(this.s).getAuthThemeConfig().getSmsNavTransparent())
      relativeLayout.getBackground().setAlpha(0); 
    linearLayout.addView((View)e(), (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    return (ViewGroup)linearLayout;
  }
  
  private void c() {
    this.s = (Context)this;
    q = new a(this);
    this.h = getIntent().getExtras();
    if (this.h == null)
      this.h = new Bundle(); 
    if (!this.h.getBoolean("isLoginSwitch", false))
      d.a("SMSIn"); 
    i.a().a(new i.b(this) {
          public void a() {
            d.a("SMSPageOut");
            OAuthActivity.a(this.a);
          }
        });
  }
  
  private ViewGroup d() {
    this.d = new RelativeLayout(i());
    this.d.setBackgroundColor(-16711936);
    this.d.setMinimumWidth(a(280));
    this.d.setClickable(true);
    try {
      this.d.setBackgroundResource(p.a(i(), AuthnHelper.getInstance(i()).getAuthThemeConfig().getSmsLogBtnImgPath()));
    } catch (Exception exception) {
      exception.printStackTrace();
      this.d.setBackgroundResource(p.a(i(), "umcsdk_login_btn_bg"));
    } 
    TextView textView = new TextView(i());
    textView.setText(AuthnHelper.getInstance((Context)this).getAuthThemeConfig().getSmsLogBtnText());
    int i = AuthnHelper.getInstance((Context)this).getAuthThemeConfig().getSmsLogBtnTextColor();
    try {
      textView.setTextColor(i);
    } catch (Exception exception) {
      exception.printStackTrace();
      textView.setTextColor(-1);
    } 
  }
  
  private ViewGroup e() {
    LinearLayout linearLayout = new LinearLayout(i());
    linearLayout.setOrientation(1);
    f();
    ViewGroup viewGroup1 = g();
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, a(36));
    layoutParams2.leftMargin = a(47);
    layoutParams2.rightMargin = a(47);
    layoutParams2.topMargin = a(37);
    linearLayout.addView((View)viewGroup1, (ViewGroup.LayoutParams)layoutParams2);
    ViewGroup viewGroup3 = h();
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-1, a(36));
    layoutParams1.leftMargin = a(47);
    layoutParams1.rightMargin = a(47);
    layoutParams1.topMargin = a(22);
    linearLayout.addView((View)viewGroup3, (ViewGroup.LayoutParams)layoutParams1);
    TextView textView = new TextView(i());
    textView.setText("中国移动提供认证服务");
    textView.setTextSize(2, 10.0F);
    try {
      textView.setTextColor(AuthnHelper.getInstance((Context)this).getAuthThemeConfig().getSmsSloganTextColor());
    } catch (Exception exception) {
      textView.setTextColor(-6710887);
    } 
    layoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    layoutParams1.gravity = 1;
    layoutParams1.topMargin = a(51);
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    linearLayout.addView((View)textView);
    ViewGroup viewGroup2 = d();
    layoutParams1 = new LinearLayout.LayoutParams(-1, a(36));
    layoutParams1.topMargin = a(11);
    layoutParams1.bottomMargin = a(120);
    layoutParams1.leftMargin = a(46);
    layoutParams1.rightMargin = a(46);
    linearLayout.addView((View)viewGroup2, (ViewGroup.LayoutParams)layoutParams1);
    return (ViewGroup)linearLayout;
  }
  
  private void f() {
    this.e = new TextView(i());
    this.e.setGravity(17);
    this.e.setTextColor(-1);
    this.e.setTextSize(2, 14.0F);
    this.e.setPadding(z.a(i(), 16.0F), 0, z.a(i(), 16.0F), 0);
    this.e.setBackgroundResource(p.a(i(), "umcsdk_toast_bg"));
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.addRule(13, -1);
    this.e.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  private ViewGroup g() {
    LinearLayout linearLayout = new LinearLayout(i());
    linearLayout.setGravity(16);
    linearLayout.setOrientation(0);
    linearLayout.setBackgroundResource(p.a(i(), "umcsdk_shape_input"));
    this.b = new EditText(i());
    this.b.setHint("请输入手机号");
    this.b.setBackgroundColor(0);
    this.b.setCompoundDrawablePadding(z.a(i(), 10.0F));
    this.b.setHintTextColor(-6710887);
    this.b.setTextColor(-13421773);
    this.b.setInputType(3);
    this.b.setTextSize(2, 11.0F);
    this.b.setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(11) });
    this.b.setPadding(z.a(i(), 16.0F), 0, 5, 0);
    this.b.setGravity(16);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, z.a(i(), 44.0F));
    linearLayout.addView((View)this.b, (ViewGroup.LayoutParams)layoutParams);
    return (ViewGroup)linearLayout;
  }
  
  private ViewGroup h() {
    RelativeLayout relativeLayout = new RelativeLayout(i());
    relativeLayout.setBackgroundResource(p.a(i(), "umcsdk_shape_input"));
    relativeLayout.setVerticalGravity(16);
    this.c = new EditText(i());
    this.c.setBackgroundColor(0);
    this.c.setHint("请输入短信验证码");
    this.c.setCompoundDrawablePadding(z.a(i(), 10.0F));
    this.c.setHintTextColor(-6710887);
    this.c.setTextColor(-13421773);
    this.c.setInputType(2);
    this.c.setTextSize(2, 11.0F);
    this.c.setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(6) });
    this.c.setPadding(z.a(i(), 16.0F), 0, 5, 0);
    this.c.setGravity(16);
    this.g = new TextView(i());
    int i = AuthnHelper.getInstance(i()).getAuthThemeConfig().getSmsCodeBtnTextColor();
    try {
      this.g.setTextColor(i);
    } catch (Exception exception) {
      exception.printStackTrace();
      this.g.setTextColor(-1);
    } 
    this.g.setTextSize(2, 11.0F);
    this.g.setEnabled(false);
    int j = z.a(i(), 5.0F);
    i = z.a(i(), 16.0F);
    this.g.setPadding(i, j, i, j);
    this.g.setText("获取验证码");
    String str = AuthnHelper.getInstance(i()).getAuthThemeConfig().getSmsCodeImgPath();
    try {
      this.g.setBackgroundResource(p.a(i(), str));
    } catch (Exception exception) {
      exception.printStackTrace();
      this.g.setBackgroundResource(p.a(i(), "umcsdk_get_smscode_btn_bg"));
    } 
  }
  
  private Context i() {
    return (Context)this;
  }
  
  private void j() {
    this.m--;
    if (this.m > 0) {
      this.g.setText(String.format(Locale.getDefault(), "重新获取(%d)", new Object[] { Integer.valueOf(this.m) }));
      q.sendEmptyMessageDelayed(2, 1000L);
      return;
    } 
    this.g.setText("获取验证码");
    if (!this.n && this.b.getText().toString().trim().length() == 11)
      this.g.setEnabled(true); 
  }
  
  private void k() {
    h.a(a, "showException " + this.l);
    if (!TextUtils.isEmpty(this.l)) {
      this.e.setText(this.l);
      Toast toast = new Toast(i());
      toast.setGravity(49, 0, z.a(i(), 400.0F));
      toast.setDuration(0);
      toast.setView((View)this.e);
      toast.show();
      q.removeMessages(3);
      q.sendEmptyMessageDelayed(3, 5000L);
    } 
  }
  
  private void l() {
    this.e.setText("");
    this.l = "";
  }
  
  private void m() {
    finish();
  }
  
  private void n() {
    this.p++;
    if (this.l.equals("验证码错误，请重新输入"))
      this.c.setText(""); 
    if (this.m <= 0) {
      this.g.setText("获取验证码");
      if (this.b.getText().toString().trim().length() == 11)
        this.g.setEnabled(true); 
      q.removeCallbacksAndMessages(null);
    } else {
      this.g.setEnabled(false);
      q.removeMessages(9);
    } 
    a(this.n);
    k();
  }
  
  private void o() {
    this.p = 0;
    a(false);
    q.removeCallbacksAndMessages(null);
    q.sendEmptyMessageDelayed(8, 500L);
  }
  
  private void p() {
    try {
      String str1 = this.r.optString("resultCode");
      String str2 = this.r.optString("resultString");
      this.h.putString("loginMethod", "sms");
      if (this.h != null) {
        if ("200020".equals(str1)) {
          this.h.putString("authtype", "2");
          AuthnHelper.getInstance((Context)this).callBackResult(str1, str2, this.h, this.r, null);
          m();
          return;
        } 
        AuthnHelper.getInstance((Context)this).callBackResult(str1, str2, this.h, this.r, null);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private void q() {
    Toast.makeText(this.s, "请返回后重试", 1).show();
  }
  
  private void r() {
    this.o = true;
    this.p = 0;
    h.a(a, "获取验证码成功");
    this.l = "获取验证码成功";
    q.removeMessages(3);
    q.sendEmptyMessageDelayed(3, 5000L);
  }
  
  private void s() {
    this.m = 0;
    this.n = false;
    q.sendEmptyMessage(1);
  }
  
  private void t() {
    this.r = new JSONObject();
    try {
      this.r.put("resultCode", "200020");
      this.r.put("resultString", "用户取消登录");
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    p();
  }
  
  private void u() {
    if (!this.o) {
      this.l = "请先发送短信验证码";
      q.sendEmptyMessage(1);
      return;
    } 
    if (this.p >= 3) {
      this.l = "请重新获取验证码";
      q.sendEmptyMessage(1);
      return;
    } 
    if (this.u) {
      q.sendEmptyMessage(14);
      a(false);
      return;
    } 
    b.a().b((Context)this);
    this.i = this.b.getText().toString().trim();
    this.j = this.c.getText().toString().trim();
    this.n = true;
    a(true);
    q.removeMessages(9);
    q.sendEmptyMessageDelayed(9, 10000L);
    v();
  }
  
  private void v() {
    h.a(a, "createKsByCondition beging.....");
    this.h.putString("authtype", "2");
    this.h.putString("account", this.i);
    this.h.putString("passwd", this.j);
    this.h.putString("imei", q.a(i()).c());
    this.h.putString("imsi", q.a(i()).a());
    x.a(new x.a(this) {
          protected void a() {
            com.cmic.sso.sdk.auth.a.a((Context)this.a).b(OAuthActivity.l(this.a), new b(this) {
                  public void a(String param2String1, String param2String2, Bundle param2Bundle, JSONObject param2JSONObject) {
                    if (OAuthActivity.m(this.a.a)) {
                      OAuthActivity.a(this.a.a, false);
                      if ("103000".equals(param2String1)) {
                        d.a("SMSVerifySuccess");
                        OAuthActivity.b(this.a.a, param2JSONObject.optString("token"));
                        OAuthActivity.a(this.a.a, param2JSONObject);
                        OAuthActivity.l(this.a.a).putString("token", OAuthActivity.n(this.a.a));
                        OAuthActivity.b(this.a.a, true);
                        OAuthActivity.a().sendEmptyMessage(7);
                        return;
                      } 
                    } else {
                      return;
                    } 
                    d.a("SMSVerifyFailed");
                    OAuthActivity.a(this.a.a, param2JSONObject.optString("resultCode") + " " + param2JSONObject.optString("desc"));
                    OAuthActivity.a().sendEmptyMessage(1);
                  }
                });
          }
        });
  }
  
  private void w() {
    if (!m.a((Context)this, "android.permission.READ_PHONE_STATE")) {
      m.a(this, new String[] { "android.permission.READ_PHONE_STATE" }, 0);
      return;
    } 
    u();
  }
  
  private void x() {
    h.a(a, "getSmsCode ");
    r.a(this.s, "sendsmstimes", System.currentTimeMillis());
    this.i = this.b.getText().toString().trim();
    if (TextUtils.isEmpty(this.i) || this.i.length() < 11) {
      h.a(a, "mMobileNumber is " + this.i);
      this.l = "请输入正确的手机号码！";
      k();
      return;
    } 
    this.h.putString("phonenumber", this.i);
    this.h.putString("authtype", "2");
    this.g.setEnabled(false);
    this.m = 60;
    this.g.setText(String.format(Locale.getDefault(), "重新获取(%d)", new Object[] { Integer.valueOf(this.m) }));
    q.sendEmptyMessageDelayed(2, 0L);
    x.a(new x.a(this, i(), this.h) {
          protected void a() {
            (new c((Context)this.a)).b((Context)this.a, OAuthActivity.l(this.a), new b(this) {
                  public void a(String param2String1, String param2String2, JSONObject param2JSONObject) {
                    String str = OAuthActivity.l(this.a.a).getString("interfacecode", "");
                    OAuthActivity.l(this.a.a).putString("interfacecode", str + param2String1 + ";");
                    long l = System.currentTimeMillis() - r.b(OAuthActivity.o(this.a.a), "sendsmstimes", 0L);
                    r.a(OAuthActivity.o(this.a.a), "tokenbetweentimes", l);
                    str = OAuthActivity.l(this.a.a).getString("interfaceelasped", "");
                    OAuthActivity.l(this.a.a).putString("interfaceelasped", str + l + ";");
                    if ("103000".equals(param2String1)) {
                      d.a("getSMSCodeSuccess");
                      param2String1 = param2JSONObject.optString("randomnum");
                      r.a(OAuthActivity.p(this.a.a), "randomnum", param2String1);
                      OAuthActivity.a().sendEmptyMessage(6);
                      return;
                    } 
                    d.a("getSMSCodeFailed");
                    h.a(OAuthActivity.a, param2JSONObject.toString());
                    if ("103125".equals(param2String1)) {
                      OAuthActivity.a(this.a.a, "请输入正确的手机号码");
                    } else if ("103901".equals(param2String1)) {
                      OAuthActivity.a(this.a.a, "短信验证码下发次数已达上限");
                    } else {
                      OAuthActivity.a(this.a.a, "发送短信验证码失败" + param2String2);
                    } 
                    OAuthActivity.q(this.a.a);
                  }
                });
          }
        });
  }
  
  private void y() {
    if (!r.b((Context)this, "validated", false)) {
      x.a(new x.a(this) {
            protected void a() {
              com.cmic.sso.sdk.auth.a.a((Context)this.a).b("2", OAuthActivity.l(this.a), new b(this) {
                    public void a(String param2String1, String param2String2, Bundle param2Bundle, JSONObject param2JSONObject) {
                      if ("103000".equals(param2String1)) {
                        OAuthActivity.a().sendEmptyMessage(11);
                        return;
                      } 
                      h.a(OAuthActivity.a, param2JSONObject.toString());
                      OAuthActivity.a(this.a.a, param2String2);
                      OAuthActivity.a().sendEmptyMessage(12);
                    }
                  });
            }
          });
      return;
    } 
    x();
  }
  
  private void z() {
    r.a((Context)this, "validated", true);
    x();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    try {
      this.t = System.currentTimeMillis();
      if (Build.VERSION.SDK_INT >= 21) {
        getWindow().addFlags(67108864);
        getWindow().addFlags(134217728);
      } 
      c();
      ViewGroup viewGroup = b();
      setContentView((View)viewGroup);
      viewGroup.setFitsSystemWindows(true);
      viewGroup.setClipToPadding(true);
      B();
    } catch (Exception exception) {
      exception.printStackTrace();
      com.cmic.sso.sdk.c.a.a.add(exception);
    } 
  }
  
  protected void onDestroy() {
    d.a("timeOnSMSPage", (System.currentTimeMillis() - this.t) + "");
    d.a(i(), this.h);
    d.a();
    i.a().e();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      d.a("SMSPageReturn");
      t();
    } 
    return true;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {
    switch (paramInt) {
      default:
        super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfint);
        return;
      case 0:
        break;
    } 
    if (paramArrayOfint[0] == 0) {
      u();
      h.a(a, "申请权限成功");
    } 
    this.l = "用户未授权，请允许权限";
    h.a(a, "申请权限失败");
    k();
  }
  
  private static class a extends Handler {
    WeakReference<OAuthActivity> a;
    
    a(OAuthActivity param1OAuthActivity) {
      this.a = new WeakReference<OAuthActivity>(param1OAuthActivity);
    }
    
    private void a(Message param1Message) {
      OAuthActivity oAuthActivity = this.a.get();
      if (oAuthActivity != null) {
        switch (param1Message.what) {
          default:
            return;
          case 1:
            OAuthActivity.b(oAuthActivity);
          case 2:
            OAuthActivity.c(oAuthActivity);
          case 3:
            OAuthActivity.d(oAuthActivity);
          case 6:
            OAuthActivity.e(oAuthActivity);
          case 14:
            OAuthActivity.f(oAuthActivity);
          case 7:
            OAuthActivity.g(oAuthActivity);
          case 8:
            OAuthActivity.h(oAuthActivity);
          case 9:
            OAuthActivity.a(oAuthActivity, "请求超时");
            OAuthActivity.a(oAuthActivity, false);
            OAuthActivity.a().sendEmptyMessage(1);
          case 42:
            OAuthActivity.i(oAuthActivity);
          case 11:
            OAuthActivity.j(oAuthActivity);
          case 12:
            break;
        } 
        OAuthActivity.k(oAuthActivity);
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
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\activity\OAuthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */