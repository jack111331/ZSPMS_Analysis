package com.zz.sdk.floatdlg.b;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.zz.sdk.i.ci;

public class cg extends Fragment implements View.OnClickListener {
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
    return paramLayoutInflater.inflate(ci.a(this.d, 2130903107), paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */