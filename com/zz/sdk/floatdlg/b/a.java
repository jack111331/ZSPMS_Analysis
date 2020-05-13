package com.zz.sdk.floatdlg.b;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.zz.sdk.a.br;
import com.zz.sdk.a.bv;
import com.zz.sdk.a.gt;
import com.zz.sdk.b.h;
import com.zz.sdk.d.a;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.Map;
import java.util.Timer;

public class a extends Fragment implements View.OnClickListener, a {
  private static final int m = 60;
  
  private static final String u = "1";
  
  protected ImageView a;
  
  protected EditText b;
  
  protected ImageView c;
  
  protected EditText d;
  
  protected FancyButton e;
  
  protected int f;
  
  protected FancyButton g;
  
  protected Handler h = new Handler();
  
  public String i;
  
  private Context j;
  
  private ImageView k;
  
  private LinearLayout l;
  
  private int n = 0;
  
  private t o;
  
  private ContentObserver p;
  
  private TextView q;
  
  private ImageView r;
  
  private ListView s;
  
  private h[] t;
  
  private boolean v = false;
  
  private Timer w = null;
  
  private int x = 60;
  
  public static a a(boolean paramBoolean) {
    a a1 = new a();
    Bundle bundle = new Bundle();
    bundle.putBoolean("is_from_gift_ui", paramBoolean);
    a1.setArguments(bundle);
    return a1;
  }
  
  private void a() {
    this.o = t.a(this.j);
    (new Thread(new k(this))).start();
  }
  
  private void a(View paramView) {
    try {
      b(paramView);
      this.i = cq.a(this.j).q();
      if (TextUtils.isEmpty(this.i))
        this.i = cq.a(this.j).v(); 
      this.o = t.a(this.j);
      this.c = (ImageView)paramView.findViewById(ci.a(this.j).a(2131296406));
      this.c.setOnClickListener(this);
      this.a = (ImageView)paramView.findViewById(ci.a(this.j).a(2131296532));
      this.a.setOnClickListener(this);
      this.b = (EditText)paramView.findViewById(ci.a(this.j).a(2131296392));
      EditText editText1 = this.b;
      b b = new b();
      this(this);
      editText1.addTextChangedListener(b);
      editText1 = this.b;
      e e = new e();
      this(this);
      editText1.setOnFocusChangeListener(e);
      this.d = (EditText)paramView.findViewById(ci.a(this.j).a(2131296407));
      EditText editText2 = this.d;
      f f = new f();
      this(this);
      editText2.setOnFocusChangeListener(f);
      this.f = ci.a(this.j).a(2131296395);
      this.e = (FancyButton)paramView.findViewById(this.f);
      this.e.setOnClickListener(this);
      this.g = (FancyButton)paramView.findViewById(ci.a(this.j).a(2131296467));
      this.g.setOnClickListener(this);
      this.b.setText("");
      this.k = (ImageView)paramView.findViewById(ci.a(this.j).a(2131296283));
      this.k.setOnClickListener(this);
      this.l = (LinearLayout)paramView.findViewById(ci.a(this.j).a(2131296508));
      this.l.setOnClickListener(this);
      this.q = (TextView)paramView.findViewById(ci.a(this.j).a(2131296536));
      this.q.setOnClickListener(this);
      this.p = h.a(this.j, (TextView)this.b, (TextView)this.d);
      if (this.v) {
        t.a(this.j).b("Buoy", "No_Tel_Bind_2", 1);
        return;
      } 
      t.a(this.j).b("Buoy", "No_Tel_Bind_1", 1);
    } catch (Exception exception) {}
  }
  
  private void a(ListView paramListView) {
    ListAdapter listAdapter = paramListView.getAdapter();
    if (listAdapter != null) {
      int i = listAdapter.getCount();
      byte b = 0;
      int j = 0;
      while (b < i) {
        View view = listAdapter.getView(b, null, (ViewGroup)paramListView);
        view.measure(0, 0);
        j += view.getMeasuredHeight();
        b++;
      } 
      ViewGroup.LayoutParams layoutParams = paramListView.getLayoutParams();
      layoutParams.height = paramListView.getDividerHeight() * (listAdapter.getCount() - 1) + j;
      paramListView.setLayoutParams(layoutParams);
    } 
  }
  
  private void a(String paramString) {
    h.a(this.j, false);
    com.zz.sdk.c.a.a().c(this.j, this.i, paramString, new l(this));
  }
  
  private void a(String paramString1, int paramInt, String paramString2) {
    h.a(this.j, false);
    com.zz.sdk.c.a.a().a(this.j, paramString1, paramInt, paramString2, new c(this));
  }
  
  private void a(String paramString1, String paramString2) {
    h.a(this.j, ci.a(this.j).a(2131165272), false);
    String str = "1";
    if (this.v)
      str = "2"; 
    com.zz.sdk.c.a.a().c(this.j, this.i, paramString1, paramString2, "", str, new i(this, paramString1));
  }
  
  private void b() {
    c();
    n n = new n(this);
    this.w = new Timer();
    this.w.schedule(n, 0L, 1000L);
  }
  
  private void b(View paramView) {
    try {
      this.v = getArguments().getBoolean("is_from_gift_ui");
      h.a(this.j, false);
      this.o = t.a(this.j);
      Thread thread = new Thread();
      g g = new g();
      this(this, paramView);
      this(g);
      thread.start();
    } catch (Exception exception) {}
  }
  
  private void c() {
    if (this.w != null) {
      this.w.purge();
      this.w.cancel();
      this.w = null;
    } 
  }
  
  private void c(View paramView) {
    this.h.post(new h(this, paramView));
  }
  
  public void a(Boolean paramBoolean) {
    if (paramBoolean.booleanValue())
      a(this.b.getText().toString(), 1, cq.a(this.j).j()); 
  }
  
  public void a(Runnable paramRunnable) {
    this.h.post(paramRunnable);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == ci.a(this.j).a(2131296395)) {
      t.a(this.j).b("Bind_platform", "bind_phone_code", 1);
      String str = h.b((TextView)this.b);
      if (str != null) {
        if (this.n < 2) {
          a(str);
          return;
        } 
        (new br(this.j, ci.a((Context)getActivity(), 2131230726), this)).show();
      } 
      return;
    } 
    if (i == ci.a(this.j).a(2131296467)) {
      t.a(this.j).b("Bind_platform", "bind_phone_enter", 1);
      String str = h.b((TextView)this.b);
      if (str != null) {
        String str1 = this.d.getText().toString();
        if (TextUtils.isEmpty(str1)) {
          cv.r(getString(ci.a((Context)getActivity(), 2131165249)));
          return;
        } 
        a(str, str1);
      } 
      return;
    } 
    if (i == ci.a(this.j).a(2131296406)) {
      this.b.setText("");
      return;
    } 
    if (i == ci.a(this.j).a(2131296532)) {
      getActivity().getSupportFragmentManager().popBackStack();
      return;
    } 
    if (i == ci.a(this.j).a(2131296536)) {
      bv.a(false);
      bv.a((Activity)getActivity(), gt.class, (Map)bv.a());
      return;
    } 
    if (i == ci.a(this.j).a(2131296283) || i == ci.a(this.j).a(2131296508)) {
      getActivity().finish();
      getActivity().overridePendingTransition(0, 0);
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.j = (Context)getActivity();
    bp.a("FM...onCreateView");
    View view = paramLayoutInflater.inflate(ci.a(this.j).a(2130903110), paramViewGroup, false);
    a(view);
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    try {
      if (this.p != null)
        this.j.getContentResolver().unregisterContentObserver(this.p); 
      c();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */