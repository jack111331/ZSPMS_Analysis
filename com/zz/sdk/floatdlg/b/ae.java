package com.zz.sdk.floatdlg.b;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.zz.sdk.b.d;
import com.zz.sdk.b.h;
import com.zz.sdk.floatdlg.FloatDialog;
import com.zz.sdk.floatdlg.a.c;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.bx;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import java.io.Serializable;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ae extends Fragment implements View.OnClickListener {
  private Context a;
  
  private ListView b;
  
  private d[] c;
  
  private t d;
  
  private LinearLayout e;
  
  private ImageView f;
  
  private ImageView g;
  
  private Uri h = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
  
  private String i = "data1";
  
  private String j = "display_name";
  
  private boolean k;
  
  private h l;
  
  private ListView m;
  
  private LinearLayout n;
  
  private TextView o;
  
  private c p;
  
  private boolean q = false;
  
  public static ae a(boolean paramBoolean, h paramh) {
    ae ae1 = new ae();
    Bundle bundle = new Bundle();
    bundle.putBoolean("from_gift_ui", paramBoolean);
    bundle.putSerializable("gift", (Serializable)paramh);
    ae1.setArguments(bundle);
    return ae1;
  }
  
  private void a(View paramView) {
    try {
      this.e = (LinearLayout)paramView.findViewById(ci.a(this.a, 2131296508));
      this.e.setOnClickListener(this);
      this.f = (ImageView)paramView.findViewById(ci.a(this.a, 2131296537));
      this.f.setOnClickListener(this);
      this.g = (ImageView)paramView.findViewById(ci.a(this.a, 2131296538));
      this.g.setOnClickListener(this);
      this.b = (ListView)paramView.findViewById(ci.a(this.a, 2131296542));
      this.b.setEmptyView(paramView.findViewById(ci.a(this.a, 2131296543)));
      this.m = (ListView)paramView.findViewById(ci.a(this.a, 2131296539));
      a();
      this.n = (LinearLayout)paramView.findViewById(ci.a(this.a, 2131296540));
      this.o = (TextView)paramView.findViewById(ci.a(this.a, 2131296541));
      this.o.setOnClickListener(this);
      c();
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
    if (TextUtils.isEmpty(paramString.replace("[", "").replace("]", ""))) {
      bp.a("upload contacts but content is empty, return");
      h.c();
      cv.r("通讯录为空");
      return;
    } 
    if (cm.b((Context)getActivity(), cq.a(this.a).s())) {
      boolean bool;
      if (System.currentTimeMillis() - cm.a(this.a) > cv.v(this.a)) {
        bool = true;
      } else {
        bool = false;
      } 
      if (!bool) {
        bp.a("client has upload contacts");
        h.c();
        e();
        return;
      } 
    } 
    this.d = t.a(this.a);
    (new Thread(new aj(this, paramString))).start();
  }
  
  private void a(List paramList) {
    cv.a(new ah(this, paramList));
  }
  
  private void c() {
    ((FloatDialog)getActivity()).a(new ai(this));
    if (getActivity() != null) {
      if (!bx.f((Context)getActivity())) {
        bx.f((Activity)getActivity());
        return;
      } 
    } else {
      return;
    } 
    d();
  }
  
  private void d() {
    JSONArray jSONArray;
    try {
      h.a((Context)getActivity(), false);
      jSONArray = new JSONArray();
      this();
      Cursor cursor = getActivity().getContentResolver().query(this.h, new String[] { this.j, this.i }, null, null, null);
      while (cursor.moveToNext()) {
        JSONObject jSONObject = new JSONObject();
        this();
        jSONObject.put("tel", cursor.getString(cursor.getColumnIndex(this.i)));
        jSONObject.put("name", cursor.getString(cursor.getColumnIndex(this.j)));
        jSONArray.put(jSONObject);
      } 
    } catch (Exception exception) {
      return;
    } 
    a(jSONArray.toString().replaceAll(" ", ""));
  }
  
  private void e() {
    try {
      this.d = t.a(this.a);
      Thread thread = new Thread();
      ak ak = new ak();
      this(this);
      this(ak);
      thread.start();
    } catch (Exception exception) {}
  }
  
  private void f() {
    cv.a(new al(this));
  }
  
  public void a() {
    (new Thread(new af(this))).start();
  }
  
  public boolean b() {
    return this.q;
  }
  
  public void onClick(View paramView) {
    boolean bool = false;
    if (paramView.getId() == ci.a(this.a, 2131296508) || paramView.getId() == ci.a(this.a, 2131296537)) {
      getActivity().finish();
      getActivity().overridePendingTransition(0, 0);
      return;
    } 
    if (paramView.getId() == ci.a(this.a, 2131296538)) {
      getActivity().getSupportFragmentManager().popBackStack();
      return;
    } 
    if (paramView.getId() == ci.a(this.a, 2131296541)) {
      if (this.q) {
        this.o.setText(getString(ci.a(this.a, 2131165470)));
      } else {
        this.o.setText(getString(ci.a(this.a, 2131165471)));
      } 
      if (!this.q)
        bool = true; 
      this.q = bool;
      this.p.notifyDataSetChanged();
      a(this.m);
    } 
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    this.a = (Context)getActivity();
    this.k = getArguments().getBoolean("from_gift_ui", false);
    this.l = (h)getArguments().getSerializable("gift");
    View view = paramLayoutInflater.inflate(ci.a(this.a, 2130903113), paramViewGroup, false);
    a(view);
    return view;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */