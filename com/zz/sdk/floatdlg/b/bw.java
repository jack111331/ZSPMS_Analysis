package com.zz.sdk.floatdlg.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
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
import com.zz.sdk.a.br;
import com.zz.sdk.a.bv;
import com.zz.sdk.a.gt;
import com.zz.sdk.b.v;
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

public class bw extends Fragment implements View.OnClickListener, a {
  private static final int j = 90;
  
  protected ImageView a;
  
  protected EditText b;
  
  protected FancyButton c;
  
  public String d;
  
  private Context e;
  
  private ImageView f;
  
  private LinearLayout g;
  
  private v h;
  
  private boolean i = false;
  
  private View k;
  
  private EditText l;
  
  private String m;
  
  private Handler n = new Handler();
  
  private Timer o = null;
  
  private int p = 90;
  
  private void a(View paramView) {
    try {
      a();
      paramView.findViewById(ci.a(this.e, 2131296408)).setOnClickListener(this);
      this.k = paramView.findViewById(ci.a(this.e, 2131296352));
      this.l = (EditText)paramView.findViewById(ci.a(this.e, 2131296392));
      this.l.setHint(cv.q(this.m));
      this.l.setHintTextColor(getResources().getColor(ci.a(this.e, 2131034299)));
      this.b = (EditText)paramView.findViewById(ci.a(this.e, 2131296407));
      EditText editText = this.b;
      bx bx = new bx();
      this(this);
      editText.setOnFocusChangeListener(bx);
      this.c = (FancyButton)paramView.findViewById(ci.a(this.e, 2131296395));
      this.c.setOnClickListener(this);
      paramView.findViewById(ci.a(this.e, 2131296410)).setOnClickListener(this);
      this.f = (ImageView)paramView.findViewById(ci.a(this.e, 2131296283));
      this.f.setOnClickListener(this);
      this.g = (LinearLayout)paramView.findViewById(ci.a(this.e, 2131296508));
      this.g.setOnClickListener(this);
      this.a = (ImageView)paramView.findViewById(ci.a(this.e, 2131296532));
      this.a.setOnClickListener(this);
    } catch (android.content.res.Resources.NotFoundException notFoundException) {}
  }
  
  private void a(String paramString) {
    h.a(this.e, false);
    a.a().a(this.e, this.d, paramString, 5, new ca(this));
  }
  
  private void a(String paramString1, int paramInt, String paramString2) {
    h.a(this.e, false);
    a.a().a(this.e, paramString1, paramInt, paramString2, new ce(this));
  }
  
  private void a(String paramString1, String paramString2) {
    h.a(this.e, ci.a(this.e, 2131165272), false);
    a.a().a(this.e, this.d, paramString1, paramString2, 5, new by(this, paramString1));
  }
  
  private void b() {
    c();
    cc cc = new cc(this);
    this.o = new Timer();
    this.o.schedule(cc, 0L, 1000L);
  }
  
  private void c() {
    if (this.o != null) {
      this.o.purge();
      this.o.cancel();
      this.o = null;
      this.i = true;
    } 
  }
  
  public void a() {
    try {
      this.h = (cq.a(this.e)).a;
      this.d = cq.a(this.e).v();
      if (this.h.i == 1) {
        this.m = cq.a(this.e).a();
        if (TextUtils.isEmpty(this.m))
          this.m = this.h.b; 
        return;
      } 
      this.m = cq.a(this.e).a();
    } catch (Exception exception) {}
  }
  
  public void a(Boolean paramBoolean) {
    if (paramBoolean.booleanValue())
      a(this.m, 5, cq.a(this.e).j()); 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == ci.a(this.e, 2131296395)) {
      String str = h.b(this.e, this.m);
      if (str != null) {
        if (!this.i) {
          a(str);
          return;
        } 
        (new br(this.e, ci.a(this.e, 2131230726), this)).show();
      } 
      return;
    } 
    if (i == ci.a(this.e, 2131296408)) {
      String str = h.b(this.e, this.m);
      if (str != null) {
        String str1 = this.b.getText().toString();
        if (TextUtils.isEmpty(str1)) {
          cv.r(getString(ci.a(this.e, 2131165249)));
          return;
        } 
        a(str, str1);
      } 
      return;
    } 
    if (i == ci.a(this.e, 2131296532)) {
      getActivity().getSupportFragmentManager().popBackStack();
      return;
    } 
    if (i == ci.a(this.e, 2131296283) || i == ci.a(this.e, 2131296508)) {
      getActivity().finish();
      getActivity().overridePendingTransition(0, 0);
      return;
    } 
    if (i == ci.a(this.e, 2131296410)) {
      bv.a(false);
      bv.a((Activity)getActivity(), gt.class, (Map)bv.a());
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    bp.a("FM...onCreateView");
    View view = paramLayoutInflater.inflate(ci.a(this.e, 2130903112), paramViewGroup, false);
    a(view);
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    c();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */