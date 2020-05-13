package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;

public final class ah extends aa {
  private a c = null;
  
  private String o = null;
  
  private String p = null;
  
  public ah(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString) {
    this(paramContext, paramInt, paramJSONObject, paramString, (byte)0);
  }
  
  private ah(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString, byte paramByte) {
    super(paramContext, paramInt, paramJSONObject, paramString);
    this.o = j.a(paramJSONObject, "button_label");
    this.p = j.a(paramJSONObject, "button_action");
    this.b.a((InputFilter)new InputFilter.LengthFilter(11));
    this.b.a(2);
    if (this.o != null && this.o.length() > 0) {
      paramInt = this.a;
      paramInt = com.unionpay.mobile.android.global.a.b;
      RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, b.n);
      layoutParams1.addRule(9, -1);
      layoutParams1.addRule(15, -1);
      this.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
      TextView textView = new TextView(getContext());
      textView.setGravity(17);
      textView.setText(this.o);
      textView.setTextColor(-7829368);
      textView.setTextSize(b.k);
      textView.setOnClickListener(new ai(this));
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
      this.b.a((View)textView, layoutParams);
    } 
  }
  
  public final String a() {
    return this.b.b();
  }
  
  public final void a(a parama) {
    this.c = parama;
  }
  
  public final boolean b() {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: getfield i : Z
    //   6: ifeq -> 11
    //   9: iload_1
    //   10: ireturn
    //   11: aload_0
    //   12: getfield j : Ljava/lang/String;
    //   15: ifnull -> 47
    //   18: aload_0
    //   19: getfield j : Ljava/lang/String;
    //   22: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   25: ifne -> 47
    //   28: aload_0
    //   29: invokevirtual a : ()Ljava/lang/String;
    //   32: aload_0
    //   33: getfield j : Ljava/lang/String;
    //   36: invokevirtual matches : (Ljava/lang/String;)Z
    //   39: ifne -> 9
    //   42: iconst_0
    //   43: istore_1
    //   44: goto -> 9
    //   47: bipush #11
    //   49: aload_0
    //   50: invokevirtual a : ()Ljava/lang/String;
    //   53: invokevirtual length : ()I
    //   56: if_icmpne -> 42
    //   59: aload_0
    //   60: invokevirtual a : ()Ljava/lang/String;
    //   63: ldc '1'
    //   65: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   68: ifeq -> 42
    //   71: goto -> 9
  }
  
  protected final String d() {
    return "_input_phoneNO";
  }
  
  public static interface a {
    void e(String param1String);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */