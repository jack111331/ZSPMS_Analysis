package com.zz.sdk.floatdlg.b;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.zz.sdk.b.a.r;
import com.zz.sdk.b.v;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.i.v;
import java.net.URLEncoder;

public class ab extends Fragment implements View.OnClickListener {
  private WebView a;
  
  private LinearLayout b;
  
  private ImageView c;
  
  private Context d;
  
  private ProgressBar e;
  
  private LinearLayout f;
  
  private String g;
  
  private cq h;
  
  private v i;
  
  private boolean j;
  
  private String k;
  
  private void a() {
    try {
      this.h = cq.a(this.d);
      this.i = this.h.a;
      this.j = false;
      if (!TextUtils.isEmpty(this.h.a())) {
        this.j = true;
        this.k = this.h.a();
      } 
    } catch (Exception exception) {}
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == ci.a(this.d, 2131296508) || paramView.getId() == ci.a(this.d, 2131296283)) {
      getActivity().finish();
      getActivity().overridePendingTransition(0, 0);
      return;
    } 
    if (paramView.getId() == ci.a(this.d, 2131296509) && this.a.canGoBack())
      this.a.goBack(); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    return paramLayoutInflater.inflate(ci.a(this.d, 2130903104), paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle) {
    try {
      a();
      this.a = (WebView)paramView.findViewById(ci.a(this.d, 2131296511));
      cv.w(this.d);
      this.b = (LinearLayout)paramView.findViewById(ci.a(this.d, 2131296508));
      this.b.setOnClickListener(this);
      this.c = (ImageView)paramView.findViewById(ci.a(this.d, 2131296283));
      this.c.setOnClickListener(this);
      this.f = (LinearLayout)paramView.findViewById(ci.a(this.d, 2131296509));
      this.f.setOnClickListener(this);
      this.e = (ProgressBar)paramView.findViewById(ci.a(this.d, 2131296510));
      WebSettings webSettings = this.a.getSettings();
      webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
      webSettings.setJavaScriptEnabled(true);
      webSettings.setUseWideViewPort(true);
      webSettings.setLoadWithOverviewMode(true);
      webSettings.setDomStorageEnabled(true);
      webSettings.setCacheMode(2);
      WebView webView2 = this.a;
      ac ac = new ac();
      this(this);
      webView2.setWebViewClient(ac);
      WebView webView1 = this.a;
      ad ad = new ad();
      this(this);
      webView1.setWebChromeClient(ad);
      r r = cv.h();
      if (r != null && !TextUtils.isEmpty((r.u()).b)) {
        String str1;
        String str4;
        StringBuilder stringBuilder3 = new StringBuilder();
        this((r.u()).b);
        StringBuilder stringBuilder2 = new StringBuilder();
        this();
        bp.a(stringBuilder2.append("club base url:").append(stringBuilder3.toString()).toString());
        if (v.z == null) {
          str1 = "";
        } else {
          str1 = v.z.f();
        } 
        if (v.z == null) {
          str2 = "";
        } else {
          str2 = v.z.d();
        } 
        if (v.z == null) {
          str3 = "";
        } else {
          str3 = v.z.g();
        } 
        if (v.z == null) {
          str4 = "";
        } else {
          str4 = v.z.e();
        } 
        if (this.j) {
          str1 = h.a(new Object[] { 
                "roleId", str1, "channelId", "", "serverId", str2, "roleName", str3, "vipLevel", "", 
                "serverName", str4, "rankLevel", "", "level", "", "phone", this.k });
        } else {
          str1 = h.a(new Object[] { 
                "roleId", str1, "channelId", "", "serverId", str2, "roleName", str3, "vipLevel", "", 
                "serverName", str4, "rankLevel", "", "level", "" });
        } 
        String str2 = h.a(true, new String[] { "data", str1, "timestamp", String.valueOf(System.currentTimeMillis() / 1000L) });
        String str3 = h.b(this.d).toLowerCase();
        stringBuilder3.append("&data=").append(URLEncoder.encode(str1)).append("&timestamp=").append(String.valueOf(System.currentTimeMillis() / 1000L)).append("&sign=").append(str2).append("&lang=").append(str3);
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        bp.a(stringBuilder1.append("club url:").append(stringBuilder3.toString()).toString());
        this.a.loadUrl(stringBuilder3.toString());
      } 
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */