package org.jar.mvchelper.vary;

import android.view.View;

public class VaryViewHelperXV extends VaryViewHelperX {
  private View view;
  
  public VaryViewHelperXV(View paramView) {
    super(paramView);
    this.view = paramView;
  }
  
  public void restoreView() {
    super.restoreView();
    this.view.setVisibility(0);
  }
  
  public void showLayout(int paramInt) {
    super.showLayout(paramInt);
    this.view.setVisibility(8);
  }
  
  public void showLayout(View paramView) {
    super.showLayout(paramView);
    this.view.setVisibility(8);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\vary\VaryViewHelperXV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */