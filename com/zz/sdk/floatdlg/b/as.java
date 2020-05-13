package com.zz.sdk.floatdlg.b;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zz.sdk.b.h;
import com.zz.sdk.b.v;
import com.zz.sdk.i.bg;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class as extends Fragment implements View.OnClickListener {
  private Button A;
  
  private t B;
  
  private cq C;
  
  private v D;
  
  private boolean E;
  
  private View F;
  
  private boolean G = false;
  
  private Context H;
  
  private LinearLayout a;
  
  private ImageView b;
  
  private ImageView c;
  
  private h d;
  
  private TextView e;
  
  private TextView f;
  
  private TextView g;
  
  private TextView h;
  
  private TextView i;
  
  private TextView j;
  
  private TextView k;
  
  private TextView l;
  
  private TextView m;
  
  private TextView n;
  
  private TextView o;
  
  private TextView p;
  
  private TextView q;
  
  private TextView r;
  
  private TextView s;
  
  private TextView t;
  
  private TextView u;
  
  private LinearLayout v;
  
  private LinearLayout w;
  
  private LinearLayout x;
  
  private LinearLayout y;
  
  private LinearLayout z;
  
  public static as a(h paramh) {
    as as1 = new as();
    Bundle bundle = new Bundle();
    bundle.putSerializable("gift_info", (Serializable)paramh);
    as1.setArguments(bundle);
    return as1;
  }
  
  private void a() {
    this.A.setText(ci.a(this.H, 2131165437));
    this.A.setBackgroundResource(ci.a(this.H, 2130837562));
    this.A.setEnabled(true);
  }
  
  private void a(View paramView) {
    try {
      h.a((Context)getActivity(), false);
      int i = ((h)getArguments().getSerializable("gift_info")).g;
      this.B = t.a((Context)getActivity());
      Thread thread = new Thread();
      at at = new at();
      this(this, i, paramView);
      this(at);
      thread.start();
      this.C = cq.a((Context)getActivity());
      this.D = (cq.a((Context)getActivity())).a;
      this.E = false;
      if (!TextUtils.isEmpty(this.C.a()))
        this.E = true; 
    } catch (Exception exception) {}
  }
  
  private void a(String paramString1, String paramString2) {
    cv.a(new aw(this, paramString2, paramString1));
  }
  
  private void b() {
    this.A.setText(ci.a(this.H, 2131165434));
    this.A.setBackgroundResource(ci.a(this.H, 2130837563));
    this.A.setEnabled(false);
    this.G = true;
  }
  
  private void b(View paramView) {
    try {
      String str;
      this.a = (LinearLayout)paramView.findViewById(ci.a(this.H, 2131296508));
      this.a.setOnClickListener(this);
      this.e = (TextView)paramView.findViewById(ci.a(this.H, 2131296563));
      this.e.setText(this.d.f);
      this.f = (TextView)paramView.findViewById(ci.a(this.H, 2131296566));
      this.f.setText(this.d.f);
      this.g = (TextView)paramView.findViewById(ci.a(this.H, 2131296568));
      this.g.setText(this.d.u);
      this.h = (TextView)paramView.findViewById(ci.a(this.H, 2131296570));
      if (this.d.s == -1L) {
        str = "无限制";
      } else {
        int i = (int)Math.ceil((this.d.s - System.currentTimeMillis()) / 1000.0D / 60.0D / 60.0D / 24.0D);
        if (i <= 0) {
          str = "已过期";
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          this();
          str = stringBuilder.append(String.valueOf(i)).append("天").toString();
        } 
      } 
      this.h.setText(str);
      this.v = (LinearLayout)paramView.findViewById(ci.a(this.H, 2131296571));
      if (TextUtils.isEmpty(this.d.v)) {
        this.v.setVisibility(8);
      } else {
        this.v.setVisibility(0);
        this.i = (TextView)paramView.findViewById(ci.a(this.H, 2131296572));
        this.i.setText(this.d.v);
      } 
      this.j = (TextView)paramView.findViewById(ci.a(this.H, 2131296574));
      this.j.setText(this.d.b);
      this.k = (TextView)paramView.findViewById(ci.a(this.H, 2131296575));
      this.k.setText(this.d.u);
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
      this("yyyy年MM月dd日 hh:mm分");
      this.l = (TextView)paramView.findViewById(ci.a(this.H, 2131296576));
      if (this.d.l == -1L) {
        str = "无限制";
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        StringBuilder stringBuilder2 = stringBuilder1.append("截止");
        Date date = new Date();
        this(this.d.l);
        str = stringBuilder2.append(simpleDateFormat.format(date)).toString();
      } 
      this.l.setText(str);
      this.m = (TextView)paramView.findViewById(ci.a(this.H, 2131296577));
      if (this.d.s == -1L) {
        str = "无限制";
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        StringBuilder stringBuilder2 = stringBuilder1.append("截止");
        Date date = new Date();
        this(this.d.s);
        str = stringBuilder2.append(simpleDateFormat.format(date)).toString();
      } 
      this.m.setText(str);
      this.n = (TextView)paramView.findViewById(ci.a(this.H, 2131296578));
      this.n.setText(getString(ci.a(this.H, 2131165459), new Object[] { String.valueOf(this.d.r) }));
      this.o = (TextView)paramView.findViewById(ci.a(this.H, 2131296579));
      this.o.setText(getString(ci.a(this.H, 2131165460), new Object[] { String.valueOf(this.d.d) }));
      this.p = (TextView)paramView.findViewById(ci.a(this.H, 2131296595));
      this.p.setText(this.d.h);
      this.A = (Button)paramView.findViewById(ci.a(this.H, 2131296573));
      if (this.d.k == 1) {
        if (this.d.i == 1) {
          if (cm.b((Context)getActivity(), cq.a((Context)getActivity()).s())) {
            long l = cv.v((Context)getActivity());
            if (System.currentTimeMillis() - cm.a((Context)getActivity()) <= l) {
              if (this.d.q < this.d.r) {
                c();
              } else {
                a();
              } 
            } else {
              b();
            } 
          } 
        } else {
          c();
          c(paramView);
          e(paramView);
        } 
      } else if (this.d.k == 0) {
        if (this.d.q >= this.d.r) {
          a();
        } else {
          b();
        } 
      } 
      this.A.setOnClickListener(this);
      this.w = (LinearLayout)paramView.findViewById(ci.a(this.H, 2131296580));
      this.x = (LinearLayout)paramView.findViewById(ci.a(this.H, 2131296584));
      this.y = (LinearLayout)paramView.findViewById(ci.a(this.H, 2131296588));
      this.z = (LinearLayout)paramView.findViewById(ci.a(this.H, 2131296590));
      String[] arrayOfString = this.d.e.split(",");
      for (byte b = 0; b < arrayOfString.length; b++) {
        if (arrayOfString[b].equals("1")) {
          this.x.setVisibility(0);
          if (this.D.i == 1) {
            e(paramView);
          } else if (this.D.i == 3) {
            if (this.E)
              e(paramView); 
          } else if (this.E) {
            e(paramView);
          } 
        } 
        if (arrayOfString[b].equals("2")) {
          this.w.setVisibility(0);
          if (bg.k)
            c(paramView); 
        } 
        if (arrayOfString[b].equals("3"))
          this.y.setVisibility(0); 
      } 
    } catch (Exception exception) {
      return;
    } 
    if (this.d.i == 1) {
      this.z.setVisibility(0);
      if (cm.b((Context)getActivity(), cq.a((Context)getActivity()).s())) {
        long l = cv.v((Context)getActivity());
        if (System.currentTimeMillis() - cm.a((Context)getActivity()) <= l) {
          d((View)exception);
        } else if (this.d.q >= this.d.r) {
          d((View)exception);
        } 
      } 
    } 
    this.q = (TextView)exception.findViewById(ci.a(this.H, 2131296582));
    this.q.setOnClickListener(this);
    this.r = (TextView)exception.findViewById(ci.a(this.H, 2131296586));
    this.r.setOnClickListener(this);
    this.s = (TextView)exception.findViewById(ci.a(this.H, 2131296589));
    this.s.setOnClickListener(this);
    this.t = (TextView)exception.findViewById(ci.a(this.H, 2131296592));
    this.t.setOnClickListener(this);
    this.u = (TextView)exception.findViewById(ci.a(this.H, 2131296594));
    if (this.d.a != -1) {
      this.u.setText(getString(ci.a(this.H, 2131165461), new Object[] { String.valueOf(this.d.a) }));
      this.u.setVisibility(0);
      if (this.d.k == 0 && this.d.q >= this.d.r)
        this.u.setTextColor(getResources().getColor(ci.a(this.H, 2131034295))); 
    } 
    if (this.d.o == 0) {
      e((View)exception);
      c((View)exception);
      d((View)exception);
    } 
    if (this.h.getText().toString().equals("已过期")) {
      e((View)exception);
      c((View)exception);
      d((View)exception);
    } 
    if (this.G) {
      if (this.d.q >= this.d.r)
        this.n.setTextColor(getResources().getColor(ci.a(this.H, 2131034296))); 
      if (this.d.c >= this.d.d)
        this.o.setTextColor(getResources().getColor(ci.a(this.H, 2131034296))); 
    } 
  }
  
  private void c() {
    this.A.setText(ci.a(this.H, 2131165434));
    this.A.setBackgroundResource(ci.a(this.H, 2130837562));
    this.A.setEnabled(true);
  }
  
  private void c(View paramView) {
    ((TextView)paramView.findViewById(ci.a(this.H, 2131296581))).setTextColor(getActivity().getResources().getColor(ci.a(this.H, 2131034295)));
    paramView.findViewById(ci.a(this.H, 2131296582)).setVisibility(8);
    paramView.findViewById(ci.a(this.H, 2131296583)).setVisibility(8);
  }
  
  private void d(View paramView) {
    ((TextView)paramView.findViewById(ci.a(this.H, 2131296591))).setTextColor(getActivity().getResources().getColor(ci.a(this.H, 2131034295)));
    paramView.findViewById(ci.a(this.H, 2131296592)).setVisibility(8);
    paramView.findViewById(ci.a(this.H, 2131296593)).setVisibility(8);
  }
  
  private void e(View paramView) {
    ((TextView)paramView.findViewById(ci.a(this.H, 2131296585))).setTextColor(getActivity().getResources().getColor(ci.a(this.H, 2131034295)));
    paramView.findViewById(ci.a(this.H, 2131296586)).setVisibility(8);
    paramView.findViewById(ci.a(this.H, 2131296587)).setVisibility(8);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == ci.a(this.H, 2131296508) || i == ci.a(this.H, 2131296564)) {
      getActivity().finish();
      getActivity().overridePendingTransition(0, 0);
      return;
    } 
    if (i == ci.a(this.H, 2131296565)) {
      getActivity().getSupportFragmentManager().popBackStack();
      return;
    } 
    if (i == ci.a(this.H, 2131296573)) {
      try {
        if (this.d != null) {
          if (this.A.getText().toString().equals("领取")) {
            this.B = t.a((Context)getActivity());
            Thread thread = new Thread();
            av av = new av();
            this(this);
            this(av);
            thread.start();
            return;
          } 
          boolean bool = this.A.getText().toString().equals("复制");
          if (bool)
            try {
              a(getString(ci.a(this.H, 2131165468)), this.d.v);
            } catch (Exception exception) {} 
        } 
      } catch (Exception exception) {}
      return;
    } 
    if (i == ci.a(this.H, 2131296582)) {
      getActivity().getSupportFragmentManager().beginTransaction().replace(2131296257, be.a(true)).addToBackStack(null).commit();
      return;
    } 
    if (i == ci.a(this.H, 2131296586)) {
      getActivity().getSupportFragmentManager().beginTransaction().replace(2131296257, a.a(true)).addToBackStack(null).commit();
      return;
    } 
    if (i == ci.a(this.H, 2131296592) && this.d != null)
      getActivity().getSupportFragmentManager().beginTransaction().replace(2131296257, ae.a(true, this.d)).addToBackStack(null).commit(); 
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    this.H = (Context)getActivity();
    this.F = paramLayoutInflater.inflate(ci.a(this.H, 2130903120), paramViewGroup, false);
    this.b = (ImageView)this.F.findViewById(ci.a(this.H, 2131296564));
    this.b.setOnClickListener(this);
    this.c = (ImageView)this.F.findViewById(ci.a(this.H, 2131296565));
    this.c.setOnClickListener(this);
    a(this.F);
    return this.F;
  }
  
  public void onDestroy() {
    super.onDestroy();
    bp.a("FragmentGiftDetail onDestroy");
  }
  
  public void onDestroyView() {
    super.onDestroyView();
    bp.a("FragmentGiftDetail onDestroyView");
    this.G = false;
  }
  
  public void onPause() {
    super.onPause();
    bp.a("FragmentGiftDetail onPause");
  }
  
  public void onStop() {
    super.onStop();
    bp.a("FragmentGiftDetail onStop");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */