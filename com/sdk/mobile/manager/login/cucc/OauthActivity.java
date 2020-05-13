package com.sdk.mobile.manager.login.cucc;

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
import com.sdk.mobile.c.c;
import com.sdk.mobile.c.d;
import com.sdk.mobile.manager.login.CucWebView;
import com.sdk.mobile.manager.login.a.c;
import com.sdk.mobile.manager.login.a.i;
import com.sdk.mobile.manager.login.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class OauthActivity extends Activity implements View.OnClickListener {
  public static final String a = "cuc_webview";
  
  public static final String b = "app_name";
  
  public static final String c = "brand";
  
  public static final String d = "oauth_mobile_et";
  
  public static final String e = "oauth_login";
  
  public static final String f = "oauth_logo";
  
  public static final String g = "navigation_bar";
  
  public static final String h = "oauth_back";
  
  public static final String i = "oauth_title";
  
  public static final String j = "navigation_bar_line";
  
  public static final String k = "protocol";
  
  public static final String l = "is_agree";
  
  public static final String m = "authorize_app";
  
  public static final String n = "service_and_privacy";
  
  public static final String o = "other_login";
  
  public static final String p = "login_before_text";
  
  private static final String q = OauthActivity.class.getSimpleName();
  
  private static Boolean r = Boolean.valueOf(c.h);
  
  private EditText A;
  
  private ImageView B;
  
  private LinearLayout C;
  
  private LinearLayout D;
  
  private Button E;
  
  private TextView F;
  
  private TextView G;
  
  private TextView H;
  
  private b I;
  
  private d J;
  
  private com.sdk.base.framework.utils.m.a K;
  
  private CucWebView L;
  
  private Map<String, OnCustomViewListener> M;
  
  private String N;
  
  private CheckBox O;
  
  private TextView P;
  
  private TextView Q;
  
  private TextView R;
  
  private String s;
  
  private String t;
  
  private String u;
  
  private String v;
  
  private OauthResultMode w;
  
  private Button x;
  
  private TextView y;
  
  private TextView z;
  
  private void a(String paramString) {
    if (!com.sdk.base.framework.utils.k.a.a(paramString).booleanValue()) {
      if (i()) {
        this.L.loadUrl(paramString);
        (new Handler()).postDelayed(new Runnable(this) {
              public void run() {
                OauthActivity.b(this.a).setVisibility(0);
              }
            },  1000L);
        return;
      } 
      Toast.makeText((Context)this, "请检查网络！", 0).show();
    } 
  }
  
  private void d() {
    Intent intent = getIntent();
    this.I = (b)intent.getSerializableExtra("uiConfig");
    this.w = (OauthResultMode)intent.getSerializableExtra("resultMode");
    h();
  }
  
  private void e() {
    setContentView(com.sdk.base.framework.utils.e.a.a((Context)this, "layout", "activity_oauth"));
    this.x = (Button)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "oauth_back"));
    this.O = (CheckBox)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "is_agree"));
    this.y = (TextView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "oauth_title"));
    this.P = (TextView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "app_name"));
    this.A = (EditText)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "oauth_mobile_et"));
    this.E = (Button)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "oauth_login"));
    this.F = (TextView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "service_and_privacy"));
    this.H = (TextView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "authorize_app"));
    this.L = (CucWebView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "cuc_webview"));
    this.z = (TextView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "brand"));
    this.G = (TextView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "navigation_bar_line"));
    this.B = (ImageView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "oauth_logo"));
    this.C = (LinearLayout)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "navigation_bar"));
    this.D = (LinearLayout)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "protocol"));
    LinearLayout linearLayout = (LinearLayout)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "oauth_content"));
    this.Q = (TextView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "other_login"));
    this.R = (TextView)findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", "login_before_text"));
    if (this.I != null) {
      this.N = this.I.a();
      String str = (String)this.w.getObject();
      try {
        JSONObject jSONObject = new JSONObject();
        this(str);
        String str1 = jSONObject.optString("fakeMobile");
        this.A.setText(str1);
      } catch (JSONException jSONException) {
        b.c(q, "获取脱敏手机号失败！（解密失败）", r);
      } 
    } 
    this.L.setWebViewClient(new a());
    this.L.setWebChromeClient(new WebChromeClient());
    this.M = com.sdk.mobile.manager.login.a.a().b();
    HashMap<String, View> hashMap = f();
    i i = this.I.m();
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
    (new c(this.I, hashMap)).a();
    int j = this.I.d();
    if (j != 0)
      linearLayout.setBackgroundResource(j); 
    this.K = new com.sdk.base.framework.utils.m.a((Context)this, this.N);
    c c = this.I.h();
    if (c != null) {
      this.K.a(c.a(), c.b());
      this.K.b(c.d());
      this.K.a(c.c());
      this.K.a(c.e());
    } 
  }
  
  @NonNull
  private HashMap<String, View> f() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(20);
    hashMap.put("app_name", this.P);
    hashMap.put("brand", this.z);
    hashMap.put("oauth_mobile_et", this.A);
    hashMap.put("oauth_logo", this.B);
    hashMap.put("navigation_bar", this.C);
    hashMap.put("oauth_back", this.x);
    hashMap.put("oauth_title", this.y);
    hashMap.put("navigation_bar_line", this.G);
    hashMap.put("protocol", this.D);
    hashMap.put("service_and_privacy", this.F);
    hashMap.put("oauth_login", this.E);
    hashMap.put("other_login", this.Q);
    hashMap.put("login_before_text", this.R);
    hashMap.put("authorize_app", this.H);
    return (HashMap)hashMap;
  }
  
  @SuppressLint({"SetTextI18n"})
  private void g() {
    this.x.setOnClickListener(this);
    this.E.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.Q.setOnClickListener(this);
    Iterator<String> iterator = this.M.keySet().iterator();
    while (iterator.hasNext()) {
      View view = findViewById(com.sdk.base.framework.utils.e.a.a((Context)this, "id", iterator.next()));
      if (view != null)
        view.setOnClickListener(this); 
    } 
    this.J = new d(this);
    String str = AppUtils.getAppLable((Context)this);
    this.H.setText("并授权" + str + "获得本机号码");
    this.P.setText(str);
    if (this.I.e()) {
      this.O.setVisibility(0);
      this.E.setBackground(getResources().getDrawable(com.sdk.base.framework.utils.e.a.a((Context)this, "drawable", "login_bg_gray")));
      this.O.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
            public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
              if (param1Boolean) {
                OauthActivity.a(this.a).setBackground(this.a.getResources().getDrawable(com.sdk.base.framework.utils.e.a.a((Context)this.a, "drawable", "selector_button_cucc")));
                return;
              } 
              OauthActivity.a(this.a).setBackground(this.a.getResources().getDrawable(com.sdk.base.framework.utils.e.a.a((Context)this.a, "drawable", "login_bg_gray")));
            }
          });
    } 
  }
  
  private void h() {
    if (this.I.b())
      com.sdk.base.framework.utils.app.a.a(this); 
    if (this.I.l() != null && this.I.l().h() && Build.VERSION.SDK_INT >= 19)
      getWindow().addFlags(67108864); 
    if (this.I.l() != null && this.I.l().a())
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
    return this.A.getText().toString();
  }
  
  public void b() {
    this.K.dismiss();
  }
  
  public void c() {
    if (this.I.c())
      this.K.show(); 
    a.a((Context)this).a(this.w, this);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    for (String str : this.M.keySet()) {
      if (com.sdk.base.framework.utils.e.a.a((Context)this, "id", str) == i) {
        ((OnCustomViewListener)this.M.get(str)).onClick(paramView, (com.sdk.mobile.c.a)this.J);
        return;
      } 
    } 
    if (i == com.sdk.base.framework.utils.e.a.a((Context)this, "id", "oauth_back")) {
      this.w.setCode(1);
      this.w.setMsg("用户取消登录");
      this.w.setStatus(100018);
      a.a((Context)this).a(this.w, this);
      finish();
      return;
    } 
    if (i == com.sdk.base.framework.utils.e.a.a((Context)this, "id", "service_and_privacy")) {
      a("https://ms.zzx9.cn/html/oauth/protocol.html");
      return;
    } 
    if (i == com.sdk.base.framework.utils.e.a.a((Context)this, "id", "oauth_login")) {
      if (!this.O.isChecked() && this.I.e()) {
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
    if (i == com.sdk.base.framework.utils.e.a.a((Context)this, "id", "other_login")) {
      OnCustomViewListener onCustomViewListener = a.a((Context)this).d();
      if (onCustomViewListener != null)
        onCustomViewListener.onClick(paramView, (com.sdk.mobile.c.a)this.J); 
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    d();
    super.onCreate(paramBundle);
    e();
    g();
  }
  
  protected void onDestroy() {
    this.L.destroy();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      if (this.L.isShown()) {
        this.L.setVisibility(8);
        return true;
      } 
      OnCustomViewListener onCustomViewListener = (OnCustomViewListener)com.sdk.mobile.manager.login.a.a().b().get("oauth_back");
      if (onCustomViewListener != null) {
        onCustomViewListener.onClick(null, (com.sdk.mobile.c.a)this.J);
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
    
    private a(OauthActivity this$0) {}
    
    public boolean shouldOverrideUrlLoading(WebView param1WebView, String param1String) {
      Uri uri = Uri.parse(Uri.decode(param1String));
      String str2 = uri.getScheme();
      String str1 = uri.getHost();
      if ("zzx".equals(str2)) {
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
        OauthActivity.b(this.a).setVisibility(8);
      } 
      return super.shouldOverrideUrlLoading(param1WebView, param1String);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\mobile\manager\login\cucc\OauthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */