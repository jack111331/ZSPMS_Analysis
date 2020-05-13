package com.unionpay.mobile.android.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.utils.g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class u extends LinearLayout implements View.OnClickListener {
  private Context a = null;
  
  private EditText b = null;
  
  private ImageView c = null;
  
  private boolean d = true;
  
  private b e = null;
  
  private a f = null;
  
  private int g;
  
  private Drawable h;
  
  private TextView i = null;
  
  private LinearLayout j;
  
  private View.OnClickListener k = new v(this);
  
  private TextWatcher l = new w(this);
  
  private View.OnFocusChangeListener m = new x(this);
  
  public u(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
    setOrientation(0);
    this.g = com.unionpay.mobile.android.global.a.n;
    setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    setFocusable(true);
    TextView textView = new TextView(this.a);
    textView.setPadding(g.a(this.a, 10.0F), 0, 0, 0);
    textView.setEms(4);
    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
    layoutParams3.gravity = 19;
    addView((View)textView, (ViewGroup.LayoutParams)layoutParams3);
    textView.setGravity(19);
    textView.setTextSize(com.unionpay.mobile.android.global.b.k);
    textView.setTextColor(-13421773);
    this.i = textView;
    this.i.setVisibility(8);
    RelativeLayout relativeLayout1 = new RelativeLayout(this.a);
    relativeLayout1.setGravity(21);
    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -1);
    layoutParams3.gravity = 19;
    addView((View)relativeLayout1, (ViewGroup.LayoutParams)layoutParams4);
    LinearLayout linearLayout = new LinearLayout(this.a);
    linearLayout.setGravity(21);
    linearLayout.setId(linearLayout.hashCode());
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
    layoutParams2.addRule(11, -1);
    layoutParams2.addRule(15, -1);
    layoutParams2.rightMargin = g.a(this.a, 10.0F);
    linearLayout.setVisibility(8);
    relativeLayout1.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams2);
    this.j = linearLayout;
    RelativeLayout relativeLayout2 = new RelativeLayout(this.a);
    relativeLayout2.setGravity(16);
    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
    layoutParams5.addRule(9, -1);
    layoutParams5.addRule(15, -1);
    layoutParams5.addRule(0, linearLayout.getId());
    layoutParams5.rightMargin = g.a(this.a, 10.0F);
    relativeLayout1.addView((View)relativeLayout2, (ViewGroup.LayoutParams)layoutParams5);
    this.c = new ImageView(this.a);
    this.c.setId(this.c.hashCode());
    this.c.setBackgroundDrawable(this.h);
    this.c.setOnClickListener(this.k);
    this.c.setVisibility(8);
    this.c.setId(this.c.hashCode());
    this.c.setAdjustViewBounds(true);
    int i = g.a(this.a, 30.0F);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(i, i);
    layoutParams1.addRule(11, -1);
    layoutParams1.addRule(15, -1);
    relativeLayout2.addView((View)this.c, (ViewGroup.LayoutParams)layoutParams1);
    this.b = new EditText(this.a);
    this.b.setSingleLine();
    this.b.setTextSize(com.unionpay.mobile.android.global.b.k);
    this.b.setTextColor(-10066330);
    this.b.setHintTextColor(-6710887);
    this.b.setBackgroundDrawable(null);
    this.b.setGravity(16);
    this.b.setPadding(g.a(this.a, 10.0F), 0, 0, 0);
    this.b.addTextChangedListener(this.l);
    if (this.d)
      this.b.setOnFocusChangeListener(this.m); 
    layoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams1.addRule(0, this.c.getId());
    layoutParams1.addRule(15, -1);
    layoutParams1.addRule(9, -1);
    relativeLayout2.addView((View)this.b, (ViewGroup.LayoutParams)layoutParams1);
  }
  
  public final TextView a(String paramString) {
    if (this.i != null && !TextUtils.isEmpty(paramString)) {
      this.i.setVisibility(0);
      this.i.setText(paramString);
    } 
    return this.i;
  }
  
  public final u a(Drawable paramDrawable) {
    if (paramDrawable != null)
      this.c.setBackgroundDrawable(paramDrawable); 
    return this;
  }
  
  public final void a() {
    this.d = false;
    if (this.b != null) {
      this.b.setKeyListener(null);
      this.b.setFocusable(false);
      if (this.c != null && this.c.getVisibility() == 0)
        this.c.setVisibility(8); 
    } 
  }
  
  public final void a(int paramInt) {
    if (this.b != null)
      this.b.setInputType(paramInt); 
  }
  
  public final void a(InputFilter paramInputFilter) {
    InputFilter[] arrayOfInputFilter = new InputFilter[1];
    arrayOfInputFilter[0] = paramInputFilter;
    if (this.b != null) {
      InputFilter[] arrayOfInputFilter2 = this.b.getFilters();
      if (arrayOfInputFilter2 == null) {
        this.b.setFilters(arrayOfInputFilter);
        return;
      } 
      InputFilter[] arrayOfInputFilter1 = new InputFilter[arrayOfInputFilter2.length + arrayOfInputFilter.length];
      System.arraycopy(arrayOfInputFilter2, 0, arrayOfInputFilter1, 0, arrayOfInputFilter2.length);
      System.arraycopy(arrayOfInputFilter, 0, arrayOfInputFilter1, arrayOfInputFilter2.length, arrayOfInputFilter.length);
      this.b.setFilters(arrayOfInputFilter1);
    } 
  }
  
  public final void a(TextWatcher paramTextWatcher) {
    if (this.b != null && paramTextWatcher != null)
      this.b.addTextChangedListener(paramTextWatcher); 
  }
  
  public final void a(View paramView, LinearLayout.LayoutParams paramLayoutParams) {
    if (paramView != null && this.j != null) {
      this.j.addView(paramView, (ViewGroup.LayoutParams)paramLayoutParams);
      this.j.setVisibility(0);
    } 
  }
  
  public final void a(TextView.OnEditorActionListener paramOnEditorActionListener) {
    if (this.b != null && this.d)
      this.b.setOnEditorActionListener(paramOnEditorActionListener); 
  }
  
  public final void a(a parama) {
    this.f = parama;
  }
  
  public final void a(b paramb) {
    this.e = paramb;
    if (this.b != null)
      this.b.setOnClickListener(this); 
  }
  
  public final String b() {
    String str = null;
    if (this.b != null)
      str = this.b.getText().toString(); 
    return str;
  }
  
  public final void b(int paramInt) {
    if (this.b != null)
      this.b.setSelection(paramInt); 
  }
  
  public final void b(String paramString) {
    if (this.b != null && paramString != null)
      this.b.setHint(paramString); 
  }
  
  public final Editable c() {
    Editable editable = null;
    if (this.b != null)
      editable = this.b.getText(); 
    return editable;
  }
  
  public final void c(String paramString) {
    if (this.b != null && paramString != null)
      this.b.setText(paramString); 
  }
  
  public final void d() {
    if (this.b != null)
      this.b.setLongClickable(false); 
  }
  
  public final void e() {
    if (this.b != null) {
      this.b.setText("");
      if (this.e != null)
        this.e.e(); 
    } 
  }
  
  public final void f() {
    ((Activity)this.a).getWindow().setSoftInputMode(3);
    int i = Build.VERSION.SDK_INT;
    String str = null;
    if (i >= 16) {
      str = "setShowSoftInputOnFocus";
    } else if (i >= 14) {
      str = "setSoftInputShownOnFocus";
    } 
    if (str == null) {
      this.b.setInputType(0);
      return;
    } 
    try {
      Method method = EditText.class.getMethod(str, new Class[] { boolean.class });
      method.setAccessible(true);
      method.invoke(this.b, new Object[] { Boolean.valueOf(false) });
    } catch (NoSuchMethodException noSuchMethodException) {
      this.b.setInputType(0);
      noSuchMethodException.printStackTrace();
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
    } catch (IllegalArgumentException illegalArgumentException) {
      illegalArgumentException.printStackTrace();
    } catch (InvocationTargetException invocationTargetException) {
      invocationTargetException.printStackTrace();
    } 
  }
  
  public final void onClick(View paramView) {
    if (this.e != null)
      this.e.a_(); 
  }
  
  public final void setOnTouchListener(View.OnTouchListener paramOnTouchListener) {
    if (this.b != null)
      this.b.setOnTouchListener(paramOnTouchListener); 
  }
  
  public static interface a {
    void a(boolean param1Boolean);
  }
  
  public static interface b extends a {
    void a_();
    
    void e();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widget\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */