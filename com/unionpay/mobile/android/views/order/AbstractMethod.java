package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.sdk.UPAgent;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbstractMethod extends LinearLayout implements a.b {
  protected static final int a = com.unionpay.mobile.android.global.b.a;
  
  protected Context b;
  
  protected String c;
  
  protected String d;
  
  protected b e;
  
  protected a f;
  
  private Button g;
  
  private RelativeLayout h;
  
  public AbstractMethod(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public AbstractMethod(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AbstractMethod(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext);
    this.b = paramContext;
    setOrientation(1);
  }
  
  protected static String a(JSONObject paramJSONObject, String paramString) {
    String str1 = null;
    String str2 = str1;
    if (paramJSONObject != null)
      try {
        str2 = paramJSONObject.getString(paramString);
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        str2 = str1;
      }  
    return str2;
  }
  
  public static void a(Context paramContext, String paramString) {
    if (com.unionpay.mobile.android.global.a.L) {
      k.a("uppay-TD", "event:" + paramString + ", keys:" + Arrays.toString((Object[])null) + ", values:" + Arrays.toString((Object[])null));
      UPAgent.onEvent(paramContext, paramString);
    } 
  }
  
  protected static void a(TextView paramTextView) {
    if (paramTextView != null) {
      paramTextView.setTextSize(com.unionpay.mobile.android.global.b.k);
      paramTextView.setTextColor(h.a(-10705958, -5846275, -5846275, -6710887));
    } 
  }
  
  protected static boolean a(String paramString) {
    return (paramString == null || paramString.length() == 0);
  }
  
  public final void a() {
    this.h = new RelativeLayout(this.b);
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
    addView((View)this.h, (ViewGroup.LayoutParams)layoutParams2);
    a(this.h);
    RelativeLayout relativeLayout1 = new RelativeLayout(this.b);
    addView((View)relativeLayout1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    b(relativeLayout1);
    RelativeLayout relativeLayout2 = new RelativeLayout(this.b);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    layoutParams1.topMargin = com.unionpay.mobile.android.global.a.f;
    addView((View)relativeLayout2, (ViewGroup.LayoutParams)layoutParams1);
    this.g = new Button(this.b);
    this.g.setText(e());
    this.g.setTextColor(h.a(com.unionpay.mobile.android.global.b.b, com.unionpay.mobile.android.global.b.c, com.unionpay.mobile.android.global.b.c, com.unionpay.mobile.android.global.b.d));
    this.g.setTextSize(com.unionpay.mobile.android.global.b.i);
    this.g.setOnClickListener(new a(this));
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.unionpay.mobile.android.global.b.n);
    layoutParams.addRule(15, -1);
    layoutParams.topMargin = com.unionpay.mobile.android.global.a.f;
    int i = g.a(this.b, 10.0F);
    layoutParams.rightMargin = i;
    layoutParams.leftMargin = i;
    relativeLayout2.addView((View)this.g, (ViewGroup.LayoutParams)layoutParams);
    relativeLayout2 = new RelativeLayout(this.b);
    addView((View)relativeLayout2, (ViewGroup.LayoutParams)layoutParams1);
    c(relativeLayout2);
    this.g.setEnabled(f());
  }
  
  public final void a(Drawable paramDrawable) {
    if (this.g != null && paramDrawable != null)
      this.g.setBackgroundDrawable(paramDrawable); 
  }
  
  public abstract void a(RelativeLayout paramRelativeLayout);
  
  public final void a(a.a parama) {}
  
  public final void a(a parama) {
    this.f = parama;
  }
  
  public final void a(b paramb) {
    this.e = paramb;
  }
  
  public final void a(boolean paramBoolean) {
    Button button = this.g;
    if (!paramBoolean) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    button.setEnabled(paramBoolean);
  }
  
  public abstract int b();
  
  public abstract void b(RelativeLayout paramRelativeLayout);
  
  public abstract a.a c();
  
  public abstract void c(RelativeLayout paramRelativeLayout);
  
  public final void c(String paramString) {}
  
  public final void c(String paramString1, String paramString2) {}
  
  public int d() {
    return 0;
  }
  
  public abstract String e();
  
  public abstract boolean f();
  
  protected final void g() {
    this.h.setVisibility(8);
  }
  
  public static interface a {
    void a(int param1Int1, boolean param1Boolean, int param1Int2, a.a param1a);
  }
  
  public static interface b {
    void a(String param1String1, String param1String2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\views\order\AbstractMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */