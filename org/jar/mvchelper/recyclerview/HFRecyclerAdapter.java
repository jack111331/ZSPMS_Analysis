package org.jar.mvchelper.recyclerview;

import android.view.ViewGroup;
import org.jar.support.v7.widget.RecyclerView;

public class HFRecyclerAdapter extends HFAdapter {
  protected RecyclerView.Adapter adapter;
  
  private RecyclerView.AdapterDataObserver adapterDataObserver = new RecyclerView.AdapterDataObserver() {
      public void onChanged() {
        HFRecyclerAdapter.this.notifyDataSetChanged();
      }
      
      public void onItemRangeChanged(int param1Int1, int param1Int2) {
        HFRecyclerAdapter.this.notifyItemRangeChanged(param1Int1 + HFRecyclerAdapter.this.getHeadSize(), param1Int2);
      }
      
      public void onItemRangeInserted(int param1Int1, int param1Int2) {
        HFRecyclerAdapter.this.notifyItemRangeInserted(param1Int1 + HFRecyclerAdapter.this.getHeadSize(), param1Int2);
      }
      
      public void onItemRangeMoved(int param1Int1, int param1Int2, int param1Int3) {
        HFRecyclerAdapter.this.notifyItemMoved(param1Int1 + HFRecyclerAdapter.this.getHeadSize(), param1Int2 + HFRecyclerAdapter.this.getHeadSize());
      }
      
      public void onItemRangeRemoved(int param1Int1, int param1Int2) {
        HFRecyclerAdapter.this.notifyItemRangeRemoved(param1Int1 + HFRecyclerAdapter.this.getHeadSize(), param1Int2);
      }
    };
  
  public HFRecyclerAdapter(RecyclerView.Adapter paramAdapter) {
    this(paramAdapter, true);
  }
  
  public HFRecyclerAdapter(RecyclerView.Adapter paramAdapter, boolean paramBoolean) {
    super(paramBoolean);
    this.adapter = paramAdapter;
    paramAdapter.registerAdapterDataObserver(this.adapterDataObserver);
  }
  
  public RecyclerView.Adapter getAdapter() {
    return this.adapter;
  }
  
  public int getItemCountHF() {
    return this.adapter.getItemCount();
  }
  
  public long getItemIdHF(int paramInt) {
    return this.adapter.getItemId(paramInt);
  }
  
  public int getItemViewTypeHF(int paramInt) {
    return this.adapter.getItemViewType(paramInt);
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView) {
    this.adapter.onAttachedToRecyclerView(paramRecyclerView);
  }
  
  public void onBindViewHolderHF(RecyclerView.ViewHolder paramViewHolder, int paramInt) {
    this.adapter.onBindViewHolder(paramViewHolder, paramInt);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolderHF(ViewGroup paramViewGroup, int paramInt) {
    return this.adapter.onCreateViewHolder(paramViewGroup, paramInt);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView) {
    this.adapter.onDetachedFromRecyclerView(paramRecyclerView);
  }
  
  public boolean onFailedToRecycleView(RecyclerView.ViewHolder paramViewHolder) {
    return this.adapter.onFailedToRecycleView(paramViewHolder);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder) {
    this.adapter.onViewAttachedToWindow(paramViewHolder);
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder) {
    this.adapter.onViewDetachedFromWindow(paramViewHolder);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder) {
    this.adapter.onViewRecycled(paramViewHolder);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\recyclerview\HFRecyclerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */