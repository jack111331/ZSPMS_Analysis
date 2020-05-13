package org.jar.photo.a;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.util.List;
import org.jar.bloc.R;
import org.jar.bloc.utils.ResUtils;
import org.jar.photo.bean.b;
import org.jar.photo.d.b;
import org.jar.support.v7.widget.RecyclerView;

public class d extends a<b, RecyclerView.ViewHolder> {
  private boolean e;
  
  private List<b> f;
  
  private int g;
  
  public d(Context paramContext, List<b> paramList, boolean paramBoolean, int paramInt) {
    super(paramContext, paramList);
    this.e = paramBoolean;
    this.g = paramInt;
    this.f = org.jar.photo.b.a.a().c();
  }
  
  private void a(View paramView, int paramInt) {
    paramView.setOnClickListener(new f(this, paramInt));
  }
  
  private void a(View paramView, b paramb, int paramInt) {
    paramView.setOnClickListener(new e(this, paramb, paramInt));
  }
  
  private void a(ImageView paramImageView, b paramb) {
    b.a(this.b, 256, this.b.getResources().getDrawable(ResUtils.id(this.b, R.drawable.bloc_photo_defaultpic)), paramImageView, Uri.fromFile(new File(paramb.a)));
  }
  
  private void a(a parama, b paramb) {
    if (this.e) {
      parama.d.setVisibility(4);
    } else if (this.f.contains(paramb)) {
      parama.d.setEnabled(true);
      parama.d.setText(String.valueOf(paramb.d));
      parama.c.setVisibility(0);
    } else {
      parama.d.setEnabled(false);
      parama.d.setText("");
      parama.c.setVisibility(8);
    } 
  }
  
  private void b() {
    int i = this.f.size();
    byte b = 0;
    while (b < i) {
      b b1 = this.f.get(b);
      b1.d = ++b;
      notifyItemChanged(b1.f);
    } 
  }
  
  public List<b> a() {
    return this.f;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt) {
    a a1 = (a)paramViewHolder;
    b b = this.d.get(paramInt);
    b.f = a1.getAdapterPosition();
    a(a1.b, b);
    a(a1, b);
    a((View)a1.e, b, a1.getAdapterPosition());
    a((View)a1.f, a1.getAdapterPosition());
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
    return new a(this, this.c.inflate(ResUtils.id(this.b, R.layout.bloc_photo_grid_item), paramViewGroup, false));
  }
  
  private class a extends RecyclerView.ViewHolder {
    public View a;
    
    public ImageView b;
    
    public ImageView c;
    
    public TextView d;
    
    public TextView e;
    
    public FrameLayout f;
    
    public a(d this$0, View param1View) {
      super(param1View);
      this.a = param1View.findViewById(ResUtils.id(this$0.b, R.id.main_frame_layout));
      this.b = (ImageView)param1View.findViewById(ResUtils.id(this$0.b, R.id.iv_pic));
      this.d = (TextView)param1View.findViewById(ResUtils.id(this$0.b, R.id.tv_select));
      this.c = (ImageView)param1View.findViewById(ResUtils.id(this$0.b, R.id.iv_forgound));
      this.f = (FrameLayout)param1View.findViewById(ResUtils.id(this$0.b, R.id.card_view));
      this.e = (TextView)param1View.findViewById(ResUtils.id(this$0.b, R.id.tv_select_v));
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */