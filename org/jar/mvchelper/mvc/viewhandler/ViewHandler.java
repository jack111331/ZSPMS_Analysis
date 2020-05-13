package org.jar.mvchelper.mvc.viewhandler;

import android.view.View;
import org.jar.mvchelper.mvc.IDataAdapter;
import org.jar.mvchelper.mvc.ILoadViewFactory;
import org.jar.mvchelper.mvc.MVCHelper;

public interface ViewHandler {
  boolean handleSetAdapter(View paramView, IDataAdapter<?> paramIDataAdapter, ILoadViewFactory.ILoadMoreView paramILoadMoreView, View.OnClickListener paramOnClickListener);
  
  void setOnScrollBottomListener(View paramView, MVCHelper.OnScrollBottomListener paramOnScrollBottomListener);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\mvc\viewhandler\ViewHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */