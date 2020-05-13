package org.jar.photo.a;

import android.view.View;
import android.widget.Toast;
import org.jar.bloc.R;
import org.jar.bloc.utils.ResUtils;
import org.jar.photo.bean.b;

class e implements View.OnClickListener {
  e(d paramd, b paramb, int paramInt) {}
  
  public void onClick(View paramView) {
    if (d.a(this.c).contains(this.a)) {
      this.a.d = 0;
      d.a(this.c).remove(this.a);
      d.b(this.c);
    } else {
      if (d.a(this.c).size() >= d.c(this.c)) {
        Toast.makeText(this.c.b, this.c.b.getResources().getString(ResUtils.id(this.c.b, R.string.publish_select_photo_max), new Object[] { Integer.valueOf(d.c(this.c)) }), 0).show();
        return;
      } 
      d.a(this.c).add(this.a);
      this.a.d = d.a(this.c).size();
    } 
    this.c.notifyItemChanged(this.b);
    if (this.c.a != null)
      this.c.a.a(paramView, -1); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */