package org.jar.photo.activity;

import android.widget.ImageView;
import org.jar.bloc.R;
import org.jar.bloc.interfaces.CallBack;
import org.jar.bloc.utils.ResUtils;
import org.jar.bloc.utils.ah;
import org.jar.bloc.widget.baserecyclerviewadapterhelper.BaseViewHolder;
import org.jar.photo.bean.EntityVideo;

class g implements CallBack<String> {
  g(ThumbSelectActivity.b paramb, BaseViewHolder paramBaseViewHolder, EntityVideo paramEntityVideo) {}
  
  public void a(String paramString) {
    if (paramString != null) {
      ah.a(paramString, (ImageView)this.a.getView(R.id.img_fm));
      this.b.b(paramString);
    } else {
      this.a.setImageResource(R.id.img_fm, ResUtils.id(ThumbSelectActivity.b.a(this.c), R.drawable.bloc_video_default_img));
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\activity\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */