package org.jar.mvchelper.vary;

import android.content.Context;
import android.view.View;

public interface IVaryViewHelper {
  Context getContext();
  
  View getCurrentLayout();
  
  View getView();
  
  View inflate(int paramInt);
  
  void restoreView();
  
  void showLayout(int paramInt);
  
  void showLayout(View paramView);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\vary\IVaryViewHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */