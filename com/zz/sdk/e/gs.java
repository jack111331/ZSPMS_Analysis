package com.zz.sdk.e;

import android.text.Html;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Toast;
import com.zz.sdk.i.a;
import com.zz.sdk.i.cg;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.text.DecimalFormat;

class gs implements AdapterView.OnItemClickListener {
  gs(go paramgo) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
    Adapter adapter = paramAdapterView.getAdapter();
    if (adapter instanceof r) {
      go.a(this.a, true);
      go.a(this.a, String.valueOf(((r)adapter).b(paramInt)));
      go.a(this.a, Double.parseDouble(go.a(this.a)));
      if (go.b(this.a) >= go.c(this.a)) {
        double d1 = go.b(this.a);
        double d2 = go.c(this.a);
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        go.b(this.a, Double.parseDouble(decimalFormat.format(d1 - d2)));
        if (go.e(this.a) != null) {
          String str = String.format(cg.N.a(), new Object[] { go.a(this.a) });
          this.a.a(gv.j, (CharSequence)Html.fromHtml(str));
          str = String.format(cg.ag.a(), new Object[] { go.a(this.a) });
          ((FancyButton)this.a.findViewById(gv.o.a())).setText(str);
          go.e(this.a).setVisibility(0);
          if (a.a()) {
            go.g(this.a).setText(go.f(this.a) + "元余额将会存入你的游戏币账户");
          } else {
            go.g(this.a).setText(go.f(this.a) + "元余额将会存入你的" + "游戏币" + "账户");
          } 
        } 
        go.h(this.a).a(paramInt);
        return;
      } 
    } else {
      return;
    } 
    Toast.makeText(go.d(this.a), "面额值不够，请重新选择", 0).show();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\gs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */