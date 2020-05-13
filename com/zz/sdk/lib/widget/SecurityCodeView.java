package com.zz.sdk.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zz.sdk.i.ci;

public class SecurityCodeView extends RelativeLayout {
  private Context a;
  
  private EditText b;
  
  private TextView[] c;
  
  private StringBuffer d = new StringBuffer();
  
  private int e = 4;
  
  private String f;
  
  private q g;
  
  public SecurityCodeView(Context paramContext) {
    this(paramContext, null);
  }
  
  public SecurityCodeView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SecurityCodeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    this.c = new TextView[4];
    View.inflate(paramContext, ci.a(paramContext, 2130903145), (ViewGroup)this);
    this.b = (EditText)findViewById(ci.a(paramContext, 2131296658));
    this.c[0] = (TextView)findViewById(ci.a(paramContext, 2131296654));
    this.c[1] = (TextView)findViewById(ci.a(paramContext, 2131296655));
    this.c[2] = (TextView)findViewById(ci.a(paramContext, 2131296656));
    this.c[3] = (TextView)findViewById(ci.a(paramContext, 2131296657));
    this.b.setCursorVisible(false);
    c();
    b();
  }
  
  private void c() {
    this.b.addTextChangedListener(new o(this));
    this.b.setOnKeyListener(new p(this));
  }
  
  public boolean a() {
    null = true;
    try {
      if (this.e == 0) {
        this.e = 4;
        return null;
      } 
      if (this.d.length() > 0) {
        this.d.delete(this.e - 1, this.e);
        this.e--;
        this.f = this.d.toString();
        this.c[this.d.length()].setText("");
        this.c[this.d.length()].setBackgroundResource(ci.a(this.a, 2130837678));
        if (this.g != null)
          this.g.a(true); 
      } 
    } catch (Exception exception) {}
    return false;
  }
  
  public void b() {
    byte b = 0;
    try {
      this.d.delete(0, this.d.length());
      this.f = this.d.toString();
      while (b < this.c.length) {
        this.c[b].setText("");
        this.c[b].setBackgroundResource(ci.a(this.a, 2130837678));
        b++;
      } 
    } catch (Exception exception) {}
  }
  
  public String getCode() {
    return this.f;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setInputCompleteListener(q paramq) {
    this.g = paramq;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\lib\widget\SecurityCodeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */