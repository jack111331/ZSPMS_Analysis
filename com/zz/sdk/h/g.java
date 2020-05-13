package com.zz.sdk.h;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.zz.sdk.floatdlg.FloatDialog;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class g implements View.OnClickListener {
  public static final int a = 1;
  
  private static final int aj = 100;
  
  public static final int b = 2000;
  
  private static final int f = 0;
  
  private static final int g = 2;
  
  private static final int h = 3;
  
  private static final int i = 4;
  
  private static final int j = 5;
  
  private static final int k = 200;
  
  private static g n = null;
  
  private static final String r = "1";
  
  private final String A = "serviceid";
  
  private final String B = "access_token";
  
  private final String C = "platform";
  
  private final String D = "sign";
  
  private final String E = "timestamp";
  
  private boolean F = true;
  
  private int G;
  
  private int H;
  
  private FrameLayout I;
  
  private FrameLayout J;
  
  private LinearLayout K;
  
  private LinearLayout L;
  
  private LinearLayout M;
  
  private LinearLayout N;
  
  private LinearLayout O;
  
  private FrameLayout P;
  
  private FrameLayout Q;
  
  private FrameLayout R;
  
  private FrameLayout S;
  
  private ImageView T;
  
  private ImageView U;
  
  private ImageView V;
  
  private ImageView W;
  
  private ImageView X;
  
  private ImageView Y;
  
  private ImageView Z;
  
  private ImageView aa;
  
  private ImageView ab;
  
  private TextView ac;
  
  private TextView ad;
  
  private TextView ae;
  
  private TextView af;
  
  private ImageView ag;
  
  private long ah;
  
  private long ai;
  
  private boolean ak = false;
  
  private n al;
  
  public Handler c = new h(this);
  
  private Activity d;
  
  private float e;
  
  private AlphaAnimation l;
  
  private boolean m = false;
  
  private boolean o = false;
  
  private boolean p = false;
  
  private boolean q = false;
  
  private final String s = "android";
  
  private final String t = "kwmxhalqho#wjnz@@";
  
  private String u;
  
  private String v;
  
  private String w = "service_name";
  
  private final String x = "productid";
  
  private final String y = "os";
  
  private final String z = "service";
  
  private g(Activity paramActivity) {
    bp.a("FloatView");
    this.d = paramActivity;
    this.e = (paramActivity.getResources().getDisplayMetrics()).density;
    s();
    d();
  }
  
  protected static g a(Activity paramActivity) {
    if (n == null)
      n = new g(paramActivity); 
    return n;
  }
  
  private String a(String paramString) {
    try {
      bp.a("FloatView...sha1");
      MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
      messageDigest.update(paramString.getBytes());
      StringBuffer stringBuffer = new StringBuffer();
      this();
      byte[] arrayOfByte = messageDigest.digest();
      for (byte b = 0; b < arrayOfByte.length; b++) {
        byte b1 = arrayOfByte[b];
        int i = b1;
        if (b1 < 0)
          i = b1 + 256; 
        if (i < 16)
          stringBuffer.append("0"); 
        stringBuffer.append(Integer.toHexString(i));
      } 
      String str = stringBuffer.toString();
    } catch (Exception exception) {
      exception = null;
    } 
    return (String)exception;
  }
  
  private String a(HashMap paramHashMap) {
    bp.a("FloatView...doPackParams");
    return a(paramHashMap, "kwmxhalqho#wjnz@@");
  }
  
  private String a(HashMap paramHashMap, String paramString) {
    bp.a("FloatView...encodeMd5Parameter");
    ArrayList<Comparable> arrayList = new ArrayList(paramHashMap.keySet());
    Collections.sort(arrayList);
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < paramHashMap.size(); b++) {
      String str1 = (String)arrayList.get(b);
      if (!"sign".equals(str1) && !"market".equals(str1)) {
        String str2 = (String)paramHashMap.get(arrayList.get(b));
        stringBuilder.append(str1).append("=").append(str2);
      } 
    } 
    stringBuilder.append(paramString);
    bp.a("FloatWindow encodeMd5Parameter: " + stringBuilder.toString());
    String str = a(paramString);
    StringBuffer stringBuffer = new StringBuffer(cv.b(stringBuilder.toString()));
    stringBuffer.append(str);
    str = cv.b(stringBuffer.toString());
    bp.a("FloatWindow sign:" + str);
    return str;
  }
  
  private String a(String... paramVarArgs) {
    bp.a("FloatView...packParams");
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramVarArgs != null && paramVarArgs.length > 0)
      for (byte b = 0; b < paramVarArgs.length; b += 2)
        hashMap.put(paramVarArgs[b], paramVarArgs[b + 1]);  
    return a(hashMap);
  }
  
  private void a(Activity paramActivity, int paramInt) {
    bp.a("FloatView...showFloatView");
    try {
      Intent intent = new Intent();
      this((Context)paramActivity, FloatDialog.class);
      paramActivity.startActivity(intent.putExtra("position", paramInt));
    } catch (Exception exception) {}
  }
  
  private void a(View paramView, Interpolator paramInterpolator) {
    bp.a("FloatView...setAnim");
    if (this.l == null) {
      this.l = new AlphaAnimation(0.3F, 1.0F);
      this.l.setDuration(300L);
      this.l.setFillAfter(true);
      this.l.setInterpolator(paramInterpolator);
    } 
    paramView.startAnimation((Animation)this.l);
  }
  
  private void a(TextView paramTextView, String paramString) {
    bp.a("FloatView...setText");
    paramTextView.setText(paramString);
    paramTextView.setPadding(0, b(2), 0, 0);
    paramTextView.setVisibility(0);
  }
  
  private int b(int paramInt) {
    return (int)(paramInt * this.e);
  }
  
  public static g b() {
    return n;
  }
  
  private void b(boolean paramBoolean) {
    bp.a("FloatView...setAllNews");
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b(8), b(8));
    layoutParams.setMargins(b(4), b(4), b(4), b(4));
    if (paramBoolean) {
      if (this.F) {
        layoutParams.gravity = 8388661;
      } else {
        layoutParams.gravity = 8388659;
      } 
      this.X.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      this.X.setVisibility(0);
      return;
    } 
    this.X.setVisibility(8);
  }
  
  private void c(boolean paramBoolean) {
    bp.a("FloatView...setServiceNews");
    if (paramBoolean) {
      bp.a("FloatView...setServiceNews if show");
      if (this.F) {
        this.Y.setVisibility(0);
        this.aa.setVisibility(8);
        return;
      } 
      this.Y.setVisibility(8);
      this.aa.setVisibility(0);
      return;
    } 
    bp.a("FloatView...setServiceNews else not show");
    this.Y.setVisibility(8);
    this.aa.setVisibility(8);
  }
  
  private void d(boolean paramBoolean) {
    bp.a("FloatView...setSafeNews");
    if (paramBoolean) {
      bp.a("FloatView...setSafeNews if show");
      if (this.F) {
        this.Z.setVisibility(0);
        this.ab.setVisibility(8);
        return;
      } 
      this.Z.setVisibility(8);
      this.ab.setVisibility(0);
      return;
    } 
    bp.a("FloatView...setSafeNews else not show");
    this.Z.setVisibility(8);
    this.ab.setVisibility(8);
  }
  
  private String r() {
    return a(new String[] { "access_token", this.v, "platform", "android", "timestamp", this.u });
  }
  
  private void s() {
    bp.a("FloatView...initUI");
    this.I = new FrameLayout((Context)this.d);
    this.I.setFocusable(true);
    this.I.setClickable(true);
    this.I.setEnabled(true);
    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b(153), b(42));
    this.K = new LinearLayout((Context)this.d);
    this.K.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.K.setVisibility(8);
    this.K.setBackgroundDrawable(ca.i.a((Context)this.d));
    this.K.setGravity(16);
    this.I.addView((View)this.K);
    this.L = x();
    this.K.addView((View)this.L);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
    this.P = new FrameLayout((Context)this.d);
    this.L.addView((View)this.P, (ViewGroup.LayoutParams)layoutParams);
    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
    this.T = new ImageView((Context)this.d);
    this.P.addView((View)this.T, (ViewGroup.LayoutParams)layoutParams3);
    this.Y = z();
    this.P.addView((View)this.Y);
    this.ac = y();
    this.L.addView((View)this.ac);
    this.M = x();
    this.K.addView((View)this.M);
    this.Q = new FrameLayout((Context)this.d);
    this.M.addView((View)this.Q, (ViewGroup.LayoutParams)layoutParams);
    this.U = new ImageView((Context)this.d);
    this.Q.addView((View)this.U, (ViewGroup.LayoutParams)layoutParams3);
    this.Z = z();
    this.Q.addView((View)this.Z);
    this.ad = y();
    this.M.addView((View)this.ad);
    this.N = x();
    this.K.addView((View)this.N);
    this.R = new FrameLayout((Context)this.d);
    this.N.addView((View)this.R, (ViewGroup.LayoutParams)layoutParams);
    this.V = new ImageView((Context)this.d);
    this.R.addView((View)this.V, (ViewGroup.LayoutParams)layoutParams3);
    this.ab = z();
    this.R.addView((View)this.ab);
    this.ae = y();
    this.N.addView((View)this.ae);
    this.O = x();
    this.K.addView((View)this.O);
    this.S = new FrameLayout((Context)this.d);
    this.O.addView((View)this.S, (ViewGroup.LayoutParams)layoutParams);
    this.W = new ImageView((Context)this.d);
    this.S.addView((View)this.W, (ViewGroup.LayoutParams)layoutParams3);
    this.aa = z();
    this.S.addView((View)this.aa);
    this.af = y();
    this.O.addView((View)this.af);
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(b(44), b(44));
    this.J = new FrameLayout((Context)this.d);
    this.ag = new ImageView((Context)this.d);
    l();
    this.ag.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.J.addView((View)this.ag);
    this.X = z();
    this.J.addView((View)this.X);
    this.I.addView((View)this.J);
    this.T.setOnClickListener(this);
    this.L.setOnClickListener(this);
    this.M.setOnClickListener(this);
    this.U.setOnClickListener(this);
    this.N.setOnClickListener(this);
    this.V.setOnClickListener(this);
    this.O.setOnClickListener(this);
    this.W.setOnClickListener(this);
    this.K.setOnClickListener(this);
    m();
    this.ag.measure(0, 0);
    this.G = b(44);
    this.H = b(44);
  }
  
  private void t() {
    bp.a("FloatView...clickService");
    this.v = cq.a((Context)this.d).v();
    if (this.al == null) {
      Toast.makeText((Context)this.d, "点击了客服, 但没有设置监听!", 0).show();
    } else {
      this.al.f();
    } 
    if (this.c != null)
      this.c.sendEmptyMessage(5); 
    this.p = false;
  }
  
  private void u() {
    bp.a("FloatView...clickSafe");
    this.v = cq.a((Context)this.d).v();
    if (TextUtils.isEmpty(this.v)) {
      v();
    } else if (this.al == null) {
      Toast.makeText((Context)this.d, "点击了安全, 但没有设置监听!", 0).show();
    } else {
      this.al.g();
    } 
    if (this.c != null)
      this.c.sendEmptyMessage(5); 
    this.q = false;
  }
  
  private void v() {
    bp.a("FloatView...showTipDialog");
    (new AlertDialog.Builder((Context)this.d)).setTitle("温馨提示").setMessage("请先登录游戏").setNegativeButton("确定", new k(this)).setCancelable(false).create().show();
  }
  
  private void w() {
    bp.a("FloatView...clickClose");
    (new AlertDialog.Builder((Context)this.d)).setTitle("温馨提示").setMessage("关闭悬浮图标，下次启动游戏将重新开启").setPositiveButton("关闭浮标", new m(this)).setNegativeButton("取消", new l(this)).setCancelable(false).create().show();
  }
  
  private LinearLayout x() {
    bp.a("FloatView...createWMLinearLayout");
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
    LinearLayout linearLayout = new LinearLayout((Context)this.d);
    linearLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    linearLayout.setOrientation(1);
    linearLayout.setGravity(17);
    return linearLayout;
  }
  
  private TextView y() {
    bp.a("FloatView...createLLWWTextView");
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
    TextView textView = new TextView((Context)this.d);
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    textView.setTextSize(2, 9.0F);
    textView.setTextColor(Color.rgb(44, 39, 36));
    textView.setOnClickListener(this);
    return textView;
  }
  
  private ImageView z() {
    bp.a("FloatView...createRedPoint");
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b(8), b(8));
    layoutParams.gravity = 8388661;
    ImageView imageView = new ImageView((Context)this.d);
    imageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    imageView.setOnClickListener(this);
    imageView.setVisibility(8);
    return imageView;
  }
  
  public void a(int paramInt) {
    bp.a("FloatView...spread");
    if (System.currentTimeMillis() - this.ai > 100L) {
      p();
      bp.a("FloatView...spread if");
      a(this.d, paramInt);
      this.ag.setAlpha(0.0F);
      this.c.sendEmptyMessageDelayed(4, 200L);
      this.ak = true;
      this.ah = System.currentTimeMillis();
    } 
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {
    boolean bool = true;
    bp.a("FloatView...startRotateAnimation");
    RotateAnimation rotateAnimation = new RotateAnimation(paramInt1, paramInt2, 1, 0.5F, 1, 0.5F);
    rotateAnimation.setDuration(200L);
    rotateAnimation.setFillAfter(true);
    this.ag.startAnimation((Animation)rotateAnimation);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.X.getLayoutParams();
    paramInt1 = 8388611;
    if (this.F)
      paramInt1 = 8388613; 
    if (paramInt3 == 1) {
      layoutParams.gravity = paramInt1 | 0x50;
    } else {
      layoutParams.gravity = paramInt1 | 0x30;
    } 
    this.X.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    if (this.m)
      bool = false; 
    this.m = bool;
  }
  
  public void a(n paramn) {
    this.al = paramn;
  }
  
  public void a(boolean paramBoolean) {
    this.F = paramBoolean;
  }
  
  public boolean a() {
    return this.m;
  }
  
  public void c() {
    bp.a("FloatView...onDestroy");
    if (this.c != null) {
      p();
      this.c.removeMessages(3);
      this.c.removeMessages(4);
      this.c.removeMessages(5);
    } 
    this.al = null;
    this.l = null;
    this.d = null;
    this.c = null;
    n = null;
    this.v = null;
    this.o = false;
    this.p = false;
    this.q = false;
  }
  
  public void d() {
    try {
      bp.a("红点访问网络");
      bp.a("FloatView...requestRedPoint");
      Thread thread = new Thread();
      i i = new i();
      this(this);
      this(i);
      thread.start();
    } catch (Exception exception) {}
  }
  
  public int e() {
    return this.G;
  }
  
  public int f() {
    return this.H;
  }
  
  public boolean g() {
    return this.F;
  }
  
  public boolean h() {
    return this.ak;
  }
  
  public View i() {
    return (View)this.I;
  }
  
  public View j() {
    return (View)this.K;
  }
  
  public View k() {
    return (View)this.ag;
  }
  
  public void l() {
    this.d.runOnUiThread(new j(this));
  }
  
  public void m() {
    bp.a("FloatView...showRight");
    this.F = true;
    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
    layoutParams2.gravity = 8388611;
    this.J.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.c.sendEmptyMessage(5);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
    layoutParams.setMargins(this.G + b(3), 0, 0, 0);
    this.L.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = new LinearLayout.LayoutParams(-2, -1);
    layoutParams.setMargins(0, 0, b(4), 0);
    this.O.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.L.setPadding(b(11), b(4), b(11), b(4));
    this.M.setPadding(b(11), b(4), b(11), b(4));
    this.N.setPadding(0, b(7), 0, b(7));
    this.O.setPadding(b(6), 0, b(6), 0);
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(b(18), b(18));
    this.T.setBackgroundDrawable(ca.f.a((Context)this.d));
    this.T.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    a(this.ac, "客服");
    this.U.setBackgroundDrawable(ca.g.a((Context)this.d));
    a(this.ad, "安全");
    this.U.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.Q.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
    this.ae.setVisibility(8);
    this.V.setBackgroundDrawable(ca.h.a((Context)this.d));
    this.V.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -1));
    this.R.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -1));
    this.W.setBackgroundDrawable(ca.j.a((Context)this.d));
    this.W.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(b(8), b(8)));
    this.af.setVisibility(8);
  }
  
  public void n() {
    bp.a("FloatView...showLeft");
    this.F = false;
    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
    layoutParams2.gravity = 8388613;
    this.J.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.c.sendEmptyMessage(5);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
    layoutParams.setMargins(b(4), 0, 0, 0);
    this.L.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = new LinearLayout.LayoutParams(-2, -2);
    layoutParams.setMargins(0, 0, this.G + b(3), 0);
    this.O.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.L.setPadding(b(6), 0, b(6), 0);
    this.M.setPadding(0, b(7), 0, b(7));
    this.N.setPadding(b(11), b(4), b(11), b(4));
    this.O.setPadding(b(11), b(4), b(11), b(4));
    this.T.setBackgroundDrawable(ca.j.a((Context)this.d));
    this.T.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(b(8), b(8)));
    this.ac.setVisibility(8);
    this.ad.setVisibility(8);
    this.U.setBackgroundDrawable(ca.h.a((Context)this.d));
    this.U.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -1));
    this.Q.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -1));
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(b(18), b(18));
    this.V.setBackgroundDrawable(ca.g.a((Context)this.d));
    a(this.ae, "安全");
    this.V.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.R.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
    this.W.setBackgroundDrawable(ca.f.a((Context)this.d));
    a(this.af, "客服");
    this.W.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
  }
  
  public void o() {
    bp.a("FloatView...close");
    if (System.currentTimeMillis() - this.ah > 100L) {
      p();
      bp.a("FloatView...close if");
      this.I.setVisibility(8);
      this.K.setVisibility(8);
      this.c.sendEmptyMessageDelayed(3, 100L);
      this.ak = false;
      this.ai = System.currentTimeMillis();
    } 
  }
  
  public void onClick(View paramView) {
    bp.a("FloatView...onClick");
    if (System.currentTimeMillis() - this.ah >= 100L) {
      if (this.ak) {
        o();
      } else if (paramView == this.I) {
        a(0);
      } 
      if (paramView == this.L || paramView == this.T || paramView == this.ac || paramView == this.P || paramView == this.Y) {
        if (this.F) {
          t();
          return;
        } 
        w();
        return;
      } 
      if (paramView == this.M || paramView == this.U || paramView == this.ad || paramView == this.Q || paramView == this.Z) {
        if (this.F)
          u(); 
        return;
      } 
      if (paramView == this.N || paramView == this.V || paramView == this.ae || paramView == this.R || paramView == this.ab) {
        if (!this.F)
          u(); 
        return;
      } 
      if (paramView == this.O || paramView == this.W || paramView == this.af || paramView == this.S || paramView == this.aa) {
        if (this.F) {
          w();
          return;
        } 
        t();
      } 
    } 
  }
  
  public void p() {
    bp.a("FloatView...removeMessages");
    if (this.c != null) {
      this.c.removeMessages(2);
      this.c.removeMessages(0);
      this.c.removeMessages(1);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\h\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */