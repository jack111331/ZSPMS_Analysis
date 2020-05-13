package org.jar.support.v7.widget.helper;

import android.graphics.Canvas;
import android.view.View;
import org.jar.support.v7.widget.RecyclerView;

public interface ItemTouchUIUtil {
  void clearView(View paramView);
  
  void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean);
  
  void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean);
  
  void onSelected(View paramView);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v7\widget\helper\ItemTouchUIUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */