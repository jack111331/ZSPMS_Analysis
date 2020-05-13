package org.jar.photo.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;
import org.jar.support.v7.widget.RecyclerView;

public class a<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  protected org.jar.photo.c.a a;
  
  protected Context b;
  
  protected LayoutInflater c;
  
  protected List<T> d;
  
  protected a(Context paramContext, List<T> paramList) {
    this.b = paramContext;
    this.d = paramList;
    this.c = LayoutInflater.from(this.b);
  }
  
  public void a(org.jar.photo.c.a parama) {
    this.a = parama;
  }
  
  public int getItemCount() {
    int i;
    if (this.d == null) {
      i = 0;
    } else {
      i = this.d.size();
    } 
    return i;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  public VH onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */