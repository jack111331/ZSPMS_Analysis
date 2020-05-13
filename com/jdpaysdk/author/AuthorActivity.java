package com.jdpaysdk.author;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jdpaysdk.author.a.c.a;
import com.jdpaysdk.author.b.a;
import com.jdpaysdk.author.browser.BrowserActivity;
import com.jdpaysdk.author.c.f;
import com.jdpaysdk.author.d.a;
import com.jdpaysdk.author.entity.CPOrderParam;
import com.jdpaysdk.author.entity.a;
import com.jdpaysdk.author.protocol.VerifyAppKeyParam;

public class AuthorActivity extends a {
  private static String o;
  
  private String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private boolean g = false;
  
  private final String h = "start_app";
  
  private final String i = "close";
  
  private final String j = "result_data";
  
  private final String k = "{\"payStatus\":\"JDP_PAY_NOTHING\"}";
  
  private Intent l = new Intent();
  
  private boolean m = false;
  
  private boolean n = false;
  
  private Handler p = new a(this);
  
  private void a(String paramString) {
    this.p.postDelayed(new b(this, paramString), 300L);
  }
  
  private void b(String paramString) {
    this.g = false;
    this.l.putExtra("jdpay_Result", paramString);
    setResult(1024, this.l);
    finish();
  }
  
  private void c() {
    this.c = getIntent().getStringExtra("orderId");
    this.d = getIntent().getStringExtra("merchant");
    this.e = getIntent().getStringExtra("appkey");
    this.f = getIntent().getStringExtra("signData");
    this.b = this.a + "merchant=" + this.d + "&orderId=" + this.c + "&sign=" + this.f;
  }
  
  private void c(String paramString) {
    a a1 = new a();
    a1.errorCode = paramString;
    a1.payStatus = "JDP_PAY_FAIL";
    a((new Gson()).toJson(a1));
  }
  
  private void d() {
    Uri uri = getIntent().getData();
    if (uri != null) {
      String str = uri.getQuery().split("=")[1];
      a(str);
      o = str;
      this.m = true;
      return;
    } 
    if (!TextUtils.isEmpty(o)) {
      a(o);
      o = "";
      this.m = true;
      return;
    } 
    if (this.g && TextUtils.isEmpty(o)) {
      if (this.n) {
        this.n = false;
        return;
      } 
      a("{\"payStatus\":\"JDP_PAY_NOTHING\"}");
      this.m = true;
    } 
  }
  
  private void e() {
    b();
  }
  
  private void f() {
    Intent intent = new Intent();
    intent.putExtra("url", this.b);
    intent.putExtra("title", getResources().getString(f.b("brower_title")));
    intent.setClass((Context)this, BrowserActivity.class);
    startActivityForResult(intent, 100);
  }
  
  private void g() {
    try {
      CPOrderParam cPOrderParam = new CPOrderParam();
      this();
      cPOrderParam.setOrderId(this.c);
      cPOrderParam.setKey(this.e);
      cPOrderParam.setMerchant(this.d);
      cPOrderParam.setSignData(this.f);
      GsonBuilder gsonBuilder = new GsonBuilder();
      this();
      gsonBuilder.disableHtmlEscaping();
      String str = gsonBuilder.create().toJson(cPOrderParam);
      Intent intent = new Intent();
      this();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      intent.setData(Uri.parse(stringBuilder.append("jdpay://?params=").append(str).toString()));
      startActivityForResult(intent, 100);
      this.g = true;
    } catch (Exception exception) {
      f();
    } 
  }
  
  public boolean a() {
    return (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(this.e));
  }
  
  public void b() {
    a a1 = new a();
    VerifyAppKeyParam verifyAppKeyParam = new VerifyAppKeyParam();
    verifyAppKeyParam.setAppKey(this.e);
    verifyAppKeyParam.setMerchantNo(this.d);
    a1.a((Activity)this, "", (new Gson()).toJson(verifyAppKeyParam), new c(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (1005 == paramInt2)
      b(paramIntent.getStringExtra("jdpay_Result")); 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    f.a((Context)this);
    setContentView(f.a("activity_author"));
    o = "";
    if (paramBundle != null) {
      this.n = true;
      this.g = paramBundle.getBoolean("start_app");
      this.m = paramBundle.getBoolean("close");
      o = paramBundle.getString("result_data");
      return;
    } 
    this.n = false;
  }
  
  protected void onDestroy() {
    a.a();
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
  }
  
  protected void onResume() {
    super.onResume();
    this.a = getResources().getString(f.b("h5_url"));
    d();
    if (!this.m) {
      c();
      if (a() && !this.g) {
        if (this.n) {
          Log.e("szp", "start recovered JDMall");
        } else {
          Log.e("szp", "start JDMall");
        } 
        e();
      } 
    } 
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {
    paramBundle.putBoolean("start_app", this.g);
    paramBundle.putBoolean("close", this.m);
    paramBundle.putString("result_data", o);
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\AuthorActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */