package com.zz.sdk.floatdlg.b;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zz.sdk.c.a;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.h;

public class br extends Fragment implements View.OnClickListener {
  protected ImageView a;
  
  private Context b;
  
  private ImageView c;
  
  private LinearLayout d;
  
  private TextView e;
  
  private TextView f;
  
  private TextView g;
  
  public static br a(String paramString1, String paramString2, String paramString3) {
    return new br();
  }
  
  private void a() {
    try {
      h.a(this.b, false);
      a a = a.a();
      Context context = this.b;
      String str = cq.a(this.b).v();
      bs bs = new bs();
      this(this);
      a.c(context, str, bs);
    } catch (Exception exception) {}
  }
  
  private void a(View paramView) {
    try {
      this.c = (ImageView)paramView.findViewById(ci.a(this.b, 2131296283));
      this.c.setOnClickListener(this);
      this.d = (LinearLayout)paramView.findViewById(ci.a(this.b, 2131296508));
      this.d.setOnClickListener(this);
      this.a = (ImageView)paramView.findViewById(ci.a(this.b, 2131296532));
      this.a.setOnClickListener(this);
      this.e = (TextView)paramView.findViewById(ci.a(this.b, 2131296624));
      this.f = (TextView)paramView.findViewById(ci.a(this.b, 2131296625));
      this.g = (TextView)paramView.findViewById(ci.a(this.b, 2131296627));
      a();
    } catch (Exception exception) {}
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == ci.a(this.b, 2131296532)) {
      getActivity().getSupportFragmentManager().popBackStack();
      return;
    } 
    if (i == ci.a(this.b, 2131296283) || i == ci.a(this.b, 2131296508)) {
      getActivity().finish();
      getActivity().overridePendingTransition(0, 0);
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.b = (Context)getActivity();
    bp.a("FM...onCreateView");
    View view = paramLayoutInflater.inflate(ci.a(this.b, 2130903127), paramViewGroup, false);
    a(view);
    return view;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */