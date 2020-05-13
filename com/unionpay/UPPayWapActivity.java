package com.unionpay;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.utils.f;
import com.unionpay.utils.i;
import org.json.JSONException;
import org.json.JSONObject;

public class UPPayWapActivity extends Activity {
  LinearLayout a;
  
  private WebView b;
  
  private WebViewJavascriptBridge c;
  
  private AlertDialog d;
  
  private static String b(String paramString1, String paramString2, String paramString3) {
    String str;
    try {
      JSONObject jSONObject = new JSONObject();
      this("{\"code\":\"0\",\"msg\":\"success\"}");
      if (paramString1 != null)
        jSONObject.put("code", paramString1); 
      if (paramString2 != null)
        jSONObject.put("msg", paramString2); 
      if (paramString3 != null)
        jSONObject.put("value", paramString3); 
      paramString1 = jSONObject.toString();
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      str = "";
    } 
    return str;
  }
  
  public void onCreate(Bundle paramBundle) {
    n n;
    super.onCreate(paramBundle);
    String str2 = getIntent().getStringExtra("waptype");
    String str1 = "";
    if (str2 != null && str2.equals("new_page")) {
      String str = getIntent().getStringExtra("wapurl");
      str2 = getIntent().getStringExtra("waptitle");
      if (str != null)
        str1 = str; 
      if (str2 == null)
        str2 = ""; 
      j j1 = new j(this);
    } else {
      str2 = getIntent().getStringExtra("wapurl");
      str1 = getIntent().getStringExtra("paydata");
      if (str1 != null) {
        str1 = str2 + "?s=" + str1;
      } else {
        str1 = "";
      } 
      str2 = (i.a()).e;
      n = new n(this);
    } 
    getWindow().requestFeature(1);
    LinearLayout linearLayout = new LinearLayout((Context)this);
    linearLayout.setOrientation(1);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    RelativeLayout relativeLayout = new RelativeLayout((Context)this);
    relativeLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    int i = f.a((Context)this, 10.0F);
    int j = f.a((Context)this, 52.0F);
    relativeLayout.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, j));
    relativeLayout.setBackgroundColor(-10705958);
    this.a = new LinearLayout((Context)this);
    this.a.setPadding(i, i, i, i);
    this.a.setGravity(16);
    layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(9, -1);
    layoutParams2.addRule(15, -1);
    layoutParams2.leftMargin = i;
    this.a.setOnClickListener(n);
    relativeLayout.addView((View)this.a, (ViewGroup.LayoutParams)layoutParams2);
    i = f.a((Context)this, 20.0F);
    int k = f.a((Context)this, 11.0F);
    ImageView imageView = new ImageView((Context)this);
    imageView.setBackgroundDrawable((Drawable)new BitmapDrawable(BitmapFactory.decodeStream(getClass().getResourceAsStream("res/nav_back.png"))));
    layoutParams2 = new RelativeLayout.LayoutParams(k, i);
    layoutParams2.addRule(15, -1);
    this.a.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams2);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(f.a((Context)this, 320.0F), j);
    layoutParams1.addRule(13, -1);
    TextView textView = new TextView((Context)this);
    textView.setTextSize(20.0F);
    textView.setTextColor(-1);
    textView.setText(str2);
    textView.setGravity(17);
    textView.setSingleLine(true);
    textView.setEllipsize(TextUtils.TruncateAt.END);
    relativeLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams1);
    linearLayout.addView((View)relativeLayout);
    this.b = new WebView((Context)this);
    this.b.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    linearLayout.addView((View)this.b);
    setContentView((View)linearLayout);
    this.c = new WebViewJavascriptBridge(this, this.b, null);
    this.b.loadUrl(str1);
    this.c.registerHandler("getDeviceInfo", new q(this));
    this.c.registerHandler("saveData", new r(this));
    this.c.registerHandler("getData", new s(this));
    this.c.registerHandler("removeData", new t(this));
    this.c.registerHandler("setPageBackEnable", new u(this));
    this.c.registerHandler("payBySDK", new v(this));
    this.c.registerHandler("downloadApp", new w(this));
    this.c.registerHandler("payResult", new k(this));
    this.c.registerHandler("closePage", new l(this));
    this.c.registerHandler("openNewPage", new m(this));
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      onPause();
      return true;
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\UPPayWapActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */