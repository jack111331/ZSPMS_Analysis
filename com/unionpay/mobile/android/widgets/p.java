package com.unionpay.mobile.android.widgets;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.upwidget.e;
import com.unionpay.mobile.android.upwidget.q;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class p extends z {
  private final View.OnClickListener a = new q(this);
  
  private final AdapterView.OnItemClickListener b = new r(this);
  
  private JSONArray c = j.d(this.n, "new_instalments");
  
  private List<Map<String, Object>> o;
  
  private AlertDialog p;
  
  private PopupWindow q;
  
  private e r;
  
  private int s = 1;
  
  private TextView t;
  
  private q u;
  
  private TextView v;
  
  private String w;
  
  private RelativeLayout x;
  
  private boolean y = false;
  
  private boolean z = true;
  
  public p(Context paramContext, JSONObject paramJSONObject, String paramString) {
    super(paramContext, paramJSONObject, paramString);
    this.w = j.a(paramJSONObject, "label");
    if (a(this.w))
      this.w = c.bD.bg; 
    this.o = b(this.c);
    this.r = new e(this.d, this.o, "");
    a(this.m);
  }
  
  private String a(int paramInt, String paramString) {
    Object object = j.b(this.c, paramInt);
    return (object != null) ? j.a((JSONObject)object, paramString) : "";
  }
  
  private JSONObject a(String paramString1, String paramString2, String paramString3) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("type", paramString1);
      jSONObject.put("label", paramString2);
      jSONObject.put("checked", paramString3);
      jSONObject.put("ckb_style", "small");
      jSONObject.put("required", "0");
      if ("instalment".equals(paramString1)) {
        JSONObject jSONObject1 = j.c(this.n, "url");
        if (jSONObject1 != null) {
          jSONObject.put("href_label", j.a(jSONObject1, "label"));
          jSONObject.put("href_url", j.a(jSONObject1, "href"));
        } 
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject;
  }
  
  private void a(int paramInt) {
    this.s = paramInt;
    int i = this.r.a();
    this.r.a(this.s);
    if (this.t != null)
      this.t.setText(a(paramInt - i, "label")); 
  }
  
  private void a(RelativeLayout paramRelativeLayout) {
    Drawable drawable = c.a(this.d).a(2014);
    LinearLayout linearLayout = new LinearLayout(this.d);
    linearLayout.setId(linearLayout.hashCode());
    linearLayout.setBackgroundColor(-3419943);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, 1);
    String str = j.a(this.n, "type");
    if ("instalment".equals(str))
      layoutParams2.leftMargin = g.a(this.d, 10.0F); 
    paramRelativeLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams2);
    this.x = new RelativeLayout(this.d);
    this.x.setId(this.x.hashCode());
    this.x.setBackgroundDrawable(drawable);
    this.x.setOnClickListener(new s(this));
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, a.n);
    layoutParams1.addRule(15, -1);
    layoutParams1.addRule(3, linearLayout.getId());
    paramRelativeLayout.addView((View)this.x, (ViewGroup.LayoutParams)layoutParams1);
    ImageView imageView = new ImageView(this.d);
    imageView.setId(imageView.hashCode());
    imageView.setBackgroundDrawable(c.a(this.d).a(1002));
    int i = g.a(this.d, 15.0F);
    layoutParams1 = new RelativeLayout.LayoutParams(i, i);
    layoutParams1.addRule(11, -1);
    layoutParams1.addRule(15, -1);
    layoutParams1.rightMargin = g.a(this.d, 10.0F);
    this.x.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams1);
    this.t = new TextView(this.d);
    this.t.setTextSize(b.k);
    this.t.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    this.t.setSingleLine(true);
    this.t.setTextColor(-10066330);
    layoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams1.addRule(15, -1);
    layoutParams1.addRule(9, -1);
    layoutParams1.addRule(0, imageView.getId());
    layoutParams1.leftMargin = g.a(this.d, 10.0F);
    layoutParams1.rightMargin = layoutParams1.leftMargin;
    this.x.addView((View)this.t, (ViewGroup.LayoutParams)layoutParams1);
    if (!"instalment".equals(str)) {
      LinearLayout linearLayout1 = new LinearLayout(this.d);
      linearLayout1.setBackgroundColor(-3419943);
      RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 1);
      layoutParams.bottomMargin = a.f;
      layoutParams.addRule(3, this.x.getId());
      paramRelativeLayout.addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams);
    } 
    b(g());
    a(this.r.a());
  }
  
  private List<Map<String, Object>> b(JSONArray paramJSONArray) {
    ArrayList<HashMap<Object, Object>> arrayList1 = null;
    ArrayList<HashMap<Object, Object>> arrayList2 = arrayList1;
    if (paramJSONArray != null) {
      arrayList2 = arrayList1;
      if (paramJSONArray.length() > 0) {
        arrayList2 = new ArrayList(paramJSONArray.length());
        for (byte b = 0; b < paramJSONArray.length(); b++) {
          HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
          hashMap.put("label", a(b, "label"));
          hashMap.put("style", a(b, "rel_value_style"));
          String[] arrayOfString = a(b, "rel_value").split("\\|");
          ArrayList<String> arrayList3 = new ArrayList(arrayOfString.length);
          ArrayList<String> arrayList4 = new ArrayList(arrayOfString.length);
          int i = arrayOfString.length;
          for (byte b1 = 0; b1 < i; b1++) {
            String[] arrayOfString1 = arrayOfString[b1].split(":");
            arrayList3.add(arrayOfString1[0]);
            arrayList4.add(arrayOfString1[1]);
          } 
          hashMap.put("keys", arrayList3);
          hashMap.put("values", arrayList4);
          arrayList2.add(hashMap);
        } 
      } 
    } 
    return (List)arrayList2;
  }
  
  public final String a() {
    String str1 = a(this.s - this.r.a(), "value");
    String str2 = str1;
    if (this.u != null) {
      str2 = str1;
      if (!this.u.b())
        str2 = null; 
    } 
    k.c("uppay", n() + " : " + str2);
    return str2;
  }
  
  public final void a(q.a parama) {
    this.u.a(parama);
  }
  
  public final void a(JSONArray paramJSONArray) {
    if (paramJSONArray != null && paramJSONArray.length() > 0) {
      this.z = true;
      this.c = paramJSONArray;
      this.o = b(paramJSONArray);
      this.r = new e(this.d, this.o, "");
      a(this.m);
    } 
  }
  
  public final void a(boolean paramBoolean) {
    this.y = paramBoolean;
  }
  
  protected final boolean a(LinearLayout paramLinearLayout, String paramString) {
    if (!a(paramString)) {
      LinearLayout linearLayout = new LinearLayout(this.d);
      linearLayout.setBackgroundColor(-1);
      linearLayout.setOrientation(1);
      paramLinearLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, a.n));
      String str = j.a(this.n, "type");
      if ("instalment".equals(str)) {
        paramLinearLayout = new LinearLayout(this.d);
        paramLinearLayout.setId(paramLinearLayout.hashCode());
        paramLinearLayout.setBackgroundColor(-3419943);
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-1, 1);
        layoutParams1.leftMargin = g.a(this.d, 10.0F);
        linearLayout.addView((View)paramLinearLayout, (ViewGroup.LayoutParams)layoutParams1);
      } 
      JSONObject jSONObject = a(str, paramString, j.a(this.n, "checked"));
      this.u = new q(this.d, jSONObject, s() + "_agree_installment");
      this.u.a();
      this.u.a(b.k);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, a.n);
      layoutParams.gravity = 16;
      int i = g.a(this.d, 10.0F);
      layoutParams.rightMargin = i;
      layoutParams.leftMargin = i;
      linearLayout.addView((View)this.u, (ViewGroup.LayoutParams)layoutParams);
    } 
    return true;
  }
  
  public final void b(boolean paramBoolean) {
    byte b;
    this.u.a(paramBoolean);
    if (!paramBoolean)
      this.y = paramBoolean; 
    if (this.y) {
      if (paramBoolean) {
        b = 0;
      } else {
        b = 8;
      } 
    } else {
      b = 8;
    } 
    this.m.setVisibility(b);
    if (this.v != null) {
      if (TextUtils.isEmpty(this.v.getText().toString())) {
        this.v.setVisibility(8);
        return;
      } 
    } else {
      return;
    } 
    this.v.setVisibility(b);
  }
  
  public final boolean b() {
    return true;
  }
  
  protected final boolean b_() {
    this.v = new TextView(this.d);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
    layoutParams.leftMargin = g.a(this.d, 10.0F);
    int i = g.a(this.d, 5.0F);
    layoutParams.bottomMargin = i;
    layoutParams.topMargin = i;
    this.v.setTextSize(b.k);
    addView((View)this.v, (ViewGroup.LayoutParams)layoutParams);
    this.v.setVisibility(8);
    return true;
  }
  
  public final boolean c() {
    return true;
  }
  
  protected final String d() {
    return "_select_installment";
  }
  
  public final boolean f() {
    String str = a(this.s - this.r.a(), "available");
    return !(!TextUtils.isEmpty(str) && "1".equals(str));
  }
  
  public final boolean g() {
    return (this.u != null) ? this.u.b() : true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */