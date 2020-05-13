package com.unionpay.mobile.android.upwidget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.widgets.ad;
import com.unionpay.mobile.android.widgets.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j extends LinearLayout {
  private View.OnClickListener A = new m(this);
  
  private View.OnClickListener B = new n(this);
  
  private View.OnClickListener C = new o(this);
  
  private View.OnClickListener D = new p(this);
  
  private Context a;
  
  private JSONArray b;
  
  private int c;
  
  private int d;
  
  private boolean e = true;
  
  private a[] f;
  
  private ArrayList<Object> g;
  
  private LinearLayout h;
  
  private HorizontalScrollView i;
  
  private k j = null;
  
  private ad k = null;
  
  private TextView l = null;
  
  private TextView m = null;
  
  private int n = 0;
  
  private int o = 0;
  
  private int p = -1;
  
  private int q;
  
  private int r;
  
  private String s;
  
  private ArrayList<AdapterView.OnItemClickListener> t = new ArrayList<AdapterView.OnItemClickListener>();
  
  private ArrayList<View.OnClickListener> u = new ArrayList<View.OnClickListener>();
  
  private ArrayList<View.OnClickListener> v = new ArrayList<View.OnClickListener>();
  
  private ArrayList<View.OnClickListener> w = new ArrayList<View.OnClickListener>();
  
  private ArrayList<View.OnClickListener> x = new ArrayList<View.OnClickListener>();
  
  private AdapterView.OnItemClickListener y = new k(this);
  
  private View.OnClickListener z = new l(this);
  
  public j(Context paramContext, JSONArray paramJSONArray, int paramInt, String paramString) {
    super(paramContext);
    this.a = paramContext;
    this.b = paramJSONArray;
    this.o = paramInt;
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((Activity)this.a).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    this.q = displayMetrics.widthPixels;
    displayMetrics = new DisplayMetrics();
    ((Activity)this.a).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    this.r = displayMetrics.heightPixels;
    this.s = paramString;
    if (this.b != null) {
      FrameLayout frameLayout = new FrameLayout(this.a);
      RelativeLayout relativeLayout = new RelativeLayout(this.a);
      frameLayout.addView((View)relativeLayout, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, this.r / 3 * 2);
      layoutParams4.addRule(12, -1);
      LinearLayout linearLayout1 = new LinearLayout(this.a);
      linearLayout1.setOrientation(1);
      linearLayout1.setBackgroundColor(-1);
      linearLayout1.setId(linearLayout1.hashCode());
      relativeLayout.addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams4);
      RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
      LinearLayout linearLayout3 = new LinearLayout(this.a);
      layoutParams5.addRule(10, -1);
      layoutParams5.addRule(2, linearLayout1.getId());
      relativeLayout.addView((View)linearLayout3, (ViewGroup.LayoutParams)layoutParams5);
      linearLayout3.setOnClickListener(this.z);
      this.h = new LinearLayout(this.a);
      this.h.setBackgroundColor(-1);
      this.h.setOrientation(0);
      LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n);
      linearLayout1.addView((View)this.h, (ViewGroup.LayoutParams)layoutParams2);
      LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, g.a(this.a, 1.0F));
      LinearLayout linearLayout2 = new LinearLayout(this.a);
      linearLayout2.setBackgroundColor(-3355444);
      linearLayout1.addView((View)linearLayout2, (ViewGroup.LayoutParams)layoutParams3);
      this.i = new HorizontalScrollView(this.a);
      this.i.setBackgroundColor(-1052684);
      LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-2, -1);
      linearLayout1.addView((View)this.i, (ViewGroup.LayoutParams)layoutParams1);
      paramInt = g.a(this.a, 40.0F);
      ImageView imageView = new ImageView(this.a);
      imageView.setBackgroundDrawable(c.a(this.a).a(1034));
      imageView.setOnClickListener(this.z);
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(paramInt, paramInt);
      layoutParams.gravity = 85;
      layoutParams.rightMargin = g.a(this.a, 10.0F);
      layoutParams.bottomMargin = this.r / 3 * 2 - paramInt / 2;
      frameLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams);
      addView((View)frameLayout);
      a();
    } 
  }
  
  private View a(LinearLayout paramLinearLayout, JSONObject paramJSONObject) {
    List<Map<String, Object>> list = b(com.unionpay.mobile.android.utils.j.d(paramJSONObject, "options"));
    c c = new c(this.a, list, "", "", "", this.p, 1);
    this.g.add(c);
    ListView listView = new ListView(this.a);
    listView.setDivider(null);
    listView.setAdapter((ListAdapter)c);
    listView.setOnItemClickListener(this.y);
    listView.setCacheColorHint(-1);
    paramLinearLayout.addView((View)listView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(this.q, -1));
    return (View)listView;
  }
  
  private static String a(JSONArray paramJSONArray, int paramInt, String paramString) {
    null = com.unionpay.mobile.android.utils.j.b(paramJSONArray, paramInt);
    return (null != null) ? com.unionpay.mobile.android.utils.j.a((JSONObject)null, paramString) : "";
  }
  
  private void a() {
    int i = this.b.length();
    this.f = new a[i];
    byte b;
    for (b = 0; b < i; b++) {
      this.f[b] = new a((byte)0);
      if ((this.f[b]).a == null)
        (this.f[b]).a = new TextView(this.a); 
      if ((this.f[b]).b == null)
        (this.f[b]).b = new LinearLayout(this.a); 
      if ((this.f[b]).c == null)
        (this.f[b]).c = (View)new ListView(this.a); 
      if ((this.f[b]).d == null)
        (this.f[b]).d = ""; 
    } 
    this.g = new ArrayList(this.b.length());
    LinearLayout linearLayout = new LinearLayout(this.a);
    linearLayout.setOrientation(0);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
    this.i.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams);
    for (b = 0; b < this.b.length(); b++) {
      View view;
      JSONObject jSONObject = (JSONObject)com.unionpay.mobile.android.utils.j.b(this.b, b);
      String str1 = com.unionpay.mobile.android.utils.j.a(jSONObject, "action");
      String str2 = com.unionpay.mobile.android.utils.j.a(jSONObject, "label");
      RelativeLayout relativeLayout = new RelativeLayout(this.a);
      LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-2, -1);
      layoutParams1.leftMargin = g.a(this.a, 10.0F);
      this.h.addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams1);
      i = g.a(this.a, 10.0F);
      TextView textView = new TextView(this.a);
      textView.setText(str2);
      textView.setTextSize(b.k);
      textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      textView.setSingleLine(true);
      textView.setTextColor(-10066330);
      textView.setPadding(i, 0, i, 0);
      RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams2.addRule(15, -1);
      relativeLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams2);
      int m = g.a(this.a, 2.0F);
      layoutParams2 = new RelativeLayout.LayoutParams((int)textView.getPaint().measureText(str2) + i + i, m);
      layoutParams2.addRule(12, -1);
      LinearLayout linearLayout1 = new LinearLayout(this.a);
      linearLayout1.setBackgroundColor(-16730965);
      if (this.o != b)
        linearLayout1.setVisibility(8); 
      relativeLayout.addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams2);
      relativeLayout.setTag(Integer.valueOf(b));
      relativeLayout.setOnClickListener(this.D);
      (this.f[b]).a = textView;
      (this.f[b]).b = linearLayout1;
      (this.f[b]).d = str1;
      if (this.o == b) {
        this.p = 0;
      } else {
        this.p = -1;
      } 
      str1 = com.unionpay.mobile.android.utils.j.a(jSONObject, "type");
      if ("coupon".equals(str1)) {
        this.d = b;
        view = b(linearLayout, jSONObject);
      } else if ("point".equals(str1)) {
        this.c = b;
        view = c(linearLayout, (JSONObject)view);
      } else if ("upoint".equals(str1)) {
        view = c(linearLayout, (JSONObject)view);
      } else {
        view = a(linearLayout, (JSONObject)view);
      } 
      (this.f[b]).c = view;
      (this.f[b]).c.setVisibility(8);
    } 
    a(this.o);
  }
  
  private void a(int paramInt) {
    (this.f[this.o]).b.setVisibility(8);
    (this.f[this.o]).a.setTextColor(-16777216);
    (this.f[this.o]).c.setVisibility(8);
    (this.f[paramInt]).b.setVisibility(0);
    (this.f[paramInt]).a.setTextColor(-16730965);
    (this.f[paramInt]).c.setVisibility(0);
    this.o = paramInt;
  }
  
  private void a(LinearLayout paramLinearLayout, boolean paramBoolean, String paramString, JSONObject paramJSONObject, c paramc) {
    paramLinearLayout.removeAllViews();
    ListView listView = new ListView(this.a);
    listView.setDivider(null);
    listView.setAdapter((ListAdapter)paramc);
    listView.setOnItemClickListener(this.y);
    this.g.add(paramc);
    paramLinearLayout.addView((View)listView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(this.q, -2));
    if (paramc != null)
      ((LinearLayout.LayoutParams)paramLinearLayout.getLayoutParams()).gravity = 48; 
    if (paramBoolean) {
      int i = com.unionpay.mobile.android.global.a.p;
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
      layoutParams.bottomMargin = g.a(this.a, 12.0F);
      layoutParams.gravity = 17;
      paramLinearLayout.addView((View)new ProgressBar(this.a), (ViewGroup.LayoutParams)layoutParams);
    } 
    TextView textView = new TextView(this.a);
    if (!TextUtils.isEmpty(paramString)) {
      textView.setText(paramString);
      textView.setTextSize(b.k);
      textView.setTextColor(-13421773);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
      layoutParams.gravity = 17;
      paramLinearLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
    } 
    if (paramJSONObject != null) {
      TextView textView1 = new TextView(this.a);
      textView1.setText(com.unionpay.mobile.android.utils.j.a(paramJSONObject, "label"));
      textView1.setTextSize(b.i);
      textView1.setTextColor(h.a(b.b, b.c, b.c, b.d));
      textView1.setGravity(17);
      textView1.setEnabled(true);
      int i = com.unionpay.mobile.android.global.a.n;
      textView1.setBackgroundDrawable(c.a(this.a).a(2008));
      float f = textView.getPaint().measureText(paramString);
      textView1.setOnClickListener(this.A);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int)f, i);
      i = com.unionpay.mobile.android.global.a.f;
      layoutParams.bottomMargin = i;
      layoutParams.topMargin = i;
      i = g.a(this.a, 10.0F);
      layoutParams.rightMargin = i;
      layoutParams.leftMargin = i;
      paramLinearLayout.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams);
    } 
  }
  
  private View b(LinearLayout paramLinearLayout, JSONObject paramJSONObject) {
    RelativeLayout relativeLayout = new RelativeLayout(this.a);
    ListView listView = new ListView(this.a);
    listView.setDivider(null);
    listView.setAdapter(null);
    this.g.add(listView);
    JSONArray jSONArray = com.unionpay.mobile.android.utils.j.d(paramJSONObject, "rules");
    Object object1 = null;
    Object object2 = null;
    Object object3 = null;
    Object object4 = null;
    Object object5 = object3;
    Object object6 = object1;
    if (jSONArray != null) {
      object5 = object3;
      object6 = object1;
      if (jSONArray.length() > 0) {
        int n = 0;
        while (true) {
          object5 = object4;
          object6 = object2;
          if (n < jSONArray.length()) {
            object5 = com.unionpay.mobile.android.utils.j.b(jSONArray, n);
            if (object5 != null) {
              object5 = object5;
              object6 = com.unionpay.mobile.android.utils.j.a((JSONObject)object5, "type");
              if ("coupon_code".equals(object6)) {
                object2 = object4;
                object4 = object5;
                continue;
              } 
              if ("string".equals(object6)) {
                object4 = object2;
                object2 = object5;
                continue;
              } 
            } 
          } else {
            object2 = new RelativeLayout.LayoutParams(this.q, -2);
            object2.addRule(10, -1);
            relativeLayout.addView((View)listView, (ViewGroup.LayoutParams)object2);
            int i1 = com.unionpay.mobile.android.global.a.I - com.unionpay.mobile.android.global.a.f * 4;
            this.j = new k(this.a, i1, (JSONObject)object6, this.s);
            this.j.setId(this.j.hashCode());
            object2 = new RelativeLayout.LayoutParams(this.q, -2);
            object2.addRule(10, -1);
            n = g.a(this.a, 10.0F);
            ((RelativeLayout.LayoutParams)object2).topMargin = n;
            ((RelativeLayout.LayoutParams)object2).rightMargin = n;
            ((RelativeLayout.LayoutParams)object2).leftMargin = n;
            relativeLayout.addView((View)this.j, (ViewGroup.LayoutParams)object2);
            this.k = new ad(this.a, i1, (JSONObject)object5, this.s);
            object2 = new RelativeLayout.LayoutParams(this.q, -2);
            object2.addRule(3, this.j.getId());
            n = g.a(this.a, 10.0F);
            ((RelativeLayout.LayoutParams)object2).topMargin = n;
            ((RelativeLayout.LayoutParams)object2).rightMargin = n;
            ((RelativeLayout.LayoutParams)object2).leftMargin = n;
            relativeLayout.addView((View)this.k, (ViewGroup.LayoutParams)object2);
            this.l = new TextView(this.a);
            this.l.setTextSize(b.k);
            this.l.setTextColor(-10066330);
            this.l.setVisibility(8);
            object2 = new RelativeLayout.LayoutParams(this.q, -2);
            object2.addRule(3, this.j.getId());
            n = g.a(this.a, 10.0F);
            ((RelativeLayout.LayoutParams)object2).topMargin = n;
            ((RelativeLayout.LayoutParams)object2).rightMargin = n;
            ((RelativeLayout.LayoutParams)object2).leftMargin = n;
            relativeLayout.addView((View)this.l, (ViewGroup.LayoutParams)object2);
            object5 = com.unionpay.mobile.android.utils.j.c(paramJSONObject, "use_button");
            linearLayout = new LinearLayout(this.a);
            linearLayout.setOrientation(1);
            linearLayout.setBackgroundColor(-1);
            object2 = new LinearLayout.LayoutParams(-1, g.a(this.a, 1.0F));
            object4 = new LinearLayout(this.a);
            object4.setBackgroundColor(-3355444);
            linearLayout.addView((View)object4, (ViewGroup.LayoutParams)object2);
            this.m = new TextView(this.a);
            this.m.setText(com.unionpay.mobile.android.utils.j.a((JSONObject)object5, "label"));
            this.m.setTextSize(b.i);
            this.m.setTextColor(h.a(b.b, b.c, b.c, b.d));
            this.m.setGravity(17);
            this.m.setEnabled(false);
            n = com.unionpay.mobile.android.global.a.n;
            object2 = c.a(this.a).a(2008);
            this.m.setBackgroundDrawable((Drawable)object2);
            this.m.setTag(Integer.valueOf(this.d));
            this.m.setOnClickListener(this.C);
            object2 = new LinearLayout.LayoutParams(-1, n);
            n = com.unionpay.mobile.android.global.a.f;
            ((LinearLayout.LayoutParams)object2).bottomMargin = n;
            ((LinearLayout.LayoutParams)object2).topMargin = n;
            n = g.a(this.a, 10.0F);
            ((LinearLayout.LayoutParams)object2).rightMargin = n;
            ((LinearLayout.LayoutParams)object2).leftMargin = n;
            linearLayout.addView((View)this.m, (ViewGroup.LayoutParams)object2);
            object2 = new RelativeLayout.LayoutParams(this.q, -2);
            object2.addRule(12, -1);
            relativeLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)object2);
            paramLinearLayout.addView((View)relativeLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(this.q, -2));
            return (View)relativeLayout;
          } 
          object5 = object2;
          object2 = object4;
          object4 = object5;
          continue;
          n++;
          object5 = object4;
          object4 = object2;
          object2 = object5;
        } 
      } 
    } 
    object2 = new RelativeLayout.LayoutParams(this.q, -2);
    object2.addRule(10, -1);
    relativeLayout.addView((View)listView, (ViewGroup.LayoutParams)object2);
    int m = com.unionpay.mobile.android.global.a.I - com.unionpay.mobile.android.global.a.f * 4;
    this.j = new k(this.a, m, (JSONObject)object6, this.s);
    this.j.setId(this.j.hashCode());
    object2 = new RelativeLayout.LayoutParams(this.q, -2);
    object2.addRule(10, -1);
    int i = g.a(this.a, 10.0F);
    ((RelativeLayout.LayoutParams)object2).topMargin = i;
    ((RelativeLayout.LayoutParams)object2).rightMargin = i;
    ((RelativeLayout.LayoutParams)object2).leftMargin = i;
    relativeLayout.addView((View)this.j, (ViewGroup.LayoutParams)object2);
    this.k = new ad(this.a, m, (JSONObject)object5, this.s);
    object2 = new RelativeLayout.LayoutParams(this.q, -2);
    object2.addRule(3, this.j.getId());
    i = g.a(this.a, 10.0F);
    ((RelativeLayout.LayoutParams)object2).topMargin = i;
    ((RelativeLayout.LayoutParams)object2).rightMargin = i;
    ((RelativeLayout.LayoutParams)object2).leftMargin = i;
    relativeLayout.addView((View)this.k, (ViewGroup.LayoutParams)object2);
    this.l = new TextView(this.a);
    this.l.setTextSize(b.k);
    this.l.setTextColor(-10066330);
    this.l.setVisibility(8);
    object2 = new RelativeLayout.LayoutParams(this.q, -2);
    object2.addRule(3, this.j.getId());
    i = g.a(this.a, 10.0F);
    ((RelativeLayout.LayoutParams)object2).topMargin = i;
    ((RelativeLayout.LayoutParams)object2).rightMargin = i;
    ((RelativeLayout.LayoutParams)object2).leftMargin = i;
    relativeLayout.addView((View)this.l, (ViewGroup.LayoutParams)object2);
    object5 = com.unionpay.mobile.android.utils.j.c((JSONObject)linearLayout, "use_button");
    LinearLayout linearLayout = new LinearLayout(this.a);
    linearLayout.setOrientation(1);
    linearLayout.setBackgroundColor(-1);
    object2 = new LinearLayout.LayoutParams(-1, g.a(this.a, 1.0F));
    object4 = new LinearLayout(this.a);
    object4.setBackgroundColor(-3355444);
    linearLayout.addView((View)object4, (ViewGroup.LayoutParams)object2);
    this.m = new TextView(this.a);
    this.m.setText(com.unionpay.mobile.android.utils.j.a((JSONObject)object5, "label"));
    this.m.setTextSize(b.i);
    this.m.setTextColor(h.a(b.b, b.c, b.c, b.d));
    this.m.setGravity(17);
    this.m.setEnabled(false);
    i = com.unionpay.mobile.android.global.a.n;
    object2 = c.a(this.a).a(2008);
    this.m.setBackgroundDrawable((Drawable)object2);
    this.m.setTag(Integer.valueOf(this.d));
    this.m.setOnClickListener(this.C);
    object2 = new LinearLayout.LayoutParams(-1, i);
    i = com.unionpay.mobile.android.global.a.f;
    ((LinearLayout.LayoutParams)object2).bottomMargin = i;
    ((LinearLayout.LayoutParams)object2).topMargin = i;
    i = g.a(this.a, 10.0F);
    ((LinearLayout.LayoutParams)object2).rightMargin = i;
    ((LinearLayout.LayoutParams)object2).leftMargin = i;
    linearLayout.addView((View)this.m, (ViewGroup.LayoutParams)object2);
    object2 = new RelativeLayout.LayoutParams(this.q, -2);
    object2.addRule(12, -1);
    relativeLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)object2);
    paramLinearLayout.addView((View)relativeLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(this.q, -2));
    return (View)relativeLayout;
  }
  
  private static List<Map<String, Object>> b(JSONArray paramJSONArray) {
    ArrayList<HashMap<Object, Object>> arrayList1 = null;
    ArrayList<HashMap<Object, Object>> arrayList2 = arrayList1;
    if (paramJSONArray != null) {
      arrayList2 = arrayList1;
      if (paramJSONArray.length() > 0) {
        arrayList2 = new ArrayList(paramJSONArray.length());
        for (byte b = 0; b < paramJSONArray.length(); b++) {
          HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
          hashMap.put("text1", a(paramJSONArray, b, "label"));
          hashMap.put("text2", "");
          hashMap.put("editable", Boolean.FALSE);
          String str = a(paramJSONArray, b, "available");
          boolean bool1 = Boolean.TRUE.booleanValue();
          boolean bool2 = bool1;
          if (!TextUtils.isEmpty(str)) {
            bool2 = bool1;
            if ("1".equals(str))
              bool2 = Boolean.FALSE.booleanValue(); 
          } 
          hashMap.put("available", Boolean.valueOf(bool2));
          arrayList2.add(hashMap);
        } 
      } 
    } 
    return (List)arrayList2;
  }
  
  private View c(LinearLayout paramLinearLayout, JSONObject paramJSONObject) {
    LinearLayout linearLayout = new LinearLayout(this.a);
    linearLayout.setOrientation(1);
    String str1 = com.unionpay.mobile.android.utils.j.a(paramJSONObject, "tip");
    String str2 = com.unionpay.mobile.android.utils.j.a(paramJSONObject, "empty_info");
    JSONObject jSONObject = com.unionpay.mobile.android.utils.j.c(paramJSONObject, "button");
    if (jSONObject != null) {
      a(linearLayout, false, str1, jSONObject, (c)null);
      layoutParams = new LinearLayout.LayoutParams(-2, -2);
      layoutParams.gravity = 17;
      linearLayout.setGravity(17);
      paramLinearLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams);
      return (View)linearLayout;
    } 
    if ("upoint".equals(com.unionpay.mobile.android.utils.j.a((JSONObject)layoutParams, "type"))) {
      if (str2 != null && !TextUtils.isEmpty(str2)) {
        a(linearLayout, false, str2, (JSONObject)null, (c)null);
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        linearLayout.setGravity(17);
        paramLinearLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams);
        return (View)linearLayout;
      } 
      return a(paramLinearLayout, (JSONObject)layoutParams);
    } 
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
    layoutParams.gravity = 17;
    linearLayout.setGravity(17);
    paramLinearLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams);
    return (View)linearLayout;
  }
  
  public final void a(View.OnClickListener paramOnClickListener) {
    this.u.add(paramOnClickListener);
  }
  
  public final void a(AdapterView.OnItemClickListener paramOnItemClickListener) {
    this.t.add(paramOnItemClickListener);
  }
  
  public final void a(JSONArray paramJSONArray) {
    Object object = com.unionpay.mobile.android.utils.j.b(paramJSONArray, 0);
    if (object != null) {
      object = object;
      this.l.setText(com.unionpay.mobile.android.utils.j.a((JSONObject)object, "label"));
      this.l.setVisibility(0);
      this.k.setVisibility(8);
    } 
    this.m.setEnabled(true);
  }
  
  public final void a(JSONArray paramJSONArray, String paramString) {
    if (paramJSONArray != null && paramJSONArray.length() > 0) {
      List<Map<String, Object>> list = b(paramJSONArray);
      c c = new c(this.a, list, "", "", "", -1, 1);
      this.g.add(this.c, c);
    } else {
      paramJSONArray = null;
    } 
    a((LinearLayout)(this.f[this.c]).c, false, paramString, (JSONObject)null, (c)paramJSONArray);
  }
  
  public final void b(View.OnClickListener paramOnClickListener) {
    this.v.add(paramOnClickListener);
  }
  
  public final void c(View.OnClickListener paramOnClickListener) {
    this.w.add(paramOnClickListener);
  }
  
  public final void d(View.OnClickListener paramOnClickListener) {
    this.x.add(paramOnClickListener);
  }
  
  public final void e(View.OnClickListener paramOnClickListener) {
    if (this.j != null) {
      this.j.a(paramOnClickListener);
      this.j.b(this.B);
    } 
  }
  
  private final class a {
    TextView a;
    
    LinearLayout b;
    
    View c;
    
    String d;
    
    private a(j this$0) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upwidget\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */