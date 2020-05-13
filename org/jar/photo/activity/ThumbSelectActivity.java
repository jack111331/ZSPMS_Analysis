package org.jar.photo.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.jar.bloc.R;
import org.jar.bloc.usercenter.view.PostLandView;
import org.jar.bloc.utils.ResUtils;
import org.jar.bloc.utils.ae;
import org.jar.bloc.utils.ah;
import org.jar.bloc.widget.baserecyclerviewadapterhelper.BaseQuickAdapter;
import org.jar.bloc.widget.baserecyclerviewadapterhelper.BaseViewHolder;
import org.jar.photo.bean.EntityVideo;
import org.jar.photo.d.e;
import org.jar.support.v7.widget.GridLayoutManager;
import org.jar.support.v7.widget.RecyclerView;

public class ThumbSelectActivity extends Activity implements View.OnClickListener {
  private Handler a = new Handler();
  
  private RecyclerView b;
  
  private b c;
  
  private List<EntityVideo> d = new ArrayList<EntityVideo>();
  
  private EntityVideo e;
  
  private LinearLayout f;
  
  private TextView g;
  
  private TextView h;
  
  private String i;
  
  private TextView j;
  
  private a k;
  
  private void b() {
    Intent intent = new Intent((Context)this, PostLandView.class);
    intent.putExtra("entity_video", (Parcelable)this.e);
    setResult(-1, intent);
    finish();
  }
  
  public int a() {
    WindowManager windowManager = getWindowManager();
    DisplayMetrics displayMetrics = new DisplayMetrics();
    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
    return displayMetrics.widthPixels;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1005) {
      if (paramIntent == null)
        return; 
      this.e = (EntityVideo)paramIntent.getParcelableExtra("entity_video");
      b();
    } 
  }
  
  public void onClick(View paramView) {
    if (paramView == this.g) {
      finish();
    } else if (paramView == this.h) {
      if (this.e == null) {
        Toast.makeText((Context)this, getResources().getString(ResUtils.id((Context)this, R.string.bloc_upload_file_is_not_null)), 0).show();
        return;
      } 
      (new Thread(new c(this))).start();
    } 
  }
  
  @TargetApi(12)
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(ResUtils.id((Context)this, R.layout.bloc_thumb_select_layout));
    this.b = (RecyclerView)findViewById(ResUtils.id((Context)this, R.id.gridView_thumb));
    this.b.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager((Context)this, 5));
    this.b.setItemAnimator(null);
    this.g = (TextView)findViewById(ResUtils.id((Context)this, R.id.txt_back));
    this.h = (TextView)findViewById(ResUtils.id((Context)this, R.id.txt_confirm));
    this.f = (LinearLayout)findViewById(ResUtils.id((Context)this, R.id.layout_proccess));
    this.f.getBackground().setAlpha(80);
    this.j = (TextView)findViewById(ResUtils.id((Context)this, R.id.txt_tip));
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.c = new b(this, ResUtils.id((Context)this, R.layout.bloc_thumb_item_layout), this.d);
    this.b.setAdapter((RecyclerView.Adapter)this.c);
    this.k = new a(this, (Context)this);
    (new Thread(this.k)).start();
  }
  
  @TargetApi(12)
  protected void onDestroy() {
    super.onDestroy();
    e.a();
    System.gc();
  }
  
  class a implements Runnable {
    private Context b;
    
    public a(ThumbSelectActivity this$0, Context param1Context) {
      this.b = param1Context;
    }
    
    public void run() {
      List list = e.a(this.b);
      if (list == null)
        return; 
      if (!list.isEmpty()) {
        ThumbSelectActivity.d(this.a).addAll(list);
        ThumbSelectActivity.b(this.a).post(new f(this));
      } 
    }
  }
  
  public class b extends BaseQuickAdapter<EntityVideo, BaseViewHolder> {
    public b(ThumbSelectActivity this$0, int param1Int, List<EntityVideo> param1List) {
      super(param1Int, param1List);
    }
    
    @TargetApi(12)
    protected void a(BaseViewHolder param1BaseViewHolder, EntityVideo param1EntityVideo) {
      Context context;
      int i;
      String str2 = e.a(param1EntityVideo.c());
      param1BaseViewHolder.setText(R.id.txt_time, str2);
      if (ThumbSelectActivity.a(this.a) != null && param1EntityVideo.a() == ThumbSelectActivity.a(this.a).a()) {
        i = R.id.img_select;
        ThumbSelectActivity thumbSelectActivity = this.a;
        j = R.drawable.bloc_photo_selected;
      } else {
        i = R.id.img_select;
        context = this.mContext;
        j = R.drawable.bloc_photo_selected_default;
      } 
      param1BaseViewHolder.setImageResource(i, ResUtils.id(context, j));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(org.jar.bloc.a.a.a.h);
      stringBuilder.append(ae.a(param1EntityVideo.b()));
      stringBuilder.append(".jpg");
      String str1 = stringBuilder.toString();
      if ((new File(str1)).exists()) {
        param1EntityVideo.b(str1);
        ah.a(str1, (ImageView)param1BaseViewHolder.getView(R.id.img_fm));
      } else {
        org.jar.bloc.utils.a.a(param1EntityVideo.b(), new g(this, param1BaseViewHolder, param1EntityVideo));
      } 
      param1BaseViewHolder.getView(R.id.img_select).setOnClickListener(new h(this, param1EntityVideo));
      param1BaseViewHolder.getConvertView().setOnClickListener(new i(this, param1EntityVideo));
      int j = this.a.a() / 5;
      param1BaseViewHolder.getConvertView().setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(j, j));
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\activity\ThumbSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */