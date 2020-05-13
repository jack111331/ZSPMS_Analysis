package org.jar.support.v7.widget.util;

import org.jar.support.v7.util.SortedList;
import org.jar.support.v7.widget.RecyclerView;

public abstract class SortedListAdapterCallback<T2> extends SortedList.Callback<T2> {
  final RecyclerView.Adapter mAdapter;
  
  public SortedListAdapterCallback(RecyclerView.Adapter paramAdapter) {
    this.mAdapter = paramAdapter;
  }
  
  public void onChanged(int paramInt1, int paramInt2) {
    this.mAdapter.notifyItemRangeChanged(paramInt1, paramInt2);
  }
  
  public void onInserted(int paramInt1, int paramInt2) {
    this.mAdapter.notifyItemRangeInserted(paramInt1, paramInt2);
  }
  
  public void onMoved(int paramInt1, int paramInt2) {
    this.mAdapter.notifyItemMoved(paramInt1, paramInt2);
  }
  
  public void onRemoved(int paramInt1, int paramInt2) {
    this.mAdapter.notifyItemRangeRemoved(paramInt1, paramInt2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v7\widge\\util\SortedListAdapterCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */