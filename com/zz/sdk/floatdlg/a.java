package com.zz.sdk.floatdlg;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import com.zz.sdk.floatdlg.tabview.b;

class a implements b {
  a(FloatDialog paramFloatDialog) {}
  
  public void a(int paramInt, ImageView paramImageView, TextView paramTextView) {
    if (paramTextView.getText().equals("wiki"))
      this.a.startActivityForResult(new Intent((Context)this.a, WiKiActivity.class), 10001); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */