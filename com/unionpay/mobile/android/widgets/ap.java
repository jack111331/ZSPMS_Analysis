package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.utils.h;
import org.json.JSONObject;

public final class ap extends aa implements Handler.Callback {
  private a c = null;
  
  private TextView o = null;
  
  private Handler p = null;
  
  private int q = 0;
  
  public ap(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString) {
    super(paramContext, paramInt, paramJSONObject, paramString);
    j();
    this.c = null;
  }
  
  public ap(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString, byte paramByte) {
    super(paramContext, paramInt, paramJSONObject, paramString);
    j();
  }
  
  private void a(boolean paramBoolean, String paramString) {
    this.o.setText(paramString);
    this.o.setEnabled(paramBoolean);
  }
  
  private void j() {
    int i = this.a;
    i = com.unionpay.mobile.android.global.a.b;
    this.b.a((InputFilter)new InputFilter.LengthFilter(6));
    this.b.a(2);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, b.n);
    layoutParams1.addRule(9, -1);
    layoutParams1.addRule(15, -1);
    this.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    LinearLayout linearLayout = new LinearLayout(this.d);
    linearLayout.setOrientation(1);
    linearLayout.setBackgroundColor(-3419943);
    new LinearLayout.LayoutParams(1, -1);
    this.o = new TextView(getContext());
    this.o.setGravity(17);
    this.o.setText(c.bD.w);
    this.o.setTextColor(h.a(-10705958, -5846275, -5846275, -6710887));
    this.o.setTextSize(b.k);
    this.o.setOnClickListener(new aq(this));
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
    this.b.a((View)this.o, layoutParams);
  }
  
  public final void a(int paramInt) {
    this.p = new Handler(this);
    ar ar = new ar(this, paramInt);
    a(false, String.format(c.bD.x, new Object[] { Integer.valueOf(paramInt) }));
    ar.start();
  }
  
  public final void a(a parama) {
    this.c = parama;
  }
  
  public final boolean b() {
    boolean bool = true;
    if (!this.i && 6 != a().length())
      bool = false; 
    return bool;
  }
  
  protected final String d() {
    return "_input_msg";
  }
  
  public final boolean handleMessage(Message paramMessage) {
    boolean bool1 = true;
    switch (paramMessage.what) {
      default:
        return false;
      case 1:
        if (c.bD != null)
          a(true, c.bD.y); 
        this.p = null;
        return bool1;
      case 0:
        break;
    } 
    this.q = paramMessage.arg1;
    boolean bool2 = bool1;
    if (c.bD != null) {
      a(false, String.format(c.bD.x, new Object[] { Integer.valueOf(paramMessage.arg1) }));
      bool2 = bool1;
    } 
    return bool2;
  }
  
  public static interface a {
    void a(z param1z);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */