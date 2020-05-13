package com.zz.sdk.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zz.sdk.SDKManager;
import com.zz.sdk.b;
import com.zz.sdk.i.bf;
import com.zz.sdk.i.bi;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.bz;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.df;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class al extends LinearLayout implements View.OnClickListener {
  private static final int ac = 2015;
  
  private SDKManager A;
  
  private final String B = "http://i.yingxiong.com/wcenter/Client";
  
  private String C;
  
  private final String D = "http://i.yingxiong.com/wcenter/custom";
  
  private String E;
  
  private String F;
  
  private String G;
  
  private String H;
  
  private final String I = "access_token";
  
  private final String J = "platform";
  
  private final String K = "timestamp";
  
  private final String L = "sign";
  
  private final String M = "productid";
  
  private final String N = "os";
  
  private final String O = "serviceid";
  
  private final String P = "service";
  
  private final String Q = "android";
  
  private String R;
  
  private final String S = "kwmxhalqho#wjnz@@";
  
  private final String T = "1";
  
  private String U = "";
  
  private String V = "";
  
  private List W;
  
  String a = "var a=document.getElementById('shareurl'),b=document.getElementById('sharetitle'),c={};if(a)c.u=''+a.innerHTML;else c.u='';if(b)c.d=''+b.innerHTML;else c.d='';c.t=document.title;";
  
  private boolean aa;
  
  private b ab;
  
  private Handler ad = new am(this);
  
  private Context b;
  
  private Button c;
  
  private FrameLayout d;
  
  private Button e;
  
  private FrameLayout f;
  
  private Button g;
  
  private FrameLayout h;
  
  private LinearLayout i;
  
  private TextView j;
  
  private ImageView k;
  
  private LinearLayout l;
  
  private TextView m;
  
  private ImageView n;
  
  private LinearLayout o;
  
  private int p;
  
  private LinearLayout.LayoutParams q = new LinearLayout.LayoutParams(-1, this.p);
  
  private boolean r = true;
  
  private boolean s = false;
  
  private View t;
  
  private int u = 153;
  
  private WebView v;
  
  private TextView w;
  
  private FrameLayout x;
  
  private TextView y;
  
  private cq z;
  
  public al(Context paramContext, int paramInt, String paramString, b paramb) {
    super(paramContext);
    this.b = paramContext;
    this.z = cq.a(paramContext);
    this.A = SDKManager.getInstance(paramContext);
    e();
    a(paramContext, paramInt, paramString);
    c(paramContext);
    a();
    setBackgroundColor(-1);
    this.W = new ArrayList();
    this.W.clear();
    this.ab = paramb;
  }
  
  private void a() {
    if (!bi.c(this.b)) {
      this.w.setVisibility(0);
      this.v.setVisibility(4);
      this.y.setText("加载失败");
    } 
  }
  
  private void a(int paramInt1, int paramInt2) {
    this.ad.post(new ax(this, paramInt1, paramInt2));
    SystemClock.sleep(10L);
  }
  
  private void a(Context paramContext) {
    String str = "";
    if (this.z.v() != null)
      str = "access_token=" + this.z.v(); 
    this.C = "?" + str + "&" + "os" + "=" + "1" + "&" + "serviceid" + "=" + SDKManager.getGameServerId(paramContext) + "&" + "service" + "=" + cv.c() + "&" + "productid" + "=" + SDKManager.getProductId(paramContext) + "&" + "platform" + "=" + "android" + "&" + "timestamp" + "=" + this.R + "&" + "sign" + "=" + f();
    this.G = "http://i.yingxiong.com/wcenter/Client" + this.C;
    this.F = this.G;
    bp.a("FloatWindow url=" + this.F);
  }
  
  private void a(Context paramContext, int paramInt, String paramString) {
    if (paramInt == 1) {
      a(paramContext);
      return;
    } 
    if (paramInt == 2) {
      b(paramContext);
      return;
    } 
    a(paramContext, paramString);
  }
  
  private void a(Context paramContext, String paramString) {
    String str = "";
    if (this.z.v() != null)
      str = "access_token=" + this.z.v(); 
    if (paramString.contains("?")) {
      this.C = "&" + str + "&" + "os" + "=" + "1" + "&" + "serviceid" + "=" + SDKManager.getGameServerId(paramContext) + "&" + "service" + "=" + cv.c() + "&" + "productid" + "=" + SDKManager.getProductId(paramContext) + "&" + "platform" + "=" + "android" + "&" + "timestamp" + "=" + this.R + "&" + "sign" + "=" + f();
    } else {
      this.C = "?" + str + "&" + "os" + "=" + "1" + "&" + "serviceid" + "=" + SDKManager.getGameServerId(paramContext) + "&" + "service" + "=" + cv.c() + "&" + "productid" + "=" + SDKManager.getProductId(paramContext) + "&" + "platform" + "=" + "android" + "&" + "timestamp" + "=" + this.R + "&" + "sign" + "=" + f();
    } 
    this.F = paramString + this.C;
    bp.a("FloatWindow url=" + this.F);
  }
  
  private void a(WebView paramWebView) {
    if (Build.VERSION.SDK_INT >= 19)
      try {
        bp.a("callJsPaySuccess");
        ay ay = new ay();
        this(this);
        paramWebView.evaluateJavascript("callJsPaySuccess()", ay);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    paramWebView.loadUrl("javascript:callJsPaySuccess()");
  }
  
  private void a(String paramString) {
    try {
      if (!TextUtils.isEmpty(paramString)) {
        String str = paramString.replaceAll("&amp;", "&");
        JSONObject jSONObject = new JSONObject();
        this(str);
        a(jSONObject.optString("u"), jSONObject.optString("d"));
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private void a(String paramString1, String paramString2) {
    bp.a("resetShareInfo, url:" + paramString1 + " ,title:" + paramString2);
    if (!TextUtils.isEmpty(paramString1))
      this.V = paramString1; 
    if (!TextUtils.isEmpty(paramString2))
      this.U = paramString2; 
  }
  
  private void b() {
    this.s = true;
    (new au(this)).start();
  }
  
  private void b(Context paramContext) {
    String str = "";
    if (this.z.v() != null)
      str = "access_token=" + this.z.v(); 
    this.E = "?" + str + "&" + "os" + "=" + "1" + "&" + "serviceid" + "=" + SDKManager.getGameServerId(paramContext) + "&" + "service" + "=" + cv.c() + "&" + "productid" + "=" + SDKManager.getProductId(paramContext) + "&" + "platform" + "=" + "android" + "&" + "timestamp" + "=" + this.R + "&" + "sign" + "=" + f();
    this.H = "http://i.yingxiong.com/wcenter/custom" + this.E;
    this.F = this.H;
    bp.a("FloatWindow url=" + this.F);
  }
  
  @SuppressLint({"NewApi"})
  private void b(WebView paramWebView) {
    if (Build.VERSION.SDK_INT >= 19)
      try {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        String str = stringBuilder.append(this.a).append("c;").toString();
        ao ao = new ao();
        this(this);
        paramWebView.evaluateJavascript(str, ao);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    paramWebView.loadUrl("javascript:" + this.a + ";window.local_obj.shareInfo('{\"d\":\"'+ c.d + '\",\"t\":\"' + c.t + '\",\"u\":\"' + c.u +'\"}');");
  }
  
  private void b(String paramString) {
    bp.a("try_shareText, msg:" + paramString);
    Intent intent = new Intent();
    intent.setAction("android.intent.action.SEND");
    intent.putExtra("android.intent.extra.TEXT", paramString);
    intent.setType("text/plain");
    this.b.startActivity(intent);
  }
  
  private void c() {
    this.t.setVisibility(0);
    this.s = true;
    (new aw(this)).start();
  }
  
  private void c(Context paramContext) {
    LinearLayout linearLayout1 = new LinearLayout(paramContext);
    linearLayout1.setOrientation(1);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
    addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams);
    RelativeLayout relativeLayout = new RelativeLayout(paramContext);
    relativeLayout.setBackgroundColor(-1579547);
    relativeLayout.setGravity(16);
    linearLayout1.addView((View)relativeLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, df.a(paramContext, 48.0F)));
    this.y = new TextView(paramContext);
    this.y.setSingleLine();
    this.y.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    this.y.setTextSize(2, 20.0F);
    this.y.setTextColor(-16514044);
    this.y.setGravity(17);
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, df.a(paramContext, 30.0F));
    layoutParams3.addRule(13);
    layoutParams3.leftMargin = df.a(paramContext, 90.0F);
    layoutParams3.rightMargin = df.a(paramContext, 90.0F);
    relativeLayout.addView((View)this.y, (ViewGroup.LayoutParams)layoutParams3);
    this.d = new FrameLayout(paramContext);
    this.c = new Button(paramContext);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.c.setBackgroundDrawable((Drawable)ca.a(this.b, ca.l, ca.m));
    int i = df.a(paramContext, 10.0F);
    this.d.setPadding(i, i, i, i);
    layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams3.addRule(9);
    layoutParams3.addRule(13);
    this.d.addView((View)this.c, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(df.a(paramContext, 13.0F), df.a(paramContext, 23.0F)));
    relativeLayout.addView((View)this.d, (ViewGroup.LayoutParams)layoutParams3);
    this.f = new FrameLayout(paramContext);
    this.e = new Button(paramContext);
    this.f.setId(321);
    this.e.setBackgroundDrawable((Drawable)ca.a(this.b, ca.a, ca.b));
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams3.addRule(11);
    layoutParams3.addRule(13);
    this.f.setPadding(df.a(paramContext, 5.0F), df.a(paramContext, 10.0F), df.a(paramContext, 10.0F), df.a(paramContext, 10.0F));
    this.f.addView((View)this.e, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(df.a(paramContext, 20.0F), df.a(paramContext, 20.0F)));
    relativeLayout.addView((View)this.f, (ViewGroup.LayoutParams)layoutParams3);
    this.h = new FrameLayout(paramContext);
    this.g = new Button(paramContext);
    this.g.setBackgroundDrawable((Drawable)ca.a(this.b, ca.n, ca.o));
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams3.addRule(0, this.f.getId());
    layoutParams3.addRule(13);
    this.h.setPadding(df.a(paramContext, 5.0F), df.a(paramContext, 10.0F), df.a(paramContext, 10.0F), df.a(paramContext, 10.0F));
    this.h.addView((View)this.g, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(df.a(paramContext, 20.0F), df.a(paramContext, 20.0F)));
    relativeLayout.addView((View)this.h, (ViewGroup.LayoutParams)layoutParams3);
    FrameLayout frameLayout1 = new FrameLayout(paramContext);
    linearLayout1.addView((View)frameLayout1, (ViewGroup.LayoutParams)layoutParams);
    linearLayout1 = new LinearLayout(paramContext);
    linearLayout1.setOrientation(1);
    this.o = new LinearLayout(paramContext);
    linearLayout1.addView((View)this.o, (ViewGroup.LayoutParams)this.q);
    this.o.setBackgroundColor(Color.rgb(195, 195, 198));
    this.o.setGravity(16);
    View view3 = new View(paramContext);
    this.o.addView(view3, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(1, 1, 3.0F));
    this.i = new LinearLayout(paramContext);
    this.i.setOrientation(1);
    this.i.setGravity(1);
    this.k = new ImageView(paramContext);
    this.k.setBackgroundDrawable(ca.p.a(paramContext));
    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(bz.a(60), bz.a(60));
    this.i.addView((View)this.k, (ViewGroup.LayoutParams)layoutParams2);
    this.j = new TextView(paramContext);
    this.j.setText("发送给朋友");
    this.j.setTextColor(Color.rgb(83, 83, 83));
    this.j.setTextSize(12.0F);
    this.j.setGravity(1);
    this.i.addView((View)this.j);
    this.o.addView((View)this.i);
    View view2 = new View(paramContext);
    this.o.addView(view2, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(1, 1, 2.0F));
    this.l = new LinearLayout(paramContext);
    this.l.setOrientation(1);
    this.l.setGravity(1);
    this.n = new ImageView(paramContext);
    this.n.setBackgroundDrawable(ca.q.a(paramContext));
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(bz.a(60), bz.a(60));
    this.l.addView((View)this.n, (ViewGroup.LayoutParams)layoutParams1);
    this.m = new TextView(paramContext);
    this.m.setText("刷新页面");
    this.m.setTextSize(12.0F);
    this.m.setGravity(1);
    this.m.setTextColor(Color.rgb(83, 83, 83));
    this.l.addView((View)this.m, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    this.o.addView((View)this.l);
    View view1 = new View(paramContext);
    this.o.addView(view1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(1, 1, 3.0F));
    this.o.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.p = bz.a(145);
    this.t = new View(paramContext);
    this.t.setBackgroundColor(Color.argb(this.u, 0, 0, 0));
    this.t.setVisibility(8);
    this.t.setOnClickListener(this);
    linearLayout1.addView(this.t, (ViewGroup.LayoutParams)layoutParams);
    this.x = new FrameLayout(paramContext);
    this.x.setVisibility(8);
    this.x.setOnTouchListener(new aq(this));
    i = df.a(paramContext, 110.0F);
    FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i, i);
    layoutParams4.gravity = 17;
    LinearLayout linearLayout2 = new LinearLayout(paramContext);
    this.x.addView((View)linearLayout2, (ViewGroup.LayoutParams)layoutParams4);
    linearLayout2.setOrientation(1);
    i = df.a(paramContext, 10.0F);
    linearLayout2.setPadding(i, i, i, i);
    linearLayout2.setBackgroundColor(Color.argb(200, 0, 0, 0));
    linearLayout2.addView(new View(paramContext), (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(1, 0, 1.0F));
    linearLayout2.addView((View)new ProgressBar(this.b, null, 16842871));
    TextView textView = new TextView(paramContext);
    textView.setText("加载中...");
    textView.setTextColor(-1);
    textView.setPadding(0, 10, 0, 0);
    textView.setGravity(1);
    linearLayout2.addView((View)textView);
    linearLayout2.addView(new View(paramContext), (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(1, 0, 1.0F));
    FrameLayout frameLayout2 = new FrameLayout(paramContext);
    frameLayout1.addView((View)frameLayout2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    frameLayout1.addView((View)this.x, (ViewGroup.LayoutParams)layoutParams);
    frameLayout1.addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams);
    this.w = new TextView(paramContext);
    this.w.setVisibility(8);
    this.w.setText("世界上最遥远的距离，莫过于网络链接失败");
    this.w.setGravity(17);
    this.w.setTextSize(16.0F);
    this.w.setTextColor(Color.parseColor("#666666"));
    frameLayout2.addView((View)this.w, (ViewGroup.LayoutParams)layoutParams);
    this.v = new WebView(paramContext);
    this.v.setBackgroundColor(-1);
    frameLayout2.addView((View)this.v, (ViewGroup.LayoutParams)layoutParams);
    this.v.getSettings().setJavaScriptEnabled(true);
    this.v.setScrollBarStyle(33554432);
    this.v.requestFocus();
    this.v.addJavascriptInterface(getHtmlObject(), "local_obj");
    this.v.setWebChromeClient((WebChromeClient)new ar(this));
    this.v.setWebViewClient(new as(this));
    this.v.setOnKeyListener(new at(this));
    this.v.loadUrl(this.F);
  }
  
  private void d() {
    b(this.v);
    (new Handler()).postDelayed(new an(this), 10L);
  }
  
  private void e() {
    this.R = Long.valueOf(System.currentTimeMillis() / 1000L).toString();
  }
  
  private String f() {
    return bf.a(new String[] { "access_token", this.z.v(), "platform", "android", "timestamp", this.R });
  }
  
  private Object getHtmlObject() {
    return new ap(this);
  }
  
  public void onClick(View paramView) {
    if (paramView == this.e || paramView == this.f) {
      ((Activity)this.b).finish();
      return;
    } 
    if (paramView == this.c || paramView == this.d) {
      if (this.v.canGoBack()) {
        this.v.goBack();
        this.aa = true;
        bp.a("isOnReceivedTitle = " + this.aa);
        return;
      } 
      ((Activity)this.b).finish();
      return;
    } 
    if (paramView == this.g || paramView == this.h) {
      if (!this.s) {
        if (this.r) {
          c();
          return;
        } 
        b();
      } 
      return;
    } 
    if (paramView == this.t || paramView == this.o) {
      b();
      return;
    } 
    if (paramView == this.k || paramView == this.i || paramView == this.j) {
      d();
      b();
      return;
    } 
    if (paramView == this.l || paramView == this.n || paramView == this.m) {
      b();
      if (!bi.c(this.b)) {
        this.w.setVisibility(0);
        this.w.setText("世界上最遥远距离，莫过于网络连接失败");
        this.v.setVisibility(4);
        this.y.setText("加载失败");
        return;
      } 
      this.v.reload();
      this.w.setVisibility(4);
      this.v.setVisibility(0);
      this.y.setText(this.U);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */