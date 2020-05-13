package org.jar.mvchelper.mvc.viewhandler;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import org.jar.mvchelper.mvc.IDataAdapter;
import org.jar.mvchelper.mvc.ILoadViewFactory;
import org.jar.mvchelper.mvc.MVCHelper;
import org.jar.mvchelper.recyclerview.HFAdapter;
import org.jar.mvchelper.recyclerview.HFRecyclerAdapter;
import org.jar.support.v4.view.ViewCompat;
import org.jar.support.v7.widget.RecyclerView;

public class RecyclerViewHandler implements ViewHandler {
  public boolean handleSetAdapter(View paramView, IDataAdapter<?> paramIDataAdapter, ILoadViewFactory.ILoadMoreView paramILoadMoreView, View.OnClickListener paramOnClickListener) {
    HFRecyclerAdapter hFRecyclerAdapter;
    RecyclerView recyclerView = (RecyclerView)paramView;
    RecyclerView.Adapter adapter2 = (RecyclerView.Adapter)paramIDataAdapter;
    boolean bool = false;
    RecyclerView.Adapter adapter1 = adapter2;
    if (paramILoadMoreView != null) {
      if (paramIDataAdapter instanceof HFAdapter) {
        HFAdapter hFAdapter = (HFAdapter)paramIDataAdapter;
      } else {
        hFRecyclerAdapter = new HFRecyclerAdapter(adapter2, false);
      } 
      paramILoadMoreView.init(new RecyclerViewOnScrollListener.RecyclerViewFootViewAdder(recyclerView, (HFAdapter)hFRecyclerAdapter), paramOnClickListener);
      bool = true;
    } 
    recyclerView.setAdapter((RecyclerView.Adapter)hFRecyclerAdapter);
    return bool;
  }
  
  public void setOnScrollBottomListener(View paramView, MVCHelper.OnScrollBottomListener paramOnScrollBottomListener) {
    RecyclerView recyclerView = (RecyclerView)paramView;
    RecyclerViewOnScrollListener recyclerViewOnScrollListener = new RecyclerViewOnScrollListener(paramOnScrollBottomListener);
    recyclerView.addOnScrollListener(recyclerViewOnScrollListener);
    recyclerView.addOnItemTouchListener(recyclerViewOnScrollListener);
  }
  
  private static class RecyclerViewOnScrollListener extends RecyclerView.OnScrollListener implements RecyclerView.OnItemTouchListener {
    private float endY = -1.0F;
    
    private MVCHelper.OnScrollBottomListener onScrollBottomListener;
    
    private float startY = -1.0F;
    
    public RecyclerViewOnScrollListener(MVCHelper.OnScrollBottomListener param1OnScrollBottomListener) {
      this.onScrollBottomListener = param1OnScrollBottomListener;
    }
    
    private boolean isCanScollVertically(RecyclerView param1RecyclerView) {
      int i = Build.VERSION.SDK_INT;
      boolean bool = true;
      if (i < 14) {
        boolean bool1 = bool;
        if (!ViewCompat.canScrollVertically((View)param1RecyclerView, 1))
          if (param1RecyclerView.getScrollY() < param1RecyclerView.getHeight()) {
            bool1 = bool;
          } else {
            bool1 = false;
          }  
        return bool1;
      } 
      return ViewCompat.canScrollVertically((View)param1RecyclerView, 1);
    }
    
    private boolean isScollBottom(RecyclerView param1RecyclerView) {
      return isCanScollVertically(param1RecyclerView) ^ true;
    }
    
    public boolean onInterceptTouchEvent(RecyclerView param1RecyclerView, MotionEvent param1MotionEvent) {
      switch (param1MotionEvent.getAction()) {
        default:
          return false;
        case 1:
          this.endY = param1MotionEvent.getY();
        case 0:
          break;
      } 
      this.endY = -1.0F;
      this.startY = param1MotionEvent.getY();
    }
    
    public void onRequestDisallowInterceptTouchEvent(boolean param1Boolean) {}
    
    public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
      if (param1Int == 0 && this.onScrollBottomListener != null && this.endY >= 0.0F && this.endY < this.startY && isScollBottom(param1RecyclerView))
        this.onScrollBottomListener.onScorllBootom(); 
    }
    
    public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {}
    
    public void onTouchEvent(RecyclerView param1RecyclerView, MotionEvent param1MotionEvent) {}
    
    private static class RecyclerViewFootViewAdder implements ILoadViewFactory.FootViewAdder {
      private HFAdapter hfAdapter;
      
      private RecyclerView recyclerView;
      
      public RecyclerViewFootViewAdder(RecyclerView param2RecyclerView, HFAdapter param2HFAdapter) {
        this.recyclerView = param2RecyclerView;
        this.hfAdapter = param2HFAdapter;
      }
      
      public View addFootView(int param2Int) {
        return addFootView(LayoutInflater.from(this.recyclerView.getContext()).inflate(param2Int, (ViewGroup)this.recyclerView, false));
      }
      
      public View addFootView(View param2View) {
        this.hfAdapter.addFooter(param2View);
        return param2View;
      }
      
      public View getContentView() {
        return (View)this.recyclerView;
      }
    }
  }
  
  private static class RecyclerViewFootViewAdder implements ILoadViewFactory.FootViewAdder {
    private HFAdapter hfAdapter;
    
    private RecyclerView recyclerView;
    
    public RecyclerViewFootViewAdder(RecyclerView param1RecyclerView, HFAdapter param1HFAdapter) {
      this.recyclerView = param1RecyclerView;
      this.hfAdapter = param1HFAdapter;
    }
    
    public View addFootView(int param1Int) {
      return addFootView(LayoutInflater.from(this.recyclerView.getContext()).inflate(param1Int, (ViewGroup)this.recyclerView, false));
    }
    
    public View addFootView(View param1View) {
      this.hfAdapter.addFooter(param1View);
      return param1View;
    }
    
    public View getContentView() {
      return (View)this.recyclerView;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\mvc\viewhandler\RecyclerViewHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */