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
import com.zz.sdk.b.a.r;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cv;

public class bu extends Fragment implements View.OnClickListener {
  private WebView a;
  
  private LinearLayout b;
  
  private ImageView c;
  
  private Context d;
  
  public void onClick(View paramView) {
    if (paramView.getId() == ci.a(this.d, 2131296508) || paramView.getId() == ci.a(this.d, 2131296283)) {
      getActivity().finish();
      getActivity().overridePendingTransition(0, 0);
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    return paramLayoutInflater.inflate(ci.a(this.d, 2130903106), paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle) {
    try {
      this.a = (WebView)paramView.findViewById(ci.a(this.d, 2131296523));
      this.b = (LinearLayout)paramView.findViewById(ci.a(this.d, 2131296508));
      this.b.setOnClickListener(this);
      this.c = (ImageView)paramView.findViewById(ci.a(this.d, 2131296283));
      this.c.setOnClickListener(this);
      WebSettings webSettings = this.a.getSettings();
      webSettings.setJavaScriptEnabled(true);
      webSettings.setUseWideViewPort(true);
      webSettings.setLoadWithOverviewMode(true);
      WebView webView = this.a;
      bv bv = new bv();
      this(this);
      webView.setWebViewClient(bv);
      r r = cv.h();
      if (r != null && !TextUtils.isEmpty((r.u()).f)) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        bp.a(stringBuilder.append("share url:").append((r.u()).f).toString());
        this.a.loadUrl((r.u()).f);
      } 
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */