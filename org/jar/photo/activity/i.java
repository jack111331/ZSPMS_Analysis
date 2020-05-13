package org.jar.photo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;
import org.jar.bloc.R;
import org.jar.bloc.utils.ResUtils;
import org.jar.bloc.utils.ae;
import org.jar.bloc.utils.ay;
import org.jar.photo.bean.EntityVideo;

class i implements View.OnClickListener {
  i(ThumbSelectActivity.b paramb, EntityVideo paramEntityVideo) {}
  
  public void onClick(View paramView) {
    ThumbSelectActivity.a(this.b.a, this.a.b());
    if (ay.a(ThumbSelectActivity.e(this.b.a)))
      return; 
    if (!ae.e(ThumbSelectActivity.e(this.b.a)))
      Toast.makeText((Context)this.b.a, ResUtils.id((Context)this.b.a, R.string.bloc_record_file_no_exist), 0).show(); 
    Intent intent = new Intent((Context)this.b.a, VideoPlayActivity.class);
    intent.putExtra("videoResult", (Parcelable)this.a);
    this.b.a.startActivityForResult(intent, 1005);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\activity\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */