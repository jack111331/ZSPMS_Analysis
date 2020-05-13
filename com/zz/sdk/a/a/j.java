package com.zz.sdk.a.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zz.sdk.i.ci;

public class j {
  public final TextView a;
  
  public final ImageView b;
  
  public final View c;
  
  public j(i parami, View paramView) {
    Context context = paramView.getContext();
    this.a = (TextView)paramView.findViewById(ci.a(context, 2131296635));
    this.b = (ImageView)paramView.findViewById(ci.a(context, 2131296360));
    this.c = paramView;
    paramView.setTag(this);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */