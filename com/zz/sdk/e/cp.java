package com.zz.sdk.e;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.LinearLayout;

class cp extends LinearLayout implements Checkable {
  CheckBox a;
  
  public cp(co paramco, Context paramContext) {
    super(paramContext);
  }
  
  void a(CheckBox paramCheckBox) {
    this.a = paramCheckBox;
  }
  
  public boolean isChecked() {
    return this.a.isChecked();
  }
  
  public void setChecked(boolean paramBoolean) {
    this.a.setChecked(paramBoolean);
  }
  
  public void toggle() {
    this.a.toggle();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */