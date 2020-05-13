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
import org.jar.support.v7.widget.RecyclerView;

public class b extends a<b, RecyclerView.ViewHolder> {
  public b(Context paramContext, List<b> paramList) {
    super(paramContext, paramList);
  }
  
  public a a(ViewGroup paramViewGroup, int paramInt) {
    return new a(this, this.c.inflate(ResUtils.id(this.b, R.layout.bloc_photo_folder_item), paramViewGroup, false));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt) {
    a a1 = (a)paramViewHolder;
    b b1 = this.d.get(paramInt);
    a1.b.setText(b1.c);
    a1.c.setText(String.format(this.b.getResources().getString(ResUtils.id(this.b, R.string.photo_num)), new Object[] { Integer.valueOf(b1.b) }));
    org.jar.photo.d.b.a(this.b, 256, this.b.getResources().getDrawable(ResUtils.id(this.b, R.drawable.bloc_photo_defaultpic)), a1.a, Uri.fromFile(new File(b1.a)));
    if (this.a != null)
      a1.d.setOnClickListener(new c(this, a1)); 
  }
  
  protected class a extends RecyclerView.ViewHolder {
    public ImageView a;
    
    public TextView b;
    
    public TextView c;
    
    public FrameLayout d;
    
    public a(b this$0, View param1View) {
      super(param1View);
      this.b = (TextView)param1View.findViewById(ResUtils.id(this$0.b, R.id.tv_file_name));
      this.c = (TextView)param1View.findViewById(ResUtils.id(this$0.b, R.id.tv_pic_nums));
      this.a = (ImageView)param1View.findViewById(ResUtils.id(this$0.b, R.id.iv_icon));
      this.d = (FrameLayout)param1View.findViewById(ResUtils.id(this$0.b, R.id.card_view));
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */