package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.upwidget.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class g extends z {
  private static List<String> u;
  
  private static List<String> v;
  
  private Spinner a;
  
  private int b;
  
  private String c;
  
  private c o;
  
  private TextView p;
  
  private RelativeLayout q;
  
  private PopupWindow r;
  
  private com.unionpay.mobile.android.upwidget.g s;
  
  private List<Map<String, Object>> t;
  
  private final View.OnClickListener w;
  
  private final AdapterView.OnItemClickListener x;
  
  static {
    ArrayList<String> arrayList = new ArrayList(8);
    arrayList.add(c.bD.M);
    arrayList.add(c.bD.N);
    arrayList.add(c.bD.O);
    arrayList.add(c.bD.P);
    arrayList.add(c.bD.Q);
    arrayList.add(c.bD.R);
    arrayList.add(c.bD.S);
    arrayList.add(c.bD.T);
    u = arrayList;
    arrayList = new ArrayList<String>(8);
    arrayList.add("01");
    arrayList.add("02");
    arrayList.add("03");
    arrayList.add("04");
    arrayList.add("05");
    arrayList.add("06");
    arrayList.add("07");
    arrayList.add("99");
    v = arrayList;
  }
  
  public g(Context paramContext, JSONObject paramJSONObject, String paramString) {
    super(paramContext, paramJSONObject, paramString);
    ArrayList<HashMap<Object, Object>> arrayList;
    this.a = null;
    this.b = 1;
    this.w = new h(this);
    this.x = new i(this);
    this.c = c.bD.bf;
    paramString = null;
    String str = paramString;
    if (u != null) {
      str = paramString;
      if (u.size() > 0) {
        arrayList = new ArrayList(u.size());
        for (byte b = 0; b < u.size(); b++) {
          HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
          hashMap.put("text1", u.get(b));
          hashMap.put("text2", "");
          hashMap.put("editable", Boolean.FALSE);
          arrayList.add(hashMap);
        } 
      } 
    } 
    this.t = (List)arrayList;
    this.o = new c(paramContext, this.t, this.c, "", "", this.b, 0);
    this.s = new com.unionpay.mobile.android.upwidget.g(this.d, this.o);
    this.s.a(this.x);
    this.s.a(this.w);
    RelativeLayout relativeLayout = this.m;
    Drawable drawable = c.a(this.d).a(2014);
    this.q = new RelativeLayout(this.d);
    this.q.setBackgroundDrawable(drawable);
    this.q.setOnClickListener(new j(this));
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, a.n);
    layoutParams1.addRule(15, -1);
    relativeLayout.addView((View)this.q, (ViewGroup.LayoutParams)layoutParams1);
    ImageView imageView = new ImageView(this.d);
    imageView.setId(imageView.hashCode());
    imageView.setBackgroundDrawable(c.a(this.d).a(1002));
    int i = com.unionpay.mobile.android.utils.g.a(this.d, 15.0F);
    layoutParams1 = new RelativeLayout.LayoutParams(i, i);
    layoutParams1.addRule(11, -1);
    layoutParams1.addRule(15, -1);
    layoutParams1.rightMargin = com.unionpay.mobile.android.utils.g.a(this.d, 10.0F);
    this.q.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams1);
    TextView textView = new TextView(this.d);
    textView.setId(textView.hashCode());
    textView.setTextSize(b.k);
    textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    textView.setSingleLine(true);
    textView.setEms(4);
    textView.setText(c.bD.bc);
    textView.setTextColor(-16777216);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(15, -1);
    layoutParams2.addRule(9, -1);
    layoutParams2.leftMargin = com.unionpay.mobile.android.utils.g.a(this.d, 10.0F);
    this.q.addView((View)textView, (ViewGroup.LayoutParams)layoutParams2);
    this.p = new TextView(this.d);
    this.p.setTextSize(b.k);
    this.p.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    this.p.setSingleLine(true);
    this.p.setTextColor(-10066330);
    layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams2.addRule(15, -1);
    layoutParams2.addRule(1, textView.getId());
    layoutParams2.addRule(0, imageView.getId());
    this.q.addView((View)this.p, (ViewGroup.LayoutParams)layoutParams2);
    if (this.i) {
      this.p.setText(b(i()));
      imageView.setVisibility(8);
      this.q.setClickable(false);
      return;
    } 
    a(1);
  }
  
  private void a(int paramInt) {
    this.b = paramInt;
    int i = this.o.c();
    this.o.a(this.b);
    if (this.p != null && u != null)
      this.p.setText(u.get(paramInt - i)); 
  }
  
  private static String b(String paramString) {
    String str = "";
    for (byte b = 0; b < v.size(); b++) {
      if (((String)v.get(b)).equals(paramString))
        str = u.get(b); 
    } 
    return str;
  }
  
  public final String a() {
    String str1 = "";
    int i = this.b - this.o.c();
    if (this.i)
      return i(); 
    String str2 = str1;
    if (i >= 0) {
      str2 = str1;
      if (i <= u.size())
        str2 = v.get(i); 
    } 
    return str2;
  }
  
  public final boolean b() {
    return true;
  }
  
  public final boolean c() {
    return true;
  }
  
  protected final String d() {
    return "_select_certtype";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */