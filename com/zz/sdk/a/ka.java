package com.zz.sdk.a;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.zz.sdk.i.h;

class ka extends ClickableSpan {
  ka(jy paramjy) {}
  
  public void onClick(View paramView) {
    h.a(this.a.b, "库洛游戏隐私政策");
  }
  
  public void updateDrawState(TextPaint paramTextPaint) {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */