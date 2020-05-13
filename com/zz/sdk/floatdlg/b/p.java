package com.zz.sdk.floatdlg.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zz.sdk.a.br;
import com.zz.sdk.a.bv;
import com.zz.sdk.a.gt;
import com.zz.sdk.c.a;
import com.zz.sdk.d.a;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.Map;
import java.util.Timer;

public class p extends Fragment implements View.OnClickListener, a {
  private static final int j = 90;
  
  private static String m;
  
  protected EditText a;
  
  protected ImageView b;
  
  protected EditText c;
  
  protected FancyButton d;
  
  protected FancyButton e;
  
  protected TextView f;
  
  public String g;
  
  protected ImageView h;
  
  private boolean i = false;
  
  private View k;
  
  private View l;
  
  private Context n;
  
  private ImageView o;
  
  private LinearLayout p;
  
  private Handler q = new Handler();
  
  private Timer r = null;
  
  private int s = 90;
  
  public static p a(String paramString) {
    p p1 = new p();
    m = paramString;
    return p1;
  }
  
  private void a() {
    b();
    x x = new x(this);
    this.r = new Timer();
    this.r.schedule(x, 0L, 1000L);
  }
  
  private void a(View paramView) {
    try {
      this.g = cq.a(this.n).v();
      this.o = (ImageView)paramView.findViewById(ci.a(this.n).a(2131296283));
      this.o.setOnClickListener(this);
      this.p = (LinearLayout)paramView.findViewById(ci.a(this.n).a(2131296508));
      this.p.setOnClickListener(this);
      this.h = (ImageView)paramView.findViewById(ci.a(this.n).a(2131296532));
      this.h.setOnClickListener(this);
      paramView.findViewById(ci.a(this.n).a(2131296410)).setOnClickListener(this);
      paramView.findViewById(ci.a(this.n).a(2131296408)).setOnClickListener(this);
      this.l = paramView.findViewById(ci.a(this.n).a(2131296352));
      this.k = paramView.findViewById(ci.a(this.n).a(2131296349));
      this.b = (ImageView)paramView.findViewById(ci.a(this.n).a(2131296406));
      this.b.setOnClickListener(this);
      this.a = (EditText)paramView.findViewById(ci.a(this.n).a(2131296392));
      EditText editText1 = this.a;
      q q = new q();
      this(this);
      editText1.addTextChangedListener(q);
      editText1 = this.a;
      r r = new r();
      this(this);
      editText1.setOnFocusChangeListener(r);
      this.c = (EditText)paramView.findViewById(ci.a(this.n).a(2131296407));
      EditText editText2 = this.c;
      s s = new s();
      this(this);
      editText2.setOnFocusChangeListener(s);
      this.d = (FancyButton)paramView.findViewById(ci.a(this.n).a(2131296395));
      this.d.setOnClickListener(this);
      this.a.setText("");
    } catch (Exception exception) {}
  }
  
  private void a(String paramString1, int paramInt, String paramString2) {
    h.a(this.n, false);
    a.a().a(this.n, paramString1, paramInt, paramString2, new z(this));
  }
  
  private void a(String paramString1, String paramString2) {
    h.a(this.n, ci.a(this.n).a(2131165272), false);
    a.a().a(this.n, this.g, m, paramString1, paramString2, 6, new t(this, paramString1));
  }
  
  private void b() {
    if (this.r != null) {
      this.r.purge();
      this.r.cancel();
      this.r = null;
      this.i = true;
    } 
  }
  
  private void b(String paramString) {
    h.a(this.n, false);
    a.a().a(this.n, this.g, paramString, 6, new v(this));
  }
  
  public void a(Boolean paramBoolean) {
    if (paramBoolean.booleanValue())
      a(this.a.getText().toString(), 6, cq.a(this.n).j()); 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == ci.a(this.n).a(2131296395)) {
      String str = h.b((TextView)this.a);
      if (str != null) {
        if (str.equals(m)) {
          cv.r(getString(ci.a(this.n).a(2131165380)));
          return;
        } 
        if (!this.i) {
          b(str);
          return;
        } 
        (new br(this.n, ci.a(this.n, 2131230726), this)).show();
      } 
      return;
    } 
    if (i == ci.a(this.n, 2131296408)) {
      String str = h.b((TextView)this.a);
      if (str != null) {
        String str1 = this.c.getText().toString();
        if (TextUtils.isEmpty(str1)) {
          cv.r(getString(ci.a(this.n, 2131165249)));
          return;
        } 
        a(str, str1);
      } 
      return;
    } 
    if (i == ci.a(this.n, 2131296406)) {
      this.a.setText("");
      return;
    } 
    if (i == ci.a(this.n, 2131296532)) {
      getActivity().getSupportFragmentManager().popBackStack();
      return;
    } 
    if (i == ci.a(this.n, 2131296283) || i == ci.a(this.n, 2131296508)) {
      getActivity().finish();
      getActivity().overridePendingTransition(0, 0);
      return;
    } 
    if (i == ci.a(this.n, 2131296410)) {
      bv.a(false);
      bv.a((Activity)getActivity(), gt.class, (Map)bv.a());
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.n = (Context)getActivity();
    bp.a("FM...onCreateView");
    View view = paramLayoutInflater.inflate(ci.a(this.n).a(2130903111), paramViewGroup, false);
    a(view);
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    b();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */