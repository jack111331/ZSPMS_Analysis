package com.zz.sdk.e;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;
import com.zz.sdk.ParamChain;
import com.zz.sdk.h;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.cd;
import com.zz.sdk.i.ce;
import com.zz.sdk.i.cf;
import com.zz.sdk.i.cg;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.df;
import com.zz.sdk.i.g;
import com.zz.sdk.i.t;
import java.text.DecimalFormat;
import java.util.ArrayList;

abstract class a extends LinearLayout implements View.OnClickListener, bg {
  protected static final boolean b = false;
  
  protected static final boolean c = false;
  
  protected static final long e = 2000L;
  
  protected static final int g = 0;
  
  protected static final int h = 1;
  
  protected static final int i = 2;
  
  protected static final int j = 3;
  
  protected static final long k = 300L;
  
  protected static final long l = 400L;
  
  protected static final long m = 400L;
  
  public ImageView a;
  
  protected DecimalFormat d = new DecimalFormat(cg.a.a());
  
  protected Context f;
  
  protected final h n = new b(this);
  
  private ParamChain o;
  
  private AsyncTask p;
  
  private ArrayList q;
  
  private com.zz.sdk.g.a r;
  
  private i s;
  
  private long t;
  
  private long u;
  
  private String v;
  
  private t w;
  
  public a(Context paramContext, ParamChain paramParamChain) {
    super(paramContext);
    bp.a("popup BaseLayout ctx:" + paramContext);
    this.f = paramContext;
    this.o = paramParamChain.grow(getClass().getName());
    this.s = i.a;
    this.w = (t)paramParamChain.get("global.util_connection", t.class);
    if (this.w == null) {
      this.w = t.a(paramContext);
      this.o.add("global.util_connection", this.w, h.b);
    } 
    this.p = null;
    this.q = new ArrayList();
    a(paramContext, this.o);
  }
  
  protected static EditText a(Context paramContext, cg paramcg, ce paramce, cf paramcf, int paramInt) {
    bp.a("popup create_normal_input ctx:" + paramContext);
    EditText editText = new EditText(paramContext);
    editText.setSingleLine();
    if (paramcg != null)
      editText.setHint(paramcg.a()); 
    if (paramce != null)
      editText.setTextColor(paramce.a()); 
    editText.setGravity(16);
    if (paramInt > 0) {
      editText.setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(paramInt) });
      editText.setTag(Integer.valueOf(paramInt));
    } 
    paramcf.a((TextView)editText);
    a((TextView)editText);
    return editText;
  }
  
  protected static LinearLayout.LayoutParams a(int paramInt) {
    switch (paramInt) {
      default:
        return new LinearLayout.LayoutParams(-2, -2);
      case 0:
        return new LinearLayout.LayoutParams(-2, -1);
      case 1:
        return new LinearLayout.LayoutParams(-1, -1);
      case 3:
        break;
    } 
    return new LinearLayout.LayoutParams(-1, -2);
  }
  
  protected static LinearLayout a(Context paramContext, LinearLayout paramLinearLayout) {
    bp.a("popup create_normal_pannel ctx:" + paramContext);
    LinearLayout linearLayout = new LinearLayout(paramContext);
    linearLayout.setOrientation(1);
    LinearLayout.LayoutParams layoutParams = a(3);
    layoutParams.topMargin = cc.a.a();
    paramLinearLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams);
    return linearLayout;
  }
  
  protected static TextView a(Context paramContext, cg paramcg) {
    bp.a("popup create_normal_label ctx:" + paramContext);
    TextView textView = new TextView(paramContext);
    if (paramcg != null)
      textView.setText(paramcg.a()); 
    textView.setSingleLine();
    textView.setTextColor(ce.g.a());
    textView.setGravity(19);
    cf.b.a(textView);
    return textView;
  }
  
  protected static String a(View paramView, f paramf, int paramInt) {
    View view2 = paramView;
    if (paramView instanceof ViewAnimator)
      view2 = ((ViewAnimator)paramView).getCurrentView(); 
    if (view2 == null)
      return null; 
    View view1 = view2.findViewById(paramf.a());
    if (view1 instanceof TextView) {
      CharSequence charSequence = ((TextView)view1).getText();
      if (charSequence != null) {
        charSequence = charSequence.toString().trim();
        if (paramInt == 1) {
          Object object = view1.getTag();
          if (object instanceof Integer && ((Integer)object).intValue() != charSequence.length())
            charSequence = ""; 
        } 
        return (String)charSequence;
      } 
    } 
    return null;
  }
  
  public static String a(String paramString) {
    if (paramString == null)
      return null; 
    char[] arrayOfChar = paramString.toCharArray();
    for (byte b = 0; b < arrayOfChar.length; b++) {
      if (arrayOfChar[b] == '　') {
        arrayOfChar[b] = (char)' ';
      } else if (arrayOfChar[b] > '＀' && arrayOfChar[b] < '｟') {
        arrayOfChar[b] = (char)(char)(arrayOfChar[b] - 65248);
      } 
    } 
    return new String(arrayOfChar);
  }
  
  protected static void a(View paramView, f paramf) {
    bp.a("popup set_child_focuse");
    View view = paramView;
    if (paramView instanceof ViewAnimator)
      view = ((ViewAnimator)paramView).getCurrentView(); 
    if (view != null) {
      paramView = view.findViewById(paramf.a());
      if (paramView != null)
        paramView.requestFocus(); 
    } 
  }
  
  protected static void a(View paramView, boolean paramBoolean) {
    bp.a("popup show_popup_enable_auto_close");
    if (paramView != null) {
      Object object;
      if (paramBoolean) {
        object = Boolean.TRUE;
      } else {
        object = null;
      } 
      paramView.setTag(object);
    } 
  }
  
  protected static void a(View paramView1, boolean paramBoolean, View paramView2) {
    bp.a("popup show_popup");
    if (paramView1 != null) {
      if (paramView1.getVisibility() != 0) {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(300L);
        animationSet.addAnimation((Animation)new AlphaAnimation(0.2F, 1.0F));
        animationSet.setFillBefore(true);
        paramView1.setVisibility(0);
        paramView1.startAnimation((Animation)animationSet);
        paramView1.requestFocus();
        cv.a(paramView1.getContext(), paramView1);
      } 
      if (paramView2 != null && paramView1 instanceof FrameLayout) {
        FrameLayout frameLayout = (FrameLayout)paramView1;
        frameLayout.removeAllViews();
        if (paramView2.getLayoutParams() == null)
          paramView2.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 17)); 
        if (paramView2.getAnimation() == null) {
          AnimationSet animationSet = new AnimationSet(true);
          animationSet.setDuration(400L);
          animationSet.addAnimation((Animation)new AlphaAnimation(0.2F, 1.0F));
          animationSet.setFillBefore(true);
          paramView2.setAnimation((Animation)animationSet);
        } 
        frameLayout.addView(paramView2);
        paramView2.getAnimation().start();
      } 
      a(paramView1, paramBoolean);
    } 
  }
  
  protected static void a(TextView paramTextView) {
    a(paramTextView, ca.s.a(paramTextView.getContext()));
  }
  
  protected static void a(TextView paramTextView, int paramInt) {
    a(paramTextView, (Drawable)new ColorDrawable(paramInt));
  }
  
  protected static void a(TextView paramTextView, Drawable paramDrawable) {
    Object object1 = g.a(paramTextView, "mCursorDrawable");
    Object object2 = object1;
    if (object1 == null) {
      Object object = g.a(paramTextView, "mEditor");
      if (object == null)
        return; 
      object2 = g.a(object, "mCursorDrawable");
    } 
    if (object2 instanceof Drawable[])
      ((Drawable[])object2)[0] = paramDrawable; 
  }
  
  protected static TextView b(Context paramContext, cg paramcg) {
    bp.a("popup create_little_label ctx:" + paramContext);
    TextView textView = new TextView(paramContext);
    if (paramcg != null)
      textView.setText(paramcg.a()); 
    textView.setSingleLine();
    textView.setTextColor(ce.g.a());
    textView.setGravity(19);
    cf.h.a(textView);
    return textView;
  }
  
  private void b(Context paramContext, LinearLayout paramLinearLayout) {
    bp.a("popup createView");
    FrameLayout frameLayout2 = new FrameLayout(paramContext);
    frameLayout2.setBackgroundColor(ce.a.a());
    paramLinearLayout.addView((View)frameLayout2, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, cc.b.a()));
    frameLayout2.setId(e.i.a());
    frameLayout2.setPadding(0, 0, 0, 0);
    TextView textView2 = a(paramContext, (cg)null);
    frameLayout2.addView((View)textView2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 17));
    textView2.setId(e.c.a());
    textView2.setGravity(17);
    textView2.setTextColor(ce.b.a());
    cd.i.a((View)textView2);
    cf.a.a(textView2);
    LinearLayout linearLayout2 = new LinearLayout(paramContext);
    frameLayout2.addView((View)linearLayout2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1, 17));
    linearLayout2.setOrientation(0);
    LinearLayout linearLayout1 = new LinearLayout(this.f);
    linearLayout1.setGravity(16);
    linearLayout1.setClickable(true);
    linearLayout1.setOnClickListener(this);
    linearLayout1.setId(e.b.a());
    linearLayout1.setBackgroundColor(ce.a.a());
    linearLayout2.addView((View)linearLayout1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(df.a(this.f, 45.0F), -1));
    this.a = new ImageView(paramContext);
    this.a.setId(e.a.a());
    this.a.setTag(Integer.valueOf(1));
    linearLayout1.addView((View)this.a, (ViewGroup.LayoutParams)a(2));
    this.a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.a.setImageDrawable((Drawable)ca.a(paramContext, ca.ah, ca.ai));
    this.a.setClickable(true);
    this.a.setOnClickListener(this);
    cd.a.a((View)this.a);
    linearLayout2.addView(new View(paramContext), (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1, 1.0F));
    TextView textView1 = new TextView(paramContext);
    textView1.setId(e.e.a());
    linearLayout2.addView((View)textView1, (ViewGroup.LayoutParams)a(0));
    textView1.setGravity(16);
    textView1.setTextColor(ce.e.a());
    cd.i.a((View)textView1);
    cf.k.a(textView1);
    textView1.setClickable(true);
    textView1.setOnClickListener(this);
    textView1.setVisibility(8);
    textView1.setText("充值记录");
    cd.a.a((View)textView1);
    ImageView imageView = new ImageView(paramContext);
    imageView.setBackgroundDrawable(ca.ar.a(paramContext));
    paramLinearLayout.addView((View)imageView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, cc.a(1.0F)));
    FrameLayout frameLayout3 = new FrameLayout(paramContext);
    paramLinearLayout.addView((View)frameLayout3, (ViewGroup.LayoutParams)a(1));
    View view = a(paramContext);
    view.setBackgroundColor(ce.c.a());
    frameLayout3.addView(view, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    FrameLayout frameLayout1 = new FrameLayout(paramContext);
    frameLayout3.addView((View)frameLayout1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    frameLayout1.setId(e.f.a());
    frameLayout1.setVisibility(8);
    frameLayout1.setBackgroundColor(-869059789);
    frameLayout1.setTag(null);
    frameLayout1.setOnClickListener(this);
    frameLayout1.setFocusable(true);
    frameLayout1.setFocusableInTouchMode(true);
  }
  
  protected static void b(View paramView) {
    bp.a("popup hide_popup");
    if (paramView != null && paramView.getVisibility() != 8) {
      AnimationSet animationSet = new AnimationSet(true);
      animationSet.setDuration(400L);
      animationSet.addAnimation((Animation)new AlphaAnimation(1.0F, 0.0F));
      animationSet.setFillBefore(true);
      paramView.startAnimation((Animation)animationSet);
      paramView.setVisibility(8);
      if (paramView instanceof ViewGroup)
        ((ViewGroup)paramView).removeAllViews(); 
    } 
  }
  
  protected static TextView c(Context paramContext, cg paramcg) {
    bp.a("popup create_normal_label_shadow ctx:" + paramContext);
    TextView textView = a(paramContext, paramcg);
    textView.setShadowLayer(0.5F, 0.5F, 0.5F, ce.f.a());
    textView.getPaint().setFakeBoldText(true);
    return textView;
  }
  
  private View v() {
    bp.a("popup popup_get_wait_panel");
    null = e();
    return (null != null && null.getVisibility() == 0) ? null.findViewById(e.k.a()) : null;
  }
  
  protected View a(Context paramContext) {
    FrameLayout frameLayout = new FrameLayout(paramContext);
    frameLayout.setId(e.j.a());
    return (View)frameLayout;
  }
  
  protected String a(f paramf) {
    null = findViewById(paramf.a());
    if (null instanceof TextView) {
      CharSequence charSequence = ((TextView)null).getText();
      if (charSequence != null)
        return charSequence.toString().trim(); 
    } 
    return null;
  }
  
  protected String a(f paramf1, f paramf2, int paramInt) {
    return a(findViewById(paramf1.a()), paramf2, paramInt);
  }
  
  protected void a(long paramLong, String paramString) {
    this.t = 0L;
    long l = paramLong;
    if (paramLong == -1L)
      l = 2000L; 
    this.u = l;
    this.v = paramString;
  }
  
  protected void a(Dialog paramDialog) {
    this.q.add(paramDialog);
  }
  
  protected abstract void a(Context paramContext, ParamChain paramParamChain);
  
  protected void a(DialogInterface paramDialogInterface) {
    this.q.remove(paramDialogInterface);
  }
  
  protected void a(View paramView) {
    a(true, paramView);
  }
  
  protected void a(View paramView, CharSequence paramCharSequence, h paramh) {
    bp.a("popup showPopup_Wait ctx:" + this.f);
    Context context = this.f;
    LinearLayout linearLayout = new LinearLayout(context);
    linearLayout.setId(e.k.a());
    linearLayout.setOrientation(1);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
    cd.b.a((ViewGroup.MarginLayoutParams)layoutParams);
    linearLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    linearLayout.setBackgroundDrawable(ca.t.a(context));
    cd.b.a((View)linearLayout);
    FrameLayout frameLayout = new FrameLayout(context);
    linearLayout.addView((View)frameLayout, (ViewGroup.LayoutParams)a(3));
    ProgressBar progressBar = new ProgressBar(context, null, 16842871);
    frameLayout.addView((View)progressBar, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 17));
    progressBar.setIndeterminate(true);
    if (paramh != null) {
      TextView textView1 = a(context, (cg)null);
      linearLayout.addView((View)textView1, (ViewGroup.LayoutParams)a(3));
      textView1.setId(e.h.a());
      textView1.setGravity(17);
      textView1.setTextColor(ce.l.a());
      textView1.setVisibility(8);
      cf.g.a(textView1);
    } 
    TextView textView = a(context, (cg)null);
    linearLayout.addView((View)textView, (ViewGroup.LayoutParams)a(3));
    textView.setId(e.g.a());
    textView.setGravity(17);
    textView.setSingleLine(false);
    if (paramCharSequence != null)
      textView.setText(paramCharSequence); 
    if (paramh != null)
      linearLayout.setTag((new c(this, paramh)).a()); 
    a(paramView, false, (View)linearLayout);
  }
  
  protected void a(f paramf, int paramInt) {
    bp.a("popup set_child_visibility");
    View view = findViewById(paramf.a());
    if (view != null)
      view.setVisibility(paramInt); 
  }
  
  protected void a(f paramf1, f paramf2) {
    a(findViewById(paramf1.a()), paramf2);
  }
  
  protected void a(f paramf, cg paramcg) {
    View view = findViewById(paramf.a());
    if (view instanceof TextView)
      ((TextView)view).setText(paramcg.a()); 
  }
  
  protected void a(f paramf, CharSequence paramCharSequence) {
    View view = findViewById(paramf.a());
    if (view instanceof TextView)
      ((TextView)view).setText(paramCharSequence); 
  }
  
  protected void a(f paramf, boolean paramBoolean) {
    View view = findViewById(paramf.a());
    if (view != null)
      view.setEnabled(paramBoolean); 
  }
  
  protected void a(cg paramcg) {
    a(true, paramcg.a());
  }
  
  protected void a(CharSequence paramCharSequence) {
    a(true, paramCharSequence);
  }
  
  protected void a(CharSequence paramCharSequence, h paramh) {
    a(e(), paramCharSequence, paramh);
  }
  
  protected void a(boolean paramBoolean, View paramView) {
    a(e(), paramBoolean, paramView);
  }
  
  protected void a(boolean paramBoolean, cg paramcg) {
    a(paramBoolean, paramcg.a());
  }
  
  protected void a(boolean paramBoolean, CharSequence paramCharSequence) {
    bp.a("popup showPopup_Tip ctx:" + this.f);
    Context context = this.f;
    LinearLayout linearLayout = new LinearLayout(context);
    linearLayout.setOrientation(1);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
    cd.b.a((ViewGroup.MarginLayoutParams)layoutParams);
    linearLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    linearLayout.setBackgroundDrawable(ca.t.a(context));
    cd.b.a((View)linearLayout);
    TextView textView = a(context, (cg)null);
    linearLayout.addView((View)textView, (ViewGroup.LayoutParams)a(3));
    textView.setSingleLine(false);
    textView.setGravity(17);
    textView.setText(paramCharSequence);
    a(paramBoolean, (View)linearLayout);
  }
  
  protected boolean a() {
    return false;
  }
  
  protected boolean a(int paramInt1, int paramInt2, Object paramObject) {
    ParamChain paramChain = getEnv();
    if (paramChain != null) {
      Handler handler = (Handler)paramChain.get("global.caller.msg_handler", Handler.class);
      Integer integer = (Integer)paramChain.get("global.caller.msg_what", Integer.class);
      if (handler != null && integer != null) {
        handler.obtainMessage(integer.intValue(), paramInt1, paramInt2, paramObject).sendToTarget();
        return true;
      } 
    } 
    return false;
  }
  
  protected boolean a(AsyncTask paramAsyncTask) {
    if (b(paramAsyncTask)) {
      this.p = null;
      return true;
    } 
    return false;
  }
  
  protected boolean a(Object paramObject) {
    boolean bool1 = false;
    bp.a("popup popup_check_active_wait");
    View view = v();
    boolean bool2 = bool1;
    if (view != null) {
      bool2 = bool1;
      if (paramObject == view.getTag())
        bool2 = true; 
    } 
    return bool2;
  }
  
  protected boolean a(boolean paramBoolean) {
    bp.a("popup callHost_exit");
    bf bf = getHost();
    if (bf != null) {
      bf.a(paramBoolean);
      return true;
    } 
    return false;
  }
  
  protected String b(f paramf, int paramInt) {
    return a((View)this, paramf, paramInt);
  }
  
  protected abstract void b(Context paramContext);
  
  protected void b(cg paramcg) {
    b(paramcg.a());
  }
  
  protected void b(String paramString) {
    Toast.makeText(this.f, paramString, 1).show();
  }
  
  protected void b(boolean paramBoolean) {
    a(e(), paramBoolean);
  }
  
  protected boolean b() {
    bp.a("popup callHost_back");
    bf bf = getHost();
    if (bf != null) {
      bf.a();
      return true;
    } 
    return false;
  }
  
  protected boolean b(AsyncTask paramAsyncTask) {
    return (paramAsyncTask == getCurrentTask());
  }
  
  protected void c() {
    bp.a("popup showPopup_Wait");
    a((CharSequence)null, (h)null);
  }
  
  protected void c(Context paramContext) {
    this.f = paramContext;
    setOrientation(1);
    setBackgroundDrawable(ca.u.a(paramContext));
    setGravity(17);
    b(paramContext, this);
    b(paramContext);
  }
  
  public boolean c(boolean paramBoolean) {
    boolean bool = false;
    bp.a("popup isExitEnabled:" + paramBoolean);
    if (paramBoolean && f())
      return bool; 
    if (this.u > 0L) {
      long l = SystemClock.uptimeMillis();
      if (l > this.t + this.u) {
        this.t = l;
        if (this.v == null || this.v.length() == 0) {
          b(cg.ap);
          return bool;
        } 
        b(this.v + "\n" + cg.ap.a());
        return bool;
      } 
    } 
    return true;
  }
  
  protected void d() {
    bp.a("popup tryHidePopup_Wait");
    View view = v();
    if (view != null) {
      view.setTag(null);
      b(e());
    } 
  }
  
  protected View e() {
    bp.a("popup popup_get_view");
    return findViewById(e.f.a());
  }
  
  protected boolean f() {
    bp.a("popup tryHidePopup");
    View view = e();
    if (view != null && view.getVisibility() == 0) {
      Object object = view.getTag();
      if (object instanceof Boolean && ((Boolean)object).booleanValue()) {
        b(view);
        return true;
      } 
    } 
    return false;
  }
  
  protected void g() {
    b(e());
  }
  
  protected Activity getActivity() {
    return (Activity)getEnv().get("global.ui_activity_instance", Activity.class);
  }
  
  protected t getConnectionUtil() {
    return this.w;
  }
  
  protected AsyncTask getCurrentTask() {
    return (this.p != null && !this.p.isCancelled()) ? this.p : null;
  }
  
  public ParamChain getEnv() {
    return this.o;
  }
  
  protected ParamChain getEnvForChild() {
    ParamChain paramChain = this.o.grow();
    paramChain.add("global.caller_env", this.o);
    return paramChain;
  }
  
  protected ParamChain getEnvOfCaller() {
    return (ParamChain)this.o.get("global.caller_env", ParamChain.class);
  }
  
  protected bf getHost() {
    bp.a("popup getHost");
    return (this.o != null) ? (bf)this.o.get("global.key_layout_factory.host", bf.class) : null;
  }
  
  public View getMainView() {
    bp.a("popup getMainView:" + this);
    return (View)this;
  }
  
  protected FrameLayout getSubjectContainer() {
    bp.a("popup getSubjectContainer");
    return (FrameLayout)findViewById(e.j.a());
  }
  
  public boolean h() {
    return (this.s == i.b || this.s == i.c);
  }
  
  public boolean i() {
    return (this.s == i.b);
  }
  
  public boolean j() {
    bp.a("popup onEnter");
    if (this.s != i.a)
      return false; 
    this.s = i.b;
    t();
    return true;
  }
  
  public boolean k() {
    bp.a("popup onPause");
    if (this.s == i.b) {
      this.s = i.c;
    } else if (this.s != i.c) {
      return false;
    } 
    u();
    return true;
  }
  
  public boolean l() {
    bp.a("popup onResume");
    if (this.s != i.b)
      if (this.s == i.c) {
        this.s = i.b;
      } else {
        return false;
      }  
    t();
    return true;
  }
  
  protected void m() {
    bp.a("popup clean");
    removeAllViews();
    q();
    s();
    o();
    r();
    if (this.o.containsKeyOwn("global.util_connection") != null)
      t.a(this.w); 
    this.w = null;
    if (this.o != null) {
      this.o.reset();
      this.o = null;
    } 
    this.f = null;
    this.d = null;
  }
  
  public boolean n() {
    bp.a("popup onExit");
    if (this.s != i.a && this.s == i.d)
      return false; 
    this.s = i.d;
    m();
    return true;
  }
  
  protected void o() {
    this.t = 0L;
    this.u = 0L;
    this.v = null;
  }
  
  public void onClick(View paramView) {
    e e = e.a(paramView.getId());
    switch (d.a[e.ordinal()]) {
      default:
        return;
      case 1:
      case 2:
        b();
      case 3:
        a(false);
      case 4:
        a();
      case 5:
        break;
    } 
    f();
  }
  
  protected Object p() {
    return this.o.remove("global.caller_ret");
  }
  
  protected void q() {
    if (this.p != null) {
      if (!this.p.isCancelled())
        this.p.cancel(true); 
      this.p = null;
    } 
  }
  
  protected void r() {
    for (Dialog dialog : this.q) {
      if (dialog.isShowing())
        dialog.dismiss(); 
    } 
    this.q.clear();
  }
  
  protected void s() {
    if (this.r != null) {
      u();
      this.r = null;
    } 
  }
  
  protected void setActivityControlInterface(com.zz.sdk.g.a parama) {
    s();
    this.r = parama;
    t();
  }
  
  protected void setCurrentTask(AsyncTask paramAsyncTask) {
    q();
    this.p = paramAsyncTask;
  }
  
  public void setTileTypeText(CharSequence paramCharSequence) {
    ((TextView)findViewById(e.c.a())).setText(paramCharSequence);
  }
  
  protected void set_child_focuse(f paramf) {
    a((View)this, paramf);
  }
  
  protected void t() {
    if (this.r != null) {
      bf bf = getHost();
      if (bf != null)
        bf.a(this.r); 
    } 
  }
  
  protected void u() {
    if (this.r != null) {
      bf bf = getHost();
      if (bf != null)
        bf.a(this.r); 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */