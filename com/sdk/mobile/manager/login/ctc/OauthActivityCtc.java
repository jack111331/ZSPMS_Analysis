package com.sdk.mobile.manager.login.ctc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sdk.base.api.OnCustomViewListener;
import com.sdk.base.framework.bean.OauthResultMode;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.app.AppUtils;
import com.sdk.base.framework.utils.f.b;
import com.sdk.mobile.c.a.b;
import com.sdk.mobile.c.c;
import com.sdk.mobile.manager.login.CucWebView;
import com.sdk.mobile.manager.login.a.c;
import com.sdk.mobile.manager.login.a.i;
import com.sdk.mobile.manager.login.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class OauthActivityCtc extends Activity implements View.OnClickListener {
  public static final String a = "cuc_webview_ctc";
  
  public static final String b = "app_name_ctc";
  
  public static final String c = "brand_ctc";
  
  public static final String d = "oauth_mobile_et_ctc";
  
  public static final String e = "oauth_login_ctc";
  
  public static final String f = "oauth_logo_ctc";
  
  public static final String g = "navigation_bar_ctc";
  
  public static final String h = "oauth_back_ctc";
  
  public static final String i = "oauth_title_ctc";
  
  public static final String j = "navigation_bar_line_ctc";
  
  public static final String k = "protocol_ctc";
  
  public static final String l = "is_agree_ctc";
  
  public static final String m = "authorize_app_ctc";
  
  public static final String n = "service_and_privacy_ctc";
  
  public static final String o = "other_login_ctc";
  
  public static final String p = "login_before_text_ctc";
  
  private static final String q = OauthActivityCtc.class.getSimpleName();
  
  private static Boolean r = Boolean.valueOf(c.h);
  
  private Button A;
  
  private TextView B;
  
  private TextView C;
  
  private b D;
  
  private b E;
  
  private com.sdk.base.framework.utils.m.a F;
  
  private CucWebView G;
  
  private Map<String, OnCustomViewListener> H;
  
  private String I;
  
  private CheckBox J;
  
  private TextView K;
  
  private TextView L;
  
  private ImageView M;
  
  private LinearLayout N;
  
  private LinearLayout O;
  
  private LinearLayout P;
  
  private TextView Q;
  
  private TextView R;
  
  private TextView S;
  
  private String s;
  
  private String t;
  
  private String u;
  
  private String v;
  
  private OauthResultMode w;
  
  private Button x;
  
  private TextView y;
  
  private EditText z;
  
  private void a(String paramString) {
    if (!com.sdk.base.framework.utils.k.a.a(paramString).booleanValue()) {
      if (i()) {
        this.G.loadUrl(paramString);
        (new Handler()).postDelayed(new Runnable(this) {
              public void run() {
                OauthActivityCtc.b(this.a).setVisibility(0);
              }
            },  1000L);
        return;
      } 
      Toast.makeText((Context)this, "请检查网络！", 0).show();
    } 
  }
  
  private void d() {
    Intent intent = getIntent();
    this.D = (b)intent.getSerializableExtra("uiConfig");
    this.w = (OauthResultMode)intent.getSerializableExtra("resultMode");
    h();
  }
  
  private void e() {
    setContentView(com.sdk.base.framework.utils.e.a.a((Context)this, "layout", "activity_oauth_ctc"));
    this.x = (Button)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "oauth_back_ctc"));
    this.J = (CheckBox)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "is_agree_ctc"));
    this.y = (TextView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "oauth_title_ctc"));
    this.z = (EditText)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "oauth_mobile_et_ctc"));
    this.A = (Button)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "oauth_login_ctc"));
    this.B = (TextView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "service_and_privacy_ctc"));
    this.C = (TextView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "authorize_app_ctc"));
    this.G = (CucWebView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "cuc_webview_ctc"));
    this.K = (TextView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "brand_ctc"));
    this.Q = (TextView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "app_name_ctc"));
    this.L = (TextView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "navigation_bar_line_ctc"));
    this.M = (ImageView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "oauth_logo_ctc"));
    this.N = (LinearLayout)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "navigation_bar_ctc"));
    this.O = (LinearLayout)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "protocol_ctc"));
    this.P = (LinearLayout)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "oauth_content_ctc"));
    this.R = (TextView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "other_login_ctc"));
    this.S = (TextView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "login_before_text_ctc"));
    if (this.D != null) {
      this.I = this.D.a();
      try {
        JSONObject jSONObject = new JSONObject();
        this((String)this.w.getObject());
        this.z.setText(jSONObject.optString("fakeMobile"));
      } catch (Exception exception) {
        b.c(q, "获取脱敏手机号失败！（解密失败）", r);
      } 
    } 
    this.G.setWebViewClient(new a());
    this.G.setWebChromeClient(new WebChromeClient());
    this.H = com.sdk.mobile.manager.login.a.a().b();
    HashMap<String, View> hashMap = f();
    i i = this.D.m();
    if (i != null) {
      this.s = i.d();
      this.u = i.e();
      if (com.sdk.base.framework.utils.k.a.b(this.s).booleanValue()) {
        TextView textView = (TextView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", this.s));
        if (textView != null) {
          hashMap.put(this.s, textView);
          textView.setOnClickListener(this);
        } 
      } 
      this.t = i.f();
      this.v = i.g();
      if (com.sdk.base.framework.utils.k.a.b(this.t).booleanValue()) {
        TextView textView = (TextView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", this.t));
        if (textView != null) {
          hashMap.put(this.t, textView);
          textView.setOnClickListener(this);
        } 
      } 
    } 
    (new c(this.D, hashMap)).a();
    int j = this.D.d();
    if (j != 0)
      this.P.setBackgroundResource(j); 
    this.F = new com.sdk.base.framework.utils.m.a((Context)this, this.I);
    c c = this.D.h();
    if (c != null) {
      this.F.a(c.a(), c.b());
      this.F.b(c.d());
      this.F.a(c.c());
      this.F.a(c.e());
    } 
  }
  
  @NonNull
  private HashMap<String, View> f() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(20);
    hashMap.put("app_name_ctc", this.Q);
    hashMap.put("brand_ctc", this.K);
    hashMap.put("oauth_mobile_et_ctc", this.z);
    hashMap.put("oauth_logo_ctc", this.M);
    hashMap.put("navigation_bar_ctc", this.N);
    hashMap.put("oauth_back_ctc", this.x);
    hashMap.put("oauth_title_ctc", this.y);
    hashMap.put("navigation_bar_line_ctc", this.L);
    hashMap.put("protocol_ctc", this.O);
    hashMap.put("service_and_privacy_ctc", this.B);
    hashMap.put("oauth_login_ctc", this.A);
    hashMap.put("other_login_ctc", this.R);
    hashMap.put("login_before_text_ctc", this.S);
    hashMap.put("authorize_app_ctc", this.C);
    return (HashMap)hashMap;
  }
  
  @SuppressLint({"SetTextI18n"})
  private void g() {
    this.x.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.B.setOnClickListener(this);
    this.R.setOnClickListener(this);
    Iterator<String> iterator = this.H.keySet().iterator();
    while (iterator.hasNext()) {
      View view = findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", iterator.next()));
      if (view != null)
        view.setOnClickListener(this); 
    } 
    this.E = new b(this);
    String str = AppUtils.getAppLable((Context)this);
    this.C.setText("并授权" + str + "获得本机号码");
    this.Q.setText(str);
    if (this.D.e()) {
      this.J.setVisibility(0);
      this.A.setBackground(getResources().getDrawable(com.sdk.base.framework.utils.e.a.a((Context)this, "drawable", "login_bg_gray")));
      this.J.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
            public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
              if (param1Boolean) {
                OauthActivityCtc.a(this.a).setBackground(this.a.getResources().getDrawable(com.sdk.base.framework.utils.e.a.a((Context)this.a, "drawable", "selector_button_ctc")));
                return;
              } 
              OauthActivityCtc.a(this.a).setBackground(this.a.getResources().getDrawable(com.sdk.base.framework.utils.e.a.a((Context)this.a, "drawable", "login_bg_gray")));
            }
          });
    } 
  }
  
  private void h() {
    if (this.D.b())
      com.sdk.base.framework.utils.app.a.a(this); 
    if (this.D.l() != null && this.D.l().h() && Build.VERSION.SDK_INT >= 19)
      getWindow().addFlags(67108864); 
    if (this.D.l() != null && this.D.l().a())
      getWindow().setFlags(1024, 1024); 
  }
  
  private boolean i() {
    ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService("connectivity");
    if (connectivityManager != null) {
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      return (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected());
    } 
    return false;
  }
  
  public String a() {
    return this.z.getText().toString();
  }
  
  public void b() {
    this.F.dismiss();
  }
  
  public void c() {
    if (this.D.c())
      this.F.show(); 
    a.a((Context)this).a(this.w, this);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    for (String str : this.H.keySet()) {
      if (com.sdk.base.framework.utils.e.a.a((Context)this, "id", str) == i) {
        ((OnCustomViewListener)this.H.get(str)).onClick(paramView, (com.sdk.mobile.c.a)this.E);
        return;
      } 
    } 
    if (i == com.sdk.base.framework.utils.e.a.a((Context)this, "id", "oauth_back_ctc")) {
      this.w.setCode(1);
      this.w.setMsg("用户取消登录");
      this.w.setStatus(100018);
      a.a((Context)this).a(this.w, this);
      finish();
      return;
    } 
    if (i == com.sdk.base.framework.utils.e.a.a((Context)this, "id", "service_and_privacy_ctc")) {
      if (i()) {
        a("https://e.189.cn/sdk/agreement/detail.do?hidetop=true");
        return;
      } 
      Toast.makeText((Context)this, "请检查网络！", 0).show();
      return;
    } 
    if (i == com.sdk.base.framework.utils.e.a.a((Context)this, "id", "oauth_login_ctc")) {
      if (!this.J.isChecked() && this.D.e()) {
        Toast.makeText((Context)this, "请先勾选协议！", 0).show();
        return;
      } 
      c();
      return;
    } 
    if (com.sdk.base.framework.utils.k.a.b(this.s).booleanValue() && i == com.sdk.base.framework.utils.e.a.a((Context)this, "id", this.s)) {
      a(this.u);
      return;
    } 
    if (com.sdk.base.framework.utils.k.a.b(this.t).booleanValue() && i == com.sdk.base.framework.utils.e.a.a((Context)this, "id", this.t)) {
      a(this.v);
      return;
    } 
    if (i == com.sdk.base.framework.utils.e.a.a((Context)this, "id", "other_login_ctc")) {
      OnCustomViewListener onCustomViewListener = a.a((Context)this).d();
      if (onCustomViewListener != null)
        onCustomViewListener.onClick(paramView, (com.sdk.mobile.c.a)this.E); 
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    d();
    super.onCreate(paramBundle);
    e();
    g();
  }
  
  protected void onDestroy() {
    this.G.destroy();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      if (this.G.isShown()) {
        this.G.setVisibility(8);
        return true;
      } 
      OnCustomViewListener onCustomViewListener = (OnCustomViewListener)com.sdk.mobile.manager.login.a.a().b().get("oauth_back_ctc");
      if (onCustomViewListener != null) {
        onCustomViewListener.onClick(null, (com.sdk.mobile.c.a)this.E);
        return true;
      } 
      this.w.setCode(1);
      this.w.setMsg("用户取消登录");
      this.w.setStatus(100018);
      a.a((Context)this).a(this.w, this);
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  private class a extends WebViewClient {
    private static final String b = "zzx";
    
    private static final String c = "back";
    
    private a(OauthActivityCtc this$0) {}
    
    public boolean shouldOverrideUrlLoading(WebView param1WebView, String param1String) {
      Uri uri = Uri.parse(Uri.decode(param1String));
      String str2 = uri.getScheme();
      String str1 = uri.getHost();
      if ("zzx".equals(str2) && com.sdk.base.framework.utils.k.a.b(str1).booleanValue()) {
        byte b = -1;
        switch (str1.hashCode()) {
          default:
            switch (b) {
              default:
                return super.shouldOverrideUrlLoading(param1WebView, param1String);
              case 0:
                break;
            } 
            break;
          case 3015911:
            if (str1.equals("back"))
              b = 0; 
        } 
        OauthActivityCtc.b(this.a).setVisibility(8);
      } 
      return super.shouldOverrideUrlLoading(param1WebView, param1String);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\mobile\manager\login\ctc\OauthActivityCtc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */