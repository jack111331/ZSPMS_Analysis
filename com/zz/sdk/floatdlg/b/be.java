package com.zz.sdk.floatdlg.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.zz.sdk.a.br;
import com.zz.sdk.b.h;
import com.zz.sdk.b.v;
import com.zz.sdk.c.a;
import com.zz.sdk.d.a;
import com.zz.sdk.i.bd;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.EditTextWithDel;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.Timer;

public class be extends Fragment implements View.OnClickListener, a {
  private static final int A = 60;
  
  private static final String v = "2";
  
  private Timer B = null;
  
  private int C = 60;
  
  protected ImageView a;
  
  private Context b;
  
  private ImageView c;
  
  private LinearLayout d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private Handler i = new Handler();
  
  private t j;
  
  private EditTextWithDel k;
  
  private EditTextWithDel l;
  
  private EditTextWithDel m;
  
  private EditTextWithDel n;
  
  private FancyButton o;
  
  private LinearLayout p;
  
  private LinearLayout q;
  
  private ImageView r;
  
  private FancyButton s;
  
  private v t;
  
  private boolean u;
  
  private h[] w;
  
  private ListView x;
  
  private boolean y;
  
  private int z = 0;
  
  public static be a(boolean paramBoolean) {
    be be1 = new be();
    Bundle bundle = new Bundle();
    bundle.putBoolean("is_from_gift_ui", paramBoolean);
    be1.setArguments(bundle);
    return be1;
  }
  
  private void a() {
    this.p.setVisibility(8);
    this.q.setVisibility(8);
  }
  
  private void a(ListView paramListView) {
    int i = 0;
    try {
      ListAdapter listAdapter = paramListView.getAdapter();
      if (listAdapter != null) {
        int j = listAdapter.getCount();
        int k = 0;
        while (i < j) {
          View view = listAdapter.getView(i, null, (ViewGroup)paramListView);
          view.measure(0, 0);
          k += view.getMeasuredHeight();
          i++;
        } 
        ViewGroup.LayoutParams layoutParams = paramListView.getLayoutParams();
        i = paramListView.getDividerHeight();
        layoutParams.height = k + (listAdapter.getCount() - 1) * i;
        paramListView.setLayoutParams(layoutParams);
      } 
    } catch (Exception exception) {}
  }
  
  private void a(String paramString1, int paramInt, String paramString2) {
    try {
      h.a(this.b, false);
      a a1 = a.a();
      Context context = this.b;
      bp bp = new bp();
      this(this);
      a1.a(context, paramString1, paramInt, paramString2, bp);
    } catch (Exception exception) {
      bd.b(exception);
    } 
  }
  
  private void a(String paramString1, String paramString2, String paramString3) {
    try {
      Pair pair = cq.k(paramString1);
      if (!((Boolean)pair.first).booleanValue()) {
        cv.r((String)pair.second);
        return;
      } 
      h.a(this.b, false);
      a a1 = a.a();
      Context context = this.b;
      bl bl = new bl();
      this(this);
      a1.d(context, paramString3, paramString2, paramString1, bl);
    } catch (Exception exception) {}
  }
  
  private void b() {
    try {
      this.e = this.k.getText().toString().trim();
      Pair pair = cq.e(this.e);
      if (!((Boolean)pair.first).booleanValue()) {
        cv.r((String)pair.second);
        return;
      } 
      this.f = this.l.getText().toString().trim();
      pair = cq.p(this.f);
      if (!((Boolean)pair.first).booleanValue()) {
        cv.r((String)pair.second);
        return;
      } 
    } catch (Exception exception) {
      return;
    } 
    if (this.p.getVisibility() == 0) {
      this.g = this.m.getText().toString().trim();
      Pair pair = cq.k(this.g);
      if (!((Boolean)pair.first).booleanValue()) {
        cv.r((String)pair.second);
        return;
      } 
      this.h = this.n.getText().toString();
      if (TextUtils.isEmpty(this.h)) {
        cv.r(getString(ci.a(this.b, 2131165249)));
        return;
      } 
    } 
    h.a(this.b, ci.a(this.b, 2131165272), false);
    Thread thread = new Thread();
    bh bh = new bh();
    this(this);
    this(bh);
    thread.start();
  }
  
  private void b(View paramView) {
    try {
      a(paramView);
      this.k = (EditTextWithDel)paramView.findViewById(ci.a(this.b, 2131296431));
      this.l = (EditTextWithDel)paramView.findViewById(ci.a(this.b, 2131296432));
      this.m = (EditTextWithDel)paramView.findViewById(ci.a(this.b, 2131296433));
      this.n = (EditTextWithDel)paramView.findViewById(ci.a(this.b, 2131296434));
      this.o = (FancyButton)paramView.findViewById(ci.a(this.b, 2131296435));
      this.o.setOnClickListener(this);
      this.s = (FancyButton)paramView.findViewById(ci.a(this.b, 2131296436));
      this.s.setOnClickListener(this);
      this.c = (ImageView)paramView.findViewById(ci.a(this.b, 2131296283));
      this.c.setOnClickListener(this);
      this.d = (LinearLayout)paramView.findViewById(ci.a(this.b, 2131296508));
      this.d.setOnClickListener(this);
      this.a = (ImageView)paramView.findViewById(ci.a(this.b, 2131296532));
      this.a.setOnClickListener(this);
      this.p = (LinearLayout)paramView.findViewById(ci.a(this.b, 2131296620));
      this.q = (LinearLayout)paramView.findViewById(ci.a(this.b, 2131296621));
      if (this.t.i == 1) {
        a();
      } else if (this.t.i == 3) {
        if (this.u)
          a(); 
      } else if (this.u) {
        a();
      } 
      if (this.y) {
        if (this.p.getVisibility() == 0)
          t.a(this.b).b("Buoy", "No_Tel_Auth_2", 1); 
        return;
      } 
    } catch (Exception exception) {
      return;
    } 
    if (this.p.getVisibility() == 0)
      t.a(this.b).b("Buoy", "No_Tel_Auth_1", 1); 
  }
  
  private void c() {
    try {
      Thread thread = new Thread();
      bk bk = new bk();
      this(this);
      this(bk);
      thread.start();
    } catch (Exception exception) {}
  }
  
  private void c(View paramView) {
    try {
      Handler handler = this.i;
      bg bg = new bg();
      this(this, paramView);
      handler.post(bg);
    } catch (Exception exception) {}
  }
  
  private void d() {
    try {
      e();
      bn bn = new bn();
      this(this);
      Timer timer = new Timer();
      this();
      this.B = timer;
      this.B.schedule(bn, 0L, 1000L);
    } catch (Exception exception) {}
  }
  
  private void e() {
    try {
      if (this.B != null) {
        this.B.purge();
        this.B.cancel();
        this.B = null;
      } 
    } catch (Exception exception) {}
  }
  
  public void a(View paramView) {
    try {
      this.y = getArguments().getBoolean("is_from_gift_ui");
      h.a(this.b, false);
      this.t = (cq.a((Context)getActivity())).a;
      this.u = false;
      if (!TextUtils.isEmpty(cq.a((Context)getActivity()).a()))
        this.u = true; 
      this.j = t.a(this.b);
      Thread thread = new Thread();
      bf bf = new bf();
      this(this, paramView);
      this(bf);
      thread.start();
    } catch (Exception exception) {}
  }
  
  public void a(Boolean paramBoolean) {
    a(this.m.getText().toString().trim(), 4, cq.a(this.b).j());
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == ci.a(this.b, 2131296436)) {
      t.a(this.b).b("Verify_platform", "Verify_verify", 1);
      b();
      return;
    } 
    if (i == ci.a(this.b, 2131296435)) {
      String str = h.b((TextView)this.m);
      if (str != null) {
        if (this.z < 2) {
          String str2 = cq.a(this.b).q();
          String str1 = str2;
          if (TextUtils.isEmpty(str2))
            str1 = cq.a(this.b).v(); 
          a(str, cq.a(this.b).j(), str1);
          return;
        } 
        (new br(this.b, ci.a(this.b, 2131230726), this)).show();
      } 
      return;
    } 
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
    bp.a("FragmentRealName...onCreateView mContext:" + this.b);
    View view = paramLayoutInflater.inflate(ci.a(this.b, 2130903126), paramViewGroup, false);
    b(view);
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    bp.a("FragmentRealName...onDestroy");
    e();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */