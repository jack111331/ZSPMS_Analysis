package org.jar.mvchelper.mvc;

import android.view.View;

public interface IRefreshView {
  View getContentView();
  
  View getSwitchView();
  
  void setOnRefreshListener(OnRefreshListener paramOnRefreshListener);
  
  void showRefreshComplete();
  
  void showRefreshing();
  
  public static interface OnRefreshListener {
    void onRefresh();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\mvc\IRefreshView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */