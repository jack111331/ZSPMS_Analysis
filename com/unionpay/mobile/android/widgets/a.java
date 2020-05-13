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
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.upwidget.c;
import com.unionpay.mobile.android.upwidget.g;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends z {
  private static List<String> u;
  
  private static List<String> v;
  
  private Spinner a = null;
  
  private int b = 1;
  
  private String c;
  
  private c o;
  
  private TextView p;
  
  private RelativeLayout q;
  
  private PopupWindow r;
  
  private g s;
  
  private List<Map<String, Object>> t;
  
  private final View.OnClickListener w = new b(this);
  
  private final AdapterView.OnItemClickListener x = new c(this);
  
  public a(Context paramContext, JSONObject paramJSONObject, JSONArray paramJSONArray, String paramString) {
    super(paramContext, paramJSONObject, paramString);
    ArrayList<JSONArray> arrayList = new ArrayList(1);
    int i;
    for (i = 0; i < paramJSONArray.length(); i++)
      arrayList.add((JSONArray)j.b(paramJSONArray, i)); 
    if (arrayList.size() > 0) {
      u = new ArrayList<String>(arrayList.size());
      v = new ArrayList<String>(arrayList.size());
      for (i = 0; i < arrayList.size(); i++) {
        v.add(j.a(arrayList.get(i), 0));
        u.add(j.a(arrayList.get(i), 1));
      } 
    } 
    RelativeLayout relativeLayout = this.m;
    Drawable drawable = c.a(this.d).a(2014);
    this.q = new RelativeLayout(this.d);
    this.q.setBackgroundDrawable(drawable);
    this.q.setOnClickListener(new d(this));
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n);
    layoutParams1.addRule(15, -1);
    relativeLayout.addView((View)this.q, (ViewGroup.LayoutParams)layoutParams1);
    ImageView imageView = new ImageView(this.d);
    imageView.setId(imageView.hashCode());
    imageView.setBackgroundDrawable(c.a(this.d).a(1002));
    i = g.a(this.d, 15.0F);
    layoutParams1 = new RelativeLayout.LayoutParams(i, i);
    layoutParams1.addRule(11, -1);
    layoutParams1.addRule(15, -1);
    layoutParams1.rightMargin = g.a(this.d, 10.0F);
    this.q.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams1);
    TextView textView = new TextView(this.d);
    textView.setId(textView.hashCode());
    textView.setTextSize(b.k);
    textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    textView.setTextColor(-13421773);
    textView.setSingleLine(true);
    textView.setEms(4);
    textView.setText(c.bD.bd);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(15, -1);
    layoutParams2.addRule(9, -1);
    layoutParams2.leftMargin = g.a(this.d, 10.0F);
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
    if (u != null && u.size() > 0)
      this.p.setText(u.get(0)); 
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
    if (this.o == null) {
      i = 1;
    } else {
      i = this.o.c();
    } 
    int i = this.b - i;
    return this.i ? i() : ((i >= 0 && i <= u.size()) ? v.get(i) : "");
  }
  
  public final boolean b() {
    return true;
  }
  
  public final boolean c() {
    return true;
  }
  
  protected final String d() {
    return "_select_areacode";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */